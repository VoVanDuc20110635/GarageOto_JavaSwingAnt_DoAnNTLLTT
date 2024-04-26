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
import src.Model.CaLam;
import src.Model.LichLamViec;
import src.Model.LichLamViecCaLam;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class LichLamViecCaLamService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<LichLamViecCaLam> hienThiTatCaLichLamViecCaLamTheoMaLichLamViec (String maLichLamViec) throws SQLException{ //
        String query = String.format("select * from lich_lam_viec_ca_lam where ma_lich_lam_viec = '%s'", maLichLamViec);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<LichLamViecCaLam> danhSachLichLamViecCaLam = new ArrayList<>();
        while(resultTable.next()){
            LichLamViecCaLam lichLamViecCaLam = new LichLamViecCaLam();
            lichLamViecCaLam.setMa(resultTable.getString("ma"));
            lichLamViecCaLam.setMaCaLam(resultTable.getString("ma_ca_lam"));
            lichLamViecCaLam.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            lichLamViecCaLam.setHoanThanh(resultTable.getBoolean("hoan_thanh"));
            danhSachLichLamViecCaLam.add(lichLamViecCaLam);
        }
        connectorDB.closeConnection();
        return danhSachLichLamViecCaLam;
    }
    public int demSoLichLamViecCaLam() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM lich_lam_viec_ca_lam;");
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
    public int themLichLamViecCaLam (LichLamViecCaLam lichLamViecCaLam) throws SQLException{ //   
        try{
           String query = String.format("insert into lich_lam_viec_ca_lam(ma, ma_lich_lam_viec, ma_ca_lam, hoan_thanh) " +
                             "values ('%s', '%s', '%s', %s)",
                   lichLamViecCaLam.getMa(),
                   lichLamViecCaLam.getMaLichLamViec(),
                   lichLamViecCaLam.getMaCaLam(),
                   lichLamViecCaLam.isHoanThanh()
                   );
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int xoaLichLamViecCaLam (String maLichLamViec) throws SQLException{ //   
        try{
           String query = String.format("delete from lich_lam_viec_ca_lam where ma_lich_lam_viec = '%s' and hoan_thanh = false", maLichLamViec);
            
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatLichLamViecCaLam (LichLamViecCaLam lichLamViecCaLam) throws SQLException{ //   
        try{
           String query = String.format("update lich_lam_viec_ca_lam set ma_lich_lam_viec = '%s', ma_ca_lam = '%s', hoan_thanh = '%s' where ma = '%s'",
                   lichLamViecCaLam.getMaLichLamViec(),
                   lichLamViecCaLam.getMaCaLam(),
                   lichLamViecCaLam.isHoanThanh(),
                   lichLamViecCaLam.getMa()
                   );
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
