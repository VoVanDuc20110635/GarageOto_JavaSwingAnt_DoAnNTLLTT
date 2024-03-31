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
import src.Model.ChiTietPhieuNhapHang;
/**
 *
 * @author WINDOWS 10
 */
public class ChiTietPhieuNhapHangService {
    private HangHoaService hangHoaService = new HangHoaService();
    public List<ChiTietPhieuNhapHang> hienThiChiTietPhieuNhapHangTheoMaPhieuNhapHang (String maPhieuNhapHang) throws SQLException{ //
        String query = String.format("select * from chi_tiet_phieu_nhap_hang where ma_phieu_nhap_hang='%s'",
                             maPhieuNhapHang);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<ChiTietPhieuNhapHang> danhSachChiTietPhieuNhapHang = new ArrayList<>();
        while(resultTable.next()){
            ChiTietPhieuNhapHang chiTietPhieuNhapHang = new ChiTietPhieuNhapHang();
            for (i= 1; i <= q; i++){
                chiTietPhieuNhapHang.setMaChiTietPhieuNhapHang(resultTable.getString("ma_chi_tiet_phieu_nhap_hang"));
                chiTietPhieuNhapHang.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                chiTietPhieuNhapHang.setSo_luong(resultTable.getShort("so_luong"));
                chiTietPhieuNhapHang.setGia_nhap(resultTable.getDouble("gia_nhap"));
                chiTietPhieuNhapHang.setTong(resultTable.getDouble("tong"));
                chiTietPhieuNhapHang.setGiam_gia(resultTable.getDouble("giam_gia"));
                chiTietPhieuNhapHang.setThanh_tien(resultTable.getDouble("thanh_tien"));
                chiTietPhieuNhapHang.setMaPhieuNhapHang(resultTable.getString("ma_phieu_nhap_hang"));
            }
            chiTietPhieuNhapHang.setHangHoa(hangHoaService.hienThiHangHoaTheoMaHangHoa(chiTietPhieuNhapHang.getMaHangHoa()));
            danhSachChiTietPhieuNhapHang.add(chiTietPhieuNhapHang);
        }
        return danhSachChiTietPhieuNhapHang;
    }   
    
    public ChiTietPhieuNhapHang hienThiChiTietPhieuNhapHangTheoMaChiTietPhieuNhapHang (String maChiTietPhieuNhapHang) throws SQLException{ //
        String query = String.format("select * from chi_tiet_phieu_nhap_hang where ma_chi_tiet_phieu_nhap_hang='%s'",
                             maChiTietPhieuNhapHang);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        ChiTietPhieuNhapHang chiTietPhieuNhapHang = new ChiTietPhieuNhapHang();
        while(resultTable.next()){
            
            for (i= 1; i <= q; i++){
                chiTietPhieuNhapHang.setMaChiTietPhieuNhapHang(resultTable.getString("ma_chi_tiet_phieu_nhap_hang"));
                chiTietPhieuNhapHang.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                chiTietPhieuNhapHang.setSo_luong(resultTable.getShort("so_luong"));
                chiTietPhieuNhapHang.setGia_nhap(resultTable.getDouble("gia_nhap"));
                chiTietPhieuNhapHang.setTong(resultTable.getDouble("tong"));
                chiTietPhieuNhapHang.setGiam_gia(resultTable.getDouble("giam_gia"));
                chiTietPhieuNhapHang.setThanh_tien(resultTable.getDouble("thanh_tien"));
                chiTietPhieuNhapHang.setMaPhieuNhapHang(resultTable.getString("ma_phieu_nhap_hang"));
            }
            chiTietPhieuNhapHang.setHangHoa(hangHoaService.hienThiHangHoaTheoMaHangHoa(chiTietPhieuNhapHang.getMaHangHoa()));
        }
        return chiTietPhieuNhapHang;
    }
    
    public int updateChiTietPhieuNhapHang (ChiTietPhieuNhapHang chiTietPhieuNhapHang) throws SQLException{ //   
        try{
           String query = String.format("update chi_tiet_phieu_nhap_hang set gia_nhap=%s, so_luong=%s, giam_gia=%s where ma_chi_tiet_phieu_nhap_hang='%s'",
                             String.valueOf(chiTietPhieuNhapHang.getGia_nhap()),
                             String.valueOf(chiTietPhieuNhapHang.getSo_luong()),
                             String.valueOf(chiTietPhieuNhapHang.getGiam_gia()),
                             String.valueOf(chiTietPhieuNhapHang.getMaChiTietPhieuNhapHang()));
            ConnectorDB.executeUpdateQueryConnectorDB(query);
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
