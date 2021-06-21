package com.example.ets.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ets.R;

public class MainActivity extends AppCompatActivity {

    LinearLayout scanBtn, xuatDC_btn, nhapDC_btn, xuatkho_btn, kiemke_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();
        setClickBtn();




    }


    private void iniViews() {
        scanBtn = findViewById(R.id.ScanBtn);
        xuatDC_btn = findViewById(R.id.XuatDC_btn);
        nhapDC_btn = findViewById(R.id.NhapDC_btn);
        xuatkho_btn = findViewById(R.id.XuatKho_btn);
        kiemke_btn = findViewById(R.id.KiemKe_btn);
    }

    private void setClickBtn(){
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ScannerActivity.class);
                startActivity(intent);

            }
        });

        xuatDC_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, XuatDiChuyenActivity.class);
                startActivity(intent);

            }
        });

        nhapDC_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NhapDiChuyenActivity.class);
                startActivity(intent);

            }
        });

        xuatkho_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, XuatKhoActivity.class);
                startActivity(intent);

            }
        });

        kiemke_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, KiemKeActivity.class);
                startActivity(intent);

            }
        });








    }
}