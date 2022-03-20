package com.example.appbanmaytinh.computer.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import com.example.appbanmaytinh.computer.inforkhachhang;

import java.util.List;

public class adapterinfor extends ArrayAdapter<inforkhachhang> {
    public adapterinfor(@NonNull Context context, int resource, @NonNull List<inforkhachhang> lstinfor) {
        super(context, 0, lstinfor);
    }
}
