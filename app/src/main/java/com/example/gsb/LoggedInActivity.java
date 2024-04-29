package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsb.databinding.LoggedinBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoggedInActivity extends AppCompatActivity {
    private LoggedinBinding binding;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private Visiteur visiteur ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LoggedinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.praticiensRecyclerView; // Get the new RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Set the LayoutManager




        String token = getIntent().getStringExtra("token");
        String idVisiteur = getIntent().getStringExtra("idVisiteur");

        GSBServices service = RetrofitClientInstance.getRetrofitInstance().create(GSBServices.class);

        // Make the API call to getVisiteur
        Call<Visiteur> callVisiteur = service.getVisiteur("Bearer " + token, idVisiteur);
        callVisiteur.enqueue(new Callback<Visiteur>() {
            @Override
            public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                if (response.isSuccessful()) {
                    visiteur = response.body();
                    String nom = visiteur.getNom();
                    binding.textViewNom.setText(nom);


                    // Make the API call to getPraticiens
                    // After you retrieve the Visiteur object
                    ArrayList<Praticien> praticiens = visiteur.getPortefeuillePraticiens();

                    // Set up the RecyclerView
                    binding.praticiensRecyclerView.setHasFixedSize(true);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    binding.praticiensRecyclerView.setLayoutManager(layoutManager);
                    binding.praticiensRecyclerView.setFocusable(false);

                    // Create and set the adapter
                    RecyclerAdapter adapter =  new RecyclerAdapter(praticiens);
                    binding.praticiensRecyclerView.setAdapter(adapter);

                    // Set up the item click listener
                    binding.praticiensRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.praticiensRecyclerView, new RecyclerViewClickListener() {
                        @Override
                        public void onClick(View view, int position) {
                            Praticien praticien = praticiens.get(position);
                            Intent intent = new Intent(getApplicationContext(), InfoPraticienActivity.class);
                            intent.putExtra("praticien", praticien);
                            intent.putExtra("visiteur", visiteur);
                            intent.putExtra("token", token);
                            startActivity(intent);
                        }
                    }));
                } else {
                    // Handle the error
                }
            }

            @Override
            public void onFailure(Call<Visiteur> call, Throwable t) {
                // Handle the failure
            }
        });
    }
}