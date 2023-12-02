package com.example.furnitureworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostFurnitureActivity extends AppCompatActivity {
    private EditText productNameEditText;
    private EditText descriptionEditText;
    private EditText conditionEditText;
    private EditText priceEditText;
    private EditText addressEditText;
    private EditText contactEditText;
    private Button postButton;
    
    private FirebaseAuth mAuth;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_furniture);

        mAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("furniture");

        productNameEditText = findViewById(R.id.productNameEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        conditionEditText = findViewById(R.id.conditionEditText);
        priceEditText = findViewById(R.id.priceEditText);
        addressEditText = findViewById(R.id.addressEditText);
        contactEditText = findViewById(R.id.contactEditText);
        postButton = findViewById(R.id.postButton);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputs()) {
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    if (currentUser != null) {
                        String userId = currentUser.getUid();
                        String productName = productNameEditText.getText().toString().trim();
                        String description = descriptionEditText.getText().toString().trim();
                        String condition = conditionEditText.getText().toString().trim();
                        String price = priceEditText.getText().toString().trim();
                        String address = addressEditText.getText().toString().trim();
                        String contact = contactEditText.getText().toString().trim();

                        Furniture furniture = new Furniture(userId, productName, description, condition, price, address, contact);
                        
                        String furnitureId = databaseReference.push().getKey();
                        if (furnitureId != null) {
                            databaseReference.child(furnitureId).setValue(furniture)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(PostFurnitureActivity.this, "Successfully Posted", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(PostFurnitureActivity.this, WelcomeBackActivity.class);
                                                startActivity(intent);
                                                finish(); // close this activity after posting
                                            } else {
                                                Toast.makeText(PostFurnitureActivity.this, "Failed to post furniture", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }
                    }
                }
            }
        });
    }

    private boolean validateInputs() {
        String productName = productNameEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        String condition = conditionEditText.getText().toString().trim();
        String price = priceEditText.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();
        String contact = contactEditText.getText().toString().trim();

        if (productName.isEmpty()) {
            productNameEditText.setError("Product Name is required");
            return false;
        }

        if (description.isEmpty()) {
            descriptionEditText.setError("Description is required");
            return false;
        }

        if (condition.isEmpty()) {
            conditionEditText.setError("Condition is required");
            return false;
        }

        if (price.isEmpty()) {
            priceEditText.setError("Price is required");
            return false;
        }

        if (address.isEmpty()) {
            addressEditText.setError("Address is required");
            return false;
        }

        if (contact.isEmpty()) {
            contactEditText.setError("Contact is required");
            return false;
        }

        String contactRegex = "^[0-9]{10}$";
        if (!contact.matches(contactRegex)) {
            contactEditText.setError("Invalid contact number format. Use a 10-digit number");
            return false;
        }

        return true;
    }
}