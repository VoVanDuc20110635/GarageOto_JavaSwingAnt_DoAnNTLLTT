/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Util;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import src.Model.ChiNhanh;
import src.Model.HangHoa;
import src.Model.KhachHang;
import src.Model.NhaCungCap;
import src.Model.NhanVien;
/**
 *
 * @author WINDOWS 10
 */
public class ImportFileCSV {
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Import csv", FileDialog.LOAD);
    private Util util = new Util();

    public ImportFileCSV() {
    }
    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name);
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }
    
    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public List<KhachHang> readCsvFileDanhSachKhachHang() {
        String url = "";
            fd.setTitle("Import file csv");
            fd.setLocationRelativeTo(null);
            url = getFile("danhSachKhachHang" + "");
            if (url.equals("nullnull")) {
                return null;
            }
//            url = url;
        List<KhachHang> khachHangList = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm");
        
        DateTimeFormatter dateFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int i = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (i ==0 ){
                    i++;
                    continue;
                }
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                System.out.println(line);
                // Create a new KhachHang object and add it to the list
                KhachHang khachHang = new KhachHang();
                khachHang.setTenKhachHang(values[0].replace("\"", "").trim());
                khachHang.setGioiTinh(values[1].replace("\"", "").trim());
                khachHang.setSoDienThoai(values[2].replace("\"", "").trim());
                khachHang.setDiaChi(values[3].replace("\"", "").trim());
                khachHang.setEmail(values[4].replace("\"", "").trim());
                khachHang.setNgaySinh(LocalDate.parse(values[5].replace("\"", "").trim(), dateFormatter));
                khachHang.setMaSoThue(values[6].replace("\"", "").trim());
                khachHang.setMaNhanVien(values[7].replace("\"", "").trim());
                khachHang.setNgayTao(LocalDateTime.parse(values[8].replace("\"", "").trim(), dateTimeFormatter));
                khachHang.setLoaiKhach(values[9].replace("\"", "").trim());
                khachHang.setTongBan(Double.parseDouble(values[10].replace("\"", "").trim()));
                khachHang.setMaChiNhanh(values[11].replace("\"", "").trim());
                khachHangList.add(khachHang);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return khachHangList;
    }
    
    public List<HangHoa> readCsvFileDanhSachHangHoa() {
        String url = "";
            fd.setTitle("Import file csv");
            fd.setLocationRelativeTo(null);
            url = getFile("danhSachHangHoa" + "");
            if (url.equals("nullnull")) {
                return null;
            }
//            url = url;
        List<HangHoa> hangHoaList = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm");
        
        DateTimeFormatter dateFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int i = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (i ==0 ){
                    i++;
                    continue;
                }
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                // Create a new KhachHang object and add it to the list
                HangHoa hangHoa = new HangHoa();
                hangHoa.setGiaBan(Double.parseDouble(values[0].replace("\"", "").trim()));
                hangHoa.setGiaVon(Double.parseDouble(values[1].replace("\"", "").trim()));
                hangHoa.setKhachDat(Short.parseShort(values[2].replace("\"", "").trim()));
                hangHoa.setTenHangHoa(values[3].replace("\"", "").trim());
                hangHoa.setTonKho(Short.parseShort(values[4].replace("\"", "").trim()));
                hangHoa.setMaNhomHang(values[5].replace("\"", "").trim());
                hangHoa.setLoaiHang(values[6].replace("\"", "").trim());
                hangHoa.setTrangThai(Integer.parseInt(values[7].replace("\"", "").trim()));
                hangHoa.setGiaThay(Double.parseDouble(values[8].replace("\"", "").trim()));
                
                hangHoaList.add(hangHoa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hangHoaList;
    }
    
    public List<NhaCungCap> readCsvFileDanhSachNhaCungCap() {
        String url = "";
            fd.setTitle("Import file csv");
            fd.setLocationRelativeTo(null);
            url = getFile("danhSachNhaCungCap" + "");
            if (url.equals("nullnull")) {
                return null;
            }
//            url = url;
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm");
        
        DateTimeFormatter dateFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int i = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                if (i ==0 ){
                    i++;
                    continue;
                }
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                // Create a new KhachHang object and add it to the list
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setDiaChi(values[0].replace("\"", "").trim());
                nhaCungCap.setEmail(values[1].replace("\"", "").trim());
                nhaCungCap.setMaSoThue(values[2].replace("\"", "").trim());
                nhaCungCap.setSoDienThoai(values[3].replace("\"", "").trim());
                nhaCungCap.setTenNhaCungCap(values[4].replace("\"", "").trim());
                nhaCungCap.setNoCanTra(0);
                nhaCungCap.setTongMua(0);
                
                nhaCungCapList.add(nhaCungCap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nhaCungCapList;
    }
    
    
    public List<NhanVien> readCsvFileDanhSachNhanVien() {
        String url = "";
            fd.setTitle("Import file csv");
            fd.setLocationRelativeTo(null);
            url = getFile("danhSachNhanVien" + "");
            if (url.equals("nullnull")) {
                return null;
            }
//            url = url;
        List<NhanVien> nhanVienList = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm");
        
        DateTimeFormatter dateFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int i = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (i ==0 ){
                    i++;
                    continue;
                }
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                System.out.println(line);
                // Create a new KhachHang object and add it to the list
                NhanVien nhanVien = new NhanVien();
                nhanVien.setCccd(values[0].replace("\"", "").trim());
                nhanVien.setChucDanh(values[1].replace("\"", "").trim());
                nhanVien.setGioiTinh(values[2].replace("\"", "").trim());
                nhanVien.setNgayBatDauLamViec(LocalDate.parse(values[3].replace("\"", "").trim(), dateFormatterTrue));
                nhanVien.setNgaySinh(LocalDate.parse(values[4].replace("\"", "").trim(), dateFormatterTrue));
                nhanVien.setSoDienThoai(values[5].replace("\"", "").trim());
                nhanVien.setTenNhanVien(values[6].replace("\"", "").trim());
                nhanVien.setDiaChi(values[7].replace("\"", "").trim());
                nhanVien.setMaSoThue(values[8].replace("\"", "").trim());
                nhanVien.setTrangThai(values[9].replace("\"", "").trim());
                nhanVienList.add(nhanVien);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nhanVienList;
    }
    
    public List<ChiNhanh> readCsvFileDanhSachChiNhanh() {
        String url = "";
            fd.setTitle("Import file csv");
            fd.setLocationRelativeTo(null);
            url = getFile("danhSachChiNhanh" + "");
            if (url.equals("nullnull")) {
                return null;
            }
//            url = url;
        List<ChiNhanh> chiNhanhList = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm");
        
        DateTimeFormatter dateFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatterTrue = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int i = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (i ==0 ){
                    i++;
                    continue;
                }
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                // Create a new KhachHang object and add it to the list
                ChiNhanh chiNhanh = new ChiNhanh();
                chiNhanh.setDiaChi(values[0].replace("\"", "").trim());
                chiNhanh.setTenChiNhanh(values[1].replace("\"", "").trim());
                chiNhanh.setTrangThai(values[2].replace("\"", "").trim());
                chiNhanh.setSoDienThoai(values[3].replace("\"", "").trim());
                chiNhanhList.add(chiNhanh);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chiNhanhList;
    }
}
