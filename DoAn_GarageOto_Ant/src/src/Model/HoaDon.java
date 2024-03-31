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
public class HoaDon {
    private String maHoaDon;
    private LocalDateTime thoiGian;
    private String loaiThuChi;
    private String trangThai;
    private double tongTien;
    private double giamGia;
    private double tienDaTra;
    private String maKhachHang;
    private String maNhaCungCap;
    private String maNhanVien;
    private String maPhieuTraHang;
    private KhachHang khachHang;
    private NhaCungCap nhaCungCap;
    private NhanVien nhanVien;
    private PhieuTraHang phieuTraHang;

    public HoaDon(String maHoaDon, LocalDateTime thoiGian, String loaiThuChi, String trangThai, double tongTien, double giamGia, double tienDaTra, String maKhachHang, String maNhaCungCap, String maNhanVien) {
        this.maHoaDon = maHoaDon;
        this.thoiGian = thoiGian;
        this.loaiThuChi = loaiThuChi;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
        this.tienDaTra = tienDaTra;
        this.maKhachHang = maKhachHang;
        this.maNhaCungCap = maNhaCungCap;
        this.maNhanVien = maNhanVien;
    }

    public HoaDon() {
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getLoaiThuChi() {
        return loaiThuChi;
    }

    public void setLoaiThuChi(String loaiThuChi) {
        this.loaiThuChi = loaiThuChi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double getTienDaTra() {
        return tienDaTra;
    }

    public void setTienDaTra(double tienDaTra) {
        this.tienDaTra = tienDaTra;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMaPhieuTraHang() {
        return maPhieuTraHang;
    }

    public void setMaPhieuTraHang(String maPhieuTraHang) {
        this.maPhieuTraHang = maPhieuTraHang;
    }

    public PhieuTraHang getPhieuTraHang() {
        return phieuTraHang;
    }

    public void setPhieuTraHang(PhieuTraHang phieuTraHang) {
        this.phieuTraHang = phieuTraHang;
    }
    
}
