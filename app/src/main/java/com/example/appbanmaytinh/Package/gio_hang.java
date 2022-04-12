package com.example.appbanmaytinh.Package;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.appbanmaytinh.computer.detil;

import com.example.appbanmaytinh.MainActivity;
import com.example.appbanmaytinh.R;
import com.example.appbanmaytinh.computer.adapter.cartadapter;
import com.example.appbanmaytinh.computer.cart;
import com.example.appbanmaytinh.computer.computer;
import com.example.appbanmaytinh.computer.database.databasecart;

import java.util.ArrayList;
import java.util.List;

public class gio_hang extends Fragment {

    private View view;
    private MainActivity nmainActivity;
    private cartadapter adapter;
    private RecyclerView lv4;
    private TextView tt;
    private List<cart> mlistcart;

    private String gmail;

    public gio_hang(String gmail) {
        this.gmail = gmail;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gio_hang, container, false);
       nmainActivity=(MainActivity) getActivity();
       lv4=view.findViewById(R.id.lv4);
       tt=view.findViewById(R.id.tt);


       /*//Co ban voi gio hang
        adapter=new cartadapter(getlistcart());
        lv4.setAdapter(adapter);*/
        adapter =new cartadapter(new cartadapter.ItemClick() {
            @Override
            public void deleteclick(cart cart ) {
                nmainActivity.deleteFragment(cart);
                long totalCartPrice = databasecart.getInstance(nmainActivity).cart2().getTotalCartPrice(gmail);

                tt.setText("Tổng tiền: " + totalCartPrice);
                lv4.getAdapter().notifyDataSetChanged();
                reload();

            }
        });
        mlistcart=new ArrayList<>();
        reload();
        addlv4();
        lv4.setAdapter(adapter);

       GridLayoutManager gridLayoutManager=new GridLayoutManager(nmainActivity,1);
       lv4.setLayoutManager(gridLayoutManager);
       RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(nmainActivity,DividerItemDecoration.VERTICAL);
       lv4.addItemDecoration(itemDecoration);

        long totalCartPrice = databasecart.getInstance(nmainActivity).cart2().getTotalCartPrice(gmail);

        tt.setText("Tổng tiền: " + totalCartPrice);
        return view;
    }
    /*//Co ban voi gio hang
    public List<cart> getlistcart()

    {
        List<cart> list=new ArrayList<>();
        Bundle bundle=getArguments();

        if(bundle!=null)

        {
            detil detil=(detil) bundle.get("detail");
            int gia=Integer.parseInt(detil.getGiapcdetail().toString());
            int sl=Integer.parseInt(detil.getSoluongmuadetail().toString());
            int t=0;
              t=gia*sl;
              String tt=Integer.toString(t);
            if(detil!=null){
                list.add(new cart(detil.getHinhpcdetail(),detil.getTenpcdetail(), detil.getGiapcdetail(), detil.getSoluongmuadetail(),tt));
                Toast.makeText(nmainActivity,"thanhcong",Toast.LENGTH_SHORT).show();
            }

        }

        return list;

    }*/


        public void addlv4() {

            Bundle bundle = getArguments();

            if (bundle != null) {
                detil detil = (detil) bundle.get("detail");
                int gia = Integer.parseInt(detil.getGiapcdetail().toString());
                int sl = Integer.parseInt(detil.getSoluongmuadetail().toString());
                int t = 0;
                t = gia * sl;
                String tt = Integer.toString(t);
                cart cart = new cart(detil.getHinhpcdetail(), detil.getTenpcdetail(), detil.getGiapcdetail(), detil.getSoluongmuadetail(), tt,gmail);
                databasecart.getInstance(nmainActivity).cart2().insertcart(cart);
                Toast.makeText(nmainActivity, "Đã nhận hàng muốn mua thành công", Toast.LENGTH_SHORT).show();
                reload();
            }
        }
        public void reload()
        {
            //mlistcart = databasecart.getInstance(nmainActivity).cart2().getListCart();
            mlistcart = databasecart.getInstance(nmainActivity).cart2().getListUserCart(gmail);
            adapter.setdata(mlistcart);
        }
        }



