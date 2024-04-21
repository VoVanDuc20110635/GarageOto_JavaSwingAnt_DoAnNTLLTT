/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.ChiNhanh;
import src.UI.NhaCungCap.*;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import src.Model.ChiNhanh;
import src.Model.NhaCungCap;
import src.Service.ChiNhanhServive;
import src.Service.NhaCungCapService;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_XemChiTietCapNhatChiNhanh extends javax.swing.JFrame {
    private Util util = new Util();
    private ChiNhanhServive chiNhanhService = new ChiNhanhServive();
    private ChiNhanh chiNhanh;

    /**
     * Creates new form frame_ThemNhaCungCap
     */
    public Frame_XemChiTietCapNhatChiNhanh(ChiNhanh chiNhanh) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.chiNhanh = chiNhanh;
        tfXemChiNhanh_ma.setEnabled(false);
        tfXemChiNhanh_soDienThoai.setEnabled(false);
        tfXemChiNhanh_ten.setEnabled(false);
        tareXemChiNhanh_diaChi.setEnabled(false);
        cbXemChiNhanh_trangThai.setEnabled(false);
        
        tfXemChiNhanh_ma.setText(chiNhanh.getMaChiNhanh());
        tfXemChiNhanh_soDienThoai.setText(chiNhanh.getSoDienThoai());
        tfXemChiNhanh_ten.setText(chiNhanh.getTenChiNhanh());
        tareXemChiNhanh_diaChi.setText(chiNhanh.getDiaChi());
        cbXemChiNhanh_trangThai.setSelectedItem(chiNhanh.getTrangThai().toString());
    }

    public Frame_XemChiTietCapNhatChiNhanh() {
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel88 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        btnXemChiNhanh_luu = new javax.swing.JButton();
        jPanel94 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        tfXemChiNhanh_ma = new javax.swing.JTextField();
        jPanel95 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        tfXemChiNhanh_ten = new javax.swing.JTextField();
        jPanel113 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        tfXemChiNhanh_soDienThoai = new javax.swing.JTextField();
        jPanel128 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        cbXemChiNhanh_trangThai = new javax.swing.JComboBox<>();
        btnXemChiNhanh_thoat = new javax.swing.JButton();
        jPanel114 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tareXemChiNhanh_diaChi = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel88.setBackground(new java.awt.Color(255, 255, 255));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel67.setText("Thông tin chi nhánh");
        jPanel86.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 30));

        jPanel88.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 6, 200, 30));

        btnXemChiNhanh_luu.setBackground(new java.awt.Color(0, 102, 255));
        btnXemChiNhanh_luu.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnXemChiNhanh_luu.setForeground(new java.awt.Color(255, 255, 255));
        btnXemChiNhanh_luu.setText("Cập nhật");
        btnXemChiNhanh_luu.setBorder(null);
        btnXemChiNhanh_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiNhanh_luuActionPerformed(evt);
            }
        });
        jPanel88.add(btnXemChiNhanh_luu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 100, 31));

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel72.setText("Mã chi nhánh");

        tfXemChiNhanh_ma.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfXemChiNhanh_ma.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(tfXemChiNhanh_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(tfXemChiNhanh_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 370, 30));

        jPanel95.setBackground(new java.awt.Color(255, 255, 255));
        jPanel95.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel79.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel79.setText("Tên chi nhánh");

        tfXemChiNhanh_ten.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfXemChiNhanh_ten.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfXemChiNhanh_ten, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(tfXemChiNhanh_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 370, 30));

        jPanel113.setBackground(new java.awt.Color(255, 255, 255));
        jPanel113.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel86.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel86.setText("Số điện thoại");

        tfXemChiNhanh_soDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfXemChiNhanh_soDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfXemChiNhanh_soDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(tfXemChiNhanh_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 370, 40));

        jPanel128.setBackground(new java.awt.Color(255, 255, 255));
        jPanel128.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel90.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel90.setText("Trạng thái");

        cbXemChiNhanh_trangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbXemChiNhanh_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Ngừng hoạt động" }));

        javax.swing.GroupLayout jPanel128Layout = new javax.swing.GroupLayout(jPanel128);
        jPanel128.setLayout(jPanel128Layout);
        jPanel128Layout.setHorizontalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbXemChiNhanh_trangThai, 0, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel128Layout.setVerticalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addComponent(cbXemChiNhanh_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 370, 30));

        btnXemChiNhanh_thoat.setBackground(new java.awt.Color(153, 153, 153));
        btnXemChiNhanh_thoat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnXemChiNhanh_thoat.setForeground(new java.awt.Color(255, 255, 255));
        btnXemChiNhanh_thoat.setText("Thoát");
        btnXemChiNhanh_thoat.setBorder(null);
        btnXemChiNhanh_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiNhanh_thoatActionPerformed(evt);
            }
        });
        jPanel88.add(btnXemChiNhanh_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 100, 31));

        jPanel114.setBackground(new java.awt.Color(255, 255, 255));
        jPanel114.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel87.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel87.setText("Địa chỉ");

        tareXemChiNhanh_diaChi.setColumns(20);
        tareXemChiNhanh_diaChi.setLineWrap(true);
        tareXemChiNhanh_diaChi.setRows(5);
        jScrollPane1.setViewportView(tareXemChiNhanh_diaChi);

        javax.swing.GroupLayout jPanel114Layout = new javax.swing.GroupLayout(jPanel114);
        jPanel114.setLayout(jPanel114Layout);
        jPanel114Layout.setHorizontalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel114Layout.setVerticalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 370, 100));

        getContentPane().add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 833, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//    int a = 0;
    private void btnXemChiNhanh_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiNhanh_thoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnXemChiNhanh_thoatActionPerformed

    private void btnXemChiNhanh_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiNhanh_luuActionPerformed
        if (btnXemChiNhanh_luu.getText().equals("Cập nhật")){
            btnXemChiNhanh_luu.setText("Lưu");
            tfXemChiNhanh_soDienThoai.setEnabled(true);
            tfXemChiNhanh_ten.setEnabled(true);
            tareXemChiNhanh_diaChi.setEnabled(true);
            cbXemChiNhanh_trangThai.setEnabled(true);
        } else {
            ChiNhanh chiNhanh = new ChiNhanh();
            chiNhanh.setMaChiNhanh(tfXemChiNhanh_ma.getText());
            chiNhanh.setDiaChi(tareXemChiNhanh_diaChi.getText());
            chiNhanh.setSoDienThoai(tfXemChiNhanh_soDienThoai.getText());
            chiNhanh.setTenChiNhanh(tfXemChiNhanh_ten.getText());
            chiNhanh.setTrangThai(cbXemChiNhanh_trangThai.getSelectedItem().toString());
            try {
                chiNhanhService.capNhatChiNhanh(chiNhanh);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_XemChiTietCapNhatChiNhanh.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            tfXemChiNhanh_ma.setEnabled(false);
            tfXemChiNhanh_soDienThoai.setEnabled(false);
            tfXemChiNhanh_ten.setEnabled(false);
            tareXemChiNhanh_diaChi.setEnabled(false);
            cbXemChiNhanh_trangThai.setEnabled(false);
        }
        
    }//GEN-LAST:event_btnXemChiNhanh_luuActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_XemChiTietCapNhatChiNhanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_XemChiTietCapNhatChiNhanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_XemChiTietCapNhatChiNhanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_XemChiTietCapNhatChiNhanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Frame_XemChiTietCapNhatChiNhanh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXemChiNhanh_luu;
    private javax.swing.JButton btnXemChiNhanh_thoat;
    private javax.swing.JComboBox<String> cbXemChiNhanh_trangThai;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tareXemChiNhanh_diaChi;
    private javax.swing.JTextField tfXemChiNhanh_ma;
    private javax.swing.JTextField tfXemChiNhanh_soDienThoai;
    private javax.swing.JTextField tfXemChiNhanh_ten;
    // End of variables declaration//GEN-END:variables
}
