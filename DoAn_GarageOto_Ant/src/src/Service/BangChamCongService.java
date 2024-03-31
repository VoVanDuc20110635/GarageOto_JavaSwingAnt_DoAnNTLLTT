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
import java.util.Date;
import src.Model.BangChamCong;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class BangChamCongService {
    private Util util = new Util();
    public List<BangChamCong> hienThiTatCaBangChamCong () throws SQLException{ //
        String query = String.format("select * from bang_cham_cong");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                bangChamCong.setGioTangCa(resultTable.getShort("gio_tang_ca"));
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                bangChamCong.setMaCaLam(resultTable.getString("ma_ca_lam"));
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        return danhSachBangChamCong;
    }
    public List<BangChamCong> hienThiBangChamCongTheoMaNhanVien (String maNhanVien) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where ma_nhan_vien='%s'",
                             maNhanVien);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                bangChamCong.setGioTangCa(resultTable.getShort("gio_tang_ca"));
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                bangChamCong.setMaCaLam(resultTable.getString("ma_ca_lam"));
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        return danhSachBangChamCong;
    }
    
    public int themBangChamCong (BangChamCong bangChamCongMoi) throws SQLException{ //   
        try{
           String query = String.format("insert into bang_cham_cong(ma_bang_cham_cong, ngay_lam, trang_thai, ma_ca_lam, ma_nhan_vien) " +
                             "values ('%s', '%s', '%s', '%s', '%s')",
                             bangChamCongMoi.getMaBangChamCong(),
                             String.valueOf(bangChamCongMoi.getNgayLam()),
                             bangChamCongMoi.getTrangThai(),
                             bangChamCongMoi.getMaCaLam(),
                             bangChamCongMoi.getMaNhanVien());
            ConnectorDB.executeUpdateQueryConnectorDB(query);
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int updateBangChamCong (BangChamCong bangChamCongMoi) throws SQLException{ //   
        try{
           String query = String.format("update bang_cham_cong set ngay_lam='%s', trang_thai='%s', ma_ca_lam='%s', ma_nhan_vien='%s' where ma_bang_cham_cong='%s'",
                             String.valueOf(bangChamCongMoi.getNgayLam()),
                             bangChamCongMoi.getTrangThai(),
                             bangChamCongMoi.getMaCaLam(),
                             bangChamCongMoi.getMaNhanVien(),
                             bangChamCongMoi.getMaBangChamCong());
            ConnectorDB.executeUpdateQueryConnectorDB(query);
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public List<BangChamCong> hienThiBangChamCongTheoTheoNgayBatDauVaNgayKetThuc (Date ngayBatDau, Date ngayKetThuc) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where ngay_lam between '%s' and '%s'",
                             util.layNgayString(ngayBatDau), util.layNgayString(ngayKetThuc));
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                bangChamCong.setGioTangCa(resultTable.getShort("gio_tang_ca"));
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                bangChamCong.setMaCaLam(resultTable.getString("ma_ca_lam"));
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        return danhSachBangChamCong;
    }
    
    public List<BangChamCong> hienThiBangChamCongTheoTheoNgay (Date date) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where DATE(ngay_lam) = '%s'",
                             util.layNgayString(date));
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                bangChamCong.setGioTangCa(resultTable.getShort("gio_tang_ca"));
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                bangChamCong.setMaCaLam(resultTable.getString("ma_ca_lam"));
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        return danhSachBangChamCong;
    }
    
    public List<BangChamCong> hienThiBangChamCongTheoTheoThang (String thang, String nam) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where MONTH(ngay_lam) = %s and YEAR(ngay_lam) = %s",
                             thang, nam);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                bangChamCong.setGioTangCa(resultTable.getShort("gio_tang_ca"));
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                bangChamCong.setMaCaLam(resultTable.getString("ma_ca_lam"));
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        return danhSachBangChamCong;
    }
    
    public List<BangChamCong> hienThiBangChamCongTheoTheoNam ( String nam) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where YEAR(ngay_lam) = %s",
                             nam);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                bangChamCong.setGioTangCa(resultTable.getShort("gio_tang_ca"));
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                bangChamCong.setMaCaLam(resultTable.getString("ma_ca_lam"));
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        return danhSachBangChamCong;
    }
    
    public LocalDateTime localDateParseMethod(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime ngayLam = LocalDateTime.parse(dateString, formatter);
        return ngayLam;
    }
    public String localDateParseMethod(LocalDateTime ngayLam){
        String formattedNgayLam = ngayLam.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return formattedNgayLam;
    }
}
