package com.example.calmshperef1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class paymentsuccessful extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymentsuccessful);

        Button viewAppointmentButton = findViewById(R.id.button);
        viewAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the button click++++
                Intent intent = new Intent(paymentsuccessful.this, home.class);
                startActivity(intent);
            }
        });
//        ImageButton backButton = findViewById(R.id.imageButton3);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Handle the button click
//                Intent intent = new Intent(paymentsuccessful.this, AddCard.class);
//                startActivity(intent);
//            }
//        });
    }
}