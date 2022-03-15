package com.example.appbanmaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appbanmaytinh.computer.database.khachhangDBHelper;
import com.example.appbanmaytinh.computer.khachhang;


public class RegisterActivity extends AppCompatActivity {
    Button btnRegister;
    EditText gmail, password, rePassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    khachhangDBHelper khachhangDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        queryItem();

        gmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkValidateForm();
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkValidateForm();
            }
        });

        rePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkValidateForm();
            }
        });


        khachhangDBHelper = new khachhangDBHelper(RegisterActivity.this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                khachhangDBHelper = new khachhangDBHelper(RegisterActivity.this);
                boolean checkRegisterSuccess = khachhangDBHelper.insertKH(new khachhang(gmail.getText().toString().trim(), password.getText().toString().trim(), rePassword.getText().toString().trim()));
                if (checkRegisterSuccess == true) {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void queryItem() {
        btnRegister = findViewById(R.id.btnRegisterRegister);
        gmail = findViewById(R.id.edGmailRegister);
        password = findViewById(R.id.edPasswordRegister);
        rePassword = findViewById(R.id.edRePasswordRegigter);
    }

    private void checkValidateForm() {
        if (gmail.getText().toString().trim().matches(emailPattern) && password.getText().toString().trim().equals(rePassword.getText().toString().trim()) && !password.getText().toString().trim().equals("") && !rePassword.getText().toString().trim().equals("")) {
            btnRegister.setEnabled(true);
        } else {

            btnRegister.setEnabled(false);
        }
    }
}