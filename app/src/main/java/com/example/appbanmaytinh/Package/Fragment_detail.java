package com.example.appbanmaytinh.Package;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbanmaytinh.computer.computer;
import com.example.appbanmaytinh.computer.detil;

import com.example.appbanmaytinh.R;

public class Fragment_detail extends Fragment {
    private ImageView sp;
    private TextView tv3;
    private TextView tv4;
    private EditText tvQuantity;
    private Button take, add, tru;
    private View view;
    private detil detil;
    private Activity mActivity;

    private String userGmail;

    public Fragment_detail() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_detail, container, false);
        tv3 = view.findViewById(R.id.tv3);
        tv4 = view.findViewById(R.id.tv4);
        tvQuantity = view.findViewById(R.id.tvQuantity);
        take = view.findViewById(R.id.bttake);
        add = view.findViewById(R.id.add);
        tru = view.findViewById(R.id.tru);
        sp = view.findViewById(R.id.sp);
        mActivity = (Activity) getActivity();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = tvQuantity.getText().toString().trim();
                int a = Integer.parseInt(t);
                int slmn = a + 1;
                tvQuantity.setText(Integer.toString(slmn));
                int s1 = Integer.parseInt(tvQuantity.getText().toString());
                if (s1 == 10) {
                    add.setVisibility(View.INVISIBLE);
                    tru.setVisibility(View.VISIBLE);

                } else if (s1 == 1) {
                    add.setVisibility(View.VISIBLE);
                    tru.setVisibility(View.INVISIBLE);
                } else if (s1 > 1) {
                    add.setVisibility(View.VISIBLE);
                    tru.setVisibility(View.VISIBLE);
                }
                getViews();
                //Cần được convert int về string
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = tvQuantity.getText().toString().trim();
                int a = Integer.parseInt(t);
                int slmn = a - 1;
                tvQuantity.setText(Integer.toString(slmn));
                int s1 = Integer.parseInt(tvQuantity.getText().toString());
                if (s1 == 10) {
                    add.setVisibility(View.INVISIBLE);
                    tru.setVisibility(View.VISIBLE);

                } else if (s1 == 1) {
                    add.setVisibility(View.VISIBLE);
                    tru.setVisibility(View.INVISIBLE);
                } else if (s1 > 1) {
                    add.setVisibility(View.VISIBLE);
                    tru.setVisibility(View.VISIBLE);
                }

                getViews();

            }
        });


        getViews();

        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendcart();
            }
        });

        return view;


    }

    public void sendcart() {
        gio_hang gio_hang = new gio_hang(userGmail);
        Bundle bundle = new Bundle();
        bundle.putSerializable("detail", detil);
        gio_hang.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content, gio_hang).commit();


    }

    public void getViews(){
        Bundle bundle = getArguments();
        computer computer = (computer) bundle.get("Anh");
        int hinhpcdetail = computer.getHinh();
        String tenpcdetail = computer.getTenpc();
        String giapcdetail = computer.getGiapc();
        String sldetail = tvQuantity.getText().toString();

        userGmail = (String) bundle.get("gmail");

        tv3.setText(tenpcdetail);
        tv4.setText(giapcdetail);
        sp.setImageResource(hinhpcdetail);

        detil = new detil(hinhpcdetail, tenpcdetail, giapcdetail, sldetail);
    }


}