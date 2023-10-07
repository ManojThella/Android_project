package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickRegister(View v){
        Intent ini = new Intent(this,WelcomeFurniture.class);
        startActivity(ini);
    }

    public void onClickSign(View v){
        Intent ini = new Intent(this,WelcomeBack.class);
        startActivity(ini);
    }
}