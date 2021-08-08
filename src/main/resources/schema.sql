CREATE TABLE jugador 
(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  fecha TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE dado 
(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  ganador BOOLEAN NOT NULL,
  num INT NOT NULL,
  num2 INT NOT NULL
);

CREATE TABLE partida 
(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  jugador_id INT,
  dado_id INT,
  FOREIGN KEY(jugador_id) REFERENCES jugador(id),
  FOREIGN KEY(dado_id) REFERENCES dado(id)
);

/*CREATE TABLE cuadro 
(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  autor VARCHAR(250),
  precio FLOAT NOT NULL,
  tienda_id INT,
  jugador_id INT,
  dado_id INT,
  FOREIGN KEY(tienda_id) REFERENCES tienda(id),
  FOREIGN KEY(jugador_id) REFERENCES jugador(id),
  FOREIGN KEY(dado_id) REFERENCES dado(id)
);

/*CREATE TABLE jugador 
(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  fecha TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE dado
(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  num INT NOT NULL,
  num2 INT NOT NULL
);

CREATE TABLE partida 
(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  ganado BOOLEAN,
  jugador_id INT,
  dado_id INT,
  FOREIGN KEY(jugador_id) REFERENCES jugador(id),
  FOREIGN KEY(dado_id) REFERENCES dado(id)
);*/