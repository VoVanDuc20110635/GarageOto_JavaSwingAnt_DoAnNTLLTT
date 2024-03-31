-- drop database database_garage_oto;
-- create database database_garage_oto;
use database_garage_oto;
INSERT INTO bang_cham_cong (ma_bang_cham_cong, ngay_lam, trang_thai, gio_tang_ca)
VALUES 
('BC001', '2024-01-01 08:00:00', 'day du', 0),
('BC002', '2024-01-02 08:00:00', 'vang', 0),
('BC003', '2024-01-03 08:00:00', 'di tre', 0),
('BC004', '2024-01-04 08:00:00', 'tang ca', 3),
('BC005', '2024-01-05 08:00:00', 'day du', 0),
('BC006', '2024-01-06 08:00:00', 'day du', 0),
('BC007', '2024-01-07 08:00:00', 'di tre', 0),
('BC008', '2024-01-08 08:00:00', 'vang', 0),
('BC009', '2024-01-09 08:00:00', 'tang ca', 2),
('BC010', '2024-01-10 08:00:00', 'tang bang_cham_congbang_cham_congca', 2);

INSERT INTO bang_luong (ma_bang_luong, che_do_luong, tien_luong, phu_cap, tong_luong) 
VALUES 
('BL001', 'gio', 23000, 0, 0),
('BL002', 'ca', 100000, 100000, 0),
('BL003', 'thang', 8000000, 100000, 0);

INSERT INTO ca_lam (ma_ca_lam, ten_ca_lam, thoi_gian_bat_dau, thoi_gian_ket_thuc) 
VALUES 
('CAL001', 'Ca Sáng', '08:00:00', '12:00:00'),
('CAL002', 'Ca Chiều', '13:00:00', '17:00:00'),
('CAL003', 'Ca Tối', '18:00:00', '22:00:00');

INSERT INTO chi_nhanh (ma_chi_nhanh, ten_chi_nhanh, dia_chi, trang_thai) 
VALUES 
('CN001', 'Chi Nhánh A', '123 ABC Street, District 1, Ho Chi Minh City', 'Hoạt động'),
('CN002', 'Chi Nhánh B', '456 XYZ Street, District 2, Ho Chi Minh City', 'Hoạt động'),
('CN003', 'Chi Nhánh C', '789 DEF Street, District 3, Ho Chi Minh City', 'Ngừng hoạt động');

INSERT INTO chi_tiet_phieu_tra_hang (ma_chi_tiet_phieu_tra_hang, so_luong, gia_tra_hang, thanh_tien) 
VALUES 
('CTPTH001', 10, 10000, 100000),
('CTPTH002', 5, 15000, 75000),
('CTPTH003', 8, 12000, 96000);

INSERT INTO hang_hoa (ma_hang_hoa, ten_hang_hoa, gia_ban, gia_von, ton_kho, khach_dat) 
VALUES 
-- Dịch vụ thay nhớt
('HH001', 'Nhớt Mobil', 100000, 80000, 20, 5),
('HH002', 'Nhớt Castrol', 120000, 90000, 18, 4),
('HH003', 'Nhớt Total', 110000, 85000, 22, 6),
('HH004', 'Nhớt Motul', 130000, 95000, 16, 3),
-- Dịch vụ thay lốp
('HH005', 'Lốp Michelin', 2000000, 1500000, 10, 2),
('HH006', 'Lốp Bridgestone', 1800000, 1400000, 12, 3),
('HH007', 'Lốp Goodyear', 1900000, 1450000, 8, 1),
('HH008', 'Lốp Pirelli', 2200000, 1650000, 9, 2),
-- Dịch vụ kiểm tra và sửa chữa động cơ
('HH009', 'Bộ lọc gió Bosch', 300000, 250000, 25, 8),
('HH010', 'Bộ lọc nhớt Mann', 350000, 300000, 20, 6),
('HH011', 'Bộ lọc nhiên liệu Fram', 280000, 220000, 30, 10),
('HH012', 'Bộ lọc không khí K&N', 400000, 350000, 18, 5),
-- Tiếp tục thêm các bản ghi cho các dịch vụ khác
-- Tiếp tục từ dịch vụ kiểm tra và sửa chữa động cơ
('HH013', 'Dầu động cơ Shell', 200000, 150000, 35, 10),
('HH014', 'Bơm nhiên liệu Denso', 500000, 400000, 12, 3),
('HH015', 'Bugi NGK', 100000, 80000, 50, 15),
('HH016', 'Dây curoa Gates', 120000, 90000, 40, 12),
-- Dịch vụ sơn xe
('HH017', 'Sơn xanh phấn Yamaha', 1500000, 1200000, 5, 1),
('HH018', 'Sơn đen nhám Toyota', 1800000, 1400000, 8, 2),
('HH019', 'Sơn trắng sữa Honda', 1700000, 1350000, 6, 1),
('HH020', 'Sơn đỏ ferrari', 2000000, 1600000, 7, 1),
-- Dịch vụ vệ sinh nội thất
('HH021', 'Dung dịch vệ sinh nội thất Meguiar', 300000, 250000, 30, 10),
('HH022', 'Bột tẩy bẩn Sonax', 200000, 150000, 25, 8),
('HH023', 'Nước tẩy rửa da Chemical Guys', 350000, 300000, 20, 6),
('HH024', 'Dầu dưỡng da Leather Honey', 400000, 350000, 15, 5),
-- Tiếp tục thêm các bản ghi cho các dịch vụ khác
-- Dịch vụ kiểm tra và sửa chữa hệ thống điện
('HH025', 'Bóng đèn halogen Philips', 200000, 150000, 40, 12),
('HH026', 'Bóng đèn LED Osram', 300000, 250000, 35, 10),
('HH027', 'Bộ điều khiển động cơ ECU Bosch', 1500000, 1200000, 15, 4),
('HH028', 'Dây điện dẹt 2.5mm²', 10000, 8000, 100, 25),
-- Dịch vụ kiểm tra và sửa chữa hệ thống phanh
('HH029', 'Bộ lốp và rotơ trước Brembo', 2500000, 2000000, 10, 2),
('HH030', 'Dầu thắng Castrol DOT 4', 300000, 250000, 25, 8),
('HH031', 'Dây phanh dầu trước ATE', 80000, 60000, 50, 15),
('HH032', 'Dây phanh sau Brembo', 120000, 100000, 40, 12),
-- Dịch vụ thay dầu hộp số tự động
('HH033', 'Dầu hộp số tự động Mobil 1', 700000, 550000, 30, 9),
('HH034', 'Dầu hộp số tự động Toyota ATF WS', 600000, 500000, 25, 8),
('HH035', 'Dầu hộp số tự động Honda ATF DW1', 650000, 520000, 28, 8),
('HH036', 'Dầu hộp số tự động Nissan Matic S', 680000, 550000, 26, 7),
-- Tiếp tục thêm các bản ghi cho các dịch vụ khác
-- Dịch vụ kiểm tra và sửa chữa hệ thống lái
('HH037', 'Bơm dầu lái trợ lực Bosch', 900000, 700000, 20, 6),
('HH038', 'Dây lái điện ô tô', 150000, 120000, 40, 10),
('HH039', 'Cụm cầu lái trước Toyota', 1800000, 1500000, 15, 4),
('HH040', 'Vòi nước lái ô tô', 80000, 60000, 30, 8),
-- Dịch vụ kiểm tra và sửa chữa hệ thống làm mát
('HH041', 'Nước làm mát Prestone', 120000, 90000, 50, 12),
('HH042', 'Quạt làm mát Denso', 500000, 400000, 20, 6),
('HH043', 'Đèn báo nhiệt độ nước làm mát', 30000, 25000, 60, 15),
('HH044', 'Vòi phun nước làm mát', 60000, 50000, 40, 10),
-- Dịch vụ kiểm tra và sửa chữa hệ thống khí thải
('HH045', 'Cảm biến O2 Bosch', 800000, 650000, 25, 7),
('HH046', 'Bộ van EGR Pierburg', 1200000, 950000, 15, 4),
('HH047', 'Ống xả ô tô', 70000, 55000, 30, 8),
('HH048', 'Kích hoạtator bảo vệ động cơ', 300000, 250000, 40, 10),
-- Tiếp tục thêm các bản ghi cho các dịch vụ khác
-- Dịch vụ kiểm tra và sửa chữa hệ thống treo
('HH049', 'Giảm xóc KYB', 600000, 450000, 20, 6),
('HH050', 'Lò xo treo ô tô', 400000, 300000, 25, 8),
('HH051', 'Bạc đạn trục giảm chấn', 200000, 150000, 30, 10),
('HH052', 'Bản lề cửa ô tô', 100000, 80000, 40, 12),
-- Dịch vụ thay nước làm mát
('HH053', 'Nước làm mát Zerex', 100000, 80000, 50, 15),
('HH054', 'Bình chứa nước làm mát', 150000, 120000, 35, 10),
('HH055', 'Bơm nước làm mát Điện lực', 250000, 200000, 25, 8),
('HH056', 'Nắp bình nước làm mát', 50000, 40000, 40, 12),
-- Dịch vụ thay pin ắc quy
('HH057', 'Pin ắc quy GS', 500000, 400000, 20, 6),
('HH058', 'Pin ắc quy Panasonic', 600000, 450000, 15, 4),
('HH059', 'Kẹp pin ắc quy', 30000, 25000, 30, 8),
('HH060', 'Dây dẫn nối pin ắc quy', 100000, 80000, 25, 6);



INSERT INTO hoa_don (ma_hoa_don, thoi_gian, loai_thu_chi, trang_thai, tong_tien, giam_gia, tien_da_tra)
VALUES 
('HD001', '2023-01-01 10:00:00', 'Thu', 'Hoàn thành', 1500000, 0, 1500000),
('HD002', '2023-01-02 11:30:00', 'Chi', 'Hoàn thành', 800000, 0, 0),
('HD003', '2023-01-03 14:45:00', 'Thu', 'Chưa thanh toán', 2000000, 200000, 1800000),
('HD004', '2023-01-04 09:15:00', 'Thu', 'Hoàn thành', 500000, 0, 500000),
('HD005', '2023-01-05 13:20:00', 'Chi', 'Chưa thanh toán', 3000000, 300000, 2700000),
('HD006', '2023-01-06 08:30:00', 'Chi', 'Hoàn thành', 1000000, 0, 0),
('HD007', '2023-01-07 10:45:00', 'Thu', 'Hoàn thành', 1200000, 0, 1200000),
('HD008', '2023-01-08 12:00:00', 'Thu', 'Chưa thanh toán', 1800000, 150000, 1650000),
('HD009', '2023-01-09 15:10:00', 'Chi', 'Hoàn thành', 600000, 0, 0),
('HD010', '2023-01-10 09:30:00', 'Chi', 'Hoàn thành', 900000, 0, 0),
('HD011', '2023-01-11 14:00:00', 'Thu', 'Chưa thanh toán', 2500000, 200000, 2300000),
('HD012', '2023-01-12 11:20:00', 'Thu', 'Hoàn thành', 700000, 0, 700000),
('HD013', '2023-01-13 10:05:00', 'Chi', 'Chưa thanh toán', 3500000, 300000, 3200000),
('HD014', '2023-01-14 08:40:00', 'Thu', 'Hoàn thành', 800000, 0, 800000),
('HD015', '2023-01-15 12:50:00', 'Chi', 'Hoàn thành', 2000000, 0, 0),
('HD016', '2023-01-16 09:55:00', 'Chi', 'Chưa thanh toán', 1100000, 100000, 1000000),
('HD017', '2023-01-17 14:25:00', 'Thu', 'Hoàn thành', 900000, 0, 900000),
('HD018', '2023-01-18 10:35:00', 'Thu', 'Chưa thanh toán', 3000000, 250000, 2750000),
('HD019', '2023-01-19 11:15:00', 'Chi', 'Hoàn thành', 400000, 0, 0),
('HD020', '2023-01-20 13:40:00', 'Thu', 'Chưa thanh toán', 1500000, 100000, 1400000);

-- Inserting detailed bill information for hoa_don HD001
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD001_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD001_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD001_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD002
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD002_CT001', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD002_CT002', 1, 0, 2000000, 2000000), -- Dịch vụ kiểm tra và sửa chữa động cơ
('HD002_CT003', 1, 0, 3000000, 3000000); -- Dịch vụ sơn xe

-- Inserting detailed bill information for hoa_don HD003
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD003_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD003_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD003_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Continue inserting detailed bill information for the remaining bills...
-- Inserting detailed bill information for hoa_don HD004
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD004_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD004_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD004_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD005
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD005_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD005_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD005_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD006
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD006_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD006_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD006_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Continue inserting detailed bill information for the remaining bills...
-- Inserting detailed bill information for hoa_don HD007
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD007_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD007_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD007_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD008
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD008_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD008_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD008_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD009
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD009_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD009_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD009_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Continue inserting detailed bill information for the remaining bills...
-- Inserting detailed bill information for hoa_don HD010
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD010_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD010_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD010_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD011
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD011_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD011_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD011_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD012
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD012_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD012_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD012_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Continue inserting detailed bill information for the remaining bills...
-- Inserting detailed bill information for hoa_don HD013
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD013_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD013_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD013_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD014
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD014_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD014_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD014_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD015
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD015_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD015_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD015_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Continue inserting detailed bill information for the remaining bills...
-- Inserting detailed bill information for hoa_don HD016
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD016_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD016_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD016_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD017
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD017_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD017_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD017_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD018
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD018_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD018_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD018_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Continue inserting detailed bill information for the remaining bills...
-- Inserting detailed bill information for hoa_don HD019
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD019_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD019_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD019_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

-- Inserting detailed bill information for hoa_don HD020
INSERT INTO hoa_don_chi_tiet (ma_hoa_don_chi_tiet, so_luong, giam_gia, gia_ban, thanh_tien)
VALUES 
('HD020_CT001', 1, 0, 500000, 500000), -- Dịch vụ thay nhớt
('HD020_CT002', 1, 0, 1000000, 1000000), -- Dịch vụ thay lốp
('HD020_CT003', 1, 0, 2000000, 2000000); -- Dịch vụ kiểm tra và sửa chữa động cơ

INSERT INTO khach_hang (ma_khach_hang, ten_khach_hang, ngay_sinh, ma_so_thue, email, so_dien_thoai, dia_chi, ngay_tao, tong_ban, tong_no)
VALUES 
('KH001', 'Nguyễn Văn An', '1990-01-01 00:00:00', '123456789', 'nguyenvana@example.com', '0987654321', '123 Đường ABC, Quận 1, TP.HCM', '2023-01-01 10:00:00', 1500000, 0),
('KH002', 'Trần Thị Bình', '1985-05-15 00:00:00', '987654321', 'tranthib@example.com', '0123456789', '456 Đường XYZ, Quận 2, TP.HCM', '2023-01-02 11:30:00', 800000, 0),
('KH003', 'Lê Văn Chiến', '1992-03-20 00:00:00', '135792468', 'levanc@example.com', '0987123456', '789 Đường MNO, Quận 3, TP.HCM', '2023-01-03 14:45:00', 2000000, 200000),
('KH004', 'Phạm Thị Dương', '1988-12-10 00:00:00', '246813579', 'phamthid@example.com', '0967123456', '0123 Đường DEF, Quận 4, TP.HCM', '2023-01-04 09:15:00', 500000, 0),
('KH005', 'Hoàng Văn Én', '1995-08-25 00:00:00', '369258147', 'hoangvane@example.com', '0987654321', '456 Đường GHI, Quận 5, TP.HCM', '2023-01-05 13:20:00', 3000000, 300000),
('KH006', 'Trần Văn Phú', '1991-07-05 00:00:00', '975310486', 'tranvanf@example.com', '0987123456', '789 Đường KLM, Quận 6, TP.HCM', '2023-01-06 08:30:00', 1000000, 0),
('KH007', 'Nguyễn Thị Giang', '1987-09-15 00:00:00', '864203951', 'nguyenthig@example.com', '0967123456', '123 Đường NOP, Quận 7, TP.HCM', '2023-01-07 10:45:00', 1200000, 0),
('KH008', 'Phan Văn Hòa', '1994-04-30 00:00:00', '753196482', 'phanvanh@example.com', '0987654321', '456 Đường QRS, Quận 8, TP.HCM', '2023-01-08 12:00:00', 1800000, 150000),
('KH009', 'Lý Thị Yến', '1989-11-20 00:00:00', '642087513', 'lythi@example.com', '0123456789', '789 Đường TUV, Quận 9, TP.HCM', '2023-01-09 15:10:00', 600000, 0),
('KH010', 'Đặng Văn Kiên', '1996-06-10 00:00:00', '531974820', 'dangvank@example.com', '0987123456', '0123 Đường WXY, Quận 10, TP.HCM', '2023-01-10 09:30:00', 900000, 0),
('KH011', 'Bùi Thị Lý', '1993-02-05 00:00:00', '420865139', 'buithil@example.com', '0967123456', '456 Đường ZAB, Quận 11, TP.HCM', '2023-01-11 14:00:00', 2500000, 200000),
('KH012', 'Nguyễn Văn Minh', '1990-10-15 00:00:00', '309751824', 'nguyenvanm@example.com', '0987654321', '123 Đường BCD, Quận 12, TP.HCM', '2023-01-12 11:20:00', 700000, 0),
('KH013', 'Trần Thị Như', '1986-08-20 00:00:00', '198642037', 'tranthin@example.com', '0123456789', '456 Đường EFG, Quận Bình Tân, TP.HCM', '2023-01-13 10:05:00', 3500000, 300000),
('KH014', 'Lê Văn Ôn', '1991-06-01 00:00:00', '087529314', 'levano@example.com', '0987123456', '789 Đường HIJ, Quận Bình Chánh, TP.HCM', '2023-01-14 08:40:00', 800000, 0),
('KH015', 'Phạm Thị Phương', '1988-04-05 00:00:00', '976420831', 'phamthip@example.com', '0967123456', '0123 Đường KLM, Quận Thủ Đức, TP.HCM', '2023-01-15 12:50:00', 2000000, 0),
('KH016', 'Hoàng Văn Qúy', '1995-02-25 00:00:00', '865309472', 'hoangvanq@example.com', '0987654321', '456 Đường NOP, Quận Gò Vấp, TP.HCM', '2023-01-16 09:55:00', 1100000, 100000),
('KH017', 'Trần Thị Riềng', '1987-12-10 00:00:00', '753186204', 'tranthir@example.com', '0123456789', '789 Đường QRS, Quận Phú Nhuận, TP.HCM', '2023-01-17 14:25:00', 900000, 0),
('KH018', 'Nguyễn Văn Sang', '1994-10-05 00:00:00', '642097531', 'nguyenvans@example.com', '0967123456', '123 Đường TUV, Quận Tân Bình, TP.HCM', '2023-01-18 10:35:00', 3000000, 250000),
('KH019', 'Phan Thị Thư', '1989-08-15 00:00:00', '531874260', 'phanthit@example.com', '0987654321', '456 Đường WXY, Quận Tân Phú, TP.HCM', '2023-01-19 11:15:00', 400000, 0),
('KH020', 'Lý Văn Uyên', '1996-05-30 00:00:00', '420963187', 'lyvanu@example.com', '0123456789', '789 Đường ZAB, Quận Bình Thạnh, TP.HCM', '2023-01-20 13:40:00', 1500000, 100000);

INSERT INTO lich_lam_viec (ma_lich_lam_viec, ngay_bat_dau, ngay_ket_thuc, lap_lai, ghi_chu)
VALUES 
('LLV001', '2023-01-01 08:00:00', '2023-01-01 17:00:00', false, 'Ca làm việc thường ngày'),
('LLV002', '2023-01-02 09:00:00', '2023-01-02 18:00:00', false, 'Ca làm việc thường ngày'),
('LLV003', '2023-01-03 07:30:00', '2023-01-03 16:30:00', false, 'Ca làm việc thường ngày'),
('LLV004', '2023-01-04 08:30:00', '2023-01-04 17:30:00', false, 'Ca làm việc thường ngày'),
('LLV005', '2023-01-05 08:00:00', '2023-01-05 17:00:00', false, 'Ca làm việc thường ngày'),
('LLV006', '2023-01-06 09:00:00', '2023-01-06 18:00:00', false, 'Ca làm việc thường ngày'),
('LLV007', '2023-01-07 07:30:00', '2023-01-07 16:30:00', false, 'Ca làm việc thường ngày'),
('LLV008', '2023-01-08 08:30:00', '2023-01-08 17:30:00', false, 'Ca làm việc thường ngày'),
('LLV009', '2023-01-09 08:00:00', '2023-01-09 17:00:00', false, 'Ca làm việc thường ngày'),
('LLV010', '2023-01-10 09:00:00', '2023-01-10 18:00:00', false, 'Ca làm việc thường ngày');

INSERT INTO loai_xe (ma_loai_xe, ten_loai_xe)
VALUES 
('LX001', 'Toyota'),
('LX002', 'Honda'),
('LX003', 'Ford'),
('LX004', 'Chevrolet'),
('LX005', 'BMW'),
('LX006', 'Mercedes-Benz'),
('LX007', 'Audi');

INSERT INTO nha_cung_cap (ma_nha_cung_cap, ten_nha_cung_cap, dia_chi, email, so_dien_thoai, ma_so_thue, ngay_tao)
VALUES 
('NCC001', 'Công ty TNHH ABC', '123 Đường ABC, Quận XYZ, Thành phố HCM', 'abc@company.com', '0123456789', 'ABC123456', '2023-01-01 08:00:00'),
('NCC002', 'Công ty XYZ Ltd', '456 Đường XYZ, Quận ABC, Thành phố Hà Nội', 'xyz@company.com', '0987654321', 'XYZ987654', '2023-01-02 09:00:00'),
('NCC003', 'Công ty MNO', '789 Đường MNO, Quận DEF, Thành phố Đà Nẵng', 'mno@company.com', '0369852147', 'MNO456789', '2023-01-03 10:00:00'),
('NCC004', 'Công ty PQR', '101 Đường PQR, Quận GHI, Thành phố Cần Thơ', 'pqr@company.com', '0246857319', 'PQR987654', '2023-01-04 11:00:00'),
('NCC005', 'Công ty STU', '111 Đường STU, Quận KLM, Thành phố Hải Phòng', 'stu@company.com', '0379514682', 'STU123456', '2023-01-05 12:00:00');

INSERT INTO nhan_vien (ma_nhan_vien, ten_nhan_vien, ngay_sinh, gioi_tinh, cccd, chuc_danh, so_dien_thoai, ngay_bat_dau_lam_viec)
VALUES 
('NV000', 'Võ Văn Đức', '2002-11-02 00:00:00', 'Nam', '068202006801', 'admin', '0869990187', '2020-01-01 08:00:00'),
('NV001', 'Nguyễn Văn Anh', '1990-01-01 00:00:00', 'Nam', '123456789', 'Nhân viên sữa chữa', '0123456789', '2020-01-01 08:00:00'),
('NV002', 'Trần Luyện', '1992-02-02 00:00:00', 'Nam', '234567890', 'Nhân viên kỹ thuật', '0987654321', '2019-12-15 09:00:00'),
('NV003', 'Phạm Văn Chiêu', '1995-03-03 00:00:00', 'Nam', '345678901', 'Bảo vệ', '0369852147', '2021-03-10 10:00:00'),
('NV004', 'Hoàng Thị D', '1988-04-04 00:00:00', 'Nữ', '456789012', 'Kế toán viên', '0246857319', '2020-06-20 11:00:00'),
('NV005', 'Tuyết Tuyết Nhi', '1993-05-05 00:00:00', 'Nữ', '567890123', 'Kế toán viên', '0379514682', '2018-09-05 12:00:00'),
('NV006', 'Lê Điển Tịch', '1997-06-06 00:00:00', 'Nam', '678901234', 'Nhân viên sữa chữa', '0987654321', '2019-11-30 08:30:00'),
('NV007', 'Nguyễn Văn Giang', '1991-07-07 00:00:00', 'Nam', '789012345', 'Nhân viên sữa chữa', '0369852147', '2021-01-15 10:45:00'),
('NV008', 'Trần Trúc Huyên', '1994-08-08 00:00:00', 'Nam', '890123456', 'Nhân viên sữa chữa', '0246857319', '2019-07-05 11:15:00'),
('NV009', 'Phạm Văn Linh', '1989-09-09 00:00:00', 'Nam', '901234567', 'Nhân viên sữa chữa', '0379514682', '2022-04-18 13:20:00'),
('NV010', 'Võ Tòng', '1996-10-10 00:00:00', 'Nam', '012345678', 'Nhân viên sữa chữa', '0987654321', '2018-11-25 14:30:00');

INSERT INTO nhom_hang (ma_nhom_hang, ten_nhom_hang)
VALUES 
('NH001', 'Dịch vụ thay nhớt'),
('NH002', 'Dịch vụ thay lốp'),
('NH003', 'Dịch vụ kiểm tra và sửa chữa động cơ'),
('NH004', 'Dịch vụ sơn xe'),
('NH005', 'Dịch vụ vệ sinh nội thất'),
('NH006', 'Dịch vụ kiểm tra và sửa chữa hệ thống điện'),
('NH007', 'Dịch vụ kiểm tra và sửa chữa hệ thống phanh'),
('NH008', 'Dịch vụ thay dầu hộp số tự động'),
('NH009', 'Dịch vụ kiểm tra và sửa chữa hệ thống lái'),
('NH010', 'Dịch vụ kiểm tra và sửa chữa hệ thống làm mát'),
('NH011', 'Dịch vụ kiểm tra và sửa chữa hệ thống khí thải'),
('NH012', 'Dịch vụ kiểm tra và sửa chữa hệ thống treo'),
('NH013', 'Dịch vụ thay nước làm mát'),
('NH014', 'Dịch vụ thay pin ắc quy'),
('NH015', 'Dịch vụ kiểm tra và sửa chữa hệ thống điều hòa'),
('NH016', 'Dịch vụ kiểm tra và sửa chữa hệ thống cảm biến'),
('NH017', 'Dịch vụ kiểm tra và sửa chữa hệ thống đèn'),
('NH018', 'Dịch vụ kiểm tra và sửa chữa hệ thống kính'),
('NH019', 'Dịch vụ kiểm tra và sửa chữa hệ thống truyền động'),
('NH020', 'Dịch vụ thay dầu hộp số thủ công'),
('NH021', 'Dịch vụ thay bộ lọc nhớt'),
('NH022', 'Dịch vụ thay bình nước làm mát'),
('NH023', 'Dịch vụ thay bình ắc quy'),
('NH024', 'Dịch vụ thay bơm xăng'),
('NH025', 'Dịch vụ thay bơm phanh'),
('NH026', 'Dịch vụ thay bình phân phối'),
('NH027', 'Dịch vụ thay đèn pha'),
('NH028', 'Dịch vụ thay gương chiếu hậu'),
('NH029', 'Dịch vụ thay cầu chì đèn hậu'),
('NH030', 'Dịch vụ thay bánh xe'),
('NH031', 'Dịch vụ xạc bình ắc quy');


INSERT INTO phieu_luong (ma_phieu, ky_viec_lam, da_tra, luong_cung, giam_luong, luong_thuong, tong_luong, trang_thai) 
VALUES 
('PL001', 'Tháng 01/2024', 5000000, 5000000, 0, 2000000, 7000000, 'Đã thanh toán'),
('PL002', 'Tháng 02/2024', 5000000, 5000000, 0, 2500000, 7500000, 'Đã thanh toán'),
('PL003', 'Tháng 03/2024', 5000000, 5000000, 0, 3000000, 8000000, 'Chưa thanh toán'),
('PL004', 'Tháng 04/2024', 5000000, 5000000, 0, 2000000, 7000000, 'Chưa thanh toán'),
('PL005', 'Tháng 05/2024', 5000000, 5000000, 0, 3500000, 8500000, 'Chưa thanh toán'),
('PL006', 'Tháng 06/2024', 5000000, 5000000, 0, 2500000, 7500000, 'Chưa thanh toán'),
('PL007', 'Tháng 07/2024', 5000000, 5000000, 0, 3000000, 8000000, 'Chưa thanh toán'),
('PL008', 'Tháng 08/2024', 5000000, 5000000, 0, 2000000, 7000000, 'Chưa thanh toán'),
('PL009', 'Tháng 09/2024', 5000000, 5000000, 0, 3500000, 8500000, 'Chưa thanh toán'),
('PL010', 'Tháng 10/2024', 5000000, 5000000, 0, 2500000, 7500000, 'Chưa thanh toán'),
('PL011', 'Tháng 11/2024', 5000000, 5000000, 0, 3000000, 8000000, 'Chưa thanh toán'),
('PL012', 'Tháng 12/2024', 5000000, 5000000, 0, 2000000, 7000000, 'Chưa thanh toán'),
('PL013', 'Tháng 01/2025', 5000000, 5000000, 0, 3500000, 8500000, 'Chưa thanh toán'),
('PL014', 'Tháng 02/2025', 5000000, 5000000, 0, 2500000, 7500000, 'Chưa thanh toán'),
('PL015', 'Tháng 03/2025', 5000000, 5000000, 0, 3000000, 8000000, 'Chưa thanh toán'),
('PL016', 'Tháng 04/2025', 5000000, 5000000, 0, 2000000, 7000000, 'Chưa thanh toán'),
('PL017', 'Tháng 05/2025', 5000000, 5000000, 0, 3500000, 8500000, 'Chưa thanh toán'),
('PL018', 'Tháng 06/2025', 5000000, 5000000, 0, 2500000, 7500000, 'Chưa thanh toán'),
('PL019', 'Tháng 07/2025', 5000000, 5000000, 0, 3000000, 8000000, 'Chưa thanh toán'),
('PL020', 'Tháng 08/2025', 5000000, 5000000, 0, 2000000, 7000000, 'Chưa thanh toán');

INSERT INTO phieu_nhap_hang (phieu_nhap_hang, thoi_gian, tong, no, trang_thai) 
VALUES 
('PNH001', '2024-01-01 08:00:00', 5000000, 0, 'Hoàn thành'),
('PNH002', '2024-01-02 10:30:00', 7000000, 0, 'Hoàn thành'),
('PNH003', '2024-01-03 09:15:00', 5500000, 0, 'Hoàn thành'),
('PNH004', '2024-01-04 11:20:00', 6000000, 0, 'Hoàn thành'),
('PNH005', '2024-01-05 08:45:00', 8000000, 0, 'Hoàn thành'),
('PNH006', '2024-01-06 10:00:00', 7500000, 0, 'Hoàn thành'),
('PNH007', '2024-01-07 09:30:00', 5300000, 0, 'Hoàn thành'),
('PNH008', '2024-01-08 10:45:00', 6800000, 0, 'Hoàn thành'),
('PNH009', '2024-01-09 08:20:00', 6200000, 0, 'Hoàn thành'),
('PNH010', '2024-01-10 11:10:00', 5800000, 0, 'Hoàn thành'),
('PNH011', '2024-01-11 09:50:00', 7300000, 0, 'Hoàn thành'),
('PNH012', '2024-01-12 10:15:00', 5400000, 0, 'Hoàn thành'),
('PNH013', '2024-01-13 08:30:00', 6700000, 0, 'Hoàn thành'),
('PNH014', '2024-01-14 11:25:00', 5900000, 0, 'Hoàn thành'),
('PNH015', '2024-01-15 09:40:00', 7200000, 0, 'Hoàn thành'),
('PNH016', '2024-01-16 10:05:00', 5600000, 0, 'Hoàn thành'),
('PNH017', '2024-01-17 08:15:00', 6900000, 0, 'Hoàn thành'),
('PNH018', '2024-01-18 11:30:00', 5700000, 0, 'Hoàn thành'),
('PNH019', '2024-01-19 09:35:00', 7400000, 0, 'Hoàn thành'),
('PNH020', '2024-01-20 10:20:00', 5500000, 0, 'Hoàn thành'),
('PNH021', '2024-01-21 08:40:00', 7100000, 0, 'Hoàn thành'),
('PNH022', '2024-01-22 11:15:00', 5600000, 0, 'Hoàn thành'),
('PNH023', '2024-01-23 09:25:00', 6900000, 0, 'Hoàn thành'),
('PNH024', '2024-01-24 10:50:00', 5300000, 0, 'Hoàn thành'),
('PNH025', '2024-01-25 08:10:00', 7200000, 0, 'Hoàn thành'),
('PNH026', '2024-01-26 11:00:00', 5800000, 0, 'Hoàn thành'),
('PNH027', '2024-01-27 09:45:00', 7100000, 0, 'Hoàn thành'),
('PNH028', '2024-01-28 10:35:00', 5400000, 0, 'Hoàn thành'),
('PNH029', '2024-01-29 08:55:00', 6800000, 0, 'Hoàn thành'),
('PNH030', '2024-01-30 11:20:00', 5900000, 0, 'Hoàn thành'),
('PNH031', '2024-01-31 09:30:00', 7300000, 0, 'Hoàn thành'),
('PNH032', '2024-02-01 08:00:00', 6000000, 0, 'Hoàn thành'),
('PNH033', '2024-02-02 10:30:00', 7500000, 0, 'Hoàn thành'),
('PNH034', '2024-02-03 09:15:00', 5400000, 0, 'Hoàn thành'),
('PNH035', '2024-02-04 11:20:00', 6900000, 0, 'Hoàn thành'),
('PNH036', '2024-02-05 08:45:00', 5700000, 0, 'Hoàn thành'),
('PNH037', '2024-02-06 10:00:00', 7200000, 0, 'Hoàn thành'),
('PNH038', '2024-02-07 09:30:00', 5600000, 0, 'Hoàn thành'),
('PNH039', '2024-02-08 10:45:00', 6900000, 0, 'Hoàn thành'),
('PNH040', '2024-02-09 08:20:00', 5300000, 0, 'Hoàn thành'),
('PNH041', '2024-02-10 11:10:00', 7100000, 0, 'Hoàn thành'),
('PNH042', '2024-02-11 09:50:00', 5500000, 0, 'Hoàn thành'),
('PNH043', '2024-02-12 10:15:00', 6900000, 0, 'Hoàn thành'),
('PNH044', '2024-02-13 08:30:00', 5800000, 0, 'Hoàn thành'),
('PNH045', '2024-02-14 11:25:00', 7000000, 0, 'Hoàn thành'),
('PNH046', '2024-02-15 09:40:00', 5400000, 0, 'Hoàn thành'),
('PNH047', '2024-02-16 10:05:00', 7200000, 0, 'Hoàn thành'),
('PNH048', '2024-02-17 08:15:00', 5600000, 0, 'Hoàn thành'),
('PNH049', '2024-02-18 11:30:00', 6900000, 0, 'Hoàn thành'),
('PNH050', '2024-02-19 09:35:00', 5500000, 0, 'Hoàn thành'),
('PNH051', '2024-02-20 10:20:00', 7100000, 0, 'Hoàn thành'),
('PNH052', '2024-02-21 08:40:00', 5600000, 0, 'Hoàn thành'),
('PNH053', '2024-02-22 11:15:00', 6900000, 0, 'Hoàn thành'),
('PNH054', '2024-02-23 09:25:00', 5300000, 0, 'Hoàn thành'),
('PNH055', '2024-02-24 10:50:00', 7200000, 0, 'Hoàn thành'),
('PNH056', '2024-02-25 08:10:00', 5900000, 0, 'Hoàn thành'),
('PNH057', '2024-02-26 11:00:00', 7100000, 0, 'Hoàn thành'),
('PNH058', '2024-02-27 09:45:00', 5400000, 0, 'Hoàn thành'),
('PNH059', '2024-02-28 10:35:00', 6800000, 0, 'Hoàn thành'),
('PNH060', '2024-02-29 08:55:00', 5700000, 0, 'Hoàn thành');

INSERT INTO phieu_sua_chua (ma_phieu_sua_chua, noi_dung_sua_chua, tong_tien, trang_thai) 
VALUES 
('PSC001', 'Thay nhớt và kiểm tra hệ thống điện', 1500000, 'Hoàn thành'),
('PSC002', 'Sửa chữa hệ thống phanh', 1200000, 'Đang xử lý'),
('PSC003', 'Kiểm tra và sửa chữa hệ thống làm mát', 1100000, 'Hoàn thành'),
('PSC004', 'Thay pin ắc quy', 400000, 'Hoàn thành'),
('PSC005', 'Kiểm tra và sửa chữa hệ thống đèn', 1400000, 'Đang xử lý'),
('PSC006', 'Thay bơm phanh', 700000, 'Hoàn thành'),
('PSC007', 'Sửa chữa hệ thống điều hòa', 1700000, 'Hoàn thành'),
('PSC008', 'Kiểm tra và sửa chữa hệ thống cảm biến', 1600000, 'Đã hủy'),
('PSC009', 'Thay bơm xăng', 500000, 'Đang xử lý'),
('PSC010', 'Kiểm tra và sửa chữa hệ thống lái', 1300000, 'Hoàn thành');

INSERT INTO phieu_tra_hang (ma_phieu_tra_hang, thoi_gian, can_tra_khach, da_tra_khach) 
VALUES 
('PTH001', '2024-01-18 08:00:00', 1500000, 1000000),
('PTH002', '2024-01-18 09:30:00', 1200000, 800000),
('PTH003', '2024-01-18 10:45:00', 1100000, 700000);

INSERT INTO the_kho (ma_the_kho, phuong_thuc, thoi_gian, gia_von, so_luong, so_luong_thuc_te, ton_cuoi) 
VALUES 
('TK001', 'Nhập', '2024-01-18 08:00:00', 50000, 100, 100, 100),
('TK002', 'Xuất', '2024-01-18 09:30:00', 60000, 80, 80, 20),
('TK003', 'Nhập', '2024-01-18 10:45:00', 55000, 120, 120, 140),
('TK004', 'Xuất', '2024-01-18 12:15:00', 60000, 60, 60, 80),
('TK005', 'Nhập', '2024-01-18 13:45:00', 52000, 90, 90, 170),
('TK006', 'Xuất', '2024-01-18 15:00:00', 60000, 50, 50, 120),
('TK007', 'Nhập', '2024-01-18 16:30:00', 53000, 80, 80, 200),
('TK008', 'Xuất', '2024-01-18 17:45:00', 58000, 70, 70, 130),
('TK009', 'Nhập', '2024-01-18 18:45:00', 54000, 110, 110, 240),
('TK010', 'Xuất', '2024-01-18 20:00:00', 62000, 40, 40, 200),
('TK011', 'Nhập', '2024-01-19 08:00:00', 51000, 95, 95, 295),
('TK012', 'Xuất', '2024-01-19 09:30:00', 59000, 65, 65, 230),
('TK013', 'Nhập', '2024-01-19 10:45:00', 55000, 100, 100, 330),
('TK014', 'Xuất', '2024-01-19 12:15:00', 61000, 55, 55, 275),
('TK015', 'Nhập', '2024-01-19 13:45:00', 53000, 85, 85, 360),
('TK016', 'Xuất', '2024-01-19 15:00:00', 62000, 45, 45, 315),
('TK017', 'Nhập', '2024-01-19 16:30:00', 54000, 105, 105, 420),
('TK018', 'Xuất', '2024-01-19 17:45:00', 59000, 75, 75, 345),
('TK019', 'Nhập', '2024-01-19 18:45:00', 52000, 115, 115, 460),
('TK020', 'Xuất', '2024-01-19 20:00:00', 63000, 35, 35, 425),
('TK021', 'Nhập', '2024-01-20 08:00:00', 53000, 90, 90, 515),
('TK022', 'Xuất', '2024-01-20 09:30:00', 60000, 60, 60, 455),
('TK023', 'Nhập', '2024-01-20 10:45:00', 55000, 105, 105, 560),
('TK024', 'Xuất', '2024-01-20 12:15:00', 61000, 50, 50, 510),
('TK025', 'Nhập', '2024-01-20 13:45:00', 52000, 95, 95, 605),
('TK026', 'Xuất', '2024-01-20 15:00:00', 63000, 40, 40, 565),
('TK027', 'Nhập', '2024-01-20 16:30:00', 54000, 110, 110, 675),
('TK028', 'Xuất', '2024-01-20 17:45:00', 59000, 70, 70, 605),
('TK029', 'Nhập', '2024-01-20 18:45:00', 51000, 120, 120, 725),
('TK030', 'Xuất', '2024-01-20 20:00:00', 64000, 30, 30, 695),
('TK031', 'Nhập', '2024-01-21 08:00:00', 54000, 85, 85, 780),
('TK032', 'Xuất', '2024-01-21 09:30:00', 61000, 55, 55, 725),
('TK033', 'Nhập', '2024-01-21 10:45:00', 55000, 100, 100, 825),
('TK034', 'Xuất', '2024-01-21 12:15:00', 62000, 45, 45, 780),
('TK035', 'Nhập', '2024-01-21 13:45:00', 53000, 95, 95, 875),
('TK036', 'Xuất', '2024-01-21 15:00:00', 64000, 35, 35, 840),
('TK037', 'Nhập', '2024-01-21 16:30:00', 55000, 110, 110, 950),
('TK038', 'Xuất', '2024-01-21 17:45:00', 60000, 70, 70, 880),
('TK039', 'Nhập', '2024-01-21 18:45:00', 52000, 120, 120, 1000),
('TK040', 'Xuất', '2024-01-21 20:00:00', 65000, 30, 30, 970),
('TK041', 'Nhập', '2024-01-22 08:00:00', 55000, 95, 95, 1065),
('TK042', 'Xuất', '2024-01-22 09:30:00', 62000, 55, 55, 1010),
('TK043', 'Nhập', '2024-01-22 10:45:00', 56000, 100, 100, 1110),
('TK044', 'Xuất', '2024-01-22 12:15:00', 63000, 45, 45, 1065),
('TK045', 'Nhập', '2024-01-22 13:45:00', 54000, 95, 95, 1160),
('TK046', 'Xuất', '2024-01-22 15:00:00', 65000, 35, 35, 1125),
('TK047', 'Nhập', '2024-01-22 16:30:00', 56000, 110, 110, 1235),
('TK048', 'Xuất', '2024-01-22 17:45:00', 61000, 70, 70, 1165),
('TK049', 'Nhập', '2024-01-22 18:45:00', 53000, 120, 120, 1285),
('TK050', 'Xuất', '2024-01-22 20:00:00', 66000, 30, 30, 1255),
('TK051', 'Nhập', '2024-01-23 08:00:00', 56000, 90, 90, 1345),
('TK052', 'Xuất', '2024-01-23 09:30:00', 63000, 60, 60, 1285),
('TK053', 'Nhập', '2024-01-23 10:45:00', 57000, 105, 105, 1390),
('TK054', 'Xuất', '2024-01-23 12:15:00', 64000, 50, 50, 1340),
('TK055', 'Nhập', '2024-01-23 13:45:00', 55000, 95, 95, 1435),
('TK056', 'Xuất', '2024-01-23 15:00:00', 66000, 40, 40, 1395),
('TK057', 'Nhập', '2024-01-23 16:30:00', 57000, 110, 110, 1505),
('TK058', 'Xuất', '2024-01-23 17:45:00', 62000, 70, 70, 1435),
('TK059', 'Nhập', '2024-01-23 18:45:00', 54000, 120, 120, 1555),
('TK060', 'Xuất', '2024-01-23 20:00:00', 67000, 30, 30, 1525);

INSERT INTO hinh_anh (ma_hinh_anh, ten_hinh, noi_dung)
VALUES 
('HA001', 'Hình ảnh 1', 'Nội dung hình ảnh 1'),
('HA002', 'Hình ảnh 2', 'Nội dung hình ảnh 2'),
('HA003', 'Hình ảnh 3', 'Nội dung hình ảnh 3'),
('HA004', 'Hình ảnh 4', 'Nội dung hình ảnh 4'),
('HA005', 'Hình ảnh 5', 'Nội dung hình ảnh 5'),
('HA006', 'Hình ảnh 6', 'Nội dung hình ảnh 6'),
('HA007', 'Hình ảnh 7', 'Nội dung hình ảnh 7'),
('HA008', 'Hình ảnh 8', 'Nội dung hình ảnh 8'),
('HA009', 'Hình ảnh 9', 'Nội dung hình ảnh 9'),
('HA010', 'Hình ảnh 10', 'Nội dung hình ảnh 10');
use database_garage_oto;
CREATE TABLE chi_tiet_phieu_nhap_hang (
    ma_chi_tiet_phieu_nhap_hang VARCHAR(50),
    ma_hang_hoa VARCHAR(50),
    so_luong SMALLINT,
    gia_nhap DOUBLE,
    tong DOUBLE,
    giam_gia DOUBLE,
    thanh_tien DOUBLE,
    PRIMARY KEY (ma_chi_tiet_phieu_nhap_hang),
    FOREIGN KEY (ma_hang_hoa) REFERENCES hang_hoa(ma_hang_hoa)
);

INSERT INTO chi_tiet_phieu_nhap_hang  (ma_chi_tiet_phieu_nhap_hang, ma_hang_hoa, so_luong, gia_nhap, tong, giam_gia, thanh_tien)
SELECT 
    CONCAT('CTPNH', LPAD(ROW_NUMBER() OVER(), 3, '0')) AS ma_chi_tiet_phieu_nhap_hang, 
    ph.ma_hang_hoa, 
    10 AS so_luong, -- Example value for "so_luong"
    50000 AS gia_nhap, -- Example value for "gia_nhap"
    500000 AS tong, -- Example value for "tong"
    0 AS giam_gia, -- Example value for "giam_gia"
    500000 AS thanh_tien -- Example value for "thanh_tien"
FROM 
    phieu_nhap_hang ph;

-- First, drop the foreign key constraint that references the 'ma_hang_hoa' column
ALTER TABLE phieu_nhap_hang DROP FOREIGN KEY FKi7gdrduv9lm993vywctoc145t;

-- Now, drop the 'ma_hang_hoa' column from the 'phieu_nhap_hang' table
ALTER TABLE phieu_nhap_hang DROP COLUMN ma_hang_hoa;
select * from bang_cham_cong;

select * from ca_lam;
select * from bang_luong;
select * from lich_lam_viec_ca_lam;
GRANT SELECT ON lich_lam_viec_ca_lam TO PUBLIC;
select * from chi_nhanh;
select * from phieu_tra_hang;
select * from chi_tiet_phieu_tra_hang;
select * from nhom_hang;
select * from hang_hoa;
select * from hinh_anh;

select * from hoa_don;
select * from khach_hang;
select * from nhan_vien;
select * from nha_cung_cap;

SELECT *
FROM bang_cham_cong
WHERE ngay_lam BETWEEN '2023-01-25' AND '2024-01-30';

SELECT *
FROM bang_cham_cong
WHERE MONTH(ngay_lam) = 1;

-- set toàn bộ giá trị của một cột là null
update hinh_anh set ma_nhan_vien = NULL;

-- copy toàn bộ giá trị từ 1 cột của bảng này sang 1 cột của bảng khác
UPDATE hinh_anh AS ha
JOIN hang_hoa AS hh ON ha.ma_hang_hoa = hh.ma_hang_hoa
SET ha.noi_dung = hh.ten_hang_hoa;

-- them primary key

-- copy toàn bộ giá trị từ 1 cột của bảng này sang 1 cột của bảng khác
SET @counter = 1; -- Initialize counter variable

INSERT INTO hinh_anh (ma_hinh_anh, ten_hinh, noi_dung, ma_hang_hoa)
SELECT CONCAT('HA', LPAD(@counter := @counter + 1, 3, '0')), 'Hình ảnh', ten_hang_hoa, ma_hang_hoa
FROM hang_hoa;


select * from nhom_hang;
select * from hang_hoa;

-- doi ten cot trong table
alter table nhom_hang 
change column ten_nhom_hang  dich_vu_lien_quan varchar(255);

-- them cot moi cho table
ALTER TABLE hang_hoa
ADD COLUMN loai_hang nvarchar(255);

-- xoa cot trong table
alter table nhom_hang
drop column loai_hang;

-- select rows chua 1 trong nhieu chuoi
SELECT *
FROM hang_hoa
WHERE ten_hang_hoa LIKE '%toyota%' OR ten_hang_hoa LIKE '%honda%' OR ten_hang_hoa LIKE '%nhớt%';
select * from hang_hoa where  ten_hang_hoa LIKE '%Toyota%' OR ten_hang_hoa LIKE '%honda%' OR ten_hang_hoa LIKE '%Nhớt%';
select * from hang_hoa where  ten_hang_hoa LIKE '%Lốp%' OR ten_hang_hoa LIKE '%Bột lọc nhớt%';
select * from hang_hoa where  ten_hang_hoa LIKE '%Lốp%' OR ten_hang_hoa LIKE '%Bộ lọc nhớt%' OR ten_hang_hoa LIKE '%Chevrolet%' OR ten_hang_hoa LIKE '%BMW%' OR ten_hang_hoa LIKE '%Audi%' OR ten_hang_hoa LIKE '%Bộ lọc không khí%';
select * from hang_hoa;

select * from hang_hoa where  (ten_hang_hoa LIKE '%Bộ lọc gió%'  OR ten_hang_hoa LIKE '%Nhớt%');

select * from hang_hoa;
select * from hinh_anh where ma_hang_hoa = 'HH061';

-- dem so dong trong table
SELECT COUNT(*) AS row_count FROM hinh_anh;

-- them cot trang thai vao bang hang_hoa
ALTER TABLE hang_hoa
ADD COLUMN trang_thai nvarchar(255) default 1;

select * from hang_hoa;

use database_garage_oto;