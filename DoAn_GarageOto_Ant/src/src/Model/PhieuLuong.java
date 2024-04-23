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
public class PhieuLuong {
    private String maPhieu;
    private double daTra;
    private double tongLuong;
    private LocalDateTime ngayIn;
    private String maNhanVienIn;
    private String maNhanVien;

    public PhieuLuong() {
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public double getDaTra() {
        return daTra;
    }

    public void setDaTra(double daTra) {
        this.daTra = daTra;
    }

    public double getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(double tongLuong) {
        this.tongLuong = tongLuong;
    }

    public LocalDateTime getNgayIn() {
        return ngayIn;
    }

    public void setNgayIn(LocalDateTime ngayIn) {
        this.ngayIn = ngayIn;
    }

    public String getMaNhanVienIn() {
        return maNhanVienIn;
    }

    public void setMaNhanVienIn(String maNhanVienIn) {
        this.maNhanVienIn = maNhanVienIn;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

     
}
