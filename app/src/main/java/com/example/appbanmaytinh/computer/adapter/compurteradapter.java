package com.example.appbanmaytinh.computer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanmaytinh.Package.home;
import com.example.appbanmaytinh.R;
import com.example.appbanmaytinh.computer.computer;

import java.util.ArrayList;
import java.util.List;

public class compurteradapter extends RecyclerView.Adapter< compurteradapter.compurterViewHolder> {
    private  Context mcontext;
    private List<computer> listcomputer;
    private ItemClick itemClick;
    public interface ItemClick{
        void onclickItem(computer computer);
    }

    public compurteradapter(List<computer> listcomputer,ItemClick listener) {
        this.listcomputer = listcomputer;
        this.itemClick=listener;
    }

    public compurteradapter() {
        this.mcontext = mcontext;
    }
    public void setData(List<computer> list){
        this.listcomputer=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public compurterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new compurterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull compurterViewHolder holder, int position) {
         final computer computer=listcomputer.get(position);
        if(computer==null)
        {
            return;
        }
        holder.anhpc.setImageResource(computer.getHinh());
        holder.anhpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onclickItem(computer);
            }
        });
        holder.tenpc.setText(computer.getTenpc());
        holder.tenpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onclickItem(computer);
            }
        });
        holder.giapc.setText(computer.getGiapc());
        holder.giapc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onclickItem(computer);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(listcomputer!=null)
        {
            return listcomputer.size();
        }
        return 0;
    }

    public class compurterViewHolder extends RecyclerView.ViewHolder{
        private ImageView anhpc;
        private TextView tenpc,giapc;
        public compurterViewHolder(@NonNull View itemView)
        {
            super(itemView);
            anhpc=(ImageView) itemView.findViewById(R.id.anhpc);
            tenpc=(TextView) itemView.findViewById(R.id.tenpc);
            giapc=(TextView) itemView.findViewById(R.id.giapc);

        }

    }
}