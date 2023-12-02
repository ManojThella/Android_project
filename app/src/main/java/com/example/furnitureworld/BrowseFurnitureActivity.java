package com.example.furnitureworld;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BrowseFurnitureActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_furniture);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatabaseReference furnitureRef = FirebaseDatabase.getInstance().getReference("furniture");

        FirebaseRecyclerOptions<Furniture> options =
                new FirebaseRecyclerOptions.Builder<Furniture>()
                        .setQuery(furnitureRef, Furniture.class)
                        .build();

        adaptor = new Adaptor(options);
        recyclerView.setAdapter(adaptor);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adaptor.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adaptor.stopListening();
    }
}