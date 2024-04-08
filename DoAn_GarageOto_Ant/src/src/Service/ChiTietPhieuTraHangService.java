/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Service;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import src.ConnectDB.ConnectorDB;
import java.time.format.DateTimeFormatter;
import src.Model.ChiTietPhieuTraHang;
import src.Util.Util;
/*
 *
 * @author WINDOWS 10
 */
public class ChiTietPhieuTraHangService {
    private Util util = new Util();
    private ConnectorDB connectorDB = new ConnectorDB();
    public List<ChiTietPhieuTraHang> hienThiTatCaChiTietPhieuTraHangTheoMaPhieuTraHang (String maPhieuTraHang) throws SQLException{ //
        String query = String.format("select * from chi_tiet_phieu_tra_hang where ma_phieu_tra_hang = '%s'", maPhieuTraHang);
        ResultSet resultTable = connectorDB.executeQueryConnectorDB(query);
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        int q = resultSetMetaData.getColumnCount();
        int i;
        List<ChiTietPhieuTraHang> danhSachChiTietPhieuTraHang = new ArrayList<>();
        while(resultTable.next()){
            ChiTietPhieuTraHang chiTietPhieuTraHang = new ChiTietPhieuTraHang();
            
                chiTietPhieuTraHang.setMaChiTietPhieuTraHang(resultTable.getString("ma_chi_tiet_phieu_tra_hang"));
                chiTietPhieuTraHang.setGiaTraHang(resultTable.getDouble("gia_tra_hang"));
                chiTietPhieuTraHang.setSoLuong(resultTable.getShort("so_luong"));
                chiTietPhieuTraHang.setThanhTien(resultTable.getDouble("thanh_tien"));
                chiTietPhieuTraHang.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                chiTietPhieuTraHang.setMaPhieuTraHang(resultTable.getString("ma_phieu_tra_hang"));
            
            danhSachChiTietPhieuTraHang.add(chiTietPhieuTraHang);
        }
        connectorDB.closeConnection();
        return danhSachChiTietPhieuTraHang;
    }
    
    public int themChiTietPhieuTraHang (ChiTietPhieuTraHang chiTietPhieuTraHang) throws SQLException{ //   
        try{
           String query = String.format("insert into chi_tiet_phieu_tra_hang(ma_chi_tiet_phieu_tra_hang, gia_tra_hang, so_luong, thanh_tien, ma_hang_hoa, ma_phieu_tra_hang)" +
                             "values ('%s', %s, %s, %s , '%s' , '%s')",
                chiTietPhieuTraHang.getMaChiTietPhieuTraHang(),
                String.valueOf(chiTietPhieuTraHang.getGiaTraHang()),
                String.valueOf(chiTietPhieuTraHang.getSoLuong()),
                String.valueOf(chiTietPhieuTraHang.getThanhTien()),
                chiTietPhieuTraHang.getMaHangHoa(),
                chiTietPhieuTraHang.getMaPhieuTraHang());
            connectorDB.executeUpdateQueryConnectorDB(query);
            connectorDB.closeConnection();
            return 1;
        } catch (Exception err){
            return 0;
        }
    }
}
