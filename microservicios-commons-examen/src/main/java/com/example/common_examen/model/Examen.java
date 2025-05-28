package com.example.common_examen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;




@Entity
@Table(name = "examen")
public class Examen {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;

	private String nombre;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at")
	private Date createAt;
	
	@JsonIgnoreProperties(value = {"examen"}, allowSetters = true)
	@OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Pregunta> preguntas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Asignatura asignatura;
	
	@Transient
	private boolean respondido;

	
	public Examen() {
		this.preguntas = new ArrayList<>();
	}
	
	
	
	public Examen(Long id, String nombre, Date createAt, List<Pregunta> preguntas) {
		this.id = id;
		this.nombre = nombre;
		this.createAt = createAt;
		this.preguntas = preguntas;
	}



	@PrePersist
	public void prePersiste() {
		this.createAt = new Date();
	}
	
	
	public void addPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
		pregunta.setExamen(this);
	}
	
	public void removePregunta(Pregunta pregunta) {
		this.preguntas.remove(pregunta);
		pregunta.setExamen(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas.clear();
		preguntas.forEach(p -> {
			this.addPregunta(p);
		});;
	}
	



	public Asignatura getAsignatura() {
		return asignatura;
	}



	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	


	public boolean isRespondido() {
		return respondido;
	}



	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Examen)) {
			return false;
		}
		
		Examen a = (Examen)obj;
		return this.id != null && this.id.equals(a.getId());
	}
	
	
}










