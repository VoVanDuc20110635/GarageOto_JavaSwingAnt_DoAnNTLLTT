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
import src.Util.Util;
import src.Model.LichLamViec;
/**
 *
 * @author WINDOWS 10
 */
public class LichLamViecService {
    private ConnectorDB connectorDB = new ConnectorDB();
    private Util util = new Util();
    public LichLamViec hienThiLichLamViecTheoMaLichLamViec (String maLichLamViec) throws SQLException{ //
        String query = String.format("select * from lich_lam_viec where ma_lich_lam_viec = '%s'", maLichLamViec);
        
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        LichLamViec lichLamViec = new LichLamViec();
        while(resultTable.next()){
            lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
            lichLamViec.setNghiLam(Boolean.parseBoolean(resultTable.getString("nghi_lam")));
            lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau")));
            lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_ket_thuc")));
            lichLamViec.setTrangThai(resultTable.getString("trang_thai"));
            lichLamViec.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            lichLamViec.setTangCa(resultTable.getShort("tang_ca"));
        }
        connectorDB.closeConnection();
        return lichLamViec;
    }
    
     public List<LichLamViec> hienThiLichLamViecTheoMaNhanVien (String maNhanVien) throws SQLException{ //
        String query = String.format("select * from lich_lam_viec where ma_nhan_vien = '%s' and nghi_lam = false and tang_ca = 0", maNhanVien);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<LichLamViec> danhSachLichLamViec = new ArrayList<>();
        while(resultTable.next()){
            LichLamViec lichLamViec = new LichLamViec();
            lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
            lichLamViec.setNghiLam(Boolean.parseBoolean(resultTable.getString("nghi_lam")));
            lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau")));
            lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_ket_thuc")));
            lichLamViec.setTrangThai(resultTable.getString("trang_thai"));
            danhSachLichLamViec.add(lichLamViec);
        }
        connectorDB.closeConnection();
        return danhSachLichLamViec;
    }
     
    public LichLamViec hienThiLichLamViecDangDienRaTheoMaNhanVien (String maNhanVien) throws SQLException{ //
        String query = String.format("select * from lich_lam_viec where ma_nhan_vien = '%s' and nghi_lam = false and tang_ca = 0 and trang_thai = 'Đang diễn ra'", maNhanVien);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        LichLamViec lichLamViec = new LichLamViec();
        while(resultTable.next()){
            
            lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
            lichLamViec.setNghiLam(Boolean.parseBoolean(resultTable.getString("nghi_lam")));
            lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau")));
            lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_ket_thuc")));
            lichLamViec.setTrangThai(resultTable.getString("trang_thai"));
            
        }
        connectorDB.closeConnection();
        return lichLamViec;
    }
    
    public List<LichLamViec> hienThiLichNghiTheoMaNhanVien (String maNhanVien) throws SQLException{ //
        String query = String.format("select * from lich_lam_viec where (ma_nhan_vien = '%s' or ma_nhan_vien = 'NV000') and nghi_lam = true", maNhanVien);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<LichLamViec> danhSachLichLamViec = new ArrayList<>();
        while(resultTable.next()){
            LichLamViec lichLamViec = new LichLamViec();
            lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
            lichLamViec.setNghiLam(Boolean.parseBoolean(resultTable.getString("nghi_lam")));
            lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau")));
            lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_ket_thuc")));
            lichLamViec.setTrangThai(resultTable.getString("trang_thai"));
            danhSachLichLamViec.add(lichLamViec);
        }
        connectorDB.closeConnection();
        return danhSachLichLamViec;
    }
    
    public List<LichLamViec> hienThiLichNghi () throws SQLException{ //
        String query = String.format("select * from lich_lam_viec where nghi_lam = true");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<LichLamViec> danhSachLichLamViec = new ArrayList<>();
        while(resultTable.next()){
            LichLamViec lichLamViec = new LichLamViec();
            lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
            lichLamViec.setNghiLam(Boolean.parseBoolean(resultTable.getString("nghi_lam")));
            lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau")));
            lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_ket_thuc")));
            lichLamViec.setTrangThai(resultTable.getString("trang_thai"));
            danhSachLichLamViec.add(lichLamViec);
        }
        connectorDB.closeConnection();
        return danhSachLichLamViec;
    }
    
    public List<LichLamViec> hienThiLichTangCaTheoMaNhanVien (String maNhanVien) throws SQLException{ //
        String query = String.format("select * from lich_lam_viec where ma_nhan_vien = '%s' and tang_ca != 0", maNhanVien);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<LichLamViec> danhSachLichLamViec = new ArrayList<>();
        while(resultTable.next()){
            LichLamViec lichLamViec = new LichLamViec();
            lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
            lichLamViec.setNghiLam(Boolean.parseBoolean(resultTable.getString("nghi_lam")));
            lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau")));
            lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_ket_thuc")));
            lichLamViec.setTrangThai(resultTable.getString("trang_thai"));
            lichLamViec.setTangCa(resultTable.getShort("tang_ca"));
            danhSachLichLamViec.add(lichLamViec);
        }
        connectorDB.closeConnection();
        return danhSachLichLamViec;
    }
     
    public List<LichLamViec> hienThiLichLamViec () throws SQLException{ //
        String query = String.format("select * from lich_lam_viec");
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        List<LichLamViec> danhSachLamViec = new ArrayList<>();
        while(resultTable.next()){
            LichLamViec lichLamViec = new LichLamViec();
            lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
            lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
            lichLamViec.setNghiLam(Boolean.parseBoolean(resultTable.getString("nghi_lam")));
            lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau")));
            lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_ket_thuc")));
            danhSachLamViec.add(lichLamViec);
        }
        connectorDB.closeConnection();
        return danhSachLamViec;
    }
    
    public int demSoLichLamViec() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM lich_lam_viec;");
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
    
    public int themLichLamViec (LichLamViec lichLamViec) throws SQLException{ //   
        try{
           String query = String.format("insert into lich_lam_viec(ma_lich_lam_viec, ghi_chu, nghi_lam, ngay_bat_dau, ngay_ket_thuc, tang_ca, trang_thai, ma_nhan_vien) " +
                             "values ('%s', '%s', %s, '%s', '%s', %s, '%s', '%s')",
                   lichLamViec.getMaLichLamViec(),
                   lichLamViec.getGhiChu(),
                   lichLamViec.isNghiLam(),
                   String.valueOf(lichLamViec.getNgayBatDau()),
                   String.valueOf(lichLamViec.getNgayKetThuc()),
                   lichLamViec.getTangCa(),
                   lichLamViec.getTrangThai(),
                   lichLamViec.getMaNhanVien()
                   );
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatLichLamViec (LichLamViec lichLamViec) throws SQLException{ //   
        try{
           String query = String.format("update lich_lam_viec set ghi_chu  = '%s', nghi_lam  = %s, ngay_bat_dau  = '%s', ngay_ket_thuc  = '%s', tang_ca  = %s, trang_thai  = '%s', ma_nhan_vien  = '%s' where ma_lich_lam_viec = '%s' ",
                   lichLamViec.getGhiChu(),
                   lichLamViec.isNghiLam(),
                   String.valueOf(lichLamViec.getNgayBatDau()),
                   String.valueOf(lichLamViec.getNgayKetThuc()),
                   lichLamViec.getTangCa(),
                   lichLamViec.getTrangThai(),
                   lichLamViec.getMaNhanVien(),
                   lichLamViec.getMaLichLamViec()
                   );
            System.out.println(query);
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int capNhatLichNghiViec (LichLamViec lichLamViec) throws SQLException{ //   
        try{
           String query = String.format("update lich_lam_viec set ghi_chu  = '%s', ngay_bat_dau  = '%s', ngay_ket_thuc  = '%s' where ma_lich_lam_viec = '%s' ",
                   lichLamViec.getGhiChu(),
                   String.valueOf(lichLamViec.getNgayBatDau()),
                   String.valueOf(lichLamViec.getNgayKetThuc()),
                   lichLamViec.getMaLichLamViec()
                   );
            System.out.println(query);
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public LichLamViec timKiemLichNghiViec (int month, int year, String maNhanVien) throws SQLException{ //   
        try{
           String query = String.format("select * from lich_lam_viec where extract(month from ngay_bat_dau) = %s and extract(year from ngay_bat_dau) = %s and ma_nhan_vien = '%s' and nghi_lam = false and tang_ca = 0",
                   month, year, maNhanVien
                   );
            System.out.println(query);
            ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
            ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
            LichLamViec lichLamViec = new LichLamViec();
            while(resultTable.next()){
            
                lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
                lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
                lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau")));
                lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_ket_thuc")));
            }
            connectorDB.closeConnection();
            return lichLamViec;
        } catch (Exception err){
            return new LichLamViec();
        }
        
    }
    
    public List<LichLamViec> timKiemLichTangCa (int month, int year, String maNhanVien) throws SQLException{ //   
        try{
            String query = String.format("select * from lich_lam_viec where extract(month from ngay_bat_dau) = %s and extract(year from ngay_bat_dau) = %s and tang_ca > 0 and nghi_lam = false and ma_nhan_vien = '%s'",
                   month, year, maNhanVien
                   );
            System.out.println(query);
            ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
            ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
            List<LichLamViec> danhSachLamViec = new ArrayList<>();
            
            while(resultTable.next()){
                LichLamViec lichLamViec = new LichLamViec();
                lichLamViec.setMaLichLamViec(resultTable.getString("ma_lich_lam_viec"));
                lichLamViec.setGhiChu(resultTable.getString("ghi_chu"));
                lichLamViec.setTangCa(resultTable.getShort("tang_ca"));
                lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_bat_dau")));
                lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(resultTable.getString("ngay_ket_thuc")));
                danhSachLamViec.add(lichLamViec);
            }
            connectorDB.closeConnection();
            return danhSachLamViec;
        } catch (Exception err){
            return new ArrayList<>();
        }
        
    }
    
    
}
