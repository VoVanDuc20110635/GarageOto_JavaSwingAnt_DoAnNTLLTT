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
import src.Model.CongViec;
import src.Model.NhaCungCap;

/**
 *
 * @author WINDOWS 10
 */
public class CongViecService {
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<CongViec> hienThiTatCaCongViec () throws SQLException{ //
        String query = String.format("select * from cong_viec");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<CongViec> danhSachCongViec = new ArrayList<>();
        while(resultTable.next()){
            CongViec congViec = new CongViec();
            congViec.setMaCongViec(resultTable.getString("ma_cong_viec"));
            congViec.setTenCongViec(resultTable.getString("ten_cong_viec"));
            danhSachCongViec.add(congViec);
        }
        connectorDB.closeConnection();
        return danhSachCongViec;
    }
    
    public CongViec hienThiCongViecTheoMaCongViec (String maCongViec) throws SQLException{ //
        String query = String.format("select * from cong_viec where ma_cong_viec = '%s'", maCongViec);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        CongViec congViec = new CongViec();
        while(resultTable.next()){
            congViec.setMaCongViec(resultTable.getString("ma_cong_viec"));
            congViec.setTenCongViec(resultTable.getString("ten_cong_viec"));
        }
        connectorDB.closeConnection();
        return congViec;
    }
    
}
