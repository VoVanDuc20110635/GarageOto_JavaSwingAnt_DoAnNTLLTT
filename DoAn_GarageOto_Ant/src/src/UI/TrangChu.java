/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI;

import src.UI.HoaDon.Frame_HoaDonChiTiet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import src.Model.BangChamCong;
import src.Model.CaLam;
import src.Model.ChiNhanh;
import src.Model.HangHoa;
import src.Model.HinhAnh;
import src.Model.HoaDon;
import src.Model.HoaDonChiTiet;
import src.Model.KhachHang;
import src.Model.LoaiXe;
import src.Model.NhaCungCap;
import src.Model.NhanVien;
import src.Model.PhieuNhapHang;
import src.Model.PhieuSuaChua;
import src.Model.PhieuTraHang;
import src.Service.BangChamCongService;
import src.Service.CaLamService;
import src.Service.ChiNhanhServive;
import src.Service.HangHoaService;
import src.Service.HinhAnhService;
import src.Service.HoaDonService;
import src.Service.KhachHangService;
import src.Service.LoaiXeService;
import src.Service.NhaCungCapService;
import src.Service.NhanVienService;
import src.Service.PhieuNhapHangService;
import src.Service.PhieuSuaChuaService;
import src.Service.PhieuTraHangService;
import src.UI.HangHoa.Frame_ThemHangHoa;
import src.UI.HangHoa.Frame_chiTietHangHoa;
import src.UI.HangHoa.frame_ChiTietDonNhapHang;
import src.UI.HoaDon.Frame_ThanhToan;
import src.UI.KhachHang.Frame_ThemKhachHang;
import src.UI.TraHang.Frame_ChiTietPhieuTraHang2;
import src.Util.AlwaysOpenComboBoxUI;
import src.Util.ImportFileCSV;
import src.Util.Util;
import src.Util.WriteCSV;

/**
 *
 * @author WINDOWS 10
 */
public class TrangChu extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private PhieuNhapHangService phieuNhapHangService = new PhieuNhapHangService();
    private HangHoaService hangHoaService = new HangHoaService();
    private HinhAnhService hinhAnhService = new HinhAnhService();
    private HoaDonService hoaDonService = new HoaDonService();
    private NhanVienService nhanVienService = new NhanVienService();
    private NhaCungCapService nhaCungCapService = new NhaCungCapService();
    private KhachHangService khachHangService = new KhachHangService();
    private PhieuTraHangService phieuTraHangService = new PhieuTraHangService();
    private PhieuSuaChuaService phieuSuaChuaService = new PhieuSuaChuaService();
    private LoaiXeService loaiXeService = new LoaiXeService();
    private ChiNhanhServive chiNhanhService = new ChiNhanhServive();
    private BangChamCongService bangChamCongService = new BangChamCongService();
    private CaLamService caLamService = new CaLamService();
    
    private List<HangHoa> danhSachHangHoaMain = new ArrayList<>();
    private List<String> danhSachLinkAnhHangHoa1th = new ArrayList<>();
    private List<KhachHang> danhSachKhachHangMain = new ArrayList<>();
    private List<NhanVien> danhSachNhanVienMain = new ArrayList<>();
    
    private Util util = new Util();
    public TrangChu() {
        
        getContentPane().setBackground(Color.white);
        initComponents();
        setSize(1550,975);
        setLocation(0,0);
        try {
            hienThiDanhSachPhieuNhapHang();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                hienThiDanhSachHangHoa();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void resetDanhSachHangHoaMain() {
        try {
            this.danhSachHangHoaMain = hangHoaService.hienThiTatCaHangHoa("","");
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeAllRowTableDanhSachHangDaChon(){
        DefaultTableModel model = (DefaultTableModel) tbDatHang_danhSachHangHoaDaChon.getModel();
        model.setRowCount(0);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tabbedPane_trangChu = new javax.swing.JTabbedPane();
        jPanel26 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbHangHoa_loaiHang = new javax.swing.JComboBox<>();
        cbHangHoa_loaiHangDaChon = new javax.swing.JComboBox<>();
        jPanel30 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbHangHoa_loaiXe = new javax.swing.JComboBox<>();
        cbHangHoa_loaiXeDaChon = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        radioBtnHangHoa_conHangTrongKho = new javax.swing.JRadioButton();
        radioBtnHangHoa_hetHangTrongKho = new javax.swing.JRadioButton();
        jPanel33 = new javax.swing.JPanel();
        tfHangHoa_maHangHoa = new javax.swing.JTextField();
        tfHangHoa_timTheoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnHangHoa_them = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_danhSachHangHoa = new javax.swing.JTable();
        btnHangHoa_timKiem = new javax.swing.JButton();
        btnHangHoa_taiLai = new javax.swing.JButton();
        tabPane_giaoDich = new javax.swing.JTabbedPane();
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
        jPanel8 = new javax.swing.JPanel();
        jPanel91 = new javax.swing.JPanel();
        jPanel90 = new javax.swing.JPanel();
        tfHoaDon_timHoaDon = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jPanel124 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        cbHoaDon_nguoiTao = new javax.swing.JComboBox<>();
        jPanel126 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        dateChooseHoaDon_batDau = new com.toedter.calendar.JDateChooser();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        dateChooserHoaDon_ketThuc = new com.toedter.calendar.JDateChooser();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbHoaDon_danhSachHoaDon = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        btnHoaDon_taiLai = new javax.swing.JButton();
        btnHoaDon_timKiem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbTraHang_danhSachPhieuTraHang = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_danhSachPhieuSuaChua = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_capNhat = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lb_soDienThoai = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lb_tenKhachHang = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        cb_nhanVienSuaChua = new javax.swing.JComboBox<>();
        jPanel67 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tare_noiDungSuaChua = new javax.swing.JTextArea();
        jPanel69 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        cb_loaiXe = new javax.swing.JComboBox<>();
        jPanel68 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        cb_phuTungCanThay = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jPanel125 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jPanel127 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jScrollPane11 = new javax.swing.JScrollPane();
        tb_danhSachPhieuNhapHang = new javax.swing.JTable();
        jPanel128 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tabbedPane_doiTac = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jPanel93 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        tb_danhSachKhachHang = new javax.swing.JTable();
        jPanel72 = new javax.swing.JPanel();
        btnKhachHang_them = new javax.swing.JButton();
        btnKhachHoa_xuatFile = new javax.swing.JButton();
        btnKhachHang_import = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        tb_danhSachNhaCungCap = new javax.swing.JTable();
        jPanel74 = new javax.swing.JPanel();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        tabbedPane_nhanVien = new javax.swing.JTabbedPane();
        jPanel23 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jPanel95 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        tb_danhSachNhanVien = new javax.swing.JTable();
        jPanel76 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_danhSachChiNhanh = new javax.swing.JTable();
        jPanel44 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_danhSachBangChamCong = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        dateChooserChamCong_theongay_ngay = new com.toedter.calendar.JDateChooser();
        radioChamCong_theoNgay = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        yearChooserChamCong_theoNam_nam = new com.toedter.calendar.JYearChooser();
        radioChamCong_theoNam = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        monthChooser_theoThang_thang = new com.toedter.calendar.JMonthChooser();
        radioChamCong_theoThang = new javax.swing.JRadioButton();
        yearChooserChamCong_theoThang_nam = new com.toedter.calendar.JYearChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        dateChooserChamCong_ngayBatDau = new com.toedter.calendar.JDateChooser();
        jPanel78 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        dateChooserChamCong_ngayKetThuc = new com.toedter.calendar.JDateChooser();
        radioChamCong_khoangThoiGian = new javax.swing.JRadioButton();
        jPanel25 = new javax.swing.JPanel();
        btnChamCong_timKiem = new javax.swing.JButton();
        btnChamCong_taiLai = new javax.swing.JButton();
        jPanel79 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        dateChoose_bangCongNgayLam = new com.toedter.calendar.JDateChooser();
        jPanel89 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        lb_maBangChamCong = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        cb_bangCongTrangThai = new javax.swing.JComboBox<>();
        jPanel98 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        cb_bangCongCaLam = new javax.swing.JComboBox<>();
        btn_bangCongThem = new javax.swing.JButton();
        btn_bangCongCapNhat = new javax.swing.JButton();
        btn_bangCongReset = new javax.swing.JButton();
        jPanel96 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        cb_bangCongNhanVien = new javax.swing.JComboBox<>();
        jPanel27 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jPanel83 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jDateChooser10 = new com.toedter.calendar.JDateChooser();
        jRadioButton9 = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        jDateChooser11 = new com.toedter.calendar.JDateChooser();
        jRadioButton10 = new javax.swing.JRadioButton();
        jPanel18 = new javax.swing.JPanel();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jRadioButton11 = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Username");

        jLabel2.setText("Tên người dùng");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.jpg"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 210, 60));

        tabbedPane_trangChu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPane_trangChuStateChanged(evt);
            }
        });

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Loại hàng");

        cbHangHoa_loaiHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbHangHoa_loaiHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbHangHoa_loaiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHangHoa_loaiHangActionPerformed(evt);
            }
        });

        cbHangHoa_loaiHangDaChon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbHangHoa_loaiHangDaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHangHoa_loaiHangDaChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbHangHoa_loaiHang, 0, 152, Short.MAX_VALUE)
                    .addComponent(cbHangHoa_loaiHangDaChon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHangHoa_loaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHangHoa_loaiHangDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Loại xe");

        cbHangHoa_loaiXe.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbHangHoa_loaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbHangHoa_loaiXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHangHoa_loaiXeActionPerformed(evt);
            }
        });

        cbHangHoa_loaiXeDaChon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbHangHoa_loaiXeDaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHangHoa_loaiXeDaChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(cbHangHoa_loaiXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbHangHoa_loaiXeDaChon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHangHoa_loaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHangHoa_loaiXeDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setText("Tồn kho");

        buttonGroup2.add(radioBtnHangHoa_conHangTrongKho);
        radioBtnHangHoa_conHangTrongKho.setText("Còn hàng trong kho");

        buttonGroup2.add(radioBtnHangHoa_hetHangTrongKho);
        radioBtnHangHoa_hetHangTrongKho.setText("Hết hàng trong kho");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioBtnHangHoa_conHangTrongKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(radioBtnHangHoa_hetHangTrongKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioBtnHangHoa_conHangTrongKho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioBtnHangHoa_hetHangTrongKho)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        tfHangHoa_maHangHoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfHangHoa_maHangHoa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        tfHangHoa_timTheoTen.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfHangHoa_timTheoTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        tfHangHoa_timTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHangHoa_timTheoTenActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Nhập mã:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Nhập tên:");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfHangHoa_maHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfHangHoa_timTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tfHangHoa_maHangHoa)
                .addComponent(tfHangHoa_timTheoTen)
                .addComponent(jLabel5)
                .addComponent(jLabel7))
        );

        btnHangHoa_them.setBackground(new java.awt.Color(51, 204, 0));
        btnHangHoa_them.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHangHoa_them.setForeground(new java.awt.Color(255, 255, 255));
        btnHangHoa_them.setText("Thêm mới");
        btnHangHoa_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangHoa_themActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Import");

        tb_danhSachHangHoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hàng", "Hình ảnh", "Tên hàng", "Giá bán", "Giá vốn", "Tồn kho", "Khách đặt"
            }
        ));
        tb_danhSachHangHoa.setRowHeight(100);
        tb_danhSachHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachHangHoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_danhSachHangHoa);

        btnHangHoa_timKiem.setBackground(new java.awt.Color(0, 51, 255));
        btnHangHoa_timKiem.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHangHoa_timKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnHangHoa_timKiem.setText("TÌM KIẾM");
        btnHangHoa_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangHoa_timKiemActionPerformed(evt);
            }
        });

        btnHangHoa_taiLai.setBackground(new java.awt.Color(255, 153, 153));
        btnHangHoa_taiLai.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHangHoa_taiLai.setForeground(new java.awt.Color(255, 255, 255));
        btnHangHoa_taiLai.setText("TẢI LẠI");
        btnHangHoa_taiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangHoa_taiLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHangHoa_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHangHoa_taiLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHangHoa_them)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHangHoa_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnHangHoa_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(btnHangHoa_taiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        btnHangHoa_them.getAccessibleContext().setAccessibleName("btn_ThemHangHoa");

        tabbedPane_trangChu.addTab("Hàng hóa", jPanel26);

        tabPane_giaoDich.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPane_giaoDichStateChanged(evt);
            }
        });

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
        jLabel101.setText("Tìm khách hàng:");
        jPanel107.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 110, -1));

        tfDatHang_timKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfDatHang_timKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfDatHang_timKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfDatHang_timKhachHangMouseClicked(evt);
            }
        });
        jPanel107.add(tfDatHang_timKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 180, 20));

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

        tabPane_giaoDich.addTab("Đặt hàng", jPanel9);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel91.setBackground(new java.awt.Color(255, 255, 255));
        jPanel91.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel91.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel90.setBackground(new java.awt.Color(255, 255, 255));
        jPanel90.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel90.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfHoaDon_timHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfHoaDon_timHoaDon.setForeground(new java.awt.Color(204, 204, 204));
        tfHoaDon_timHoaDon.setText("Tìm hóa đơn theo tên người nộp/ nhận");
        tfHoaDon_timHoaDon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfHoaDon_timHoaDon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfHoaDon_timHoaDonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfHoaDon_timHoaDonFocusLost(evt);
            }
        });
        tfHoaDon_timHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfHoaDon_timHoaDonKeyReleased(evt);
            }
        });
        jPanel90.add(tfHoaDon_timHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 30));

        jPanel91.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel8.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 580, 40));

        jLabel110.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel110.setText("Hóa đơn");
        jPanel8.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel124.setBackground(new java.awt.Color(255, 255, 255));

        jLabel111.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel111.setText("Người tạo");

        cbHoaDon_nguoiTao.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbHoaDon_nguoiTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHoaDon_nguoiTaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel124Layout = new javax.swing.GroupLayout(jPanel124);
        jPanel124.setLayout(jPanel124Layout);
        jPanel124Layout.setHorizontalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel124Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel124Layout.createSequentialGroup()
                        .addComponent(cbHoaDon_nguoiTao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel124Layout.createSequentialGroup()
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 173, Short.MAX_VALUE))))
        );
        jPanel124Layout.setVerticalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel124Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHoaDon_nguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 250, 360));

        jPanel126.setBackground(new java.awt.Color(255, 255, 255));

        jLabel155.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel155.setText("Thời gian");

        dateChooseHoaDon_batDau.setDateFormatString("yyyy-MM-dd");

        jLabel156.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel156.setText("Bắt đầu");

        jLabel157.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel157.setText("Kết thúc");

        dateChooserHoaDon_ketThuc.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel126Layout = new javax.swing.GroupLayout(jPanel126);
        jPanel126.setLayout(jPanel126Layout);
        jPanel126Layout.setHorizontalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel126Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel126Layout.createSequentialGroup()
                        .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel126Layout.createSequentialGroup()
                        .addGroup(jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooseHoaDon_batDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateChooserHoaDon_ketThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        jPanel126Layout.setVerticalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel126Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel155)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooseHoaDon_batDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel156))
                .addGap(20, 20, 20)
                .addGroup(jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel157)
                    .addComponent(dateChooserHoaDon_ketThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 250, 120));

        tbHoaDon_danhSachHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbHoaDon_danhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Thời gian", "Mã trả hàng", "Nhân viên", "Người nộp/ nhận", "Loại thu chi", "Trạng thái", "Tổng tiền", "Giảm giá", "Tiền đã trả"
            }
        ));
        tbHoaDon_danhSachHoaDon.setRowHeight(30);
        tbHoaDon_danhSachHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDon_danhSachHoaDonMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbHoaDon_danhSachHoaDon);

        jPanel8.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 1230, 500));

        jButton17.setBackground(new java.awt.Color(102, 102, 102));
        jButton17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exportFile.png"))); // NOI18N
        jButton17.setText("Xuất file");
        jPanel8.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 590, -1, -1));

        btnHoaDon_taiLai.setBackground(new java.awt.Color(255, 153, 153));
        btnHoaDon_taiLai.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDon_taiLai.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDon_taiLai.setText("TẢI LẠI");
        btnHoaDon_taiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDon_taiLaiActionPerformed(evt);
            }
        });

        btnHoaDon_timKiem.setBackground(new java.awt.Color(0, 51, 255));
        btnHoaDon_timKiem.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHoaDon_timKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDon_timKiem.setText("TÌM KIẾM");
        btnHoaDon_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDon_timKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(btnHoaDon_timKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnHoaDon_taiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHoaDon_timKiem)
                    .addComponent(btnHoaDon_taiLai))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, -1));

        tabPane_giaoDich.addTab("Hóa đơn", jPanel8);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbTraHang_danhSachPhieuTraHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbTraHang_danhSachPhieuTraHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu trả hàng", "Mã hóa đơn", "Nhân Viên", "Thời gian", "Khách hàng/ Nhà cung cấp", "Cần trả ", "Đã trả", "Trạng thái"
            }
        ));
        tbTraHang_danhSachPhieuTraHang.setRowHeight(30);
        tbTraHang_danhSachPhieuTraHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTraHang_danhSachPhieuTraHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbTraHang_danhSachPhieuTraHang);

        jButton18.setBackground(new java.awt.Color(0, 204, 0));
        jButton18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exportFile.png"))); // NOI18N
        jButton18.setText("Xuất file");

        jButton19.setBackground(new java.awt.Color(0, 204, 0));
        jButton19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus2.png"))); // NOI18N
        jButton19.setText("Trả hàng");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1528, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton19)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        tabPane_giaoDich.addTab("Trả hàng", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_danhSachPhieuSuaChua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachPhieuSuaChua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Khách hàng", "Số điện thoại", "Loại xe", "Nội dung sửa chữa", "Phụ tùng cần thay", "Nhân viên", "Tổng tiền", "Trạng thái"
            }
        ));
        tb_danhSachPhieuSuaChua.setRowHeight(30);
        tb_danhSachPhieuSuaChua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachPhieuSuaChuaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_danhSachPhieuSuaChua);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 200, 1508, 403));

        btn_them.setBackground(new java.awt.Color(0, 204, 0));
        btn_them.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus2.png"))); // NOI18N
        btn_them.setText("Thêm");
        jPanel6.add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(1342, 23, 121, 35));

        btn_capNhat.setBackground(new java.awt.Color(0, 102, 255));
        btn_capNhat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_capNhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_capNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update.png"))); // NOI18N
        btn_capNhat.setText("Cập nhật");
        jPanel6.add(btn_capNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 80, 121, 35));

        btn_reset.setBackground(new java.awt.Color(255, 102, 102));
        btn_reset.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/return2.png"))); // NOI18N
        btn_reset.setText("Reset");
        jPanel6.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1342, 129, 121, 35));

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Số điện thoại:");

        lb_soDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lb_soDienThoai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_soDienThoai.setText("0");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lb_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lb_soDienThoai))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel51.setText("Khách hàng:");

        jButton3.setBackground(new java.awt.Color(0, 204, 0));
        jButton3.setForeground(new java.awt.Color(0, 204, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus2.png"))); // NOI18N

        lb_tenKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lb_tenKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tenKhachHang.setText("Name");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(lb_tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel51)
                        .addComponent(lb_tenKhachHang)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 320, 40));

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel52.setText("Nhân viên sữa chữa:");

        cb_nhanVienSuaChua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_nhanVienSuaChua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kiệt", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(cb_nhanVienSuaChua, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(cb_nhanVienSuaChua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 390, 40));

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel53.setText("Nội dung sửa chữa:");

        tare_noiDungSuaChua.setColumns(20);
        tare_noiDungSuaChua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tare_noiDungSuaChua.setRows(5);
        tare_noiDungSuaChua.setText("Nhập nội dung cần sữa");
        jScrollPane6.setViewportView(tare_noiDungSuaChua);

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel53)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 470, 140));

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel56.setText("Loại xe:");

        cb_loaiXe.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_loaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(cb_loaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(cb_loaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 390, 40));

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel54.setText("Phụ tùng cần thay:");

        cb_phuTungCanThay.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_phuTungCanThay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phuộc xe", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(cb_phuTungCanThay, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(cb_phuTungCanThay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 390, 40));

        tabPane_giaoDich.addTab("Yêu cầu sữa chửa", jPanel6);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel92.setBackground(new java.awt.Color(255, 255, 255));
        jPanel92.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel92.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.jpg"))); // NOI18N
        jPanel92.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        jTextField31.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextField31.setText("Lọc tự động");
        jTextField31.setBorder(null);
        jPanel92.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, -1));

        jTextField46.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField46.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel92.add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 430, -1));

        jPanel70.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 580, 40));

        jLabel112.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel112.setText("Phiếu nhập hàng");
        jPanel70.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel125.setBackground(new java.awt.Color(255, 255, 255));

        jLabel113.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel113.setText("Nhân viên");

        jLabel153.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel153.setText("Người tạo");

        jComboBox8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel125Layout = new javax.swing.GroupLayout(jPanel125);
        jPanel125.setLayout(jPanel125Layout);
        jPanel125Layout.setHorizontalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel125Layout.createSequentialGroup()
                        .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel125Layout.createSequentialGroup()
                        .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel125Layout.setVerticalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113)
                .addGap(13, 13, 13)
                .addGroup(jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel153)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel70.add(jPanel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 250, 140));

        jPanel127.setBackground(new java.awt.Color(255, 255, 255));

        jLabel158.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel158.setText("Thời gian");

        jLabel159.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel159.setText("Bắt đầu");

        jLabel160.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel160.setText("Kết thúc");

        javax.swing.GroupLayout jPanel127Layout = new javax.swing.GroupLayout(jPanel127);
        jPanel127.setLayout(jPanel127Layout);
        jPanel127Layout.setHorizontalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel127Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel127Layout.createSequentialGroup()
                        .addComponent(jLabel158, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel127Layout.createSequentialGroup()
                        .addGroup(jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel159, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser9, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jDateChooser8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        jPanel127Layout.setVerticalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel127Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel158)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel159))
                .addGap(20, 20, 20)
                .addGroup(jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel160)
                    .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel70.add(jPanel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 250, 120));

        tb_danhSachPhieuNhapHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachPhieuNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhập hàng", "Thời gian", "Nhà cung cấp", "Tổng", "Nợ", "Trạng thái"
            }
        ));
        tb_danhSachPhieuNhapHang.setRowHeight(30);
        tb_danhSachPhieuNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachPhieuNhapHangMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tb_danhSachPhieuNhapHang);

        jPanel70.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 1230, 560));

        jPanel128.setBackground(new java.awt.Color(255, 255, 255));

        jLabel114.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel114.setText("Trạng thái");

        jCheckBox11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jCheckBox11.setText("Đang chờ nhập hàng");

        jCheckBox12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jCheckBox12.setText("Đã nhập hàng");

        javax.swing.GroupLayout jPanel128Layout = new javax.swing.GroupLayout(jPanel128);
        jPanel128.setLayout(jPanel128Layout);
        jPanel128Layout.setHorizontalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel128Layout.setVerticalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel114)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox11)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox12)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel70.add(jPanel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 250, 130));

        jButton24.setBackground(new java.awt.Color(0, 204, 0));
        jButton24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus2.png"))); // NOI18N
        jButton24.setText("Thêm");

        jButton20.setBackground(new java.awt.Color(102, 102, 102));
        jButton20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exportFile.png"))); // NOI18N
        jButton20.setText("Xuất file");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel70.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, 230, 40));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1540, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 1520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabPane_giaoDich.addTab("Nhập hàng", jPanel4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng", "Tên hàng", "Số lượng"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1234, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(425, Short.MAX_VALUE))
        );

        tabPane_giaoDich.addTab("tab6", jPanel32);

        tabbedPane_trangChu.addTab("Giao dịch", tabPane_giaoDich);

        tabbedPane_doiTac.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPane_doiTacStateChanged(evt);
            }
        });

        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel93.setBackground(new java.awt.Color(255, 255, 255));
        jPanel93.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel93.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.jpg"))); // NOI18N
        jPanel93.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        jTextField32.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextField32.setText("Lọc tự động");
        jTextField32.setBorder(null);
        jPanel93.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, -1));

        jTextField47.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField47.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel93.add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 270, -1));

        jPanel71.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 420, 40));

        tb_danhSachKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Điện thoại", "Nợ hiện tại", "Tổng bán", "Tổng bán trừ trả hàng"
            }
        ));
        tb_danhSachKhachHang.setRowHeight(30);
        jScrollPane12.setViewportView(tb_danhSachKhachHang);

        jPanel71.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1520, 500));

        btnKhachHang_them.setBackground(new java.awt.Color(0, 204, 0));
        btnKhachHang_them.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnKhachHang_them.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHang_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus2.png"))); // NOI18N
        btnKhachHang_them.setText("Khách hàng");
        btnKhachHang_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHang_themActionPerformed(evt);
            }
        });

        btnKhachHoa_xuatFile.setBackground(new java.awt.Color(102, 102, 102));
        btnKhachHoa_xuatFile.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnKhachHoa_xuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHoa_xuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exportFile.png"))); // NOI18N
        btnKhachHoa_xuatFile.setText("Xuất file");
        btnKhachHoa_xuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHoa_xuatFileActionPerformed(evt);
            }
        });

        btnKhachHang_import.setBackground(new java.awt.Color(102, 102, 102));
        btnKhachHang_import.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnKhachHang_import.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHang_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exportFile.png"))); // NOI18N
        btnKhachHang_import.setText("Import");
        btnKhachHang_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHang_importActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKhachHang_them)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnKhachHang_import)
                .addGap(27, 27, 27)
                .addComponent(btnKhachHoa_xuatFile)
                .addGap(14, 14, 14))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKhachHang_them, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachHoa_xuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachHang_import, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel71.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 430, 40));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1540, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, 1520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabbedPane_doiTac.addTab("Khách hàng", jPanel11);

        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel94.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.jpg"))); // NOI18N
        jPanel94.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        jTextField33.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextField33.setText("Lọc tự động");
        jTextField33.setBorder(null);
        jPanel94.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, -1));

        jTextField48.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField48.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel94.add(jTextField48, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 270, -1));

        jPanel73.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 420, 40));

        tb_danhSachNhaCungCap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Điện thoại", "Email", "Nợ cần trả", "Tổng mua"
            }
        ));
        tb_danhSachNhaCungCap.setRowHeight(30);
        jScrollPane13.setViewportView(tb_danhSachNhaCungCap);

        jPanel73.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1520, 500));

        jButton27.setBackground(new java.awt.Color(0, 204, 0));
        jButton27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus2.png"))); // NOI18N
        jButton27.setText("Nhà cung cấp");

        jButton28.setBackground(new java.awt.Color(102, 102, 102));
        jButton28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exportFile.png"))); // NOI18N
        jButton28.setText("Xuất file");

        jButton29.setBackground(new java.awt.Color(0, 204, 0));
        jButton29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        jButton29.setText("Import");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton29)
                .addGap(26, 26, 26)
                .addComponent(jButton28)
                .addContainerGap())
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel73.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 420, 40));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1540, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, 1520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabbedPane_doiTac.addTab("Nhà cung cấp", jPanel12);

        tabbedPane_trangChu.addTab("Đối tác", tabbedPane_doiTac);

        tabbedPane_nhanVien.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPane_nhanVienStateChanged(evt);
            }
        });

        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel95.setBackground(new java.awt.Color(255, 255, 255));
        jPanel95.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel95.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.jpg"))); // NOI18N
        jPanel95.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        jTextField34.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextField34.setText("Lọc tự động");
        jTextField34.setBorder(null);
        jPanel95.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, -1));

        jTextField49.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField49.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel95.add(jTextField49, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 270, -1));

        jPanel75.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 420, 40));

        tb_danhSachNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "CMND/CCCD", "Chức vụ", "Cơ sở làm việc", "Nợ lương"
            }
        ));
        tb_danhSachNhanVien.setRowHeight(30);
        jScrollPane14.setViewportView(tb_danhSachNhanVien);

        jPanel75.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1520, 390));

        jButton32.setBackground(new java.awt.Color(0, 204, 0));
        jButton32.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus2.png"))); // NOI18N
        jButton32.setText("Nhân viên");

        jButton33.setBackground(new java.awt.Color(102, 102, 102));
        jButton33.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton33.setForeground(new java.awt.Color(255, 255, 255));
        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exportFile.png"))); // NOI18N
        jButton33.setText("Xuất file");

        jButton34.setBackground(new java.awt.Color(0, 204, 0));
        jButton34.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        jButton34.setText("Import");

        jButton35.setBackground(new java.awt.Color(0, 204, 0));
        jButton35.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus2.png"))); // NOI18N
        jButton35.setText("Chi nhánh");

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jButton35)
                .addGap(18, 18, 18)
                .addComponent(jButton32)
                .addGap(26, 26, 26)
                .addComponent(jButton34)
                .addGap(26, 26, 26)
                .addComponent(jButton33)
                .addContainerGap())
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel75.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 550, 40));

        tb_danhSachChiNhanh.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachChiNhanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã chi nhánh", "Tên chi nhánh", "Địa chỉ", "Trạng thái"
            }
        ));
        jScrollPane8.setViewportView(tb_danhSachChiNhanh);

        jPanel75.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 1520, 110));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel20.setText("Danh sách chi nhánh");
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel75.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 200, 30));

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel55.setText("Danh sách nhân viên");
        jLabel55.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addComponent(jLabel55)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel75.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 30));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1540, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                    .addContainerGap(10, Short.MAX_VALUE)
                    .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, 1520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(10, Short.MAX_VALUE)))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tabbedPane_nhanVien.addTab("Nhân viên/ Chi nhánh", jPanel23);

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_danhSachBangChamCong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachBangChamCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã bảng", "Ngày làm", "Mã nhân viên", "Tên nhân viên", "Ca làm", "Trạng thái"
            }
        ));
        tb_danhSachBangChamCong.setRowHeight(30);
        tb_danhSachBangChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachBangChamCongMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tb_danhSachBangChamCong);

        jPanel24.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 139, 1248, 374));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        dateChooserChamCong_theongay_ngay.setDateFormatString("yyyy-MM-dd");
        dateChooserChamCong_theongay_ngay.setEnabled(false);
        dateChooserChamCong_theongay_ngay.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        buttonGroup2.add(radioChamCong_theoNgay);
        radioChamCong_theoNgay.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        radioChamCong_theoNgay.setText("Theo ngày");
        radioChamCong_theoNgay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioChamCong_theoNgayStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioChamCong_theoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateChooserChamCong_theongay_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioChamCong_theoNgay)
                    .addComponent(dateChooserChamCong_theongay_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 296, 262, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        yearChooserChamCong_theoNam_nam.setEnabled(false);

        buttonGroup2.add(radioChamCong_theoNam);
        radioChamCong_theoNam.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        radioChamCong_theoNam.setText("Theo năm");
        radioChamCong_theoNam.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioChamCong_theoNamStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioChamCong_theoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(yearChooserChamCong_theoNam_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioChamCong_theoNam)
                    .addComponent(yearChooserChamCong_theoNam_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 467, 262, -1));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        monthChooser_theoThang_thang.setEnabled(false);
        monthChooser_theoThang_thang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        buttonGroup2.add(radioChamCong_theoThang);
        radioChamCong_theoThang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        radioChamCong_theoThang.setText("Theo tháng");
        radioChamCong_theoThang.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioChamCong_theoThangStateChanged(evt);
            }
        });

        yearChooserChamCong_theoThang_nam.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioChamCong_theoThang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(yearChooserChamCong_theoThang_nam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monthChooser_theoThang_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioChamCong_theoThang)
                    .addComponent(monthChooser_theoThang_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yearChooserChamCong_theoThang_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 260, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel77.setBackground(new java.awt.Color(255, 255, 255));

        jLabel60.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel60.setText("Ngày bắt đầu");

        dateChooserChamCong_ngayBatDau.setDateFormatString("yyyy-MM-dd");
        dateChooserChamCong_ngayBatDau.setEnabled(false);
        dateChooserChamCong_ngayBatDau.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(dateChooserChamCong_ngayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addGap(12, 12, 12)
                .addComponent(dateChooserChamCong_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));

        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel61.setText("Ngày kết thúc");

        dateChooserChamCong_ngayKetThuc.setDateFormatString("yyyy-MM-dd");
        dateChooserChamCong_ngayKetThuc.setEnabled(false);
        dateChooserChamCong_ngayKetThuc.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel78Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(dateChooserChamCong_ngayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel78Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(dateChooserChamCong_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonGroup2.add(radioChamCong_khoangThoiGian);
        radioChamCong_khoangThoiGian.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        radioChamCong_khoangThoiGian.setText("Theo khoảng thời gian");
        radioChamCong_khoangThoiGian.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioChamCong_khoangThoiGianStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioChamCong_khoangThoiGian)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioChamCong_khoangThoiGian)
                .addGap(5, 5, 5)
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 83, 262, -1));

        btnChamCong_timKiem.setBackground(new java.awt.Color(0, 153, 153));
        btnChamCong_timKiem.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnChamCong_timKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnChamCong_timKiem.setText("Tìm kiếm");
        btnChamCong_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamCong_timKiemActionPerformed(evt);
            }
        });

        btnChamCong_taiLai.setBackground(new java.awt.Color(255, 102, 102));
        btnChamCong_taiLai.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnChamCong_taiLai.setForeground(new java.awt.Color(255, 255, 255));
        btnChamCong_taiLai.setText("Tải lại");
        btnChamCong_taiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamCong_taiLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(btnChamCong_timKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnChamCong_taiLai))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChamCong_timKiem)
                    .addComponent(btnChamCong_taiLai))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 27, 262, -1));

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));

        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel57.setText("Tổng nhân viên");

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel58.setText("10");

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(1283, 519, -1, -1));

        jPanel80.setBackground(new java.awt.Color(255, 255, 255));

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel59.setText("Tổng lương");

        jLabel62.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel62.setText("10");

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel62))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(1283, 557, -1, -1));

        jPanel81.setBackground(new java.awt.Color(255, 255, 255));

        jLabel63.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel63.setText("Tổng nợ");

        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel64.setText("10");

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(1283, 595, 240, -1));

        jPanel88.setBackground(new java.awt.Color(255, 255, 255));

        jLabel91.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel91.setText("Ngày làm");

        dateChoose_bangCongNgayLam.setDateFormatString("yyyy-MM-dd");
        dateChoose_bangCongNgayLam.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel91)
                .addGap(18, 18, 18)
                .addComponent(dateChoose_bangCongNgayLam, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChoose_bangCongNgayLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 27, -1, -1));

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));

        jLabel92.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel92.setText("Mã bảng");

        lb_maBangChamCong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lb_maBangChamCong.setText("BCC");

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_maBangChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(lb_maBangChamCong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 80, 320, -1));

        jPanel97.setBackground(new java.awt.Color(255, 255, 255));

        jLabel94.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel94.setText("Trạng thái");

        cb_bangCongTrangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_bangCongTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đầy đủ", "Vắng", "Đi trễ", "Tăng ca" }));

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel94)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(cb_bangCongTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(cb_bangCongTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 27, -1, -1));

        jPanel98.setBackground(new java.awt.Color(255, 255, 255));

        jLabel95.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel95.setText("Ca làm");

        cb_bangCongCaLam.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_bangCongCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca Sáng", "Ca Chiều", "Ca Tối" }));

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cb_bangCongCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(cb_bangCongCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 78, 306, -1));

        btn_bangCongThem.setBackground(new java.awt.Color(0, 204, 51));
        btn_bangCongThem.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_bangCongThem.setForeground(new java.awt.Color(255, 255, 255));
        btn_bangCongThem.setText("Thêm");
        btn_bangCongThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bangCongThemActionPerformed(evt);
            }
        });
        jPanel24.add(btn_bangCongThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1271, 27, 116, 39));

        btn_bangCongCapNhat.setBackground(new java.awt.Color(255, 153, 153));
        btn_bangCongCapNhat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_bangCongCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_bangCongCapNhat.setText("Cập nhật");
        btn_bangCongCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bangCongCapNhatActionPerformed(evt);
            }
        });
        jPanel24.add(btn_bangCongCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1271, 78, 116, 43));

        btn_bangCongReset.setBackground(new java.awt.Color(0, 102, 255));
        btn_bangCongReset.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btn_bangCongReset.setForeground(new java.awt.Color(255, 255, 255));
        btn_bangCongReset.setText("Reset");
        btn_bangCongReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bangCongResetActionPerformed(evt);
            }
        });
        jPanel24.add(btn_bangCongReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1405, 27, 116, 39));

        jPanel96.setBackground(new java.awt.Color(255, 255, 255));

        jLabel93.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel93.setText("Nhân viên");

        cb_bangCongNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_bangCongNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NV001 Anh" }));

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cb_bangCongNhanVien, 0, 213, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(cb_bangCongNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 27, -1, -1));

        tabbedPane_nhanVien.addTab("Chấm công", jPanel24);

        tabbedPane_trangChu.addTab("Nhân sự", tabbedPane_nhanVien);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel35.setToolTipText("");
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("KẾT QUẢ BÁN HÀNG NGÀY HÔM NAY");
        jPanel35.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, -1));

        jLabel23.setText("Nhập hàng");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 102, 102));
        jLabel22.setText("0");

        jLabel21.setText("0 phiếu");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(14, 14, 14)
                .addComponent(jLabel22)
                .addGap(15, 15, 15)
                .addComponent(jLabel23)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 170, 100));

        jLabel14.setText("1 hóa đơn thu tiền");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("250000");

        jLabel16.setText("Doanh thu");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dollars.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel15))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(4, 4, 4)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15)))
                .addGap(10, 10, 10)
                .addComponent(jLabel16)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 160, -1));

        jLabel70.setText("Lợi nhuận");

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/return.png"))); // NOI18N

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 102, 102));
        jLabel72.setText("0");

        jLabel75.setText("0 phiếu");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel72))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75)
                .addGap(4, 4, 4)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel72)))
                .addGap(10, 10, 10)
                .addComponent(jLabel70)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 40, 160, 100));

        jLabel76.setText("Khách trả hàng");

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/return.png"))); // NOI18N

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 102, 102));
        jLabel78.setText("0");

        jLabel79.setText("0 phiếu");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel78))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79)
                .addGap(4, 4, 4)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel78)))
                .addGap(10, 10, 10)
                .addComponent(jLabel76)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 170, 100));

        jLabel80.setText("Trả hàng về NCC");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 102, 102));
        jLabel81.setText("0");

        jLabel82.setText("0 phiếu");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel81)
                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82)
                .addGap(14, 14, 14)
                .addComponent(jLabel81)
                .addGap(15, 15, 15)
                .addComponent(jLabel80)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 170, 100));

        jLabel83.setText("Chi phí");

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/return.png"))); // NOI18N

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 102, 102));
        jLabel85.setText("0");

        jLabel86.setText("0 phiếu");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel85))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86)
                .addGap(4, 4, 4)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel85)))
                .addGap(10, 10, 10)
                .addComponent(jLabel83)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 160, 100));

        jLabel87.setText("Lương nhân viên");

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/return.png"))); // NOI18N

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 102, 102));
        jLabel89.setText("0");

        jLabel90.setText("0 phiếu");

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel86Layout.createSequentialGroup()
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel89))
                    .addGroup(jPanel86Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90)
                .addGap(4, 4, 4)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel86Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel89)))
                .addGap(10, 10, 10)
                .addComponent(jLabel87)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, 160, 100));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Doanh thu");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(421, Short.MAX_VALUE))
        );

        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel67.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jPanel82.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel68.setText("Ngày bắt đầu");

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel82Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel82Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68)
                .addGap(12, 12, 12)
                .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel69.setText("Ngày kết thúc");

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel83Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jDateChooser10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jRadioButton9.setText("Theo khoảng thời gian");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jRadioButton9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton9)
                .addGap(5, 5, 5)
                .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        buttonGroup1.add(jRadioButton10);
        jRadioButton10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jRadioButton10.setText("Theo ngày");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton10)
                    .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jMonthChooser2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        buttonGroup1.add(jRadioButton11);
        jRadioButton11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jRadioButton11.setText("Theo tháng");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jMonthChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton11)
                    .addComponent(jMonthChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        buttonGroup1.add(jRadioButton12);
        jRadioButton12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jRadioButton12.setText("Theo năm");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton12)
                    .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabbedPane_trangChu.addTab("Doanh thu", jPanel27);

        getContentPane().add(tabbedPane_trangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1540, 700));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Screenshot 2024-02-26 152859.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 50));
        jLabel4.getAccessibleContext().setAccessibleName("m");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHangHoa_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHoa_themActionPerformed
        Frame_ThemHangHoa frame_themHangHoa = new Frame_ThemHangHoa();
        frame_themHangHoa.setVisible(true);
        frame_themHangHoa.setSize(850, 460);
        frame_themHangHoa.setLocation(0,0);
    }//GEN-LAST:event_btnHangHoa_themActionPerformed

    private void btnDatHang_themKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang_themKhachHangActionPerformed
        Frame_ThemKhachHang frame_themKhachHang = new Frame_ThemKhachHang();
        frame_themKhachHang.setVisible(true);
        frame_themKhachHang.setSize(950, 400);
        frame_themKhachHang.setLocation(0,0);
    }//GEN-LAST:event_btnDatHang_themKhachHangActionPerformed

    private void tb_danhSachPhieuNhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachPhieuNhapHangMouseClicked
        int index = tb_danhSachPhieuNhapHang.getSelectedRow();
        TableModel model = tb_danhSachPhieuNhapHang.getModel();
        PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
        try {
            phieuNhapHang = phieuNhapHangService.layPhieuNhapHangDuaTrenMaPhieuNhapHang(model.getValueAt(index, 0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
//        phieuNhapHang.setPhieuNhapHang(model.getValueAt(index, 0).toString());
//        phieuNhapHang.setThoiGian( util.localDateParseMethodWithoutNanosecond(model.getValueAt(index, 1).toString()));
//        phieuNhapHang.setMaNhaCungCap(model.getValueAt(index, 2).toString());
//        phieuNhapHang.setTong(Double.parseDouble(model.getValueAt(index, 3).toString()));
//        phieuNhapHang.setNo(Double.parseDouble(model.getValueAt(index, 4).toString()));
//        phieuNhapHang.setTrangThai(model.getValueAt(index, 5).toString());
        frame_ChiTietDonNhapHang frame_chiTietDonNhapHang = new frame_ChiTietDonNhapHang(phieuNhapHang);
        frame_chiTietDonNhapHang.setVisible(true);
        frame_chiTietDonNhapHang.setSize(1000, 710);
        frame_chiTietDonNhapHang.setLocation(0,0);
    }//GEN-LAST:event_tb_danhSachPhieuNhapHangMouseClicked

    private void tabPane_giaoDichStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPane_giaoDichStateChanged
        int selectedIndex = tabPane_giaoDich.getSelectedIndex();
        if (selectedIndex == 1 && tabbedPane_trangChu.getSelectedIndex() == 1) { // Change 1 to the index of your specific tab
            hienThiDanhSachHoaDon();
            hienThiDanhSachNhanVienCombobox(cbHoaDon_nguoiTao);
        } 
        if (selectedIndex == 2 && tabbedPane_trangChu.getSelectedIndex() == 1){
            hienThiDanhSachPhieuTraHang();
        }
        if (selectedIndex == 3 && tabbedPane_trangChu.getSelectedIndex() == 1){
            List<LoaiXe> danhSachLoaiXe = new ArrayList<>();
            try {
                danhSachLoaiXe = loaiXeService.hienThiTatCaLoaiXe();
            } catch (SQLException ex) {
                System.out.println("Loi hien thi combobox loai xe");
            }
            cb_loaiXe.removeAllItems();
            for (LoaiXe loaiXe : danhSachLoaiXe) {
                cb_loaiXe.addItem(loaiXe.getTenLoaiXe());
            }
            
            List<NhanVien> danhSachNhanVien = new ArrayList<>();
            try {
                danhSachNhanVien = nhanVienService.hienThiTatCaNhanVien();
            } catch (SQLException ex) {
                System.out.println("Loi hien thi combobox nhan vien sua chua");
            }
            cb_nhanVienSuaChua.removeAllItems();
            for (NhanVien nhanVien : danhSachNhanVien) {
                cb_nhanVienSuaChua.addItem(nhanVien.getTenNhanVien());
            }
            
            List<HangHoa> danhSachHangHoa = new ArrayList<>();
            try {
                danhSachHangHoa = hangHoaService.hienThiTatCaHangHoa("","");
            } catch (SQLException ex) {
                System.out.println("Loi hien thi combobox hang hoa");
            }
            cb_phuTungCanThay.removeAllItems();
            for (HangHoa hangHoa : danhSachHangHoa) {
                cb_phuTungCanThay.addItem(hangHoa.getTenHangHoa());
            }
            hienThiDanhSachPhieuSuaChua();
        }
    }//GEN-LAST:event_tabPane_giaoDichStateChanged

    private void tb_danhSachPhieuSuaChuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachPhieuSuaChuaMouseClicked
        int index = tb_danhSachPhieuSuaChua.getSelectedRow();
        TableModel model = tb_danhSachPhieuSuaChua.getModel();
        lb_tenKhachHang.setText(model.getValueAt(index, 0).toString());
        lb_soDienThoai.setText(model.getValueAt(index, 1).toString());
        cb_loaiXe.setSelectedItem(model.getValueAt(index, 2).toString());
        tare_noiDungSuaChua.setText(model.getValueAt(index, 3).toString());
        cb_phuTungCanThay.setSelectedItem(model.getValueAt(index, 4).toString());
        cb_nhanVienSuaChua.setSelectedItem(model.getValueAt(index, 5).toString());
    }//GEN-LAST:event_tb_danhSachPhieuSuaChuaMouseClicked

    private void tabbedPane_doiTacStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPane_doiTacStateChanged
        
        int selectedIndex = tabbedPane_doiTac.getSelectedIndex();
        int selectedIndexMain = tabbedPane_trangChu.getSelectedIndex();
        if (selectedIndex == 0 && selectedIndexMain == 2) { // Change 1 to the index of your specific tab
            hienThiDanhSachKhachHang();
        }
        
        if (selectedIndex == 1 && selectedIndexMain == 2) { // Change 1 to the index of your specific tab
            hienThiDanhSachNhaCungCap();
        }
    }//GEN-LAST:event_tabbedPane_doiTacStateChanged

    private void tabbedPane_trangChuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPane_trangChuStateChanged
        int selectedTab = tabbedPane_trangChu.getSelectedIndex();
        
        if (selectedTab == 3 && tabbedPane_nhanVien.getSelectedIndex() == 0){
            hienThiDanhSachNhanVien();
            hienThiDanhSachChiNhanh();
        }
        if (selectedTab == 1 && tabPane_giaoDich.getSelectedIndex() == 0){
            hienThiDanhSachHangHoaKhiDatHang();
            hienThiDanhSachKhachHangTaiCombobox(cbDatHang_danhSachKhachHang);
//            int soHoaDon = 0;
//            try {
//                soHoaDon = hoaDonService.demSoHoaDon() + 1;
//            } catch (SQLException ex) {
//                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            lbDatHang_maDonHang.setText(lbDatHang_maDonHang.getText() + " " + "HD0" + soHoaDon);
            
        }
        if (selectedTab == 2 && tabbedPane_doiTac.getSelectedIndex() == 0){
            hienThiDanhSachKhachHang();
        }
    }//GEN-LAST:event_tabbedPane_trangChuStateChanged

    private void tabbedPane_nhanVienStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPane_nhanVienStateChanged
        
        int selectedTab = tabbedPane_nhanVien.getSelectedIndex();
        if (selectedTab == 1 && tabbedPane_trangChu.getSelectedIndex() == 3){
            hienThiDanhSachBangChamCong();
            try {
                List<NhanVien> danhSachNhanVien = nhanVienService.hienThiTatCaNhanVien();
                cb_bangCongNhanVien.removeAllItems();
                cb_bangCongNhanVien.addItem("");
                for (NhanVien nhanVien : danhSachNhanVien) {
                    cb_bangCongNhanVien.addItem(nhanVien.getMaNhanVien() + " " + nhanVien.getTenNhanVien());
                }
                List <CaLam> danhSachCaLam = caLamService.hienThiTatCaCaLam();
                cb_bangCongCaLam.removeAllItems();
                for(CaLam calam : danhSachCaLam){
                    cb_bangCongCaLam.addItem(calam.getMaCaLam() + " " + calam.getTenCaLam());
                }
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                dateChoose_bangCongNgayLam.setDate(dateFormat.parse("2014-01-01"));
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            } 
//            catch (ParseException ex) {
//                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
        }
    }//GEN-LAST:event_tabbedPane_nhanVienStateChanged

    private void tb_danhSachBangChamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachBangChamCongMouseClicked
        int index = tb_danhSachBangChamCong.getSelectedRow();
        TableModel model = tb_danhSachBangChamCong.getModel();
        cb_bangCongNhanVien.setSelectedItem(model.getValueAt(index, 2).toString()+ " " + model.getValueAt(index, 3).toString());
        dateChoose_bangCongNgayLam.setDate(util.layNgayDate(model.getValueAt(index, 1).toString()));
        for (int i=0; i < cb_bangCongCaLam.getItemCount(); i++){
            if (cb_bangCongCaLam.getItemAt(i).toString().contains(model.getValueAt(index, 4).toString())){
                cb_bangCongCaLam.setSelectedIndex(i);
            }
        }
        cb_bangCongTrangThai.setSelectedItem(model.getValueAt(index, 5).toString());
        lb_maBangChamCong.setText(model.getValueAt(index, 0).toString());
    }//GEN-LAST:event_tb_danhSachBangChamCongMouseClicked

    private void btn_bangCongResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bangCongResetActionPerformed
        cb_bangCongNhanVien.setSelectedItem("");
        cb_bangCongTrangThai.setSelectedItem("Đầy đủ");
        cb_bangCongCaLam.setSelectedItem("Ca Sáng");
        lb_maBangChamCong.setText("");
    }//GEN-LAST:event_btn_bangCongResetActionPerformed

    private void btn_bangCongCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bangCongCapNhatActionPerformed

        BangChamCong bangChamCongNew = new BangChamCong();
        bangChamCongNew.setMaCaLam(cb_bangCongCaLam.getSelectedItem().toString().split(" ")[0]);
        bangChamCongNew.setMaBangChamCong(lb_maBangChamCong.getText());
        bangChamCongNew.setNgayLam(util.localDateParseMethodToLocalDate(util.layNgayString(dateChoose_bangCongNgayLam.getDate())));
        bangChamCongNew.setMaNhanVien(cb_bangCongNhanVien.getSelectedItem().toString().split(" ")[0]);
        bangChamCongNew.setTrangThai(cb_bangCongTrangThai.getSelectedItem().toString());
        try {
            bangChamCongService.updateBangChamCong(bangChamCongNew);
            hienThiDanhSachBangChamCong();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btn_bangCongCapNhatActionPerformed

    private void btn_bangCongThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bangCongThemActionPerformed
        BangChamCong bangChamCongNew = new BangChamCong();
        bangChamCongNew.setMaCaLam(cb_bangCongCaLam.getSelectedItem().toString().split(" ")[0]);
        bangChamCongNew.setMaBangChamCong("BC0" + String.valueOf(tongSoBangChamCong + 1));
        bangChamCongNew.setNgayLam(util.localDateParseMethodToLocalDate(util.layNgayString(dateChoose_bangCongNgayLam.getDate())));
        bangChamCongNew.setMaNhanVien(cb_bangCongNhanVien.getSelectedItem().toString().split(" ")[0]);
        bangChamCongNew.setTrangThai(cb_bangCongTrangThai.getSelectedItem().toString());
        try {   
            bangChamCongService.themBangChamCong(bangChamCongNew);
            hienThiDanhSachBangChamCong();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btn_bangCongThemActionPerformed

    private void btnChamCong_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCong_timKiemActionPerformed
        try {
            List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
            if (radioChamCong_khoangThoiGian.isSelected() == true){
                danhSachBangChamCong = bangChamCongService.hienThiBangChamCongTheoTheoNgayBatDauVaNgayKetThuc(dateChooserChamCong_ngayBatDau.getDate(), dateChooserChamCong_ngayKetThuc.getDate());
            }
            
            if (radioChamCong_theoNgay.isSelected() == true){
                danhSachBangChamCong = bangChamCongService.hienThiBangChamCongTheoTheoNgay(dateChooserChamCong_theongay_ngay.getDate());
            }
            
            if (radioChamCong_theoThang.isSelected() == true){
                danhSachBangChamCong = bangChamCongService.hienThiBangChamCongTheoTheoThang(String.valueOf(monthChooser_theoThang_thang.getMonth()+1), String.valueOf(yearChooserChamCong_theoThang_nam.getYear()));
            }
            
            if (radioChamCong_theoNam.isSelected() == true){
                danhSachBangChamCong = bangChamCongService.hienThiBangChamCongTheoTheoNam(String.valueOf(yearChooserChamCong_theoNam_nam.getYear()));
            }
            
            DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachBangChamCong.getModel();
            recordTable.setRowCount(0);
            for (BangChamCong bangChamCong : danhSachBangChamCong) {
                Vector columnData = new Vector();
                columnData.add(bangChamCong.getMaBangChamCong());
                columnData.add((bangChamCong.getNgayLam()));
                columnData.add(bangChamCong.getMaNhanVien());
                columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(bangChamCong.getMaNhanVien()).getTenNhanVien());
                columnData.add(caLamService.hienThiCaLamTheoMaCaLam(bangChamCong.getMaCaLam()).getTenCaLam());
                columnData.add(bangChamCong.getTrangThai());
                recordTable.addRow(columnData);
            }
            tongSoBangChamCong = danhSachBangChamCong.size();
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnChamCong_timKiemActionPerformed

    private void btnChamCong_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCong_taiLaiActionPerformed
        hienThiDanhSachBangChamCong();
    }//GEN-LAST:event_btnChamCong_taiLaiActionPerformed

    private void radioChamCong_khoangThoiGianStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioChamCong_khoangThoiGianStateChanged
        if (radioChamCong_khoangThoiGian.isSelected() == true){
            dateChooserChamCong_ngayBatDau.setEnabled(true);
            dateChooserChamCong_ngayKetThuc.setEnabled(true);
        } else {
            dateChooserChamCong_ngayBatDau.setEnabled(false);
            dateChooserChamCong_ngayKetThuc.setEnabled(false);
        }
    }//GEN-LAST:event_radioChamCong_khoangThoiGianStateChanged

    private void radioChamCong_theoNgayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioChamCong_theoNgayStateChanged
        if (radioChamCong_theoNgay.isSelected() == true){
            dateChooserChamCong_theongay_ngay.setEnabled(true);
        } else {
            dateChooserChamCong_theongay_ngay.setEnabled(false);
        }
    }//GEN-LAST:event_radioChamCong_theoNgayStateChanged

    private void radioChamCong_theoThangStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioChamCong_theoThangStateChanged
        if (radioChamCong_theoThang.isSelected() == true){
            monthChooser_theoThang_thang.setEnabled(true);
            yearChooserChamCong_theoThang_nam.setEnabled(true);
        } else {
            monthChooser_theoThang_thang.setEnabled(false);
            yearChooserChamCong_theoThang_nam.setEnabled(false);
        }
    }//GEN-LAST:event_radioChamCong_theoThangStateChanged

    private void radioChamCong_theoNamStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioChamCong_theoNamStateChanged
        if (radioChamCong_theoNam.isSelected() == true){
            yearChooserChamCong_theoNam_nam.setEnabled(true);
        } else {
            yearChooserChamCong_theoNam_nam.setEnabled(false);
        }
    }//GEN-LAST:event_radioChamCong_theoNamStateChanged
    List<String> inputs = new ArrayList<>();

    private void btnHangHoa_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHoa_timKiemActionPerformed
        if (inputs.isEmpty()){
            try {
                hienThiDanhSachHangHoa(tfHangHoa_maHangHoa.getText(), tfHangHoa_timTheoTen.getText());
                return;
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            List<HangHoa> danhSachHangHoa = hangHoaService.LocHangHoaTheoInput(inputs,tfHangHoa_maHangHoa.getText(), tfHangHoa_timTheoTen.getText());
            hienThiDanhSachHangHoa(danhSachHangHoa);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnHangHoa_timKiemActionPerformed

    private void btnHangHoa_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHoa_taiLaiActionPerformed
        inputs.clear();
        tfHangHoa_maHangHoa.setText("");
        tfHangHoa_timTheoTen.setText("");
        radioBtnHangHoa_conHangTrongKho.setSelected(false);
        radioBtnHangHoa_hetHangTrongKho.setSelected(false);
        try {
            hienThiDanhSachHangHoa();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHangHoa_taiLaiActionPerformed
    private boolean actionPerformedEnabled = true;
    private boolean actionPerformedEnabledLoaiXe = true;
    private void cbHangHoa_loaiHangDaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHangHoa_loaiHangDaChonActionPerformed
        if (actionPerformedEnabled) {
            for (int i =0; i< inputs.size(); i++){
                if (inputs.get(i).equals(cbHangHoa_loaiHangDaChon.getSelectedItem())){
                    inputs.remove(i);
                    cbHangHoa_loaiHangDaChon.removeItem(cbHangHoa_loaiHangDaChon.getSelectedItem());
                    return;
                }
            }
        }
        
    }//GEN-LAST:event_cbHangHoa_loaiHangDaChonActionPerformed

    private void cbHangHoa_loaiXeDaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHangHoa_loaiXeDaChonActionPerformed
        if (actionPerformedEnabledLoaiXe) {
            
            for (int i =0; i< inputs.size(); i++){
                if (inputs.get(i).equals(cbHangHoa_loaiXeDaChon.getSelectedItem())){
                    inputs.remove(i);
                    cbHangHoa_loaiXeDaChon.removeItem(cbHangHoa_loaiXeDaChon.getSelectedItem());
                    return;
                }
            }
        }
    }//GEN-LAST:event_cbHangHoa_loaiXeDaChonActionPerformed

    private void cbHangHoa_loaiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHangHoa_loaiHangActionPerformed
        if (String.valueOf(cbHangHoa_loaiHang.getSelectedItem()).equals("null") || String.valueOf(cbHangHoa_loaiHang.getSelectedItem()).equals("Chọn loại hàng")){
            return;
        }
        if (inputs.contains(String.valueOf(cbHangHoa_loaiHang.getSelectedItem())) == false){
            inputs.add(String.valueOf(cbHangHoa_loaiHang.getSelectedItem()));
            actionPerformedEnabled = false;
            cbHangHoa_loaiHangDaChon.addItem(String.valueOf(cbHangHoa_loaiHang.getSelectedItem()));
            actionPerformedEnabled = true;
        }
    }//GEN-LAST:event_cbHangHoa_loaiHangActionPerformed

    private void cbHangHoa_loaiXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHangHoa_loaiXeActionPerformed
        if (String.valueOf(cbHangHoa_loaiXe.getSelectedItem()).equals("null") || String.valueOf(cbHangHoa_loaiXe.getSelectedItem()).equals("Chọn loại xe")){
            return;
        } else {
            if (inputs.contains(String.valueOf(cbHangHoa_loaiXe.getSelectedItem())) == false){
                inputs.add(String.valueOf(cbHangHoa_loaiXe.getSelectedItem()));
                actionPerformedEnabledLoaiXe = false;
                cbHangHoa_loaiXeDaChon.addItem(String.valueOf(cbHangHoa_loaiXe.getSelectedItem()));
                actionPerformedEnabledLoaiXe = true;
            }
        }
    }//GEN-LAST:event_cbHangHoa_loaiXeActionPerformed

    private void tfHangHoa_timTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHangHoa_timTheoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHangHoa_timTheoTenActionPerformed

    private void tb_danhSachHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachHangHoaMouseClicked
        int index = tb_danhSachHangHoa.getSelectedRow();
        TableModel model = tb_danhSachHangHoa.getModel();
        HangHoa hangHoa = new HangHoa();
        try {
            hangHoa = hangHoaService.hienThiHangHoaTheoMaHangHoa(model.getValueAt(index, 0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }

        Frame_chiTietHangHoa frame_chiTietHangHoa = new Frame_chiTietHangHoa(hangHoa);
        frame_chiTietHangHoa.setVisible(true);
        frame_chiTietHangHoa.setSize(1320, 560);
        frame_chiTietHangHoa.setLocation(0,0);
    }//GEN-LAST:event_tb_danhSachHangHoaMouseClicked

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

    private void tfDatHang_timHangHoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDatHang_timHangHoaKeyReleased
        String query = tfDatHang_timHangHoa.getText().toLowerCase();
        filterHangHoaDatHang(query);
    }//GEN-LAST:event_tfDatHang_timHangHoaKeyReleased

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

    private void btnKhachHang_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHang_themActionPerformed
        Frame_ThemKhachHang frame_themKhachHang = new Frame_ThemKhachHang();
        frame_themKhachHang.setVisible(true);
        frame_themKhachHang.setSize(950, 400);
        frame_themKhachHang.setLocation(0,0);
    }//GEN-LAST:event_btnKhachHang_themActionPerformed

    private void btnDatHang_timKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang_timKhachHangActionPerformed
        String timKhachHang = tfDatHang_timKhachHang.getText();
        cbDatHang_danhSachKhachHang.removeAllItems();
        hienThiDanhSachKhachHangTaiCombobox(cbDatHang_danhSachKhachHang);
        
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

    private void tfDatHang_timKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfDatHang_timKhachHangMouseClicked
        try {
            danhSachKhachHangMain = khachHangService.hienThiTatCaKhachHang();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tfDatHang_timKhachHangMouseClicked

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
            int soHoaDon = hoaDonService.demSoHoaDon() + 1;
            String maHoaDon = "HD0" + soHoaDon;
            tfDatHang_tenKhachHang.setText(tenKhachHang);
            lbDatHang_maDonHang.setText(maHoaDon + tfDatHang_maKhachHang.getText().trim());
            
        } catch (Exception err){
            tfDatHang_tenKhachHang.setText("");
            tfDatHang_timKhachHang.setText("");
            tfDatHang_soDienThoai.setText("");
        }
        
        
        
    }//GEN-LAST:event_cbDatHang_danhSachKhachHangActionPerformed

    private void btnDatHang_datHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang_datHangActionPerformed
        KhachHang khachHang = new KhachHang();
        
        try {
            khachHang = khachHangService.hienThiKhachHangTheoMaKhachHang(tfDatHang_maKhachHang.getText());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        String maHoaDon = lbDatHang_maDonHang.getText();
        List<HoaDonChiTiet> danhSachHoaDonChiTiet = new ArrayList<>();
        for (int i =0; i< tbDatHang_danhSachHangHoaDaChon.getRowCount(); i++){
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setMaHoaDonChiTiet(maHoaDon + "CT0" + i);
            hoaDonChiTiet.setGiaBan(Double.parseDouble(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,3).toString()));
            hoaDonChiTiet.setGiamGia(0);
            hoaDonChiTiet.setSoLuong(Short.parseShort(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,5).toString()));
            hoaDonChiTiet.setThanhTien(Double.parseDouble(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,7).toString()));
            hoaDonChiTiet.setMaHangHoa(String.valueOf(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,0).toString()));
            hoaDonChiTiet.setMaHoaDon(maHoaDon);
            hoaDonChiTiet.setTenHangHoa(tbDatHang_danhSachHangHoaDaChon.getModel().getValueAt(i,1).toString());
            danhSachHoaDonChiTiet.add(hoaDonChiTiet);
        }
        int tongSoLuong = Integer.parseInt(tfDatHang_soLuong.getText().toString());
        double tongTienHang = Double.parseDouble(tfDatHang_tongTienHang.getText().toString());
        Frame_ThanhToan frame_thanhToan = new Frame_ThanhToan(danhSachHoaDonChiTiet, khachHang, maHoaDon, tongSoLuong, tongTienHang, trangChuInstance);
        frame_thanhToan.setVisible(true);
        frame_thanhToan.setSize(360, 650);
        frame_thanhToan.setLocation(1170,0);
    }//GEN-LAST:event_btnDatHang_datHangActionPerformed

    private void btnKhachHoa_xuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHoa_xuatFileActionPerformed
        try {
            WriteCSV writeCSV = new WriteCSV();
            List<KhachHang> danhSachKhachHang = khachHangService.hienThiTatCaKhachHang();
            writeCSV.writeCSVFile1(danhSachKhachHang);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnKhachHoa_xuatFileActionPerformed

    private void btnKhachHang_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHang_importActionPerformed
        ImportFileCSV importCSV = new ImportFileCSV();
//            List<KhachHang> danhSachKhachHang = khachHangService.hienThiTatCaKhachHang();
            importCSV.readCsvFile();
    }//GEN-LAST:event_btnKhachHang_importActionPerformed

    private void tfHoaDon_timHoaDonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfHoaDon_timHoaDonFocusGained
        if(tfHoaDon_timHoaDon.getText().equals("Tìm hóa đơn theo tên người nộp/ nhận")){
            tfHoaDon_timHoaDon.setText("");
        }
    }//GEN-LAST:event_tfHoaDon_timHoaDonFocusGained

    private void tfHoaDon_timHoaDonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfHoaDon_timHoaDonFocusLost
        if(tfHoaDon_timHoaDon.getText().equals("")){
            tfHoaDon_timHoaDon.setText("Tìm hóa đơn theo tên người nộp/ nhận");
        }
    }//GEN-LAST:event_tfHoaDon_timHoaDonFocusLost

    private void tfHoaDon_timHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHoaDon_timHoaDonKeyReleased
        String query = tfHoaDon_timHoaDon.getText().toLowerCase();
        filterHoaDon(query);
    }//GEN-LAST:event_tfHoaDon_timHoaDonKeyReleased

    private void btnHoaDon_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDon_taiLaiActionPerformed
        hienThiDanhSachHoaDon();
    }//GEN-LAST:event_btnHoaDon_taiLaiActionPerformed

    private void btnHoaDon_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDon_timKiemActionPerformed
        
        if (cbHoaDon_nguoiTao.getSelectedItem().equals("Chọn tất cả") && (dateChooseHoaDon_batDau.getDate() == null || dateChooserHoaDon_ketThuc.getDate() == null )){
            hienThiDanhSachHoaDon();
            return;
        }
        LocalDate ngayBatDau = util.localDateParseMethodToLocalDate(util.layNgayString(dateChooseHoaDon_batDau.getDate()));
        LocalDate ngayKetThuc = util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserHoaDon_ketThuc.getDate()));
        try {
            hienThiDanhSachHoaDon(hoaDonService.hienThiHoaDonTheoNgayBatDauVaNgayKetThuc(ngayBatDau, ngayKetThuc)); 
            
//        try {
//            List<HangHoa> danhSachHangHoa = hangHoaService.LocHangHoaTheoInput(inputs,tfHangHoa_maHangHoa.getText(), tfHangHoa_timTheoTen.getText());
//            hienThiDanhSachHangHoa(danhSachHangHoa);
//        } catch (SQLException ex) {
//            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHoaDon_timKiemActionPerformed

    private void cbHoaDon_nguoiTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHoaDon_nguoiTaoActionPerformed
        try{
            hienThiDanhSachHoaDon();
            if (cbHoaDon_nguoiTao.getSelectedIndex() == 0){
                return;
            }
            String tenNhanVien = "";
            String[] selectedItemCb =  cbHoaDon_nguoiTao.getSelectedItem().toString().split(" ");
            for (int i = 0; i < selectedItemCb.length; i++){
                if ( i ==0 ){
                    continue;
                }
                tenNhanVien += " " +selectedItemCb[i];
            }
            tenNhanVien = tenNhanVien.trim();
            DefaultTableModel model = (DefaultTableModel) tbHoaDon_danhSachHoaDon.getModel();
            Object[] columnIdentifiers = new Object[model.getColumnCount()];
            for (int i = 0; i < model.getColumnCount(); i++) {
                columnIdentifiers[i] = model.getColumnName(i);
            }
            DefaultTableModel modelNew = new DefaultTableModel(columnIdentifiers, 0); // 0 for row count
            for (int i = 0; i< model.getRowCount(); i++ ){
                if (tbHoaDon_danhSachHoaDon.getValueAt(i, 3).toString().equals(tenNhanVien)){
                    
                    Vector<Object> row = new Vector<>();
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            row.add(model.getValueAt(i, j));
                        }
                        modelNew.addRow(row);
                }
            }
            tbHoaDon_danhSachHoaDon.setModel(modelNew);
        } catch(Exception err){
            return;
        }
        
    }//GEN-LAST:event_cbHoaDon_nguoiTaoActionPerformed

    private void tbHoaDon_danhSachHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDon_danhSachHoaDonMouseClicked
        int index = tbHoaDon_danhSachHoaDon.getSelectedRow();
        TableModel model = tbHoaDon_danhSachHoaDon.getModel();
        HoaDon hoaDon = new HoaDon();
        try {
            hoaDon = hoaDonService.hienThiHoaDonTheoMaHoadon(model.getValueAt(index, 0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
//        phieuNhapHang.setPhieuNhapHang(model.getValueAt(index, 0).toString());
//        phieuNhapHang.setThoiGian( util.localDateParseMethodWithoutNanosecond(model.getValueAt(index, 1).toString()));
//        phieuNhapHang.setMaNhaCungCap(model.getValueAt(index, 2).toString());
//        phieuNhapHang.setTong(Double.parseDouble(model.getValueAt(index, 3).toString()));
//        phieuNhapHang.setNo(Double.parseDouble(model.getValueAt(index, 4).toString()));
//        phieuNhapHang.setTrangThai(model.getValueAt(index, 5).toString());
        String tenNhanVien = model.getValueAt(index, 3).toString();
        String tenDoiTac = model.getValueAt(index, 4).toString();
        Frame_HoaDonChiTiet frame_hoaDonChiTiet = new Frame_HoaDonChiTiet(hoaDon, tenNhanVien, tenDoiTac);
        frame_hoaDonChiTiet.setVisible(true);
        frame_hoaDonChiTiet.setSize(1075, 620);
        frame_hoaDonChiTiet.setLocation(0,0);
    }//GEN-LAST:event_tbHoaDon_danhSachHoaDonMouseClicked

    private void tbTraHang_danhSachPhieuTraHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTraHang_danhSachPhieuTraHangMouseClicked
        int index = tbTraHang_danhSachPhieuTraHang.getSelectedRow();
        TableModel model = tbTraHang_danhSachPhieuTraHang.getModel();
        PhieuTraHang phieuTraHang = new PhieuTraHang();
        try {
            phieuTraHang = phieuTraHangService.hienThiPhieuTraHangTheoMaPhieuTraHang(model.getValueAt(index, 0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Frame_ChiTietPhieuTraHang2 frame_chiTietPhieuTraHang = new Frame_ChiTietPhieuTraHang2(phieuTraHang);
        frame_chiTietPhieuTraHang.setVisible(true);
        frame_chiTietPhieuTraHang.setSize(1070, 600);
        frame_chiTietPhieuTraHang.setLocation(0,0);
    }//GEN-LAST:event_tbTraHang_danhSachPhieuTraHangMouseClicked
    

    
    private void hienThiDanhSachHoaDon(){
        try {
            List<HoaDon> danhSachHoaDon = hoaDonService.hienThiTatCaHoaDon();
            DefaultTableModel recordTable = (DefaultTableModel)tbHoaDon_danhSachHoaDon.getModel();
            recordTable.setRowCount(0);
        for (HoaDon hoaDon : danhSachHoaDon) {
            Vector columnData = new Vector();
            columnData.add(hoaDon.getMaHoaDon());
            columnData.add(util.localDateParseMethod(hoaDon.getThoiGian()));
            try{
                columnData.add(hoaDon.getMaPhieuTraHang());
            } catch (Exception err){
                columnData.add("");
            }
            
            columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(hoaDon.getMaNhanVien()).getTenNhanVien());
            if (hoaDon.getMaKhachHang() == null){
                columnData.add(nhaCungCapService.hienThiNhaCungCapTheoMaNhaCungCap(hoaDon.getMaNhaCungCap()).getTenNhaCungCap());    
            } else {
                columnData.add(khachHangService.hienThiKhachHangTheoMaKhachHang(hoaDon.getMaKhachHang()).getTenKhachHang());
            }
            
            
            columnData.add(hoaDon.getLoaiThuChi());
            columnData.add(hoaDon.getTrangThai());
            columnData.add(hoaDon.getTongTien());
            columnData.add(hoaDon.getGiamGia());
            columnData.add(hoaDon.getTienDaTra());
            recordTable.addRow(columnData);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void hienThiDanhSachHoaDon(List<HoaDon> danhSachHoaDon){
        try {
            
            DefaultTableModel recordTable = (DefaultTableModel)tbHoaDon_danhSachHoaDon.getModel();
        recordTable.setRowCount(0);
        for (HoaDon hoaDon : danhSachHoaDon) {
            Vector columnData = new Vector();
            columnData.add(hoaDon.getMaHoaDon());
            columnData.add(util.localDateParseMethod(hoaDon.getThoiGian()));
            try{
                columnData.add(hoaDon.getMaPhieuTraHang());
            } catch (Exception err){
                columnData.add("");
            }
            
            columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(hoaDon.getMaNhanVien()).getTenNhanVien());
            if (hoaDon.getMaKhachHang() == null){
                columnData.add(nhaCungCapService.hienThiNhaCungCapTheoMaNhaCungCap(hoaDon.getMaNhaCungCap()).getTenNhaCungCap());    
            } else {
                columnData.add(khachHangService.hienThiKhachHangTheoMaKhachHang(hoaDon.getMaKhachHang()).getTenKhachHang());
            }
            
            
            columnData.add(hoaDon.getLoaiThuChi());
            columnData.add(hoaDon.getTrangThai());
            columnData.add(hoaDon.getTongTien());
            columnData.add(hoaDon.getGiamGia());
            columnData.add(hoaDon.getTienDaTra());
            recordTable.addRow(columnData);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void hienThiDanhSachPhieuTraHang(){
        try {
            List<PhieuTraHang> danhSachPhieuTraHang = phieuTraHangService.hienThiTatCaPhieuTraHang();
            DefaultTableModel recordTable = (DefaultTableModel)tbTraHang_danhSachPhieuTraHang.getModel();
            recordTable.setRowCount(0);
            for (PhieuTraHang phieuTraHang : danhSachPhieuTraHang) {
                Vector columnData = new Vector();
                columnData.add(phieuTraHang.getMaPhieuTraHang());
                columnData.add(phieuTraHang.getMaHoaDon());
                columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(phieuTraHang.getMaNhanVien()).getTenNhanVien());
                columnData.add(util.localDateParseMethod(phieuTraHang.getThoiGian()));



                if (phieuTraHang.getMaKhachHang() == null){
                    columnData.add(nhaCungCapService.hienThiNhaCungCapTheoMaNhaCungCap(phieuTraHang.getMaNhaCungCap()).getTenNhaCungCap());    
                } else {
                    columnData.add(khachHangService.hienThiKhachHangTheoMaKhachHang(phieuTraHang.getMaKhachHang()).getTenKhachHang());
                }


                columnData.add(phieuTraHang.getCanTra());
                columnData.add(phieuTraHang.getDaTra());
                columnData.add(phieuTraHang.getTrangThai());
                recordTable.addRow(columnData);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void hienThiDanhSachPhieuSuaChua(){
        try {
            List<PhieuSuaChua> danhSachPhieuSuaChua = phieuSuaChuaService.hienThiTatCaPhieuSuaChua();
            DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachPhieuSuaChua.getModel();
            recordTable.setRowCount(0);
            for (PhieuSuaChua phieuSuaChua : danhSachPhieuSuaChua) {
                Vector columnData = new Vector();
                columnData.add(khachHangService.hienThiKhachHangTheoMaKhachHang(phieuSuaChua.getMaKhachHang()).getTenKhachHang());
                columnData.add(khachHangService.hienThiKhachHangTheoMaKhachHang(phieuSuaChua.getMaKhachHang()).getSoDienThoai());
                columnData.add(loaiXeService.hienThiLoaiXeTheoMaLoaiXe(phieuSuaChua.getMaLoaiXe()).getTenLoaiXe());
                columnData.add(phieuSuaChua.getNoiDungSuaChua());
                columnData.add(hangHoaService.hienThiHangHoaTheoMaHangHoa(phieuSuaChua.getMaHangHoa()).getTenHangHoa());
                columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(phieuSuaChua.getMaNhanVien()).getTenNhanVien());
                columnData.add(phieuSuaChua.getTongTien());
                columnData.add(phieuSuaChua.getTrangThai());
                recordTable.addRow(columnData);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void hienThiDanhSachKhachHang(){
        try {
            List<KhachHang> danhSachKhachHang = khachHangService.hienThiTatCaKhachHang();
            DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachKhachHang.getModel();
            recordTable.setRowCount(0);
            for (KhachHang khachHang : danhSachKhachHang) {
                Vector columnData = new Vector();
                columnData.add(khachHang.getMaKhachHang());
                columnData.add(khachHang.getTenKhachHang());
                columnData.add(khachHang.getSoDienThoai());
                columnData.add(khachHang.getTongNo());
                columnData.add(khachHang.getTongBan());
                columnData.add(khachHang.getTongBan() - phieuTraHangService.tinhTongTienThuDuocSauKhiTraHang(khachHang.getMaKhachHang()));
                recordTable.addRow(columnData);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void hienThiDanhSachNhaCungCap(){
        try {
            List<NhaCungCap> danhSachNhaCungCap = nhaCungCapService.hienThiTatCaNhaCungCap();
            DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachNhaCungCap.getModel();
            recordTable.setRowCount(0);
            for (NhaCungCap nhaCungCap : danhSachNhaCungCap) {
                Vector columnData = new Vector();
                columnData.add(nhaCungCap.getMaNhaCungCap());
                columnData.add(nhaCungCap.getTenNhaCungCap());
                columnData.add(nhaCungCap.getSoDienThoai());
                columnData.add(nhaCungCap.getEmail());
                columnData.add(nhaCungCap.getNoCanTra());
                columnData.add((long)(nhaCungCap.getTongMua()));
                recordTable.addRow(columnData);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void hienThiDanhSachNhanVien(){
        try {
            danhSachNhanVienMain = nhanVienService.hienThiTatCaNhanVien();
            DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachNhanVien.getModel();
            recordTable.setRowCount(0);
            for (NhanVien nhanVien : danhSachNhanVienMain) {
                Vector columnData = new Vector();
                columnData.add(nhanVien.getMaNhanVien());
                columnData.add(nhanVien.getTenNhanVien());
                columnData.add(nhanVien.getSoDienThoai());
                columnData.add(nhanVien.getCccd());
                columnData.add(nhanVien.getChucDanh());
                columnData.add(chiNhanhService.hienThiChiNhanhTheoMaChiNhanh(nhanVien.getMaChiNhanh()).getTenChiNhanh());
                columnData.add((long)nhanVien.getNoLuong());
                recordTable.addRow(columnData);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void hienThiDanhSachChiNhanh(){
        try {
            List<ChiNhanh> danhSachChiNhanh = chiNhanhService.hienThiTatCaChiNhanh();
            DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachChiNhanh.getModel();
            recordTable.setRowCount(0);
            for (ChiNhanh chiNhanh : danhSachChiNhanh) {
                Vector columnData = new Vector();
                columnData.add(chiNhanh.getMaChiNhanh());
                columnData.add(chiNhanh.getTenChiNhanh());
                columnData.add(chiNhanh.getDiaChi());
                columnData.add(chiNhanh.getTrangThai());
                recordTable.addRow(columnData);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void hienThiDanhSachPhieuNhapHang() throws SQLException{
        DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachPhieuNhapHang.getModel();
        recordTable.setRowCount(0);
        List<PhieuNhapHang> danhSachPhieuNhapHang = phieuNhapHangService.hienThiTatCaPhieuNhapHang();
        for (PhieuNhapHang phieuNhapHang : danhSachPhieuNhapHang){
            Vector columnData = new Vector();
            columnData.add(phieuNhapHang.getPhieuNhapHang());
            columnData.add(util.localDateParseMethod(phieuNhapHang.getThoiGian()));
            columnData.add(phieuNhapHang.getMaNhaCungCap());
            columnData.add(phieuNhapHang.getTong());
            columnData.add(phieuNhapHang.getNo());
            columnData.add(phieuNhapHang.getTrangThai());
            recordTable.addRow(columnData);
        }
    }
    
    public void hienThiDanhSachHangHoa(String maHangHoa, String tenHangHoa) throws SQLException, IOException{
//        cbHangHoa_loaiHangDaChon.setPopupVisible(true);
//        cbHangHoa_loaiXeDaChon.setPopupVisible(true);
        cbHangHoa_loaiHangDaChon.removeAllItems();
        cbHangHoa_loaiXeDaChon.removeAllItems();
        DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachHangHoa.getModel();
        recordTable.setRowCount(0);
        List<HangHoa> danhSachHangHoa = hangHoaService.hienThiTatCaHangHoa(maHangHoa,tenHangHoa);
        tb_danhSachHangHoa.getColumnModel().getColumn(1)
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
        for (int index = 0; index < danhSachHangHoa.size(); index ++){
            if (radioBtnHangHoa_conHangTrongKho.isSelected() == true){
                if (danhSachHangHoa.get(index).getTonKho() == 0){
                    danhSachHangHoa.remove(index);
                    index --;
                    continue;
                }
            }
            if (radioBtnHangHoa_hetHangTrongKho.isSelected() == true){
                if (danhSachHangHoa.get(index).getTonKho() != 0){
                    danhSachHangHoa.remove(index);
                    index --;
                    continue;
                }
            }
        }
        
        for (HangHoa hangHoa : danhSachHangHoa){
            Vector columnData = new Vector();
            columnData.add(hangHoa.getMaHangHoa());
            try{
                String imageFolder = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\Git_GarageOtoAnt_DoAn\\GarageOto_JavaSwingAnt\\DoAn_GarageOto_Ant\\src\\image\\";
                File file = new File(imageFolder + hinhAnhService.hienThiHinhAnhTheoMaHangHoa(hangHoa.getMaHangHoa()).getTenHinh());
                BufferedImage originalImage = ImageIO.read(file);
                Image scaledImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                columnData.add(icon);
            } catch(Exception err){
                columnData.add("No Image");
            }
            
            columnData.add(hangHoa.getTenHangHoa());
            columnData.add(hangHoa.getGiaBan());
            columnData.add(hangHoa.getGiaVon());
            columnData.add(hangHoa.getTonKho());
            columnData.add(hangHoa.getKhachDat());
            recordTable.addRow(columnData);

        }
    }
    
    public void hienThiDanhSachHangHoa() throws SQLException, IOException{
//        cbHangHoa_loaiHangDaChon.setPopupVisible(true);
//        cbHangHoa_loaiXeDaChon.setPopupVisible(true);
        cbHangHoa_loaiHangDaChon.removeAllItems();
        cbHangHoa_loaiXeDaChon.removeAllItems();
        DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachHangHoa.getModel();
        recordTable.setRowCount(0);
        danhSachHangHoaMain = hangHoaService.hienThiTatCaHangHoa("","");
        tb_danhSachHangHoa.getColumnModel().getColumn(1)
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
        cbHangHoa_loaiHang.removeAllItems();
        cbHangHoa_loaiHang.addItem("Chọn loại hàng");
        for (HangHoa hangHoa : danhSachHangHoaMain){
            Vector columnData = new Vector();
            columnData.add(hangHoa.getMaHangHoa());
            try{
                String imageFolder = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\Git_GarageOtoAnt_DoAn\\GarageOto_JavaSwingAnt\\DoAn_GarageOto_Ant\\src\\image\\";
                String tenHinh = hinhAnhService.hienThiHinhAnhTheoMaHangHoa(hangHoa.getMaHangHoa()).getTenHinh();
                File file = new File(imageFolder + tenHinh);
                danhSachLinkAnhHangHoa1th.add(imageFolder + tenHinh);
                BufferedImage originalImage = ImageIO.read(file);
                Image scaledImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                columnData.add(icon);
            } catch(Exception err){
                columnData.add("No Image");
            }
            
            columnData.add(hangHoa.getTenHangHoa());
            columnData.add(hangHoa.getGiaBan());
            columnData.add(hangHoa.getGiaVon());
            columnData.add(hangHoa.getTonKho());
            columnData.add(hangHoa.getKhachDat());
            recordTable.addRow(columnData);
            if (kiemTraItemTonTaiTrongComboboxLoaiHang(hangHoa.getLoaiHang(), cbHangHoa_loaiHang) == false){
                cbHangHoa_loaiHang.addItem(hangHoa.getLoaiHang());
            }
        }
        hienThiComboboxLoaiXe();
    }
    
    public void hienThiDanhSachHangHoa(List<HangHoa> danhSachHangHoa) throws SQLException, IOException{
        DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachHangHoa.getModel();
        recordTable.setRowCount(0);
        tb_danhSachHangHoa.getColumnModel().getColumn(1)
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
        for (HangHoa hangHoa : danhSachHangHoa){
            Vector columnData = new Vector();
            columnData.add(hangHoa.getMaHangHoa());
            try{
                String imageFolder = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\Git_GarageOtoAnt_DoAn\\GarageOto_JavaSwingAnt\\DoAn_GarageOto_Ant\\src\\image\\";
                File file = new File(imageFolder + hinhAnhService.hienThiHinhAnhTheoMaHangHoa(hangHoa.getMaHangHoa()).getTenHinh());
                BufferedImage originalImage = ImageIO.read(file);
                Image scaledImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                columnData.add(icon);
            } catch(Exception err){
                columnData.add("No Image");
            }
            
            columnData.add(hangHoa.getTenHangHoa());
            columnData.add(hangHoa.getGiaBan());
            columnData.add(hangHoa.getGiaVon());
            columnData.add(hangHoa.getTonKho());
            columnData.add(hangHoa.getKhachDat());
            recordTable.addRow(columnData);
        }
    }
    
    int tongSoBangChamCong = 0;
    private void hienThiDanhSachBangChamCong(){
        try {
            List<BangChamCong> danhSachBangChamCong = bangChamCongService.hienThiTatCaBangChamCong();
            DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachBangChamCong.getModel();
            recordTable.setRowCount(0);
            for (BangChamCong bangChamCong : danhSachBangChamCong) {
                Vector columnData = new Vector();
                columnData.add(bangChamCong.getMaBangChamCong());
                columnData.add((bangChamCong.getNgayLam()));
                columnData.add(bangChamCong.getMaNhanVien());
                columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(bangChamCong.getMaNhanVien()).getTenNhanVien());
                columnData.add(caLamService.hienThiCaLamTheoMaCaLam(bangChamCong.getMaCaLam()).getTenCaLam());
                columnData.add(bangChamCong.getTrangThai());
                recordTable.addRow(columnData);
            }
            tongSoBangChamCong = danhSachBangChamCong.size();
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void hienThiComboboxLoaiXe() throws SQLException{
        List<LoaiXe> danhSachLoaiXe = loaiXeService.hienThiTatCaLoaiXe();
        cbHangHoa_loaiXe.removeAllItems();
        cbHangHoa_loaiXe.addItem("Chọn loại xe");
        for (LoaiXe loaiXe : danhSachLoaiXe) {
            cbHangHoa_loaiXe.addItem(loaiXe.getTenLoaiXe());
        }
    }
    
    public boolean kiemTraItemTonTaiTrongComboboxLoaiHang(String loaiHang, javax.swing.JComboBox<String> cbHangHoa_loaiHang1){
        for (int i = 0; i < cbHangHoa_loaiHang1.getItemCount(); i++) {
            if (cbHangHoa_loaiHang1.getItemAt(i).toString().equals(loaiHang)) {
                // Item already exists in the combobox
                return true;
            }
        }
        return false;
    }
     
    public void hienThiDanhSachHangHoaKhiDatHang(){
        
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
    
    public void filterHangHoaDatHang(String query){
        DefaultTableModel model = (DefaultTableModel) tbDatHang_danhSachHangHoa.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tbDatHang_danhSachHangHoa.setRowSorter(tr);
        
        RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
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
    
    public void filterHoaDon(String query){
        DefaultTableModel model = (DefaultTableModel) tbHoaDon_danhSachHoaDon.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tbHoaDon_danhSachHoaDon.setRowSorter(tr);
        
        RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Get the value in the second column (index 2) of the current row
                Object value = entry.getValue(4 );
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
    
    public void hienThiDanhSachKhachHangTaiCombobox(JComboBox<String> comboBox){
        try {
            danhSachKhachHangMain = khachHangService.hienThiTatCaKhachHang();
            for (KhachHang khachHang : danhSachKhachHangMain){
                comboBox.addItem(khachHang.getMaKhachHang() + " " + khachHang.getTenKhachHang() + " " + khachHang.getSoDienThoai());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hienThiDanhSachNhanVienCombobox(JComboBox<String> comboBox){
        try {
            comboBox.removeAllItems();
            comboBox.addItem("Chọn tất cả");
            danhSachNhanVienMain = nhanVienService.hienThiTatCaNhanVien();
            for (NhanVien nhanVien : danhSachNhanVienMain){
                comboBox.addItem(nhanVien.getMaNhanVien() + " " + nhanVien.getTenNhanVien());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    static TrangChu trangChuInstance;
    public static void main(String args[]) {
        // ... Look and feel setting code
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                trangChuInstance = new TrangChu();
                trangChuInstance.setVisible(true);
                
                // Now you can use trangChuInstance to pass to the ThanhToan frame when needed
                // For example, if you open ThanhToan from a button click in TrangChu, you can pass it like so:
                // ThanhToan thanhToanFrame = new ThanhToan(trangChuInstance);
                // thanhToanFrame.setVisible(true);
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChamCong_taiLai;
    private javax.swing.JButton btnChamCong_timKiem;
    private javax.swing.JButton btnDatHang_datHang;
    private javax.swing.JButton btnDatHang_themKhachHang;
    private javax.swing.JButton btnDatHang_timKhachHang;
    private javax.swing.JButton btnHangHoa_taiLai;
    private javax.swing.JButton btnHangHoa_them;
    private javax.swing.JButton btnHangHoa_timKiem;
    private javax.swing.JButton btnHoaDon_taiLai;
    private javax.swing.JButton btnHoaDon_timKiem;
    private javax.swing.JButton btnKhachHang_import;
    private javax.swing.JButton btnKhachHang_them;
    private javax.swing.JButton btnKhachHoa_xuatFile;
    private javax.swing.JButton btn_bangCongCapNhat;
    private javax.swing.JButton btn_bangCongReset;
    private javax.swing.JButton btn_bangCongThem;
    private javax.swing.JButton btn_capNhat;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbDatHang_danhSachKhachHang;
    private javax.swing.JComboBox<String> cbHangHoa_loaiHang;
    private javax.swing.JComboBox<String> cbHangHoa_loaiHangDaChon;
    private javax.swing.JComboBox<String> cbHangHoa_loaiXe;
    private javax.swing.JComboBox<String> cbHangHoa_loaiXeDaChon;
    private javax.swing.JComboBox<String> cbHoaDon_nguoiTao;
    private javax.swing.JComboBox<String> cb_bangCongCaLam;
    private javax.swing.JComboBox<String> cb_bangCongNhanVien;
    private javax.swing.JComboBox<String> cb_bangCongTrangThai;
    private javax.swing.JComboBox<String> cb_loaiXe;
    private javax.swing.JComboBox<String> cb_nhanVienSuaChua;
    private javax.swing.JComboBox<String> cb_phuTungCanThay;
    private com.toedter.calendar.JDateChooser dateChooseHoaDon_batDau;
    private com.toedter.calendar.JDateChooser dateChoose_bangCongNgayLam;
    private com.toedter.calendar.JDateChooser dateChooserChamCong_ngayBatDau;
    private com.toedter.calendar.JDateChooser dateChooserChamCong_ngayKetThuc;
    private com.toedter.calendar.JDateChooser dateChooserChamCong_theongay_ngay;
    private com.toedter.calendar.JDateChooser dateChooserHoaDon_ketThuc;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JComboBox<String> jComboBox8;
    private com.toedter.calendar.JDateChooser jDateChooser10;
    private com.toedter.calendar.JDateChooser jDateChooser11;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel242;
    private javax.swing.JPanel jPanel247;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel250;
    private javax.swing.JPanel jPanel252;
    private javax.swing.JPanel jPanel253;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    private javax.swing.JLabel lbDatHang_maDonHang;
    private javax.swing.JLabel lbDatHang_maDonHang1;
    private javax.swing.JLabel lb_maBangChamCong;
    private javax.swing.JLabel lb_soDienThoai;
    private javax.swing.JLabel lb_tenKhachHang;
    private com.toedter.calendar.JMonthChooser monthChooser_theoThang_thang;
    private javax.swing.JRadioButton radioBtnHangHoa_conHangTrongKho;
    private javax.swing.JRadioButton radioBtnHangHoa_hetHangTrongKho;
    private javax.swing.JRadioButton radioChamCong_khoangThoiGian;
    private javax.swing.JRadioButton radioChamCong_theoNam;
    private javax.swing.JRadioButton radioChamCong_theoNgay;
    private javax.swing.JRadioButton radioChamCong_theoThang;
    private javax.swing.JTabbedPane tabPane_giaoDich;
    private javax.swing.JTabbedPane tabbedPane_doiTac;
    private javax.swing.JTabbedPane tabbedPane_nhanVien;
    private javax.swing.JTabbedPane tabbedPane_trangChu;
    private javax.swing.JTextArea tare_noiDungSuaChua;
    private javax.swing.JTable tbDatHang_danhSachHangHoa;
    private javax.swing.JTable tbDatHang_danhSachHangHoaDaChon;
    private javax.swing.JTable tbHoaDon_danhSachHoaDon;
    private javax.swing.JTable tbTraHang_danhSachPhieuTraHang;
    private javax.swing.JTable tb_danhSachBangChamCong;
    private javax.swing.JTable tb_danhSachChiNhanh;
    private javax.swing.JTable tb_danhSachHangHoa;
    private javax.swing.JTable tb_danhSachKhachHang;
    private javax.swing.JTable tb_danhSachNhaCungCap;
    private javax.swing.JTable tb_danhSachNhanVien;
    private javax.swing.JTable tb_danhSachPhieuNhapHang;
    private javax.swing.JTable tb_danhSachPhieuSuaChua;
    private javax.swing.JLabel tfDatHang_maKhachHang;
    private javax.swing.JLabel tfDatHang_soDienThoai;
    private javax.swing.JLabel tfDatHang_soLuong;
    private javax.swing.JLabel tfDatHang_tenKhachHang;
    private javax.swing.JTextField tfDatHang_timHangHoa;
    private javax.swing.JTextField tfDatHang_timKhachHang;
    private javax.swing.JLabel tfDatHang_tongTienHang;
    private javax.swing.JTextField tfHangHoa_maHangHoa;
    private javax.swing.JTextField tfHangHoa_timTheoTen;
    private javax.swing.JTextField tfHoaDon_timHoaDon;
    private com.toedter.calendar.JYearChooser yearChooserChamCong_theoNam_nam;
    private com.toedter.calendar.JYearChooser yearChooserChamCong_theoThang_nam;
    // End of variables declaration//GEN-END:variables
}
