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
public class TheKho {
    private String maTheKho;
    private String phuongThuc;
    private LocalDateTime thoiGian;
    private double giaVon;
    private short soLuong;
    private short soLuongThucTe;    
    private short tonCuoi;
    private String maHangHoa;
    private String maKhachHang;
    private String maNhanVien;
    private String maNhaCungCap;
    private HangHoa hangHoa;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private NhaCungCap nhaCungCap;

    public TheKho() {
    }

    public TheKho(String maTheKho, String phuongThuc, LocalDateTime thoiGian, double giaVon, short soLuong, short soLuongThucTe, short tonCuoi, String maHangHoa, String maKhachHang, String maNhanVien, String maNhaCungCap) {
        this.maTheKho = maTheKho;
        this.phuongThuc = phuongThuc;
        this.thoiGian = thoiGian;
        this.giaVon = giaVon;
        this.soLuong = soLuong;
        this.soLuongThucTe = soLuongThucTe;
        this.tonCuoi = tonCuoi;
        this.maHangHoa = maHangHoa;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaTheKho() {
        return maTheKho;
    }

    public void setMaTheKho(String maTheKho) {
        this.maTheKho = maTheKho;
    }

    public String getPhuongThuc() {
        return phuongThuc;
    }

    public void setPhuongThuc(String phuongThuc) {
        this.phuongThuc = phuongThuc;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
        this.thoiGian = thoiGian;
    }

    public double getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(double giaVon) {
        this.giaVon = giaVon;
    }

    public short getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(short soLuong) {
        this.soLuong = soLuong;
    }

    public short getSoLuongThucTe() {
        return soLuongThucTe;
    }

    public void setSoLuongThucTe(short soLuongThucTe) {
        this.soLuongThucTe = soLuongThucTe;
    }

    public short getTonCuoi() {
        return tonCuoi;
    }

    public void setTonCuoi(short tonCuoi) {
        this.tonCuoi = tonCuoi;
    }

    public String getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    
}
