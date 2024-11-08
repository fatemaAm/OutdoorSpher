package com.example.outdoorsphere;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CyclingActivity extends AppCompatActivity {
    private Spinner spinners;
    private Button show;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycling);

        spinners = findViewById(R.id.spinner2);
        show = findViewById(R.id.show);

        bindSpinner();

        show.setOnClickListener(v -> {
            String selectedType = spinners.getSelectedItem().toString().trim();
            int selectedPosition = spinners.getSelectedItemPosition();

            Intent intente;
            switch (selectedType) {

                case "BIKE RIDES":
                    intente = new Intent(CyclingActivity.this, BIKERIDESActivity.class);
                    break;
                case "MOUNT BIKING":
                    intente = new Intent(CyclingActivity.this, BIKERIDESActivity.class);
                    break;
                default:
                    Toast.makeText(CyclingActivity.this, "Please select a valid activity.", Toast.LENGTH_SHORT).show();
                    return;
            }

            // Pass the selected position to the next activity
            intente.putExtra("selected_id", selectedPosition);
            startActivity(intente);

            Log.d("CyclingActivity", "Selected Item: " + selectedType + ", Position: " + selectedPosition);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void bindSpinner() {
        InformationMockUp da = new InformationMockUp();
        String[] cycleTypes = da.getCycleTypes();
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cycleTypes);
        spnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners.setAdapter(spnAdapter);
    }
}
