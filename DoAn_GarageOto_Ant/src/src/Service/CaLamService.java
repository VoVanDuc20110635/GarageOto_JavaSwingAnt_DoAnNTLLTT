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
    public List<CaLam> hienThiTatCaCaLam () throws SQLException{ //
        String query = String.format("select * from ca_lam");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
        return danhSachCaLam;
    }
    
    public CaLam hienThiCaLamTheoMaCaLam (String maCaLam) throws SQLException{ //
        String query = String.format("select * from ca_lam where ma_ca_lam = '%s'", maCaLam);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
        return caLam;
    }
}
