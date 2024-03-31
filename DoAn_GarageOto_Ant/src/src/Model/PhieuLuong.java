/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author WINDOWS 10
 */
public class PhieuLuong {
    private String maPhieu;
    private String kyViecLam;
    private double daTra;
    private double luongCung;
    private double giamLuong;
    private double luongThuong;
    private double tongLuong;
    private String trangThai;
    private String maNhanVien;
    private NhanVien nhanVien;

    public PhieuLuong(String maPhieu, String kyViecLam, double daTra, double luongCung, double giamLuong, double luongThuong, double tongLuong, String trangThai, String maNhanVien) {
        this.maPhieu = maPhieu;
        this.kyViecLam = kyViecLam;
        this.daTra = daTra;
        this.luongCung = luongCung;
        this.giamLuong = giamLuong;
        this.luongThuong = luongThuong;
        this.tongLuong = tongLuong;
        this.trangThai = trangThai;
        this.maNhanVien = maNhanVien;
    }

    public PhieuLuong() {
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getKyViecLam() {
        return kyViecLam;
    }

    public void setKyViecLam(String kyViecLam) {
        this.kyViecLam = kyViecLam;
    }

    public double getDaTra() {
        return daTra;
    }

    public void setDaTra(double daTra) {
        this.daTra = daTra;
    }

    public double getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(double luongCung) {
        this.luongCung = luongCung;
    }

    public double getGiamLuong() {
        return giamLuong;
    }

    public void setGiamLuong(double giamLuong) {
        this.giamLuong = giamLuong;
    }

    public double getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(double luongThuong) {
        this.luongThuong = luongThuong;
    }

    public double getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(double tongLuong) {
        this.tongLuong = tongLuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
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
