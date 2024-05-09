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
import src.Model.HinhAnh;
/**
 *
 * @author WINDOWS 10
 */
public class HinhAnhService {
    private ConnectorDB connectorDB = new ConnectorDB();
    public HinhAnh hienThiHinhAnhTheoMaNhanVien (String maNhanVien) throws SQLException{ //
        String query = String.format("select * from hinh_anh where ma_nhan_vien ='%s'",
                             maNhanVien);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        HinhAnh hinhAnh = new HinhAnh();
        while(resultTable.next()){
            
            for (i= 1; i <= q; i++){
                hinhAnh.setMaHinhAnh(resultTable.getString("ma_hinh_anh"));
                hinhAnh.setNoiDung(resultTable.getString("noi_dung"));
                hinhAnh.setTenHinh(resultTable.getString("ten_hinh"));
                hinhAnh.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                hinhAnh.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
        }
        connectorDB.closeConnection();
        return hinhAnh;
    }
    
    public HinhAnh hienThiHinhAnhTheoMaHangHoa (String maHangHoa) throws SQLException{ //
        String query = String.format("select * from hinh_anh where ma_hang_hoa ='%s'",
                             maHangHoa);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        HinhAnh hinhAnh = new HinhAnh();
        while(resultTable.next()){
            
            for (i= 1; i <= q; i++){
                hinhAnh.setMaHinhAnh(resultTable.getString("ma_hinh_anh"));
                hinhAnh.setNoiDung(resultTable.getString("noi_dung"));
                hinhAnh.setTenHinh(resultTable.getString("ten_hinh"));
                hinhAnh.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                hinhAnh.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            break;  
        }
        connectorDB.closeConnection();
        return hinhAnh;
    }
    
    public List<HinhAnh> hienThiTatCaHinhAnhTheoMaHangHoa (String maHangHoa) throws SQLException{ //
        String query = String.format("select * from hinh_anh where ma_hang_hoa ='%s'",
                             maHangHoa);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<HinhAnh> danhSacHinhAnh = new ArrayList<>();
        while(resultTable.next()){
            HinhAnh hinhAnh = new HinhAnh();
            for (i= 1; i <= q; i++){
                hinhAnh.setMaHinhAnh(resultTable.getString("ma_hinh_anh"));
                hinhAnh.setNoiDung(resultTable.getString("noi_dung"));
                hinhAnh.setTenHinh(resultTable.getString("ten_hinh"));
                hinhAnh.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                hinhAnh.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
            }
            danhSacHinhAnh.add(hinhAnh);
        }
        connectorDB.closeConnection();
        return danhSacHinhAnh;
    }
    
    public int themHinhAnh (HinhAnh hinhAnh) throws SQLException{ //   
//        try{
            System.out.println("hihih");
           String query = "";
           if (hinhAnh.getMaNhanVien() == null){
               query = String.format("insert into hinh_anh(ma_hinh_anh, noi_dung, ten_hinh, ma_hang_hoa) " +
                             "values ('%s', '%s', '%s', '%s')",
                             hinhAnh.getMaHinhAnh(), 
                             hinhAnh.getNoiDung(),
                             hinhAnh.getTenHinh(),
                             hinhAnh.getMaHangHoa());
           }
           if (hinhAnh.getMaHangHoa()== null){
               query = String.format("insert into hinh_anh(ma_hinh_anh, noi_dung, ten_hinh, ma_nhan_vien) " +
                             "values ('%s', '%s', '%s', '%s')",
                             hinhAnh.getMaHinhAnh(), 
                             hinhAnh.getNoiDung(),
                             hinhAnh.getTenHinh(),
                             hinhAnh.getMaNhanVien());
           }
            System.out.println("query them hinh anh: " +  query);
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
//        } catch (Exception err){
//            return 0;
//        }
    }
    
    public int demSoHinhAnh() throws SQLException{
        String query = String.format("SELECT COUNT(*) AS row_count FROM hinh_anh;");
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
    
    public int updateHinhAnh (HinhAnh hinhAnhMoi) throws SQLException{ //   
        try{
           String query = String.format("update hinh_anh set ten_hinh='%s' where ma_hinh_anh='%s'",
                             hinhAnhMoi.getTenHinh(),
                             hinhAnhMoi.getMaHinhAnh());
            System.out.println(query);
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
    
    public int deleteAllHinhAnh (String maHangHoa) throws SQLException{ //   
        try{
           String query = String.format("delete from hinh_anh where ma_hang_hoa='%s'",
                             maHangHoa);
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
