package com.dados.DAO;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dados.model.Jugador;

public interface IJugadorDAO extends MongoRepository<Jugador, UUID> {


}
