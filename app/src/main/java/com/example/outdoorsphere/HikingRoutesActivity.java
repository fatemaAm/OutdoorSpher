package com.example.outdoorsphere;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HikingRoutesActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hiking_routes);

        // Retrieve the selected index from the Intent
        Intent intent = getIntent();
        int selectedIndex = intent.getIntExtra("selected_id", -1);  // Default to -1 if no data is passed

        if (selectedIndex != -1 && selectedIndex < InformationMockUp.getList().size()) {
            Information selected = InformationMockUp.getList().get(selectedIndex);

            // Set the data in the views
            TextView nameTextView = findViewById(R.id.txtnamerun);
            ImageView imageView = findViewById(R.id.imgrun);
            TextView descriptionTextView = findViewById(R.id.txtinfo);
            TextView priceTextView = findViewById(R.id.txtrun);

            nameTextView.setText(selected.getName());
            imageView.setImageResource(selected.getImage());
            descriptionTextView.setText(selected.getInfo());
            priceTextView.setText(selected.getAdvice());
        } else {
            // Handle the case when index is invalid
            Log.e("HikingRoutesActivity", "Invalid index: " + selectedIndex);
            // Optionally, display default content or an error message
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}