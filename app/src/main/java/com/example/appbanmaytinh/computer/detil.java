package com.example.appbanmaytinh.computer;

import java.io.Serializable;

public class detil implements Serializable {
    private int hinhpcdetail;
    private String tenpcdetail,Giapcdetail,Soluongmuadetail;

    public detil(int hinhpcdetail, String tenpcdetail, String giapcdetail, String soluongmuadetail) {
        this.hinhpcdetail = hinhpcdetail;
        this.tenpcdetail = tenpcdetail;
        Giapcdetail = giapcdetail;
        Soluongmuadetail = soluongmuadetail;
    }

    public int getHinhpcdetail() {
        return hinhpcdetail;
    }

    public void setHinhpcdetail(int hinhpcdetail) {
        this.hinhpcdetail = hinhpcdetail;
    }

    public String getTenpcdetail() {
        return tenpcdetail;
    }

    public void setTenpcdetail(String tenpcdetail) {
        this.tenpcdetail = tenpcdetail;
    }

    public String getGiapcdetail() {
        return Giapcdetail;
    }

    public void setGiapcdetail(String giapcdetail) {
        Giapcdetail = giapcdetail;
    }

    public String getSoluongmuadetail() {
        return Soluongmuadetail;
    }

    public void setSoluongmuadetail(String soluongmuadetail) {
        Soluongmuadetail = soluongmuadetail;
    }
}
