package com.example.appbanmaytinh.Package;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

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

public class DELL extends Fragment {
    private View view;
    private MainActivity nmainActivity;
    private computeradapter2 adapter2;
    private RecyclerView lv2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.dell, container, false);
        lv2=view.findViewById(R.id.lv2);
        nmainActivity=(MainActivity) getActivity();
        Context context;
        GridLayoutManager gridLayoutManager2=new GridLayoutManager(nmainActivity, 1);
        lv2.setLayoutManager(gridLayoutManager2);

        //insertMultipleDell();
        List<computer> listComputer = new ArrayList<>();
        listComputer = databaseproduct.getInstance(nmainActivity).product().getProductsBrand("DELL");

        computeradapter2 adapter2 = new computeradapter2(listComputer, new compurteradapter.ItemClick() {
            @Override
            public void onclickItem(computer computer) {
                nmainActivity.gotoDetailFragmet(computer);
            }
        });
        lv2.setAdapter(adapter2);
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(nmainActivity,DividerItemDecoration.VERTICAL);
        lv2.addItemDecoration(itemDecoration);
        return view;
    }

    private void insertMultipleDell() {
        List<computer> list2=new ArrayList<>();
        list2.add(new computer("LAPTOP DELL VOSTRO 3400 (YX51W3)","17000000",R.drawable.dell,"DELL"));
        list2.add(new computer("LAPTOP DELL INSPIRON 5415(TX4H61)","24000000",R.drawable.dell,"DELL"));
        list2.add(new computer("LAPTOP DELL VOSTRO 3400 (V4I7015W1)","20000000",R.drawable.dell,"DELL"));
        list2.add(new computer("LAPTOP DELL VOSTRO 3510 (7T2YC2) ","15000000",R.drawable.dell,"DELL"));
        list2.add(new computer("LAPTOP DELL VOSTRO 3400","13000000",R.drawable.dell,"DELL"));
        list2.add(new computer("LAPTOP DELL VOSTRO 3510","31000000",R.drawable.dell,"DELL"));
        list2.add(new computer("LAPTOP DELL VOSTRO 5310 (YV5WY5)","39000000",R.drawable.dell,"DELL"));
        list2.add(new computer("LAPTOP DELL INSPIRON 3511 (5101BLK) ","11000000",R.drawable.dell,"DELL"));
        list2.add(new computer("LAPTOP DELL VOSTRO 5410 (V4I5214W1)","27000000",R.drawable.dell,"DELL"));
        list2.add(new computer("LAPTOP DELL INSPIRON 5410 2 IN 1 (5149SLV) ","99000000",R.drawable.dell,"DELL"));

        databaseproduct.getInstance(nmainActivity).product().insertMultipleProducts(list2);


        ;
    }
}
