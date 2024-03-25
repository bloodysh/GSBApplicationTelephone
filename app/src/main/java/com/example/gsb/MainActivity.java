package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gsb.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Now you can access views directly using binding object

        binding.LoginEditText.setHint("Enter your login");
        binding.PasswordEditText.setHint("Enter your password");

        binding.LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.LoginEditText.getText().toString();
                String password = binding.PasswordEditText.getText().toString();
                Visiteur unVisiteur = new Visiteur(email, password);

                GSBServices service = RetrofitClientInstance.getRetrofitInstance().create(GSBServices.class);
                Call<Visiteur> callLogin = service.login(unVisiteur);

                callLogin.enqueue(new Callback<Visiteur>() {
                    @Override
                    public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_SHORT).show();

                            // Retrieve the "nom" from the response
                            String token = response.body().getToken();
                            String idVisiteur =  response.body().getVisiteurId();

                            // Pass "nom" to LoggedInActivity
                            Intent intent = new Intent(MainActivity.this, LoggedInActivity.class);
                            intent.putExtra("token", token);
                            intent.putExtra("idVisiteur", idVisiteur);
                            startActivity(intent);


                        } else {
                            Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Visiteur> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Une erreur est survenue !", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




    }
}
