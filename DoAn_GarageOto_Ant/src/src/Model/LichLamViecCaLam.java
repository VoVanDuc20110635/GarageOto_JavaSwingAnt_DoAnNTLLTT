/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author WINDOWS 10
 */
public class LichLamViecCaLam {
    private String ma;
    private String maLichLamViec;
    private String maCaLam;
    private boolean hoanThanh;

    public LichLamViecCaLam() {
    }

    public LichLamViecCaLam(String maLichLamViec, String maCaLam) {
        this.maLichLamViec = maLichLamViec;
        this.maCaLam = maCaLam;
    }

    public String getMaLichLamViec() {
        return maLichLamViec;
    }

    public void setMaLichLamViec(String maLichLamViec) {
        this.maLichLamViec = maLichLamViec;
    }

    public String getMaCaLam() {
        return maCaLam;
    }

    public void setMaCaLam(String maCaLam) {
        this.maCaLam = maCaLam;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public boolean isHoanThanh() {
        return hoanThanh;
    }

    public void setHoanThanh(boolean hoanThanh) {
        this.hoanThanh = hoanThanh;
    }
    
    
}
