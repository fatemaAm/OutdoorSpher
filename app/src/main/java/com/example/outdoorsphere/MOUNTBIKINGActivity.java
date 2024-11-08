package com.example.outdoorsphere;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MOUNTBIKINGActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountbikingactivity);  // Ensure this layout contains the required UI elements.

        // Get the selected index passed from the previous activity
        Intent intent = getIntent();
        int selectedIndex = intent.getIntExtra("selected_id", -1); // Default to -1 if no data is passed

        // Check if selectedIndex is valid
        if (selectedIndex != -1 && selectedIndex < InformationMockUp.getListcycle().size()) {
            Information selected = InformationMockUp.getListcycle().get(selectedIndex);

            // Set the data in the views
            TextView nameTextView = findViewById(R.id.txtnamerun); // Replace with correct IDs
            ImageView imageView = findViewById(R.id.imgrun); // Replace with correct IDs
            TextView descriptionTextView = findViewById(R.id.txtmmk); // Replace with correct IDs
            TextView priceTextView = findViewById(R.id.txtrun); // Replace with correct IDs

            // Set the values from the selected information
            nameTextView.setText(selected.getName());
            imageView.setImageResource(selected.getImage());
            descriptionTextView.setText(selected.getInfo());
            priceTextView.setText(selected.getAdvice());
        } else {
            // Handle the case when the index is invalid
            // For example, you can log an error or display a default message
            Log.e("MOUNTBIKINGActivity", "Invalid index: " + selectedIndex);
        }

        // Apply window insets to adjust the layout for system bars (e.g., status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
