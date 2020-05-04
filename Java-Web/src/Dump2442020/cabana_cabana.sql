-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: cabana
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cabana`
--

DROP TABLE IF EXISTS `cabana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cabana` (
  `IdCabana` int NOT NULL,
  `PrecioDia` double DEFAULT NULL,
  `Televisor` varchar(45) DEFAULT NULL,
  `Calefaccion` varchar(45) DEFAULT NULL,
  `WiFi` varchar(45) DEFAULT NULL,
  `Cochera` varchar(45) DEFAULT NULL,
  `Lavarropa` varchar(45) DEFAULT NULL,
  `Heladera` varchar(45) DEFAULT NULL,
  `Cocina` varchar(45) DEFAULT NULL,
  `Asador` varchar(45) DEFAULT NULL,
  `Capacidad` varchar(45) DEFAULT NULL,
  `Lugar` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdCabana`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabana`
--

LOCK TABLES `cabana` WRITE;
/*!40000 ALTER TABLE `cabana` DISABLE KEYS */;
INSERT INTO `cabana` VALUES (1,6500,'si','si','si','si','si','si','si','si','5 personas','Chalten','Cerro Solo 69'),(2,5000,'si','si','si','no','no','si','si','no','4 personas','Calafate','Los Tehuelches 1232'),(3,5500,'si','si','si','si','si','si','si','no','3 personas','Ushuaia','Luis Fernando Martial 1430'),(4,5000,'si','si','si','si','si','si','si','si','6 personas','Bolson',' Subida Los Maitenes 1540'),(5,7000,'si','si','si','si','si','si','si','no','6 personas','Esquel','Los Cipreses 1200');
/*!40000 ALTER TABLE `cabana` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04 12:53:03
