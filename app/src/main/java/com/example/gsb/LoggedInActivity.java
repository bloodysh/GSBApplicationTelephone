package com.example.gsb;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoggedInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggedin);

        // Retrieve the "nom" from Intent extras
        String nom = getIntent().getStringExtra("nom");

        // Display the "nom" in a TextView or any other view as needed
        TextView nomTextView = findViewById(R.id.editTextText);
        nomTextView.setText(nom);
    }
}

