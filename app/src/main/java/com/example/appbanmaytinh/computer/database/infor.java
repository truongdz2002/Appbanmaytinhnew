package com.example.appbanmaytinh.computer.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.appbanmaytinh.computer.inforkhachhang;

import java.util.List;
@Dao
public interface infor {
    @Insert
    public abstract void insertkh(inforkhachhang kh);
    @Query("SELECT * FROM INFORKHACHHANG")
    public abstract List<inforkhachhang> getListkh();
}
