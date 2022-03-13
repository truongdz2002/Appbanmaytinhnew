package com.example.appbanmaytinh.computer;

import java.io.Serializable;

public class computer implements Serializable {
    private String tenpc;
    private String giapc;
    private int hinh;
    public computer(){

    }
    public computer(String tenpc, String giapc, int hinh) {
        this.tenpc = tenpc;
        this.giapc = giapc;
        this.hinh = hinh;
    }

    public String getTenpc() {
        return tenpc;
    }

    public void setTenpc(String tenpc) {
        this.tenpc = tenpc;
    }

    public String getGiapc() {
        return giapc;
    }

    public void setGiapc(String giapc) {
        this.giapc = giapc;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
