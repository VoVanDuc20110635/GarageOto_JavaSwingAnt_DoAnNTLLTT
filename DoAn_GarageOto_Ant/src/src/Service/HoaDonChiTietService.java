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
import java.util.Date;
import src.Model.HoaDonChiTiet;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class HoaDonChiTietService {
    private Util util = new Util();
    private HangHoaService hangHoaService = new HangHoaService();
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<HoaDonChiTiet> hienThiHoaDonChiTietTheoMaHoaDon (String maHoadon) throws SQLException{ //
        String query = String.format("select * from hoa_don_chi_tiet where ma_hoa_don = '%s'", maHoadon);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<HoaDonChiTiet> danhSachHoaDonChiTiet = new ArrayList<>();
        while(resultTable.next()){
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            for (i= 1; i <= q; i++){
                hoaDonChiTiet.setMaHoaDonChiTiet(resultTable.getString("ma_hoa_don_chi_tiet"));
                hoaDonChiTiet.setGiaBan(resultTable.getDouble("gia_ban"));
                hoaDonChiTiet.setGiamGia(resultTable.getDouble("giam_gia"));
                hoaDonChiTiet.setSoLuong(resultTable.getShort("so_luong"));
                hoaDonChiTiet.setThanhTien(resultTable.getDouble("thanh_tien"));
                hoaDonChiTiet.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                hoaDonChiTiet.setMaHoaDon(resultTable.getString("ma_hoa_don"));
                hoaDonChiTiet.setTenHangHoa(resultTable.getString("ten_hang_hoa"));
            }
            danhSachHoaDonChiTiet.add(hoaDonChiTiet);
        }
        connectorDB.closeConnection();
        return danhSachHoaDonChiTiet;
    }
    
    public int themHoaDonChiTiet (HoaDonChiTiet hoaDonChiTiet) throws SQLException{ //   
        try{
            String tenHangHoa = hangHoaService.hienThiHangHoaTheoMaHangHoa(hoaDonChiTiet.getMaHangHoa()).getTenHangHoa();
           String query = String.format("insert into hoa_don_chi_tiet(ma_hoa_don_chi_tiet, gia_ban, giam_gia, so_luong, thanh_tien, ma_hang_hoa, ma_hoa_don, ten_hang_hoa)" +
                             "values ('%s', %s, %s, %s , %s , '%s', '%s', '%s')",
            hoaDonChiTiet.getMaHoaDonChiTiet(),
                hoaDonChiTiet.getGiaBan(),
                hoaDonChiTiet.getGiamGia(),
                hoaDonChiTiet.getSoLuong(),
                hoaDonChiTiet.getThanhTien(),
                hoaDonChiTiet.getMaHangHoa(),
                hoaDonChiTiet.getMaHoaDon(),
                tenHangHoa);
            connectorDB.executeUpdateQueryConnectorDB(query);
            query = String.format("update hang_hoa set ton_kho = ton_kho - %s where ma_hang_hoa = '%s'",hoaDonChiTiet.getSoLuong(), hoaDonChiTiet.getMaHangHoa());
            connectorDB.executeUpdateQueryConnectorDB(query);
            query = String.format("update hang_hoa set khach_dat = khach_dat + %s where ma_hang_hoa = '%s'",hoaDonChiTiet.getSoLuong(),hoaDonChiTiet.getMaHangHoa());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int updateSoLuongHoaDonChiTiet (HoaDonChiTiet hoaDonChiTiet) throws SQLException{ //   
        try{
           String query = String.format("update hoa_don_chi_tiet set so_luong=%s where ma_hang_hoa = '%s' && ma_hoa_don = '%s'",
                             String.valueOf(hoaDonChiTiet.getSoLuong()),
                             hoaDonChiTiet.getMaHangHoa(),
                             hoaDonChiTiet.getMaHoaDon());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
