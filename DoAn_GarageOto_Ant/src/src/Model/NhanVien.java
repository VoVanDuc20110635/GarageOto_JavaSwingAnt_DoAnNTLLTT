/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author WINDOWS 10
 */
public class NhanVien {
    private String maNhanVien;
    private String tenNhanVien;
    private LocalDate ngaySinh;
    private String gioiTinh;
    private String cccd;
    private String chucDanh;
    private String soDienThoai;
    private LocalDate ngayBatDauLamViec;
    private String maChiNhanh;
    private String taoBoiMaNhanVien;
    
    private String diaChi;
    private String maSoThue;
    private String trangThai;
    private double noLuong;
    
    private ChiNhanh chiNhanh;
    private NhanVien taoBoiNhanVien;
    private LichLamViec lichLamViec;

    

    public NhanVien() {
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public LocalDate getNgayBatDauLamViec() {
        return ngayBatDauLamViec;
    }

    public void setNgayBatDauLamViec(LocalDate ngayBatDauLamViec) {
        this.ngayBatDauLamViec = ngayBatDauLamViec;
    }


    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getTaoBoiMaNhanVien() {
        return taoBoiMaNhanVien;
    }

    public void setTaoBoiMaNhanVien(String taoBoiMaNhanVien) {
        this.taoBoiMaNhanVien = taoBoiMaNhanVien;
    }

    public ChiNhanh getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(ChiNhanh chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public NhanVien getTaoBoiNhanVien() {
        return taoBoiNhanVien;
    }

    public void setTaoBoiNhanVien(NhanVien taoBoiNhanVien) {
        this.taoBoiNhanVien = taoBoiNhanVien;
    }

    public LichLamViec getLichLamViec() {
        return lichLamViec;
    }

    public void setLichLamViec(LichLamViec lichLamViec) {
        this.lichLamViec = lichLamViec;
    }

    public double getNoLuong() {
        return noLuong;
    }

    public void setNoLuong(double noLuong) {
        this.noLuong = noLuong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}

