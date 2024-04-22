/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Service;
import src.Model.NhanVien;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import src.ConnectDB.ConnectorDB;
import java.time.format.DateTimeFormatter;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class NhanVienService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    private ChiNhanhServive chiNhanhServive = new ChiNhanhServive();
    private LichLamViecService lichLamViecService = new LichLamViecService();
    
    public List<NhanVien> hienThiTatCaNhanVien () throws SQLException{ //
        String query = String.format("select * from nhan_vien");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
        while(resultTable.next()){
            NhanVien nhanVien = new NhanVien();
            for (i= 1; i <= q; i++){
                nhanVien.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                nhanVien.setCccd(resultTable.getString("cccd"));
                nhanVien.setChucDanh(resultTable.getString("chuc_danh"));
                nhanVien.setGioiTinh(resultTable.getString("gioi_tinh"));
                nhanVien.setNgayBatDauLamViec(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau_lam_viec")));
                nhanVien.setNgaySinh(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_sinh")));
                nhanVien.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                nhanVien.setTenNhanVien(resultTable.getString("ten_nhan_vien"));
                nhanVien.setNoLuong(resultTable.getDouble("no_luong"));
                
                nhanVien.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                nhanVien.setTaoBoiMaNhanVien(resultTable.getString("tao_boi_ma_nhan_vien"));
                nhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
                nhanVien.setDiaChi(resultTable.getString("dia_chi"));
                nhanVien.setMaSoThue(resultTable.getString("ma_so_thue"));
                nhanVien.setTrangThai(resultTable.getString("trang_thai"));
//                
            }
            danhSachNhanVien.add(nhanVien);
        }
        connectorDB.closeConnection();
        return danhSachNhanVien;
    }
    
    public NhanVien hienThiNhanVienTheoMaNhanVien (String maNhanVien) throws SQLException{ //
        String query = String.format("select * from nhan_vien where ma_nhan_vien = '%s'", maNhanVien);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        NhanVien nhanVien = new NhanVien();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                nhanVien.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                nhanVien.setCccd(resultTable.getString("cccd"));
                nhanVien.setChucDanh(resultTable.getString("chuc_danh"));
                nhanVien.setGioiTinh(resultTable.getString("gioi_tinh"));
                nhanVien.setNgayBatDauLamViec(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau_lam_viec")));
                nhanVien.setNgaySinh(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_sinh")));
                nhanVien.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                nhanVien.setTenNhanVien(resultTable.getString("ten_nhan_vien"));
                nhanVien.setNoLuong(Double.parseDouble(resultTable.getString("no_luong")));
                
                nhanVien.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                // vi nhan vien lai la 1-1 voi nhan vien nen lay ma duoc roi, keo bi lap vo hang
                nhanVien.setTaoBoiMaNhanVien(resultTable.getString("tao_boi_ma_nhan_vien"));
                nhanVien.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
                nhanVien.setDiaChi(resultTable.getString("dia_chi"));
                nhanVien.setMaSoThue(resultTable.getString("ma_so_thue"));
                nhanVien.setTrangThai(resultTable.getString("trang_thai"));
            }
        }
        connectorDB.closeConnection();
        return nhanVien;
    }
    
    public int themNhanVien (NhanVien nhanVien) throws SQLException{ //   
        try{
           String query = String.format("insert into nhan_vien (ma_nhan_vien, cccd, chuc_danh, gioi_tinh, ngay_bat_dau_lam_viec, "
                   + "ngay_sinh, so_dien_thoai, ten_nhan_vien, ma_chi_nhanh, tao_boi_ma_nhan_vien, ma_lich_lam_viec, "
                   + "no_luong, dia_chi, ma_so_thue, trang_thai) " +
                             "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, '%s', '%s', '%s')",
                             nhanVien.getMaNhanVien(),
                             nhanVien.getCccd(),
                             nhanVien.getChucDanh(),
                             nhanVien.getGioiTinh(),
                             String.valueOf(nhanVien.getNgayBatDauLamViec()),
                             String.valueOf(nhanVien.getNgaySinh()),
                             nhanVien.getSoDienThoai(),
                             nhanVien.getTenNhanVien(),
                             nhanVien.getMaChiNhanh(),
                             nhanVien.getTaoBoiMaNhanVien(), 
                             nhanVien.getMaLichLamViec(),
                             nhanVien.getNoLuong(),
                             nhanVien.getDiaChi(),
                             nhanVien.getMaSoThue(),
                             nhanVien.getTrangThai());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatNhanVienTaiTrangThongtinChiTiet (NhanVien nhanVien) throws SQLException{ //   
        try{
            System.out.println(nhanVien.getChucDanh());
           String query = String.format("update nhan_vien set cccd = '%s', chuc_danh = '%s', gioi_tinh = '%s', "
                   + "ngay_sinh = '%s', so_dien_thoai = '%s', ten_nhan_vien = '%s', ma_chi_nhanh = '%s', "
                   + "dia_chi = '%s', ma_so_thue = '%s', trang_thai = '%s' where ma_nhan_vien = '%s'",
                             nhanVien.getCccd(),
                             nhanVien.getChucDanh(),
                             nhanVien.getGioiTinh(),
                             String.valueOf(nhanVien.getNgaySinh()),
                             nhanVien.getSoDienThoai(),
                             nhanVien.getTenNhanVien(),
                             nhanVien.getMaChiNhanh(),
                             nhanVien.getDiaChi(),
                             nhanVien.getMaSoThue(),
                             nhanVien.getTrangThai(),
                             nhanVien.getMaNhanVien()
                             );
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    

}
