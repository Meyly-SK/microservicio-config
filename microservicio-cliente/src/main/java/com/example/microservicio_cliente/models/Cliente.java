package com.example.microservicio_cliente.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(min = 1, max =100)
	private String nombre;
	@NotEmpty
	@Pattern(regexp = "^[0-9]{9,15}$", message = "El teléfono debe contener solo números y tener entre 10 y 15 dígitos.")
	private String telefono;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size(min = 1, max = 100)
	private String direccion;
}
