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
import src.Model.PhieuTraHang;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class PhieuTraHangService {
    private Util util = new Util();
    public List<PhieuTraHang> hienThiTatCaPhieuTraHang () throws SQLException{ //
        String query = String.format("select * from phieu_tra_hang");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<PhieuTraHang> danhSachPhieuTraHang = new ArrayList<>();
        while(resultTable.next()){
            PhieuTraHang phieuTraHang = new PhieuTraHang();
            
                phieuTraHang.setMaPhieuTraHang(resultTable.getString("ma_phieu_tra_hang"));
                phieuTraHang.setCanTra(resultTable.getDouble("can_tra"));
                phieuTraHang.setDaTra(resultTable.getDouble("da_tra"));
                phieuTraHang.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                phieuTraHang.setMaHoaDon(resultTable.getString("ma_hoa_don"));
                phieuTraHang.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                phieuTraHang.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                phieuTraHang.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                phieuTraHang.setTrangThai(resultTable.getString("trang_thai"));
            
            danhSachPhieuTraHang.add(phieuTraHang);
        }
        return danhSachPhieuTraHang;
    }
    
    public PhieuTraHang hienThiPhieuTraHangTheoMaPhieuTraHang (String maPhieuTraHang) throws SQLException{ //
        String query = String.format("select * from phieu_tra_hang where ma_phieu_tra_hang = '%s'", maPhieuTraHang);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        PhieuTraHang phieuTraHang = new PhieuTraHang();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                phieuTraHang.setMaPhieuTraHang(resultTable.getString("ma_phieu_tra_hang"));
                phieuTraHang.setCanTra(resultTable.getDouble("can_tra"));
                phieuTraHang.setDaTra(resultTable.getDouble("da_tra"));
                phieuTraHang.setThoiGian(util.localDateParseMethod(resultTable.getString("da_tra_khach")));
                phieuTraHang.setMaHoaDon(resultTable.getString("ma_hoa_don"));
                phieuTraHang.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                phieuTraHang.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                phieuTraHang.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                phieuTraHang.setTrangThai(resultTable.getString("trang_thai"));
            }
        }
        return phieuTraHang;
    }
    
    public double tinhTongTienThuDuocSauKhiTraHang(String maKhachHang) throws SQLException{
        String query = String.format("select * from phieu_tra_hang where ma_khach_hang = '%s'", maKhachHang);
        double tongTien = 0;
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        PhieuTraHang phieuTraHang = new PhieuTraHang();
        while(resultTable.next()){
            tongTien += resultTable.getDouble("can_tra");
            
        }
        return tongTien;
    }
}
