package com.example.outdoorsphere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OutdoorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_outdoor);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                if(position == 0){
                    Intent intent = new Intent(OutdoorActivity.this, HikingActivity.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    Intent intent = new Intent(OutdoorActivity.this, CyclingActivity.class);
                    startActivity(intent);
                }
                else if(position == 2){
                    Intent intent = new Intent(OutdoorActivity.this, RunningActivity.class);
                    startActivity(intent);
                }
                else if(position == 3){
                    Intent intent = new Intent(OutdoorActivity.this, MountaineeringActivity.class);
                    startActivity(intent);
                }
                else if(position == 4){
                    Intent intent = new Intent(OutdoorActivity.this, WinterSportsActivity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView)findViewById(R.id.lstOption);
        listView.setOnItemClickListener(itemClickListener);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}