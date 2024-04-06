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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class WriteCSV {
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất csv", FileDialog.SAVE);
    private Util util = new Util();
    public WriteCSV() {
        
    }
    
    public void writeCSVFile1(List<KhachHang> danhSachKhachHang){
        try {
            String url = "";
            fd.setTitle("In hóa đơn");
            fd.setLocationRelativeTo(null);
            url = getFile("danhSachKhachHang" + "");
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".csv";
            try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(url), StandardCharsets.UTF_8)) {
                writer.write('\ufeff');  // Writes the BOM
                CSVWriter write = new CSVWriter(writer);
                // ... rest of your code ...
                String set1[] = {"Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại", "Địa chỉ", "Email", "Ngày sinh", "Mã số thuế", "Nhân viên tạo", "Ngày tạo", "Loại Khách", "Tổng bán"};
                write.writeNext(set1);

                for (KhachHang khachHang : danhSachKhachHang){
                    String set[] = {String.valueOf(khachHang.getMaKhachHang()),
                    String.valueOf(khachHang.getTenKhachHang()),
                    String.valueOf(khachHang.getGioiTinh()),
                    String.valueOf(khachHang.getSoDienThoai()),
                    String.valueOf(khachHang.getDiaChi()),
                    String.valueOf(khachHang.getEmail()),
                    String.valueOf(khachHang.getNgaySinh()),
                    String.valueOf(khachHang.getMaSoThue()),
                    String.valueOf(khachHang.getMaNhanVien()),
                    String.valueOf(util.localDateParseMethod(khachHang.getNgayTao())),
                    String.valueOf(khachHang.getLoaiKhach()),
                    String.valueOf(khachHang.getTongBan()),};
                    write.writeNext(set);
                }

                write.flush();
                openFile(url);
            }
//            CSVWriter write = new CSVWriter(new FileWriter(url, StandardCharsets.UTF_8));
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(WriteCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeCSV2(){
        String url = "";
            fd.setTitle("In hóa đơn");
            fd.setLocationRelativeTo(null);
            url = getFile("danhSachKhachHang" + "");
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".csv";
        try {
            FileWriter fileWriter = new FileWriter(url);
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.ORACLE);

            // Formatting the current date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = LocalDateTime.now().format(formatter);

            // Write the first row with custom formatting
            csvPrinter.print("Gara oto Lam Vinh");
            csvPrinter.print(formattedDateTime);
            csvPrinter.println();

            // Write the second row with custom formatting
            csvPrinter.print("DANH SACH KHACH HANG");
            csvPrinter.println();

            // Write the third row with custom formatting
            csvPrinter.print("Nhan vien in: Hoang Nam");
            csvPrinter.println();

            // Write the data rows
            String set1[] = {"name", "country", "id", "dept"};
            String set2[] = {"ram", "USA", "001", "IT"};
            String set3[] = {"ramesh", "INDIA", "002", "Operation"};
            String set4[] = {"raju", "USA", "004", "Software"};
            String set5[] = {"ravi", "INDIA", "005", "ID"};

            csvPrinter.printRecord(set1);
            csvPrinter.printRecord(set2);
            csvPrinter.printRecord(set3);
            csvPrinter.printRecord(set4);
            csvPrinter.printRecord(set5);

            // Close the CSV printer
            csvPrinter.close();
            
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeCSVDanhSachKhachHang(List<KhachHang> danhSachKhachHang){
        String url = "";
        fd.setTitle("In hóa đơn");
        fd.setLocationRelativeTo(null);
        url = getFile("danhSachKhachHang" + "");
        if (url.equals("nullnull")) {
            return;
        }
        url = url + ".csv";
        String set1[] = {"Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại", "Địa chỉ", "Email", "Ngày sinh", "Mã số thuế", "Nhân viên tạo", "Ngày tạo", "Loại Khách", "Tổng bán"};
        writeUnicodeJava11(url, set1);

        for (KhachHang khachHang : danhSachKhachHang){
            String set[] = {String.valueOf(khachHang.getMaKhachHang()),
            String.valueOf(khachHang.getTenKhachHang()),
            String.valueOf(khachHang.getSoDienThoai()),
            String.valueOf(khachHang.getDiaChi()),
            String.valueOf(khachHang.getEmail()),
            String.valueOf(khachHang.getNgaySinh()),
            String.valueOf(khachHang.getMaSoThue()),
            String.valueOf(khachHang.getMaNhanVien()),
            String.valueOf(util.localDateParseMethod(khachHang.getNgayTao())),
            String.valueOf(khachHang.getLoaiKhach()),
            String.valueOf(khachHang.getTongBan()),};
            writeUnicodeJava11(url, set);
        }
        openFile(url);
            
    }
    
    public static void writeUnicodeClassic(String fileName, String[] lines) {

        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)
        ) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static void writeUnicodeJava11(String fileName, String[] lines) {

        try (FileWriter fw = new FileWriter(new File(fileName), StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(fw)) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

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
    
    
    
}
