-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 21, 2012 at 10:03 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cbt-pmb`
--

-- --------------------------------------------------------

--
-- Table structure for table `calon_mahasiswa`
--

CREATE TABLE IF NOT EXISTS `calon_mahasiswa` (
  `calon_mahasiswa_id` bigint(20) NOT NULL,
  `agama` varchar(25) NOT NULL,
  `alamat_ortu` varchar(100) NOT NULL,
  `alamat_sekolah` varchar(100) NOT NULL,
  `alamat_tes` varchar(100) DEFAULT NULL,
  `email_tes` varchar(50) DEFAULT NULL,
  `handphone_ortu` varchar(20) DEFAULT NULL,
  `handphone_tes` varchar(20) DEFAULT NULL,
  `info_stta` varchar(100) DEFAULT NULL,
  `jenis_kelamin` int(11) NOT NULL,
  `jurusan` varchar(15) NOT NULL,
  `kabupaten` varchar(100) NOT NULL,
  `kabupaten_ortu` varchar(100) NOT NULL,
  `kabupaten_tes` varchar(100) DEFAULT NULL,
  `kode_pos_ortu` varchar(100) NOT NULL,
  `kode_pos_sekolah` varchar(10) NOT NULL,
  `kode_pos_tes` varchar(10) DEFAULT NULL,
  `nama` varchar(30) NOT NULL,
  `nama_ortu` varchar(100) NOT NULL,
  `nama_sekolah` varchar(100) NOT NULL,
  `pekerjaan_ortu` varchar(100) NOT NULL,
  `pilihankedua` varchar(50) NOT NULL,
  `pilihanpertama` varchar(50) NOT NULL,
  `propinsi_ortu` varchar(100) NOT NULL,
  `propinsi_sekolah` varchar(30) NOT NULL,
  `propinsi_tes` varchar(100) DEFAULT NULL,
  `slta` varchar(100) NOT NULL,
  `sumbangan` varchar(10) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `telephone_ortu` varchar(20) DEFAULT NULL,
  `telephone_tes` varchar(20) DEFAULT NULL,
  `tempat_lahir` varchar(100) NOT NULL,
  `tgl_registrasi` date NOT NULL,
  PRIMARY KEY (`calon_mahasiswa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `calon_mahasiswa`
--

INSERT INTO `calon_mahasiswa` (`calon_mahasiswa_id`, `agama`, `alamat_ortu`, `alamat_sekolah`, `alamat_tes`, `email_tes`, `handphone_ortu`, `handphone_tes`, `info_stta`, `jenis_kelamin`, `jurusan`, `kabupaten`, `kabupaten_ortu`, `kabupaten_tes`, `kode_pos_ortu`, `kode_pos_sekolah`, `kode_pos_tes`, `nama`, `nama_ortu`, `nama_sekolah`, `pekerjaan_ortu`, `pilihankedua`, `pilihanpertama`, `propinsi_ortu`, `propinsi_sekolah`, `propinsi_tes`, `slta`, `sumbangan`, `tanggal_lahir`, `telephone_ortu`, `telephone_tes`, `tempat_lahir`, `tgl_registrasi`) VALUES
(12, 'islam', 'yk', 'yk', NULL, NULL, NULL, NULL, NULL, 0, 'tkj', 'yk', 'yk', 'yk', '23444', '32222', '22222', 'Yusron', 'Hadi', 'SMA Bla', 'PNS', 'tp', 'tf', 'yk', 'yk', 'yk', 'bla', '200000', '1990-12-01', '32432432', '2343', 'yk', '2012-06-20');

-- --------------------------------------------------------

--
-- Table structure for table `jawaban`
--

CREATE TABLE IF NOT EXISTS `jawaban` (
  `jawaban_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kebenaran` bit(1) NOT NULL,
  `pilihan` text NOT NULL,
  `soal_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`jawaban_id`),
  KEY `FK93951E2E26C8BA60` (`soal_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=201 ;

--
-- Dumping data for table `jawaban`
--

INSERT INTO `jawaban` (`jawaban_id`, `kebenaran`, `pilihan`, `soal_id`) VALUES
(1, '0', 'Positif', 1),
(2, '0', 'Abnormal', 1),
(3, '0', 'Keras', 1),
(4, '1', 'Mutlak', 1),
(5, '0', 'Kesepakatan', 2),
(6, '0', 'Keadaan', 2),
(7, '0', 'Penggabungan', 2),
(8, '1', 'Penyesuaian', 2),
(9, '0', 'Keuangan', 3),
(10, '0', 'Laporan', 3),
(11, '1', 'Aturan', 3),
(12, '0', 'Pembelian', 3),
(13, '0', 'Persamaan', 4),
(14, '0', 'Kelembagaan', 4),
(15, '1', 'Pengakuan', 4),
(16, '0', 'Persyaratan', 4),
(17, '1', 'Percepatan', 5),
(18, '0', 'Kecepatan', 5),
(19, '0', 'Keindahan', 5),
(20, '0', 'Perpaduan', 5),
(21, '0', 'Hubungan', 6),
(22, '1', 'Ukuran', 6),
(23, '0', 'Berat', 6),
(24, '0', 'Acuan', 6),
(25, '0', 'Kelebihan', 7),
(26, '0', 'Perimbangan', 7),
(27, '1', 'Kekurangan', 7),
(28, '0', 'Pertemuan', 7),
(29, '1', 'Penderma', 8),
(30, '0', 'Penerima', 8),
(31, '0', 'Darah', 8),
(32, '0', 'Pemberian', 8),
(33, '0', 'Bertujuan', 9),
(34, '0', 'Berpeluang', 9),
(35, '0', 'Berhemat', 9),
(36, '1', 'Berhasil guna', 9),
(37, '1', 'Pendayagunaan', 10),
(38, '0', 'Pengumuman', 10),
(39, '0', 'Penelitian', 10),
(40, '0', 'Gosip', 10),
(41, '0', '20 tahun', 11),
(42, '1', '30 tahun', 11),
(43, '0', '35 tahun', 11),
(44, '0', '40 tahun', 11),
(45, '0', '7 tahun', 12),
(46, '0', '3 tahun', 12),
(47, '1', '5 tahun', 12),
(48, '0', '6 tahun', 12),
(49, '0', '1 berbanding 6', 13),
(50, '0', '5 berbanding 18', 13),
(51, '0', '5 berbanding 9', 13),
(52, '1', '6 berbanding 15', 13),
(53, '0', 'Seluruh uang Dias digunakan untuk membeli mobil-mobilan.', 14),
(54, '1', 'Mobil-mobilan koleksi Dias sebagian merupakan pemberian orang lain.', 14),
(55, '0', 'Dias membeli mobil-mobilan bekas yang harganya murah.', 14),
(56, '0', 'Uang saku Dias digunakan sebagian untuk membeli mobil-mobilan.', 14),
(57, '0', '3', 15),
(58, '1', '6', 15),
(59, '0', '12', 15),
(60, '0', '5', 15),
(61, '0', 'Rp. 100.000,-', 16),
(62, '1', 'Rp. 64.000,-', 16),
(63, '0', 'Rp. 120.000,-', 16),
(64, '0', 'Rp. 20.000,-', 16),
(65, '0', '78%', 17),
(66, '0', '68%', 17),
(67, '0', '48%', 17),
(68, '1', '46%', 17),
(69, '0', '28 orang', 18),
(70, '1', '56 orang', 18),
(71, '0', '14 orang', 18),
(72, '0', '58 orang', 18),
(73, '1', '10 unit', 19),
(74, '0', '15 unit', 19),
(75, '0', '12 unit', 19),
(76, '0', '30 unit', 19),
(77, '0', '21 orang', 20),
(78, '1', '24 orang', 20),
(79, '0', '26 orang', 20),
(80, '0', '29 orang', 20),
(81, '0', '64', 21),
(82, '0', '81', 21),
(83, '1', '49', 21),
(84, '0', '100', 21),
(85, '0', '36', 22),
(86, '0', '46', 22),
(87, '0', '48', 22),
(88, '1', '64', 22),
(89, '1', '80', 23),
(90, '0', '81', 23),
(91, '0', '79', 23),
(92, '0', '78', 23),
(93, '0', '9,6', 24),
(94, '0', '6,9', 24),
(95, '1', '9,0', 24),
(96, '0', '3,0', 24),
(97, '0', '6,9', 25),
(98, '0', '6,8', 25),
(99, '0', '5,9', 25),
(100, '1', '5,8', 25),
(101, '1', '0', 26),
(102, '0', '1', 26),
(103, '0', '2', 26),
(104, '0', '3', 26),
(105, '0', '30', 27),
(106, '0', '31', 27),
(107, '0', '32', 27),
(108, '1', '33', 27),
(109, '0', 'N,E', 28),
(110, '1', 'M,E', 28),
(111, '0', 'L,E', 28),
(112, '0', 'K,E', 28),
(113, '0', 'M,N', 29),
(114, '1', '''K,N', 29),
(115, '0', 'L,M', 29),
(116, '0', 'P,K', 29),
(117, '0', '31,32', 30),
(118, '0', '21,22', 30),
(119, '1', '30,32', 30),
(120, '0', '20,22', 30),
(121, '0', '11.30', 31),
(122, '0', '11.00', 31),
(123, '0', '10.30', 31),
(124, '1', '10.40', 31),
(125, '0', '440 km/jam', 32),
(126, '0', '520 km/jam', 32),
(127, '0', '600 km/jam', 32),
(128, '1', '720 km/jam', 32),
(129, '0', '5 km/jam', 33),
(130, '0', '8 km/jam', 33),
(131, '1', '10 km/jam', 33),
(132, '0', '12 km/jam', 33),
(133, '0', '10 km', 34),
(134, '1', '11 km', 34),
(135, '0', '12 km', 34),
(136, '0', '13 km', 34),
(137, '0', '120 km', 35),
(138, '0', '135 km', 35),
(139, '1', '150 km', 35),
(140, '0', '155 km', 35),
(141, '0', '10', 36),
(142, '1', '8', 36),
(143, '0', '6', 36),
(144, '0', '5', 36),
(145, '0', '3,5 jam', 37),
(146, '0', '5 jam', 37),
(147, '1', '4,5 jam', 37),
(148, '0', '4 jam', 37),
(149, '0', '2/2', 38),
(150, '0', '6/8', 38),
(151, '0', '''8/14', 38),
(152, '1', '15/64', 38),
(153, '0', '11', 39),
(154, '0', '13', 39),
(155, '1', '15', 39),
(156, '0', '17', 39),
(157, '0', '92 kali', 40),
(158, '1', '72 kali ', 40),
(159, '0', '74 kali', 40),
(160, '0', '84 kali', 40),
(161, '0', 'Pengawas', 41),
(162, '1', 'Pelajar', 41),
(163, '0', 'Ujian', 41),
(164, '0', 'Kelas', 41),
(165, '0', 'Listrik', 42),
(166, '0', 'Penyiar', 42),
(167, '1', 'Suara', 42),
(168, '0', 'Merdu', 42),
(169, '0', 'Roda', 43),
(170, '0', 'Lomba', 43),
(171, '0', 'Cepat', 43),
(172, '1', 'Transportasi', 43),
(173, '1', 'Kuas', 44),
(174, '0', 'Dempul', 44),
(175, '0', 'Amplas', 44),
(176, '0', 'Cat', 44),
(177, '0', 'Olah Raga', 45),
(178, '0', 'Piala', 45),
(179, '0', 'Cina', 45),
(180, '1', 'Sudirman', 45),
(181, '0', 'Bentol', 46),
(182, '0', 'Garuk', 46),
(183, '1', 'Semut', 46),
(184, '0', 'Luka', 46),
(185, '1', 'Awal', 47),
(186, '0', 'Kemudian', 47),
(187, '0', 'Setelah', 47),
(188, '0', 'Zaman', 47),
(189, '0', 'Manis', 48),
(190, '1', 'Lebah', 48),
(191, '0', 'Hutan', 48),
(192, '0', 'Bunga', 48),
(193, '0', 'Angin', 49),
(194, '0', 'Terbang', 49),
(195, '0', 'Perahu', 49),
(196, '1', 'Pesawat Terbang', 49),
(197, '0', 'Banteng', 50),
(198, '0', 'Gemuk', 50),
(199, '1', 'Binatang', 50),
(200, '0', 'Kulit', 50);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
  `kategori_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  PRIMARY KEY (`kategori_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`kategori_id`, `nama`) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C'),
(4, 'D'),
(5, 'E');

-- --------------------------------------------------------

--
-- Table structure for table `pengerjaan_soal`
--

CREATE TABLE IF NOT EXISTS `pengerjaan_soal` (
  `pengerjaan_soal_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jawaban_id` bigint(20) DEFAULT NULL,
  `soal_id` bigint(20) DEFAULT NULL,
  `ujian_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pengerjaan_soal_id`),
  KEY `FK153E6E0786BE38D4` (`ujian_id`),
  KEY `FK153E6E075FFD4B34` (`jawaban_id`),
  KEY `FK153E6E0726C8BA60` (`soal_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=51 ;

--
-- Dumping data for table `pengerjaan_soal`
--

INSERT INTO `pengerjaan_soal` (`pengerjaan_soal_id`, `jawaban_id`, `soal_id`, `ujian_id`) VALUES
(1, NULL, NULL, 1),
(2, NULL, NULL, 1),
(3, NULL, NULL, 1),
(4, NULL, NULL, 1),
(5, NULL, NULL, 1),
(6, NULL, NULL, 1),
(7, NULL, NULL, 1),
(8, NULL, NULL, 1),
(9, NULL, NULL, 1),
(10, NULL, NULL, 1),
(11, NULL, NULL, 1),
(12, NULL, NULL, 1),
(13, NULL, NULL, 1),
(14, NULL, NULL, 1),
(15, NULL, NULL, 1),
(16, NULL, NULL, 1),
(17, NULL, NULL, 1),
(18, NULL, NULL, 1),
(19, NULL, NULL, 1),
(20, NULL, NULL, 1),
(21, NULL, NULL, 1),
(22, NULL, NULL, 1),
(23, NULL, NULL, 1),
(24, NULL, NULL, 1),
(25, NULL, NULL, 1),
(26, NULL, NULL, 1),
(27, NULL, NULL, 1),
(28, NULL, NULL, 1),
(29, NULL, NULL, 1),
(30, NULL, NULL, 1),
(31, NULL, NULL, 1),
(32, NULL, NULL, 1),
(33, NULL, NULL, 1),
(34, NULL, NULL, 1),
(35, NULL, NULL, 1),
(36, NULL, NULL, 1),
(37, NULL, NULL, 1),
(38, NULL, NULL, 1),
(39, NULL, NULL, 1),
(40, NULL, NULL, 1),
(41, NULL, NULL, 1),
(42, NULL, NULL, 1),
(43, NULL, NULL, 1),
(44, NULL, NULL, 1),
(45, NULL, NULL, 1),
(46, NULL, NULL, 1),
(47, NULL, NULL, 1),
(48, NULL, NULL, 1),
(49, NULL, NULL, 1),
(50, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `soal`
--

CREATE TABLE IF NOT EXISTS `soal` (
  `soal_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_view` bigint(20) DEFAULT NULL,
  `pertanyaan` text NOT NULL,
  `kategori_id` bigint(20) NOT NULL,
  PRIMARY KEY (`soal_id`),
  KEY `FK35F3879AE57700` (`kategori_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=51 ;

--
-- Dumping data for table `soal`
--

INSERT INTO `soal` (`soal_id`, `is_view`, `pertanyaan`, `kategori_id`) VALUES
(1, NULL, 'ABSOLUT == ....   ', 5),
(2, NULL, 'ADAPTASI == ....', 5),
(3, NULL, 'ANGGARAN == .... ', 5),
(4, NULL, 'AKREDITASI ==  .....', 5),
(5, NULL, 'AKSELERASI == ....', 5),
(6, NULL, 'BAROMETER == ....', 5),
(7, NULL, 'DEFISIT == ....', 5),
(8, NULL, 'DONOR == ....', 5),
(9, NULL, 'EFEKTIF == .... ', 5),
(10, NULL, 'EKSPLOITASI == ....', 5),
(11, NULL, 'Rina menanyakan berapa umurnya dengan pernyataan: "Umur saya sekarang tiga kali umur keponakan saya, dan lima tahun yang lalu umur saya lima kali dari umur keponakan saya". Berapakah umur Rina ?', 2),
(12, NULL, 'Naufal berusia 7 tahun lebih tua dari Rizki. Rizki berusia 2 tahun lebih muda dari Hillmy. Berapa tahun selisih usia Naufal dengan Hilmy ?', 2),
(13, NULL, '1/3 berbanding 5/6 sama dengan ....', 2),
(14, NULL, 'Dias suka mengoleksi mobil-mobilan. Rata-rata harga mobil-mobilan yang ia miliki adalah Rp. 50.000,- per buah. Uang saku Dias sehari adalah Rp. 5.000,- . Dias sudah mengoleksi 10 mobil-mobilan dalam 2 bulan. Pernyataan di bawah ini yang dapat menjelaskan hal di atas adalah : ', 2),
(15, NULL, '9 adalah 150 persen dari ?', 2),
(16, NULL, 'Bambang menjual sebuah barang dengan harga Rp. 80.000,- dan memperoleh laba 25% dari harga beli. Berapakah harga beli barang tersebut?', 2),
(17, NULL, 'Dalam suatu pertemuan, panitia mengundang 50 wanita dan 70 pria. Ternyata dari undangan tersebut yang hadir hanya 40 % wanita dan 50 % pria dari jumlah keseluruhan undangan. Berapa persen tamu yang hadir ?', 2),
(18, NULL, 'Empat (4) orang menggali selokan dan selesai dalam waktu 7 hari. Berapa orang yang diperlukan untuk menggali selokan dalam waktu 1/2 hari?', 2),
(19, NULL, 'Feri akan menerima komisi sebesar 6% dari penjualan barang senilai Rp 3.000.000. Dalam waktu sebulan Feri menerima komisi Rp 900.000 setelah ia menjual beberapa barang A seharga Rp 300.000 per unit dan barang B sebesar Rp 400.000 per unit. Berapa unit barang A yang telah dijual oleh Feri jika perbandinagn barang A dan B yang terjual adalah 1/3?', 2),
(20, NULL, 'Enam buruh dapat menyelesaikan suatu pekerjaan dalam waktu 4 hari. Berapa orang buruh yang dibutuhkan untuk menyelesaikan pekerjaan tersebut dalam waktu 1 hari ?', 2),
(21, NULL, '4, 9, 16, 25, 36, ...  ', 3),
(22, NULL, '1, 2, 4, 8, 16, 32, ... ', 3),
(23, NULL, '18, 20, 24, 32, 48, ...', 3),
(24, NULL, '9, 9, 9, 6, 9, 3, ... , ...   ', 4),
(25, NULL, '2, 5, 3, 6, 4, 7, ... , ... ', 3),
(26, NULL, '15, 15, 14, 12, 9, 5, ...   	', 3),
(27, NULL, '8, 9, 12, 17, 24, ... , ... ', 3),
(28, NULL, 'A, E, D, E, H, E, ... , ... ', 3),
(29, NULL, 'C, F, E, H, G, J, I, L, ... , ...', 3),
(30, NULL, '60, 62, 50, 52, 40, 42, ... , ...', 3),
(31, NULL, 'Kecepatan mobil Adri 90 km per jam. Jarak Bogor-Jakarta 60 km. Jika Adri berangkat dari Bogor pukul 10, pukul berapa Adri akan tiba di Jakarta?', 4),
(32, NULL, 'Sebuah pesawat terbang menempuh jarak 3 km dalam waktu 15 detik. Berapa kecepatan pesawat terbang tersebut ?', 4),
(33, NULL, 'Jatmiko berjalan dari kota A ke kota B dengan kecepatan 8 km/jam selama 5 jam dan ia kembali ke kota A dengan naik motor. Berapakah kecepatan rata-rata seluruh perjalanan Jatmiko bila ia kembali dari kota B ke kota A selama 3 jam ? ', 4),
(34, NULL, 'Suatu perlombaan lari diadakan dengan dua kali perhentian. Jarak tempuh antara start sampai perhentian A adalah 2 km, antara perhentian A sampai dengan perhentian B adalah 7,5 km, dan antara perhentian B sampai dengan finish adalah 1,5 km. Berapa kilo meterkah total jarak tempuh pada perlombaan lari tersebut?', 4),
(35, NULL, 'Wiwik berangkat dari kota P pukul 6:15 dan sesampainya di kota M pukul 9:45. Jika Wiwik mengendarai mobilnya dengan kecepatan rata-rata 60 km/jam dan beristirahat selama satu jam untuk makan dan minum, berapa km jarak kota P dan M ?', 4),
(36, NULL, 'Benny berjalan kaki dengan kecepatan 5 km per jam, setelah 20 km dia berlari sehingga mencapai 60 km dalam waktu 6 jam. Berapa km per jam kecepatan rata-rata Benny itu ?', 4),
(37, NULL, 'Jika cuaca berkabut, sebuah mobil berjalan dengan kecepatan 30 km per jam. Jika cuaca baik kecepatan rata-rata mobil tersebut 60 km per jam. Berapa lama ia menempuh jalan yang panjangnya 210 km jika 2/7 (dua per tujuh) dari perjalanan itu bercuaca buruk berkabut?', 4),
(38, NULL, 'Di dalam suatu penelitian didapat kesimpulan bahwa perbandingan hewan yang bersifat PQ dengan populasi hewan yang tidak bersifat PQ adalah 5 : 3 dan bahwa 3/8 dari hewan tersebut yang bersifat PQ adalah jantan. Berapa perbandingan populasi hewan PQ jantan terhadap populasi hewan seluruhnya ?', 4),
(39, NULL, 'Jika roda pertama berputar 2 kali maka roda kedua berputar 5 kali. Berapa kalikah roda kedua akan berputar jika roda pertama berputar 6 kali ?', 4),
(40, NULL, 'Jika roda berputar 9 kali maka roda kedua berputar 24 kali. Jika roda yang pertama berputar 27 kali, berapa kali putaran roda kedua?', 4),
(41, NULL, 'Perusahaan - Karyawan = Sekolah - ....', 1),
(42, NULL, 'Televisi - Gambar = Radio - ....', 1),
(43, NULL, 'Telepon - Komunikasi = Sepeda - ...', 1),
(44, NULL, 'Kertas - Pena = Dinding - .... ', 1),
(45, NULL, 'Film - Oscar = Bulutangkis = ....', 1),
(46, NULL, 'Lapar - Makan = Gatal - ....', 1),
(47, NULL, 'Datang - Pergi = Akhir - ....', 1),
(48, NULL, 'Sutra - Ulat = Madu -', 1),
(49, NULL, 'Darat - Mobil = Udara - ....', 1),
(50, NULL, 'Pisang - Buah = Sapi - ....', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ujian`
--

CREATE TABLE IF NOT EXISTS `ujian` (
  `ujian_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hasil` float DEFAULT NULL,
  `calon_mahasiswa_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ujian_id`),
  KEY `FK6A283A1A1A70B25` (`calon_mahasiswa_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `ujian`
--

INSERT INTO `ujian` (`ujian_id`, `hasil`, `calon_mahasiswa_id`) VALUES
(1, NULL, 12);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jawaban`
--
ALTER TABLE `jawaban`
  ADD CONSTRAINT `FK93951E2E26C8BA60` FOREIGN KEY (`soal_id`) REFERENCES `soal` (`soal_id`);

--
-- Constraints for table `pengerjaan_soal`
--
ALTER TABLE `pengerjaan_soal`
  ADD CONSTRAINT `FK153E6E0726C8BA60` FOREIGN KEY (`soal_id`) REFERENCES `soal` (`soal_id`),
  ADD CONSTRAINT `FK153E6E075FFD4B34` FOREIGN KEY (`jawaban_id`) REFERENCES `jawaban` (`jawaban_id`),
  ADD CONSTRAINT `FK153E6E0786BE38D4` FOREIGN KEY (`ujian_id`) REFERENCES `ujian` (`ujian_id`);

--
-- Constraints for table `soal`
--
ALTER TABLE `soal`
  ADD CONSTRAINT `FK35F3879AE57700` FOREIGN KEY (`kategori_id`) REFERENCES `kategori` (`kategori_id`);

--
-- Constraints for table `ujian`
--
ALTER TABLE `ujian`
  ADD CONSTRAINT `FK6A283A1A1A70B25` FOREIGN KEY (`calon_mahasiswa_id`) REFERENCES `calon_mahasiswa` (`calon_mahasiswa_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
