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
import src.Model.NhaCungCap;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class NhaCungCapService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    private NhanVienService nhanVienService = new NhanVienService();
    public List<NhaCungCap> hienThiTatCaNhaCungCap () throws SQLException{ //
        String query = String.format("select * from nha_cung_cap");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<NhaCungCap> danhSachNhaCungCap = new ArrayList<>();
        while(resultTable.next()){
            NhaCungCap nhaCungCap = new NhaCungCap();
            for (i= 1; i <= q; i++){
                nhaCungCap.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                nhaCungCap.setDiaChi(resultTable.getString("dia_chi"));
                nhaCungCap.setEmail(resultTable.getString("email"));
                nhaCungCap.setMaSoThue(resultTable.getString("ma_so_thue"));
                nhaCungCap.setNgayTao(util.localDateParseMethod(resultTable.getString("ngay_tao")));
                nhaCungCap.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                nhaCungCap.setTenNhaCungCap(resultTable.getString("ten_nha_cung_cap"));
                nhaCungCap.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                nhaCungCap.setTongMua(resultTable.getDouble("tong_mua"));
            }
            danhSachNhaCungCap.add(nhaCungCap);
        }
        connectorDB.closeConnection();
        return danhSachNhaCungCap;
    }
    
    public NhaCungCap hienThiNhaCungCapTheoMaNhaCungCap (String maNhaCungCap) throws SQLException{ //
        String query = String.format("select * from nha_cung_cap where ma_nha_cung_cap = '%s'", maNhaCungCap);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        NhaCungCap nhaCungCap = new NhaCungCap();
        while(resultTable.next()){
            for (i= 1; i <= q; i++){
                nhaCungCap.setMaNhaCungCap(resultTable.getString("ma_nha_cung_cap"));
                nhaCungCap.setDiaChi(resultTable.getString("dia_chi"));
                nhaCungCap.setEmail(resultTable.getString("email"));
                nhaCungCap.setMaSoThue(resultTable.getString("ma_so_thue"));
                nhaCungCap.setNgayTao(util.localDateParseMethod(resultTable.getString("ngay_tao")));
                nhaCungCap.setSoDienThoai(resultTable.getString("so_dien_thoai"));
                nhaCungCap.setTenNhaCungCap(resultTable.getString("ten_nha_cung_cap"));
                nhaCungCap.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                nhaCungCap.setTongMua(Double.parseDouble(resultTable.getString("tong_mua")));
            }
        }
        connectorDB.closeConnection();
        return nhaCungCap;
    }
    
    
    public int themNhaCungCap (NhaCungCap nhaCungCap) throws SQLException{ //   
        try{
           String query = String.format("insert into nha_cung_cap(ma_nha_cung_cap, dia_chi, email, ma_nhan_vien, ma_so_thue, so_dien_thoai, ten_nha_cung_cap, ma_chi_nhanh, ngay_tao) " +
                             "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    nhaCungCap.getMaNhaCungCap(),
                    nhaCungCap.getDiaChi(),
                    nhaCungCap.getEmail(),
                    nhaCungCap.getMaNhanVien(),
                    nhaCungCap.getMaSoThue(),
                    nhaCungCap.getSoDienThoai(),
                    nhaCungCap.getTenNhaCungCap(),
                    nhaCungCap.getMaChiNhanh(),
                    util.localDateParseMethod(nhaCungCap.getNgayTao()));
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatNhaCungCap (NhaCungCap nhaCungCap) throws SQLException{ //   
        try{
           String query = String.format("update nha_cung_cap set dia_chi = '%s', email = '%s', ma_so_thue = '%s', so_dien_thoai = '%s', ten_nha_cung_cap = '%s' where ma_nha_cung_cap = '%s'",
                    nhaCungCap.getDiaChi(),
                    nhaCungCap.getEmail(),
                    nhaCungCap.getMaSoThue(),
                    nhaCungCap.getSoDienThoai(),
                    nhaCungCap.getTenNhaCungCap(),
                    nhaCungCap.getMaNhaCungCap());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int demSoNhaCungCap() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM nha_cung_cap;");
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
