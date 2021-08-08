package com.dados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dados.DAO.IDadoDAO;
import com.dados.DAO.IJugadorDAO;
import com.dados.DAO.IPartidaDAO;

import com.dados.model.Dado;
import com.dados.model.Jugador;
import com.dados.model.Partida;


@Service
public class PartidaService implements IServicePartida {
	
	
	@Autowired
	private IJugadorDAO jugadorDAO;
	
	@Autowired
	private IDadoDAO dadoDAO;
	
	@Autowired
	private IPartidaDAO partidaDAO;
	


	@Override
	public List<Jugador> getJugadores() {
		// TODO Auto-generated method stub
		return jugadorDAO.findAll();
	}

	@Override
	public Optional<Jugador> getJugadorId(String id) {
		
		// TODO Auto-generated method stub
		return jugadorDAO.findById(id);
	}

	@Override
	public Jugador agregarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		return jugadorDAO.save(jugador);
	}

	@Override
	public Jugador editar(Jugador jugador) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void eliminarJugador(String id) {
		// TODO Auto-generated method stub
		jugadorDAO.deleteById(id);
	}

	@Override
	public List<Dado> getDados() {
		// TODO Auto-generated method stub
		return dadoDAO.findAll();
	}

	@Override
	public Optional<Dado> getDadoId(String id) {
		// TODO Auto-generated method stub
		return dadoDAO.findById(id);
	}

	@Override
	public Dado agregarDado(Dado dado) {
		// TODO Auto-generated method stub
		return dadoDAO.save(dado);
	}

	@Override
	public Dado editar(Dado dado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarDado(String id) {
		// TODO Auto-generated method stub
		dadoDAO.deleteById(id);
	}

	@Override
	public List<Partida> getPartidas() {
		// TODO Auto-generated method stub
		return partidaDAO.findAll();
	}

	@Override
	public Optional<Partida> getPartidaId(String id) {
		// TODO Auto-generated method stub
		return partidaDAO.findById(id);
	}

	@Override
	public Partida agregarPartida(Partida partida) {
		// TODO Auto-generated method stub
		return partidaDAO.save(partida);
	}

	@Override
	public Partida editar(Partida partida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPartida(String id) {
		// TODO Auto-generated method stub
		partidaDAO.deleteById(id);
	}

}
