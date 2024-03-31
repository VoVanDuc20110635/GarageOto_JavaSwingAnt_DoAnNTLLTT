/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author WINDOWS 10
 */
public class HoaDonChiTiet {
    private String maHoaDonChiTiet;
    private short soLuong;
    private double giamGia;
    private double giaBan;
    private double thanhTien;
    private String maHangHoa;
    private String maHoaDon;
    private HangHoa hangHoa;
    private HoaDon hoaDon;
    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHoaDonChiTiet, short soLuong, double giamGia, double giaBan, double thanhTien, String maHangHoa, String maHoaDon) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
        this.maHangHoa = maHangHoa;
        this.maHoaDon = maHoaDon;
    }

    public String getMaHoaDonChiTiet() {
        return maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
    }

    public short getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(short soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
    
    
}
