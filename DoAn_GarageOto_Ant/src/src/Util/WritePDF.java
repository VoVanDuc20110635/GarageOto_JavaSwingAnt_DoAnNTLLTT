/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Util;
import com.itextpdf.text.Chunk;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import src.Model.BangChamCong;
import src.Model.BangLuong;
import src.Model.BangLuongNhanVien;
import src.Model.ChiTietPhieuNhapHang;
import src.Model.ChiTietPhieuTraHang;
import src.Model.HoaDon;
import src.Model.HoaDonChiTiet;
import src.Model.KhachHang;
import src.Model.LichLamViec;
import src.Model.LichLamViecCaLam;
import src.Model.NhaCungCap;
import src.Model.NhanVien;
import src.Model.PhieuLuong;
import src.Model.PhieuNhapHang;
import src.Model.PhieuTraHang;
import src.Service.BangLuongNhanVienService;
import src.Service.BangLuongService;
import src.Service.CaLamService;
import src.Service.KhachHangService;
import src.Service.LichLamViecCaLamService;
import src.Service.LichLamViecService;
import src.Service.NhaCungCapService;
import src.Service.NhanVienService;
/**
 *
 * @author WINDOWS 10
 */
public class WritePDF {
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontNormal10;
    Font fontBold15;
    Font fontBold25;
    Font fontBoldItalic15;
    NhanVienService nhanVienService = new NhanVienService();
    KhachHangService khachHangService = new KhachHangService();
    NhaCungCapService nhaCungCapService = new NhaCungCapService();
    private BangLuongService bangLuongService = new BangLuongService();
    private CaLamService caLamService = new CaLamService();
    private LichLamViecService lichLamViecService = new LichLamViecService();
    private BangLuongNhanVienService bangLuongNhanVienService = new BangLuongNhanVienService();
    private LichLamViecCaLamService lichLamViecCaLamService = new LichLamViecCaLamService();
    Util util = new Util();
    String folderPDF = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\DoAnNNLLTT_31_3_2024\\GarageOto_JavaSwingAnt_DoAnNTLLTT\\DoAn_GarageOto_Ant\\filePDF\\";
    public WritePDF() {
        try {
            fontNormal10 = new Font(BaseFont.createFont("D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\[cnttqn.net] SVN-Times New Roman\\SVN-Times New Roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12, Font.NORMAL);
            fontBold25 = new Font(BaseFont.createFont("D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\[cnttqn.net] SVN-Times New Roman\\SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontBold15 = new Font(BaseFont.createFont("D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\[cnttqn.net] SVN-Times New Roman\\SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
            fontBoldItalic15 = new Font(BaseFont.createFont("D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\[cnttqn.net] SVN-Times New Roman\\SVN-Times New Roman Bold Italic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }
    
    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontBold25));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
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

    public static Chunk createWhiteSpace(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(" ");
        }
        return new Chunk(builder.toString());
    }

    public void writeHoaDon(HoaDon hoaDon, List<HoaDonChiTiet> danhSachHoaDonChiTiet, KhachHang khachHang) {
        String url = "";
        try {
            fd.setTitle("In hóa đơn");
            fd.setLocationRelativeTo(null);
            url = getFile(hoaDon.getMaHoaDon() + "");
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph company = new Paragraph("Garage oto Lâm Vinh", fontBold15);
            company.add(new Chunk(createWhiteSpace(20)));
            Date today = new Date(System.currentTimeMillis());
            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
            company.setAlignment(Element.ALIGN_LEFT);
            document.add(company);
            // Thêm tên công ty vào file PDF
            document.add(Chunk.NEWLINE);
            Paragraph header = new Paragraph("HÓA ĐƠN", fontBold25);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            
            // Thêm dòng Paragraph vào file PDF

            Paragraph paragraph1 = new Paragraph("Mã phiếu: " + hoaDon.getMaHoaDon(), fontNormal10);
            String tenKhachHang = khachHang.getTenKhachHang();
            Paragraph paragraph2 = new Paragraph("Khách hàng: " + tenKhachHang, fontNormal10);
            paragraph2.add(new Chunk(createWhiteSpace(5)));
            paragraph2.add(new Chunk("-"));
            paragraph2.add(new Chunk(createWhiteSpace(5)));
            String diaChi = khachHang.getDiaChi();
            
            paragraph2.add(new Chunk(diaChi, fontNormal10));

            NhanVien nhanVien = new NhanVien();
            nhanVien = nhanVienService.hienThiNhanVienTheoMaNhanVien(hoaDon.getMaNhanVien());
            String ngtao = nhanVien.getTenNhanVien() ;
            Paragraph paragraph3 = new Paragraph("Người thực hiện: " + ngtao, fontNormal10);
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("-"));
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("Mã nhân viên: " + nhanVien.getMaNhanVien(), fontNormal10));
            Paragraph paragraph4 = new Paragraph("Thời gian nhập: " + util.localDateParseMethod(hoaDon.getThoiGian()), fontNormal10);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(Chunk.NEWLINE);
            // Thêm table 5 cột vào file PDF
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{30f, 35f, 20f, 15f, 20f, 20f});
            PdfPCell cell;

            table.addCell(new PdfPCell(new Phrase("Mã hàng hóa", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tên hàng hóa", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Giá", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Số lượng", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Giảm giá", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tổng", fontBold15)));
            for (int i = 0; i < 6; i++) {
                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
            for (HoaDonChiTiet hoaDonChiTiet : danhSachHoaDonChiTiet) {
                table.addCell(new PdfPCell(new Phrase(hoaDonChiTiet.getMaHangHoa(), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(hoaDonChiTiet.getMaHangHoa(), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(formatter.format(hoaDonChiTiet.getGiaBan()) + "đ", fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(hoaDonChiTiet.getSoLuong()), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(hoaDonChiTiet.getGiamGia()), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(formatter.format(hoaDonChiTiet.getSoLuong()* hoaDonChiTiet.getGiaBan()*(1-hoaDonChiTiet.getGiamGia()/100)) + "đ", fontNormal10)));
            }

            document.add(table);
            document.add(Chunk.NEWLINE);

            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thành tiền: " + formatter.format(hoaDon.getTongTien()) + "đ", fontBold15));
            paraTongThanhToan.setIndentationLeft(300);

            document.add(paraTongThanhToan);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(22);
            paragraph.add(new Chunk("Người lập phiếu", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Nhân viên nhận", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Khách hàng", fontBoldItalic15));

            Paragraph sign = new Paragraph();
            sign.setIndentationLeft(23);
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(30)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(28)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            document.add(paragraph);
            document.add(sign);

            document.close();
            writer.close();
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        } catch (SQLException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void writePhieuNhapHang(PhieuNhapHang phieuNhapHang, List<ChiTietPhieuNhapHang> danhSachChiTietPhieuNhapHang, NhaCungCap nhaCungCap) {
        String url = "";
        try {
            fd.setTitle("In phiếu nhập hàng");
            fd.setLocationRelativeTo(null);
            url = getFile(phieuNhapHang.getPhieuNhapHang() + "");
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph company = new Paragraph("Garage oto Lâm Vinh", fontBold15);
            company.add(new Chunk(createWhiteSpace(20)));
            Date today = new Date(System.currentTimeMillis());
            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
            company.setAlignment(Element.ALIGN_LEFT);
            document.add(company);
            // Thêm tên công ty vào file PDF
            document.add(Chunk.NEWLINE);
            Paragraph header = new Paragraph("PHIẾU NHẬP HÀNG", fontBold25);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            
            // Thêm dòng Paragraph vào file PDF

            Paragraph paragraph1 = new Paragraph("Mã phiếu: " + phieuNhapHang.getPhieuNhapHang(), fontNormal10);
            String tenKhachHang = nhaCungCap.getTenNhaCungCap();
            Paragraph paragraph2 = new Paragraph("Nhà cung cấp: " + tenKhachHang, fontNormal10);
            paragraph2.add(new Chunk(createWhiteSpace(5)));
            paragraph2.add(new Chunk("-"));
            paragraph2.add(new Chunk(createWhiteSpace(5)));
            String diaChi = nhaCungCap.getDiaChi();
            
            paragraph2.add(new Chunk(diaChi, fontNormal10));

            NhanVien nhanVien = new NhanVien();
            nhanVien = nhanVienService.hienThiNhanVienTheoMaNhanVien(phieuNhapHang.getMaNhanVienTao());
            String ngtao = nhanVien.getTenNhanVien() ;
            Paragraph paragraph3 = new Paragraph("Người thực hiện: " + ngtao, fontNormal10);
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("-"));
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("Mã nhân viên: " + nhanVien.getMaNhanVien(), fontNormal10));
            Paragraph paragraph4 = new Paragraph("Thời gian nhập: " + util.localDateParseMethod(phieuNhapHang.getThoiGian()), fontNormal10);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(Chunk.NEWLINE);
            // Thêm table 5 cột vào file PDF
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{30f, 35f, 20f, 15f, 20f, 20f});
            PdfPCell cell;

            table.addCell(new PdfPCell(new Phrase("Mã hàng hóa", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tên hàng hóa", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Giá nhập", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Số lượng", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Giảm giá", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tổng", fontBold15)));
            for (int i = 0; i < 6; i++) {
                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
            for (ChiTietPhieuNhapHang chiTietPhieuNhapHang : danhSachChiTietPhieuNhapHang) {
                table.addCell(new PdfPCell(new Phrase(chiTietPhieuNhapHang.getMaHangHoa(), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(chiTietPhieuNhapHang.getMaHangHoa(), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(formatter.format(chiTietPhieuNhapHang.getGia_nhap()) + "đ", fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(chiTietPhieuNhapHang.getSo_luong()), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(chiTietPhieuNhapHang.getGiam_gia()), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(formatter.format(chiTietPhieuNhapHang.getSo_luong()* chiTietPhieuNhapHang.getGia_nhap()*(1-chiTietPhieuNhapHang.getGiam_gia()/100)) + "đ", fontNormal10)));
            }

            document.add(table);
            document.add(Chunk.NEWLINE);

            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thành tiền: " + formatter.format(phieuNhapHang.getTong()) + "đ", fontBold15));
            paraTongThanhToan.setIndentationLeft(300);

            document.add(paraTongThanhToan);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(22);
            paragraph.add(new Chunk("Người lập phiếu", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Nhân viên nhận", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Nhà cung cấp", fontBoldItalic15));

            Paragraph sign = new Paragraph();
            sign.setIndentationLeft(23);
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(30)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(28)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            document.add(paragraph);
            document.add(sign);

            document.close();
            writer.close();
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        } catch (SQLException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     public void writePhieuTraHang(PhieuTraHang phieuTraHang, List<ChiTietPhieuTraHang> danhSachPhieuTraHang) {
        String url = "";
        try {
            fd.setTitle("In phiếu trả hàng");
            fd.setLocationRelativeTo(null);
            url = getFile(phieuTraHang.getMaPhieuTraHang() + "");
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph company = new Paragraph("Garage oto Lâm Vinh", fontBold15);
            company.add(new Chunk(createWhiteSpace(20)));
            Date today = new Date(System.currentTimeMillis());
            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
            company.setAlignment(Element.ALIGN_LEFT);
            document.add(company);
            // Thêm tên công ty vào file PDF
            document.add(Chunk.NEWLINE);
            Paragraph header = new Paragraph("PHIẾU TRẢ HÀNG", fontBold25);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            
            // Thêm dòng Paragraph vào file PDF
            Paragraph paragraph2;
            Paragraph paragraph1 = new Paragraph("Mã phiếu: " + phieuTraHang.getMaPhieuTraHang(), fontNormal10);
            if (phieuTraHang.getMaNhaCungCap() == null){
                KhachHang khachHang = khachHangService.hienThiKhachHangTheoMaKhachHang(phieuTraHang.getMaKhachHang());
                
                paragraph2 = new Paragraph("Khách hàng: " + khachHang.getMaKhachHang() + " " + khachHang.getTenKhachHang(), fontNormal10);
                paragraph2.add(new Chunk(createWhiteSpace(5)));
                paragraph2.add(new Chunk("-"));
                paragraph2.add(new Chunk(createWhiteSpace(5)));
                String diaChi = khachHang.getDiaChi();
                paragraph2.add(new Chunk(diaChi, fontNormal10));
            } else {
                NhaCungCap nhaCungCap = nhaCungCapService.hienThiNhaCungCapTheoMaNhaCungCap(phieuTraHang.getMaNhaCungCap());
                paragraph2 = new Paragraph("Nhà cung cấp: " + nhaCungCap.getMaNhaCungCap() + " " + nhaCungCap.getTenNhaCungCap() , fontNormal10);
                paragraph2.add(new Chunk(createWhiteSpace(5)));
                paragraph2.add(new Chunk("-"));
                paragraph2.add(new Chunk(createWhiteSpace(5)));
                String diaChi = nhaCungCap.getDiaChi();
                paragraph2.add(new Chunk(diaChi, fontNormal10));
            }
            

            NhanVien nhanVien = new NhanVien();
            nhanVien = nhanVienService.hienThiNhanVienTheoMaNhanVien(phieuTraHang.getMaNhanVien());
            String ngtao = nhanVien.getTenNhanVien() ;
            Paragraph paragraph3 = new Paragraph("Người thực hiện: " + nhanVien.getMaNhanVien(), fontNormal10);
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("-"));
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("Mã nhân viên: " + nhanVien.getMaNhanVien(), fontNormal10));
            Paragraph paragraph4 = new Paragraph("Thời gian nhập: " + util.localDateParseMethod(phieuTraHang.getThoiGian()), fontNormal10);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(Chunk.NEWLINE);
            // Thêm table 5 cột vào file PDF
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{30f, 35f, 20f, 15f, 20f});
            PdfPCell cell;

            table.addCell(new PdfPCell(new Phrase("Mã hàng hóa", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tên hàng hóa", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Giá", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Số lượng", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tổng", fontBold15)));
            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
            for (ChiTietPhieuTraHang chiTietPhieuTraHang : danhSachPhieuTraHang) {
                table.addCell(new PdfPCell(new Phrase(chiTietPhieuTraHang.getMaChiTietPhieuTraHang(), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(chiTietPhieuTraHang.getTenHangHoa(), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(formatter.format(chiTietPhieuTraHang.getGiaTraHang()) + "đ", fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(chiTietPhieuTraHang.getSoLuong()), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(formatter.format(chiTietPhieuTraHang.getSoLuong()* chiTietPhieuTraHang.getGiaTraHang()) + "đ", fontNormal10)));
            }

            document.add(table);
            document.add(Chunk.NEWLINE);

            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thành tiền: " + formatter.format(phieuTraHang.getCanTra()) + "đ", fontBold15));
            paraTongThanhToan.setIndentationLeft(300);

            document.add(paraTongThanhToan);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(22);
            paragraph.add(new Chunk("Người lập phiếu", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Nhân viên nhận", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Nhà cung cấp", fontBoldItalic15));

            Paragraph sign = new Paragraph();
            sign.setIndentationLeft(23);
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(30)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(28)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            document.add(paragraph);
            document.add(sign);

            document.close();
            writer.close();
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        } catch (SQLException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     public void writePhieuLuong(NhanVien nhanVienDangNhap, NhanVien nhanVien, PhieuLuong phieuLuong, LichLamViec lichLamViecMain, List<LichLamViec> danhSachLichTangCaMain, List<BangLuong> danhSachTroCapMain, List<BangChamCong> danhSachBangChamCongMain, int thang, int nam) {
        String url = "";
        try {
            fd.setTitle("In phiếu lương");
            fd.setLocationRelativeTo(null);
            url = getFile(nhanVien.getMaNhanVien() + "thang" + thang + "nam" + nam + "");
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph company = new Paragraph("Garage oto Lâm Vinh", fontBold15);
            company.add(new Chunk(createWhiteSpace(20)));
            Date today = new Date(System.currentTimeMillis());
            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
            company.setAlignment(Element.ALIGN_LEFT);
            document.add(company);
            // Thêm tên công ty vào file PDF
            document.add(Chunk.NEWLINE);
            Paragraph header = new Paragraph("PHIẾU LƯƠNG", fontBold25);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            
            // Thêm dòng Paragraph vào file PDF

            Paragraph paragraph1 = new Paragraph("Mã phiếu: " + phieuLuong.getMaPhieu() , fontNormal10);
            String tenKhachHang = nhanVien.getTenNhanVien();
            Paragraph paragraph2 = new Paragraph("Nhân viên: " + tenKhachHang, fontNormal10);
            paragraph2.add(new Chunk(createWhiteSpace(5)));
            paragraph2.add(new Chunk("-"));
            paragraph2.add(new Chunk(createWhiteSpace(5)));
            String diaChi = nhanVien.getDiaChi();
            
            paragraph2.add(new Chunk(diaChi, fontNormal10));

            String ngtao = nhanVienDangNhap.getTenNhanVien();
            Paragraph paragraph3 = new Paragraph("Người thực hiện: " + ngtao, fontNormal10);
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("-"));
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("Mã nhân viên: " + nhanVienDangNhap.getMaNhanVien(), fontNormal10));
            Paragraph paragraph4 = new Paragraph("Thời gian nhập: " + util.localDateParseMethod(phieuLuong.getNgayIn()), fontNormal10);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(Chunk.NEWLINE);
            
            BangLuongNhanVien bangLuongNhanVien = bangLuongNhanVienService.hienThiBangLuongNhanVienTheoLichLamViec(lichLamViecMain.getMaLichLamViec());
            BangLuong bangLuong  = bangLuongService.hienThiBangLuongTheoMaBangLuong(bangLuongNhanVien.getMaBangLuong());
            
            List<LichLamViecCaLam> danhSachLamViecCaLam = lichLamViecCaLamService.hienThiTatCaLichLamViecCaLamTheoMaLichLamViec(lichLamViecMain.getMaLichLamViec());
            for (LichLamViecCaLam lichLamViecCaLam: danhSachLamViecCaLam){
                lichLamViecMain.getDanhSachCaLam().add(caLamService.hienThiCaLamTheoMaCaLam(lichLamViecCaLam.getMaCaLam()));
            }
            String danhSachTenCaLam = "";
            for (int i =0; i< lichLamViecMain.getDanhSachCaLam().size(); i++){
                danhSachTenCaLam += lichLamViecMain.getDanhSachCaLam().get(i).getTenCaLam();
                if (i != lichLamViecMain.getDanhSachCaLam().size()-1){
                    danhSachTenCaLam += ", ";
                }
            }
            
            Paragraph paragraph5 = new Paragraph("Lịch làm việc" , fontBold15);
            Paragraph paragraph6 = new Paragraph("Mã lịch làm việc: " + lichLamViecMain.getMaLichLamViec(), fontNormal10);
            Paragraph paragraph7 = new Paragraph("Thời gian: " +  String.valueOf(lichLamViecMain.getNgayBatDau()) + " - " + String.valueOf(lichLamViecMain.getNgayKetThuc()), fontNormal10);
            Paragraph paragraph8 = new Paragraph("Ca làm: " + danhSachTenCaLam, fontNormal10);
            Paragraph paragraph9 = new Paragraph("Mã bảng lương: " + bangLuong.getMaBangLuong(), fontNormal10);
            Paragraph paragraph10 = new Paragraph("Tiền lương: " + bangLuong.getTienLuong() +"/ 1 " + bangLuong.getCheDoLuong(), fontNormal10);
            Paragraph paragraph11 = new Paragraph("Nội dung: " + bangLuong.getNoiDung(), fontNormal10);
            document.add(paragraph5);
            document.add(paragraph6);
            document.add(paragraph7);
            document.add(paragraph8);
            document.add(paragraph9);
            document.add(paragraph10);
            document.add(paragraph11);
            document.add(Chunk.NEWLINE);
            
            
            // Thêm table 5 cột vào file PDF
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{30f, 35f, 20f, 15f, 20f, 20f});
            PdfPCell cell;

            table.addCell(new PdfPCell(new Phrase("Mã lịch tăng ca", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Ngày bắt đầu", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Ngày kết thúc", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Số giờ tăng ca", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Mã bảng lương", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tiền lương", fontBold15)));
            for (int i = 0; i < 6; i++) {
                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
            for (LichLamViec lichLamViec : danhSachLichTangCaMain) {
                table.addCell(new PdfPCell(new Phrase(lichLamViec.getMaLichLamViec(), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(lichLamViec.getNgayBatDau()), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(lichLamViec.getNgayKetThuc()), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(lichLamViec.getTangCa()), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(lichLamViec.getBangLuong().getMaBangLuong()), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(formatter.format(lichLamViec.getBangLuong().getTienLuong()) + "đ/ 1 " + lichLamViec.getBangLuong().getCheDoLuong(), fontNormal10)));
            }

            document.add(table);
            document.add(Chunk.NEWLINE);

            // tro cap
            // Thêm table 5 cột vào file PDF
            PdfPTable table2 = new PdfPTable(3);
            table2.setWidthPercentage(100);
            table2.setWidths(new float[]{30f, 35f, 20f});
            PdfPCell cell2;
 
            table2.addCell(new PdfPCell(new Phrase("Mã phụ cấp", fontBold15)));
            table2.addCell(new PdfPCell(new Phrase("Tiền", fontBold15)));
            table2.addCell(new PdfPCell(new Phrase("Nội dung", fontBold15)));
            
            for (int i = 0; i < 3; i++) {
                cell2 = new PdfPCell(new Phrase(""));
                table2.addCell(cell2);
            }

            //Truyen thong tin tung chi tiet vao table
            for (BangLuong bangLuong1 : danhSachTroCapMain) {
                table2.addCell(new PdfPCell(new Phrase(bangLuong1.getMaBangLuong(), fontNormal10)));
                table2.addCell(new PdfPCell(new Phrase(formatter.format(bangLuong1.getTienLuong()) + "đ/ 1 " + bangLuong1.getCheDoLuong(), fontNormal10)));
                table2.addCell(new PdfPCell(new Phrase(bangLuong1.getNoiDung(), fontNormal10)));
            }

            document.add(table2);
            document.add(Chunk.NEWLINE);
            
            // vang, tre
            // tro cap
            // Thêm table 5 cột vào file PDF
            PdfPTable table3 = new PdfPTable(4);
            table3.setWidthPercentage(100);
            table3.setWidths(new float[]{30f, 35f, 20f, 20f});
            PdfPCell cell3;
 
            table3.addCell(new PdfPCell(new Phrase("Mã", fontBold15)));
            table3.addCell(new PdfPCell(new Phrase("Ngày", fontBold15)));
            table3.addCell(new PdfPCell(new Phrase("Trạng thái", fontBold15)));
            table3.addCell(new PdfPCell(new Phrase("Trừ lương", fontBold15)));
            
            for (int i = 0; i < 4; i++) {
                cell3 = new PdfPCell(new Phrase(""));
                table3.addCell(cell3);
            }

            //Truyen thong tin tung chi tiet vao table
            for (BangChamCong bangChamCong : danhSachBangChamCongMain) {
                table3.addCell(new PdfPCell(new Phrase(bangChamCong.getMaCaLam(), fontNormal10)));
                table3.addCell(new PdfPCell(new Phrase(String.valueOf(bangChamCong.getNgayLam()), fontNormal10)));
                table3.addCell(new PdfPCell(new Phrase(bangChamCong.getTrangThai(), fontNormal10)));
                
                
                if (bangChamCong.getTrangThai().equals("Đi trễ")){
                    Double truTien = bangLuong.getTienLuong()/30*0.1;
                    table3.addCell(new PdfPCell(new Phrase(String.valueOf(truTien), fontNormal10)));
                } 
                if (bangChamCong.getTrangThai().equals("Vắng")){
                    Double truTien = bangLuong.getTienLuong()/30;
                    table3.addCell(new PdfPCell(new Phrase(String.valueOf(truTien), fontNormal10)));
                }
            }

            document.add(table3);
            document.add(Chunk.NEWLINE);
            

            
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thành tiền: " + formatter.format(phieuLuong.getTongLuong()) + "đ", fontBold15));
            paraTongThanhToan.setIndentationLeft(300);

            document.add(paraTongThanhToan);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(22);
            paragraph.add(new Chunk("Người lập phiếu", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Nhân viên nhận", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Khách hàng", fontBoldItalic15));

            Paragraph sign = new Paragraph();
            sign.setIndentationLeft(23);
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(30)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(28)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            document.add(paragraph);
            document.add(sign);

            document.close();
            writer.close();
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        } catch (SQLException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
//    public void writePX(int maphieu) {
//        String url = "";
//        try {
//            fd.setTitle("In phiếu xuất");
//            fd.setLocationRelativeTo(null);
//            url = getFile(maphieu + "");
//            if (url.equals("nullnull")) {
//                return;
//            }
//            url = url + ".pdf";
//            file = new FileOutputStream(url);
//            document = new Document();
//            PdfWriter writer = PdfWriter.getInstance(document, file);
//            document.open();
//
//            Paragraph company = new Paragraph("Hệ thống quản lý điện thoại AnBaoChSi", fontBold15);
//            company.add(new Chunk(createWhiteSpace(20)));
//            Date today = new Date(System.currentTimeMillis());
//            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
//            company.setAlignment(Element.ALIGN_LEFT);
//            document.add(company);
//            // Thêm tên công ty vào file PDF
//            document.add(Chunk.NEWLINE);
//            Paragraph header = new Paragraph("THÔNG TIN PHIẾU XUẤT", fontBold25);
//            header.setAlignment(Element.ALIGN_CENTER);
//            document.add(header);
//            PhieuXuatDTO px = PhieuXuatDAO.getInstance().selectById(maphieu + "");
//            // Thêm dòng Paragraph vào file PDF
//
//            Paragraph paragraph1 = new Paragraph("Mã phiếu: PX-" + px.getMaphieu(), fontNormal10);
//            String hoten = KhachHangDAO.getInstance().selectById(px.getMakh() + "").getHoten();
//            Paragraph paragraph2 = new Paragraph("khách hàng: " + hoten, fontNormal10);
//            paragraph2.add(new Chunk(createWhiteSpace(5)));
//            paragraph2.add(new Chunk("-"));
//            paragraph2.add(new Chunk(createWhiteSpace(5)));
//            String diachikh = KhachHangDAO.getInstance().selectById(px.getMakh() + "").getDiachi();
//            paragraph2.add(new Chunk(diachikh, fontNormal10));
//
//            String ngtao = NhanVienDAO.getInstance().selectById(px.getManguoitao() + "").getHoten();
//            Paragraph paragraph3 = new Paragraph("Người thực hiện: " + ngtao, fontNormal10);
//            paragraph3.add(new Chunk(createWhiteSpace(5)));
//            paragraph3.add(new Chunk("-"));
//            paragraph3.add(new Chunk(createWhiteSpace(5)));
//            paragraph3.add(new Chunk("Mã nhân viên: " + px.getManguoitao(), fontNormal10));
//            Paragraph paragraph4 = new Paragraph("Thời gian nhập: " + formatDate.format(px.getThoigiantao()), fontNormal10);
//            document.add(paragraph1);
//            document.add(paragraph2);
//            document.add(paragraph3);
//            document.add(paragraph4);
//            document.add(Chunk.NEWLINE);
//            // Thêm table 5 cột vào file PDF
//            PdfPTable table = new PdfPTable(5);
//            table.setWidthPercentage(100);
//            table.setWidths(new float[]{30f, 35f, 20f, 15f, 20f});
//            PdfPCell cell;
//
//            table.addCell(new PdfPCell(new Phrase("Tên sản phẩm", fontBold15)));
//            table.addCell(new PdfPCell(new Phrase("Phiên bản", fontBold15)));
//            table.addCell(new PdfPCell(new Phrase("Giá", fontBold15)));
//            table.addCell(new PdfPCell(new Phrase("Số lượng", fontBold15)));
//            table.addCell(new PdfPCell(new Phrase("Tổng tiền", fontBold15)));
//            for (int i = 0; i < 5; i++) {
//                cell = new PdfPCell(new Phrase(""));
//                table.addCell(cell);
//            }
//
//            //Truyen thong tin tung chi tiet vao table
//            for (ChiTietPhieuDTO ctp : ChiTietPhieuXuatDAO.getInstance().selectAll(maphieu + "")) {
//                SanPhamDTO sp = new SanPhamDAO().selectByPhienBan(ctp.getMaphienbansp() + "");
//                table.addCell(new PdfPCell(new Phrase(sp.getTensp(), fontNormal10)));
//                PhienBanSanPhamDTO pbsp = new PhienBanSanPhamDAO().selectById(ctp.getMaphienbansp());
//                table.addCell(new PdfPCell(new Phrase(romBus.getKichThuocById(pbsp.getRom()) + "GB - "
//                        + ramBus.getKichThuocById(pbsp.getRam()) + "GB - " + mausacBus.getTenMau(pbsp.getMausac()), fontNormal10)));
//                table.addCell(new PdfPCell(new Phrase(formatter.format(ctp.getDongia()) + "đ", fontNormal10)));
//                table.addCell(new PdfPCell(new Phrase(String.valueOf(ctp.getSoluong()), fontNormal10)));
//                table.addCell(new PdfPCell(new Phrase(formatter.format(ctp.getSoluong() * ctp.getDongia()) + "đ", fontNormal10)));
//            }
//
//            document.add(table);
//            document.add(Chunk.NEWLINE);
//
//            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thành tiền: " + formatter.format(px.getTongTien()) + "đ", fontBold15));
//            paraTongThanhToan.setIndentationLeft(300);
//
//            document.add(paraTongThanhToan);
//            document.add(Chunk.NEWLINE);
//            document.add(Chunk.NEWLINE);
//            Paragraph paragraph = new Paragraph();
//            paragraph.setIndentationLeft(22);
//            paragraph.add(new Chunk("Người lập phiếu", fontBoldItalic15));
//            paragraph.add(new Chunk(createWhiteSpace(30)));
//            paragraph.add(new Chunk("Người giao", fontBoldItalic15));
//            paragraph.add(new Chunk(createWhiteSpace(30)));
//            paragraph.add(new Chunk("Khách hàng", fontBoldItalic15));
//
//            Paragraph sign = new Paragraph();
//            sign.setIndentationLeft(20);
//            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
//            sign.add(new Chunk(createWhiteSpace(25)));
//            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
//            sign.add(new Chunk(createWhiteSpace(23)));
//            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
//            document.add(paragraph);
//            document.add(sign);
//            document.close();
//            writer.close();
//            openFile(url);
//
//        } catch (DocumentException | FileNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
//        }
//    }   

}
