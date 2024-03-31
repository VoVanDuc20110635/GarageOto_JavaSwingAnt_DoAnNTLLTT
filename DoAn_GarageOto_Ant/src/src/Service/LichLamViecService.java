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
import src.Model.LichLamViec;
/**
 *
 * @author WINDOWS 10
 */
public class LichLamViecService {
    private Util util = new Util();
    public LichLamViec hienThiLichLamViecTheoMaLichLamViec (String maLichLamViec) throws SQLException{ //
        String query = String.format("select * from lich_lam_viec where ma_lich_lam_viec = '%s'", maLichLamViec);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        LichLamViec lichLamViec = new LichLamViec();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
                lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
                lichLamViec.setLapLai(Boolean.parseBoolean(resultTable.getString("lap_lai")));
                lichLamViec.setNgayBatDau(util.localDateParseMethod(resultTable.getString("ngay_bat_dau")));
                lichLamViec.setNgayKetThuc(util.localDateParseMethod(resultTable.getString("ngay_ket_thuc")));
            }
        }
        return lichLamViec;
    }
}
