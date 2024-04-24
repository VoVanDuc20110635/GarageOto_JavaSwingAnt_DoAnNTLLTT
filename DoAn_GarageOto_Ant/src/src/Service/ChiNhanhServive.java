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
import java.time.format.DateTimeFormatter;
import src.Util.Util;
import src.Model.ChiNhanh;
/**
 *
 * @author WINDOWS 10
 */
public class ChiNhanhServive {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<ChiNhanh> hienThiTatCaChiNhanh () throws SQLException{ //
        String query = String.format("select * from chi_nhanh");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<ChiNhanh> danhSachChiNhanh = new ArrayList<>();
        while(resultTable.next()){
            ChiNhanh chiNhanh = new ChiNhanh();
            for (i= 1; i <= q; i++){
                chiNhanh.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                chiNhanh.setDiaChi(resultTable.getString("dia_chi"));
                chiNhanh.setTenChiNhanh(resultTable.getString("ten_chi_nhanh"));
                chiNhanh.setTrangThai(resultTable.getString("trang_thai"));
                chiNhanh.setSoDienThoai(resultTable.getString("so_dien_thoai"));
            }
            danhSachChiNhanh.add(chiNhanh);
        }
        connectorDB.closeConnection();
        return danhSachChiNhanh;
    }
    
    public ChiNhanh hienThiChiNhanhTheoMaChiNhanh (String maChiNhanh) throws SQLException{ //
        String query = String.format("select * from chi_nhanh where ma_chi_nhanh = '%s'", maChiNhanh);        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        ChiNhanh chiNhanh = new ChiNhanh();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                chiNhanh.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                chiNhanh.setDiaChi(resultTable.getString("dia_chi"));
                chiNhanh.setTenChiNhanh(resultTable.getString("ten_chi_nhanh"));
                chiNhanh.setTrangThai(resultTable.getString("trang_thai"));
                chiNhanh.setSoDienThoai(resultTable.getString("so_dien_thoai"));
            }
        }
        connectorDB.closeConnection();
        return chiNhanh;
    }
    
    public int themChiNhanh (ChiNhanh chiNhanh) throws SQLException{ //   
        try{
           String query = String.format("insert into chi_nhanh(ma_chi_nhanh, dia_chi, so_dien_thoai, ten_chi_nhanh, trang_thai) " +
                             "values ('%s', '%s', '%s', '%s', '%s')",
                            chiNhanh.getMaChiNhanh(),
                            chiNhanh.getDiaChi(),
                            chiNhanh.getSoDienThoai(),
                            chiNhanh.getTenChiNhanh(),
                            chiNhanh.getTrangThai());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatChiNhanh (ChiNhanh chiNhanh) throws SQLException{ //   
        try{
           String query = String.format("update chi_nhanh set dia_chi = '%s', ten_chi_nhanh = '%s', trang_thai = '%s', so_dien_thoai = '%s' where ma_chi_nhanh = '%s'",
                            chiNhanh.getDiaChi(),                            
                            chiNhanh.getTenChiNhanh(),
                            chiNhanh.getTrangThai(),
                            chiNhanh.getSoDienThoai(),
                            chiNhanh.getMaChiNhanh());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    public int demSoChiNhanh() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM chi_nhanh;");
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
