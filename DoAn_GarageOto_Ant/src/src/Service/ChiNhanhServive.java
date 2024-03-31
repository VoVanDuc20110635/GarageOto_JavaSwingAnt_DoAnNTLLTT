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
    public List<ChiNhanh> hienThiTatCaChiNhanh () throws SQLException{ //
        String query = String.format("select * from chi_nhanh");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
            }
            danhSachChiNhanh.add(chiNhanh);
        }
        return danhSachChiNhanh;
    }
    
    public ChiNhanh hienThiChiNhanhTheoMaChiNhanh (String maChiNhanh) throws SQLException{ //
        String query = String.format("select * from chi_nhanh where ma_chi_nhanh = '%s'", maChiNhanh);        
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
            }
        }
        return chiNhanh;
    }
}
