use milk_intake;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(25) NOT NULL,
  `password` varchar(8) DEFAULT NULL,
  `role` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- -----------------------------------------------------
-- Table `milk_intake`.`cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `milk_intake`.`cars` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `namber` VARCHAR(10) NOT NULL,
  `weight_cistern` DECIMAL NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `milk_intake`.`contragents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `milk_intake`.`suppliers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NOT NULL,
  `unn` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `milk_intake`.`routes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `milk_intake`.`routes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cars_id` INT NOT NULL,
  `date_incoming` DATETIME NOT NULL  DEFAULT current_timestamp,
  `driver` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_routes_cars1_idx` (`cars_id` ASC),
  CONSTRAINT `fk_routes_cars1`
    FOREIGN KEY (`cars_id`)
    REFERENCES `milk_intake`.`cars` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `milk_intake`.`ttn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `milk_intake`.`ttn` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number_ttn` VARCHAR(10) NOT NULL,
  `date_ttn` DATETIME NOT NULL  DEFAULT current_timestamp,
  `routes_id` INT NOT NULL,
  `suppliers_id` INT NOT NULL,
  `weight_supplier` INT NOT NULL,
  `weight_receiving` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ttn_routes1_idx` (`routes_id` ASC),
  INDEX `fk_ttn_suppliers1_idx` (`suppliers_id` ASC),
  CONSTRAINT `fk_ttn_routes1`
    FOREIGN KEY (`routes_id`)
    REFERENCES `milk_intake`.`routes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ttn_suppliers1`
    FOREIGN KEY (`suppliers_id`)
    REFERENCES `milk_intake`.`suppliers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
commit;