/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import src.ConnectDB.ConnectorDB;
import src.Model.BangLuongNhanVien;
import src.Model.PhieuLuong;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
    public class PhieuLuongService {
    private ConnectorDB connectorDB = new ConnectorDB();
    private Util util = new Util();
    public List<PhieuLuong> hienThiPhieuLuong() throws SQLException{
        String query = String.format("select * from phieu_luong");
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<PhieuLuong> danhSachPhieuLuong = new ArrayList<>();
        while(resultTable.next()){
            PhieuLuong phieuLuong = new PhieuLuong();
            phieuLuong.setMaPhieu(resultTable.getString("ma_phieu"));
            phieuLuong.setDaTra(resultTable.getDouble("da_tra"));
            phieuLuong.setTongLuong(resultTable.getDouble("tong_luong"));
            phieuLuong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            phieuLuong.setMaNhanVienIn(resultTable.getString("ma_nhan_vien_in"));
            phieuLuong.setNgayIn(util.localDateParseMethod(resultTable.getString("ma_nhan_vien_in")));
            danhSachPhieuLuong.add(phieuLuong);
        }
        connectorDB.closeConnection();
        return danhSachPhieuLuong;
    }
    
    public PhieuLuong hienThiPhieuLuongTheoMaBangLuongNhanVien(String maBangLuongNhanVien) throws SQLException{
        String query = String.format("select * from phieu_luong where ma_bang_luong_nhan_vien = '%s'", maBangLuongNhanVien);
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        PhieuLuong phieuLuong = new PhieuLuong();
        while(resultTable.next()){
            phieuLuong.setMaPhieu(resultTable.getString("ma_phieu"));
            phieuLuong.setDaTra(resultTable.getDouble("da_tra"));
            phieuLuong.setTongLuong(resultTable.getDouble("tong_luong"));
            phieuLuong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            phieuLuong.setMaNhanVienIn(resultTable.getString("ma_nhan_vien_in"));
            phieuLuong.setNgayIn(util.localDateParseMethod(resultTable.getString("ma_nhan_vien_in")));
        }
        connectorDB.closeConnection();
        return phieuLuong;
    }
    
    public List<PhieuLuong> hienThiPhieuLuongTheoMaNhanVien(String maNhanVien) throws SQLException{
        String query = String.format("select * from phieu_luong where ma_nhan_vien = '%s'", maNhanVien);
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<PhieuLuong> danhSachPhieuLuong = new ArrayList<PhieuLuong>();
        while(resultTable.next()){
            PhieuLuong phieuLuong = new PhieuLuong();
            phieuLuong.setMaPhieu(resultTable.getString("ma_phieu"));
            phieuLuong.setDaTra(resultTable.getDouble("da_tra"));
            phieuLuong.setTongLuong(resultTable.getDouble("tong_luong"));
            phieuLuong.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            phieuLuong.setMaNhanVienIn(resultTable.getString("ma_nhan_vien_in"));
            phieuLuong.setNgayIn(util.localDateParseMethod(resultTable.getString("ma_nhan_vien_in")));
            danhSachPhieuLuong.add(phieuLuong);
        }
        connectorDB.closeConnection();
        return danhSachPhieuLuong;
    }
    
    public int demSoPhieuLuong() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM phieu_luong;");
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
    public int themPhieuLuong (PhieuLuong phieuLuong) throws SQLException{ //   
        try{
           String query = String.format("insert into phieu_luong(ma_phieu, da_tra, tong_luong, ngay_in, ma_nhan_vien_in, ma_nhan_vien) " +
                             "values ('%s', %s, %s, '%s', '%s', '%s')",
                             phieuLuong.getMaPhieu(),
                             String.valueOf(phieuLuong.getDaTra()),
                             String.valueOf(phieuLuong.getTongLuong()),
                             util.localDateParseMethod(phieuLuong.getNgayIn()),
                             phieuLuong.getMaNhanVienIn(),
                             phieuLuong.getMaNhanVien());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatPhieuLuong (PhieuLuong phieuLuong) throws SQLException{ //   
        try{
           String query = String.format("update phieu_luong set da_tra = '%s', tong_luong = '%s', ma_bang_luong_nhan_vien = '%s', where ma_phieu = '%s' ",
                             String.valueOf(phieuLuong.getDaTra()),
                             String.valueOf(phieuLuong.getTongLuong()),
                             util.localDateParseMethod(phieuLuong.getNgayIn()),
                             phieuLuong.getMaNhanVienIn(),
                             phieuLuong.getMaNhanVien(),
                             phieuLuong.getMaPhieu());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
