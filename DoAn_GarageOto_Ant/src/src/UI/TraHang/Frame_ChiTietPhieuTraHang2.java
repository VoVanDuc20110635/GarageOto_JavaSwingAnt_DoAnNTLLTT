/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.TraHang;

import src.UI.HoaDon.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import src.Model.ChiNhanh;
import src.Model.ChiTietPhieuTraHang;
import src.Model.HangHoa;
import src.Model.HoaDon;
import src.Model.HoaDonChiTiet;
import src.Model.KhachHang;
import src.Model.NhanVien;
import src.Model.PhieuNhapHang;
import src.Model.PhieuTraHang;
import src.Service.ChiNhanhServive;
import src.Service.ChiTietPhieuTraHangService;
import src.Service.HangHoaService;
import src.Service.HoaDonChiTietService;
import src.Service.HoaDonService;
import src.Service.KhachHangService;
import src.Service.MailSender;
import src.Service.NhanVienService;
import src.Service.PhieuTraHangService;
import src.UI.TrangChu;
import src.Util.Util;
import src.Util.WritePDF;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_ChiTietPhieuTraHang2 extends javax.swing.JFrame {
    private PhieuTraHang phieuTraHang;
    private List<ChiTietPhieuTraHang> danhSachChiTietPhieuTraHang;
    private ChiNhanhServive chiNhanhService = new ChiNhanhServive();
    private KhachHangService khachHangService = new KhachHangService();
    private NhanVienService nhanVienService = new NhanVienService();
    private ChiTietPhieuTraHangService chiTietPhieuTraHangService = new ChiTietPhieuTraHangService();
    private HangHoaService hangHoaService = new HangHoaService();
    private PhieuTraHangService phieuTraHangService = new PhieuTraHangService();
    private MailSender mailSender = new MailSender();
    private Util util = new Util();
    
    
    
    
    public PhieuTraHang getPhieuTraHang(){
        return phieuTraHang;
    }

    /**
     * Creates new form frame_HoaDonChiTiet
     */
    public void setPhieuTraHang(PhieuTraHang phieuTraHang) {
        this.phieuTraHang = phieuTraHang;
    }

    public Frame_ChiTietPhieuTraHang2(PhieuTraHang phieuTraHang) {
        this.phieuTraHang = phieuTraHang;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            this.danhSachChiTietPhieuTraHang = chiTietPhieuTraHangService.hienThiTatCaChiTietPhieuTraHangTheoMaPhieuTraHang(phieuTraHang.getMaPhieuTraHang());
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ChiTietPhieuTraHang2.class.getName()).log(Level.SEVERE, null, ex);
        }
        hienThiThongTinPhieuTraHang();
    }

    public Frame_ChiTietPhieuTraHang2() {
    }

    
    private void hienThiThongTinPhieuTraHang() {
        try {
            ChiNhanh chiNhanh = chiNhanhService.hienThiChiNhanhTheoMaChiNhanh(phieuTraHang.getMaChiNhanh());
            lbChiTietPhieuTraHang_chiNhanh.setText(chiNhanh.getMaChiNhanh() + " " + chiNhanh.getTenChiNhanh());
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ChiTietPhieuTraHang2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            KhachHang khachHang = khachHangService.hienThiKhachHangTheoMaKhachHang(phieuTraHang.getMaKhachHang());
            lbChiTietPhieuTraHang_khachHang.setText(khachHang.getMaKhachHang() + " " + khachHang.getTenKhachHang());
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ChiTietPhieuTraHang2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            NhanVien nhanVien = nhanVienService.hienThiNhanVienTheoMaNhanVien(phieuTraHang.getMaNhanVien());
            lbChiTietPhieuTraHang_nguoiTao.setText(nhanVien.getMaNhanVien() + " " + nhanVien.getTenNhanVien());
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ChiTietPhieuTraHang2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (phieuTraHang.getMaNhaCungCap() == null){
            lbChiTietPhieuTraHang_doiTac.setText("Khách hàng: ");
        } else {
            lbChiTietPhieuTraHang_doiTac.setText("Nhà cung cấp: ");
        }
        lbChiTietPhieuTraHang_maPhieuTraHang.setText(phieuTraHang.getMaPhieuTraHang());
        lbChiTietPhieuTraHang_thoiGian.setText(util.localDateParseMethod(phieuTraHang.getThoiGian()));
        lbChiTietPhieuTraHang_tienDaTra.setText(String.valueOf(phieuTraHang.getDaTra()));
        lbChiTietPhieuTraHang_tienThua.setText(String.valueOf(phieuTraHang.getDaTra() - phieuTraHang.getCanTra()));
        lbChiTietPhieuTraHang_tongTienTraHang.setText(String.valueOf(phieuTraHang.getCanTra()));
        lbChiTietPhieuTraHang_trangThai.setText(phieuTraHang.getTrangThai());
        
        
        DefaultTableModel recordTable = (DefaultTableModel)tbChiTietPhieuTraHang_danhSachChiTietPhieuTraHang.getModel();
        recordTable.setRowCount(0);
        for (ChiTietPhieuTraHang chiTietPhieuTraHang : danhSachChiTietPhieuTraHang) {
            try{
                Vector columnData = new Vector();
                columnData.add(chiTietPhieuTraHang.getMaHangHoa());
                columnData.add(hangHoaService.hienThiHangHoaTheoMaHangHoa(chiTietPhieuTraHang.getMaHangHoa()).getTenHangHoa());
                columnData.add(chiTietPhieuTraHang.getSoLuong());
                columnData.add(chiTietPhieuTraHang.getGiaTraHang());
                columnData.add(chiTietPhieuTraHang.getThanhTien());
                recordTable.addRow(columnData);
            } catch (SQLException ex){
                Logger.getLogger(Frame_ChiTietPhieuTraHang2.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jPanel239 = new javax.swing.JPanel();
        btnChiTietPhieuTraHang_guiMail = new javax.swing.JButton();
        btnChiTietPhieuTraHang_in = new javax.swing.JButton();
        btnChiTietPhieuTraHang_huyBo = new javax.swing.JButton();
        jPanel241 = new javax.swing.JPanel();
        jLabel287 = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_maPhieuTraHang = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbChiTietPhieuTraHang_danhSachChiTietPhieuTraHang = new javax.swing.JTable();
        jPanel247 = new javax.swing.JPanel();
        jLabel299 = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_tienDaTra = new javax.swing.JLabel();
        jPanel248 = new javax.swing.JPanel();
        jLabel301 = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_thoiGian = new javax.swing.JLabel();
        jPanel250 = new javax.swing.JPanel();
        jLabel305 = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_tongSoLuongTra = new javax.swing.JLabel();
        jPanel252 = new javax.swing.JPanel();
        jLabel304 = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_tienThua = new javax.swing.JLabel();
        jPanel253 = new javax.swing.JPanel();
        jLabel294 = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_tongTienTraHang = new javax.swing.JLabel();
        jPanel246 = new javax.swing.JPanel();
        jLabel297 = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_chiNhanh = new javax.swing.JLabel();
        jPanel249 = new javax.swing.JPanel();
        jLabel303 = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_trangThai = new javax.swing.JLabel();
        jPanel243 = new javax.swing.JPanel();
        jLabel291 = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_nguoiTao = new javax.swing.JLabel();
        jPanel254 = new javax.swing.JPanel();
        lbChiTietPhieuTraHang_doiTac = new javax.swing.JLabel();
        lbChiTietPhieuTraHang_khachHang = new javax.swing.JLabel();
        lbHoaDonChiTiet_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel239.setBackground(new java.awt.Color(255, 255, 255));
        jPanel239.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChiTietPhieuTraHang_guiMail.setBackground(new java.awt.Color(51, 204, 0));
        btnChiTietPhieuTraHang_guiMail.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietPhieuTraHang_guiMail.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietPhieuTraHang_guiMail.setText("Gửi mail");
        btnChiTietPhieuTraHang_guiMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietPhieuTraHang_guiMailActionPerformed(evt);
            }
        });
        jPanel239.add(btnChiTietPhieuTraHang_guiMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, -1, -1));

        btnChiTietPhieuTraHang_in.setBackground(new java.awt.Color(51, 204, 0));
        btnChiTietPhieuTraHang_in.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietPhieuTraHang_in.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietPhieuTraHang_in.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exportFile.png"))); // NOI18N
        btnChiTietPhieuTraHang_in.setText("In");
        btnChiTietPhieuTraHang_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietPhieuTraHang_inActionPerformed(evt);
            }
        });
        jPanel239.add(btnChiTietPhieuTraHang_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, -1, -1));

        btnChiTietPhieuTraHang_huyBo.setBackground(new java.awt.Color(255, 51, 51));
        btnChiTietPhieuTraHang_huyBo.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietPhieuTraHang_huyBo.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietPhieuTraHang_huyBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel.png"))); // NOI18N
        btnChiTietPhieuTraHang_huyBo.setText("Hủy bỏ");
        btnChiTietPhieuTraHang_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietPhieuTraHang_huyBoActionPerformed(evt);
            }
        });
        jPanel239.add(btnChiTietPhieuTraHang_huyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 510, -1, -1));

        jPanel241.setBackground(new java.awt.Color(255, 255, 255));

        jLabel287.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel287.setText("Mã phiếu trả hàng:");

        lbChiTietPhieuTraHang_maPhieuTraHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbChiTietPhieuTraHang_maPhieuTraHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_maPhieuTraHang.setText("0");

        javax.swing.GroupLayout jPanel241Layout = new javax.swing.GroupLayout(jPanel241);
        jPanel241.setLayout(jPanel241Layout);
        jPanel241Layout.setHorizontalGroup(
            jPanel241Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel241Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel287)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbChiTietPhieuTraHang_maPhieuTraHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel241Layout.setVerticalGroup(
            jPanel241Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel241Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel241Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel287)
                    .addComponent(lbChiTietPhieuTraHang_maPhieuTraHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 290, -1));

        tbChiTietPhieuTraHang_danhSachChiTietPhieuTraHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbChiTietPhieuTraHang_danhSachChiTietPhieuTraHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng", "Tên hàng", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tbChiTietPhieuTraHang_danhSachChiTietPhieuTraHang.setRowHeight(30);
        jScrollPane15.setViewportView(tbChiTietPhieuTraHang_danhSachChiTietPhieuTraHang);

        jPanel239.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 165, 1020, 262));

        jPanel247.setBackground(new java.awt.Color(255, 255, 255));

        jLabel299.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel299.setText("Tiền đã trả");

        lbChiTietPhieuTraHang_tienDaTra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbChiTietPhieuTraHang_tienDaTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_tienDaTra.setText("0");

        javax.swing.GroupLayout jPanel247Layout = new javax.swing.GroupLayout(jPanel247);
        jPanel247.setLayout(jPanel247Layout);
        jPanel247Layout.setHorizontalGroup(
            jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel247Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel299)
                .addGap(24, 24, 24)
                .addComponent(lbChiTietPhieuTraHang_tienDaTra, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel247Layout.setVerticalGroup(
            jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel247Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel299)
                    .addComponent(lbChiTietPhieuTraHang_tienDaTra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, -1, -1));

        jPanel248.setBackground(new java.awt.Color(255, 255, 255));

        jLabel301.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel301.setText("Thời gian:");

        lbChiTietPhieuTraHang_thoiGian.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietPhieuTraHang_thoiGian.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_thoiGian.setText("0");

        javax.swing.GroupLayout jPanel248Layout = new javax.swing.GroupLayout(jPanel248);
        jPanel248.setLayout(jPanel248Layout);
        jPanel248Layout.setHorizontalGroup(
            jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel248Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel301)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbChiTietPhieuTraHang_thoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel248Layout.setVerticalGroup(
            jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel248Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel301)
                    .addComponent(lbChiTietPhieuTraHang_thoiGian))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 290, -1));

        jPanel250.setBackground(new java.awt.Color(255, 255, 255));

        jLabel305.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel305.setText("Tổng số lượng trả:");

        lbChiTietPhieuTraHang_tongSoLuongTra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbChiTietPhieuTraHang_tongSoLuongTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_tongSoLuongTra.setText("0");

        javax.swing.GroupLayout jPanel250Layout = new javax.swing.GroupLayout(jPanel250);
        jPanel250.setLayout(jPanel250Layout);
        jPanel250Layout.setHorizontalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel250Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel305)
                .addGap(18, 18, 18)
                .addComponent(lbChiTietPhieuTraHang_tongSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel250Layout.setVerticalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel250Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel305)
                    .addComponent(lbChiTietPhieuTraHang_tongSoLuongTra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 277, -1));

        jPanel252.setBackground(new java.awt.Color(255, 255, 255));

        jLabel304.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel304.setText("Tiền thừa:");

        lbChiTietPhieuTraHang_tienThua.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbChiTietPhieuTraHang_tienThua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_tienThua.setText("0");

        javax.swing.GroupLayout jPanel252Layout = new javax.swing.GroupLayout(jPanel252);
        jPanel252.setLayout(jPanel252Layout);
        jPanel252Layout.setHorizontalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel252Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel304, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbChiTietPhieuTraHang_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel252Layout.setVerticalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel252Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel304)
                    .addComponent(lbChiTietPhieuTraHang_tienThua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel252, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, -1, -1));

        jPanel253.setBackground(new java.awt.Color(255, 255, 255));

        jLabel294.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel294.setText("Tổng tiền hàng trả:");

        lbChiTietPhieuTraHang_tongTienTraHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbChiTietPhieuTraHang_tongTienTraHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_tongTienTraHang.setText("0");

        javax.swing.GroupLayout jPanel253Layout = new javax.swing.GroupLayout(jPanel253);
        jPanel253.setLayout(jPanel253Layout);
        jPanel253Layout.setHorizontalGroup(
            jPanel253Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel253Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel294, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbChiTietPhieuTraHang_tongTienTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel253Layout.setVerticalGroup(
            jPanel253Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel253Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel253Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel294)
                    .addComponent(lbChiTietPhieuTraHang_tongTienTraHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel253, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        jPanel246.setBackground(new java.awt.Color(255, 255, 255));

        jLabel297.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel297.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel297.setText("Chi nhánh:");

        lbChiTietPhieuTraHang_chiNhanh.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietPhieuTraHang_chiNhanh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_chiNhanh.setText("0");

        javax.swing.GroupLayout jPanel246Layout = new javax.swing.GroupLayout(jPanel246);
        jPanel246.setLayout(jPanel246Layout);
        jPanel246Layout.setHorizontalGroup(
            jPanel246Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel246Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel297)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lbChiTietPhieuTraHang_chiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel246Layout.setVerticalGroup(
            jPanel246Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel246Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel246Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel297)
                    .addComponent(lbChiTietPhieuTraHang_chiNhanh))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 280, -1));

        jPanel249.setBackground(new java.awt.Color(255, 255, 255));

        jLabel303.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel303.setText("Trạng thái:");

        lbChiTietPhieuTraHang_trangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietPhieuTraHang_trangThai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_trangThai.setText("0");

        javax.swing.GroupLayout jPanel249Layout = new javax.swing.GroupLayout(jPanel249);
        jPanel249.setLayout(jPanel249Layout);
        jPanel249Layout.setHorizontalGroup(
            jPanel249Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel249Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel303)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lbChiTietPhieuTraHang_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel249Layout.setVerticalGroup(
            jPanel249Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel249Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel249Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel303)
                    .addComponent(lbChiTietPhieuTraHang_trangThai))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel249, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 280, -1));

        jPanel243.setBackground(new java.awt.Color(255, 255, 255));
        jPanel243.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel291.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel291.setText("Người tạo:");

        lbChiTietPhieuTraHang_nguoiTao.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietPhieuTraHang_nguoiTao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_nguoiTao.setText("0");

        javax.swing.GroupLayout jPanel243Layout = new javax.swing.GroupLayout(jPanel243);
        jPanel243.setLayout(jPanel243Layout);
        jPanel243Layout.setHorizontalGroup(
            jPanel243Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel243Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel291)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lbChiTietPhieuTraHang_nguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel243Layout.setVerticalGroup(
            jPanel243Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel243Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel243Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel291)
                    .addComponent(lbChiTietPhieuTraHang_nguoiTao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 280, -1));

        jPanel254.setBackground(new java.awt.Color(255, 255, 255));
        jPanel254.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lbChiTietPhieuTraHang_doiTac.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietPhieuTraHang_doiTac.setText("Khách hàng:");

        lbChiTietPhieuTraHang_khachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietPhieuTraHang_khachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietPhieuTraHang_khachHang.setText("name");

        javax.swing.GroupLayout jPanel254Layout = new javax.swing.GroupLayout(jPanel254);
        jPanel254.setLayout(jPanel254Layout);
        jPanel254Layout.setHorizontalGroup(
            jPanel254Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel254Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbChiTietPhieuTraHang_doiTac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbChiTietPhieuTraHang_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel254Layout.setVerticalGroup(
            jPanel254Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel254Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel254Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbChiTietPhieuTraHang_doiTac)
                    .addComponent(lbChiTietPhieuTraHang_khachHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel254, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 290, -1));
        jPanel239.add(lbHoaDonChiTiet_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 370, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel239, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel239, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChiTietPhieuTraHang_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietPhieuTraHang_huyBoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnChiTietPhieuTraHang_huyBoActionPerformed

    private void btnChiTietPhieuTraHang_guiMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietPhieuTraHang_guiMailActionPerformed
        String to = "2k2lmhtlol@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "voduc0100@gmail.com";

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";

        // Subject
        String subject = "This is the Subject Line!";
        
        mailSender.sendEmailPhieuTraHang(to, from, host, subject, phieuTraHang, danhSachChiTietPhieuTraHang);
    }//GEN-LAST:event_btnChiTietPhieuTraHang_guiMailActionPerformed

    private void btnChiTietPhieuTraHang_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietPhieuTraHang_inActionPerformed
        WritePDF writePDF = new WritePDF();
        writePDF.writePhieuTraHang(phieuTraHang, danhSachChiTietPhieuTraHang);
    }//GEN-LAST:event_btnChiTietPhieuTraHang_inActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_ChiTietPhieuTraHang2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_ChiTietPhieuTraHang2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_ChiTietPhieuTraHang2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_ChiTietPhieuTraHang2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_ChiTietPhieuTraHang2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietPhieuTraHang_guiMail;
    private javax.swing.JButton btnChiTietPhieuTraHang_huyBo;
    private javax.swing.JButton btnChiTietPhieuTraHang_in;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JPanel jPanel239;
    private javax.swing.JPanel jPanel241;
    private javax.swing.JPanel jPanel243;
    private javax.swing.JPanel jPanel246;
    private javax.swing.JPanel jPanel247;
    private javax.swing.JPanel jPanel248;
    private javax.swing.JPanel jPanel249;
    private javax.swing.JPanel jPanel250;
    private javax.swing.JPanel jPanel252;
    private javax.swing.JPanel jPanel253;
    private javax.swing.JPanel jPanel254;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JLabel lbChiTietPhieuTraHang_chiNhanh;
    private javax.swing.JLabel lbChiTietPhieuTraHang_doiTac;
    private javax.swing.JLabel lbChiTietPhieuTraHang_khachHang;
    private javax.swing.JLabel lbChiTietPhieuTraHang_maPhieuTraHang;
    private javax.swing.JLabel lbChiTietPhieuTraHang_nguoiTao;
    private javax.swing.JLabel lbChiTietPhieuTraHang_thoiGian;
    private javax.swing.JLabel lbChiTietPhieuTraHang_tienDaTra;
    private javax.swing.JLabel lbChiTietPhieuTraHang_tienThua;
    private javax.swing.JLabel lbChiTietPhieuTraHang_tongSoLuongTra;
    private javax.swing.JLabel lbChiTietPhieuTraHang_tongTienTraHang;
    private javax.swing.JLabel lbChiTietPhieuTraHang_trangThai;
    private javax.swing.JLabel lbHoaDonChiTiet_error;
    private javax.swing.JTable tbChiTietPhieuTraHang_danhSachChiTietPhieuTraHang;
    // End of variables declaration//GEN-END:variables
}
