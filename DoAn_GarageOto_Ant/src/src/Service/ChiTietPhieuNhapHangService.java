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
    private ConnectorDB connectorDB = new ConnectorDB();
    private HangHoaService hangHoaService = new HangHoaService();
    public List<ChiTietPhieuNhapHang> hienThiChiTietPhieuNhapHangTheoMaPhieuNhapHang (String maPhieuNhapHang) throws SQLException{ //
        String query = String.format("select * from chi_tiet_phieu_nhap_hang where ma_phieu_nhap_hang='%s'",
                             maPhieuNhapHang);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
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
        connectorDB.closeConnection();
        return danhSachChiTietPhieuNhapHang;
    }   
    
    public ChiTietPhieuNhapHang hienThiChiTietPhieuNhapHangTheoMaChiTietPhieuNhapHang (String maChiTietPhieuNhapHang) throws SQLException{ //
        String query = String.format("select * from chi_tiet_phieu_nhap_hang where ma_chi_tiet_phieu_nhap_hang='%s'",
                             maChiTietPhieuNhapHang);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
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
        connectorDB.closeConnection();
        return chiTietPhieuNhapHang;
    }
    
    public int updateChiTietPhieuNhapHang (ChiTietPhieuNhapHang chiTietPhieuNhapHang) throws SQLException{ //   
        try{
           String query = String.format("update chi_tiet_phieu_nhap_hang set gia_nhap=%s, so_luong=%s, giam_gia=%s where ma_chi_tiet_phieu_nhap_hang='%s'",
                             String.valueOf(chiTietPhieuNhapHang.getGia_nhap()),
                             String.valueOf(chiTietPhieuNhapHang.getSo_luong()),
                             String.valueOf(chiTietPhieuNhapHang.getGiam_gia()),
                             String.valueOf(chiTietPhieuNhapHang.getMaChiTietPhieuNhapHang()));
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int themChiTietPhieuNhapHang (ChiTietPhieuNhapHang chiTietPhieuNhapHang) throws SQLException{ //   
        try{
            String tenHangHoa = hangHoaService.hienThiHangHoaTheoMaHangHoa(chiTietPhieuNhapHang.getMaHangHoa()).getTenHangHoa();
           String query = String.format("insert into chi_tiet_phieu_nhap_hang(ma_chi_tiet_phieu_nhap_hang, gia_nhap, giam_gia, so_luong, tong, ma_hang_hoa, ma_phieu_nhap_hang, ten_hang_hoa)" +
                             "values ('%s', %s, %s, %s , %s , '%s', '%s', '%s')",
            chiTietPhieuNhapHang.getMaChiTietPhieuNhapHang(),
                chiTietPhieuNhapHang.getGia_nhap(),
                chiTietPhieuNhapHang.getGiam_gia(),
                chiTietPhieuNhapHang.getSo_luong(),
                chiTietPhieuNhapHang.getGia_nhap()*(1 - chiTietPhieuNhapHang.getGiam_gia()/100) * chiTietPhieuNhapHang.getSo_luong(),
                chiTietPhieuNhapHang.getMaHangHoa(),
                chiTietPhieuNhapHang.getMaPhieuNhapHang(),
                tenHangHoa);
            connectorDB.executeUpdateQueryConnectorDB(query);
            query = String.format("update hang_hoa set ton_kho = ton_kho - %s where ma_hang_hoa = '%s'",
                    chiTietPhieuNhapHang.getSo_luong(), 
                    chiTietPhieuNhapHang.getMaHangHoa());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
