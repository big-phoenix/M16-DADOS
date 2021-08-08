package com.dados.model;

import java.util.Random;

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
	private String id=null;
	
	@Field (name="num")
	private int num;
	@Field (name="num2")
	private int num2;
	@Field (name="ganador")
	private boolean ganador;
	
	public Dado() {
		
	}
	

	public Dado(int num, int num2,boolean ganador) {
		super();
		//this.id = id;
		this.num = num;
		this.num2 = num2;
		this.ganador = ganador;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	

	public boolean getGanador() {
		return ganador;
	}


	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}


	public void tirarDados(int rang) {
		
		Random rand = new Random();
		int int_Ramdom1 = rand.nextInt(rang)+1;
		int int_Ramdom2 = rand.nextInt(rang)+1;
		
		this.num = int_Ramdom1;
		this.num2 = int_Ramdom2;
		
		if(num+num2==7) {
			this.ganador = true;
		}else {
			this.ganador = false;
		}
		
	}
	

}
