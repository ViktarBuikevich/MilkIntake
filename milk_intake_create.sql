-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema milk_intake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `milk_intake` DEFAULT CHARACTER SET utf8 ;
USE `milk_intake` ;
CREATE TABLE `cars` (
  `id` int NOT NULL AUTO_INCREMENT,
  `namber` varchar(10) NOT NULL,
  `weight_cistern` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `routes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cars_id` int NOT NULL,
  `date_incoming` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `driver` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_routes_cars1_idx` (`cars_id`),
  CONSTRAINT `fk_routes_cars1` FOREIGN KEY (`cars_id`) REFERENCES `cars` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `suppliers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(70) NOT NULL,
  `unn` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ttn` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number_ttn` varchar(10) NOT NULL,
  `date_ttn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `routes_id` int NOT NULL,
  `suppliers_id` int NOT NULL,
  `weight_supplier` int NOT NULL,
  `weight_receiving` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ttn_routes1_idx` (`routes_id`),
  KEY `fk_ttn_suppliers1_idx` (`suppliers_id`),
  CONSTRAINT `fk_ttn_routes1` FOREIGN KEY (`routes_id`) REFERENCES `routes` (`id`),
  CONSTRAINT `fk_ttn_suppliers1` FOREIGN KEY (`suppliers_id`) REFERENCES `suppliers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(25) NOT NULL,
  `password` varchar(8) DEFAULT NULL,
  `role` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
