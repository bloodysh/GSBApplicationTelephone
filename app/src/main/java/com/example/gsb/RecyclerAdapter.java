package com.example.gsb;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<Praticien> praticiens;

    public RecyclerAdapter(ArrayList<Praticien> praticiens) {
        this.praticiens = praticiens;
    }

    public Praticien getPraticienAtPosition(int position) {
        return praticiens.get(position);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerpraticiens, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Praticien praticien = praticiens.get(position);
        holder.nomPraticien.setText(praticien.getNom()); // Set the nom of the Praticien to the TextView
        holder.prenomPraticien.setText(praticien.getPrenom()); // Set the prenom of the Praticien to the TextView

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InfoPraticienActivity.class);
                intent.putExtra("praticien", praticien);
                v.getContext().startActivity(intent);
            }
        };

        holder.nomPraticien.setOnClickListener(listener);
        holder.prenomPraticien.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return praticiens.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView nomPraticien;
        TextView prenomPraticien;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            nomPraticien = itemView.findViewById(R.id.recycler_visite); // Get the TextView for nom
            prenomPraticien = itemView.findViewById(R.id.prenomPraticien); // Get the TextView for prenom
        }
    }
}