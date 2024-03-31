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
public class PhieuTraHang {
    private String maPhieuTraHang;
    private LocalDateTime thoiGian;
    private double canTra;
    private double daTra;
    private String trangThai;
    private String maNhaCungCap;
    private String maHoaDon;
    private String maKhachHang;
    private String maNhanVien;
    private HoaDon hoaDon;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private NhaCungCap nhaCungCap;
          

    public PhieuTraHang(String maPhieuTraHang, LocalDateTime thoiGian, double canTra, double daTra, String maHoaDon, String maKhachHang, String maNhanVien) {
        this.maPhieuTraHang = maPhieuTraHang;
        this.thoiGian = thoiGian;
        this.canTra = canTra;
        this.daTra = daTra;
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
    }

    public PhieuTraHang() {
    }

    public String getMaPhieuTraHang() {
        return maPhieuTraHang;
    }

    public void setMaPhieuTraHang(String maPhieuTraHang) {
        this.maPhieuTraHang = maPhieuTraHang;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
        this.thoiGian = thoiGian;
    }

    public double getCanTra() {
        return canTra;
    }

    public void setCanTra(double canTra) {
        this.canTra = canTra;
    }

    public double getDaTra() {
        return daTra;
    }

    public void setDaTra(double daTra) {
        this.daTra = daTra;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    
    
}
