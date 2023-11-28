-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: payport_express_db
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `birthdate` date NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `email_address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `email_address` (`email_address`),
  UNIQUE KEY `phone_number` (`phone_number`),
  UNIQUE KEY `admin_id` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES (100,'Admin','Kein','2002-10-22','Male','Musuan, Maramag, Bukidnon','09999999999','kein@gmail.com','123','2023-11-25 16:44:02','2023-11-25 16:44:02'),(101,'Admin','Bebong','1999-12-10','Male','Musuan, Maramag, Bukidnon','09888888888','bebong@gmail.com','123','2023-11-25 16:47:00','2023-11-25 16:47:00');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branches`
--

DROP TABLE IF EXISTS `branches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branches` (
  `branch_id` int NOT NULL AUTO_INCREMENT,
  `operation_status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `branch_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL,
  PRIMARY KEY (`branch_id`),
  UNIQUE KEY `branch_id` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branches`
--

LOCK TABLES `branches` WRITE;
/*!40000 ALTER TABLE `branches` DISABLE KEYS */;
INSERT INTO `branches` VALUES (106,'Active','Valencia Branch','Lumbo, Valencia, Bukidnon','2023-11-26 00:03:28','2023-11-26 00:04:30'),(107,'Inactive','Don Carlos Branch','Poblacion, Don Carlos, Bukidnon','2023-11-26 00:04:05','2023-11-26 00:18:11'),(108,'Active','Musuan Branch','Musuan, Maramag, Bukidnon','2023-11-26 00:06:28','2023-11-26 00:18:07');
/*!40000 ALTER TABLE `branches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `branch_stationed` int NOT NULL,
  `working_status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `birthdate` date NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `email_address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE,
  UNIQUE KEY `email_address` (`email_address`),
  UNIQUE KEY `phone_number` (`phone_number`),
  UNIQUE KEY `employee_id` (`employee_id`),
  KEY `branch_id_idx` (`branch_stationed`),
  CONSTRAINT `branch_stationed` FOREIGN KEY (`branch_stationed`) REFERENCES `branches` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1005,106,'Active','Employee','One','2023-11-01','Male','Lumbo, Valencia, Bukidnon','09111111111','one@gmail.com','123','2023-11-26 00:10:18','2023-11-26 00:11:45'),(1006,107,'On Leave','Employee','Two','2023-11-02','Female','Poblacion, Don Carlos, Bukidnon','09222222222','two@gmail.com','123','2023-11-26 00:11:23','2023-11-26 00:18:25'),(1008,106,'Fired','Employee','Three','2023-11-04','Male','Lumbo, Valencia, Bukidnon','09333333333','three@gmail.com','123','2023-11-26 00:16:01','2023-11-28 22:53:32');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `control_number` int NOT NULL AUTO_INCREMENT,
  `verification_status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `sender_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `sender_contact_number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `receiver_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `receiver_contact_number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `amount` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `sender_employee` int DEFAULT NULL,
  `receiver_employee` int DEFAULT NULL,
  `branch_sent` int DEFAULT NULL,
  `branch_withdrawn` int DEFAULT NULL,
  `date_sent` datetime DEFAULT NULL,
  `withdrawal_status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `date_withdrawn` datetime DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL,
  PRIMARY KEY (`control_number`),
  UNIQUE KEY `control_number` (`control_number`),
  KEY `sender_employee_idx` (`sender_employee`),
  KEY `receiver_employee_idx` (`receiver_employee`),
  KEY `branch_sent_idx` (`branch_sent`),
  KEY `branch_withdrawn_idx` (`branch_withdrawn`),
  CONSTRAINT `branch_sent` FOREIGN KEY (`branch_sent`) REFERENCES `branches` (`branch_id`),
  CONSTRAINT `branch_withdrawn` FOREIGN KEY (`branch_withdrawn`) REFERENCES `branches` (`branch_id`),
  CONSTRAINT `receiver_employee` FOREIGN KEY (`receiver_employee`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `sender_employee` FOREIGN KEY (`sender_employee`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100019 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (100010,'Verified','Sender One','09101010101','Receiver One','09010101010','1000',1005,1006,106,107,'2023-11-26 00:27:35','Withdrawn','2023-11-26 00:35:13','2023-11-26 00:21:58','2023-11-26 00:35:13'),(100011,'Verified','Sender Two','09202020202','Receiver Two','09020202020','2000',1006,NULL,107,NULL,'2023-11-26 00:28:14','Not Withdrawn',NULL,'2023-11-26 00:22:59','2023-11-26 00:28:14'),(100012,'Verified','Sender Three','09303030303','Receiver Three','09030303030','3000',1008,1006,106,107,'2023-11-26 00:29:22','Withdrawn','2023-11-26 00:34:59','2023-11-26 00:23:59','2023-11-26 00:34:59'),(100014,'Verified','Sender Four','09404040404','Receiver Four','09040404040','4000',1005,NULL,106,NULL,'2023-11-28 19:54:06','Not Withdrawn',NULL,'2023-11-26 00:25:34','2023-11-28 19:54:06');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 23:40:27
