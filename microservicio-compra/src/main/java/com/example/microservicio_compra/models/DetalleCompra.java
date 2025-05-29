package com.example.microservicio_compra.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "compra_id")
	@JsonBackReference
	private Compra compra;
	
	@NotNull(message = "Debe especificar un producto")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Producto producto;
	
	@NotNull(message = "La cantidad es obligatoria")
	@Positive(message = "La cantidad debe ser mayor que cero")
	private Integer cantidad;
	
	@PositiveOrZero(message = "El subtotal no puede ser negativo")
	private double subTotal;
	
}
