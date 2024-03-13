package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gsb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Now you can access views directly using binding object
        binding.LoginTextView.setText("Login");
        binding.PasswordTextView.setText("Password");
        binding.LoginEditText.setHint("Enter your login");
        binding.PasswordEditText.setHint("Enter your password");

        // Alternatively, if you want to keep references to views for further manipulation
        // you can assign them from the binding object
        TextView loginTextView = binding.LoginTextView;
        TextView passwordTextView = binding.PasswordTextView;
        EditText loginEditText = binding.LoginEditText;
        EditText passwordEditText = binding.PasswordEditText;


    }
}
