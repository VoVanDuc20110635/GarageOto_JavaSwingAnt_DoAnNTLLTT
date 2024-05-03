/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.HoaDon;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import src.Model.ChiNhanh;
import src.Model.ChiTietPhieuTraHang;
import src.Model.NhanVien;
import src.Model.PhieuTraHang;
import src.Service.ChiNhanhServive;
import src.Service.ChiTietPhieuTraHangService;
import src.Service.HangHoaService;
import src.Service.PhieuTraHangService;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_TienThanhToanTraHang extends javax.swing.JFrame {
    private JTable tbDanhSachSanPhamTraHang;
    private double tongTienHang;
    private short soLuongHang;
    private String maHoaDon;
    private String maKhachHang;
    private String maNhanVien;
    private String maNhaCungCap;
    private String maPhieuNhapHang;
    private NhanVien nhanVienDangNhap;
    
    private PhieuTraHangService phieuTraHangService = new PhieuTraHangService();
    private ChiTietPhieuTraHangService chiTietPhieuTraHangService = new ChiTietPhieuTraHangService();
    private HangHoaService hangHoaService = new HangHoaService();
    private ChiNhanhServive chiNhanhServive = new ChiNhanhServive();
    private Util util = new Util();
    /**
     * Creates new form TienThanhToanTraHang
     */
    public Frame_TienThanhToanTraHang() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Frame_TienThanhToanTraHang(JTable tbDanhSachSanPhamTraHang, double tongTienHang, short soLuongHang, String maHoaDon, String maKhachHang, String maNhanVien) {
        this.tbDanhSachSanPhamTraHang = tbDanhSachSanPhamTraHang;
        this.tongTienHang = tongTienHang;
        this.soLuongHang = soLuongHang;
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        initComponents();
        btnTienThanhToanTraHang_traHang.setVisible(false);
        this.tongTienHang = tinhTongTienHangTraLai();
        lbTienThanhToanTraHang_tongTienHang.setText(String.valueOf(this.tongTienHang));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public Frame_TienThanhToanTraHang( String maPhieuNhapHang, String maNhaCungCap, String maNhanVien, JTable tbDanhSachSanPhamTraHang, NhanVien nhanVienDangNhap) {
        this.tbDanhSachSanPhamTraHang = tbDanhSachSanPhamTraHang;
        this.maPhieuNhapHang = maPhieuNhapHang;
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
        this.nhanVienDangNhap = nhanVienDangNhap;
        initComponents();
        btnTienThanhToanTraHang_traHang.setVisible(false);
        this.tongTienHang = tinhTongTienHangTraLai();
        lbTienThanhToanTraHang_tongTienHang.setText(String.valueOf(this.tongTienHang));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
    }
    
    
    private void thanhToan(){
        try {
            PhieuTraHang phieuTraHang = new PhieuTraHang();
            int tongSoPhieuTraHang = 0;
            try {
                tongSoPhieuTraHang = phieuTraHangService.demSoPhieuTraHang() + 1;
            } catch (SQLException ex) {
                Logger.getLogger(Frame_HoaDonChiTiet.class.getName()).log(Level.SEVERE, null, ex);
            }
            phieuTraHang.setMaPhieuTraHang("PTH0" + tongSoPhieuTraHang);
            phieuTraHang.setCanTra(Double.parseDouble(lbTienThanhToanTraHang_tongTienHang.getText()));
            phieuTraHang.setDaTra(Double.parseDouble(tfTienThanhToanTraHang_khachThanhToan.getText()));
//        String localDateTimeNow = util.localDateParseMethod(LocalDateTime.now());
phieuTraHang.setThoiGian(LocalDateTime.now());
if (this.maPhieuNhapHang == null){
    phieuTraHang.setMaHoaDon(maHoaDon);
} else {
    phieuTraHang.setMaPhieuNhapHang(maPhieuNhapHang);
}

phieuTraHang.setMaKhachHang(maKhachHang);
phieuTraHang.setMaNhaCungCap(maNhaCungCap);
phieuTraHang.setMaNhanVien(maNhanVien);
phieuTraHang.setTrangThai("Đã xử lý");
ChiNhanh chiNhanh = chiNhanhServive.hienThiChiNhanhTheoMaChiNhanh(nhanVienDangNhap.getMaNhanVien());
phieuTraHang.setMaChiNhanh(chiNhanh.getMaChiNhanh());
try {
    if (this.maPhieuNhapHang == null){
        phieuTraHangService.themPhieuTraHangKhachHang(phieuTraHang);
    } else {
        phieuTraHangService.themPhieuTraHangDonNhapHang(phieuTraHang);
    }
} catch (SQLException ex) {
    Logger.getLogger(Frame_TienThanhToanTraHang.class.getName()).log(Level.SEVERE, null, ex);
}
TableModel model = tbDanhSachSanPhamTraHang.getModel();
for (int i =0 ; i < model.getRowCount(); i++){
    try {
        ChiTietPhieuTraHang chiTietPhieuTraHang = new ChiTietPhieuTraHang();
        int j = i + 1;
        chiTietPhieuTraHang.setMaChiTietPhieuTraHang(phieuTraHang.getMaPhieuTraHang() + "CTPTH" + j);
        chiTietPhieuTraHang.setGiaTraHang(Double.parseDouble(model.getValueAt(i, 2).toString()));
        chiTietPhieuTraHang.setSoLuong(Short.parseShort(model.getValueAt(i, 3).toString()));
        chiTietPhieuTraHang.setThanhTien(Double.parseDouble(model.getValueAt(i, 2).toString()) * Short.parseShort(model.getValueAt(i, 3).toString()) );
        chiTietPhieuTraHang.setMaHangHoa(model.getValueAt(i, 0).toString());
        chiTietPhieuTraHang.setTenHangHoa(model.getValueAt(i, 1).toString());
        chiTietPhieuTraHang.setMaPhieuTraHang(phieuTraHang.getMaPhieuTraHang());
        if (model.getValueAt(i, 4).toString().equals("Lỗi")){
            chiTietPhieuTraHang.setLoi(true);
        } else {
            chiTietPhieuTraHang.setLoi(false);
        }
        chiTietPhieuTraHangService.themChiTietPhieuTraHang(chiTietPhieuTraHang);
    } catch (SQLException ex) {
        Logger.getLogger(Frame_TienThanhToanTraHang.class.getName()).log(Level.SEVERE, null, ex);
    }
}
        } catch (SQLException ex) {
            Logger.getLogger(Frame_TienThanhToanTraHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double tinhTongTienHangTraLai(){
        double tongTienTraHang = 0;
        TableModel model = tbDanhSachSanPhamTraHang.getModel();
        for (int i =0; i< model.getRowCount(); i++){
            tongTienTraHang += Double.parseDouble(model.getValueAt(i, 2).toString()) * Short.parseShort(model.getValueAt(i, 3).toString());
        }
        return tongTienTraHang;
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
        jPanel120 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        tfTienThanhToanTraHang_khachThanhToan = new javax.swing.JTextField();
        jPanel122 = new javax.swing.JPanel();
        lbTienThanhToanTraHang_tienThua = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        lbTienThanhToanTraHang_tongTienHang = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jPanel160 = new javax.swing.JPanel();
        btnTienThanhToanTraHang_traHang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel120.setBackground(new java.awt.Color(255, 255, 255));

        jLabel112.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel112.setText("Khách thanh toán");

        tfTienThanhToanTraHang_khachThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfTienThanhToanTraHang_khachThanhToan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTienThanhToanTraHang_khachThanhToan.setText("0");
        tfTienThanhToanTraHang_khachThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfTienThanhToanTraHang_khachThanhToan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfTienThanhToanTraHang_khachThanhToanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTienThanhToanTraHang_khachThanhToanFocusLost(evt);
            }
        });
        tfTienThanhToanTraHang_khachThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTienThanhToanTraHang_khachThanhToanKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel112)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(tfTienThanhToanTraHang_khachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel120Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(tfTienThanhToanTraHang_khachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jPanel122.setBackground(new java.awt.Color(255, 255, 255));

        lbTienThanhToanTraHang_tienThua.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbTienThanhToanTraHang_tienThua.setForeground(new java.awt.Color(0, 102, 255));
        lbTienThanhToanTraHang_tienThua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTienThanhToanTraHang_tienThua.setText("0");

        jLabel150.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel150.setText("Tiền thừa");

        javax.swing.GroupLayout jPanel122Layout = new javax.swing.GroupLayout(jPanel122);
        jPanel122.setLayout(jPanel122Layout);
        jPanel122Layout.setHorizontalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel122Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel150)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(lbTienThanhToanTraHang_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel122Layout.setVerticalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel122Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTienThanhToanTraHang_tienThua)
                    .addComponent(jLabel150))
                .addContainerGap())
        );

        jPanel1.add(jPanel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 330, 30));

        jPanel118.setBackground(new java.awt.Color(255, 255, 255));

        lbTienThanhToanTraHang_tongTienHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbTienThanhToanTraHang_tongTienHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTienThanhToanTraHang_tongTienHang.setText("0");

        jLabel109.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel109.setText("Tổng tiền hàng");

        jPanel160.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel118Layout = new javax.swing.GroupLayout(jPanel118);
        jPanel118.setLayout(jPanel118Layout);
        jPanel118Layout.setHorizontalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel109)
                .addGap(18, 18, 18)
                .addComponent(jPanel160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(lbTienThanhToanTraHang_tongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel118Layout.setVerticalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel118Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTienThanhToanTraHang_tongTienHang)
                        .addComponent(jLabel109)))
                .addContainerGap())
        );

        jPanel1.add(jPanel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 30));

        btnTienThanhToanTraHang_traHang.setBackground(new java.awt.Color(0, 51, 255));
        btnTienThanhToanTraHang_traHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnTienThanhToanTraHang_traHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTienThanhToanTraHang_traHang.setText("Trả hàng");
        btnTienThanhToanTraHang_traHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienThanhToanTraHang_traHangActionPerformed(evt);
            }
        });
        jPanel1.add(btnTienThanhToanTraHang_traHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfTienThanhToanTraHang_khachThanhToanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTienThanhToanTraHang_khachThanhToanFocusGained
        if (tfTienThanhToanTraHang_khachThanhToan.getText().equals("0")){
            tfTienThanhToanTraHang_khachThanhToan.setText("");
        }
    }//GEN-LAST:event_tfTienThanhToanTraHang_khachThanhToanFocusGained

    private void tfTienThanhToanTraHang_khachThanhToanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTienThanhToanTraHang_khachThanhToanFocusLost
        if (tfTienThanhToanTraHang_khachThanhToan.getText().equals("")){
            tfTienThanhToanTraHang_khachThanhToan.setText("0");
        }
    }//GEN-LAST:event_tfTienThanhToanTraHang_khachThanhToanFocusLost

    private void tfTienThanhToanTraHang_khachThanhToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTienThanhToanTraHang_khachThanhToanKeyReleased
        double tienCanTra = Double.parseDouble(lbTienThanhToanTraHang_tongTienHang.getText());
        double tienThanhToan = Double.parseDouble(tfTienThanhToanTraHang_khachThanhToan.getText());
        if (tienThanhToan >= tienCanTra){
            btnTienThanhToanTraHang_traHang.setVisible(true);
        }
        lbTienThanhToanTraHang_tienThua.setText(String.valueOf(tienThanhToan - tienCanTra));
    }//GEN-LAST:event_tfTienThanhToanTraHang_khachThanhToanKeyReleased

    private void btnTienThanhToanTraHang_traHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienThanhToanTraHang_traHangActionPerformed
        
        TableModel model = tbDanhSachSanPhamTraHang.getModel();
        for (int i =0 ; i < model.getRowCount(); i++){
            hangHoaService.updateSoLuongTonKhoHangHoa(model.getValueAt(i, 0).toString(), Short.parseShort(model.getValueAt(i, 3).toString()));
        }
        thanhToan();
    }//GEN-LAST:event_btnTienThanhToanTraHang_traHangActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_TienThanhToanTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_TienThanhToanTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_TienThanhToanTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_TienThanhToanTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_TienThanhToanTraHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTienThanhToanTraHang_traHang;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel160;
    private javax.swing.JLabel lbTienThanhToanTraHang_tienThua;
    private javax.swing.JLabel lbTienThanhToanTraHang_tongTienHang;
    private javax.swing.JTextField tfTienThanhToanTraHang_khachThanhToan;
    // End of variables declaration//GEN-END:variables
}
