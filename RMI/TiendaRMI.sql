-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: TiendaRMI
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.17.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `AxF`
--

DROP TABLE IF EXISTS `AxF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AxF` (
  `idF` int(11) DEFAULT NULL,
  `IdA` int(11) DEFAULT NULL,
  KEY `fk_AxF_1_idx` (`idF`),
  KEY `fk_AxF_2_idx` (`IdA`),
  CONSTRAINT `fk_AxF_1` FOREIGN KEY (`idF`) REFERENCES `Factura` (`idFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AxF_2` FOREIGN KEY (`IdA`) REFERENCES `RMIarticulos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AxF`
--

LOCK TABLES `AxF` WRITE;
/*!40000 ALTER TABLE `AxF` DISABLE KEYS */;
/*!40000 ALTER TABLE `AxF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Factura`
--

DROP TABLE IF EXISTS `Factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Factura` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `Cliente` varchar(45) DEFAULT NULL,
  `Montototal` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`idFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Factura`
--

LOCK TABLES `Factura` WRITE;
/*!40000 ALTER TABLE `Factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `Factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RMIarticulos`
--

DROP TABLE IF EXISTS `RMIarticulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RMIarticulos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) CHARACTER SET utf8 DEFAULT NULL,
  `precio` varchar(70) CHARACTER SET utf8 DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RMIarticulos`
--

LOCK TABLES `RMIarticulos` WRITE;
/*!40000 ALTER TABLE `RMIarticulos` DISABLE KEYS */;
INSERT INTO `RMIarticulos` VALUES (1,'Relojes','1700','15'),(2,'Mesas','1400','20'),(3,'basos','750','45'),(4,'platos','1000','45'),(5,'utencilios','1100','45');
/*!40000 ALTER TABLE `RMIarticulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RMIusuarios`
--

DROP TABLE IF EXISTS `RMIusuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RMIusuarios` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(70) CHARACTER SET utf8 DEFAULT NULL,
  `correo` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `pass` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RMIusuarios`
--

LOCK TABLES `RMIusuarios` WRITE;
/*!40000 ALTER TABLE `RMIusuarios` DISABLE KEYS */;
INSERT INTO `RMIusuarios` VALUES (1,'brnady','ejemplo.com','1234'),(2,'asd','asd','asd'),(3483659,'Brandon','branrodsan@gmail.com','lechuga');
/*!40000 ALTER TABLE `RMIusuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'TiendaRMI'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26  3:01:16
