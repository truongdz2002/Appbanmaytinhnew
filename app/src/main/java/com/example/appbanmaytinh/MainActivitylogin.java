package com.example.appbanmaytinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appbanmaytinh.Package.in_for;
import com.example.appbanmaytinh.computer.database.khachhangDBHelper;

public class MainActivitylogin extends AppCompatActivity {
    Button login,btnRegister;
    EditText gmail , password;
    private String email;
    khachhangDBHelper khachhangDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitylogin);
        login = findViewById(R.id.login);
        btnRegister = findViewById(R.id.Register);
        gmail = findViewById(R.id.edGmailLogin);
        password = findViewById(R.id.edPasswordLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                khachhangDBHelper = new khachhangDBHelper(MainActivitylogin.this);
                boolean checkExisted = khachhangDBHelper.checkKhIsExisted(gmail.getText().toString().trim(),password.getText().toString().trim());
                if(checkExisted == true){
                    Intent intent = new Intent(MainActivitylogin.this, MainActivity.class);
                    String mail=gmail.getText().toString().trim();
                    intent.putExtra("Gmail",mail);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivitylogin.this, "Sai gmail hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }

            }
        });
//123@gmail.com
        //123456
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitylogin.this , RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    public String getEmail() {
        return email;
    }
}