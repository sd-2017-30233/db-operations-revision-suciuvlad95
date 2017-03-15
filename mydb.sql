-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cursuri
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cursuri
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cursuri` DEFAULT CHARACTER SET latin1 ;
USE `cursuri` ;

-- -----------------------------------------------------
-- Table `cursuri`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursuri`.`course` (
  `course_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `teacher` VARCHAR(45) NOT NULL,
  `study_year` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`course_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cursuri`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursuri`.`student` (
  `idstudent` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  `adress` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`idstudent`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cursuri`.`enrollment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursuri`.`enrollment` (
  `idenrollment` INT(11) NOT NULL,
  `dataInrolare` DATE NOT NULL,
  `idstudent` INT(11) NOT NULL,
  `courseid` INT(11) NOT NULL,
  PRIMARY KEY (`idenrollment`),
  UNIQUE INDEX `idenrollment_UNIQUE` (`idenrollment` ASC),
  INDEX `idstudent_idx` (`idstudent` ASC),
  INDEX `courseid_idx` (`courseid` ASC),
  CONSTRAINT `courseid`
    FOREIGN KEY (`courseid`)
    REFERENCES `cursuri`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idstudent`
    FOREIGN KEY (`idstudent`)
    REFERENCES `cursuri`.`student` (`idstudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

