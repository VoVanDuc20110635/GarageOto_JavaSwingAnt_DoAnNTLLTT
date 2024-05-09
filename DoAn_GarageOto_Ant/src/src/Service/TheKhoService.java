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
import src.Model.TheKho;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class TheKhoService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<TheKho> hienThiTatCaTheKhoTheoMaHangHoa(String maHangHoa) throws SQLException{ //
        String query = String.format("select * from the_kho where ma_hang_hoa = '%s'", maHangHoa);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<TheKho> danhSachTheKho = new ArrayList<>();
        while(resultTable.next()){
            TheKho theKho = new TheKho();
            for (i= 1; i <= q; i++){
                theKho.setMaTheKho(resultTable.getString("ma_the_kho"));
                theKho.setGiaVon(resultTable.getDouble("gia_von"));
                theKho.setPhuongThuc(resultTable.getString("phuong_thuc"));
                theKho.setSoLuong(resultTable.getShort("so_luong"));
                theKho.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                theKho.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                theKho.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                theKho.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                theKho.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));              
            }
            danhSachTheKho.add(theKho);
        }
        connectorDB.closeConnection();
        return danhSachTheKho;
    }
    
    public int themTheKho (TheKho theKho) throws SQLException{ //   
        try{
           if (theKho.getMaNhaCungCap() == null && theKho.getMaKhachHang()!= null){
               String query = String.format("insert into the_kho(ma_the_kho, gia_von, phuong_thuc, so_luong, thoi_gian, ma_hang_hoa, ma_khach_hang, ma_nhan_vien) " +
                             "values ('%s', %s, '%s', %s, '%s', '%s', '%s', '%s')",
                             theKho.getMaTheKho(),
                             String.valueOf(theKho.getGiaVon()),
                             theKho.getPhuongThuc(),
                             String.valueOf(theKho.getSoLuong()),
                             util.localDateParseMethod(theKho.getThoiGian()),
                             String.valueOf(theKho.getMaHangHoa()),
                             String.valueOf(theKho.getMaKhachHang()),
                             String.valueOf(theKho.getMaNhanVien()));
                connectorDB.executeUpdateQueryConnectorDB(query);
           }
           if (theKho.getMaKhachHang()== null && theKho.getMaNhaCungCap() != null){
               String query = String.format("insert into the_kho(ma_the_kho, gia_von, phuong_thuc, so_luong, thoi_gian, ma_hang_hoa, ma_nhan_vien, ma_nha_cung_cap) " +
                             "values ('%s', %s, '%s', %s, '%s', '%s', '%s', '%s')",
                             theKho.getMaTheKho(),
                             String.valueOf(theKho.getGiaVon()),
                             theKho.getPhuongThuc(),
                             String.valueOf(theKho.getSoLuong()),
                             util.localDateParseMethod(theKho.getThoiGian()),
                             String.valueOf(theKho.getMaHangHoa()),
                             String.valueOf(theKho.getMaNhanVien()),
                             String.valueOf(theKho.getMaNhaCungCap()));
                connectorDB.executeUpdateQueryConnectorDB(query);
           }
           
           if (theKho.getMaKhachHang()== null && theKho.getMaNhaCungCap() == null){
               String query = String.format("insert into the_kho(ma_the_kho, gia_von, phuong_thuc, so_luong, thoi_gian, ma_hang_hoa, ma_nhan_vien) " +
                             "values ('%s', %s, '%s', %s, '%s', '%s', '%s')",
                             theKho.getMaTheKho(),
                             String.valueOf(theKho.getGiaVon()),
                             theKho.getPhuongThuc(),
                             String.valueOf(theKho.getSoLuong()),
                             util.localDateParseMethod(theKho.getThoiGian()),
                             String.valueOf(theKho.getMaHangHoa()),
                             String.valueOf(theKho.getMaNhanVien()));
                connectorDB.executeUpdateQueryConnectorDB(query);
           }
           connectorDB.closeConnection();
           return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int demSoTheKho() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM the_kho;");
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
