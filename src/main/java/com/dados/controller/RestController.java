package com.dados.controller;

import java.util.*;


import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dados.model.Dado;
import com.dados.model.Jugador;
import com.dados.model.Partida;


import com.dados.service.IServicePartida;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")

public class RestController {
	
	@Autowired
	private IServicePartida servicePartida;
	
	
	
	@GetMapping(value = "players") 
	public ResponseEntity<List<Jugador>> allJugadores(){
		
		List<Jugador> jugadores = servicePartida.getJugadores();
		
		return ResponseEntity.ok(jugadores);
	}
	
	@PostMapping(value = "players")
	public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador){
		
		jugador.setFecha();
		
		Jugador newJugador = servicePartida.agregarJugador(jugador);
		
		return ResponseEntity.ok(newJugador);
	}
	
	
	@GetMapping("/players/ranking") 
	public ResponseEntity<String> getRanking(){
		
		List<Partida> partidas = servicePartida.getPartidas();
		List<Jugador> jugador = servicePartida.getJugadores();
		
		int ganadas = 0;
		
		for(Partida p: partidas) {
			
			if(p.getDado().getGanador() == true) {
				ganadas++;
			}
			
		}
		
		double resultado = (100/partidas.size())*ganadas;
		
		return ResponseEntity.ok("El resultado medio de aciertos es: "+resultado+"%");
		
	}
	
	@GetMapping("/players/ranking/loser") 
	public ResponseEntity<String> getRankingLose(){
		
		List<Partida> partidas = servicePartida.getPartidas();
		List<Jugador> jugador = servicePartida.getJugadores();
	
		List<Jugador> jugadasPerdida = new ArrayList<Jugador>();
		List<Integer> num = new ArrayList<Integer>();
		int index = 0;
		
			for(Partida p: partidas) {
				if(p.getDado().getGanador() == false) {
					jugadasPerdida.add(p.getJugador());
				}
			}
			
			for(Jugador j: jugador) {
				num.add(Collections.frequency(jugadasPerdida, j));
			}
			
			for(int i=0;i<num.size();i++) {
				if(num.get(i)>index){
					index = num.indexOf(num.get(i));
				}
			}
			
		
		return ResponseEntity.ok("El peor Jugador es: Id "+jugador.get(index).getId()+" - "+jugador.get(index).getNombre());
		
	}
	
	@GetMapping("/players/ranking/winner") 
	public ResponseEntity<String> getRankingWinner(){
		
		List<Partida> partidas = servicePartida.getPartidas();
		List<Jugador> jugador = servicePartida.getJugadores();
	
		List<Jugador> jugadasPerdida = new ArrayList<Jugador>();
		List<Integer> num = new ArrayList<Integer>();
		int index = 0;
		
			for(Partida p: partidas) {
				if(p.getDado().getGanador() == true) {
					jugadasPerdida.add(p.getJugador());
				}
			}
			
			for(Jugador j: jugador) {
				num.add(Collections.frequency(jugadasPerdida, j));
			}
			
			for(int i=0;i<num.size();i++) {
				if(num.get(i)>index){
					index = num.indexOf(num.get(i));
				}
			}
		
		
		return ResponseEntity.ok("El mejor Jugador es: Id "+jugador.get(index).getId()+" - "+jugador.get(index).getNombre());
		
	}
	
	@GetMapping(value = "dado") 
	public ResponseEntity<List<Dado>> allDados(){
		
		List<Dado> dados = servicePartida.getDados();
		
		return ResponseEntity.ok(dados);
	}
	
	@GetMapping(value = "games") 
	public ResponseEntity<List<Partida>> allPartidas(){
		
		List<Partida> partidas = servicePartida.getPartidas();
		
		return ResponseEntity.ok(partidas);
	}
	
	
	
	@PostMapping(value = "dado")
	public ResponseEntity<Dado> crearDado(){
		
		List<Dado> dados = servicePartida.getDados();
		
		//inter id = dados.size()+1;
		Dado dado = new Dado();
		//dado.setId(id);
		dado.tirarDados(6);
		
		
		Dado newDado = servicePartida.agregarDado(dado);
		
		return ResponseEntity.ok(newDado);
	}
	
	
	@GetMapping(value = "players/{ID}/games") 
	public ResponseEntity<List<Partida>> getPartidaId(@PathVariable("ID") String ID){
		Optional<Jugador> optionalJugador = servicePartida.getJugadorId(ID);
		
		List<Partida> partidas = servicePartida.getPartidas();
		List<Partida> resultado = new ArrayList<Partida>();
		
		for(Partida p: partidas) {
			
			System.out.println(p.getJugador().getId()+"---");
			System.out.println(optionalJugador.get().getId()+"---");
			
			if(p.getJugador().getId().equals(optionalJugador.get().getId())) { 
															
				resultado.add(p);
			}else{
				System.out.println("Loser el judar es: "+p.getJugador().getId());
			}
		}
		
		return ResponseEntity.ok(resultado);
		
	}
	
	@PutMapping(value = "players")
	public ResponseEntity<Jugador> updateJugador(@RequestBody Jugador jugador){
		
		Optional<Jugador> optionalJugador = servicePartida.getJugadorId(jugador.getId());
		
		if(optionalJugador.isPresent()) {
			
			Jugador updateJugador = optionalJugador.get();
			updateJugador.setNombre(jugador.getNombre());
			servicePartida.agregarJugador(updateJugador);
			return ResponseEntity.ok(updateJugador);
		}else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
	
	@PostMapping(value = "players/{ID}/games")
	public ResponseEntity<Partida> crearPartida(@PathVariable("ID") String ID,@RequestBody Partida partida){
		
		Optional<Jugador> optionalJugador = servicePartida.getJugadorId(ID);
		
		System.out.print(optionalJugador);
		
		crearDado();
		
		List<Dado> dados = servicePartida.getDados();
		int pos_Dado = dados.size()-1;
		Optional<Dado> optionalDado = servicePartida.getDadoId(dados.get(pos_Dado).getId());
		
		partida.setJugador(optionalJugador.get());
		partida.setDado(optionalDado.get());
		
		Partida newPartida = servicePartida.agregarPartida(partida);
		
		return ResponseEntity.ok(newPartida);
	}
	
	@DeleteMapping(value = "players/{ID}/games") // Eliminar tiradas partida
	public ResponseEntity<Void> deleteTiradaId(@PathVariable("ID") String ID){
		
		Optional<Jugador> optionalJugador = servicePartida.getJugadorId(ID);
		
		List<Partida> partida = servicePartida.getPartidas();
		
		
		for(Partida p: partida) {
			
			if(p.getJugador().getId().equals(optionalJugador.get().getId())) { 
				
				System.out.println("Partida: "+p);
				System.out.println("DADO: "+p.getDado().getId());
				
				deleteDadoId(p.getDado().getId());
				
			}
		}
		
		
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping(value = "dado/{ID}/partida") // Eliminar tiradas partida
	public ResponseEntity<Dado> deleteDadoId(@PathVariable("ID") String ID){
		
		Optional<Dado> optionalDado = servicePartida.getDadoId(ID);
		
		if(optionalDado.isPresent()) {
			
			Dado updateDado = optionalDado.get();
			updateDado.setNum(0);
			updateDado.setNum2(0);
			updateDado.setGanador(false);
			servicePartida.agregarDado(updateDado);
			return ResponseEntity.ok(updateDado);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
}
