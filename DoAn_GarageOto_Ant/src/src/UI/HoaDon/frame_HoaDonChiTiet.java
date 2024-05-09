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
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import src.Model.ChiTietPhieuTraHang;
import src.Model.HangHoa;
import src.Model.HoaDon;
import src.Model.HoaDonChiTiet;
import src.Model.NhanVien;
import src.Model.PhieuNhapHang;
import src.Model.PhieuTraHang;
import src.Service.ChiNhanhServive;
import src.Service.ChiTietPhieuTraHangService;
import src.Service.HangHoaService;
import src.Service.HoaDonChiTietService;
import src.Service.HoaDonService;
import src.Service.PhieuTraHangService;
import src.UI.TrangChu;
import src.Util.Util;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_HoaDonChiTiet extends javax.swing.JFrame {
    private HoaDon hoaDon;
    private HoaDonService hoaDonService = new HoaDonService();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
    private ChiNhanhServive chiNhanhServive = new ChiNhanhServive();
    private HangHoaService hangHoaService = new HangHoaService();
    private PhieuTraHangService phieuTraHangService = new PhieuTraHangService();
    private ChiTietPhieuTraHangService chiTietPhieuTraHangService = new ChiTietPhieuTraHangService();
    private Util util = new Util();
    private String tenNhanVien;
    private String tenDoiTac;
    private NhanVien nhanVienDangNhap;
    /**
     * Creates new form frame_HoaDonChiTiet
     */
    public Frame_HoaDonChiTiet() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Frame_HoaDonChiTiet(HoaDon hoaDon, String tenNhanVien, String tenDoiTac, NhanVien nhanVien) {
        this.hoaDon = hoaDon;
        this.tenNhanVien= tenNhanVien;
        this.tenDoiTac = tenDoiTac;
        this.nhanVienDangNhap  = nhanVien;
        
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hienThiThongTinHoaDon();
        hienThiDanhSachHoaDonChiTiet();
    }
    
    private void hienThiThongTinHoaDon(){
        try {
            lbHoaDonChiTiet_chiNhanh.setText(chiNhanhServive.hienThiChiNhanhTheoMaChiNhanh(hoaDon.getMaChiNhanh()).getTenChiNhanh());
        } catch (SQLException ex) {
            Logger.getLogger(Frame_HoaDonChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbHoaDonChiTiet_maHoaDon.setText(hoaDon.getMaHoaDon());
        lbHoaDonChiTiet_nguoiTao.setText(hoaDon.getMaNhanVien() + " " + tenNhanVien);
        if (hoaDon.getMaNhaCungCap() == null){
            lbHoaDonChiTiet_doiTac.setText("Khách hàng: ");  
        }  else {
            lbHoaDonChiTiet_doiTac.setText("Nhà cung cấp: ");  
        }
        lbHoaDonChiTiet_tenDoiTac.setText(tenDoiTac);
        lbHoaDonChiTiet_thoiGian.setText(util.localDateParseMethod(hoaDon.getThoiGian()));
        lbHoaDonChiTiet_trangThai.setText(hoaDon.getTrangThai());
        tareHoaDonChiTiet_ghiChu.setText(hoaDon.getGhiChu());
        lbHoaDonChiTiet_giamGia.setText(String.valueOf(hoaDon.getGiamGia()));
        lbHoaDonChiTiet_tongTienHang.setText(String.valueOf(hoaDon.getTongTien()));
        lbHoaDonChiTiet_tienCanTra.setText(String.valueOf(hoaDon.getTongTien() - hoaDon.getGiamGia()));
        
        lbHoaDonChiTiet_tienDaTra.setText(String.valueOf(hoaDon.getTienDaTra()));
        lbHoaDonChiTiet_tienThua.setText(String.valueOf(hoaDon.getTienDaTra() - (hoaDon.getTongTien() - hoaDon.getGiamGia())));
        
        panelHoaDonChiTiet_maHang.setVisible(false);
        panelHoaDonChiTiet_tenHang.setVisible(false);
        panelHoaDonChiTiet_soLuong.setVisible(false);
        btnHoaDonChiTiet_traHang.setVisible(false);
        btnHoaDonChiTiet_traSanPham.setVisible(false);
        btnHoaDonChiTiet_hoanTac.setVisible(false);
        tbHoaDonChiTiet_traHang.setVisible(false);
        scrollPaneHoaDonChiTiet_traHang.setVisible(false);
        checkBoxHoaDonChiTiet_sanPhamLoi.setVisible(false);
    }
    
    private void hienThiDanhSachHoaDonChiTiet(){
        int soLuong = 0;
        try {
            List<HoaDonChiTiet> danhSachHoaDonChiTiet = hoaDonChiTietService.hienThiHoaDonChiTietTheoMaHoaDon(this.hoaDon.getMaHoaDon());
            DefaultTableModel recordTable = (DefaultTableModel)tbHoaDonChiTiet_danhSachHoaDonChiTiet.getModel();
            recordTable.setRowCount(0);
            for (HoaDonChiTiet hoaDonChiTiet : danhSachHoaDonChiTiet) {
                Vector columnData = new Vector();
                columnData.add(hoaDonChiTiet.getMaHangHoa());
                columnData.add(hangHoaService.hienThiHangHoaTheoMaHangHoa(hoaDonChiTiet.getMaHangHoa()).getTenHangHoa());
                columnData.add(String.valueOf(hoaDonChiTiet.getSoLuong()));
                soLuong += hoaDonChiTiet.getSoLuong();
                columnData.add(String.valueOf(hoaDonChiTiet.getGiaBan()));
                columnData.add(String.valueOf(hoaDonChiTiet.getGiamGia()));
                columnData.add(String.valueOf(hoaDonChiTiet.getThanhTien()));
                recordTable.addRow(columnData);
            }
            lbHoaDonChiTiet_soLuong.setText(String.valueOf(soLuong));
            TableColumnModel columnModel = tbHoaDonChiTiet_danhSachHoaDonChiTiet.getColumnModel();
        // Get the column at the desired index
            TableColumn columnSL = columnModel.getColumn(2);
            // Set the preferred width of the column
            columnSL.setMaxWidth(75);
            columnSL.setMinWidth(75);
            
            TableColumn columnDonGia = columnModel.getColumn(3);
            // Set the preferred width of the column
            columnDonGia.setMaxWidth(100);
            columnDonGia.setMinWidth(100);
            
            TableColumn columnGiamGia = columnModel.getColumn(4);
            // Set the preferred width of the column
            columnGiamGia.setMaxWidth(100);
            columnGiamGia.setMinWidth(100);
            
            TableColumn columnMaHang = columnModel.getColumn(0);
            // Set the preferred width of the column
            columnMaHang.setMaxWidth(75);
            columnMaHang.setMinWidth(75);
            
            TableColumn columnThanhTien = columnModel.getColumn(5);
            // Set the preferred width of the column
            columnThanhTien.setMaxWidth(125);
            columnThanhTien.setMinWidth(125);
            
            TableColumnModel columnTraHangModel = tbHoaDonChiTiet_traHang.getColumnModel();
        // Get the column at the desired index
            TableColumn columnMahangTraHang = columnTraHangModel.getColumn(0);
            // Set the preferred width of the column
            columnMahangTraHang.setMaxWidth(75);
            columnMahangTraHang.setMinWidth(75);
            
            TableColumn columnDonGiaTraHang = columnTraHangModel.getColumn(2);
            // Set the preferred width of the column
            columnDonGiaTraHang.setMaxWidth(75);
            columnDonGiaTraHang.setMinWidth(75);
            
            TableColumn columnSoLuongTraHang = columnTraHangModel.getColumn(3);
            // Set the preferred width of the column
            columnSoLuongTraHang.setMaxWidth(75);
            columnSoLuongTraHang.setMinWidth(75);
            
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
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
        btnHoaDonChiTiet_capNhat = new javax.swing.JButton();
        btnHoaDonChiTiet_traHang = new javax.swing.JButton();
        jPanel240 = new javax.swing.JPanel();
        jLabel285 = new javax.swing.JLabel();
        lbHoaDonChiTiet_giamGia = new javax.swing.JLabel();
        btnHoaDonChiTiet_in = new javax.swing.JButton();
        btnHoaDonChiTiet_huyBo = new javax.swing.JButton();
        jPanel241 = new javax.swing.JPanel();
        jLabel287 = new javax.swing.JLabel();
        lbHoaDonChiTiet_maHoaDon = new javax.swing.JLabel();
        jPanel244 = new javax.swing.JPanel();
        jLabel293 = new javax.swing.JLabel();
        lbHoaDonChiTiet_tienCanTra = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbHoaDonChiTiet_danhSachHoaDonChiTiet = new javax.swing.JTable();
        jPanel247 = new javax.swing.JPanel();
        jLabel299 = new javax.swing.JLabel();
        lbHoaDonChiTiet_tienDaTra = new javax.swing.JLabel();
        jPanel248 = new javax.swing.JPanel();
        jLabel301 = new javax.swing.JLabel();
        lbHoaDonChiTiet_thoiGian = new javax.swing.JLabel();
        jPanel250 = new javax.swing.JPanel();
        jLabel305 = new javax.swing.JLabel();
        lbHoaDonChiTiet_soLuong = new javax.swing.JLabel();
        jPanel251 = new javax.swing.JPanel();
        jLabel307 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tareHoaDonChiTiet_ghiChu = new javax.swing.JTextArea();
        jPanel252 = new javax.swing.JPanel();
        jLabel304 = new javax.swing.JLabel();
        lbHoaDonChiTiet_tienThua = new javax.swing.JLabel();
        jPanel253 = new javax.swing.JPanel();
        jLabel294 = new javax.swing.JLabel();
        lbHoaDonChiTiet_tongTienHang = new javax.swing.JLabel();
        jPanel246 = new javax.swing.JPanel();
        jLabel297 = new javax.swing.JLabel();
        lbHoaDonChiTiet_chiNhanh = new javax.swing.JLabel();
        jPanel249 = new javax.swing.JPanel();
        jLabel303 = new javax.swing.JLabel();
        lbHoaDonChiTiet_trangThai = new javax.swing.JLabel();
        jPanel243 = new javax.swing.JPanel();
        jLabel291 = new javax.swing.JLabel();
        lbHoaDonChiTiet_nguoiTao = new javax.swing.JLabel();
        jPanel254 = new javax.swing.JPanel();
        lbHoaDonChiTiet_doiTac = new javax.swing.JLabel();
        lbHoaDonChiTiet_tenDoiTac = new javax.swing.JLabel();
        panelHoaDonChiTiet_soLuong = new javax.swing.JPanel();
        lbHoaDonChiTiet_doiTac2 = new javax.swing.JLabel();
        tfHoaDonChiTiet_soLuong = new javax.swing.JTextField();
        panelHoaDonChiTiet_maHang = new javax.swing.JPanel();
        lbHoaDonChiTiet_doiTac3 = new javax.swing.JLabel();
        lbHoaDonChiTiet_maHang = new javax.swing.JLabel();
        panelHoaDonChiTiet_tenHang = new javax.swing.JPanel();
        lbHoaDonChiTiet_doiTac4 = new javax.swing.JLabel();
        tfHoaDonChiTiet_tenHang = new javax.swing.JTextField();
        scrollPaneHoaDonChiTiet_traHang = new javax.swing.JScrollPane();
        tbHoaDonChiTiet_traHang = new javax.swing.JTable();
        btnHoaDonChiTiet_traSanPham = new javax.swing.JButton();
        btnHoaDonChiTiet_hoanTac = new javax.swing.JButton();
        lbHoaDonChiTiet_error = new javax.swing.JLabel();
        checkBoxHoaDonChiTiet_sanPhamLoi = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel239.setBackground(new java.awt.Color(242, 249, 255));
        jPanel239.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHoaDonChiTiet_capNhat.setBackground(new java.awt.Color(51, 204, 0));
        btnHoaDonChiTiet_capNhat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDonChiTiet_capNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDonChiTiet_capNhat.setText("Cập nhật");
        btnHoaDonChiTiet_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChiTiet_capNhatActionPerformed(evt);
            }
        });
        jPanel239.add(btnHoaDonChiTiet_capNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, -1, -1));

        btnHoaDonChiTiet_traHang.setBackground(new java.awt.Color(255, 153, 153));
        btnHoaDonChiTiet_traHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDonChiTiet_traHang.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDonChiTiet_traHang.setText("Trả hàng");
        btnHoaDonChiTiet_traHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChiTiet_traHangActionPerformed(evt);
            }
        });
        jPanel239.add(btnHoaDonChiTiet_traHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 119, -1));

        jPanel240.setBackground(new java.awt.Color(255, 255, 255));

        jLabel285.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel285.setText("Giảm giá:");

        lbHoaDonChiTiet_giamGia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDonChiTiet_giamGia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_giamGia.setText("0");

        javax.swing.GroupLayout jPanel240Layout = new javax.swing.GroupLayout(jPanel240);
        jPanel240.setLayout(jPanel240Layout);
        jPanel240Layout.setHorizontalGroup(
            jPanel240Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel240Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel285)
                .addGap(18, 18, 18)
                .addComponent(lbHoaDonChiTiet_giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel240Layout.setVerticalGroup(
            jPanel240Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel240Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel240Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel285)
                    .addComponent(lbHoaDonChiTiet_giamGia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 277, -1));

        btnHoaDonChiTiet_in.setBackground(new java.awt.Color(0, 102, 255));
        btnHoaDonChiTiet_in.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDonChiTiet_in.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDonChiTiet_in.setText("In");
        btnHoaDonChiTiet_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChiTiet_inActionPerformed(evt);
            }
        });
        jPanel239.add(btnHoaDonChiTiet_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 550, -1, -1));

        btnHoaDonChiTiet_huyBo.setBackground(new java.awt.Color(255, 51, 51));
        btnHoaDonChiTiet_huyBo.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDonChiTiet_huyBo.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDonChiTiet_huyBo.setText("Thoát");
        btnHoaDonChiTiet_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChiTiet_huyBoActionPerformed(evt);
            }
        });
        jPanel239.add(btnHoaDonChiTiet_huyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 550, -1, -1));

        jPanel241.setBackground(new java.awt.Color(242, 249, 255));

        jLabel287.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel287.setText("Mã hóa đơn:");

        lbHoaDonChiTiet_maHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDonChiTiet_maHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_maHoaDon.setText("0");

        javax.swing.GroupLayout jPanel241Layout = new javax.swing.GroupLayout(jPanel241);
        jPanel241.setLayout(jPanel241Layout);
        jPanel241Layout.setHorizontalGroup(
            jPanel241Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel241Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel287)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHoaDonChiTiet_maHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel241Layout.setVerticalGroup(
            jPanel241Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel241Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel241Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel287)
                    .addComponent(lbHoaDonChiTiet_maHoaDon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 290, -1));

        jPanel244.setBackground(new java.awt.Color(255, 255, 255));

        jLabel293.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel293.setText("Tiền cần trả:");

        lbHoaDonChiTiet_tienCanTra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDonChiTiet_tienCanTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_tienCanTra.setText("0");

        javax.swing.GroupLayout jPanel244Layout = new javax.swing.GroupLayout(jPanel244);
        jPanel244.setLayout(jPanel244Layout);
        jPanel244Layout.setHorizontalGroup(
            jPanel244Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel244Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel293)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHoaDonChiTiet_tienCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel244Layout.setVerticalGroup(
            jPanel244Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel244Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel244Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel293)
                    .addComponent(lbHoaDonChiTiet_tienCanTra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, -1, -1));

        tbHoaDonChiTiet_danhSachHoaDonChiTiet.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbHoaDonChiTiet_danhSachHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng", "Tên hàng", "Số lượng", "Đơn giá", "Giảm giá", "Thành tiền"
            }
        ));
        tbHoaDonChiTiet_danhSachHoaDonChiTiet.setRowHeight(30);
        tbHoaDonChiTiet_danhSachHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonChiTiet_danhSachHoaDonChiTietMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tbHoaDonChiTiet_danhSachHoaDonChiTiet);

        jPanel239.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 165, 1020, 262));

        jPanel247.setBackground(new java.awt.Color(255, 255, 255));

        jLabel299.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel299.setText("Tiền đã trả");

        lbHoaDonChiTiet_tienDaTra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDonChiTiet_tienDaTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_tienDaTra.setText("0");

        javax.swing.GroupLayout jPanel247Layout = new javax.swing.GroupLayout(jPanel247);
        jPanel247.setLayout(jPanel247Layout);
        jPanel247Layout.setHorizontalGroup(
            jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel247Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel299)
                .addGap(24, 24, 24)
                .addComponent(lbHoaDonChiTiet_tienDaTra, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel247Layout.setVerticalGroup(
            jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel247Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel299)
                    .addComponent(lbHoaDonChiTiet_tienDaTra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, -1, -1));

        jPanel248.setBackground(new java.awt.Color(242, 249, 255));

        jLabel301.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel301.setText("Thời gian:");

        lbHoaDonChiTiet_thoiGian.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_thoiGian.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_thoiGian.setText("0");

        javax.swing.GroupLayout jPanel248Layout = new javax.swing.GroupLayout(jPanel248);
        jPanel248.setLayout(jPanel248Layout);
        jPanel248Layout.setHorizontalGroup(
            jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel248Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel301)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHoaDonChiTiet_thoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel248Layout.setVerticalGroup(
            jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel248Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel248Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel301)
                    .addComponent(lbHoaDonChiTiet_thoiGian))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 290, -1));

        jPanel250.setBackground(new java.awt.Color(255, 255, 255));

        jLabel305.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel305.setText("Tổng số lượng:");

        lbHoaDonChiTiet_soLuong.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDonChiTiet_soLuong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_soLuong.setText("0");

        javax.swing.GroupLayout jPanel250Layout = new javax.swing.GroupLayout(jPanel250);
        jPanel250.setLayout(jPanel250Layout);
        jPanel250Layout.setHorizontalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel250Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel305)
                .addGap(18, 18, 18)
                .addComponent(lbHoaDonChiTiet_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel250Layout.setVerticalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel250Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel305)
                    .addComponent(lbHoaDonChiTiet_soLuong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 277, -1));

        jPanel251.setBackground(new java.awt.Color(242, 249, 255));
        jPanel251.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel307.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil.png"))); // NOI18N
        jPanel251.add(jLabel307, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tareHoaDonChiTiet_ghiChu.setColumns(20);
        tareHoaDonChiTiet_ghiChu.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        tareHoaDonChiTiet_ghiChu.setLineWrap(true);
        tareHoaDonChiTiet_ghiChu.setRows(5);
        tareHoaDonChiTiet_ghiChu.setText("Ghi chú...");
        tareHoaDonChiTiet_ghiChu.setEnabled(false);
        jScrollPane16.setViewportView(tareHoaDonChiTiet_ghiChu);

        jPanel251.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 137));

        jPanel239.add(jPanel251, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 310, -1));

        jPanel252.setBackground(new java.awt.Color(255, 255, 255));

        jLabel304.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel304.setText("Tiền thừa:");

        lbHoaDonChiTiet_tienThua.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDonChiTiet_tienThua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_tienThua.setText("0");

        javax.swing.GroupLayout jPanel252Layout = new javax.swing.GroupLayout(jPanel252);
        jPanel252.setLayout(jPanel252Layout);
        jPanel252Layout.setHorizontalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel252Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel304)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lbHoaDonChiTiet_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel252Layout.setVerticalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel252Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel304)
                    .addComponent(lbHoaDonChiTiet_tienThua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel252, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, -1, -1));

        jPanel253.setBackground(new java.awt.Color(255, 255, 255));

        jLabel294.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel294.setText("Tổng tiền hàng:");

        lbHoaDonChiTiet_tongTienHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHoaDonChiTiet_tongTienHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_tongTienHang.setText("0");

        javax.swing.GroupLayout jPanel253Layout = new javax.swing.GroupLayout(jPanel253);
        jPanel253.setLayout(jPanel253Layout);
        jPanel253Layout.setHorizontalGroup(
            jPanel253Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel253Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel294, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHoaDonChiTiet_tongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel253Layout.setVerticalGroup(
            jPanel253Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel253Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel253Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel294)
                    .addComponent(lbHoaDonChiTiet_tongTienHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel253, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        jPanel246.setBackground(new java.awt.Color(242, 249, 255));

        jLabel297.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel297.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel297.setText("Chi nhánh:");

        lbHoaDonChiTiet_chiNhanh.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_chiNhanh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_chiNhanh.setText("0");

        javax.swing.GroupLayout jPanel246Layout = new javax.swing.GroupLayout(jPanel246);
        jPanel246.setLayout(jPanel246Layout);
        jPanel246Layout.setHorizontalGroup(
            jPanel246Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel246Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel297)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lbHoaDonChiTiet_chiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel246Layout.setVerticalGroup(
            jPanel246Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel246Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel246Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel297)
                    .addComponent(lbHoaDonChiTiet_chiNhanh))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 280, -1));

        jPanel249.setBackground(new java.awt.Color(242, 249, 255));

        jLabel303.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel303.setText("Trạng thái:");

        lbHoaDonChiTiet_trangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_trangThai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_trangThai.setText("0");

        javax.swing.GroupLayout jPanel249Layout = new javax.swing.GroupLayout(jPanel249);
        jPanel249.setLayout(jPanel249Layout);
        jPanel249Layout.setHorizontalGroup(
            jPanel249Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel249Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel303)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lbHoaDonChiTiet_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel249Layout.setVerticalGroup(
            jPanel249Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel249Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel249Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel303)
                    .addComponent(lbHoaDonChiTiet_trangThai))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel249, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 280, -1));

        jPanel243.setBackground(new java.awt.Color(242, 249, 255));
        jPanel243.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel291.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel291.setText("Người tạo:");

        lbHoaDonChiTiet_nguoiTao.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_nguoiTao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_nguoiTao.setText("0");

        javax.swing.GroupLayout jPanel243Layout = new javax.swing.GroupLayout(jPanel243);
        jPanel243.setLayout(jPanel243Layout);
        jPanel243Layout.setHorizontalGroup(
            jPanel243Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel243Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel291)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lbHoaDonChiTiet_nguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel243Layout.setVerticalGroup(
            jPanel243Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel243Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel243Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel291)
                    .addComponent(lbHoaDonChiTiet_nguoiTao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 280, -1));

        jPanel254.setBackground(new java.awt.Color(242, 249, 255));
        jPanel254.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lbHoaDonChiTiet_doiTac.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_doiTac.setText("Khách hàng:");

        lbHoaDonChiTiet_tenDoiTac.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_tenDoiTac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoaDonChiTiet_tenDoiTac.setText("name");

        javax.swing.GroupLayout jPanel254Layout = new javax.swing.GroupLayout(jPanel254);
        jPanel254.setLayout(jPanel254Layout);
        jPanel254Layout.setHorizontalGroup(
            jPanel254Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel254Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoaDonChiTiet_doiTac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHoaDonChiTiet_tenDoiTac, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel254Layout.setVerticalGroup(
            jPanel254Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel254Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel254Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDonChiTiet_doiTac)
                    .addComponent(lbHoaDonChiTiet_tenDoiTac))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(jPanel254, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 290, -1));

        panelHoaDonChiTiet_soLuong.setBackground(new java.awt.Color(242, 249, 255));

        lbHoaDonChiTiet_doiTac2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_doiTac2.setText("Số lượng:");

        tfHoaDonChiTiet_soLuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfHoaDonChiTiet_soLuong.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfHoaDonChiTiet_soLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfHoaDonChiTiet_soLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfHoaDonChiTiet_soLuongKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelHoaDonChiTiet_soLuongLayout = new javax.swing.GroupLayout(panelHoaDonChiTiet_soLuong);
        panelHoaDonChiTiet_soLuong.setLayout(panelHoaDonChiTiet_soLuongLayout);
        panelHoaDonChiTiet_soLuongLayout.setHorizontalGroup(
            panelHoaDonChiTiet_soLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonChiTiet_soLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoaDonChiTiet_doiTac2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfHoaDonChiTiet_soLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelHoaDonChiTiet_soLuongLayout.setVerticalGroup(
            panelHoaDonChiTiet_soLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonChiTiet_soLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHoaDonChiTiet_soLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDonChiTiet_doiTac2)
                    .addComponent(tfHoaDonChiTiet_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(panelHoaDonChiTiet_soLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 180, -1));

        panelHoaDonChiTiet_maHang.setBackground(new java.awt.Color(242, 249, 255));

        lbHoaDonChiTiet_doiTac3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_doiTac3.setText("Mã hàng:");

        lbHoaDonChiTiet_maHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_maHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout panelHoaDonChiTiet_maHangLayout = new javax.swing.GroupLayout(panelHoaDonChiTiet_maHang);
        panelHoaDonChiTiet_maHang.setLayout(panelHoaDonChiTiet_maHangLayout);
        panelHoaDonChiTiet_maHangLayout.setHorizontalGroup(
            panelHoaDonChiTiet_maHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonChiTiet_maHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoaDonChiTiet_doiTac3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHoaDonChiTiet_maHang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHoaDonChiTiet_maHangLayout.setVerticalGroup(
            panelHoaDonChiTiet_maHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonChiTiet_maHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHoaDonChiTiet_maHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDonChiTiet_doiTac3)
                    .addComponent(lbHoaDonChiTiet_maHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(panelHoaDonChiTiet_maHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 180, -1));

        panelHoaDonChiTiet_tenHang.setBackground(new java.awt.Color(242, 249, 255));

        lbHoaDonChiTiet_doiTac4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbHoaDonChiTiet_doiTac4.setText("Tên hàng:");

        tfHoaDonChiTiet_tenHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfHoaDonChiTiet_tenHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout panelHoaDonChiTiet_tenHangLayout = new javax.swing.GroupLayout(panelHoaDonChiTiet_tenHang);
        panelHoaDonChiTiet_tenHang.setLayout(panelHoaDonChiTiet_tenHangLayout);
        panelHoaDonChiTiet_tenHangLayout.setHorizontalGroup(
            panelHoaDonChiTiet_tenHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonChiTiet_tenHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHoaDonChiTiet_doiTac4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfHoaDonChiTiet_tenHang, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelHoaDonChiTiet_tenHangLayout.setVerticalGroup(
            panelHoaDonChiTiet_tenHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonChiTiet_tenHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHoaDonChiTiet_tenHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoaDonChiTiet_doiTac4)
                    .addComponent(tfHoaDonChiTiet_tenHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel239.add(panelHoaDonChiTiet_tenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 240, -1));

        tbHoaDonChiTiet_traHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbHoaDonChiTiet_traHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng", "Tên hàng", "Đơn giá", "Số lượng", "Lỗi"
            }
        ));
        tbHoaDonChiTiet_traHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonChiTiet_traHangMouseClicked(evt);
            }
        });
        scrollPaneHoaDonChiTiet_traHang.setViewportView(tbHoaDonChiTiet_traHang);

        jPanel239.add(scrollPaneHoaDonChiTiet_traHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 450, 150));

        btnHoaDonChiTiet_traSanPham.setBackground(new java.awt.Color(51, 153, 255));
        btnHoaDonChiTiet_traSanPham.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDonChiTiet_traSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDonChiTiet_traSanPham.setText("Trả");
        btnHoaDonChiTiet_traSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChiTiet_traSanPhamActionPerformed(evt);
            }
        });
        jPanel239.add(btnHoaDonChiTiet_traSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 60, 30));

        btnHoaDonChiTiet_hoanTac.setBackground(new java.awt.Color(255, 153, 153));
        btnHoaDonChiTiet_hoanTac.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDonChiTiet_hoanTac.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDonChiTiet_hoanTac.setText("Hoàn tác");
        btnHoaDonChiTiet_hoanTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChiTiet_hoanTacActionPerformed(evt);
            }
        });
        jPanel239.add(btnHoaDonChiTiet_hoanTac, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 100, 30));
        jPanel239.add(lbHoaDonChiTiet_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 280, 20));

        checkBoxHoaDonChiTiet_sanPhamLoi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        checkBoxHoaDonChiTiet_sanPhamLoi.setText("Sản phẩm lỗi");
        jPanel239.add(checkBoxHoaDonChiTiet_sanPhamLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel239, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel239, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHoaDonChiTiet_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChiTiet_huyBoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHoaDonChiTiet_huyBoActionPerformed

    int soLuongSanPhamTra = 0;
    double donGiaSanPhamTra = 0;
    private void tbHoaDonChiTiet_danhSachHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonChiTiet_danhSachHoaDonChiTietMouseClicked
        btnHoaDonChiTiet_hoanTac.setVisible(false);
        int index = tbHoaDonChiTiet_danhSachHoaDonChiTiet.getSelectedRow();
        TableModel model = tbHoaDonChiTiet_danhSachHoaDonChiTiet.getModel();

        lbHoaDonChiTiet_maHang.setText(model.getValueAt(index, 0).toString());
        tfHoaDonChiTiet_tenHang.setText(model.getValueAt(index, 1).toString());
        tfHoaDonChiTiet_soLuong.setText(model.getValueAt(index, 2).toString());
        
        soLuongSanPhamTra = Integer.parseInt(model.getValueAt(index, 2).toString());
        if (btnHoaDonChiTiet_capNhat.getText().equals("Lưu")){
            btnHoaDonChiTiet_traSanPham.setVisible(true);
        }
        donGiaSanPhamTra = Double.parseDouble(model.getValueAt(index, 3).toString());
    }//GEN-LAST:event_tbHoaDonChiTiet_danhSachHoaDonChiTietMouseClicked

    private void btnHoaDonChiTiet_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChiTiet_capNhatActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 6.3 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền cập nhật thông tin hóa đơn!");
                return;
            }
        if (btnHoaDonChiTiet_capNhat.getText().equals("Cập nhật")){
            btnHoaDonChiTiet_capNhat.setText("Lưu");
            panelHoaDonChiTiet_maHang.setVisible(true);
            panelHoaDonChiTiet_tenHang.setVisible(true);
            panelHoaDonChiTiet_soLuong.setVisible(true);
            if (tbHoaDonChiTiet_traHang.getRowCount() > 0){
                btnHoaDonChiTiet_traHang.setVisible(true);
            }
            tareHoaDonChiTiet_ghiChu.setEnabled(true);
            btnHoaDonChiTiet_traSanPham.setVisible(true);
            tbHoaDonChiTiet_traHang.setVisible(true);
            scrollPaneHoaDonChiTiet_traHang.setVisible(true);
            checkBoxHoaDonChiTiet_sanPhamLoi.setVisible(true);
            btnHoaDonChiTiet_in.setVisible(false);
            HoaDon hoaDonNew = new HoaDon();
            hoaDonNew.setMaHoaDon(lbHoaDonChiTiet_maHoaDon.getText());
            hoaDonNew.setGhiChu(tareHoaDonChiTiet_ghiChu.getText());
            try {
                hoaDonService.updateHoaDon(hoaDonNew);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_HoaDonChiTiet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            panelHoaDonChiTiet_maHang.setVisible(false);
            panelHoaDonChiTiet_tenHang.setVisible(false);
            panelHoaDonChiTiet_soLuong.setVisible(false);
            btnHoaDonChiTiet_traHang.setVisible(false);
            tareHoaDonChiTiet_ghiChu.setEnabled(false);
            btnHoaDonChiTiet_traSanPham.setVisible(false);
            tbHoaDonChiTiet_traHang.setVisible(false);
            scrollPaneHoaDonChiTiet_traHang.setVisible(false);
            checkBoxHoaDonChiTiet_sanPhamLoi.setVisible(false);
            btnHoaDonChiTiet_in.setVisible(true);
            btnHoaDonChiTiet_capNhat.setText("Cập nhật");
        }
    }//GEN-LAST:event_btnHoaDonChiTiet_capNhatActionPerformed

    private void btnHoaDonChiTiet_traSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChiTiet_traSanPhamActionPerformed
        if (tfHoaDonChiTiet_soLuong.getText().equals("")){
            return;
        }
        DefaultTableModel recordTable = (DefaultTableModel)tbHoaDonChiTiet_traHang.getModel();

            for (int i =0; i< recordTable.getRowCount(); i++){
                if (tbHoaDonChiTiet_traHang.getValueAt(i, 0).equals(lbHoaDonChiTiet_maHang.getText())){
                    return;
                }
            }


        Vector columnData = new Vector();
        columnData.add(lbHoaDonChiTiet_maHang.getText());
        columnData.add(tfHoaDonChiTiet_tenHang.getText());
        if (checkBoxHoaDonChiTiet_sanPhamLoi.isSelected()){
            columnData.add(donGiaSanPhamTra);
        } else {
            columnData.add(donGiaSanPhamTra*1.1); // phụ thu 10%
        }
        
        columnData.add(tfHoaDonChiTiet_soLuong.getText());
        if (checkBoxHoaDonChiTiet_sanPhamLoi.isSelected()){
            columnData.add("Lỗi");
        }
        recordTable.addRow(columnData);
        
        if (tbHoaDonChiTiet_traHang.getRowCount() > 0){
            btnHoaDonChiTiet_traHang.setVisible(true);
        }
    }//GEN-LAST:event_btnHoaDonChiTiet_traSanPhamActionPerformed

    private void btnHoaDonChiTiet_hoanTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChiTiet_hoanTacActionPerformed

        DefaultTableModel recordTable = (DefaultTableModel)tbHoaDonChiTiet_traHang.getModel();
        for (int i =0; i< recordTable.getRowCount(); i++){
            if (tbHoaDonChiTiet_traHang.getValueAt(i, 0).equals(lbHoaDonChiTiet_maHang.getText())){
                recordTable.removeRow(i);
                return;
            }
        }
        if (tbHoaDonChiTiet_traHang.getRowCount() == 0){
            btnHoaDonChiTiet_traHang.setVisible(false);
        }
    }//GEN-LAST:event_btnHoaDonChiTiet_hoanTacActionPerformed

    private void tbHoaDonChiTiet_traHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonChiTiet_traHangMouseClicked
        btnHoaDonChiTiet_hoanTac.setVisible(true);
        int index = tbHoaDonChiTiet_traHang.getSelectedRow();
        TableModel model = tbHoaDonChiTiet_traHang.getModel();

        lbHoaDonChiTiet_maHang.setText(model.getValueAt(index, 0).toString());
        tfHoaDonChiTiet_tenHang.setText(model.getValueAt(index, 1).toString());
        tfHoaDonChiTiet_soLuong.setText(model.getValueAt(index, 2).toString());
    }//GEN-LAST:event_tbHoaDonChiTiet_traHangMouseClicked

    private void tfHoaDonChiTiet_soLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHoaDonChiTiet_soLuongKeyReleased
        try{
            if (Integer.parseInt(tfHoaDonChiTiet_soLuong.getText()) <= 0){
                lbHoaDonChiTiet_error.setText("Số lượng lớn hơn 0");
                btnHoaDonChiTiet_traSanPham.setVisible(false);
            } else if (Integer.parseInt(tfHoaDonChiTiet_soLuong.getText()) > soLuongSanPhamTra){
                lbHoaDonChiTiet_error.setText("Số lượng không hợp lệ");
                btnHoaDonChiTiet_traSanPham.setVisible(false);
            } else {
                lbHoaDonChiTiet_error.setText("");
                btnHoaDonChiTiet_traSanPham.setVisible(true);
            }
            
        } catch (Exception err){
            lbHoaDonChiTiet_error.setText("Không đúng định dạng");
        }
        
    }//GEN-LAST:event_tfHoaDonChiTiet_soLuongKeyReleased

    private void btnHoaDonChiTiet_traHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChiTiet_traHangActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 14.2")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền trả hàng!");
                return;
            }
//        JTable tbDanhSachSanPhamTraHang, double tongTienHang, short soLuongHang, String maHoaDon, String maKhachHang, String maNhanVien
        Frame_TienThanhToanTraHang frame_TienThanhToanTraHang = new Frame_TienThanhToanTraHang(tbHoaDonChiTiet_traHang, Double.parseDouble(lbHoaDonChiTiet_tongTienHang.getText()),Short.parseShort(lbHoaDonChiTiet_soLuong.getText()), lbHoaDonChiTiet_maHoaDon.getText(), hoaDon.getMaKhachHang() , "NV004" );
        frame_TienThanhToanTraHang.setVisible(true);
        frame_TienThanhToanTraHang.setSize(365, 200);
        frame_TienThanhToanTraHang.setLocation(400,200);
        
        
    }//GEN-LAST:event_btnHoaDonChiTiet_traHangActionPerformed

    private void btnHoaDonChiTiet_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChiTiet_inActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 6.5 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền in hóa đơn!");
                return;
            }
    }//GEN-LAST:event_btnHoaDonChiTiet_inActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_HoaDonChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDonChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDonChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDonChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_HoaDonChiTiet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoaDonChiTiet_capNhat;
    private javax.swing.JButton btnHoaDonChiTiet_hoanTac;
    private javax.swing.JButton btnHoaDonChiTiet_huyBo;
    private javax.swing.JButton btnHoaDonChiTiet_in;
    private javax.swing.JButton btnHoaDonChiTiet_traHang;
    private javax.swing.JButton btnHoaDonChiTiet_traSanPham;
    private javax.swing.JCheckBox checkBoxHoaDonChiTiet_sanPhamLoi;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JPanel jPanel239;
    private javax.swing.JPanel jPanel240;
    private javax.swing.JPanel jPanel241;
    private javax.swing.JPanel jPanel243;
    private javax.swing.JPanel jPanel244;
    private javax.swing.JPanel jPanel246;
    private javax.swing.JPanel jPanel247;
    private javax.swing.JPanel jPanel248;
    private javax.swing.JPanel jPanel249;
    private javax.swing.JPanel jPanel250;
    private javax.swing.JPanel jPanel251;
    private javax.swing.JPanel jPanel252;
    private javax.swing.JPanel jPanel253;
    private javax.swing.JPanel jPanel254;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JLabel lbHoaDonChiTiet_chiNhanh;
    private javax.swing.JLabel lbHoaDonChiTiet_doiTac;
    private javax.swing.JLabel lbHoaDonChiTiet_doiTac2;
    private javax.swing.JLabel lbHoaDonChiTiet_doiTac3;
    private javax.swing.JLabel lbHoaDonChiTiet_doiTac4;
    private javax.swing.JLabel lbHoaDonChiTiet_error;
    private javax.swing.JLabel lbHoaDonChiTiet_giamGia;
    private javax.swing.JLabel lbHoaDonChiTiet_maHang;
    private javax.swing.JLabel lbHoaDonChiTiet_maHoaDon;
    private javax.swing.JLabel lbHoaDonChiTiet_nguoiTao;
    private javax.swing.JLabel lbHoaDonChiTiet_soLuong;
    private javax.swing.JLabel lbHoaDonChiTiet_tenDoiTac;
    private javax.swing.JLabel lbHoaDonChiTiet_thoiGian;
    private javax.swing.JLabel lbHoaDonChiTiet_tienCanTra;
    private javax.swing.JLabel lbHoaDonChiTiet_tienDaTra;
    private javax.swing.JLabel lbHoaDonChiTiet_tienThua;
    private javax.swing.JLabel lbHoaDonChiTiet_tongTienHang;
    private javax.swing.JLabel lbHoaDonChiTiet_trangThai;
    private javax.swing.JPanel panelHoaDonChiTiet_maHang;
    private javax.swing.JPanel panelHoaDonChiTiet_soLuong;
    private javax.swing.JPanel panelHoaDonChiTiet_tenHang;
    private javax.swing.JScrollPane scrollPaneHoaDonChiTiet_traHang;
    private javax.swing.JTextArea tareHoaDonChiTiet_ghiChu;
    private javax.swing.JTable tbHoaDonChiTiet_danhSachHoaDonChiTiet;
    private javax.swing.JTable tbHoaDonChiTiet_traHang;
    private javax.swing.JTextField tfHoaDonChiTiet_soLuong;
    private javax.swing.JTextField tfHoaDonChiTiet_tenHang;
    // End of variables declaration//GEN-END:variables
}
