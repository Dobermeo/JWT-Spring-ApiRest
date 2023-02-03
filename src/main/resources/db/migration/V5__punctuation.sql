CREATE TABLE IF NOT EXISTS punctuation(
  id SERIAL,
  puntuacion INT NOT NULL,
  game_id INT NOT NULL,
  usuario_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (game_id) REFERENCES game(id),
  FOREIGN KEY (usuario_id) REFERENCES usuario(id)
  )
