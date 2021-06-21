package com.example.ets.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.ets.R;
import com.google.zxing.Result;

public class ScannerActivity extends AppCompatActivity {



    private CodeScanner mCodeScanner;

    TextView kq_txt, test;

    Button XuatDC_btn, NhapDC_btn, KhoDC_btn, KK_btn;

    String xuatdc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        DisplayMetrics dp = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dp);

        int width = dp.widthPixels;
        int height = dp.heightPixels;

        getWindow().setLayout((int)(width*1),(int)(height*1.));


        test = findViewById(R.id.test);

        kq_txt = findViewById(R.id.kq_txt);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);


        XuatDC_btn = findViewById(R.id.XuatDC_btn);
        NhapDC_btn = findViewById(R.id.NhapDC_btn);
        KhoDC_btn = findViewById(R.id.KhoDC_btn);
        KK_btn = findViewById(R.id.KK_btn);


        getDataActi();


        setClickBtn();

        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        kq_txt.setText(result.getText());

                        xuatdc = result.getText();


                    }
                });
            }
        });


        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }

    private void getDataActi(){

        Intent intent = getIntent();
        final int btnxuatdc = intent.getIntExtra("Button", 0);
        final int btnnhapdc = intent.getIntExtra("ButtonNhap", 0);
        final int btnkhodc = intent.getIntExtra("ButtonKho", 0);
        final int btnkk = intent.getIntExtra("ButtonKK", 0);


        if (btnxuatdc == 1){
            XuatDC_btn.setVisibility(View.VISIBLE);
        }

        if (btnnhapdc == 1){
            NhapDC_btn.setVisibility(View.VISIBLE);
        }

        if (btnkhodc == 1){
            KhoDC_btn.setVisibility(View.VISIBLE);
        }

        if (btnkk == 1){
            KK_btn.setVisibility(View.VISIBLE);
        }

    }

    private void setClickBtn(){

        XuatDC_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mtp ="MTP: "+xuatdc;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("mtp", mtp);

                setResult(RESULT_OK, resultIntent);
                finish();

                //                if(xuatdc.equals("11223344")){
//
//                    test.setText(xuatdc);
//                    test.setVisibility(View.VISIBLE);
//
//                } else {
//                    test.setText("khong lay duoc data");
//                    test.setVisibility(View.VISIBLE);
//                }

            }
        });

        NhapDC_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String mtp ="MTP: "+xuatdc;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("mtpNhap", mtp);

                setResult(RESULT_OK, resultIntent);
                finish();


            }
        });

        KhoDC_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String mtp ="MTP: "+xuatdc;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("mtpKho", mtp);

                setResult(RESULT_OK, resultIntent);
                finish();


            }
        });

        KK_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String mtp ="MTP: "+xuatdc;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("mtpKK", mtp);

                setResult(RESULT_OK, resultIntent);
                finish();


            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }



}