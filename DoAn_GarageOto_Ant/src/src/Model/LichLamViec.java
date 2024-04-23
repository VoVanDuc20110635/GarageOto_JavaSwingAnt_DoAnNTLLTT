/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author WINDOWS 10
 */
public class LichLamViec {
    private String maLichLamViec;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private boolean nghiLam;
    private String ghiChu;
    private short tangCa;
    private String trangThai;
    private String maNhanVien;
    private List<CaLam> danhSachCaLam;

    public LichLamViec() {
    }

    public String getMaLichLamViec() {
        return maLichLamViec;
    }

    public void setMaLichLamViec(String maLichLamViec) {
        this.maLichLamViec = maLichLamViec;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public boolean isNghiLam() {
        return nghiLam;
    }

    public void setNghiLam(boolean nghiLam) {
        this.nghiLam = nghiLam;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public short getTangCa() {
        return tangCa;
    }

    public void setTangCa(short tangCa) {
        this.tangCa = tangCa;
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

    public List<CaLam> getDanhSachCaLam() {
        return danhSachCaLam;
    }

    public void setDanhSachCaLam(List<CaLam> danhSachCaLam) {
        this.danhSachCaLam = danhSachCaLam;
    }

    

        
    
}
