package com.example.respuesta.models;

import com.example.common_examen.model.Pregunta;
import com.example.commons_alumno.models.Alumno;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "respuestas")
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String texto;
	@ManyToOne(fetch = FetchType.LAZY)
	private Alumno alumno;
	@OneToMany(fetch = FetchType.LAZY)
	private Pregunta pregunta;
}
