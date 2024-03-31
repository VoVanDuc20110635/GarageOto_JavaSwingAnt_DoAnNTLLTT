/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author WINDOWS 10
 */
public class HinhAnh {
    private String maHinhAnh;
    private String tenHinh;
    private String noiDung;
    private String maHangHoa;
    private String maNhanVien;
    private HangHoa hangHoa;
    private NhanVien nhanVien;

    public HinhAnh() {
    }

    public HinhAnh(String maHinhAnh, String tenHinh, String noiDung, String maHangHoa, String maNhanVien) {
        this.maHinhAnh = maHinhAnh;
        this.tenHinh = tenHinh;
        this.noiDung = noiDung;
        this.maHangHoa = maHangHoa;
        this.maNhanVien = maNhanVien;
    }

    public String getMaHinhAnh() {
        return maHinhAnh;
    }

    public void setMaHinhAnh(String maHinhAnh) {
        this.maHinhAnh = maHinhAnh;
    }

    public String getTenHinh() {
        return tenHinh;
    }

    public void setTenHinh(String tenHinh) {
        this.tenHinh = tenHinh;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
    
    

}
