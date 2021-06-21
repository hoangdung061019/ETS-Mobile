package com.example.ets.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ets.R;

public class KiemKe_CTActivity extends AppCompatActivity {

    Button Htat_btn,capnhatBtn;

    TextView m1,m2,m3,m4,m5;

    TextView edt1, sl1;

    RelativeLayout r1,r2,r3,r4,r5,r6;

    EditText slThuc;

    Boolean enable;

    String edit1,slthuc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_ke__c_t);

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


        r1 = findViewById(R.id.rela1);
        r2 = findViewById(R.id.rela2);
        r3 = findViewById(R.id.rela3);
        r4 = findViewById(R.id.rela4);
        r5 = findViewById(R.id.rela5);
        r6 = findViewById(R.id.rela6);

        sl1 = findViewById(R.id.sl1_txt);

        edt1 = findViewById(R.id.edit_btn1);

        slThuc = findViewById(R.id.slthuc_txt);

        capnhatBtn = findViewById(R.id.capnhatBtn);



    }

    private void setClickBtn(){

        Intent intent= getIntent();
        final int flag = intent.getIntExtra("result",0);



        Htat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = 1;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);

                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });

        capnhatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    slthuc2 = slThuc.getText().toString();

                    sl1.setText("");
                    slThuc.setText("");

//                    sl1.setText("SL Tồn: "+slThuc.getText().toString());
//                    slThuc.setText("SL Thực: "+slThuc.getText().toString());

                    sl1.setText("SL Tồn: "+slthuc2);
                    slThuc.setText("SL Thực: "+slthuc2);

//                    sl1.setText(slthuc2);
//                    slThuc.setText("SL Thực: "+slThuc.getText().toString());

            }
        });

    }


    public void onScanClick(View View){


        int mtp =1;
        Intent intent = new Intent(KiemKe_CTActivity.this, ScannerActivity.class);
        intent.putExtra("ButtonKK",mtp);
        startActivityForResult(intent, 234);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 234) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("mtpKK");
                if(result.equals("MTP: 11223344")){

                    r1.setVisibility(View.VISIBLE);


                }


            }

        }
    }


}