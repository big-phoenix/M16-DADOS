package com.dados.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.persistence.*;
//import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


//@Entity
//@Table(name = "dado")
@Document(collection = "dado")
public class Dado {

	@Id
	//@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	
	@Field(name="dados")
	private List<Integer> dados = new ArrayList<>();
	
	@Field (name="ganador")
	private boolean ganador;
	
	public Dado() {
		
	}
	

	public Dado(List<Integer> dados,boolean ganador) {
		super();
		this.dados = dados;
		this.ganador = ganador;
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public List<Integer> getDados() {
		return dados;
	}


	public void setDados() {
		for(int i=0;i<dados.size();i++) {
			dados.set(i, 0);
		}
	}

	public boolean getGanador() {
		return ganador;
	}


	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}


	public void tirarDados(int rang,int numDados) {
		
		Random rand = new Random();
		int suma = 0;
		
		for(int i=0;i<numDados;i++) {
			int int_Ramdom = rand.nextInt(rang)+1;
			dados.add(int_Ramdom);
			suma+=int_Ramdom;
			System.out.println("El numero del dado es: "+int_Ramdom);
		}
		
		System.out.println("La SUMA ES :"+suma);
		
		if(suma == 7) {
			this.ganador = true;
		}else {
			this.ganador = false;
		}
		
		
	}
	

}
