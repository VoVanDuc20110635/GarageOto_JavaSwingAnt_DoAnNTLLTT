/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author WINDOWS 10
 */
public class HangHoa {
    private String maHangHoa;
    private String tenHangHoa;
    private double giaBan;
    private double giaVon;
    private short tonKho;
    private short khachDat;
    private String maNhomHang;
    private NhomHang nhomHang;
    private String loaiHang;
    private int trangThai;

    public HangHoa() {
    }

    public HangHoa(String maHangHoa, String tenHangHoa, double giaBan, double giaVon, short tonKho, short khachDat, String maNhomHang) {
        this.maHangHoa = maHangHoa;
        this.tenHangHoa = tenHangHoa;
        this.giaBan = giaBan;
        this.giaVon = giaVon;
        this.tonKho = tonKho;
        this.khachDat = khachDat;
        this.maNhomHang = maNhomHang;
    }

    public String getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(double giaVon) {
        this.giaVon = giaVon;
    }

    public short getTonKho() {
        return tonKho;
    }

    public void setTonKho(short tonKho) {
        this.tonKho = tonKho;
    }

    public short getKhachDat() {
        return khachDat;
    }

    public void setKhachDat(short khachDat) {
        this.khachDat = khachDat;
    }

    public String getMaNhomHang() {
        return maNhomHang;
    }

    public void setMaNhomHang(String maNhomHang) {
        this.maNhomHang = maNhomHang;
    }

    public NhomHang getNhomHang() {
        return nhomHang;
    }

    public void setNhomHang(NhomHang nhomHang) {
        this.nhomHang = nhomHang;
    }

    public String getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
