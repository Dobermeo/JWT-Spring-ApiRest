CREATE TABLE IF NOT EXISTS usuario(
  id SERIAL,
  clave VARCHAR(255),
  person_id INT NOT NULL,
  rol_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (rol_id) REFERENCES rol(id),
  FOREIGN KEY (person_id) REFERENCES person(id)
  )
