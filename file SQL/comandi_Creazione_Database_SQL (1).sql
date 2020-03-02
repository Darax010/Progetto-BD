CREATE SCHEMA catena;
USE  catena;


CREATE TABLE istruttore(
 cf	VARCHAR(45) not null,
 nome 	VARCHAR(45)	not null,
 cognome VARCHAR(45) not null,
 telefono	VARCHAR(13)	not null,
 Contratto	BOOLEAN not null,
 anniesperienza INT not null,
 tipospecializzazione VARCHAR(25),
 PRIMARY KEY(cf)
);

 CREATE TABLE segretario(
 cf	VARCHAR(45) not null,
 nome 	VARCHAR(45)	not null,
 cognome VARCHAR(45) not null,
 telefono	VARCHAR(13)	not null,
 contratto	BOOLEAN not null,
 PRIMARY KEY(cf)
);

 CREATE TABLE responsabile(
 cf	VARCHAR(45) not null,
 nome 	VARCHAR(45)	not null,
 cognome VARCHAR(45) not null,
 telefono	VARCHAR(13)	not null,
 contratto	BOOLEAN not null,
 PRIMARY KEY(cf)
);


 CREATE TABLE interno(
 cf VARCHAR(45) NOT NULL,
 nome VARCHAR (45) NOT NULL,
 cognome VARCHAR(45) NOT NULL,
 documento VARCHAR(200) NOT NULL,
 telefono VARCHAR(13) NOT NULL, 
 email VARCHAR(30) NOT NULL,
 password VARCHAR(45) NOT NULL,
 PRIMARY KEY(cf)
);

 CREATE TABLE esterno(
 cf VARCHAR(45) NOT NULL,
 nome VARCHAR (45) NOT NULL,
 cognome VARCHAR(45) NOT NULL,
 documento VARCHAR(200) NOT NULL,
 telefono VARCHAR(13) NOT NULL, 
 email VARCHAR(30) NOT NULL,
 password VARCHAR(45) NOT NULL,
 PRIMARY KEY(cf)
);

CREATE TABLE centrosportivo(
 nome	VARCHAR(45) not null,
 fax 	VARCHAR(45)	not null,
 telefono	VARCHAR(13)	not null,
 indirizzo VARCHAR(45) not null,
 PRIMARY KEY(nome)
);
 
 CREATE TABLE struttura(
 codstruttura	VARCHAR(45) not null,
 areaoccupata 	INT	not null,
 totalegiorniultimoanno	INT	not null,
 totaleoreultimoanno	NUMERIC(6,2) not null,
 presenzaattrezzature BOOLEAN,
 apertoochiuso BOOLEAN,

 PRIMARY KEY(codstruttura)
);

 
 CREATE TABLE attivitasportiva(
 codiceattivita VARCHAR(45) not null,
 descrizione VARCHAR(70) not null,
 numeroiscritti INT not null, 
 durata INT not null,
 periodicità INT, 
 duratainmesi INT,
 partecipanti INT,
 tipologiaattivita BOOLEAN not null,
 allenatoreassegnato VARCHAR(45) NOT NULL,
 PRIMARY KEY (codiceattivita),
 foreign key (allenatoreassegnato)  REFERENCES istruttore(cf) ON UPDATE CASCADE
);



	-- RELAZIONI --

CREATE TABLE agenda(
 id INT NOT NULL AUTO_INCREMENT,
 data DATE NOT NULL,
 ora INT NOT NULL,
 codstruttura VARCHAR(45) NOT NULL REFERENCES struttura(codstruttura) ON UPDATE CASCADE,
 codattivitasportiva VARCHAR(45) NOT NULL REFERENCES attivitasportiva(codiceattivita) ON UPDATE CASCADE,
 codsegretario VARCHAR(45) NOT NULL REFERENCES segretario(cf) ON UPDATE CASCADE,
 codesterno VARCHAR(45) NOT NULL REFERENCES esterno(cf) ON UPDATE CASCADE,
 PRIMARY KEY(id)
);

CREATE TABLE calendario(
 id INT NOT NULL AUTO_INCREMENT,
 data DATE NOT NULL,
 ora INT NOT NULL,
 codstruttura VARCHAR(45) NOT NULL REFERENCES struttura(codstruttura) ON UPDATE CASCADE,
 codattivitasportiva VARCHAR(45) NOT NULL REFERENCES attivitasportiva(codiceattivita) ON UPDATE CASCADE,
 PRIMARY KEY(id)
);

CREATE TABLE ubicazione(
 id INT NOT NULL AUTO_INCREMENT,
 codcentrosportivo VARCHAR(45) not null REFERENCES centrosportivo(nome) ON UPDATE CASCADE,
 codstruttura VARCHAR(45) NOT NULL REFERENCES struttura(codstruttura) ON UPDATE CASCADE,
 PRIMARY KEY(id)
);

CREATE TABLE dirigente(
 id INT NOT NULL AUTO_INCREMENT,
 codcentrosportivo VARCHAR(45) not null REFERENCES centrosportivo(nome) ON UPDATE CASCADE,
 codresponsabile VARCHAR(45) not null,
 PRIMARY KEY(id)
);
 
CREATE TABLE partecipazione(
 id INT NOT NULL AUTO_INCREMENT,
 codattivitasportiva VARCHAR(45) NOT NULL REFERENCES attivitasportiva(codiceattivita) ON UPDATE CASCADE,
 codinterno  VARCHAR(45) NOT NULL REFERENCES interno(cf) ON UPDATE CASCADE,
 PRIMARY KEY(id)
);