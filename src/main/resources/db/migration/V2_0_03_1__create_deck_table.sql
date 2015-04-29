CREATE TABLE `deck` (
  `id`          INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`        VARCHAR(50) NOT NULL,
  `description` TEXT,
  `owner_email` VARCHAR(30) NOT NULL,
  CONSTRAINT `fk_deck_owner` FOREIGN KEY (`owner_email`) REFERENCES `user` (`email`)
    ON UPDATE RESTRICT
    ON DELETE CASCADE
)