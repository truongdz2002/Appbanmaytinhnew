package com.example.appbanmaytinh.computer.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.appbanmaytinh.computer.inforkhachhang;

import java.net.ContentHandler;

@Database(entities = {inforkhachhang.class},version = 1)
public abstract class databaseinfor extends RoomDatabase {
    private final static String DATABASE_NAME="inforkh.db";
    private static databaseinfor instance;

    public static synchronized databaseinfor getInstance(Context context) {


        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),databaseinfor.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract infor infor();
}
