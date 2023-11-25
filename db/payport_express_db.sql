-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2023 at 05:44 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payport_express_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `admin_id` int(11) NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `birthdate` date NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`admin_id`, `first_name`, `last_name`, `birthdate`, `sex`, `address`, `phone_number`, `email_address`, `password`, `date_created`, `date_modified`) VALUES
(100, 'Admin', 'Kein', '2002-10-22', 'Male', 'Musuan, Maramag, Bukidnon', '09999999999', 'kein@gmail.com', '123', '2023-11-25 16:44:02', '2023-11-25 16:44:02'),
(101, 'Admin', 'Bebong', '1999-12-10', 'Male', 'Musuan, Maramag, Bukidnon', '09888888888', 'bebong@gmail.com', '123', '2023-11-25 16:47:00', '2023-11-25 16:47:00');

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE `branches` (
  `branch_id` int(11) NOT NULL,
  `operation_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `branch_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `branches`
--

INSERT INTO `branches` (`branch_id`, `operation_status`, `branch_name`, `address`, `date_created`, `date_modified`) VALUES
(106, 'Active', 'Valencia Branch', 'Lumbo, Valencia, Bukidnon', '2023-11-26 00:03:28', '2023-11-26 00:04:30'),
(107, 'Inactive', 'Don Carlos Branch', 'Poblacion, Don Carlos, Bukidnon', '2023-11-26 00:04:05', '2023-11-26 00:18:11'),
(108, 'Active', 'Musuan Branch', 'Musuan, Maramag, Bukidnon', '2023-11-26 00:06:28', '2023-11-26 00:18:07');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `branch_stationed` int(11) NOT NULL,
  `working_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `birthdate` date NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`employee_id`, `branch_stationed`, `working_status`, `first_name`, `last_name`, `birthdate`, `sex`, `address`, `phone_number`, `email_address`, `password`, `date_created`, `date_modified`) VALUES
(1005, 106, 'Active', 'Employee', 'One', '2023-11-01', 'Male', 'Lumbo, Valencia, Bukidnon', '09111111111', 'one@gmail.com', '123', '2023-11-26 00:10:18', '2023-11-26 00:11:45'),
(1006, 107, 'On Leave', 'Employee', 'Two', '2023-11-02', 'Female', 'Poblacion, Don Carlos, Bukidnon', '09222222222', 'two@gmail.com', '123', '2023-11-26 00:11:23', '2023-11-26 00:18:25'),
(1007, 108, 'Fired', 'Employee', 'Three', '2023-11-03', 'Female', 'Musuan, Maramag, Bukidnon', '09333333333', 'three@gmail.com', '123', '2023-11-26 00:14:49', '2023-11-26 00:18:29'),
(1008, 106, 'Active', 'Employee', 'Four', '2023-11-04', 'Male', 'Lumbo, Valencia, Bukidnon', '09444444444', 'four@gmail.com', '123', '2023-11-26 00:16:01', '2023-11-26 00:16:01');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `control_number` int(11) NOT NULL,
  `verification_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sender_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sender_contact_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `receiver_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `receiver_contact_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sender_employee` int(11) DEFAULT NULL,
  `receiver_employee` int(11) DEFAULT NULL,
  `branch_sent` int(11) DEFAULT NULL,
  `branch_withdrawn` int(11) DEFAULT NULL,
  `date_sent` datetime DEFAULT NULL,
  `withdrawal_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `date_withdrawn` datetime DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`control_number`, `verification_status`, `sender_name`, `sender_contact_number`, `receiver_name`, `receiver_contact_number`, `amount`, `sender_employee`, `receiver_employee`, `branch_sent`, `branch_withdrawn`, `date_sent`, `withdrawal_status`, `date_withdrawn`, `date_created`, `date_modified`) VALUES
(100010, 'Verified', 'Sender One', '09101010101', 'Receiver One', '09010101010', '1000.00', 1005, 1006, 106, 107, '2023-11-26 00:27:35', 'Withdrawn', '2023-11-26 00:35:13', '2023-11-26 00:21:58', '2023-11-26 00:35:13'),
(100011, 'Verified', 'Sender Two', '09202020202', 'Receiver Two', '09020202020', '2000.00', 1006, NULL, 107, NULL, '2023-11-26 00:28:14', 'Not Withdrawn', NULL, '2023-11-26 00:22:59', '2023-11-26 00:28:14'),
(100012, 'Verified', 'Sender Three', '09303030303', 'Receiver Three', '09030303030', '3000.00', 1008, 1006, 106, 107, '2023-11-26 00:29:22', 'Withdrawn', '2023-11-26 00:34:59', '2023-11-26 00:23:59', '2023-11-26 00:34:59'),
(100014, 'Not Verified', 'Sender Four', '09404040404', 'Receiver Four', '09040404040', '4000.00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2023-11-26 00:25:34', '2023-11-26 00:25:34'),
(100015, 'Removed', 'Sender Five', '09505050505', 'Receiver Five', '09050505050', '5000.00', 1006, 1008, 107, 106, '2023-11-26 00:34:47', 'Withdrawn', '2023-11-26 00:37:09', '2023-11-26 00:34:11', '2023-11-26 00:38:04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `email_address` (`email_address`),
  ADD UNIQUE KEY `phone_number` (`phone_number`),
  ADD UNIQUE KEY `admin_id` (`admin_id`);

--
-- Indexes for table `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`branch_id`),
  ADD UNIQUE KEY `branch_id` (`branch_id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_id`) USING BTREE,
  ADD UNIQUE KEY `email_address` (`email_address`),
  ADD UNIQUE KEY `phone_number` (`phone_number`),
  ADD UNIQUE KEY `employee_id` (`employee_id`),
  ADD KEY `branch_id_idx` (`branch_stationed`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`control_number`),
  ADD UNIQUE KEY `control_number` (`control_number`),
  ADD KEY `sender_employee_idx` (`sender_employee`),
  ADD KEY `receiver_employee_idx` (`receiver_employee`),
  ADD KEY `branch_sent_idx` (`branch_sent`),
  ADD KEY `branch_withdrawn_idx` (`branch_withdrawn`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT for table `branches`
--
ALTER TABLE `branches`
  MODIFY `branch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1009;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `control_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100016;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `branch_stationed` FOREIGN KEY (`branch_stationed`) REFERENCES `branches` (`branch_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `branch_sent` FOREIGN KEY (`branch_sent`) REFERENCES `branches` (`branch_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `branch_withdrawn` FOREIGN KEY (`branch_withdrawn`) REFERENCES `branches` (`branch_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `receiver_employee` FOREIGN KEY (`receiver_employee`) REFERENCES `employees` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `sender_employee` FOREIGN KEY (`sender_employee`) REFERENCES `employees` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
