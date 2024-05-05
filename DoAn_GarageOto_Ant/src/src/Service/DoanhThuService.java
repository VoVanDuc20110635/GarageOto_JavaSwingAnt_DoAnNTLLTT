/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Service;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import src.ConnectDB.ConnectorDB;
import src.Model.DoanhThu.DoanhThuTrongNam;
import src.Model.DoanhThu.HangHoaTieuThuTrongKhoangThoiGian;
import src.Model.DoanhThu.ThongKeTongTienSoLuong;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class DoanhThuService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    
    // doanh thu
    public ThongKeTongTienSoLuong tinhDoanhThuHoaDonTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("SELECT SUM(tong_tien) AS revenue, count(ma_hoa_don) as so_luong FROM hoa_don WHERE thoi_gian > '%s' AND thoi_gian < '%s';  ",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("revenue"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhDoanhThuHoaDonTrongNgayNhatDinh (LocalDate ngay) throws SQLException{ //
        String query = String.format("SELECT SUM(tong_tien) AS revenue, count(ma_hoa_don) as so_luong FROM hoa_don WHERE thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59';  ",
                             String.valueOf(ngay), String.valueOf(ngay));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("revenue"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhDoanhThuHoaDonTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("SELECT SUM(tong_tien) AS revenue, count(ma_hoa_don) as so_luong FROM hoa_don WHERE YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s;  ",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("revenue"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public List<DoanhThuTrongNam> tinhDoanhThuHoaDonTrongNamNhatDinh ( int nam) throws SQLException{ //
        String query = String.format("SELECT  MONTH(thoi_gian) AS thang,  SUM(tong_tien) AS tong_tien , count(ma_hoa_don) as so_luong FROM   hoa_don WHERE   YEAR(thoi_gian) = %s  GROUP BY    MONTH(thoi_gian) ORDER BY  thang;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<DoanhThuTrongNam> danhSachDoanhThuTheoThang = new ArrayList<>();
        while(resultTable.next()){
            DoanhThuTrongNam doanhThuTrongNam = new DoanhThuTrongNam();
            doanhThuTrongNam.setThang(resultTable.getInt("thang"));
            doanhThuTrongNam.setTongTien(resultTable.getDouble("tong_tien"));
            doanhThuTrongNam.setSoLuong(resultTable.getInt("so_luong"));
            danhSachDoanhThuTheoThang.add(doanhThuTrongNam);
        }
        connectorDB.closeConnection();
        return danhSachDoanhThuTheoThang;
    }
    
    public ThongKeTongTienSoLuong tinhDoanhThuPhieuSuaChuaTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("SELECT SUM(tong_tien) AS revenue, count(ma_phieu_sua_chua) as so_luong FROM phieu_sua_chua WHERE thoi_gian > '%s' AND thoi_gian < '%s';  ",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("revenue"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhDoanhThuPhieuSuaChuaTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("SELECT SUM(tong_tien) AS revenue, count(ma_phieu_sua_chua) as so_luong FROM phieu_sua_chua WHERE thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59';  ",
                             String.valueOf(ngayBaDau), String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("revenue"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhDoanhThuPhieuSuaChuaTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("SELECT SUM(tong_tien) AS revenue, count(ma_phieu_sua_chua)as so_luong FROM phieu_sua_chua WHERE YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s;  ",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("revenue"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public List<DoanhThuTrongNam> tinhDoanhThuPhieuSuaChuaTrongNamNhatDinh ( int nam) throws SQLException{ //
        String query = String.format("SELECT  MONTH(thoi_gian) AS thang,  SUM(tong_tien) AS tong_tien, count(ma_phieu_sua_chua)as so_luong FROM   phieu_sua_chua WHERE   YEAR(thoi_gian) = %s  GROUP BY    MONTH(thoi_gian) ORDER BY  thang;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<DoanhThuTrongNam> danhSachDoanhThuTheoThang = new ArrayList<>();
        while(resultTable.next()){
            DoanhThuTrongNam doanhThuTrongNam = new DoanhThuTrongNam();
            doanhThuTrongNam.setThang(resultTable.getInt("thang"));
            doanhThuTrongNam.setTongTien(resultTable.getDouble("tong_tien"));
            doanhThuTrongNam.setSoLuong(resultTable.getInt("so_luong"));
            danhSachDoanhThuTheoThang.add(doanhThuTrongNam);
        }
        connectorDB.closeConnection();
        return danhSachDoanhThuTheoThang;
    }
    
    public ThongKeTongTienSoLuong tinhDoanhThuPhieuTraHangTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select SUM(can_tra) as revenue, count(ma_phieu_tra_hang) as so_luong from phieu_tra_hang where thoi_gian between '%s' and '%s';",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("revenue"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhDoanhThuPhieuTraHangTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("select SUM(can_tra) as revenue, count(ma_phieu_tra_hang) as so_luong from phieu_tra_hang where thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59';",
                             String.valueOf(ngayBaDau) ,String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("revenue"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhDoanhThuPhieuPhieuTraHangTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("select SUM(can_tra) as revenue, count(ma_phieu_tra_hang) as so_luong from phieu_tra_hang WHERE YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s;  ",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("revenue"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public List<DoanhThuTrongNam> tinhDoanhThuPhieuTraHangTrongNamNhatDinh ( int nam) throws SQLException{ //
        String query = String.format("SELECT  MONTH(thoi_gian) AS thang,  SUM(can_tra) AS tong_tien, count(ma_phieu_tra_hang) as so_luong FROM   phieu_tra_hang WHERE  ma_nha_cung_cap is not null and YEAR(thoi_gian) = %s  GROUP BY    MONTH(thoi_gian) ORDER BY  thang;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<DoanhThuTrongNam> danhSachDoanhThuTheoThang = new ArrayList<>();
        while(resultTable.next()){
            DoanhThuTrongNam doanhThuTrongNam = new DoanhThuTrongNam();
            doanhThuTrongNam.setThang(resultTable.getInt("thang"));
            doanhThuTrongNam.setTongTien(resultTable.getDouble("tong_tien"));
            doanhThuTrongNam.setSoLuong(resultTable.getInt("so_luong"));
            danhSachDoanhThuTheoThang.add(doanhThuTrongNam);
        }
        connectorDB.closeConnection();
        return danhSachDoanhThuTheoThang;
    }
    
    // chi tieu
    
    public ThongKeTongTienSoLuong tinhChiTieuPhieuTraHangTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select SUM(can_tra) as chi_phi, count(ma_phieu_tra_hang) as so_luong from phieu_tra_hang where ma_khach_hang is not null and thoi_gian between '%s' and '%s';",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("chi_phi"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhChiTieuPhieuTraHangTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("select SUM(can_tra) as chi_phi, count(ma_phieu_tra_hang) as so_luong from phieu_tra_hang where ma_khach_hang is not null and thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59';",
                             String.valueOf(ngayBaDau) ,String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("chi_phi"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhChiTieuPhieuNhapHangTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select SUM(tong) as chi_phi, count(phieu_nhap_hang) as so_luong from phieu_nhap_hang where thoi_gian between '%s' and '%s';",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("chi_phi"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhChiTieuPhieuNhapHangTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("select SUM(tong) as chi_phi, count(phieu_nhap_hang) as so_luong from phieu_nhap_hang where thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59';",
                             String.valueOf(ngayBaDau) ,String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("chi_phi"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhTienLuongNhanVienTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select SUM(tong_luong) as tien_luong, count(ma_phieu) as so_luong from phieu_luong where ngay_in between '%s' and '%s';",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("tien_luong"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhTienLuongNhanVienTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("select SUM(tong_luong) as tien_luong, count(ma_phieu) as so_luong from phieu_luong where ngay_in = '%s';",
                             String.valueOf(ngayBaDau) ,String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("tien_luong"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhChiTieuPhieuTraHangTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("select SUM(can_tra) as chi_phi, count(ma_phieu_tra_hang) as so_luong from phieu_tra_hang where ma_khach_hang is not null and YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s;",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("chi_phi"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhChiTieuPhieuNhapHangTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("select SUM(tong) as chi_phi, count(phieu_nhap_hang) as so_luong from phieu_nhap_hang where YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s;",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("chi_phi"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public ThongKeTongTienSoLuong tinhTienLuongNhanVienTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("select SUM(tong_luong) as tien_luong, count(ma_phieu) as so_luong from phieu_luong where YEAR(ngay_in) = %s AND MONTH(ngay_in) = %s;",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        ThongKeTongTienSoLuong thongKeTongTienSoLuong = new ThongKeTongTienSoLuong();
        while(resultTable.next()){
            thongKeTongTienSoLuong.setTongTien(resultTable.getDouble("tien_luong"));
            thongKeTongTienSoLuong.setSoLuong(resultTable.getInt("so_luong"));
        }
        connectorDB.closeConnection();
        return thongKeTongTienSoLuong;
    }
    
    public List<DoanhThuTrongNam> tinhChiTieuPhieuTraHangTrongNamNhatDinh (int nam) throws SQLException{ //
        String query = String.format("SELECT  MONTH(thoi_gian) AS thang,  SUM(can_tra) AS tong_tien, count(ma_phieu_tra_hang) as so_luong FROM   phieu_tra_hang WHERE  ma_khach_hang is not null and YEAR(thoi_gian) = %s  GROUP BY    MONTH(thoi_gian) ORDER BY  thang;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<DoanhThuTrongNam> danhSachDoanhThuTheoThang = new ArrayList<>();
        while(resultTable.next()){
            DoanhThuTrongNam doanhThuTrongNam = new DoanhThuTrongNam();
            doanhThuTrongNam.setThang(resultTable.getInt("thang"));
            doanhThuTrongNam.setTongTien(resultTable.getDouble("tong_tien"));
            doanhThuTrongNam.setSoLuong(resultTable.getInt("so_luong"));
            danhSachDoanhThuTheoThang.add(doanhThuTrongNam);
        }
        connectorDB.closeConnection();
        return danhSachDoanhThuTheoThang;
    }
    
    public List<DoanhThuTrongNam> tinhTienLuongNhanVienTrongNamNhatDinh (int nam) throws SQLException{ //
        String query = String.format("SELECT  MONTH(ngay_in) AS thang,  SUM(tong_luong) AS tong_tien, count(ma_phieu) as so_luong FROM   phieu_luong WHERE YEAR(ngay_in) = %s  GROUP BY    MONTH(ngay_in) ORDER BY  thang;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<DoanhThuTrongNam> danhSachDoanhThuTheoThang = new ArrayList<>();
        while(resultTable.next()){
            DoanhThuTrongNam doanhThuTrongNam = new DoanhThuTrongNam();
            doanhThuTrongNam.setThang(resultTable.getInt("thang"));
            doanhThuTrongNam.setTongTien(resultTable.getDouble("tong_tien"));
            doanhThuTrongNam.setSoLuong(resultTable.getInt("so_luong"));
            danhSachDoanhThuTheoThang.add(doanhThuTrongNam);
        }
        connectorDB.closeConnection();
        return danhSachDoanhThuTheoThang;
    }
    
    public List<DoanhThuTrongNam> tinhChiTieuPhieuNhapHangTrongNamNhatDinh (int nam) throws SQLException{ //
        String query = String.format("SELECT  MONTH(thoi_gian) AS thang,  SUM(tong) AS tong_tien, count(phieu_nhap_hang) as so_luong FROM   phieu_nhap_hang WHERE YEAR(thoi_gian) = %s  GROUP BY    MONTH(thoi_gian) ORDER BY  thang;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<DoanhThuTrongNam> danhSachDoanhThuTheoThang = new ArrayList<>();
        while(resultTable.next()){
            DoanhThuTrongNam doanhThuTrongNam = new DoanhThuTrongNam();
            doanhThuTrongNam.setThang(resultTable.getInt("thang"));
            doanhThuTrongNam.setTongTien(resultTable.getDouble("tong_tien"));
            doanhThuTrongNam.setSoLuong(resultTable.getInt("so_luong"));
            danhSachDoanhThuTheoThang.add(doanhThuTrongNam);
        }
        connectorDB.closeConnection();
        return danhSachDoanhThuTheoThang;
    }
    
    
    
    // so san pham 
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaTieuThuTrongSuaChuaTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("SELECT hang_hoa.ma_hang_hoa, hang_hoa.ten_hang_hoa, COUNT(*) AS so_luong FROM phieu_sua_chua INNER JOIN phieu_sua_chua_phu_tung ON phieu_sua_chua.ma_phieu_sua_chua = phieu_sua_chua_phu_tung.ma_phieu_sua_chua INNER JOIN hang_hoa ON phieu_sua_chua_phu_tung.ma_hang_hoa = hang_hoa.ma_hang_hoa WHERE thoi_gian BETWEEN '%s' AND '%s' GROUP BY hang_hoa.ma_hang_hoa, hang_hoa.ten_hang_hoa;",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaTieuThuTrongSuaChuaTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("SELECT hang_hoa.ma_hang_hoa, hang_hoa.ten_hang_hoa, COUNT(*) AS so_luong FROM phieu_sua_chua INNER JOIN phieu_sua_chua_phu_tung ON phieu_sua_chua.ma_phieu_sua_chua = phieu_sua_chua_phu_tung.ma_phieu_sua_chua INNER JOIN hang_hoa ON phieu_sua_chua_phu_tung.ma_hang_hoa = hang_hoa.ma_hang_hoa WHERE thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59' GROUP BY hang_hoa.ma_hang_hoa, hang_hoa.ten_hang_hoa;",
                             String.valueOf(ngayBaDau) ,String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaDuocMuaTrongHoaDonTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("SELECT hoa_don_chi_tiet.ma_hang_hoa, SUM(so_luong) AS so_luong, hang_hoa.ten_hang_hoa FROM hoa_don_chi_tiet inner join hang_hoa on hang_hoa.ma_hang_hoa = hoa_don_chi_tiet.ma_hang_hoa     inner join hoa_don on hoa_don.ma_hoa_don = hoa_don_chi_tiet.ma_hoa_don where hoa_don.thoi_gian between '%s' AND '%s' GROUP BY hoa_don_chi_tiet.ma_hang_hoa;",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaDuocMuaTrongHoaDonTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("SELECT hoa_don_chi_tiet.ma_hang_hoa, SUM(so_luong) AS so_luong, hang_hoa.ten_hang_hoa FROM hoa_don_chi_tiet inner join hang_hoa on hang_hoa.ma_hang_hoa = hoa_don_chi_tiet.ma_hang_hoa     inner join hoa_don on hoa_don.ma_hoa_don = hoa_don_chi_tiet.ma_hoa_don where hoa_don.thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59' GROUP BY hoa_don_chi_tiet.ma_hang_hoa;",
                             String.valueOf(ngayBaDau) ,String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaBiKhachHangTraTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_tra_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(thanh_tien) from chi_tiet_phieu_tra_hang inner join phieu_tra_hang on phieu_tra_hang.ma_phieu_tra_hang = chi_tiet_phieu_tra_hang.ma_phieu_tra_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_tra_hang.ma_hang_hoa where phieu_tra_hang.ma_khach_hang is not null and thoi_gian between '%s' and '%s' group by chi_tiet_phieu_tra_hang.ma_hang_hoa;",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaBiKhachHangTraTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_tra_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(thanh_tien) from chi_tiet_phieu_tra_hang inner join phieu_tra_hang on phieu_tra_hang.ma_phieu_tra_hang = chi_tiet_phieu_tra_hang.ma_phieu_tra_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_tra_hang.ma_hang_hoa where phieu_tra_hang.ma_khach_hang is not null and thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59' group by chi_tiet_phieu_tra_hang.ma_hang_hoa;",
                             String.valueOf(ngayBaDau) ,String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaTraLaiNhaCungCapTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_tra_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(thanh_tien) from chi_tiet_phieu_tra_hang inner join phieu_tra_hang on phieu_tra_hang.ma_phieu_tra_hang = chi_tiet_phieu_tra_hang.ma_phieu_tra_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_tra_hang.ma_hang_hoa where phieu_tra_hang.ma_nha_cung_cap is not null and thoi_gian between '%s' and '%s' group by chi_tiet_phieu_tra_hang.ma_hang_hoa;",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaTraLaiNhaCungCapTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_tra_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(thanh_tien) from chi_tiet_phieu_tra_hang inner join phieu_tra_hang on phieu_tra_hang.ma_phieu_tra_hang = chi_tiet_phieu_tra_hang.ma_phieu_tra_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_tra_hang.ma_hang_hoa where phieu_tra_hang.ma_nha_cung_cap is not null and thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59' group by chi_tiet_phieu_tra_hang.ma_hang_hoa;",
                             String.valueOf(ngayBaDau) ,String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaBiNhapTrongKhoangThoiGian (LocalDate ngayBaDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_nhap_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(chi_tiet_phieu_nhap_hang.tong) as tong from chi_tiet_phieu_nhap_hang inner join phieu_nhap_hang on phieu_nhap_hang.phieu_nhap_hang = chi_tiet_phieu_nhap_hang.ma_phieu_nhap_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_nhap_hang.ma_hang_hoa where thoi_gian between '%s' and '%s' group by chi_tiet_phieu_nhap_hang.ma_hang_hoa;",
                             String.valueOf(ngayBaDau),
                             String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaBiNhapTrongNgayNhatDinh (LocalDate ngayBaDau) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_nhap_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(chi_tiet_phieu_nhap_hang.tong) as tong from chi_tiet_phieu_nhap_hang inner join phieu_nhap_hang on phieu_nhap_hang.phieu_nhap_hang = chi_tiet_phieu_nhap_hang.ma_phieu_nhap_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_nhap_hang.ma_hang_hoa where thoi_gian BETWEEN '%s 00:00:00' AND '%s 23:59:59' group by chi_tiet_phieu_nhap_hang.ma_hang_hoa;",
                             String.valueOf(ngayBaDau) ,String.valueOf(ngayBaDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaTieuThuTrongSuaChuaTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("SELECT hang_hoa.ma_hang_hoa, hang_hoa.ten_hang_hoa, COUNT(*) AS so_luong FROM phieu_sua_chua INNER JOIN phieu_sua_chua_phu_tung ON phieu_sua_chua.ma_phieu_sua_chua = phieu_sua_chua_phu_tung.ma_phieu_sua_chua INNER JOIN hang_hoa ON phieu_sua_chua_phu_tung.ma_hang_hoa = hang_hoa.ma_hang_hoa WHERE YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s GROUP BY hang_hoa.ma_hang_hoa, hang_hoa.ten_hang_hoa;",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaDuocMuaTrongHoaDonTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("SELECT hoa_don_chi_tiet.ma_hang_hoa, SUM(so_luong) AS so_luong, hang_hoa.ten_hang_hoa FROM hoa_don_chi_tiet inner join hang_hoa on hang_hoa.ma_hang_hoa = hoa_don_chi_tiet.ma_hang_hoa     inner join hoa_don on hoa_don.ma_hoa_don = hoa_don_chi_tiet.ma_hoa_don WHERE YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s GROUP BY hoa_don_chi_tiet.ma_hang_hoa;",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaBiKhachHangTraTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_tra_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(thanh_tien) from chi_tiet_phieu_tra_hang inner join phieu_tra_hang on phieu_tra_hang.ma_phieu_tra_hang = chi_tiet_phieu_tra_hang.ma_phieu_tra_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_tra_hang.ma_hang_hoa where phieu_tra_hang.ma_khach_hang is not null and YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s group by chi_tiet_phieu_tra_hang.ma_hang_hoa;",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaTraLaiNhaCungCapTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_tra_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(thanh_tien) from chi_tiet_phieu_tra_hang inner join phieu_tra_hang on phieu_tra_hang.ma_phieu_tra_hang = chi_tiet_phieu_tra_hang.ma_phieu_tra_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_tra_hang.ma_hang_hoa where phieu_tra_hang.ma_nha_cung_cap is not null and YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s group by chi_tiet_phieu_tra_hang.ma_hang_hoa;",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaBiNhapTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_nhap_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(chi_tiet_phieu_nhap_hang.tong) as tong from chi_tiet_phieu_nhap_hang inner join phieu_nhap_hang on phieu_nhap_hang.phieu_nhap_hang = chi_tiet_phieu_nhap_hang.ma_phieu_nhap_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_nhap_hang.ma_hang_hoa WHERE YEAR(thoi_gian) = %s AND MONTH(thoi_gian) = %s group by chi_tiet_phieu_nhap_hang.ma_hang_hoa;",
                             String.valueOf(nam),
                             String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaTieuThuTrongSuaChuaTrongNam ( int nam) throws SQLException{ //
        String query = String.format("SELECT hang_hoa.ma_hang_hoa, hang_hoa.ten_hang_hoa, COUNT(*) AS so_luong FROM phieu_sua_chua INNER JOIN phieu_sua_chua_phu_tung ON phieu_sua_chua.ma_phieu_sua_chua = phieu_sua_chua_phu_tung.ma_phieu_sua_chua INNER JOIN hang_hoa ON phieu_sua_chua_phu_tung.ma_hang_hoa = hang_hoa.ma_hang_hoa WHERE YEAR(thoi_gian) = %s GROUP BY hang_hoa.ma_hang_hoa, hang_hoa.ten_hang_hoa;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaDuocMuaTrongHoaDonTrongNam ( int nam) throws SQLException{ //
        String query = String.format("SELECT hoa_don_chi_tiet.ma_hang_hoa, SUM(so_luong) AS so_luong, hang_hoa.ten_hang_hoa FROM hoa_don_chi_tiet inner join hang_hoa on hang_hoa.ma_hang_hoa = hoa_don_chi_tiet.ma_hang_hoa     inner join hoa_don on hoa_don.ma_hoa_don = hoa_don_chi_tiet.ma_hoa_don WHERE YEAR(thoi_gian) = %s  GROUP BY hoa_don_chi_tiet.ma_hang_hoa;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaBiKhachHangTraTrongNam ( int nam) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_tra_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(thanh_tien) from chi_tiet_phieu_tra_hang inner join phieu_tra_hang on phieu_tra_hang.ma_phieu_tra_hang = chi_tiet_phieu_tra_hang.ma_phieu_tra_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_tra_hang.ma_hang_hoa where phieu_tra_hang.ma_khach_hang is not null and YEAR(thoi_gian) = %s  group by chi_tiet_phieu_tra_hang.ma_hang_hoa;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaTraLaiNhaCungCapTrongNam ( int nam) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_tra_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(thanh_tien) from chi_tiet_phieu_tra_hang inner join phieu_tra_hang on phieu_tra_hang.ma_phieu_tra_hang = chi_tiet_phieu_tra_hang.ma_phieu_tra_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_tra_hang.ma_hang_hoa where phieu_tra_hang.ma_nha_cung_cap is not null and YEAR(thoi_gian) = %s  group by chi_tiet_phieu_tra_hang.ma_hang_hoa;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public List<HangHoaTieuThuTrongKhoangThoiGian> hangHoaBiNhapTrongNam ( int nam) throws SQLException{ //
        String query = String.format("select chi_tiet_phieu_nhap_hang.ma_hang_hoa, SUM(so_luong) as so_luong , hang_hoa.ten_hang_hoa, SUM(chi_tiet_phieu_nhap_hang.tong) as tong from chi_tiet_phieu_nhap_hang inner join phieu_nhap_hang on phieu_nhap_hang.phieu_nhap_hang = chi_tiet_phieu_nhap_hang.ma_phieu_nhap_hang inner join hang_hoa on hang_hoa.ma_hang_hoa = chi_tiet_phieu_nhap_hang.ma_hang_hoa WHERE YEAR(thoi_gian) = %s  group by chi_tiet_phieu_nhap_hang.ma_hang_hoa;",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoaTieuThuTrongKhoangThoiGian hangHoa = new HangHoaTieuThuTrongKhoangThoiGian();
            hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
            hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            hangHoa.setSoLuongSuDung(resultTable.getInt("so_luong"));
            hangHoa.setThanhTien(resultTable.getDouble("tong"));
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
}
