package com.example.appbanmaytinh.computer.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.appbanmaytinh.computer.cart;
import com.example.appbanmaytinh.computer.computer;


@Database(entities = {computer.class}, version = 1)
public abstract class databaseproduct extends RoomDatabase {
    private static final String DATABASE_NAME = "product.db";
    private static databaseproduct instance;

    public static synchronized databaseproduct getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), databaseproduct.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;

    }

    public abstract product product();
}
