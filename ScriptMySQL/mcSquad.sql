DROP DATABASE portafolio;
CREATE DATABASE portafolio;
USE portafolio;

CREATE TABLE usuario (
idusuario int not null auto_increment primary key, 
nombre varchar(30) not null, 
apellido varchar(30) not null, 
fechanacimiento varchar(10) not null, 
clave varchar(15) not null,
run VARCHAR(10) not null unique
);

CREATE TABLE cliente (
idcliente INT not null auto_increment PRIMARY KEY,
telefono VARCHAR (20) NOT NULL,
email VARCHAR(25) NOT NULL,
rutcliente VARCHAR(10) not null
);

CREATE TABLE administrativo (
idadministrativo int not null auto_increment primary key, 
area varchar(20) not null,
rutadmin varchar(10) not null
);