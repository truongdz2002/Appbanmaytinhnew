package com.example.appbanmaytinh.computer.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.appbanmaytinh.computer.cart;

@Database(entities = {cart.class},version = 2)
public abstract class databasecart extends RoomDatabase {
    private static final String DATABASE_NAME="cart.db";
    private static databasecart instance;

    static Migration migrationCart_from_1_to_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE CART ADD COLUMN userGmail TEXT");
        }
    };

    public static synchronized databasecart getInstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),databasecart.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .addMigrations(migrationCart_from_1_to_2)
                    .build();
        }
        return instance;

    }
    public abstract cart2 cart2();
}
