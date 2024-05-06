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
import src.Model.KhachHang;
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
                khachHangList.add(khachHang);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return khachHangList;
    }
}
