CREATE TABLE IF NOT EXISTS  workout (
  id serial,
  description VARCHAR(45) NOT NULL,
  details VARCHAR(45) NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS  diet (
  id serial,
  description VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
  );
