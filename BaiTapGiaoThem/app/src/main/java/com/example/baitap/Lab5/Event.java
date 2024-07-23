package com.example.baitap.Lab5;

public class Event {
    private String tieude;
    private String ngay;
    private String ghichu;

    public Event(String tieude, String ngay, String ghichu) {
        this.tieude = tieude;
        this.ngay = ngay;
        this.ghichu = ghichu;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
