package com.example.furnitureworld;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class BrowseFurnitureActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button addFurnitureButton;

    private DatabaseReference databaseReference;
    private FirebaseRecyclerAdapter<Model, ViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_furniture);

        // Initialize Firebase Realtime Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("furniture");

        // Initialize views
        recyclerView = findViewById(R.id.recyclerView);
        addFurnitureButton = findViewById(R.id.addFurnitureButton);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up FirebaseRecyclerOptions
        Query query = databaseReference.orderByChild("userId").equalTo(getCurrentUserId());
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(query, Model.class)
                        .build();

        // Set up the adapter
        adapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Model model) {
                // Bind data to ViewHolder
                // (e.g., holder.bind(model);)
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                // Create and return a new ViewHolder
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adaptor, parent, false);
                return new ViewHolder(view);
            }
        };

        recyclerView.setAdapter(adapter);

        // Set onClick functionality for the "Add Furniture" button
        addFurnitureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event (e.g., navigate to the screen for adding new furniture)
                Intent intent = new Intent(BrowseFurnitureActivity.this, PostFurnitureActivity.class);
                startActivity(intent);
            }
        });
    }

    private String getCurrentUserId() {
        // Use Firebase Authentication to get the current user's ID
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            return auth.getCurrentUser().getUid();
        }
        return "";
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Start listening for changes in the Firebase Realtime Database
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Stop listening for changes in the Firebase Realtime Database
        adapter.stopListening();
    }
}