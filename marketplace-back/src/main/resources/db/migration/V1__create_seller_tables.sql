
CREATE TABLE IF NOT EXISTS `seller` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(120) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `first_name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


