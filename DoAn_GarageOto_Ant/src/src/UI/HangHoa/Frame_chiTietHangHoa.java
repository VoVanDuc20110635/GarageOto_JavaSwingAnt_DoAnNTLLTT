/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.HangHoa;

import java.awt.Color;
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
import src.Model.ChiTietPhieuNhapHang;
import src.Model.HangHoa;
import src.Model.HinhAnh;
import src.Model.NhomHang;
import src.Model.TheKho;
import src.Service.HangHoaService;
import src.Service.HinhAnhService;
import src.Service.KhachHangService;
import src.Service.NhaCungCapService;
import src.Service.NhanVienService;
import src.Service.NhomHangService;
import src.Service.TheKhoService;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_chiTietHangHoa extends javax.swing.JFrame {

    /**
     * Creates new form Frame_chiTietHangHoa
     */
    private HangHoa hangHoa;
    private HangHoaService hangHoaService = new HangHoaService();
    private NhomHangService nhomHangService = new NhomHangService();
    private TheKhoService theKhoService = new TheKhoService();
    private HinhAnhService hinhAnhService = new HinhAnhService();
    private List<HinhAnh> danhSachHinhAnh = new ArrayList<>();
    private NhanVienService nhanVienService = new NhanVienService();
    private KhachHangService khachHangService = new KhachHangService();
    private NhaCungCapService nhaCungCapService = new NhaCungCapService();
    private Util util = new Util();
    List<String> danhSachLinkHinhAnh = new ArrayList<>();
    List<String> danhSachLinkMoiHinhAnh = new ArrayList<>();
    List<TheKho> danhSachTheKho = new ArrayList<>();
    String destinationFolderPath = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\Git_GarageOtoAnt_DoAn\\GarageOto_JavaSwingAnt\\DoAn_GarageOto_Ant\\src\\image";
    public Frame_chiTietHangHoa() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            hienThiDanhSachMaNhomHang();
        } catch (SQLException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            hienThiThongTin();
        } catch (IOException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public Frame_chiTietHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            hienThiDanhSachMaNhomHang();
        } catch (SQLException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            hienThiThongTin();
        } catch (SQLException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void hienThiThongTin() throws SQLException, IOException{
        danhSachHinhAnh = hinhAnhService.hienThiTatCaHinhAnhTheoMaHangHoa(this.hangHoa.getMaHangHoa());
        lbChiTietHangHoa_tenHangHoa.setText(hangHoa.getTenHangHoa());
        tfChiTietHangHang_maHangHoa.setText(hangHoa.getMaHangHoa());
        tfChiTietHangHang_tenHangHoa.setText(hangHoa.getTenHangHoa());
        for (int i = 0; i < cbChiTietHangHang_dichVuLienQuan.getItemCount(); i++) {
            String item = cbChiTietHangHang_dichVuLienQuan.getItemAt(i).toString();
            if (item.contains(hangHoa.getMaNhomHang())) {
                cbChiTietHangHang_dichVuLienQuan.setSelectedItem(item);
                break;
            }
        }

        tfChiTietHangHang_giaBan.setText(String.valueOf(hangHoa.getGiaBan()));
        tfChiTietHangHang_giaVon.setText(String.valueOf(hangHoa.getGiaVon()));
        tfChiTietHangHang_tonKho.setText(String.valueOf(hangHoa.getTonKho()));
        tfChiTietHangHang_loaiHang.setText(String.valueOf(hangHoa.getLoaiHang()));
        tfChiTietHangHang_khachDat.setText(String.valueOf(hangHoa.getKhachDat()));
        if (hangHoa.getTrangThai() == 1){
            cbChiTietHangHang_trangThai.setSelectedItem("Còn bán");
        }
        if (hangHoa.getTrangThai() == 2){
            cbChiTietHangHang_trangThai.setSelectedItem("Ngưng bán");
        }
        
        
        for (HinhAnh hinhAnh : danhSachHinhAnh){
            danhSachLinkHinhAnh.add(destinationFolderPath + "\\" + hinhAnh.getTenHinh());
            danhSachLinkMoiHinhAnh.add("");
        }
        hienThiHanhAnh(danhSachLinkHinhAnh);
        lbChiTietHangHang_hinhAnh0.setIcon(null);
        File file = new File(danhSachLinkHinhAnh.get(0));
        BufferedImage originalImage = ImageIO.read(file);
        Image scaledImage = originalImage.getScaledInstance(284, 284, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        lbChiTietHangHang_hinhAnh0.setIcon(icon);
        
        btnChiTietHangHoa_thayHinh1.setVisible(false);
        btnChiTietHangHoa_thayHinh2.setVisible(false);
        btnChiTietHangHoa_thayHinh3.setVisible(false);
    }
    
    private void hienThiHanhAnh(List<String> danhSachLinkHinhAnh){
        lbChiTietHinhAnh_hinhAnh1.setIcon(null);
        lbChiTietHinhAnh_hinhAnh2.setIcon(null);
        lbChiTietHinhAnh_hinhAnh3.setIcon(null);
        String lb_hienThiHinhAnh = "lbChiTietHinhAnh_hinhAnh";
        int i =1;
        for(String linkHinhAnh : danhSachLinkHinhAnh){
            File file;
            try {
                file = new File(linkHinhAnh);
                BufferedImage originalImage = ImageIO.read(file);
                Image scaledImage = originalImage.getScaledInstance(88, 67, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                if (i == 1){
                    lbChiTietHinhAnh_hinhAnh1.setIcon(icon);
                }
                if (i == 2){
                    lbChiTietHinhAnh_hinhAnh2.setIcon(icon);
                }
                if (i == 3){
                    lbChiTietHinhAnh_hinhAnh3.setIcon(icon);
                }
                
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(Frame_ThemHangHoa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Frame_ThemHangHoa.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }
    
    private void hienThiDanhSachMaNhomHang() throws SQLException{
        List<NhomHang> danhSachNhomHang = new ArrayList<>();
        cbChiTietHangHang_dichVuLienQuan.removeAllItems();
        danhSachNhomHang = nhomHangService.hienThiTatCaNhomHang();
        for (NhomHang nhomHang : danhSachNhomHang){
            cbChiTietHangHang_dichVuLienQuan.addItem(nhomHang.getMaNhomHang() + " " + nhomHang.getTenNhomHang());
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

        jPanel45 = new javax.swing.JPanel();
        tabbedPaneChiTietHangHoa_theKho = new javax.swing.JTabbedPane();
        jPanel38 = new javax.swing.JPanel();
        lbChiTietHangHoa_tenHangHoa = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        lbChiTietHangHang_hinhAnh0 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        lbChiTietHinhAnh_hinhAnh2 = new javax.swing.JLabel();
        lbChiTietHinhAnh_hinhAnh3 = new javax.swing.JLabel();
        lbChiTietHinhAnh_hinhAnh1 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        tfChiTietHangHang_khachDat = new javax.swing.JTextField();
        jPanel52 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        cbChiTietHangHang_dichVuLienQuan = new javax.swing.JComboBox<>();
        jPanel53 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        tfChiTietHangHang_tenHangHoa = new javax.swing.JTextField();
        jPanel54 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        tfChiTietHangHang_loaiHang = new javax.swing.JTextField();
        jPanel57 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        tfChiTietHangHang_giaBan = new javax.swing.JTextField();
        jPanel58 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        tfChiTietHangHang_giaVon = new javax.swing.JTextField();
        jPanel59 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        tfChiTietHangHang_tonKho = new javax.swing.JTextField();
        jPanel60 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        tfChiTietHangHang_maHangHoa = new javax.swing.JTextField();
        btnChiTietHangHoa_huyBo = new javax.swing.JButton();
        btnChiTietHangHoa_ngungKinhDoanh = new javax.swing.JButton();
        jPanel55 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        cbChiTietHangHang_trangThai = new javax.swing.JComboBox<>();
        btnChiTietHangHoa_capNhat = new javax.swing.JButton();
        panelChiTietHangHoa_error = new javax.swing.JPanel();
        lbChiTietHangHoa_error = new javax.swing.JLabel();
        btnChiTietHangHoa_thayHinh3 = new javax.swing.JButton();
        btnChiTietHangHoa_thayHinh1 = new javax.swing.JButton();
        btnChiTietHangHoa_thayHinh2 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbChiTietHangHoa_theKho = new javax.swing.JTable();
        jPanel90 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        lbChiTietHangHoa_theKho_tongTonKho = new javax.swing.JLabel();
        btnChiTietHangHoa_theKho_xuatFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel45.setBackground(new java.awt.Color(209, 202, 202));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPaneChiTietHangHoa_theKho.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneChiTietHangHoa_theKhoStateChanged(evt);
            }
        });

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbChiTietHangHoa_tenHangHoa.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jPanel38.add(lbChiTietHangHoa_tenHangHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 6, 352, 30));

        jPanel40.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbChiTietHangHang_hinhAnh0, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbChiTietHangHang_hinhAnh0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel38.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 281));

        lbChiTietHinhAnh_hinhAnh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbChiTietHinhAnh_hinhAnh2MouseClicked(evt);
            }
        });

        lbChiTietHinhAnh_hinhAnh3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbChiTietHinhAnh_hinhAnh3MouseClicked(evt);
            }
        });

        lbChiTietHinhAnh_hinhAnh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbChiTietHinhAnh_hinhAnh1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbChiTietHinhAnh_hinhAnh2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addComponent(lbChiTietHinhAnh_hinhAnh3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addComponent(lbChiTietHinhAnh_hinhAnh1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(lbChiTietHinhAnh_hinhAnh1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lbChiTietHinhAnh_hinhAnh2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(lbChiTietHinhAnh_hinhAnh3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel38.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, 280));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel38.setText("Khách đặt:");

        tfChiTietHangHang_khachDat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfChiTietHangHang_khachDat.setEnabled(false);
        tfChiTietHangHang_khachDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChiTietHangHang_khachDatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietHangHang_khachDat, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(tfChiTietHangHang_khachDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 380, 30));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel40.setText("Dịch vụ liên quan:");

        cbChiTietHangHang_dichVuLienQuan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        cbChiTietHangHang_dichVuLienQuan.setEnabled(false);

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbChiTietHangHang_dichVuLienQuan, 0, 262, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(cbChiTietHangHang_dichVuLienQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 380, 30));

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel41.setText("Tên hàng hóa:");

        tfChiTietHangHang_tenHangHoa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfChiTietHangHang_tenHangHoa.setEnabled(false);

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addGap(34, 34, 34)
                .addComponent(tfChiTietHangHang_tenHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(tfChiTietHangHang_tenHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 380, 30));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel42.setText("Loại hàng:");

        tfChiTietHangHang_loaiHang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfChiTietHangHang_loaiHang.setEnabled(false);

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(tfChiTietHangHang_loaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(tfChiTietHangHang_loaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 380, 30));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel45.setText("Giá bán:");

        tfChiTietHangHang_giaBan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfChiTietHangHang_giaBan.setEnabled(false);
        tfChiTietHangHang_giaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChiTietHangHang_giaBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietHangHang_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(tfChiTietHangHang_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 380, 30));

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));
        jPanel58.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel46.setText("Giá vốn:");

        tfChiTietHangHang_giaVon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfChiTietHangHang_giaVon.setEnabled(false);
        tfChiTietHangHang_giaVon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChiTietHangHang_giaVonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietHangHang_giaVon, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(tfChiTietHangHang_giaVon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 380, 30));

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel47.setText("Tồn kho:");

        tfChiTietHangHang_tonKho.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfChiTietHangHang_tonKho.setEnabled(false);
        tfChiTietHangHang_tonKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfChiTietHangHang_tonKhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfChiTietHangHang_tonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(tfChiTietHangHang_tonKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 380, 30));

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel48.setText("Mã hàng:");

        tfChiTietHangHang_maHangHoa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfChiTietHangHang_maHangHoa.setEnabled(false);

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(tfChiTietHangHang_maHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(tfChiTietHangHang_maHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 380, 30));

        btnChiTietHangHoa_huyBo.setBackground(new java.awt.Color(255, 153, 153));
        btnChiTietHangHoa_huyBo.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietHangHoa_huyBo.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietHangHoa_huyBo.setText("Hủy bỏ");
        btnChiTietHangHoa_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietHangHoa_huyBoActionPerformed(evt);
            }
        });
        jPanel42.add(btnChiTietHangHoa_huyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, -1, -1));

        btnChiTietHangHoa_ngungKinhDoanh.setBackground(new java.awt.Color(255, 51, 51));
        btnChiTietHangHoa_ngungKinhDoanh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietHangHoa_ngungKinhDoanh.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietHangHoa_ngungKinhDoanh.setText("Ngừng kinh doanh");
        btnChiTietHangHoa_ngungKinhDoanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietHangHoa_ngungKinhDoanhActionPerformed(evt);
            }
        });
        jPanel42.add(btnChiTietHangHoa_ngungKinhDoanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 160, -1));

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel43.setText("Trạng thái:");

        cbChiTietHangHang_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn bán", "Ngưng bán" }));
        cbChiTietHangHang_trangThai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        cbChiTietHangHang_trangThai.setEnabled(false);

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(cbChiTietHangHang_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(cbChiTietHangHang_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 380, 30));

        btnChiTietHangHoa_capNhat.setBackground(new java.awt.Color(0, 204, 0));
        btnChiTietHangHoa_capNhat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietHangHoa_capNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietHangHoa_capNhat.setText("Cập nhật");
        btnChiTietHangHoa_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietHangHoa_capNhatActionPerformed(evt);
            }
        });
        jPanel42.add(btnChiTietHangHoa_capNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        panelChiTietHangHoa_error.setBackground(new java.awt.Color(255, 255, 255));

        lbChiTietHangHoa_error.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietHangHoa_error.setForeground(new java.awt.Color(255, 255, 255));
        lbChiTietHangHoa_error.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout panelChiTietHangHoa_errorLayout = new javax.swing.GroupLayout(panelChiTietHangHoa_error);
        panelChiTietHangHoa_error.setLayout(panelChiTietHangHoa_errorLayout);
        panelChiTietHangHoa_errorLayout.setHorizontalGroup(
            panelChiTietHangHoa_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbChiTietHangHoa_error, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        panelChiTietHangHoa_errorLayout.setVerticalGroup(
            panelChiTietHangHoa_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChiTietHangHoa_errorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbChiTietHangHoa_error, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel42.add(panelChiTietHangHoa_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 350, 30));

        jPanel38.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 870, 440));

        btnChiTietHangHoa_thayHinh3.setText("...");
        btnChiTietHangHoa_thayHinh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietHangHoa_thayHinh3ActionPerformed(evt);
            }
        });
        jPanel38.add(btnChiTietHangHoa_thayHinh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 40, -1));

        btnChiTietHangHoa_thayHinh1.setText("...");
        btnChiTietHangHoa_thayHinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietHangHoa_thayHinh1ActionPerformed(evt);
            }
        });
        jPanel38.add(btnChiTietHangHoa_thayHinh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 40, -1));

        btnChiTietHangHoa_thayHinh2.setText("...");
        btnChiTietHangHoa_thayHinh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietHangHoa_thayHinh2ActionPerformed(evt);
            }
        });
        jPanel38.add(btnChiTietHangHoa_thayHinh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 40, -1));

        tabbedPaneChiTietHangHoa_theKho.addTab("Thông tin", jPanel38);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));

        tbChiTietHangHoa_theKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thẻ kho", "Phương thức", "Thời gian", "Người thực hiện", "Đối tác", "Giá vốn", "Số lượng", "Tồn cuối"
            }
        ));
        jScrollPane9.setViewportView(tbChiTietHangHoa_theKho);

        jPanel90.setBackground(new java.awt.Color(255, 255, 255));

        jLabel73.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel73.setText("Tổng tồn kho");

        lbChiTietHangHoa_theKho_tongTonKho.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbChiTietHangHoa_theKho_tongTonKho.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbChiTietHangHoa_theKho_tongTonKho.setText("1");

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbChiTietHangHoa_theKho_tongTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbChiTietHangHoa_theKho_tongTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnChiTietHangHoa_theKho_xuatFile.setBackground(new java.awt.Color(102, 102, 102));
        btnChiTietHangHoa_theKho_xuatFile.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChiTietHangHoa_theKho_xuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietHangHoa_theKho_xuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exportFile.png"))); // NOI18N
        btnChiTietHangHoa_theKho_xuatFile.setText("Xuất file");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChiTietHangHoa_theKho_xuatFile))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChiTietHangHoa_theKho_xuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabbedPaneChiTietHangHoa_theKho.addTab("Thẻ kho", jPanel39);

        jPanel45.add(tabbedPaneChiTietHangHoa_theKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfChiTietHangHang_khachDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChiTietHangHang_khachDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChiTietHangHang_khachDatActionPerformed

    private void tfChiTietHangHang_giaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChiTietHangHang_giaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChiTietHangHang_giaBanActionPerformed

    private void tfChiTietHangHang_giaVonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChiTietHangHang_giaVonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChiTietHangHang_giaVonActionPerformed

    private void tfChiTietHangHang_tonKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfChiTietHangHang_tonKhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChiTietHangHang_tonKhoActionPerformed

    private void btnChiTietHangHoa_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietHangHoa_huyBoActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnChiTietHangHoa_huyBoActionPerformed

    private void btnChiTietHangHoa_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietHangHoa_capNhatActionPerformed

        if (btnChiTietHangHoa_capNhat.getText().equals("Cập nhật")){
//            tfChiTietHangHang_maHangHoa.setEnabled(true);
            tfChiTietHangHang_tenHangHoa.setEnabled(true);
            cbChiTietHangHang_dichVuLienQuan.setEnabled(true);

            tfChiTietHangHang_giaBan.setEnabled(true);
            tfChiTietHangHang_giaVon.setEnabled(true);
//            tfChiTietHangHang_tonKho.setEnabled(true);
            tfChiTietHangHang_loaiHang.setEnabled(true);
//            tfChiTietHangHang_khachDat.setEnabled(true);
            cbChiTietHangHang_trangThai.setEnabled(true);
            
            btnChiTietHangHoa_capNhat.setText("Lưu");
            btnChiTietHangHoa_thayHinh1.setVisible(true);
            btnChiTietHangHoa_thayHinh2.setVisible(true);
            btnChiTietHangHoa_thayHinh3.setVisible(true);
        } else {
            HangHoa hangHoaNew = new HangHoa();
            hangHoaNew.setMaHangHoa(tfChiTietHangHang_maHangHoa.getText());
            hangHoaNew.setTenHangHoa(tfChiTietHangHang_tenHangHoa.getText());
            hangHoaNew.setMaNhomHang(cbChiTietHangHang_dichVuLienQuan.getSelectedItem().toString().split(" ")[0]);
            hangHoaNew.setGiaBan(Double.parseDouble(tfChiTietHangHang_giaBan.getText()));
            hangHoaNew.setGiaVon(Double.parseDouble(tfChiTietHangHang_giaVon.getText()));
            hangHoaNew.setTonKho(Short.parseShort(tfChiTietHangHang_tonKho.getText()));
            hangHoaNew.setLoaiHang(tfChiTietHangHang_loaiHang.getText());
            hangHoaNew.setKhachDat(Short.parseShort( tfChiTietHangHang_khachDat.getText()));
            if (cbChiTietHangHang_trangThai.getSelectedItem().equals("Còn bán")){
                hangHoaNew.setTrangThai(1);
            } else {
                hangHoaNew.setTrangThai(0);
            }
            try {
                hangHoaService.updateHangHoa(hangHoaNew);
                lbChiTietHangHoa_error.setText("Cập nhật thành công");
                panelChiTietHangHoa_error.setBackground(Color.GREEN);
            } catch (SQLException ex) {
                lbChiTietHangHoa_error.setText("Cập nhật không thành công");
                panelChiTietHangHoa_error.setBackground(Color.RED);
            }
            btnChiTietHangHoa_capNhat.setText("Cập nhật");
            tfChiTietHangHang_maHangHoa.setEnabled(false);
            tfChiTietHangHang_tenHangHoa.setEnabled(false);
            cbChiTietHangHang_dichVuLienQuan.setEnabled(false);

            tfChiTietHangHang_giaBan.setEnabled(false);
            tfChiTietHangHang_giaVon.setEnabled(false);
            tfChiTietHangHang_tonKho.setEnabled(false);
            tfChiTietHangHang_loaiHang.setEnabled(false);
            tfChiTietHangHang_khachDat.setEnabled(false);
            cbChiTietHangHang_trangThai.setEnabled(false);
            btnChiTietHangHoa_thayHinh1.setVisible(false);
            btnChiTietHangHoa_thayHinh2.setVisible(false);
            btnChiTietHangHoa_thayHinh3.setVisible(false);
            
            int index = 0;
            for (HinhAnh hinhAnh : danhSachHinhAnh){
                if (!danhSachLinkMoiHinhAnh.get(index).equals("")){
                    deleteImage(danhSachLinkHinhAnh.get(index));
                }
                
                saveImage(danhSachLinkMoiHinhAnh.get(index), destinationFolderPath);
                try {
                    hinhAnhService.updateHinhAnh(hinhAnh);
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
                }
                index ++;
            }
        }
    }//GEN-LAST:event_btnChiTietHangHoa_capNhatActionPerformed

    private void btnChiTietHangHoa_ngungKinhDoanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietHangHoa_ngungKinhDoanhActionPerformed
        try {
            hangHoaService.updateTrangThaiHangHoa(tfChiTietHangHang_maHangHoa.getText(), 0);
            cbChiTietHangHang_trangThai.setSelectedItem("Ngưng bán");
            lbChiTietHangHoa_error.setText("Cập nhật thành công");
            panelChiTietHangHoa_error.setBackground(Color.GREEN);
            
            
        } catch (SQLException ex) {
            lbChiTietHangHoa_error.setText("Cập nhật không thành công");
            panelChiTietHangHoa_error.setBackground(Color.RED);
        }
    }//GEN-LAST:event_btnChiTietHangHoa_ngungKinhDoanhActionPerformed

    private void lbChiTietHinhAnh_hinhAnh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChiTietHinhAnh_hinhAnh1MouseClicked
        try {
            lbChiTietHangHang_hinhAnh0.setIcon(null);
            File file = new File(danhSachLinkHinhAnh.get(0));
            BufferedImage originalImage = ImageIO.read(file);
            Image scaledImage = originalImage.getScaledInstance(284, 284, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            lbChiTietHangHang_hinhAnh0.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbChiTietHinhAnh_hinhAnh1MouseClicked

    private void lbChiTietHinhAnh_hinhAnh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChiTietHinhAnh_hinhAnh2MouseClicked
        try {
            lbChiTietHangHang_hinhAnh0.setIcon(null);
            File file = new File(danhSachLinkHinhAnh.get(1));
            BufferedImage originalImage = ImageIO.read(file);
            Image scaledImage = originalImage.getScaledInstance(284, 284, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            lbChiTietHangHang_hinhAnh0.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbChiTietHinhAnh_hinhAnh2MouseClicked

    private void lbChiTietHinhAnh_hinhAnh3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChiTietHinhAnh_hinhAnh3MouseClicked
        try {
            lbChiTietHangHang_hinhAnh0.setIcon(null);
            File file = new File(danhSachLinkHinhAnh.get(2));
            BufferedImage originalImage = ImageIO.read(file);
            Image scaledImage = originalImage.getScaledInstance(284, 284, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            lbChiTietHangHang_hinhAnh0.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbChiTietHinhAnh_hinhAnh3MouseClicked

    private void btnChiTietHangHoa_thayHinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietHangHoa_thayHinh1ActionPerformed
        try {
            String linkHinhAnh = layTenFile();
            String[] parts = linkHinhAnh.split("\\\\");
            danhSachHinhAnh.get(0).setTenHinh(parts[parts.length - 1]);
            danhSachLinkMoiHinhAnh.set(0, linkHinhAnh);
            File file = new File(linkHinhAnh);
            BufferedImage originalImage = ImageIO.read(file);
            Image scaledImage = originalImage.getScaledInstance(88, 67, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            lbChiTietHinhAnh_hinhAnh1.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChiTietHangHoa_thayHinh1ActionPerformed

    private void btnChiTietHangHoa_thayHinh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietHangHoa_thayHinh2ActionPerformed
        try {
            String linkHinhAnh = layTenFile();
            String[] parts = linkHinhAnh.split("\\\\");
            danhSachHinhAnh.get(1).setTenHinh(parts[parts.length - 1]);
            danhSachLinkMoiHinhAnh.set(1, linkHinhAnh);
            File file = new File(linkHinhAnh);
            BufferedImage originalImage = ImageIO.read(file);
            Image scaledImage = originalImage.getScaledInstance(88, 67, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            lbChiTietHinhAnh_hinhAnh2.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChiTietHangHoa_thayHinh2ActionPerformed

    private void btnChiTietHangHoa_thayHinh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietHangHoa_thayHinh3ActionPerformed
        try {
            String linkHinhAnh = layTenFile();
            String[] parts = linkHinhAnh.split("\\\\");
            danhSachHinhAnh.get(2).setTenHinh(parts[parts.length - 1]);
            danhSachLinkMoiHinhAnh.set(2, linkHinhAnh);
            File file = new File(linkHinhAnh);
            BufferedImage originalImage = ImageIO.read(file);
            Image scaledImage = originalImage.getScaledInstance(88, 67, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            lbChiTietHinhAnh_hinhAnh3.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChiTietHangHoa_thayHinh3ActionPerformed

    private void tabbedPaneChiTietHangHoa_theKhoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPaneChiTietHangHoa_theKhoStateChanged
        int tabbedPaneSelected = tabbedPaneChiTietHangHoa_theKho.getSelectedIndex();
        short tongSoLuong = 0;
        if (tabbedPaneSelected == 1){
            try {
                danhSachTheKho = theKhoService.hienThiTatCaTheKhoTheoMaHangHoa(hangHoa.getMaHangHoa());
                DefaultTableModel recordTable = (DefaultTableModel)tbChiTietHangHoa_theKho.getModel();
                recordTable.setRowCount(0);
                for (TheKho theKho : danhSachTheKho) {
                    theKhoService.themTheKho(theKho);
                    Vector columnData = new Vector();
                    columnData.add(theKho.getMaTheKho());
                    columnData.add(theKho.getPhuongThuc());
                    columnData.add(util.localDateParseMethod(theKho.getThoiGian()));
                    columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(theKho.getMaNhanVien()).getTenNhanVien());
                    
                    if (theKho.getMaNhaCungCap() == null){
                        columnData.add(khachHangService.hienThiKhachHangTheoMaKhachHang(theKho.getMaKhachHang()).getTenKhachHang());
                    } else {
                        columnData.add(nhaCungCapService.hienThiNhaCungCapTheoMaNhaCungCap(theKho.getMaNhaCungCap()).getTenNhaCungCap());
                    }
                    
                    columnData.add(theKho.getGiaVon());
                    columnData.add(theKho.getSoLuong());
                    columnData.add(theKho.getTonCuoi());
                    tongSoLuong += theKho.getSoLuong();
                    
                    recordTable.addRow(columnData);
                }
                lbChiTietHangHoa_theKho_tongTonKho.setText(String.valueOf(tongSoLuong));
            } catch (SQLException ex) {
                Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tabbedPaneChiTietHangHoa_theKhoStateChanged

    private String layTenFile(){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("", "jpg"));
        chooser.setFileFilter(chooser.getChoosableFileFilters()[1]);
        int r = chooser.showDialog(this,null);
        if (r!= JFileChooser.APPROVE_OPTION) return null;
        File file = new File(chooser.getSelectedFile() + chooser.getFileFilter().getDescription());
        return file.getPath();
    }
    
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
    
    public void deleteImage(String fileName){
        System.out.println(fileName);
        String linkImage =  fileName;
        File fileToDelete = new File(linkImage);
        if (fileToDelete.exists()) {
            // Attempt to delete the file
            if (fileToDelete.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
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
            java.util.logging.Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_chiTietHangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_chiTietHangHoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietHangHoa_capNhat;
    private javax.swing.JButton btnChiTietHangHoa_huyBo;
    private javax.swing.JButton btnChiTietHangHoa_ngungKinhDoanh;
    private javax.swing.JButton btnChiTietHangHoa_thayHinh1;
    private javax.swing.JButton btnChiTietHangHoa_thayHinh2;
    private javax.swing.JButton btnChiTietHangHoa_thayHinh3;
    private javax.swing.JButton btnChiTietHangHoa_theKho_xuatFile;
    private javax.swing.JComboBox<String> cbChiTietHangHang_dichVuLienQuan;
    private javax.swing.JComboBox<String> cbChiTietHangHang_trangThai;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbChiTietHangHang_hinhAnh0;
    private javax.swing.JLabel lbChiTietHangHoa_error;
    private javax.swing.JLabel lbChiTietHangHoa_tenHangHoa;
    private javax.swing.JLabel lbChiTietHangHoa_theKho_tongTonKho;
    private javax.swing.JLabel lbChiTietHinhAnh_hinhAnh1;
    private javax.swing.JLabel lbChiTietHinhAnh_hinhAnh2;
    private javax.swing.JLabel lbChiTietHinhAnh_hinhAnh3;
    private javax.swing.JPanel panelChiTietHangHoa_error;
    private javax.swing.JTabbedPane tabbedPaneChiTietHangHoa_theKho;
    private javax.swing.JTable tbChiTietHangHoa_theKho;
    private javax.swing.JTextField tfChiTietHangHang_giaBan;
    private javax.swing.JTextField tfChiTietHangHang_giaVon;
    private javax.swing.JTextField tfChiTietHangHang_khachDat;
    private javax.swing.JTextField tfChiTietHangHang_loaiHang;
    private javax.swing.JTextField tfChiTietHangHang_maHangHoa;
    private javax.swing.JTextField tfChiTietHangHang_tenHangHoa;
    private javax.swing.JTextField tfChiTietHangHang_tonKho;
    // End of variables declaration//GEN-END:variables
}
