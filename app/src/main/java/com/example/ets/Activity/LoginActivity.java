package com.example.ets.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ets.R;


public class LoginActivity extends AppCompatActivity {

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon colors
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });




    }

    public void onLoginClick(View View){
        startActivity(new Intent(this, RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }
}