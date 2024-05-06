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
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<BangChamCong> hienThiTatCaBangChamCong () throws SQLException{ //
        String query = String.format("select * from bang_cham_cong");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));

                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));

                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        connectorDB.closeConnection();
        return danhSachBangChamCong;
    }
    public List<BangChamCong> hienThiBangChamCongTheoMaNhanVien (String maNhanVien) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where ma_nhan_vien='%s'",
                             maNhanVien);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
          
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
          
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        connectorDB.closeConnection();
        return danhSachBangChamCong;
    }
    
    public List<BangChamCong> hienThiBangChamCongTheoMaNhanVien (int month, int year, String maNhanVien) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where ma_nhan_vien='%s' and extract(month from ngay_lam) = %s and extract(year from ngay_lam) = %s and trang_thai not like '%%Đầy đủ%%'",
                             maNhanVien, month, year);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
              
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
              
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        connectorDB.closeConnection();
        return danhSachBangChamCong;
    }
    
    public int themBangChamCong (BangChamCong bangChamCongMoi) throws SQLException{ //   
        try{
           String query = String.format("insert into bang_cham_cong(ma_bang_cham_cong, ngay_lam, trang_thai, ma_nhan_vien) " +
                             "values ('%s', '%s', '%s', '%s')",
                             bangChamCongMoi.getMaBangChamCong(),
                             String.valueOf(bangChamCongMoi.getNgayLam()),
                             bangChamCongMoi.getTrangThai(),
                      
                             bangChamCongMoi.getMaNhanVien());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int updateBangChamCong (BangChamCong bangChamCongMoi) throws SQLException{ //   
        try{
           String query = String.format("update bang_cham_cong set ngay_lam='%s', trang_thai='%s', ma_nhan_vien='%s' where ma_bang_cham_cong='%s'",
                             String.valueOf(bangChamCongMoi.getNgayLam()),
                             bangChamCongMoi.getTrangThai(),
                             bangChamCongMoi.getMaNhanVien(),
                             bangChamCongMoi.getMaBangChamCong());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public List<BangChamCong> hienThiBangChamCongTheoTheoNgayBatDauVaNgayKetThuc (Date ngayBatDau, Date ngayKetThuc) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where ngay_lam between '%s' and '%s'",
                             util.layNgayString(ngayBatDau), util.layNgayString(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        connectorDB.closeConnection();
        return danhSachBangChamCong;
    }
    
    public List<BangChamCong> hienThiBangChamCongTheoTheoNgay (Date date) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where DATE(ngay_lam) = '%s'",
                             util.layNgayString(date));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        connectorDB.closeConnection();
        return danhSachBangChamCong;
    }
    
    public List<BangChamCong> hienThiBangChamCongTheoTheoThang (String thang, String nam) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where MONTH(ngay_lam) = %s and YEAR(ngay_lam) = %s",
                             thang, nam);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        connectorDB.closeConnection();
        return danhSachBangChamCong;
    }
    
    public List<BangChamCong> hienThiBangChamCongTheoTheoNam ( String nam) throws SQLException{ //
        String query = String.format("select * from bang_cham_cong where YEAR(ngay_lam) = %s",
                             nam);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        while(resultTable.next()){
            BangChamCong bangChamCong = new BangChamCong();
            for (i= 1; i <= q; i++){
                bangChamCong.setMaBangChamCong(resultTable.getString("ma_bang_cham_cong"));
                bangChamCong.setNgayLam(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_lam")));
                bangChamCong.setTrangThai(resultTable.getString("trang_thai"));
                bangChamCong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSachBangChamCong.add(bangChamCong);
        }
        connectorDB.closeConnection();
        return danhSachBangChamCong;
    }
    
    public int demSoLuongNhanVienTrongKhoangThoiGian (LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException{ //
        String query = String.format("select count(DISTINCT ma_nhan_vien) as so_luong from bang_cham_cong where ngay_lam between '%s 00:00:00' and '%s 23:59:59' and trang_thai not like 'Vắng';",
                             String.valueOf(ngayBatDau), String.valueOf(ngayKetThuc));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        int soLuongNhanVien = 0;
        while(resultTable.next()){
            soLuongNhanVien = resultTable.getInt("so_luong");
        }
        connectorDB.closeConnection();
        return soLuongNhanVien;
    }
    
    public int demSoLuongNhanVienTrongNgayNhatDinh (LocalDate ngayBatDau) throws SQLException{ //
        String query = String.format("select count(DISTINCT ma_nhan_vien) as so_luong from bang_cham_cong where ngay_lam = '%s' and trang_thai not like 'Vắng';",
                             String.valueOf(ngayBatDau));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        int soLuongNhanVien = 0;
        while(resultTable.next()){
            soLuongNhanVien = resultTable.getInt("so_luong");
        }
        connectorDB.closeConnection();
        return soLuongNhanVien;
    }
    
    public int demSoLuongNhanVienTrongThangNhatDinh (int thang, int nam) throws SQLException{ //
        String query = String.format("select count(DISTINCT ma_nhan_vien) as so_luong from bang_cham_cong where year(ngay_lam) = %s and month(ngay_lam) = %s and trang_thai not like 'Vắng';",
                             String.valueOf(nam), String.valueOf(thang));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        int soLuongNhanVien = 0;
        while(resultTable.next()){
            soLuongNhanVien = resultTable.getInt("so_luong");
        }
        connectorDB.closeConnection();
        return soLuongNhanVien;
    }
    
    public int demSoLuongNhanVienTrongNamNhatDinh (int nam) throws SQLException{ //
        String query = String.format("select count(DISTINCT ma_nhan_vien) as so_luong from bang_cham_cong where year(ngay_lam) = %s and trang_thai not like 'Vắng';",
                             String.valueOf(nam));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        int soLuongNhanVien = 0;
        while(resultTable.next()){
            soLuongNhanVien = resultTable.getInt("so_luong");
        }
        connectorDB.closeConnection();
        return soLuongNhanVien;
    }
    
    public int kiemTraDiemDanhNhanVien (LocalDate ngayLam, String maNhanVien) throws SQLException{ //
        String query = String.format("select count(ma_nhan_vien) as so_luong from bang_cham_cong where ngay_lam = '%s' and ma_nhan_vien = '%s';",
                             String.valueOf(ngayLam), String.valueOf(maNhanVien));
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
        int soLuongNhanVien = 0;
        while(resultTable.next()){
            soLuongNhanVien = resultTable.getInt("so_luong");
        }
        connectorDB.closeConnection();
        return soLuongNhanVien;
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
