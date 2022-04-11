package com.example.appbanmaytinh.Package;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.appbanmaytinh.MainActivity;
import com.example.appbanmaytinh.R;
import com.example.appbanmaytinh.computer.adapter.compurteradapter;
import com.example.appbanmaytinh.computer.adapter.quangcaoadapter;
import com.example.appbanmaytinh.computer.computer;
import com.example.appbanmaytinh.computer.quangcao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class home extends Fragment  {
    private View view;
    private ViewPager vp;
    private CircleIndicator cr;
    private quangcaoadapter qcadapter;
    private  RecyclerView rcvcomputer;
    private MainActivity mainActivity;
    private compurteradapter adapter;
    private List<quangcao> mlistsquangcao;
    private  Timer mtimer;
    private EditText timkiem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
       view= inflater.inflate(R.layout.home, container, false);
       //phan san pham moi nhat
        mainActivity= (MainActivity) getActivity();
        rcvcomputer=view.findViewById(R.id.lv);
        timkiem=view.findViewById(R.id.tk);
        Context context;
        GridLayoutManager gridLayoutManager=new GridLayoutManager(mainActivity, 2);
        rcvcomputer.setLayoutManager(gridLayoutManager);
        adapter=new compurteradapter(getlistcomputer(), new compurteradapter.ItemClick() {
            @Override
            public void onclickItem(computer computer) {
                mainActivity.gotoDetailFragmet(computer);
            }
        });
        rcvcomputer.setAdapter(adapter);
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(mainActivity,DividerItemDecoration.VERTICAL);
        rcvcomputer.addItemDecoration(itemDecoration);
        setclick();
        // phan chay quang cao
        vp=view.findViewById(R.id.vp);
        cr=view.findViewById(R.id.cr);
        mlistsquangcao=getlistqc();
        qcadapter=new quangcaoadapter(mainActivity,mlistsquangcao);
        vp.setAdapter(qcadapter);
        cr.setViewPager(vp);
        qcadapter.registerDataSetObserver(cr.getDataSetObserver());
        autoSlideImage();
        return view;
    }
    private List<quangcao> getlistqc()
    {
        List<quangcao> list=new ArrayList<>();
        list.add(new quangcao(R.drawable.img));
        list.add(new quangcao(R.drawable.img_1));
        list.add(new quangcao(R.drawable.img_2));
        list.add(new quangcao(R.drawable.img_3));
        list.add(new quangcao(R.drawable.quangcao1));
        return list;
    }
    private void setclick()
    {
        timkiem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_SEARCH)
                {
                    String s=timkiem.getText().toString();
                    adapter.shortmt(s);
                }
                return false;
            }
        });
    }
    private List<computer> getlistcomputer()
    {
        List<computer> list=new ArrayList<>();
        list.add(new computer("ASUS VIVOBOOK PRO 14X OLED","29000000",R.drawable.asus));
        list.add(new computer("ASUS GAMING TUF FA506IHR-HN019W","15000000",R.drawable.asus));
        list.add(new computer("ASUS GAMING TUF FX517ZC-HN079W","30000000",R.drawable.asus));
        list.add(new computer("ASUS VIVOBOOK A415EA-EB1474W","25000000",R.drawable.asus));
        list.add(new computer("ASUS GAMING ROG STRIX G513IM-HN008W","14000000",R.drawable.asus));
        list.add(new computer("ASUS X515EP-EJ405W","27000000",R.drawable.asus));
        list.add(new computer("ASUS ZENBOOK UX425EA-KI883W","17000000",R.drawable.asus));
        list.add(new computer("DELL VOSTRO 3400 (YX51W3)","17000000",R.drawable.dell));
        list.add(new computer("DELL INSPIRON 5415(TX4H61)","24000000",R.drawable.dell));
        list.add(new computer("DELL VOSTRO 3400 (V4I7015W1)","20000000",R.drawable.dell));
        list.add(new computer("DELL VOSTRO 3510 (7T2YC2) ","15000000",R.drawable.dell));
        list.add(new computer("DELL VOSTRO 3400","13000000",R.drawable.dell));
        list.add(new computer("DELL VOSTRO 3510","31000000",R.drawable.dell));
        list.add(new computer("MACBOOK", "25000000", R.drawable.macbook));
        list.add(new computer("MacBook Pro 2021 14 inch Apple M1", "22000000", R.drawable.macbook));
        list.add(new computer("MacBook Pro 2020 13 inch", "25900000", R.drawable.macbook));
        list.add(new computer("Studio Display", "32000000", R.drawable.macbook));
        list.add(new computer("MacBook Pro 14”", "22000000", R.drawable.macbook));
        list.add(new computer("MacBook Air", "34000000", R.drawable.macbook));
        list.add(new computer("MacBook Pro 2020 13 inch Apple M1", "12000000", R.drawable.macbook));
        list.add(new computer("MacBook Pro 2019 13 inch", "21000000", R.drawable.macbook));
        list.add(new computer("MacBook Pro 2018 13 inch", "29000000", R.drawable.macbook));
        list.add(new computer("MacBook Pro 2019 16 inch", "30000000", R.drawable.macbook));
        list.add(new computer("MacBook Pro 2018 15 inch", "20000000", R.drawable.macbook));
        list.add(new computer("MacBook Pro 2019 16 inch", "31000000", R.drawable.macbook));
        return list;
    }
    private void autoSlideImage()
    {
        if(mlistsquangcao==null||mlistsquangcao.isEmpty()||vp==null)
        {
            return;
        }
        if(mtimer==null)
        {
            mtimer=new Timer();
        }
        mtimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem=vp.getCurrentItem();
                        int totalItem=mlistsquangcao.size()-1;
                        if(currentItem <totalItem)
                        {
                            currentItem++;
                            vp.setCurrentItem(currentItem);

                        }
                        else
                        {
                            vp.setCurrentItem(0);

                        }
                    }
                });
            }
        },    1000,5000);
    }


}
