package com.example.outdoorsphere;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WinterSportsActivity extends AppCompatActivity {
    private Spinner spn;
    private Button bts;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_winter_sports);
        spn= findViewById(R.id.spinner4);

        bts = findViewById(R.id.btwint);

        bindSpinner();
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected item type and position after the spinner is set up
                String selectedType = spn.getSelectedItem().toString();
                int selectedPosition = spn.getSelectedItemPosition();

                Intent intentM = null;

                // Choose activity based on spinner selection
                switch (selectedType) {
                    case "VIAFERRATA":
                        intentM = new Intent(WinterSportsActivity.this, WINTERHIKING.class);
                        break;
                    case "ALPINEROUTE":
                        intentM = new Intent(WinterSportsActivity.this, SLEDDING.class);
                        break;
                    default:
                        // If the selected option doesn't match any case, show a message and return
                        Toast.makeText(WinterSportsActivity.this, "Please select a valid activity.", Toast.LENGTH_SHORT).show();
                        return;
                }

                // Attach the selected position as an extra and start the intended activity
                if (intentM != null) {
                    intentM.putExtra("selected_id", selectedPosition);
                    startActivity(intentM);
                }
            }
        });

    }
    private void bindSpinner() {
        InformationMockUp da = new InformationMockUp();
        String[] arr = da.getWinterTypes();
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
        spn.setAdapter(spnAdapter);
    }
}