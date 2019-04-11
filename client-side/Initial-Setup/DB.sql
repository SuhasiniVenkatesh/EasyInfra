-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: trial
-- ------------------------------------------------------
-- Server version	5.5.49-0ubuntu0.14.04.1

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
-- Table structure for table `axatech`
--

DROP TABLE IF EXISTS `axatech`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `axatech` (
  `id-axatech` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(10) NOT NULL,
  `month` varchar(10) NOT NULL,
  `date` varchar(10) NOT NULL,
  `hour` varchar(10) NOT NULL,
  `minute` varchar(10) NOT NULL,
  `second` varchar(10) NOT NULL,
  `millisecond` varchar(10) DEFAULT '00',
  `pRed` float NOT NULL,
  `pYellow` float NOT NULL,
  `pGreen` float NOT NULL,
  PRIMARY KEY (`id-axatech`)
) ENGINE=InnoDB;


--
-- Table structure for table `hosur_road`
--

DROP TABLE IF EXISTS `hosur_road`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosur_road` (
  `id-hosur-road` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(10) NOT NULL,
  `month` varchar(10) NOT NULL,
  `date` varchar(10) NOT NULL,
  `hour` varchar(10) NOT NULL,
  `minute` varchar(10) NOT NULL,
  `second` varchar(10) NOT NULL,
  `millisecond` varchar(10) DEFAULT '00',
  `pRed` float NOT NULL,
  `pYellow` float NOT NULL,
  `pGreen` float NOT NULL,
  PRIMARY KEY (`id-hosur-road`)
) ENGINE=InnoDB; 


--
-- Table structure for table `hosur_road_2`
--

DROP TABLE IF EXISTS `hosur_road_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosur_road_2` (
  `id-hosur-road-2` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(10) NOT NULL,
  `month` varchar(10) NOT NULL,
  `date` varchar(10) NOT NULL,
  `hour` varchar(10) NOT NULL,
  `minute` varchar(10) NOT NULL,
  `second` varchar(10) NOT NULL,
  `millisecond` varchar(10) DEFAULT '00',
  `pRed` float NOT NULL,
  `pYellow` float NOT NULL,
  `pGreen` float NOT NULL,
  PRIMARY KEY (`id-hosur-road-2`)
) ENGINE=InnoDB;

--
-- Table structure for table `ring_road`
--

DROP TABLE IF EXISTS `ring_road`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ring_road` (
  `id-ring-road` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(10) NOT NULL,
  `month` varchar(10) NOT NULL,
  `date` varchar(10) NOT NULL,
  `hour` varchar(10) NOT NULL,
  `minute` varchar(10) NOT NULL,
  `second` varchar(10) NOT NULL,
  `millisecond` varchar(10) DEFAULT '00',
  `pRed` float NOT NULL,
  `pYellow` float NOT NULL,
  `pGreen` float NOT NULL,
  PRIMARY KEY (`id-ring-road`)
) ENGINE=InnoDB;


--
-- Table structure for table `silkboard`
--

DROP TABLE IF EXISTS `silkboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `silkboard` (
  `id-silkboard` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(10) NOT NULL,
  `month` varchar(10) NOT NULL,
  `date` varchar(10) NOT NULL,
  `hour` varchar(10) NOT NULL,
  `minute` varchar(10) NOT NULL,
  `second` varchar(10) NOT NULL,
  `millisecond` varchar(10) DEFAULT '00',
  `pRed` float NOT NULL,
  `pYellow` float NOT NULL,
  `pGreen` float NOT NULL,
  PRIMARY KEY (`id-silkboard`)
) ENGINE=InnoDB;
