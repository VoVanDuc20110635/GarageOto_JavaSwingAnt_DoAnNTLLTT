/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Service;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import src.ConnectDB.ConnectorDB;
import src.Model.PhieuNhapHang;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class PhieuNhapHangService {
    private Util util = new Util();
    private NhaCungCapService nhaCungCapService = new NhaCungCapService();
    private ChiNhanhServive chiNhanhServive = new ChiNhanhServive();
    private NhanVienService nhanVienService = new NhanVienService();
    
    public List<PhieuNhapHang> hienThiTatCaPhieuNhapHang () throws SQLException{ //
        String query = String.format("select * from phieu_nhap_hang");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<PhieuNhapHang> danhSachPhieuNhapHang = new ArrayList<>();
        while(resultTable.next()){
            PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
            for (i= 1; i <= q; i++){
                phieuNhapHang.setPhieuNhapHang(resultTable.getString("phieu_nhap_hang"));
                phieuNhapHang.setNo(resultTable.getDouble("no"));
                phieuNhapHang.setThoiGian( util.localDateParseMethod(resultTable.getString("thoi_gian")));
                phieuNhapHang.setTong(resultTable.getDouble("tong"));
                phieuNhapHang.setTrangThai(resultTable.getString("trang_thai"));
                phieuNhapHang.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                phieuNhapHang.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                phieuNhapHang.setMaNhanVienTao(resultTable.getString("ma_nhan_vien"));
            }
            danhSachPhieuNhapHang.add(phieuNhapHang);
        }
        return danhSachPhieuNhapHang;
    }
    
    public PhieuNhapHang layPhieuNhapHangDuaTrenMaPhieuNhapHang (String maPhieuNhapHang) throws SQLException{ //
        String query = String.format("select * from phieu_nhap_hang where phieu_nhap_hang = '%s'", maPhieuNhapHang);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                phieuNhapHang.setPhieuNhapHang(resultTable.getString("phieu_nhap_hang"));
                phieuNhapHang.setNo(resultTable.getDouble("no"));
                phieuNhapHang.setThoiGian( util.localDateParseMethod(resultTable.getString("thoi_gian")));
                phieuNhapHang.setTong(resultTable.getDouble("tong"));
                phieuNhapHang.setTrangThai(resultTable.getString("trang_thai"));
                phieuNhapHang.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                phieuNhapHang.setMaChiNhanh(resultTable.getString("ma_chi_nhanh"));
                phieuNhapHang.setMaNhanVienTao(resultTable.getString("ma_nhan_vien"));
                phieuNhapHang.setTienDaTra(resultTable.getShort("tien_da_tra"));            }
        }
        return phieuNhapHang;
    }
    
    public int updatePhieuNhapHang (PhieuNhapHang phieuNhapHang) throws SQLException{ //   
        try{
           String query = String.format("update phieu_nhap_hang set trang_thai='%s', ma_nha_cung_cap='%s' where phieu_nhap_hang='%s'",
                             String.valueOf(phieuNhapHang.getTrangThai()),
                             String.valueOf(phieuNhapHang.getMaNhaCungCap()),
                             String.valueOf(phieuNhapHang.getPhieuNhapHang()));
            ConnectorDB.executeUpdateQueryConnectorDB(query);
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
