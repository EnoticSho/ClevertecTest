CREATE SCHEMA `clevertectest` ;


CREATE TABLE `clevertectest`.`products` (
  `id_products` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `cost` INT NOT NULL,
  `isDiscount` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_products`));

CREATE TABLE `clevertectest`.`discount_card` (
  `id_discount_card` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `percent` INT NOT NULL,
  PRIMARY KEY (`id_discount_card`));

CREATE TABLE `clevertectest`.`checks` (
  `id_checks` INT NOT NULL AUTO_INCREMENT,
  `params` VARCHAR(100) NOT NULL,
  `card` VARCHAR(45) NULL,
  PRIMARY KEY (`id_checks`));

INSERT INTO clevertectest.checks(params, card) VALUES ('3-1 2-5 5-1 1-5', card-12311)

INSERT INTO clevertectest.discount_card(name, percent) Values ('123', 17),
                                                              ('124', 17),
                                                              ('125', 17),
                                                              ('126', 17)
                                                              
INSERT INTO clevertectest.products(name, cost, isDiscount) Values ('apple', 100, true),
                                                              ('orange', 200, true),
                                                              ('cucumber', 300, false),
                                                              ('lemon', 1500, false),
                                                              ('tomato', 400, true)

