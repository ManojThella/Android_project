package com.example.furnitureworld;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText editTextFullName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private Button buttonRegister;
    private TextView textViewSignIn;

    // Firebase Authentication
    private FirebaseAuth mAuth;

    // Firebase Realtime Database
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Initialize Firebase Realtime Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        // Initialize views
        editTextFullName = findViewById(R.id.fullNameET);
        editTextEmail = findViewById(R.id.emailET);
        editTextPassword = findViewById(R.id.newPasswordET);
        editTextConfirmPassword = findViewById(R.id.confirmPasswordET);
        buttonRegister = findViewById(R.id.registerBTN);
        textViewSignIn = findViewById(R.id.signInTV);

        // Set onClick functionality for the "Register" button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform registration logic here
                String fullName = editTextFullName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();

                if (password.equals(confirmPassword) && !fullName.isEmpty()) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Registration success, update Firebase Realtime Database with user data
                                        String userId = mAuth.getCurrentUser().getUid();
                                        databaseReference.child(userId).child("full_name").setValue(fullName);
                                        databaseReference.child(userId).child("email").setValue(email);

                                        // Redirect to the user's profile or main activity
                                        Intent intent = new Intent(MainActivity.this, WelcomeBackActivity.class);
                                        startActivity(intent);
                                    } else {
                                        // If registration fails, display a message to the user.
                                        String errorMessage = task.getException().getMessage();
                                        Toast.makeText(MainActivity.this, "Registration failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(MainActivity.this, "Passwords do not match or Full Name is empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set onClick functionality for the "Sign In" text view
        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the Sign In activity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
