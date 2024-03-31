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
import src.Model.HangHoa;
/**
 *
 * @author WINDOWS 10
 */
public class HangHoaService {
    public List<HangHoa> hienThiTatCaHangHoa(String maHangHoa, String tenHangHoa) throws SQLException{ //
        String query = String.format("select * from hang_hoa");
        int flag = 0;
        if (maHangHoa.equals("") == false ){
            query += String.format(" where ma_hang_hoa like '%%%s%%' ", maHangHoa);
            flag = 1;
            if (tenHangHoa.equals("") == false){
                query += String.format(" AND ten_hang_hoa like '%%%s%%' ", tenHangHoa);
            }
        }
        if (tenHangHoa.equals("") == false && 0 == flag){
            query += String.format(" where ten_hang_hoa like '%%%s%%' ", tenHangHoa);
        }
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<HangHoa> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoa hangHoa = new HangHoa();
            for (i= 1; i <= q; i++){
                hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                hangHoa.setGiaBan(resultTable.getDouble("gia_ban"));
                hangHoa.setGiaVon(resultTable.getDouble("gia_von"));
                hangHoa.setKhachDat(resultTable.getShort("khach_dat"));
                hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
                hangHoa.setTonKho(resultTable.getShort("ton_kho"));
                hangHoa.setMaNhomHang(resultTable.getString("ma_nhom_hang"));
                hangHoa.setLoaiHang(resultTable.getString("loai_hang"));
                hangHoa.setTrangThai(resultTable.getInt("trang_thai"));
                
            }
            danhSachHangHoa.add(hangHoa);
        }
        return danhSachHangHoa;
    }
    
    public HangHoa hienThiHangHoaTheoMaHangHoa(String maHangHoa) throws SQLException{ //
        String query = String.format("select * from hang_hoa where ma_hang_hoa = '%s'", maHangHoa);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        HangHoa hangHoa = new HangHoa();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                hangHoa.setGiaBan(resultTable.getDouble("gia_ban"));
                hangHoa.setGiaVon(resultTable.getDouble("gia_von"));
                hangHoa.setKhachDat(resultTable.getShort("khach_dat"));
                hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
                hangHoa.setTonKho(resultTable.getShort("ton_kho"));
                hangHoa.setMaNhomHang(resultTable.getString("ma_nhom_hang"));
                hangHoa.setLoaiHang(resultTable.getString("loai_hang"));
                hangHoa.setTrangThai(resultTable.getInt("trang_thai"));
            }
        }
        return hangHoa;
    }
    
    public List<HangHoa> LocHangHoaTheoInput(List<String> inputs, String maHangHoa, String tenHangHoa) throws SQLException{ //
        String query = String.format("select * from hang_hoa where (");
        int j = 1;
        for (String input : inputs){
            if (j ==1 ){
                query += String.format(" ten_hang_hoa LIKE '%%%s%%' ", input);
            } else{
                query += String.format(" OR ten_hang_hoa LIKE '%%%s%%' ", input);
            }
            j++;
        }
        query += ")";
        if (maHangHoa.equals("") == false ){
            query += String.format(" AND ma_hang_hoa like '%%%s%%' ", maHangHoa);
        }
        if (tenHangHoa.equals("") == false){
            query += String.format(" AND ten_hang_hoa like '%%%s%%' ", tenHangHoa);
        }
        System.out.println(query);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<HangHoa> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoa hangHoa = new HangHoa();
            for (i= 1; i <= q; i++){
                hangHoa.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                hangHoa.setGiaBan(resultTable.getDouble("gia_ban"));
                hangHoa.setGiaVon(resultTable.getDouble("gia_von"));
                hangHoa.setKhachDat(resultTable.getShort("khach_dat"));
                hangHoa.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
                hangHoa.setTonKho(resultTable.getShort("ton_kho"));
                hangHoa.setMaNhomHang(resultTable.getString("ma_nhom_hang"));
                hangHoa.setLoaiHang(resultTable.getString("loai_hang"));
                hangHoa.setTrangThai(resultTable.getInt("trang_thai"));
            }
            danhSachHangHoa.add(hangHoa);
        }
        return danhSachHangHoa;
    }
    
    public int themHangHoa (HangHoa hangHoaMoi) throws SQLException{ //   
        try{
           String query = String.format("insert into hang_hoa(ma_hang_hoa, gia_ban, gia_von, khach_dat, ten_hang_hoa, ton_kho, ma_nhom_hang, loai_hang) " +
                             "values ('%s', %s, %s, %s, '%s', %s, '%s', '%s')",
                             hangHoaMoi.getMaHangHoa(), 
                             String.valueOf(hangHoaMoi.getGiaBan()),
                             String.valueOf(hangHoaMoi.getGiaVon()),
                             String.valueOf(hangHoaMoi.getKhachDat()),
                             hangHoaMoi.getTenHangHoa(),
                             String.valueOf(hangHoaMoi.getTonKho()),
                             hangHoaMoi.getMaNhomHang(),
                             hangHoaMoi.getLoaiHang());
            ConnectorDB.executeUpdateQueryConnectorDB(query);
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    public int demSoHangHoa() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM hang_hoa;");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        int numberOfRows  = 0;
        while(resultTable.next()){
            numberOfRows = resultTable.getInt("row_count");
        }
        return numberOfRows;
    }
    public int updateHangHoa (HangHoa hangHoa) throws SQLException{ //   
        try{
           String query = String.format("update hang_hoa set ten_hang_hoa='%s', ma_nhom_hang='%s', "
                   + "loai_hang='%s', gia_ban=%s , gia_von=%s, trang_thai=%s where ma_hang_hoa='%s'",
                             hangHoa.getTenHangHoa(),
                             hangHoa.getMaNhomHang(),
                             hangHoa.getLoaiHang(),
                             hangHoa.getGiaBan(),
                             hangHoa.getGiaVon(),
                             hangHoa.getTrangThai(),
                             hangHoa.getMaHangHoa());
            ConnectorDB.executeUpdateQueryConnectorDB(query);
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int updateTrangThaiHangHoa (String maHangHoa, int trangThaiHangHoa) throws SQLException{ //   
        try{
           String query = String.format("update hang_hoa set trang_thai=%s where ma_hang_hoa='%s'",
                             trangThaiHangHoa,
                             maHangHoa);
            ConnectorDB.executeUpdateQueryConnectorDB(query);
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
