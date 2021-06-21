package com.example.ets.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ets.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class KiemKe_AddActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    TextView dateButton;

    Button Htat_btn;

    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_ke__add);

        DisplayMetrics dp = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dp);

        int width = dp.widthPixels;
        int height = dp.heightPixels;

        getWindow().setLayout((int)(width*.95),(int)(height*.6));


        iniViews();
        setClickBtn();





    }

    private void iniViews() {

        dateButton = findViewById(R.id.dateButton);
        Htat_btn = findViewById(R.id.Htat_btn);


    }

    private void setClickBtn() {



        Htat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        final Calendar calendar = Calendar.getInstance();

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(KiemKe_AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        dateButton.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                },day, month, year);
                datePickerDialog.show();
            }
        });

    }








}