package com.example.appbanmaytinh.computer;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "COMPUTER")
public class computer implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String tenpc;
    private String giapc;
    private int hinh;
    private String brand;

    public computer() {

    }

    public computer(String tenpc, String giapc, int hinh, String brand) {
        this.tenpc = tenpc;
        this.giapc = giapc;
        this.hinh = hinh;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
