-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2026 at 12:40 PM
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
-- Database: `course_db`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `tambah_kursus` (IN `p_nama` VARCHAR(50), IN `p_kategori` VARCHAR(50), IN `p_slot` INT)   BEGIN

    INSERT INTO kursus(
        nama_kursus,
        kategori,
        slot_tersedia
    )

    VALUES(
        p_nama,
        p_kategori,
        p_slot
    );

END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `jumlah_slot` () RETURNS INT(11) DETERMINISTIC BEGIN

    DECLARE total INT;

    SELECT SUM(slot_tersedia)
    INTO total
    FROM kursus;

    RETURN IFNULL(total,0);

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `kursus`
--

CREATE TABLE `kursus` (
  `id_kursus` int(11) NOT NULL,
  `nama_kursus` varchar(50) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `slot_tersedia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pendaftaran`
--

CREATE TABLE `pendaftaran` (
  `id_pendaftaran` int(11) NOT NULL,
  `id_peserta` int(11) NOT NULL,
  `id_kursus` int(11) NOT NULL,
  `tanggal_daftar` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `pendaftaran`
--
DELIMITER $$
CREATE TRIGGER `kurangi_slot` AFTER INSERT ON `pendaftaran` FOR EACH ROW BEGIN

    UPDATE kursus

    SET slot_tersedia = slot_tersedia - 1

    WHERE id_kursus = NEW.id_kursus;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tambah_slot` AFTER DELETE ON `pendaftaran` FOR EACH ROW BEGIN

    UPDATE kursus

    SET slot_tersedia = slot_tersedia + 1

    WHERE id_kursus = OLD.id_kursus;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `peserta`
--

CREATE TABLE `peserta` (
  `id_peserta` int(11) NOT NULL,
  `nama_peserta` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_peserta_terdaftar`
-- (See below for the actual view)
--
CREATE TABLE `v_peserta_terdaftar` (
`id_pendaftaran` int(11)
,`nama_peserta` varchar(50)
,`email` varchar(100)
,`nama_kursus` varchar(50)
,`kategori` varchar(50)
,`tanggal_daftar` timestamp
);

-- --------------------------------------------------------

--
-- Structure for view `v_peserta_terdaftar`
--
DROP TABLE IF EXISTS `v_peserta_terdaftar`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_peserta_terdaftar`  AS SELECT `pendaftaran`.`id_pendaftaran` AS `id_pendaftaran`, `peserta`.`nama_peserta` AS `nama_peserta`, `peserta`.`email` AS `email`, `kursus`.`nama_kursus` AS `nama_kursus`, `kursus`.`kategori` AS `kategori`, `pendaftaran`.`tanggal_daftar` AS `tanggal_daftar` FROM ((`pendaftaran` join `peserta` on(`peserta`.`id_peserta` = `pendaftaran`.`id_peserta`)) join `kursus` on(`kursus`.`id_kursus` = `pendaftaran`.`id_kursus`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kursus`
--
ALTER TABLE `kursus`
  ADD PRIMARY KEY (`id_kursus`);

--
-- Indexes for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD PRIMARY KEY (`id_pendaftaran`),
  ADD KEY `id_peserta` (`id_peserta`),
  ADD KEY `id_kursus` (`id_kursus`);

--
-- Indexes for table `peserta`
--
ALTER TABLE `peserta`
  ADD PRIMARY KEY (`id_peserta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kursus`
--
ALTER TABLE `kursus`
  MODIFY `id_kursus` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  MODIFY `id_pendaftaran` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `peserta`
--
ALTER TABLE `peserta`
  MODIFY `id_peserta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD CONSTRAINT `pendaftaran_ibfk_1` FOREIGN KEY (`id_peserta`) REFERENCES `peserta` (`id_peserta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pendaftaran_ibfk_2` FOREIGN KEY (`id_kursus`) REFERENCES `kursus` (`id_kursus`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
