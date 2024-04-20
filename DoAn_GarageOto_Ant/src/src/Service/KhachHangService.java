/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Service;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import src.ConnectDB.ConnectorDB;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import src.Model.KhachHang;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class KhachHangService {
    private ConnectorDB connectorDB = new ConnectorDB();
    private Util util = new Util();
    public List<KhachHang> hienThiTatCaKhachHang () throws SQLException{ //
        String query = String.format("select * from khach_hang");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<KhachHang> danhSachKhachHang = new ArrayList<>();
        while(resultTable.next()){
            KhachHang khachHang = new KhachHang();
            for (i= 1; i <= q; i++){
                khachHang.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                khachHang.setDiaChi(resultTable.getString("dia_chi"));
                khachHang.setEmail(resultTable.getString("email"));
                khachHang.setMaSoThue(resultTable.getString("ma_so_thue"));
                khachHang.setNgaySinh(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_sinh")));
                khachHang.setNgayTao(util.localDateParseMethod(resultTable.getString("ngay_tao")));
                khachHang.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                khachHang.setTenKhachHang(resultTable.getString("ten_khach_hang"));
                khachHang.setTongBan(resultTable.getDouble("tong_ban"));
                khachHang.setTongNo(resultTable.getDouble("tong_no"));
                khachHang.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                khachHang.setGioiTinh(resultTable.getString("gioi_tinh"));
                khachHang.setLoaiKhach(resultTable.getString("loai_khach"));
                khachHang.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
            }
            danhSachKhachHang.add(khachHang);
        }
        connectorDB.closeConnection();
        return danhSachKhachHang;
    }
    
    public KhachHang hienThiKhachHangTheoMaKhachHang (String maKhachHang) throws SQLException{ //
        String query = String.format("select * from khach_hang where ma_khach_hang = '%s'", maKhachHang);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        KhachHang khachHang = new KhachHang();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                khachHang.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                khachHang.setDiaChi(resultTable.getString("dia_chi"));
                khachHang.setEmail(resultTable.getString("email"));
                khachHang.setMaSoThue(resultTable.getString("ma_so_thue"));
                khachHang.setNgaySinh(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_sinh")));
                khachHang.setNgayTao(util.localDateParseMethod(resultTable.getString("ngay_tao")));
                khachHang.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                khachHang.setTenKhachHang(resultTable.getString("ten_khach_hang"));
                khachHang.setTongBan(resultTable.getDouble("tong_ban"));
                khachHang.setTongNo(resultTable.getDouble("tong_no"));
                khachHang.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                khachHang.setGioiTinh(resultTable.getString("gioi_tinh"));
                khachHang.setLoaiKhach(resultTable.getString("loai_khach"));
                khachHang.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
            }
        }
        connectorDB.closeConnection();
        return khachHang;
    }
    
    public int themKhachHang (KhachHang khachHang) throws SQLException{ //   
        System.out.println(khachHang.getNgaySinh());
        System.out.println(khachHang.getNgayTao());
//        util.localDateParseMethod(LocalDateTime.now();
        try{
           String query = String.format("insert into khach_hang(ma_khach_hang, dia_chi, email, ma_so_thue, ngay_sinh,"
                   + "ngay_tao, so_dien_thoai, ten_khach_hang, tong_ban, tong_no, ma_nhan_vien, gioi_tinh, ma_chi_nhanh) " +
                             "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, %s, '%s', '%s', '%s')",
                             khachHang.getMaKhachHang(),
                             khachHang.getDiaChi(),
                             khachHang.getEmail(),
                             khachHang.getMaSoThue(),
                             String.valueOf(khachHang.getNgaySinh()),
                             String.valueOf(util.localDateParseMethod(khachHang.getNgayTao())),
                             khachHang.getSoDienThoai(),
                             khachHang.getTenKhachHang(),
                             khachHang.getTongBan(),
                             khachHang.getTongNo(),
                             khachHang.getMaNhanVien(),
                             khachHang.getGioiTinh(),
                             khachHang.getMaChiNhanh());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    public int demSoKhachHang() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM khach_hang;");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        int numberOfRows  = 0;
        while(resultTable.next()){
            numberOfRows = resultTable.getInt("row_count");
        }
        connectorDB.closeConnection();
        return numberOfRows;
    }
    public int updateKhachHang (KhachHang khachHang) throws SQLException{ //   
        try{
           String query = String.format("update khach_hang set dia_chi='%s', so_dien_thoai='%s', email='%s', ma_so_thue='%s', ten_khach_hang='%s',"
                   + " gioi_tinh = '%s', loai_khach = '%s', ngay_sinh = '%s' where ma_khach_hang = '%s'",
                             String.valueOf(khachHang.getDiaChi()),
                             khachHang.getSoDienThoai(),
                             khachHang.getEmail(),
                             khachHang.getMaSoThue(),
                             khachHang.getTenKhachHang(),
                             khachHang.getGioiTinh(),
                             khachHang.getLoaiKhach(),
                             String.valueOf(khachHang.getNgaySinh()),
                             khachHang.getMaKhachHang());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
