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
import java.time.format.DateTimeFormatter;
import src.Model.HoaDon;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class HoaDonService {
    private ConnectorDB connectorDB = new ConnectorDB();
    private Util util = new Util();
    public List<HoaDon> hienThiTatCaHoaDon () throws SQLException{ //
        String query = String.format("select * from hoa_don");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        while(resultTable.next()){
            HoaDon hoaDon = new HoaDon();
            for (i= 1; i <= q; i++){
                hoaDon.setMaHoaDon(resultTable.getString("ma_hoa_don"));
                hoaDon.setGiamGia(resultTable.getDouble("giam_gia"));
                hoaDon.setLoaiThuChi(resultTable.getString("loai_thu_chi"));
                hoaDon.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                hoaDon.setTienDaTra(resultTable.getDouble("tien_da_tra"));
                hoaDon.setTongTien(resultTable.getDouble("tong_tien"));
                
                hoaDon.setTrangThai(resultTable.getString("trang_thai"));
                hoaDon.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                hoaDon.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                hoaDon.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                hoaDon.setMaPhieuTraHang(resultTable.getString("ma_phieu_tra_hang"));
                hoaDon.setGhiChu(resultTable.getString("ghi_chu"));
            }
            danhSachHoaDon.add(hoaDon);
        }
        connectorDB.closeConnection();
        return danhSachHoaDon;
    }
    
    public HoaDon hienThiHoaDonTheoMaHoadon (String maHoaDon) throws SQLException{ //
        String query = String.format("select * from hoa_don where ma_hoa_don = '%s'", maHoaDon);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        HoaDon hoaDon = new HoaDon();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                hoaDon.setMaHoaDon(resultTable.getString("ma_hoa_don"));
                hoaDon.setGiamGia(resultTable.getDouble("giam_gia"));
                hoaDon.setLoaiThuChi(resultTable.getString("loai_thu_chi"));
                hoaDon.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                hoaDon.setTienDaTra(resultTable.getDouble("tien_da_tra"));
                hoaDon.setTongTien(resultTable.getDouble("tong_tien"));
                
                hoaDon.setTrangThai(resultTable.getString("trang_thai"));
                hoaDon.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                hoaDon.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                hoaDon.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                hoaDon.setGhiChu(resultTable.getString("ghi_chu"));
                hoaDon.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
            }
        }
        connectorDB.closeConnection();
        return hoaDon;
    }
    public int demSoHoaDon() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM hoa_don;");
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
    public int themHoaDon (HoaDon hoaDon) throws SQLException{ //   
        try{
           String query = String.format("insert into hoa_don(ma_hoa_don, giam_gia, loai_thu_chi, thoi_gian, tien_da_tra, tong_tien, trang_thai, ma_khach_hang, ma_nhan_vien, ma_chi_nhanh)" +
                             "values ('%s', %s, '%s', '%s' , %s , %s, '%s', '%s', '%s', '%s' )",
                hoaDon.getMaHoaDon(),
                hoaDon.getGiamGia(),
                hoaDon.getLoaiThuChi(),
                util.localDateParseMethod( hoaDon.getThoiGian()),
                hoaDon.getTienDaTra(),
                hoaDon.getTongTien(),
                hoaDon.getTrangThai(),
                hoaDon.getMaKhachHang(),
                hoaDon.getMaNhanVien(),
                hoaDon.getMaChiNhanh());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public List<HoaDon> hienThiHoaDonTheoNgayBatDauVaNgayKetThuc (LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select * from hoa_don where thoi_gian between '%s' and '%s'", 
                String.valueOf(ngayBatDau), 
                String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        while(resultTable.next()){
            HoaDon hoaDon = new HoaDon();
            for (i= 1; i <= q; i++){
                hoaDon.setMaHoaDon(resultTable.getString("ma_hoa_don"));
                hoaDon.setGiamGia(resultTable.getDouble("giam_gia"));
                hoaDon.setLoaiThuChi(resultTable.getString("loai_thu_chi"));
                hoaDon.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                hoaDon.setTienDaTra(resultTable.getDouble("tien_da_tra"));
                hoaDon.setTongTien(resultTable.getDouble("tong_tien"));
                
                hoaDon.setTrangThai(resultTable.getString("trang_thai"));
                hoaDon.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                hoaDon.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                hoaDon.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                hoaDon.setMaPhieuTraHang(resultTable.getString("ma_phieu_tra_hang"));
                hoaDon.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
            }
            danhSachHoaDon.add(hoaDon);
        }
        connectorDB.closeConnection();
        return danhSachHoaDon;
    }
    
    public int updateHoaDon (HoaDon hoaDon) throws SQLException{ //   
        try{
           String query = String.format("update hoa_don set ghi_chu='%s' where ma_hoa_don = '%s'",
                             hoaDon.getGhiChu(),
                             hoaDon.getMaHoaDon());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
