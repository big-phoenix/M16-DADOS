package com.dados.service;

import java.util.List;
import java.util.Optional;

import com.dados.model.Dado;
import com.dados.model.Jugador;
import com.dados.model.Partida;



public interface IServicePartida {

	
	public List<Jugador> getJugadores();
	public Optional<Jugador> getJugadorId(String uuid);
	public Jugador agregarJugador(Jugador jugador);
	public Jugador editar(Jugador jugador);
	public void eliminarJugador(String uuid);

	public List<Dado> getDados();
	public Optional<Dado> getDadoId(String uuid);
	public Dado agregarDado(Dado dado);
	public Dado editar(Dado dado);
	public void eliminarDado(String uuid);
	
	public List<Partida> getPartidas();
	public Optional<Partida> getPartidaId(String uuid);
	public Partida agregarPartida(Partida partida);
	public Partida editar(Partida partida);
	public void eliminarPartida(String uuid);
	
	
}
