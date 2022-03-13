package com.example.appbanmaytinh.computer.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.appbanmaytinh.computer.cart;

import java.util.List;

@Dao
public interface cart2 {
    @Insert
    void insertcart(cart cart);
    @Query("SELECT * FROM CART")
    List<cart> getListCart();
}
