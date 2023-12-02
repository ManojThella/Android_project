package com.example.furnitureworld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Adaptor extends FirebaseRecyclerAdapter<Furniture, Adaptor.ViewHolder> {

    public Adaptor(@NonNull FirebaseRecyclerOptions<Furniture> options) {
        super(options);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adaptor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Furniture model) {
        holder.textViewProductName.setText(model.getProductName());
        holder.textViewDescription.setText(model.getDescription());
        holder.textViewCondition.setText(model.getCondition());
        holder.textViewPrice.setText(model.getPrice());
        holder.textViewAddress.setText(model.getAddress());
        holder.textViewContact.setText(model.getContact());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewProductName;
        public TextView textViewDescription;
        public TextView textViewCondition;
        public TextView textViewPrice;
        public TextView textViewAddress;

        public TextView textViewContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewCondition = itemView.findViewById(R.id.textViewCondition);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            textViewContact = itemView.findViewById(R.id.textViewContact);
        }
    }
}
