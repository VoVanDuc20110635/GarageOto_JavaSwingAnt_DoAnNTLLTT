/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.HangHoa;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import src.Model.ChiTietPhieuNhapHang;
import src.Model.HangHoa;
import src.Model.KhachHang;
import src.Model.NhaCungCap;
import src.Service.ChiTietPhieuNhapHangService;
import src.Service.HangHoaService;
import src.Service.HinhAnhService;
import src.Service.KhachHangService;
import src.Service.NhaCungCapService;
import src.Service.PhieuNhapHangService;
import src.UI.HoaDon.Frame_ThanhToan;
import src.UI.TrangChu;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_taoDonNhapHang extends javax.swing.JFrame {
    private List<HangHoa> danhSachHangHoaMain = new ArrayList<>();
    private List<String> danhSachLinkAnhHangHoa1th = new ArrayList<>();
    private List<NhaCungCap> danhSachNhaCungCapMain = new ArrayList<>();
    private HangHoaService hangHoaService = new HangHoaService();
    private HinhAnhService hinhAnhService = new HinhAnhService();
    private NhaCungCapService nhaCungCapService = new NhaCungCapService();
    private ChiTietPhieuNhapHangService chiTietPhieuNhapHangService = new ChiTietPhieuNhapHangService();
    private PhieuNhapHangService phieuNhapHangService = new PhieuNhapHangService();
    /**
     * Creates new form frame_ChiTietTraHang
     */
    public Frame_taoDonNhapHang() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hienThiDanhSachHangHoaKhiDatHang();
        hienThiDanhSachNhaCungCapTaiCombobox(cbDatHang_danhSachKhachHang);
    }

    public void hienThiDanhSachHangHoaKhiDatHang(){
        try {
            danhSachHangHoaMain = hangHoaService.hienThiTatCaHangHoa("", "");
            for (HangHoa hangHoa : danhSachHangHoaMain){
                String imageFolder = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\Git_GarageOtoAnt_DoAn\\GarageOto_JavaSwingAnt\\DoAn_GarageOto_Ant\\src\\image\\";
                String tenHinh = hinhAnhService.hienThiHinhAnhTheoMaHangHoa(hangHoa.getMaHangHoa()).getTenHinh();
                File file = new File(imageFolder + tenHinh);
                danhSachLinkAnhHangHoa1th.add(imageFolder + tenHinh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame_taoDonNhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel recordTable = (DefaultTableModel)tbDatHang_danhSachHangHoa.getModel();
        recordTable.setRowCount(0);
        tbDatHang_danhSachHangHoa.getColumnModel().getColumn(0)
        .setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                // Ensure the value is an ImageIcon
                if (value instanceof ImageIcon) {
                    // Render the ImageIcon in a JLabel
                    JLabel label = new JLabel((ImageIcon) value);
                    label.setHorizontalAlignment(JLabel.CENTER); // Center the image
                    label.setOpaque(true); // Make the label opaque
                    label.setBackground(new Color(255, 255, 255, 0));
                    return label;
                } else {
                    // Return default renderer for other types
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });
        int index = 0;
        for (HangHoa hangHoa : danhSachHangHoaMain){
            if (hangHoa.getTonKho() <= 0){
                index++;
                continue;
            }
            Vector columnData = new Vector();
            
            try{
                String imageFolder = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\Git_GarageOtoAnt_DoAn\\GarageOto_JavaSwingAnt\\DoAn_GarageOto_Ant\\src\\image\\";
                File file = new File(danhSachLinkAnhHangHoa1th.get(index));
                BufferedImage originalImage = ImageIO.read(file);
                Image scaledImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                columnData.add(icon);
            } catch(Exception err){
                columnData.add("No Image");
            }
            columnData.add(hangHoa.getMaHangHoa());
            columnData.add(hangHoa.getTenHangHoa());
            columnData.add(hangHoa.getGiaBan());
            columnData.add(hangHoa.getTonKho());
            recordTable.addRow(columnData);
            index++;
        }
        
        // Assuming you already have a JTable named tbDatHang_danhSachHangHoa

        // Create a custom cell renderer for the button column
        TableColumn buttonColumn = tbDatHang_danhSachHangHoaDaChon.getColumnModel().getColumn(8);
        buttonColumn.setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = new JButton("Xóa");
                button.setBackground(Color.blue);
                Font font = new Font("Times New Roman", Font.BOLD, 16);
                button.setFont(font);   
                button.setForeground(Color.WHITE);
                return button;
            }
        });
        
        
        tbDatHang_danhSachHangHoaDaChon.getColumnModel().getColumn(4).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = new JButton("-");
                button.setBackground(Color.ORANGE);
                Font font = new Font("Times New Roman", Font.BOLD, 16);
                button.setFont(font);
                button.setForeground(Color.WHITE);
                return button;
            }
        });
        
        tbDatHang_danhSachHangHoaDaChon.getColumnModel().getColumn(6).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = new JButton("+");
                button.setBackground(Color.ORANGE);
                Font font = new Font("Times New Roman", Font.BOLD, 16);
                button.setFont(font);
                button.setForeground(Color.WHITE);
                return button;
            }
        });
        
        

        // Get the column model of the table
        TableColumnModel columnModel = tbDatHang_danhSachHangHoaDaChon.getColumnModel();
        // Get the column at the desired index
        TableColumn columnSL = columnModel.getColumn(5);
        // Set the preferred width of the column
        columnSL.setMaxWidth(30);
        columnSL.setMinWidth(30);
        
        TableColumn columnTangSL = columnModel.getColumn(6);
        // Set the preferred width of the column
        columnTangSL.setMaxWidth(45);
        columnTangSL.setMinWidth(45);
       
        TableColumn columnGiamSL = columnModel.getColumn(4);
        // Set the preferred width of the column
        columnGiamSL.setMaxWidth(45);
        columnGiamSL.setMinWidth(45);
        
        TableColumn columnXoa = columnModel.getColumn(8);
        // Set the preferred width of the column
        columnXoa.setMaxWidth(70);
        columnXoa.setMinWidth(70);
        
        TableColumn columnTonKho = columnModel.getColumn(2);
        // Set the preferred width of the column
        columnTonKho.setMaxWidth(110);
        columnTonKho.setMinWidth(110);

        
    }
    
    public void removeAllRowTableDanhSachHangDaChon(){
        DefaultTableModel model = (DefaultTableModel) tbDatHang_danhSachHangHoaDaChon.getModel();
        model.setRowCount(0);
    }

    
    public void hienThiDanhSachNhaCungCapTaiCombobox(JComboBox<String> comboBox){
        try {
            danhSachNhaCungCapMain = nhaCungCapService.hienThiTatCaNhaCungCap();
            comboBox.removeAllItems();
            comboBox.addItem("");
            for (NhaCungCap nhaCungCap : danhSachNhaCungCapMain){
                comboBox.addItem(nhaCungCap.getMaNhaCungCap() + " " + nhaCungCap.getTenNhaCungCap() + " " + nhaCungCap.getSoDienThoai());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame_taoDonNhapHang.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel9 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        tfDatHang_timHangHoa = new javax.swing.JTextField();
        lbDatHang_maDonHang = new javax.swing.JLabel();
        lbDatHang_maDonHang1 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDatHang_danhSachHangHoa = new javax.swing.JTable();
        jPanel102 = new javax.swing.JPanel();
        jPanel103 = new javax.swing.JPanel();
        jPanel106 = new javax.swing.JPanel();
        jPanel107 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        tfDatHang_timKhachHang = new javax.swing.JTextField();
        btnDatHang_themKhachHang = new javax.swing.JButton();
        btnDatHang_timKhachHang = new javax.swing.JButton();
        cbDatHang_danhSachKhachHang = new javax.swing.JComboBox<>();
        btnDatHang_datHang = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbDatHang_danhSachHangHoaDaChon = new javax.swing.JTable();
        jPanel250 = new javax.swing.JPanel();
        jLabel305 = new javax.swing.JLabel();
        tfDatHang_soLuong = new javax.swing.JLabel();
        jPanel242 = new javax.swing.JPanel();
        jLabel289 = new javax.swing.JLabel();
        tfDatHang_tongTienHang = new javax.swing.JLabel();
        jPanel247 = new javax.swing.JPanel();
        jLabel299 = new javax.swing.JLabel();
        tfDatHang_maKhachHang = new javax.swing.JLabel();
        jPanel252 = new javax.swing.JPanel();
        jLabel304 = new javax.swing.JLabel();
        tfDatHang_soDienThoai = new javax.swing.JLabel();
        jPanel253 = new javax.swing.JPanel();
        jLabel306 = new javax.swing.JLabel();
        tfDatHang_tenKhachHang = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel65.setBackground(new java.awt.Color(0, 153, 255));

        jPanel84.setBackground(new java.awt.Color(255, 255, 255));
        jPanel84.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfDatHang_timHangHoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfDatHang_timHangHoa.setForeground(new java.awt.Color(204, 204, 204));
        tfDatHang_timHangHoa.setText("Tìm hàng hóa");
        tfDatHang_timHangHoa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfDatHang_timHangHoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDatHang_timHangHoaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDatHang_timHangHoaFocusLost(evt);
            }
        });
        tfDatHang_timHangHoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDatHang_timHangHoaKeyReleased(evt);
            }
        });
        jPanel84.add(tfDatHang_timHangHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        lbDatHang_maDonHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDatHang_maDonHang.setForeground(new java.awt.Color(255, 255, 255));

        lbDatHang_maDonHang1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDatHang_maDonHang1.setForeground(new java.awt.Color(255, 255, 255));
        lbDatHang_maDonHang1.setText("Mã đơn hàng");

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel84, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1027, Short.MAX_VALUE)
                .addComponent(lbDatHang_maDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                    .addContainerGap(1249, Short.MAX_VALUE)
                    .addComponent(lbDatHang_maDonHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(173, 173, 173)))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDatHang_maDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel65Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbDatHang_maDonHang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel9.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 50));

        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbDatHang_danhSachHangHoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbDatHang_danhSachHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hình ảnh", "Mã hàng hóa", "Tên hàng hóa", "Giá bán", "Tồn kho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDatHang_danhSachHangHoa.setRowHeight(100);
        tbDatHang_danhSachHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatHang_danhSachHangHoaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDatHang_danhSachHangHoa);

        jPanel85.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 550));

        jPanel9.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 730, 570));

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, 400, -1));

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 590, -1, 20));

        jPanel106.setBackground(new java.awt.Color(255, 255, 255));
        jPanel106.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel107.setBackground(new java.awt.Color(255, 255, 255));
        jPanel107.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel107.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel101.setText("Tìm nhà cung cấp:");
        jPanel107.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 120, -1));

        tfDatHang_timKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfDatHang_timKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfDatHang_timKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfDatHang_timKhachHangMouseClicked(evt);
            }
        });
        jPanel107.add(tfDatHang_timKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 150, 20));

        btnDatHang_themKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.jpg"))); // NOI18N
        btnDatHang_themKhachHang.setBorder(null);
        btnDatHang_themKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHang_themKhachHangActionPerformed(evt);
            }
        });
        jPanel107.add(btnDatHang_themKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 20, 20));

        btnDatHang_timKhachHang.setBackground(new java.awt.Color(0, 102, 255));
        btnDatHang_timKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnDatHang_timKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnDatHang_timKhachHang.setText("Tìm");
        btnDatHang_timKhachHang.setBorder(null);
        btnDatHang_timKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHang_timKhachHangActionPerformed(evt);
            }
        });
        jPanel107.add(btnDatHang_timKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 50, 30));

        cbDatHang_danhSachKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbDatHang_danhSachKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDatHang_danhSachKhachHangActionPerformed(evt);
            }
        });
        jPanel107.add(cbDatHang_danhSachKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 300, -1));

        jPanel106.add(jPanel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 760, 40));

        btnDatHang_datHang.setBackground(new java.awt.Color(0, 153, 255));
        btnDatHang_datHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnDatHang_datHang.setForeground(new java.awt.Color(255, 255, 255));
        btnDatHang_datHang.setText("ĐẶT HÀNG");
        btnDatHang_datHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHang_datHangActionPerformed(evt);
            }
        });
        jPanel106.add(btnDatHang_datHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, 130, 40));

        tbDatHang_danhSachHangHoaDaChon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbDatHang_danhSachHangHoaDaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng hóa", "Tên hàng hóa", "Tồn kho", "Giá bán", "", "SL", "", "Thành tiền", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDatHang_danhSachHangHoaDaChon.setRowHeight(30);
        tbDatHang_danhSachHangHoaDaChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatHang_danhSachHangHoaDaChonMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbDatHang_danhSachHangHoaDaChon);

        jPanel106.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 340));

        jPanel250.setBackground(new java.awt.Color(255, 255, 255));
        jPanel250.setEnabled(false);

        jLabel305.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel305.setText("Tổng số lượng:");

        tfDatHang_soLuong.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfDatHang_soLuong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfDatHang_soLuong.setText("0");
        tfDatHang_soLuong.setEnabled(false);

        javax.swing.GroupLayout jPanel250Layout = new javax.swing.GroupLayout(jPanel250);
        jPanel250.setLayout(jPanel250Layout);
        jPanel250Layout.setHorizontalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel250Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel305)
                .addGap(18, 18, 18)
                .addComponent(tfDatHang_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel250Layout.setVerticalGroup(
            jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel250Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel250Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel305)
                    .addComponent(tfDatHang_soLuong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel106.add(jPanel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 277, -1));

        jPanel242.setBackground(new java.awt.Color(255, 255, 255));

        jLabel289.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel289.setText("Tổng tiền hàng:");

        tfDatHang_tongTienHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfDatHang_tongTienHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfDatHang_tongTienHang.setText("0");
        tfDatHang_tongTienHang.setEnabled(false);

        javax.swing.GroupLayout jPanel242Layout = new javax.swing.GroupLayout(jPanel242);
        jPanel242.setLayout(jPanel242Layout);
        jPanel242Layout.setHorizontalGroup(
            jPanel242Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel242Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel289)
                .addGap(18, 18, 18)
                .addComponent(tfDatHang_tongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel242Layout.setVerticalGroup(
            jPanel242Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel242Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel242Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel289)
                    .addComponent(tfDatHang_tongTienHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel106.add(jPanel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, -1, -1));

        jPanel247.setBackground(new java.awt.Color(255, 255, 255));

        jLabel299.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel299.setText("Mã khách hàng:");

        tfDatHang_maKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfDatHang_maKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfDatHang_maKhachHang.setText("id");
        tfDatHang_maKhachHang.setEnabled(false);

        javax.swing.GroupLayout jPanel247Layout = new javax.swing.GroupLayout(jPanel247);
        jPanel247.setLayout(jPanel247Layout);
        jPanel247Layout.setHorizontalGroup(
            jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel247Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel299)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDatHang_maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel247Layout.setVerticalGroup(
            jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel247Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel247Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel299)
                    .addComponent(tfDatHang_maKhachHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel106.add(jPanel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jPanel252.setBackground(new java.awt.Color(255, 255, 255));

        jLabel304.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel304.setText("Số điện thoại:");

        tfDatHang_soDienThoai.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfDatHang_soDienThoai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfDatHang_soDienThoai.setText("0865611515");
        tfDatHang_soDienThoai.setEnabled(false);

        javax.swing.GroupLayout jPanel252Layout = new javax.swing.GroupLayout(jPanel252);
        jPanel252.setLayout(jPanel252Layout);
        jPanel252Layout.setHorizontalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel252Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel304)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(tfDatHang_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel252Layout.setVerticalGroup(
            jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel252Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel252Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel304)
                    .addComponent(tfDatHang_soDienThoai))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel106.add(jPanel252, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 280, -1));

        jPanel253.setBackground(new java.awt.Color(255, 255, 255));
        jPanel253.setEnabled(false);

        jLabel306.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel306.setText("Tên khách hàng:");

        tfDatHang_tenKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfDatHang_tenKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfDatHang_tenKhachHang.setText("name");
        tfDatHang_tenKhachHang.setEnabled(false);

        javax.swing.GroupLayout jPanel253Layout = new javax.swing.GroupLayout(jPanel253);
        jPanel253.setLayout(jPanel253Layout);
        jPanel253Layout.setHorizontalGroup(
            jPanel253Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel253Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel306)
                .addGap(24, 24, 24)
                .addComponent(tfDatHang_tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel253Layout.setVerticalGroup(
            jPanel253Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel253Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel253Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel306)
                    .addComponent(tfDatHang_tenKhachHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel106.add(jPanel253, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jPanel9.add(jPanel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 790, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDatHang_timHangHoaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDatHang_timHangHoaFocusGained
        if (tfDatHang_timHangHoa.getText().equals("Tìm hàng hóa")){
            tfDatHang_timHangHoa.setText("");
            tfDatHang_timHangHoa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfDatHang_timHangHoaFocusGained

    private void tfDatHang_timHangHoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDatHang_timHangHoaFocusLost
        if (tfDatHang_timHangHoa.getText().equals("")){
            tfDatHang_timHangHoa.setText("Tìm hàng hóa");
            tfDatHang_timHangHoa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfDatHang_timHangHoaFocusLost

    private void tfDatHang_timHangHoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDatHang_timHangHoaKeyReleased
        String query = tfDatHang_timHangHoa.getText().toLowerCase();
        filterHangHoaDatHang(query);
    }//GEN-LAST:event_tfDatHang_timHangHoaKeyReleased

    private void tbDatHang_danhSachHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatHang_danhSachHangHoaMouseClicked
        int index0 = tbDatHang_danhSachHangHoa.getSelectedRow();
        int index = tbDatHang_danhSachHangHoa.convertRowIndexToModel(index0);
        TableModel modelTbDanhSachHangHoa = tbDatHang_danhSachHangHoa.getModel();
        int selectedRow = tbDatHang_danhSachHangHoa.getSelectedRow();
        DefaultTableModel modelTbDanhSachHangHoaDaChon = (DefaultTableModel) tbDatHang_danhSachHangHoaDaChon.getModel();

        for (int i = 0; i < modelTbDanhSachHangHoaDaChon.getRowCount(); i++) {
            Object value = modelTbDanhSachHangHoaDaChon.getValueAt(i, 0); // Get value from the first column
            if (value != null && value.toString().equals(modelTbDanhSachHangHoa.getValueAt(index, 1).toString())) {
                return;
            }
        }

        modelTbDanhSachHangHoaDaChon.addRow(new Object[]{
            modelTbDanhSachHangHoa.getValueAt(index, 1).toString(),
            modelTbDanhSachHangHoa.getValueAt(index, 2).toString(),
            modelTbDanhSachHangHoa.getValueAt(index, 4).toString(),
            modelTbDanhSachHangHoa.getValueAt(index, 3).toString(),
            "",
            1,
            "",
            modelTbDanhSachHangHoa.getValueAt(index, 3).toString()
        });
        long donGia = Long.parseLong(modelTbDanhSachHangHoa.getValueAt(selectedRow, 3).toString().split("\\.")[0]);
        tfDatHang_soLuong.setText(String.valueOf(Integer.parseInt(tfDatHang_soLuong.getText()) + 1));
        tfDatHang_tongTienHang.setText(String.valueOf(Long.parseLong(tfDatHang_tongTienHang.getText()) + donGia));

        //        phieuNhapHang.setPhieuNhapHang(model.getValueAt(index, 0).toString());
        //        phieuNhapHang.setThoiGian( util.localDateParseMethodWithoutNanosecond(model.getValueAt(index, 1).toString()));
        //        phieuNhapHang.setMaNhaCungCap(model.getValueAt(index, 2).toString());
        //        phieuNhapHang.setTong(Double.parseDouble(model.getValueAt(index, 3).toString()));
        //        phieuNhapHang.setNo(Double.parseDouble(model.getValueAt(index, 4).toString()));
        //        phieuNhapHang.setTrangThai(model.getValueAt(index, 5).toString());
    }//GEN-LAST:event_tbDatHang_danhSachHangHoaMouseClicked

    private void tfDatHang_timKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfDatHang_timKhachHangMouseClicked
        try {
            danhSachNhaCungCapMain = nhaCungCapService.hienThiTatCaNhaCungCap();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tfDatHang_timKhachHangMouseClicked

    private void btnDatHang_themKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang_themKhachHangActionPerformed
//        Frame_ThemKhachHang frame_themKhachHang = new Frame_ThemKhachHang();
//        frame_themKhachHang.setVisible(true);
//        frame_themKhachHang.setSize(950, 400);
//        frame_themKhachHang.setLocation(0,0);
    }//GEN-LAST:event_btnDatHang_themKhachHangActionPerformed

    private void btnDatHang_timKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang_timKhachHangActionPerformed
        String timKhachHang = tfDatHang_timKhachHang.getText();
        cbDatHang_danhSachKhachHang.removeAllItems();
        hienThiDanhSachNhaCungCapTaiCombobox(cbDatHang_danhSachKhachHang);

        // lúc thực hiện 2 dòng lệnh trên thì event performed cũng được thực hiện cùng lúc

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (int i = 0; i < cbDatHang_danhSachKhachHang.getItemCount(); i++) {

            String item = cbDatHang_danhSachKhachHang.getItemAt(i);
            if (item.toLowerCase().contains(timKhachHang.toLowerCase())) {
                model.addElement(item);

            }
        }
        cbDatHang_danhSachKhachHang.setModel(model);
        if (cbDatHang_danhSachKhachHang.getItemCount() == 0){
            tfDatHang_tenKhachHang.setText("");
            tfDatHang_soDienThoai.setText("");
            return;
        }
    }//GEN-LAST:event_btnDatHang_timKhachHangActionPerformed

    private void cbDatHang_danhSachKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDatHang_danhSachKhachHangActionPerformed
        try{
            String[] parts = cbDatHang_danhSachKhachHang.getSelectedItem().toString().split(" ");
            String tenKhachHang = "";
            tfDatHang_maKhachHang.setText(parts[0]);
            for (int j = 0 ; j < parts.length; j++){
                if (j == 0){
                    continue;
                } else if(j != parts.length - 1){
                    tenKhachHang += parts[j] + " ";
                }
                if(j == parts.length - 1){
                    tfDatHang_soDienThoai.setText(parts[j]);
                }
            }
            int soPhieuNhapHang = phieuNhapHangService.demSoPhieuNhapHang()+ 1;
            String maPhieuNhapHang = "PNH0" + soPhieuNhapHang;
            tfDatHang_tenKhachHang.setText(tenKhachHang);
            lbDatHang_maDonHang.setText(maPhieuNhapHang + tfDatHang_maKhachHang.getText().trim());

        } catch (Exception err){
            tfDatHang_tenKhachHang.setText("");
            tfDatHang_timKhachHang.setText("");
            tfDatHang_soDienThoai.setText("");
        }

    }//GEN-LAST:event_cbDatHang_danhSachKhachHangActionPerformed

    private void btnDatHang_datHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang_datHangActionPerformed
        NhaCungCap nhaCungCap = new NhaCungCap();

        try {
            nhaCungCap = nhaCungCapService.hienThiNhaCungCapTheoMaNhaCungCap(tfDatHang_maKhachHang.getText());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        String maPhieuNhapHang = lbDatHang_maDonHang.getText();
        List<ChiTietPhieuNhapHang> danhSachChiTietPhieuNhapHang = new ArrayList<>();
        for (int i =0; i< tbDatHang_danhSachHangHoaDaChon.getRowCount(); i++){
            ChiTietPhieuNhapHang chiTietPhieuNhapHang = new ChiTietPhieuNhapHang();
            chiTietPhieuNhapHang.setMaChiTietPhieuNhapHang(maPhieuNhapHang + "CTPNH0" + i);
            chiTietPhieuNhapHang.setGia_nhap(Double.parseDouble(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,3).toString()));
            chiTietPhieuNhapHang.setGiam_gia(0);
            chiTietPhieuNhapHang.setSo_luong(Short.parseShort(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,5).toString()));
            chiTietPhieuNhapHang.setThanh_tien(Double.parseDouble(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,7).toString()));
            chiTietPhieuNhapHang.setMaHangHoa(String.valueOf(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,0).toString()));
            chiTietPhieuNhapHang.setMaPhieuNhapHang(maPhieuNhapHang);
            chiTietPhieuNhapHang.setTenHangHoa(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,1).toString());
            danhSachChiTietPhieuNhapHang.add(chiTietPhieuNhapHang);
        }
        int tongSoLuong = Integer.parseInt(tfDatHang_soLuong.getText().toString());
        double tongTienHang = Double.parseDouble(tfDatHang_tongTienHang.getText().toString());
        Frame_ThanhToan frame_thanhToan = new Frame_ThanhToan(danhSachChiTietPhieuNhapHang, nhaCungCap, maPhieuNhapHang, tongSoLuong, tongTienHang, taoDonNhapHangInstance);
        frame_thanhToan.setVisible(true);
        frame_thanhToan.setSize(360, 650);
        frame_thanhToan.setLocation(1170,0);
    }//GEN-LAST:event_btnDatHang_datHangActionPerformed

    private void tbDatHang_danhSachHangHoaDaChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatHang_danhSachHangHoaDaChonMouseClicked
        int row = tbDatHang_danhSachHangHoaDaChon.rowAtPoint(evt.getPoint());
        int col = tbDatHang_danhSachHangHoaDaChon.columnAtPoint(evt.getPoint());
        TableModel model = tbDatHang_danhSachHangHoaDaChon.getModel();
        DefaultTableModel recordTable = (DefaultTableModel)tbDatHang_danhSachHangHoaDaChon.getModel();
        int selectedRow = tbDatHang_danhSachHangHoaDaChon.getSelectedRow();
        // Check if the click occurred on the specific row and column
        long donGia = Long.parseLong(model.getValueAt(selectedRow, 3).toString().split("\\.")[0]);
        long thanhTien = Long.parseLong(model.getValueAt(selectedRow, 7).toString().split("\\.")[0]);
        if (col == 8){
            int tongSoLuong = Integer.parseInt(tfDatHang_soLuong.getText());
            int soLuongDuocChon = Integer.parseInt(model.getValueAt(selectedRow, 5).toString());
            tfDatHang_soLuong.setText(String.valueOf(tongSoLuong - soLuongDuocChon));
            tfDatHang_tongTienHang.setText(String.valueOf(Long.parseLong(tfDatHang_tongTienHang.getText()) - thanhTien));
            recordTable.removeRow(selectedRow);

        }

        if (col == 4){
            int soLuong = Integer.parseInt(model.getValueAt(selectedRow, 5).toString()) - 1 ;

            if (soLuong < 1){
                soLuong = 1;
                return;
            }
            recordTable.setValueAt(soLuong , selectedRow, col + 1);
            recordTable.setValueAt(soLuong * donGia  , selectedRow, 7);
            tfDatHang_soLuong.setText(String.valueOf(Integer.parseInt(tfDatHang_soLuong.getText()) - 1));
            tfDatHang_tongTienHang.setText(String.valueOf(Long.parseLong(tfDatHang_tongTienHang.getText()) - donGia));
        }
        if (col == 6){
            int soLuong = Integer.parseInt(model.getValueAt(selectedRow, 5).toString().split("\\.")[0]) + 1 ;
            if (soLuong > Integer.parseInt(model.getValueAt(selectedRow, 2).toString().split("\\.")[0])){
                soLuong = Integer.parseInt(model.getValueAt(selectedRow, 2).toString().split("\\.")[0]);
                return;
            }
            recordTable.setValueAt(soLuong , selectedRow, col - 1);
            recordTable.setValueAt(soLuong * donGia  , selectedRow, 7);
            tfDatHang_soLuong.setText(String.valueOf(Integer.parseInt(tfDatHang_soLuong.getText()) + 1));
            tfDatHang_tongTienHang.setText(String.valueOf(Long.parseLong(tfDatHang_tongTienHang.getText()) + donGia));
        }
    }//GEN-LAST:event_tbDatHang_danhSachHangHoaDaChonMouseClicked

    public void filterHangHoaDatHang(String query){
        DefaultTableModel model = (DefaultTableModel) tbDatHang_danhSachHangHoa.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tbDatHang_danhSachHangHoa.setRowSorter(tr);
        
        RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Get the value in the second column (index 2) of the current row
                Object value = entry.getValue(2 );
                if (value != null) {
                    // Convert the value to lowercase string
                    String columnValue = value.toString().toLowerCase();
                    // Check if the column value contains the query string
                    return columnValue.contains(query.toLowerCase());
                }
                return false;
            }
        };

        
        tr.setRowFilter(rowFilter);
    }
    
    /**
     * @param args the command line arguments
     */
    static Frame_taoDonNhapHang taoDonNhapHangInstance;
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
            java.util.logging.Logger.getLogger(Frame_taoDonNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_taoDonNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_taoDonNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_taoDonNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                taoDonNhapHangInstance = new Frame_taoDonNhapHang();
                taoDonNhapHangInstance.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatHang_datHang;
    private javax.swing.JButton btnDatHang_themKhachHang;
    private javax.swing.JButton btnDatHang_timKhachHang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbDatHang_danhSachKhachHang;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel242;
    private javax.swing.JPanel jPanel247;
    private javax.swing.JPanel jPanel250;
    private javax.swing.JPanel jPanel252;
    private javax.swing.JPanel jPanel253;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbDatHang_maDonHang;
    private javax.swing.JLabel lbDatHang_maDonHang1;
    private javax.swing.JTable tbDatHang_danhSachHangHoa;
    private javax.swing.JTable tbDatHang_danhSachHangHoaDaChon;
    private javax.swing.JLabel tfDatHang_maKhachHang;
    private javax.swing.JLabel tfDatHang_soDienThoai;
    private javax.swing.JLabel tfDatHang_soLuong;
    private javax.swing.JLabel tfDatHang_tenKhachHang;
    private javax.swing.JTextField tfDatHang_timHangHoa;
    private javax.swing.JTextField tfDatHang_timKhachHang;
    private javax.swing.JLabel tfDatHang_tongTienHang;
    // End of variables declaration//GEN-END:variables
}
