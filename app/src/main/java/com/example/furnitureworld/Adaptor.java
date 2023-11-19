package com.example.furnitureworld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Adaptor extends FirebaseRecyclerAdapter<Model, ViewHolder> {

    public Adaptor(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Model model) {
        // Bind data to views in the ViewHolder
        holder.bind(model);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create and return a new ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adaptor, parent, false);
        return new ViewHolder(view);
    }
}
