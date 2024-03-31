-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: database_garage_oto
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bang_cham_cong`
--

DROP TABLE IF EXISTS `bang_cham_cong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bang_cham_cong` (
  `ma_bang_cham_cong` varchar(255) NOT NULL,
  `gio_tang_ca` smallint(6) DEFAULT NULL,
  `ngay_lam` date DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT NULL,
  `ma_ca_lam` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_bang_cham_cong`),
  KEY `FKkviqrs0io1flj8hfds1vlt20i` (`ma_ca_lam`),
  KEY `FK8d1210voh20sgyowbutqw36q8` (`ma_nhan_vien`),
  CONSTRAINT `FK8d1210voh20sgyowbutqw36q8` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `FKkviqrs0io1flj8hfds1vlt20i` FOREIGN KEY (`ma_ca_lam`) REFERENCES `ca_lam` (`ma_ca_lam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bang_cham_cong`
--

LOCK TABLES `bang_cham_cong` WRITE;
/*!40000 ALTER TABLE `bang_cham_cong` DISABLE KEYS */;
INSERT INTO `bang_cham_cong` VALUES ('BC001',0,'2024-01-01','Đầy đủ','CAL001','NV001'),('BC002',0,'2024-01-02','Vắng','CAL001','NV002'),('BC003',0,'2024-01-27','Đi trễ','CAL001','NV003'),('BC004',0,'2024-01-04','Đầy đủ','CAL002','NV004'),('BC005',0,'2023-01-18','Đầy đủ','CAL001','NV005'),('BC006',0,'2024-02-06','Đầy đủ','CAL002','NV006'),('BC007',0,'2024-03-19','Đi trễ','CAL003','NV007'),('BC008',0,'2023-05-08','Vắng','CAL003','NV008'),('BC009',2,'2024-01-09','Tăng ca','CAL001','NV009'),('BC010',0,'2024-01-31','Vắng','CAL001','NV005'),('BCC011',NULL,'2024-03-25','Vắng','CAL002','NV005');
/*!40000 ALTER TABLE `bang_cham_cong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bang_luong`
--

DROP TABLE IF EXISTS `bang_luong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bang_luong` (
  `ma_bang_luong` varchar(255) NOT NULL,
  `che_do_luong` varchar(255) DEFAULT NULL,
  `tien_luong` double DEFAULT NULL,
  PRIMARY KEY (`ma_bang_luong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bang_luong`
--

LOCK TABLES `bang_luong` WRITE;
/*!40000 ALTER TABLE `bang_luong` DISABLE KEYS */;
INSERT INTO `bang_luong` VALUES ('BL001','gio',23000),('BL002','ca',100000),('BL003','thang',8000000);
/*!40000 ALTER TABLE `bang_luong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bang_luong_nhan_vien`
--

DROP TABLE IF EXISTS `bang_luong_nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bang_luong_nhan_vien` (
  `ma_bang_luong` varchar(50) NOT NULL,
  `ma_nhan_vien` varchar(50) NOT NULL,
  `ngay_bat_dau` datetime DEFAULT NULL,
  `ngay_ket_thuc` datetime DEFAULT NULL,
  PRIMARY KEY (`ma_bang_luong`,`ma_nhan_vien`),
  KEY `ma_nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `bang_luong_nhan_vien_ibfk_1` FOREIGN KEY (`ma_bang_luong`) REFERENCES `bang_luong` (`ma_bang_luong`),
  CONSTRAINT `bang_luong_nhan_vien_ibfk_2` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bang_luong_nhan_vien`
--

LOCK TABLES `bang_luong_nhan_vien` WRITE;
/*!40000 ALTER TABLE `bang_luong_nhan_vien` DISABLE KEYS */;
INSERT INTO `bang_luong_nhan_vien` VALUES ('BL003','NV001','2024-01-01 08:00:00','2024-12-31 23:00:00'),('BL003','NV002','2024-01-01 08:00:00','2024-12-31 23:00:00'),('BL003','NV003','2024-01-01 08:00:00','2024-12-31 23:00:00'),('BL003','NV004','2024-01-01 08:00:00','2024-12-31 23:00:00'),('BL003','NV005','2024-01-01 08:00:00','2024-12-31 23:00:00'),('BL003','NV006','2024-01-01 08:00:00','2024-12-31 23:00:00'),('BL003','NV007','2024-01-01 08:00:00','2024-12-31 23:00:00'),('BL003','NV008','2024-01-01 08:00:00','2024-12-31 23:00:00'),('BL003','NV009','2024-01-01 08:00:00','2024-12-31 23:00:00'),('BL003','NV010','2024-01-01 08:00:00','2024-12-31 23:00:00');
/*!40000 ALTER TABLE `bang_luong_nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ca_lam`
--

DROP TABLE IF EXISTS `ca_lam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ca_lam` (
  `ma_ca_lam` varchar(255) NOT NULL,
  `ten_ca_lam` varchar(255) DEFAULT NULL,
  `thoi_gian_bat_dau` time(6) DEFAULT NULL,
  `thoi_gian_ket_thuc` time(6) DEFAULT NULL,
  PRIMARY KEY (`ma_ca_lam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ca_lam`
--

LOCK TABLES `ca_lam` WRITE;
/*!40000 ALTER TABLE `ca_lam` DISABLE KEYS */;
INSERT INTO `ca_lam` VALUES ('CAL001','Ca Sáng','08:00:00.000000','12:00:00.000000'),('CAL002','Ca Chiều','13:00:00.000000','17:00:00.000000'),('CAL003','Ca Tối','18:00:00.000000','22:00:00.000000');
/*!40000 ALTER TABLE `ca_lam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_nhanh`
--

DROP TABLE IF EXISTS `chi_nhanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chi_nhanh` (
  `ma_chi_nhanh` varchar(255) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `ten_chi_nhanh` varchar(255) DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_chi_nhanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_nhanh`
--

LOCK TABLES `chi_nhanh` WRITE;
/*!40000 ALTER TABLE `chi_nhanh` DISABLE KEYS */;
INSERT INTO `chi_nhanh` VALUES ('CN001','123 ABC Street, District 1, Ho Chi Minh City','Chi Nhánh A','Hoạt động'),('CN002','456 XYZ Street, District 2, Ho Chi Minh City','Chi Nhánh B','Ngừng hoạt động'),('CN003','789 DEF Street, District 3, Ho Chi Minh City','Chi Nhánh C','Ngừng hoạt động');
/*!40000 ALTER TABLE `chi_nhanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_tiet_phieu_nhap_hang`
--

DROP TABLE IF EXISTS `chi_tiet_phieu_nhap_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chi_tiet_phieu_nhap_hang` (
  `ma_chi_tiet_phieu_nhap_hang` varchar(50) NOT NULL,
  `ma_hang_hoa` varchar(50) DEFAULT NULL,
  `so_luong` smallint(6) DEFAULT NULL,
  `gia_nhap` double DEFAULT NULL,
  `tong` double DEFAULT NULL,
  `giam_gia` double DEFAULT NULL,
  `thanh_tien` double DEFAULT NULL,
  `ma_phieu_nhap_hang` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_chi_tiet_phieu_nhap_hang`),
  KEY `ma_hang_hoa` (`ma_hang_hoa`),
  KEY `fk_ma_phieu_nhap_hang` (`ma_phieu_nhap_hang`),
  CONSTRAINT `chi_tiet_phieu_nhap_hang_ibfk_1` FOREIGN KEY (`ma_hang_hoa`) REFERENCES `hang_hoa` (`ma_hang_hoa`),
  CONSTRAINT `fk_ma_phieu_nhap_hang` FOREIGN KEY (`ma_phieu_nhap_hang`) REFERENCES `phieu_nhap_hang` (`phieu_nhap_hang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_phieu_nhap_hang`
--

LOCK TABLES `chi_tiet_phieu_nhap_hang` WRITE;
/*!40000 ALTER TABLE `chi_tiet_phieu_nhap_hang` DISABLE KEYS */;
INSERT INTO `chi_tiet_phieu_nhap_hang` VALUES ('CTPNH001','HH001',8,50000,500000,0,0,'PNH001'),('CTPNH002','HH002',10,50000,500000,0,500000,'PNH002'),('CTPNH003','HH003',10,50000,500000,0,500000,'PNH003'),('CTPNH004','HH004',10,50000,500000,0,500000,'PNH004'),('CTPNH005','HH005',10,50000,500000,0,500000,'PNH005'),('CTPNH006','HH006',10,50000,500000,0,500000,'PNH006'),('CTPNH007','HH007',10,50000,500000,0,500000,'PNH007'),('CTPNH008','HH008',10,50000,500000,0,500000,'PNH008'),('CTPNH009','HH009',10,50000,500000,0,500000,'PNH009'),('CTPNH010','HH010',10,50000,500000,0,500000,'PNH010'),('CTPNH011','HH011',10,50000,500000,0,500000,'PNH059'),('CTPNH012','HH012',10,50000,500000,0,500000,'PNH060'),('CTPNH013','HH013',10,50000,500000,0,500000,'PNH011'),('CTPNH014','HH014',10,50000,500000,0,500000,'PNH012'),('CTPNH015','HH015',10,50000,500000,0,500000,'PNH013'),('CTPNH016','HH016',10,50000,500000,0,500000,'PNH014'),('CTPNH017','HH017',10,50000,500000,0,500000,'PNH015'),('CTPNH018','HH018',10,50000,500000,0,500000,'PNH016'),('CTPNH019','HH019',10,50000,500000,0,500000,'PNH017'),('CTPNH020','HH020',10,50000,500000,0,500000,'PNH018'),('CTPNH021','HH021',10,50000,500000,0,500000,'PNH019'),('CTPNH022','HH022',10,50000,500000,0,500000,'PNH020'),('CTPNH023','HH023',10,50000,500000,0,500000,'PNH057'),('CTPNH024','HH024',10,50000,500000,0,500000,'PNH058'),('CTPNH025','HH025',10,50000,500000,0,500000,'PNH021'),('CTPNH026','HH026',10,50000,500000,0,500000,'PNH022'),('CTPNH027','HH027',10,50000,500000,0,500000,'PNH023'),('CTPNH028','HH028',10,50000,500000,0,500000,'PNH024'),('CTPNH029','HH029',10,50000,500000,0,500000,'PNH025'),('CTPNH030','HH030',10,50000,500000,0,500000,'PNH026'),('CTPNH031','HH031',10,50000,500000,0,500000,'PNH027'),('CTPNH032','HH032',10,50000,500000,0,500000,'PNH028'),('CTPNH033','HH033',10,50000,500000,0,500000,'PNH029'),('CTPNH034','HH034',10,50000,500000,0,500000,'PNH030'),('CTPNH035','HH035',10,50000,500000,0,500000,'PNH055'),('CTPNH036','HH036',10,50000,500000,0,500000,'PNH056'),('CTPNH037','HH037',10,50000,500000,0,500000,'PNH031'),('CTPNH038','HH038',10,50000,500000,0,500000,'PNH032'),('CTPNH039','HH039',10,50000,500000,0,500000,'PNH033'),('CTPNH040','HH040',10,50000,500000,0,500000,'PNH034'),('CTPNH041','HH041',10,50000,500000,0,500000,'PNH035'),('CTPNH042','HH042',10,50000,500000,0,500000,'PNH036'),('CTPNH043','HH043',10,50000,500000,0,500000,'PNH037'),('CTPNH044','HH044',10,50000,500000,0,500000,'PNH038'),('CTPNH045','HH045',10,50000,500000,0,500000,'PNH039'),('CTPNH046','HH046',10,50000,500000,0,500000,'PNH040'),('CTPNH047','HH047',10,50000,500000,0,500000,'PNH053'),('CTPNH048','HH048',10,50000,500000,0,500000,'PNH054'),('CTPNH049','HH049',10,50000,500000,0,500000,'PNH041'),('CTPNH050','HH050',10,50000,500000,0,500000,'PNH042'),('CTPNH051','HH051',10,50000,500000,0,500000,'PNH043'),('CTPNH052','HH052',10,50000,500000,0,500000,'PNH044'),('CTPNH053','HH053',10,50000,500000,0,500000,'PNH045'),('CTPNH054','HH054',10,50000,500000,0,500000,'PNH046'),('CTPNH055','HH055',10,50000,500000,0,500000,'PNH047'),('CTPNH056','HH056',10,50000,500000,0,500000,'PNH048'),('CTPNH057','HH057',10,50000,500000,0,500000,'PNH049'),('CTPNH058','HH058',10,50000,500000,0,500000,'PNH050'),('CTPNH059','HH059',10,50000,500000,0,500000,'PNH051'),('CTPNH060','HH060',10,50000,500000,0,500000,'PNH052'),('CTPNH061','HH015',6,130000,600000,0,0,'PNH001');
/*!40000 ALTER TABLE `chi_tiet_phieu_nhap_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_tiet_phieu_tra_hang`
--

DROP TABLE IF EXISTS `chi_tiet_phieu_tra_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chi_tiet_phieu_tra_hang` (
  `ma_chi_tiet_phieu_tra_hang` varchar(255) NOT NULL,
  `gia_tra_hang` double DEFAULT NULL,
  `so_luong` smallint(6) DEFAULT NULL,
  `thanh_tien` double DEFAULT NULL,
  `ma_hang_hoa` varchar(255) DEFAULT NULL,
  `ma_phieu_tra_hang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_chi_tiet_phieu_tra_hang`),
  KEY `FKtjam5x98uf4ujww6cu2tm5hag` (`ma_hang_hoa`),
  KEY `FK1l19bp3xnbtvteqcrmawfn8wc` (`ma_phieu_tra_hang`),
  CONSTRAINT `FK1l19bp3xnbtvteqcrmawfn8wc` FOREIGN KEY (`ma_phieu_tra_hang`) REFERENCES `phieu_tra_hang` (`ma_phieu_tra_hang`),
  CONSTRAINT `FKtjam5x98uf4ujww6cu2tm5hag` FOREIGN KEY (`ma_hang_hoa`) REFERENCES `hang_hoa` (`ma_hang_hoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_phieu_tra_hang`
--

LOCK TABLES `chi_tiet_phieu_tra_hang` WRITE;
/*!40000 ALTER TABLE `chi_tiet_phieu_tra_hang` DISABLE KEYS */;
INSERT INTO `chi_tiet_phieu_tra_hang` VALUES ('CTPTH001',10000,10,100000,'HH001','PTH001'),('CTPTH002',15000,5,75000,'HH004','PTH001'),('CTPTH003',12000,8,96000,'HH005','PTH002');
/*!40000 ALTER TABLE `chi_tiet_phieu_tra_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hang_hoa`
--

DROP TABLE IF EXISTS `hang_hoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hang_hoa` (
  `ma_hang_hoa` varchar(255) NOT NULL,
  `gia_ban` double DEFAULT NULL,
  `gia_von` double DEFAULT NULL,
  `khach_dat` smallint(6) DEFAULT NULL,
  `ten_hang_hoa` varchar(255) DEFAULT NULL,
  `ton_kho` smallint(6) DEFAULT NULL,
  `ma_nhom_hang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_hang_hoa`),
  KEY `FKlc58gvmkruvayxxeqcv69gj0n` (`ma_nhom_hang`),
  CONSTRAINT `FKlc58gvmkruvayxxeqcv69gj0n` FOREIGN KEY (`ma_nhom_hang`) REFERENCES `nhom_hang` (`ma_nhom_hang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hang_hoa`
--

LOCK TABLES `hang_hoa` WRITE;
/*!40000 ALTER TABLE `hang_hoa` DISABLE KEYS */;
INSERT INTO `hang_hoa` VALUES ('HH001',100000,80000,5,'Nhớt Mobil',20,'NH001'),('HH002',120000,90000,4,'Nhớt Castrol',18,'NH001'),('HH003',110000,85000,6,'Nhớt Total',22,'NH001'),('HH004',130000,95000,3,'Nhớt Motul',16,'NH001'),('HH005',2000000,1500000,2,'Lốp Michelin',10,'NH002'),('HH006',1800000,1400000,3,'Lốp Bridgestone',12,'NH002'),('HH007',1900000,1450000,1,'Lốp Goodyear',8,'NH002'),('HH008',2200000,1650000,2,'Lốp Pirelli',9,'NH002'),('HH009',300000,250000,8,'Bộ lọc gió Bosch',25,'NH003'),('HH010',350000,300000,6,'Bộ lọc nhớt Mann',20,'NH003'),('HH011',280000,220000,10,'Bộ lọc nhiên liệu Fram',30,'NH003'),('HH012',400000,350000,5,'Bộ lọc không khí K&N',18,'NH003'),('HH013',200000,150000,10,'Dầu động cơ Shell',35,'NH003'),('HH014',500000,400000,3,'Bơm nhiên liệu Denso',12,'NH003'),('HH015',100000,80000,15,'Bugi NGK',50,'NH003'),('HH016',120000,90000,12,'Dây curoa Gates',40,'NH003'),('HH017',1500000,1200000,1,'Sơn xanh phấn Yamaha',5,'NH004'),('HH018',1800000,1400000,2,'Sơn đen nhám Toyota',8,'NH004'),('HH019',1700000,1350000,1,'Sơn trắng sữa Honda',6,'NH004'),('HH020',2000000,1600000,1,'Sơn đỏ ferrari',7,'NH004'),('HH021',300000,250000,10,'Dung dịch vệ sinh nội thất Meguiar',30,'NH005'),('HH022',200000,150000,8,'Bột tẩy bẩn Sonax',25,'NH005'),('HH023',350000,300000,6,'Nước tẩy rửa da Chemical Guys',20,'NH005'),('HH024',400000,350000,5,'Dầu dưỡng da Leather Honey',15,'NH005'),('HH025',200000,150000,12,'Bóng đèn halogen Philips',40,'NH006'),('HH026',300000,250000,10,'Bóng đèn LED Osram',35,'NH006'),('HH027',1500000,1200000,4,'Bộ điều khiển động cơ ECU Bosch',15,'NH007'),('HH028',10000,8000,25,'Dây điện dẹt 2.5mm²',100,'NH006'),('HH029',2500000,2000000,2,'Bộ lốp và rotơ trước Brembo',10,'NH008'),('HH030',300000,250000,8,'Dầu thắng Castrol DOT 4',25,'NH007'),('HH031',80000,60000,15,'Dây phanh dầu trước ATE',50,'NH007'),('HH032',120000,100000,12,'Dây phanh sau Brembo',40,'NH007'),('HH033',700000,550000,9,'Dầu hộp số tự động Mobil 1',30,'NH008'),('HH034',600000,500000,8,'Dầu hộp số tự động Toyota ATF WS',25,'NH008'),('HH035',650000,520000,8,'Dầu hộp số tự động Honda ATF DW1',28,'NH008'),('HH036',680000,550000,7,'Dầu hộp số tự động Nissan Matic S',26,'NH008'),('HH037',900000,700000,6,'Bơm dầu lái trợ lực Bosch',20,'NH009'),('HH038',150000,120000,10,'Dây lái điện ô tô',40,'NH009'),('HH039',1800000,1500000,4,'Cụm cầu lái trước Toyota',15,'NH009'),('HH040',80000,60000,8,'Vòi nước lái ô tô',30,'NH010'),('HH041',120000,90000,12,'Nước làm mát Prestone',50,'NH010'),('HH042',500000,400000,6,'Quạt làm mát Denso',20,'NH010'),('HH043',30000,25000,15,'Đèn báo nhiệt độ nước làm mát',60,'NH010'),('HH044',60000,50000,10,'Vòi phun nước làm mát',40,'NH010'),('HH045',800000,650000,7,'Cảm biến O2 Bosch',25,'NH011'),('HH046',1200000,950000,4,'Bộ van EGR Pierburg',15,'NH011'),('HH047',70000,55000,8,'Ống xả ô tô',30,'NH011'),('HH048',300000,250000,10,'Kích hoạt ator bảo vệ động cơ',40,'NH012'),('HH049',600000,450000,6,'Giảm xóc KYB',20,'NH012'),('HH050',400000,300000,8,'Lò xo treo ô tô',25,'NH012'),('HH051',200000,150000,10,'Bạc đạn trục giảm chấn',30,'NH012'),('HH052',100000,80000,12,'Bản lề cửa ô tô',40,'NH012'),('HH053',100000,80000,15,'Nước làm mát Zerex',50,'NH013'),('HH054',150000,120000,10,'Bình chứa nước làm mát',35,'NH013'),('HH055',250000,200000,8,'Bơm nước làm mát Điện lực',25,'NH013'),('HH056',50000,40000,12,'Nắp bình nước làm mát',40,'NH013'),('HH057',500000,400000,6,'Pin ắc quy GS',20,'NH014'),('HH058',600000,450000,4,'Pin ắc quy Panasonic',15,'NH014'),('HH059',30000,25000,8,'Kẹp pin ắc quy',30,'NH014'),('HH060',100000,80000,6,'Dây dẫn nối pin ắc quy',25,'NH014');
/*!40000 ALTER TABLE `hang_hoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hinh_anh`
--

DROP TABLE IF EXISTS `hinh_anh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hinh_anh` (
  `ma_hinh_anh` varchar(255) NOT NULL,
  `noi_dung` varchar(255) DEFAULT NULL,
  `ten_hinh` varchar(255) DEFAULT NULL,
  `ma_hang_hoa` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_hinh_anh`),
  UNIQUE KEY `UK_c4kr0shrn2exoi3sqsc5er54w` (`ma_nhan_vien`),
  KEY `FKt5ywhrhkxo2f4mf7su3j14ydn` (`ma_hang_hoa`),
  CONSTRAINT `FKaxrjqtrnu7nxiij4bq9m5wyxl` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `FKt5ywhrhkxo2f4mf7su3j14ydn` FOREIGN KEY (`ma_hang_hoa`) REFERENCES `hang_hoa` (`ma_hang_hoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hinh_anh`
--

LOCK TABLES `hinh_anh` WRITE;
/*!40000 ALTER TABLE `hinh_anh` DISABLE KEYS */;
INSERT INTO `hinh_anh` VALUES ('HA001','Nhớt mobil','nhot_mobil.jpg','HH001','NV001'),('HA002','Nội dung hình ảnh 2','Hình ảnh 2',NULL,'NV002'),('HA003','Nội dung hình ảnh 3','Hình ảnh 3',NULL,'NV003'),('HA004','Nội dung hình ảnh 4','Hình ảnh 4',NULL,'NV004'),('HA005','Nội dung hình ảnh 5','Hình ảnh 5',NULL,'NV005'),('HA006','Nội dung hình ảnh 6','Hình ảnh 6',NULL,'NV006'),('HA007','Nội dung hình ảnh 7','Hình ảnh 7',NULL,'NV007'),('HA008','Nội dung hình ảnh 8','Hình ảnh 8',NULL,'NV008'),('HA009','Nội dung hình ảnh 9','Hình ảnh 9',NULL,'NV009'),('HA010','Nội dung hình ảnh 10','Hình ảnh 10',NULL,'NV010');
/*!40000 ALTER TABLE `hinh_anh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hoa_don` (
  `ma_hoa_don` varchar(255) NOT NULL,
  `giam_gia` double DEFAULT NULL,
  `loai_thu_chi` varchar(255) DEFAULT NULL,
  `thoi_gian` datetime(6) DEFAULT NULL,
  `tien_da_tra` double DEFAULT NULL,
  `tong_tien` double DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT NULL,
  `ma_khach_hang` varchar(255) DEFAULT NULL,
  `ma_nha_cung_cap` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  `ma_phieu_tra_hang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_hoa_don`),
  KEY `FKnuqkgajew2traqcy7umgm7i1g` (`ma_khach_hang`),
  KEY `FKpu3pgvm4uiwlce2obab169949` (`ma_nha_cung_cap`),
  KEY `FKsh87ilak874fkwk9pw28pafx7` (`ma_nhan_vien`),
  KEY `fk_ma_phieu_tra_hang_hoa_don` (`ma_phieu_tra_hang`),
  CONSTRAINT `FKnuqkgajew2traqcy7umgm7i1g` FOREIGN KEY (`ma_khach_hang`) REFERENCES `khach_hang` (`ma_khach_hang`),
  CONSTRAINT `FKpu3pgvm4uiwlce2obab169949` FOREIGN KEY (`ma_nha_cung_cap`) REFERENCES `nha_cung_cap` (`ma_nha_cung_cap`),
  CONSTRAINT `FKsh87ilak874fkwk9pw28pafx7` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `fk_ma_phieu_tra_hang_hoa_don` FOREIGN KEY (`ma_phieu_tra_hang`) REFERENCES `phieu_tra_hang` (`ma_phieu_tra_hang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
INSERT INTO `hoa_don` VALUES ('HD001',0,'Thu','2023-01-01 10:00:00.000000',1500000,1500000,'Hoàn thành','KH001',NULL,'NV004',NULL),('HD002',0,'Chi','2023-01-02 11:30:00.000000',0,800000,'Hoàn thành',NULL,'NCC004','NV004',NULL),('HD003',200000,'Thu','2023-01-03 14:45:00.000000',1800000,2000000,'Chưa thanh toán','KH002',NULL,'NV004',NULL),('HD004',0,'Thu','2023-01-04 09:15:00.000000',500000,500000,'Hoàn thành','KH003',NULL,'NV005',NULL),('HD005',300000,'Chi','2023-01-05 13:20:00.000000',2700000,3000000,'Chưa thanh toán',NULL,'NCC002','NV005',NULL),('HD006',0,'Chi','2023-01-06 08:30:00.000000',0,1000000,'Hoàn thành',NULL,'NCC001','NV005',NULL),('HD007',0,'Thu','2023-01-07 10:45:00.000000',1200000,1200000,'Hoàn thành','KH004',NULL,'NV004',NULL),('HD008',150000,'Thu','2023-01-08 12:00:00.000000',1650000,1800000,'Chưa thanh toán','KH005',NULL,'NV004',NULL),('HD009',0,'Chi','2023-01-09 15:10:00.000000',0,600000,'Hoàn thành',NULL,'NCC005','NV005',NULL),('HD010',0,'Chi','2023-01-10 09:30:00.000000',0,900000,'Hoàn thành',NULL,'NCC001','NV005',NULL),('HD011',200000,'Thu','2023-01-11 14:00:00.000000',2300000,2500000,'Chưa thanh toán','KH006',NULL,'NV004',NULL),('HD012',0,'Thu','2023-01-12 11:20:00.000000',700000,700000,'Hoàn thành','KH007',NULL,'NV004',NULL),('HD013',300000,'Chi','2023-01-13 10:05:00.000000',3200000,3500000,'Chưa thanh toán',NULL,'NCC004','NV005',NULL),('HD014',0,'Thu','2023-01-14 08:40:00.000000',800000,800000,'Hoàn thành','KH008',NULL,'NV004',NULL),('HD015',0,'Chi','2023-01-15 12:50:00.000000',0,2000000,'Hoàn thành',NULL,'NCC003','NV005',NULL),('HD016',100000,'Chi','2023-01-16 09:55:00.000000',1000000,1100000,'Chưa thanh toán',NULL,'NCC001','NV004',NULL),('HD017',0,'Thu','2023-01-17 14:25:00.000000',900000,900000,'Hoàn thành','KH009',NULL,'NV005',NULL),('HD018',250000,'Thu','2023-01-18 10:35:00.000000',2750000,3000000,'Chưa thanh toán','KH010',NULL,'NV005',NULL),('HD019',0,'Chi','2023-01-19 11:15:00.000000',0,400000,'Hoàn thành',NULL,'NCC002','NV004',NULL),('HD020',100000,'Thu','2023-01-20 13:40:00.000000',1400000,1500000,'Chưa thanh toán','KH011',NULL,'NV004',NULL);
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don_chi_tiet`
--

DROP TABLE IF EXISTS `hoa_don_chi_tiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hoa_don_chi_tiet` (
  `ma_hoa_don_chi_tiet` varchar(255) NOT NULL,
  `gia_ban` double DEFAULT NULL,
  `giam_gia` double DEFAULT NULL,
  `so_luong` smallint(6) DEFAULT NULL,
  `thanh_tien` double DEFAULT NULL,
  `ma_hang_hoa` varchar(255) DEFAULT NULL,
  `ma_hoa_don` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_hoa_don_chi_tiet`),
  KEY `FK3ywptxwm8rk6nl3pm23yf2kqb` (`ma_hang_hoa`),
  KEY `FK4bcsxsdj3n0mjr459010ykk8m` (`ma_hoa_don`),
  CONSTRAINT `FK3ywptxwm8rk6nl3pm23yf2kqb` FOREIGN KEY (`ma_hang_hoa`) REFERENCES `hang_hoa` (`ma_hang_hoa`),
  CONSTRAINT `FK4bcsxsdj3n0mjr459010ykk8m` FOREIGN KEY (`ma_hoa_don`) REFERENCES `hoa_don` (`ma_hoa_don`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don_chi_tiet`
--

LOCK TABLES `hoa_don_chi_tiet` WRITE;
/*!40000 ALTER TABLE `hoa_don_chi_tiet` DISABLE KEYS */;
INSERT INTO `hoa_don_chi_tiet` VALUES ('HD001_CT001',500000,0,1,500000,'HH001','HD001'),('HD001_CT002',1000000,0,1,1000000,'HH004','HD001'),('HD001_CT003',2000000,0,1,2000000,'HH010','HD001'),('HD002_CT001',1000000,0,1,1000000,'HH002','HD002'),('HD002_CT002',2000000,0,1,2000000,'HH003','HD002'),('HD002_CT003',3000000,0,1,3000000,'HH005','HD002'),('HD003_CT001',500000,0,1,500000,'HH012','HD003'),('HD003_CT002',1000000,0,1,1000000,'HH019','HD003'),('HD003_CT003',2000000,0,1,2000000,'HH003','HD003'),('HD004_CT001',500000,0,1,500000,'HH011','HD004'),('HD004_CT002',1000000,0,1,1000000,'HH012','HD004'),('HD004_CT003',2000000,0,1,2000000,'HH014','HD004'),('HD005_CT001',500000,0,1,500000,'HH016','HD005'),('HD005_CT002',1000000,0,1,1000000,'HH012','HD005'),('HD005_CT003',2000000,0,1,2000000,'HH010','HD005'),('HD006_CT001',500000,0,1,500000,'HH001','HD006'),('HD006_CT002',1000000,0,1,1000000,'HH008','HD006'),('HD006_CT003',2000000,0,1,2000000,'HH019','HD006'),('HD007_CT001',500000,0,1,500000,'HH044','HD007'),('HD007_CT002',1000000,0,1,1000000,'HH033','HD007'),('HD007_CT003',2000000,0,1,2000000,'HH029','HD007'),('HD008_CT001',500000,0,1,500000,'HH012','HD008'),('HD008_CT002',1000000,0,1,1000000,'HH028','HD008'),('HD008_CT003',2000000,0,1,2000000,'HH020','HD008'),('HD009_CT001',500000,0,1,500000,'HH036','HD009'),('HD009_CT002',1000000,0,1,1000000,'HH045','HD009'),('HD009_CT003',2000000,0,1,2000000,'HH047','HD009'),('HD010_CT001',500000,0,1,500000,'HH012','HD010'),('HD010_CT002',1000000,0,1,1000000,'HH006','HD010'),('HD010_CT003',2000000,0,1,2000000,'HH049','HD010'),('HD011_CT001',500000,0,1,500000,'HH051','HD011'),('HD011_CT002',1000000,0,1,1000000,'HH053','HD011'),('HD011_CT003',2000000,0,1,2000000,'HH056','HD011'),('HD012_CT001',500000,0,1,500000,'HH060','HD012'),('HD012_CT002',1000000,0,1,1000000,'HH057','HD012'),('HD012_CT003',2000000,0,1,2000000,'HH042','HD012'),('HD013_CT001',500000,0,1,500000,'HH034','HD013'),('HD013_CT002',1000000,0,1,1000000,'HH033','HD013'),('HD013_CT003',2000000,0,1,2000000,'HH012','HD013'),('HD014_CT001',500000,0,1,500000,'HH007','HD014'),('HD014_CT002',1000000,0,1,1000000,'HH008','HD014'),('HD014_CT003',2000000,0,1,2000000,'HH032','HD014'),('HD015_CT001',500000,0,1,500000,'HH042','HD015'),('HD015_CT002',1000000,0,1,1000000,'HH049','HD015'),('HD015_CT003',2000000,0,1,2000000,'HH048','HD015'),('HD016_CT001',500000,0,1,500000,'HH024','HD016'),('HD016_CT002',1000000,0,1,1000000,'HH014','HD016'),('HD016_CT003',2000000,0,1,2000000,'HH023','HD016'),('HD017_CT001',500000,0,1,500000,'HH045','HD017'),('HD017_CT002',1000000,0,1,1000000,'HH021','HD017'),('HD017_CT003',2000000,0,1,2000000,'HH054','HD017'),('HD018_CT001',500000,0,1,500000,'HH036','HD018'),('HD018_CT002',1000000,0,1,1000000,'HH047','HD018'),('HD018_CT003',2000000,0,1,2000000,'HH020','HD018'),('HD019_CT001',500000,0,1,500000,'HH012','HD019'),('HD019_CT002',1000000,0,1,1000000,'HH048','HD019'),('HD019_CT003',2000000,0,1,2000000,'HH034','HD019'),('HD020_CT001',500000,0,1,500000,'HH048','HD020'),('HD020_CT002',1000000,0,1,1000000,'HH046','HD020'),('HD020_CT003',2000000,0,1,2000000,'HH026','HD020');
/*!40000 ALTER TABLE `hoa_don_chi_tiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `khach_hang` (
  `ma_khach_hang` varchar(255) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ma_so_thue` varchar(255) DEFAULT NULL,
  `ngay_sinh` datetime(6) DEFAULT NULL,
  `ngay_tao` datetime(6) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_khach_hang` varchar(255) DEFAULT NULL,
  `tong_ban` double DEFAULT NULL,
  `tong_no` double DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_khach_hang`),
  KEY `FKip8bppn8gjt3u3lescd3k2pi4` (`ma_nhan_vien`),
  CONSTRAINT `FKip8bppn8gjt3u3lescd3k2pi4` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES ('KH001','123 Đường ABC, Quận 1, TP.HCM','nguyenvana@example.com','123456789','1990-01-01 00:00:00.000000','2023-01-01 10:00:00.000000','0987654321','Nguyễn Văn An',1500000,0,'NV004'),('KH002','456 Đường XYZ, Quận 2, TP.HCM','tranthib@example.com','987654321','1985-05-15 00:00:00.000000','2023-01-02 11:30:00.000000','0123456789','Trần Thị Bình',800000,0,'NV004'),('KH003','789 Đường MNO, Quận 3, TP.HCM','levanc@example.com','135792468','1992-03-20 00:00:00.000000','2023-01-03 14:45:00.000000','0987123456','Lê Văn Chiến',2000000,200000,'NV004'),('KH004','0123 Đường DEF, Quận 4, TP.HCM','phamthid@example.com','246813579','1988-12-10 00:00:00.000000','2023-01-04 09:15:00.000000','0967123456','Phạm Thị Dương',500000,0,'NV005'),('KH005','456 Đường GHI, Quận 5, TP.HCM','hoangvane@example.com','369258147','1995-08-25 00:00:00.000000','2023-01-05 13:20:00.000000','0987654321','Hoàng Văn Én',3000000,300000,'NV005'),('KH006','789 Đường KLM, Quận 6, TP.HCM','tranvanf@example.com','975310486','1991-07-05 00:00:00.000000','2023-01-06 08:30:00.000000','0987123456','Trần Văn Phú',1000000,0,'NV004'),('KH007','123 Đường NOP, Quận 7, TP.HCM','nguyenthig@example.com','864203951','1987-09-15 00:00:00.000000','2023-01-07 10:45:00.000000','0967123456','Nguyễn Thị Giang',1200000,0,'NV004'),('KH008','456 Đường QRS, Quận 8, TP.HCM','phanvanh@example.com','753196482','1994-04-30 00:00:00.000000','2023-01-08 12:00:00.000000','0987654321','Phan Văn Hòa',1800000,150000,'NV005'),('KH009','789 Đường TUV, Quận 9, TP.HCM','lythi@example.com','642087513','1989-11-20 00:00:00.000000','2023-01-09 15:10:00.000000','0123456789','Lý Thị Yến',600000,0,'NV005'),('KH010','0123 Đường WXY, Quận 10, TP.HCM','dangvank@example.com','531974820','1996-06-10 00:00:00.000000','2023-01-10 09:30:00.000000','0987123456','Đặng Văn Kiên',900000,0,'NV004'),('KH011','456 Đường ZAB, Quận 11, TP.HCM','buithil@example.com','420865139','1993-02-05 00:00:00.000000','2023-01-11 14:00:00.000000','0967123456','Bùi Thị Lý',2500000,200000,'NV004'),('KH012','123 Đường BCD, Quận 12, TP.HCM','nguyenvanm@example.com','309751824','1990-10-15 00:00:00.000000','2023-01-12 11:20:00.000000','0987654321','Nguyễn Văn Minh',700000,0,'NV005'),('KH013','456 Đường EFG, Quận Bình Tân, TP.HCM','tranthin@example.com','198642037','1986-08-20 00:00:00.000000','2023-01-13 10:05:00.000000','0123456789','Trần Thị Như',3500000,300000,'NV004'),('KH014','789 Đường HIJ, Quận Bình Chánh, TP.HCM','levano@example.com','087529314','1991-06-01 00:00:00.000000','2023-01-14 08:40:00.000000','0987123456','Lê Văn Ôn',800000,0,'NV005'),('KH015','0123 Đường KLM, Quận Thủ Đức, TP.HCM','phamthip@example.com','976420831','1988-04-05 00:00:00.000000','2023-01-15 12:50:00.000000','0967123456','Phạm Thị Phương',2000000,0,'NV005'),('KH016','456 Đường NOP, Quận Gò Vấp, TP.HCM','hoangvanq@example.com','865309472','1995-02-25 00:00:00.000000','2023-01-16 09:55:00.000000','0987654321','Hoàng Văn Qúy',1100000,100000,'NV004'),('KH017','789 Đường QRS, Quận Phú Nhuận, TP.HCM','tranthir@example.com','753186204','1987-12-10 00:00:00.000000','2023-01-17 14:25:00.000000','0123456789','Trần Thị Riềng',900000,0,'NV004'),('KH018','123 Đường TUV, Quận Tân Bình, TP.HCM','nguyenvans@example.com','642097531','1994-10-05 00:00:00.000000','2023-01-18 10:35:00.000000','0967123456','Nguyễn Văn Sang',3000000,250000,'NV005'),('KH019','456 Đường WXY, Quận Tân Phú, TP.HCM','phanthit@example.com','531874260','1989-08-15 00:00:00.000000','2023-01-19 11:15:00.000000','0987654321','Phan Thị Thư',400000,0,'NV005'),('KH020','789 Đường ZAB, Quận Bình Thạnh, TP.HCM','lyvanu@example.com','420963187','1996-05-30 00:00:00.000000','2023-01-20 13:40:00.000000','0123456789','Lý Văn Uyên',1500000,100000,'NV004');
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lich_lam_viec`
--

DROP TABLE IF EXISTS `lich_lam_viec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lich_lam_viec` (
  `ma_lich_lam_viec` varchar(255) NOT NULL,
  `ghi_chu` varchar(255) DEFAULT NULL,
  `lap_lai` bit(1) DEFAULT NULL,
  `ngay_bat_dau` datetime(6) DEFAULT NULL,
  `ngay_ket_thuc` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ma_lich_lam_viec`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lich_lam_viec`
--

LOCK TABLES `lich_lam_viec` WRITE;
/*!40000 ALTER TABLE `lich_lam_viec` DISABLE KEYS */;
INSERT INTO `lich_lam_viec` VALUES ('LLV001','Ca làm việc thường ngày',_binary '\0','2023-01-01 08:00:00.000000','2023-01-01 17:00:00.000000'),('LLV002','Ca làm việc thường ngày',_binary '\0','2023-01-02 09:00:00.000000','2023-01-02 18:00:00.000000'),('LLV003','Ca làm việc thường ngày',_binary '\0','2023-01-03 07:30:00.000000','2023-01-03 16:30:00.000000'),('LLV004','Ca làm việc thường ngày',_binary '\0','2023-01-04 08:30:00.000000','2023-01-04 17:30:00.000000'),('LLV005','Ca làm việc thường ngày',_binary '\0','2023-01-05 08:00:00.000000','2023-01-05 17:00:00.000000'),('LLV006','Ca làm việc thường ngày',_binary '\0','2023-01-06 09:00:00.000000','2023-01-06 18:00:00.000000'),('LLV007','Ca làm việc thường ngày',_binary '\0','2023-01-07 07:30:00.000000','2023-01-07 16:30:00.000000'),('LLV008','Ca làm việc thường ngày',_binary '\0','2023-01-08 08:30:00.000000','2023-01-08 17:30:00.000000'),('LLV009','Ca làm việc thường ngày',_binary '\0','2023-01-09 08:00:00.000000','2023-01-09 17:00:00.000000'),('LLV010','Ca làm việc thường ngày',_binary '\0','2023-01-10 09:00:00.000000','2023-01-10 18:00:00.000000');
/*!40000 ALTER TABLE `lich_lam_viec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lich_lam_viec_ca_lam`
--

DROP TABLE IF EXISTS `lich_lam_viec_ca_lam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lich_lam_viec_ca_lam` (
  `ma_lich_lam_viec` varchar(255) NOT NULL,
  `ma_ca_lam` varchar(255) NOT NULL,
  PRIMARY KEY (`ma_lich_lam_viec`,`ma_ca_lam`),
  KEY `FKn0hwxvo702xah44p9wb3fx4ub` (`ma_ca_lam`),
  CONSTRAINT `FK7g7qi4fgb4ma6nuy5djaoxbls` FOREIGN KEY (`ma_lich_lam_viec`) REFERENCES `lich_lam_viec` (`ma_lich_lam_viec`),
  CONSTRAINT `FKn0hwxvo702xah44p9wb3fx4ub` FOREIGN KEY (`ma_ca_lam`) REFERENCES `ca_lam` (`ma_ca_lam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lich_lam_viec_ca_lam`
--

LOCK TABLES `lich_lam_viec_ca_lam` WRITE;
/*!40000 ALTER TABLE `lich_lam_viec_ca_lam` DISABLE KEYS */;
INSERT INTO `lich_lam_viec_ca_lam` VALUES ('LLV001','CAL001'),('LLV002','CAL001'),('LLV003','CAL001'),('LLV004','CAL001'),('LLV005','CAL001'),('LLV006','CAL001'),('LLV007','CAL001'),('LLV008','CAL001'),('LLV001','CAL002'),('LLV002','CAL002'),('LLV003','CAL002'),('LLV004','CAL002'),('LLV005','CAL002'),('LLV006','CAL002'),('LLV007','CAL002'),('LLV008','CAL002'),('LLV009','CAL003'),('LLV010','CAL003');
/*!40000 ALTER TABLE `lich_lam_viec_ca_lam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_xe`
--

DROP TABLE IF EXISTS `loai_xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `loai_xe` (
  `ma_loai_xe` varchar(255) NOT NULL,
  `ten_loai_xe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_loai_xe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_xe`
--

LOCK TABLES `loai_xe` WRITE;
/*!40000 ALTER TABLE `loai_xe` DISABLE KEYS */;
INSERT INTO `loai_xe` VALUES ('LX001','Toyota'),('LX002','Honda'),('LX003','Ford'),('LX004','Chevrolet'),('LX005','BMW'),('LX006','Mercedes-Benz'),('LX007','Audi');
/*!40000 ALTER TABLE `loai_xe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nha_cung_cap`
--

DROP TABLE IF EXISTS `nha_cung_cap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nha_cung_cap` (
  `ma_nha_cung_cap` varchar(255) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ma_so_thue` varchar(255) DEFAULT NULL,
  `ngay_tao` datetime(6) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_nha_cung_cap` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  `no_can_tra` double DEFAULT NULL,
  `tong_mua` double DEFAULT NULL,
  PRIMARY KEY (`ma_nha_cung_cap`),
  KEY `FKf5u7s4s6dmvwrjkxqcx3d3xoa` (`ma_nhan_vien`),
  CONSTRAINT `FKf5u7s4s6dmvwrjkxqcx3d3xoa` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nha_cung_cap`
--

LOCK TABLES `nha_cung_cap` WRITE;
/*!40000 ALTER TABLE `nha_cung_cap` DISABLE KEYS */;
INSERT INTO `nha_cung_cap` VALUES ('NCC001','123 Đường ABC, Quận XYZ, Thành phố HCM','abc@company.com','ABC123456','2023-01-01 08:00:00.000000','0123456789','Công ty TNHH ABC','NV004',0,20000000),('NCC002','456 Đường XYZ, Quận ABC, Thành phố Hà Nội','xyz@company.com','XYZ987654','2023-01-02 09:00:00.000000','0987654321','Công ty XYZ Ltd','NV004',200000,52000000),('NCC003','789 Đường MNO, Quận DEF, Thành phố Đà Nẵng','mno@company.com','MNO456789','2023-01-03 10:00:00.000000','0369852147','Công ty MNO','NV005',150000,30000000),('NCC004','101 Đường PQR, Quận GHI, Thành phố Cần Thơ','pqr@company.com','PQR987654','2023-01-04 11:00:00.000000','0246857319','Công ty PQR','NV005',0,15000000),('NCC005','111 Đường STU, Quận KLM, Thành phố Hải Phòng','stu@company.com','STU123456','2023-01-05 12:00:00.000000','0379514682','Công ty STU','NV005',0,60000000);
/*!40000 ALTER TABLE `nha_cung_cap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nhan_vien` (
  `ma_nhan_vien` varchar(255) NOT NULL,
  `cccd` varchar(255) DEFAULT NULL,
  `chuc_danh` varchar(255) DEFAULT NULL,
  `gioi_tinh` varchar(255) DEFAULT NULL,
  `ngay_bat_dau_lam_viec` datetime(6) DEFAULT NULL,
  `ngay_sinh` datetime(6) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_nhan_vien` varchar(255) DEFAULT NULL,
  `ma_chi_nhanh` varchar(255) DEFAULT NULL,
  `tao_boi_ma_nhan_vien` varchar(255) DEFAULT NULL,
  `ma_lich_lam_viec` varchar(255) DEFAULT NULL,
  `no_luong` double DEFAULT NULL,
  PRIMARY KEY (`ma_nhan_vien`),
  UNIQUE KEY `UK_ie7b5kt6wc752x7tvm3sj1ja2` (`ma_lich_lam_viec`),
  KEY `FKb11u6kme9duvp5351r3b1d809` (`ma_chi_nhanh`),
  KEY `FK890nxbbbytqoal27svt7biq4b` (`tao_boi_ma_nhan_vien`),
  CONSTRAINT `FK890nxbbbytqoal27svt7biq4b` FOREIGN KEY (`tao_boi_ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `FKb11u6kme9duvp5351r3b1d809` FOREIGN KEY (`ma_chi_nhanh`) REFERENCES `chi_nhanh` (`ma_chi_nhanh`),
  CONSTRAINT `FKrh75p9tnv7nhdyb6hp7y1u07g` FOREIGN KEY (`ma_lich_lam_viec`) REFERENCES `lich_lam_viec` (`ma_lich_lam_viec`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES ('NV000','068202006801','admin','Nam','2020-01-01 08:00:00.000000','2002-11-02 00:00:00.000000','0869990187','Võ Văn Đức',NULL,NULL,NULL,NULL),('NV001','123456789','Nhân viên sữa chữa','Nam','2020-01-01 08:00:00.000000','1990-01-01 00:00:00.000000','0123456789','Nguyễn Văn Anh','CN001','NV004','LLV001',0),('NV002','234567890','Nhân viên kỹ thuật','Nam','2019-12-15 09:00:00.000000','1992-02-02 00:00:00.000000','0987654321','Trần Luyện','CN001','NV004','LLV002',0),('NV003','345678901','Bảo vệ','Nam','2021-03-10 10:00:00.000000','1995-03-03 00:00:00.000000','0369852147','Phạm Văn Chiêu','CN001','NV004','LLV003',0),('NV004','456789012','Kế toán viên','Nữ','2020-06-20 11:00:00.000000','1988-04-04 00:00:00.000000','0246857319','Hoàng Thị Diệu','CN001','NV000','LLV004',0),('NV005','567890123','Kế toán viên','Nữ','2018-09-05 12:00:00.000000','1993-05-05 00:00:00.000000','0379514682','Tuyết Tuyết Nhi','CN001','NV000','LLV005',0),('NV006','678901234','Nhân viên sữa chữa','Nam','2019-11-30 08:30:00.000000','1997-06-06 00:00:00.000000','0987654321','Lê Điển Tịch','CN001','NV005','LLV006',0),('NV007','789012345','Nhân viên sữa chữa','Nam','2021-01-15 10:45:00.000000','1991-07-07 00:00:00.000000','0369852147','Nguyễn Văn Giang','CN001','NV004','LLV007',1000000),('NV008','890123456','Nhân viên sữa chữa','Nam','2019-07-05 11:15:00.000000','1994-08-08 00:00:00.000000','0246857319','Trần Trúc Huyên','CN001','NV004','LLV008',2000000),('NV009','901234567','Nhân viên sữa chữa','Nam','2022-04-18 13:20:00.000000','1989-09-09 00:00:00.000000','0379514682','Phạm Văn Linh','CN001','NV005','LLV009',0),('NV010','012345678','Nhân viên sữa chữa','Nam','2018-11-25 14:30:00.000000','1996-10-10 00:00:00.000000','0987654321','Võ Tòng','CN001','NV005','LLV010',0);
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhom_hang`
--

DROP TABLE IF EXISTS `nhom_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nhom_hang` (
  `ma_nhom_hang` varchar(255) NOT NULL,
  `ten_nhom_hang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_nhom_hang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhom_hang`
--

LOCK TABLES `nhom_hang` WRITE;
/*!40000 ALTER TABLE `nhom_hang` DISABLE KEYS */;
INSERT INTO `nhom_hang` VALUES ('NH001','Dịch vụ thay nhớt'),('NH002','Dịch vụ thay lốp'),('NH003','Dịch vụ kiểm tra và sửa chữa động cơ'),('NH004','Dịch vụ sơn xe'),('NH005','Dịch vụ vệ sinh nội thất'),('NH006','Dịch vụ kiểm tra và sửa chữa hệ thống điện'),('NH007','Dịch vụ kiểm tra và sửa chữa hệ thống phanh'),('NH008','Dịch vụ thay dầu hộp số tự động'),('NH009','Dịch vụ kiểm tra và sửa chữa hệ thống lái'),('NH010','Dịch vụ kiểm tra và sửa chữa hệ thống làm mát'),('NH011','Dịch vụ kiểm tra và sửa chữa hệ thống khí thải'),('NH012','Dịch vụ kiểm tra và sửa chữa hệ thống treo'),('NH013','Dịch vụ thay nước làm mát'),('NH014','Dịch vụ thay pin ắc quy'),('NH015','Dịch vụ kiểm tra và sửa chữa hệ thống điều hòa'),('NH016','Dịch vụ kiểm tra và sửa chữa hệ thống cảm biến'),('NH017','Dịch vụ kiểm tra và sửa chữa hệ thống đèn'),('NH018','Dịch vụ kiểm tra và sửa chữa hệ thống kính'),('NH019','Dịch vụ kiểm tra và sửa chữa hệ thống truyền động'),('NH020','Dịch vụ thay dầu hộp số thủ công'),('NH021','Dịch vụ thay bộ lọc nhớt'),('NH022','Dịch vụ thay bình nước làm mát'),('NH023','Dịch vụ thay bình ắc quy'),('NH024','Dịch vụ thay bơm xăng'),('NH025','Dịch vụ thay bơm phanh'),('NH026','Dịch vụ thay bình phân phối'),('NH027','Dịch vụ thay đèn pha'),('NH028','Dịch vụ thay gương chiếu hậu'),('NH029','Dịch vụ thay cầu chì đèn hậu'),('NH030','Dịch vụ thay bánh xe'),('NH031','Dịch vụ xạc bình ắc quy');
/*!40000 ALTER TABLE `nhom_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_luong`
--

DROP TABLE IF EXISTS `phieu_luong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `phieu_luong` (
  `ma_phieu` varchar(255) NOT NULL,
  `da_tra` double DEFAULT NULL,
  `giam_luong` double DEFAULT NULL,
  `ky_viec_lam` varchar(255) DEFAULT NULL,
  `luong_cung` double DEFAULT NULL,
  `luong_thuong` double DEFAULT NULL,
  `tong_luong` double DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_phieu`),
  KEY `FKkyki8e54dldtd24dvumhr67yc` (`ma_nhan_vien`),
  CONSTRAINT `FKkyki8e54dldtd24dvumhr67yc` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_luong`
--

LOCK TABLES `phieu_luong` WRITE;
/*!40000 ALTER TABLE `phieu_luong` DISABLE KEYS */;
INSERT INTO `phieu_luong` VALUES ('PL001',5000000,0,'Tháng 01/2024',5000000,2000000,7000000,'Đã thanh toán','NV001'),('PL002',5000000,0,'Tháng 02/2024',5000000,2500000,7500000,'Đã thanh toán','NV001'),('PL003',5000000,0,'Tháng 03/2024',5000000,3000000,8000000,'Chưa thanh toán','NV002'),('PL004',5000000,0,'Tháng 04/2024',5000000,2000000,7000000,'Chưa thanh toán','NV002'),('PL005',5000000,0,'Tháng 05/2024',5000000,3500000,8500000,'Chưa thanh toán','NV003'),('PL006',5000000,0,'Tháng 06/2024',5000000,2500000,7500000,'Chưa thanh toán','NV003'),('PL007',5000000,0,'Tháng 07/2024',5000000,3000000,8000000,'Chưa thanh toán','NV004'),('PL008',5000000,0,'Tháng 08/2024',5000000,2000000,7000000,'Chưa thanh toán','NV004'),('PL009',5000000,0,'Tháng 09/2024',5000000,3500000,8500000,'Chưa thanh toán','NV005'),('PL010',5000000,0,'Tháng 10/2024',5000000,2500000,7500000,'Chưa thanh toán','NV005'),('PL011',5000000,0,'Tháng 11/2024',5000000,3000000,8000000,'Chưa thanh toán','NV006'),('PL012',5000000,0,'Tháng 12/2024',5000000,2000000,7000000,'Chưa thanh toán','NV006'),('PL013',5000000,0,'Tháng 01/2025',5000000,3500000,8500000,'Chưa thanh toán','NV007'),('PL014',5000000,0,'Tháng 02/2025',5000000,2500000,7500000,'Chưa thanh toán','NV007'),('PL015',5000000,0,'Tháng 03/2025',5000000,3000000,8000000,'Chưa thanh toán','NV008'),('PL016',5000000,0,'Tháng 04/2025',5000000,2000000,7000000,'Chưa thanh toán','NV008'),('PL017',5000000,0,'Tháng 05/2025',5000000,3500000,8500000,'Chưa thanh toán','NV009'),('PL018',5000000,0,'Tháng 06/2025',5000000,2500000,7500000,'Chưa thanh toán','NV009'),('PL019',5000000,0,'Tháng 07/2025',5000000,3000000,8000000,'Chưa thanh toán','NV010'),('PL020',5000000,0,'Tháng 08/2025',5000000,2000000,7000000,'Chưa thanh toán','NV010');
/*!40000 ALTER TABLE `phieu_luong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_nhap_hang`
--

DROP TABLE IF EXISTS `phieu_nhap_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `phieu_nhap_hang` (
  `phieu_nhap_hang` varchar(255) NOT NULL,
  `no` double DEFAULT NULL,
  `thoi_gian` datetime(6) DEFAULT NULL,
  `tong` double DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT NULL,
  `ma_nha_cung_cap` varchar(255) DEFAULT NULL,
  `ma_chi_nhanh` varchar(50) DEFAULT NULL,
  `ma_nhan_vien` varchar(50) DEFAULT NULL,
  `tien_da_tra` double DEFAULT NULL,
  PRIMARY KEY (`phieu_nhap_hang`),
  KEY `FK4t3f4mnp77xa20a7kfjtpyoep` (`ma_nha_cung_cap`),
  KEY `fk_ma_chi_nhanh` (`ma_chi_nhanh`),
  KEY `fk_ma_nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `FK4t3f4mnp77xa20a7kfjtpyoep` FOREIGN KEY (`ma_nha_cung_cap`) REFERENCES `nha_cung_cap` (`ma_nha_cung_cap`),
  CONSTRAINT `fk_ma_chi_nhanh` FOREIGN KEY (`ma_chi_nhanh`) REFERENCES `chi_nhanh` (`ma_chi_nhanh`),
  CONSTRAINT `fk_ma_nhan_vien` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_nhap_hang`
--

LOCK TABLES `phieu_nhap_hang` WRITE;
/*!40000 ALTER TABLE `phieu_nhap_hang` DISABLE KEYS */;
INSERT INTO `phieu_nhap_hang` VALUES ('PNH001',0,'2024-01-01 08:00:00.000000',5000000,'Đã nhập hàng','NCC001','CN001','NV004',0),('PNH002',0,'2024-01-02 10:30:00.000000',7000000,'Chưa nhập hàng','NCC001','CN001','NV004',0),('PNH003',0,'2024-01-03 09:15:00.000000',5500000,'Chưa nhập hàng','NCC001','CN001','NV004',0),('PNH004',0,'2024-01-04 11:20:00.000000',6000000,'Đã nhập hàng','NCC001','CN001','NV004',0),('PNH005',0,'2024-01-05 08:45:00.000000',8000000,'Đã nhập hàng','NCC001','CN001','NV004',0),('PNH006',0,'2024-01-06 10:00:00.000000',7500000,'Đã nhập hàng','NCC001','CN001','NV004',0),('PNH007',0,'2024-01-07 09:30:00.000000',5300000,'Chưa nhập hàng','NCC001','CN001','NV004',0),('PNH008',0,'2024-01-08 10:45:00.000000',6800000,'Chưa nhập hàng','NCC001','CN001','NV004',0),('PNH009',0,'2024-01-09 08:20:00.000000',6200000,'Đã nhập hàng','NCC001','CN001','NV004',0),('PNH010',0,'2024-01-10 11:10:00.000000',5800000,'Đã thanh toán','NCC001','CN001','NV004',0),('PNH011',0,'2024-01-11 09:50:00.000000',7300000,'Đã thanh toán','NCC002','CN001','NV004',0),('PNH012',0,'2024-01-12 10:15:00.000000',5400000,'Đã nhập hàng','NCC002','CN001','NV004',0),('PNH013',0,'2024-01-13 08:30:00.000000',6700000,'Đã thanh toán','NCC002','CN001','NV004',0),('PNH014',0,'2024-01-14 11:25:00.000000',5900000,'Đã nhập hàng','NCC002','CN001','NV004',0),('PNH015',0,'2024-01-15 09:40:00.000000',7200000,'Chưa nhập hàng','NCC002','CN001','NV004',0),('PNH016',0,'2024-01-16 10:05:00.000000',5600000,'Đã nhập hàng','NCC002','CN001','NV004',0),('PNH017',0,'2024-01-17 08:15:00.000000',6900000,'Đã nhập hàng','NCC002','CN001','NV004',0),('PNH018',0,'2024-01-18 11:30:00.000000',5700000,'Đã nhập hàng','NCC002','CN001','NV004',0),('PNH019',0,'2024-01-19 09:35:00.000000',7400000,'Đã nhập hàng','NCC002','CN001','NV004',0),('PNH020',0,'2024-01-20 10:20:00.000000',5500000,'Đã thanh toán','NCC002','CN001','NV004',0),('PNH021',0,'2024-01-21 08:40:00.000000',7100000,'Đã nhập hàng','NCC003','CN001','NV004',0),('PNH022',0,'2024-01-22 11:15:00.000000',5600000,'Đã nhập hàng','NCC003','CN001','NV004',0),('PNH023',0,'2024-01-23 09:25:00.000000',6900000,'Chưa nhập hàng','NCC003','CN001','NV004',0),('PNH024',0,'2024-01-24 10:50:00.000000',5300000,'Đã thanh toán','NCC003','CN001','NV004',0),('PNH025',0,'2024-01-25 08:10:00.000000',7200000,'Đã thanh toán','NCC003','CN001','NV004',0),('PNH026',0,'2024-01-26 11:00:00.000000',5800000,'Chưa nhập hàng','NCC003','CN001','NV004',0),('PNH027',0,'2024-01-27 09:45:00.000000',7100000,'Chưa nhập hàng','NCC003','CN001','NV004',0),('PNH028',0,'2024-01-28 10:35:00.000000',5400000,'Đã nhập hàng','NCC003','CN001','NV004',0),('PNH029',0,'2024-01-29 08:55:00.000000',6800000,'Chưa nhập hàng','NCC003','CN001','NV004',0),('PNH030',0,'2024-01-30 11:20:00.000000',5900000,'Đã nhập hàng','NCC003','CN001','NV004',0),('PNH031',0,'2024-01-31 09:30:00.000000',7300000,'Đã nhập hàng','NCC004','CN001','NV005',0),('PNH032',0,'2024-02-01 08:00:00.000000',6000000,'Đã nhập hàng','NCC004','CN001','NV005',0),('PNH033',0,'2024-02-02 10:30:00.000000',7500000,'Đã nhập hàng','NCC004','CN001','NV005',0),('PNH034',0,'2024-02-03 09:15:00.000000',5400000,'Chưa nhập hàng','NCC004','CN001','NV005',0),('PNH035',0,'2024-02-04 11:20:00.000000',6900000,'Đã nhập hàng','NCC004','CN001','NV005',0),('PNH036',0,'2024-02-05 08:45:00.000000',5700000,'Chưa nhập hàng','NCC004','CN001','NV005',0),('PNH037',0,'2024-02-06 10:00:00.000000',7200000,'Đã nhập hàng','NCC004','CN001','NV005',0),('PNH038',0,'2024-02-07 09:30:00.000000',5600000,'Đã nhập hàng','NCC004','CN001','NV005',0),('PNH039',0,'2024-02-08 10:45:00.000000',6900000,'Chưa nhập hàng','NCC004','CN001','NV005',0),('PNH040',0,'2024-02-09 08:20:00.000000',5300000,'Đã nhập hàng','NCC004','CN001','NV005',0),('PNH041',0,'2024-02-10 11:10:00.000000',7100000,'Chưa nhập hàng','NCC005','CN001','NV005',0),('PNH042',0,'2024-02-11 09:50:00.000000',5500000,'Đã thanh toán','NCC005','CN001','NV005',0),('PNH043',0,'2024-02-12 10:15:00.000000',6900000,'Đã thanh toán','NCC005','CN001','NV005',0),('PNH044',0,'2024-02-13 08:30:00.000000',5800000,'Đã nhập hàng','NCC005','CN001','NV005',0),('PNH045',0,'2024-02-14 11:25:00.000000',7000000,'Chưa nhập hàng','NCC005','CN001','NV005',0),('PNH046',0,'2024-02-15 09:40:00.000000',5400000,'Chưa nhập hàng','NCC005','CN001','NV005',0),('PNH047',0,'2024-02-16 10:05:00.000000',7200000,'Chưa nhập hàng','NCC005','CN001','NV005',0),('PNH048',0,'2024-02-17 08:15:00.000000',5600000,'Đã thanh toán','NCC005','CN001','NV005',0),('PNH049',0,'2024-02-18 11:30:00.000000',6900000,'Chưa nhập hàng','NCC005','CN001','NV005',0),('PNH050',0,'2024-02-19 09:35:00.000000',5500000,'Đã nhập hàng','NCC005','CN001','NV005',0),('PNH051',0,'2024-02-20 10:20:00.000000',7100000,'Đã thanh toán','NCC005','CN001','NV005',0),('PNH052',0,'2024-02-21 08:40:00.000000',5600000,'Đã thanh toán','NCC005','CN001','NV005',0),('PNH053',0,'2024-02-22 11:15:00.000000',6900000,'Đã nhập hàng','NCC004','CN001','NV005',0),('PNH054',0,'2024-02-23 09:25:00.000000',5300000,'Đã nhập hàng','NCC004','CN001','NV005',0),('PNH055',0,'2024-02-24 10:50:00.000000',7200000,'Chưa nhập hàng','NCC003','CN001','NV005',0),('PNH056',0,'2024-02-25 08:10:00.000000',5900000,'Đã nhập hàng','NCC003','CN001','NV005',0),('PNH057',0,'2024-02-26 11:00:00.000000',7100000,'Chưa nhập hàng','NCC002','CN001','NV005',0),('PNH058',0,'2024-02-27 09:45:00.000000',5400000,'Chưa nhập hàng','NCC002','CN001','NV005',0),('PNH059',0,'2024-02-28 10:35:00.000000',6800000,'Đã nhập hàng','NCC001','CN001','NV005',0),('PNH060',0,'2024-02-29 08:55:00.000000',5700000,'Đã nhập hàng','NCC001','CN001','NV005',0);
/*!40000 ALTER TABLE `phieu_nhap_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_sua_chua`
--

DROP TABLE IF EXISTS `phieu_sua_chua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `phieu_sua_chua` (
  `ma_phieu_sua_chua` varchar(255) NOT NULL,
  `noi_dung_sua_chua` varchar(255) DEFAULT NULL,
  `tong_tien` double DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT NULL,
  `ma_hang_hoa` varchar(255) DEFAULT NULL,
  `ma_khach_hang` varchar(255) DEFAULT NULL,
  `ma_loai_xe` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  `ma_nhom_hang` varchar(255) DEFAULT NULL,
  `thoi_gian` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ma_phieu_sua_chua`),
  KEY `FK6udsjokgu2si366xfc3r0i4ul` (`ma_hang_hoa`),
  KEY `FKe3ehjl95ayopna4mqko4npj0f` (`ma_khach_hang`),
  KEY `FK9256h7bkh7247r4wcs49mfcy5` (`ma_loai_xe`),
  KEY `FKec1y345r1np4lsreu4a6kfq59` (`ma_nhan_vien`),
  KEY `FK6dd34ysx51okkvyrhdcq1jtuj` (`ma_nhom_hang`),
  CONSTRAINT `FK6dd34ysx51okkvyrhdcq1jtuj` FOREIGN KEY (`ma_nhom_hang`) REFERENCES `nhom_hang` (`ma_nhom_hang`),
  CONSTRAINT `FK6udsjokgu2si366xfc3r0i4ul` FOREIGN KEY (`ma_hang_hoa`) REFERENCES `hang_hoa` (`ma_hang_hoa`),
  CONSTRAINT `FK9256h7bkh7247r4wcs49mfcy5` FOREIGN KEY (`ma_loai_xe`) REFERENCES `loai_xe` (`ma_loai_xe`),
  CONSTRAINT `FKe3ehjl95ayopna4mqko4npj0f` FOREIGN KEY (`ma_khach_hang`) REFERENCES `khach_hang` (`ma_khach_hang`),
  CONSTRAINT `FKec1y345r1np4lsreu4a6kfq59` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_sua_chua`
--

LOCK TABLES `phieu_sua_chua` WRITE;
/*!40000 ALTER TABLE `phieu_sua_chua` DISABLE KEYS */;
INSERT INTO `phieu_sua_chua` VALUES ('PSC001','Thay nhớt và kiểm tra hệ thống điện',1500000,'Hoàn thành','HH001','KH001','LX001','NV006','NH001','2024-01-01 08:00:00.000000'),('PSC002','Sửa chữa hệ thống phanh',1200000,'Đang xử lý','HH002','KH002','LX001','NV006','NH001','2024-01-01 08:00:00.000000'),('PSC003','Kiểm tra và sửa chữa hệ thống làm mát',1100000,'Hoàn thành','HH003','KH003','LX002','NV007','NH001','2024-01-01 08:00:00.000000'),('PSC004','Thay pin ắc quy',400000,'Hoàn thành','HH004','KH004','LX002','NV007','NH001','2024-01-01 08:00:00.000000'),('PSC005','Kiểm tra và sửa chữa hệ thống đèn',1400000,'Đang xử lý','HH005','KH005','LX002','NV008','NH002','2024-01-01 08:00:00.000000'),('PSC006','Thay bơm phanh',700000,'Hoàn thành','HH006','KH006','LX003','NV008','NH002','2024-01-01 08:00:00.000000'),('PSC007','Sửa chữa hệ thống điều hòa',1700000,'Hoàn thành','HH007','KH007','LX004','NV009','NH002','2024-01-01 08:00:00.000000'),('PSC008','Kiểm tra và sửa chữa hệ thống cảm biến',1600000,'Đã hủy','HH017','KH008','LX005','NV009','NH004','2024-01-01 08:00:00.000000'),('PSC009','Thay bơm xăng',500000,'Đang xử lý','HH018','KH009','LX006','NV010','NH004','2024-01-01 08:00:00.000000'),('PSC010','Kiểm tra và sửa chữa hệ thống lái',1300000,'Hoàn thành','HH019','KH010','LX007','NV001','NH004','2024-01-01 08:00:00.000000');
/*!40000 ALTER TABLE `phieu_sua_chua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_tra_hang`
--

DROP TABLE IF EXISTS `phieu_tra_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `phieu_tra_hang` (
  `ma_phieu_tra_hang` varchar(255) NOT NULL,
  `can_tra` double DEFAULT NULL,
  `da_tra` double DEFAULT NULL,
  `thoi_gian` datetime(6) DEFAULT NULL,
  `ma_hoa_don` varchar(255) DEFAULT NULL,
  `ma_khach_hang` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  `ma_nha_cung_cap` varchar(255) DEFAULT NULL,
  `trang_thai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_phieu_tra_hang`),
  UNIQUE KEY `UK_rgogid0kbtv4j2t5qdtm1kcu7` (`ma_hoa_don`),
  KEY `FK8h6q70v26v9b1wbruu4ueycr3` (`ma_khach_hang`),
  KEY `FKsp7xbcksck81jyt11nxeqbt5m` (`ma_nhan_vien`),
  KEY `fk_ma_nha_cung_cap_phieu_tra_hang` (`ma_nha_cung_cap`),
  CONSTRAINT `FK8h6q70v26v9b1wbruu4ueycr3` FOREIGN KEY (`ma_khach_hang`) REFERENCES `khach_hang` (`ma_khach_hang`),
  CONSTRAINT `FKfxcbvnmn98ximsbvrf4uu52nq` FOREIGN KEY (`ma_hoa_don`) REFERENCES `hoa_don` (`ma_hoa_don`),
  CONSTRAINT `FKsp7xbcksck81jyt11nxeqbt5m` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `fk_ma_nha_cung_cap_phieu_tra_hang` FOREIGN KEY (`ma_nha_cung_cap`) REFERENCES `nha_cung_cap` (`ma_nha_cung_cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_tra_hang`
--

LOCK TABLES `phieu_tra_hang` WRITE;
/*!40000 ALTER TABLE `phieu_tra_hang` DISABLE KEYS */;
INSERT INTO `phieu_tra_hang` VALUES ('PTH001',1500000,1000000,'2024-01-18 08:00:00.000000','HD001','KH001','NV004',NULL,'Đã xử lý'),('PTH002',1200000,800000,'2024-01-18 09:30:00.000000','HD003','KH002','NV004',NULL,'Đang xử lý'),('PTH003',1100000,700000,'2024-01-18 10:45:00.000000','HD008','KH005','NV004',NULL,'Đã xử lý'),('PTH004',2000000,1800000,'2024-01-16 10:45:00.000000','HD002',NULL,'NV005','NCC004','Đang xử lý');
/*!40000 ALTER TABLE `phieu_tra_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phu_cap`
--

DROP TABLE IF EXISTS `phu_cap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `phu_cap` (
  `ma_phu_cap` varchar(50) NOT NULL,
  `noi_dung` varchar(255) DEFAULT NULL,
  `tien_phu_cap` double DEFAULT NULL,
  PRIMARY KEY (`ma_phu_cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phu_cap`
--

LOCK TABLES `phu_cap` WRITE;
/*!40000 ALTER TABLE `phu_cap` DISABLE KEYS */;
INSERT INTO `phu_cap` VALUES ('PC001','Tiền xăng',200000),('PC002','Tết',2000000);
/*!40000 ALTER TABLE `phu_cap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `the_kho`
--

DROP TABLE IF EXISTS `the_kho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `the_kho` (
  `ma_the_kho` varchar(255) NOT NULL,
  `gia_von` double DEFAULT NULL,
  `phuong_thuc` varchar(255) DEFAULT NULL,
  `so_luong` smallint(6) DEFAULT NULL,
  `so_luong_thuc_te` smallint(6) DEFAULT NULL,
  `thoi_gian` datetime(6) DEFAULT NULL,
  `ton_cuoi` smallint(6) DEFAULT NULL,
  `ma_hang_hoa` varchar(255) DEFAULT NULL,
  `ma_khach_hang` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  `ma_nha_cung_cap` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_the_kho`),
  KEY `FKona35b4mu3gorbdeik0d73742` (`ma_hang_hoa`),
  KEY `FKbv2oghucn1wh4ok43md97xlbk` (`ma_khach_hang`),
  KEY `FKatlpjkwmq08wx1vefg7gqr496` (`ma_nhan_vien`),
  KEY `fk_ma_nha_cung_cap` (`ma_nha_cung_cap`),
  CONSTRAINT `FKatlpjkwmq08wx1vefg7gqr496` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `FKbv2oghucn1wh4ok43md97xlbk` FOREIGN KEY (`ma_khach_hang`) REFERENCES `khach_hang` (`ma_khach_hang`),
  CONSTRAINT `FKona35b4mu3gorbdeik0d73742` FOREIGN KEY (`ma_hang_hoa`) REFERENCES `hang_hoa` (`ma_hang_hoa`),
  CONSTRAINT `fk_ma_nha_cung_cap` FOREIGN KEY (`ma_nha_cung_cap`) REFERENCES `nha_cung_cap` (`ma_nha_cung_cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `the_kho`
--

LOCK TABLES `the_kho` WRITE;
/*!40000 ALTER TABLE `the_kho` DISABLE KEYS */;
INSERT INTO `the_kho` VALUES ('TK001',50000,'Nhập',100,100,'2024-01-18 08:00:00.000000',100,'HH001',NULL,'NV004','NCC001'),('TK002',60000,'Nhập',80,80,'2024-01-18 09:30:00.000000',20,'HH002',NULL,'NV004','NCC001'),('TK003',55000,'Nhập',120,120,'2024-01-18 10:45:00.000000',140,'HH003',NULL,'NV004','NCC001'),('TK004',60000,'Nhập',60,60,'2024-01-18 12:15:00.000000',80,'HH004',NULL,'NV004','NCC001'),('TK005',52000,'Nhập',90,90,'2024-01-18 13:45:00.000000',170,'HH005',NULL,'NV004','NCC001'),('TK006',60000,'Nhập',50,50,'2024-01-18 15:00:00.000000',120,'HH006',NULL,'NV004','NCC001'),('TK007',53000,'Nhập',80,80,'2024-01-18 16:30:00.000000',200,'HH007',NULL,'NV004','NCC001'),('TK008',58000,'Nhập',70,70,'2024-01-18 17:45:00.000000',130,'HH008',NULL,'NV004','NCC001'),('TK009',54000,'Nhập',110,110,'2024-01-18 18:45:00.000000',240,'HH009',NULL,'NV004','NCC001'),('TK010',62000,'Nhập',40,40,'2024-01-18 20:00:00.000000',200,'HH010',NULL,'NV004','NCC001'),('TK011',51000,'Nhập',95,95,'2024-01-19 08:00:00.000000',295,'HH011',NULL,'NV004','NCC002'),('TK012',59000,'Nhập',65,65,'2024-01-19 09:30:00.000000',230,'HH012',NULL,'NV004','NCC002'),('TK013',55000,'Nhập',100,100,'2024-01-19 10:45:00.000000',330,'HH013',NULL,'NV004','NCC002'),('TK014',61000,'Nhập',55,55,'2024-01-19 12:15:00.000000',275,'HH014',NULL,'NV004','NCC002'),('TK015',53000,'Nhập',85,85,'2024-01-19 13:45:00.000000',360,'HH015',NULL,'NV004','NCC002'),('TK016',62000,'Nhập',45,45,'2024-01-19 15:00:00.000000',315,'HH016',NULL,'NV004','NCC002'),('TK017',54000,'Nhập',105,105,'2024-01-19 16:30:00.000000',420,'HH017',NULL,'NV004','NCC002'),('TK018',59000,'Nhập',75,75,'2024-01-19 17:45:00.000000',345,'HH018',NULL,'NV004','NCC002'),('TK019',52000,'Nhập',115,115,'2024-01-19 18:45:00.000000',460,'HH019',NULL,'NV004','NCC002'),('TK020',63000,'Nhập',35,35,'2024-01-19 20:00:00.000000',425,'HH020',NULL,'NV004','NCC002'),('TK021',53000,'Nhập',90,90,'2024-01-20 08:00:00.000000',515,'HH021',NULL,'NV004','NCC003'),('TK022',60000,'Nhập',60,60,'2024-01-20 09:30:00.000000',455,'HH022',NULL,'NV004','NCC003'),('TK023',55000,'Nhập',105,105,'2024-01-20 10:45:00.000000',560,'HH023',NULL,'NV004','NCC003'),('TK024',61000,'Nhập',50,50,'2024-01-20 12:15:00.000000',510,'HH024',NULL,'NV004','NCC003'),('TK025',52000,'Nhập',95,95,'2024-01-20 13:45:00.000000',605,'HH025',NULL,'NV004','NCC003'),('TK026',63000,'Nhập',40,40,'2024-01-20 15:00:00.000000',565,'HH026',NULL,'NV004','NCC003'),('TK027',54000,'Nhập',110,110,'2024-01-20 16:30:00.000000',675,'HH027',NULL,'NV004','NCC003'),('TK028',59000,'Nhập',70,70,'2024-01-20 17:45:00.000000',605,'HH028',NULL,'NV004','NCC003'),('TK029',51000,'Nhập',120,120,'2024-01-20 18:45:00.000000',725,'HH029',NULL,'NV004','NCC003'),('TK030',64000,'Nhập',30,30,'2024-01-20 20:00:00.000000',695,'HH030',NULL,'NV004','NCC003'),('TK031',54000,'Nhập',85,85,'2024-01-21 08:00:00.000000',780,'HH031',NULL,'NV004','NCC004'),('TK032',61000,'Nhập',55,55,'2024-01-21 09:30:00.000000',725,'HH032',NULL,'NV004','NCC004'),('TK033',55000,'Nhập',100,100,'2024-01-21 10:45:00.000000',825,'HH033',NULL,'NV004','NCC004'),('TK034',62000,'Nhập',45,45,'2024-01-21 12:15:00.000000',780,'HH034',NULL,'NV004','NCC004'),('TK035',53000,'Nhập',95,95,'2024-01-21 13:45:00.000000',875,'HH035',NULL,'NV004','NCC004'),('TK036',64000,'Nhập',35,35,'2024-01-21 15:00:00.000000',840,'HH036',NULL,'NV005','NCC004'),('TK037',55000,'Nhập',110,110,'2024-01-21 16:30:00.000000',950,'HH037',NULL,'NV005','NCC004'),('TK038',60000,'Nhập',70,70,'2024-01-21 17:45:00.000000',880,'HH038',NULL,'NV005','NCC004'),('TK039',52000,'Nhập',120,120,'2024-01-21 18:45:00.000000',1000,'HH039',NULL,'NV005','NCC004'),('TK040',65000,'Nhập',30,30,'2024-01-21 20:00:00.000000',970,'HH040',NULL,'NV005','NCC004'),('TK041',55000,'Nhập',95,95,'2024-01-22 08:00:00.000000',1065,'HH041',NULL,'NV005','NCC005'),('TK042',62000,'Nhập',55,55,'2024-01-22 09:30:00.000000',1010,'HH042',NULL,'NV005','NCC005'),('TK043',56000,'Nhập',100,100,'2024-01-22 10:45:00.000000',1110,'HH043',NULL,'NV005','NCC005'),('TK044',63000,'Nhập',45,45,'2024-01-22 12:15:00.000000',1065,'HH044',NULL,'NV005','NCC005'),('TK045',54000,'Nhập',95,95,'2024-01-22 13:45:00.000000',1160,'HH045',NULL,'NV005','NCC005'),('TK046',65000,'Nhập',35,35,'2024-01-22 15:00:00.000000',1125,'HH046',NULL,'NV005','NCC005'),('TK047',56000,'Nhập',110,110,'2024-01-22 16:30:00.000000',1235,'HH047',NULL,'NV005','NCC005'),('TK048',61000,'Nhập',70,70,'2024-01-22 17:45:00.000000',1165,'HH048',NULL,'NV005','NCC005'),('TK049',53000,'Nhập',120,120,'2024-01-22 18:45:00.000000',1285,'HH049',NULL,'NV005','NCC005'),('TK050',66000,'Nhập',30,30,'2024-01-22 20:00:00.000000',1255,'HH050',NULL,'NV005','NCC005'),('TK051',56000,'Nhập',90,90,'2024-01-23 08:00:00.000000',1345,'HH051',NULL,'NV005','NCC005'),('TK052',63000,'Nhập',60,60,'2024-01-23 09:30:00.000000',1285,'HH052',NULL,'NV005','NCC005'),('TK053',57000,'Nhập',105,105,'2024-01-23 10:45:00.000000',1390,'HH053',NULL,'NV005','NCC004'),('TK054',64000,'Nhập',50,50,'2024-01-23 12:15:00.000000',1340,'HH054',NULL,'NV005','NCC004'),('TK055',55000,'Nhập',95,95,'2024-01-23 13:45:00.000000',1435,'HH055',NULL,'NV005','NCC003'),('TK056',66000,'Nhập',40,40,'2024-01-23 15:00:00.000000',1395,'HH056',NULL,'NV005','NCC003'),('TK057',57000,'Nhập',110,110,'2024-01-23 16:30:00.000000',1505,'HH057',NULL,'NV005','NCC002'),('TK058',62000,'Nhập',70,70,'2024-01-23 17:45:00.000000',1435,'HH058',NULL,'NV005','NCC002'),('TK059',54000,'Nhập',120,120,'2024-01-23 18:45:00.000000',1555,'HH059',NULL,'NV005','NCC001'),('TK060',67000,'Nhập',30,30,'2024-01-23 20:00:00.000000',1525,'HH060',NULL,'NV005','NCC001');
/*!40000 ALTER TABLE `the_kho` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-25 16:34:05
