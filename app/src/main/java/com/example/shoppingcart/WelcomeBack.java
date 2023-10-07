package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);
    }

    public void onClickSignIn(View v){
        Intent ini = new Intent(this,WelcomeBack.class);
        startActivity(ini);
    }

    public void onClickSignUp(View v){
        Intent ini = new Intent(this,MainActivity.class);
        startActivity(ini);
    }
}