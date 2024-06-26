/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.HoaDon;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import src.Model.ChiTietPhieuNhapHang;
import src.Model.HoaDon;
import src.Model.HoaDonChiTiet;
import src.Model.KhachHang;
import src.Model.NhaCungCap;
import src.Model.NhanVien;
import src.Model.PhieuNhapHang;
import src.Service.HoaDonService;
import src.Service.MailSender;
import src.Service.PhieuNhapHangService;
import src.UI.TrangChu;
import src.Util.FullTextTableCellRenderer;
import src.Util.Util;
import src.Util.WritePDF;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_HoaDon extends javax.swing.JFrame {
    private List<HoaDonChiTiet> danhSachHoaDonChiTiet;
    private KhachHang khachHang;
    private HoaDon hoaDon;
    private String maHoaDon;
    
    private List<ChiTietPhieuNhapHang> danhSachChiTietPhieuNhapHang;
    private NhaCungCap nhaCungCap;
    private PhieuNhapHang phieuNhapHang;
    private String maPhieuNhapHang;
    
    private int tongSoLuong;
    private double tongTienHang;
    double tienCanTra;
    double tienKhachTra;
    double tienThua;
    double giamGia;
    String ngayHienTai;
    
    private NhanVien nhanVienDangNhap;
    
    private HoaDonService hoaDonService = new HoaDonService();
    private MailSender mailSender = new MailSender();
    private PhieuNhapHangService phieuNhapHangService = new PhieuNhapHangService();
    
    private Util util = new Util();
    /**
     * Creates new form frame_HoaDon
     */
    public Frame_HoaDon() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Frame_HoaDon(String ngayHienTai, List<HoaDonChiTiet> danhSachHoaDonChiTiet, KhachHang khachHang, String maHoaDon, int tongSoLuong, double tongTienHang, double tienCanTra, double tienKhachTra, double tienThua, double giamGia, HoaDon hoaDon, NhanVien nhanVien) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.danhSachHoaDonChiTiet = danhSachHoaDonChiTiet;
        this.khachHang = khachHang;
        this.maHoaDon = maHoaDon;
        this.tongSoLuong = tongSoLuong;
        this.tongTienHang = tongTienHang;
        this.tienCanTra = tienCanTra;
        this.tienKhachTra = tienKhachTra;
        this.tienThua = tienThua;
        this.ngayHienTai = ngayHienTai;
        this.giamGia = giamGia;
        this.hoaDon = hoaDon;
        this.nhanVienDangNhap = nhanVien;
        lbHoadon_maLable.setText("Mã khách hàng:");
        lbHoadon_tenLable.setText("Tên khách hàng: ");
        lbHoadon_canTraLable.setText("Khách cần trả: ");
        lbHoadon_thanhToanLable.setText("Khách thanh toán: ");
        lbHoadon_tienThuaLable.setText("Tiền thừa trả khách");
        hienThiHoaDon();
    }
    
    public Frame_HoaDon(String ngayHienTai, List<ChiTietPhieuNhapHang> danhSachChiTietPhieuNhapHang, NhaCungCap nhaCungCap, 
            String maPhieuNhapHang, int tongSoLuong, double tongTienHang, double tienCanTra, double tienKhachTra,
            double tienThua, double giamGia, PhieuNhapHang phieuNhapHang) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.danhSachChiTietPhieuNhapHang = danhSachChiTietPhieuNhapHang;
        this.nhaCungCap = nhaCungCap;
        this.maPhieuNhapHang = maPhieuNhapHang;
        this.tongSoLuong = tongSoLuong;
        this.tongTienHang = tongTienHang;
        this.tienCanTra = tienCanTra;
        this.tienKhachTra = tienKhachTra;
        this.tienThua = tienThua;
        this.ngayHienTai = ngayHienTai;
        this.giamGia = giamGia;
        this.phieuNhapHang = phieuNhapHang;
        lbHoadon_maLable.setText("Mã nhà cung cấp:");
        lbHoadon_tenLable.setText("Tên nhà cung cấp: ");
        lbHoadon_canTraLable.setText("Cần trả: ");
        lbHoadon_thanhToanLable.setText("Thanh toán: ");
        lbHoadon_tienThuaLable.setText("Tiền thừa: ");
        hienThiHoaDon();
    }
    
    private void hienThiHoaDon(){
        if (maHoaDon != null && maPhieuNhapHang == null){
            lbHoaDon_giamGia.setText(String.valueOf(this.giamGia));
            lbHoaDon_khachCanTra.setText(String.valueOf(this.tienCanTra));
            lbHoaDon_khachThanhToan.setText(String.valueOf(this.tienKhachTra));
            lbHoaDon_maHoaDon.setText(String.valueOf(this.maHoaDon));
            lbHoaDon_maKhachHang.setText(String.valueOf(this.khachHang.getMaKhachHang()));
            lbHoaDon_ngay.setText(String.valueOf(this.ngayHienTai));
            lbHoaDon_soDienThoai.setText(String.valueOf(this.khachHang.getSoDienThoai()));
            lbHoaDon_soLuong.setText(String.valueOf(this.tongSoLuong));
            lbHoaDon_tenKhachHang.setText(String.valueOf(this.khachHang.getTenKhachHang()));
            lbHoaDon_tienThua.setText(String.valueOf(this.tienThua));
            lbHoaDon_tongTienHang.setText(String.valueOf(this.tongTienHang));
            hienThiDanhSachChiTietHoaDon();
        } 
        
        if (maHoaDon == null && maPhieuNhapHang != null){
            lbHoaDon_giamGia.setText(String.valueOf(this.giamGia));
            lbHoaDon_khachCanTra.setText(String.valueOf(this.tienCanTra));
            lbHoaDon_khachThanhToan.setText(String.valueOf(this.tienKhachTra));
            lbHoaDon_maHoaDon.setText(String.valueOf(this.maPhieuNhapHang));
            lbHoaDon_maKhachHang.setText(String.valueOf(this.nhaCungCap.getMaNhaCungCap()));
            lbHoaDon_ngay.setText(String.valueOf(this.ngayHienTai));
            lbHoaDon_soDienThoai.setText(String.valueOf(this.nhaCungCap.getSoDienThoai()));
            lbHoaDon_soLuong.setText(String.valueOf(this.tongSoLuong));
            lbHoaDon_tenKhachHang.setText(String.valueOf(this.nhaCungCap.getTenNhaCungCap()));
            lbHoaDon_tienThua.setText(String.valueOf(this.tienThua));
            lbHoaDon_tongTienHang.setText(String.valueOf(this.tongTienHang));
            hienThiDanhSachChiTietPhieuNhapHang();
        } 
        
        
    }
    
    void hienThiDanhSachChiTietHoaDon(){
        tbHoaDon_danhSachChiTietHoaDon.getColumnModel().getColumn(1).setCellRenderer(new FullTextTableCellRenderer());
        DefaultTableModel recordTable = (DefaultTableModel)tbHoaDon_danhSachChiTietHoaDon.getModel();
        recordTable.setRowCount(0);
        for (HoaDonChiTiet hoaDonChiTiet : danhSachHoaDonChiTiet) {
            Vector columnData = new Vector();
            columnData.add(hoaDonChiTiet.getMaHangHoa());
            columnData.add(hoaDonChiTiet.getTenHangHoa());
            columnData.add(hoaDonChiTiet.getGiaBan());
            columnData.add(hoaDonChiTiet.getSoLuong());
            columnData.add(hoaDonChiTiet.getGiamGia());
            recordTable.addRow(columnData);
        }
    }
    
     void hienThiDanhSachChiTietPhieuNhapHang(){
        tbHoaDon_danhSachChiTietHoaDon.getColumnModel().getColumn(1).setCellRenderer(new FullTextTableCellRenderer());
        DefaultTableModel recordTable = (DefaultTableModel)tbHoaDon_danhSachChiTietHoaDon.getModel();
        recordTable.setRowCount(0);
        for (ChiTietPhieuNhapHang chiTietPhieuNhapHang : danhSachChiTietPhieuNhapHang) {
            Vector columnData = new Vector();
            columnData.add(chiTietPhieuNhapHang.getMaHangHoa());
            columnData.add(chiTietPhieuNhapHang.getTenHangHoa());
            columnData.add(chiTietPhieuNhapHang.getGia_nhap());
            columnData.add(chiTietPhieuNhapHang.getSo_luong());
            columnData.add(chiTietPhieuNhapHang.getGiam_gia());
            recordTable.addRow(columnData);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel174 = new javax.swing.JPanel();
        jPanel175 = new javax.swing.JPanel();
        lbHoaDon_ngay = new javax.swing.JLabel();
        lbHoaDon_maHoaDon = new javax.swing.JLabel();
        jPanel176 = new javax.swing.JPanel();
        jLabel233 = new javax.swing.JLabel();
        lbHoaDon_tenNhanVien = new javax.swing.JLabel();
        jPanel177 = new javax.swing.JPanel();
        jPanel200 = new javax.swing.JPanel();
        lbHoadon_maLable = new javax.swing.JLabel();
        lbHoaDon_maKhachHang = new javax.swing.JLabel();
        jPanel217 = new javax.swing.JPanel();
        lbHoaDon_tenKhachHang = new javax.swing.JLabel();
        lbHoadon_tenLable = new javax.swing.JLabel();
        jPanel218 = new javax.swing.JPanel();
        lbHoaDon_soDienThoai = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jPanel219 = new javax.swing.JPanel();
        lbHoaDon_tongTienHang = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        lbHoaDon_soLuong = new javax.swing.JLabel();
        jPanel220 = new javax.swing.JPanel();
        lbHoaDon_giamGia = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        jPanel221 = new javax.swing.JPanel();
        lbHoaDon_khachCanTra = new javax.swing.JLabel();
        lbHoadon_canTraLable = new javax.swing.JLabel();
        jPanel222 = new javax.swing.JPanel();
        lbHoaDon_khachThanhToan = new javax.swing.JLabel();
        lbHoadon_thanhToanLable = new javax.swing.JLabel();
        jPanel223 = new javax.swing.JPanel();
        lbHoaDon_tienThua = new javax.swing.JLabel();
        lbHoadon_tienThuaLable = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbHoaDon_danhSachChiTietHoaDon = new javax.swing.JTable();
        jLabel254 = new javax.swing.JLabel();
        btnHoaDon_in = new javax.swing.JButton();
        btnHoaDon_guiMail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane7.setToolTipText("");
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane7.setViewportBorder(new javax.swing.border.MatteBorder(null));

        jPanel174.setBackground(new java.awt.Color(255, 255, 255));
        jPanel174.setPreferredSize(new java.awt.Dimension(350, 756));
        jPanel174.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel175.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDon_ngay.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDon_ngay.setForeground(new java.awt.Color(153, 153, 153));
        lbHoaDon_ngay.setText("10/05/2023");
        lbHoaDon_ngay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        lbHoaDon_maHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDon_maHoaDon.setForeground(new java.awt.Color(153, 153, 153));
        lbHoaDon_maHoaDon.setText("Mã hóa đơn");
        lbHoaDon_maHoaDon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel175Layout = new javax.swing.GroupLayout(jPanel175);
        jPanel175.setLayout(jPanel175Layout);
        jPanel175Layout.setHorizontalGroup(
            jPanel175Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel175Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoaDon_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(lbHoaDon_maHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel175Layout.setVerticalGroup(
            jPanel175Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel175Layout.createSequentialGroup()
                .addGroup(jPanel175Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDon_ngay)
                    .addComponent(lbHoaDon_maHoaDon))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel174.add(jPanel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 400, 30));

        jPanel176.setBackground(new java.awt.Color(255, 255, 255));
        jPanel176.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel233.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel233.setText("Nhân viên thanh toán:");

        lbHoaDon_tenNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDon_tenNhanVien.setText("Hằng");

        javax.swing.GroupLayout jPanel176Layout = new javax.swing.GroupLayout(jPanel176);
        jPanel176.setLayout(jPanel176Layout);
        jPanel176Layout.setHorizontalGroup(
            jPanel176Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel176Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel233)
                .addGap(18, 18, 18)
                .addComponent(lbHoaDon_tenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel176Layout.setVerticalGroup(
            jPanel176Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel176Layout.createSequentialGroup()
                .addGroup(jPanel176Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel233)
                    .addComponent(lbHoaDon_tenNhanVien))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel174.add(jPanel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 400, 30));

        jPanel177.setBackground(new java.awt.Color(255, 255, 255));
        jPanel177.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel200.setBackground(new java.awt.Color(255, 255, 255));

        lbHoadon_maLable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoadon_maLable.setText("Mã khách hàng:");

        lbHoaDon_maKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDon_maKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDon_maKhachHang.setText("NAM 59 C1");

        javax.swing.GroupLayout jPanel200Layout = new javax.swing.GroupLayout(jPanel200);
        jPanel200.setLayout(jPanel200Layout);
        jPanel200Layout.setHorizontalGroup(
            jPanel200Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel200Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoadon_maLable, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(lbHoaDon_maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel200Layout.setVerticalGroup(
            jPanel200Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel200Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel200Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoadon_maLable)
                    .addComponent(lbHoaDon_maKhachHang))
                .addContainerGap())
        );

        jPanel177.add(jPanel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        jPanel217.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDon_tenKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDon_tenKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDon_tenKhachHang.setText("Lê Văn Nam");

        lbHoadon_tenLable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoadon_tenLable.setText("Tên khách hàng:");

        javax.swing.GroupLayout jPanel217Layout = new javax.swing.GroupLayout(jPanel217);
        jPanel217.setLayout(jPanel217Layout);
        jPanel217Layout.setHorizontalGroup(
            jPanel217Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel217Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoadon_tenLable, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(lbHoaDon_tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel217Layout.setVerticalGroup(
            jPanel217Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel217Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel217Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDon_tenKhachHang)
                    .addComponent(lbHoadon_tenLable))
                .addContainerGap())
        );

        jPanel177.add(jPanel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 30));

        jPanel218.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDon_soDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDon_soDienThoai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDon_soDienThoai.setText("086017884");

        jLabel240.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel240.setText("Số điện thoại:");

        javax.swing.GroupLayout jPanel218Layout = new javax.swing.GroupLayout(jPanel218);
        jPanel218.setLayout(jPanel218Layout);
        jPanel218Layout.setHorizontalGroup(
            jPanel218Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel218Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel240)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(lbHoaDon_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel218Layout.setVerticalGroup(
            jPanel218Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel218Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel218Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDon_soDienThoai)
                    .addComponent(jLabel240))
                .addContainerGap())
        );

        jPanel177.add(jPanel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 400, 30));

        jPanel219.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDon_tongTienHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDon_tongTienHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDon_tongTienHang.setText("0");

        jLabel242.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel242.setText("Tổng tiền hàng");

        lbHoaDon_soLuong.setBackground(new java.awt.Color(204, 204, 204));
        lbHoaDon_soLuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDon_soLuong.setText("0");

        javax.swing.GroupLayout jPanel219Layout = new javax.swing.GroupLayout(jPanel219);
        jPanel219.setLayout(jPanel219Layout);
        jPanel219Layout.setHorizontalGroup(
            jPanel219Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel219Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel242)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lbHoaDon_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbHoaDon_tongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel219Layout.setVerticalGroup(
            jPanel219Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel219Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel219Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDon_tongTienHang)
                    .addComponent(jLabel242)
                    .addComponent(lbHoaDon_soLuong))
                .addContainerGap())
        );

        jPanel177.add(jPanel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, 30));

        jPanel220.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDon_giamGia.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDon_giamGia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDon_giamGia.setText("0");
        lbHoaDon_giamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel245.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel245.setText("Giảm giá (%)");

        javax.swing.GroupLayout jPanel220Layout = new javax.swing.GroupLayout(jPanel220);
        jPanel220.setLayout(jPanel220Layout);
        jPanel220Layout.setHorizontalGroup(
            jPanel220Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel220Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel245)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(lbHoaDon_giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel220Layout.setVerticalGroup(
            jPanel220Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel220Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel220Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDon_giamGia)
                    .addComponent(jLabel245))
                .addContainerGap())
        );

        jPanel177.add(jPanel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, 30));

        jPanel221.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDon_khachCanTra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDon_khachCanTra.setForeground(new java.awt.Color(0, 102, 255));
        lbHoaDon_khachCanTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDon_khachCanTra.setText("0");

        lbHoadon_canTraLable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoadon_canTraLable.setText("Khách cần trả");

        javax.swing.GroupLayout jPanel221Layout = new javax.swing.GroupLayout(jPanel221);
        jPanel221.setLayout(jPanel221Layout);
        jPanel221Layout.setHorizontalGroup(
            jPanel221Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel221Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoadon_canTraLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(lbHoaDon_khachCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel221Layout.setVerticalGroup(
            jPanel221Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel221Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel221Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDon_khachCanTra)
                    .addComponent(lbHoadon_canTraLable))
                .addContainerGap())
        );

        jPanel177.add(jPanel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, -1, 30));

        jPanel222.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDon_khachThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDon_khachThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDon_khachThanhToan.setText("0");
        lbHoaDon_khachThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        lbHoadon_thanhToanLable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoadon_thanhToanLable.setText("Khách thanh toán");

        javax.swing.GroupLayout jPanel222Layout = new javax.swing.GroupLayout(jPanel222);
        jPanel222.setLayout(jPanel222Layout);
        jPanel222Layout.setHorizontalGroup(
            jPanel222Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel222Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoadon_thanhToanLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(lbHoaDon_khachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel222Layout.setVerticalGroup(
            jPanel222Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel222Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel222Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDon_khachThanhToan)
                    .addComponent(lbHoadon_thanhToanLable))
                .addContainerGap())
        );

        jPanel177.add(jPanel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, -1, 30));

        jPanel223.setBackground(new java.awt.Color(255, 255, 255));
        jPanel223.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)));

        lbHoaDon_tienThua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDon_tienThua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDon_tienThua.setText("0");

        lbHoadon_tienThuaLable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoadon_tienThuaLable.setText("Tiền thừa trả khách");

        javax.swing.GroupLayout jPanel223Layout = new javax.swing.GroupLayout(jPanel223);
        jPanel223.setLayout(jPanel223Layout);
        jPanel223Layout.setHorizontalGroup(
            jPanel223Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel223Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoadon_tienThuaLable, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(lbHoaDon_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel223Layout.setVerticalGroup(
            jPanel223Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel223Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel223Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDon_tienThua)
                    .addComponent(lbHoadon_tienThuaLable))
                .addGap(54, 54, 54))
        );

        jPanel177.add(jPanel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 400, 30));

        tbHoaDon_danhSachChiTietHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbHoaDon_danhSachChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng", "Tên hàng", "Đơn giá", "Số lượng", "Giảm giá"
            }
        ));
        tbHoaDon_danhSachChiTietHoaDon.setRowHeight(35);
        tbHoaDon_danhSachChiTietHoaDon.setShowGrid(false);
        jScrollPane8.setViewportView(tbHoaDon_danhSachChiTietHoaDon);

        jPanel177.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 400, 290));

        jPanel174.add(jPanel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 400, 600));

        jLabel254.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel254.setText("Cảm ơn và hẹn gặp lại!");
        jPanel174.add(jLabel254, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 670, 170, 30));

        btnHoaDon_in.setBackground(new java.awt.Color(153, 153, 153));
        btnHoaDon_in.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDon_in.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDon_in.setText("IN");
        btnHoaDon_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDon_inActionPerformed(evt);
            }
        });
        jPanel174.add(btnHoaDon_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 710, 60, 30));

        btnHoaDon_guiMail.setBackground(new java.awt.Color(0, 51, 255));
        btnHoaDon_guiMail.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDon_guiMail.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDon_guiMail.setText("GỬI MAIL");
        btnHoaDon_guiMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDon_guiMailActionPerformed(evt);
            }
        });
        jPanel174.add(btnHoaDon_guiMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 710, 120, 30));

        jScrollPane7.setViewportView(jPanel174);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHoaDon_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDon_inActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 6.5 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền in hóa đơn!");
                return;
            }
        WritePDF writePDF = new WritePDF();
        if (lbHoadon_tenLable.getText().toString().contains("khách")){
            HoaDon hoaDon = new HoaDon();
            try {
                hoaDon = hoaDonService.hienThiHoaDonTheoMaHoadon(this.maHoaDon);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            writePDF.writeHoaDon(hoaDon, danhSachHoaDonChiTiet, khachHang);
        } else {
            PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
            try {
                phieuNhapHang = phieuNhapHangService.layPhieuNhapHangDuaTrenMaPhieuNhapHang(this.maPhieuNhapHang);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            writePDF.writePhieuNhapHang(phieuNhapHang, danhSachChiTietPhieuNhapHang, nhaCungCap);
        }
        
        
    }//GEN-LAST:event_btnHoaDon_inActionPerformed

    private void btnHoaDon_guiMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDon_guiMailActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 6.6 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền gửi hóa đơn qua Email!");
                return;
            }
        if (lbHoadon_tenLable.getText().toString().contains("khách")){
            String to = "2k2lmhtlol@gmail.com";

            // Sender's email ID needs to be mentioned
            String from = "voduc0100@gmail.com";

            // Assuming you are sending email from localhost
            String host = "smtp.gmail.com";

            // Subject
            String subject = "This is the Subject Line!";

            mailSender.sendEmail(to, from, host, subject, hoaDon, danhSachHoaDonChiTiet);
        } else {
            String to = "2k2lmhtlol@gmail.com";

            // Sender's email ID needs to be mentioned
            String from = "voduc0100@gmail.com";

            // Assuming you are sending email from localhost
            String host = "smtp.gmail.com";

            // Subject
            String subject = "This is the Subject Line!";

            mailSender.sendEmailPhieuNhapHang(to, from, host, subject, phieuNhapHang,danhSachChiTietPhieuNhapHang);
        } 
        JOptionPane.showMessageDialog(this, "Gửi mail thành công!");
        
    }//GEN-LAST:event_btnHoaDon_guiMailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_HoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoaDon_guiMail;
    private javax.swing.JButton btnHoaDon_in;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JPanel jPanel174;
    private javax.swing.JPanel jPanel175;
    private javax.swing.JPanel jPanel176;
    private javax.swing.JPanel jPanel177;
    private javax.swing.JPanel jPanel200;
    private javax.swing.JPanel jPanel217;
    private javax.swing.JPanel jPanel218;
    private javax.swing.JPanel jPanel219;
    private javax.swing.JPanel jPanel220;
    private javax.swing.JPanel jPanel221;
    private javax.swing.JPanel jPanel222;
    private javax.swing.JPanel jPanel223;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbHoaDon_giamGia;
    private javax.swing.JLabel lbHoaDon_khachCanTra;
    private javax.swing.JLabel lbHoaDon_khachThanhToan;
    private javax.swing.JLabel lbHoaDon_maHoaDon;
    private javax.swing.JLabel lbHoaDon_maKhachHang;
    private javax.swing.JLabel lbHoaDon_ngay;
    private javax.swing.JLabel lbHoaDon_soDienThoai;
    private javax.swing.JLabel lbHoaDon_soLuong;
    private javax.swing.JLabel lbHoaDon_tenKhachHang;
    private javax.swing.JLabel lbHoaDon_tenNhanVien;
    private javax.swing.JLabel lbHoaDon_tienThua;
    private javax.swing.JLabel lbHoaDon_tongTienHang;
    private javax.swing.JLabel lbHoadon_canTraLable;
    private javax.swing.JLabel lbHoadon_maLable;
    private javax.swing.JLabel lbHoadon_tenLable;
    private javax.swing.JLabel lbHoadon_thanhToanLable;
    private javax.swing.JLabel lbHoadon_tienThuaLable;
    private javax.swing.JTable tbHoaDon_danhSachChiTietHoaDon;
    // End of variables declaration//GEN-END:variables
}
