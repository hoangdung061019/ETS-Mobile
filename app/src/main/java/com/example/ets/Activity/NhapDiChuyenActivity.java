package com.example.ets.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.ets.R;

public class NhapDiChuyenActivity extends AppCompatActivity {

    Button Htat_btn;

    TextView m1,m2,m3,m4,m5, ck1;

    TextView edt1;

    RelativeLayout r1,r2,r3,r4,r5,r6;

    EditText sl1,sl2,sl3,sl4,sl5,sl6;

    Boolean enable;

    String edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_di_chuyen);


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

        sl1 = findViewById(R.id.sl1_txt);

        edt1 = findViewById(R.id.edit_btn1);


    }

    private void setClickBtn(){

        Intent intent= getIntent();
        final int flag = intent.getIntExtra("result2",0);




        edt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enable = true;
                sl1.setText(" ");
                sl1.setEnabled(enable);

                Htat_btn.setEnabled(enable);

            }
        });

        Htat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edit1 = sl1.getText().toString();

                sl1.setText("SL Nhận: " +edit1);

                enable = false;

                sl1.setEnabled(enable);

                Htat_btn.setEnabled(enable);

                Toast.makeText(getApplicationContext(), "Đã tạo Phiếu Nhập Di Chuyển Nội Bộ", Toast.LENGTH_SHORT).show();

            }
        });


    }


    public void onScanClick(View View){


        int mtp =1;
        Intent intent = new Intent(NhapDiChuyenActivity.this, ScannerActivity.class);
        intent.putExtra("ButtonNhap",mtp);
        startActivityForResult(intent, 1234);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1234) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("mtpNhap");
                if(result.equals("MTP: 11223344")){

                    r1.setVisibility(View.VISIBLE);
                    Htat_btn.setVisibility(View.VISIBLE);




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