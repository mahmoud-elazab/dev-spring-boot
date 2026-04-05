CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--


INSERT INTO `employee` VALUES
                           (1,'Mahmoud','Elazab','elazab.mahmoud@outlook.com'),
                           (2,'Katja','Schiergott','schiergott.k@gmail.com'),
                           (3,'Daniela','Kuhn','daniela.kuhn@outlook.de'),
                           (4,'Sebastian','Langemann','s.langemann@gmail.com'),
                           (5,'Hans','Flick','hans_flick@gmail.com');

