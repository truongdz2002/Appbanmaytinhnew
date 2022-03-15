package com.example.appbanmaytinh.computer;

public class khachhang {
    public String gmail , password , rePassword;
    public int id;

    public khachhang() {
    }

    public khachhang(String gmail, String password, String rePassword) {
        this.gmail = gmail;
        this.password = password;
        this.rePassword = rePassword;
//        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
