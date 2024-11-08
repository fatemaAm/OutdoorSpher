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

public class MountaineeringActivity extends AppCompatActivity {
    private Spinner spinn;
    private Button btsh;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountaineering);

        spinn= findViewById(R.id.spinner2);
        btsh = findViewById(R.id.btmount);

        bindSpinner();
        btsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected item type and position after the spinner is set up
                String selectedType = spinn.getSelectedItem().toString();
                int selectedPosition = spinn.getSelectedItemPosition();

                Intent intentM = null;

                // Choose activity based on spinner selection
                switch (selectedType) {
                    case "VIA FERRATA":
                        intentM = new Intent(MountaineeringActivity.this, VIAFERRATA.class);
                        break;
                    case "ALPINE ROUTE":
                        intentM = new Intent(MountaineeringActivity.this, VIAFERRATA.class);
                        break;
                    default:
                        // If the selected option doesn't match any case, show a message and return
                        Toast.makeText(MountaineeringActivity.this, "Please select a valid activity.", Toast.LENGTH_SHORT).show();
                        return;
                }

                // Attach the selected position as an extra and start the intended activity
                if (intentM != null) {
                    intentM.putExtra("selected_id", selectedPosition);
                    startActivity(intentM);
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    private void bindSpinner() {
        InformationMockUp da = new InformationMockUp();
        String[] arr = da.getMountTypes();
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
        spinn.setAdapter(spnAdapter);
    }
}