package com.example.outdoorsphere;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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
        EdgeToEdge.enable(this); // Makes activity edge-to-edge for modern Android UI
        setContentView(R.layout.activity_winter_sports);

        spn = findViewById(R.id.spinner4); // Ensure spinner ID matches XML layout
        bts = findViewById(R.id.btwint);   // Ensure button ID matches XML layout
bindSpinner();
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected item type and position after the spinner is set up
                String selectedType = spn.getSelectedItem().toString();
                int selectedPosition = spn.getSelectedItemPosition();

                Intent intent = null;

                // Choose activity based on spinner selection
                switch (selectedType) {
                    case "WINTER HIKING":
                        intent = new Intent(WinterSportsActivity.this, WINTERHIKING.class);
                        break;
                    case "SLEDDING":
                        intent = new Intent(WinterSportsActivity.this, WINTERHIKING.class);
                        break;
                    default:
                        // If the selected option doesn't match any case, show a message and return
                        Toast.makeText(WinterSportsActivity.this, "Please select a valid activity.", Toast.LENGTH_SHORT).show();
                        return;
                }

                // Attach the selected position as an extra and start the intended activity
                if (intent != null) {
                    intent.putExtra("selected_id", selectedPosition);
                    startActivity(intent);
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
        String[] arr = da.getWinterTypes(); // This should return the types correctly
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
        spnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(spnAdapter);
    }


}