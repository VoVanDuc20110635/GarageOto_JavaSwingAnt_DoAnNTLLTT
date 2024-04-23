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
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<BangLuong> hienThiBangLuong() throws SQLException{
        String query = String.format("select * from bang_luong") ;
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<BangLuong> danhSachBangLuong = new ArrayList<>();
        while(resultTable.next()){
            BangLuong bangLuong = new BangLuong();
            bangLuong.setMaBangLuong(resultTable.getString("ma_bang_luong"));
            bangLuong.setCheDoLuong(resultTable.getString("che_do_luong"));
            bangLuong.setLoai(resultTable.getString("loai"));
            bangLuong.setTienLuong(resultTable.getDouble("tien_luong"));
            bangLuong.setNoiDung(resultTable.getString("noi_dung"));
            bangLuong.setTrangThai(resultTable.getString("trang_thai"));
            danhSachBangLuong.add(bangLuong);
        }
        connectorDB.closeConnection();
        return danhSachBangLuong;
    }
    public BangLuong hienThiBangLuongTheoMaBangLuong(String maBangLuong) throws SQLException{
        String query = String.format("select * from bang_luong where ma_bang_luong='%s'", maBangLuong) ;
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        BangLuong bangLuong = new BangLuong();
        while(resultTable.next()){
            bangLuong.setMaBangLuong(resultTable.getString("ma_bang_luong"));
            bangLuong.setCheDoLuong(resultTable.getString("che_do_luong"));
            bangLuong.setLoai(resultTable.getString("loai"));
            bangLuong.setTienLuong(resultTable.getDouble("tien_luong"));
            bangLuong.setNoiDung(resultTable.getString("noi_dung"));
            bangLuong.setTrangThai(resultTable.getString("trang_thai"));
        }
        connectorDB.closeConnection();
        return bangLuong;
    }
    
    public int themBangLuong (BangLuong bangLuong) throws SQLException{ //   
        try{
           String query = String.format("insert into bang_luong(ma_bang_luong, che_do_luong, tien_luong, loai, noi_dung, trang_thai) " +
                             "values ('%s', '%s', %s, '%s', '%s', '%s')",
                             bangLuong.getMaBangLuong(),
                             bangLuong.getCheDoLuong(),
                             String.valueOf(bangLuong.getTienLuong()),
                             bangLuong.getLoai(),
                             bangLuong.getNoiDung(),
                             bangLuong.getTrangThai());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatBangLuong (BangLuong bangLuong) throws SQLException{ //   
        try{
           String query = String.format("update bang_luong set che_do_luong = '%s', tien_luong = %s, loai = '%s', noi_dung = '%s', trang_thai = '%s', where ma_bang_luong = '%s' ",
                             bangLuong.getCheDoLuong(),
                             String.valueOf(bangLuong.getTienLuong()),
                             bangLuong.getLoai(),
                             bangLuong.getNoiDung(),
                             bangLuong.getTrangThai(),
                             bangLuong.getMaBangLuong());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int demSoBangLuong() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM bang_luong;");
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
