package com.example.outdoorsphere;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RunningActivity extends AppCompatActivity {
    private Spinner spinnerr;
    private Button btnShowR;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);  // Ensure you have activity_running.xml with similar structure

        spinnerr = findViewById(R.id.spinner3);
        btnShowR = findViewById(R.id.btrun);

        // Bind the spinner with running types
        bindSpinner();

        btnShowR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected item and position after spinner setup
                String selectedType = spinnerr.getSelectedItem().toString();
                int selectedPosition = spinnerr.getSelectedItemPosition();

                Intent intentr = null;

                // Choose activity based on spinner selection
                switch (selectedType) {
                    case "RUNNING":
                        intentr = new Intent(RunningActivity.this, RUNNING.class);
                        break;
                    case "TRAIL RUNNING":
                        intentr = new Intent(RunningActivity.this, RUNNING.class);
                        break;
                    default:
                        // If no match is found, show a message and return
                        Toast.makeText(RunningActivity.this, "Please select a valid activity.", Toast.LENGTH_SHORT).show();
                        return;
                }

                // Attach the selected position as an extra and start the intended activity
                if (intentr != null) {
                    intentr.putExtra("selected_id", selectedPosition);
                    startActivity(intentr);
                }
            }
        });


        // Adjust insets for full screen layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void bindSpinner() {
        InformationMockUp data = new InformationMockUp();
        String[] arr = data.getRunnTypes(); // Get running types from InformationMockUp
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
        spnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerr.setAdapter(spnAdapter);
    }
}
