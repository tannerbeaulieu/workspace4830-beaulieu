CREATE DATABASE 'MyDBBeaulieu1006';
USE MyDBBeaulieu1006;

create table students (
	id  int(3) NOT NULL AUTO_INCREMENT,
	name varchar(120) NOT NULL,
	university varchar(220) NOT NULL,
	major varchar(120),
	grade varchar(120),
	PRIMARY KEY (id)
);

