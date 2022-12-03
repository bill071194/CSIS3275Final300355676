-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 03, 2022 at 09:50 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.1.6

use "heroku_c2dcd1b592dbb4b";

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `SugarTrack_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `carbid` bigint(20) NOT NULL,
  `calories` float NOT NULL,
  `carbdate` varchar(255) DEFAULT NULL,
  `carbtime` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `foodtype` char(1) NOT NULL,
  `meal` char(1) NOT NULL,
  `pid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `pid` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `countrycode` varchar(255) DEFAULT NULL,
  `emailaddress` varchar(255) DEFAULT NULL,
  `emergencyemail` varchar(255) DEFAULT NULL,
  `emergencyfirstname` varchar(255) DEFAULT NULL,
  `emergencylastname` varchar(255) DEFAULT NULL,
  `emergencyphone` varchar(255) DEFAULT NULL,
  `exercise` int(11) NOT NULL,
  `exerciseduration` int(11) NOT NULL,
  `favfood` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `gender` char(1) NOT NULL,
  `height` float NOT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `mealsperday` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `pregnancystatus` varchar(255) DEFAULT NULL,
  `stateprovince` varchar(255) DEFAULT NULL,
  `subscriptionstatus` varchar(255) DEFAULT NULL,
  `weight` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`pid`, `address`, `countrycode`, `emailaddress`, `emergencyemail`, `emergencyfirstname`, `emergencylastname`, `emergencyphone`, `exercise`, `exerciseduration`, `favfood`, `firstname`, `gender`, `height`, `lastname`, `mealsperday`, `password`, `phonenumber`, `pregnancystatus`, `stateprovince`, `subscriptionstatus`, `weight`) VALUES
(1, '8750 140 Street', 'CAN', 'bruno', 'nageshbaral@gmail.com', 'Nagesh', 'Baral', '90', 0, 20, 'Meat', 'Bruno', 'M', 178, 'Finkielman', 3, 'bruno', '90', 'N', 'BC', 'P', 68);

-- --------------------------------------------------------

--
-- Table structure for table `physician`
--

CREATE TABLE `physician` (
  `phid` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `emailaddress` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `licencenumber` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `physician`
--

INSERT INTO `physician` (`phid`, `address`, `emailaddress`, `firstname`, `lastname`, `licencenumber`, `password`, `phonenumber`) VALUES
(1, '8750 140 Street', 'bruno', 'Jimesh', 'Adhikari', '34567', 'bruno', '90');

-- --------------------------------------------------------

--
-- Table structure for table `sugar`
--

CREATE TABLE `sugar` (
  `sugarid` bigint(20) NOT NULL,
  `activity` char(1) NOT NULL,
  `beforeafter` char(1) NOT NULL,
  `insulin` varchar(255) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `sugardate` varchar(255) DEFAULT NULL,
  `sugarlevel` float NOT NULL,
  `time` varchar(255) DEFAULT NULL,
  `units` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sugar`
--

INSERT INTO `sugar` (`sugarid`, `activity`, `beforeafter`, `insulin`, `pid`, `sugardate`, `sugarlevel`, `time`, `units`) VALUES
(1, 'M', 'M', 'Rapid Test', 1, '2022-12-03', 23, '12:40', 2),
(2, 'M', 'M', 'Rapid Test', 1, '2022-12-03', 4, '12:41', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`carbid`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `physician`
--
ALTER TABLE `physician`
  ADD PRIMARY KEY (`phid`);

--
-- Indexes for table `sugar`
--
ALTER TABLE `sugar`
  ADD PRIMARY KEY (`sugarid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `carbid` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `pid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `physician`
--
ALTER TABLE `physician`
  MODIFY `phid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sugar`
--
ALTER TABLE `sugar`
  MODIFY `sugarid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
