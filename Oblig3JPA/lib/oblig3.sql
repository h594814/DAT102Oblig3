-- SQL fil for oblig 3

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;

CREATE TABLE ansatt (
    ansatt_id SERIAL PRIMARY KEY,
    brukernavn VARCHAR(20) UNIQUE,
    fornavn VARCHAR(50) NOT NULL,
    etternavn VARCHAR(50) NOT NULL,
    ansettelsesdato DATE NOT NULL,
    stilling VARCHAR(50) NOT NULL,
    manedslonn DECIMAL(10, 2) NOT NULL CHECK(manedslonn >= 0)
);

INSERT INTO ansatt (brukernavn, fornavn, etternavn, ansettelsesdato, stilling, manedslonn)
VALUES 
('lph', 'Lars', 'Pettersen', '2020-01-01', 'Sjef', 100000),
('aja', 'Anne', 'Jensen', '2021-05-01', 'Salgssjef', 80000),
('kbe', 'Kari', 'Bakken', '2019-10-01', 'Regnskapsfører', 60000);

select * from ansatt



-- Iterasjon 3


BEGIN;
DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;


CREATE TABLE avdeling (
    avdeling_id SERIAL PRIMARY KEY,
    navn VARCHAR(20) NOT NULL,
    sjef_id INTEGER NOT NULL
);

CREATE TABLE ansatt (
	ansatt_id SERIAL PRIMARY KEY,
    brukernavn VARCHAR(20) NOT NULL,
    fornavn VARCHAR(50) NOT NULL,
    etternavn VARCHAR(50) NOT NULL,
    ansettelsesdato DATE NOT NULL,
    stilling VARCHAR(50) NOT NULL,
    manedslonn DECIMAL(10, 2) NOT NULL CHECK(manedslonn >= 0),
    avdeling_id INTEGER REFERENCES avdeling(avdeling_id)
);

INSERT INTO avdeling(navn, sjef_id)
VALUES ('default',1);

INSERT INTO ansatt(brukernavn, fornavn, etternavn, ansettelsesdato,stilling, manedslonn,avdeling_id)
VALUES ('tmp', 'DontUse', 'DoNotUse', '2023-04-01', 'default', 1, 1);
		
ALTER TABLE Avdeling
ADD CONSTRAINT AnsattFK FOREIGN KEY (sjef_id) REFERENCES Ansatt (ansatt_id);

-- test avdeling
INSERT INTO Avdeling
    (navn, sjef_id)
VALUES ('Secret Society', 1);

-- test ansatte
INSERT INTO Ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn, avdeling_id)
VALUES ('smr', 'Sondre', 'Moa Risnes', '2021-08-15', 'trollman', 250000, 2),
       ('mo', 'Mats', 'Bell', '2021-08-15', 'spellcaster', 250000, 2),
       ('maj', 'Marius', 'Horn', '2021-08-15', '"var tilstede"', 50000, 2);

