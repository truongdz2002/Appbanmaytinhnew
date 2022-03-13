package com.example.appbanmaytinh.computer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanmaytinh.R;
import com.example.appbanmaytinh.computer.computer;

import java.util.List;

public class computeradapter2 extends RecyclerView.Adapter<computeradapter2.computer2ViewHolder>{
    private Context ncontext;
    private List<computer> list2computer;
    private compurteradapter.ItemClick itemClick;
    public interface ItemClick{
        void onclickItem(computer computer);
    }


    public computeradapter2(List<computer> list2computer, compurteradapter.ItemClick listener) {
        this.list2computer = list2computer;
        this.itemClick=listener;

    }
    public computeradapter2(){
        this.ncontext=ncontext;
    }
    public void setdata(List<computer> list2){
        this.list2computer=list2;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public computer2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_computer, parent, false);
        return new computer2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull computer2ViewHolder holder, int position) {
        final computer computer=list2computer.get(position);
        if(computer==null)
        {
            return;
        }
        holder.pc1.setImageResource(computer.getHinh());
        holder.pc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onclickItem(computer);
            }
        });
        holder.tv1.setText(computer.getTenpc());
        holder.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onclickItem(computer);
            }
        });
        holder.tv2.setText(computer.getGiapc());
        holder.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onclickItem(computer);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list2computer!=null)
        {
            return list2computer.size();
        }
        return 0;
    }

    public class computer2ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView pc1;
        private TextView tv1;
        private TextView tv2;
        public computer2ViewHolder(@NonNull View itemView) {
            super(itemView);
            pc1=itemView.findViewById(R.id.pc1);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
        }
    }
}
