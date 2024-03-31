/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author WINDOWS 10
 */
public class ChiTietPhieuNhapHang {
    private String maChiTietPhieuNhapHang;
    private String maHangHoa;
    private short so_luong;
    private double gia_nhap;
    private double tong;
    private double giam_gia;
    private double thanh_tien;
    private String maPhieuNhapHang;
    private HangHoa hangHoa;
    private PhieuNhapHang phieuNhapHang;

    public ChiTietPhieuNhapHang() {
    }

    public ChiTietPhieuNhapHang(String maChiTietPhieuNhapHang, String maHangHoa, short so_luong, double gia_nhap, double tong, double giam_gia, double thanh_tien) {
        this.maChiTietPhieuNhapHang = maChiTietPhieuNhapHang;
        this.maHangHoa = maHangHoa;
        this.so_luong = so_luong;
        this.gia_nhap = gia_nhap;
        this.tong = tong;
        this.giam_gia = giam_gia;
        this.thanh_tien = thanh_tien;
    }

    public String getMaChiTietPhieuNhapHang() {
        return maChiTietPhieuNhapHang;
    }

    public void setMaChiTietPhieuNhapHang(String maChiTietPhieuNhapHang) {
        this.maChiTietPhieuNhapHang = maChiTietPhieuNhapHang;
    }

    public String getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public short getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(short so_luong) {
        this.so_luong = so_luong;
    }

    public double getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(double gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public double getTong() {
        return tong;
    }

    public void setTong(double tong) {
        this.tong = tong;
    }

    public double getGiam_gia() {
        return giam_gia;
    }

    public void setGiam_gia(double giam_gia) {
        this.giam_gia = giam_gia;
    }

    public double getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(double thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public String getMaPhieuNhapHang() {
        return maPhieuNhapHang;
    }

    public void setMaPhieuNhapHang(String maPhieuNhapHang) {
        this.maPhieuNhapHang = maPhieuNhapHang;
    }

    public PhieuNhapHang getPhieuNhapHang() {
        return phieuNhapHang;
    }

    public void setPhieuNhapHang(PhieuNhapHang phieuNhapHang) {
        this.phieuNhapHang = phieuNhapHang;
    }
    
}
