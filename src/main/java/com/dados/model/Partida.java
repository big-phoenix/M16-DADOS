package com.dados.model;

import javax.persistence.*;

//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


//@Entity
//@Table(name = "partida")
@Document(collection = "partida")
public class Partida {
	
	@Id
	//@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id=null;
	
	//@OneToOne
	//@JoinColumn(name = "jugador_id", unique = true)
	@DBRef
	private Jugador jugador;
	
	//@OneToOne
	//@JoinColumn(name = "dado_id", unique = true, nullable=false)
	@DBRef
	private Dado dado;
	
	public Partida() {
		
	}

	public Partida(Jugador jugador, Dado dado) {
		super();
		this.jugador = jugador;
		this.dado = dado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Dado getDado() {
		return dado;
	}

	public void setDado(Dado dado) {
		this.dado = dado;
	}

}
