package com.example.calmshperef1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class anxiety_community_page extends AppCompatActivity {


   public TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.anxiety_community_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button JoinAnxietyBtn = findViewById(R.id.JoinAnxietyBtn);
        t1 = findViewById(R.id.anxi);
        JoinAnxietyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to open MediationActivity
                Intent intent = new Intent(anxiety_community_page.this, StartPage.class);
                String send = t1.getText().toString();
                intent.putExtra("anxi" , send );
                // Start the activity
                startActivity(intent);
            }
        });


    }
}