DROP DATABASE mcsquad;
CREATE DATABASE mcsquad;
USE mcsquad;

CREATE TABLE usuario (
idusuario int not null auto_increment primary key, 
username varchar(30) not null,
nombre varchar(30) not null, 
apellido varchar(30) not null, 
fechanacimiento date not null, 
clave varchar(15) not null,
run VARCHAR(10) not null unique
);

CREATE TABLE cliente (
idcliente INT not null auto_increment PRIMARY KEY,
telefono numeric (20) NOT NULL,
email VARCHAR(25) NOT NULL,
rutcliente VARCHAR(10) not null
);

CREATE TABLE administrativo (
idadministrativo int not null auto_increment primary key, 
area varchar(20) not null,
rutadmin varchar(10) not null
);

ALTER TABLE administrativo
ADD CONSTRAINT fk_rutadmin
FOREIGN KEY (rutadmin)
REFERENCES usuario(run)
ON DELETE CASCADE;

ALTER TABLE cliente
ADD CONSTRAINT fk_rutcliente
FOREIGN KEY (rutcliente)
REFERENCES usuario(run)
ON DELETE CASCADE;

INSERT INTO usuario values (1, 'mundenius', 'Valentina', 'Saldias', '1997-07-20',  'gryffindor', '19616866-4');
INSERT INTO administrativo values (1, 'gerencia', '19616866-4');