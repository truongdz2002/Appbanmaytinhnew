package com.example.appbanmaytinh.Package;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanmaytinh.MainActivity;
import com.example.appbanmaytinh.R;
import com.example.appbanmaytinh.computer.adapter.computeradapter2;
import com.example.appbanmaytinh.computer.computer;
import com.example.appbanmaytinh.computer.database.databaseproduct;

import java.util.ArrayList;
import java.util.List;

public class SanPhamTren1Ty extends Fragment {
    private View view;
    private MainActivity mainActivity;
    private computeradapter2 computeradapter2;
    private RecyclerView lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tren1ty,container,false);
        lv= view.findViewById(R.id.lv);

        mainActivity = (MainActivity) getActivity();
        Context context ;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mainActivity,2);
        lv.setLayoutManager(gridLayoutManager);

        List<computer> listComputer = new ArrayList<>();
        listComputer = databaseproduct.getInstance(mainActivity).product().;
    }
}
