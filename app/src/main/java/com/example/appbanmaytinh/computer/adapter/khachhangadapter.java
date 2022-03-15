package com.example.appbanmaytinh.computer.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appbanmaytinh.computer.khachhang;

import java.util.ArrayList;

public class khachhangadapter extends ArrayAdapter<khachhang> {

    public khachhangadapter(@NonNull Context context, ArrayList<khachhang> lstKH) {
        super(context, 0,lstKH);
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View currentView = convertView;
//        if(currentView == null){
//
//        }
//        return super.getView(position, convertView, parent);
//    }
}
