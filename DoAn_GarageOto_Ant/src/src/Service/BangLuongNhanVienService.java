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
import src.Model.BangLuong;
import src.Model.BangLuongNhanVien;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class BangLuongNhanVienService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    public BangLuongNhanVien hienThiBangLuongNhanVienTheoMa(String ma) throws SQLException{
        String query = String.format("select * from bang_luong_nhan_vien where ma = '%s'", ma) ;
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
        while(resultTable.next()){
            bangLuongNhanVien.setMa(resultTable.getString("ma"));
            bangLuongNhanVien.setMaBangLuong(resultTable.getString("ma_bang_luong"));
            bangLuongNhanVien.setMaPhieuLuong(resultTable.getString("ma_phieu_luong"));
            bangLuongNhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            bangLuongNhanVien.setMa_nhan_vien(resultTable.getString("ma_nhan_vien"));
            bangLuongNhanVien.setThoiGian(util.localDateParseMethodToLocalDate(resultTable.getString("thoi_gian")));
//            bangLuongNhanVien.setDaXuLy(resultTable.getBoolean("da_xu_ly"));
        }
        connectorDB.closeConnection();
        return bangLuongNhanVien;
    }
    
    public BangLuongNhanVien hienThiBangLuongNhanVienTheoLichLamViec(String maLichLamViec) throws SQLException{
        String query = String.format("select * from bang_luong_nhan_vien where ma_lich_lam_viec = '%s'", maLichLamViec) ;
        System.out.println(query);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
        while(resultTable.next()){
            bangLuongNhanVien.setMa(resultTable.getString("ma"));
            bangLuongNhanVien.setMaBangLuong(resultTable.getString("ma_bang_luong"));
            bangLuongNhanVien.setMaPhieuLuong(resultTable.getString("ma_phieu_luong"));
            bangLuongNhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            bangLuongNhanVien.setMa_nhan_vien(resultTable.getString("ma_nhan_vien"));
//            bangLuongNhanVien.setDaXuLy(resultTable.getBoolean("da_xu_ly"));
            bangLuongNhanVien.setThoiGian(util.localDateParseMethodToLocalDate(resultTable.getString("thoi_gian")));
        }
        connectorDB.closeConnection();
        return bangLuongNhanVien;
    }
    
    public List<BangLuongNhanVien> hienThiBangLuongNhanVienTheoMaNhanVien(String maNhanVien) throws SQLException{
        String query = String.format("select * from bang_luong_nhan_vien where ma_nhan_vien = '%s'", maNhanVien) ;
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<BangLuongNhanVien> danhSachBangLuongNhanVien = new ArrayList<>();
        while(resultTable.next()){
            BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
            bangLuongNhanVien.setMa(resultTable.getString("ma"));
            bangLuongNhanVien.setMaBangLuong(resultTable.getString("ma_bang_luong"));
            bangLuongNhanVien.setMaPhieuLuong(resultTable.getString("ma_phieu_luong"));
            bangLuongNhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            bangLuongNhanVien.setMa_nhan_vien(resultTable.getString("ma_nhan_vien"));
            bangLuongNhanVien.setThoiGian(util.localDateParseMethodToLocalDate(resultTable.getString("thoi_gian")));
//            bangLuongNhanVien.setDaXuLy(resultTable.getBoolean("da_xu_ly"));
            danhSachBangLuongNhanVien.add(bangLuongNhanVien);
        }
        connectorDB.closeConnection();
        return danhSachBangLuongNhanVien;
    }
    
    public List<BangLuongNhanVien> hienThiTroCapBangLuongNhanVienTheoMaNhanVien(int month, int year, String maNhanVien) throws SQLException{
        String query = String.format("select * from bang_luong_nhan_vien where ma_bang_luong not like '%%BL%%' and ma_nhan_vien = '%s' and extract(month from thoi_gian) = %s and extract(year from thoi_gian) = %s ", maNhanVien, month , year) ;
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<BangLuongNhanVien> danhSachBangLuongNhanVien = new ArrayList<>();
        while(resultTable.next()){
            BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
            bangLuongNhanVien.setMa(resultTable.getString("ma"));
            bangLuongNhanVien.setMaBangLuong(resultTable.getString("ma_bang_luong"));
            bangLuongNhanVien.setMaPhieuLuong(resultTable.getString("ma_phieu_luong"));
            bangLuongNhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            bangLuongNhanVien.setMa_nhan_vien(resultTable.getString("ma_nhan_vien"));
            bangLuongNhanVien.setThoiGian(util.localDateParseMethodToLocalDate(resultTable.getString("thoi_gian")));
//            bangLuongNhanVien.setDaXuLy(resultTable.getBoolean("da_xu_ly"));
            danhSachBangLuongNhanVien.add(bangLuongNhanVien);
        }
        connectorDB.closeConnection();
        return danhSachBangLuongNhanVien;
    }
     
    public int demSoBangLuongNhanVien() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM bang_luong_nhan_vien;");
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
    
    public int themBangLuongNhanVien (BangLuongNhanVien bangLuongNhanVien) throws SQLException{ //   
        try{
           String query = String.format("insert into bang_luong_nhan_vien(ma, ma_bang_luong, ma_lich_lam_viec, ma_nhan_vien, thoi_gian) " +
                             "values ('%s', '%s', '%s', '%s', '%s')",
                             bangLuongNhanVien.getMa(),
                             bangLuongNhanVien.getMaBangLuong(),
                             bangLuongNhanVien.getMaLichLamViec(),
                             bangLuongNhanVien.getMa_nhan_vien(),
                             String.valueOf(bangLuongNhanVien.getThoiGian()));
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int themTroCapNhanVien (BangLuongNhanVien bangLuongNhanVien) throws SQLException{ //   
        try{
           String query = String.format("insert into bang_luong_nhan_vien(ma, ma_bang_luong, ma_nhan_vien, thoi_gian) " +
                             "values ('%s', '%s', '%s', '%s')",
                             bangLuongNhanVien.getMa(),
                             bangLuongNhanVien.getMaBangLuong(),
                             bangLuongNhanVien.getMa_nhan_vien(),
                             String.valueOf(bangLuongNhanVien.getThoiGian()));
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int xoaBangLuongNhanVien (String maLichLamViec) throws SQLException{ //   
        try{
           String query = String.format("delete from bang_luong_nhan_vien where ma_lich_lam_viec = '%s' and ma_phieu_luong is NULL ", maLichLamViec) ;
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int xoaTroCapNhanVien (String maBangLuong, String maNhanVien) throws SQLException{ //   
        try{
            String query = String.format("delete from bang_luong_nhan_vien where ma_bang_luong = '%s' and ma_nhan_vien = '%s'", maBangLuong, maNhanVien) ;
            System.out.println(query);
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatBangLuongNhanVien (BangLuongNhanVien bangLuongNhanVien) throws SQLException{ //   
        try{
           String query = String.format("update bang_luong_nhan_vien set ma_bang_luong = '%s', ma_phieu_luong = '%s', ma_lich_lam_viec = '%s', where ma = '%s' " ,
                             bangLuongNhanVien.getMaBangLuong(),
                             bangLuongNhanVien.getMaPhieuLuong(),
                             bangLuongNhanVien.getMaLichLamViec(),
                             bangLuongNhanVien.getMa());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public List<BangLuongNhanVien> hienThiBangLuongNhanVienTheoMaNhanVienVaThoiGian(String maNhanVien, int thang, int nam) throws SQLException{
        String query = String.format("select * from bang_luong_nhan_vien where ma_nhan_vien = '%s' and extract(year from thoi_gian) = %s and extract(month from thoi_gian) = %s", 
                maNhanVien, thang, nam) ;
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
        List<BangLuongNhanVien> danhSachBangLuongNhanVien = new ArrayList<>();
        while(resultTable.next()){
            bangLuongNhanVien.setMa(resultTable.getString("ma"));
            bangLuongNhanVien.setMaBangLuong(resultTable.getString("ma_bang_luong"));
            bangLuongNhanVien.setMaPhieuLuong(resultTable.getString("ma_phieu_luong"));
            bangLuongNhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            bangLuongNhanVien.setMa_nhan_vien(resultTable.getString("ma_nhan_vien"));
            bangLuongNhanVien.setThoiGian(util.localDateParseMethodToLocalDate(resultTable.getString("thoi_gian")));
//            bangLuongNhanVien.setDaXuLy(resultTable.getBoolean("da_xu_ly"));
            danhSachBangLuongNhanVien.add(bangLuongNhanVien);
        }
        connectorDB.closeConnection();
        return danhSachBangLuongNhanVien;
    }
}
