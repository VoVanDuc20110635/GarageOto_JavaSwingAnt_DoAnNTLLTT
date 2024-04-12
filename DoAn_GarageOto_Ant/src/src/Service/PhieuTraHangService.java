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
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<PhieuTraHang> hienThiTatCaPhieuTraHang () throws SQLException{ //
        String query = String.format("select * from phieu_tra_hang");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
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
                phieuTraHang.setMaChiNhanh(resultTable.getString("ma_nha_cung_cap"));
            danhSachPhieuTraHang.add(phieuTraHang);
        }
        connectorDB.closeConnection();
        return danhSachPhieuTraHang;
    }
    
    public PhieuTraHang hienThiPhieuTraHangTheoMaPhieuTraHang (String maPhieuTraHang) throws SQLException{ //
        String query = String.format("select * from phieu_tra_hang where ma_phieu_tra_hang = '%s'", maPhieuTraHang);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        PhieuTraHang phieuTraHang = new PhieuTraHang();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                phieuTraHang.setMaPhieuTraHang(resultTable.getString("ma_phieu_tra_hang"));
                phieuTraHang.setCanTra(resultTable.getDouble("can_tra"));
                phieuTraHang.setDaTra(resultTable.getDouble("da_tra"));
                phieuTraHang.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                phieuTraHang.setMaHoaDon(resultTable.getString("ma_hoa_don"));
                phieuTraHang.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                phieuTraHang.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                phieuTraHang.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                phieuTraHang.setTrangThai(resultTable.getString("trang_thai"));
                phieuTraHang.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
            }
        }
        connectorDB.closeConnection();
        return phieuTraHang;
    }
    
    public double tinhTongTienThuDuocSauKhiTraHang(String maKhachHang) throws SQLException{
        String query = String.format("select * from phieu_tra_hang where ma_khach_hang = '%s'", maKhachHang);
        double tongTien = 0;
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        PhieuTraHang phieuTraHang = new PhieuTraHang();
        while(resultTable.next()){
            tongTien += resultTable.getDouble("can_tra");
            
        }
        connectorDB.closeConnection();
        return tongTien;
    }
    
    public int themPhieuTraHangKhachHang (PhieuTraHang phieuTraHang) throws SQLException{ //   
        try{
           String query = String.format("insert into phieu_tra_hang(ma_phieu_tra_hang, can_tra, da_tra, thoi_gian, ma_hoa_don, ma_khach_hang, ma_nhan_vien, trang_thai, ma_nha_cung_cap)" +
                             "values ('%s', %s, %s, '%s' , '%s' , '%s', '%s', '%s', '%s' )",
                phieuTraHang.getMaPhieuTraHang(),
                String.valueOf(phieuTraHang.getCanTra()),
                String.valueOf(phieuTraHang.getDaTra()),
                util.localDateParseMethod( phieuTraHang.getThoiGian()),
                phieuTraHang.getMaHoaDon(),
                phieuTraHang.getMaKhachHang(),
                phieuTraHang.getMaNhanVien(),
                phieuTraHang.getTrangThai(),
                phieuTraHang.getMaChiNhanh());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int themPhieuTraHangNhaCungCap (PhieuTraHang phieuTraHang) throws SQLException{ //   
        try{
           String query = String.format("insert into phieu_tra_hang(ma_phieu_tra_hang, can_tra, da_tra, thoi_gian, ma_hoa_don, ma_nha_cung_cap, ma_nhan_vien, trang_thai)" +
                             "values ('%s', %s, %s, '%s' , '%s' , '%s', '%s', '%s' )",
                phieuTraHang.getMaPhieuTraHang(),
                String.valueOf(phieuTraHang.getCanTra()),
                String.valueOf(phieuTraHang.getDaTra()),
                util.localDateParseMethod( phieuTraHang.getThoiGian()),
                phieuTraHang.getMaHoaDon(),
                phieuTraHang.getMaNhaCungCap(),
                phieuTraHang.getMaNhanVien(),
                phieuTraHang.getTrangThai());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    public int demSoPhieuTraHang() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM phieu_tra_hang;");
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
    
}
