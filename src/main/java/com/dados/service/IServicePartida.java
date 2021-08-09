package com.dados.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dados.model.Dado;
import com.dados.model.Jugador;
import com.dados.model.Partida;



public interface IServicePartida {

	
	public List<Jugador> getJugadores();
	public Optional<Jugador> getJugadorId(UUID uuid);
	public Jugador agregarJugador(Jugador jugador);
	public Jugador editar(Jugador jugador);
	public void eliminarJugador(UUID uuid);

	public List<Dado> getDados();
	public Optional<Dado> getDadoId(UUID uuid);
	public Dado agregarDado(Dado dado);
	public Dado editar(Dado dado);
	public void eliminarDado(UUID uuid);
	
	public List<Partida> getPartidas();
	public Optional<Partida> getPartidaId(UUID uuid);
	public Partida agregarPartida(Partida partida);
	public Partida editar(Partida partida);
	public void eliminarPartida(UUID uuid);
	
	
}
