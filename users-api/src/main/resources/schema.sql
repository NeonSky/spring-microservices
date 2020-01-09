CREATE TABLE users(
  id         SERIAL  NOT NULL,
  first_name varchar(100) NOT NULL,
  last_name  varchar(100) DEFAULT NULL,
  email      varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);