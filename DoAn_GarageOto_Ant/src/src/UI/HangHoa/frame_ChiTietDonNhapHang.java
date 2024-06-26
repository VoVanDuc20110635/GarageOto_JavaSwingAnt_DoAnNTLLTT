/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.HangHoa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import src.Model.ChiTietPhieuNhapHang;
import src.Model.NhaCungCap;
import src.Model.NhanVien;
import src.Model.PhieuNhapHang;
import src.Service.ChiTietPhieuNhapHangService;
import src.Service.NhaCungCapService;
import src.Service.PhieuNhapHangService;
import src.UI.HoaDon.Frame_TienThanhToanTraHang;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class frame_ChiTietDonNhapHang extends javax.swing.JFrame {
    private ChiTietPhieuNhapHangService chiTietPhieuNhapHangService = new ChiTietPhieuNhapHangService();
    private NhaCungCapService nhaCungCapService = new NhaCungCapService();
    private PhieuNhapHangService phieuNhapHangService = new PhieuNhapHangService();
    private PhieuNhapHang phieuNhapHang;
    private Util util = new Util();
    int soLuongSanPhamTra = 0;
    double donGiaSanPhamTra = 0;
    private NhanVien nhanVienDangNhap;
    public PhieuNhapHang getPhieuNhapHang() {
        return phieuNhapHang;
    }

    public void setPhieuNhapHang(PhieuNhapHang phieuNhapHang) {
        this.phieuNhapHang = phieuNhapHang;
    }
    
    /**
     * Creates new form frame_HoaDonChiTiet
     */
    public frame_ChiTietDonNhapHang() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        hienThiThongTinPhieuNhapHang();
        try {
            hienThiDanhSachChiTietPhieuNhapHangTheoMaPhieuNhapHang(this.phieuNhapHang.getPhieuNhapHang());
            
        } catch (SQLException ex) {
            Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.phieuNhapHang.getTrangThai().equals("Chưa nhập hàng")){
            btnChiTietDonNhapHang_capNhat_TraHang.setText("Cập nhật");
            panelChiTietDonNhapHang_maHang.setVisible(false);
            panelChiTietDonNhapHang_soLuong.setVisible(false);
            panelChiTietDonNhapHang_tenHang.setVisible(false);
            tbChiTietDonNhapHang_traHang.setVisible(false);
            btnChiTietDonNhapHang_hoanTac.setVisible(false);
        } else if (this.phieuNhapHang.getTrangThai().equals("Đã nhập hàng")){
            btnChiTietDonNhapHang_capNhat_TraHang.setText("Trả hàng");
            tb_chiTietDonNhapHang.setEnabled(false);
        } else {
            btnChiTietDonNhapHang_capNhat_TraHang.setVisible(false);
            tb_chiTietDonNhapHang.setEnabled(false);
        }
        getContentPane().setBackground(Color.WHITE);
    }

    public frame_ChiTietDonNhapHang(PhieuNhapHang phieuNhapHang, NhanVien nhanVienDangNhap) {
        this.phieuNhapHang = phieuNhapHang;
        this.nhanVienDangNhap = nhanVienDangNhap;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hienThiThongTinPhieuNhapHang();
        try {
            hienThiDanhSachChiTietPhieuNhapHangTheoMaPhieuNhapHang(this.phieuNhapHang.getPhieuNhapHang());
        } catch (SQLException ex) {
            Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.phieuNhapHang.getTrangThai().equals("Chưa nhập hàng")){
            btnChiTietDonNhapHang_capNhat_TraHang.setText("Cập nhật");
        } else if (this.phieuNhapHang.getTrangThai().equals("Đã nhập hàng")){
            btnChiTietDonNhapHang_capNhat_TraHang.setText("Trả hàng");
        } else {
            btnChiTietDonNhapHang_capNhat_TraHang.setVisible(false);
            tb_chiTietDonNhapHang.setEnabled(false);
        }
        panelChiTietDonNhapHang_maHang.setVisible(false);
        panelChiTietDonNhapHang_soLuong.setVisible(false);
        panelChiTietDonNhapHang_tenHang.setVisible(false);
        tbChiTietDonNhapHang_traHang.setVisible(false);
        btnChiTietDonNhapHang_hoanTac.setVisible(false);
        btnChiTietDonNhapHang_traSanPham.setVisible(false);
        btnChiTietDonNhapHang_luuTraHang.setVisible(false);
        tfChiTietDonNhapHang_tenHang.setEnabled(false);
        getContentPane().setBackground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_huyBo = new javax.swing.JButton();
        btnChiTietDonNhapHang_capNhat_TraHang = new javax.swing.JButton();
        btn_in = new javax.swing.JButton();
        panel_ChiTietDonNhapHang = new javax.swing.JPanel();
        jPanel241 = new javax.swing.JPanel();
        jLabel287 = new javax.swing.JLabel();
        lb_maNhapHang = new javax.swing.JLabel();
        jPanel243 = new javax.swing.JPanel();
        jLabel291 = new javax.swing.JLabel();
        lb_tenNguoiTao = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tb_chiTietDonNhapHang = new javax.swing.JTable();
        jPanel246 = new javax.swing.JPanel();
        jLabel297 = new javax.swing.JLabel();
        lb_tenChiNhanh = new javax.swing.JLabel();
        jPanel248 = new javax.swing.JPanel();
        jLabel301 = new javax.swing.JLabel();
        lb_thoiGian = new javax.swing.JLabel();
        jPanel249 = new javax.swing.JPanel();
        jLabel303 = new javax.swing.JLabel();
        cb_trangThai = new javax.swing.JComboBox<>();
        jPanel251 = new javax.swing.JPanel();
        jLabel307 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tare_ghiChu = new javax.swing.JTextArea();
        jLabel296 = new javax.swing.JLabel();
        jPanel245 = new javax.swing.JPanel();
        jLabel295 = new javax.swing.JLabel();
        cb_nhaCungCap = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        panelChiTietDonNhapHang_maHang = new javax.swing.JPanel();
        lbHoaDonChiTiet_doiTac3 = new javax.swing.JLabel();
        lbChiTietDonNhapHang_maHang = new javax.swing.JLabel();
        panelChiTietDonNhapHang_tenHang = new javax.swing.JPanel();
        lbHoaDonChiTiet_doiTac4 = new javax.swing.JLabel();
        tfChiTietDonNhapHang_tenHang = new javax.swing.JTextField();
        panelChiTietDonNhapHang_soLuong = new javax.swing.JPanel();
        lbHoaDonChiTiet_doiTac2 = new javax.swing.JLabel();
        tfChiTietDonNhapHang_soLuong = new javax.swing.JTextField();
        btnChiTietDonNhapHang_traSanPham = new javax.swing.JButton();
        btnChiTietDonNhapHang_hoanTac = new javax.swing.JButton();
        lbChiTietDonNhapHang_error = new javax.swing.JLabel();
        checkBoxChiTietDonNhapHang_sanPhamLoi = new javax.swing.JCheckBox();
        jPanel250 = new javax.swing.JPanel();
        jLabel305 = new javax.swing.JLabel();
        lb_tongSoLuong = new javax.swing.JLabel();
        jPanel242 = new javax.swing.JPanel();
        jLabel289 = new javax.swing.JLabel();
        lb_tongTienHang = new javax.swing.JLabel();
        jPanel244 = new javax.swing.JPanel();
        jLabel293 = new javax.swing.JLabel();
        lb_tienDaTra = new javax.swing.JLabel();
        jPanel247 = new javax.swing.JPanel();
        jLabel299 = new javax.swing.JLabel();
        lb_noNhaCungCap = new javax.swing.JLabel();
        jPanel252 = new javax.swing.JPanel();
        jLabel304 = new javax.swing.JLabel();
        lb_nhaCungCapNo = new javax.swing.JLabel();
        scrollPaneHoaDonChiTiet_traHang = new javax.swing.JScrollPane();
        tbChiTietDonNhapHang_traHang = new javax.swing.JTable();
        btnChiTietDonNhapHang_luuTraHang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_huyBo.setBackground(new java.awt.Color(255, 51, 51));
        btn_huyBo.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_huyBo.setForeground(new java.awt.Color(255, 255, 255));
        btn_huyBo.setText("Hủy bỏ");
        btn_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyBoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_huyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 640, -1, -1));

        btnChiTietDonNhapHang_capNhat_TraHang.setBackground(new java.awt.Color(0, 51, 255));
        btnChiTietDonNhapHang_capNhat_TraHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietDonNhapHang_capNhat_TraHang.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietDonNhapHang_capNhat_TraHang.setText("Cập nhật");
        btnChiTietDonNhapHang_capNhat_TraHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietDonNhapHang_capNhat_TraHangActionPerformed(evt);
            }
        });
        jPanel1.add(btnChiTietDonNhapHang_capNhat_TraHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 640, -1, -1));

        btn_in.setBackground(new java.awt.Color(255, 153, 153));
        btn_in.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_in.setForeground(new java.awt.Color(255, 255, 255));
        btn_in.setText("In");
        btn_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inActionPerformed(evt);
            }
        });
        jPanel1.add(btn_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 640, -1, -1));

        panel_ChiTietDonNhapHang.setBackground(new java.awt.Color(255, 255, 255));
        panel_ChiTietDonNhapHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel241.setBackground(new java.awt.Color(255, 255, 255));

        jLabel287.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel287.setText("Mã nhập hàng:");

        lb_maNhapHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_maNhapHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_maNhapHang.setText("lb_maNhapHang");

        javax.swing.GroupLayout jPanel241Layout = new javax.swing.GroupLayout(jPanel241);
        jPanel241.setLayout(jPanel241Layout);
        jPanel241Layout.setHorizontalGroup(
            jPanel241Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel241Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel287)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_maNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel241Layout.setVerticalGroup(
            jPanel241Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel241Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel241Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel287)
                    .addComponent(lb_maNhapHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_ChiTietDonNhapHang.add(jPanel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 256, -1));

        jPanel243.setBackground(new java.awt.Color(255, 255, 255));
        jPanel243.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel291.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel291.setText("Người tạo:");

        lb_tenNguoiTao.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lb_tenNguoiTao.setText("A");

        javax.swing.GroupLayout jPanel243Layout = new javax.swing.GroupLayout(jPanel243);
        jPanel243.setLayout(jPanel243Layout);
        jPanel243Layout.setHorizontalGroup(
            jPanel243Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel243Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel291)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(lb_tenNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel243Layout.setVerticalGroup(
            jPanel243Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel243Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel243Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel291)
                    .addComponent(lb_tenNguoiTao))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panel_ChiTietDonNhapHang.add(jPanel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 260, -1));

        tb_chiTietDonNhapHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_chiTietDonNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã chi tiết", "Mã hàng", "Tên hàng", "Số lượng", "Giá nhập", "Tổng", "Giảm giá", "Thành tiền"
            }
        ));
        tb_chiTietDonNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chiTietDonNhapHangMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tb_chiTietDonNhapHang);

        panel_ChiTietDonNhapHang.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 960, 262));

        jPanel246.setBackground(new java.awt.Color(255, 255, 255));

        jLabel297.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel297.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel297.setText("Chi nhánh:");

        lb_tenChiNhanh.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lb_tenChiNhanh.setText("Chi nhánh trung tâm");

        javax.swing.GroupLayout jPanel246Layout = new javax.swing.GroupLayout(jPanel246);
        jPanel246.setLayout(jPanel246Layout);
        jPanel246Layout.setHorizontalGroup(
            jPanel246Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel246Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel297)
                .addGap(62, 62, 62)
                .addComponent(lb_tenChiNhanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel246Layout.setVerticalGroup(
            jPanel246Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel246Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel246Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel297)
                    .addComponent(lb_tenChiNhanh))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        panel_ChiTietDonNhapHang.add(jPanel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 316, -1));

        jPanel248.setBackground(new java.awt.Color(255, 255, 255));

        jLabel301.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel301.setText("Thời gian:");

        lb_thoiGian.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lb_thoiGian.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_thoiGian.setText("03/03/2024 10:29");

        javax.swing.GroupLayout jPanel248Layout = new javax.swing.GroupLayout(jPanel248);
        jPanel248.setLayout(jPanel248Layout);
        jPanel248Layout.setHorizontalGroup(
            jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel248Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel301)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_thoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel248Layout.setVerticalGroup(
            jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel248Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel301)
                    .addComponent(lb_thoiGian))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_ChiTietDonNhapHang.add(jPanel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 256, -1));

        jPanel249.setBackground(new java.awt.Color(255, 255, 255));

        jLabel303.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel303.setText("Trạng thái:");

        cb_trangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa nhập hàng", "Đã nhập hàng", "Đã trả hàng" }));

        javax.swing.GroupLayout jPanel249Layout = new javax.swing.GroupLayout(jPanel249);
        jPanel249.setLayout(jPanel249Layout);
        jPanel249Layout.setHorizontalGroup(
            jPanel249Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel249Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel303)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(cb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel249Layout.setVerticalGroup(
            jPanel249Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel249Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel249Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel303)
                    .addComponent(cb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panel_ChiTietDonNhapHang.add(jPanel249, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jPanel251.setBackground(new java.awt.Color(255, 255, 255));

        jLabel307.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil.png"))); // NOI18N

        tare_ghiChu.setColumns(20);
        tare_ghiChu.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        tare_ghiChu.setRows(5);
        tare_ghiChu.setText("Ghi chú...");
        tare_ghiChu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tare_ghiChuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tare_ghiChuFocusLost(evt);
            }
        });
        jScrollPane16.setViewportView(tare_ghiChu);

        javax.swing.GroupLayout jPanel251Layout = new javax.swing.GroupLayout(jPanel251);
        jPanel251.setLayout(jPanel251Layout);
        jPanel251Layout.setHorizontalGroup(
            jPanel251Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel251Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel307)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel251Layout.setVerticalGroup(
            jPanel251Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel251Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel307)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
        );

        panel_ChiTietDonNhapHang.add(jPanel251, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 290, -1));

        jLabel296.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel296.setForeground(new java.awt.Color(102, 102, 102));
        jLabel296.setText("Chỉnh sửa chi tiết đơn đặt hàng bằng cách chọn tương ứng");
        panel_ChiTietDonNhapHang.add(jLabel296, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 380, -1));

        jPanel245.setBackground(new java.awt.Color(255, 255, 255));
        jPanel245.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel295.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel295.setText("Nhà cung cấp:");

        cb_nhaCungCap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel245Layout = new javax.swing.GroupLayout(jPanel245);
        jPanel245.setLayout(jPanel245Layout);
        jPanel245Layout.setHorizontalGroup(
            jPanel245Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel245Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel295)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(cb_nhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel245Layout.setVerticalGroup(
            jPanel245Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel245Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel245Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel295)
                    .addComponent(cb_nhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_ChiTietDonNhapHang.add(jPanel245, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 370, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel20.setText("CHI TIẾT ĐƠN NHẬP HÀNG");
        jLabel20.setToolTipText("");
        panel_ChiTietDonNhapHang.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel92.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel92.setText("Garage oto Lâm Vinh");
        panel_ChiTietDonNhapHang.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelChiTietDonNhapHang_maHang.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDonChiTiet_doiTac3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_doiTac3.setText("Mã hàng:");

        lbChiTietDonNhapHang_maHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietDonNhapHang_maHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout panelChiTietDonNhapHang_maHangLayout = new javax.swing.GroupLayout(panelChiTietDonNhapHang_maHang);
        panelChiTietDonNhapHang_maHang.setLayout(panelChiTietDonNhapHang_maHangLayout);
        panelChiTietDonNhapHang_maHangLayout.setHorizontalGroup(
            panelChiTietDonNhapHang_maHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietDonNhapHang_maHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoaDonChiTiet_doiTac3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbChiTietDonNhapHang_maHang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelChiTietDonNhapHang_maHangLayout.setVerticalGroup(
            panelChiTietDonNhapHang_maHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietDonNhapHang_maHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChiTietDonNhapHang_maHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDonChiTiet_doiTac3)
                    .addComponent(lbChiTietDonNhapHang_maHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_ChiTietDonNhapHang.add(panelChiTietDonNhapHang_maHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, -1));

        panelChiTietDonNhapHang_tenHang.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDonChiTiet_doiTac4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_doiTac4.setText("Tên hàng:");

        tfChiTietDonNhapHang_tenHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfChiTietDonNhapHang_tenHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout panelChiTietDonNhapHang_tenHangLayout = new javax.swing.GroupLayout(panelChiTietDonNhapHang_tenHang);
        panelChiTietDonNhapHang_tenHang.setLayout(panelChiTietDonNhapHang_tenHangLayout);
        panelChiTietDonNhapHang_tenHangLayout.setHorizontalGroup(
            panelChiTietDonNhapHang_tenHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietDonNhapHang_tenHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoaDonChiTiet_doiTac4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietDonNhapHang_tenHang, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelChiTietDonNhapHang_tenHangLayout.setVerticalGroup(
            panelChiTietDonNhapHang_tenHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietDonNhapHang_tenHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChiTietDonNhapHang_tenHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDonChiTiet_doiTac4)
                    .addComponent(tfChiTietDonNhapHang_tenHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_ChiTietDonNhapHang.add(panelChiTietDonNhapHang_tenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 240, -1));

        panelChiTietDonNhapHang_soLuong.setBackground(new java.awt.Color(255, 255, 255));

        lbHoaDonChiTiet_doiTac2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_doiTac2.setText("Số lượng:");

        tfChiTietDonNhapHang_soLuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfChiTietDonNhapHang_soLuong.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfChiTietDonNhapHang_soLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfChiTietDonNhapHang_soLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfChiTietDonNhapHang_soLuongKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelChiTietDonNhapHang_soLuongLayout = new javax.swing.GroupLayout(panelChiTietDonNhapHang_soLuong);
        panelChiTietDonNhapHang_soLuong.setLayout(panelChiTietDonNhapHang_soLuongLayout);
        panelChiTietDonNhapHang_soLuongLayout.setHorizontalGroup(
            panelChiTietDonNhapHang_soLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietDonNhapHang_soLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoaDonChiTiet_doiTac2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietDonNhapHang_soLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelChiTietDonNhapHang_soLuongLayout.setVerticalGroup(
            panelChiTietDonNhapHang_soLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChiTietDonNhapHang_soLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChiTietDonNhapHang_soLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDonChiTiet_doiTac2)
                    .addComponent(tfChiTietDonNhapHang_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_ChiTietDonNhapHang.add(panelChiTietDonNhapHang_soLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 180, -1));

        btnChiTietDonNhapHang_traSanPham.setBackground(new java.awt.Color(51, 153, 255));
        btnChiTietDonNhapHang_traSanPham.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietDonNhapHang_traSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietDonNhapHang_traSanPham.setText("Trả");
        btnChiTietDonNhapHang_traSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietDonNhapHang_traSanPhamActionPerformed(evt);
            }
        });
        panel_ChiTietDonNhapHang.add(btnChiTietDonNhapHang_traSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 100, 30));

        btnChiTietDonNhapHang_hoanTac.setBackground(new java.awt.Color(255, 153, 153));
        btnChiTietDonNhapHang_hoanTac.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietDonNhapHang_hoanTac.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietDonNhapHang_hoanTac.setText("Hoàn tác");
        btnChiTietDonNhapHang_hoanTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietDonNhapHang_hoanTacActionPerformed(evt);
            }
        });
        panel_ChiTietDonNhapHang.add(btnChiTietDonNhapHang_hoanTac, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 100, 30));
        panel_ChiTietDonNhapHang.add(lbChiTietDonNhapHang_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 370, 20));

        checkBoxChiTietDonNhapHang_sanPhamLoi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        checkBoxChiTietDonNhapHang_sanPhamLoi.setText("Sản phẩm lỗi");
        panel_ChiTietDonNhapHang.add(checkBoxChiTietDonNhapHang_sanPhamLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        jPanel1.add(panel_ChiTietDonNhapHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 977, 510));

        jPanel250.setBackground(new java.awt.Color(255, 255, 255));

        jLabel305.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel305.setText("Tổng số lượng:");

        lb_tongSoLuong.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_tongSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tongSoLuong.setText("21");

        javax.swing.GroupLayout jPanel250Layout = new javax.swing.GroupLayout(jPanel250);
        jPanel250.setLayout(jPanel250Layout);
        jPanel250Layout.setHorizontalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel250Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel305)
                .addGap(18, 18, 18)
                .addComponent(lb_tongSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel250Layout.setVerticalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel250Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel305)
                    .addComponent(lb_tongSoLuong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 220, -1));

        jPanel242.setBackground(new java.awt.Color(255, 255, 255));

        jLabel289.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel289.setText("Tổng tiền hàng:");

        lb_tongTienHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_tongTienHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tongTienHang.setText("16,926,700");

        javax.swing.GroupLayout jPanel242Layout = new javax.swing.GroupLayout(jPanel242);
        jPanel242.setLayout(jPanel242Layout);
        jPanel242Layout.setHorizontalGroup(
            jPanel242Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel242Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel289)
                .addGap(18, 18, 18)
                .addComponent(lb_tongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel242Layout.setVerticalGroup(
            jPanel242Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel242Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel242Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel289)
                    .addComponent(lb_tongTienHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, -1, -1));

        jPanel244.setBackground(new java.awt.Color(255, 255, 255));

        jLabel293.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel293.setText("Tiền đã trả:");

        lb_tienDaTra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_tienDaTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tienDaTra.setText("16,926,700");

        javax.swing.GroupLayout jPanel244Layout = new javax.swing.GroupLayout(jPanel244);
        jPanel244.setLayout(jPanel244Layout);
        jPanel244Layout.setHorizontalGroup(
            jPanel244Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel244Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel293, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(lb_tienDaTra, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel244Layout.setVerticalGroup(
            jPanel244Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel244Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel244Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel293)
                    .addComponent(lb_tienDaTra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, -1, -1));

        jPanel247.setBackground(new java.awt.Color(255, 255, 255));

        jLabel299.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel299.setText("Nợ nhà cung cấp:");

        lb_noNhaCungCap.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_noNhaCungCap.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_noNhaCungCap.setText("0");

        javax.swing.GroupLayout jPanel247Layout = new javax.swing.GroupLayout(jPanel247);
        jPanel247.setLayout(jPanel247Layout);
        jPanel247Layout.setHorizontalGroup(
            jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel247Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel299)
                .addGap(18, 18, 18)
                .addComponent(lb_noNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel247Layout.setVerticalGroup(
            jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel247Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel299)
                    .addComponent(lb_noNhaCungCap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 250, -1));

        jPanel252.setBackground(new java.awt.Color(255, 255, 255));

        jLabel304.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel304.setText("Nhà cung cấp nợ:");

        lb_nhaCungCapNo.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_nhaCungCapNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_nhaCungCapNo.setText("0");

        javax.swing.GroupLayout jPanel252Layout = new javax.swing.GroupLayout(jPanel252);
        jPanel252.setLayout(jPanel252Layout);
        jPanel252Layout.setHorizontalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel252Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel304)
                .addGap(24, 24, 24)
                .addComponent(lb_nhaCungCapNo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel252Layout.setVerticalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel252Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel304)
                    .addComponent(lb_nhaCungCapNo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel252, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, -1, -1));

        tbChiTietDonNhapHang_traHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbChiTietDonNhapHang_traHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng", "Tên hàng", "Đơn giá", "Số lượng", "Lỗi"
            }
        ));
        tbChiTietDonNhapHang_traHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChiTietDonNhapHang_traHangMouseClicked(evt);
            }
        });
        scrollPaneHoaDonChiTiet_traHang.setViewportView(tbChiTietDonNhapHang_traHang);

        jPanel1.add(scrollPaneHoaDonChiTiet_traHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 450, 150));

        btnChiTietDonNhapHang_luuTraHang.setBackground(new java.awt.Color(51, 204, 0));
        btnChiTietDonNhapHang_luuTraHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietDonNhapHang_luuTraHang.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietDonNhapHang_luuTraHang.setText("Lưu");
        btnChiTietDonNhapHang_luuTraHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietDonNhapHang_luuTraHangActionPerformed(evt);
            }
        });
        jPanel1.add(btnChiTietDonNhapHang_luuTraHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 640, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyBoActionPerformed
        // close the frame
        this.dispose();
    }//GEN-LAST:event_btn_huyBoActionPerformed

    private void btnChiTietDonNhapHang_capNhat_TraHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietDonNhapHang_capNhat_TraHangActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 12.3 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền cập nhật phiếu nhập hàng!");
                return;
            }
        if (btnChiTietDonNhapHang_capNhat_TraHang.getText().equals("Cập nhật")){
            PhieuNhapHang phieuNhapHangUpdate = new PhieuNhapHang();
            phieuNhapHangUpdate.setPhieuNhapHang(lb_maNhapHang.getText());
            phieuNhapHangUpdate.setMaNhaCungCap(String.valueOf(cb_nhaCungCap.getSelectedItem()).split("\\s+")[0]);
            phieuNhapHangUpdate.setTrangThai(String.valueOf(cb_trangThai.getSelectedItem()));
            try {
                phieuNhapHangService.updatePhieuNhapHang(phieuNhapHangUpdate);
                this.phieuNhapHang.setMaNhaCungCap(phieuNhapHangUpdate.getMaNhaCungCap());
                this.phieuNhapHang.setTrangThai(phieuNhapHangUpdate.getTrangThai());
                hienThiThongTinPhieuNhapHang();
            } catch (SQLException ex) {
                Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (btnChiTietDonNhapHang_capNhat_TraHang.getText().equals("Trả hàng")){
            panelChiTietDonNhapHang_maHang.setVisible(true);
            panelChiTietDonNhapHang_soLuong.setVisible(true);
            panelChiTietDonNhapHang_tenHang.setVisible(true);
            tbChiTietDonNhapHang_traHang.setVisible(true);
            btnChiTietDonNhapHang_hoanTac.setVisible(true);
            btnChiTietDonNhapHang_traSanPham.setVisible(true);
            btnChiTietDonNhapHang_capNhat_TraHang.setText("Lưu");
        }
    }//GEN-LAST:event_btnChiTietDonNhapHang_capNhat_TraHangActionPerformed

    private void btn_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 12.5 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền in phiếu nhập hàng!");
                return;
            }
        try{
            panel_ChiTietDonNhapHang.setBackground(Color.WHITE);
            BufferedImage bi = new BufferedImage(panel_ChiTietDonNhapHang.getWidth(), panel_ChiTietDonNhapHang.getHeight(), BufferedImage.TYPE_INT_RGB);
            panel_ChiTietDonNhapHang.paint(bi.getGraphics());
            String path = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\Git_GarageOtoAnt_DoAn\\GarageOto_JavaSwingAnt\\DoAn_GarageOto_Ant\\filePDF\\" + this.phieuNhapHang.getPhieuNhapHang() + ".jpg";
            ImageIO.write(bi, "jpg", new File(path));
            
        } catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btn_inActionPerformed

    
    
    private void tb_chiTietDonNhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chiTietDonNhapHangMouseClicked
        if (btnChiTietDonNhapHang_capNhat_TraHang.getText().equals("Cập nhật")){
            int index = tb_chiTietDonNhapHang.getSelectedRow();
            TableModel model = tb_chiTietDonNhapHang.getModel();
            ChiTietPhieuNhapHang chiTietPhieuNhapHang = new ChiTietPhieuNhapHang();
            try {
                chiTietPhieuNhapHang = chiTietPhieuNhapHangService.hienThiChiTietPhieuNhapHangTheoMaChiTietPhieuNhapHang(model.getValueAt(index, 0).toString());
            } catch (SQLException ex) {
                Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            Frame_CapNhatChiTietDonNhapHang frame_CapNhatChiTietDonNhapHang = new Frame_CapNhatChiTietDonNhapHang(chiTietPhieuNhapHang);
            frame_CapNhatChiTietDonNhapHang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame_CapNhatChiTietDonNhapHang.setVisible(true);
            frame_CapNhatChiTietDonNhapHang.setSize(300, 352);
            frame_CapNhatChiTietDonNhapHang.setLocation(250,250);
            frame_CapNhatChiTietDonNhapHang.addCloseEventListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    try {
                        // Execute your function when the Frame_CapNhatChiTietDonNhapHang frame is closed
                        hienThiDanhSachChiTietPhieuNhapHangTheoMaPhieuNhapHang(phieuNhapHang.getPhieuNhapHang());
                    } catch (SQLException ex) {
                        Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } else {
            btnChiTietDonNhapHang_hoanTac.setVisible(false);
            int index = tb_chiTietDonNhapHang.getSelectedRow();
            TableModel model = tb_chiTietDonNhapHang.getModel();

            lbChiTietDonNhapHang_maHang.setText(model.getValueAt(index, 1).toString());
            tfChiTietDonNhapHang_tenHang.setText(model.getValueAt(index, 2).toString());
            tfChiTietDonNhapHang_soLuong.setText(model.getValueAt(index, 3).toString());

            soLuongSanPhamTra = Integer.parseInt(model.getValueAt(index, 3).toString());
            if (btnChiTietDonNhapHang_capNhat_TraHang.getText().equals("Lưu")){
                btnChiTietDonNhapHang_traSanPham.setVisible(true);
            }
            donGiaSanPhamTra = Double.parseDouble(model.getValueAt(index, 4).toString());
        }
        
    }//GEN-LAST:event_tb_chiTietDonNhapHangMouseClicked

    private void tare_ghiChuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tare_ghiChuFocusGained
        tare_ghiChu.setText("");
    }//GEN-LAST:event_tare_ghiChuFocusGained

    private void tare_ghiChuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tare_ghiChuFocusLost
        if (tare_ghiChu.getText().isEmpty()){
            tare_ghiChu.setText("Ghi chú ...");
            tare_ghiChu.setFont(tare_ghiChu.getFont().deriveFont(Font.ITALIC));

        }
    }//GEN-LAST:event_tare_ghiChuFocusLost

    private void tfChiTietDonNhapHang_soLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfChiTietDonNhapHang_soLuongKeyReleased
        try{
            if (Integer.parseInt(tfChiTietDonNhapHang_soLuong.getText()) <= 0){
                lbChiTietDonNhapHang_error.setText("Số lượng lớn hơn 0");
                btnChiTietDonNhapHang_traSanPham.setVisible(false);
            } else if (Integer.parseInt(tfChiTietDonNhapHang_soLuong.getText()) > soLuongSanPhamTra){
                lbChiTietDonNhapHang_error.setText("Số lượng không hợp lệ");
                btnChiTietDonNhapHang_traSanPham.setVisible(false);
            } else {
                lbChiTietDonNhapHang_error.setText("");
                btnChiTietDonNhapHang_traSanPham.setVisible(true);
            }

        } catch (Exception err){
            lbChiTietDonNhapHang_error.setText("Không đúng định dạng");
        }

    }//GEN-LAST:event_tfChiTietDonNhapHang_soLuongKeyReleased

    private void btnChiTietDonNhapHang_traSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietDonNhapHang_traSanPhamActionPerformed
        if (tfChiTietDonNhapHang_soLuong.getText().equals("")){
            return;
        }
        DefaultTableModel recordTable = (DefaultTableModel)tbChiTietDonNhapHang_traHang.getModel();

        for (int i =0; i< recordTable.getRowCount(); i++){
            if (tbChiTietDonNhapHang_traHang.getValueAt(i, 0).equals(lbChiTietDonNhapHang_maHang.getText())){
                return;
            }
        }

        Vector columnData = new Vector();
        columnData.add(lbChiTietDonNhapHang_maHang.getText());
        columnData.add(tfChiTietDonNhapHang_tenHang.getText());
        if (checkBoxChiTietDonNhapHang_sanPhamLoi.isSelected()){
            columnData.add(donGiaSanPhamTra);
        } else {
            columnData.add(donGiaSanPhamTra*1.1); // phụ thu 10%
        }
        columnData.add(tfChiTietDonNhapHang_soLuong.getText());
        if (checkBoxChiTietDonNhapHang_sanPhamLoi.isSelected()){
            columnData.add("Lỗi");
        }
        recordTable.addRow(columnData);

        if (recordTable.getRowCount() > 0){
            btnChiTietDonNhapHang_luuTraHang.setVisible(true);
        }
    }//GEN-LAST:event_btnChiTietDonNhapHang_traSanPhamActionPerformed

    private void btnChiTietDonNhapHang_hoanTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietDonNhapHang_hoanTacActionPerformed

        DefaultTableModel recordTable = (DefaultTableModel)tbChiTietDonNhapHang_traHang.getModel();
        for (int i =0; i< recordTable.getRowCount(); i++){
            if (tbChiTietDonNhapHang_traHang.getValueAt(i, 0).equals(lbChiTietDonNhapHang_maHang.getText())){
                recordTable.removeRow(i);
                return;
            }
        }
        if (tbChiTietDonNhapHang_traHang.getRowCount() == 0){
            btnChiTietDonNhapHang_capNhat_TraHang.setVisible(false);
        }
        if (recordTable.getRowCount() > 0){
            btnChiTietDonNhapHang_luuTraHang.setVisible(true);
        }
    }//GEN-LAST:event_btnChiTietDonNhapHang_hoanTacActionPerformed

    private void tbChiTietDonNhapHang_traHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietDonNhapHang_traHangMouseClicked
        btnChiTietDonNhapHang_hoanTac.setVisible(true);
        int index = tbChiTietDonNhapHang_traHang.getSelectedRow();
        TableModel model = tbChiTietDonNhapHang_traHang.getModel();

        lbChiTietDonNhapHang_maHang.setText(model.getValueAt(index, 0).toString());
        tfChiTietDonNhapHang_tenHang.setText(model.getValueAt(index, 1).toString());
        tfChiTietDonNhapHang_soLuong.setText(model.getValueAt(index, 3).toString());
        
        
    }//GEN-LAST:event_tbChiTietDonNhapHang_traHangMouseClicked

    private void btnChiTietDonNhapHang_luuTraHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietDonNhapHang_luuTraHangActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 14.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền trả hàng!");
                return;
            }
        Frame_TienThanhToanTraHang frame_TienThanhToanTraHang = new Frame_TienThanhToanTraHang( phieuNhapHang.getPhieuNhapHang(), phieuNhapHang.getMaNhaCungCap() , nhanVienDangNhap.getMaNhanVien(), tbChiTietDonNhapHang_traHang, nhanVienDangNhap );
        frame_TienThanhToanTraHang.setVisible(true);
        frame_TienThanhToanTraHang.setSize(365, 200);
        frame_TienThanhToanTraHang.setLocation(400,200);
        btnChiTietDonNhapHang_capNhat_TraHang.setVisible(false);
    }//GEN-LAST:event_btnChiTietDonNhapHang_luuTraHangActionPerformed

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
            java.util.logging.Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_ChiTietDonNhapHang().setVisible(true);
            }
        });
    }
    
    public void hienThiDanhSachChiTietPhieuNhapHangTheoMaPhieuNhapHang(String maPhieuNhapHang) throws SQLException{
        tbChiTietDonNhapHang_traHang.setVisible(false);
        DefaultTableModel recordTable = (DefaultTableModel)tb_chiTietDonNhapHang.getModel();
        recordTable.setRowCount(0);
        List<ChiTietPhieuNhapHang> danhChiTietPhieuNhapHang = chiTietPhieuNhapHangService.hienThiChiTietPhieuNhapHangTheoMaPhieuNhapHang(maPhieuNhapHang);
        short tongSoLuong = 0;
        double tongTienHang = 0;
        for (ChiTietPhieuNhapHang chiTietPhieuNhapHang : danhChiTietPhieuNhapHang) {
            Vector columnData = new Vector();
            columnData.add(chiTietPhieuNhapHang.getMaChiTietPhieuNhapHang());
            columnData.add(chiTietPhieuNhapHang.getMaHangHoa());
            columnData.add(chiTietPhieuNhapHang.getHangHoa().getTenHangHoa());
            columnData.add(chiTietPhieuNhapHang.getSo_luong());
            columnData.add(chiTietPhieuNhapHang.getGia_nhap());
            columnData.add(chiTietPhieuNhapHang.getTong());
            columnData.add(chiTietPhieuNhapHang.getGiam_gia());
            columnData.add(chiTietPhieuNhapHang.getThanh_tien());
            recordTable.addRow(columnData);
            tongTienHang += chiTietPhieuNhapHang.getTong();
            tongSoLuong += chiTietPhieuNhapHang.getSo_luong();
        }
        lb_tongSoLuong.setText(String.valueOf(tongSoLuong));
        lb_tongTienHang.setText(String.valueOf(tongTienHang));
        if (tongTienHang > this.phieuNhapHang.getTienDaTra()){
            lb_noNhaCungCap.setText(String.valueOf(tongTienHang - this.phieuNhapHang.getTienDaTra()));
        }
        if (tongTienHang < this.phieuNhapHang.getTienDaTra()){
            lb_noNhaCungCap.setText(String.valueOf(this.phieuNhapHang.getTienDaTra() - tongTienHang));
        }
    }
    public void hienThiThongTinPhieuNhapHang(){
        lb_maNhapHang.setText(this.phieuNhapHang.getPhieuNhapHang());
        lb_tenChiNhanh.setText(this.phieuNhapHang.getMaChiNhanh());
        lb_tenNguoiTao.setText(this.phieuNhapHang.getMaNhanVienTao());
//        lb_tenNhaCungCap.setText(this.phieuNhapHang.getMaNhaCungCap());
        lb_thoiGian.setText(util.localDateParseMethod(this.phieuNhapHang.getThoiGian()));
//        lb_trangThai.setText(this.phieuNhapHang.getTrangThai());
        lb_tienDaTra.setText(String.valueOf(this.phieuNhapHang.getTienDaTra()));
        
        List<NhaCungCap> danhSachNhaCungCap = new ArrayList<>();
        try {
            danhSachNhaCungCap = nhaCungCapService.hienThiTatCaNhaCungCap();
        } catch (SQLException ex) {
            Logger.getLogger(frame_ChiTietDonNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        cb_nhaCungCap.removeAllItems();
        for (NhaCungCap nhaCungCap : danhSachNhaCungCap) {
            cb_nhaCungCap.addItem(nhaCungCap.getMaNhaCungCap() + " " + nhaCungCap.getTenNhaCungCap());
            if (phieuNhapHang.getMaNhaCungCap().equals(nhaCungCap.getMaNhaCungCap())){
                cb_nhaCungCap.setSelectedItem(nhaCungCap.getMaNhaCungCap() + " " + nhaCungCap.getTenNhaCungCap());
            }
        }
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cb_trangThai.getModel();
        for (int i=0; i< model.getSize(); i++){
            if (phieuNhapHang.getTrangThai().equals(String.valueOf(model.getElementAt(i)))){
                cb_trangThai.setSelectedItem(model.getElementAt(i));
                break;
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietDonNhapHang_capNhat_TraHang;
    private javax.swing.JButton btnChiTietDonNhapHang_hoanTac;
    private javax.swing.JButton btnChiTietDonNhapHang_luuTraHang;
    private javax.swing.JButton btnChiTietDonNhapHang_traSanPham;
    private javax.swing.JButton btn_huyBo;
    private javax.swing.JButton btn_in;
    private javax.swing.JComboBox<String> cb_nhaCungCap;
    private javax.swing.JComboBox<String> cb_trangThai;
    private javax.swing.JCheckBox checkBoxChiTietDonNhapHang_sanPhamLoi;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel241;
    private javax.swing.JPanel jPanel242;
    private javax.swing.JPanel jPanel243;
    private javax.swing.JPanel jPanel244;
    private javax.swing.JPanel jPanel245;
    private javax.swing.JPanel jPanel246;
    private javax.swing.JPanel jPanel247;
    private javax.swing.JPanel jPanel248;
    private javax.swing.JPanel jPanel249;
    private javax.swing.JPanel jPanel250;
    private javax.swing.JPanel jPanel251;
    private javax.swing.JPanel jPanel252;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JLabel lbChiTietDonNhapHang_error;
    private javax.swing.JLabel lbChiTietDonNhapHang_maHang;
    private javax.swing.JLabel lbHoaDonChiTiet_doiTac2;
    private javax.swing.JLabel lbHoaDonChiTiet_doiTac3;
    private javax.swing.JLabel lbHoaDonChiTiet_doiTac4;
    private javax.swing.JLabel lb_maNhapHang;
    private javax.swing.JLabel lb_nhaCungCapNo;
    private javax.swing.JLabel lb_noNhaCungCap;
    private javax.swing.JLabel lb_tenChiNhanh;
    private javax.swing.JLabel lb_tenNguoiTao;
    private javax.swing.JLabel lb_thoiGian;
    private javax.swing.JLabel lb_tienDaTra;
    private javax.swing.JLabel lb_tongSoLuong;
    private javax.swing.JLabel lb_tongTienHang;
    private javax.swing.JPanel panelChiTietDonNhapHang_maHang;
    private javax.swing.JPanel panelChiTietDonNhapHang_soLuong;
    private javax.swing.JPanel panelChiTietDonNhapHang_tenHang;
    private javax.swing.JPanel panel_ChiTietDonNhapHang;
    private javax.swing.JScrollPane scrollPaneHoaDonChiTiet_traHang;
    private javax.swing.JTextArea tare_ghiChu;
    private javax.swing.JTable tbChiTietDonNhapHang_traHang;
    private javax.swing.JTable tb_chiTietDonNhapHang;
    private javax.swing.JTextField tfChiTietDonNhapHang_soLuong;
    private javax.swing.JTextField tfChiTietDonNhapHang_tenHang;
    // End of variables declaration//GEN-END:variables
}
