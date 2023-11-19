package com.example.furnitureworld;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.IOException;

public class PostFurnitureActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView furnitureImageView;
    private EditText productNameEditText;
    private EditText descriptionEditText;
    private EditText conditionEditText;
    private EditText priceEditText;
    private EditText addressEditText;
    private Button postButton;

    // Firebase Authentication
    private FirebaseAuth mAuth;

    // Firebase Realtime Database
    private DatabaseReference databaseReference;

    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_furniture);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Initialize Firebase Realtime Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("furniture");

        // Initialize views
        furnitureImageView = findViewById(R.id.furnitureImageView);
        productNameEditText = findViewById(R.id.productNameEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        conditionEditText = findViewById(R.id.conditionEditText);
        priceEditText = findViewById(R.id.priceEditText);
        addressEditText = findViewById(R.id.addressEditText);
        postButton = findViewById(R.id.postButton);

        // Set onClick functionality for the "Post" button
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user ID
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser == null) {
                    // User is not authenticated, handle accordingly
                    return;
                }
                String userId = currentUser.getUid();

                // Get furniture details
                String productName = productNameEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String condition = conditionEditText.getText().toString();
                String price = priceEditText.getText().toString();
                String address = addressEditText.getText().toString();

                // Create a Furniture object (assuming you have a Furniture class)
                Furniture furniture = new Furniture(userId, productName, description, condition, price, address);

//                 Add the furniture details to the database
                String furnitureId = databaseReference.push().getKey();
                if (furnitureId != null) {
                databaseReference.child("furnitureId").push().setValue(furniture);
               }

                Toast.makeText(PostFurnitureActivity.this, "Successfully Posted",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(PostFurnitureActivity.this,WelcomeBackActivity.class);
                startActivity(intent);


            }
        });

        // Set onClick functionality for the "Pick Image" button
        furnitureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the image picker
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            // Get the selected image URI
            imageUri = data.getData();

            // Display the selected image in the ImageView
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                furnitureImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}