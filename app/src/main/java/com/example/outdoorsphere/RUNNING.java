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

public class RUNNING extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_running2);  // Ensure you have an activity_running_routes.xml

        // Retrieve the selected index from the Intent
        Intent intent = getIntent();
        int selectedIndex = intent.getIntExtra("selected_id", -1);  // Default to -1 if no data is passed

        if (selectedIndex != -1 && selectedIndex < InformationMockUp.getListRun().size()) {
            Information selected = InformationMockUp.getListRun().get(selectedIndex);

            // Set data into the views
            TextView nameTextView = findViewById(R.id.txtnamerun);
            ImageView imageView = findViewById(R.id.imgrun);
            TextView descriptionTextView = findViewById(R.id.txtr);
            TextView adviceTextView = findViewById(R.id.txtrun);

            nameTextView.setText(selected.getName());
            imageView.setImageResource(selected.getImage());
            descriptionTextView.setText(selected.getInfo());
            adviceTextView.setText(selected.getAdvice());
        } else {
            // Handle invalid index cases
            Log.e("RUNNING", "Invalid index: " + selectedIndex);
        }

        // Apply window insets for full screen layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
