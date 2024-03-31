/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author WINDOWS 10
 */
public class PhuCap {
    private String maPhuCap;
    private String noiDung;
    private double tienPhuCap;

    public PhuCap() {
    }

    public PhuCap(String maPhuCap, String noiDung, double tienPhuCap) {
        this.maPhuCap = maPhuCap;
        this.noiDung = noiDung;
        this.tienPhuCap = tienPhuCap;
    }

    public String getMaPhuCap() {
        return maPhuCap;
    }

    public void setMaPhuCap(String maPhuCap) {
        this.maPhuCap = maPhuCap;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public double getTienPhuCap() {
        return tienPhuCap;
    }

    public void setTienPhuCap(double tienPhuCap) {
        this.tienPhuCap = tienPhuCap;
    }
    
}
