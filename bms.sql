-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2017 at 05:26 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bms`
--

-- --------------------------------------------------------

--
-- Table structure for table `education_loan_details`
--

CREATE TABLE `education_loan_details` (
  `EDUCATION_LOAN_ID` varchar(255) NOT NULL,
  `COURSE_FEE` bigint(20) DEFAULT NULL,
  `COURSE_NAME` varchar(255) DEFAULT NULL,
  `EDU_LOAN_ACCOUNT_NUMBER` bigint(20) NOT NULL,
  `EDU_LOAN_AMOUNT` bigint(20) DEFAULT NULL,
  `EDU_LOAN_APPLY_DATE` datetime DEFAULT NULL,
  `EDU_LOAN_DURATION` int(11) DEFAULT NULL,
  `FATHER_ANNUAL_INCOME` bigint(20) DEFAULT NULL,
  `FATHER_NAME` varchar(255) DEFAULT NULL,
  `ID_CARD_NUMBER` bigint(20) DEFAULT NULL,
  `ACCOUNT_NUMBER` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `education_loan_details`
--

INSERT INTO `education_loan_details` (`EDUCATION_LOAN_ID`, `COURSE_FEE`, `COURSE_NAME`, `EDU_LOAN_ACCOUNT_NUMBER`, `EDU_LOAN_AMOUNT`, `EDU_LOAN_APPLY_DATE`, `EDU_LOAN_DURATION`, `FATHER_ANNUAL_INCOME`, `FATHER_NAME`, `ID_CARD_NUMBER`, `ACCOUNT_NUMBER`) VALUES
('EL-123456', 9999, 'iot', 1000000000000006, 99999, '2017-12-12 00:00:00', 5, 88989889, 'John', 789, 1234567890123456),
('EL-123456', 9999, 'iot', 1000000000000007, 99999, '2017-12-12 00:00:00', 5, 88989889, 'John', 789, 1234567890123456),
('EL-123456', 8889, 'Android', 1000000000000008, 8888, '2017-12-12 00:00:00', 5, 88989889, 'John', 789, 1234567890123456),
('EL-123456', 8889, 'Android', 1000000000000009, 8888, '2017-12-12 00:00:00', 5, 88989889, 'John', 789, 1234567890123456),
('EL-123456', 12000, 'Full Stack', 1000000000000010, 8888, '2017-12-12 00:00:00', 10, 999990990, 'doine', 878, 1234567890123457),
('EL-123456', 5000000, 'MS', 1000000000000011, 1000000, '2017-07-02 20:53:40', 5, 6000000, 'pritesh', 123456789123, 1234567890111111),
('EL-123456', 5000000, 'MS', 1000000000000012, 1000000, '2017-07-02 20:54:16', 5, 6000000, 'pritesh', 123456789123, 1234567890111111),
('EL-123456', 5000000, 'MS', 1000000000000013, 1000000, '2017-07-02 20:54:36', 5, 6000000, 'pritesh', 123456789123, 1234567890111111);

-- --------------------------------------------------------

--
-- Table structure for table `home_loan_details`
--

CREATE TABLE `home_loan_details` (
  `HOME_LOAN_ID` varchar(255) NOT NULL,
  `ANNUAL_INCOME` bigint(20) NOT NULL,
  `COMPANY_NAME` varchar(255) DEFAULT NULL,
  `EXP_CURRENT_COMPANY` int(11) DEFAULT NULL,
  `DESIGNATION` varchar(255) DEFAULT NULL,
  `HOME_LOAN_ACCOUNT_NUMBER` bigint(20) NOT NULL,
  `LOAN_AMOUNT` bigint(20) DEFAULT NULL,
  `LOAN_APPLY_DATE` datetime DEFAULT NULL,
  `TOTAL_EXP` int(11) DEFAULT NULL,
  `ACCOUNT_NUMBER` bigint(20) NOT NULL,
  `LOAN_DURATION` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `home_loan_details`
--

INSERT INTO `home_loan_details` (`HOME_LOAN_ID`, `ANNUAL_INCOME`, `COMPANY_NAME`, `EXP_CURRENT_COMPANY`, `DESIGNATION`, `HOME_LOAN_ACCOUNT_NUMBER`, `LOAN_AMOUNT`, `LOAN_APPLY_DATE`, `TOTAL_EXP`, `ACCOUNT_NUMBER`, `LOAN_DURATION`) VALUES
('HL-457', 9999999999, 'CTS', 5, 'Des', 1000000000000008, 767676, '2017-10-08 00:00:00', 5, 1234567890123457, 20),
('HL-456', 5000000, 'ddsf', 1, 'fs', 1000000000000015, 2342342, '2017-12-07 00:00:00', 1, 1234567890123456, 10),
('HL-111', 300000, 'cognizant', 1, 'pat', 1000000000000016, 10000, '2017-07-02 20:48:25', 3, 1234567890111111, 3),
('HL-111', 300000, 'cognizant', 1, 'pat', 1000000000000017, 10000, '2017-07-02 20:49:37', 3, 1234567890111111, 3),
('HL-111', 300000, 'cognizant', 1, 'pat', 1000000000000018, 10000, '2017-07-02 20:50:19', 3, 1234567890111111, 3),
('HL-111', 300000, 'cognizant', 1, 'pat', 1000000000000019, 10000, '2017-07-02 20:51:22', 3, 1234567890111111, 3);

-- --------------------------------------------------------

--
-- Table structure for table `sequence_education`
--

CREATE TABLE `sequence_education` (
  `pk_id` varchar(255) DEFAULT NULL,
  `sequence_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence_education`
--

INSERT INTO `sequence_education` (`pk_id`, `sequence_id`) VALUES
('sequenceedu', 1000000000000014);

-- --------------------------------------------------------

--
-- Table structure for table `sequence_home`
--

CREATE TABLE `sequence_home` (
  `pk_id` varchar(255) DEFAULT NULL,
  `sequence_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence_home`
--

INSERT INTO `sequence_home` (`pk_id`, `sequence_id`) VALUES
('sequencehome', 1000000000000020);

-- --------------------------------------------------------

--
-- Table structure for table `sequence_transaction`
--

CREATE TABLE `sequence_transaction` (
  `pk_id` varchar(255) DEFAULT NULL,
  `sequence_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence_transaction`
--

INSERT INTO `sequence_transaction` (`pk_id`, `sequence_id`) VALUES
('sequencetransaction', 1000000001);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_details`
--

CREATE TABLE `transaction_details` (
  `TRANSACTION_ID` bigint(20) NOT NULL,
  `TRANSACTION_AMOUNT` bigint(20) DEFAULT NULL,
  `TRANSACTION_DESCRIPTION` varchar(255) DEFAULT NULL,
  `TRANSACTION_TYPE` varchar(255) DEFAULT NULL,
  `ACCOUNT_NUMBER` bigint(20) DEFAULT NULL,
  `accountNumber` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction_details`
--

INSERT INTO `transaction_details` (`TRANSACTION_ID`, `TRANSACTION_AMOUNT`, `TRANSACTION_DESCRIPTION`, `TRANSACTION_TYPE`, `ACCOUNT_NUMBER`, `accountNumber`) VALUES
(1000000006, 1, 'test', 'credit', 1234567890123456, NULL),
(1000000007, 1, 'test', 'credit', 1234567890123456, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `ACCOUNT_NUMBER` bigint(20) NOT NULL,
  `ACCOUNT_BALANCE` bigint(20) DEFAULT NULL,
  `ACCOUNT_HOLDER_NAME` varchar(255) DEFAULT NULL,
  `ACCOUNT_TYPE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`ACCOUNT_NUMBER`, `ACCOUNT_BALANCE`, `ACCOUNT_HOLDER_NAME`, `ACCOUNT_TYPE`) VALUES
(1234567890111111, 99000, 'x', 'saving'),
(1234567890123456, 10108139, 'Om Prakash', 'saving'),
(1234567890123457, 840000, 'Donnie Yen', 'salary');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `education_loan_details`
--
ALTER TABLE `education_loan_details`
  ADD PRIMARY KEY (`EDU_LOAN_ACCOUNT_NUMBER`),
  ADD KEY `FK_8gclerl7ejc4w2q8t6bcp1pwj` (`ACCOUNT_NUMBER`);

--
-- Indexes for table `home_loan_details`
--
ALTER TABLE `home_loan_details`
  ADD PRIMARY KEY (`HOME_LOAN_ACCOUNT_NUMBER`),
  ADD KEY `FK_nad1q7afj9454w0cbrwja2ojt` (`ACCOUNT_NUMBER`);

--
-- Indexes for table `transaction_details`
--
ALTER TABLE `transaction_details`
  ADD PRIMARY KEY (`TRANSACTION_ID`),
  ADD KEY `FK_e1fmwe181hdlushykhb1j7dmc` (`ACCOUNT_NUMBER`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`ACCOUNT_NUMBER`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transaction_details`
--
ALTER TABLE `transaction_details`
  MODIFY `TRANSACTION_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000000009;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `education_loan_details`
--
ALTER TABLE `education_loan_details`
  ADD CONSTRAINT `FK_8gclerl7ejc4w2q8t6bcp1pwj` FOREIGN KEY (`ACCOUNT_NUMBER`) REFERENCES `user_details` (`ACCOUNT_NUMBER`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
