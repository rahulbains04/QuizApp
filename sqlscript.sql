CREATE DATABASE  IF NOT EXISTS `screeningdb`;
USE `screeningdb`;

DROP TABLE IF EXISTS `screen_category`;

CREATE TABLE `screen_category` (
    `id` INT PRIMARY KEY,
    `title` VARCHAR(255),
    `created_at` DATETIME,
    `updated_at` DATETIME,
    `clues_count` INT
);


DROP TABLE IF EXISTS `screen_question`;

CREATE TABLE `screen_question` (
   `id` INT PRIMARY KEY,
    `answer` VARCHAR(255),
    `question` VARCHAR(255),
    `value` INT,
    `airdate` DATETIME,
    `created_at` DATETIME,
    `updated_at` DATETIME,
    `screen_category_id` INT,
    `game_id` INT,
    `invalid_count` INT,
    `category_id` INT,
    FOREIGN KEY (`category_id`) REFERENCES `screen_category`(`id`)
);


