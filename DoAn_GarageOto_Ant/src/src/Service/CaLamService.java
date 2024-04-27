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
import src.Model.CaLam;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class CaLamService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<CaLam> hienThiTatCaCaLam () throws SQLException{ //
        String query = String.format("select * from ca_lam");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<CaLam> danhSachCaLam = new ArrayList<>();
        while(resultTable.next()){
            CaLam caLam = new CaLam();
            for (i= 1; i <= q; i++){
                caLam.setMaCaLam(resultTable.getString("ma_ca_lam"));
                caLam.setTenCaLam(resultTable.getString("ten_ca_lam"));
                caLam.setThoiGianBatDau(util. localDateParseMethodToLocalTime(resultTable.getString("thoi_gian_bat_dau")));
                caLam.setThoiGianKetThuc(util.localDateParseMethodToLocalTime(resultTable.getString("thoi_gian_ket_thuc")));
            }
            danhSachCaLam.add(caLam);
        }
        connectorDB.closeConnection();
        return danhSachCaLam;
    }
    
    public CaLam hienThiCaLamTheoMaCaLam (String maCaLam) throws SQLException{ //
        String query = String.format("select * from ca_lam where ma_ca_lam = '%s'", maCaLam);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        CaLam caLam = new CaLam();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                caLam.setMaCaLam(resultTable.getString("ma_ca_lam"));
                caLam.setTenCaLam(resultTable.getString("ten_ca_lam"));
                caLam.setThoiGianBatDau(util. localDateParseMethodToLocalTime(resultTable.getString("thoi_gian_bat_dau")));
                caLam.setThoiGianKetThuc(util.localDateParseMethodToLocalTime(resultTable.getString("thoi_gian_ket_thuc")));
            }
        }
        connectorDB.closeConnection();
        return caLam;
    }
    public int demSoCaLam() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM ca_lam;");
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
    
    public int themCaLam (CaLam caLam) throws SQLException{ //   
        try{
           String query = String.format("insert into ca_lam(ma_ca_lam, ten_ca_lam, thoi_gian_bat_dau, thoi_gian_ket_thuc) " +
                             "values ('%s', '%s', '%s', '%s')",
                             caLam.getMaCaLam(),
                             caLam.getTenCaLam(),
                             String.valueOf(caLam.getThoiGianBatDau()),
                             String.valueOf(caLam.getThoiGianKetThuc()));
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatCaLam (CaLam caLam) throws SQLException{ //   
        try{
           String query = String.format("update ca_lam set ten_ca_lam = '%s', thoi_gian_bat_dau = '%s', thoi_gian_ket_thuc = '%s' where ma_ca_lam = '%s'",
                             caLam.getTenCaLam(),
                             String.valueOf(caLam.getThoiGianBatDau()),
                             String.valueOf(caLam.getThoiGianKetThuc()),
                             caLam.getMaCaLam());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}

