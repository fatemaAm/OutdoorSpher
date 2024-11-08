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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HikingActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button btnshow;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiking);

        spinner = findViewById(R.id.spinner);
        btnshow = findViewById(R.id.btnshow);

        // Only bind the spinner once here, not in the button's onClick
        bindSpinner();

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected item type and position after the spinner is set up
                String selectedType = spinner.getSelectedItem().toString();
                int selectedPosition = spinner.getSelectedItemPosition();

                Intent intent = null;

                // Choose activity based on spinner selection
                switch (selectedType) {
                    case "Hiking Routes":
                        intent = new Intent(HikingActivity.this, HikingRoutesActivity.class);
                        break;
                    case "Long-Distance Hiking":
                        intent = new Intent(HikingActivity.this, HikingRoutesActivity.class);
                        break;
                    default:
                        // If the selected option doesn't match any case, show a message and return
                        Toast.makeText(HikingActivity.this, "Please select a valid activity.", Toast.LENGTH_SHORT).show();
                        return;
                }

                // Attach the selected position as an extra and start the intended activity
                if (intent != null) {
                    intent.putExtra("selected_id", selectedPosition);
                    startActivity(intent);
                }
            }
        });

        // Adjust insets for full screen
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void bindSpinner() {
        InformationMockUp da = new InformationMockUp();
        String[] arr = da.getOutdoorTypes(); // This should return the types correctly
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
        spnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spnAdapter);
    }


}
