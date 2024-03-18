package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


        GSBServices service =
                RetrofitClientInstance.getRetrofitInstance().create(GSBServices.
                        class);
        Call<Visiteur> call = service.login();
        call.enqueue(new Callback<Visiteur>() {
            @Override
            public void onResponse(Call<Visiteur> call, Response<Visiteur>
                    response) {
                response.body();
            }
            @Override
            public void onFailure(Call<Visiteur> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
