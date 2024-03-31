/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

import java.time.LocalDateTime;

/**
 *
 * @author WINDOWS 10
 */
public class PhieuSuaChua {
    private String maPhieuSuaChua;
    private String noiDungSuaChua;
    private double tongTien;
    private String trangThai;
    private LocalDateTime thoiGian;
    private String maHangHoa;
    private String maKhachHang;
    private String maLoaiXe;
    private String maNhanVien;
    private String maNhomHang;
    
    private HangHoa hangHoa;
    private KhachHang khachHang;
    private LoaiXe loaiXe;
    private NhanVien nhanVien;
    

    public PhieuSuaChua() {
    }

    public PhieuSuaChua(String maPhieuSuaChua, String noiDungSuaChua, double tongTien, String trangThai, String maHangHoa, String maKhachHang, String maLoaiXe, String maNhanVien, String maNhomHang) {
        this.maPhieuSuaChua = maPhieuSuaChua;
        this.noiDungSuaChua = noiDungSuaChua;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.maHangHoa = maHangHoa;
        this.maKhachHang = maKhachHang;
        this.maLoaiXe = maLoaiXe;
        this.maNhanVien = maNhanVien;
        this.maNhomHang = maNhomHang;
    }

    public String getMaPhieuSuaChua() {
        return maPhieuSuaChua;
    }

    public void setMaPhieuSuaChua(String maPhieuSuaChua) {
        this.maPhieuSuaChua = maPhieuSuaChua;
    }

    public String getNoiDungSuaChua() {
        return noiDungSuaChua;
    }

    public void setNoiDungSuaChua(String noiDungSuaChua) {
        this.noiDungSuaChua = noiDungSuaChua;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaLoaiXe() {
        return maLoaiXe;
    }

    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhomHang() {
        return maNhomHang;
    }

    public void setMaNhomHang(String maNhomHang) {
        this.maNhomHang = maNhomHang;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
        this.thoiGian = thoiGian;
    }
    
    
}
