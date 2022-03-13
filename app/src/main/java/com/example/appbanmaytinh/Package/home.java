package com.example.appbanmaytinh.Package;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
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
    private List<quangcao> mlistsquangcao;
    private  Timer mtimer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
       view= inflater.inflate(R.layout.home, container, false);
       //phan san pham moi nhat
        mainActivity= (MainActivity) getActivity();
        rcvcomputer=view.findViewById(R.id.lv);
        Context context;
        GridLayoutManager gridLayoutManager=new GridLayoutManager(mainActivity, 2);
        rcvcomputer.setLayoutManager(gridLayoutManager);
        compurteradapter adapter=new compurteradapter(getlistcomputer(), new compurteradapter.ItemClick() {
            @Override
            public void onclickItem(computer computer) {
                mainActivity.gotoDetailFragmet(computer);
            }
        });
        rcvcomputer.setAdapter(adapter);
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(mainActivity,DividerItemDecoration.VERTICAL);
        rcvcomputer.addItemDecoration(itemDecoration);
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


    private List<computer> getlistcomputer()
    {
        List<computer> list=new ArrayList<>();
        list.add(new computer("ASUS","14000000",R.drawable.asus));
        list.add(new computer("ASUS","14000000",R.drawable.asus));
        list.add(new computer("ASUS","14000000",R.drawable.asus));
        list.add(new computer("ASUS","14000000",R.drawable.asus));
        list.add(new computer("ASUS","14000000",R.drawable.asus));
        list.add(new computer("ASUS","14000000",R.drawable.asus));
        list.add(new computer("ASUS","14000000",R.drawable.asus));
        list.add(new computer("DELL","17000000",R.drawable.dell));
        list.add(new computer("DELL","17000000",R.drawable.dell));
        list.add(new computer("DELL","17000000",R.drawable.dell));
        list.add(new computer("DELL","17000000",R.drawable.dell));
        list.add(new computer("DELL","17000000",R.drawable.dell));
        list.add(new computer("MACBOOK","25000000",R.drawable.macbook));
        list.add(new computer("MACBOOK","25000000",R.drawable.macbook));
        list.add(new computer("MACBOOK","25000000",R.drawable.macbook));
        list.add(new computer("MACBOOK","25000000",R.drawable.macbook));
        list.add(new computer("MACBOOK","25000000",R.drawable.macbook));
        list.add(new computer("MACBOOK","25000000",R.drawable.macbook));
        list.add(new computer("MACBOOK","25000000",R.drawable.macbook));
        list.add(new computer("MACBOOK","25000000",R.drawable.macbook));


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
