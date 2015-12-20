CREATE DATABASE MedicDB;
USE MedicDB;

CREATE TABLE Medic
(
	collegiateNumber INT(10) UNSIGNED PRIMARY KEY,
	userName VARCHAR(20) NOT NULL,
	userPasword VARCHAR(16)	NOT NULL,
	name VARCHAR(20) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	adress VARCHAR(100) NOT NULL,
	medicalCentre VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	medicalSpeciality VARCHAR(100) NOT NULL,
	telephone VARCHAR(100) NOT NULL,
	birthDate DATE NOT NULL
);

CREATE TABLE Patient
(
	cias INT(10) UNSIGNED PRIMARY KEY,
	patientUser VARCHAR(20) NOT NULL,
	patientPassword VARCHAR(16) NOT NULL,
	name VARCHAR(20) NOT NULL,
	surname	VARCHAR(30) NOT NULL,
	sex	CHAR(1)	NOT NULL,
	adress VARCHAR(100)	NOT NULL,
	birthDate Date NOT NULL,
	telephone VARCHAR(100) NOT NULL,
	bloodType CHAR(2) NULL
);

CREATE TABLE Radiography
(
	id INT(10) UNSIGNED PRIMARY KEY,
	reportDate DATE NULL,
	receptionDate DATE NOT NULL,
	radiographyDate	DATE NOT NULL,
	study VARCHAR(255) NOT NULL,
	report VARCHAR(255) NULL,
	controlDone	VARCHAR(255) NOT NULL
);

CREATE TABLE Analysis
(
	id INT(10) UNSIGNED PRIMARY KEY,
	analysisDate DATE NOT NULL,
	analysisType VARCHAR(50) NOT NULL,
	report VARCHAR(255) NOT NULL,
	reportDate DATE NOT NULL
);

CREATE TABLE Pharmacotherapy
(
	id INT(10) UNSIGNED PRIMARY KEY,
	descript VARCHAR(255) NOT NULL,
	dosage VARCHAR(255) NULL,
	startDate DATE NOT NULL,
	endDate DATE NULL,
	initialWeight FLOAT NULL,
	finalWeight FLOAT NULL
);

CREATE TABLE Medicament
(
	id INT(10) UNSIGNED PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	composition VARCHAR(100) NOT NULL,
	formatt VARCHAR(50) NULL,
	laboratory VARCHAR(50) NOT NULL,
	prize FLOAT NULL
);

CREATE TABLE PharmacotherapyMedicament
(
	idPharmacotherapy INT UNSIGNED,
	INDEX(idPharmacotherapy),
	FOREIGN KEY(idPharmacotherapy)
		REFERENCES Pharmacotherapy(id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	idMedicament INT UNSIGNED,
	INDEX(idMedicament),
	FOREIGN KEY(idMedicament)
		REFERENCES Medicament(id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(idPharmacotherapy, idMedicament)
);

CREATE TABLE  Episodes
(
	id INT(10) UNSIGNED PRIMARY KEY,
	descript VARCHAR(255) NOT NULL,
	startDate DATE NOT NULL,
	endDate DATE NULL,
	evolution VARCHAR(255) NULL
);

CREATE TABLE Disease
(
	id INT(10) UNSIGNED PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	descr VARCHAR(255) NOT NULL,
	evolution VARCHAR(255) NULL,
	treatment VARCHAR(255) NOT NULL,
	prevention VARCHAR(255)	NULL,
    diseaseType VARCHAR(100) NULL,
	pathogenesis VARCHAR(255) NULL
);

CREATE TABLE EpisodeDisease
(
	idEpisode INT UNSIGNED,
	INDEX(idEpisode),
	FOREIGN KEY(idEpisode)
		REFERENCES Episodes(id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	idDisease INT UNSIGNED,
	INDEX(idDisease),
	FOREIGN KEY(idDisease)
		REFERENCES Disease(id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(idEpisode, idDisease)
);

CREATE TABLE Visit
(
	id INT(10) UNSIGNED PRIMARY KEY, 
	reception Date NULL,
	visitDate DATE NOT NULL,
	report VARCHAR(255) NULL,
	medicalCentre VARCHAR(100) NOT NULL,
	idAnalysis INT UNSIGNED,
	INDEX(idAnalysis),
	FOREIGN KEY(idAnalysis)
		REFERENCES Analysis(id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	idEpisode INT UNSIGNED,
	INDEX(idEpisode),
	FOREIGN KEY(idEpisode)
		REFERENCES Episodes(id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	idMedic INT UNSIGNED,
	INDEX(idMedic),
	FOREIGN KEY(idMedic)
		REFERENCES Medic(collegiateNumber)
		ON UPDATE CASCADE ON DELETE CASCADE,
	idPatient INT UNSIGNED,
	INDEX(idPatient),
	FOREIGN KEY(idPatient)
		REFERENCES Patient(cias)
		ON UPDATE CASCADE ON DELETE CASCADE,
	idPharmacotherapy INT UNSIGNED,
	INDEX(idPharmacotherapy),
	FOREIGN KEY(idPharmacotherapy)
		REFERENCES Pharmacotherapy(id)
		ON UPDATE CASCADE ON DELETE CASCADE
);