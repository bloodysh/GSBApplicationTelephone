package com.example.gsb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerVisiteAdapter extends RecyclerView.Adapter<RecyclerVisiteAdapter.RecyclerViewHolder> {
    private ArrayList<Visite> visites;

    public RecyclerVisiteAdapter(ArrayList<Visite> visites) {
        this.visites = visites;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_praticien, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Visite visite = visites.get(position);
        // Set the text of the TextViews to the Visite information
    }

    @Override
    public int getItemCount() {
        return visites.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.recycler_visite);
        }
    }
}