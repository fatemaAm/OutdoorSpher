package com.example.outdoorsphere;

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

public class BIKERIDESActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bikeridesactivity);

        Intent intente = getIntent();
        int selectedIndex = intente.getIntExtra("selected_id", -1);  // Default to -1 if no data is passed

        if (selectedIndex != -1 && selectedIndex < InformationMockUp.getListcycle().size()) {
            Information selected = InformationMockUp.getListcycle().get(selectedIndex);

            // Set the data in the views
            TextView nameTextView = findViewById(R.id.txtnamebi);
            ImageView imageView = findViewById(R.id.imagesportbi);
            TextView descriptionTextView = findViewById(R.id.txtinfor);
            TextView priceTextView = findViewById(R.id.txtadvicebi);

            nameTextView.setText(selected.getName());
            imageView.setImageResource(selected.getImage());
            descriptionTextView.setText(selected.getInfo());
            priceTextView.setText(selected.getAdvice());
        } else {
            // Handle the case when index is invalid
            Log.e("BIKERIDESActivity", "Invalid index: " + selectedIndex);
            // Optionally, display default content or an error message
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}