create database Student;

use Student;

CREATE TABLE `students` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`rollNo` varchar(11) NOT NULL UNIQUE,
	`name` varchar(45) NOT NULL,
	`fatherName` varchar(45) NOT NULL,
	PRIMARY KEY (`id`)
);
