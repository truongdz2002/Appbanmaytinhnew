package com.example.appbanmaytinh.computer.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.appbanmaytinh.computer.computer;

import java.util.List;

@Dao
public interface product {
    @Insert
    void insertProduct(computer computer);

    @Insert
    void insertMultipleProducts(List<computer> computerList);

    @Query("SELECT * FROM COMPUTER")
    List<computer> getAllProducts();

    @Query("SELECT * FROM COMPUTER WHERE brand = :brand")
    List<computer> getProductsBrand(String brand);

    @Query("SELECT * FROM COMPUTER WHERE tenpc LIKE '%' || :name || '%'")
    List<computer> searchProduct(String name);
}
