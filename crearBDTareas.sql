//Creacion de la BD
CREATE DATABASE sisweb_tareas;
use sisweb_tareas;

//Tabla usuarios
CREATE TABLE `sisweb_tareas`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `correo_electronico` VARCHAR(100) NOT NULL,
  `clave` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_usuario`));
  
//Tabla tareas
CREATE TABLE `sisweb_tareas`.`tareas` (
  `id_tareas` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `imagen` MEDIUMBLOB NULL DEFAULT NULL,
  `id_usuario` INT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_tareas`));
  
ALTER TABLE tareas
ADD FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);