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
public class PhieuNhapHang {
    private String phieuNhapHang;
    private LocalDateTime thoiGian;
    private double tong;
    private double no;
    private String trangThai;
    private String maNhaCungCap;
    private String maChiNhanh;
    private String maNhanVienTao;
    private double tienDaTra;
    private NhaCungCap nhaCungCap;
    private ChiNhanh chiNhanh;
    private NhanVien nhanVienTao;

    public PhieuNhapHang() {
    }

    public PhieuNhapHang(String phieuNhapHang, LocalDateTime thoiGian, double tong, double no, String trangThai, String maNhaCungCap) {
        this.phieuNhapHang = phieuNhapHang;
        this.thoiGian = thoiGian;
        this.tong = tong;
        this.no = no;
        this.trangThai = trangThai;
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getPhieuNhapHang() {
        return phieuNhapHang;
    }

    public void setPhieuNhapHang(String phieuNhapHang) {
        this.phieuNhapHang = phieuNhapHang;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
        this.thoiGian = thoiGian;
    }

    public double getTong() {
        return tong;
    }

    public void setTong(double tong) {
        this.tong = tong;
    }

    public double getNo() {
        return no;
    }

    public void setNo(double no) {
        this.no = no;
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

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public String getMaNhanVienTao() {
        return maNhanVienTao;
    }

    public void setMaNhanVienTao(String maNhanVienTao) {
        this.maNhanVienTao = maNhanVienTao;
    }

    public NhanVien getNhanVienTao() {
        return nhanVienTao;
    }

    public void setNhanVienTao(NhanVien nhanVienTao) {
        this.nhanVienTao = nhanVienTao;
    }

    public double getTienDaTra() {
        return tienDaTra;
    }

    public void setTienDaTra(double tienDaTra) {
        this.tienDaTra = tienDaTra;
    }
    
    
}
