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
import src.Model.HangHoa;
import src.Model.PhieuSuaChua;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class PhieuSuaChuaService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    private HangHoaService hangHoaService = new HangHoaService();
    public List<PhieuSuaChua> hienThiTatCaPhieuSuaChua() throws SQLException{ //
        String query = String.format("select * from phieu_sua_chua");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<PhieuSuaChua> danhSachPhieuSuaChua = new ArrayList<>();
        while(resultTable.next()){
            PhieuSuaChua phieuSuaChua = new PhieuSuaChua();
            for (i= 1; i <= q; i++){
                phieuSuaChua.setMaPhieuSuaChua(resultTable.getString("ma_phieu_sua_chua"));
                phieuSuaChua.setNoiDungSuaChua(resultTable.getString("noi_dung_sua_chua"));
                phieuSuaChua.setTongTien(resultTable.getDouble("tong_tien"));
                phieuSuaChua.setThoiGian(util.localDateParseMethod(resultTable.getString("thoi_gian")));
                phieuSuaChua.setTrangThai(resultTable.getString("trang_thai"));
                
                phieuSuaChua.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                phieuSuaChua.setMaLoaiXe(resultTable.getString("ma_loai_xe"));
                phieuSuaChua.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                              
            }
            danhSachPhieuSuaChua.add(phieuSuaChua);
        }
        connectorDB.closeConnection();
        return danhSachPhieuSuaChua;
    }

    
    public List<HangHoa> hienThiTatCaPhuTungTheoMaPhieuSuaChua(String maPhieuSuaChua) throws SQLException{ //
        String query = String.format("select * from phieu_sua_chua_phu_tung where ma_phieu_sua_chua = '%s'", maPhieuSuaChua);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<HangHoa> danhSachHangHoa = new ArrayList<>();
        while(resultTable.next()){
            HangHoa hangHoa = hangHoaService.hienThiHangHoaTheoMaHangHoa(resultTable.getString("ma_hang_hoa")); 
            danhSachHangHoa.add(hangHoa);
        }
        connectorDB.closeConnection();
        return danhSachHangHoa;
    }
    
    public int themPhieuSuaChua (PhieuSuaChua phieuSuaChua ) throws SQLException{ //   
        try{
           String query = String.format("insert into phieu_sua_chua (ma_phieu_sua_chua, noi_dung_sua_chua , tong_tien, trang_thai, ma_khach_hang, ma_loai_xe, ma_nhan_vien, thoi_gian) " +
                             "values ('%s', '%s', %s, '%s', '%s', '%s', '%s', '%s')",
                             phieuSuaChua.getMaPhieuSuaChua(), 
                             phieuSuaChua.getNoiDungSuaChua(),
                             String.valueOf(phieuSuaChua.getTongTien()),
                             phieuSuaChua.getTrangThai(),
                             phieuSuaChua.getMaKhachHang(),
                             phieuSuaChua.getMaLoaiXe(),
                             phieuSuaChua.getMaNhanVien(),
                             util.localDateParseMethod(phieuSuaChua.getThoiGian()));
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public boolean themPhieuSuaChuaPhuTung (String maPhieuSuaChua, String maHangHoa) throws SQLException{ //   
        try{
           String query = String.format("insert into phieu_sua_chua_phu_tung(ma_phieu_sua_chua, ma_hang_hoa)" +
                             "values ('%s','%s' )",
                maPhieuSuaChua, maHangHoa);
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return true;
        } catch (Exception err){
            return false;
        }
    }
    
    public int capNhatPhieuSuaChua (PhieuSuaChua phieuSuaChua) throws SQLException{ //   
        try{
           String query = String.format("update phieu_sua_chua set noi_dung_sua_chua = '%s' , set tong_tien = '%s', set trang_thai = '%s', set ma_khach_hang = '%s', set ma_loai_xe = '%s', set ma_nhan_vien = '%s', set thoi_gian = '%s') where ma_phieu_sua_chua = '%s' ", 
                             phieuSuaChua.getNoiDungSuaChua(),
                             String.valueOf(phieuSuaChua.getTongTien()),
                             phieuSuaChua.getTrangThai(),
                             phieuSuaChua.getMaKhachHang(),
                             phieuSuaChua.getMaLoaiXe(),
                             phieuSuaChua.getMaNhanVien(),
                             util.localDateParseMethod(phieuSuaChua.getThoiGian()),
                             phieuSuaChua.getMaPhieuSuaChua());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int xoaPhieuSuaChuaPhuTung (String maPhieuSuaChua) throws SQLException{ //   
        try{
           String query = String.format("delete phieu_sua_chua_phu_tung  where ma_phieu_sua_chua = '%s' ", 
                             maPhieuSuaChua);
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    public int demSoPhieuSuaChua() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM phieu_sua_chua;");
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
