-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2023 at 10:17 PM
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
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `sex` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`admin_id`, `first_name`, `last_name`, `birthdate`, `sex`, `address`, `phone_number`, `email_address`, `password`, `date_created`, `date_modified`) VALUES
(1, 'Default', 'Admin', '2000-01-01', 'Male', 'Default City', '09999999999', 'defaultadmin@gmail.com', '12345678', '2023-10-13 17:03:36', '2023-10-13 17:03:36');

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE `branches` (
  `branch_id` int(11) NOT NULL,
  `operation_status` varchar(255) NOT NULL,
  `branch_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `contact_information` varchar(255) NOT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `branches`
--

INSERT INTO `branches` (`branch_id`, `operation_status`, `branch_name`, `address`, `contact_information`, `date_created`, `date_modified`) VALUES
(1, 'Active', 'Default Branch', 'Default City', '09999999999', '2023-10-13 16:43:29', '2023-10-13 16:43:29');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `branch_stationed` int(11) NOT NULL,
  `working_status` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `sex` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`employee_id`, `branch_stationed`, `working_status`, `first_name`, `last_name`, `birthdate`, `sex`, `address`, `phone_number`, `email_address`, `password`, `date_created`, `date_modified`) VALUES
(1, 1, 'Active', 'Default', 'Employee', '2000-01-01', 'Male', 'Default City', '09999999999', 'defaultemployee@gmail.com', '12345678', '2023-10-13 16:49:55', '2023-10-13 16:49:55');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transaction_id` int(11) NOT NULL,
  `verification_status` varchar(255) NOT NULL,
  `sender_name` varchar(255) NOT NULL,
  `sender_contact_number` varchar(255) NOT NULL,
  `receiver_name` varchar(255) NOT NULL,
  `receiver_contact_number` varchar(255) NOT NULL,
  `amount` varchar(255) NOT NULL,
  `control_number` varchar(255) DEFAULT NULL,
  `sender_employee` int(11) DEFAULT NULL,
  `receiver_employee` int(11) DEFAULT NULL,
  `branch_sent` int(11) DEFAULT NULL,
  `branch_withdrawn` int(11) DEFAULT NULL,
  `date_sent` datetime DEFAULT NULL,
  `withdrawal_status` varchar(255) DEFAULT NULL,
  `date_withdrawn` datetime DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transaction_id`, `verification_status`, `sender_name`, `sender_contact_number`, `receiver_name`, `receiver_contact_number`, `amount`, `control_number`, `sender_employee`, `receiver_employee`, `branch_sent`, `branch_withdrawn`, `date_sent`, `withdrawal_status`, `date_withdrawn`, `date_created`, `date_modified`) VALUES
(1, 'Not Verified', 'Default Sender', '09999999999', 'Default Receiver', '09999999999', '1000.00', NULL, 1, 1, 1, 1, NULL, NULL, NULL, '2023-10-13 23:01:40', '2023-10-13 23:01:40');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`branch_id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_id`,`branch_stationed`),
  ADD KEY `branch_id_idx` (`branch_stationed`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transaction_id`),
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
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `branches`
--
ALTER TABLE `branches`
  MODIFY `branch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

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
