package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeFurniture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_furniture);
    }

    public void onClickPostFurniture(View v){
        Intent ini = new Intent(this,PostActivity.class);
        startActivity(ini);
    }
}