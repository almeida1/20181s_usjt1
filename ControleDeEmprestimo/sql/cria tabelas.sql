-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `mydb`.`Emprestimo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Emprestimo` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Emprestimo` (
  `emprestimoNumero` INT NOT NULL,
  `codigoLivro` VARCHAR(15) NOT NULL,
  `codigoUsuario` VARCHAR(15) NOT NULL,
  `dataEmprestimo` DATE NOT NULL,
  `dataDevolucao` DATE NOT NULL,
  PRIMARY KEY (`emprestimoNumero`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
