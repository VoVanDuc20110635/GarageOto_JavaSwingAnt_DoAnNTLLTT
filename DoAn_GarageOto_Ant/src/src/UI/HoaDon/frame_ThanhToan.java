/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.HoaDon;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import src.Model.ChiNhanh;
import src.Model.ChiTietPhieuNhapHang;
import src.Model.HangHoa;
import src.Model.HoaDon;
import src.Model.HoaDonChiTiet;
import src.Model.KhachHang;
import src.Model.NhaCungCap;
import src.Model.NhanVien;
import src.Model.PhieuNhapHang;
import src.Model.TheKho;
import src.Service.ChiNhanhServive;
import src.Service.ChiTietPhieuNhapHangService;
import src.Service.HangHoaService;
import src.Service.HoaDonChiTietService;
import src.Service.HoaDonService;
import src.Service.MailSender;
import src.Service.PhieuNhapHangService;
import src.Service.TheKhoService;
import src.UI.HangHoa.Frame_ThemHangHoa;
import src.UI.HangHoa.Frame_taoDonNhapHang;
import src.UI.TrangChu;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_ThanhToan extends javax.swing.JFrame {
    private List<HoaDonChiTiet> danhSachHoaDonChiTiet;
    private List<ChiTietPhieuNhapHang> danhChiTietPhieuNhapHang;
    private KhachHang khachHang;
    private NhaCungCap nhaCungCap;
    private String maHoaDon;
    private String maPhieuNhapHang;
    private int tongSoLuong;
    private double tongTienHang;
    private Frame_taoDonNhapHang taoDonNhapHangInstance;
    private Util util = new Util();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
    private HoaDonService hoaDonService = new HoaDonService();
    private HangHoaService hangHoaService = new HangHoaService();
    private PhieuNhapHangService phieuNhapHangService = new PhieuNhapHangService();
    private ChiTietPhieuNhapHangService chiTietPhieuNhapHangService = new ChiTietPhieuNhapHangService();
    private ChiNhanhServive chiNhanhService = new ChiNhanhServive();
    private TheKhoService theKhoService = new TheKhoService();
    
    private TrangChu trangChuReference;
    
    private NhanVien nhanVienDangNhap;
    /**
     * Creates new form frame_ThanhToan
     */
    public Frame_ThanhToan() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Frame_ThanhToan(List<HoaDonChiTiet> danhSachHoaDonChiTiet, KhachHang khachHang, String maHoaDon, int tongSoLuong, double tongTienHang, TrangChu trangChu, NhanVien nhanVien) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.danhSachHoaDonChiTiet = danhSachHoaDonChiTiet;
        this.khachHang = khachHang;
        this.maHoaDon = maHoaDon;
        this.tongSoLuong = tongSoLuong;
        this.tongTienHang = tongTienHang;
        this.trangChuReference = trangChu;
        this.nhanVienDangNhap = nhanVien;
        System.out.println(this.trangChuReference);
        
        lbThanhToan_ma.setText("Mã khách hàng:");
        lbThanhToan_ten.setText("Tên khách hàng: ");
        lbThanhToan_canTra.setText("Khách cần trả: ");
        lbThanhToan_thanhToan.setText("Khách thanh toán: ");
        lbThanhToan_tienThua.setText("Tiền thừa trả khách");
        
        hienThiThongTin();
    }
    
    public Frame_ThanhToan(List<ChiTietPhieuNhapHang> danhSachChiTietPhieuNhapHang, NhaCungCap nhaCungCap, String maPhieuNhapHang, int tongSoLuong, double tongTienHang,  Frame_taoDonNhapHang taoDonNhapHangInstance, NhanVien nhanVien) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.danhChiTietPhieuNhapHang = danhSachChiTietPhieuNhapHang;
        this.nhaCungCap = nhaCungCap;
        this.maPhieuNhapHang = maPhieuNhapHang;
        this.tongSoLuong = tongSoLuong;
        this.tongTienHang = tongTienHang;
        this.taoDonNhapHangInstance = taoDonNhapHangInstance;
        this.nhanVienDangNhap = nhanVien;
        System.out.println(this.taoDonNhapHangInstance);
        
        lbThanhToan_ma.setText("Mã nhà cung cấp:");
        lbThanhToan_ten.setText("Tên nhà cung cấp: ");
        lbThanhToan_canTra.setText("Cần trả: ");
        lbThanhToan_thanhToan.setText("Tiền thanh toán: ");
        lbThanhToan_tienThua.setText("Tiền thừa: ");
        hienThiThongTin();
    }
    
    void hienThiThongTin(){
        if (maHoaDon != null && maPhieuNhapHang == null){
            String ngayGioHienTai = util.localDateParseMethod(LocalDateTime.now());
            lbThanhToan_ngay.setText(ngayGioHienTai);
            lbThanhToan_maHoaDon.setText(maHoaDon);
            lbThanhToan_maKhachHang.setText(khachHang.getMaKhachHang());
            lbThanhToan_tenKhachHang.setText(khachHang.getTenKhachHang());
            lbThanhToan_soDienThoai.setText(khachHang.getSoDienThoai());
            lbThanhToan_tongSoLuongHang.setText(String.valueOf( this.tongSoLuong));
            lbThanhToan_tongTienHang.setText(String.valueOf( this.tongTienHang));
            lbThanhToan_khachCanTra.setText(lbThanhToan_tongTienHang.getText());
            btnThanhToan_thanhToan.setVisible(false);
        }   
        
        if (maHoaDon == null && maPhieuNhapHang != null){
            String ngayGioHienTai = util.localDateParseMethod(LocalDateTime.now());
            lbThanhToan_ngay.setText(ngayGioHienTai);
            lbThanhToan_maHoaDon.setText(maPhieuNhapHang);
            lbThanhToan_maKhachHang.setText(nhaCungCap.getMaNhaCungCap());
            lbThanhToan_tenKhachHang.setText(nhaCungCap.getTenNhaCungCap());
            lbThanhToan_soDienThoai.setText(nhaCungCap.getSoDienThoai());
            lbThanhToan_tongSoLuongHang.setText(String.valueOf( this.tongSoLuong));
            lbThanhToan_tongTienHang.setText(String.valueOf( this.tongTienHang));
            lbThanhToan_khachCanTra.setText(lbThanhToan_tongTienHang.getText());
            btnThanhToan_thanhToan.setVisible(false);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel89 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        lbThanhToan_ngay = new javax.swing.JLabel();
        lbThanhToan_maHoaDon = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        lbThanhToan_tenNhanhVien = new javax.swing.JLabel();
        jPanel110 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        lbThanhToan_ma = new javax.swing.JLabel();
        lbThanhToan_maKhachHang = new javax.swing.JLabel();
        jPanel117 = new javax.swing.JPanel();
        lbThanhToan_tenKhachHang = new javax.swing.JLabel();
        lbThanhToan_ten = new javax.swing.JLabel();
        jPanel119 = new javax.swing.JPanel();
        lbThanhToan_soDienThoai = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        lbThanhToan_tongTienHang = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jPanel160 = new javax.swing.JPanel();
        lbThanhToan_tongSoLuongHang = new javax.swing.JLabel();
        jPanel121 = new javax.swing.JPanel();
        jLabel148 = new javax.swing.JLabel();
        tfThanhToan_giamGia = new javax.swing.JTextField();
        jPanel122 = new javax.swing.JPanel();
        lbThanhToan_khachCanTra = new javax.swing.JLabel();
        lbThanhToan_canTra = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        lbThanhToan_thanhToan = new javax.swing.JLabel();
        tfThanhToan_khachThanhToan = new javax.swing.JTextField();
        jPanel125 = new javax.swing.JPanel();
        tfThanhToan_tienThuaTraKhach = new javax.swing.JLabel();
        lbThanhToan_tienThua = new javax.swing.JLabel();
        btnThanhToan_thanhToan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel101.setBackground(new java.awt.Color(255, 255, 255));

        lbThanhToan_ngay.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbThanhToan_ngay.setForeground(new java.awt.Color(153, 153, 153));
        lbThanhToan_ngay.setText("10/05/2023");
        lbThanhToan_ngay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        lbThanhToan_maHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbThanhToan_maHoaDon.setForeground(new java.awt.Color(153, 153, 153));
        lbThanhToan_maHoaDon.setText("Mã hóa đơn");
        lbThanhToan_maHoaDon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel101Layout = new javax.swing.GroupLayout(jPanel101);
        jPanel101.setLayout(jPanel101Layout);
        jPanel101Layout.setHorizontalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhToan_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lbThanhToan_maHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel101Layout.setVerticalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addGroup(jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThanhToan_ngay)
                    .addComponent(lbThanhToan_maHoaDon))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, 30));

        jPanel109.setBackground(new java.awt.Color(255, 255, 255));
        jPanel109.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel76.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel76.setText("Nhân viên thanh toán:");

        lbThanhToan_tenNhanhVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_tenNhanhVien.setText("Hằng");

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addGap(18, 18, 18)
                .addComponent(lbThanhToan_tenNhanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addGroup(jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(lbThanhToan_tenNhanhVien))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 340, 30));

        jPanel110.setBackground(new java.awt.Color(255, 255, 255));
        jPanel110.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel111.setBackground(new java.awt.Color(255, 255, 255));

        lbThanhToan_ma.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_ma.setText("Mã khách hàng:");

        lbThanhToan_maKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbThanhToan_maKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbThanhToan_maKhachHang.setText("NAM 59 C1");

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhToan_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(lbThanhToan_maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel111Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThanhToan_ma)
                    .addComponent(lbThanhToan_maKhachHang))
                .addContainerGap())
        );

        jPanel110.add(jPanel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jPanel117.setBackground(new java.awt.Color(255, 255, 255));

        lbThanhToan_tenKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_tenKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbThanhToan_tenKhachHang.setText("Lê Văn Nam");

        lbThanhToan_ten.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_ten.setText("Tên khách hàng:");

        javax.swing.GroupLayout jPanel117Layout = new javax.swing.GroupLayout(jPanel117);
        jPanel117.setLayout(jPanel117Layout);
        jPanel117Layout.setHorizontalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhToan_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(lbThanhToan_tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel117Layout.setVerticalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel117Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThanhToan_tenKhachHang)
                    .addComponent(lbThanhToan_ten))
                .addContainerGap())
        );

        jPanel110.add(jPanel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 30));

        jPanel119.setBackground(new java.awt.Color(255, 255, 255));

        lbThanhToan_soDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_soDienThoai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbThanhToan_soDienThoai.setText("086017884");

        jLabel113.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel113.setText("Số điện thoại:");

        javax.swing.GroupLayout jPanel119Layout = new javax.swing.GroupLayout(jPanel119);
        jPanel119.setLayout(jPanel119Layout);
        jPanel119Layout.setHorizontalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lbThanhToan_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel119Layout.setVerticalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel119Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThanhToan_soDienThoai)
                    .addComponent(jLabel113))
                .addContainerGap())
        );

        jPanel110.add(jPanel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 30));

        jPanel118.setBackground(new java.awt.Color(255, 255, 255));

        lbThanhToan_tongTienHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_tongTienHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbThanhToan_tongTienHang.setText("600000");

        jLabel109.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel109.setText("Tổng tiền hàng");

        jPanel160.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbThanhToan_tongSoLuongHang.setBackground(new java.awt.Color(204, 204, 204));
        lbThanhToan_tongSoLuongHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_tongSoLuongHang.setText("2");
        jPanel160.add(lbThanhToan_tongSoLuongHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 20));

        javax.swing.GroupLayout jPanel118Layout = new javax.swing.GroupLayout(jPanel118);
        jPanel118.setLayout(jPanel118Layout);
        jPanel118Layout.setHorizontalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel109)
                .addGap(18, 18, 18)
                .addComponent(jPanel160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(lbThanhToan_tongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel118Layout.setVerticalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel118Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbThanhToan_tongTienHang)
                        .addComponent(jLabel109)))
                .addContainerGap())
        );

        jPanel110.add(jPanel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 30));

        jPanel121.setBackground(new java.awt.Color(255, 255, 255));

        jLabel148.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel148.setText("Giảm giá (%)");

        tfThanhToan_giamGia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfThanhToan_giamGia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfThanhToan_giamGia.setText("0");
        tfThanhToan_giamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfThanhToan_giamGia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfThanhToan_giamGiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfThanhToan_giamGiaFocusLost(evt);
            }
        });
        tfThanhToan_giamGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfThanhToan_giamGiaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel121Layout = new javax.swing.GroupLayout(jPanel121);
        jPanel121.setLayout(jPanel121Layout);
        jPanel121Layout.setHorizontalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel148)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(tfThanhToan_giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel121Layout.setVerticalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel121Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(tfThanhToan_giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel110.add(jPanel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, 40));

        jPanel122.setBackground(new java.awt.Color(255, 255, 255));

        lbThanhToan_khachCanTra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbThanhToan_khachCanTra.setForeground(new java.awt.Color(0, 102, 255));
        lbThanhToan_khachCanTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbThanhToan_khachCanTra.setText("0");

        lbThanhToan_canTra.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_canTra.setText("Khách cần trả");

        javax.swing.GroupLayout jPanel122Layout = new javax.swing.GroupLayout(jPanel122);
        jPanel122.setLayout(jPanel122Layout);
        jPanel122Layout.setHorizontalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel122Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhToan_canTra, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbThanhToan_khachCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel122Layout.setVerticalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel122Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThanhToan_khachCanTra)
                    .addComponent(lbThanhToan_canTra))
                .addContainerGap())
        );

        jPanel110.add(jPanel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, 30));

        jPanel120.setBackground(new java.awt.Color(255, 255, 255));

        lbThanhToan_thanhToan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_thanhToan.setText("Khách thanh toán");

        tfThanhToan_khachThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfThanhToan_khachThanhToan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfThanhToan_khachThanhToan.setText("0");
        tfThanhToan_khachThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfThanhToan_khachThanhToan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfThanhToan_khachThanhToanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfThanhToan_khachThanhToanFocusLost(evt);
            }
        });
        tfThanhToan_khachThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfThanhToan_khachThanhToanKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhToan_thanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(tfThanhToan_khachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel120Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThanhToan_thanhToan)
                    .addComponent(tfThanhToan_khachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel110.add(jPanel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, 30));

        jPanel125.setBackground(new java.awt.Color(255, 255, 255));
        jPanel125.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)));

        tfThanhToan_tienThuaTraKhach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfThanhToan_tienThuaTraKhach.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfThanhToan_tienThuaTraKhach.setText("0");

        lbThanhToan_tienThua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbThanhToan_tienThua.setText("Tiền thừa trả khách:");

        javax.swing.GroupLayout jPanel125Layout = new javax.swing.GroupLayout(jPanel125);
        jPanel125.setLayout(jPanel125Layout);
        jPanel125Layout.setHorizontalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbThanhToan_tienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(tfThanhToan_tienThuaTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel125Layout.setVerticalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel125Layout.createSequentialGroup()
                .addGroup(jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel125Layout.createSequentialGroup()
                        .addComponent(lbThanhToan_tienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel125Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfThanhToan_tienThuaTraKhach)))
                .addGap(54, 54, 54))
        );

        jPanel110.add(jPanel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 330, 30));

        jPanel89.add(jPanel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 340, 360));

        btnThanhToan_thanhToan.setBackground(new java.awt.Color(0, 102, 255));
        btnThanhToan_thanhToan.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnThanhToan_thanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan_thanhToan.setText("THANH TOÁN");
        btnThanhToan_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToan_thanhToanActionPerformed(evt);
            }
        });
        jPanel89.add(btnThanhToan_thanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfThanhToan_giamGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfThanhToan_giamGiaKeyReleased
        try{
            if (Double.parseDouble(tfThanhToan_giamGia.getText())< 0 || Double.parseDouble(tfThanhToan_giamGia.getText())> 100){
                double tienCanTra = this.tongTienHang;
                lbThanhToan_khachCanTra.setText(String.valueOf(tienCanTra));    
                return;
            }
            double tienCanTra = this.tongTienHang * (1- Double.parseDouble(tfThanhToan_giamGia.getText())/100);
            lbThanhToan_khachCanTra.setText(String.valueOf(tienCanTra));    
        } catch (Exception err){
            
        }
    }//GEN-LAST:event_tfThanhToan_giamGiaKeyReleased

    private void tfThanhToan_khachThanhToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfThanhToan_khachThanhToanKeyReleased
        try{
            double tienThanhToan = Double.parseDouble(tfThanhToan_khachThanhToan.getText());
            double tienCanTra = Double.parseDouble(lbThanhToan_khachCanTra.getText());
            tfThanhToan_tienThuaTraKhach.setText(String.valueOf(tienThanhToan - tienCanTra));
            if (tienThanhToan >= tienCanTra && Double.parseDouble(tfThanhToan_giamGia.getText()) > 0 && Double.parseDouble(tfThanhToan_giamGia.getText()) < 100 ){
                btnThanhToan_thanhToan.setVisible(true);
            } else {
                btnThanhToan_thanhToan.setVisible(false);
            }
        } catch (Exception err){
            
        }
    }//GEN-LAST:event_tfThanhToan_khachThanhToanKeyReleased

    private void btnThanhToan_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToan_thanhToanActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 6.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền tạo hóa đơn!");
                return;
            }
        if (this.maPhieuNhapHang == null && this.maHoaDon != null){
            try {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(this.maHoaDon);
                hoaDon.setGiamGia(Double.parseDouble(tfThanhToan_giamGia.getText()));
                hoaDon.setLoaiThuChi("Thu");
                hoaDon.setThoiGian(util.localDateParseMethodFromTableSwing(lbThanhToan_ngay.getText()));
                hoaDon.setTienDaTra(Double.parseDouble(tfThanhToan_khachThanhToan.getText()));
                hoaDon.setTongTien(tongTienHang);
                hoaDon.setTrangThai("Hoàn thành");
                hoaDon.setMaKhachHang(this.khachHang.getMaKhachHang());
                hoaDon.setMaNhanVien(this.nhanVienDangNhap.getMaNhanVien());
                ChiNhanh chiNhanh = chiNhanhService.hienThiChiNhanhTheoMaChiNhanh(this.nhanVienDangNhap.getMaChiNhanh());
                hoaDon.setMaChiNhanh(chiNhanh.getMaChiNhanh());
                try {
                    hoaDonService.themHoaDon(hoaDon);
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
                }
                int soLuongTheKho = theKhoService.demSoTheKho();
                for (HoaDonChiTiet hoaDonChiTiet: danhSachHoaDonChiTiet){
                    try {
                        hoaDonChiTietService.themHoaDonChiTiet(hoaDonChiTiet);
                        try {
                            TheKho theKho = new TheKho();
                            soLuongTheKho = soLuongTheKho +1;
                            theKho.setMaTheKho("TK0" + soLuongTheKho + hoaDonChiTiet.getMaHangHoa());
                            theKho.setGiaVon(hoaDonChiTiet.getGiaBan());
                            theKho.setPhuongThuc("Bán");
                            theKho.setSoLuong(hoaDonChiTiet.getSoLuong());
                            theKho.setThoiGian(LocalDateTime.now());
                            theKho.setMaHangHoa(hoaDonChiTiet.getMaHangHoa());
                            theKho.setMaNhanVien(nhanVienDangNhap.getMaNhanVien());
                            theKho.setMaKhachHang(this.khachHang.getMaKhachHang());
                            theKhoService.themTheKho(theKho);
                        } catch (SQLException ex) {
                            Logger.getLogger(Frame_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //                hangHoaService.updateSoLuongTonKhoHangHoa(hoaDonChiTiet.getMaHangHoa(), (-1)*hoaDonChiTiet.getSoLuong());
                    } catch (SQLException ex) {
                        Logger.getLogger(Frame_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
                double tienCanTra = Double.parseDouble(lbThanhToan_khachCanTra.getText());
                double tienKhachTra = Double.parseDouble(tfThanhToan_khachThanhToan.getText());
                double tienThua = Double.parseDouble(tfThanhToan_tienThuaTraKhach.getText());
                double giamGia = Double.parseDouble(tfThanhToan_giamGia.getText());
                String ngayGioHienTai = util.localDateParseMethod(LocalDateTime.now());
                
                
                trangChuReference.resetDanhSachHangHoaMain();
                trangChuReference.hienThiDanhSachHangHoaKhiDatHang();
                trangChuReference.removeAllRowTableDanhSachHangDaChon();
                
                Frame_HoaDon frame_hoaDon = new Frame_HoaDon(ngayGioHienTai, danhSachHoaDonChiTiet, khachHang, maHoaDon, tongSoLuong, tongTienHang, tienCanTra, tienKhachTra, tienThua, giamGia, hoaDon, this.nhanVienDangNhap);
                frame_hoaDon.setVisible(true);
                frame_hoaDon.setSize(460, 800);
                frame_hoaDon.setLocation(1070,0);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (this.maPhieuNhapHang != null && this.maHoaDon == null){
            PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
            phieuNhapHang.setPhieuNhapHang(this.maPhieuNhapHang);
            phieuNhapHang.setGiamGia(Double.parseDouble(tfThanhToan_giamGia.getText()));
            phieuNhapHang.setThoiGian(util.localDateParseMethodFromTableSwing(lbThanhToan_ngay.getText()));
            phieuNhapHang.setDaTra(Double.parseDouble(tfThanhToan_khachThanhToan.getText()));
            phieuNhapHang.setTong(tongTienHang);
            phieuNhapHang.setTrangThai("Chưa nhập hàng");
            phieuNhapHang.setMaNhaCungCap(this.nhaCungCap.getMaNhaCungCap());
            phieuNhapHang.setMaNhanVienTao("NV005");
            phieuNhapHang.setMaChiNhanh("CN001");
            try {
                phieuNhapHangService.themPhieuNhapHang(phieuNhapHang);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (ChiTietPhieuNhapHang chiTietPhieuNhapHang: danhChiTietPhieuNhapHang){
                try {
                    chiTietPhieuNhapHangService.themChiTietPhieuNhapHang(chiTietPhieuNhapHang);
                    int soLuongTheKho = theKhoService.demSoTheKho();
                    try {
                        TheKho theKho = new TheKho();
                        soLuongTheKho = soLuongTheKho +1;
                        theKho.setMaTheKho("TK0" + soLuongTheKho + chiTietPhieuNhapHang.getMaHangHoa());
                        theKho.setGiaVon(chiTietPhieuNhapHang.getGia_nhap()*(1 - chiTietPhieuNhapHang.getGiam_gia()));
                        theKho.setPhuongThuc("Nhập hàng");
                        theKho.setSoLuong(chiTietPhieuNhapHang.getSo_luong());
                        theKho.setThoiGian(LocalDateTime.now());
                        theKho.setMaHangHoa(chiTietPhieuNhapHang.getMaHangHoa());
                        theKho.setMaNhanVien(nhanVienDangNhap.getMaNhanVien());
                        theKho.setMaNhaCungCap(this.nhaCungCap.getMaNhaCungCap());
                        theKhoService.themTheKho(theKho);
                    } catch (SQLException ex) {
                        Logger.getLogger(Frame_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


            double tienCanTra = Double.parseDouble(lbThanhToan_khachCanTra.getText());
            double tienKhachTra = Double.parseDouble(tfThanhToan_khachThanhToan.getText());
            double tienThua = Double.parseDouble(tfThanhToan_tienThuaTraKhach.getText());
            double giamGia = Double.parseDouble(tfThanhToan_giamGia.getText());
            String ngayGioHienTai = util.localDateParseMethod(LocalDateTime.now());


//            taoDonNhapHangInstance.hienThiDanhSachHangHoaKhiDatHang();
//            
//            taoDonNhapHangInstance.removeAllRowTableDanhSachHangDaChon();

            Frame_HoaDon frame_hoaDon = new Frame_HoaDon(ngayGioHienTai, danhChiTietPhieuNhapHang, nhaCungCap, maPhieuNhapHang, tongSoLuong, tongTienHang, tienCanTra, tienKhachTra, tienThua, giamGia, phieuNhapHang);
            frame_hoaDon.setVisible(true);
            frame_hoaDon.setSize(460, 800);
            frame_hoaDon.setLocation(1070,0);
        }
        
    }//GEN-LAST:event_btnThanhToan_thanhToanActionPerformed

    private void tfThanhToan_giamGiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfThanhToan_giamGiaFocusGained
        if (tfThanhToan_giamGia.getText().equals("0")){
            tfThanhToan_giamGia.setText("");
        }
    }//GEN-LAST:event_tfThanhToan_giamGiaFocusGained

    private void tfThanhToan_giamGiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfThanhToan_giamGiaFocusLost
        if (tfThanhToan_giamGia.getText().equals("")){
            tfThanhToan_giamGia.setText("0");
            lbThanhToan_khachCanTra.setText(lbThanhToan_tongTienHang.getText());
        }
    }//GEN-LAST:event_tfThanhToan_giamGiaFocusLost

    private void tfThanhToan_khachThanhToanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfThanhToan_khachThanhToanFocusGained
        if (tfThanhToan_khachThanhToan.getText().equals("0")){
            tfThanhToan_khachThanhToan.setText("");
        }
    }//GEN-LAST:event_tfThanhToan_khachThanhToanFocusGained

    private void tfThanhToan_khachThanhToanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfThanhToan_khachThanhToanFocusLost
        if (tfThanhToan_khachThanhToan.getText().equals("")){
            tfThanhToan_khachThanhToan.setText("0");
        }
    }//GEN-LAST:event_tfThanhToan_khachThanhToanFocusLost

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
            java.util.logging.Logger.getLogger(Frame_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_ThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan_thanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel160;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JLabel lbThanhToan_canTra;
    private javax.swing.JLabel lbThanhToan_khachCanTra;
    private javax.swing.JLabel lbThanhToan_ma;
    private javax.swing.JLabel lbThanhToan_maHoaDon;
    private javax.swing.JLabel lbThanhToan_maKhachHang;
    private javax.swing.JLabel lbThanhToan_ngay;
    private javax.swing.JLabel lbThanhToan_soDienThoai;
    private javax.swing.JLabel lbThanhToan_ten;
    private javax.swing.JLabel lbThanhToan_tenKhachHang;
    private javax.swing.JLabel lbThanhToan_tenNhanhVien;
    private javax.swing.JLabel lbThanhToan_thanhToan;
    private javax.swing.JLabel lbThanhToan_tienThua;
    private javax.swing.JLabel lbThanhToan_tongSoLuongHang;
    private javax.swing.JLabel lbThanhToan_tongTienHang;
    private javax.swing.JTextField tfThanhToan_giamGia;
    private javax.swing.JTextField tfThanhToan_khachThanhToan;
    private javax.swing.JLabel tfThanhToan_tienThuaTraKhach;
    // End of variables declaration//GEN-END:variables
}
