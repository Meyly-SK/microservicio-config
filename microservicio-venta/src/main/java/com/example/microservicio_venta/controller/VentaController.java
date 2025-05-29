package com.example.microservicio_venta.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.commons.controller.CommonController;
import com.example.commons.exceptions.BadRequestException;
import com.example.commons.exceptions.NotFoundException;
import com.example.microservicio_venta.clients.MovimientoFeignClient;
import com.example.microservicio_venta.models.DetalleVenta;
import com.example.microservicio_venta.models.MovimientoInventario;
import com.example.microservicio_venta.models.Producto;
import com.example.microservicio_venta.models.Venta;
import com.example.microservicio_venta.service.DetalleVentaService;
import com.example.microservicio_venta.service.VentaService;

import jakarta.validation.Valid;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.core.HttpHeaders;

@RestController
public class VentaController extends CommonController<Venta, VentaService>{

	@Autowired
	private DetalleVentaService detalleVentaService;


	
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevaVenta(@Valid @RequestBody Venta ventaRequest, BindingResult result){

		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		try {
			if(ventaRequest.getCliente() == null) {
				throw new BadRequestException("El cliente es obligatorio");
			}
			
			if(ventaRequest.getDetalles() == null || ventaRequest.getDetalles().isEmpty()) {
				throw new BadRequestException("Debe incluir al menos un detalle en la venta");
			}
			
			double  totalAcumulado = 0.0;
			Venta venta = new Venta();
			venta.setCliente(ventaRequest.getCliente());
			venta.setEstado(ventaRequest.getEstado());
			venta.setFecha(new Date());
			List<DetalleVenta> detalleVentas =  new ArrayList<>();
			for (DetalleVenta item : ventaRequest.getDetalles()) {
				if(item.getProducto() == null || item.getCantidad() == null || item.getCantidad() <= 0) {
					throw new BadRequestException("Todos los productos deben tener un cantidad valida y no nula");
				}
				Producto producto = detalleVentaService.obtenerInventario(item.getProducto().getId());
				
				if(producto == null) {
					throw new NotFoundException("Producto con ID + " + item.getProducto().getId() + " no encontrado.");
				}
				if(producto.getPrecioUnitario() < 0) {
					throw new BadRequestException("Precio unitario invalido para el producto " + producto.getNombre());
				}
				
				item.setProducto(producto);
				item.setVenta(venta);
				double subTotal = item.getCantidad() * item.getProducto().getPrecioUnitario();
				item.setSubTotal(subTotal);
				totalAcumulado += subTotal;
				detalleVentas.add(item);
				
			}
			
			venta.setDetalles(detalleVentas);
			venta.setTotal(totalAcumulado);
			Venta ventaGuardada = service.save(venta);
			
			for(DetalleVenta detalle : ventaGuardada.getDetalles()) {
				
				MovimientoInventario mInventario = new MovimientoInventario();
				mInventario.setProducto(detalle.getProducto());
				mInventario.setCantidad(detalle.getCantidad());
				mInventario.setTipoMovimiento("SALIDA");
				mInventario.setOrigen("VENTA");
				mInventario.setReferenciaId(ventaGuardada.getId());
				mInventario.setDescripcion("VENTA - ID " + ventaGuardada.getId());
				
				try {
					detalleVentaService.guardarInventario(mInventario);
				}catch(Exception e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body("Error al registrar el movimiento de inventario: " + e.getMessage());
				}
			}
			return ResponseEntity.ok("Compra y movimientos guardados exitosamente");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocurrio un error inesperado : " + e.getMessage());
		}
	}
	
	@GetMapping("/{id}/pdf")
	public ResponseEntity<byte[]> generarPdfReporte(@PathVariable Long id) throws Exception {
		Venta venta = service.findById(id)
				.orElseThrow(() -> new NotFoundException("La venta con ID " + id + " no existe"));
		
		
		byte[] pdf;
		
		try {
			pdf = service.generarPdfVenta(venta);
		}catch(Exception e) {
			throw new InternalServerErrorException("Error al generar el PDF de la venta con ID " + id + " : " + e.getMessage());
		}
		
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=venta_" + id + ".pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.body(pdf);
	}
}
