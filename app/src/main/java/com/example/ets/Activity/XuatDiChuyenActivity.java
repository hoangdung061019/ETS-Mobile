package com.example.ets.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ets.R;

public class XuatDiChuyenActivity extends AppCompatActivity {

    RelativeLayout p1,p2,p3,p4,p5;
    TextView ck1,ck2,ck3,ck4,ck5;

    ImageView back_pressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuat_di_chuyen);


        iniViews();
        setClickBtn();

    }

    private void iniViews() {

        p1 = findViewById(R.id.phieu1_btn);
        p2 = findViewById(R.id.phieu2_btn);
        p3 = findViewById(R.id.phieu3_btn);
        p4 = findViewById(R.id.phieu4_btn);
        p5 = findViewById(R.id.phieu5_btn);


        ck1 = findViewById(R.id.check_ok);
        ck2 = findViewById(R.id.check_ok2);
        ck3 = findViewById(R.id.check_ok3);
        ck4 = findViewById(R.id.check_ok4);
        ck5 = findViewById(R.id.check_ok5);




    }


    private void setClickBtn(){



        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XuatDiChuyenActivity.this, Xuat_DC_CTActivity.class);
                intent.putExtra("result", 0);
                startActivityForResult(intent,1);
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XuatDiChuyenActivity.this, Xuat_DC_CTActivity.class);
                intent.putExtra("result", 0);
                startActivityForResult(intent,2);
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XuatDiChuyenActivity.this, Xuat_DC_CTActivity.class);
                intent.putExtra("result", 0);
                startActivityForResult(intent,3);
            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XuatDiChuyenActivity.this, Xuat_DC_CTActivity.class);
                intent.putExtra("result", 0);
                startActivityForResult(intent,4);
            }
        });

        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XuatDiChuyenActivity.this, Xuat_DC_CTActivity.class);
                intent.putExtra("result", 0);
                startActivityForResult(intent,5);
            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                if(result ==1){
                    ck1.setVisibility(View.VISIBLE);
                }
            }
        } else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                if(result ==1){
                    ck2.setVisibility(View.VISIBLE);
                }
            }
        } else if (requestCode == 3) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                if(result ==1){
                    ck3.setVisibility(View.VISIBLE);
                }
            }
        }else if (requestCode == 4) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                if(result ==1){
                    ck4.setVisibility(View.VISIBLE);
                }
            }
        }else if (requestCode == 5) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                if(result ==1){
                    ck5.setVisibility(View.VISIBLE);
                }
            }
        }



    }


}