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
import jakarta.validation.constraints.Pattern;
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
	@Pattern(regexp = "PENDIENTE|RECIBIDO|CANCELADO", message = "Estado inválido")
	private String estado;
	
	@ManyToOne
	private Proveedor proveedor;
	
	private double total;
	
	@OneToMany(mappedBy = "compra", cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<DetalleCompra> detalles;
	
	@PrePersist
	public void prePersist() {
		this.fecha = new Date();	
	}
}
