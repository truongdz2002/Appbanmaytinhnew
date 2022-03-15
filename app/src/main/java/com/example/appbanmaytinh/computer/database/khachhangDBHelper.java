package com.example.appbanmaytinh.computer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.appbanmaytinh.computer.khachhang;

public class khachhangDBHelper extends SQLiteOpenHelper {
    public static final  String DB_NAME = "quanlymaytinh.db";
    public static final  int DB_VERSION = 1;
    public static final String TB_Name = "tbl_khachhang";
    Context context;
    public khachhangDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // dinh nghĩa cau lenh tao moi bang tbl_khachhang
        String sql = "CREATE TABLE IF NOT EXISTS " + TB_Name + "( Gmail VARCHAR(30) PRIMARY KEY , Password VARCHAR(50) , RePassword VARCHAR(50))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TB_Name;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public boolean insertKH(khachhang khachhang){
        ContentValues contentValues = new ContentValues();
        //put du lieu can insert vao doi tuong contentValues
        contentValues.put("Gmail", khachhang.getGmail());
        contentValues.put("Password", khachhang.getPassword());
        contentValues.put("RePassword", khachhang.getRePassword());
        //lay ra sqliteDatabase de ghi du lieu
        SQLiteDatabase db = getWritableDatabase();
        //String sql = "INSERT INTO " + TB_NAME + " VALUES('" + khachhang.getGmail() + "','" + khachhang.getPassword() + "','" + khachhang.getRePassword() +"')";
        //db.execSQL(sql);

        long result = db.insert(TB_Name, null, contentValues);
        if (result != -1) {
            Toast.makeText(context, "Register successfully!", Toast.LENGTH_LONG).show();
            return true;
        } else {
            Toast.makeText(context, "Register failed !", Toast.LENGTH_LONG).show();
            return false;
        }

    }

//    public void updateKH(khachhang khachhang , int id){
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put("Gmail");
//    }

    public boolean checkKhIsExisted( String khGmail , String khPassword){
        SQLiteDatabase database = getReadableDatabase();
        boolean check = false ;
        String sql = "SELECT * FROM " + TB_Name + " WHERE '" + khGmail + "' = Gmail AND '" + khPassword + "' = Password";
        Cursor cursor= database.rawQuery(sql,null);
        if (cursor.getCount() != 0){
            return true;
        }
        return false;
    }
}
