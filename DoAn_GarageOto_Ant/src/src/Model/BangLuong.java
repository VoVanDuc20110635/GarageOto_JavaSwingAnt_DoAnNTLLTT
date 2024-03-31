/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Model;

/**
 *
 * @author WINDOWS 10
 */
public class BangLuong {
    private String maBangLuong;
    private String cheDoLuong;
    private double tienLuong;
    private double phuCap;
    private double tongLuong;

    public BangLuong() {
    }

    public BangLuong(String maBangLuong, String cheDoLuong, double tienLuong, double phuCap, double tongLuong) {
        this.maBangLuong = maBangLuong;
        this.cheDoLuong = cheDoLuong;
        this.tienLuong = tienLuong;
        this.phuCap = phuCap;
        this.tongLuong = tongLuong;
    }

    public String getMaBangLuong() {
        return maBangLuong;
    }

    public void setMaBangLuong(String maBangLuong) {
        this.maBangLuong = maBangLuong;
    }

    public String getCheDoLuong() {
        return cheDoLuong;
    }

    public void setCheDoLuong(String cheDoLuong) {
        this.cheDoLuong = cheDoLuong;
    }

    public double getTienLuong() {
        return tienLuong;
    }

    public void setTienLuong(double tienLuong) {
        this.tienLuong = tienLuong;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public double getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(double tongLuong) {
        this.tongLuong = tongLuong;
    }
    
    
}
