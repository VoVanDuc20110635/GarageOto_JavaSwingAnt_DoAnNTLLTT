/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Service;
import src.Model.NhanVien;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import src.ConnectDB.ConnectorDB;
import java.time.format.DateTimeFormatter;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class NhanVienService {
    private Util util = new Util();
    private ChiNhanhServive chiNhanhServive = new ChiNhanhServive();
    private LichLamViecService lichLamViecService = new LichLamViecService();
    
    public List<NhanVien> hienThiTatCaNhanVien () throws SQLException{ //
        String query = String.format("select * from nhan_vien");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
        while(resultTable.next()){
            NhanVien nhanVien = new NhanVien();
            for (i= 1; i <= q; i++){
                nhanVien.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                nhanVien.setCccd(resultTable.getString("cccd"));
                nhanVien.setChucDanh(resultTable.getString("chuc_danh"));
                nhanVien.setGioiTinh(resultTable.getString("gioi_tinh"));
                nhanVien.setNgayBatDauLamViec(util.localDateParseMethod(resultTable.getString("ngay_bat_dau_lam_viec")));
                nhanVien.setNgaySinh(util.localDateParseMethod(resultTable.getString("ngay_sinh")));
                nhanVien.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                nhanVien.setTenNhanVien(resultTable.getString("ten_nhan_vien"));
                nhanVien.setNoLuong(resultTable.getDouble("no_luong"));
                
                nhanVien.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                nhanVien.setTaoBoiMaNhanVien(resultTable.getString("tao_boi_ma_nhan_vien"));
                nhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
//                
            }
            danhSachNhanVien.add(nhanVien);
        }
        return danhSachNhanVien;
    }
    
    public NhanVien hienThiNhanVienTheoMaNhanVien (String maNhanVien) throws SQLException{ //
        String query = String.format("select * from nhan_vien where ma_nhan_vien = '%s'", maNhanVien);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        NhanVien nhanVien = new NhanVien();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                nhanVien.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                nhanVien.setCccd(resultTable.getString("cccd"));
                nhanVien.setChucDanh(resultTable.getString("chuc_danh"));
                nhanVien.setGioiTinh(resultTable.getString("gioi_tinh"));
                nhanVien.setNgayBatDauLamViec(util.localDateParseMethod(resultTable.getString("ngay_bat_dau_lam_viec")));
                nhanVien.setNgaySinh(util.localDateParseMethod(resultTable.getString("ngay_sinh")));
                nhanVien.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                nhanVien.setTenNhanVien(resultTable.getString("ten_nhan_vien"));
                nhanVien.setNoLuong(Double.parseDouble(resultTable.getString("no_luong")));
                
                nhanVien.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                // vi nhan vien lai la 1-1 voi nhan vien nen lay ma duoc roi, keo bi lap vo hang
                nhanVien.setTaoBoiMaNhanVien(resultTable.getString("tao_boi_ma_nhan_vien"));
                nhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            }
        }
        return nhanVien;
    }
}
