CREATE TABLE `associate_card` (
  `deck_id`       INT NOT NULL,
  `multiverse_id` INT NOT NULL,
  `number`        INT NOT NULL,
  PRIMARY KEY (`deck_id`, `multiverse_id`),
  CONSTRAINT `fk_associate_card_deck` FOREIGN KEY (`deck_id`) REFERENCES `deck` (`id`)
    ON UPDATE RESTRICT
    ON DELETE CASCADE,
  CONSTRAINT `fk_associate_card_card` FOREIGN KEY (`multiverse_id`) REFERENCES `card` (`multiverse_id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT
)