package com.example.ets.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ets.R;

public class XuatKho_CTActivity extends AppCompatActivity {

    Button Htat_btn;

    TextView m1,m2,m3,m4,m5, ck1;

    RelativeLayout r1,r2,r3,r4,r5,r6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuat_kho__c_t);

        DisplayMetrics dp = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dp);

        int width = dp.widthPixels;
        int height = dp.heightPixels;

        getWindow().setLayout((int)(width*.95),(int)(height*.97));

        iniViews();
        setClickBtn();





    }



    private void iniViews() {

        Htat_btn = findViewById(R.id.Htat_btn);
        m1 = findViewById(R.id.mtp1);
        m2 = findViewById(R.id.mtp2);
        m3 = findViewById(R.id.mtp3);
        m4 = findViewById(R.id.mtp4);
        m5 = findViewById(R.id.mtp5);

        ck1 = findViewById(R.id.ck1);

        r1 = findViewById(R.id.rela1);
        r2 = findViewById(R.id.rela2);
        r3 = findViewById(R.id.rela3);
        r4 = findViewById(R.id.rela4);
        r5 = findViewById(R.id.rela5);
        r6 = findViewById(R.id.rela6);


    }

    private void setClickBtn(){

        Intent intent= getIntent();
        final int flag = intent.getIntExtra("resultKho",0);

        Htat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = 1;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("resultKho", result);

                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });

    }


    public void onScanClick(View View){


        int mtp =1;
        Intent intent = new Intent(XuatKho_CTActivity.this, ScannerActivity.class);
        intent.putExtra("ButtonKho",mtp);
        startActivityForResult(intent, 1233);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1233) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("mtpKho");
                if(result.equals("MTP: 11223344")){

                    ck1.setVisibility(View.VISIBLE);
                    r1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.false_bg));

                }

//                if(result.equals(m1.getText().toString())){
//
//                    ck1.setVisibility(View.VISIBLE);
//                    r1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.false_bg));
//
//                }
            }

        }
    }






}