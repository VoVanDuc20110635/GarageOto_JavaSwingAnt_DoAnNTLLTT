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
import src.Model.LoaiXe;
/**
 *
 * @author WINDOWS 10
 */
public class LoaiXeService {
    public List<LoaiXe> hienThiTatCaLoaiXe() throws SQLException{ //
        String query = String.format("select * from loai_xe ");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<LoaiXe> danhSachLoaiXe = new ArrayList<>();
        while(resultTable.next()){
            LoaiXe loaiXe = new LoaiXe();
            for (i= 1; i <= q; i++){
                loaiXe.setMaLoaiXe(resultTable.getString("ma_loai_xe"));
                loaiXe.setTenLoaiXe(resultTable.getString("ten_loai_xe"));
            }
            danhSachLoaiXe.add(loaiXe);
        }
        return danhSachLoaiXe;
    }
    
    public LoaiXe hienThiLoaiXeTheoMaLoaiXe(String maLoaiXe) throws SQLException{ //
        String query = String.format("select * from loai_xe where ma_loai_xe = '%s'", maLoaiXe);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        LoaiXe loaiXe = new LoaiXe();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                loaiXe.setMaLoaiXe(resultTable.getString("ma_loai_xe"));
                loaiXe.setTenLoaiXe(resultTable.getString("ten_loai_xe"));
            }
        }
        return loaiXe;
    }
}
