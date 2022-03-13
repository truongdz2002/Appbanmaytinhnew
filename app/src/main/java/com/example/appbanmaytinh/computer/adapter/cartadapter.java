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
import com.example.appbanmaytinh.computer.cart;

import java.util.List;
public class cartadapter extends RecyclerView.Adapter<cartadapter.cartViewHolder> {
    private Context context;
    private List<cart> listcart;
    /*public cartadapter(List<cart> listcart) {
        this.listcart = listcart;
    }

   // public cartadapter(Context context) {
        this.context = context;
    }*/

    public void setdata(List<cart> list)
    {
        this.listcart=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giohang, parent, false);
        return new cartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {
        cart cart=listcart.get(position);
        if(cart==null)
        {
            return;
        }
        holder.anhspmua.setImageResource(cart.getAnhspmua());
        holder.tenspmua.setText(cart.getTenspmua());
        holder.giaspmua.setText(cart.getGiaspmua());

    }

    @Override
    public int getItemCount() {
        if(listcart!=null)
        {
            return listcart.size();
        }
        return 0;
    }

    public class cartViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView anhspmua;
        private TextView tenspmua;
        private TextView giaspmua;

        public cartViewHolder(@NonNull View itemView) {
            super(itemView);
            anhspmua= (ImageView)itemView.findViewById(R.id.anhspmua);
            tenspmua=(TextView)itemView.findViewById(R.id.tenspmua);
            giaspmua=(TextView)itemView.findViewById(R.id.giaspmua);

        }
    }
}
