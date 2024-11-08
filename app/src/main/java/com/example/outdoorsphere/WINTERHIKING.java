package com.example.outdoorsphere;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

public class WINTERHIKING extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winterhiking);

        // Get the intent and the selected index
        Intent intent = getIntent();
        int selectedIndex = intent.getIntExtra("selected_id", -1);  // Default to -1 if no data is passed

        Log.d("WINTERHIKING", "Selected index: " + selectedIndex);

        // Ensure that the index is valid
        if (selectedIndex != -1 && selectedIndex < InformationMockUp.getListWinter().size()) {
            Information selected = InformationMockUp.getListWinter().get(selectedIndex);

            // Set the data in the views
            TextView nameTextView = findViewById(R.id.txtnamv);
            ImageView imageView = findViewById(R.id.imgvv);
            TextView descriptionTextView = findViewById(R.id.winter);
            TextView priceTextView = findViewById(R.id.txtv);

            if (nameTextView != null) {
                nameTextView.setText(selected.getName());
            }

           if (imageView != null) {
                imageView.setImageResource(selected.getImage());
            }

            if (descriptionTextView != null) {
                descriptionTextView.setText(selected.getInfo());
            }

            if (priceTextView != null) {
                priceTextView.setText(selected.getAdvice());
            }
        } else {
            // Handle the case when the index is invalid
            Log.e("WINTERHIKING", "Invalid index: " + selectedIndex);
        }

        // Handle window insets for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
