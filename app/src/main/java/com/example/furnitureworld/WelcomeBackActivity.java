package com.example.furnitureworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);

        Button postButton = findViewById(R.id.postButton);
        Button browseButton = findViewById(R.id.browseButton);

        // Set onClick functionality for the "Post Furniture Details" button
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to PostFurnitureActivity
                Intent intent = new Intent(WelcomeBackActivity.this, PostFurnitureActivity.class);
                startActivity(intent);
            }
        });

        // Set onClick functionality for the "Browse Posted Items" button
        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to BrowseItemsActivity
                Intent intent = new Intent(WelcomeBackActivity.this, BrowseFurnitureActivity.class);
                startActivity(intent);
            }
        });
    }
}