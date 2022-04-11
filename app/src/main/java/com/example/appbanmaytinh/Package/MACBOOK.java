package com.example.appbanmaytinh.Package;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanmaytinh.MainActivity;
import com.example.appbanmaytinh.R;
import com.example.appbanmaytinh.computer.adapter.compurteradapter;
import com.example.appbanmaytinh.computer.adapter.computeradapter2;
import com.example.appbanmaytinh.computer.computer;

import com.example.appbanmaytinh.computer.database.databaseproduct;

import java.util.ArrayList;
import java.util.List;

public class MACBOOK extends Fragment {
    private View view;
    private MainActivity nmainActivity;
    private computeradapter2 adapter2;
    private RecyclerView lv3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.macbook, container, false);
        lv3 = view.findViewById(R.id.lv3);
        nmainActivity = (MainActivity) getActivity();
        Context context;
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(nmainActivity, 1);
        lv3.setLayoutManager(gridLayoutManager2);

        //insertMultipleMacbook();
        List<computer> listComputer = new ArrayList<>();
        listComputer = databaseproduct.getInstance(nmainActivity).product().getProductsBrand("Apple");
        computeradapter2 adapter2 = new computeradapter2(listComputer, new compurteradapter.ItemClick() {
            @Override
            public void onclickItem(computer computer) {
                nmainActivity.gotoDetailFragmet(computer);
            }
        });
        lv3.setAdapter(adapter2);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(nmainActivity, DividerItemDecoration.VERTICAL);
        lv3.addItemDecoration(itemDecoration);
        return view;
    }

    private void insertMultipleMacbook() {
        List<computer> list2 = new ArrayList<>();
        list2.add(new computer("MACBOOK", "25000000", R.drawable.macbook ,"Apple"));
        list2.add(new computer("MacBook Pro 2021 14 inch Apple M1", "22000000", R.drawable.macbook,"Apple"));
        list2.add(new computer("MacBook Pro 2020 13 inch", "25900000", R.drawable.macbook,"Apple"));
        list2.add(new computer("Studio Display", "32000000", R.drawable.macbook,"Apple"));
        list2.add(new computer("MacBook Pro 14”", "22000000", R.drawable.macbook,"Apple"));
        list2.add(new computer("MacBook Air", "34000000", R.drawable.macbook,"Apple"));
        list2.add(new computer("MacBook Pro 2020 13 inch Apple M1", "12000000", R.drawable.macbook,"Apple"));
        list2.add(new computer("MacBook Pro 2019 13 inch", "21000000", R.drawable.macbook,"Apple"));
        list2.add(new computer("MacBook Pro 2018 13 inch", "29000000", R.drawable.macbook,"Apple"));
        list2.add(new computer("MacBook Pro 2019 16 inch", "30000000", R.drawable.macbook,"Apple"));
        list2.add(new computer("MacBook Pro 2018 15 inch", "20000000", R.drawable.macbook,"Apple"));
        list2.add(new computer("MacBook Pro 2019 16 inch", "31000000", R.drawable.macbook,"Apple"));

        databaseproduct.getInstance(nmainActivity).product().insertMultipleProducts(list2);



    }
}
