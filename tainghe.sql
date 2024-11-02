-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 02, 2024 at 12:50 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlytainghe`
--

-- --------------------------------------------------------

--
-- Table structure for table `tainghe`
--

CREATE TABLE `tainghe` (
  `maTN` int(11) NOT NULL,
  `tenTN` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `mau_sac` varchar(50) DEFAULT NULL,
  `nhaSX` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tainghe`
--

INSERT INTO `tainghe` (`maTN`, `tenTN`, `price`, `mau_sac`, `nhaSX`) VALUES
(123, 'Airpod 2', 12000000.00, 'Black', 'Apple');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tainghe`
--
ALTER TABLE `tainghe`
  ADD PRIMARY KEY (`maTN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
