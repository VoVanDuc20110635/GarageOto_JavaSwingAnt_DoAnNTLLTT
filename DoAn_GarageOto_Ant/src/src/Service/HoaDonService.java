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
import src.Model.HoaDon;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class HoaDonService {
    private Util util = new Util();
    public List<HoaDon> hienThiTatCaHoaDon () throws SQLException{ //
        String query = String.format("select * from hoa_don");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        while(resultTable.next()){
            HoaDon hoaDon = new HoaDon();
            for (i= 1; i <= q; i++){
                hoaDon.setMaHoaDon(resultTable.getString("ma_hoa_don"));
                hoaDon.setGiamGia(resultTable.getDouble("giam_gia"));
                hoaDon.setLoaiThuChi(resultTable.getString("loai_thu_chi"));
                hoaDon.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                hoaDon.setTienDaTra(resultTable.getDouble("tien_da_tra"));
                hoaDon.setTongTien(resultTable.getDouble("tong_tien"));
                
                hoaDon.setTrangThai(resultTable.getString("trang_thai"));
                hoaDon.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                hoaDon.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                hoaDon.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                hoaDon.setMaPhieuTraHang(resultTable.getString("ma_phieu_tra_hang"));
            }
            danhSachHoaDon.add(hoaDon);
        }
        return danhSachHoaDon;
    }
    
    public HoaDon hienThiHoaDonTheoMaHoadon (String maHoaDon) throws SQLException{ //
        String query = String.format("select * from hoa_don where ma_hoa_don = '%s'", maHoaDon);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        HoaDon hoaDon = new HoaDon();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                hoaDon.setMaHoaDon(resultTable.getString("ma_hoa_don"));
                hoaDon.setGiamGia(resultTable.getDouble("giam_gia"));
                hoaDon.setLoaiThuChi(resultTable.getString("loai_thu_chi"));
                hoaDon.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                hoaDon.setTienDaTra(resultTable.getDouble("tien_da_tra"));
                hoaDon.setTongTien(resultTable.getDouble("tong_tien"));
                
                hoaDon.setTrangThai(resultTable.getString("trang_thai"));
                hoaDon.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                hoaDon.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                hoaDon.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
        }
        return hoaDon;
    }
}
