package com.example.ets.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ets.R;

public class RegisterActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }

    public void onLoginClick(View View){
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.stay);
    }
}
