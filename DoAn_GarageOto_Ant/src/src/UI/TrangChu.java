/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.UI;

import java.awt.BorderLayout;
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
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import src.Model.BangChamCong;
import src.Model.BangLuong;
import src.Model.BangLuongNhanVien;
import src.Model.CaLam;
import src.Model.ChiNhanh;
import src.Model.DoanhThu.DoanhThuTrongNam;
import src.Model.DoanhThu.HangHoaTieuThuTrongKhoangThoiGian;
import src.Model.DoanhThu.ThongKeTongTienSoLuong;
import src.Model.HangHoa;
import src.Model.HinhAnh;
import src.Model.HoaDon;
import src.Model.HoaDonChiTiet;
import src.Model.KhachHang;
import src.Model.LichLamViec;
import src.Model.LichLamViecCaLam;
import src.Model.LoaiXe;
import src.Model.NhaCungCap;
import src.Model.NhanVien;
import src.Model.PhieuNhapHang;
import src.Model.PhieuSuaChua;
import src.Model.PhieuTraHang;
import src.Model.TheKho;
import src.Service.BangChamCongService;
import src.Service.BangLuongNhanVienService;
import src.Service.BangLuongService;
import src.Service.CaLamService;
import src.Service.ChiNhanhServive;
import src.Service.DoanhThuService;
import src.Service.HangHoaService;
import src.Service.HinhAnhService;
import src.Service.HoaDonService;
import src.Service.KhachHangService;
import src.Service.LichLamViecCaLamService;
import src.Service.LichLamViecService;
import src.Service.LoaiXeService;
import src.Service.NhaCungCapService;
import src.Service.NhanVienService;
import src.Service.PhieuLuongService;
import src.Service.PhieuNhapHangService;
import src.Service.PhieuSuaChuaService;
import src.Service.PhieuTraHangService;
import src.Service.TheKhoService;
import src.UI.Chart.chat.ModelChart;
import src.UI.Chart.piechart.ModelPieChart;
import src.UI.Chart.piechart.PieChart;
import src.UI.ChiNhanh.Frame_ThemChiNhanh;
import src.UI.ChiNhanh.Frame_XemChiTietCapNhatChiNhanh;
import src.UI.HangHoa.Frame_ThemHangHoa;
import src.UI.HangHoa.Frame_chiTietHangHoa;
import src.UI.HangHoa.Frame_taoDonNhapHang;
import src.UI.HangHoa.frame_ChiTietDonNhapHang;
import src.UI.HoaDon.Frame_ThanhToan;
import src.UI.KhachHang.Frame_ThemKhachHang;
import src.UI.KhachHang.Frame_XemChiTietCapNhatKhachHang;
import src.UI.NhaCungCap.Frame_ThemNhaCungCap;
import src.UI.NhaCungCap.Frame_XemChiTietCapNhatNhaCungCap;
import src.UI.NhanVien.Frame_BangLuong;
import src.UI.NhanVien.Frame_CaLam;
import src.UI.NhanVien.Frame_ChiTietNhanVien;
import src.UI.NhanVien.Frame_LapPhieuLuong;
import src.UI.NhanVien.Frame_LichNghi;
import src.UI.NhanVien.Frame_ThemNhanVien;
import src.UI.NhanVien.Frame_TroCap;
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
    private LichLamViecService lichLamViecService = new LichLamViecService();
    private BangLuongService bangLuongService = new BangLuongService();
    private PhieuLuongService phieuLuongService = new PhieuLuongService();
    private BangLuongNhanVienService bangLuongNhanVienService = new BangLuongNhanVienService();
    private LichLamViecCaLamService  lichLamViecCaLamService = new LichLamViecCaLamService();
    private DoanhThuService doanhThuService = new DoanhThuService();
    private TheKhoService theKhoService = new TheKhoService();
    
    private List<HangHoa> danhSachHangHoaMain = new ArrayList<>();
    private List<String> danhSachLinkAnhHangHoa1th = new ArrayList<>();
    private List<KhachHang> danhSachKhachHangMain = new ArrayList<>();
    private List<NhanVien> danhSachNhanVienMain = new ArrayList<>();
    private NhanVien nhanVienDangNhap;
    
    private Util util = new Util();

    public TrangChu() {
    }
    
    public TrangChu(NhanVien nhanVien) {
        this.nhanVienDangNhap = nhanVien;
        getContentPane().setBackground(Color.white);
        initComponents();
        setSize(1550,975);
        setLocation(0,0);
        hienThiThongTinNhanVienDangNhap();
        try {
            if (!util.kiemTraTonTaiChuoi(nhanVien.getPhanQuyen(), " 5.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý hàng hóa!");
                return;
            }
                hienThiDanhSachHangHoa();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void hienThiThongTinNhanVienDangNhap(){
        lbTrangChu_tenNguoiDung.setText(nhanVienDangNhap.getMaNhanVien() + " " + nhanVienDangNhap.getTenNhanVien());
        HinhAnh hinhAnhNhanVien;
        String destinationFolderPath = "D:\\tai_lieu_tren_lop\\LapTrinhTienTien\\Workspace\\Git_GarageOtoAnt_DoAn\\GarageOto_JavaSwingAnt\\DoAn_GarageOto_Ant\\src\\image";
        String imageLink = "";
        try {
            hinhAnhNhanVien = hinhAnhService.hienThiHinhAnhTheoMaNhanVien(nhanVienDangNhap.getMaNhanVien());
            imageLink = hinhAnhNhanVien.getTenHinh();
            if (imageLink != null ){
                if (!imageLink.equals("")){
                    imageLink = destinationFolderPath + "\\" + imageLink;
                    lbTrangChu_anhNhanVien.setIcon(null);
                    File file;
                    try {
                        file = new File(imageLink);
                        BufferedImage originalImage = ImageIO.read(file);
                        Image scaledImage = originalImage.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(scaledImage);
                        lbTrangChu_anhNhanVien.setIcon(icon);

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
        tabbedPane_trangChu = new javax.swing.JTabbedPane();
        jPanel26 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbHangHoa_loaiHang = new javax.swing.JComboBox<>();
        cbHangHoa_loaiHangDaChon = new javax.swing.JComboBox<>();
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
        btnHangHoa_import = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_danhSachHangHoa = new javax.swing.JTable();
        btnHangHoa_timKiem = new javax.swing.JButton();
        btnHangHoa_taiLai = new javax.swing.JButton();
        btnHangHoa_export = new javax.swing.JButton();
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
        btnDatHang_loadLaiKhachHang = new javax.swing.JButton();
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
        btnPhieuTraHang_exportFile = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_danhSachPhieuSuaChua = new javax.swing.JTable();
        btnSuaChua_them = new javax.swing.JButton();
        btnSuaChua_reset = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbSuaChua_soDienThoai = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        cb_nhanVienSuaChua = new javax.swing.JComboBox<>();
        jPanel67 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tare_noiDungSuaChua = new javax.swing.JTextArea();
        jPanel69 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        tfSuaChua_loaiXe = new javax.swing.JTextField();
        jPanel68 = new javax.swing.JPanel();
        cb_phuTungCanThay = new javax.swing.JComboBox<>();
        cbSuaChua_phuTungDaChon = new javax.swing.JComboBox<>();
        jPanel111 = new javax.swing.JPanel();
        lbSuaChua_chiMucKhachHang2 = new javax.swing.JLabel();
        tfSuaChua_tenPhuTungTimKiem = new javax.swing.JTextField();
        btnSuaChua_timPhuTung = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        lbSuaChua_chiMucKhachHang = new javax.swing.JLabel();
        tfSuaChua_tenKhachHang = new javax.swing.JTextField();
        btnSuaChua_themKhachHang = new javax.swing.JButton();
        btnSuaChua_timKhachHang = new javax.swing.JButton();
        cbSuaChua_danhSachKhachHang = new javax.swing.JComboBox<>();
        btnDatHang_loadLaiKhachHang1 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbSuaChua_tongTien = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tb_danhSachPhieuNhapHang = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnNhapHang_them = new javax.swing.JButton();
        btnPhieuNhapHang_export = new javax.swing.JButton();
        btnPhieuNhapHang_timKiem = new javax.swing.JButton();
        btnPhieuNhapHang_taiLai = new javax.swing.JButton();
        jPanel144 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        dateChoosePhieuNhapHang_batDau = new com.toedter.calendar.JDateChooser();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        dateChooserPhieuNhapHang_ketThuc = new com.toedter.calendar.JDateChooser();
        tabbedPane_doiTac = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jPanel93 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        tfKhachHang_locTuDong = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        tb_danhSachKhachHang = new javax.swing.JTable();
        jPanel72 = new javax.swing.JPanel();
        btnKhachHang_them = new javax.swing.JButton();
        btnKhachHoa_xuatFile = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        tfNhaCungCap_locTuDong = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tb_danhSachNhaCungCap = new javax.swing.JTable();
        jPanel74 = new javax.swing.JPanel();
        btnNhaCungCap_them = new javax.swing.JButton();
        btnNhaCungCap_xuatFile = new javax.swing.JButton();
        btnNhacungCap_import = new javax.swing.JButton();
        tabbedPane_nhanVien = new javax.swing.JTabbedPane();
        jPanel23 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        btnNhanVienChiNhanh_themNhanVien = new javax.swing.JButton();
        btnNhanVienChiNhanh_exportNhanVien = new javax.swing.JButton();
        btnNhanVienChiNhanh_importChiNhanh = new javax.swing.JButton();
        btnNhanVienChiNhanh_taiLai = new javax.swing.JButton();
        btnNhanVienChiNhanh_themChiNhanh = new javax.swing.JButton();
        btnNhanVienChiNhanh_exportChiNhanh = new javax.swing.JButton();
        btnNhanVienChiNhanh_importNhanVien = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_danhSachChiNhanh = new javax.swing.JTable();
        jPanel95 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        tfNhanVienChiNhanh_locTuDong = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tb_danhSachNhanVien = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        btnNhanVienChiNhanh_xemChiTiet = new javax.swing.JButton();
        lbNhanVienChiNhanh_ma = new javax.swing.JLabel();
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
        lbBangChamCong_soLuongNhanVien = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        dateChoose_bangCongNgayLam = new com.toedter.calendar.JDateChooser();
        jPanel89 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        lb_maBangChamCong = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        cb_bangCongTrangThai = new javax.swing.JComboBox<>();
        btn_bangCongThem = new javax.swing.JButton();
        btn_bangCongCapNhat = new javax.swing.JButton();
        btn_bangCongReset = new javax.swing.JButton();
        jPanel96 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        cb_bangCongNhanVien = new javax.swing.JComboBox<>();
        jPanel40 = new javax.swing.JPanel();
        jPanel99 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        tfLichLamViec_locTuDong = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tbLichLamViec_danhSachNhanVien = new javax.swing.JTable();
        btnLichLamViec_themBangLuong = new javax.swing.JButton();
        btnLichLamViec_lichNghiViec = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        lbLichLamViec_nhanViec = new javax.swing.JLabel();
        lbLichLamViec_thongBao = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tareLichLamViec_ghiChu = new javax.swing.JTextArea();
        jPanel42 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        tfLichLamViec_soGioTangCa = new javax.swing.JTextField();
        jPanel43 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        cbLichLamViec_bangLuong = new javax.swing.JComboBox<>();
        jPanel48 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lbLichLamViec_cccd = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        lbLichLamViec_tenNhanVien = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lbLichLamViec_maNhanVien = new javax.swing.JLabel();
        btnLichLamViec_lapPhieuLuong = new javax.swing.JButton();
        btnLichLamViec_capNhatLichLamViec = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tbLichLamViec_lichLamViec = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tbLichLamViec_lichTangCa = new javax.swing.JTable();
        jPanel50 = new javax.swing.JPanel();
        lbLichLamViec_ngayBatDauLabel = new javax.swing.JLabel();
        dateChooserLichLamViec_ngayBatDau = new com.toedter.calendar.JDateChooser();
        btnLichLamViec_themLichLamViec = new javax.swing.JButton();
        btnLichLamViec_themLichTangCa = new javax.swing.JButton();
        btnLichLamViec_luu = new javax.swing.JButton();
        panelLichLamViec_ngayKetThuc = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        dateChooserLichLamViec_ngayKetThuc = new com.toedter.calendar.JDateChooser();
        jPanel52 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        cbLichLamViec_trangThai = new javax.swing.JComboBox<>();
        jPanel53 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        cbLichLamViec_caLam = new javax.swing.JComboBox<>();
        jPanel54 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        lbLichLamViec_Ma = new javax.swing.JLabel();
        btnLichLamViec_themPhuCap = new javax.swing.JButton();
        btnLichLamViec_capNhatLichTangCa = new javax.swing.JButton();
        btnLichLamViec_huyBo = new javax.swing.JButton();
        btnLichLamViec_lamMoi = new javax.swing.JButton();
        jPanel56 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        cbLichLamViec_caLamDaChon = new javax.swing.JComboBox<>();
        btnLichLamViec_capNhatCaLam = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        tbLichLamViec_danhSachChiNhanh = new javax.swing.JTable();
        jPanel49 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        checkBoxPhanQuyen_kiemKhoXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_kiemKhoThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_kiemKhoCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_kiemKhoImport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_kiemKhoExport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_kiemKhoMail = new javax.swing.JCheckBox();
        jPanel112 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        checkBoxPhanQuyen_bangChamCongXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_bangChamCongThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_bangChamCongCapNhat = new javax.swing.JCheckBox();
        jPanel113 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        checkBoxPhanQuyen_bangLuongXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_bangLuongThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_bangLuongCapNhat = new javax.swing.JCheckBox();
        jPanel114 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        checkBoxPhanQuyen_caLamXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_caLamThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_caLamCapNhat = new javax.swing.JCheckBox();
        jPanel115 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        checkBoxPhanQuyen_chiNhanhXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_chiNhanhThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_chiNhanhCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_chiNhanhImport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_chiNhanhExport = new javax.swing.JCheckBox();
        jPanel116 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        checkBoxPhanQuyen_hangHoaXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_hangHoaThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_hangHoaCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_hangHoaImport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_hangHoaExport = new javax.swing.JCheckBox();
        jPanel117 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        checkBoxPhanQuyen_hoaDonXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_hoaDonThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_hoaDonCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_hoaDonExport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_hoaDonMail = new javax.swing.JCheckBox();
        jPanel118 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        checkBoxPhanQuyen_khachHangXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_khachHangThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_khachHangCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_khachHangImport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_khachHangExport = new javax.swing.JCheckBox();
        jPanel119 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        checkBoxPhanQuyen_lichLamViecXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_lichLamViecThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_lichLamViecCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_lichLamViecImport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_lichLamViecExport = new javax.swing.JCheckBox();
        jPanel105 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        checkBoxPhanQuyen_nhaCungCapXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_nhaCungCapThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_nhaCungCapCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_nhaCungCapImport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_nhaCungCapExport = new javax.swing.JCheckBox();
        jPanel120 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        checkBoxPhanQuyen_nhanVienXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_nhanVienThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_nhanVienCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_nhanVienExport = new javax.swing.JCheckBox();
        jPanel121 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        checkBoxPhanQuyen_phieuLuongXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phieuLuongThem = new javax.swing.JCheckBox();
        jPanel122 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        checkBoxPhanQuyen_phieuNhapHangXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phieuNhapHangThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phieuNhapHangCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phieuNhapHangExport = new javax.swing.JCheckBox();
        jPanel123 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        checkBoxPhanQuyen_phieuSuaChuaXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phieuSuaChuaThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phieuSuaChuaCapNhat = new javax.swing.JCheckBox();
        jPanel129 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        checkBoxPhanQuyen_phieuTraHangXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phieuTraHangThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phieuTraHangExport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phieuTraHangMail = new javax.swing.JCheckBox();
        jPanel130 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        checkBoxPhanQuyen_phuCapXem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phuCapThem = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phuCapCapNhat = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phuCapImport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phuCapExport = new javax.swing.JCheckBox();
        checkBoxPhanQuyen_phuCapMail = new javax.swing.JCheckBox();
        jPanel131 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        cbPhanQuyen_nhanVien = new javax.swing.JComboBox<>();
        jLabel123 = new javax.swing.JLabel();
        tfPhanQuyen_tenTenKhoan = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        tfPhanQuyen_matKhau = new javax.swing.JTextField();
        btnPhanQuyen_capNhat = new javax.swing.JButton();
        jPanel132 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        checkBoxPhanQuyen_datHang = new javax.swing.JCheckBox();
        jLabel126 = new javax.swing.JLabel();
        checkBoxPhanQuyen_phanQuyen = new javax.swing.JCheckBox();
        jPanel27 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lbDoanhThu_tienTraHangNhaCungCap = new javax.swing.JLabel();
        lbDoanhThu_soLuongPhieuTraHangNhaCungCap = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lbDoanhThu_soLuongHoaDon = new javax.swing.JLabel();
        lbDoanhThu_tienHoaDon = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        lbDoanhThu_tienSuaChua = new javax.swing.JLabel();
        lbDoanhThu_soLuongSuaChua = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        lbDoanhThu_tienTraHangKhachHang = new javax.swing.JLabel();
        lbDoanhThu_soLuongPhieuTraHangKhachHang = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        lbDoanhThu_tienNhapHang = new javax.swing.JLabel();
        lbDoanhThu_soLuongPhieuNhapHang = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        lbDoanhThu_loiNhuan = new javax.swing.JLabel();
        jPanel135 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        lbDoanhThu_tienLuongNhanVien = new javax.swing.JLabel();
        lbDoanhThu_soLuongPhieuLuong = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        tabbedDoanhThu = new javax.swing.JTabbedPane();
        jPanel133 = new javax.swing.JPanel();
        chart1 = new src.UI.Chart.chat.Chart();
        jPanel134 = new javax.swing.JPanel();
        pieChart1 = new src.UI.Chart.piechart.PieChart();
        jPanel20 = new javax.swing.JPanel();
        pieChart2 = new src.UI.Chart.piechart.PieChart();
        jPanel136 = new javax.swing.JPanel();
        pieChart3 = new src.UI.Chart.piechart.PieChart();
        jPanel137 = new javax.swing.JPanel();
        jPanel138 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbDoanhThu_tienLuong_tongSoNhanVien = new javax.swing.JLabel();
        jPanel139 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbDoanhThu_tienLuong_luongCung = new javax.swing.JLabel();
        jPanel140 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbDoanhThu_tienLuong_tangCa = new javax.swing.JLabel();
        jPanel141 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lbDoanhThu_tienLuong_tongTienThuong = new javax.swing.JLabel();
        jPanel142 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        lbDoanhThu_tienLuong_tongTienTroCap = new javax.swing.JLabel();
        jPanel143 = new javax.swing.JPanel();
        chart3 = new src.UI.Chart.chat.Chart();
        jPanel28 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        dateChooser_theoThang_thang = new com.toedter.calendar.JMonthChooser();
        radioDoanhThu_thang = new javax.swing.JRadioButton();
        dateChooser_theoThang_nam = new com.toedter.calendar.JYearChooser();
        jPanel17 = new javax.swing.JPanel();
        dateChooser_theoNgay_ngay = new com.toedter.calendar.JDateChooser();
        radioDoanhThu_ngay = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        dateChooser_ngayBatDau = new com.toedter.calendar.JDateChooser();
        jPanel83 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        dateChooser_ngayKetThuc = new com.toedter.calendar.JDateChooser();
        radioDoanhThu_khoangThoiGian = new javax.swing.JRadioButton();
        btnDoanhThu_timKiem = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        dateChooser_theoNam_nam = new com.toedter.calendar.JYearChooser();
        radioDoanhThu_nam = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbTrangChu_tenNguoiDung = new javax.swing.JLabel();
        lbTrangChu_anhNhanVien = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        btnTaiLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 249, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPane_trangChu.setBackground(new java.awt.Color(242, 249, 255));
        tabbedPane_trangChu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tabbedPane_trangChu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPane_trangChuStateChanged(evt);
            }
        });

        jPanel26.setBackground(new java.awt.Color(242, 249, 255));

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

        btnHangHoa_import.setBackground(new java.awt.Color(255, 102, 102));
        btnHangHoa_import.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHangHoa_import.setForeground(new java.awt.Color(255, 255, 255));
        btnHangHoa_import.setText("Import");
        btnHangHoa_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangHoa_importActionPerformed(evt);
            }
        });

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

        btnHangHoa_export.setBackground(new java.awt.Color(0, 0, 255));
        btnHangHoa_export.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHangHoa_export.setForeground(new java.awt.Color(255, 255, 255));
        btnHangHoa_export.setText("Export");
        btnHangHoa_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangHoa_exportActionPerformed(evt);
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
                    .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHangHoa_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHangHoa_taiLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHangHoa_them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHangHoa_import, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHangHoa_export, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
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
                            .addComponent(btnHangHoa_import, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHangHoa_export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnHangHoa_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(btnHangHoa_taiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        btnHangHoa_them.getAccessibleContext().setAccessibleName("btn_ThemHangHoa");

        tabbedPane_trangChu.addTab("Hàng hóa", jPanel26);

        tabPane_giaoDich.setBackground(new java.awt.Color(242, 249, 255));
        tabPane_giaoDich.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tabPane_giaoDich.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPane_giaoDichStateChanged(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(242, 249, 255));
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

        jPanel85.setBackground(new java.awt.Color(242, 249, 255));
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
        jPanel107.add(btnDatHang_themKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 20, 20));

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

        btnDatHang_loadLaiKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/return2.png"))); // NOI18N
        btnDatHang_loadLaiKhachHang.setBorder(null);
        btnDatHang_loadLaiKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHang_loadLaiKhachHangActionPerformed(evt);
            }
        });
        jPanel107.add(btnDatHang_loadLaiKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 20, 20));

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

        jPanel8.setBackground(new java.awt.Color(242, 249, 255));
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
                        .addGap(22, 176, Short.MAX_VALUE))))
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

        jPanel34.setBackground(new java.awt.Color(242, 249, 255));

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

        jPanel5.setBackground(new java.awt.Color(242, 249, 255));

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

        btnPhieuTraHang_exportFile.setBackground(new java.awt.Color(0, 204, 0));
        btnPhieuTraHang_exportFile.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnPhieuTraHang_exportFile.setForeground(new java.awt.Color(255, 255, 255));
        btnPhieuTraHang_exportFile.setText("Xuất file");
        btnPhieuTraHang_exportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuTraHang_exportFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1528, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 1440, Short.MAX_VALUE)
                        .addComponent(btnPhieuTraHang_exportFile)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btnPhieuTraHang_exportFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        tabPane_giaoDich.addTab("Trả hàng", jPanel5);

        jPanel6.setBackground(new java.awt.Color(242, 249, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_danhSachPhieuSuaChua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachPhieuSuaChua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Khách hàng", "Số điện thoại", "Loại xe", "Nội dung sửa chữa", "Nhân viên", "Tổng tiền", "Mã phiếu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_danhSachPhieuSuaChua.setRowHeight(30);
        tb_danhSachPhieuSuaChua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachPhieuSuaChuaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_danhSachPhieuSuaChua);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 200, 1508, 403));

        btnSuaChua_them.setBackground(new java.awt.Color(0, 204, 0));
        btnSuaChua_them.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnSuaChua_them.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaChua_them.setText("Thêm");
        btnSuaChua_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChua_themActionPerformed(evt);
            }
        });
        jPanel6.add(btnSuaChua_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 20, 121, 35));

        btnSuaChua_reset.setBackground(new java.awt.Color(255, 102, 102));
        btnSuaChua_reset.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnSuaChua_reset.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaChua_reset.setText("Reset");
        btnSuaChua_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChua_resetActionPerformed(evt);
            }
        });
        jPanel6.add(btnSuaChua_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 70, 121, 35));

        jPanel63.setBackground(new java.awt.Color(242, 249, 255));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Số điện thoại:");

        lbSuaChua_soDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbSuaChua_soDienThoai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(lbSuaChua_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbSuaChua_soDienThoai))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 380, -1));

        jPanel66.setBackground(new java.awt.Color(242, 249, 255));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel52.setText("Nhân viên:");

        cb_nhanVienSuaChua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_nhanVienSuaChua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kiệt", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(cb_nhanVienSuaChua, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
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

        jPanel6.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 380, 40));

        jPanel67.setBackground(new java.awt.Color(242, 249, 255));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel53.setText("Nội dung sửa chữa:");

        tare_noiDungSuaChua.setColumns(20);
        tare_noiDungSuaChua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tare_noiDungSuaChua.setRows(5);
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

        jPanel6.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 470, 140));

        jPanel69.setBackground(new java.awt.Color(242, 249, 255));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel56.setText("Loại xe:");

        tfSuaChua_loaiXe.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(tfSuaChua_loaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(tfSuaChua_loaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 470, 40));

        jPanel68.setBackground(new java.awt.Color(242, 249, 255));

        cb_phuTungCanThay.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_phuTungCanThay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phuộc xe", "Item 2", "Item 3", "Item 4" }));
        cb_phuTungCanThay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_phuTungCanThayActionPerformed(evt);
            }
        });

        cbSuaChua_phuTungDaChon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbSuaChua_phuTungDaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSuaChua_phuTungDaChonActionPerformed(evt);
            }
        });

        jPanel111.setBackground(new java.awt.Color(242, 249, 255));
        jPanel111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSuaChua_chiMucKhachHang2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbSuaChua_chiMucKhachHang2.setText("Tìm phụ tùng:");
        jPanel111.add(lbSuaChua_chiMucKhachHang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, -1));

        tfSuaChua_tenPhuTungTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfSuaChua_tenPhuTungTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfSuaChua_tenPhuTungTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSuaChua_tenPhuTungTimKiemMouseClicked(evt);
            }
        });
        jPanel111.add(tfSuaChua_tenPhuTungTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 220, 20));

        btnSuaChua_timPhuTung.setBackground(new java.awt.Color(0, 102, 255));
        btnSuaChua_timPhuTung.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnSuaChua_timPhuTung.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaChua_timPhuTung.setText("Tìm");
        btnSuaChua_timPhuTung.setBorder(null);
        btnSuaChua_timPhuTung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChua_timPhuTungActionPerformed(evt);
            }
        });
        jPanel111.add(btnSuaChua_timPhuTung, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 50, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Danh sách dịch vụ sửa chữa đã chọn:");

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel68Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbSuaChua_phuTungDaChon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_phuTungCanThay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel111, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_phuTungCanThay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSuaChua_phuTungDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 470, 140));

        jPanel109.setBackground(new java.awt.Color(242, 249, 255));
        jPanel109.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSuaChua_chiMucKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbSuaChua_chiMucKhachHang.setText("Tìm khách hàng:");
        jPanel109.add(lbSuaChua_chiMucKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 110, -1));

        tfSuaChua_tenKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfSuaChua_tenKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfSuaChua_tenKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSuaChua_tenKhachHangMouseClicked(evt);
            }
        });
        jPanel109.add(tfSuaChua_tenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 180, 20));

        btnSuaChua_themKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.jpg"))); // NOI18N
        btnSuaChua_themKhachHang.setBorder(null);
        btnSuaChua_themKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChua_themKhachHangActionPerformed(evt);
            }
        });
        jPanel109.add(btnSuaChua_themKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 20, 20));

        btnSuaChua_timKhachHang.setBackground(new java.awt.Color(0, 102, 255));
        btnSuaChua_timKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnSuaChua_timKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaChua_timKhachHang.setText("Tìm");
        btnSuaChua_timKhachHang.setBorder(null);
        btnSuaChua_timKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChua_timKhachHangActionPerformed(evt);
            }
        });
        jPanel109.add(btnSuaChua_timKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 50, 30));

        cbSuaChua_danhSachKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbSuaChua_danhSachKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSuaChua_danhSachKhachHangActionPerformed(evt);
            }
        });
        jPanel109.add(cbSuaChua_danhSachKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 300, -1));

        btnDatHang_loadLaiKhachHang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/return2.png"))); // NOI18N
        btnDatHang_loadLaiKhachHang1.setBorder(null);
        btnDatHang_loadLaiKhachHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHang_loadLaiKhachHang1ActionPerformed(evt);
            }
        });
        jPanel109.add(btnDatHang_loadLaiKhachHang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 20, 20));

        jPanel6.add(jPanel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 380, 90));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Tổng tiền:");

        lbSuaChua_tongTien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbSuaChua_tongTien.setText("0");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(lbSuaChua_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbSuaChua_tongTien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, -1, 30));

        tabPane_giaoDich.addTab("Yêu cầu sữa chửa", jPanel6);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel70.setBackground(new java.awt.Color(242, 249, 255));
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

        tb_danhSachPhieuNhapHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachPhieuNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhập hàng", "Thời gian", "Nhà cung cấp", "Tổng", "Mã phiếu nhập hàng"
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

        jPanel7.setBackground(new java.awt.Color(242, 249, 255));

        btnNhapHang_them.setBackground(new java.awt.Color(0, 204, 0));
        btnNhapHang_them.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhapHang_them.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapHang_them.setText("Thêm");
        btnNhapHang_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHang_themActionPerformed(evt);
            }
        });

        btnPhieuNhapHang_export.setBackground(new java.awt.Color(102, 102, 102));
        btnPhieuNhapHang_export.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnPhieuNhapHang_export.setForeground(new java.awt.Color(255, 255, 255));
        btnPhieuNhapHang_export.setText("Xuất file");
        btnPhieuNhapHang_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuNhapHang_exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNhapHang_them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPhieuNhapHang_export)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapHang_them, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhieuNhapHang_export, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel70.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, 230, 40));

        btnPhieuNhapHang_timKiem.setBackground(new java.awt.Color(0, 51, 255));
        btnPhieuNhapHang_timKiem.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnPhieuNhapHang_timKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnPhieuNhapHang_timKiem.setText("TÌM KIẾM");
        btnPhieuNhapHang_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuNhapHang_timKiemActionPerformed(evt);
            }
        });
        jPanel70.add(btnPhieuNhapHang_timKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btnPhieuNhapHang_taiLai.setBackground(new java.awt.Color(255, 153, 153));
        btnPhieuNhapHang_taiLai.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnPhieuNhapHang_taiLai.setForeground(new java.awt.Color(255, 255, 255));
        btnPhieuNhapHang_taiLai.setText("TẢI LẠI");
        btnPhieuNhapHang_taiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhieuNhapHang_taiLaiActionPerformed(evt);
            }
        });
        jPanel70.add(btnPhieuNhapHang_taiLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        jPanel144.setBackground(new java.awt.Color(255, 255, 255));

        jLabel161.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel161.setText("Thời gian");

        dateChoosePhieuNhapHang_batDau.setDateFormatString("yyyy-MM-dd");

        jLabel162.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel162.setText("Bắt đầu");

        jLabel163.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel163.setText("Kết thúc");

        dateChooserPhieuNhapHang_ketThuc.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel144Layout = new javax.swing.GroupLayout(jPanel144);
        jPanel144.setLayout(jPanel144Layout);
        jPanel144Layout.setHorizontalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel144Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel144Layout.createSequentialGroup()
                        .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel144Layout.createSequentialGroup()
                        .addGroup(jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChoosePhieuNhapHang_batDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateChooserPhieuNhapHang_ketThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        jPanel144Layout.setVerticalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel144Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel161)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChoosePhieuNhapHang_batDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel162))
                .addGap(20, 20, 20)
                .addGroup(jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel163)
                    .addComponent(dateChooserPhieuNhapHang_ketThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel70.add(jPanel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 250, 120));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, 1540, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabPane_giaoDich.addTab("Nhập hàng", jPanel4);

        tabbedPane_trangChu.addTab("Giao dịch", tabPane_giaoDich);

        tabbedPane_doiTac.setBackground(new java.awt.Color(242, 249, 255));
        tabbedPane_doiTac.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tabbedPane_doiTac.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPane_doiTacStateChanged(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(242, 249, 255));

        jPanel71.setBackground(new java.awt.Color(242, 249, 255));
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

        tfKhachHang_locTuDong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfKhachHang_locTuDong.setForeground(new java.awt.Color(153, 153, 153));
        tfKhachHang_locTuDong.setText("Tìm tên khách hàng");
        tfKhachHang_locTuDong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfKhachHang_locTuDong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfKhachHang_locTuDongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfKhachHang_locTuDongFocusLost(evt);
            }
        });
        tfKhachHang_locTuDong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfKhachHang_locTuDongKeyReleased(evt);
            }
        });
        jPanel93.add(tfKhachHang_locTuDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 270, -1));

        jPanel71.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 420, 40));

        tb_danhSachKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Điện thoại", "Email", "Mã số thuế", "Tổng bán"
            }
        ));
        tb_danhSachKhachHang.setRowHeight(30);
        tb_danhSachKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachKhachHangMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tb_danhSachKhachHang);

        jPanel71.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1520, 500));

        jPanel72.setBackground(new java.awt.Color(242, 249, 255));

        btnKhachHang_them.setBackground(new java.awt.Color(0, 204, 0));
        btnKhachHang_them.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnKhachHang_them.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHang_them.setText("Khách hàng");
        btnKhachHang_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHang_themActionPerformed(evt);
            }
        });

        btnKhachHoa_xuatFile.setBackground(new java.awt.Color(102, 102, 102));
        btnKhachHoa_xuatFile.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnKhachHoa_xuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHoa_xuatFile.setText("Xuất file");
        btnKhachHoa_xuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHoa_xuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(btnKhachHang_them)
                .addGap(18, 18, 18)
                .addComponent(btnKhachHoa_xuatFile)
                .addGap(14, 14, 14))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKhachHang_them, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachHoa_xuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel12.setBackground(new java.awt.Color(242, 249, 255));

        jPanel73.setBackground(new java.awt.Color(242, 249, 255));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel94.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.jpg"))); // NOI18N
        jPanel94.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        tfNhaCungCap_locTuDong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfNhaCungCap_locTuDong.setForeground(new java.awt.Color(153, 153, 153));
        tfNhaCungCap_locTuDong.setText("Tìm tên nhà cung cấp");
        tfNhaCungCap_locTuDong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfNhaCungCap_locTuDong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNhaCungCap_locTuDongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNhaCungCap_locTuDongFocusLost(evt);
            }
        });
        tfNhaCungCap_locTuDong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNhaCungCap_locTuDongKeyReleased(evt);
            }
        });
        jPanel94.add(tfNhaCungCap_locTuDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 270, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Lọc tự động");
        jPanel94.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel73.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 420, 40));

        tb_danhSachNhaCungCap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Điện thoại", "Email", "Mã số thuế", "Tổng mua"
            }
        ));
        tb_danhSachNhaCungCap.setRowHeight(30);
        tb_danhSachNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachNhaCungCapMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tb_danhSachNhaCungCap);

        jPanel73.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1520, 500));

        jPanel74.setBackground(new java.awt.Color(242, 249, 255));

        btnNhaCungCap_them.setBackground(new java.awt.Color(0, 204, 0));
        btnNhaCungCap_them.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhaCungCap_them.setForeground(new java.awt.Color(255, 255, 255));
        btnNhaCungCap_them.setText("Thêm nhà cung cấp");
        btnNhaCungCap_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhaCungCap_themActionPerformed(evt);
            }
        });

        btnNhaCungCap_xuatFile.setBackground(new java.awt.Color(102, 102, 102));
        btnNhaCungCap_xuatFile.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhaCungCap_xuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnNhaCungCap_xuatFile.setText("Xuất file");
        btnNhaCungCap_xuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhaCungCap_xuatFileActionPerformed(evt);
            }
        });

        btnNhacungCap_import.setBackground(new java.awt.Color(0, 204, 0));
        btnNhacungCap_import.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhacungCap_import.setForeground(new java.awt.Color(255, 255, 255));
        btnNhacungCap_import.setText("Import");
        btnNhacungCap_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhacungCap_importActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(btnNhaCungCap_them)
                .addGap(28, 28, 28)
                .addComponent(btnNhacungCap_import)
                .addGap(27, 27, 27)
                .addComponent(btnNhaCungCap_xuatFile)
                .addContainerGap())
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhaCungCap_them, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhaCungCap_xuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhacungCap_import, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        tabbedPane_nhanVien.setBackground(new java.awt.Color(242, 249, 255));
        tabbedPane_nhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tabbedPane_nhanVien.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPane_nhanVienStateChanged(evt);
            }
        });

        jPanel23.setBackground(new java.awt.Color(242, 249, 255));

        jPanel75.setBackground(new java.awt.Color(242, 249, 255));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel76.setBackground(new java.awt.Color(242, 249, 255));

        btnNhanVienChiNhanh_themNhanVien.setBackground(new java.awt.Color(0, 51, 255));
        btnNhanVienChiNhanh_themNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhanVienChiNhanh_themNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVienChiNhanh_themNhanVien.setText("Thêm nhân viên");
        btnNhanVienChiNhanh_themNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienChiNhanh_themNhanVienActionPerformed(evt);
            }
        });

        btnNhanVienChiNhanh_exportNhanVien.setBackground(new java.awt.Color(102, 102, 102));
        btnNhanVienChiNhanh_exportNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhanVienChiNhanh_exportNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVienChiNhanh_exportNhanVien.setText("Xuất file nhân viên");
        btnNhanVienChiNhanh_exportNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienChiNhanh_exportNhanVienActionPerformed(evt);
            }
        });

        btnNhanVienChiNhanh_importChiNhanh.setBackground(new java.awt.Color(0, 204, 204));
        btnNhanVienChiNhanh_importChiNhanh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhanVienChiNhanh_importChiNhanh.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVienChiNhanh_importChiNhanh.setText("Import chi nhánh");
        btnNhanVienChiNhanh_importChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienChiNhanh_importChiNhanhActionPerformed(evt);
            }
        });

        btnNhanVienChiNhanh_taiLai.setBackground(new java.awt.Color(255, 102, 102));
        btnNhanVienChiNhanh_taiLai.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhanVienChiNhanh_taiLai.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVienChiNhanh_taiLai.setText("Tải lại");
        btnNhanVienChiNhanh_taiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienChiNhanh_taiLaiActionPerformed(evt);
            }
        });

        btnNhanVienChiNhanh_themChiNhanh.setBackground(new java.awt.Color(0, 204, 0));
        btnNhanVienChiNhanh_themChiNhanh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhanVienChiNhanh_themChiNhanh.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVienChiNhanh_themChiNhanh.setText("Thêm chi nhánh");
        btnNhanVienChiNhanh_themChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienChiNhanh_themChiNhanhActionPerformed(evt);
            }
        });

        btnNhanVienChiNhanh_exportChiNhanh.setBackground(new java.awt.Color(102, 102, 102));
        btnNhanVienChiNhanh_exportChiNhanh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhanVienChiNhanh_exportChiNhanh.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVienChiNhanh_exportChiNhanh.setText("Xuất file chi nhánh");
        btnNhanVienChiNhanh_exportChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienChiNhanh_exportChiNhanhActionPerformed(evt);
            }
        });

        btnNhanVienChiNhanh_importNhanVien.setBackground(new java.awt.Color(0, 204, 204));
        btnNhanVienChiNhanh_importNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnNhanVienChiNhanh_importNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVienChiNhanh_importNhanVien.setText("Import nhân viên");
        btnNhanVienChiNhanh_importNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienChiNhanh_importNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnNhanVienChiNhanh_taiLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhanVienChiNhanh_themChiNhanh)
                .addGap(18, 18, 18)
                .addComponent(btnNhanVienChiNhanh_themNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnNhanVienChiNhanh_importNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhanVienChiNhanh_importChiNhanh)
                .addGap(18, 18, 18)
                .addComponent(btnNhanVienChiNhanh_exportChiNhanh)
                .addGap(18, 18, 18)
                .addComponent(btnNhanVienChiNhanh_exportNhanVien)
                .addContainerGap())
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhanVienChiNhanh_themNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanVienChiNhanh_exportNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanVienChiNhanh_importChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanVienChiNhanh_taiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanVienChiNhanh_themChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanVienChiNhanh_exportChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanVienChiNhanh_importNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel75.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 1080, 40));

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
        tb_danhSachChiNhanh.setRowHeight(30);
        tb_danhSachChiNhanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachChiNhanhMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tb_danhSachChiNhanh);

        jPanel75.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1520, 110));

        jPanel95.setBackground(new java.awt.Color(255, 255, 255));
        jPanel95.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel95.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.jpg"))); // NOI18N
        jPanel95.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        tfNhanVienChiNhanh_locTuDong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfNhanVienChiNhanh_locTuDong.setForeground(new java.awt.Color(153, 153, 153));
        tfNhanVienChiNhanh_locTuDong.setText("Tìm tên nhân viên");
        tfNhanVienChiNhanh_locTuDong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfNhanVienChiNhanh_locTuDong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNhanVienChiNhanh_locTuDongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNhanVienChiNhanh_locTuDongFocusLost(evt);
            }
        });
        tfNhanVienChiNhanh_locTuDong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNhanVienChiNhanh_locTuDongKeyReleased(evt);
            }
        });
        jPanel95.add(tfNhanVienChiNhanh_locTuDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 270, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setText("Lọc tự động");
        jPanel95.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel75.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 420, 40));

        jPanel87.setBackground(new java.awt.Color(242, 249, 255));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addComponent(jLabel55)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel75.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, 30));

        tb_danhSachNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "CMND/CCCD", "Chức vụ"
            }
        ));
        tb_danhSachNhanVien.setRowHeight(30);
        tb_danhSachNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachNhanVienMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tb_danhSachNhanVien);

        jPanel75.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1520, 360));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel20.setText("Danh sách chi nhánh");
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel75.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel39.setBackground(new java.awt.Color(242, 249, 255));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNhanVienChiNhanh_xemChiTiet.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnNhanVienChiNhanh_xemChiTiet.setText("Xem chi tiết");
        btnNhanVienChiNhanh_xemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienChiNhanh_xemChiTietActionPerformed(evt);
            }
        });
        jPanel39.add(btnNhanVienChiNhanh_xemChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        lbNhanVienChiNhanh_ma.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbNhanVienChiNhanh_ma.setText("Mã chi nhánh");
        jPanel39.add(lbNhanVienChiNhanh_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 20));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1319, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                    .addContainerGap(10, Short.MAX_VALUE)
                    .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, 1520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(10, Short.MAX_VALUE)))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(575, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tabbedPane_nhanVien.addTab("Nhân viên/ Chi nhánh", jPanel23);

        jPanel24.setBackground(new java.awt.Color(242, 249, 255));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_danhSachBangChamCong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tb_danhSachBangChamCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã bảng", "Ngày làm", "Mã nhân viên", "Tên nhân viên", "Trạng thái"
            }
        ));
        tb_danhSachBangChamCong.setRowHeight(30);
        tb_danhSachBangChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_danhSachBangChamCongMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tb_danhSachBangChamCong);

        jPanel24.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 139, 1248, 440));

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

        jPanel25.setBackground(new java.awt.Color(242, 249, 255));

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

        lbBangChamCong_soLuongNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbBangChamCong_soLuongNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbBangChamCong_soLuongNhanVien.setText("0");

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbBangChamCong_soLuongNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(lbBangChamCong_soLuongNhanVien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 590, -1, -1));

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

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel99.setBackground(new java.awt.Color(255, 255, 255));
        jPanel99.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel99.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.jpg"))); // NOI18N
        jPanel99.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        tfLichLamViec_locTuDong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfLichLamViec_locTuDong.setForeground(new java.awt.Color(153, 153, 153));
        tfLichLamViec_locTuDong.setText("Tìm tên nhân viên");
        tfLichLamViec_locTuDong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        tfLichLamViec_locTuDong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfLichLamViec_locTuDongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfLichLamViec_locTuDongFocusLost(evt);
            }
        });
        tfLichLamViec_locTuDong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfLichLamViec_locTuDongKeyReleased(evt);
            }
        });
        jPanel99.add(tfLichLamViec_locTuDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 270, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel28.setText("Lọc tự động");
        jPanel99.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel40.add(jPanel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 420, 40));

        tbLichLamViec_danhSachNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbLichLamViec_danhSachNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "CMND/CCCD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLichLamViec_danhSachNhanVien.setRowHeight(30);
        tbLichLamViec_danhSachNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLichLamViec_danhSachNhanVienMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tbLichLamViec_danhSachNhanVien);

        jPanel40.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 440, 410));

        btnLichLamViec_themBangLuong.setBackground(new java.awt.Color(0, 204, 51));
        btnLichLamViec_themBangLuong.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_themBangLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_themBangLuong.setText("Bảng lương");
        btnLichLamViec_themBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_themBangLuongActionPerformed(evt);
            }
        });
        jPanel40.add(btnLichLamViec_themBangLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        btnLichLamViec_lichNghiViec.setBackground(new java.awt.Color(0, 204, 204));
        btnLichLamViec_lichNghiViec.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_lichNghiViec.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_lichNghiViec.setText("Lịch nghỉ việc");
        btnLichLamViec_lichNghiViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_lichNghiViecActionPerformed(evt);
            }
        });
        jPanel40.add(btnLichLamViec_lichNghiViec, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        jPanel44.setBackground(new java.awt.Color(242, 249, 255));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel47.setBackground(new java.awt.Color(242, 249, 255));

        lbLichLamViec_nhanViec.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbLichLamViec_nhanViec.setText("Thêm lịch làm việc");

        lbLichLamViec_thongBao.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbLichLamViec_thongBao.setForeground(new java.awt.Color(255, 0, 51));
        lbLichLamViec_thongBao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(lbLichLamViec_thongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(lbLichLamViec_nhanViec, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addGap(220, 220, 220))))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(lbLichLamViec_nhanViec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbLichLamViec_thongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel44.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 360, 50));

        jPanel41.setBackground(new java.awt.Color(242, 249, 255));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel25.setText("Ghi chú");

        tareLichLamViec_ghiChu.setColumns(20);
        tareLichLamViec_ghiChu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tareLichLamViec_ghiChu.setLineWrap(true);
        tareLichLamViec_ghiChu.setRows(5);
        jScrollPane15.setViewportView(tareLichLamViec_ghiChu);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 350, 90));

        jPanel42.setBackground(new java.awt.Color(242, 249, 255));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel26.setText("Số giờ tăng ca");

        tfLichLamViec_soGioTangCa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(tfLichLamViec_soGioTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(tfLichLamViec_soGioTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 320, -1));

        jPanel43.setBackground(new java.awt.Color(242, 249, 255));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel27.setText("Bảng lương");

        cbLichLamViec_bangLuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLichLamViec_bangLuong, 0, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cbLichLamViec_bangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 350, -1));

        jPanel48.setBackground(new java.awt.Color(242, 249, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel35.setText("CCCD:");

        lbLichLamViec_cccd.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbLichLamViec_cccd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLichLamViec_cccd.setText("tên");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLichLamViec_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lbLichLamViec_cccd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 200, -1));

        jPanel45.setBackground(new java.awt.Color(242, 249, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel29.setText("Họ và tên:");

        lbLichLamViec_tenNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbLichLamViec_tenNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLichLamViec_tenNhanVien.setText("tên");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLichLamViec_tenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lbLichLamViec_tenNhanVien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 300, -1));

        jPanel46.setBackground(new java.awt.Color(242, 249, 255));
        jPanel46.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel31.setText("Mã nhân viên:");

        lbLichLamViec_maNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbLichLamViec_maNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLichLamViec_maNhanVien.setText("tên");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLichLamViec_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lbLichLamViec_maNhanVien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, -1));

        btnLichLamViec_lapPhieuLuong.setBackground(new java.awt.Color(255, 153, 51));
        btnLichLamViec_lapPhieuLuong.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_lapPhieuLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_lapPhieuLuong.setText("Lập phiếu lương");
        btnLichLamViec_lapPhieuLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_lapPhieuLuongActionPerformed(evt);
            }
        });
        jPanel44.add(btnLichLamViec_lapPhieuLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 150, -1));

        btnLichLamViec_capNhatLichLamViec.setBackground(new java.awt.Color(51, 51, 255));
        btnLichLamViec_capNhatLichLamViec.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_capNhatLichLamViec.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_capNhatLichLamViec.setText("Cập nhật");
        btnLichLamViec_capNhatLichLamViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_capNhatLichLamViecActionPerformed(evt);
            }
        });
        jPanel44.add(btnLichLamViec_capNhatLichLamViec, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, 30));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel37.setText("Lịch tăng ca");
        jPanel44.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        tbLichLamViec_lichLamViec.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbLichLamViec_lichLamViec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Ngày bắt đầu", "Ngày kết thúc", "Ca làm", "Trạng thái", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLichLamViec_lichLamViec.setRowHeight(30);
        tbLichLamViec_lichLamViec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLichLamViec_lichLamViecMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tbLichLamViec_lichLamViec);

        jPanel44.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 640, 200));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel38.setText("Lịch làm việc");
        jPanel44.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        tbLichLamViec_lichTangCa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbLichLamViec_lichTangCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lịch làm việc", "Ngày", "Ghi chú", "Số giờ tăng ca", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLichLamViec_lichTangCa.setRowHeight(30);
        tbLichLamViec_lichTangCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLichLamViec_lichTangCaMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tbLichLamViec_lichTangCa);

        jPanel44.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 640, 190));

        jPanel50.setBackground(new java.awt.Color(242, 249, 255));

        lbLichLamViec_ngayBatDauLabel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbLichLamViec_ngayBatDauLabel.setText("Ngày bắt đầu");

        dateChooserLichLamViec_ngayBatDau.setDateFormatString("yyyy-MM-dd");
        dateChooserLichLamViec_ngayBatDau.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLichLamViec_ngayBatDauLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(dateChooserLichLamViec_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooserLichLamViec_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLichLamViec_ngayBatDauLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 320, -1));

        btnLichLamViec_themLichLamViec.setBackground(new java.awt.Color(0, 204, 0));
        btnLichLamViec_themLichLamViec.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_themLichLamViec.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_themLichLamViec.setText("Thêm");
        btnLichLamViec_themLichLamViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_themLichLamViecActionPerformed(evt);
            }
        });
        jPanel44.add(btnLichLamViec_themLichLamViec, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 30));

        btnLichLamViec_themLichTangCa.setBackground(new java.awt.Color(0, 204, 0));
        btnLichLamViec_themLichTangCa.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_themLichTangCa.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_themLichTangCa.setText("Thêm");
        btnLichLamViec_themLichTangCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_themLichTangCaActionPerformed(evt);
            }
        });
        jPanel44.add(btnLichLamViec_themLichTangCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, 30));

        btnLichLamViec_luu.setBackground(new java.awt.Color(0, 204, 0));
        btnLichLamViec_luu.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_luu.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_luu.setText("Lưu");
        btnLichLamViec_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_luuActionPerformed(evt);
            }
        });
        jPanel44.add(btnLichLamViec_luu, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, -1, 30));

        panelLichLamViec_ngayKetThuc.setBackground(new java.awt.Color(242, 249, 255));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel42.setText("Ngày kết thúc");

        dateChooserLichLamViec_ngayKetThuc.setDateFormatString("yyyy-MM-dd");
        dateChooserLichLamViec_ngayKetThuc.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout panelLichLamViec_ngayKetThucLayout = new javax.swing.GroupLayout(panelLichLamViec_ngayKetThuc);
        panelLichLamViec_ngayKetThuc.setLayout(panelLichLamViec_ngayKetThucLayout);
        panelLichLamViec_ngayKetThucLayout.setHorizontalGroup(
            panelLichLamViec_ngayKetThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLichLamViec_ngayKetThucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(dateChooserLichLamViec_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLichLamViec_ngayKetThucLayout.setVerticalGroup(
            panelLichLamViec_ngayKetThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLichLamViec_ngayKetThucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLichLamViec_ngayKetThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooserLichLamViec_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(panelLichLamViec_ngayKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 320, -1));

        jPanel52.setBackground(new java.awt.Color(242, 249, 255));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel43.setText("Trạng thái");

        cbLichLamViec_trangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbLichLamViec_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang diễn ra", "Đã trả lương", "Nghỉ" }));

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(cbLichLamViec_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(cbLichLamViec_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 320, -1));

        jPanel53.setBackground(new java.awt.Color(242, 249, 255));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel44.setText("Ca làm");

        cbLichLamViec_caLam.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbLichLamViec_caLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLichLamViec_caLamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(cbLichLamViec_caLam, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(cbLichLamViec_caLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 320, -1));

        jPanel54.setBackground(new java.awt.Color(242, 249, 255));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel45.setText("Mã");

        lbLichLamViec_Ma.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbLichLamViec_Ma.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLichLamViec_Ma.setText("0");

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lbLichLamViec_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(lbLichLamViec_Ma))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 320, -1));

        btnLichLamViec_themPhuCap.setBackground(new java.awt.Color(255, 153, 153));
        btnLichLamViec_themPhuCap.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_themPhuCap.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_themPhuCap.setText("Thêm phụ cấp");
        btnLichLamViec_themPhuCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_themPhuCapActionPerformed(evt);
            }
        });
        jPanel44.add(btnLichLamViec_themPhuCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 150, -1));

        btnLichLamViec_capNhatLichTangCa.setBackground(new java.awt.Color(51, 51, 255));
        btnLichLamViec_capNhatLichTangCa.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_capNhatLichTangCa.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_capNhatLichTangCa.setText("Cập nhật");
        btnLichLamViec_capNhatLichTangCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_capNhatLichTangCaActionPerformed(evt);
            }
        });
        jPanel44.add(btnLichLamViec_capNhatLichTangCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, 30));

        btnLichLamViec_huyBo.setBackground(new java.awt.Color(255, 0, 0));
        btnLichLamViec_huyBo.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_huyBo.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_huyBo.setText("Hủy");
        btnLichLamViec_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_huyBoActionPerformed(evt);
            }
        });
        jPanel44.add(btnLichLamViec_huyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 530, -1, 30));

        btnLichLamViec_lamMoi.setBackground(new java.awt.Color(255, 51, 102));
        btnLichLamViec_lamMoi.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_lamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_lamMoi.setText("Làm mới");
        btnLichLamViec_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_lamMoiActionPerformed(evt);
            }
        });
        jPanel44.add(btnLichLamViec_lamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, -1, 30));

        jPanel56.setBackground(new java.awt.Color(242, 249, 255));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel46.setText("Ca làm đã chọn");

        cbLichLamViec_caLamDaChon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbLichLamViec_caLamDaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLichLamViec_caLamDaChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(cbLichLamViec_caLamDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(cbLichLamViec_caLamDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 320, -1));

        jPanel40.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 1030, 570));

        btnLichLamViec_capNhatCaLam.setBackground(new java.awt.Color(255, 102, 153));
        btnLichLamViec_capNhatCaLam.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLichLamViec_capNhatCaLam.setForeground(new java.awt.Color(255, 255, 255));
        btnLichLamViec_capNhatCaLam.setText("Cập nhật ca làm");
        btnLichLamViec_capNhatCaLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViec_capNhatCaLamActionPerformed(evt);
            }
        });
        jPanel40.add(btnLichLamViec_capNhatCaLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        tbLichLamViec_danhSachChiNhanh.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbLichLamViec_danhSachChiNhanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chi nhánh", "Tên chi nhánh"
            }
        ));
        tbLichLamViec_danhSachChiNhanh.setRowHeight(30);
        tbLichLamViec_danhSachChiNhanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLichLamViec_danhSachChiNhanhMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(tbLichLamViec_danhSachChiNhanh);

        jPanel40.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 120));

        tabbedPane_nhanVien.addTab("Lịch làm việc", jPanel40);

        jPanel49.setBackground(new java.awt.Color(242, 249, 255));

        jPanel57.setBackground(new java.awt.Color(242, 249, 255));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel30.setText("Danh mục chức năng");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel32.setText("Xem");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel33.setText("Thêm");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel34.setText("Cập nhật");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel36.setText("Import");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel39.setText("Export");
        jLabel39.setToolTipText("");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel40.setText("Gửi mail");
        jLabel40.setToolTipText("");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel30)
                .addGap(147, 147, 147)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel36)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel58.setBackground(new java.awt.Color(242, 249, 255));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel41.setText("(16) Kiểm kho");
        jPanel58.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel58.add(checkBoxPhanQuyen_kiemKhoXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel58.add(checkBoxPhanQuyen_kiemKhoThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel58.add(checkBoxPhanQuyen_kiemKhoCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel58.add(checkBoxPhanQuyen_kiemKhoImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 6, -1, -1));
        jPanel58.add(checkBoxPhanQuyen_kiemKhoExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));
        jPanel58.add(checkBoxPhanQuyen_kiemKhoMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1345, 6, -1, -1));

        jPanel112.setBackground(new java.awt.Color(172, 234, 255));
        jPanel112.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel48.setText("(1) Quản lý bảng chấm công");
        jPanel112.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel112.add(checkBoxPhanQuyen_bangChamCongXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel112.add(checkBoxPhanQuyen_bangChamCongThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel112.add(checkBoxPhanQuyen_bangChamCongCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));

        jPanel113.setBackground(new java.awt.Color(242, 249, 255));
        jPanel113.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel49.setText("(2) Quản lý bảng bảng lương");
        jPanel113.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel113.add(checkBoxPhanQuyen_bangLuongXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel113.add(checkBoxPhanQuyen_bangLuongThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel113.add(checkBoxPhanQuyen_bangLuongCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));

        jPanel114.setBackground(new java.awt.Color(172, 234, 255));
        jPanel114.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel50.setText("(3) Quản lý bảng ca làm");
        jPanel114.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel114.add(checkBoxPhanQuyen_caLamXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel114.add(checkBoxPhanQuyen_caLamThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel114.add(checkBoxPhanQuyen_caLamCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));

        jPanel115.setBackground(new java.awt.Color(242, 249, 255));
        jPanel115.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel51.setText("(4) Quản lý chi nhánh");
        jPanel115.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel115.add(checkBoxPhanQuyen_chiNhanhXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel115.add(checkBoxPhanQuyen_chiNhanhThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel115.add(checkBoxPhanQuyen_chiNhanhCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel115.add(checkBoxPhanQuyen_chiNhanhImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 6, -1, -1));
        jPanel115.add(checkBoxPhanQuyen_chiNhanhExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));

        jPanel116.setBackground(new java.awt.Color(172, 234, 255));
        jPanel116.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel54.setText("(5) Quản lý hàng hóa");
        jPanel116.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel116.add(checkBoxPhanQuyen_hangHoaXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel116.add(checkBoxPhanQuyen_hangHoaThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel116.add(checkBoxPhanQuyen_hangHoaCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel116.add(checkBoxPhanQuyen_hangHoaImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 6, -1, -1));
        jPanel116.add(checkBoxPhanQuyen_hangHoaExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));

        jPanel117.setBackground(new java.awt.Color(242, 249, 255));
        jPanel117.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel103.setText("(6) Quản lý hóa đơn");
        jPanel117.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel117.add(checkBoxPhanQuyen_hoaDonXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel117.add(checkBoxPhanQuyen_hoaDonThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel117.add(checkBoxPhanQuyen_hoaDonCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel117.add(checkBoxPhanQuyen_hoaDonExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));
        jPanel117.add(checkBoxPhanQuyen_hoaDonMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1345, 6, -1, -1));

        jPanel118.setBackground(new java.awt.Color(172, 234, 255));
        jPanel118.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel104.setText("(7) Quản lý khách hàng");
        jPanel118.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel118.add(checkBoxPhanQuyen_khachHangXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel118.add(checkBoxPhanQuyen_khachHangThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel118.add(checkBoxPhanQuyen_khachHangCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel118.add(checkBoxPhanQuyen_khachHangImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 6, -1, -1));
        jPanel118.add(checkBoxPhanQuyen_khachHangExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));

        jPanel119.setBackground(new java.awt.Color(242, 249, 255));
        jPanel119.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel105.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel105.setText("(8) Quản lý lịch làm việc");
        jPanel119.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel119.add(checkBoxPhanQuyen_lichLamViecXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel119.add(checkBoxPhanQuyen_lichLamViecThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel119.add(checkBoxPhanQuyen_lichLamViecCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel119.add(checkBoxPhanQuyen_lichLamViecImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 6, -1, -1));
        jPanel119.add(checkBoxPhanQuyen_lichLamViecExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));

        jPanel105.setBackground(new java.awt.Color(172, 234, 255));
        jPanel105.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel99.setText("(9) Quản lý nhà cung cấp");
        jPanel105.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel105.add(checkBoxPhanQuyen_nhaCungCapXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel105.add(checkBoxPhanQuyen_nhaCungCapThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel105.add(checkBoxPhanQuyen_nhaCungCapCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel105.add(checkBoxPhanQuyen_nhaCungCapImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 6, -1, -1));
        jPanel105.add(checkBoxPhanQuyen_nhaCungCapExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));

        jPanel120.setBackground(new java.awt.Color(242, 249, 255));
        jPanel120.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel106.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel106.setText("(10) Quản lý nhân viên");
        jPanel120.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel120.add(checkBoxPhanQuyen_nhanVienXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel120.add(checkBoxPhanQuyen_nhanVienThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel120.add(checkBoxPhanQuyen_nhanVienCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel120.add(checkBoxPhanQuyen_nhanVienExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));

        jPanel121.setBackground(new java.awt.Color(172, 234, 255));
        jPanel121.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel107.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel107.setText("(11) Quản lý phiếu lương");
        jPanel121.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel121.add(checkBoxPhanQuyen_phieuLuongXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel121.add(checkBoxPhanQuyen_phieuLuongThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));

        jPanel122.setBackground(new java.awt.Color(242, 249, 255));
        jPanel122.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel108.setText("(12) Quản lý phiếu nhập hàng");
        jLabel108.setToolTipText("");
        jPanel122.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel122.add(checkBoxPhanQuyen_phieuNhapHangXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel122.add(checkBoxPhanQuyen_phieuNhapHangThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel122.add(checkBoxPhanQuyen_phieuNhapHangCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel122.add(checkBoxPhanQuyen_phieuNhapHangExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));

        jPanel123.setBackground(new java.awt.Color(172, 234, 255));
        jPanel123.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel119.setText("(13) Quản lý phiếu sửa chữa");
        jPanel123.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel123.add(checkBoxPhanQuyen_phieuSuaChuaXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel123.add(checkBoxPhanQuyen_phieuSuaChuaThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel123.add(checkBoxPhanQuyen_phieuSuaChuaCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));

        jPanel129.setBackground(new java.awt.Color(242, 249, 255));
        jPanel129.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel120.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel120.setText("(14) Quản lý phiếu trả hàng");
        jPanel129.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel129.add(checkBoxPhanQuyen_phieuTraHangXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel129.add(checkBoxPhanQuyen_phieuTraHangThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel129.add(checkBoxPhanQuyen_phieuTraHangExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));
        jPanel129.add(checkBoxPhanQuyen_phieuTraHangMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1345, 6, -1, -1));

        jPanel130.setBackground(new java.awt.Color(172, 234, 255));
        jPanel130.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel121.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel121.setText("(15) Quản lý phụ cấp");
        jPanel130.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, -1, -1));
        jPanel130.add(checkBoxPhanQuyen_phuCapXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 6, -1, -1));
        jPanel130.add(checkBoxPhanQuyen_phuCapThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));
        jPanel130.add(checkBoxPhanQuyen_phuCapCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 6, -1, -1));
        jPanel130.add(checkBoxPhanQuyen_phuCapImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 6, -1, -1));
        jPanel130.add(checkBoxPhanQuyen_phuCapExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1181, 6, -1, -1));
        jPanel130.add(checkBoxPhanQuyen_phuCapMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1345, 6, -1, -1));

        jPanel131.setBackground(new java.awt.Color(242, 249, 255));

        jLabel122.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel122.setText("Nhân viên:");

        cbPhanQuyen_nhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbPhanQuyen_nhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kiệt", "Item 2", "Item 3", "Item 4" }));
        cbPhanQuyen_nhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPhanQuyen_nhanVienActionPerformed(evt);
            }
        });

        jLabel123.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel123.setText("Tên tài khoản:");

        tfPhanQuyen_tenTenKhoan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfPhanQuyen_tenTenKhoan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPhanQuyen_tenTenKhoan.setText("0");

        jLabel124.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel124.setText("Mật khẩu:");

        tfPhanQuyen_matKhau.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfPhanQuyen_matKhau.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPhanQuyen_matKhau.setText("0");

        javax.swing.GroupLayout jPanel131Layout = new javax.swing.GroupLayout(jPanel131);
        jPanel131.setLayout(jPanel131Layout);
        jPanel131Layout.setHorizontalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel131Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel122)
                .addGap(18, 18, 18)
                .addComponent(cbPhanQuyen_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel123)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPhanQuyen_tenTenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel124)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPhanQuyen_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel131Layout.setVerticalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel131Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel124)
                        .addComponent(tfPhanQuyen_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel122)
                        .addComponent(cbPhanQuyen_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel123)
                        .addComponent(tfPhanQuyen_tenTenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPhanQuyen_capNhat.setBackground(new java.awt.Color(0, 204, 0));
        btnPhanQuyen_capNhat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnPhanQuyen_capNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnPhanQuyen_capNhat.setText("Cập nhật");
        btnPhanQuyen_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanQuyen_capNhatActionPerformed(evt);
            }
        });

        jPanel132.setBackground(new java.awt.Color(172, 234, 255));

        jLabel125.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel125.setText("(17) Đặt hàng");

        jLabel126.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel126.setText("(18) Phân quyền");

        javax.swing.GroupLayout jPanel132Layout = new javax.swing.GroupLayout(jPanel132);
        jPanel132.setLayout(jPanel132Layout);
        jPanel132Layout.setHorizontalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel132Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel125)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxPhanQuyen_datHang)
                .addGap(39, 39, 39)
                .addComponent(jLabel126)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxPhanQuyen_phanQuyen)
                .addContainerGap())
        );
        jPanel132Layout.setVerticalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel132Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhanQuyen_phanQuyen)
                    .addComponent(jLabel126)
                    .addComponent(jLabel125)
                    .addComponent(checkBoxPhanQuyen_datHang, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel130, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel49Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel131, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPhanQuyen_capNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel132, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPhanQuyen_capNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel116, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel117, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel118, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel121, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel132, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        tabbedPane_nhanVien.addTab("Phân quyền", jPanel49);

        tabbedPane_trangChu.addTab("Nhân sự", tabbedPane_nhanVien);

        jPanel27.setBackground(new java.awt.Color(242, 249, 255));

        jPanel35.setBackground(new java.awt.Color(242, 249, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel35.setToolTipText("");
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("KẾT QUẢ BÁN HÀNG NGÀY HÔM NAY");
        jPanel35.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, -1));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel23.setText("Trả hàng nhà cung cấp");

        lbDoanhThu_tienTraHangNhaCungCap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbDoanhThu_tienTraHangNhaCungCap.setForeground(new java.awt.Color(255, 102, 102));
        lbDoanhThu_tienTraHangNhaCungCap.setText("0");

        lbDoanhThu_soLuongPhieuTraHangNhaCungCap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_soLuongPhieuTraHangNhaCungCap.setText("0 phiếu trả hàng");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbDoanhThu_tienTraHangNhaCungCap)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbDoanhThu_soLuongPhieuTraHangNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDoanhThu_soLuongPhieuTraHangNhaCungCap)
                .addGap(14, 14, 14)
                .addComponent(lbDoanhThu_tienTraHangNhaCungCap)
                .addGap(15, 15, 15)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 170, 100));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        lbDoanhThu_soLuongHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_soLuongHoaDon.setText("0 hóa đơn");

        lbDoanhThu_tienHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbDoanhThu_tienHoaDon.setForeground(new java.awt.Color(51, 51, 255));
        lbDoanhThu_tienHoaDon.setText("0");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel16.setText("Bán hàng");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDoanhThu_soLuongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(lbDoanhThu_tienHoaDon))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDoanhThu_soLuongHoaDon)
                .addGap(14, 14, 14)
                .addComponent(lbDoanhThu_tienHoaDon)
                .addGap(15, 15, 15)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 160, 100));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel76.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel76.setText("Sữa chữa");

        lbDoanhThu_tienSuaChua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbDoanhThu_tienSuaChua.setForeground(new java.awt.Color(255, 102, 102));
        lbDoanhThu_tienSuaChua.setText("0");

        lbDoanhThu_soLuongSuaChua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_soLuongSuaChua.setText("0 phiếu sữa chữa");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbDoanhThu_soLuongSuaChua, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel76))
                    .addComponent(lbDoanhThu_tienSuaChua))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDoanhThu_soLuongSuaChua)
                .addGap(14, 14, 14)
                .addComponent(lbDoanhThu_tienSuaChua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel76)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 170, 100));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel80.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel80.setText("Khách hàng trả hàng");

        lbDoanhThu_tienTraHangKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbDoanhThu_tienTraHangKhachHang.setForeground(new java.awt.Color(255, 102, 102));
        lbDoanhThu_tienTraHangKhachHang.setText("0");

        lbDoanhThu_soLuongPhieuTraHangKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_soLuongPhieuTraHangKhachHang.setText("0 phiếu trả hàng");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbDoanhThu_tienTraHangKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(lbDoanhThu_soLuongPhieuTraHangKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addGap(15, 15, 15))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDoanhThu_soLuongPhieuTraHangKhachHang)
                .addGap(14, 14, 14)
                .addComponent(lbDoanhThu_tienTraHangKhachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel80)
                .addContainerGap())
        );

        jPanel35.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 170, 100));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jLabel83.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel83.setText("Nhập hàng");

        lbDoanhThu_tienNhapHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbDoanhThu_tienNhapHang.setForeground(new java.awt.Color(255, 102, 102));
        lbDoanhThu_tienNhapHang.setText("0");

        lbDoanhThu_soLuongPhieuNhapHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_soLuongPhieuNhapHang.setText("0 phiếu nhập hàng");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDoanhThu_tienNhapHang)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbDoanhThu_soLuongPhieuNhapHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDoanhThu_soLuongPhieuNhapHang)
                .addGap(14, 14, 14)
                .addComponent(lbDoanhThu_tienNhapHang)
                .addGap(15, 15, 15)
                .addComponent(jLabel83)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 160, 100));

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));

        jLabel87.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel87.setText("Lợi nhuận");

        lbDoanhThu_loiNhuan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbDoanhThu_loiNhuan.setForeground(new java.awt.Color(255, 102, 102));
        lbDoanhThu_loiNhuan.setText("0");

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87)
                    .addComponent(lbDoanhThu_loiNhuan))
                .addGap(0, 48, Short.MAX_VALUE))
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addComponent(jLabel87)
                .addGap(20, 20, 20)
                .addComponent(lbDoanhThu_loiNhuan)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 40, 160, 100));

        jPanel135.setBackground(new java.awt.Color(255, 255, 255));

        jLabel88.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel88.setText("Lương nhân viên");

        lbDoanhThu_tienLuongNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbDoanhThu_tienLuongNhanVien.setForeground(new java.awt.Color(255, 102, 102));
        lbDoanhThu_tienLuongNhanVien.setText("0");

        lbDoanhThu_soLuongPhieuLuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_soLuongPhieuLuong.setText("0 phiếu lương");

        javax.swing.GroupLayout jPanel135Layout = new javax.swing.GroupLayout(jPanel135);
        jPanel135.setLayout(jPanel135Layout);
        jPanel135Layout.setHorizontalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel135Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbDoanhThu_tienLuongNhanVien)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel135Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDoanhThu_soLuongPhieuLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel135Layout.setVerticalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel135Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDoanhThu_soLuongPhieuLuong)
                .addGap(14, 14, 14)
                .addComponent(lbDoanhThu_tienLuongNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel88)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.add(jPanel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 160, 100));

        jPanel37.setBackground(new java.awt.Color(242, 249, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        tabbedDoanhThu.setBackground(new java.awt.Color(242, 249, 255));
        tabbedDoanhThu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jPanel133.setBackground(new java.awt.Color(242, 249, 255));

        javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
        jPanel133.setLayout(jPanel133Layout);
        jPanel133Layout.setHorizontalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel133Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 1222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel133Layout.setVerticalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel133Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedDoanhThu.addTab("Doanh thu", jPanel133);

        jPanel134.setBackground(new java.awt.Color(242, 249, 255));

        pieChart1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel134Layout = new javax.swing.GroupLayout(jPanel134);
        jPanel134.setLayout(jPanel134Layout);
        jPanel134Layout.setHorizontalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel134Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel134Layout.setVerticalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel134Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedDoanhThu.addTab("Hàng hóa bán chạy", jPanel134);

        jPanel20.setBackground(new java.awt.Color(242, 249, 255));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pieChart2, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pieChart2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        );

        tabbedDoanhThu.addTab("Hàng hóa sữa chữa", jPanel20);

        jPanel136.setBackground(new java.awt.Color(242, 249, 255));

        javax.swing.GroupLayout jPanel136Layout = new javax.swing.GroupLayout(jPanel136);
        jPanel136.setLayout(jPanel136Layout);
        jPanel136Layout.setHorizontalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel136Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pieChart3, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel136Layout.setVerticalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel136Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pieChart3, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        );

        tabbedDoanhThu.addTab("Hàng hóa được nhập", jPanel136);

        jPanel137.setBackground(new java.awt.Color(242, 249, 255));

        jPanel138.setBackground(new java.awt.Color(242, 249, 255));
        jPanel138.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Tổng số nhân viên:");
        jPanel138.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 140, -1));

        lbDoanhThu_tienLuong_tongSoNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_tienLuong_tongSoNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDoanhThu_tienLuong_tongSoNhanVien.setText("0");
        jPanel138.add(lbDoanhThu_tienLuong_tongSoNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 6, 110, -1));

        jPanel139.setBackground(new java.awt.Color(242, 249, 255));
        jPanel139.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setText("Tổng lương cứng:");
        jPanel139.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 140, -1));

        lbDoanhThu_tienLuong_luongCung.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_tienLuong_luongCung.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDoanhThu_tienLuong_luongCung.setText("0");
        jPanel139.add(lbDoanhThu_tienLuong_luongCung, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 6, 100, -1));

        jPanel140.setBackground(new java.awt.Color(242, 249, 255));
        jPanel140.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setText("Tổng lương tăng ca:");
        jPanel140.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 140, -1));

        lbDoanhThu_tienLuong_tangCa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_tienLuong_tangCa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDoanhThu_tienLuong_tangCa.setText("0");
        jPanel140.add(lbDoanhThu_tienLuong_tangCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 6, 90, -1));

        jPanel141.setBackground(new java.awt.Color(242, 249, 255));
        jPanel141.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel22.setText("Tổng tiền thưởng:");
        jPanel141.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 140, -1));

        lbDoanhThu_tienLuong_tongTienThuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_tienLuong_tongTienThuong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDoanhThu_tienLuong_tongTienThuong.setText("0");
        jPanel141.add(lbDoanhThu_tienLuong_tongTienThuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 6, 100, -1));

        jPanel142.setBackground(new java.awt.Color(242, 249, 255));
        jPanel142.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel70.setText("Tổng tiền trợ cấp:");
        jPanel142.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 140, -1));

        lbDoanhThu_tienLuong_tongTienTroCap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbDoanhThu_tienLuong_tongTienTroCap.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDoanhThu_tienLuong_tongTienTroCap.setText("0");
        jPanel142.add(lbDoanhThu_tienLuong_tongTienTroCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 6, 100, -1));

        javax.swing.GroupLayout jPanel143Layout = new javax.swing.GroupLayout(jPanel143);
        jPanel143.setLayout(jPanel143Layout);
        jPanel143Layout.setHorizontalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel143Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart3, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel143Layout.setVerticalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel143Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart3, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel137Layout = new javax.swing.GroupLayout(jPanel137);
        jPanel137.setLayout(jPanel137Layout);
        jPanel137Layout.setHorizontalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel137Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel139, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel140, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel142, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel137Layout.setVerticalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel137Layout.createSequentialGroup()
                .addGroup(jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel137Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel138, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel139, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel140, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel141, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel142, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel137Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tabbedDoanhThu.addTab("Tiền lương", jPanel137);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(242, 249, 255));

        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel67.setText("Tìm kiếm");

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        dateChooser_theoThang_thang.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        dateChooser_theoThang_thang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        buttonGroup1.add(radioDoanhThu_thang);
        radioDoanhThu_thang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        radioDoanhThu_thang.setText("Theo tháng");
        radioDoanhThu_thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDoanhThu_thangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioDoanhThu_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateChooser_theoThang_nam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateChooser_theoThang_thang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioDoanhThu_thang)
                    .addComponent(dateChooser_theoThang_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooser_theoThang_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        dateChooser_theoNgay_ngay.setDateFormatString("yyyy-MM-dd");
        dateChooser_theoNgay_ngay.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        buttonGroup1.add(radioDoanhThu_ngay);
        radioDoanhThu_ngay.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        radioDoanhThu_ngay.setText("Theo ngày");
        radioDoanhThu_ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDoanhThu_ngayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioDoanhThu_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateChooser_theoNgay_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioDoanhThu_ngay)
                    .addComponent(dateChooser_theoNgay_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jPanel82.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel68.setText("Ngày bắt đầu");

        dateChooser_ngayBatDau.setDateFormatString("yyyy-MM-dd");
        dateChooser_ngayBatDau.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel82Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(dateChooser_ngayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(dateChooser_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel69.setText("Ngày kết thúc");

        dateChooser_ngayKetThuc.setDateFormatString("yyyy-MM-dd");
        dateChooser_ngayKetThuc.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel83Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(dateChooser_ngayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(dateChooser_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonGroup1.add(radioDoanhThu_khoangThoiGian);
        radioDoanhThu_khoangThoiGian.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        radioDoanhThu_khoangThoiGian.setText("Theo khoảng thời gian");
        radioDoanhThu_khoangThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDoanhThu_khoangThoiGianActionPerformed(evt);
            }
        });

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
                        .addComponent(radioDoanhThu_khoangThoiGian)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioDoanhThu_khoangThoiGian)
                .addGap(5, 5, 5)
                .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDoanhThu_timKiem.setBackground(new java.awt.Color(255, 102, 102));
        btnDoanhThu_timKiem.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnDoanhThu_timKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnDoanhThu_timKiem.setText("Tìm kiếm");
        btnDoanhThu_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanhThu_timKiemActionPerformed(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        buttonGroup1.add(radioDoanhThu_nam);
        radioDoanhThu_nam.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        radioDoanhThu_nam.setText("Theo năm");
        radioDoanhThu_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDoanhThu_namActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioDoanhThu_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateChooser_theoNam_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioDoanhThu_nam)
                    .addComponent(dateChooser_theoNam_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnDoanhThu_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoanhThu_timKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, 1471, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane_trangChu.addTab("Doanh thu", jPanel27);

        getContentPane().add(tabbedPane_trangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1540, 700));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Screenshot 2024-02-26 152859.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 50));
        jLabel4.getAccessibleContext().setAccessibleName("m");

        jPanel51.setBackground(new java.awt.Color(242, 249, 255));

        jPanel3.setBackground(new java.awt.Color(242, 249, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Nhân viên");

        lbTrangChu_tenNguoiDung.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbTrangChu_tenNguoiDung.setText("Tên người dùng");

        lbTrangChu_anhNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangChu_anhNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.jpg"))); // NOI18N
        lbTrangChu_anhNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTrangChu_tenNguoiDung)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(lbTrangChu_anhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTrangChu_tenNguoiDung)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(lbTrangChu_anhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnDangXuat.setBackground(new java.awt.Color(51, 0, 255));
        btnDangXuat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnTaiLai.setBackground(new java.awt.Color(255, 102, 102));
        btnTaiLai.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnTaiLai.setForeground(new java.awt.Color(255, 255, 255));
        btnTaiLai.setText("Tải lại");
        btnTaiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addContainerGap(1130, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaiLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(btnTaiLai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDangXuat)))
                .addGap(0, 720, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHangHoa_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHoa_themActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 5.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm hàng hóa!");
                return;
            }
        Frame_ThemHangHoa frame_themHangHoa = new Frame_ThemHangHoa(nhanVienDangNhap);
        frame_themHangHoa.setVisible(true);
        frame_themHangHoa.setSize(850, 520);
        frame_themHangHoa.setLocation(0,0);
    }//GEN-LAST:event_btnHangHoa_themActionPerformed

    private void btnDatHang_themKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang_themKhachHangActionPerformed
        Frame_ThemKhachHang frame_themKhachHang = new Frame_ThemKhachHang(nhanVienDangNhap);
        frame_themKhachHang.setVisible(true);
        frame_themKhachHang.setSize(950, 400);
        frame_themKhachHang.setLocation(0,0);
    }//GEN-LAST:event_btnDatHang_themKhachHangActionPerformed

    private void tb_danhSachPhieuNhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachPhieuNhapHangMouseClicked
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 12.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem thông tin chi tiết phiếu nhập hàng!");
                return;
            }
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
        frame_ChiTietDonNhapHang frame_chiTietDonNhapHang = new frame_ChiTietDonNhapHang(phieuNhapHang, nhanVienDangNhap);
        frame_chiTietDonNhapHang.setVisible(true);
        frame_chiTietDonNhapHang.setSize(1000, 720);
        frame_chiTietDonNhapHang.setLocation(0,0);
    }//GEN-LAST:event_tb_danhSachPhieuNhapHangMouseClicked

    private void tabPane_giaoDichStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPane_giaoDichStateChanged
        
        int selectedIndex = tabPane_giaoDich.getSelectedIndex();
        if (selectedIndex == 1 && tabbedPane_trangChu.getSelectedIndex() == 1) { // Change 1 to the index of your specific tab
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 6.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý hóa đơn!");
                return;
            }
            hienThiDanhSachHoaDon();
            hienThiDanhSachNhanVienCombobox(cbHoaDon_nguoiTao);
        } 
        if (selectedIndex == 2 && tabbedPane_trangChu.getSelectedIndex() == 1){
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 14.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý phiếu trả hàng!");
                return;
            }
            hienThiDanhSachPhieuTraHang();
        }
        if (selectedIndex == 3 && tabbedPane_trangChu.getSelectedIndex() == 1){
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 13.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý sữa chữa!");
                return;
            }
            List<LoaiXe> danhSachLoaiXe = new ArrayList<>();
            try {
                danhSachLoaiXe = loaiXeService.hienThiTatCaLoaiXe();
            } catch (SQLException ex) {
                System.out.println("Loi hien thi combobox loai xe");
            }
            
            List<NhanVien> danhSachNhanVien = new ArrayList<>();
            try {
                danhSachNhanVien = nhanVienService.hienThiTatCaNhanVien();
            } catch (SQLException ex) {
                System.out.println("Loi hien thi combobox nhan vien sua chua");
            }
            cb_nhanVienSuaChua.removeAllItems();
            for (NhanVien nhanVien : danhSachNhanVien) {
                cb_nhanVienSuaChua.addItem(nhanVien.getMaNhanVien() + " " + nhanVien.getTenNhanVien());
            }
            
            List<HangHoa> danhSachHangHoa = new ArrayList<>();
            try {
                danhSachHangHoa = hangHoaService.hienThiTatCaHangHoa("","");
            } catch (SQLException ex) {
                System.out.println("Loi hien thi combobox hang hoa");
            }
            cb_phuTungCanThay.removeAllItems();
            cb_phuTungCanThay.addItem("");
            for (HangHoa hangHoa : danhSachHangHoa) {
                if (hangHoa.getTonKho() > 0){
                    cb_phuTungCanThay.addItem(hangHoa.getMaHangHoa() + " " + hangHoa.getTenHangHoa() + " ;Giá " + hangHoa.getGiaThay());
                }
                
            }
            hienThiDanhSachPhieuSuaChua();
            hienThiDanhSachKhachHangTaiCombobox(cbSuaChua_danhSachKhachHang);
            lbSuaChua_tongTien.setText("0");
            TableColumnModel columnModel = tb_danhSachPhieuSuaChua.getColumnModel();
            TableColumn columnMaPhieuSuaChua = columnModel.getColumn(6);
            columnMaPhieuSuaChua.setMaxWidth(0);
            columnMaPhieuSuaChua.setMinWidth(0);
            
//            cbSuaChua_phuTungDaChon.setEnabled(false);
            btnSuaChua_timKhachHang.setVisible(false);
            btnSuaChua_timPhuTung.setVisible(false);
            cb_phuTungCanThay.setEnabled(false);
            cbSuaChua_danhSachKhachHang.setEnabled(false);
            cb_nhanVienSuaChua.setEnabled(false);
            tare_noiDungSuaChua.setEnabled(false);
            tb_danhSachPhieuSuaChua.setEnabled(true);
            btnSuaChua_reset.setVisible(false);
        }
        if (selectedIndex == 4){
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 12.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý phiếu nhập hàng!");
                return;
            }
            try {
                hienThiDanhSachPhieuNhapHang();

            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tabPane_giaoDichStateChanged

    private void tb_danhSachPhieuSuaChuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachPhieuSuaChuaMouseClicked
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 13.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập xem chi tiết phiếu sữa chữa!");
                return;
            }
        int index = tb_danhSachPhieuSuaChua.getSelectedRow();
        TableModel model = tb_danhSachPhieuSuaChua.getModel();
        lbSuaChua_soDienThoai.setText(model.getValueAt(index, 1).toString());
        tfSuaChua_loaiXe.setText(model.getValueAt(index, 2).toString());
        tare_noiDungSuaChua.setText(model.getValueAt(index, 3).toString());
//        cb_phuTungCanThay.setSelectedItem(model.getValueAt(index, 4).toString());
//        cb_nhanVienSuaChua.setSelectedItem(model.getValueAt(index, 4).toString());
        for (int i =0; i< cb_nhanVienSuaChua.getItemCount(); i++){
            if (cb_nhanVienSuaChua.getItemAt(i).toString().contains(model.getValueAt(index, 4).toString())){
                cb_nhanVienSuaChua.setSelectedIndex(i);
                break;
            }
        }

        cbSuaChua_danhSachKhachHang.setSelectedIndex(0);
        tfSuaChua_tenKhachHang.setText(model.getValueAt(index, 0).toString());
        lbSuaChua_tongTien.setText(model.getValueAt(index, 5).toString());
        try {
            List<HangHoa> danhSachPhuTung = phieuSuaChuaService.hienThiTatCaPhuTungTheoMaPhieuSuaChua(model.getValueAt(index, 6).toString());
            actionPerformedPhuTungDaChonEnabled = false;
            cbSuaChua_phuTungDaChon.removeAllItems();
            actionPerformedPhuTungDaChonEnabled = true;
            for (HangHoa hangHoa : danhSachPhuTung) {
                actionPerformedPhuTungDaChonEnabled = false;
                cbSuaChua_phuTungDaChon.addItem(hangHoa.getMaHangHoa() + " " + hangHoa.getTenHangHoa() + " ;Giá " + hangHoa.getGiaThay());
                actionPerformedPhuTungDaChonEnabled = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tb_danhSachPhieuSuaChuaMouseClicked

    private void tabbedPane_doiTacStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPane_doiTacStateChanged
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 9.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý nhà cung cấp!");
                return;
            }
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
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 4.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý chi nhánh!");
                return;
            }
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 10.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý nhân viên!");
                return;
            }
            hienThiDanhSachNhanVien();
            hienThiDanhSachChiNhanh();
        }
        if (selectedTab == 1 && tabPane_giaoDich.getSelectedIndex() == 0){
             if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 17 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền đặt hàng ,thanh toán!");
                return;
            }
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
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 7.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập trang quản lý khách hàng!");
                return;
            }
            hienThiDanhSachKhachHang();
        }
        
        if (selectedTab == 4 && tabbedDoanhThu.getSelectedIndex() == 0){
            dateChooser_ngayBatDau.setEnabled(false);
            dateChooser_ngayKetThuc.setEnabled(false);
            dateChooser_theoNam_nam.setEnabled(false);
            dateChooser_theoNgay_ngay.setEnabled(false);
            dateChooser_theoThang_nam.setEnabled(false);
            dateChooser_theoThang_thang.setEnabled(false);
        }
    }//GEN-LAST:event_tabbedPane_trangChuStateChanged

    private void tabbedPane_nhanVienStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPane_nhanVienStateChanged
        
        int selectedTab = tabbedPane_nhanVien.getSelectedIndex();
        if (selectedTab == 1 && tabbedPane_trangChu.getSelectedIndex() == 3 ){
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 1.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào bảng chấm công!");
                return;
            }
            hienThiDanhSachBangChamCong();
            try {
                List<NhanVien> danhSachNhanVien = nhanVienService.hienThiTatCaNhanVien();
                cb_bangCongNhanVien.removeAllItems();
                cb_bangCongNhanVien.addItem("");
                for (NhanVien nhanVien : danhSachNhanVien) {
                    cb_bangCongNhanVien.addItem(nhanVien.getMaNhanVien() + " " + nhanVien.getTenNhanVien());
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
        if (selectedTab == 2 && tabbedPane_trangChu.getSelectedIndex() == 3){
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 8.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý lịch làm việc!");
                return;
            }
            hienThiDanhSachNhanVienLichLamViec();
            hienThiDanhSachChiNhanhLichLamViec();
            lbLichLamViec_maNhanVien.setText("");
            hienThiThemLichLamViec(false, false, false);
            hienThiDanhSachCaLamCombobox(cbLichLamViec_caLam);
            
            btnLichLamViec_capNhatLichLamViec.setEnabled(false);
            btnLichLamViec_capNhatLichTangCa.setEnabled(false);
            btnLichLamViec_themLichLamViec.setEnabled(false);
            btnLichLamViec_themLichTangCa.setEnabled(false);
            btnLichLamViec_themPhuCap.setEnabled(false);
            btnLichLamViec_lapPhieuLuong.setEnabled(false);
            
        }
        
        if (selectedTab == 3){
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 18 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý phân quyền nhân viên!");
                return;
            }
            hienThiDanhSachNhanVienCombobox(cbPhanQuyen_nhanVien);
            
        }
    }//GEN-LAST:event_tabbedPane_nhanVienStateChanged

    private void hienThiThemLichLamViec(boolean them, boolean lichLamViec, boolean lichTangCa){
        lbLichLamViec_Ma.setEnabled(them);
        dateChooserLichLamViec_ngayBatDau.setEnabled(them);
        dateChooserLichLamViec_ngayKetThuc.setEnabled(them);
        cbLichLamViec_bangLuong.setEnabled(them);
        cbLichLamViec_caLam.setEnabled(them);
        cbLichLamViec_trangThai.setEnabled(them);
        cbLichLamViec_caLamDaChon.setEnabled(them);
        tfLichLamViec_soGioTangCa.setEnabled(them);
        tareLichLamViec_ghiChu.setEnabled(them);
        btnLichLamViec_huyBo.setEnabled(them);
        btnLichLamViec_luu.setEnabled(them);
        
        if (them == true){
            btnLichLamViec_capNhatLichLamViec.setEnabled(false);
            btnLichLamViec_capNhatLichTangCa.setEnabled(false);
            btnLichLamViec_lapPhieuLuong.setEnabled(false);
            btnLichLamViec_themLichLamViec.setEnabled(false);
            btnLichLamViec_themLichTangCa.setEnabled(false);
            btnLichLamViec_themPhuCap.setEnabled(false);
            btnLichLamViec_huyBo.setEnabled(true);
            btnLichLamViec_lamMoi.setEnabled(true);
            btnLichLamViec_luu.setEnabled(true);
            lbLichLamViec_thongBao.setText("");
        } else {
            btnLichLamViec_capNhatLichLamViec.setEnabled(true);
            btnLichLamViec_capNhatLichTangCa.setEnabled(true);
            btnLichLamViec_lapPhieuLuong.setEnabled(true);
            btnLichLamViec_themLichLamViec.setEnabled(true);
            btnLichLamViec_themLichTangCa.setEnabled(true);
            btnLichLamViec_themPhuCap.setEnabled(true);
            btnLichLamViec_huyBo.setEnabled(false);
            btnLichLamViec_lamMoi.setEnabled(false);
            btnLichLamViec_luu.setEnabled(false);
            lbLichLamViec_thongBao.setText("");
            tfLichLamViec_soGioTangCa.setText("");
        }
        if(lichLamViec == true){
            tfLichLamViec_soGioTangCa.setEnabled(false);
            
            
        } else {
            tfLichLamViec_soGioTangCa.setEnabled(true);
        }
        if (lichTangCa == true){
            cbLichLamViec_caLam.setEnabled(false);
            cbLichLamViec_caLamDaChon.setEnabled(false);
            panelLichLamViec_ngayKetThuc.setVisible(false);
            lbLichLamViec_ngayBatDauLabel.setText("Ngày");
            btnLichLamViec_capNhatLichLamViec.setEnabled(false);
            btnLichLamViec_themLichLamViec.setEnabled(false);
        } else {
            panelLichLamViec_ngayKetThuc.setVisible(true);
            lbLichLamViec_ngayBatDauLabel.setText("Ngày bắt đầu");
            btnLichLamViec_capNhatLichTangCa.setEnabled(false);
            btnLichLamViec_capNhatLichTangCa.setEnabled(false);
            btnLichLamViec_themLichTangCa.setEnabled(false);
        }
    }
    
    private void tb_danhSachBangChamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachBangChamCongMouseClicked
        int index = tb_danhSachBangChamCong.getSelectedRow();
        TableModel model = tb_danhSachBangChamCong.getModel();
        cb_bangCongNhanVien.setSelectedItem(model.getValueAt(index, 2).toString()+ " " + model.getValueAt(index, 3).toString());
        dateChoose_bangCongNgayLam.setDate(util.layNgayDate(model.getValueAt(index, 1).toString()));
        
        cb_bangCongTrangThai.setSelectedItem(model.getValueAt(index, 4).toString());
        lb_maBangChamCong.setText(model.getValueAt(index, 0).toString());
    }//GEN-LAST:event_tb_danhSachBangChamCongMouseClicked

    private void btn_bangCongResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bangCongResetActionPerformed
        cb_bangCongNhanVien.setSelectedItem("");
        cb_bangCongTrangThai.setSelectedItem("Đầy đủ");
        
        lb_maBangChamCong.setText("");
    }//GEN-LAST:event_btn_bangCongResetActionPerformed

    private void btn_bangCongCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bangCongCapNhatActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 1.3 ")){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền cập nhật bảng chấm công!");
            return;
        }
        BangChamCong bangChamCongNew = new BangChamCong();
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
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 1.2 ")){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm bảng chấm công!");
            return;
        }
        BangChamCong bangChamCongNew = new BangChamCong();
        bangChamCongNew.setMaBangChamCong("BC0" + String.valueOf(tongSoBangChamCong + 1));
        System.out.println(dateChoose_bangCongNgayLam.getDate());
        bangChamCongNew.setNgayLam(util.localDateParseMethodToLocalDate(util.layNgayString(dateChoose_bangCongNgayLam.getDate())));
        bangChamCongNew.setMaNhanVien(cb_bangCongNhanVien.getSelectedItem().toString().split(" ")[0]);
        bangChamCongNew.setTrangThai(cb_bangCongTrangThai.getSelectedItem().toString());
        try {   
            if (bangChamCongService.kiemTraDiemDanhNhanVien(bangChamCongNew.getNgayLam(), bangChamCongNew.getMaNhanVien()) == 0){
                bangChamCongService.themBangChamCong(bangChamCongNew);
            }
            hienThiDanhSachBangChamCong();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btn_bangCongThemActionPerformed

    private void btnChamCong_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCong_timKiemActionPerformed
        try {
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 1.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào xem bảng chấm công!");
                return;
            }
            List<BangChamCong> danhSachBangChamCong = new ArrayList<>();
            if (radioChamCong_khoangThoiGian.isSelected() == true){
                LocalDate ngayBatDau = util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserChamCong_ngayBatDau.getDate()));
                LocalDate ngayKetThuc = util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserChamCong_ngayKetThuc.getDate()));
                danhSachBangChamCong = bangChamCongService.hienThiBangChamCongTheoTheoNgayBatDauVaNgayKetThuc(dateChooserChamCong_ngayBatDau.getDate(), dateChooserChamCong_ngayKetThuc.getDate());
                int soLuongNhanVien = bangChamCongService.demSoLuongNhanVienTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                lbBangChamCong_soLuongNhanVien.setText(String.valueOf(soLuongNhanVien));
            }
            
            if (radioChamCong_theoNgay.isSelected() == true){
                LocalDate ngayBatDau = util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserChamCong_theongay_ngay.getDate()));
                danhSachBangChamCong = bangChamCongService.hienThiBangChamCongTheoTheoNgay(dateChooserChamCong_theongay_ngay.getDate());
                int soLuongNhanVien = bangChamCongService.demSoLuongNhanVienTrongNgayNhatDinh(ngayBatDau);
                lbBangChamCong_soLuongNhanVien.setText(String.valueOf(soLuongNhanVien));
            }
            
            if (radioChamCong_theoThang.isSelected() == true){
                danhSachBangChamCong = bangChamCongService.hienThiBangChamCongTheoTheoThang(String.valueOf(monthChooser_theoThang_thang.getMonth()+1), String.valueOf(yearChooserChamCong_theoThang_nam.getYear()));
                int thang = monthChooser_theoThang_thang.getMonth()+1;
                int nam = yearChooserChamCong_theoThang_nam.getYear();
                int soLuongNhanVien = bangChamCongService.demSoLuongNhanVienTrongThangNhatDinh(thang, nam);
                lbBangChamCong_soLuongNhanVien.setText(String.valueOf(soLuongNhanVien));
            }
            
            if (radioChamCong_theoNam.isSelected() == true){
                danhSachBangChamCong = bangChamCongService.hienThiBangChamCongTheoTheoNam(String.valueOf(yearChooserChamCong_theoNam_nam.getYear()));
                int nam = yearChooserChamCong_theoNam_nam.getYear();
                int soLuongNhanVien = bangChamCongService.demSoLuongNhanVienTrongNamNhatDinh(nam);
                lbBangChamCong_soLuongNhanVien.setText(String.valueOf(soLuongNhanVien));
            }
            
            DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachBangChamCong.getModel();
            recordTable.setRowCount(0);
            for (BangChamCong bangChamCong : danhSachBangChamCong) {
                Vector columnData = new Vector();
                columnData.add(bangChamCong.getMaBangChamCong());
                columnData.add((bangChamCong.getNgayLam()));
                columnData.add(bangChamCong.getMaNhanVien());
                columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(bangChamCong.getMaNhanVien()).getTenNhanVien());
                columnData.add(bangChamCong.getTrangThai());
                recordTable.addRow(columnData);
            }
            tongSoBangChamCong = danhSachBangChamCong.size();
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnChamCong_timKiemActionPerformed

    private void btnChamCong_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCong_taiLaiActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 1.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem bảng chấm công!");
                return;
            }
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
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 5.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem danh sách hàng hóa!");
                return;
            }
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
            List<HangHoa> danhSachHangHoaTonKho = new ArrayList<>();
            if (radioBtnHangHoa_conHangTrongKho.isSelected()){
                for (HangHoa hangHoa: danhSachHangHoa){
                    if (hangHoa.getTonKho() > 0){
                        danhSachHangHoaTonKho.add(hangHoa);
                    }
                }
            }
            if (radioBtnHangHoa_hetHangTrongKho.isSelected()){
                for (HangHoa hangHoa: danhSachHangHoa){
                    if (hangHoa.getTonKho() == 0){
                        danhSachHangHoaTonKho.add(hangHoa);
                    }
                }
            }
            if (!radioBtnHangHoa_hetHangTrongKho.isSelected() && !radioBtnHangHoa_conHangTrongKho.isSelected()){
                danhSachHangHoaTonKho = danhSachHangHoa;
            }
            hienThiDanhSachHangHoa(danhSachHangHoaTonKho);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnHangHoa_timKiemActionPerformed

    private void btnHangHoa_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHoa_taiLaiActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 5.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem danh sách hàng hóa!");
                return;
            }
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

    private void tfHangHoa_timTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHangHoa_timTheoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHangHoa_timTheoTenActionPerformed

    private void tb_danhSachHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachHangHoaMouseClicked
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 5.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem thông tin chi tiết hàng hóa!");
                return;
            }
        int index = tb_danhSachHangHoa.getSelectedRow();
        TableModel model = tb_danhSachHangHoa.getModel();
        HangHoa hangHoa = new HangHoa();
        try {
            hangHoa = hangHoaService.hienThiHangHoaTheoMaHangHoa(model.getValueAt(index, 0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }

        Frame_chiTietHangHoa frame_chiTietHangHoa = new Frame_chiTietHangHoa(hangHoa, this.nhanVienDangNhap);
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
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 7.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm khách hàng!");
                return;
            }
        Frame_ThemKhachHang frame_themKhachHang = new Frame_ThemKhachHang(this.nhanVienDangNhap);
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
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 17 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền đặt hàng!");
                return;
            }
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
        Frame_ThanhToan frame_thanhToan = new Frame_ThanhToan(danhSachHoaDonChiTiet, khachHang, maHoaDon, tongSoLuong, tongTienHang, this, this.nhanVienDangNhap);
        frame_thanhToan.setVisible(true);
        frame_thanhToan.setSize(360, 650);
        frame_thanhToan.setLocation(1170,0);
    }//GEN-LAST:event_btnDatHang_datHangActionPerformed

    private void btnKhachHoa_xuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHoa_xuatFileActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 7.5 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền export file khách hàng!");
                return;
            }
        try {
            WriteCSV writeCSV = new WriteCSV();
            List<KhachHang> danhSachKhachHang = khachHangService.hienThiTatCaKhachHang();
            writeCSV.writeCSVFileDanhSachKhachHang(danhSachKhachHang);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnKhachHoa_xuatFileActionPerformed

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
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 6.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem danh sách hóa đơn!");
                return;
            }
        hienThiDanhSachHoaDon();
    }//GEN-LAST:event_btnHoaDon_taiLaiActionPerformed

    private void btnHoaDon_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDon_timKiemActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 6.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem danh sách hóa đơn!");
                return;
            }
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
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 6.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem thông tin chi tiết hóa đơn!");
                return;
            }
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
        Frame_HoaDonChiTiet frame_hoaDonChiTiet = new Frame_HoaDonChiTiet(hoaDon, tenNhanVien, tenDoiTac, this.nhanVienDangNhap);
        frame_hoaDonChiTiet.setVisible(true);
        frame_hoaDonChiTiet.setSize(1075, 620);
        frame_hoaDonChiTiet.setLocation(0,0);
    }//GEN-LAST:event_tbHoaDon_danhSachHoaDonMouseClicked

    private void tbTraHang_danhSachPhieuTraHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTraHang_danhSachPhieuTraHangMouseClicked
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 14.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem thông tin chi tiết phiếu trả hàng!");
                return;
            }
        int index = tbTraHang_danhSachPhieuTraHang.getSelectedRow();
        TableModel model = tbTraHang_danhSachPhieuTraHang.getModel();
        PhieuTraHang phieuTraHang = new PhieuTraHang();
        try {
            phieuTraHang = phieuTraHangService.hienThiPhieuTraHangTheoMaPhieuTraHang(model.getValueAt(index, 0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Frame_ChiTietPhieuTraHang2 frame_chiTietPhieuTraHang = new Frame_ChiTietPhieuTraHang2(phieuTraHang, nhanVienDangNhap);
        frame_chiTietPhieuTraHang.setVisible(true);
        frame_chiTietPhieuTraHang.setSize(1070, 600);
        frame_chiTietPhieuTraHang.setLocation(0,0);
    }//GEN-LAST:event_tbTraHang_danhSachPhieuTraHangMouseClicked

    private void btnSuaChua_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChua_themActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 13.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm phiếu sữa chữa!");
                return;
            }
        if (btnSuaChua_them.getText().equals("Thêm")){
            btnSuaChua_them.setText("Lưu");
            lbSuaChua_tongTien.setText("0");
            tfSuaChua_tenKhachHang.setText("");
            lbSuaChua_soDienThoai.setText("0");
            tfSuaChua_tenPhuTungTimKiem.setText("");
            cbSuaChua_danhSachKhachHang.setSelectedIndex(0);
            actionPerformedPhuTungDaChonEnabled = false;
            cbSuaChua_phuTungDaChon.removeAllItems();
            actionPerformedPhuTungDaChonEnabled = true;
            cb_phuTungCanThay.setSelectedIndex(0);
            tare_noiDungSuaChua.setText("Nhập nội dung cần sửa");
//            cbSuaChua_phuTungDaChon.setEnabled(true);
            btnSuaChua_timKhachHang.setVisible(true);
            btnSuaChua_timPhuTung.setVisible(true);
            cb_phuTungCanThay.setEnabled(true);
            cbSuaChua_danhSachKhachHang.setEnabled(true);
            cb_nhanVienSuaChua.setEnabled(true);
            tare_noiDungSuaChua.setEnabled(true);
            tb_danhSachPhieuSuaChua.setRowSelectionAllowed(false);
            tb_danhSachPhieuSuaChua.setEnabled(false);
            btnSuaChua_reset.setVisible(true);
            
        } else {
            try {
                btnSuaChua_them.setText("Thêm");
                
                PhieuSuaChua phieuSuaChua = new PhieuSuaChua();
                int tongSoPhieuSuaChua = phieuSuaChuaService.demSoPhieuSuaChua() + 1;
                phieuSuaChua.setMaPhieuSuaChua("PSC0" + String.valueOf(tongSoPhieuSuaChua));
                phieuSuaChua.setNoiDungSuaChua(tare_noiDungSuaChua.getText());
                phieuSuaChua.setTongTien(Double.parseDouble(lbSuaChua_tongTien.getText()));
                phieuSuaChua.setTrangThai("Đang xử lý");
                phieuSuaChua.setMaKhachHang(cbSuaChua_danhSachKhachHang.getSelectedItem().toString().split(" ")[0]);
                phieuSuaChua.setMaLoaiXe(tfSuaChua_loaiXe.getText());
                phieuSuaChua.setMaNhanVien(cb_nhanVienSuaChua.getSelectedItem().toString().split(" ")[0]);
                phieuSuaChua.setThoiGian(LocalDateTime.now());
                
                phieuSuaChuaService.themPhieuSuaChua(phieuSuaChua);
                for (int i =0; i< cbSuaChua_phuTungDaChon.getItemCount(); i++){
                    String maPhuTung = cbSuaChua_phuTungDaChon.getItemAt(i).split(" ")[0];
                    phieuSuaChuaService.themPhieuSuaChuaPhuTung(phieuSuaChua.getMaPhieuSuaChua(), maPhuTung);
                    int soLuongTheKho = theKhoService.demSoTheKho();
                    try {
                        TheKho theKho = new TheKho();
                        soLuongTheKho = soLuongTheKho +1;
                        theKho.setMaTheKho("TK0" + soLuongTheKho + maPhuTung);
                        String[] parts = cbSuaChua_phuTungDaChon.getItemAt(i).split(" ");
                        theKho.setGiaVon(Double.parseDouble(parts[parts.length - 1]));
                        theKho.setPhuongThuc("Thay, Sữa chữa");
                        theKho.setSoLuong(Short.parseShort("1"));
                        theKho.setThoiGian(LocalDateTime.now());
                        theKho.setMaHangHoa(maPhuTung);
                        theKho.setMaNhanVien(nhanVienDangNhap.getMaNhanVien());
                        theKhoService.themTheKho(theKho);
                    } catch (SQLException ex) {
                        Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
//                cbSuaChua_phuTungDaChon.setEnabled(false);
                btnSuaChua_timKhachHang.setVisible(false);
                btnSuaChua_timPhuTung.setVisible(false);
                cb_phuTungCanThay.setEnabled(false);
                cbSuaChua_danhSachKhachHang.setEnabled(false);
                cb_nhanVienSuaChua.setEnabled(false);
                tare_noiDungSuaChua.setEnabled(false);
                tb_danhSachPhieuSuaChua.setEnabled(true);
                tb_danhSachPhieuSuaChua.setRowSelectionAllowed(true);
                btnSuaChua_reset.setVisible(false);
                hienThiDanhSachPhieuSuaChua();
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnSuaChua_themActionPerformed

    private void tfSuaChua_tenKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSuaChua_tenKhachHangMouseClicked
        // TODO add your handling c ode here:
    }//GEN-LAST:event_tfSuaChua_tenKhachHangMouseClicked

    private void btnSuaChua_themKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChua_themKhachHangActionPerformed
        Frame_ThemKhachHang frame_themKhachHang = new Frame_ThemKhachHang(nhanVienDangNhap);
        frame_themKhachHang.setVisible(true);
        frame_themKhachHang.setSize(950, 400);
        frame_themKhachHang.setLocation(0,0);
    }//GEN-LAST:event_btnSuaChua_themKhachHangActionPerformed

    private void btnSuaChua_timKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChua_timKhachHangActionPerformed
        if (cbSuaChua_danhSachKhachHang.getSelectedItem().equals("") && tfSuaChua_tenKhachHang.getText().equals("")){
            hienThiDanhSachKhachHangTaiCombobox(cbSuaChua_danhSachKhachHang);
            return;
        }
        String timKhachHang = tfSuaChua_tenKhachHang.getText();
        System.out.println(timKhachHang);
        cbSuaChua_danhSachKhachHang.removeAllItems();
        hienThiDanhSachKhachHangTaiCombobox(cbSuaChua_danhSachKhachHang);
        
        // lúc thực hiện 2 dòng lệnh trên thì event performed cũng được thực hiện cùng lúc
        
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("");
        for (int i = 0; i < cbSuaChua_danhSachKhachHang.getItemCount(); i++) {
        
            String item = cbSuaChua_danhSachKhachHang.getItemAt(i);
            if (item.toLowerCase().contains(timKhachHang.toLowerCase())) {
                model.addElement(item);
        
            }
        }
        cbSuaChua_danhSachKhachHang.setModel(model);
        if (cbSuaChua_danhSachKhachHang.getItemCount() == 0){
            tfSuaChua_tenKhachHang.setText("");
            tfSuaChua_tenKhachHang.setText("");
            return;
        }
    }//GEN-LAST:event_btnSuaChua_timKhachHangActionPerformed

    private void cbSuaChua_danhSachKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSuaChua_danhSachKhachHangActionPerformed
        try{
            if (cbSuaChua_danhSachKhachHang.getSelectedItem().equals("")){
                lbSuaChua_chiMucKhachHang.setText("Tìm khách hàng: ");
            }
            lbSuaChua_chiMucKhachHang.setText("Tên khách hàng: ");
            String[] parts = cbSuaChua_danhSachKhachHang.getSelectedItem().toString().split(" ");
            String tenKhachHang = "";
            tenKhachHang = parts[0] + " ";
//            tfDatHang_maKhachHang.setText(parts[0]);
            for (int j = 0 ; j < parts.length; j++){
                if (j == 0){
                    continue;
                } else if(j != parts.length - 1){
                    tenKhachHang += parts[j] + " ";
                }
                if(j == parts.length - 1){
                    lbSuaChua_soDienThoai.setText(parts[j]);
                }
            }
            tfSuaChua_tenKhachHang.setText(tenKhachHang);
            
        } catch (Exception err){
            tfSuaChua_tenKhachHang.setText("");
            lbSuaChua_soDienThoai.setText("");
        }
        

    }//GEN-LAST:event_cbSuaChua_danhSachKhachHangActionPerformed

    private void tfSuaChua_tenPhuTungTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSuaChua_tenPhuTungTimKiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSuaChua_tenPhuTungTimKiemMouseClicked

    private void btnSuaChua_timPhuTungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChua_timPhuTungActionPerformed
        if (cb_phuTungCanThay.getSelectedItem().equals("") && tfSuaChua_tenPhuTungTimKiem.getText().equals("")){
            hienThiDanhSachHangHoaTaiCombobox(cb_phuTungCanThay);
            return;
        }
        String timPhuTung = tfSuaChua_tenPhuTungTimKiem.getText();
        cb_phuTungCanThay.removeAllItems();
        cb_phuTungCanThay.addItem("");
        hienThiDanhSachHangHoaTaiCombobox(cb_phuTungCanThay);
        
        // lúc thực hiện 2 dòng lệnh trên thì event performed cũng được thực hiện cùng lúc
        
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("");
        for (int i = 0; i < cb_phuTungCanThay.getItemCount(); i++) {
        
            String item = cb_phuTungCanThay.getItemAt(i);
            if (item.toLowerCase().contains(timPhuTung.toLowerCase())) {
                model.addElement(item);
        
            }
        }
        cb_phuTungCanThay.setModel(model);
        if (cb_phuTungCanThay.getItemCount() == 0){
            tfSuaChua_tenPhuTungTimKiem.setText("");
            return;
        }
    }//GEN-LAST:event_btnSuaChua_timPhuTungActionPerformed

    private void cb_phuTungCanThayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_phuTungCanThayActionPerformed
        try{
            if (cb_phuTungCanThay.getSelectedItem().toString().equals("")){
                return;
            }
            
            for (int i=0; i < cbSuaChua_phuTungDaChon.getItemCount(); i++){
                if (cbSuaChua_phuTungDaChon.getItemAt(i).toString().equals(cb_phuTungCanThay.getSelectedItem().toString())){
                    return;
                }
            }
            actionPerformedPhuTungDaChonEnabled = false;
            cbSuaChua_phuTungDaChon.addItem(cb_phuTungCanThay.getSelectedItem().toString());
            actionPerformedPhuTungDaChonEnabled = true;
            double tongTienSuaChua = 0;
            for (int i=0; i< cbSuaChua_phuTungDaChon.getItemCount(); i++){
                String[] parts = cbSuaChua_phuTungDaChon.getItemAt(i).toString().split(" ");
                tongTienSuaChua += Double.parseDouble(parts[parts.length - 1]);
                lbSuaChua_tongTien.setText(String.valueOf(tongTienSuaChua));
            }
        } catch (Exception err){
            
        }
        
    }//GEN-LAST:event_cb_phuTungCanThayActionPerformed
    private boolean actionPerformedPhuTungDaChonEnabled = true;
    private void cbSuaChua_phuTungDaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSuaChua_phuTungDaChonActionPerformed
        if (actionPerformedPhuTungDaChonEnabled){
            double tongTienSuaChua = 0;
            for (int i=0; i< cbSuaChua_phuTungDaChon.getItemCount(); i++){
                String[] parts1 = cbSuaChua_phuTungDaChon.getItemAt(i).toString().split(" ");
                tongTienSuaChua += Double.parseDouble(parts1[parts1.length - 1]);
            }
            String[] parts = cbSuaChua_phuTungDaChon.getSelectedItem().toString().split(" ");
            
            tongTienSuaChua =  tongTienSuaChua - Double.parseDouble(parts[parts.length - 1]);
            lbSuaChua_tongTien.setText(String.valueOf(tongTienSuaChua));
            cbSuaChua_phuTungDaChon.removeItemAt(cbSuaChua_phuTungDaChon.getSelectedIndex());
        }
    }//GEN-LAST:event_cbSuaChua_phuTungDaChonActionPerformed

    private void btnSuaChua_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChua_resetActionPerformed
        lbSuaChua_tongTien.setText("0");
        tfSuaChua_tenKhachHang.setText("");
        lbSuaChua_soDienThoai.setText("0");
        tfSuaChua_tenPhuTungTimKiem.setText("");
        cbSuaChua_danhSachKhachHang.setSelectedIndex(0);
        actionPerformedPhuTungDaChonEnabled = false;
        cbSuaChua_phuTungDaChon.removeAllItems();
        actionPerformedPhuTungDaChonEnabled = true;
        cb_phuTungCanThay.setSelectedIndex(0);
        tare_noiDungSuaChua.setText("Nhập nội dung cần sửa");
    }//GEN-LAST:event_btnSuaChua_resetActionPerformed

    private void btnNhapHang_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHang_themActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 12.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm phiếu nhập hàng!");
                return;
            }
        Frame_taoDonNhapHang frame_taoDonNhapHang = new Frame_taoDonNhapHang(nhanVienDangNhap);
        frame_taoDonNhapHang.setVisible(true);
        frame_taoDonNhapHang.setSize(1550, 670);
        frame_taoDonNhapHang.setLocation(0,0);
    }//GEN-LAST:event_btnNhapHang_themActionPerformed

    private void tb_danhSachKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachKhachHangMouseClicked
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 7.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem thông tin chi tiết khách hàng!");
                return;
            }
        int index = tb_danhSachKhachHang.getSelectedRow();
        TableModel model = tb_danhSachKhachHang.getModel();
        KhachHang khachHang = new KhachHang();
        try {
            khachHang = khachHangService.hienThiKhachHangTheoMaKhachHang(model.getValueAt(index, 0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }

        Frame_XemChiTietCapNhatKhachHang frame_XemChiTietCapNhatKhachHang = new Frame_XemChiTietCapNhatKhachHang(khachHang, this.nhanVienDangNhap);
        frame_XemChiTietCapNhatKhachHang.setVisible(true);
        frame_XemChiTietCapNhatKhachHang.setSize(950, 370);
        frame_XemChiTietCapNhatKhachHang.setLocation(0,0);
    }//GEN-LAST:event_tb_danhSachKhachHangMouseClicked

    private void tfKhachHang_locTuDongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKhachHang_locTuDongKeyReleased
        String query = tfKhachHang_locTuDong.getText().toLowerCase();
        filterDanhSachKhachHang(query);
    }//GEN-LAST:event_tfKhachHang_locTuDongKeyReleased

    private void tfKhachHang_locTuDongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfKhachHang_locTuDongFocusGained
        if (tfKhachHang_locTuDong.getText().equals("Tìm tên khách hàng")){
            tfKhachHang_locTuDong.setText("");
            tfKhachHang_locTuDong.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfKhachHang_locTuDongFocusGained

    private void tfKhachHang_locTuDongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfKhachHang_locTuDongFocusLost
        if (tfKhachHang_locTuDong.getText().equals("")){
            tfKhachHang_locTuDong.setText("Tìm tên khách hàng");
            tfKhachHang_locTuDong.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfKhachHang_locTuDongFocusLost

    private void tfNhaCungCap_locTuDongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNhaCungCap_locTuDongFocusGained
        if (tfNhaCungCap_locTuDong.getText().equals("Tìm tên nhà cung cấp")){
            tfNhaCungCap_locTuDong.setText("");
            tfNhaCungCap_locTuDong.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfNhaCungCap_locTuDongFocusGained

    private void tfNhaCungCap_locTuDongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNhaCungCap_locTuDongFocusLost
        if (tfNhaCungCap_locTuDong.getText().equals("")){
            tfNhaCungCap_locTuDong.setText("Tìm tên nhà cung cấp");
            tfNhaCungCap_locTuDong.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfNhaCungCap_locTuDongFocusLost

    private void tfNhaCungCap_locTuDongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNhaCungCap_locTuDongKeyReleased
        String query = tfNhaCungCap_locTuDong.getText().toLowerCase();
        filterDanhSachNhaCungCap(query);
    }//GEN-LAST:event_tfNhaCungCap_locTuDongKeyReleased

    private void btnNhaCungCap_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhaCungCap_themActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 9.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm nhà cung cấp!");
                return;
            }
        Frame_ThemNhaCungCap frame_ThemNhaCungCap = new Frame_ThemNhaCungCap();
        frame_ThemNhaCungCap.setVisible(true);
        frame_ThemNhaCungCap.setSize(860, 300);
        frame_ThemNhaCungCap.setLocation(0,0);
    }//GEN-LAST:event_btnNhaCungCap_themActionPerformed

    private void tb_danhSachNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachNhaCungCapMouseClicked
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 9.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem thông tin chi tiết nhà cung cấp!");
                return;
            }
        int index = tb_danhSachNhaCungCap.getSelectedRow();
        TableModel model = tb_danhSachNhaCungCap.getModel();
        NhaCungCap nhaCungCap = new NhaCungCap();
        try {
            nhaCungCap = nhaCungCapService.hienThiNhaCungCapTheoMaNhaCungCap(model.getValueAt(index, 0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }

        Frame_XemChiTietCapNhatNhaCungCap frame_XemChiTietCapNhatNhaCungCap = new Frame_XemChiTietCapNhatNhaCungCap(nhaCungCap, nhanVienDangNhap);
        frame_XemChiTietCapNhatNhaCungCap.setVisible(true);
        frame_XemChiTietCapNhatNhaCungCap.setSize(860, 300);
        frame_XemChiTietCapNhatNhaCungCap.setLocation(0,0);
    }//GEN-LAST:event_tb_danhSachNhaCungCapMouseClicked

    private void btnNhanVienChiNhanh_themNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienChiNhanh_themNhanVienActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 10.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm nhân viên!");
                return;
            }
        ChiNhanh chiNhanh = new ChiNhanh();
        try {
            chiNhanh = chiNhanhService.hienThiChiNhanhTheoMaChiNhanh(nhanVienDangNhap.getMaChiNhanh());
            Frame_ThemNhanVien frame_ThemNhanVien = new Frame_ThemNhanVien(chiNhanh, nhanVienDangNhap);
            frame_ThemNhanVien.setVisible(true);
            frame_ThemNhanVien.setSize(965, 460);
            frame_ThemNhanVien.setLocation(0,0);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnNhanVienChiNhanh_themNhanVienActionPerformed

    private void tb_danhSachChiNhanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachChiNhanhMouseClicked
        int index = tb_danhSachChiNhanh.getSelectedRow();
        TableModel model = tb_danhSachChiNhanh.getModel();
        lbNhanVienChiNhanh_ma.setText(model.getValueAt(index, 0).toString());
        DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachNhanVien.getModel();
        recordTable.setRowCount(0);
        for (int i =0; i < danhSachNhanVienMain.size(); i++){
            if (i == 0){
                continue;
            }
            if (danhSachNhanVienMain.get(i).getMaChiNhanh().equals(lbNhanVienChiNhanh_ma.getText())){
                Vector columnData = new Vector();
                columnData.add(danhSachNhanVienMain.get(i).getMaNhanVien());
                columnData.add(danhSachNhanVienMain.get(i).getTenNhanVien());
                columnData.add(danhSachNhanVienMain.get(i).getSoDienThoai());
                columnData.add(danhSachNhanVienMain.get(i).getCccd());
                columnData.add(danhSachNhanVienMain.get(i).getChucDanh());
                recordTable.addRow(columnData);
            }
        }
    }//GEN-LAST:event_tb_danhSachChiNhanhMouseClicked

    private void tfNhanVienChiNhanh_locTuDongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNhanVienChiNhanh_locTuDongFocusGained
        if (tfNhanVienChiNhanh_locTuDong.getText().equals("Tìm tên nhân viên")){
            tfNhanVienChiNhanh_locTuDong.setText("");
            tfNhanVienChiNhanh_locTuDong.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfNhanVienChiNhanh_locTuDongFocusGained

    private void tfNhanVienChiNhanh_locTuDongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNhanVienChiNhanh_locTuDongFocusLost
        if (tfNhanVienChiNhanh_locTuDong.getText().equals("")){
            tfNhanVienChiNhanh_locTuDong.setText("Tìm tên nhân viên");
            tfNhanVienChiNhanh_locTuDong.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfNhanVienChiNhanh_locTuDongFocusLost

    private void tfNhanVienChiNhanh_locTuDongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNhanVienChiNhanh_locTuDongKeyReleased
        String query = tfNhanVienChiNhanh_locTuDong.getText().toLowerCase();
        filterDanhSachNhanVien(query);
    }//GEN-LAST:event_tfNhanVienChiNhanh_locTuDongKeyReleased

    private void btnNhanVienChiNhanh_xemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienChiNhanh_xemChiTietActionPerformed
        
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 1.1 ")){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền xem thông tin chi tiết chi nhánh!");
            return;
        }
        try {
            ChiNhanh chiNhanh = chiNhanhService.hienThiChiNhanhTheoMaChiNhanh(lbNhanVienChiNhanh_ma.getText());
            Frame_XemChiTietCapNhatChiNhanh frame_XemChiTietCapNhatchiNhanh = new Frame_XemChiTietCapNhatChiNhanh(chiNhanh, this.nhanVienDangNhap);
            frame_XemChiTietCapNhatchiNhanh.setVisible(true);
            frame_XemChiTietCapNhatchiNhanh.setSize(860, 290);
            frame_XemChiTietCapNhatchiNhanh.setLocation(0,0);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNhanVienChiNhanh_xemChiTietActionPerformed

    private void btnNhanVienChiNhanh_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienChiNhanh_taiLaiActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 4.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem trang chi nhánh!");
                return;
            }
        hienThiDanhSachNhanVien();
        hienThiDanhSachChiNhanh();
    }//GEN-LAST:event_btnNhanVienChiNhanh_taiLaiActionPerformed

    private void tb_danhSachNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachNhanVienMouseClicked
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 10.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem thông tin chi tiết nhân viên!");
                return;
            }
        int index = tb_danhSachNhanVien.getSelectedRow();
        TableModel model = tb_danhSachNhanVien.getModel();
        NhanVien nhanVien = new NhanVien();
        try {
            nhanVien = nhanVienService.hienThiNhanVienTheoMaNhanVien(model.getValueAt(index, 0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ChiNhanh chiNhanh;
        try {
            chiNhanh = chiNhanhService.hienThiChiNhanhTheoMaChiNhanh("CN001");
            Frame_ChiTietNhanVien frame_ChiTietNhanVien = new Frame_ChiTietNhanVien(nhanVien, chiNhanh, nhanVienDangNhap);
            frame_ChiTietNhanVien.setVisible(true);
            frame_ChiTietNhanVien.setSize(970, 450);
            frame_ChiTietNhanVien.setLocation(0,0);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tb_danhSachNhanVienMouseClicked

    private void btnNhanVienChiNhanh_themChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienChiNhanh_themChiNhanhActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 4.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm chi nhánh!");
                return;
            }
        Frame_ThemChiNhanh frame_ThemChiNhanh = new Frame_ThemChiNhanh(this.nhanVienDangNhap);
        frame_ThemChiNhanh.setVisible(true);
        frame_ThemChiNhanh.setSize(860, 290);
        frame_ThemChiNhanh.setLocation(0,0);
    }//GEN-LAST:event_btnNhanVienChiNhanh_themChiNhanhActionPerformed

    private void tfLichLamViec_locTuDongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfLichLamViec_locTuDongFocusGained
        if (tfLichLamViec_locTuDong.getText().equals("Tìm tên nhân viên")){
            tfLichLamViec_locTuDong.setText("");
            tfLichLamViec_locTuDong.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfLichLamViec_locTuDongFocusGained

    private void tfLichLamViec_locTuDongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfLichLamViec_locTuDongFocusLost
        if (tfLichLamViec_locTuDong.getText().equals("")){
            tfLichLamViec_locTuDong.setText("Tìm tên nhân viên");
            tfLichLamViec_locTuDong.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfLichLamViec_locTuDongFocusLost

    private void tfLichLamViec_locTuDongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLichLamViec_locTuDongKeyReleased
        String query = tfLichLamViec_locTuDong.getText().toLowerCase();
        filterDanhSachNhanVienLichLamViec(query);
    }//GEN-LAST:event_tfLichLamViec_locTuDongKeyReleased

    private void tbLichLamViec_danhSachNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLichLamViec_danhSachNhanVienMouseClicked
        btnLichLamViec_themPhuCap.setEnabled(true);
        btnLichLamViec_lapPhieuLuong.setEnabled(true);
        int index = tbLichLamViec_danhSachNhanVien.getSelectedRow();
        TableModel model = tbLichLamViec_danhSachNhanVien.getModel();
        String maNhanVien = model.getValueAt(index, 0).toString();
        
        hienThiDanhSachLichTangCa(maNhanVien);
        hienThiDanhSachLichViecLam(maNhanVien);
        
        hienThiThemLichLamViec(false, false, false);
    }//GEN-LAST:event_tbLichLamViec_danhSachNhanVienMouseClicked
    
    private void hienThiDanhSachLichViecLam(String maNhanVien){
        NhanVien nhanVien = new NhanVien();
        try {
            nhanVien = nhanVienService.hienThiNhanVienTheoMaNhanVien(maNhanVien);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbLichLamViec_maNhanVien.setText(nhanVien.getMaNhanVien());
        lbLichLamViec_cccd.setText(nhanVien.getCccd());
        lbLichLamViec_tenNhanVien.setText(nhanVien.getTenNhanVien());
        
        try {
            List<LichLamViec> danhSachLichLamViec = lichLamViecService.hienThiLichLamViecTheoMaNhanVien(nhanVien.getMaNhanVien());
            for (LichLamViec lichLamViec: danhSachLichLamViec){
                List<LichLamViecCaLam> danhSachLamViecCaLam = lichLamViecCaLamService.hienThiTatCaLichLamViecCaLamTheoMaLichLamViec(lichLamViec.getMaLichLamViec());
                for (LichLamViecCaLam lichLamViecCaLam: danhSachLamViecCaLam){
                    lichLamViec.getDanhSachCaLam().add(caLamService.hienThiCaLamTheoMaCaLam(lichLamViecCaLam.getMaCaLam()));
                }
            }
            DefaultTableModel recordTable = (DefaultTableModel)tbLichLamViec_lichLamViec.getModel();
            recordTable.setRowCount(0);
            for (LichLamViec lichLamViec : danhSachLichLamViec){
                Vector columnData = new Vector();
                columnData.add(String.valueOf(lichLamViec.getMaLichLamViec()));
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
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void hienThiDanhSachLichTangCa(String maNhanVien){
        try {
            List<LichLamViec> danhSachLichTangCa = lichLamViecService.hienThiLichTangCaTheoMaNhanVien(maNhanVien);
            DefaultTableModel recordTable = (DefaultTableModel)tbLichLamViec_lichTangCa.getModel();
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
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnLichLamViec_lapPhieuLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_lapPhieuLuongActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 11.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào trang quản lý phiếu lương!");
                return;
            }
        try {
            NhanVien nhanVien = nhanVienService.hienThiNhanVienTheoMaNhanVien(lbLichLamViec_maNhanVien.getText());
            Frame_LapPhieuLuong frame_LapPhieuLuong = new Frame_LapPhieuLuong(nhanVien, nhanVienDangNhap);
            frame_LapPhieuLuong.setVisible(true);
            frame_LapPhieuLuong.setSize(1135, 800);
            frame_LapPhieuLuong.setLocation(0,0);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLichLamViec_lapPhieuLuongActionPerformed

    private void tbLichLamViec_danhSachChiNhanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLichLamViec_danhSachChiNhanhMouseClicked
        int index = tbLichLamViec_danhSachChiNhanh.getSelectedRow();
        TableModel model = tbLichLamViec_danhSachChiNhanh.getModel();
        DefaultTableModel recordTable = (DefaultTableModel)tbLichLamViec_danhSachNhanVien.getModel();
        recordTable.setRowCount(0);
        for (int i =0; i < danhSachNhanVienMain.size(); i++){
            if (i == 0){
                continue;
            }
            if (danhSachNhanVienMain.get(i).getMaChiNhanh().equals(model.getValueAt(index, 0).toString())){
                Vector columnData = new Vector();
                columnData.add(danhSachNhanVienMain.get(i).getMaNhanVien());
                columnData.add(danhSachNhanVienMain.get(i).getTenNhanVien());
                columnData.add(danhSachNhanVienMain.get(i).getCccd());
                recordTable.addRow(columnData);
            }
        }
    }//GEN-LAST:event_tbLichLamViec_danhSachChiNhanhMouseClicked

    private void btnLichLamViec_themLichLamViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_themLichLamViecActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 8.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm lịch làm việc!");
                return;
            }
        hienThiThemLichLamViec(true, true, false);
        lamMoiInputLichLamViec();
        capNhatLichLamViec = false;
        try {
            int soLichLamViec = lichLamViecService.demSoLichLamViec();
            lbLichLamViec_Ma.setText("LLV0" + String.valueOf(soLichLamViec + 1));
            hienThiDanhSachBangLuongCombobox(cbLichLamViec_bangLuong, "BL");
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnLichLamViec_themLichLamViecActionPerformed

    private void btnLichLamViec_themLichTangCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_themLichTangCaActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 8.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm lịch tăng ca!");
                return;
            }
        hienThiThemLichLamViec(true, false, true);
        lamMoiInputLichLamViec();
        capNhatLichLamViec = false;
        hienThiDanhSachBangLuongCombobox(cbLichLamViec_bangLuong, "TCa");
        try {
            int soLichLamViec = lichLamViecService.demSoLichLamViec();
            lbLichLamViec_Ma.setText("LLV0" + String.valueOf(soLichLamViec + 1));
            
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLichLamViec_themLichTangCaActionPerformed

    private void btnLichLamViec_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_luuActionPerformed
        // them lich lam 
        if (lbLichLamViec_ngayBatDauLabel.getText().equals("Ngày") == true && dateChooserLichLamViec_ngayBatDau.getDate().before(new Date())){
            lbLichLamViec_thongBao.setText("Chọn ngày không hợp lệ!");
            lbLichLamViec_thongBao.setForeground(Color.red);
            return;
        }
        if (lbLichLamViec_ngayBatDauLabel.getText().equals("Ngày") == false && (dateChooserLichLamViec_ngayBatDau.getDate().after(dateChooserLichLamViec_ngayKetThuc.getDate()) || dateChooserLichLamViec_ngayBatDau.getDate().before(new Date()))){
            lbLichLamViec_thongBao.setText("Chọn ngày không hợp lệ!");
            lbLichLamViec_thongBao.setForeground(Color.red);
            return;
        } else {
            lbLichLamViec_thongBao.setText("");
        }
        if (!tfLichLamViec_soGioTangCa.isEnabled()){
            LichLamViec lichLamViec = new LichLamViec();
            lichLamViec.setMaLichLamViec(lbLichLamViec_Ma.getText());
            lichLamViec.setGhiChu(tareLichLamViec_ghiChu.getText());
            lichLamViec.setNghiLam(false);
            lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserLichLamViec_ngayBatDau.getDate())));
            lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserLichLamViec_ngayKetThuc.getDate())));
            lichLamViec.setTangCa(Short.parseShort("0"));
            lichLamViec.setTrangThai("Đang diễn ra");
            lichLamViec.setMaNhanVien(lbLichLamViec_maNhanVien.getText());
            try {
                if (capNhatLichLamViec == false){
                    lichLamViecService.themLichLamViec(lichLamViec);
                } else {
                    lichLamViecService.capNhatLichLamViec(lichLamViec);
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                int tongSoLichLamViecCaLam = lichLamViecCaLamService.demSoLichLamViecCaLam();
                
                if (capNhatLichLamViec == true){
                    lichLamViecCaLamService.xoaLichLamViecCaLam(lbLichLamViec_Ma.getText());
                }
                for (int i =0; i< cbLichLamViec_caLamDaChon.getItemCount(); i++){
                    LichLamViecCaLam lichLamViecCaLam = new LichLamViecCaLam();
                    lichLamViecCaLam.setMa("LLVCL0" + String.valueOf(lichLamViec.getMaLichLamViec() + tongSoLichLamViecCaLam + i + 1));
                    
                    lichLamViecCaLam.setHoanThanh(false);
                    lichLamViecCaLam.setMaCaLam(cbLichLamViec_caLamDaChon.getItemAt(i).toString().split(" ")[0]);
                    lichLamViecCaLam.setMaLichLamViec(lbLichLamViec_Ma.getText());
                    lichLamViecCaLamService.themLichLamViecCaLam(lichLamViecCaLam);
                }
                BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
                int soBangLuongNhanVien = bangLuongNhanVienService.demSoBangLuongNhanVien();
                bangLuongNhanVien.setMa("BLNV0" +lichLamViec.getMaLichLamViec()+ String.valueOf(soBangLuongNhanVien + 1));
                bangLuongNhanVien.setMaBangLuong(cbLichLamViec_bangLuong.getSelectedItem().toString().split(" ")[0]);
                bangLuongNhanVien.setMaLichLamViec(lbLichLamViec_Ma.getText());
                bangLuongNhanVien.setMa_nhan_vien(lbLichLamViec_maNhanVien.getText());
                System.out.println(capNhatLichLamViec);
                if (capNhatLichLamViec == false){
                    bangLuongNhanVienService.themBangLuongNhanVien(bangLuongNhanVien);
                } else {
                    bangLuongNhanVienService.xoaBangLuongNhanVien(lbLichLamViec_Ma.getText());
                    bangLuongNhanVienService.themBangLuongNhanVien(bangLuongNhanVien);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        } else if (tfLichLamViec_soGioTangCa.isEnabled()){   // them lich tang ca
            LichLamViec lichLamViec = new LichLamViec();
            lichLamViec.setMaLichLamViec(lbLichLamViec_Ma.getText());
            lichLamViec.setGhiChu(tareLichLamViec_ghiChu.getText());
            lichLamViec.setNghiLam(false);
            lichLamViec.setNgayBatDau(util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserLichLamViec_ngayBatDau.getDate())));
            lichLamViec.setNgayKetThuc(util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserLichLamViec_ngayBatDau.getDate())));
            lichLamViec.setTangCa(Short.parseShort(tfLichLamViec_soGioTangCa.getText()));
            lichLamViec.setTrangThai("Đang diễn ra");
            lichLamViec.setMaNhanVien(lbLichLamViec_maNhanVien.getText());
            try {
                if (capNhatLichLamViec == false){
                    lichLamViecService.themLichLamViec(lichLamViec);
                } else {
                    lichLamViecService.capNhatLichLamViec(lichLamViec);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hienThiDanhSachLichTangCa(lbLichLamViec_maNhanVien.getText());
        hienThiDanhSachLichViecLam(lbLichLamViec_maNhanVien.getText());
        hienThiThemLichLamViec(false, false, false);
        dateChooserLichLamViec_ngayBatDau.setDate(null);
        dateChooserLichLamViec_ngayKetThuc.setDate(null);
        if (capNhatLichLamViec == false){
            lbLichLamViec_thongBao.setText("Thêm dữ liệu thành công!");
        } else {
            lbLichLamViec_thongBao.setText("Cập nhật dữ liệu thành công!");
        }
        
        lbLichLamViec_thongBao.setForeground(Color.green);
        capNhatLichLamViec = false;
    }//GEN-LAST:event_btnLichLamViec_luuActionPerformed
    boolean actionPerformedCaLamDaChonEnabled = true;
    private void cbLichLamViec_caLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLichLamViec_caLamActionPerformed
        try{
            if (cbLichLamViec_caLam.getSelectedItem().toString().equals("")){
                return;
            }
            
            for (int i=0; i < cbLichLamViec_caLamDaChon.getItemCount(); i++){
                if (cbLichLamViec_caLamDaChon.getItemAt(i).toString().equals(cbLichLamViec_caLam.getSelectedItem().toString())){
                    return;
                }
            }
            actionPerformedCaLamDaChonEnabled = false;
            cbLichLamViec_caLamDaChon.addItem(cbLichLamViec_caLam.getSelectedItem().toString());
            actionPerformedCaLamDaChonEnabled = true;
        } catch (Exception err){
            
        }
    }//GEN-LAST:event_cbLichLamViec_caLamActionPerformed

    private void cbLichLamViec_caLamDaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLichLamViec_caLamDaChonActionPerformed
        if (actionPerformedCaLamDaChonEnabled){
            if (cbLichLamViec_caLamDaChon.getItemCount() > 0){
                cbLichLamViec_caLamDaChon.removeItemAt(cbLichLamViec_caLamDaChon.getSelectedIndex());
            }
            
        }
    }//GEN-LAST:event_cbLichLamViec_caLamDaChonActionPerformed

    private void btnLichLamViec_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_lamMoiActionPerformed
        lamMoiInputLichLamViec();
    }//GEN-LAST:event_btnLichLamViec_lamMoiActionPerformed

    private void lamMoiInputLichLamViec(){
        dateChooserLichLamViec_ngayBatDau.setDate(null);
        dateChooserLichLamViec_ngayKetThuc.setDate(null);
        cbLichLamViec_bangLuong.setSelectedIndex(-1);
        actionPerformedCaLamDaChonEnabled = false;
        cbLichLamViec_caLam.setSelectedIndex(-1);
        actionPerformedCaLamDaChonEnabled = true;
        cbLichLamViec_trangThai.setSelectedIndex(-1);
        actionPerformedCaLamDaChonEnabled = false;
        cbLichLamViec_caLamDaChon.setSelectedIndex(-1);
        actionPerformedCaLamDaChonEnabled = true;
        tfLichLamViec_soGioTangCa.setText("");
        tareLichLamViec_ghiChu.setText("");
    }
    
    private void btnLichLamViec_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_huyBoActionPerformed
        hienThiThemLichLamViec(false, false, false);
        dateChooserLichLamViec_ngayBatDau.setDate(null);
        dateChooserLichLamViec_ngayKetThuc.setDate(null);
    }//GEN-LAST:event_btnLichLamViec_huyBoActionPerformed

    private void tbLichLamViec_lichLamViecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLichLamViec_lichLamViecMouseClicked
        try {
            int index = tbLichLamViec_lichLamViec.getSelectedRow();
            TableModel model = tbLichLamViec_lichLamViec.getModel();
            String maLichViecLam = model.getValueAt(index, 0).toString();
            LichLamViec lichLamViec = lichLamViecService.hienThiLichLamViecTheoMaLichLamViec(maLichViecLam);
            cbLichLamViec_caLamDaChon.removeAllItems();
            List<LichLamViecCaLam> danhSachLichLamViecCaLam = lichLamViecCaLamService.hienThiTatCaLichLamViecCaLamTheoMaLichLamViec(maLichViecLam);
            for (LichLamViecCaLam lichLamViecCaLam: danhSachLichLamViecCaLam){
                CaLam caLam = caLamService.hienThiCaLamTheoMaCaLam(lichLamViecCaLam.getMaCaLam());
                lichLamViec.getDanhSachCaLam().add(caLam);
                actionPerformedCaLamDaChonEnabled = false;
                cbLichLamViec_caLamDaChon.addItem(caLam.getMaCaLam() + " " + caLam.getTenCaLam());
                actionPerformedCaLamDaChonEnabled = true;
            }
            BangLuongNhanVien bangLuongNhanVien = bangLuongNhanVienService.hienThiBangLuongNhanVienTheoLichLamViec(maLichViecLam);
            System.out.println(bangLuongNhanVien.getMaBangLuong());
            BangLuong bangLuong = bangLuongService.hienThiBangLuongTheoMaBangLuong(bangLuongNhanVien.getMaBangLuong());
            hienThiDanhSachBangLuongCombobox(cbLichLamViec_bangLuong, "BL");
            cbLichLamViec_bangLuong.setSelectedItem(bangLuong.getMaBangLuong() + " " + bangLuong.getNoiDung());
            
            lbLichLamViec_Ma.setText(lichLamViec.getMaLichLamViec());
            dateChooserLichLamViec_ngayBatDau.setDate(util.layNgayDate(lichLamViec.getNgayBatDau().toString()));
            dateChooserLichLamViec_ngayKetThuc.setDate(util.layNgayDate(lichLamViec.getNgayKetThuc().toString()));
            cbLichLamViec_trangThai.setSelectedItem(lichLamViec.getTrangThai());
            tareLichLamViec_ghiChu.setText(lichLamViec.getGhiChu());
            
            hienThiThemLichLamViec(false, true, false);
            
            if (dateChooserLichLamViec_ngayBatDau.getDate().before(new Date())){
                btnLichLamViec_capNhatLichLamViec.setEnabled(false);
            } else {
                btnLichLamViec_capNhatLichLamViec.setEnabled(true);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tbLichLamViec_lichLamViecMouseClicked
    private boolean capNhatLichLamViec = false;
    private void btnLichLamViec_capNhatLichLamViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_capNhatLichLamViecActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 8.3 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền cập nhật lịch làm việc!");
                return;
            }
        hienThiThemLichLamViec(true, true, false);
        capNhatLichLamViec = true;
    }//GEN-LAST:event_btnLichLamViec_capNhatLichLamViecActionPerformed

    private void btnLichLamViec_capNhatLichTangCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_capNhatLichTangCaActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 8.3 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền cập nhật lịch tăng ca!");
                return;
            }
        hienThiThemLichLamViec(true, false, true);
        capNhatLichLamViec = true;
    }//GEN-LAST:event_btnLichLamViec_capNhatLichTangCaActionPerformed

    private void tbLichLamViec_lichTangCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLichLamViec_lichTangCaMouseClicked
        try {
            
            int index = tbLichLamViec_lichTangCa.getSelectedRow();
            TableModel model = tbLichLamViec_lichTangCa.getModel();
            String maLichViecLam = model.getValueAt(index, 0).toString();
            System.out.println(maLichViecLam);
            LichLamViec lichLamViec = lichLamViecService.hienThiLichLamViecTheoMaLichLamViec(maLichViecLam);
            
            BangLuongNhanVien bangLuongNhanVien = bangLuongNhanVienService.hienThiBangLuongNhanVienTheoLichLamViec(maLichViecLam);
            BangLuong bangLuong = bangLuongService.hienThiBangLuongTheoMaBangLuong(bangLuongNhanVien.getMaBangLuong());
            hienThiDanhSachBangLuongCombobox(cbLichLamViec_bangLuong, "TCa");
            cbLichLamViec_bangLuong.setSelectedItem(bangLuong.getMaBangLuong() + " " + bangLuong.getNoiDung());
            
            lbLichLamViec_Ma.setText(lichLamViec.getMaLichLamViec());
            dateChooserLichLamViec_ngayBatDau.setDate(util.layNgayDate(lichLamViec.getNgayBatDau().toString()));
            cbLichLamViec_trangThai.setSelectedItem(lichLamViec.getTrangThai());
            tareLichLamViec_ghiChu.setText(lichLamViec.getGhiChu());
            tfLichLamViec_soGioTangCa.setText(String.valueOf(lichLamViec.getTangCa()));
            hienThiThemLichLamViec(false, false, true);
            if (dateChooserLichLamViec_ngayBatDau.getDate().before(new Date())){
                btnLichLamViec_capNhatLichTangCa.setEnabled(false);
            } else {
                btnLichLamViec_capNhatLichTangCa.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbLichLamViec_lichTangCaMouseClicked

    private void btnLichLamViec_themBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_themBangLuongActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 2.")){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào bảng lương!");
            return;
        }
        Frame_BangLuong frame_BangLuong = new Frame_BangLuong(this.nhanVienDangNhap);
        frame_BangLuong.setVisible(true);
        frame_BangLuong.setSize(875, 435);
        frame_BangLuong.setLocation(0,0);
    }//GEN-LAST:event_btnLichLamViec_themBangLuongActionPerformed

    private void btnLichLamViec_capNhatCaLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_capNhatCaLamActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 3.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào bảng ca làm!");
                return;
            }
        Frame_CaLam frame_CaLam = new Frame_CaLam(this.nhanVienDangNhap);
        frame_CaLam.setVisible(true);
        frame_CaLam.setSize(875, 435);
        frame_CaLam.setLocation(0,0);
    }//GEN-LAST:event_btnLichLamViec_capNhatCaLamActionPerformed

    private void btnLichLamViec_lichNghiViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_lichNghiViecActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 8.2 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền thêm lịch nghỉ!");
                return;
            }
        Frame_LichNghi frame_LichNghi = new Frame_LichNghi();
        frame_LichNghi.setVisible(true);
        frame_LichNghi.setSize(875, 435);
        frame_LichNghi.setLocation(0,0);
    }//GEN-LAST:event_btnLichLamViec_lichNghiViecActionPerformed

    private void btnLichLamViec_themPhuCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViec_themPhuCapActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 15.")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập trang quản lý phụ cấp!");
                return;
            }
        try {
            NhanVien nhanVien = nhanVienService.hienThiNhanVienTheoMaNhanVien(lbLichLamViec_maNhanVien.getText());
            Frame_TroCap frame_TroCap = new Frame_TroCap(nhanVien, nhanVienDangNhap);
            frame_TroCap.setVisible(true);
            frame_TroCap.setSize(875, 435);
            frame_TroCap.setLocation(0,0);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLichLamViec_themPhuCapActionPerformed

    private void cbPhanQuyen_nhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPhanQuyen_nhanVienActionPerformed
        try {
            if (performComboboxNhanVien == false){
                return;
            }
            String maNhanVien = cbPhanQuyen_nhanVien.getSelectedItem().toString().split(" ")[0];
            NhanVien nhanVien = nhanVienService.hienThiNhanVienTheoMaNhanVien(maNhanVien);
            tfPhanQuyen_matKhau.setText(nhanVien.getMatKhau());
            tfPhanQuyen_tenTenKhoan.setText(nhanVien.getTenTaiKhoan());
            String tokenPhanQuyen = nhanVien.getPhanQuyen();
            if (tokenPhanQuyen == null){
                tokenPhanQuyen = "";
            }
            System.out.println(tokenPhanQuyen + ".");
            hienThiQuyenTaiKhoan(tokenPhanQuyen);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }//GEN-LAST:event_cbPhanQuyen_nhanVienActionPerformed

    private void btnPhanQuyen_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanQuyen_capNhatActionPerformed
        try {
            if (!(tfPhanQuyen_matKhau.getText().length() > 8) || !Pattern.compile("[A-Z]").matcher(tfPhanQuyen_matKhau.getText()).find() ||
                    !Pattern.compile("[a-z]").matcher(tfPhanQuyen_matKhau.getText()).find() || !Pattern.compile("[0-9]").matcher(tfPhanQuyen_matKhau.getText()).find()
                    || !Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(tfPhanQuyen_matKhau.getText()).find()){
                JOptionPane.showMessageDialog(this, "Mật khẩu phải chứa đủ chữ hoa, chữ thường, số, ký tự đặc biệt, độ dài tối thiểu là 8!");
                return;
            }
            String tokenPhanQuyen = getTokenPhanQuyen();
            nhanVienService.capNhatNhanVienXacThucPhanQuyen(cbPhanQuyen_nhanVien.getSelectedItem().toString().split(" ")[0], tfPhanQuyen_tenTenKhoan.getText(), tfPhanQuyen_matKhau.getText(), tokenPhanQuyen);
            nhanVienDangNhap = nhanVienService.hienThiNhanVienTheoMaNhanVien(nhanVienDangNhap.getMaNhanVien());
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPhanQuyen_capNhatActionPerformed

    private void btnNhanVienChiNhanh_importChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienChiNhanh_importChiNhanhActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 4.4 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền import file chinh nhánh!");
                return;
            }
        ImportFileCSV importCSV = new ImportFileCSV();
        //            List<KhachHang> danhSachKhachHang = khachHangService.hienThiTatCaKhachHang();
        List<ChiNhanh> danhSachChiNhanh = importCSV.readCsvFileDanhSachChiNhanh();
        int soLuongChiNhanh = 0;
        try {
            soLuongChiNhanh = chiNhanhService.demSoChiNhanh();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (ChiNhanh chiNhanh : danhSachChiNhanh){
            soLuongChiNhanh += 1;
            chiNhanh.setMaChiNhanh("CN0" + soLuongChiNhanh);
            try {
                chiNhanhService.themChiNhanh(chiNhanh);
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnNhanVienChiNhanh_importChiNhanhActionPerformed

    private void btnNhanVienChiNhanh_exportChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienChiNhanh_exportChiNhanhActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 4.5 ")){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền export file chinh nhánh!");
            return;
        }
        try {
            WriteCSV writeCSV = new WriteCSV();
            List<ChiNhanh> danhSachChiNhanh = chiNhanhService.hienThiTatCaChiNhanh();
            writeCSV.writeCSVFileDanhSachChiNhanh(danhSachChiNhanh);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNhanVienChiNhanh_exportChiNhanhActionPerformed

    private void btnHangHoa_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHoa_importActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 5.4 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền import file hàng hóa!");
                return;
            }
        ImportFileCSV importCSV = new ImportFileCSV();
//            List<KhachHang> danhSachKhachHang = khachHangService.hienThiTatCaKhachHang();
        List<HangHoa> danhSachHangHoa = importCSV.readCsvFileDanhSachHangHoa();
        int soLuongHangHoa = 0;
        try {
            soLuongHangHoa = hangHoaService.demSoHangHoa();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (HangHoa hangHoa : danhSachHangHoa){
            soLuongHangHoa += 1;
            hangHoa.setMaHangHoa("HH0" + soLuongHangHoa);
            try {
                hangHoaService.themHangHoa(hangHoa);
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnHangHoa_importActionPerformed

    private void btnHangHoa_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHoa_exportActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 5.5 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền export file hàng hóa!");
                return;
            }
        
        try {
            WriteCSV writeCSV = new WriteCSV();
            List<HangHoa> danhSachHangHoa = hangHoaService.hienThiTatCaHangHoa("", "");
            writeCSV.writeCSVFileDanhSachHangHoa(danhSachHangHoa);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnHangHoa_exportActionPerformed

    private void btnNhacungCap_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhacungCap_importActionPerformed
        try {
            if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 9.4 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền import file nhà cung cấp!");
                return;
            }
            ImportFileCSV importCSV = new ImportFileCSV();
            //            List<KhachHang> danhSachKhachHang = khachHangService.hienThiTatCaKhachHang();
            List<NhaCungCap> danhSachNhaCungCap = importCSV.readCsvFileDanhSachNhaCungCap();
            int soLuongNhaCungCap = 0;
            try {
                soLuongNhaCungCap = nhaCungCapService.demSoNhaCungCap();
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
            ChiNhanh chiNhanh = chiNhanhService.hienThiChiNhanhTheoMaChiNhanh(nhanVienDangNhap.getMaChiNhanh());

            for (NhaCungCap nhaCungCap : danhSachNhaCungCap){
                soLuongNhaCungCap += 1;
                nhaCungCap.setMaNhaCungCap("NCC0" + soLuongNhaCungCap);
                nhaCungCap.setNgayTao(LocalDateTime.now());
                nhaCungCap.setMaNhanVien(nhanVienDangNhap.getMaNhanVien());
                nhaCungCap.setMaChiNhanh(chiNhanh.getMaChiNhanh());
                try {
                    nhaCungCapService.themNhaCungCap(nhaCungCap);
                } catch (SQLException ex) {
                    Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNhacungCap_importActionPerformed

    private void btnNhaCungCap_xuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhaCungCap_xuatFileActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 9.5 ")){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền xuất file danh sách nhà cung cấp!");
            return;
        }
        try {
            WriteCSV writeCSV = new WriteCSV();
            List<NhaCungCap> danhSachNhaCungCap = nhaCungCapService.hienThiTatCaNhaCungCap();
            writeCSV.writeCSVFileDanhSachNhaCungCap(danhSachNhaCungCap);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNhaCungCap_xuatFileActionPerformed

    private void btnNhanVienChiNhanh_exportNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienChiNhanh_exportNhanVienActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 10.5 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xuất file danh sách nhân viên!");
                return;
            }
        try {
            WriteCSV writeCSV = new WriteCSV();
            List<NhanVien> danhSachNhanVien = nhanVienService.hienThiTatCaNhanVien();
            writeCSV.writeCSVFileDanhSachNhanVien(danhSachNhanVien);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNhanVienChiNhanh_exportNhanVienActionPerformed

    private void btnPhieuNhapHang_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuNhapHang_exportActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 12.5 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền export file phiếu nhập hàng!");
                return;
            }
        try {
            WriteCSV writeCSV = new WriteCSV();
            List<PhieuNhapHang> danhSachPhieuNhapHang = phieuNhapHangService.hienThiTatCaPhieuNhapHang();
            writeCSV.writeCSVFileDanhSachPhieuNhapHang(danhSachPhieuNhapHang);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPhieuNhapHang_exportActionPerformed

    private void btnPhieuTraHang_exportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuTraHang_exportFileActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 14.5 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền export file danh sách phiếu trả hàng!");
                return;
            }
    }//GEN-LAST:event_btnPhieuTraHang_exportFileActionPerformed

    private void btnDoanhThu_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanhThu_timKiemActionPerformed
        if (radioDoanhThu_khoangThoiGian.isSelected()){
            try {
                LocalDate ngayBatDau = util.localDateParseMethodToLocalDate(util.layNgayString(dateChooser_ngayBatDau.getDate()));
                LocalDate ngayKetThuc = util.localDateParseMethodToLocalDate(util.layNgayString(dateChooser_ngayKetThuc.getDate()));
                if (dateChooser_ngayBatDau.getDate().after(dateChooser_ngayKetThuc.getDate())){
                    System.out.println("sai dinh dang");
                }
                    
                ThongKeTongTienSoLuong doanhThuHoaDon = doanhThuService.tinhDoanhThuHoaDonTrongKhoangThoiGian(ngayBatDau, ngayKetThuc );
                ThongKeTongTienSoLuong doanhThuSuaChua = doanhThuService.tinhDoanhThuPhieuSuaChuaTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                ThongKeTongTienSoLuong doanhThuTraHang = doanhThuService.tinhDoanhThuPhieuTraHangTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                
                ThongKeTongTienSoLuong chiTieuTraHang = doanhThuService.tinhChiTieuPhieuTraHangTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                ThongKeTongTienSoLuong chiTieuNhapHang = doanhThuService.tinhChiTieuPhieuNhapHangTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                ThongKeTongTienSoLuong chiTieuTienLuongNhanVien = doanhThuService.tinhTienLuongNhanVienTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                
                lbDoanhThu_soLuongHoaDon.setText(String.valueOf(doanhThuHoaDon.getSoLuong()) + " hóa đơn");
                lbDoanhThu_soLuongPhieuLuong.setText(String.valueOf(chiTieuTienLuongNhanVien.getSoLuong()) + " phiếu lương");
                lbDoanhThu_soLuongPhieuNhapHang.setText(String.valueOf(chiTieuNhapHang.getSoLuong()) + " phiếu nhập hàng");
                lbDoanhThu_soLuongPhieuTraHangKhachHang.setText(String.valueOf(chiTieuTraHang.getSoLuong()) + " phiếu trả hàng");
                lbDoanhThu_soLuongPhieuTraHangNhaCungCap.setText(String.valueOf(doanhThuTraHang.getSoLuong()) + " phiếu trả hàng");
                lbDoanhThu_soLuongSuaChua.setText(String.valueOf(doanhThuSuaChua.getSoLuong()) + " phiếu sữa chữa");
                lbDoanhThu_soLuongHoaDon.setText(String.valueOf(doanhThuSuaChua.getSoLuong()) + " hóa đơn");
                lbDoanhThu_tienHoaDon.setText(String.valueOf(doanhThuHoaDon.getTongTien()));
                lbDoanhThu_loiNhuan.setText(String.valueOf(chiTieuTienLuongNhanVien.getTongTien()));
                lbDoanhThu_tienNhapHang.setText(String.valueOf(chiTieuNhapHang.getTongTien()));
                lbDoanhThu_tienSuaChua.setText(String.valueOf(doanhThuSuaChua.getTongTien()));
                lbDoanhThu_tienTraHangKhachHang.setText(String.valueOf(doanhThuTraHang.getTongTien()));
                lbDoanhThu_tienTraHangNhaCungCap.setText(String.valueOf(chiTieuTraHang.getTongTien()));
                        
                
                double loiNhuan1 = doanhThuHoaDon.getTongTien() + doanhThuSuaChua.getTongTien() + doanhThuTraHang.getTongTien() - chiTieuTraHang.getTongTien() - chiTieuNhapHang.getTongTien() - chiTieuTienLuongNhanVien.getTongTien();
                double doanhThu1 = doanhThuHoaDon.getTongTien() + doanhThuSuaChua.getTongTien() + doanhThuTraHang.getTongTien();
                double chiTieu1 = chiTieuTraHang.getTongTien() + chiTieuNhapHang.getTongTien() + chiTieuTienLuongNhanVien.getTongTien();
                
                long loiNhuan = (long) loiNhuan1;
                long doanhThu = (long) doanhThu1;
                long chiTieu = (long) chiTieu1;
                
                jPanel133.removeAll();
                src.UI.Chart.chat.Chart chart2 = new src.UI.Chart.chat.Chart();
                jPanel133.setBackground(new java.awt.Color(242, 249, 255));
                javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
                jPanel133.setLayout(jPanel133Layout);
                        jPanel133Layout.setHorizontalGroup(
                            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel133Layout.createSequentialGroup()
                                .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
                                .addContainerGap())
                        );
                        jPanel133Layout.setVerticalGroup(
                            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel133Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                jPanel133.revalidate();
                jPanel133.repaint();

                chart2.addLegend("DoanhThu", new Color(245, 189, 135));
                chart2.addLegend("Chi phí", new Color(135, 189, 245));
                chart2.addLegend("Lợi nhuận", new Color(189, 135, 245));

                chart2.addData(new ModelChart("Tổng quan", new double[]{doanhThu, chiTieu, loiNhuan}));
                
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaHoaDon = doanhThuService.hangHoaDuocMuaTrongHoaDonTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaSuaChua = doanhThuService.hangHoaTieuThuTrongSuaChuaTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaNhapHang = doanhThuService.hangHoaBiNhapTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                veBieuDoTron(jPanel134, danhSachHangHoaHoaDon);
                veBieuDoTron(jPanel20, danhSachHangHoaSuaChua);
                veBieuDoTron(jPanel136, danhSachHangHoaNhapHang);
                
                int tongSoNhanVien = doanhThuService.tongSoNhanVienTrongKhoangThoiGian(ngayBatDau, ngayKetThuc);
                double tongLuongCung = doanhThuService.tongTienLuongTrongKhoangThoiGian("BL", ngayBatDau, ngayKetThuc);
                double tongTangCa = doanhThuService.tongTienLuongTrongKhoangThoiGian("TC", ngayBatDau, ngayKetThuc);
                double tongLuongThuong = doanhThuService.tongTienLuongTrongKhoangThoiGian("LT", ngayBatDau, ngayKetThuc);
                double tongTroCap = doanhThuService.tongTienLuongTrongKhoangThoiGian("TCa", ngayBatDau, ngayKetThuc);
                
                lbDoanhThu_tienLuong_tongSoNhanVien.setText(String.valueOf(tongSoNhanVien));
                veBieuTroDoanhThu(jPanel143, tongLuongCung, tongTangCa, tongLuongThuong, tongTroCap);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (radioDoanhThu_ngay.isSelected()){
            try {
                LocalDate ngayDuocChon = util.localDateParseMethodToLocalDate(util.layNgayString(dateChooser_theoNgay_ngay.getDate()));
                    
                ThongKeTongTienSoLuong doanhThuHoaDon = doanhThuService.tinhDoanhThuHoaDonTrongNgayNhatDinh(ngayDuocChon);
                ThongKeTongTienSoLuong doanhThuSuaChua = doanhThuService.tinhDoanhThuPhieuSuaChuaTrongNgayNhatDinh(ngayDuocChon);
                ThongKeTongTienSoLuong doanhThuTraHang = doanhThuService.tinhDoanhThuPhieuTraHangTrongNgayNhatDinh(ngayDuocChon);
                
                ThongKeTongTienSoLuong chiTieuTraHang = doanhThuService.tinhChiTieuPhieuTraHangTrongNgayNhatDinh(ngayDuocChon);
                ThongKeTongTienSoLuong chiTieuNhapHang = doanhThuService.tinhChiTieuPhieuNhapHangTrongNgayNhatDinh(ngayDuocChon);
                ThongKeTongTienSoLuong chiTieuTienLuongNhanVien = doanhThuService.tinhTienLuongNhanVienTrongNgayNhatDinh(ngayDuocChon);
                
                
                lbDoanhThu_soLuongPhieuLuong.setText(String.valueOf(chiTieuTienLuongNhanVien.getSoLuong()) + " phiếu lương");
                lbDoanhThu_soLuongPhieuNhapHang.setText(String.valueOf(chiTieuNhapHang.getSoLuong()) + " phiếu nhập hàng");
                lbDoanhThu_soLuongPhieuTraHangKhachHang.setText(String.valueOf(chiTieuTraHang.getSoLuong()) + " phiếu trả hàng");
                lbDoanhThu_soLuongPhieuTraHangNhaCungCap.setText(String.valueOf(doanhThuTraHang.getSoLuong()) + " phiếu trả hàng");
                lbDoanhThu_soLuongSuaChua.setText(String.valueOf(doanhThuSuaChua.getSoLuong()) + " phiếu sữa chữa");
                lbDoanhThu_soLuongHoaDon.setText(String.valueOf(doanhThuSuaChua.getSoLuong()) + " hóa đơn");
                lbDoanhThu_tienHoaDon.setText(String.valueOf(doanhThuHoaDon.getTongTien()));
                lbDoanhThu_loiNhuan.setText(String.valueOf(chiTieuTienLuongNhanVien.getTongTien()));
                lbDoanhThu_tienNhapHang.setText(String.valueOf(chiTieuNhapHang.getTongTien()));
                lbDoanhThu_tienSuaChua.setText(String.valueOf(doanhThuSuaChua.getTongTien()));
                lbDoanhThu_tienTraHangKhachHang.setText(String.valueOf(doanhThuTraHang.getTongTien()));
                lbDoanhThu_tienTraHangNhaCungCap.setText(String.valueOf(chiTieuTraHang.getTongTien()));
                        
                
                double loiNhuan1 = 0;
                double doanhThu1 = 0;
                double chiTieu1 = 0;
                
                loiNhuan1 = doanhThuHoaDon.getTongTien() + doanhThuSuaChua.getTongTien() + doanhThuTraHang.getTongTien() - chiTieuTraHang.getTongTien() - chiTieuNhapHang.getTongTien() - chiTieuTienLuongNhanVien.getTongTien();
                doanhThu1 = doanhThuHoaDon.getTongTien() + doanhThuSuaChua.getTongTien() + doanhThuTraHang.getTongTien();
                chiTieu1 = chiTieuTraHang.getTongTien() + chiTieuNhapHang.getTongTien() + chiTieuTienLuongNhanVien.getTongTien();
                
                long loiNhuan = (long) loiNhuan1;
                long doanhThu = (long) doanhThu1;
                long chiTieu = (long) chiTieu1;
                
                jPanel133.removeAll();
                src.UI.Chart.chat.Chart chart2 = new src.UI.Chart.chat.Chart();
                jPanel133.setBackground(new java.awt.Color(242, 249, 255));
                javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
                jPanel133.setLayout(jPanel133Layout);
                        jPanel133Layout.setHorizontalGroup(
                            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel133Layout.createSequentialGroup()
                                .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
                                .addContainerGap())
                        );
                        jPanel133Layout.setVerticalGroup(
                            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel133Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                jPanel133.revalidate();
                jPanel133.repaint();

                chart2.addLegend("DoanhThu", new Color(245, 189, 135));
                chart2.addLegend("Chi phí", new Color(135, 189, 245));
                chart2.addLegend("Lợi nhuận", new Color(189, 135, 245));

                chart2.addData(new ModelChart("Tổng quan", new double[]{doanhThu, chiTieu, loiNhuan}));
                
                
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaHoaDon = doanhThuService.hangHoaDuocMuaTrongHoaDonTrongNgayNhatDinh(ngayDuocChon);
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaSuaChua = doanhThuService.hangHoaTieuThuTrongSuaChuaTrongNgayNhatDinh(ngayDuocChon);
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaNhapHang = doanhThuService.hangHoaBiNhapTrongNgayNhatDinh(ngayDuocChon);
                veBieuDoTron(jPanel134, danhSachHangHoaHoaDon);
                veBieuDoTron(jPanel20, danhSachHangHoaSuaChua);
                veBieuDoTron(jPanel136, danhSachHangHoaNhapHang);
                
                int tongSoNhanVien = doanhThuService.tongSoNhanVienTrongTrongNgayNhatDinh(ngayDuocChon);
                double tongLuongCung = doanhThuService.tongTienLuongTrongNgayNhatDinh("BL", ngayDuocChon);
                double tongTangCa = doanhThuService.tongTienLuongTrongNgayNhatDinh("TC", ngayDuocChon);
                double tongLuongThuong = doanhThuService.tongTienLuongTrongNgayNhatDinh("LT", ngayDuocChon);
                double tongTroCap = doanhThuService.tongTienLuongTrongNgayNhatDinh("TCa", ngayDuocChon);
                
                lbDoanhThu_tienLuong_tongSoNhanVien.setText(String.valueOf(tongSoNhanVien));
                veBieuTroDoanhThu(jPanel143, tongLuongCung, tongTangCa, tongLuongThuong, tongTroCap);
                
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (radioDoanhThu_thang.isSelected()){
            int thang = dateChooser_theoThang_thang.getMonth() + 1;
            int nam = dateChooser_theoThang_nam.getYear();
            
            try {
                    
                ThongKeTongTienSoLuong doanhThuHoaDon = doanhThuService.tinhDoanhThuHoaDonTrongThangNhatDinh(thang, nam);
                ThongKeTongTienSoLuong doanhThuSuaChua = doanhThuService.tinhDoanhThuPhieuSuaChuaTrongThangNhatDinh(thang, nam);
                ThongKeTongTienSoLuong doanhThuTraHang = doanhThuService.tinhDoanhThuPhieuPhieuTraHangTrongThangNhatDinh(thang, nam);
                
                ThongKeTongTienSoLuong chiTieuTraHang = doanhThuService.tinhChiTieuPhieuTraHangTrongThangNhatDinh(thang, nam);
                ThongKeTongTienSoLuong chiTieuNhapHang = doanhThuService.tinhChiTieuPhieuNhapHangTrongThangNhatDinh(thang, nam);
                ThongKeTongTienSoLuong chiTieuTienLuongNhanVien = doanhThuService.tinhTienLuongNhanVienTrongThangNhatDinh(thang, nam);
                
                
                lbDoanhThu_soLuongPhieuLuong.setText(String.valueOf(chiTieuTienLuongNhanVien.getSoLuong()) + " phiếu lương");
                lbDoanhThu_soLuongPhieuNhapHang.setText(String.valueOf(chiTieuNhapHang.getSoLuong()) + " phiếu nhập hàng");
                lbDoanhThu_soLuongPhieuTraHangKhachHang.setText(String.valueOf(chiTieuTraHang.getSoLuong()) + " phiếu trả hàng");
                lbDoanhThu_soLuongPhieuTraHangNhaCungCap.setText(String.valueOf(doanhThuTraHang.getSoLuong()) + " phiếu trả hàng");
                lbDoanhThu_soLuongSuaChua.setText(String.valueOf(doanhThuSuaChua.getSoLuong()) + " phiếu sữa chữa");
                lbDoanhThu_soLuongHoaDon.setText(String.valueOf(doanhThuSuaChua.getSoLuong()) + " hóa đơn");
                lbDoanhThu_tienHoaDon.setText(String.valueOf(doanhThuHoaDon.getTongTien()));
                lbDoanhThu_loiNhuan.setText(String.valueOf(chiTieuTienLuongNhanVien.getTongTien()));
                lbDoanhThu_tienNhapHang.setText(String.valueOf(chiTieuNhapHang.getTongTien()));
                lbDoanhThu_tienSuaChua.setText(String.valueOf(doanhThuSuaChua.getTongTien()));
                lbDoanhThu_tienTraHangKhachHang.setText(String.valueOf(doanhThuTraHang.getTongTien()));
                lbDoanhThu_tienTraHangNhaCungCap.setText(String.valueOf(chiTieuTraHang.getTongTien()));
                        
                
                double loiNhuan1 = 0;
                double doanhThu1 = 0;
                double chiTieu1 = 0;
                
                loiNhuan1 = doanhThuHoaDon.getTongTien() + doanhThuSuaChua.getTongTien() + doanhThuTraHang.getTongTien() - chiTieuTraHang.getTongTien() - chiTieuNhapHang.getTongTien() - chiTieuTienLuongNhanVien.getTongTien();
                doanhThu1 = doanhThuHoaDon.getTongTien() + doanhThuSuaChua.getTongTien() + doanhThuTraHang.getTongTien();
                chiTieu1 = chiTieuTraHang.getTongTien() + chiTieuNhapHang.getTongTien() + chiTieuTienLuongNhanVien.getTongTien();
                
                long loiNhuan = (long) loiNhuan1;
                long doanhThu = (long) doanhThu1;
                long chiTieu = (long) chiTieu1;
                
                jPanel133.removeAll();
                src.UI.Chart.chat.Chart chart2 = new src.UI.Chart.chat.Chart();
                jPanel133.setBackground(new java.awt.Color(242, 249, 255));
                javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
                jPanel133.setLayout(jPanel133Layout);
                        jPanel133Layout.setHorizontalGroup(
                            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel133Layout.createSequentialGroup()
                                .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
                                .addContainerGap())
                        );
                        jPanel133Layout.setVerticalGroup(
                            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel133Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                jPanel133.revalidate();
                jPanel133.repaint();

                chart2.addLegend("DoanhThu", new Color(245, 189, 135));
                chart2.addLegend("Chi phí", new Color(135, 189, 245));
                chart2.addLegend("Lợi nhuận", new Color(189, 135, 245));

                chart2.addData(new ModelChart("Tổng quan", new double[]{doanhThu, chiTieu, loiNhuan}));
                
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaHoaDon = doanhThuService.hangHoaDuocMuaTrongHoaDonTrongThangNhatDinh(thang, nam);
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaSuaChua = doanhThuService.hangHoaTieuThuTrongSuaChuaTrongThangNhatDinh(thang, nam);
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaNhapHang = doanhThuService.hangHoaBiNhapTrongThangNhatDinh(thang, nam);
                veBieuDoTron(jPanel134, danhSachHangHoaHoaDon);
                veBieuDoTron(jPanel20, danhSachHangHoaSuaChua);
                veBieuDoTron(jPanel136, danhSachHangHoaNhapHang);
                
                int tongSoNhanVien = doanhThuService.tongSoNhanVienTrongTrongThangNhatDinh(thang, nam);
                double tongLuongCung = doanhThuService.tongTienLuongTrongThangNhatDinh("BL", thang, nam);
                double tongTangCa = doanhThuService.tongTienLuongTrongThangNhatDinh("TC", thang, nam);
                double tongLuongThuong = doanhThuService.tongTienLuongTrongThangNhatDinh("LT", thang, nam);
                double tongTroCap = doanhThuService.tongTienLuongTrongThangNhatDinh("TCa", thang, nam);
                
                lbDoanhThu_tienLuong_tongSoNhanVien.setText(String.valueOf(tongSoNhanVien));
                veBieuTroDoanhThu(jPanel143, tongLuongCung, tongTangCa, tongLuongThuong, tongTroCap);
                
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (radioDoanhThu_nam.isSelected()){
            try {
                
                jPanel133.removeAll();
                src.UI.Chart.chat.Chart chart2 = new src.UI.Chart.chat.Chart();
                jPanel133.setBackground(new java.awt.Color(242, 249, 255));
                javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
                jPanel133.setLayout(jPanel133Layout);
                        jPanel133Layout.setHorizontalGroup(
                            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel133Layout.createSequentialGroup()
                                .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
                                .addContainerGap())
                        );
                        jPanel133Layout.setVerticalGroup(
                            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel133Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                jPanel133.revalidate();
                jPanel133.repaint();

                chart2.addLegend("DoanhThu", new Color(245, 189, 135));
                chart2.addLegend("Chi phí", new Color(135, 189, 245));
                chart2.addLegend("Lợi nhuận", new Color(189, 135, 245));
                
                
                int nam = dateChooser_theoNam_nam.getYear();
                List<DoanhThuTrongNam> doanhThuHoaDon = doanhThuService.tinhDoanhThuHoaDonTrongNamNhatDinh( nam);
                List<DoanhThuTrongNam> doanhThuSuaChua = doanhThuService.tinhDoanhThuPhieuSuaChuaTrongNamNhatDinh( nam);
                List<DoanhThuTrongNam> doanhThuTraHang = doanhThuService.tinhDoanhThuPhieuTraHangTrongNamNhatDinh( nam);
                
                List<DoanhThuTrongNam> chiTieuTraHang = doanhThuService.tinhChiTieuPhieuTraHangTrongNamNhatDinh( nam);
                List<DoanhThuTrongNam> chiTieuNhapHang = doanhThuService.tinhChiTieuPhieuNhapHangTrongNamNhatDinh( nam);
                List<DoanhThuTrongNam> chiTieuTienLuongNhanVien = doanhThuService.tinhTienLuongNhanVienTrongNamNhatDinh( nam);
                
                double loiNhuanTong1 = 0;
                double doanhThuTong1 = 0;
                double chiTieuTong1 = 0;
                int soLuongHoaDon = 0;
                int soLuongPhieuSuaChua = 0;
                int soLuongPhieuTraHangNhaCungCap = 0;
                int soLuongPhieuTraHangKhachHang = 0;
                int soLuongPhieuNhapHang = 0;
                int soLuongPhieuLuong = 0;
                
                double tongTienHoaDon1 = 0;
                double tongTienPhieuSuaChua1 = 0;
                double tongTienPhieuTraHangNhaCungCap1 = 0;
                double tongTienPhieuTraHangKhachHang1 = 0;
                double tongTienPhieuNhapHang1 = 0;
                double tongTienPhieuLuong1 = 0;
                
                
                for (int i =1; i <= 12; i++){
                    double loiNhuan = 0;
                    double doanhThu = 0;
                    double chiTieu = 0;
                    for (int j = 0; j < doanhThuHoaDon.size(); j++){
                        if(doanhThuHoaDon.get(j).getThang() == i){
                            doanhThu = doanhThu + doanhThuHoaDon.get(j).getTongTien();
                            soLuongHoaDon = soLuongHoaDon + doanhThuHoaDon.get(j).getSoLuong();
                            tongTienHoaDon1 = tongTienHoaDon1 + doanhThuHoaDon.get(j).getTongTien();
                            break;
                        } 
                    }
                    
                    for (int j = 0; j < doanhThuSuaChua.size(); j++){
                        if(doanhThuSuaChua.get(j).getThang() == i){
                            doanhThu = doanhThu + doanhThuSuaChua.get(j).getTongTien();
                            soLuongPhieuSuaChua = soLuongPhieuSuaChua + doanhThuSuaChua.get(j).getSoLuong();
                            tongTienPhieuSuaChua1 = tongTienPhieuSuaChua1 + doanhThuSuaChua.get(j).getTongTien();
                            break;
                        } 
                    }
                    
                    for (int j = 0; j < doanhThuTraHang.size(); j++){
                        if(doanhThuTraHang.get(j).getThang() == i){
                            doanhThu = doanhThu + doanhThuTraHang.get(j).getTongTien();
                            soLuongPhieuTraHangNhaCungCap = soLuongPhieuTraHangNhaCungCap + doanhThuTraHang.get(j).getSoLuong();
                            tongTienPhieuTraHangNhaCungCap1 = tongTienPhieuTraHangNhaCungCap1 + doanhThuTraHang.get(j).getTongTien();
                            break;
                        } 
                    }
                    
                    for (int j = 0; j < chiTieuNhapHang.size(); j++){
                        if(chiTieuNhapHang.get(j).getThang() == i){
                            chiTieu = chiTieu + chiTieuNhapHang.get(j).getTongTien();
                            soLuongPhieuNhapHang = soLuongPhieuNhapHang + chiTieuNhapHang.get(j).getSoLuong();
                            tongTienPhieuNhapHang1 = tongTienPhieuNhapHang1 + chiTieuNhapHang.get(j).getTongTien();
                            break;
                        } 
                    }
                    
                    for (int j = 0; j < chiTieuTraHang.size(); j++){
                        if(chiTieuTraHang.get(j).getThang() == i){
                            chiTieu = chiTieu + chiTieuTraHang.get(j).getTongTien();
                            soLuongPhieuTraHangKhachHang = soLuongPhieuTraHangKhachHang + chiTieuTraHang.get(j).getSoLuong();
                            tongTienPhieuTraHangKhachHang1 = tongTienPhieuTraHangKhachHang1 + chiTieuTraHang.get(j).getTongTien();
                            break;
                        } 
                    }
                    
                    for (int j = 0; j < chiTieuTienLuongNhanVien.size(); j++){
                        if(chiTieuTienLuongNhanVien.get(j).getThang() == i){
                            chiTieu = chiTieu + chiTieuTienLuongNhanVien.get(j).getTongTien();
                            soLuongPhieuLuong = soLuongPhieuLuong + chiTieuTienLuongNhanVien.get(j).getSoLuong();
                            tongTienPhieuLuong1 = tongTienPhieuLuong1 + chiTieuTienLuongNhanVien.get(j).getTongTien();
                            break;
                        } 
                    }
                    doanhThuTong1 += doanhThu;
                    chiTieuTong1 += chiTieu;
                    String thang = "Tháng " + String.valueOf(i);
                    chart2.addData(new ModelChart(thang, new double[]{doanhThu, chiTieu, loiNhuan}));
                    
                    
                }
                
                loiNhuanTong1 = doanhThuTong1 - chiTieuTong1;
                
                long tongTienHoaDon = (long) tongTienHoaDon1;
                long tongTienPhieuLuong = (long) tongTienPhieuLuong1;
                long tongTienPhieuNhapHang = (long) tongTienPhieuNhapHang1;
                long tongTienPhieuSuaChua = (long) tongTienPhieuSuaChua1;
                long tongTienPhieuTraHangKhachHang = (long) tongTienPhieuTraHangKhachHang1;
                long tongTienPhieuTraHangNhaCungCap = (long) tongTienPhieuTraHangNhaCungCap1;
                long loiNhuanTong = (long) loiNhuanTong1;
                
                lbDoanhThu_soLuongPhieuLuong.setText(String.valueOf(soLuongPhieuLuong) + " phiếu lương");
                lbDoanhThu_soLuongPhieuNhapHang.setText(String.valueOf(soLuongPhieuNhapHang) + " phiếu nhập hàng");
                lbDoanhThu_soLuongPhieuTraHangKhachHang.setText(String.valueOf(soLuongPhieuTraHangKhachHang) + " phiếu trả hàng");
                lbDoanhThu_soLuongPhieuTraHangNhaCungCap.setText(String.valueOf(soLuongPhieuTraHangNhaCungCap) + " phiếu trả hàng");
                lbDoanhThu_soLuongSuaChua.setText(String.valueOf(soLuongPhieuSuaChua) + " phiếu sữa chữa");
                lbDoanhThu_soLuongHoaDon.setText(String.valueOf(soLuongHoaDon) + " hóa đơn");
                lbDoanhThu_tienHoaDon.setText(String.valueOf(tongTienHoaDon));
                lbDoanhThu_loiNhuan.setText(String.valueOf(tongTienPhieuLuong));
                lbDoanhThu_tienNhapHang.setText(String.valueOf(tongTienPhieuNhapHang));
                lbDoanhThu_tienSuaChua.setText(String.valueOf(tongTienPhieuSuaChua));
                lbDoanhThu_tienTraHangKhachHang.setText(String.valueOf(tongTienPhieuTraHangKhachHang));
                lbDoanhThu_tienTraHangNhaCungCap.setText(String.valueOf(tongTienPhieuTraHangNhaCungCap));
                lbDoanhThu_loiNhuan.setText(String.valueOf(loiNhuanTong));
                
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaHoaDon = doanhThuService.hangHoaDuocMuaTrongHoaDonTrongNam(nam);
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaSuaChua = doanhThuService.hangHoaTieuThuTrongSuaChuaTrongNam( nam);
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaNhapHang = doanhThuService.hangHoaBiNhapTrongNam( nam);
                veBieuDoTron(jPanel134, danhSachHangHoaHoaDon);
                veBieuDoTron(jPanel20, danhSachHangHoaSuaChua);
                veBieuDoTron(jPanel136, danhSachHangHoaNhapHang);
                
                int tongSoNhanVien = doanhThuService.tongSoNhanVienTrongTrongNamNhatDinh( nam);
                double tongLuongCung = doanhThuService.tongTienLuongTrongNamNhatDinh("BL",  nam);
                double tongTangCa = doanhThuService.tongTienLuongTrongNamNhatDinh("TC",  nam);
                double tongLuongThuong = doanhThuService.tongTienLuongTrongNamNhatDinh("LT",  nam);
                double tongTroCap = doanhThuService.tongTienLuongTrongNamNhatDinh("TCa",  nam);
                
                lbDoanhThu_tienLuong_tongSoNhanVien.setText(String.valueOf(tongSoNhanVien));
                veBieuTroDoanhThu(jPanel143, tongLuongCung, tongTangCa, tongLuongThuong, tongTroCap);
                
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDoanhThu_timKiemActionPerformed

    private void veBieuTroDoanhThu(JPanel panel, double tongLuongCung, double tongTangCa, double tongLuongThuong, double tongTroCap){
        lbDoanhThu_tienLuong_luongCung.setText(String.valueOf(tongLuongCung));
        lbDoanhThu_tienLuong_tangCa.setText(String.valueOf(tongTangCa));
        lbDoanhThu_tienLuong_tongTienThuong.setText(String.valueOf(tongLuongThuong));
        lbDoanhThu_tienLuong_tongTienTroCap.setText(String.valueOf(tongTroCap));

        panel.removeAll();
        src.UI.Chart.chat.Chart chart4 = new src.UI.Chart.chat.Chart();
        panel.setBackground(new java.awt.Color(242, 249, 255));
        javax.swing.GroupLayout jPanel143Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel143Layout);
        jPanel143Layout.setHorizontalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel143Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart4, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel143Layout.setVerticalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel143Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart4, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel.revalidate();
        panel.repaint();

        chart4.addLegend("Lương cứng", new Color(245, 189, 135));
        chart4.addLegend("Lương tăng ca", new Color(135, 189, 245));
        chart4.addLegend("Lương thưởng", new Color(189, 135, 245));
        chart4.addLegend("Trợ cấp", new Color(48,210,175)); 

        chart4.addData(new ModelChart("Tổng quan", new double[]{tongLuongCung, tongTangCa, tongLuongThuong, tongTroCap}));
    }
    
    private void veBieuDoTron(JPanel jpanel, List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaHoaDonInput){
        jpanel.removeAll();
                src.UI.Chart.piechart.PieChart pieChart2 = new src.UI.Chart.piechart.PieChart();
                
                jpanel.setBackground(new java.awt.Color(242, 249, 255));

                javax.swing.GroupLayout jPanel134Layout = new javax.swing.GroupLayout(jpanel);
                jpanel.setLayout(jPanel134Layout);
                jPanel134Layout.setHorizontalGroup( 
                    jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel134Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pieChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(221, Short.MAX_VALUE))
                );
                jPanel134Layout.setVerticalGroup(
                    jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel134Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pieChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                
                
                
                JPanel dataPanel;
                pieChart2.setModelsEmpty();
                pieChart2.setChartType(PieChart.PeiChartType.DONUT_CHART);
                
                // Initialize and configure the dataPanel
                dataPanel = new JPanel();
                dataPanel.removeAll();
                dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
                dataPanel.setBorder(BorderFactory.createTitledBorder("Data"));
                dataPanel.setBackground(new Color(242, 249, 255)); // Set màu nền cho dataPanel

                // Tạo font mới
                Font labelFont = new Font("Times New Roman", Font.PLAIN, 16);
                
                
                List<HangHoaTieuThuTrongKhoangThoiGian> danhSachHangHoaHoaDon = danhSachHangHoaHoaDonInput;
                
                for (int i =0; i < danhSachHangHoaHoaDon.size(); i++){
                    pieChart2.addData(new ModelPieChart(danhSachHangHoaHoaDon.get(i).getTenHangHoa(), danhSachHangHoaHoaDon.get(i).getSoLuongSuDung(), pieChart2.getColorList().get(i)));
                
                    // Add data to the dataPanel dynamically based on the pie chart data
                    String input = danhSachHangHoaHoaDon.get(i).getTenHangHoa() + ": " + danhSachHangHoaHoaDon.get(i).getSoLuongSuDung();
                    JLabel labelTigher = new JLabel(input);
                    labelTigher.setFont(labelFont);
                    dataPanel.add(labelTigher);
                }

                // Now, add pieChart2 to jPanel134
                dataPanel.setBorder(new EmptyBorder(20, 0, 0, 200));

                // Create a JScrollPane that will contain dataPanel
                JScrollPane scrollPane = new JScrollPane(dataPanel);                
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setBorder(null); // You can set a border if you like
                
                // Calculate the preferred width of the dataPanel based on its components
                int preferredWidth = dataPanel.getPreferredSize().width;
                // Optionally, you can add some extra width to accommodate the vertical scrollbar
                preferredWidth += scrollPane.getVerticalScrollBar().getPreferredSize().width;

                // Set the preferred size of the scrollPane with the calculated width
                scrollPane.setPreferredSize(new Dimension(preferredWidth, dataPanel.getPreferredSize().height));
                
                // Now, add both pieChart2 and dataPanel to jPanel134
                jpanel.setLayout(new BorderLayout()); // Set layout for jPanel134
                jpanel.add(pieChart2, BorderLayout.CENTER); // Add pieChart2 to the center
//                jPanel134.add(dataPanel, BorderLayout.EAST); // Add dataPanel to the right (east)
                jpanel.add(scrollPane, BorderLayout.EAST);
                
                // Revalidate jPanel134 to apply the new layout and components
                jpanel.revalidate();
                jpanel.repaint();
    }
    
    private void radioDoanhThu_khoangThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDoanhThu_khoangThoiGianActionPerformed
        if (radioDoanhThu_khoangThoiGian.isSelected()){
            dateChooser_ngayBatDau.setEnabled(true);
            dateChooser_ngayKetThuc.setEnabled(true);
            dateChooser_theoNam_nam.setEnabled(false);
            dateChooser_theoNgay_ngay.setEnabled(false);
            dateChooser_theoThang_nam.setEnabled(false);
            dateChooser_theoThang_thang.setEnabled(false);
        } else {
            dateChooser_ngayBatDau.setEnabled(false);
            dateChooser_ngayKetThuc.setEnabled(false);
            dateChooser_theoNam_nam.setEnabled(false);
            dateChooser_theoNgay_ngay.setEnabled(false);
            dateChooser_theoThang_nam.setEnabled(false);
            dateChooser_theoThang_thang.setEnabled(false);
        }
    }//GEN-LAST:event_radioDoanhThu_khoangThoiGianActionPerformed

    private void radioDoanhThu_ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDoanhThu_ngayActionPerformed
        if (radioDoanhThu_ngay.isSelected()){
            dateChooser_ngayBatDau.setEnabled(false);
            dateChooser_ngayKetThuc.setEnabled(false);
            dateChooser_theoNam_nam.setEnabled(false);
            dateChooser_theoNgay_ngay.setEnabled(true);
            dateChooser_theoThang_nam.setEnabled(false);
            dateChooser_theoThang_thang.setEnabled(false);
        } else {
            dateChooser_ngayBatDau.setEnabled(false);
            dateChooser_ngayKetThuc.setEnabled(false);
            dateChooser_theoNam_nam.setEnabled(false);
            dateChooser_theoNgay_ngay.setEnabled(false);
            dateChooser_theoThang_nam.setEnabled(false);
            dateChooser_theoThang_thang.setEnabled(false);
        }
    }//GEN-LAST:event_radioDoanhThu_ngayActionPerformed

    private void radioDoanhThu_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDoanhThu_thangActionPerformed
        if (radioDoanhThu_thang.isSelected()){
            dateChooser_ngayBatDau.setEnabled(false);
            dateChooser_ngayKetThuc.setEnabled(false);
            dateChooser_theoNam_nam.setEnabled(false);
            dateChooser_theoNgay_ngay.setEnabled(false);
            dateChooser_theoThang_nam.setEnabled(true);
            dateChooser_theoThang_thang.setEnabled(true);
        } else {
            dateChooser_ngayBatDau.setEnabled(false);
            dateChooser_ngayKetThuc.setEnabled(false);
            dateChooser_theoNam_nam.setEnabled(false);
            dateChooser_theoNgay_ngay.setEnabled(false);
            dateChooser_theoThang_nam.setEnabled(false);
            dateChooser_theoThang_thang.setEnabled(false);
        }
    }//GEN-LAST:event_radioDoanhThu_thangActionPerformed

    private void radioDoanhThu_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDoanhThu_namActionPerformed
        if (radioDoanhThu_nam.isSelected()){
            dateChooser_ngayBatDau.setEnabled(false);
            dateChooser_ngayKetThuc.setEnabled(false);
            dateChooser_theoNam_nam.setEnabled(true);
            dateChooser_theoNgay_ngay.setEnabled(false);
            dateChooser_theoThang_nam.setEnabled(false);
            dateChooser_theoThang_thang.setEnabled(false);
        } else {
            dateChooser_ngayBatDau.setEnabled(false);
            dateChooser_ngayKetThuc.setEnabled(false);
            dateChooser_theoNam_nam.setEnabled(false);
            dateChooser_theoNgay_ngay.setEnabled(false);
            dateChooser_theoThang_nam.setEnabled(false);
            dateChooser_theoThang_thang.setEnabled(false);
        }
    }//GEN-LAST:event_radioDoanhThu_namActionPerformed

    private void btnNhanVienChiNhanh_importNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienChiNhanh_importNhanVienActionPerformed
        try {                                                                   
            ImportFileCSV importCSV = new ImportFileCSV();
            //            List<KhachHang> danhSachKhachHang = khachHangService.hienThiTatCaKhachHang();
            List<NhanVien> danhSachNhanVien = importCSV.readCsvFileDanhSachNhanVien();
            int soLuongNhanVien = 0;
            try {
                soLuongNhanVien = nhanVienService.demSoNhanVien();
            } catch (SQLException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
            ChiNhanh chiNhanh = chiNhanhService.hienThiChiNhanhTheoMaChiNhanh(nhanVienDangNhap.getMaChiNhanh());

            for (NhanVien nhanVien : danhSachNhanVien){
                soLuongNhanVien += 1;
                nhanVien.setMaNhanVien("NV0" + soLuongNhanVien);
                nhanVien.setTaoBoiMaNhanVien(nhanVienDangNhap.getMaNhanVien());
                nhanVien.setMaChiNhanh(chiNhanh.getMaChiNhanh());
                nhanVien.setTenTaiKhoan("NV0" + soLuongNhanVien);
                nhanVien.setMatKhau("0");
                try {
                    nhanVienService.themNhanVien(nhanVien);
                } catch (SQLException ex) {
                    Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_btnNhanVienChiNhanh_importNhanVienActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        this.dispose();
        this.nhanVienDangNhap = new NhanVien();
        Login login = new Login();
        login.setVisible(true);
        login.setSize(630, 430);
        login.setLocation(0,0);
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiLaiActionPerformed
        hienThiThongTinNhanVienDangNhap();
    }//GEN-LAST:event_btnTaiLaiActionPerformed

    private void btnPhieuNhapHang_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuNhapHang_timKiemActionPerformed
        if (!util.kiemTraTonTaiChuoi(nhanVienDangNhap.getPhanQuyen(), " 12.1 ")){
                JOptionPane.showMessageDialog(this, "Bạn không có quyền xem danh sách phiếu nhập hàng!");
                return;
            }
        LocalDate ngayBatDau = util.localDateParseMethodToLocalDate(util.layNgayString(dateChoosePhieuNhapHang_batDau.getDate()));
        LocalDate ngayKetThuc = util.localDateParseMethodToLocalDate(util.layNgayString(dateChooserPhieuNhapHang_ketThuc.getDate()));
        try {
            hienThiDanhSachPhieuNhapHang(phieuNhapHangService.hienThiPhieuNhapHangTheoNgayBatDauVaNgayKetThuc(ngayBatDau, ngayKetThuc)); 
            
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
    }//GEN-LAST:event_btnPhieuNhapHang_timKiemActionPerformed

    private void btnPhieuNhapHang_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhieuNhapHang_taiLaiActionPerformed
        try {
            hienThiDanhSachPhieuNhapHang();
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPhieuNhapHang_taiLaiActionPerformed

    private void btnDatHang_loadLaiKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang_loadLaiKhachHangActionPerformed
        hienThiDanhSachKhachHangTaiCombobox(cbDatHang_danhSachKhachHang);
    }//GEN-LAST:event_btnDatHang_loadLaiKhachHangActionPerformed

    private void btnDatHang_loadLaiKhachHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang_loadLaiKhachHang1ActionPerformed
        hienThiDanhSachKhachHangTaiCombobox(cbSuaChua_danhSachKhachHang);
    }//GEN-LAST:event_btnDatHang_loadLaiKhachHang1ActionPerformed
    
    
    
    
    private String getTokenPhanQuyen(){
        String token = " ";
        
        if(checkBoxPhanQuyen_bangChamCongXem.isSelected()){ token = token + "1.1 ";}
        if(checkBoxPhanQuyen_bangChamCongThem.isSelected()){ token = token + "1.2 ";}
        if(checkBoxPhanQuyen_bangChamCongCapNhat.isSelected()){ token = token + "1.3 ";}
        
        if(checkBoxPhanQuyen_bangLuongXem.isSelected()){ token = token + "2.1 ";}
        if(checkBoxPhanQuyen_bangLuongThem.isSelected()){ token = token + "2.2 ";}
        if(checkBoxPhanQuyen_bangLuongCapNhat.isSelected()){ token = token + "2.3 ";}
        
        if(checkBoxPhanQuyen_caLamXem.isSelected()){ token = token + "3.1 ";}
        if(checkBoxPhanQuyen_caLamThem.isSelected()){ token = token + "3.2 ";}
        if(checkBoxPhanQuyen_caLamCapNhat.isSelected()){ token = token + "3.3 ";}
        
        if(checkBoxPhanQuyen_chiNhanhXem.isSelected()){ token = token + "4.1 ";}
        if(checkBoxPhanQuyen_chiNhanhThem.isSelected()){ token = token + "4.2 ";}
        if(checkBoxPhanQuyen_chiNhanhCapNhat.isSelected()){ token = token + "4.3 ";}
        if(checkBoxPhanQuyen_chiNhanhImport.isSelected()){ token = token + "4.4 ";}
        if(checkBoxPhanQuyen_chiNhanhExport.isSelected()){ token = token + "4.5 ";}
        
        if(checkBoxPhanQuyen_hangHoaXem.isSelected()){ token = token + "5.1 ";}
        if(checkBoxPhanQuyen_hangHoaThem.isSelected()){ token = token + "5.2 ";}
        if(checkBoxPhanQuyen_hangHoaCapNhat.isSelected()){ token = token + "5.3 ";}
        if(checkBoxPhanQuyen_hangHoaImport.isSelected()){ token = token + "5.4 ";}
        if(checkBoxPhanQuyen_hangHoaExport.isSelected()){ token = token + "5.5 ";}
        
        if(checkBoxPhanQuyen_hoaDonXem.isSelected()){ token = token + "6.1 ";}
        if(checkBoxPhanQuyen_hoaDonThem.isSelected()){ token = token + "6.2 ";}
        if(checkBoxPhanQuyen_hoaDonCapNhat.isSelected()){ token = token + "6.3 ";}
        if(checkBoxPhanQuyen_hoaDonExport.isSelected()){ token = token + "6.5 ";}
        if(checkBoxPhanQuyen_hoaDonMail.isSelected()){ token = token + "6.6 ";}
        
        if(checkBoxPhanQuyen_khachHangXem.isSelected()){ token = token + "7.1 ";}
        if(checkBoxPhanQuyen_khachHangThem.isSelected()){ token = token + "7.2 ";}
        if(checkBoxPhanQuyen_khachHangCapNhat.isSelected()){ token = token + "7.3 ";}
        if(checkBoxPhanQuyen_khachHangImport.isSelected()){ token = token + "7.4 ";}
        if(checkBoxPhanQuyen_khachHangExport.isSelected()){ token = token + "7.5 ";}
        
        if(checkBoxPhanQuyen_lichLamViecXem.isSelected()){ token = token + "8.1 ";}
        if(checkBoxPhanQuyen_lichLamViecThem.isSelected()){ token = token + "8.2 ";}
        if(checkBoxPhanQuyen_lichLamViecCapNhat.isSelected()){ token = token + "8.3 ";}
        if(checkBoxPhanQuyen_lichLamViecImport.isSelected()){ token = token + "8.4 ";}
        if(checkBoxPhanQuyen_lichLamViecExport.isSelected()){ token = token + "8.5 ";}
        
        if(checkBoxPhanQuyen_nhaCungCapXem.isSelected()){ token = token + "9.1 ";}
        if(checkBoxPhanQuyen_nhaCungCapThem.isSelected()){ token = token + "9.2 ";}
        if(checkBoxPhanQuyen_nhaCungCapCapNhat.isSelected()){ token = token + "9.3 ";}
        if(checkBoxPhanQuyen_nhaCungCapImport.isSelected()){ token = token + "9.4 ";}
        if(checkBoxPhanQuyen_nhaCungCapExport.isSelected()){ token = token + "9.5 ";}
        
        if(checkBoxPhanQuyen_nhanVienXem.isSelected()){ token = token + "10.1 ";}
        if(checkBoxPhanQuyen_nhanVienThem.isSelected()){ token = token + "10.2 ";}
        if(checkBoxPhanQuyen_nhanVienCapNhat.isSelected()){ token = token + "10.3 ";}
        if(checkBoxPhanQuyen_nhanVienExport.isSelected()){ token = token + "10.5 ";}
        
        if(checkBoxPhanQuyen_phieuLuongXem.isSelected()){ token = token + "11.1 ";}
        if(checkBoxPhanQuyen_phieuLuongThem.isSelected()){ token = token + "11.2 ";}
        
        if(checkBoxPhanQuyen_phieuNhapHangXem.isSelected()){ token = token + "12.1 ";}
        if(checkBoxPhanQuyen_phieuNhapHangThem.isSelected()){ token = token + "12.2 ";}
        if(checkBoxPhanQuyen_phieuNhapHangCapNhat.isSelected()){ token = token + "12.3 ";}
        if(checkBoxPhanQuyen_phieuNhapHangExport.isSelected()){ token = token + "12.5 ";}
        
        if(checkBoxPhanQuyen_phieuSuaChuaXem.isSelected()){ token = token + "13.1 ";}
        if(checkBoxPhanQuyen_phieuSuaChuaThem.isSelected()){ token = token + "13.2 ";}
        if(checkBoxPhanQuyen_phieuSuaChuaCapNhat.isSelected()){ token = token + "13.3 ";}
        
        if(checkBoxPhanQuyen_phieuTraHangXem.isSelected()){ token = token + "14.1 ";}
        if(checkBoxPhanQuyen_phieuTraHangThem.isSelected()){ token = token + "14.2 ";}
        if(checkBoxPhanQuyen_phieuTraHangExport.isSelected()){ token = token + "14.5 ";}
        if(checkBoxPhanQuyen_phieuTraHangMail.isSelected()){ token = token + "14.6 ";}
        
        if(checkBoxPhanQuyen_phuCapXem.isSelected()){ token = token + "15.1 ";}
        if(checkBoxPhanQuyen_phuCapThem.isSelected()){ token = token + "15.2 ";}
        if(checkBoxPhanQuyen_phuCapCapNhat.isSelected()){ token = token + "15.3 ";}
        if(checkBoxPhanQuyen_phuCapImport.isSelected()){ token = token + "15.4 ";}
        if(checkBoxPhanQuyen_phuCapExport.isSelected()){ token = token + "15.5 ";}
        if(checkBoxPhanQuyen_phuCapMail.isSelected()){ token = token + "15.6 ";}
        
        if(checkBoxPhanQuyen_kiemKhoXem.isSelected()){ token = token + "16.1 ";}
        if(checkBoxPhanQuyen_kiemKhoThem.isSelected()){ token = token + "16.2 ";}
        if(checkBoxPhanQuyen_kiemKhoCapNhat.isSelected()){ token = token + "16.3 ";}
        if(checkBoxPhanQuyen_kiemKhoImport.isSelected()){ token = token + "16.4 ";}
        if(checkBoxPhanQuyen_kiemKhoExport.isSelected()){ token = token + "16.5 ";}
        if(checkBoxPhanQuyen_kiemKhoMail.isSelected()){ token = token + "16.6 ";}
        
        if(checkBoxPhanQuyen_datHang.isSelected()){ token = token + "17 ";}
        if(checkBoxPhanQuyen_phanQuyen.isSelected()){ token = token + "18 ";}
        
        return token;
    }
    
    private void hienThiQuyenTaiKhoan(String tokenPhanQuyen){
        setSelectCheckBox(checkBoxPhanQuyen_bangChamCongXem,tokenPhanQuyen, " 1.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_bangChamCongThem,tokenPhanQuyen, " 1.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_bangChamCongCapNhat,tokenPhanQuyen, " 1.3 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_bangLuongXem,tokenPhanQuyen, " 2.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_bangLuongThem,tokenPhanQuyen, " 2.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_bangLuongCapNhat,tokenPhanQuyen, " 2.3 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_caLamXem,tokenPhanQuyen, " 3.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_caLamThem,tokenPhanQuyen, " 3.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_caLamCapNhat,tokenPhanQuyen, " 3.3 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_chiNhanhXem,tokenPhanQuyen, " 4.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_chiNhanhThem,tokenPhanQuyen, " 4.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_chiNhanhCapNhat,tokenPhanQuyen, " 4.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_chiNhanhImport,tokenPhanQuyen, " 4.4 ");
        setSelectCheckBox(checkBoxPhanQuyen_chiNhanhExport,tokenPhanQuyen, " 4.5 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_hangHoaXem,tokenPhanQuyen, " 5.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_hangHoaThem,tokenPhanQuyen, " 5.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_hangHoaCapNhat,tokenPhanQuyen, " 5.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_hangHoaImport,tokenPhanQuyen, " 5.4 ");
        setSelectCheckBox(checkBoxPhanQuyen_hangHoaExport,tokenPhanQuyen, " 5.5 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_hoaDonXem,tokenPhanQuyen, " 6.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_hoaDonThem,tokenPhanQuyen, " 6.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_hoaDonCapNhat,tokenPhanQuyen, " 6.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_hoaDonExport,tokenPhanQuyen, " 6.5 ");
        setSelectCheckBox(checkBoxPhanQuyen_hoaDonMail,tokenPhanQuyen, " 6.6 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_khachHangXem,tokenPhanQuyen, " 7.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_khachHangThem,tokenPhanQuyen, " 7.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_khachHangCapNhat,tokenPhanQuyen, " 7.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_khachHangImport,tokenPhanQuyen, " 7.4 ");
        setSelectCheckBox(checkBoxPhanQuyen_khachHangExport,tokenPhanQuyen, " 7.5 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_lichLamViecXem,tokenPhanQuyen, " 8.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_lichLamViecThem,tokenPhanQuyen, " 8.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_lichLamViecCapNhat,tokenPhanQuyen, " 8.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_lichLamViecImport,tokenPhanQuyen, " 8.4 ");
        setSelectCheckBox(checkBoxPhanQuyen_lichLamViecExport,tokenPhanQuyen, " 8.5 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_nhaCungCapXem,tokenPhanQuyen, " 9.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_nhaCungCapThem,tokenPhanQuyen, " 9.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_nhaCungCapCapNhat,tokenPhanQuyen, " 9.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_nhaCungCapImport,tokenPhanQuyen, " 9.4 ");
        setSelectCheckBox(checkBoxPhanQuyen_nhaCungCapExport,tokenPhanQuyen, " 9.5 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_nhanVienXem,tokenPhanQuyen, " 10.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_nhanVienThem,tokenPhanQuyen, " 10.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_nhanVienCapNhat,tokenPhanQuyen, " 10.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_nhanVienExport,tokenPhanQuyen, " 10.5 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_phieuLuongXem,tokenPhanQuyen, " 11.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_phieuLuongThem,tokenPhanQuyen, " 11.2 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_phieuNhapHangXem,tokenPhanQuyen, " 12.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_phieuNhapHangThem,tokenPhanQuyen, " 12.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_phieuNhapHangCapNhat,tokenPhanQuyen, " 12.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_phieuNhapHangExport,tokenPhanQuyen, " 12.5 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_phieuSuaChuaXem,tokenPhanQuyen, " 13.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_phieuSuaChuaThem,tokenPhanQuyen, " 13.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_phieuSuaChuaCapNhat,tokenPhanQuyen, " 13.3 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_phieuTraHangXem,tokenPhanQuyen, " 14.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_phieuTraHangThem,tokenPhanQuyen, " 14.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_phieuTraHangExport,tokenPhanQuyen, " 14.5 ");
        setSelectCheckBox(checkBoxPhanQuyen_phieuTraHangMail,tokenPhanQuyen, " 14.6 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_phuCapXem,tokenPhanQuyen, " 15.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_phuCapThem,tokenPhanQuyen, " 15.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_phuCapCapNhat,tokenPhanQuyen, " 15.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_phuCapImport,tokenPhanQuyen, " 15.4 ");
        setSelectCheckBox(checkBoxPhanQuyen_phuCapExport,tokenPhanQuyen, " 15.5 ");
        setSelectCheckBox(checkBoxPhanQuyen_phuCapMail,tokenPhanQuyen, " 15.6 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_kiemKhoXem,tokenPhanQuyen, " 16.1 ");
        setSelectCheckBox(checkBoxPhanQuyen_kiemKhoThem,tokenPhanQuyen, " 16.2 ");
        setSelectCheckBox(checkBoxPhanQuyen_kiemKhoCapNhat,tokenPhanQuyen, " 16.3 ");
        setSelectCheckBox(checkBoxPhanQuyen_kiemKhoImport,tokenPhanQuyen, " 16.4 ");
        setSelectCheckBox(checkBoxPhanQuyen_kiemKhoExport,tokenPhanQuyen, " 16.5 ");
        setSelectCheckBox(checkBoxPhanQuyen_kiemKhoMail,tokenPhanQuyen, " 16.6 ");
        
        setSelectCheckBox(checkBoxPhanQuyen_datHang,tokenPhanQuyen, " 17 ");
        setSelectCheckBox(checkBoxPhanQuyen_phanQuyen,tokenPhanQuyen, " 18 ");
    }
    
    private void setSelectCheckBox(JCheckBox checkBox, String tokenPhanQuyen, String quyen){
        if (util.kiemTraTonTaiChuoi(tokenPhanQuyen, quyen)){
            checkBox.setSelected(true);
        } else {
            checkBox.setSelected(false);
        }
    }
    
    public void filterDanhSachNhanVien(String query){
        DefaultTableModel model = (DefaultTableModel) tb_danhSachNhanVien.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tb_danhSachNhanVien.setRowSorter(tr);
        
        RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Get the value in the second column (index 2) of the current row
                Object value = entry.getValue(1 );
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
    
    public void filterDanhSachNhanVienLichLamViec(String query){
        DefaultTableModel model = (DefaultTableModel) tbLichLamViec_danhSachNhanVien.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tbLichLamViec_danhSachNhanVien.setRowSorter(tr);
        
        RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Get the value in the second column (index 2) of the current row
                Object value = entry.getValue(1 );
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
                columnData.add(phieuSuaChua.getMaLoaiXe());
                columnData.add(phieuSuaChua.getNoiDungSuaChua());
                columnData.add(nhanVienService.hienThiNhanVienTheoMaNhanVien(phieuSuaChua.getMaNhanVien()).getTenNhanVien());
                columnData.add(phieuSuaChua.getTongTien());
                columnData.add(phieuSuaChua.getMaPhieuSuaChua());
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
                columnData.add(khachHang.getEmail());
                columnData.add(khachHang.getMaSoThue());
                columnData.add(khachHang.getTongBan());
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
                columnData.add(nhaCungCap.getMaSoThue());
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
    
    private void hienThiDanhSachNhanVienLichLamViec(){
        try {
            danhSachNhanVienMain = nhanVienService.hienThiTatCaNhanVien();
            DefaultTableModel recordTable = (DefaultTableModel)tbLichLamViec_danhSachNhanVien.getModel();
            recordTable.setRowCount(0);
            for (NhanVien nhanVien : danhSachNhanVienMain) {
                Vector columnData = new Vector();
                columnData.add(nhanVien.getMaNhanVien());
                columnData.add(nhanVien.getTenNhanVien());
                columnData.add(nhanVien.getCccd());
                recordTable.addRow(columnData);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void hienThiDanhSachChiNhanh(){
        try {
            List<ChiNhanh> danhSachChiNhanh = chiNhanhService.hienThiTatCaChiNhanh();
            lbNhanVienChiNhanh_ma.setText(danhSachChiNhanh.get(0).getMaChiNhanh());
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
    private void hienThiDanhSachChiNhanhLichLamViec(){
        try {
            List<ChiNhanh> danhSachChiNhanh = chiNhanhService.hienThiTatCaChiNhanh();
            DefaultTableModel recordTable = (DefaultTableModel)tbLichLamViec_danhSachChiNhanh.getModel();
            recordTable.setRowCount(0);
            for (ChiNhanh chiNhanh : danhSachChiNhanh) {
                Vector columnData = new Vector();
                columnData.add(chiNhanh.getMaChiNhanh());
                columnData.add(chiNhanh.getTenChiNhanh());
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
            columnData.add(phieuNhapHang.getPhieuNhapHang());
            recordTable.addRow(columnData);
        }
    }
    
    public void hienThiDanhSachPhieuNhapHang(List<PhieuNhapHang> danhSachPhieuNhapHang){
        DefaultTableModel recordTable = (DefaultTableModel)tb_danhSachPhieuNhapHang.getModel();
        recordTable.setRowCount(0);
        for (PhieuNhapHang phieuNhapHang : danhSachPhieuNhapHang){
            Vector columnData = new Vector();
            columnData.add(phieuNhapHang.getPhieuNhapHang());
            columnData.add(util.localDateParseMethod(phieuNhapHang.getThoiGian()));
            columnData.add(phieuNhapHang.getMaNhaCungCap());
            columnData.add(phieuNhapHang.getTong());
            columnData.add(phieuNhapHang.getPhieuNhapHang());
            recordTable.addRow(columnData);
        }
    }
    
    public void hienThiDanhSachHangHoa(String maHangHoa, String tenHangHoa) throws SQLException, IOException{
//        cbHangHoa_loaiHangDaChon.setPopupVisible(true);
//        cbHangHoa_loaiXeDaChon.setPopupVisible(true);
        cbHangHoa_loaiHangDaChon.removeAllItems();

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
    
    public void filterDanhSachKhachHang(String query){
        DefaultTableModel model = (DefaultTableModel) tb_danhSachKhachHang.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tb_danhSachKhachHang.setRowSorter(tr);
        
        RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Get the value in the second column (index 2) of the current row
                Object value = entry.getValue(1 );
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
    
    public void filterDanhSachNhaCungCap(String query){
        DefaultTableModel model = (DefaultTableModel) tb_danhSachNhaCungCap.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tb_danhSachNhaCungCap.setRowSorter(tr);
        
        RowFilter<DefaultTableModel, Object> rowFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Get the value in the second column (index 2) of the current row
                Object value = entry.getValue(1 );
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
            comboBox.removeAllItems();
            comboBox.addItem("");
            for (KhachHang khachHang : danhSachKhachHangMain){
                comboBox.addItem(khachHang.getMaKhachHang() + " " + khachHang.getTenKhachHang() + " " + khachHang.getSoDienThoai());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hienThiDanhSachHangHoaTaiCombobox(JComboBox<String> comboBox){
        List<HangHoa> danhSachHangHoa = new ArrayList<>();
            try {
                danhSachHangHoa = hangHoaService.hienThiTatCaHangHoa("","");
            } catch (SQLException ex) {
                System.out.println("Loi hien thi combobox hang hoa");
            }
            comboBox.removeAllItems();
            comboBox.addItem("");
            for (HangHoa hangHoa : danhSachHangHoa) {
                comboBox.addItem(hangHoa.getMaHangHoa() + " " + hangHoa.getTenHangHoa() + "; Giá: " + hangHoa.getGiaThay());
            }
    }
    
    private boolean performComboboxNhanVien = true;
    public void hienThiDanhSachNhanVienCombobox(JComboBox<String> comboBox){
        performComboboxNhanVien = false;
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
        performComboboxNhanVien = true;
    }
    
    public void hienThiDanhSachCaLamCombobox(JComboBox<String> comboBox){
        try {
            comboBox.removeAllItems();
            comboBox.addItem("");
            List<CaLam> danhSachCaLam = caLamService.hienThiTatCaCaLam();
            for (CaLam caLam : danhSachCaLam){
                comboBox.addItem(caLam.getMaCaLam() + " " + caLam.getTenCaLam());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void hienThiDanhSachBangLuongCombobox(JComboBox<String> comboBox, String input){
        try {
            comboBox.removeAllItems();
            comboBox.addItem("");
            List<BangLuong> danhSachBangLuong = bangLuongService.hienThiBangLuong();
            for (BangLuong bangLuong : danhSachBangLuong){
                if (bangLuong.getMaBangLuong().toString().contains(input)){
                    comboBox.addItem(bangLuong.getMaBangLuong() + " " + bangLuong.getNoiDung());
                }
                
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
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDatHang_datHang;
    private javax.swing.JButton btnDatHang_loadLaiKhachHang;
    private javax.swing.JButton btnDatHang_loadLaiKhachHang1;
    private javax.swing.JButton btnDatHang_themKhachHang;
    private javax.swing.JButton btnDatHang_timKhachHang;
    private javax.swing.JButton btnDoanhThu_timKiem;
    private javax.swing.JButton btnHangHoa_export;
    private javax.swing.JButton btnHangHoa_import;
    private javax.swing.JButton btnHangHoa_taiLai;
    private javax.swing.JButton btnHangHoa_them;
    private javax.swing.JButton btnHangHoa_timKiem;
    private javax.swing.JButton btnHoaDon_taiLai;
    private javax.swing.JButton btnHoaDon_timKiem;
    private javax.swing.JButton btnKhachHang_them;
    private javax.swing.JButton btnKhachHoa_xuatFile;
    private javax.swing.JButton btnLichLamViec_capNhatCaLam;
    private javax.swing.JButton btnLichLamViec_capNhatLichLamViec;
    private javax.swing.JButton btnLichLamViec_capNhatLichTangCa;
    private javax.swing.JButton btnLichLamViec_huyBo;
    private javax.swing.JButton btnLichLamViec_lamMoi;
    private javax.swing.JButton btnLichLamViec_lapPhieuLuong;
    private javax.swing.JButton btnLichLamViec_lichNghiViec;
    private javax.swing.JButton btnLichLamViec_luu;
    private javax.swing.JButton btnLichLamViec_themBangLuong;
    private javax.swing.JButton btnLichLamViec_themLichLamViec;
    private javax.swing.JButton btnLichLamViec_themLichTangCa;
    private javax.swing.JButton btnLichLamViec_themPhuCap;
    private javax.swing.JButton btnNhaCungCap_them;
    private javax.swing.JButton btnNhaCungCap_xuatFile;
    private javax.swing.JButton btnNhacungCap_import;
    private javax.swing.JButton btnNhanVienChiNhanh_exportChiNhanh;
    private javax.swing.JButton btnNhanVienChiNhanh_exportNhanVien;
    private javax.swing.JButton btnNhanVienChiNhanh_importChiNhanh;
    private javax.swing.JButton btnNhanVienChiNhanh_importNhanVien;
    private javax.swing.JButton btnNhanVienChiNhanh_taiLai;
    private javax.swing.JButton btnNhanVienChiNhanh_themChiNhanh;
    private javax.swing.JButton btnNhanVienChiNhanh_themNhanVien;
    private javax.swing.JButton btnNhanVienChiNhanh_xemChiTiet;
    private javax.swing.JButton btnNhapHang_them;
    private javax.swing.JButton btnPhanQuyen_capNhat;
    private javax.swing.JButton btnPhieuNhapHang_export;
    private javax.swing.JButton btnPhieuNhapHang_taiLai;
    private javax.swing.JButton btnPhieuNhapHang_timKiem;
    private javax.swing.JButton btnPhieuTraHang_exportFile;
    private javax.swing.JButton btnSuaChua_reset;
    private javax.swing.JButton btnSuaChua_them;
    private javax.swing.JButton btnSuaChua_themKhachHang;
    private javax.swing.JButton btnSuaChua_timKhachHang;
    private javax.swing.JButton btnSuaChua_timPhuTung;
    private javax.swing.JButton btnTaiLai;
    private javax.swing.JButton btn_bangCongCapNhat;
    private javax.swing.JButton btn_bangCongReset;
    private javax.swing.JButton btn_bangCongThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbDatHang_danhSachKhachHang;
    private javax.swing.JComboBox<String> cbHangHoa_loaiHang;
    private javax.swing.JComboBox<String> cbHangHoa_loaiHangDaChon;
    private javax.swing.JComboBox<String> cbHoaDon_nguoiTao;
    private javax.swing.JComboBox<String> cbLichLamViec_bangLuong;
    private javax.swing.JComboBox<String> cbLichLamViec_caLam;
    private javax.swing.JComboBox<String> cbLichLamViec_caLamDaChon;
    private javax.swing.JComboBox<String> cbLichLamViec_trangThai;
    private javax.swing.JComboBox<String> cbPhanQuyen_nhanVien;
    private javax.swing.JComboBox<String> cbSuaChua_danhSachKhachHang;
    private javax.swing.JComboBox<String> cbSuaChua_phuTungDaChon;
    private javax.swing.JComboBox<String> cb_bangCongNhanVien;
    private javax.swing.JComboBox<String> cb_bangCongTrangThai;
    private javax.swing.JComboBox<String> cb_nhanVienSuaChua;
    private javax.swing.JComboBox<String> cb_phuTungCanThay;
    private src.UI.Chart.chat.Chart chart1;
    private src.UI.Chart.chat.Chart chart3;
    private javax.swing.JCheckBox checkBoxPhanQuyen_bangChamCongCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_bangChamCongThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_bangChamCongXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_bangLuongCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_bangLuongThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_bangLuongXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_caLamCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_caLamThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_caLamXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_chiNhanhCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_chiNhanhExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_chiNhanhImport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_chiNhanhThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_chiNhanhXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_datHang;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hangHoaCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hangHoaExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hangHoaImport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hangHoaThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hangHoaXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hoaDonCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hoaDonExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hoaDonMail;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hoaDonThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_hoaDonXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_khachHangCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_khachHangExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_khachHangImport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_khachHangThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_khachHangXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_kiemKhoCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_kiemKhoExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_kiemKhoImport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_kiemKhoMail;
    private javax.swing.JCheckBox checkBoxPhanQuyen_kiemKhoThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_kiemKhoXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_lichLamViecCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_lichLamViecExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_lichLamViecImport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_lichLamViecThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_lichLamViecXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_nhaCungCapCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_nhaCungCapExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_nhaCungCapImport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_nhaCungCapThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_nhaCungCapXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_nhanVienCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_nhanVienExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_nhanVienThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_nhanVienXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phanQuyen;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuLuongThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuLuongXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuNhapHangCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuNhapHangExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuNhapHangThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuNhapHangXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuSuaChuaCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuSuaChuaThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuSuaChuaXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuTraHangExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuTraHangMail;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuTraHangThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phieuTraHangXem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phuCapCapNhat;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phuCapExport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phuCapImport;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phuCapMail;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phuCapThem;
    private javax.swing.JCheckBox checkBoxPhanQuyen_phuCapXem;
    private com.toedter.calendar.JDateChooser dateChooseHoaDon_batDau;
    private com.toedter.calendar.JDateChooser dateChoosePhieuNhapHang_batDau;
    private com.toedter.calendar.JDateChooser dateChoose_bangCongNgayLam;
    private com.toedter.calendar.JDateChooser dateChooserChamCong_ngayBatDau;
    private com.toedter.calendar.JDateChooser dateChooserChamCong_ngayKetThuc;
    private com.toedter.calendar.JDateChooser dateChooserChamCong_theongay_ngay;
    private com.toedter.calendar.JDateChooser dateChooserHoaDon_ketThuc;
    private com.toedter.calendar.JDateChooser dateChooserLichLamViec_ngayBatDau;
    private com.toedter.calendar.JDateChooser dateChooserLichLamViec_ngayKetThuc;
    private com.toedter.calendar.JDateChooser dateChooserPhieuNhapHang_ketThuc;
    private com.toedter.calendar.JDateChooser dateChooser_ngayBatDau;
    private com.toedter.calendar.JDateChooser dateChooser_ngayKetThuc;
    private com.toedter.calendar.JYearChooser dateChooser_theoNam_nam;
    private com.toedter.calendar.JDateChooser dateChooser_theoNgay_ngay;
    private com.toedter.calendar.JYearChooser dateChooser_theoThang_nam;
    private com.toedter.calendar.JMonthChooser dateChooser_theoThang_thang;
    private javax.swing.JButton jButton17;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
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
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel63;
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
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JLabel lbBangChamCong_soLuongNhanVien;
    private javax.swing.JLabel lbDatHang_maDonHang;
    private javax.swing.JLabel lbDatHang_maDonHang1;
    private javax.swing.JLabel lbDoanhThu_loiNhuan;
    private javax.swing.JLabel lbDoanhThu_soLuongHoaDon;
    private javax.swing.JLabel lbDoanhThu_soLuongPhieuLuong;
    private javax.swing.JLabel lbDoanhThu_soLuongPhieuNhapHang;
    private javax.swing.JLabel lbDoanhThu_soLuongPhieuTraHangKhachHang;
    private javax.swing.JLabel lbDoanhThu_soLuongPhieuTraHangNhaCungCap;
    private javax.swing.JLabel lbDoanhThu_soLuongSuaChua;
    private javax.swing.JLabel lbDoanhThu_tienHoaDon;
    private javax.swing.JLabel lbDoanhThu_tienLuongNhanVien;
    private javax.swing.JLabel lbDoanhThu_tienLuong_luongCung;
    private javax.swing.JLabel lbDoanhThu_tienLuong_tangCa;
    private javax.swing.JLabel lbDoanhThu_tienLuong_tongSoNhanVien;
    private javax.swing.JLabel lbDoanhThu_tienLuong_tongTienThuong;
    private javax.swing.JLabel lbDoanhThu_tienLuong_tongTienTroCap;
    private javax.swing.JLabel lbDoanhThu_tienNhapHang;
    private javax.swing.JLabel lbDoanhThu_tienSuaChua;
    private javax.swing.JLabel lbDoanhThu_tienTraHangKhachHang;
    private javax.swing.JLabel lbDoanhThu_tienTraHangNhaCungCap;
    private javax.swing.JLabel lbLichLamViec_Ma;
    private javax.swing.JLabel lbLichLamViec_cccd;
    private javax.swing.JLabel lbLichLamViec_maNhanVien;
    private javax.swing.JLabel lbLichLamViec_ngayBatDauLabel;
    private javax.swing.JLabel lbLichLamViec_nhanViec;
    private javax.swing.JLabel lbLichLamViec_tenNhanVien;
    private javax.swing.JLabel lbLichLamViec_thongBao;
    private javax.swing.JLabel lbNhanVienChiNhanh_ma;
    private javax.swing.JLabel lbSuaChua_chiMucKhachHang;
    private javax.swing.JLabel lbSuaChua_chiMucKhachHang2;
    private javax.swing.JLabel lbSuaChua_soDienThoai;
    private javax.swing.JLabel lbSuaChua_tongTien;
    private javax.swing.JLabel lbTrangChu_anhNhanVien;
    private javax.swing.JLabel lbTrangChu_tenNguoiDung;
    private javax.swing.JLabel lb_maBangChamCong;
    private com.toedter.calendar.JMonthChooser monthChooser_theoThang_thang;
    private javax.swing.JPanel panelLichLamViec_ngayKetThuc;
    private src.UI.Chart.piechart.PieChart pieChart1;
    private src.UI.Chart.piechart.PieChart pieChart2;
    private src.UI.Chart.piechart.PieChart pieChart3;
    private javax.swing.JRadioButton radioBtnHangHoa_conHangTrongKho;
    private javax.swing.JRadioButton radioBtnHangHoa_hetHangTrongKho;
    private javax.swing.JRadioButton radioChamCong_khoangThoiGian;
    private javax.swing.JRadioButton radioChamCong_theoNam;
    private javax.swing.JRadioButton radioChamCong_theoNgay;
    private javax.swing.JRadioButton radioChamCong_theoThang;
    private javax.swing.JRadioButton radioDoanhThu_khoangThoiGian;
    private javax.swing.JRadioButton radioDoanhThu_nam;
    private javax.swing.JRadioButton radioDoanhThu_ngay;
    private javax.swing.JRadioButton radioDoanhThu_thang;
    private javax.swing.JTabbedPane tabPane_giaoDich;
    private javax.swing.JTabbedPane tabbedDoanhThu;
    private javax.swing.JTabbedPane tabbedPane_doiTac;
    private javax.swing.JTabbedPane tabbedPane_nhanVien;
    private javax.swing.JTabbedPane tabbedPane_trangChu;
    private javax.swing.JTextArea tareLichLamViec_ghiChu;
    private javax.swing.JTextArea tare_noiDungSuaChua;
    private javax.swing.JTable tbDatHang_danhSachHangHoa;
    private javax.swing.JTable tbDatHang_danhSachHangHoaDaChon;
    private javax.swing.JTable tbHoaDon_danhSachHoaDon;
    private javax.swing.JTable tbLichLamViec_danhSachChiNhanh;
    private javax.swing.JTable tbLichLamViec_danhSachNhanVien;
    private javax.swing.JTable tbLichLamViec_lichLamViec;
    private javax.swing.JTable tbLichLamViec_lichTangCa;
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
    private javax.swing.JTextField tfKhachHang_locTuDong;
    private javax.swing.JTextField tfLichLamViec_locTuDong;
    private javax.swing.JTextField tfLichLamViec_soGioTangCa;
    private javax.swing.JTextField tfNhaCungCap_locTuDong;
    private javax.swing.JTextField tfNhanVienChiNhanh_locTuDong;
    private javax.swing.JTextField tfPhanQuyen_matKhau;
    private javax.swing.JTextField tfPhanQuyen_tenTenKhoan;
    private javax.swing.JTextField tfSuaChua_loaiXe;
    private javax.swing.JTextField tfSuaChua_tenKhachHang;
    private javax.swing.JTextField tfSuaChua_tenPhuTungTimKiem;
    private com.toedter.calendar.JYearChooser yearChooserChamCong_theoNam_nam;
    private com.toedter.calendar.JYearChooser yearChooserChamCong_theoThang_nam;
    // End of variables declaration//GEN-END:variables
}
