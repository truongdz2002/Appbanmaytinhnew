package com.example.appbanmaytinh.computer.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.appbanmaytinh.computer.cart;

@Database(entities = {cart.class},version = 1)
public abstract class databasecart extends RoomDatabase {
    private static final String DATABASE_NAME="cart.db";
    private static databasecart instance;
    public static synchronized databasecart getInstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),databasecart.class,DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;

    }
    public abstract cart2 cart2();
}
