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

public class ASUS extends Fragment {
    private View view;
    private MainActivity nmainActivity;
    private computeradapter2 adapter2;
    private RecyclerView lv1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.asus, container, false);
        lv1=view.findViewById(R.id.lv1);
        nmainActivity=(MainActivity) getActivity();
        Context context;
        GridLayoutManager gridLayoutManager2=new GridLayoutManager(nmainActivity, 1);
        lv1.setLayoutManager(gridLayoutManager2);

        //insertMultipleAsus();
        List<computer> listComputer = new ArrayList<>();
        listComputer = databaseproduct.getInstance(nmainActivity).product().getProductsBrand("ASUS");

        computeradapter2 adapter2 =new computeradapter2(listComputer, new compurteradapter.ItemClick() {
            @Override
            public void onclickItem(computer computer) {
                nmainActivity.gotoDetailFragmet(computer);
            }
        });
        lv1.setAdapter(adapter2);
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(nmainActivity,DividerItemDecoration.VERTICAL);
        lv1.addItemDecoration(itemDecoration);
        return view;
    }

    private void insertMultipleAsus() {
        List<computer> list2=new ArrayList<>(); list2.add(new computer("ASUS","14000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS VIVOBOOK PRO 14X OLED","29000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS GAMING TUF FA506IHR-HN019W","15000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS GAMING TUF FX517ZC-HN079W","30000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS VIVOBOOK A415EA-EB1474W","25000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS GAMING ROG STRIX G513IM-HN008W","14000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS X515EP-EJ405W","27000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS ZENBOOK UX425EA-KI883W","17000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS X415EA-EB640T","26000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS GAMING TUF FX506HCB-HN1138W","39000000",R.drawable.asus,"ASUS"));
        list2.add(new computer("LAPTOP ASUS ZENBOOK UX325EA-KG656W","35000000",R.drawable.asus,"ASUS"));

        databaseproduct.getInstance(nmainActivity).product().insertMultipleProducts(list2);
    }

}
