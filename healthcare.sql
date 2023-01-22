-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2023 at 10:26 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `speciality` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `number` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`name`, `email`, `username`, `password`, `speciality`, `address`, `number`) VALUES
('Dr Ibrahim Ahmed', 'ibrahim@gmail.com', 'ibrahim123', 'ibrahim123', 'Cardiologists', 'India', '+99545456214'),
('Dr. Rakib', 'rakib@gmail.com', 'rakib123', 'rakib123', 'Allergists', 'Sherpur', '01743223204');

-- --------------------------------------------------------

--
-- Table structure for table `problem`
--

CREATE TABLE `problem` (
  `ID` int(11) NOT NULL,
  `problem` varchar(300) NOT NULL,
  `solution` varchar(300) NOT NULL,
  `username` varchar(70) NOT NULL,
  `doctor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `problem`
--

INSERT INTO `problem` (`ID`, `problem`, `solution`, `username`, `doctor`) VALUES
(4, 'facing pain in back', '', 'abbas123', 'Dr. Rakib'),
(5, 'can\'t sleep properly', '', 'abbas123', 'Dr. Rakib'),
(8, 'Dimple problem in face', 'Drink water regularly', 'ragib123', 'Dr. Rakib');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`name`, `email`, `username`, `password`, `role`) VALUES
('Abbas Mastan', 'abbas@gmail.com', 'abbas123', 'abbas123', 'user'),
('Admin', 'admin@gmail.com', 'admin123', 'admin123', 'admin'),
('Abrar Ragib', 'ragib@gmail.com', 'ragib123', 'ragib123', 'user'),
('user2', 'user2', 'user2user2', 'user2user2', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `problem`
--
ALTER TABLE `problem`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`username`,`password`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `problem`
--
ALTER TABLE `problem`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
