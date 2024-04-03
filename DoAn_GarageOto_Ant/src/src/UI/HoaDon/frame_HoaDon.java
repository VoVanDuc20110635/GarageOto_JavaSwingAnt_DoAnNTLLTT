/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI.HoaDon;

import java.util.List;
import javax.swing.JFrame;
import src.Model.HoaDonChiTiet;
import src.Model.KhachHang;

/**
 *
 * @author WINDOWS 10
 */
public class Frame_HoaDon extends javax.swing.JFrame {
    
    private List<HoaDonChiTiet> danhSachHoaDonChiTiet;
    private KhachHang khachHang;
    private String maHoaDon;
    private int tongSoLuong;
    private double tongTienHang;
    double tienCanTra;
    double tienKhachTra;
    double tienThua;
    /**
     * Creates new form frame_HoaDon
     */
    public Frame_HoaDon() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Frame_HoaDon(List<HoaDonChiTiet> danhSachHoaDonChiTiet, KhachHang khachHang, String maHoaDon, int tongSoLuong, double tongTienHang, double tienCanTra, double tienKhachTra, double tienThua) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.danhSachHoaDonChiTiet = danhSachHoaDonChiTiet;
        this.khachHang = khachHang;
        this.maHoaDon = maHoaDon;
        this.tongSoLuong = tongSoLuong;
        this.tongTienHang = tongTienHang;
        this.tienCanTra = tienCanTra;
        this.tienKhachTra = tienKhachTra;
        this.tienThua = tienThua;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel174 = new javax.swing.JPanel();
        jPanel175 = new javax.swing.JPanel();
        jLabel230 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jPanel176 = new javax.swing.JPanel();
        jLabel233 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jPanel177 = new javax.swing.JPanel();
        jPanel200 = new javax.swing.JPanel();
        jLabel235 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jPanel217 = new javax.swing.JPanel();
        jLabel237 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jPanel218 = new javax.swing.JPanel();
        jLabel239 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jPanel219 = new javax.swing.JPanel();
        jLabel241 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        jPanel220 = new javax.swing.JPanel();
        jLabel244 = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        jPanel221 = new javax.swing.JPanel();
        jLabel246 = new javax.swing.JLabel();
        jLabel247 = new javax.swing.JLabel();
        jPanel222 = new javax.swing.JPanel();
        jLabel248 = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jPanel223 = new javax.swing.JPanel();
        jLabel250 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel254 = new javax.swing.JLabel();
        btnHoaDon_in = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane7.setToolTipText("");
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane7.setViewportBorder(new javax.swing.border.MatteBorder(null));

        jPanel174.setBackground(new java.awt.Color(255, 255, 255));
        jPanel174.setPreferredSize(new java.awt.Dimension(350, 756));
        jPanel174.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel175.setBackground(new java.awt.Color(255, 255, 255));

        jLabel230.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(153, 153, 153));
        jLabel230.setText("10/05/2023");
        jLabel230.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel231.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(153, 153, 153));
        jLabel231.setText("12:50");
        jLabel231.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel232.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(153, 153, 153));
        jLabel232.setText("Mã hóa đơn");
        jLabel232.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel175Layout = new javax.swing.GroupLayout(jPanel175);
        jPanel175.setLayout(jPanel175Layout);
        jPanel175Layout.setHorizontalGroup(
            jPanel175Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel175Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel230)
                .addGap(18, 18, 18)
                .addComponent(jLabel231, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel232, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel175Layout.setVerticalGroup(
            jPanel175Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel175Layout.createSequentialGroup()
                .addGroup(jPanel175Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel230)
                    .addComponent(jLabel231)
                    .addComponent(jLabel232))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel174.add(jPanel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, 30));

        jPanel176.setBackground(new java.awt.Color(255, 255, 255));
        jPanel176.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel233.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel233.setText("Nhân viên thanh toán:");

        jLabel234.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel234.setText("Hằng");

        javax.swing.GroupLayout jPanel176Layout = new javax.swing.GroupLayout(jPanel176);
        jPanel176.setLayout(jPanel176Layout);
        jPanel176Layout.setHorizontalGroup(
            jPanel176Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel176Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel233)
                .addGap(18, 18, 18)
                .addComponent(jLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel176Layout.setVerticalGroup(
            jPanel176Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel176Layout.createSequentialGroup()
                .addGroup(jPanel176Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel233)
                    .addComponent(jLabel234))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel174.add(jPanel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 340, 30));

        jPanel177.setBackground(new java.awt.Color(255, 255, 255));
        jPanel177.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel200.setBackground(new java.awt.Color(255, 255, 255));

        jLabel235.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel235.setText("Mã khách hàng:");

        jLabel236.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel236.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel236.setText("NAM 59 C1");

        javax.swing.GroupLayout jPanel200Layout = new javax.swing.GroupLayout(jPanel200);
        jPanel200.setLayout(jPanel200Layout);
        jPanel200Layout.setHorizontalGroup(
            jPanel200Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel200Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel235)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jLabel236, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel200Layout.setVerticalGroup(
            jPanel200Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel200Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel200Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel235)
                    .addComponent(jLabel236))
                .addContainerGap())
        );

        jPanel177.add(jPanel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jPanel217.setBackground(new java.awt.Color(255, 255, 255));

        jLabel237.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel237.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel237.setText("Lê Văn Nam");

        jLabel238.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel238.setText("Tên khách hàng:");

        javax.swing.GroupLayout jPanel217Layout = new javax.swing.GroupLayout(jPanel217);
        jPanel217.setLayout(jPanel217Layout);
        jPanel217Layout.setHorizontalGroup(
            jPanel217Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel217Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel238)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jLabel237, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel217Layout.setVerticalGroup(
            jPanel217Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel217Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel217Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel237)
                    .addComponent(jLabel238))
                .addContainerGap())
        );

        jPanel177.add(jPanel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 30));

        jPanel218.setBackground(new java.awt.Color(255, 255, 255));

        jLabel239.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel239.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel239.setText("086017884");

        jLabel240.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel240.setText("Số điện thoại:");

        javax.swing.GroupLayout jPanel218Layout = new javax.swing.GroupLayout(jPanel218);
        jPanel218.setLayout(jPanel218Layout);
        jPanel218Layout.setHorizontalGroup(
            jPanel218Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel218Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel240)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jLabel239, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel218Layout.setVerticalGroup(
            jPanel218Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel218Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel218Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel239)
                    .addComponent(jLabel240))
                .addContainerGap())
        );

        jPanel177.add(jPanel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 30));

        jPanel219.setBackground(new java.awt.Color(255, 255, 255));

        jLabel241.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel241.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel241.setText("600000");

        jLabel242.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel242.setText("Tổng tiền hàng");

        jLabel243.setBackground(new java.awt.Color(204, 204, 204));
        jLabel243.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel243.setText("2");

        javax.swing.GroupLayout jPanel219Layout = new javax.swing.GroupLayout(jPanel219);
        jPanel219.setLayout(jPanel219Layout);
        jPanel219Layout.setHorizontalGroup(
            jPanel219Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel219Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel242)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel243, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel241, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel219Layout.setVerticalGroup(
            jPanel219Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel219Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel219Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel241)
                    .addComponent(jLabel242)
                    .addComponent(jLabel243))
                .addContainerGap())
        );

        jPanel177.add(jPanel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, 30));

        jPanel220.setBackground(new java.awt.Color(255, 255, 255));

        jLabel244.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel244.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel244.setText("0");
        jLabel244.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel245.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel245.setText("Giảm giá");

        javax.swing.GroupLayout jPanel220Layout = new javax.swing.GroupLayout(jPanel220);
        jPanel220.setLayout(jPanel220Layout);
        jPanel220Layout.setHorizontalGroup(
            jPanel220Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel220Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel245)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jLabel244, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel220Layout.setVerticalGroup(
            jPanel220Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel220Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel220Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel244)
                    .addComponent(jLabel245))
                .addContainerGap())
        );

        jPanel177.add(jPanel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, 30));

        jPanel221.setBackground(new java.awt.Color(255, 255, 255));

        jLabel246.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel246.setForeground(new java.awt.Color(0, 102, 255));
        jLabel246.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel246.setText("600000");

        jLabel247.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel247.setText("Khách cần trả");

        javax.swing.GroupLayout jPanel221Layout = new javax.swing.GroupLayout(jPanel221);
        jPanel221.setLayout(jPanel221Layout);
        jPanel221Layout.setHorizontalGroup(
            jPanel221Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel221Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel247)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel246, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel221Layout.setVerticalGroup(
            jPanel221Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel221Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel221Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel246)
                    .addComponent(jLabel247))
                .addContainerGap())
        );

        jPanel177.add(jPanel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, -1, 30));

        jPanel222.setBackground(new java.awt.Color(255, 255, 255));

        jLabel248.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel248.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel248.setText("1000000");
        jLabel248.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel249.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel249.setText("Khách thanh toán");

        javax.swing.GroupLayout jPanel222Layout = new javax.swing.GroupLayout(jPanel222);
        jPanel222.setLayout(jPanel222Layout);
        jPanel222Layout.setHorizontalGroup(
            jPanel222Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel222Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel249)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jLabel248, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel222Layout.setVerticalGroup(
            jPanel222Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel222Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel222Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel248)
                    .addComponent(jLabel249))
                .addContainerGap())
        );

        jPanel177.add(jPanel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, -1, 30));

        jPanel223.setBackground(new java.awt.Color(255, 255, 255));
        jPanel223.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)));

        jLabel250.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel250.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel250.setText("1000000");

        jLabel251.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel251.setText("Tiền thừa trả khách");

        javax.swing.GroupLayout jPanel223Layout = new javax.swing.GroupLayout(jPanel223);
        jPanel223.setLayout(jPanel223Layout);
        jPanel223Layout.setHorizontalGroup(
            jPanel223Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel223Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel251, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel250, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel223Layout.setVerticalGroup(
            jPanel223Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel223Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel223Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel250)
                    .addComponent(jLabel251))
                .addGap(54, 54, 54))
        );

        jPanel177.add(jPanel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 330, 30));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane8.setViewportView(jTable4);

        jPanel177.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 330, 290));

        jPanel174.add(jPanel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 340, 600));

        jLabel254.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel254.setText("Cảm ơn và hẹn gặp lại!");
        jPanel174.add(jLabel254, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 670, 170, 30));

        btnHoaDon_in.setBackground(new java.awt.Color(153, 153, 153));
        btnHoaDon_in.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDon_in.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDon_in.setText("IN");
        jPanel174.add(btnHoaDon_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 710, 60, 30));

        jScrollPane7.setViewportView(jPanel174);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Frame_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_HoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoaDon_in;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JPanel jPanel174;
    private javax.swing.JPanel jPanel175;
    private javax.swing.JPanel jPanel176;
    private javax.swing.JPanel jPanel177;
    private javax.swing.JPanel jPanel200;
    private javax.swing.JPanel jPanel217;
    private javax.swing.JPanel jPanel218;
    private javax.swing.JPanel jPanel219;
    private javax.swing.JPanel jPanel220;
    private javax.swing.JPanel jPanel221;
    private javax.swing.JPanel jPanel222;
    private javax.swing.JPanel jPanel223;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
