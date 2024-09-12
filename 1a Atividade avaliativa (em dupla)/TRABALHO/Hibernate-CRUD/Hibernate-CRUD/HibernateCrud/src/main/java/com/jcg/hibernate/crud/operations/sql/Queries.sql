CREATE DATABASE IF NOT EXISTS tutorialDb;

USE tutorialDb;

DROP TABLE IF EXISTS student;

CREATE TABLE IF NOT EXISTS student (
  student_id int(100) NOT NULL AUTO_INCREMENT,
  student_name varchar(50) DEFAULT NULL,
  roll_number varchar(50) DEFAULT NULL,
  course varchar(50) DEFAULT NULL,  
  PRIMARY KEY (student_id)
);

-----------------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `Medico_765210` (
	`CRM` varchar(255) NOT NULL UNIQUE,
	`Nome` varchar(255) NOT NULL,
	`Salario` float NOT NULL,
	`Especialidade` varchar(255) NOT NULL,
	PRIMARY KEY (`CRM`)
);

CREATE TABLE IF NOT EXISTS `Paciente_765210` (
	`CPF` varchar(255) NOT NULL UNIQUE,
	`Nome` varchar(255) NOT NULL,
	`Endereço` varchar(255) NOT NULL,
	`Telefone` varchar(255) NOT NULL,
	`Data_Nasc` date NOT NULL,
	`Quarto` int NOT NULL,
	PRIMARY KEY (`CPF`)
);

CREATE TABLE IF NOT EXISTS `Tratamento` (
	`CPF_Paciente` varchar(255) NOT NULL UNIQUE,
	`CRM_Medico` varchar(255) NOT NULL UNIQUE,
	`Responsavel` boolean NOT NULL
);



ALTER TABLE `Tratamento` ADD CONSTRAINT `Tratamento_fk0` FOREIGN KEY (`CPF_Paciente`) REFERENCES `Paciente_765210`(`CPF`);

ALTER TABLE `Tratamento` ADD CONSTRAINT `Tratamento_fk1` FOREIGN KEY (`CRM_Medico`) REFERENCES `Medico_765210`(`CRM`);