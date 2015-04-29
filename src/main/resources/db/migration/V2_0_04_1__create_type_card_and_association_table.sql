CREATE TABLE `card_type` (
  `id`   INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(10) NOT NULL
);

CREATE TABLE `card_associate_type` (
  `multiverse_id` INT NOT NULL,
  `type_id`       INT NOT NULL,
  CONSTRAINT `fk_card_associate_type_card`
  FOREIGN KEY (`multiverse_id`) REFERENCES `card` (`multiverse_id`)
    ON UPDATE RESTRICT
    ON DELETE CASCADE,
  CONSTRAINT `fk_card_associate_type_type`
  FOREIGN KEY (`type_id`) REFERENCES `card_type` (`id`)
    ON UPDATE RESTRICT
    ON DELETE CASCADE
);