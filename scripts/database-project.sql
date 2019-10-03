CREATE DATABASE IF NOT EXISTS project;
USE project;

CREATE TABLE IF NOT EXISTS person (
	  id bigint NOT NULL auto_increment,
    doc_type VARCHAR(100) NOT NULL,
	  doc_number VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    gender ENUM('F','M') NOT NULL,
    name VARCHAR(100),
    surname VARCHAR(100),
	  age SMALLINT,
    email VARCHAR(60),
    phone VARCHAR(20),
    PRIMARY KEY (id, doc_type, doc_number, country, gender)
);