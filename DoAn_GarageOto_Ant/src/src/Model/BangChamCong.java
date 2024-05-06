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
public class BangChamCong {
    private String maBangChamCong;
    private LocalDate ngayLam;
    private String trangThai;
    
    private String maNhanVien;
    
    private NhanVien nhanVien;
    private CaLam caLam;

    public BangChamCong() {
    }

    public BangChamCong(String maBangChamCong, LocalDate ngayLam, String trangThai, short gioTangCa, String maNhanVien, String maCaLam) {
        this.maBangChamCong = maBangChamCong;
        this.ngayLam = ngayLam;
        this.trangThai = trangThai;
        
        this.maNhanVien = maNhanVien;
        
    }

    public String getMaBangChamCong() {
        return maBangChamCong;
    }

    public void setMaBangChamCong(String maBangChamCong) {
        this.maBangChamCong = maBangChamCong;
    }

    public LocalDate getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(LocalDate ngayLam) {
        this.ngayLam = ngayLam;
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

    public CaLam getCaLam() {
        return caLam;
    }

    public void setCaLam(CaLam caLam) {
        this.caLam = caLam;
    }
    
    
}
