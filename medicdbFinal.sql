CREATE DATABASE MedicDB;
USE MedicDB;

CREATE TABLE Medic
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
	Pas VARCHAR(16)	NOT NULL,
	name VARCHAR(20) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	adress VARCHAR(100) NOT NULL,
	med VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	Spec VARCHAR(100) NOT NULL,
	telephone VARCHAR(100) NOT NULL,
	idfoto INT UNSIGNED NULL
);

CREATE TABLE Patient
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
	pas VARCHAR(16) NOT NULL,
	name VARCHAR(20) NOT NULL,
	surname	VARCHAR(30) NOT NULL,
	sex	CHAR(1)	NOT NULL,
	adress VARCHAR(100)	NOT NULL,
	birthdate Date NOT NULL,
	telephone VARCHAR(100) NOT NULL,
	bloodtype CHAR(2) NULL,
	idfoto INT UNSIGNED NULL
);

CREATE TABLE Radiography
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	reportdate DATE NULL,
	receptiondate DATE NOT NULL,
	radiographydate	DATE NOT NULL,
	study VARCHAR(255) NOT NULL,
	report VARCHAR(255) NULL,
	controldone	VARCHAR(255) NOT NULL
);

CREATE TABLE Analysis
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	analysisdate DATE NOT NULL,
	analysistype VARCHAR(50) NOT NULL,
	report VARCHAR(255) NOT NULL,
	reportdate DATE NOT NULL
);

CREATE TABLE Pharmacotherapy
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	descript VARCHAR(255) NOT NULL,
	dosage VARCHAR(255) NULL,
	startdate DATE NOT NULL,
	enddate DATE NULL,
	initialweight FLOAT NULL,
	finalweight FLOAT NULL,
	medicament VARCHAR(100)
);

CREATE TABLE Medicament
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL
);

CREATE TABLE  Episodes
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	descript VARCHAR(255) NOT NULL,
	startdate DATE NOT NULL,
	enddate DATE NULL,
	evolution VARCHAR(255) NULL,
	disease VARCHAR(255)
);

CREATE TABLE Disease
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL
);

CREATE TABLE Visit
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
	reception Date NULL,
	visitdate DATE NOT NULL,
	report VARCHAR(255) NULL,
	medicalcentre VARCHAR(100) NOT NULL,
	idanalysis INT UNSIGNED NULL,
	idepisode INT UNSIGNED NULL,
	idmedic INT UNSIGNED NULL,
	idpatient INT UNSIGNED NULL,
	idpharmacotherapy INT UNSIGNED NULL,
	idradiography INT UNSIGNED NULL
);

CREATE TABLE centros
(
	id INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	positionx FLOAT,
	positiony FLOAT,
	icon VARCHAR(255)
);

INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Especialidades Grande Covián", 41.664305, -0.858579, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Especialidades Inocencio Jiménez", 41.656300, -0.909407, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Especialidades Ramón y Cajal", 41.650902, -0.889351, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Especialidades San José", 41.642730, -0.870782, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Promoción de Salud Amparo Poch ( Actur Oeste )", 41.671504, -0.891857, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Actur Norte", 41.675321, -0.886286, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Actur Sur", 41.662499, -0.884971, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Almozara", 41.659457, -0.904802, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Arrabal", 41.662147, -0.877631, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Bombarda", 41.652993, -0.916507, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Canal Imperial", 41.633775, -0.888462, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Casablanca", 41.632936, -0.912151, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Delicias Norte", 41.656480, -0.906603, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Delicias Sur", 41.645384, -0.904151, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Fernando El Católico", 41.640202, -0.901238, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud José R. Muñoz Fernández", 41.641730, -0.886574, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud La Jota", 41.661182, -0.859090, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Las Fuentes Norte", 41.649853, -0.863554, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Miralbueno-Garrapinillos", 41.660125, -0.938541, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Oliver", 41.652187, -0.929969, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Parque Goya", 41.688754, -0.875636, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Parque Roma", 41.652416, -0.896852, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Picarral", 41.667841, -0.871906, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Rebolería", 41.652948, -0.870690, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Romareda", 41.636372, -0.908104, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud San José", 41.642731, -0.870779, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud San Pablo", 41.656721, -0.887323, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Santa Isabel", 41.666712, -0.836580, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Torre Ramona", 41.640839, -0.861659, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Torrero-La Paz", 41.623828, -0.874349, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Univérsitas", 41.647362, -0.913550, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Valdefierro", 41.640882, -0.933992, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Centro de Salud Valdespartera", 41.621022, -0.923734, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Consultorio El Zorongo", 41.764969, -0.877275, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Consultorio Hermanos Ibarra", 41.650832, -0.876984, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Hospital Nuestra Señora de Gracia", 41.652337, -0.888114, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");
INSERT INTO centros(name, positionx, positiony, icon) VALUES ("Hospital Universitario Miguel Servet", 41.634969, -0.900007, "http://www.zaragoza.es/contenidos/iconos/sanidadYconsumo.png");