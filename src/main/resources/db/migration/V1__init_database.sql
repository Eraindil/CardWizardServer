CREATE TABLE `user` (
  `email`    VARCHAR(30) PRIMARY KEY,
  `username` VARCHAR(30) UNIQUE NOT NULL,
  `password` VARCHAR(256)       NOT NULL,
  `role`     VARCHAR(10)        NOT NULL
);
-- password = y4bBdhvRu64jWDM9IdRD
INSERT INTO `user`
VALUES ('admin@cardwizard.fr', 'admin', '$2a$10$lpNoe31H7jZ8RhC9M2IKcOfnS6WnsVBPZhS9QONjKw8vdks5m8hs6', 'ADMIN');