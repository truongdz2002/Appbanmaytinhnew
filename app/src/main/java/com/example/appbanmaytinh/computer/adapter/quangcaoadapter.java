package com.example.appbanmaytinh.computer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.appbanmaytinh.R;
import com.example.appbanmaytinh.computer.quangcao;

import java.util.List;

public class quangcaoadapter extends PagerAdapter {
    private Context mContext;
    private List<quangcao> mlistquangcao;

    public quangcaoadapter(Context mContext, List<quangcao> mlistquangcao) {
        this.mContext = mContext;
        this.mlistquangcao = mlistquangcao;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        View view=LayoutInflater.from(container.getContext()).inflate(R.layout.item_quangcao, container, false);
        ImageView imgqc=view.findViewById(R.id.quangcao);
        quangcao qc=mlistquangcao.get(position);
        if(qc!=null)
        {
           Glide.with(mContext).load(qc.getQuangcao()).into(imgqc);
        }
        container.addView(view);
        return view;
    }


    @Override
    public int getCount(){
        if(mlistquangcao!=null)
        {
            return mlistquangcao.size();
        }
        return 0;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view ,@NonNull Object object)
    {
        return  view==object;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
