package com.example.microservicio_compra.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@NotBlank(message = "El estado no puede estar vacio")
	@Pattern(regexp = "PENDIENTE|RECIBIDO|CANCELADO", message = "Estado inválido. Debe ser PENDIENTE, RECIBIDO o CANCELADO")
	private String estado;
	
	@NotNull(message = "El proveedor es obligatorio")
	@ManyToOne
	private Proveedor proveedor;
	
	@PositiveOrZero(message = "El total no puede ser negativo")
	private double total;
	
	@NotEmpty(message = "Debe incluir al menos un detalle de compra")
	@OneToMany(mappedBy = "compra", cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<DetalleCompra> detalles;
	
	@PrePersist
	public void prePersist() {
		this.fecha = new Date();	
	}
}
