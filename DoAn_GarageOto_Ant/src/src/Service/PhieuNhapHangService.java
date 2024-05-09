 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Service;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import src.ConnectDB.ConnectorDB;
import src.Model.HoaDon;
import src.Model.PhieuNhapHang;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class PhieuNhapHangService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    private NhaCungCapService nhaCungCapService = new NhaCungCapService();
    private ChiNhanhServive chiNhanhServive = new ChiNhanhServive();
    private NhanVienService nhanVienService = new NhanVienService();
    
    public List<PhieuNhapHang> hienThiTatCaPhieuNhapHang () throws SQLException{ //
        String query = String.format("select * from phieu_nhap_hang");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<PhieuNhapHang> danhSachPhieuNhapHang = new ArrayList<>();
        while(resultTable.next()){
            PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
            for (i= 1; i <= q; i++){
                phieuNhapHang.setPhieuNhapHang(resultTable.getString("phieu_nhap_hang"));
                phieuNhapHang.setGiamGia(resultTable.getDouble("giam_gia"));
                phieuNhapHang.setThoiGian( util.localDateParseMethod(resultTable.getString("thoi_gian")));
                phieuNhapHang.setTong(resultTable.getDouble("tong"));
                phieuNhapHang.setTrangThai(resultTable.getString("trang_thai"));
                phieuNhapHang.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                phieuNhapHang.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                phieuNhapHang.setMaNhanVienTao(resultTable.getString("ma_nhan_vien"));
                phieuNhapHang.setDaTra(resultTable.getDouble("da_tra"));
            }
            danhSachPhieuNhapHang.add(phieuNhapHang);
        }
        connectorDB.closeConnection();
        return danhSachPhieuNhapHang;
    }
    
    public PhieuNhapHang layPhieuNhapHangDuaTrenMaPhieuNhapHang (String maPhieuNhapHang) throws SQLException{ //
        String query = String.format("select * from phieu_nhap_hang where phieu_nhap_hang = '%s'", maPhieuNhapHang);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                phieuNhapHang.setPhieuNhapHang(resultTable.getString("phieu_nhap_hang"));
                phieuNhapHang.setGiamGia(resultTable.getDouble("giam_gia"));
                phieuNhapHang.setThoiGian( util.localDateParseMethod(resultTable.getString("thoi_gian")));
                phieuNhapHang.setTong(resultTable.getDouble("tong"));
                phieuNhapHang.setTrangThai(resultTable.getString("trang_thai"));
                phieuNhapHang.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                phieuNhapHang.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                phieuNhapHang.setMaNhanVienTao(resultTable.getString("ma_nhan_vien"));
                phieuNhapHang.setDaTra(resultTable.getDouble("da_tra"));            }
        }
        connectorDB.closeConnection();
        return phieuNhapHang;
    }
    
    public int updatePhieuNhapHang (PhieuNhapHang phieuNhapHang) throws SQLException{ //   
        try{
           String query = String.format("update phieu_nhap_hang set trang_thai='%s', ma_nha_cung_cap='%s' where phieu_nhap_hang='%s'",
                             String.valueOf(phieuNhapHang.getTrangThai()),
                             String.valueOf(phieuNhapHang.getMaNhaCungCap()),
                             String.valueOf(phieuNhapHang.getPhieuNhapHang()));
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
     public int demSoPhieuNhapHang() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM phieu_nhap_hang;");
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
     
     public int themPhieuNhapHang (PhieuNhapHang phieuNhapHang) throws SQLException{ //   
        try{
           String query = String.format("insert into phieu_nhap_hang(phieu_nhap_hang, giam_gia, thoi_gian, da_tra, tong, trang_thai, ma_nha_cung_cap, ma_nhan_vien, ma_chi_nhanh)" +
                             "values ('%s', %s, '%s' , %s , %s, '%s', '%s', '%s', '%s' )",
                        phieuNhapHang.getPhieuNhapHang(),
                        phieuNhapHang.getGiamGia(),
                        util.localDateParseMethod(phieuNhapHang.getThoiGian()),
                        phieuNhapHang.getDaTra(),
                        phieuNhapHang.getTong(),
                        phieuNhapHang.getTrangThai(),
                        phieuNhapHang.getMaNhaCungCap(),
                        phieuNhapHang.getMaNhanVienTao(),
                        phieuNhapHang.getMaChiNhanh());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
     
     public List<PhieuNhapHang> hienThiPhieuNhapHangTheoNgayBatDauVaNgayKetThuc (LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select * from phieu_nhap_hang where thoi_gian between '%s' and '%s'", 
                String.valueOf(ngayBatDau), 
                String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<PhieuNhapHang> danhSachPhieuNhapHang = new ArrayList<>();
        while(resultTable.next()){
            PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
            for (i= 1; i <= q; i++){
                phieuNhapHang.setPhieuNhapHang(resultTable.getString("phieu_nhap_hang"));
                phieuNhapHang.setGiamGia(resultTable.getDouble("giam_gia"));
                phieuNhapHang.setThoiGian( util.localDateParseMethod(resultTable.getString("thoi_gian")));
                phieuNhapHang.setTong(resultTable.getDouble("tong"));
                phieuNhapHang.setTrangThai(resultTable.getString("trang_thai"));
                phieuNhapHang.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                phieuNhapHang.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                phieuNhapHang.setMaNhanVienTao(resultTable.getString("ma_nhan_vien"));
                phieuNhapHang.setDaTra(resultTable.getDouble("da_tra"));
            }
            danhSachPhieuNhapHang.add(phieuNhapHang);
        }
        connectorDB.closeConnection();
        return danhSachPhieuNhapHang;
    }
}
