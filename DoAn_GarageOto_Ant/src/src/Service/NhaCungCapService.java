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
    private NhanVienService nhanVienService = new NhanVienService();
    public List<NhaCungCap> hienThiTatCaNhaCungCap () throws SQLException{ //
        String query = String.format("select * from nha_cung_cap");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
                nhaCungCap.setTongMua(Double.parseDouble(resultTable.getString("tong_mua")));
                nhaCungCap.setNoCanTra(Double.parseDouble(resultTable.getString("no_can_tra")));
            }
            danhSachNhaCungCap.add(nhaCungCap);
        }
        return danhSachNhaCungCap;
    }
    
    public NhaCungCap hienThiNhaCungCapTheoMaNhaCungCap (String maNhaCungCap) throws SQLException{ //
        String query = String.format("select * from nha_cung_cap where ma_nha_cung_cap = '%s'", maNhaCungCap);
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
                nhaCungCap.setNoCanTra(Double.parseDouble(resultTable.getString("no_can_tra")));
            }
        }
        return nhaCungCap;
    }
    
    
}
