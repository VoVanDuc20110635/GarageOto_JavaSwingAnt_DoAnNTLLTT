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
import src.Model.HoaDon;
import src.Model.HoaDonChiTiet;
import src.Model.KhachHang;
import src.Model.NhanVien;
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
