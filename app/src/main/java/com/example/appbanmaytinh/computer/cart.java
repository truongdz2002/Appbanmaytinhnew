package com.example.appbanmaytinh.computer;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "CART")

public class cart {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int anhspmua;
    private String tenspmua;
    private String giaspmua;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public cart(int anhspmua, String tenspmua, String giaspmua) {
        this.anhspmua = anhspmua;
        this.tenspmua = tenspmua;
        this.giaspmua = giaspmua;
    }

    public int getAnhspmua() {
        return anhspmua;
    }

    public void setAnhspmua(int anhspmua) {
        this.anhspmua = anhspmua;
    }

    public String getTenspmua() {
        return tenspmua;
    }

    public void setTenspmua(String tenspmua) {
        this.tenspmua = tenspmua;
    }

    public String getGiaspmua() {
        return giaspmua;
    }

    public void setGiaspmua(String giaspmua) {
        this.giaspmua = giaspmua;
    }
}
