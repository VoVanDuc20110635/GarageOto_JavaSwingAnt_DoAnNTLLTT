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
public class LichLamViec {
    private String maLichLamViec;
    private LocalDateTime ngayBatDau;
    private LocalDateTime ngayKetThuc;
    private boolean lapLai;
    private String ghiChu;

    public LichLamViec() {
    }

    public LichLamViec(String maLichLamViec, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc, boolean lapLai, String ghiChu) {
        this.maLichLamViec = maLichLamViec;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.lapLai = lapLai;
        this.ghiChu = ghiChu;
    }

    public String getMaLichLamViec() {
        return maLichLamViec;
    }

    public void setMaLichLamViec(String maLichLamViec) {
        this.maLichLamViec = maLichLamViec;
    }

    public LocalDateTime getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDateTime ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDateTime getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDateTime ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public boolean isLapLai() {
        return lapLai;
    }

    public void setLapLai(boolean lapLai) {
        this.lapLai = lapLai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    
}
