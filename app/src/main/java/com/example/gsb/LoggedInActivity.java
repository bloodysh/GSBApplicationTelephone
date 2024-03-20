package com.example.gsb;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoggedInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggedin);

        // Retrieve the token from Intent extras
        String token = getIntent().getStringExtra("token");
        String idVisiteur = getIntent().getStringExtra("idVisiteur");
        GSBServices service = RetrofitClientInstance.getRetrofitInstance().create(GSBServices.class);
        Call<Visiteur> call = service.getVisiteur("Bearer " + token, idVisiteur );
        call.enqueue(new Callback<Visiteur>() {
            @Override
            public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                if (response.isSuccessful()) {
                    Visiteur visiteur = response.body();

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

