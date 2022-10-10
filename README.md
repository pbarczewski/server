# server


CREATE TABLE `files` (  
  `guId` int(11) NOT NULL,  
  `filename` varchar(250) NOT NULL,  
  `srcLang` varchar(50) NOT NULL,  
  `trgLang` varchar(50) NOT NULL,  
  `customer` varchar(250) DEFAULT NULL,  
  `specialisation` int(3) DEFAULT NULL,  
  `engine` varchar(150) DEFAULT NULL,  
  `project` varchar(100) DEFAULT NULL,  
  `translator` varchar(250) DEFAULT NULL,  
  `addedOn` date NOT NULL,  
  PRIMARY KEY (`guId`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `segments` (  
  `guId` int(11) NOT NULL,  
  `srcText` text NOT NULL,  
  `trgText` text NOT NULL,  
  `mtText` text,  
  `matchRate` double DEFAULT NULL,  
  `ed` double DEFAULT NULL,  
  `fileid` int(11) DEFAULT NULL,  
  PRIMARY KEY (`guId`),  
  KEY `fileId` (`fileid`),  
  CONSTRAINT `segments_ibfk_1` FOREIGN KEY (`fileid`) REFERENCES `files` (`guid`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
