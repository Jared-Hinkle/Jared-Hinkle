CREATE DATABASE `comics` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `collection` (
  `issue` int NOT NULL,
  `series` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `pubMonth` varchar(45) DEFAULT NULL,
  `pubYear` varchar(45) DEFAULT NULL,
  `userID` int DEFAULT NULL,
  PRIMARY KEY (`issue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `admin` int DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `wishlist` (
  `issue` int NOT NULL,
  `series` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `pubMonth` varchar(45) DEFAULT NULL,
  `pubYear` varchar(45) DEFAULT NULL,
  `userID` int DEFAULT NULL,
  PRIMARY KEY (`issue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `comics`.`collection`
(`issue`,
`series`,
`publisher`,
`pubMonth`,
`pubYear`,
`userID`)
VALUES
(<{issue: }>,
<{series: }>,
<{publisher: }>,
<{pubMonth: }>,
<{pubYear: }>,
<{userID: }>);

INSERT INTO `comics`.`user`
(`id`,
`admin`,
`username`,
`password`)
VALUES
(<{id: }>,
<{admin: }>,
<{username: }>,
<{password: }>);

INSERT INTO `comics`.`wishlist`
(`issue`,
`series`,
`publisher`,
`pubMonth`,
`pubYear`,
`userID`)
VALUES
(<{issue: }>,
<{series: }>,
<{publisher: }>,
<{pubMonth: }>,
<{pubYear: }>,
<{userID: }>);
