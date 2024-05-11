package com.example.calmshperef1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class grief_community_page extends AppCompatActivity {

    public TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grief_community_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton backButton = findViewById(R.id.imageButton2);
        t1 = findViewById(R.id.gri);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the button click to navigate back t
                // o ReviewSummary activity
                Intent intent = new Intent(grief_community_page.this, safe_space.class);
                startActivity(intent);
            }
        });
        Button joinnow = findViewById(R.id.button5);
        joinnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the button click to navigate back t
                // o ReviewSummary activity
                Intent intent = new Intent(grief_community_page.this, StartPage.class);
                String send = t1.getText().toString();
                intent.putExtra("anxi" , send);
                startActivity(intent);
            }
        });
    }
}