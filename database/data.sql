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
INSERT INTO `bang_cham_cong` VALUES ('BC001',0,'2024-01-01','Đầy đủ','CAL001','NV001'),('BC002',0,'2024-01-02','Vắng','CAL001','NV002'),('BC003',0,'2024-01-27','Đi trễ','CAL001','NV003'),('BC004',0,'2024-01-04','Đầy đủ','CAL002','NV004'),('BC005',0,'2023-01-18','Đầy đủ','CAL001','NV005'),('BC006',0,'2024-02-06','Đầy đủ','CAL002','NV006'),('BC007',0,'2024-03-19','Đi trễ','CAL003','NV007'),('BC008',0,'2023-05-08','Vắng','CAL003','NV008'),('BC009',2,'2024-01-09','Tăng ca','CAL001','NV009'),('BC010',0,'2024-01-31','Vắng','CAL001','NV005'),('BC012',NULL,'2024-04-18','Đầy đủ','CAL002','NV000'),('BC013',NULL,'2024-04-20','Đầy đủ','CAL001','NV002'),('BCC011',NULL,'2024-03-25','Vắng','CAL002','NV005');
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
  `loai` varchar(255) DEFAULT NULL,
  `noi_dung` varchar(255) DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT 'Còn sử dụng',
  PRIMARY KEY (`ma_bang_luong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bang_luong`
--

LOCK TABLES `bang_luong` WRITE;
/*!40000 ALTER TABLE `bang_luong` DISABLE KEYS */;
INSERT INTO `bang_luong` VALUES ('BL001','giờ',23000,'Bảng lương','Thực tập','Còn sử dụng'),('BL002','ca',100000,'Bảng lương','Bán thời gian','Còn sử dụng'),('BL003','tháng',8000000,'Bảng lương','0 năm kinh nghiệm','Còn sử dụng'),('BL07','tháng',15000000,'Bảng lương','Kinh nghiệm 1 năm','Còn sử dụng'),('LT005','năm',1000000,'Lương thưởng','Thưởng tết','Còn sử dụng'),('TC004','tháng',500000,'Trợ cấp','Xăng','Còn sử dụng'),('TCa004','giờ',40000,'Tăng ca','Nhân viên lâu năm','Còn sử dụng');
/*!40000 ALTER TABLE `bang_luong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bang_luong_nhan_vien`
--

DROP TABLE IF EXISTS `bang_luong_nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bang_luong_nhan_vien` (
  `ma` varchar(255) NOT NULL,
  `ma_bang_luong` varchar(255) DEFAULT NULL,
  `ma_lich_lam_viec` varchar(255) DEFAULT NULL,
  `ma_phieu_luong` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  `da_xu_ly` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `ma_bang_luong` (`ma_bang_luong`),
  KEY `ma_lich_lam_viec` (`ma_lich_lam_viec`),
  KEY `ma_phieu_luong` (`ma_phieu_luong`),
  KEY `ma_nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `bang_luong_nhan_vien_ibfk_1` FOREIGN KEY (`ma_bang_luong`) REFERENCES `bang_luong` (`ma_bang_luong`),
  CONSTRAINT `bang_luong_nhan_vien_ibfk_3` FOREIGN KEY (`ma_lich_lam_viec`) REFERENCES `lich_lam_viec` (`ma_lich_lam_viec`),
  CONSTRAINT `bang_luong_nhan_vien_ibfk_4` FOREIGN KEY (`ma_phieu_luong`) REFERENCES `phieu_luong` (`ma_phieu`),
  CONSTRAINT `bang_luong_nhan_vien_ibfk_5` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bang_luong_nhan_vien`
--

LOCK TABLES `bang_luong_nhan_vien` WRITE;
/*!40000 ALTER TABLE `bang_luong_nhan_vien` DISABLE KEYS */;
INSERT INTO `bang_luong_nhan_vien` VALUES ('BLNV01','BL001','LLV022',NULL,'NV004',NULL),('BLNV02','BL001','LLV023',NULL,'NV002',NULL),('BLNV0LLV0263','BL003','LLV026',NULL,'NV004',NULL),('BLNV0LLV0275','BL003','LLV027',NULL,'NV001',NULL);
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
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_chi_nhanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_nhanh`
--

LOCK TABLES `chi_nhanh` WRITE;
/*!40000 ALTER TABLE `chi_nhanh` DISABLE KEYS */;
INSERT INTO `chi_nhanh` VALUES ('CN001','123 ABC Street, District 1, Ho Chi Minh City','Garage oto Lâm Vinh chi nhánh Hoàng Diệu 2','Hoạt động','0151531867'),('CN002','456 XYZ Street, District 2, Ho Chi Minh City','Chi Nhánh B','Ngừng hoạt động','0869511645'),('CN003','789 DEF Street, District 3, Ho Chi Minh City','Chi Nhánh C','Ngừng hoạt động','0256161658'),('CN04','91 Đường Lê Văn Sỹ, Phường 1, Tân Bình, Hồ Chí Minh','Garage oto Lâm Vinh chi nhánh Tân Bình','Ngừng hoạt động','0153164867'),('CN05','Số 5 đường 3/4, thành phố Đà Lạt','Garage oto Lâm Vinh chi nhánh Đà Lạt','Ngừng hoạt động','0561684315');
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
  `ten_hang_hoa` varchar(255) DEFAULT NULL,
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
INSERT INTO `chi_tiet_phieu_nhap_hang` VALUES ('CTPNH001','HH001',8,50000,500000,0,400000,'PNH001','Nhớt Mobil'),('CTPNH002','HH002',10,50000,500000,0,500000,'PNH002','Nhớt Castrol'),('CTPNH003','HH003',10,50000,500000,0,500000,'PNH003','Nhớt Total'),('CTPNH004','HH004',10,50000,500000,0,500000,'PNH004','Nhớt Motul'),('CTPNH005','HH005',10,50000,500000,0,500000,'PNH005','Lốp Michelin'),('CTPNH006','HH006',10,50000,500000,0,500000,'PNH006','Lốp Bridgestone'),('CTPNH007','HH007',10,50000,500000,0,500000,'PNH007','Lốp Goodyear'),('CTPNH008','HH008',10,50000,500000,0,500000,'PNH008','Lốp Pirelli'),('CTPNH009','HH009',10,50000,500000,0,500000,'PNH009','Bộ lọc gió Bosch'),('CTPNH010','HH010',10,50000,500000,0,500000,'PNH010','Bộ lọc nhớt Mann'),('CTPNH011','HH011',10,50000,500000,0,500000,'PNH059','Bộ lọc nhiên liệu Fram'),('CTPNH012','HH012',10,50000,500000,0,500000,'PNH060','Bộ lọc không khí K&N'),('CTPNH013','HH013',10,50000,500000,0,500000,'PNH011','Dầu động cơ Shell'),('CTPNH014','HH014',10,50000,500000,0,500000,'PNH012','Bơm nhiên liệu Denso'),('CTPNH015','HH015',10,50000,500000,0,500000,'PNH013','Bugi NGK'),('CTPNH016','HH016',10,50000,500000,0,500000,'PNH014','Dây curoa Gates'),('CTPNH017','HH017',10,50000,500000,0,500000,'PNH015','Sơn xanh phấn Yamaha'),('CTPNH018','HH018',10,50000,500000,0,500000,'PNH016','Sơn đen nhám Toyota'),('CTPNH019','HH019',10,50000,500000,0,500000,'PNH017','Sơn trắng sữa Honda'),('CTPNH020','HH020',10,50000,500000,0,500000,'PNH018','Sơn đỏ ferrari'),('CTPNH021','HH021',10,50000,500000,0,500000,'PNH019','Dung dịch vệ sinh nội thất Meguiar'),('CTPNH022','HH022',10,50000,500000,0,500000,'PNH020','Bột tẩy bẩn Sonax'),('CTPNH023','HH023',10,50000,500000,0,500000,'PNH057','Nước tẩy rửa da Chemical Guys'),('CTPNH024','HH024',10,50000,500000,0,500000,'PNH058','Dầu dưỡng da Leather Honey'),('CTPNH025','HH025',10,50000,500000,0,500000,'PNH021','Bóng đèn halogen Philips'),('CTPNH026','HH026',10,50000,500000,0,500000,'PNH022','Bóng đèn LED Osram'),('CTPNH027','HH027',10,50000,500000,0,500000,'PNH023','Bộ điều khiển động cơ ECU Bosch'),('CTPNH028','HH028',10,50000,500000,0,500000,'PNH024','Dây điện dẹt 2.5mm²'),('CTPNH029','HH029',10,50000,500000,0,500000,'PNH025','Bộ lốp và rotơ trước Brembo'),('CTPNH030','HH030',10,50000,500000,0,500000,'PNH026','Dầu thắng Castrol DOT 4'),('CTPNH031','HH031',10,50000,500000,0,500000,'PNH027','Dây phanh dầu trước ATE'),('CTPNH032','HH032',10,50000,500000,0,500000,'PNH028','Dây phanh sau Brembo'),('CTPNH033','HH033',10,50000,500000,0,500000,'PNH029','Dầu hộp số tự động Mobil 1'),('CTPNH034','HH034',10,50000,500000,0,500000,'PNH030','Dầu hộp số tự động Toyota ATF WS'),('CTPNH035','HH035',10,50000,500000,0,500000,'PNH055','Dầu hộp số tự động Honda ATF DW1'),('CTPNH036','HH036',10,50000,500000,0,500000,'PNH056','Dầu hộp số tự động Nissan Matic S'),('CTPNH037','HH037',10,50000,500000,0,500000,'PNH031','Bơm dầu lái trợ lực Bosch'),('CTPNH038','HH038',10,50000,500000,0,500000,'PNH032','Dây lái điện ô tô'),('CTPNH039','HH039',10,50000,500000,0,500000,'PNH033','Cụm cầu lái trước Toyota'),('CTPNH040','HH040',10,50000,500000,0,500000,'PNH034','Vòi nước lái ô tô'),('CTPNH041','HH041',10,50000,500000,0,500000,'PNH035','Nước làm mát Prestone'),('CTPNH042','HH042',10,50000,500000,0,500000,'PNH036','Quạt làm mát Denso'),('CTPNH043','HH043',10,50000,500000,0,500000,'PNH037','Đèn báo nhiệt độ nước làm mát'),('CTPNH044','HH044',10,50000,500000,0,500000,'PNH038','Vòi phun nước làm mát'),('CTPNH045','HH045',10,50000,500000,0,500000,'PNH039','Cảm biến O2 Bosch'),('CTPNH046','HH046',10,50000,500000,0,500000,'PNH040','Bộ van EGR Pierburg'),('CTPNH047','HH047',10,50000,500000,0,500000,'PNH053','Ống xả ô tô'),('CTPNH048','HH048',10,50000,500000,0,500000,'PNH054','Kích hoạt ator bảo vệ động cơ'),('CTPNH049','HH049',10,50000,500000,0,500000,'PNH041','Giảm xóc KYB'),('CTPNH050','HH050',10,50000,500000,0,500000,'PNH042','Lò xo treo ô tô'),('CTPNH051','HH051',10,50000,500000,0,500000,'PNH043','Bạc đạn trục giảm chấn'),('CTPNH052','HH052',10,50000,500000,0,500000,'PNH044','Bản lề cửa ô tô'),('CTPNH053','HH053',10,50000,500000,0,500000,'PNH045','Nước làm mát Zerex'),('CTPNH054','HH054',10,50000,500000,0,500000,'PNH046','Bình chứa nước làm mát'),('CTPNH055','HH055',10,50000,500000,0,500000,'PNH047','Bơm nước làm mát Điện lực'),('CTPNH056','HH056',10,50000,500000,0,500000,'PNH048','Nắp bình nước làm mát'),('CTPNH057','HH057',10,50000,500000,0,500000,'PNH049','Pin ắc quy GS'),('CTPNH058','HH058',10,50000,500000,0,500000,'PNH050','Pin ắc quy Panasonic'),('CTPNH059','HH059',10,50000,500000,0,500000,'PNH051','Kẹp pin ắc quy'),('CTPNH060','HH060',10,50000,500000,0,500000,'PNH052','Dây dẫn nối pin ắc quy'),('CTPNH061','HH015',6,130000,600000,0,780000,'PNH001','Bugi NGK'),('PNH061NCC003CTPNH00','HH006',1,1800000,1800000,0,1800000,'PNH061NCC003','Lốp Bridgestone'),('PNH061NCC003CTPNH01','HH008',1,2200000,2200000,0,2200000,'PNH061NCC003','Lốp Pirelli'),('PNH061NCC003CTPNH02','HH004',1,130000,130000,0,130000,'PNH061NCC003','Nhớt Motul'),('PNH062NCC002CTPNH00','HH004',1,130000,130000,0,130000,'PNH062NCC002','Nhớt Motul'),('PNH062NCC002CTPNH01','HH008',1,2200000,2200000,0,2200000,'PNH062NCC002','Lốp Pirelli'),('PNH063NCC001CTPNH00','HH008',1,2200000,2200000,0,2200000,'PNH063NCC001','Lốp Pirelli'),('PNH063NCC001CTPNH01','HH010',1,350000,350000,0,350000,'PNH063NCC001','Bộ lọc nhớt Mann'),('PNH064NCC001CTPNH00','HH009',1,300000,300000,0,NULL,'PNH064NCC001','Bộ lọc gió Bosch'),('PNH064NCC001CTPNH01','HH010',1,350000,350000,0,NULL,'PNH064NCC001','Bộ lọc nhớt Mann'),('PNH065NCC003CTPNH00','HH001',1,100000,100000,0,NULL,'PNH065NCC003','Nhớt Mobil'),('PNH065NCC003CTPNH01','HH008',1,2200000,2200000,0,NULL,'PNH065NCC003','Lốp Pirelli');
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
  `ten_hang_hoa` varchar(255) DEFAULT NULL,
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
INSERT INTO `chi_tiet_phieu_tra_hang` VALUES ('CTPTH001',10000,10,100000,'HH001','PTH001','Nhớt Mobil'),('CTPTH002',15000,5,75000,'HH004','PTH001','Nhớt Motul'),('CTPTH003',12000,8,96000,'HH005','PTH002','Lốp Michelin'),('PTH05CTPTH1',1000000,1,1000000,'HH012','PTH05','Bộ lọc không khí K&N'),('PTH05CTPTH2',500000,1,500000,'HH011','PTH05','Bộ lọc nhiên liệu Fram'),('PTH06CTPTH1',500000,1,500000,'HH045','PTH06','Cảm biến O2 Bosch'),('PTH06CTPTH2',2000000,1,2000000,'HH054','PTH06','Bình chứa nước làm mát'),('PTH07CTPTH1',50000,4,200000,'HH001','PTH07','Nhớt Mobil'),('PTH07CTPTH2',130000,2,260000,'HH015','PTH07','Bugi NGK');
/*!40000 ALTER TABLE `chi_tiet_phieu_tra_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cong_viec`
--

DROP TABLE IF EXISTS `cong_viec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cong_viec` (
  `ma_cong_viec` varchar(255) NOT NULL,
  `ten_cong_viec` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_cong_viec`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cong_viec`
--

LOCK TABLES `cong_viec` WRITE;
/*!40000 ALTER TABLE `cong_viec` DISABLE KEYS */;
INSERT INTO `cong_viec` VALUES ('CV001','admin'),('CV002','Nhân viên sữa chữa'),('CV003','Nhân viên kỹ thuật'),('CV004','Bảo vệ'),('CV005','Kế toán viên');
/*!40000 ALTER TABLE `cong_viec` ENABLE KEYS */;
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
  `loai_hang` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `trang_thai` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1',
  `gia_thay` double DEFAULT '0',
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
INSERT INTO `hang_hoa` VALUES ('HH001',100000,80000,6,'Nhớt Mobil',14,'NH001','Nhớt','1',85000),('HH002',120000,90000,8,'Nhớt Castrol',-5,'NH004','Nhớt','1',95000),('HH003',110000,85000,9,'Nhớt Total',-4,'NH001','Nhớt','1',90000),('HH004',130000,95000,16,'Nhớt Motul',0,'NH001','Nhớt','1',100000),('HH005',2000000,1500000,10,'Lốp Michelin',-1,'NH002','Lốp','1',1600000),('HH006',1800000,1400000,8,'Lốp Bridgestone',0,'NH002','Lốp','1',1450000),('HH007',1900000,1450000,4,'Lốp Goodyear',0,'NH002','Lốp','1',1500000),('HH008',2200000,1650000,4,'Lốp Pirelli',3,'NH002','Lốp','1',1700000),('HH009',300000,250000,9,'Bộ lọc gió Bosch',23,'NH003','Bộ lọc gió','1',300000),('HH010',350000,300000,6,'Bộ lọc nhớt Mann',18,'NH003','Bộ lọc nhớt','1',350000),('HH011',280000,220000,10,'Bộ lọc nhiên liệu Fram',30,'NH003','Bộ lọc nhiên liệu','1',270000),('HH012',400000,350000,5,'Bộ lọc không khí K&N',20,'NH003','Bộ lọc không khí','1',400000),('HH013',200000,150000,10,'Dầu động cơ Shell',35,'NH003','Dầu động cơ','1',170000),('HH014',500000,400000,3,'Bơm nhiên liệu Denso',12,'NH003','Bơm nhiên liệu','1',420000),('HH015',100000,80000,15,'Bugi NGK',63,'NH003','Bugi','1',100000),('HH016',120000,90000,12,'Dây curoa Gates',40,'NH003','Dây curoa','1',100000),('HH017',1500000,1200000,1,'Sơn xanh phấn Yamaha',5,'NH004','Sơn','1',1250000),('HH018',1800000,1400000,2,'Sơn đen nhám Toyota',8,'NH004','Sơn','1',1500000),('HH019',1700000,1350000,1,'Sơn trắng sữa Honda',6,'NH004','Sơn','1',1400000),('HH020',2000000,1600000,1,'Sơn đỏ ferrari',7,'NH004','Sơn','1',1650000),('HH021',300000,250000,10,'Dung dịch vệ sinh nội thất Meguiar',30,'NH005','Dung dịch vệ sinh','1',300000),('HH022',200000,150000,8,'Bột tẩy bẩn Sonax',25,'NH005','Bột tẩy','1',150000),('HH023',350000,300000,6,'Nước tẩy rửa da Chemical Guys',20,'NH005','Nước tẩy','1',320000),('HH024',400000,350000,5,'Dầu dưỡng da Leather Honey',15,'NH005','Dầu dưỡng','1',350000),('HH025',200000,150000,12,'Bóng đèn halogen Philips',40,'NH006','Bóng đèn','1',150000),('HH026',300000,250000,10,'Bóng đèn LED Osram',35,'NH006','Bóng đèn','1',250000),('HH027',1500000,1200000,4,'Bộ điều khiển động cơ ECU Bosch',15,'NH007','Bộ điều khiển động cơ','1',1300000),('HH028',10000,8000,25,'Dây điện dẹt 2.5mm²',102,'NH006','Dây điện dẹt','1',8000),('HH029',2500000,2000000,2,'Bộ lốp và rotơ trước Brembo',10,'NH008','Bộ lốp và rotơ','1',2100000),('HH030',300000,250000,8,'Dầu thắng Castrol DOT 4',25,'NH007','Dầu thắng','1',250000),('HH031',80000,60000,15,'Dây phanh dầu trước ATE',50,'NH007','Dây phanh dầu trước','1',60000),('HH032',120000,100000,12,'Dây phanh sau Brembo',40,'NH007','Dây phanh sau','1',110000),('HH033',700000,550000,9,'Dầu hộp số tự động Mobil 1',30,'NH008','Dầu hộp số tự động','1',550000),('HH034',600000,500000,8,'Dầu hộp số tự động Toyota ATF WS',25,'NH008','Dầu hộp số tự động','1',510000),('HH035',650000,520000,8,'Dầu hộp số tự động Honda ATF DW1',28,'NH008','Dầu hộp số tự động','1',520000),('HH036',680000,550000,7,'Dầu hộp số tự động Nissan Matic S',26,'NH008','Dầu hộp số tự động','1',550000),('HH037',900000,700000,6,'Bơm dầu lái trợ lực Bosch',20,'NH009','Bơm dầu lái','1',710000),('HH038',150000,120000,10,'Dây lái điện ô tô',40,'NH009','Dây lái điện','1',120000),('HH039',1800000,1500000,4,'Cụm cầu lái trước Toyota',15,'NH009','Cụm cầu','1',1550000),('HH040',80000,60000,8,'Vòi nước lái ô tô',30,'NH010','Vòi nước','1',65000),('HH041',120000,90000,12,'Nước làm mát Prestone',50,'NH010','Nước làm mát','1',100000),('HH042',500000,400000,6,'Quạt làm mát Denso',20,'NH010','Quạt làm mát','1',410000),('HH043',30000,25000,15,'Đèn báo nhiệt độ nước làm mát',60,'NH010','Đèn báo nhiệt','1',30000),('HH044',60000,50000,10,'Vòi phun nước làm mát',40,'NH010','Vòi phun nước','1',60000),('HH045',800000,650000,7,'Cảm biến O2 Bosch',26,'NH011','Cảm biến','1',650000),('HH046',1200000,950000,4,'Bộ van EGR Pierburg',15,'NH011','Bộ van','1',970000),('HH047',70000,55000,8,'Ống xả ô tô',30,'NH011','Ống xả','1',55000),('HH048',300000,250000,10,'Kích hoạt ator bảo vệ động cơ',40,'NH012','Kích hoạt ator','1',270000),('HH049',600000,450000,6,'Giảm xóc KYB',20,'NH012','Giảm xóc','1',500000),('HH050',400000,300000,8,'Lò xo treo ô tô',25,'NH012','Lò xo','1',330000),('HH051',200000,150000,10,'Bạc đạn trục giảm chấn',30,'NH012','Bạc đạn','1',160000),('HH052',100000,80000,12,'Bản lề cửa ô tô',40,'NH012','Bản lề','1',80000),('HH053',100000,80000,15,'Nước làm mát Zerex',50,'NH013','Nước làm mát','1',80000),('HH054',150000,120000,10,'Bình chứa nước làm mát',36,'NH013','Bình chứa nước','1',130000),('HH055',250000,200000,8,'Bơm nước làm mát Điện lực',25,'NH013','Bơm nước','1',230000),('HH056',50000,40000,12,'Nắp bình nước làm mát',40,'NH013','Nắp bình nước','1',40000),('HH057',500000,400000,6,'Pin ắc quy GS',20,'NH014','Pin ắc quy','1',400000),('HH058',600000,450000,4,'Pin ắc quy Panasonic',15,'NH014','Pin ắc quy','1',450000),('HH059',30000,25000,8,'Kẹp pin ắc quy',30,'NH014','Kẹp pin','1',25000),('HH060',100000,80000,6,'Dây dẫn nối pin ắc quy',25,'NH014','Dây dẫn','1',80000),('HH061',5120,100000,0,'aa',0,'NH007','as','1',100000);
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
INSERT INTO `hinh_anh` VALUES ('HA002','Nhớt Mobil','nhot_mobil.jpg','HH001',NULL),('HA003','Nhớt Castrol','nhot_castrol.jpg','HH002',NULL),('HA004','Nhớt Total','nhot_total.jpg','HH003',NULL),('HA005','Nhớt Motul','nhot_motul.png','HH004',NULL),('HA006','Lốp Michelin','lop_michelin.jpg','HH005',NULL),('HA007','Lốp Bridgestone','lop_bridgestone.jpg','HH006',NULL),('HA008','Lốp Goodyear','lop-goodyear.png','HH007',NULL),('HA009','Lốp Pirelli','lop-pirelli.jpeg','HH008',NULL),('HA010','Bộ lọc gió Bosch','bo_loc_gio_bosch.jpg','HH009',NULL),('HA011','Bộ lọc nhớt Mann','bo_loc_nhot_mann.jpg','HH010',NULL),('HA012','Bộ lọc nhiên liệu Fram','bo_loc_nhien_lieu_fram.jpg','HH011',NULL),('HA013','Bộ lọc không khí K&N','bo_loc_khong_khi_K_and_N.jpg','HH012',NULL),('HA014','Dầu động cơ Shell','dau_dong_co_shell.jpg','HH013',NULL),('HA015','Bơm nhiên liệu Denso','bom_nhien_lieu_denso.jpg','HH014',NULL),('HA016','Bugi NGK','Bugi_NGK.jpg','HH015',NULL),('HA017','Dây curoa Gates','Gates-belt-1.jpg','HH016',NULL),('HA018','Sơn xanh phấn Yamaha','Sf499a64f532d42d5b190030bd2a3773ft.jpg','HH017',NULL),('HA019','Sơn đen nhám Toyota','son_den_nham_Toyota.jpg','HH018',NULL),('HA020','Sơn trắng sữa Honda','son_trang_sua_honda.jpg','HH019',NULL),('HA021','Sơn đỏ ferrari','son_do_ferrari.jpeg','HH020',NULL),('HA022','Dung dịch vệ sinh nội thất Meguiar','ve_sinh_noi_that_Meguiar.jpg','HH021',NULL),('HA023','Bột tẩy bẩn Sonax','bot_tay_ban_Sonax.jpg','HH022',NULL),('HA024','Nước tẩy rửa da Chemical Guys','nuoc_tay_rua_da_Chemical_Guys.jpg','HH023',NULL),('HA025','Dầu dưỡng da Leather Honey','dau_duong_da_Leather_Honey.jpg','HH024',NULL),('HA026','Bóng đèn halogen Philips','bong_den_halogen_Philips.jpg','HH025',NULL),('HA027','Bóng đèn LED Osram','bong_den_LED_Osram.jpg','HH026',NULL),('HA028','Bộ điều khiển động cơ ECU Bosch','bo_dieu_khien_dong_co_ECU_Bosch.jpg','HH027',NULL),('HA029','Dây điện dẹt 2.5mm²','day_dien_det2.5.jpg','HH028',NULL),('HA030','Bộ lốp và rotơ trước Brembo','bo_lop_va_roto_truoc_Brembo.jpg','HH029',NULL),('HA031','Dầu thắng Castrol DOT 4','dau_thang_Castrol_DOT_4.png','HH030',NULL),('HA032','Dây phanh dầu trước ATE','day_phanh_dau_truoc_ATE.jpg','HH031',NULL),('HA033','Dây phanh sau Brembo','day_phanh_sau_Brembo.jpg','HH032',NULL),('HA034','Dầu hộp số tự động Mobil 1','dau_hop_so_tu_dong_Mobil_1.jpg','HH033',NULL),('HA035','Dầu hộp số tự động Toyota ATF WS','dau_hop_so_tu_dong_Toyota_ATF_WS.jpg','HH034',NULL),('HA036','Dầu hộp số tự động Honda ATF DW1','dau_hop_so_tu_dong_Honda_ATF_DW1.jpg','HH035',NULL),('HA037','Dầu hộp số tự động Nissan Matic S','dau_hop_so_tu_dong_Nissan_Matic_S.jpg','HH036',NULL),('HA038','Bơm dầu lái trợ lực Bosch','bom_dau_lai_tro_luc_Bosch.jpg','HH037',NULL),('HA039','Dây lái điện ô tô','day_lai_dien_oto.jpg','HH038',NULL),('HA040','Cụm cầu lái trước Toyota','cum_cai_lai_truoc_Toyota.jpg','HH039',NULL),('HA041','Vòi nước lái ô tô','voi_nuoc_lai_oto.jpg','HH040',NULL),('HA042','Nước làm mát Prestone','nuoc_lam_mat_Prestone.jpg','HH041',NULL),('HA043','Quạt làm mát Denso','quat_lam_mat_Denso.jpeg','HH042',NULL),('HA044','Đèn báo nhiệt độ nước làm mát','den_bao_nhiet_do_nuoc_lam_mat.jpg','HH043',NULL),('HA045','Vòi phun nước làm mát','voi-phun-nuoc-lam-mat.jpg','HH044',NULL),('HA046','Cảm biến O2 Bosch','cam_bien_oxi_Bosch.png','HH045',NULL),('HA047','Bộ van EGR Pierburg','bo_van_EGR_Pierburg.jpg','HH046',NULL),('HA048','Ống xả ô tô','ong_xa_oto.jpg','HH047',NULL),('HA049','Kích hoạt ator bảo vệ động cơ','kich_hoat_ato_bao_ve_dong_co.png','HH048',NULL),('HA050','Giảm xóc KYB','giam_xoc_KYB.jpg','HH049',NULL),('HA051','Lò xo treo ô tô','lo_xo_treo_oto.jpg','HH050',NULL),('HA052','Bạc đạn trục giảm chấn','bac_dan_giam_chan.jpg','HH051',NULL),('HA053','Bản lề cửa ô tô','ban_le_cua_oto.jpg','HH052',NULL),('HA054','Nước làm mát Zerex','nuoc-lam-mat-oto-zerex-blue.jpg','HH053',NULL),('HA055','Bình chứa nước làm mát','binh_nuoc_lam_mat_oto.jpg','HH054',NULL),('HA056','Bơm nước làm mát Điện lực','binh_nuoc_lam_mat_oto.jpg','HH055',NULL),('HA057','Nắp bình nước làm mát','nap_binh_nuoc_lam_mat.jpg','HH056',NULL),('HA058','Pin ắc quy GS','pin_ac_quy_GS.jpg','HH057',NULL),('HA059','Pin ắc quy Panasonic','pin_ac_quy_Panasonic.jpg','HH058',NULL),('HA060','Kẹp pin ắc quy','kep_pin_ac_quy.jpg','HH059',NULL),('HA0601','aa','415756740_278442738551694_6575643374033248150_n.jpg','HH061',NULL),('HA061','Dây dẫn nối pin ắc quy','day_dan_noi_binh_ac_quy.jpg','HH060',NULL),('HA0611','aa','thiet-ke-phong-net-6.jpg','HH061',NULL),('HA0621','aa','343808602_1308587203370983_6810021877347918128_n.jpg','HH061',NULL),('HA064','Phạm Văn Chiêu','Screenshot 2022-04-25 220052.jpg',NULL,'NV003'),('HA065','Trần Luyện','image2.jpg',NULL,'NV002'),('HA066','Nguyễn Văn Giang','339296571_963065158034356_4229750286134670840_n.jpg',NULL,'NV007'),('HA067','Dương Chí Khang','438222129_1461564554714961_1092338726809871324_n.jpg',NULL,'NV012');
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
  `ghi_chu` varchar(500) DEFAULT NULL,
  `ma_chi_nhanh` varchar(255) DEFAULT NULL,
  `lich_su_hoa_don` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_hoa_don`),
  KEY `FKnuqkgajew2traqcy7umgm7i1g` (`ma_khach_hang`),
  KEY `FKpu3pgvm4uiwlce2obab169949` (`ma_nha_cung_cap`),
  KEY `FKsh87ilak874fkwk9pw28pafx7` (`ma_nhan_vien`),
  KEY `fk_ma_phieu_tra_hang_hoa_don` (`ma_phieu_tra_hang`),
  KEY `hoa_don_chi_nhanh` (`ma_chi_nhanh`),
  CONSTRAINT `FKnuqkgajew2traqcy7umgm7i1g` FOREIGN KEY (`ma_khach_hang`) REFERENCES `khach_hang` (`ma_khach_hang`),
  CONSTRAINT `FKpu3pgvm4uiwlce2obab169949` FOREIGN KEY (`ma_nha_cung_cap`) REFERENCES `nha_cung_cap` (`ma_nha_cung_cap`),
  CONSTRAINT `FKsh87ilak874fkwk9pw28pafx7` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `fk_ma_phieu_tra_hang_hoa_don` FOREIGN KEY (`ma_phieu_tra_hang`) REFERENCES `phieu_tra_hang` (`ma_phieu_tra_hang`),
  CONSTRAINT `hoa_don_chi_nhanh` FOREIGN KEY (`ma_chi_nhanh`) REFERENCES `chi_nhanh` (`ma_chi_nhanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
INSERT INTO `hoa_don` VALUES ('HD001',0,'Thu','2023-01-01 10:00:00.000000',1500000,1500000,'Đã thanh toán','KH001',NULL,'NV004',NULL,'','CN001',NULL),('HD002',0,'Chi','2023-01-02 11:30:00.000000',800000,800000,'Đã thanh toán',NULL,'NCC004','NV004',NULL,NULL,'CN001',NULL),('HD003',200000,'Thu','2023-01-03 14:45:00.000000',2000000,2000000,'Đã thanh toán','KH002',NULL,'NV004',NULL,'Khách hàng yêu cầu kiểm hàng 2 lần','CN001',NULL),('HD004',0,'Thu','2023-01-04 09:15:00.000000',500000,500000,'Đã thanh toán','KH003',NULL,'NV005',NULL,'','CN001',NULL),('HD005',300000,'Chi','2023-01-05 13:20:00.000000',3000000,3000000,'Đã thanh toán',NULL,'NCC002','NV005',NULL,'','CN001',NULL),('HD006',0,'Chi','2023-01-06 08:30:00.000000',1000000,1000000,'Đã thanh toán',NULL,'NCC001','NV005',NULL,'','CN001',NULL),('HD007',0,'Thu','2023-01-07 10:45:00.000000',1200000,1200000,'Đã thanh toán','KH004',NULL,'NV004',NULL,'','CN001',NULL),('HD008',150000,'Thu','2023-01-08 12:00:00.000000',1800000,1800000,'Đã thanh toán','KH005',NULL,'NV004',NULL,'','CN001',NULL),('HD009',0,'Chi','2023-01-09 15:10:00.000000',600000,600000,'Đã thanh toán',NULL,'NCC005','NV005',NULL,'','CN001',NULL),('HD010',0,'Chi','2023-01-10 09:30:00.000000',900000,900000,'Đã thanh toán',NULL,'NCC001','NV005',NULL,'','CN001',NULL),('HD011',200000,'Thu','2023-01-11 14:00:00.000000',2500000,2500000,'Đã thanh toán','KH006',NULL,'NV004',NULL,NULL,'CN001',NULL),('HD012',0,'Thu','2023-01-12 11:20:00.000000',700000,700000,'Đã thanh toán','KH007',NULL,'NV004',NULL,NULL,'CN001',NULL),('HD013',300000,'Chi','2023-01-13 10:05:00.000000',3500000,3500000,'Đã thanh toán',NULL,'NCC004','NV005',NULL,NULL,'CN001',NULL),('HD014',0,'Thu','2023-01-14 08:40:00.000000',800000,800000,'Đã thanh toán','KH008',NULL,'NV004',NULL,NULL,'CN001',NULL),('HD015',0,'Chi','2023-01-15 12:50:00.000000',2000000,2000000,'Đã thanh toán',NULL,'NCC003','NV005',NULL,NULL,'CN001',NULL),('HD016',100000,'Chi','2023-01-16 09:55:00.000000',1100000,1100000,'Đã thanh toán',NULL,'NCC001','NV004',NULL,NULL,'CN001',NULL),('HD017',0,'Thu','2023-01-17 14:25:00.000000',900000,900000,'Đã thanh toán','KH009',NULL,'NV005',NULL,'','CN001',NULL),('HD018',250000,'Thu','2023-01-18 10:35:00.000000',3000000,3000000,'Đã thanh toán','KH010',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD019',0,'Chi','2023-01-19 11:15:00.000000',400000,400000,'Đã thanh toán',NULL,'NCC002','NV004',NULL,NULL,'CN001',NULL),('HD020',100000,'Thu','2023-01-20 13:40:00.000000',1500000,1500000,'Đã thanh toán','KH011',NULL,'NV004',NULL,NULL,'CN001',NULL),('HD021KH004',5,'Thu','2024-04-03 16:19:46.000000',340000,340000,'Đã thanh toán','KH004',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD022KH001',5,'Thu','2024-04-03 21:58:38.000000',370000,370000,'Đã thanh toán','KH001',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD023KH001',0,'Thu','2024-04-03 22:03:32.000000',120000,120000,'Đã thanh toán','KH001',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD024KH001',0,'Thu','2024-04-03 22:06:13.000000',2110000,2110000,'Đã thanh toán','KH001',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD025KH001',0,'Thu','2024-04-03 22:09:27.000000',250000,250000,'Đã thanh toán','KH001',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD026KH001',5,'Thu','2024-04-03 22:11:34.000000',2120000,2120000,'Đã thanh toán','KH001',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD027KH001',4,'Thu','2024-04-03 22:20:00.000000',2120000,2120000,'Đã thanh toán','KH001',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD028KH001',0,'Thu','2024-04-04 10:33:20.000000',2130000,2130000,'Đã thanh toán','KH001',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD029KH001',0,'Thu','2024-04-04 10:36:10.000000',2130000,2130000,'Đã thanh toán','KH001',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD030KH007',0,'Thu','2024-04-04 11:12:39.000000',240000,240000,'Đã thanh toán','KH007',NULL,'NV005',NULL,NULL,'CN001',NULL),('HD031KH001',0,'Thu','2024-04-09 06:57:25.000000',3900000,3900000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD032KH001',0,'Thu','2024-04-09 07:13:36.000000',7530000,7530000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD033KH001',0,'Thu','2024-04-09 07:41:33.000000',7500000,7500000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD034KH003',0,'Thu','2024-04-09 07:44:46.000000',130000,130000,'Hoàn thành','KH003',NULL,'NV005',NULL,'',NULL,NULL),('HD035KH001',0,'Thu','2024-04-09 07:51:28.000000',130000,130000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD036KH001',0,'Thu','2024-04-09 07:54:48.000000',130000,130000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD037KH001',0,'Thu','2024-04-09 07:56:50.000000',260000,260000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD038KH004',0,'Thu','2024-04-10 07:13:12.000000',2200000,2200000,'Hoàn thành','KH004',NULL,'NV005',NULL,NULL,NULL,NULL),('HD039KH001',0,'Thu','2024-04-10 07:15:12.000000',3900000,3900000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD040KH001',0,'Thu','2024-04-10 08:45:29.000000',1930000,1930000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD041KH001',0,'Thu','2024-04-10 08:54:59.000000',130000,130000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD042KH001',0,'Thu','2024-04-10 09:03:52.000000',2330000,2330000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD043KH001',0,'Thu','2024-04-10 09:22:38.000000',8700000,8700000,'Hoàn thành','KH001',NULL,'NV005',NULL,NULL,NULL,NULL),('HD044KH004',0,'Thu','2024-04-18 09:39:20.000000',1900000,1900000,'Hoàn thành','KH004',NULL,'NV005',NULL,NULL,'CN001',NULL);
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
  `ten_hang_hoa` varchar(255) DEFAULT NULL,
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
INSERT INTO `hoa_don_chi_tiet` VALUES ('HD001_CT001',500000,0,1,500000,'HH001','HD001','Nhớt Mobil'),('HD001_CT002',1000000,0,1,1000000,'HH004','HD001','Nhớt Motul'),('HD001_CT003',2000000,0,1,2000000,'HH010','HD001','Bộ lọc nhớt Mann'),('HD002_CT001',1000000,0,1,1000000,'HH002','HD002','Nhớt Castrol'),('HD002_CT002',2000000,0,1,2000000,'HH003','HD002','Nhớt Total'),('HD002_CT003',3000000,0,1,3000000,'HH005','HD002','Lốp Michelin'),('HD003_CT001',500000,0,1,500000,'HH012','HD003','Bộ lọc không khí K&N'),('HD003_CT002',1000000,0,1,1000000,'HH019','HD003','Sơn trắng sữa Honda'),('HD003_CT003',2000000,0,1,2000000,'HH003','HD003','Nhớt Total'),('HD004_CT001',500000,0,1,500000,'HH011','HD004','Bộ lọc nhiên liệu Fram'),('HD004_CT002',1000000,0,1,1000000,'HH012','HD004','Bộ lọc không khí K&N'),('HD004_CT003',2000000,0,1,2000000,'HH014','HD004','Bơm nhiên liệu Denso'),('HD005_CT001',500000,0,1,500000,'HH016','HD005','Dây curoa Gates'),('HD005_CT002',1000000,0,1,1000000,'HH012','HD005','Bộ lọc không khí K&N'),('HD005_CT003',2000000,0,1,2000000,'HH010','HD005','Bộ lọc nhớt Mann'),('HD006_CT001',500000,0,1,500000,'HH001','HD006','Nhớt Mobil'),('HD006_CT002',1000000,0,1,1000000,'HH008','HD006','Lốp Pirelli'),('HD006_CT003',2000000,0,1,2000000,'HH019','HD006','Sơn trắng sữa Honda'),('HD007_CT001',500000,0,1,500000,'HH044','HD007','Vòi phun nước làm mát'),('HD007_CT002',1000000,0,1,1000000,'HH033','HD007','Dầu hộp số tự động Mobil 1'),('HD007_CT003',2000000,0,1,2000000,'HH029','HD007','Bộ lốp và rotơ trước Brembo'),('HD008_CT001',500000,0,1,500000,'HH012','HD008','Bộ lọc không khí K&N'),('HD008_CT002',1000000,0,1,1000000,'HH028','HD008','Dây điện dẹt 2.5mm²'),('HD008_CT003',2000000,0,1,2000000,'HH020','HD008','Sơn đỏ ferrari'),('HD009_CT001',500000,0,1,500000,'HH036','HD009','Dầu hộp số tự động Nissan Matic S'),('HD009_CT002',1000000,0,1,1000000,'HH045','HD009','Cảm biến O2 Bosch'),('HD009_CT003',2000000,0,1,2000000,'HH047','HD009','Ống xả ô tô'),('HD010_CT001',500000,0,1,500000,'HH012','HD010','Bộ lọc không khí K&N'),('HD010_CT002',1000000,0,1,1000000,'HH006','HD010','Lốp Bridgestone'),('HD010_CT003',2000000,0,1,2000000,'HH049','HD010','Giảm xóc KYB'),('HD011_CT001',500000,0,1,500000,'HH051','HD011','Bạc đạn trục giảm chấn'),('HD011_CT002',1000000,0,1,1000000,'HH053','HD011','Nước làm mát Zerex'),('HD011_CT003',2000000,0,1,2000000,'HH056','HD011','Nắp bình nước làm mát'),('HD012_CT001',500000,0,1,500000,'HH060','HD012','Dây dẫn nối pin ắc quy'),('HD012_CT002',1000000,0,1,1000000,'HH057','HD012','Pin ắc quy GS'),('HD012_CT003',2000000,0,1,2000000,'HH042','HD012','Quạt làm mát Denso'),('HD013_CT001',500000,0,1,500000,'HH034','HD013','Dầu hộp số tự động Toyota ATF WS'),('HD013_CT002',1000000,0,1,1000000,'HH033','HD013','Dầu hộp số tự động Mobil 1'),('HD013_CT003',2000000,0,1,2000000,'HH012','HD013','Bộ lọc không khí K&N'),('HD014_CT001',500000,0,1,500000,'HH007','HD014','Lốp Goodyear'),('HD014_CT002',1000000,0,1,1000000,'HH008','HD014','Lốp Pirelli'),('HD014_CT003',2000000,0,1,2000000,'HH032','HD014','Dây phanh sau Brembo'),('HD015_CT001',500000,0,1,500000,'HH042','HD015','Quạt làm mát Denso'),('HD015_CT002',1000000,0,1,1000000,'HH049','HD015','Giảm xóc KYB'),('HD015_CT003',2000000,0,1,2000000,'HH048','HD015','Kích hoạt ator bảo vệ động cơ'),('HD016_CT001',500000,0,1,500000,'HH024','HD016','Dầu dưỡng da Leather Honey'),('HD016_CT002',1000000,0,1,1000000,'HH014','HD016','Bơm nhiên liệu Denso'),('HD016_CT003',2000000,0,1,2000000,'HH023','HD016','Nước tẩy rửa da Chemical Guys'),('HD017_CT001',500000,0,1,500000,'HH045','HD017','Cảm biến O2 Bosch'),('HD017_CT002',1000000,0,1,1000000,'HH021','HD017','Dung dịch vệ sinh nội thất Meguiar'),('HD017_CT003',2000000,0,1,2000000,'HH054','HD017','Bình chứa nước làm mát'),('HD018_CT001',500000,0,1,500000,'HH036','HD018','Dầu hộp số tự động Nissan Matic S'),('HD018_CT002',1000000,0,1,1000000,'HH047','HD018','Ống xả ô tô'),('HD018_CT003',2000000,0,1,2000000,'HH020','HD018','Sơn đỏ ferrari'),('HD019_CT001',500000,0,1,500000,'HH012','HD019','Bộ lọc không khí K&N'),('HD019_CT002',1000000,0,1,1000000,'HH048','HD019','Kích hoạt ator bảo vệ động cơ'),('HD019_CT003',2000000,0,1,2000000,'HH034','HD019','Dầu hộp số tự động Toyota ATF WS'),('HD020_CT001',500000,0,1,500000,'HH048','HD020','Kích hoạt ator bảo vệ động cơ'),('HD020_CT002',1000000,0,1,1000000,'HH046','HD020','Bộ van EGR Pierburg'),('HD020_CT003',2000000,0,1,2000000,'HH026','HD020','Bóng đèn LED Osram'),('HD021KH004CT00',120000,0,1,120000,'HH002','HD021KH004','Nhớt Castrol'),('HD021KH004CT01',110000,0,2,220000,'HH003','HD021KH004','Nhớt Total'),('HD022KH001CT00',110000,0,1,110000,'HH003','HD022KH001','Nhớt Total'),('HD022KH001CT01',130000,0,2,260000,'HH004','HD022KH001','Nhớt Motul'),('HD023KH001CT00',120000,0,1,120000,'HH002','HD023KH001','Nhớt Castrol'),('HD024KH001CT00',110000,0,1,110000,'HH003','HD024KH001','Nhớt Total'),('HD024KH001CT01',2000000,0,1,2000000,'HH005','HD024KH001','Lốp Michelin'),('HD025KH001CT00',120000,0,1,120000,'HH002','HD025KH001','Nhớt Castrol'),('HD025KH001CT01',130000,0,1,130000,'HH004','HD025KH001','Nhớt Motul'),('HD026KH001CT00',120000,0,1,120000,'HH002','HD026KH001','Nhớt Castrol'),('HD026KH001CT01',2000000,0,1,2000000,'HH005','HD026KH001','Lốp Michelin'),('HD027KH001CT00',120000,0,1,120000,'HH002','HD027KH001','Nhớt Castrol'),('HD027KH001CT01',2000000,0,1,2000000,'HH005','HD027KH001','Lốp Michelin'),('HD028KH001CT00',130000,0,1,130000,'HH004','HD028KH001','Nhớt Motul'),('HD028KH001CT01',2000000,0,1,2000000,'HH005','HD028KH001','Lốp Michelin'),('HD029KH001CT00',130000,0,1,130000,'HH004','HD029KH001','Nhớt Motul'),('HD029KH001CT01',2000000,0,1,2000000,'HH005','HD029KH001','Lốp Michelin'),('HD030KH007CT00',110000,0,1,110000,'HH003','HD030KH007','Nhớt Total'),('HD030KH007CT01',130000,0,1,130000,'HH004','HD030KH007','Nhớt Motul'),('HD031KH001CT00',2000000,0,1,2000000,'HH005','HD031KH001','Lốp Michelin'),('HD031KH001CT01',1900000,0,1,1900000,'HH007','HD031KH001','Lốp Goodyear'),('HD032KH001CT00',130000,0,1,130000,'HH004','HD032KH001','Nhớt Motul'),('HD032KH001CT01',2000000,0,1,2000000,'HH005','HD032KH001','Lốp Michelin'),('HD032KH001CT02',1800000,0,3,5400000,'HH006','HD032KH001','Lốp Bridgestone'),('HD033KH001CT00',1800000,0,1,1800000,'HH006','HD033KH001','Lốp Bridgestone'),('HD033KH001CT01',1900000,0,3,5700000,'HH007','HD033KH001','Lốp Goodyear'),('HD034KH003CT00',130000,0,1,130000,'HH004','HD034KH003','Nhớt Motul'),('HD035KH001CT00',130000,0,1,130000,'HH004','HD035KH001','Nhớt Motul'),('HD036KH001CT00',130000,0,1,130000,'HH004','HD036KH001','Nhớt Motul'),('HD037KH001CT00',130000,0,2,260000,'HH004','HD037KH001','Nhớt Motul'),('HD039KH001CT00',2000000,0,1,2000000,'HH005','HD039KH001','Lốp Michelin'),('HD039KH001CT01',1900000,0,1,1900000,'HH007','HD039KH001','Lốp Goodyear'),('HD040KH001CT00',1800000,0,1,1800000,'HH006','HD040KH001','Lốp Bridgestone'),('HD040KH001CT01',130000,0,1,130000,'HH004','HD040KH001','Nhớt Motul'),('HD041KH001CT00',130000,0,1,130000,'HH004','HD041KH001','Nhớt Motul'),('HD042KH001CT00',130000,0,1,130000,'HH004','HD042KH001','Nhớt Motul'),('HD042KH001CT01',2200000,0,1,2200000,'HH008','HD042KH001','Lốp Pirelli'),('HD043KH001CT00',1800000,0,1,1800000,'HH006','HD043KH001','Lốp Bridgestone'),('HD043KH001CT01',2200000,0,3,6600000,'HH008','HD043KH001','Lốp Pirelli'),('HD043KH001CT02',300000,0,1,300000,'HH009','HD043KH001','Bộ lọc gió Bosch'),('HD044KH004CT00',100000,0,1,100000,'HH001','HD044KH004','Nhớt Mobil'),('HD044KH004CT01',1800000,0,1,1800000,'HH006','HD044KH004','Lốp Bridgestone');
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
  `ngay_sinh` date DEFAULT NULL,
  `ngay_tao` datetime(6) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_khach_hang` varchar(255) DEFAULT NULL,
  `tong_ban` double DEFAULT NULL,
  `tong_no` double DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  `gioi_tinh` varchar(255) DEFAULT 'Nam',
  `loai_khach` varchar(255) DEFAULT 'Cá nhân',
  `ma_chi_nhanh` varchar(255) DEFAULT 'CN001',
  PRIMARY KEY (`ma_khach_hang`),
  KEY `FKip8bppn8gjt3u3lescd3k2pi4` (`ma_nhan_vien`),
  KEY `khach_hang_chi_nhanh` (`ma_chi_nhanh`),
  CONSTRAINT `FKip8bppn8gjt3u3lescd3k2pi4` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `khach_hang_chi_nhanh` FOREIGN KEY (`ma_chi_nhanh`) REFERENCES `chi_nhanh` (`ma_chi_nhanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES ('KH001','123 Đường ABC, Quận 1, TP.HCM','nguyenvana@example.com','123456789','1990-01-01','2023-01-01 10:00:00.000000','0987654321','Nguyễn Văn An',1500000,0,'NV004','Nam','Cá nhân','CN001'),('KH002','456 Đường XYZ, Quận 2, TP.HCM','tranthib@example.com','987654321','1985-05-15','2023-01-02 11:30:00.000000','0123456789','Trần Thị Bình',800000,0,'NV004','Nam','Cá nhân','CN001'),('KH003','789 Đường MNO, Quận 3, TP.HCM','levanc@example.com','135792468','1992-03-20','2023-01-03 14:45:00.000000','0987123456','Lê Văn Chiến',2000000,200000,'NV004','Nam','Cá nhân','CN001'),('KH004','0123 Đường DEF, Quận 4, TP.HCM','phamthid@example.com','246813579','2002-12-10','2023-01-04 09:15:00.000000','0967123456','Phạm Thị Dương',500000,0,'NV005','Nữ','Cá nhân','CN001'),('KH005','456 Đường GHI, Quận 5, TP.HCM','hoangvane@example.com','369258147','1995-08-25','2023-01-05 13:20:00.000000','0987654321','Hoàng Văn Én',3000000,300000,'NV005','Nam','Cá nhân','CN001'),('KH006','789 Đường KLM, Quận 6, TP.HCM','tranvanf@example.com','975310486','1991-07-05','2023-01-06 08:30:00.000000','0987123456','Trần Văn Phú',1000000,0,'NV004','Nam','Cá nhân','CN001'),('KH007','123 Đường NOP, Quận 7, TP.HCM','nguyenthig@example.com','864203951','1987-09-15','2023-01-07 10:45:00.000000','0967123456','Nguyễn Thị Giang',1200000,0,'NV004','Nam','Cá nhân','CN001'),('KH008','456 Đường QRS, Quận 8, TP.HCM','phanvanh@example.com','753196482','1994-04-30','2023-01-08 12:00:00.000000','0987654321','Phan Văn Hòa',1800000,150000,'NV005','Nam','Cá nhân','CN001'),('KH009','789 Đường TUV, Quận 9, TP.HCM','lythi@example.com','642087513','1989-11-20','2023-01-09 15:10:00.000000','0123456789','Lý Thị Yến',600000,0,'NV005','Nam','Cá nhân','CN001'),('KH010','0123 Đường WXY, Quận 10, TP.HCM','dangvank@example.com','531974820','1996-06-10','2023-01-10 09:30:00.000000','0987123456','Đặng Văn Kiên',900000,0,'NV004','Nam','Cá nhân','CN001'),('KH011','456 Đường ZAB, Quận 11, TP.HCM','buithil@example.com','420865139','1993-02-05','2023-01-11 14:00:00.000000','0967123456','Bùi Thị Lý',2500000,200000,'NV004','Nam','Cá nhân','CN001'),('KH012','123 Đường BCD, Quận 12, TP.HCM','nguyenvanm@example.com','309751824','1990-10-15','2023-01-12 11:20:00.000000','0987654321','Nguyễn Văn Minh',700000,0,'NV005','Nam','Cá nhân','CN001'),('KH013','456 Đường EFG, Quận Bình Tân, TP.HCM','tranthin@example.com','198642037','1986-08-20','2023-01-13 10:05:00.000000','0123456789','Trần Thị Như',3500000,300000,'NV004','Nam','Cá nhân','CN001'),('KH014','789 Đường HIJ, Quận Bình Chánh, TP.HCM','levano@example.com','087529314','1991-06-01','2023-01-14 08:40:00.000000','0987123456','Lê Văn Ôn',800000,0,'NV005','Nam','Cá nhân','CN001'),('KH015','0123 Đường KLM, Quận Thủ Đức, TP.HCM','phamthip@example.com','976420831','1988-04-05','2023-01-15 12:50:00.000000','0967123456','Phạm Thị Phương',2000000,0,'NV005','Nam','Cá nhân','CN001'),('KH016','456 Đường NOP, Quận Gò Vấp, TP.HCM','hoangvanq@example.com','865309472','1995-02-25','2023-01-16 09:55:00.000000','0987654321','Hoàng Văn Qúy',1100000,100000,'NV004','Nam','Cá nhân','CN001'),('KH017','789 Đường QRS, Quận Phú Nhuận, TP.HCM','tranthir@example.com','753186204','1987-12-10','2023-01-17 14:25:00.000000','0123456789','Trần Thị Riềng',900000,0,'NV004','Nam','Cá nhân','CN001'),('KH018','123 Đường TUV, Quận Tân Bình, TP.HCM','nguyenvans@example.com','642097531','1994-10-05','2023-01-18 10:35:00.000000','0967123456','Nguyễn Văn Sang',3000000,250000,'NV005','Nam','Cá nhân','CN001'),('KH019','456 Đường WXY, Quận Tân Phú, TP.HCM','phanthit@example.com','531874260','1989-08-15','2023-01-19 11:15:00.000000','0987654321','Phan Thị Thư',400000,0,'NV005','Nam','Cá nhân','CN001'),('KH020','789 Đường ZAB, Quận Bình Thạnh, TP.HCM','lyvanu@example.com','420963187','1996-05-30','2023-01-20 13:40:00.000000','0123456789','Lý Văn Uyên',1500000,100000,'NV004','Nam','Cá nhân','CN001'),('KH021','84, thôn 1, xã Đạ Oai, huyện Đạ Huoai, tỉnh Lâm Đồng','voduc0100@gmail.com','005615489','2024-04-06','2024-04-02 11:57:35.000000','086990187','Võ Văn Đức',0,0,'NV004','Nam','Cá nhân','CN001'),('KH022','Thôn 1, xã Đạ Oai, huyện Đạ Huoai, tỉnh Lâm Đồng','dinhphongdaoai@gmail.com','0068415531','2002-04-11','2024-04-20 13:35:34.000000','0869990187','Lê Đình Phong',0,0,'NV004','Nam','Cá nhân','CN001'),('KH023','Tân bình, HCM','duongtanbinh@gmail.com','0164598588','2002-04-18','2024-04-20 15:10:09.000000','0861584658','Dương Triệu Lâm',0,0,'NV004','Nữ','Cá nhân','CN001');
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
  `nghi_lam` bit(1) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `tang_ca` smallint(6) DEFAULT '0',
  `trang_thai` varchar(255) DEFAULT 'Đang diễn ra',
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_lich_lam_viec`),
  KEY `ma_nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `lich_lam_viec_ibfk_1` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lich_lam_viec`
--

LOCK TABLES `lich_lam_viec` WRITE;
/*!40000 ALTER TABLE `lich_lam_viec` DISABLE KEYS */;
INSERT INTO `lich_lam_viec` VALUES ('LLV000','Ca làm việc thường ngày',_binary '\0','2023-01-10','2023-01-10',0,'Đã trả lương','NV001'),('LLV001','Ca làm việc thường ngày',_binary '\0','2023-01-01','2023-01-01',0,'Đã trả lương','NV001'),('LLV002','Ca làm việc thường ngày',_binary '\0','2023-01-02','2023-01-02',0,'Đã trả lương','NV002'),('LLV003','Ca làm việc thường ngày',_binary '\0','2023-01-03','2023-01-03',0,'Đã trả lương','NV003'),('LLV004','Ca làm việc thường ngày',_binary '\0','2023-01-04','2023-01-04',0,'Đã trả lương','NV004'),('LLV005','Ca làm việc thường ngày',_binary '\0','2023-01-05','2023-01-05',0,'Đã trả lương','NV005'),('LLV006','Ca làm việc thường ngày',_binary '\0','2023-01-06','2023-01-06',0,'Đã trả lương','NV006'),('LLV007','Ca làm việc thường ngày',_binary '\0','2023-01-07','2023-01-07',0,'Đã trả lương','NV007'),('LLV008','Ca làm việc thường ngày',_binary '\0','2023-01-08','2023-01-08',0,'Đã trả lương','NV008'),('LLV009','Ca làm việc thường ngày',_binary '\0','2023-01-09','2023-01-09',0,'Đã trả lương','NV009'),('LLV010','Ca làm việc thường ngày',_binary '\0','2023-01-10','2023-01-10',0,'Đã trả lương','NV010'),('LLV011','Nghỉ quốc khánh',_binary '','2023-09-02','2023-09-02',0,'Không','NV000'),('LLV012','Tăng ca',_binary '\0','2023-09-03','2023-09-03',2,'Đã trả lương','NV007'),('LLV013','Tăng ca',_binary '\0','2023-09-03','2023-09-03',2,'Đã trả lương','NV008'),('LLV014','Tăng ca',_binary '\0','2023-09-03','2023-09-03',2,'Đã trả lương','NV009'),('LLV015','Tăng ca',_binary '\0','2023-09-03','2023-09-03',2,'Đã trả lương','NV010'),('LLV016','Tăng ca',_binary '\0','2023-09-03','2023-09-03',2,'Đã trả lương','NV001'),('LLV017','Tăng ca',_binary '\0','2023-09-03','2023-09-03',2,'Đã trả lương','NV002'),('LLV018','Tăng ca',_binary '\0','2023-09-03','2023-09-03',2,'Đã trả lương','NV003'),('LLV019','Tăng ca',_binary '\0','2023-09-03','2023-09-03',2,'Đã trả lương','NV004'),('LLV020','Tăng ca',_binary '\0','2023-09-03','2023-09-03',2,'Đã trả lương','NV005'),('LLV022','Thực tập 2 tháng trước khi làm chính thức',_binary '\0','2024-04-26','2024-04-30',0,'Đang diễn ra','NV004'),('LLV023','tăng ca ngày nghỉ lễ 30/4 - 1/5',_binary '\0','2024-04-26','2024-04-30',0,'Đang diễn ra','NV002'),('LLV024','Tăng ca tối',_binary '\0','2024-04-26','2024-04-26',3,'Đang diễn ra','NV003'),('LLV025','Lịch làm việc tháng 5 2024',_binary '\0','2024-05-01','2024-05-31',0,'Đang diễn ra','NV002'),('LLV026','Lịch làm việc tháng 5',_binary '\0','2024-05-01','2024-05-31',0,'Đang diễn ra','NV004'),('LLV027','Ca làm việc thường ngày',_binary '\0','2024-05-01','2024-05-30',0,'Đang diễn ra','NV001'),('LLV028','Tăng ca sáng',_binary '\0','2024-05-01','2024-05-01',10,'Đang diễn ra','NV001');
/*!40000 ALTER TABLE `lich_lam_viec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lich_lam_viec_ca_lam`
--

DROP TABLE IF EXISTS `lich_lam_viec_ca_lam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lich_lam_viec_ca_lam` (
  `ma` varchar(255) NOT NULL,
  `ma_lich_lam_viec` varchar(255) DEFAULT NULL,
  `ma_ca_lam` varchar(255) DEFAULT NULL,
  `hoan_thanh` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `ma_lich_lam_viec` (`ma_lich_lam_viec`),
  KEY `ma_ca_lam` (`ma_ca_lam`),
  CONSTRAINT `lich_lam_viec_ca_lam_ibfk_1` FOREIGN KEY (`ma_lich_lam_viec`) REFERENCES `lich_lam_viec` (`ma_lich_lam_viec`),
  CONSTRAINT `lich_lam_viec_ca_lam_ibfk_2` FOREIGN KEY (`ma_ca_lam`) REFERENCES `ca_lam` (`ma_ca_lam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lich_lam_viec_ca_lam`
--

LOCK TABLES `lich_lam_viec_ca_lam` WRITE;
/*!40000 ALTER TABLE `lich_lam_viec_ca_lam` DISABLE KEYS */;
INSERT INTO `lich_lam_viec_ca_lam` VALUES ('LLVCL0001','LLV001','CAL001',_binary '\0'),('LLVCL0002','LLV001','CAL002',_binary '\0'),('LLVCL0003','LLV002','CAL001',_binary '\0'),('LLVCL0004','LLV002','CAL002',_binary '\0'),('LLVCL0007','LLV004','CAL001',_binary '\0'),('LLVCL0008','LLV004','CAL002',_binary '\0'),('LLVCL0009','LLV005','CAL001',_binary '\0'),('LLVCL0010','LLV005','CAL002',_binary '\0'),('LLVCL0011','LLV006','CAL001',_binary '\0'),('LLVCL0012','LLV006','CAL002',_binary '\0'),('LLVCL0013','LLV007','CAL001',_binary '\0'),('LLVCL0014','LLV007','CAL002',_binary '\0'),('LLVCL0015','LLV008','CAL001',_binary '\0'),('LLVCL0016','LLV008','CAL002',_binary '\0'),('LLVCL0017','LLV009','CAL003',_binary '\0'),('LLVCL0018','LLV010','CAL003',_binary '\0'),('LLVCL019','LLV022','CAL001',_binary '\0'),('LLVCL020','LLV022','CAL002',_binary '\0'),('LLVCL021','LLV023','CAL001',_binary '\0'),('LLVCL022','LLV023','CAL002',_binary '\0'),('LLVCL0LLV0262001','LLV026','CAL001',_binary '\0'),('LLVCL0LLV0262011','LLV026','CAL002',_binary '\0'),('LLVCL0LLV0272401','LLV027','CAL001',_binary '\0'),('LLVCL0LLV0272411','LLV027','CAL002',_binary '\0');
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
  `ma_chi_nhanh` varchar(255) DEFAULT 'CN001',
  PRIMARY KEY (`ma_nha_cung_cap`),
  KEY `FKf5u7s4s6dmvwrjkxqcx3d3xoa` (`ma_nhan_vien`),
  KEY `nha_cung_cap_chi_nhanh` (`ma_chi_nhanh`),
  CONSTRAINT `FKf5u7s4s6dmvwrjkxqcx3d3xoa` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `nha_cung_cap_chi_nhanh` FOREIGN KEY (`ma_chi_nhanh`) REFERENCES `chi_nhanh` (`ma_chi_nhanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nha_cung_cap`
--

LOCK TABLES `nha_cung_cap` WRITE;
/*!40000 ALTER TABLE `nha_cung_cap` DISABLE KEYS */;
INSERT INTO `nha_cung_cap` VALUES ('NCC001','123 Đường ABC, Quận XYZ, Thành phố HCM','abc@company.com','ABC123456','2023-01-01 08:00:00.000000','0123456789','Công ty TNHH ABC','NV004',0,20000000,'CN001'),('NCC002','456 Đường XYZ, Quận ABC, Thành phố Hà Nội','xyz@company.com','0485186538','2023-01-02 09:00:00.000000','0987654321','Công ty XYZ Ltd','NV004',200000,52000000,'CN001'),('NCC003','789 Đường MNO, Quận DEF, Thành phố Đà Nẵng','mno@company.com','MNO456789','2023-01-03 10:00:00.000000','0369852147','Công ty MNO','NV005',150000,30000000,'CN001'),('NCC004','101 Đường PQR, Quận GHI, Thành phố Cần Thơ','pqr@company.com','PQR987654','2023-01-04 11:00:00.000000','0246857319','Công ty PQR','NV005',0,15000000,'CN001'),('NCC005','111 Đường STU, Quận KLM, Thành phố Hải Phòng','stu@company.com','STU123456','2023-01-05 12:00:00.000000','0379514682','Công ty STU','NV005',0,60000000,'CN001'),('NCC06','Dĩ An, Bình Dương','binhlamoto@gmail.com','065464891','2024-04-20 16:52:12.000000','0165164866','Nhà cung cấp công cụ sữa chữa oto Bình Lâm','NV004',NULL,NULL,'CN001');
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
  `ngay_bat_dau_lam_viec` date DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_nhan_vien` varchar(255) DEFAULT NULL,
  `ma_chi_nhanh` varchar(255) DEFAULT NULL,
  `tao_boi_ma_nhan_vien` varchar(255) DEFAULT NULL,
  `ma_lich_lam_viec` varchar(255) DEFAULT NULL,
  `no_luong` double DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `ma_so_thue` varchar(255) DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT 'Đang làm việc',
  PRIMARY KEY (`ma_nhan_vien`),
  UNIQUE KEY `UK_ie7b5kt6wc752x7tvm3sj1ja2` (`ma_lich_lam_viec`),
  KEY `FKb11u6kme9duvp5351r3b1d809` (`ma_chi_nhanh`),
  KEY `FK890nxbbbytqoal27svt7biq4b` (`tao_boi_ma_nhan_vien`),
  KEY `chuc_danh` (`chuc_danh`),
  CONSTRAINT `FK890nxbbbytqoal27svt7biq4b` FOREIGN KEY (`tao_boi_ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `FKb11u6kme9duvp5351r3b1d809` FOREIGN KEY (`ma_chi_nhanh`) REFERENCES `chi_nhanh` (`ma_chi_nhanh`),
  CONSTRAINT `FKrh75p9tnv7nhdyb6hp7y1u07g` FOREIGN KEY (`ma_lich_lam_viec`) REFERENCES `lich_lam_viec` (`ma_lich_lam_viec`),
  CONSTRAINT `nhan_vien_ibfk_1` FOREIGN KEY (`chuc_danh`) REFERENCES `cong_viec` (`ma_cong_viec`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES ('NV000','068202006801','CV001','Nam','2020-01-01','2002-11-02','0869990187','Võ Văn Đức','CN001','NV000','LLV000',0,'216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức','0616361535','Đang làm việc'),('NV001','123456789','CV002','Nam','2020-01-01','1990-01-01','0123456789','Nguyễn Văn Anh','CN001','NV004','LLV001',0,'269 Linh Đông, Phường Linh Đông, Quận Thủ Đức','1611512165','Đang làm việc'),('NV002','234567890','CV003','Nam','2019-12-15','1992-02-02','0987654321','Trần Luyện','CN001','NV004','LLV002',0,'Chợ Bình Phước, Quốc lộ 13 cũ, Quận Thủ Đức','0513186153','Đang làm việc'),('NV003','345678901','CV004','Nam','2021-03-10','1995-03-03','0369852147','Phạm Văn Chiêu','CN001','NV004','LLV003',0,'996 Phạm Văn Đồng, Phường Hiệp Bình Chánh, Quận Thủ Đức','8946513150','Đang làm việc'),('NV004','456789012','CV005','Nữ','2020-06-20','2000-04-04','0246857319','Hoàng Thị Diệu','CN001','NV000','LLV004',0,'663 Tô Ngọc Vân, Phường Tam Bình, Quận Thủ Đức','1132511613','Đang làm việc'),('NV005','567890123','CV005','Nữ','2018-09-05','1993-05-05','0379514682','Tuyết Tuyết Nhi','CN001','NV000','LLV005',0,'42 Dân Chủ, Phường Bình Thọ, Quận Thủ Đức','0562323287','Đang làm việc'),('NV006','678901234','CV002','Nam','2019-11-30','1997-06-06','0987654321','Lê Điển Tịch','CN001','NV005','LLV006',0,'27 Thống Nhất, Phường Bình Thọ, Quận Thủ Đức','0321815314','Đang làm việc'),('NV007','789012345','CV002','Nam','2021-01-15','1991-07-07','0369852147','Nguyễn Văn Giang','CN001','NV004','LLV007',1000000,'17 Quang Trung, Quận Thủ Đức','0231315514','Đang làm việc'),('NV008','890123456','CV002','Nam','2019-07-05','1994-08-08','0246857319','Trần Trúc Huyên','CN001','NV004','LLV008',2000000,'11 Bác Ái, Quận Thủ Đức','0168644348','Đang làm việc'),('NV009','901234567','CV002','Nam','2022-04-18','1989-09-09','0379514682','Phạm Văn Linh','CN001','NV005','LLV009',0,'200 Hoàng Diệu 2, Phường Linh Chiểu, Quận Thủ Đức','0131654897','Đang làm việc'),('NV010','012345678','CV002','Nam','2018-11-25','1996-10-10','0987654321','Võ Tòng','CN001','NV005','LLV010',0,' 46 Cây Keo, Phường Tam Phú, Quận Thủ Đức','1351489645','Đang làm việc'),('NV012','015648645','CV004','Nam','2024-04-24','1998-04-25','053154646','Dương Chí Khang','CN04','NV004',NULL,0,'số 12, đường Cây Xa Dề, phường Đông Hòa, thành phố Dĩ An, tỉnh Bình Dương','01564345','Ngừng làm việc');
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
  `dich_vu_lien_quan` varchar(255) DEFAULT NULL,
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
  `tong_luong` double DEFAULT NULL,
  `ngay_in` datetime(6) DEFAULT NULL,
  `ma_nhan_vien_in` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_phieu`),
  KEY `ma_nhan_vien_in` (`ma_nhan_vien_in`),
  KEY `ma_nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `phieu_luong_ibfk_3` FOREIGN KEY (`ma_nhan_vien_in`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `phieu_luong_ibfk_4` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_luong`
--

LOCK TABLES `phieu_luong` WRITE;
/*!40000 ALTER TABLE `phieu_luong` DISABLE KEYS */;
INSERT INTO `phieu_luong` VALUES ('PL001',5000000,7000000,NULL,NULL,NULL),('PL002',5000000,7500000,NULL,NULL,NULL),('PL003',5000000,8000000,NULL,NULL,NULL),('PL004',5000000,7000000,NULL,NULL,NULL),('PL005',5000000,8500000,NULL,NULL,NULL),('PL006',5000000,7500000,NULL,NULL,NULL),('PL007',5000000,8000000,NULL,NULL,NULL),('PL008',5000000,7000000,NULL,NULL,NULL),('PL009',5000000,8500000,NULL,NULL,NULL),('PL010',5000000,7500000,NULL,NULL,NULL),('PL011',5000000,8000000,NULL,NULL,NULL),('PL012',5000000,7000000,NULL,NULL,NULL),('PL013',5000000,8500000,NULL,NULL,NULL),('PL014',5000000,7500000,NULL,NULL,NULL),('PL015',5000000,8000000,NULL,NULL,NULL),('PL016',5000000,7000000,NULL,NULL,NULL),('PL017',5000000,8500000,NULL,NULL,NULL),('PL018',5000000,7500000,NULL,NULL,NULL),('PL019',5000000,8000000,NULL,NULL,NULL),('PL020',5000000,7000000,NULL,NULL,NULL);
/*!40000 ALTER TABLE `phieu_luong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_luong_cac_loai_luong`
--

DROP TABLE IF EXISTS `phieu_luong_cac_loai_luong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `phieu_luong_cac_loai_luong` (
  `ma` varchar(255) NOT NULL,
  `ma_phieu_luong` varchar(255) DEFAULT NULL,
  `ma_lich_lam_viec` varchar(255) DEFAULT NULL,
  `ma_bang_luong` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `ma_phieu_luong` (`ma_phieu_luong`),
  KEY `ma_lich_lam_viec` (`ma_lich_lam_viec`),
  KEY `ma_bang_luong` (`ma_bang_luong`),
  CONSTRAINT `phieu_luong_cac_loai_luong_ibfk_1` FOREIGN KEY (`ma_phieu_luong`) REFERENCES `phieu_luong` (`ma_phieu`),
  CONSTRAINT `phieu_luong_cac_loai_luong_ibfk_2` FOREIGN KEY (`ma_lich_lam_viec`) REFERENCES `lich_lam_viec` (`ma_lich_lam_viec`),
  CONSTRAINT `phieu_luong_cac_loai_luong_ibfk_3` FOREIGN KEY (`ma_bang_luong`) REFERENCES `bang_luong` (`ma_bang_luong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_luong_cac_loai_luong`
--

LOCK TABLES `phieu_luong_cac_loai_luong` WRITE;
/*!40000 ALTER TABLE `phieu_luong_cac_loai_luong` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieu_luong_cac_loai_luong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_nhap_hang`
--

DROP TABLE IF EXISTS `phieu_nhap_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `phieu_nhap_hang` (
  `phieu_nhap_hang` varchar(255) NOT NULL,
  `giam_gia` double DEFAULT NULL,
  `thoi_gian` datetime(6) DEFAULT NULL,
  `tong` double DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT NULL,
  `ma_nha_cung_cap` varchar(255) DEFAULT NULL,
  `ma_chi_nhanh` varchar(50) DEFAULT NULL,
  `ma_nhan_vien` varchar(50) DEFAULT NULL,
  `tien_da_tra` double DEFAULT NULL,
  `da_tra` double DEFAULT NULL,
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
INSERT INTO `phieu_nhap_hang` VALUES ('PNH001',0,'2024-01-01 08:00:00.000000',5000000,'Đã nhập hàng','NCC001','CN001','NV004',0,5000000),('PNH002',0,'2024-01-02 10:30:00.000000',7000000,'Chưa nhập hàng','NCC001','CN001','NV004',0,7000000),('PNH003',0,'2024-01-03 09:15:00.000000',5500000,'Chưa nhập hàng','NCC001','CN001','NV004',0,5500000),('PNH004',0,'2024-01-04 11:20:00.000000',6000000,'Đã nhập hàng','NCC004','CN001','NV004',0,6000000),('PNH005',0,'2024-01-05 08:45:00.000000',8000000,'Đã nhập hàng','NCC001','CN001','NV004',0,8000000),('PNH006',0,'2024-01-06 10:00:00.000000',7500000,'Đã nhập hàng','NCC001','CN001','NV004',0,7500000),('PNH007',0,'2024-01-07 09:30:00.000000',5300000,'Chưa nhập hàng','NCC001','CN001','NV004',0,5300000),('PNH008',0,'2024-01-08 10:45:00.000000',6800000,'Chưa nhập hàng','NCC001','CN001','NV004',0,6800000),('PNH009',0,'2024-01-09 08:20:00.000000',6200000,'Đã nhập hàng','NCC001','CN001','NV004',0,6200000),('PNH010',0,'2024-01-10 11:10:00.000000',5800000,'Đã thanh toán','NCC001','CN001','NV004',0,5800000),('PNH011',0,'2024-01-11 09:50:00.000000',7300000,'Đã thanh toán','NCC002','CN001','NV004',0,7300000),('PNH012',0,'2024-01-12 10:15:00.000000',5400000,'Đã nhập hàng','NCC002','CN001','NV004',0,5400000),('PNH013',0,'2024-01-13 08:30:00.000000',6700000,'Đã thanh toán','NCC002','CN001','NV004',0,6700000),('PNH014',0,'2024-01-14 11:25:00.000000',5900000,'Đã nhập hàng','NCC002','CN001','NV004',0,5900000),('PNH015',0,'2024-01-15 09:40:00.000000',7200000,'Chưa nhập hàng','NCC002','CN001','NV004',0,7200000),('PNH016',0,'2024-01-16 10:05:00.000000',5600000,'Đã nhập hàng','NCC002','CN001','NV004',0,5600000),('PNH017',0,'2024-01-17 08:15:00.000000',6900000,'Đã nhập hàng','NCC002','CN001','NV004',0,6900000),('PNH018',0,'2024-01-18 11:30:00.000000',5700000,'Đã nhập hàng','NCC002','CN001','NV004',0,5700000),('PNH019',0,'2024-01-19 09:35:00.000000',7400000,'Đã nhập hàng','NCC002','CN001','NV004',0,7400000),('PNH020',0,'2024-01-20 10:20:00.000000',5500000,'Đã thanh toán','NCC002','CN001','NV004',0,5500000),('PNH021',0,'2024-01-21 08:40:00.000000',7100000,'Đã nhập hàng','NCC003','CN001','NV004',0,7100000),('PNH022',0,'2024-01-22 11:15:00.000000',5600000,'Đã nhập hàng','NCC003','CN001','NV004',0,5600000),('PNH023',0,'2024-01-23 09:25:00.000000',6900000,'Chưa nhập hàng','NCC003','CN001','NV004',0,6900000),('PNH024',0,'2024-01-24 10:50:00.000000',5300000,'Đã thanh toán','NCC003','CN001','NV004',0,5300000),('PNH025',0,'2024-01-25 08:10:00.000000',7200000,'Đã thanh toán','NCC003','CN001','NV004',0,7200000),('PNH026',0,'2024-01-26 11:00:00.000000',5800000,'Chưa nhập hàng','NCC003','CN001','NV004',0,5800000),('PNH027',0,'2024-01-27 09:45:00.000000',7100000,'Chưa nhập hàng','NCC003','CN001','NV004',0,7100000),('PNH028',0,'2024-01-28 10:35:00.000000',5400000,'Đã nhập hàng','NCC003','CN001','NV004',0,5400000),('PNH029',0,'2024-01-29 08:55:00.000000',6800000,'Chưa nhập hàng','NCC003','CN001','NV004',0,6800000),('PNH030',0,'2024-01-30 11:20:00.000000',5900000,'Đã nhập hàng','NCC003','CN001','NV004',0,5900000),('PNH031',0,'2024-01-31 09:30:00.000000',7300000,'Đã nhập hàng','NCC004','CN001','NV005',0,7300000),('PNH032',0,'2024-02-01 08:00:00.000000',6000000,'Đã nhập hàng','NCC004','CN001','NV005',0,6000000),('PNH033',0,'2024-02-02 10:30:00.000000',7500000,'Đã nhập hàng','NCC004','CN001','NV005',0,7500000),('PNH034',0,'2024-02-03 09:15:00.000000',5400000,'Chưa nhập hàng','NCC004','CN001','NV005',0,5400000),('PNH035',0,'2024-02-04 11:20:00.000000',6900000,'Đã nhập hàng','NCC004','CN001','NV005',0,6900000),('PNH036',0,'2024-02-05 08:45:00.000000',5700000,'Chưa nhập hàng','NCC004','CN001','NV005',0,5700000),('PNH037',0,'2024-02-06 10:00:00.000000',7200000,'Đã nhập hàng','NCC004','CN001','NV005',0,7200000),('PNH038',0,'2024-02-07 09:30:00.000000',5600000,'Đã nhập hàng','NCC004','CN001','NV005',0,5600000),('PNH039',0,'2024-02-08 10:45:00.000000',6900000,'Chưa nhập hàng','NCC004','CN001','NV005',0,6900000),('PNH040',0,'2024-02-09 08:20:00.000000',5300000,'Đã nhập hàng','NCC004','CN001','NV005',0,5300000),('PNH041',0,'2024-02-10 11:10:00.000000',7100000,'Chưa nhập hàng','NCC005','CN001','NV005',0,7100000),('PNH042',0,'2024-02-11 09:50:00.000000',5500000,'Đã thanh toán','NCC005','CN001','NV005',0,5500000),('PNH043',0,'2024-02-12 10:15:00.000000',6900000,'Đã thanh toán','NCC005','CN001','NV005',0,6900000),('PNH044',0,'2024-02-13 08:30:00.000000',5800000,'Đã nhập hàng','NCC005','CN001','NV005',0,5800000),('PNH045',0,'2024-02-14 11:25:00.000000',7000000,'Chưa nhập hàng','NCC005','CN001','NV005',0,7000000),('PNH046',0,'2024-02-15 09:40:00.000000',5400000,'Chưa nhập hàng','NCC005','CN001','NV005',0,5400000),('PNH047',0,'2024-02-16 10:05:00.000000',7200000,'Chưa nhập hàng','NCC005','CN001','NV005',0,7200000),('PNH048',0,'2024-02-17 08:15:00.000000',5600000,'Đã thanh toán','NCC005','CN001','NV005',0,5600000),('PNH049',0,'2024-02-18 11:30:00.000000',6900000,'Chưa nhập hàng','NCC005','CN001','NV005',0,6900000),('PNH050',0,'2024-02-19 09:35:00.000000',5500000,'Đã nhập hàng','NCC005','CN001','NV005',0,5500000),('PNH051',0,'2024-02-20 10:20:00.000000',7100000,'Đã thanh toán','NCC005','CN001','NV005',0,7100000),('PNH052',0,'2024-02-21 08:40:00.000000',5600000,'Đã thanh toán','NCC005','CN001','NV005',0,5600000),('PNH053',0,'2024-02-22 11:15:00.000000',6900000,'Đã nhập hàng','NCC004','CN001','NV005',0,6900000),('PNH054',0,'2024-02-23 09:25:00.000000',5300000,'Đã nhập hàng','NCC004','CN001','NV005',0,5300000),('PNH055',0,'2024-02-24 10:50:00.000000',7200000,'Chưa nhập hàng','NCC003','CN001','NV005',0,7200000),('PNH056',0,'2024-02-25 08:10:00.000000',5900000,'Đã nhập hàng','NCC003','CN001','NV005',0,5900000),('PNH057',0,'2024-02-26 11:00:00.000000',7100000,'Chưa nhập hàng','NCC002','CN001','NV005',0,7100000),('PNH058',0,'2024-02-27 09:45:00.000000',5400000,'Chưa nhập hàng','NCC002','CN001','NV005',0,5400000),('PNH059',0,'2024-02-28 10:35:00.000000',6800000,'Đã nhập hàng','NCC001','CN001','NV005',0,6800000),('PNH060',0,'2024-02-29 08:55:00.000000',5700000,'Đã nhập hàng','NCC001','CN001','NV005',0,5700000),('PNH061NCC003',0,'2024-04-18 09:25:34.000000',4130000,'Chưa nhập hàng','NCC003','CN001','NV005',NULL,4130000),('PNH062NCC002',0,'2024-04-18 09:29:38.000000',2330000,'Chưa nhập hàng','NCC002','CN001','NV005',NULL,2330000),('PNH063NCC001',0,'2024-04-18 09:46:46.000000',2550000,'Chưa nhập hàng','NCC001','CN001','NV005',NULL,2550000),('PNH064NCC001',0,'2024-04-18 10:18:29.000000',650000,'Chưa nhập hàng','NCC001','CN001','NV005',NULL,650000),('PNH065NCC003',0,'2024-04-18 10:21:36.000000',2300000,'Chưa nhập hàng','NCC003','CN001','NV005',NULL,2300000);
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
INSERT INTO `phieu_sua_chua` VALUES ('PSC001','Thay nhớt và kiểm tra hệ thống điện',1500000,'Hoàn thành','HH001','KH001','LX001','NV006','NH001','2024-01-01 08:00:00.000000'),('PSC002','Sửa chữa hệ thống phanh',1200000,'Đang xử lý','HH002','KH002','LX001','NV006','NH001','2024-01-01 08:00:00.000000'),('PSC003','Kiểm tra và sửa chữa hệ thống làm mát',1100000,'Hoàn thành','HH003','KH003','LX002','NV007','NH001','2024-01-01 08:00:00.000000'),('PSC004','Thay pin ắc quy',400000,'Hoàn thành','HH004','KH004','LX002','NV007','NH001','2024-01-01 08:00:00.000000'),('PSC005','Kiểm tra và sửa chữa hệ thống đèn',1400000,'Đang xử lý','HH005','KH005','LX002','NV008','NH002','2024-01-01 08:00:00.000000'),('PSC006','Thay bơm phanh',700000,'Hoàn thành','HH006','KH006','LX003','NV008','NH002','2024-01-01 08:00:00.000000'),('PSC007','Sửa chữa hệ thống điều hòa',1700000,'Hoàn thành','HH007','KH007','LX004','NV009','NH002','2024-01-01 08:00:00.000000'),('PSC008','Kiểm tra và sửa chữa hệ thống cảm biến',1600000,'Đã hủy','HH017','KH008','LX005','NV009','NH004','2024-01-01 08:00:00.000000'),('PSC009','Thay bơm xăng',500000,'Đang xử lý','HH018','KH009','LX006','NV010','NH004','2024-01-01 08:00:00.000000'),('PSC010','Kiểm tra và sửa chữa hệ thống lái',1300000,'Hoàn thành','HH019','KH010','LX007','NV001','NH004','2024-01-01 08:00:00.000000'),('PSC011','Chiều lấy',1590000,'Đang xử lý',NULL,'KH005','LX006','NV009',NULL,'2024-04-12 13:08:26.000000');
/*!40000 ALTER TABLE `phieu_sua_chua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_sua_chua_phu_tung`
--

DROP TABLE IF EXISTS `phieu_sua_chua_phu_tung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `phieu_sua_chua_phu_tung` (
  `ma_phieu_sua_chua` varchar(255) NOT NULL,
  `ma_hang_hoa` varchar(255) NOT NULL,
  PRIMARY KEY (`ma_phieu_sua_chua`,`ma_hang_hoa`),
  KEY `ma_hang_hoa` (`ma_hang_hoa`),
  CONSTRAINT `phieu_sua_chua_phu_tung_ibfk_1` FOREIGN KEY (`ma_phieu_sua_chua`) REFERENCES `phieu_sua_chua` (`ma_phieu_sua_chua`),
  CONSTRAINT `phieu_sua_chua_phu_tung_ibfk_2` FOREIGN KEY (`ma_hang_hoa`) REFERENCES `hang_hoa` (`ma_hang_hoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_sua_chua_phu_tung`
--

LOCK TABLES `phieu_sua_chua_phu_tung` WRITE;
/*!40000 ALTER TABLE `phieu_sua_chua_phu_tung` DISABLE KEYS */;
INSERT INTO `phieu_sua_chua_phu_tung` VALUES ('PSC001','HH001'),('PSC001','HH002'),('PSC002','HH003'),('PSC011','HH003'),('PSC002','HH004'),('PSC003','HH005'),('PSC003','HH006'),('PSC004','HH007'),('PSC011','HH007'),('PSC004','HH008'),('PSC005','HH009'),('PSC005','HH010'),('PSC006','HH011'),('PSC006','HH012'),('PSC007','HH013'),('PSC007','HH014'),('PSC008','HH015'),('PSC008','HH016'),('PSC009','HH017'),('PSC009','HH018'),('PSC010','HH019'),('PSC010','HH020');
/*!40000 ALTER TABLE `phieu_sua_chua_phu_tung` ENABLE KEYS */;
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
  `ma_chi_nhanh` varchar(255) DEFAULT 'CN001',
  `ma_phieu_nhap_hang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_phieu_tra_hang`),
  UNIQUE KEY `UK_rgogid0kbtv4j2t5qdtm1kcu7` (`ma_hoa_don`),
  KEY `FK8h6q70v26v9b1wbruu4ueycr3` (`ma_khach_hang`),
  KEY `FKsp7xbcksck81jyt11nxeqbt5m` (`ma_nhan_vien`),
  KEY `fk_ma_nha_cung_cap_phieu_tra_hang` (`ma_nha_cung_cap`),
  KEY `phieu_tra_hang_chi_nhanh` (`ma_chi_nhanh`),
  KEY `phieu_tra_hang_phieu_nhap_hang` (`ma_phieu_nhap_hang`),
  CONSTRAINT `FK8h6q70v26v9b1wbruu4ueycr3` FOREIGN KEY (`ma_khach_hang`) REFERENCES `khach_hang` (`ma_khach_hang`),
  CONSTRAINT `FKfxcbvnmn98ximsbvrf4uu52nq` FOREIGN KEY (`ma_hoa_don`) REFERENCES `hoa_don` (`ma_hoa_don`),
  CONSTRAINT `FKsp7xbcksck81jyt11nxeqbt5m` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`),
  CONSTRAINT `fk_ma_nha_cung_cap_phieu_tra_hang` FOREIGN KEY (`ma_nha_cung_cap`) REFERENCES `nha_cung_cap` (`ma_nha_cung_cap`),
  CONSTRAINT `phieu_tra_hang_chi_nhanh` FOREIGN KEY (`ma_chi_nhanh`) REFERENCES `chi_nhanh` (`ma_chi_nhanh`),
  CONSTRAINT `phieu_tra_hang_phieu_nhap_hang` FOREIGN KEY (`ma_phieu_nhap_hang`) REFERENCES `phieu_nhap_hang` (`phieu_nhap_hang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_tra_hang`
--

LOCK TABLES `phieu_tra_hang` WRITE;
/*!40000 ALTER TABLE `phieu_tra_hang` DISABLE KEYS */;
INSERT INTO `phieu_tra_hang` VALUES ('PTH001',1500000,1000000,'2024-01-18 08:00:00.000000','HD001','KH001','NV004',NULL,'Đã xử lý','CN001',NULL),('PTH002',1200000,800000,'2024-01-18 09:30:00.000000','HD003','KH002','NV004',NULL,'Đang xử lý','CN001',NULL),('PTH003',1100000,700000,'2024-01-18 10:45:00.000000','HD008','KH005','NV004',NULL,'Đã xử lý','CN001',NULL),('PTH004',2000000,1800000,'2024-01-16 10:45:00.000000','HD002',NULL,'NV005','NCC004','Đang xử lý','CN001',NULL),('PTH05',1500000,1500000,'2024-04-08 15:15:33.000000','HD004','KH003','NV004',NULL,'Đã xử lý','CN001',NULL),('PTH06',2500000,2500000,'2024-04-08 20:01:54.000000','HD017','KH009','NV004',NULL,'Đã xử lý','CN001',NULL),('PTH07',460000,460000,'2024-04-17 14:56:35.000000',NULL,NULL,'NV004','NCC001','Đã xử lý','CN001','PNH001');
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

-- Dump completed on 2024-04-26 16:10:40
