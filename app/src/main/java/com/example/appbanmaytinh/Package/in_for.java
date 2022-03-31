package com.example.appbanmaytinh.Package;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appbanmaytinh.MainActivity;
import com.example.appbanmaytinh.R;
import com.example.appbanmaytinh.computer.database.databaseinfor;
import com.example.appbanmaytinh.computer.inforkhachhang;

import java.util.ArrayList;
import java.util.List;

public class in_for extends Fragment {
    private View view;
    private MainActivity mActivity;
    private EditText name,date,sdt,diachi;
    private Button btSubmit;
    @Nullable
    @Override
    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view= inflater.inflate(R.layout.information, container, false);
        name=view.findViewById(R.id.name);
        date=view.findViewById(R.id.date);
        sdt=view.findViewById(R.id.SDT);
        diachi=view.findViewById(R.id.diachi);
        btSubmit=view.findViewById(R.id.submit);
        mActivity=(MainActivity) getActivity();
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = name.getText().toString().trim();
                String ns = date.getText().toString().trim();
                String SDT = sdt.getText().toString().trim();
                String dc = diachi.getText().toString().trim();
                inforkhachhang ifkh = new inforkhachhang(ten, ns, SDT, dc);
                    Toast.makeText(mActivity, "Đã lưu thông tin thành công", Toast.LENGTH_SHORT).show();
                    databaseinfor.getInstance(mActivity).infor().insertkh(ifkh);

            }
        });
        return view;

    }
    public void GetData()
    {



    }
}


