/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

import java.time.LocalDate;

/**
 *
 * @author WINDOWS 10
 */
public class BangLuongNhanVien {
    private String ma;
    private String maBangLuong;
    private String maPhieuLuong;
    private String maLichLamViec;
    private boolean daXuLy;
    private LocalDate thoiGian;
    private String ma_nhan_vien;

    public BangLuongNhanVien() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMaBangLuong() {
        return maBangLuong;
    }

    public void setMaBangLuong(String maBangLuong) {
        this.maBangLuong = maBangLuong;
    }

    public String getMaPhieuLuong() {
        return maPhieuLuong;
    }

    public void setMaPhieuLuong(String maPhieuLuong) {
        this.maPhieuLuong = maPhieuLuong;
    }

    public String getMaLichLamViec() {
        return maLichLamViec;
    }

    public void setMaLichLamViec(String maLichLamViec) {
        this.maLichLamViec = maLichLamViec;
    }

    public boolean isDaXuLy() {
        return daXuLy;
    }

    public void setDaXuLy(boolean daXuLy) {
        this.daXuLy = daXuLy;
    }

    public String getMa_nhan_vien() {
        return ma_nhan_vien;
    }

    public void setMa_nhan_vien(String ma_nhan_vien) {
        this.ma_nhan_vien = ma_nhan_vien;
    }

    public LocalDate getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDate thoiGian) {
        this.thoiGian = thoiGian;
    }

    
}
