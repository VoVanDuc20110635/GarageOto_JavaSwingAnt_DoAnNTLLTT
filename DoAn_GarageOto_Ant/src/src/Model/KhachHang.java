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
public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private LocalDateTime ngaySinh;
    private String maSoThue;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private LocalDateTime ngayTao;
    private double tongBan;
    private double tongNo;
    private String maNhanVien;
    private NhanVien nhanVien;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String tenKhachHang, LocalDateTime ngaySinh, String maSoThue, String email, String soDienThoai, String diaChi, LocalDateTime ngayTao, double tongBan, double tongNo, String maNhanVien) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.maSoThue = maSoThue;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.tongBan = tongBan;
        this.tongNo = tongNo;
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public LocalDateTime getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDateTime ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getTongBan() {
        return tongBan;
    }

    public void setTongBan(double tongBan) {
        this.tongBan = tongBan;
    }

    public double getTongNo() {
        return tongNo;
    }

    public void setTongNo(double tongNo) {
        this.tongNo = tongNo;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
   
    
}
