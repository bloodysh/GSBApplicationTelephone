package com.example.gsb;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gsb.databinding.InfoPraticienBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoPraticienActivity extends AppCompatActivity {
    private InfoPraticienBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = InfoPraticienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String token = getIntent().getStringExtra("token");
        Praticien praticien = (Praticien) getIntent().getSerializableExtra("praticien");
        Visiteur visiteur = (Visiteur) getIntent().getSerializableExtra("visiteur");

        binding.textViewNomPraticien.setText(praticien.getNom());
        binding.textViewPrenom.setText(praticien.getPrenom());
        binding.textViewTelephone.setText(praticien.getTel());
        binding.textViewEmail.setText(praticien.getEmail());
        binding.textViewTelephone.setText(praticien.getRue());
        binding.textViewCodePostal.setText(praticien.getCode_postale());
        binding.textViewVille.setText(praticien.getVille());
        binding.textViewId.setText(praticien.getId());


        String idVisiteur = getIntent().getStringExtra("idVisiteur");
        String idPraticien = getIntent().getStringExtra("idPraticien");

        GSBServices service = RetrofitClientInstance.getRetrofitInstance().create(GSBServices.class);
        // Make the API call to getVisiteur
        Call<ArrayList<Visite>> callVisites = service.getVisitesPraticien("Bearer " + token, idPraticien);

        callVisites.enqueue(new Callback<ArrayList<Visite>>() {
            @Override
            public void onResponse(Call<ArrayList<Visite>> call, Response<ArrayList<Visite>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Visite> visites = response.body();
                    binding.recyclerVisitesPraticien.setHasFixedSize(true);
                    binding.recyclerVisitesPraticien.setLayoutManager(new LinearLayoutManager(InfoPraticienActivity.this));
                    binding.recyclerVisitesPraticien.setAdapter(new RecyclerVisiteAdapter(visites));
                } else {
                    Toast.makeText(InfoPraticienActivity.this, "Failed to get visits", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Visite>> call, Throwable t) {
                Toast.makeText(InfoPraticienActivity.this, "Failed to get visits", Toast.LENGTH_SHORT).show();
            }
        });
    }
}