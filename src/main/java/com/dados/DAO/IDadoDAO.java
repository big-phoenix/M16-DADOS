package com.dados.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dados.model.Dado;

public interface IDadoDAO extends MongoRepository<Dado, String> {

}
