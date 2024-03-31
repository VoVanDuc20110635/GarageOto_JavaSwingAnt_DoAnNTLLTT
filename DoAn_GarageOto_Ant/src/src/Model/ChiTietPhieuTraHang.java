/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author WINDOWS 10
 */
public class ChiTietPhieuTraHang {
    private String maChiTietPhieuTraHang;
    private short soLuong;
    private double giaTraHang;
    private double thanhTien;
    private String maHangHoa;
    private String maPhieuTraHang;
    private HangHoa hangHoa;
    private PhieuTraHang phieuTraHang;

    public ChiTietPhieuTraHang() {
    }

    public ChiTietPhieuTraHang(String maChiTietPhieuTraHang, short soLuong, double giaTraHang, double thanhTien, String maHangHoa, String maPhieuTraHang) {
        this.maChiTietPhieuTraHang = maChiTietPhieuTraHang;
        this.soLuong = soLuong;
        this.giaTraHang = giaTraHang;
        this.thanhTien = thanhTien;
        this.maHangHoa = maHangHoa;
        this.maPhieuTraHang = maPhieuTraHang;
    }

    public String getMaChiTietPhieuTraHang() {
        return maChiTietPhieuTraHang;
    }

    public void setMaChiTietPhieuTraHang(String maChiTietPhieuTraHang) {
        this.maChiTietPhieuTraHang = maChiTietPhieuTraHang;
    }

    public short getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(short soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTraHang() {
        return giaTraHang;
    }

    public void setGiaTraHang(double giaTraHang) {
        this.giaTraHang = giaTraHang;
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

    public String getMaPhieuTraHang() {
        return maPhieuTraHang;
    }

    public void setMaPhieuTraHang(String maPhieuTraHang) {
        this.maPhieuTraHang = maPhieuTraHang;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public PhieuTraHang getPhieuTraHang() {
        return phieuTraHang;
    }

    public void setPhieuTraHang(PhieuTraHang phieuTraHang) {
        this.phieuTraHang = phieuTraHang;
    }
    
    
    
}
