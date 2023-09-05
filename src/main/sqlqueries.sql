query for creating table.
CREATE TABLE `bloodrequest` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bloodType` varchar(3) NOT NULL,
  `description` varchar(255) NOT NULL,
  `contactNo` varchar(20) NOT NULL,
  `reqDate` date DEFAULT NULL,
  `reqVerification` varchar(20) NOT NULL,
  `status` varchar(6) NOT NULL,
  `closedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `contactNo_UNIQUE` (`contactNo`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci