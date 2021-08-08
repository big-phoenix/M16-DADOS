package com.dados.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dados.model.Partida;

public interface IPartidaDAO extends MongoRepository<Partida, String> {

}
