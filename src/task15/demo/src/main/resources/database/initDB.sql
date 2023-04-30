CREATE TABLE IF NOT EXISTS patients
(
    id SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL ,
    second_name VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS doctors
(
    id SERIAL NOT NULL PRIMARY KEY ,
    first_name VARCHAR(128) NOT NULL,
    second_name VARCHAR(128) NOT NULL,
    pos INTEGER NOT NULL
);
