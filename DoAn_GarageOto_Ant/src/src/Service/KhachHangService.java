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
    private Util util = new Util();
    public List<KhachHang> hienThiTatCaKhachHang () throws SQLException{ //
        String query = String.format("select * from khach_hang");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
                khachHang.setNgaySinh(util.localDateParseMethod(resultTable.getString("ngay_sinh")));
                khachHang.setNgayTao(util.localDateParseMethod(resultTable.getString("ngay_tao")));
                khachHang.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                khachHang.setTenKhachHang(resultTable.getString("ten_khach_hang"));
                khachHang.setTongBan(resultTable.getDouble("tong_ban"));
                khachHang.setTongNo(resultTable.getDouble("tong_no"));
                khachHang.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachKhachHang.add(khachHang);
        }
        return danhSachKhachHang;
    }
    
    public KhachHang hienThiKhachHangTheoMaKhachHang (String maKhachHang) throws SQLException{ //
        String query = String.format("select * from khach_hang where ma_khach_hang = '%s'", maKhachHang);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
                khachHang.setNgaySinh(util.localDateParseMethod(resultTable.getString("ngay_sinh")));
                khachHang.setNgayTao(util.localDateParseMethod(resultTable.getString("ngay_tao")));
                khachHang.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                khachHang.setTenKhachHang(resultTable.getString("ten_khach_hang"));
                khachHang.setTongBan(resultTable.getDouble("tong_ban"));
                khachHang.setTongNo(resultTable.getDouble("tong_no"));
                khachHang.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
        }
        return khachHang;
    }
}
