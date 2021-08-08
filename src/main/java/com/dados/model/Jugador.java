package com.dados.model;

import java.time.LocalDate;

import javax.persistence.*;

//import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


//@Entity
//@Table(name = "jugador")
@Document(collection = "jugador")
public class Jugador {
	
	@Id
	//@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String id=null;
	
	@Field (name="nombre")
	private String nombre;
	
	@Field (name="fecha")
	private LocalDate fecha;
	
	public Jugador() {
		
	}
	
	public Jugador(String nombre) {
		super();
		//this.id = id;
		this.nombre = nombre;
		//this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha() {
		LocalDate dataActual = LocalDate.now();
		this.fecha = dataActual;
	}
	
	

}
