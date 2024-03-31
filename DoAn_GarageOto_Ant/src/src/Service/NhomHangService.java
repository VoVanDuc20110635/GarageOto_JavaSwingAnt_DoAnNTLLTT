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
import src.Model.NhomHang;
/**
 *
 * @author WINDOWS 10
 */
public class NhomHangService {
    public List<NhomHang> hienThiTatCaNhomHang() throws SQLException{ //
        String query = String.format("select * from nhom_hang ");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<NhomHang> danhSachNhomHang = new ArrayList<>();
        while(resultTable.next()){
            NhomHang nhomHang = new NhomHang();
            for (i= 1; i <= q; i++){
                nhomHang.setMaNhomHang(resultTable.getString("ma_nhom_hang"));
                nhomHang.setTenNhomHang(resultTable.getString("dich_vu_lien_quan"));
            }
            danhSachNhomHang.add(nhomHang);
        }
        return danhSachNhomHang;
    }
    
    public NhomHang hienThiNhomHangTheoMaNhomHang(String maNhomHang) throws SQLException{ //
        String query = String.format("select * from nhom_hang where ma_nhom_hang = '%s'", maNhomHang);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        NhomHang nhomHang = new NhomHang();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                nhomHang.setMaNhomHang(resultTable.getString("ma_nhom_hang"));
                nhomHang.setTenNhomHang(resultTable.getString("ten_nhom_hang"));
            }
        }
        return nhomHang;
    }
}
