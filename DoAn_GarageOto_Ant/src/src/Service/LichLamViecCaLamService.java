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
}
