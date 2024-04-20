/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.KhachHang;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import src.Model.KhachHang;
import src.Service.KhachHangService;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_ThemKhachHang extends javax.swing.JFrame {
    private Util util = new Util();
    private KhachHangService khachHangService = new KhachHangService();
    /**
     * Creates new form frame_ThemKhachHang
     */
    public Frame_ThemKhachHang() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int soLuongKhachHang = 0;
        try {
            soLuongKhachHang = khachHangService.demSoKhachHang();
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ThemKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        soLuongKhachHang = soLuongKhachHang + 1;
        tfThemKhachHang_maKhachHang.setText("KH0" + soLuongKhachHang);
        tfThemKhachHang_maKhachHang.setEnabled(false);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel88 = new javax.swing.JPanel();
        jPanel87 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        btnThemKhachHang_luu = new javax.swing.JButton();
        jPanel93 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        radioThemKhachHang_nu = new javax.swing.JRadioButton();
        radioThemKhachHang_nam = new javax.swing.JRadioButton();
        dateChooserThemKhachHang_ngaySinh = new com.toedter.calendar.JDateChooser();
        jPanel94 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        tfThemKhachHang_maKhachHang = new javax.swing.JTextField();
        jPanel95 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        tfThemKhachHang_tenKhachHang = new javax.swing.JTextField();
        jPanel96 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        tfThemKhachHang_diaChi = new javax.swing.JTextField();
        jPanel97 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        tfThemKhachHang_dienThoai = new javax.swing.JTextField();
        jPanel100 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        radioThemKhachHang_caNhan = new javax.swing.JRadioButton();
        radioThemKhachHang_congTy = new javax.swing.JRadioButton();
        jPanel113 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        tfThemKhachHang_email = new javax.swing.JTextField();
        jPanel128 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        tfThemKhachHang_maSoThue = new javax.swing.JTextField();
        btnThemKhachHang_boQua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel88.setBackground(new java.awt.Color(255, 255, 255));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel87.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(153, 153, 153));
        jLabel68.setText("Chi nhánh tạo:");

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(153, 153, 153));
        jLabel69.setText("Chi nhánh trung tâm");

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel69)
                .addGap(0, 70, Short.MAX_VALUE))
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 290, 30));

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(204, 204, 204)));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel67.setText("Thêm khách hàng");
        jPanel86.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jPanel88.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 6, 130, 30));

        btnThemKhachHang_luu.setBackground(new java.awt.Color(0, 102, 255));
        btnThemKhachHang_luu.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnThemKhachHang_luu.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKhachHang_luu.setText("Lưu");
        btnThemKhachHang_luu.setBorder(null);
        btnThemKhachHang_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHang_luuActionPerformed(evt);
            }
        });
        jPanel88.add(btnThemKhachHang_luu, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 100, 31));

        jPanel93.setBackground(new java.awt.Color(255, 255, 255));
        jPanel93.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel71.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel71.setText("Ngày sinh");

        buttonGroup1.add(radioThemKhachHang_nu);
        radioThemKhachHang_nu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        radioThemKhachHang_nu.setText("Nữ");

        buttonGroup1.add(radioThemKhachHang_nam);
        radioThemKhachHang_nam.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        radioThemKhachHang_nam.setText("Nam");

        dateChooserThemKhachHang_ngaySinh.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(dateChooserThemKhachHang_ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioThemKhachHang_nam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioThemKhachHang_nu)
                .addContainerGap())
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioThemKhachHang_nu)
                    .addComponent(dateChooserThemKhachHang_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel71)
                        .addComponent(radioThemKhachHang_nam)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 370, 40));

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel72.setText("Mã khách hàng");

        tfThemKhachHang_maKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfThemKhachHang_maKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfThemKhachHang_maKhachHang.setEnabled(false);

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfThemKhachHang_maKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(tfThemKhachHang_maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 48, 370, 30));

        jPanel95.setBackground(new java.awt.Color(255, 255, 255));
        jPanel95.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel79.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel79.setText("Tên khách hàng");

        tfThemKhachHang_tenKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfThemKhachHang_tenKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfThemKhachHang_tenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(tfThemKhachHang_tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 370, 30));

        jPanel96.setBackground(new java.awt.Color(255, 255, 255));
        jPanel96.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel80.setBackground(new java.awt.Color(255, 255, 255));
        jLabel80.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel80.setText("Địa chỉ");

        tfThemKhachHang_diaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfThemKhachHang_diaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfThemKhachHang_diaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(tfThemKhachHang_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 370, 30));

        jPanel97.setBackground(new java.awt.Color(255, 255, 255));
        jPanel97.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel81.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel81.setText("Điện thoại");

        tfThemKhachHang_dienThoai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfThemKhachHang_dienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfThemKhachHang_dienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(tfThemKhachHang_dienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 370, 40));

        jPanel100.setBackground(new java.awt.Color(255, 255, 255));
        jPanel100.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel84.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel84.setText("Loại khách");

        buttonGroup2.add(radioThemKhachHang_caNhan);
        radioThemKhachHang_caNhan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        radioThemKhachHang_caNhan.setText("Cá nhân");

        buttonGroup2.add(radioThemKhachHang_congTy);
        radioThemKhachHang_congTy.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        radioThemKhachHang_congTy.setText("Công ty");

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioThemKhachHang_caNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioThemKhachHang_congTy, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(radioThemKhachHang_caNhan)
                    .addComponent(radioThemKhachHang_congTy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 370, 30));

        jPanel113.setBackground(new java.awt.Color(255, 255, 255));
        jPanel113.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel86.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel86.setText("Email");

        tfThemKhachHang_email.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfThemKhachHang_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfThemKhachHang_email, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(tfThemKhachHang_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 370, 40));

        jPanel128.setBackground(new java.awt.Color(255, 255, 255));
        jPanel128.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel90.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel90.setText("Mã số thuế");

        tfThemKhachHang_maSoThue.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfThemKhachHang_maSoThue.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel128Layout = new javax.swing.GroupLayout(jPanel128);
        jPanel128.setLayout(jPanel128Layout);
        jPanel128Layout.setHorizontalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfThemKhachHang_maSoThue, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel128Layout.setVerticalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(tfThemKhachHang_maSoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel88.add(jPanel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 370, 30));

        btnThemKhachHang_boQua.setBackground(new java.awt.Color(255, 153, 153));
        btnThemKhachHang_boQua.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnThemKhachHang_boQua.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKhachHang_boQua.setText("Thoát");
        btnThemKhachHang_boQua.setBorder(null);
        btnThemKhachHang_boQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHang_boQuaActionPerformed(evt);
            }
        });
        jPanel88.add(btnThemKhachHang_boQua, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, 100, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel88, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel88, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKhachHang_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHang_luuActionPerformed
                                                          
        KhachHang khachHang = new KhachHang();
        khachHang.setMaKhachHang(tfThemKhachHang_maKhachHang.getText());
        khachHang.setDiaChi(tfThemKhachHang_diaChi.getText());
        khachHang.setEmail(tfThemKhachHang_email.getText());
        khachHang.setMaSoThue(tfThemKhachHang_maSoThue.getText());
        khachHang.setNgaySinh(util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserThemKhachHang_ngaySinh.getDate())));
        khachHang.setNgayTao(LocalDateTime.now());
        khachHang.setSoDienThoai(tfThemKhachHang_dienThoai.getText());
        khachHang.setTenKhachHang(tfThemKhachHang_tenKhachHang.getText());
        khachHang.setMaNhanVien("NV004");
        khachHang.setMaChiNhanh("CN001");
        if (radioThemKhachHang_nam.isSelected()){
            khachHang.setGioiTinh("Nam");
        } else {
            khachHang.setGioiTinh("Nữ");
        }
        if (radioThemKhachHang_congTy.isSelected()){
            khachHang.setLoaiKhach("Công ty");
        } else {
            khachHang.setLoaiKhach("Cá nhân");
        }
        try {
            khachHangService.themKhachHang(khachHang);
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ThemKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnThemKhachHang_luuActionPerformed

    private void btnThemKhachHang_boQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHang_boQuaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThemKhachHang_boQuaActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_ThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_ThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_ThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_ThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_ThemKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemKhachHang_boQua;
    private javax.swing.JButton btnThemKhachHang_luu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser dateChooserThemKhachHang_ngaySinh;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JRadioButton radioThemKhachHang_caNhan;
    private javax.swing.JRadioButton radioThemKhachHang_congTy;
    private javax.swing.JRadioButton radioThemKhachHang_nam;
    private javax.swing.JRadioButton radioThemKhachHang_nu;
    private javax.swing.JTextField tfThemKhachHang_diaChi;
    private javax.swing.JTextField tfThemKhachHang_dienThoai;
    private javax.swing.JTextField tfThemKhachHang_email;
    private javax.swing.JTextField tfThemKhachHang_maKhachHang;
    private javax.swing.JTextField tfThemKhachHang_maSoThue;
    private javax.swing.JTextField tfThemKhachHang_tenKhachHang;
    // End of variables declaration//GEN-END:variables
}
