package com.example.appbanmaytinh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appbanmaytinh.Package.ASUS;
import com.example.appbanmaytinh.Package.DELL;
import com.example.appbanmaytinh.Package.Fragment_detail;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbanmaytinh.Package.in_for;
import com.example.appbanmaytinh.computer.cart;

import com.example.appbanmaytinh.Package.MACBOOK;
import com.example.appbanmaytinh.Package.gio_hang;
import com.example.appbanmaytinh.Package.home;
import com.example.appbanmaytinh.computer.computer;
import com.example.appbanmaytinh.computer.database.databasecart;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_ASUS = 1;
    private static final int FRAGMENT_DELL = 2;
    private static final int FRAGMENT_MACBOOK = 3;
    private static final int FRAGMENT_CART = 4;
    private static final int FRAGMENT_INFOR = 5;
    private DrawerLayout mDrawerLayout;
    private int mCurrentFragment = FRAGMENT_HOME;
    private TextView account;
    private String mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.tootbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.draweabale_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.naviopen, R.string.naviclose);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new home());
        navigationView.getMenu().findItem(R.id.home).setChecked(true);
       mail=getIntent().getStringExtra("Gmail");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            if (mCurrentFragment != FRAGMENT_HOME) {
                replaceFragment(new home());
                mCurrentFragment = FRAGMENT_HOME;
            }

        } else if (id == R.id.ASUS) {
            if (mCurrentFragment != FRAGMENT_ASUS) {
                replaceFragment(new ASUS());
                mCurrentFragment = FRAGMENT_ASUS;
            }
        } else if (id == R.id.DELL) {
            if (mCurrentFragment != FRAGMENT_DELL) {
                replaceFragment(new DELL());
                mCurrentFragment = FRAGMENT_DELL;
            }
        } else if (id == R.id.MACBOOK) {
            if (mCurrentFragment != FRAGMENT_MACBOOK) {
                replaceFragment(new MACBOOK());
                mCurrentFragment = FRAGMENT_MACBOOK;
            }
        } else if (id == R.id.G) {
            if (mCurrentFragment != FRAGMENT_CART) {
                replaceFragment(new gio_hang());
                mCurrentFragment = FRAGMENT_CART;
            }
        } else if (id == R.id.infor) {
            if (mCurrentFragment != FRAGMENT_INFOR) {
                replaceFragment(new in_for(mail));
                mCurrentFragment = FRAGMENT_INFOR;
            }
        }

        mDrawerLayout.closeDrawer(Gravity.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }

    public void gotoDetailFragmet(computer computer) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment_detail fragment_detail = new Fragment_detail();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Anh", computer);
        fragment_detail.setArguments(bundle);
        fragmentTransaction.replace(R.id.content, fragment_detail);
        fragmentTransaction.commit();
    }

    public void deleteFragment(final cart cart) {
        new AlertDialog.Builder(this)
                .setTitle("confirm delete cart")
                .setMessage("Are you cart")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        databasecart.getInstance(MainActivity.this).cart2().deletecart(cart);
                        Toast.makeText(MainActivity.this, "Delete cart successfully", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("no", null)
                .show();
    }

    public String getMail() {
        return mail;
    }
}


