package com.example.microservicio_venta.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@NotBlank(message = "El estado no puede estar vacion")
	@Pattern(regexp = "PENDIENTE|RECIBIDO|CANCELADO", message = "Estado inválido. Debe ser PENDIENTE, RECIBIDO o CANCELADO")
	private String estado;
	@NotNull(message = "El cliente es obligatorio")
	@ManyToOne
	private Cliente cliente;
	
	@PositiveOrZero(message = "El total no puede negativo")
	private double total;
	@NotEmpty(message = "Debe incluir al menos un detalle de venta")
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<DetalleVenta> detalles;
	
	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}
}
