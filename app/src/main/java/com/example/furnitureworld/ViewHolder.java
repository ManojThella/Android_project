package com.example.furnitureworld;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView productNameTextView;
    private TextView descriptionTextView;
    // ... other views

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        // Initialize views in the constructor
        productNameTextView = itemView.findViewById(R.id.productNameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        // ... initialize other views
    }

    public void bind(Model model) {
        // Bind data to views
        productNameTextView.setText(model.getProductName());
        descriptionTextView.setText(model.getDescription());
        // ... bind other data to other views
    }
}