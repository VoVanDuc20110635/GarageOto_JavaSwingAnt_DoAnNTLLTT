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
import src.Model.PhieuSuaChua;
import src.Util.Util;
/**
 *
 * @author WINDOWS 10
 */
public class PhieuSuaChuaService {
    private Util util = new Util();
    public List<PhieuSuaChua> hienThiTatCaPhieuSuaChua() throws SQLException{ //
        String query = String.format("select * from phieu_sua_chua");
        ResultSet resultTable = ConnectorDB.executeQueryConnectorDB(query);
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
                phieuSuaChua.setMaHangHoa(resultTable.getString("ma_hang_hoa"));
                phieuSuaChua.setMaKhachHang(resultTable.getString("ma_khach_hang"));
                phieuSuaChua.setMaLoaiXe(resultTable.getString("ma_loai_xe"));
                phieuSuaChua.setMaNhanVien(resultTable.getString("ma_nhan_vien"));
                phieuSuaChua.setMaNhomHang(resultTable.getString("ma_nhom_hang"));                
            }
            danhSachPhieuSuaChua.add(phieuSuaChua);
        }
        return danhSachPhieuSuaChua;
    }
    
}
