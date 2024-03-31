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
    public List<TheKho> hienThiTatCaTheKhoTheoMaHangHoa(String maHangHoa) throws SQLException{ //
        String query = String.format("select * from the_kho where ma_hang_hoa = '%s'", maHangHoa);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
                theKho.setSoLuongThucTe(resultTable.getShort("so_luong_thuc_te"));
                theKho.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                theKho.setTonCuoi(resultTable.getShort("ton_cuoi"));
                theKho.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                theKho.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                theKho.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                theKho.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));              
            }
            danhSachTheKho.add(theKho);
        }
        return danhSachTheKho;
    }
    
    public int themTheKho (TheKho theKho) throws SQLException{ //   
        try{
           if (theKho.getMaNhaCungCap() == null){
               String query = String.format("insert into the_kho(ma_the_kho, gia_von, phuong_thuc, so_luong, so_luong_thuc_te, thoi_gian, ton_cuoi, ma_hang_hoa, ma_khach_hang, ma_nhan_vien) " +
                             "values ('%s', %s, '%s', %s, %s, '%s', %s, '%s', '%s', '%s')",
                             theKho.getMaTheKho(),
                             String.valueOf(theKho.getGiaVon()),
                             theKho.getPhuongThuc(),
                             String.valueOf(theKho.getSoLuong()),
                             String.valueOf(theKho.getSoLuongThucTe()),
                             String.valueOf(theKho.getThoiGian()),
                             bangChamCongMoi.getMaNhanVien());
            ConnectorDB.executeUpdateQueryConnectorDB(query);
           } 
           if (theKho.getMaKhachHang()== null){
               System.out.println("huhu");
           }
           
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}