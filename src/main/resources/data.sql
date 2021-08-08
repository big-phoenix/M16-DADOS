INSERT INTO jugador (nombre,fecha) VALUES ('Javi',NOW());
INSERT INTO jugador (nombre,fecha) VALUES ('Rafa',NOW());

INSERT INTO dado (ganador,num,num2) VALUES (FALSE,4,2);
INSERT INTO dado (ganador,num,num2) VALUES (FALSE,1,3);
INSERT INTO dado (ganador,num,num2) VALUES (FALSE,2,4);
INSERT INTO dado (ganador,num,num2) VALUES (FALSE,6,3);
INSERT INTO dado (ganador,num,num2) VALUES (FALSE,1,4);
INSERT INTO dado (ganador,num,num2) VALUES (TRUE,5,2);

INSERT INTO partida (jugador_id,dado_id) VALUES (1,1);
INSERT INTO partida (jugador_id,dado_id) VALUES (2,2);
INSERT INTO partida (jugador_id,dado_id) VALUES (2,3);
INSERT INTO partida (jugador_id,dado_id) VALUES (1,4);
INSERT INTO partida (jugador_id,dado_id) VALUES (2,5);
INSERT INTO partida (jugador_id,dado_id) VALUES (1,6);
