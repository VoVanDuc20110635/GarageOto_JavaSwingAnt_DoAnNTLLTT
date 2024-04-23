/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.NhanVien;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import src.Model.BangLuong;
import src.Model.BangLuongNhanVien;
import src.Model.CaLam;
import src.Model.ChiNhanh;
import src.Model.CongViec;
import src.Model.HinhAnh;
import src.Model.LichLamViec;
import src.Model.LichLamViecCaLam;
import src.Model.NhanVien;
import src.Model.PhieuLuong;
import src.Model.PhieuNhapHang;
import src.Service.BangLuongNhanVienService;
import src.Service.BangLuongService;
import src.Service.CaLamService;
import src.Service.ChiNhanhServive;
import src.Service.CongViecService;
import src.Service.HinhAnhService;
import src.Service.LichLamViecCaLamService;
import src.Service.LichLamViecService;
import src.Service.NhanVienService;
import src.Service.PhieuLuongService;
import src.UI.HangHoa.Frame_ThemHangHoa;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_ChiTietNhanVien extends javax.swing.JFrame {
    private NhanVien nhanVien;
    private ChiNhanh chiNhanh;
    private NhanVienService nhanVienService = new NhanVienService();
    private ChiNhanhServive chiNhanhService = new ChiNhanhServive();
    private CongViecService congViecService = new CongViecService();
    private HinhAnhService hinhAnhService = new HinhAnhService();
    
    private LichLamViecService lichLamViecService = new LichLamViecService();
    private BangLuongService bangLuongService = new BangLuongService();
    private PhieuLuongService phieuLuongService = new PhieuLuongService();
    private BangLuongNhanVienService bangLuongNhanVienService = new BangLuongNhanVienService();
    private LichLamViecCaLamService  lichLamViecCaLamService = new LichLamViecCaLamService();
    private CaLamService caLamService = new CaLamService();
    String destinationFolderPath = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\Git_GarageOtoAnt_DoAn\\GarageOto_JavaSwingAnt\\DoAn_GarageOto_Ant\\src\\image";
    private String imageLink = "";
            
    private Util util = new Util();
    /**
     * Creates new form frame_ThemKhachHang
     */
    public Frame_ChiTietNhanVien(NhanVien nhanVien, ChiNhanh chiNhanh) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.nhanVien = nhanVien;
        this.chiNhanh = chiNhanh;
        try {
            List<ChiNhanh> danhSachChiNhanh = chiNhanhService.hienThiTatCaChiNhanh();
            cbChiTietNhanVien_chiNhanhLamViec.removeAllItems();
            for (ChiNhanh chiNhanhItem: danhSachChiNhanh){
                cbChiTietNhanVien_chiNhanhLamViec.addItem(chiNhanhItem.getMaChiNhanh() + " " + chiNhanhItem.getTenChiNhanh());
            }
            List<CongViec> danhSachCongViec = congViecService.hienThiTatCaCongViec();
            cbChiTietNhanVien_chucDanh.removeAllItems();
            for (CongViec congViec: danhSachCongViec){
                cbChiTietNhanVien_chucDanh.addItem(congViec.getMaCongViec() + " " + congViec.getTenCongViec());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbChiTietNhanVien_tenChiNhanh.setText(chiNhanh.getTenChiNhanh());
        tfChiTietNhanVien_ma.setText(nhanVien.getMaNhanVien());
        tfChiTietNhanVien_cccd.setText(nhanVien.getCccd());
        tfChiTietNhanVien_diaChi.setText(nhanVien.getDiaChi());
        tfChiTietNhanVien_maSoThue.setText(nhanVien.getMaSoThue());
        tfChiTietNhanVien_soDienThoai.setText(nhanVien.getSoDienThoai());
        tfChiTietNhanVien_ten.setText(nhanVien.getTenNhanVien());
        
        if(nhanVien.getGioiTinh().equals("Nam")){
            radioChiTietNhanVien_nam.setSelected(true);
        } else {
            radioChiTietNhanVien_nu.setSelected(true);
        }
        dateChooserChiTietNhanVien_ngaySinh.setDate(util.layNgayDate(nhanVien.getNgaySinh().toString()));
        try {
            cbChiTietNhanVien_chiNhanhLamViec.setSelectedItem(chiNhanhService.hienThiChiNhanhTheoMaChiNhanh(nhanVien.getMaChiNhanh()).getTenChiNhanh());
            CongViec congViec = congViecService.hienThiCongViecTheoMaCongViec(nhanVien.getChucDanh());
            cbChiTietNhanVien_chucDanh.setSelectedItem(congViec.getMaCongViec() + " " + congViec.getTenCongViec());
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HinhAnh hinhAnhNhanVien;
        try {
            hinhAnhNhanVien = hinhAnhService.hienThiHinhAnhTheoMaNhanVien(nhanVien.getMaNhanVien());
            imageLink = hinhAnhNhanVien.getTenHinh();
            if (imageLink != null ){
                if (!imageLink.equals("")){
                    imageLink = destinationFolderPath + "\\" + imageLink;
                    lbChiTietNhanVien_anh.setIcon(null);
                    File file;
                    try {
                        file = new File(imageLink);
                        BufferedImage originalImage = ImageIO.read(file);
                        Image scaledImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(scaledImage);
                        lbChiTietNhanVien_anh.setIcon(icon);

                    } catch (MalformedURLException ex) {
                        Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        cbChiTietNhanVien_trangThai.setSelectedItem(nhanVien.getTrangThai());
        lbChiTietNhanVien_tenChiNhanh.setEnabled(false);
        tfChiTietNhanVien_ma.setEnabled(false);
        tfChiTietNhanVien_cccd.setEnabled(false);
        tfChiTietNhanVien_diaChi.setEnabled(false);
        tfChiTietNhanVien_maSoThue.setEnabled(false);
        tfChiTietNhanVien_soDienThoai.setEnabled(false);
        tfChiTietNhanVien_ten.setEnabled(false);
        radioChiTietNhanVien_nam.setEnabled(false);
        radioChiTietNhanVien_nu.setEnabled(false);
        dateChooserChiTietNhanVien_ngaySinh.setEnabled(false);
        cbChiTietNhanVien_chiNhanhLamViec.setEnabled(false);
        cbChiTietNhanVien_chucDanh.setEnabled(false);
        cbChiTietNhanVien_trangThai.setEnabled(false);
        btnChiTietNhanVien_chonAnh.setEnabled(false);
        
        
    }

    public Frame_ChiTietNhanVien() {
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
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
        btnGroup_gioiTinh = new javax.swing.ButtonGroup();
        tabbedPane_chiTietNhanVien = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel89 = new javax.swing.JPanel();
        jPanel90 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        lbChiTietNhanVien_tenChiNhanh = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        panelAnh = new javax.swing.JPanel();
        lbChiTietNhanVien_anh = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        radioChiTietNhanVien_nu = new javax.swing.JRadioButton();
        radioChiTietNhanVien_nam = new javax.swing.JRadioButton();
        dateChooserChiTietNhanVien_ngaySinh = new com.toedter.calendar.JDateChooser();
        jPanel94 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        tfChiTietNhanVien_ma = new javax.swing.JTextField();
        jPanel95 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        tfChiTietNhanVien_ten = new javax.swing.JTextField();
        jPanel96 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        tfChiTietNhanVien_diaChi = new javax.swing.JTextField();
        jPanel97 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        tfChiTietNhanVien_soDienThoai = new javax.swing.JTextField();
        jPanel98 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        tfChiTietNhanVien_cccd = new javax.swing.JTextField();
        jPanel99 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        cbChiTietNhanVien_chucDanh = new javax.swing.JComboBox<>();
        jPanel112 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        cbChiTietNhanVien_chiNhanhLamViec = new javax.swing.JComboBox<>();
        panelhihi = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        tfChiTietNhanVien_maSoThue = new javax.swing.JTextField();
        btnChiTietNhanVien_chonAnh = new javax.swing.JButton();
        btnChiTietNhanVien_capNhat = new javax.swing.JButton();
        btnChiTietNhanVien_thoat = new javax.swing.JButton();
        jPanel100 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        cbChiTietNhanVien_trangThai = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbChiTietNhanVien_lichLamViec = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChiTietNhanVien_lichTangCa = new javax.swing.JTable();
        btnChiTietNhanVien_lichNghi = new javax.swing.JButton();
        btnChiTietNhanVien_lichTangCa = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbChiTietNhanVien_phieuLuong = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbChiTietNhanVien_bangLuong = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbChiTietNhanVien_phuCap = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPane_chiTietNhanVien.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPane_chiTietNhanVienStateChanged(evt);
            }
        });

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel90.setBackground(new java.awt.Color(255, 255, 255));

        jLabel73.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(153, 153, 153));
        jLabel73.setText("Chi nhánh tạo:");

        lbChiTietNhanVien_tenChiNhanh.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietNhanVien_tenChiNhanh.setForeground(new java.awt.Color(153, 153, 153));
        lbChiTietNhanVien_tenChiNhanh.setText("Chi nhánh trung tâm");

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbChiTietNhanVien_tenChiNhanh, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbChiTietNhanVien_tenChiNhanh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 390, 30));

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(204, 204, 204)));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel67.setText("Thông tin nhân viên");
        jPanel86.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        jPanel89.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 6, 150, 30));

        javax.swing.GroupLayout panelAnhLayout = new javax.swing.GroupLayout(panelAnh);
        panelAnh.setLayout(panelAnhLayout);
        panelAnhLayout.setHorizontalGroup(
            panelAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbChiTietNhanVien_anh, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panelAnhLayout.setVerticalGroup(
            panelAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbChiTietNhanVien_anh, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel89.add(panelAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 48, 80, 80));

        jPanel93.setBackground(new java.awt.Color(255, 255, 255));
        jPanel93.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel71.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel71.setText("Ngày sinh");

        btnGroup_gioiTinh.add(radioChiTietNhanVien_nu);
        radioChiTietNhanVien_nu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        radioChiTietNhanVien_nu.setText("Nữ");

        btnGroup_gioiTinh.add(radioChiTietNhanVien_nam);
        radioChiTietNhanVien_nam.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        radioChiTietNhanVien_nam.setText("Nam");

        dateChooserChiTietNhanVien_ngaySinh.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(dateChooserChiTietNhanVien_ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioChiTietNhanVien_nam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioChiTietNhanVien_nu)
                .addContainerGap())
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioChiTietNhanVien_nu)
                    .addComponent(dateChooserChiTietNhanVien_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel71)
                        .addComponent(radioChiTietNhanVien_nam)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 370, 40));

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel72.setText("Mã nhân viên");

        tfChiTietNhanVien_ma.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfChiTietNhanVien_ma.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfChiTietNhanVien_ma.setText("NV000006");
        tfChiTietNhanVien_ma.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietNhanVien_ma, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(tfChiTietNhanVien_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 48, 370, 30));

        jPanel95.setBackground(new java.awt.Color(255, 255, 255));
        jPanel95.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel79.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel79.setText("Tên nhân viên");

        tfChiTietNhanVien_ten.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfChiTietNhanVien_ten.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfChiTietNhanVien_ten.setText(" võ văn đức");
        tfChiTietNhanVien_ten.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietNhanVien_ten, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(tfChiTietNhanVien_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 370, 30));

        jPanel96.setBackground(new java.awt.Color(255, 255, 255));
        jPanel96.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel80.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel80.setText("Địa chỉ");

        tfChiTietNhanVien_diaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfChiTietNhanVien_diaChi.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfChiTietNhanVien_diaChi.setText("thôn 1");
        tfChiTietNhanVien_diaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietNhanVien_diaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(tfChiTietNhanVien_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 370, 30));

        jPanel97.setBackground(new java.awt.Color(255, 255, 255));
        jPanel97.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel81.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel81.setText("Điện thoại");

        tfChiTietNhanVien_soDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfChiTietNhanVien_soDienThoai.setText(" 01343278192");
        tfChiTietNhanVien_soDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietNhanVien_soDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(tfChiTietNhanVien_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 370, 40));

        jPanel98.setBackground(new java.awt.Color(255, 255, 255));
        jPanel98.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel82.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel82.setText("CMND/CCCD");

        tfChiTietNhanVien_cccd.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfChiTietNhanVien_cccd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfChiTietNhanVien_cccd.setText("65101065031");
        tfChiTietNhanVien_cccd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(tfChiTietNhanVien_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(tfChiTietNhanVien_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 370, 30));

        jPanel99.setBackground(new java.awt.Color(255, 255, 255));
        jPanel99.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel83.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel83.setText("Chức danh");

        cbChiTietNhanVien_chucDanh.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbChiTietNhanVien_chucDanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên sơn", "Nhân viên sữa chữa", "Nhân viên kỹ thuật", "Bảo vệ", "Kế toán viên", "Admin" }));

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(cbChiTietNhanVien_chucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(cbChiTietNhanVien_chucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 370, 40));

        jPanel112.setBackground(new java.awt.Color(255, 255, 255));
        jPanel112.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel85.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel85.setText("Chi nhánh làm việc");

        cbChiTietNhanVien_chiNhanhLamViec.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel85)
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel112Layout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(cbChiTietNhanVien_chiNhanhLamViec, 0, 215, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel85)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel112Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(cbChiTietNhanVien_chiNhanhLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel89.add(jPanel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 370, 40));

        panelhihi.setBackground(new java.awt.Color(255, 255, 255));
        panelhihi.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel90.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel90.setText("Mã số thuế");

        tfChiTietNhanVien_maSoThue.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfChiTietNhanVien_maSoThue.setText(" 04986532");
        tfChiTietNhanVien_maSoThue.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout panelhihiLayout = new javax.swing.GroupLayout(panelhihi);
        panelhihi.setLayout(panelhihiLayout);
        panelhihiLayout.setHorizontalGroup(
            panelhihiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelhihiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(tfChiTietNhanVien_maSoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelhihiLayout.setVerticalGroup(
            panelhihiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelhihiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelhihiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(tfChiTietNhanVien_maSoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(panelhihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 370, 30));

        btnChiTietNhanVien_chonAnh.setBackground(new java.awt.Color(0, 51, 255));
        btnChiTietNhanVien_chonAnh.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnChiTietNhanVien_chonAnh.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietNhanVien_chonAnh.setText("Chọn ảnh");
        btnChiTietNhanVien_chonAnh.setBorder(null);
        btnChiTietNhanVien_chonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietNhanVien_chonAnhActionPerformed(evt);
            }
        });
        jPanel89.add(btnChiTietNhanVien_chonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 31));

        btnChiTietNhanVien_capNhat.setBackground(new java.awt.Color(0, 204, 0));
        btnChiTietNhanVien_capNhat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietNhanVien_capNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietNhanVien_capNhat.setText("Cập nhật");
        btnChiTietNhanVien_capNhat.setBorder(null);
        btnChiTietNhanVien_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietNhanVien_capNhatActionPerformed(evt);
            }
        });
        jPanel89.add(btnChiTietNhanVien_capNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 100, 31));

        btnChiTietNhanVien_thoat.setBackground(new java.awt.Color(51, 51, 255));
        btnChiTietNhanVien_thoat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietNhanVien_thoat.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietNhanVien_thoat.setText("Thoát");
        btnChiTietNhanVien_thoat.setBorder(null);
        btnChiTietNhanVien_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietNhanVien_thoatActionPerformed(evt);
            }
        });
        jPanel89.add(btnChiTietNhanVien_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 100, 31));

        jPanel100.setBackground(new java.awt.Color(255, 255, 255));
        jPanel100.setPreferredSize(new java.awt.Dimension(450, 100));

        jLabel84.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel84.setText("Trạng thái");

        cbChiTietNhanVien_trangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbChiTietNhanVien_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm việc", "Ngừng làm việc" }));

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(cbChiTietNhanVien_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(cbChiTietNhanVien_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel89.add(jPanel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 370, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel89, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel89, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tabbedPane_chiTietNhanVien.addTab("Thông tin", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbChiTietNhanVien_lichLamViec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày bắt đầu", "Ngày kết thúc", "Ca làm", "Trạng thái", "Ghi chú"
            }
        ));
        jScrollPane2.setViewportView(tbChiTietNhanVien_lichLamViec);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane_chiTietNhanVien.addTab("Lịch làm việc", jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbChiTietNhanVien_lichTangCa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbChiTietNhanVien_lichTangCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lịch làm việc", "Ngày", "Ghi chú", "Số giờ tăng ca", "Trạng thái"
            }
        ));
        tbChiTietNhanVien_lichTangCa.setRowHeight(30);
        jScrollPane1.setViewportView(tbChiTietNhanVien_lichTangCa);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 59, 930, 310));

        btnChiTietNhanVien_lichNghi.setBackground(new java.awt.Color(0, 51, 255));
        btnChiTietNhanVien_lichNghi.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietNhanVien_lichNghi.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietNhanVien_lichNghi.setText("Lịch nghỉ");
        btnChiTietNhanVien_lichNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietNhanVien_lichNghiActionPerformed(evt);
            }
        });
        jPanel7.add(btnChiTietNhanVien_lichNghi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        btnChiTietNhanVien_lichTangCa.setBackground(new java.awt.Color(255, 153, 153));
        btnChiTietNhanVien_lichTangCa.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietNhanVien_lichTangCa.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietNhanVien_lichTangCa.setText("Lịch tăng ca");
        btnChiTietNhanVien_lichTangCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietNhanVien_lichTangCaActionPerformed(evt);
            }
        });
        jPanel7.add(btnChiTietNhanVien_lichTangCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 30));

        tabbedPane_chiTietNhanVien.addTab("Lịch nghỉ và lịch tăng ca", jPanel7);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbChiTietNhanVien_phieuLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu", "Ngày in", "Tổng lương", "Đã trả", "Nợ", "Nhân viên tạo"
            }
        ));
        jScrollPane3.setViewportView(tbChiTietNhanVien_phieuLuong);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Tổng nợ:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(111, 111, 111)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        tabbedPane_chiTietNhanVien.addTab("Phiếu lương", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbChiTietNhanVien_bangLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã bảng lương", "Tiền lương", "Chế độ lương", "Nội dung"
            }
        ));
        jScrollPane4.setViewportView(tbChiTietNhanVien_bangLuong);

        tbChiTietNhanVien_phuCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phụ cấp", "Tiền phụ cấp", "Chế độ lương", "Nội dung"
            }
        ));
        jScrollPane5.setViewportView(tbChiTietNhanVien_phuCap);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(124, 124, 124))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabbedPane_chiTietNhanVien.addTab("Bảng lương", jPanel3);

        getContentPane().add(tabbedPane_chiTietNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 4, 950, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChiTietNhanVien_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietNhanVien_thoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnChiTietNhanVien_thoatActionPerformed

    private void btnChiTietNhanVien_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietNhanVien_capNhatActionPerformed
        if(btnChiTietNhanVien_capNhat.getText().equals("Cập nhật")){
            btnChiTietNhanVien_capNhat.setText("Lưu");
            lbChiTietNhanVien_tenChiNhanh.setEnabled(true);
            tfChiTietNhanVien_cccd.setEnabled(true);
            tfChiTietNhanVien_diaChi.setEnabled(true);
            tfChiTietNhanVien_maSoThue.setEnabled(true);
            tfChiTietNhanVien_soDienThoai.setEnabled(true);
            tfChiTietNhanVien_ten.setEnabled(true);
            radioChiTietNhanVien_nam.setEnabled(true);
            radioChiTietNhanVien_nu.setEnabled(true);
            dateChooserChiTietNhanVien_ngaySinh.setEnabled(true);
            cbChiTietNhanVien_chiNhanhLamViec.setEnabled(true);
            cbChiTietNhanVien_chucDanh.setEnabled(true);
            cbChiTietNhanVien_trangThai.setEnabled(true);
            btnChiTietNhanVien_chonAnh.setEnabled(true);
            
            
        } else {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNhanVien(tfChiTietNhanVien_ma.getText());
            nhanVien.setCccd(tfChiTietNhanVien_cccd.getText());
            nhanVien.setChucDanh(cbChiTietNhanVien_chucDanh.getSelectedItem().toString().split(" ")[0]);
            if (radioChiTietNhanVien_nam.isSelected()){
                nhanVien.setGioiTinh("Nam");
            } else {
                nhanVien.setGioiTinh("Nữ");
            }
            nhanVien.setNgaySinh(util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserChiTietNhanVien_ngaySinh.getDate())));
            nhanVien.setSoDienThoai(tfChiTietNhanVien_soDienThoai.getText());
            nhanVien.setTenNhanVien(tfChiTietNhanVien_ten.getText());
            nhanVien.setTrangThai(cbChiTietNhanVien_trangThai.getSelectedItem().toString());
            nhanVien.setMaChiNhanh(cbChiTietNhanVien_chiNhanhLamViec.getSelectedItem().toString().split(" ")[0]);
//            nhanVien.setTaoBoiMaNhanVien("NV004");
//            nhanVien.setMaLichLamViec("LLV001");
//            nhanVien.setNoLuong(0);
            nhanVien.setDiaChi(tfChiTietNhanVien_diaChi.getText());
            nhanVien.setMaSoThue(tfChiTietNhanVien_maSoThue.getText());
            try {
                nhanVienService.capNhatNhanVienTaiTrangThongtinChiTiet(nhanVien);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (lbChiTietNhanVien_anh.getIcon() != null){
                saveImage(imageLink, destinationFolderPath);
                HinhAnh hinhAnh = new HinhAnh();
                try {
                    int temp = hinhAnhService.demSoHinhAnh() + 1;
                    hinhAnh.setMaHinhAnh("HA0"+ temp);
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_ThemHangHoa.class.getName()).log(Level.SEVERE, null, ex);
                }
                hinhAnh.setNoiDung(nhanVien.getTenNhanVien());
                String[] parts = imageLink.split("\\\\");
                hinhAnh.setTenHinh(parts[parts.length - 1]);
                hinhAnh.setMaNhanVien(nhanVien.getMaNhanVien());
                try {
                    HinhAnh hinhAnhDb = hinhAnhService.hienThiHinhAnhTheoMaNhanVien(nhanVien.getMaNhanVien());
                    if (hinhAnhDb.getMaHinhAnh() == null){
                        hinhAnhService.themHinhAnh(hinhAnh);
                    } else {
                        hinhAnh.setMaHinhAnh(hinhAnhDb.getMaHinhAnh());
                        hinhAnhService.updateHinhAnh(hinhAnh);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_ThemHangHoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            btnChiTietNhanVien_capNhat.setText("Cập nhật");
            lbChiTietNhanVien_tenChiNhanh.setEnabled(false);
            tfChiTietNhanVien_ma.setEnabled(false);
            tfChiTietNhanVien_cccd.setEnabled(false);
            tfChiTietNhanVien_diaChi.setEnabled(false);
            tfChiTietNhanVien_maSoThue.setEnabled(false);
            tfChiTietNhanVien_soDienThoai.setEnabled(false);
            tfChiTietNhanVien_ten.setEnabled(false);
            radioChiTietNhanVien_nam.setEnabled(false);
            radioChiTietNhanVien_nu.setEnabled(false);
            dateChooserChiTietNhanVien_ngaySinh.setEnabled(false);
            cbChiTietNhanVien_chiNhanhLamViec.setEnabled(false);
            cbChiTietNhanVien_chucDanh.setEnabled(false);
            cbChiTietNhanVien_trangThai.setEnabled(false);
            btnChiTietNhanVien_chonAnh.setEnabled(false);
        }
    }//GEN-LAST:event_btnChiTietNhanVien_capNhatActionPerformed
    public void saveImage(String sourceImagePath, String destinationFolderPath) {
        try {
            // Create a Path object for the source image
            Path sourcePath = Paths.get(sourceImagePath);

            // Create a Path object for the destination folder
            Path destinationFolder = Paths.get(destinationFolderPath);

            // Ensure the destination folder exists, create it if it doesn't
            Files.createDirectories(destinationFolder);

            // Get the file name of the source image
            String fileName = sourcePath.getFileName().toString();

            // Create a Path object for the destination image file
            Path destinationFilePath = destinationFolder.resolve(fileName);

            // Copy the source image file to the destination folder
            Files.copy(sourcePath, destinationFilePath);

            System.out.println("Image saved successfully to: " + destinationFilePath);
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }
    private void btnChiTietNhanVien_chonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietNhanVien_chonAnhActionPerformed
        layTenFile();
        lbChiTietNhanVien_anh.setIcon(null);
        File file;
        try {
            file = new File(imageLink);
            BufferedImage originalImage = ImageIO.read(file);
            Image scaledImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            lbChiTietNhanVien_anh.setIcon(icon);

        } catch (MalformedURLException ex) {
            Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnChiTietNhanVien_chonAnhActionPerformed

    private void tabbedPane_chiTietNhanVienStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPane_chiTietNhanVienStateChanged
        int index = tabbedPane_chiTietNhanVien.getSelectedIndex();
        if (index == 1){
            try {
                List<LichLamViec> danhSachLichLamViec = lichLamViecService.hienThiLichLamViecTheoMaNhanVien(nhanVien.getMaNhanVien());
                for (LichLamViec lichLamViec: danhSachLichLamViec){
                    List<LichLamViecCaLam> danhSachLamViecCaLam = lichLamViecCaLamService.hienThiTatCaLichLamViecCaLamTheoMaLichLamViec(lichLamViec.getMaLichLamViec());
                    for (LichLamViecCaLam lichLamViecCaLam: danhSachLamViecCaLam){
                        lichLamViec.getDanhSachCaLam().add(caLamService.hienThiCaLamTheoMaCaLam(lichLamViecCaLam.getMaCaLam()));
                    }
                }
                DefaultTableModel recordTable = (DefaultTableModel)tbChiTietNhanVien_lichLamViec.getModel();
                recordTable.setRowCount(0);
                for (LichLamViec lichLamViec : danhSachLichLamViec){
                    Vector columnData = new Vector();
                    columnData.add(String.valueOf(lichLamViec.getNgayBatDau()));
                    columnData.add(String.valueOf(lichLamViec.getNgayKetThuc()));
                    String danhSachTenCaLam = "";
                    for (int i =0; i< lichLamViec.getDanhSachCaLam().size(); i++){
                        danhSachTenCaLam += lichLamViec.getDanhSachCaLam().get(i).getTenCaLam();
                        if (i != lichLamViec.getDanhSachCaLam().size()-1){
                            danhSachTenCaLam += ", ";
                        }
                    }
                    columnData.add(danhSachTenCaLam);
                    columnData.add(lichLamViec.getTrangThai());
                    columnData.add(lichLamViec.getGhiChu());
                    recordTable.addRow(columnData);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (index == 2){
            try {
                List<LichLamViec> danhSachLichNghi = lichLamViecService.hienThiLichNghiTheoMaNhanVien(nhanVien.getMaNhanVien());
                List<LichLamViec> danhSachLichTangCa = lichLamViecService.hienThiLichTangCaTheoMaNhanVien(nhanVien.getMaNhanVien());
                DefaultTableModel recordTable = (DefaultTableModel)tbChiTietNhanVien_lichTangCa.getModel();
                recordTable.setRowCount(0);
                for (LichLamViec lichLamViec : danhSachLichNghi){
                    Vector columnData = new Vector();
                    columnData.add(String.valueOf(lichLamViec.getMaLichLamViec()));
                    columnData.add(String.valueOf(lichLamViec.getNgayBatDau()));
                    columnData.add(lichLamViec.getGhiChu());
                    columnData.add("");
                    columnData.add(lichLamViec.getTrangThai());
                    recordTable.addRow(columnData);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (index == 3){
            try {
                List<PhieuLuong> danhSachPhieuLuong = phieuLuongService.hienThiPhieuLuongTheoMaNhanVien(nhanVien.getMaNhanVien());
                DefaultTableModel recordTable = (DefaultTableModel)tbChiTietNhanVien_phieuLuong.getModel();
                recordTable.setRowCount(0);
                for (PhieuLuong phieuLuong : danhSachPhieuLuong){
                    Vector columnData = new Vector();
                    columnData.add(phieuLuong.getMaPhieu());
                    columnData.add(util.localDateParseMethod(phieuLuong.getNgayIn()));
                    columnData.add(phieuLuong.getTongLuong());
                    columnData.add(phieuLuong.getDaTra());
                    columnData.add(phieuLuong.getTongLuong() - phieuLuong.getDaTra());
                    columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(phieuLuong.getMaNhanVienIn()).getTenNhanVien());
                    recordTable.addRow(columnData);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (index == 4){
            List<BangLuong> danhSachBangLuong =  new ArrayList<>();
            try {
                List<BangLuongNhanVien> danhSachBangLuongNhanVien  = bangLuongNhanVienService.hienThiBangLuongNhanVienTheoMaNhanVien(nhanVien.getMaNhanVien());
                for (BangLuongNhanVien bangLuongNhanVien : danhSachBangLuongNhanVien){
                    BangLuong bangLuong = bangLuongService.hienThiBangLuongTheoMaBangLuong(bangLuongNhanVien.getMaBangLuong());
                    danhSachBangLuong.add(bangLuong);
                }
                DefaultTableModel recordTable = (DefaultTableModel)tbChiTietNhanVien_bangLuong.getModel();
                DefaultTableModel recordTable2 = (DefaultTableModel)tbChiTietNhanVien_phuCap.getModel();        
                recordTable.setRowCount(0);
                recordTable2.setRowCount(0);
                for (BangLuong bangLuong: danhSachBangLuong){
                    if (bangLuong.getMaBangLuong().contains("BL")){
                        Vector columnData = new Vector();
                        columnData.add(bangLuong.getMaBangLuong());
                        columnData.add(bangLuong.getTienLuong());
                        columnData.add(bangLuong.getCheDoLuong());
                        columnData.add(bangLuong.getNoiDung());
                        recordTable.addRow(columnData);
                    }
                    if (!bangLuong.getMaBangLuong().contains("BL")){
                        Vector columnData = new Vector();
                        columnData.add(bangLuong.getMaBangLuong());
                        columnData.add(bangLuong.getTienLuong());
                        columnData.add(bangLuong.getCheDoLuong());
                        columnData.add(bangLuong.getNoiDung());
                        recordTable2.addRow(columnData);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_tabbedPane_chiTietNhanVienStateChanged

    private void btnChiTietNhanVien_lichNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietNhanVien_lichNghiActionPerformed
        try {
            List<LichLamViec> danhSachLichNghi = lichLamViecService.hienThiLichNghiTheoMaNhanVien(nhanVien.getMaNhanVien());
            DefaultTableModel recordTable = (DefaultTableModel)tbChiTietNhanVien_lichTangCa.getModel();
            recordTable.setRowCount(0);
            for (LichLamViec lichLamViec : danhSachLichNghi){
                Vector columnData = new Vector();
                columnData.add(String.valueOf(lichLamViec.getMaLichLamViec()));
                columnData.add(String.valueOf(lichLamViec.getNgayBatDau()));
                columnData.add(lichLamViec.getGhiChu());
                columnData.add("");
                columnData.add(lichLamViec.getTrangThai());
                recordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChiTietNhanVien_lichNghiActionPerformed

    private void btnChiTietNhanVien_lichTangCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietNhanVien_lichTangCaActionPerformed
        try {
            List<LichLamViec> danhSachLichTangCa = lichLamViecService.hienThiLichTangCaTheoMaNhanVien(nhanVien.getMaNhanVien());
            DefaultTableModel recordTable = (DefaultTableModel)tbChiTietNhanVien_lichTangCa.getModel();
            recordTable.setRowCount(0);
            for (LichLamViec lichLamViec : danhSachLichTangCa){
                Vector columnData = new Vector();
                columnData.add(String.valueOf(lichLamViec.getMaLichLamViec()));
                columnData.add(String.valueOf(lichLamViec.getNgayBatDau()));
                columnData.add(lichLamViec.getGhiChu());
                columnData.add(lichLamViec.getTangCa());
                columnData.add(lichLamViec.getTrangThai());
                recordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChiTietNhanVien_lichTangCaActionPerformed
    private void layTenFile(){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("", "jpg"));
        chooser.setFileFilter(chooser.getChoosableFileFilters()[1]);
        int r = chooser.showDialog(this,null);
        if (r!= JFileChooser.APPROVE_OPTION) return;
        File file = new File(chooser.getSelectedFile() + chooser.getFileFilter().getDescription());
        imageLink = file.getPath();
    }
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
            java.util.logging.Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_ChiTietNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Frame_ChiTietNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietNhanVien_capNhat;
    private javax.swing.JButton btnChiTietNhanVien_chonAnh;
    private javax.swing.JButton btnChiTietNhanVien_lichNghi;
    private javax.swing.JButton btnChiTietNhanVien_lichTangCa;
    private javax.swing.JButton btnChiTietNhanVien_thoat;
    private javax.swing.ButtonGroup btnGroup_gioiTinh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbChiTietNhanVien_chiNhanhLamViec;
    private javax.swing.JComboBox<String> cbChiTietNhanVien_chucDanh;
    private javax.swing.JComboBox<String> cbChiTietNhanVien_trangThai;
    private com.toedter.calendar.JDateChooser dateChooserChiTietNhanVien_ngaySinh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbChiTietNhanVien_anh;
    private javax.swing.JLabel lbChiTietNhanVien_tenChiNhanh;
    private javax.swing.JPanel panelAnh;
    private javax.swing.JPanel panelhihi;
    private javax.swing.JRadioButton radioChiTietNhanVien_nam;
    private javax.swing.JRadioButton radioChiTietNhanVien_nu;
    private javax.swing.JTabbedPane tabbedPane_chiTietNhanVien;
    private javax.swing.JTable tbChiTietNhanVien_bangLuong;
    private javax.swing.JTable tbChiTietNhanVien_lichLamViec;
    private javax.swing.JTable tbChiTietNhanVien_lichTangCa;
    private javax.swing.JTable tbChiTietNhanVien_phieuLuong;
    private javax.swing.JTable tbChiTietNhanVien_phuCap;
    private javax.swing.JTextField tfChiTietNhanVien_cccd;
    private javax.swing.JTextField tfChiTietNhanVien_diaChi;
    private javax.swing.JTextField tfChiTietNhanVien_ma;
    private javax.swing.JTextField tfChiTietNhanVien_maSoThue;
    private javax.swing.JTextField tfChiTietNhanVien_soDienThoai;
    private javax.swing.JTextField tfChiTietNhanVien_ten;
    // End of variables declaration//GEN-END:variables
}
