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
import src.Model.BangLuong;
/**
 *
 * @author WINDOWS 10
 */
public class BangLuongService {
    public List<BangLuong> hienThiBangLuong(String maBangLuong) throws SQLException{
        String query = String.format("select * from bang_luong where ma_bang_luong='%s'", maBangLuong) ;
        
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<BangLuong> danhSachBangLuong = new ArrayList<>();
        while(resultTable.next()){
            BangLuong bangLuong = new BangLuong();
            for (i= 1; i <= q; i++){
                bangLuong.setMaBangLuong(resultTable.getString("ma_bang_luong"));
                bangLuong.setCheDoLuong(resultTable.getString("che_do_luong"));
                bangLuong.setPhuCap(resultTable.getDouble("phu_cap"));
                bangLuong.setTienLuong(resultTable.getDouble("tien_luong"));
                bangLuong.setTongLuong(resultTable.getDouble("tong_luong"));
            }
            danhSachBangLuong.add(bangLuong);
        }
        return danhSachBangLuong;
    }
    
}
