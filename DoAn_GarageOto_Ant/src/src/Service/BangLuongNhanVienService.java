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

/**
 *
 * @author WINDOWS 10
 */
public class BangLuongNhanVienService {
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
            bangLuongNhanVien.setDaXuLy(resultTable.getBoolean("da_xu_ly"));
        }
        connectorDB.closeConnection();
        return bangLuongNhanVien;
    }
    
    public BangLuongNhanVien hienThiBangLuongNhanVienTheoLichLamViec(String maLichLamViec) throws SQLException{
        String query = String.format("select * from bang_luong_nhan_vien where ma_lich_lam_viec = '%s'", maLichLamViec) ;
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
        while(resultTable.next()){
            bangLuongNhanVien.setMa(resultTable.getString("ma"));
            bangLuongNhanVien.setMaBangLuong(resultTable.getString("ma_bang_luong"));
            bangLuongNhanVien.setMaPhieuLuong(resultTable.getString("ma_phieu_luong"));
            bangLuongNhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            bangLuongNhanVien.setMa_nhan_vien(resultTable.getString("ma_nhan_vien"));
            bangLuongNhanVien.setDaXuLy(resultTable.getBoolean("da_xu_ly"));
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
            bangLuongNhanVien.setDaXuLy(resultTable.getBoolean("da_xu_ly"));
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
           String query = String.format("insert into bang_luong_nhan_vien(ma, ma_bang_luong, ma_phieu_luong, ma_lich_lam_viec) " +
                             "values ('%s', '%s', '%s', '%s')",
                             bangLuongNhanVien.getMa(),
                             bangLuongNhanVien.getMaBangLuong(),
                             bangLuongNhanVien.getMaPhieuLuong(),
                             bangLuongNhanVien.getMaLichLamViec());
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
}
