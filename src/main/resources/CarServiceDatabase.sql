-- MySQL Script generated by MySQL Workbench
-- Thu Jan 12 16:45:26 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `idCustomer` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `phoneNumber` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(45) NOT NULL,
  `discount` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Car` (
  `idCar` INT NOT NULL AUTO_INCREMENT,
  `idCustomer` INT NOT NULL,
  `vin` VARCHAR(45) NOT NULL,
  `make` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `bodytype` VARCHAR(45) NOT NULL,
  `productionyear` INT NOT NULL,
  `enginecapacity` VARCHAR(45) NOT NULL,
  `fueltype` VARCHAR(45) NOT NULL,
  `exteriorcolor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCar`),
  UNIQUE INDEX `Vin_UNIQUE` (`vin` ASC) VISIBLE,
  INDEX `fk_Car_Customer1_idx` (`idCustomer` ASC) VISIBLE,
  CONSTRAINT `fk_Car_Customer1`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CarServiceA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CarServiceA` (
  `idCarServiceA` INT NOT NULL AUTO_INCREMENT,
  `idCar` INT NULL,
  `serviceType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCarServiceA`),
  INDEX `fk_Car Service A_Car1_idx` (`idCar` ASC) VISIBLE,
  CONSTRAINT `fk_Car Service A_Car1`
    FOREIGN KEY (`idCar`)
    REFERENCES `mydb`.`Car` (`idCar`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Manager` (
  `idManager` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(45) NOT NULL,
  `phoneNumber` VARCHAR(45) NOT NULL,
  `salary` INT NOT NULL,
  PRIMARY KEY (`idManager`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Employees` (
  `idEmployees` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `phoneNumber` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(45) NOT NULL,
  `salary` INT NOT NULL,
  `idManager` INT NULL,
  PRIMARY KEY (`idEmployees`),
  INDEX `fk_Employees_Manager1_idx` (`idManager` ASC) VISIBLE,
  CONSTRAINT `fk_Employees_Manager1`
    FOREIGN KEY (`idManager`)
    REFERENCES `mydb`.`Manager` (`idManager`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EngineMechanic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EngineMechanic` (
  `idEngineMechanic` INT NOT NULL AUTO_INCREMENT,
  `idCarServiceA` INT NULL,
  `idEmployees` INT NULL,
  PRIMARY KEY (`idEngineMechanic`),
  INDEX `fk_Engine Mechanic_Car Service A1_idx` (`idCarServiceA` ASC) VISIBLE,
  INDEX `fk_Engine Mechanic_Employees1_idx` (`idEmployees` ASC) VISIBLE,
  CONSTRAINT `fk_Engine Mechanic_Car Service A1`
    FOREIGN KEY (`idCarServiceA`)
    REFERENCES `mydb`.`CarServiceA` (`idCarServiceA`)
    ON DELETE SET NULL
    ON UPDATE SET NULL,
  CONSTRAINT `fk_Engine Mechanic_Employees1`
    FOREIGN KEY (`idEmployees`)
    REFERENCES `mydb`.`Employees` (`idEmployees`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CarServiceB`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CarServiceB` (
  `idCarServiceB` INT NOT NULL AUTO_INCREMENT,
  `idCar` INT NULL,
  `serviceType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCarServiceB`),
  INDEX `fk_Car Service B_Car1_idx` (`idCar` ASC) VISIBLE,
  CONSTRAINT `fk_Car Service B_Car1`
    FOREIGN KEY (`idCar`)
    REFERENCES `mydb`.`Car` (`idCar`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DiagnosticsMechanic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DiagnosticsMechanic` (
  `idDiagnosticsMechanic` INT NOT NULL,
  `idCarServiceA` INT NULL,
  `idEmployees` INT NULL,
  INDEX `fk_Diagnostics Mechanic_Car Service A1_idx` (`idCarServiceA` ASC) VISIBLE,
  INDEX `fk_Diagnostics Mechanic_Employees1_idx` (`idEmployees` ASC) VISIBLE,
  PRIMARY KEY (`idDiagnosticsMechanic`),
  CONSTRAINT `fk_Diagnostics Mechanic_Car Service A1`
    FOREIGN KEY (`idCarServiceA`)
    REFERENCES `mydb`.`CarServiceA` (`idCarServiceA`)
    ON DELETE SET NULL
    ON UPDATE SET NULL,
  CONSTRAINT `fk_Diagnostics Mechanic_Employees1`
    FOREIGN KEY (`idEmployees`)
    REFERENCES `mydb`.`Employees` (`idEmployees`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`AutomotiveElectrician`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`AutomotiveElectrician` (
  `idAutomotiveElectrician` INT NOT NULL,
  `idCarServiceB` INT NULL,
  `idEmployees` INT NULL,
  INDEX `fk_Automotive Electrician_Car Service B1_idx` (`idCarServiceB` ASC) VISIBLE,
  INDEX `fk_Automotive Electrician_Employees1_idx` (`idEmployees` ASC) VISIBLE,
  PRIMARY KEY (`idAutomotiveElectrician`),
  CONSTRAINT `fk_Automotive Electrician_Car Service B1`
    FOREIGN KEY (`idCarServiceB`)
    REFERENCES `mydb`.`CarServiceB` (`idCarServiceB`)
    ON DELETE SET NULL
    ON UPDATE SET NULL,
  CONSTRAINT `fk_Automotive Electrician_Employees1`
    FOREIGN KEY (`idEmployees`)
    REFERENCES `mydb`.`Employees` (`idEmployees`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SuspensionMechanic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SuspensionMechanic` (
  `idSuspensionMechanic` INT NOT NULL,
  `idCarServiceB` INT NULL,
  `idEmployees` INT NULL,
  INDEX `fk_Suspension Mechanic_Car Service B1_idx` (`idCarServiceB` ASC) VISIBLE,
  INDEX `fk_Suspension Mechanic_Employees1_idx` (`idEmployees` ASC) VISIBLE,
  PRIMARY KEY (`idSuspensionMechanic`),
  CONSTRAINT `fk_Suspension Mechanic_Car Service B1`
    FOREIGN KEY (`idCarServiceB`)
    REFERENCES `mydb`.`CarServiceB` (`idCarServiceB`)
    ON DELETE SET NULL
    ON UPDATE SET NULL,
  CONSTRAINT `fk_Suspension Mechanic_Employees1`
    FOREIGN KEY (`idEmployees`)
    REFERENCES `mydb`.`Employees` (`idEmployees`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`GearboxMechanic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`GearboxMechanic` (
  `idGearboxMechanic` INT NOT NULL,
  `idCarServiceB` INT NULL,
  `idEmployees` INT NULL,
  INDEX `fk_Gearbox Mechanic_Car Service B1_idx` (`idCarServiceB` ASC) VISIBLE,
  INDEX `fk_Gearbox Mechanic_Employees1_idx` (`idEmployees` ASC) VISIBLE,
  PRIMARY KEY (`idGearboxMechanic`),
  CONSTRAINT `fk_Gearbox Mechanic_Car Service B1`
    FOREIGN KEY (`idCarServiceB`)
    REFERENCES `mydb`.`CarServiceB` (`idCarServiceB`)
    ON DELETE SET NULL
    ON UPDATE SET NULL,
  CONSTRAINT `fk_Gearbox Mechanic_Employees1`
    FOREIGN KEY (`idEmployees`)
    REFERENCES `mydb`.`Employees` (`idEmployees`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`??ashier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`??ashier` (
  `id??ashier` INT NOT NULL AUTO_INCREMENT,
  `idEmployees` INT NULL,
  PRIMARY KEY (`id??ashier`),
  INDEX `fk_??ashier_Employees1_idx` (`idEmployees` ASC) VISIBLE,
  CONSTRAINT `fk_??ashier_Employees1`
    FOREIGN KEY (`idEmployees`)
    REFERENCES `mydb`.`Employees` (`idEmployees`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Orders` (
  `idOrders` INT NOT NULL AUTO_INCREMENT,
  `idCustomer` INT NOT NULL,
  `orderedProducts` VARCHAR(45) NOT NULL,
  `orderAmount` DOUBLE NOT NULL,
  `orderDate` DATE NOT NULL,
  PRIMARY KEY (`idOrders`),
  INDEX `fk_Orders_Customer1_idx` (`idCustomer` ASC) VISIBLE,
  CONSTRAINT `fk_Orders_Customer1`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PartWarehouse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PartWarehouse` (
  `idPartWarehouse` INT NOT NULL,
  `partid` VARCHAR(45) NOT NULL,
  `partname` VARCHAR(45) NOT NULL,
  `partnumber` VARCHAR(45) NOT NULL,
  `partquantity` INT NOT NULL,
  `producer` VARCHAR(45) NOT NULL,
  `releaseyear` INT NOT NULL,
  PRIMARY KEY (`idPartWarehouse`, `partid`),
  UNIQUE INDEX `part id_UNIQUE` (`partid` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EnginePartsStore`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EnginePartsStore` (
  `idEngine Parts Store` INT NOT NULL AUTO_INCREMENT,
  `id??ashier` INT NULL,
  `idOrders` INT NOT NULL,
  `idPartWarehouse` INT NOT NULL,
  `partid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEngine Parts Store`),
  INDEX `fk_Engine Parts Store_??ashier1_idx` (`id??ashier` ASC) VISIBLE,
  INDEX `fk_Engine Parts Store_Orders1_idx` (`idOrders` ASC) VISIBLE,
  INDEX `fk_Engine Parts Store_Part Warehouse1_idx` (`idPartWarehouse` ASC, `partid` ASC) VISIBLE,
  CONSTRAINT `fk_Engine Parts Store_??ashier1`
    FOREIGN KEY (`id??ashier`)
    REFERENCES `mydb`.`??ashier` (`id??ashier`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Engine Parts Store_Orders1`
    FOREIGN KEY (`idOrders`)
    REFERENCES `mydb`.`Orders` (`idOrders`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Engine Parts Store_Part Warehouse1`
    FOREIGN KEY (`idPartWarehouse` , `partid`)
    REFERENCES `mydb`.`PartWarehouse` (`idPartWarehouse` , `partid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`AutomotivePartsStore`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`AutomotivePartsStore` (
  `idAutomotive Parts Store` INT NOT NULL AUTO_INCREMENT,
  `id??ashier` INT NOT NULL,
  `idOrders` INT NOT NULL,
  `idPartWarehouse` INT NOT NULL,
  `partid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAutomotive Parts Store`),
  INDEX `fk_Automotive Parts Store_??ashier1_idx` (`id??ashier` ASC) VISIBLE,
  INDEX `fk_Automotive Parts Store_Orders1_idx` (`idOrders` ASC) VISIBLE,
  INDEX `fk_Automotive Parts Store_Part Warehouse1_idx` (`idPartWarehouse` ASC, `partid` ASC) VISIBLE,
  CONSTRAINT `fk_Automotive Parts Store_??ashier1`
    FOREIGN KEY (`id??ashier`)
    REFERENCES `mydb`.`??ashier` (`id??ashier`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Automotive Parts Store_Orders1`
    FOREIGN KEY (`idOrders`)
    REFERENCES `mydb`.`Orders` (`idOrders`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Automotive Parts Store_Part Warehouse1`
    FOREIGN KEY (`idPartWarehouse` , `partid`)
    REFERENCES `mydb`.`PartWarehouse` (`idPartWarehouse` , `partid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
