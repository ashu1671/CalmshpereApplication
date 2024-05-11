package com.example.calmshperef1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseTherapist extends AppCompatActivity {

    public TextView t1 , t2 , t3, t4;

    public Button b1, b2 , b3 , b4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choose_therapaist);

        t1 = findViewById(R.id.textViewDrpawan);
        t2 = findViewById(R.id.textViewWanitha);
        t3 = findViewById(R.id.textViewDrudara);
        t4 = findViewById(R.id.textViewDrramesh);

        b1 = findViewById(R.id.buttonpawan);
        b2 = findViewById(R.id.buttonwanitha);
        b3 = findViewById(R.id.buttonudara);
        b4 = findViewById(R.id.buttonramesh);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTherapist.this , appointment_timeslots.class);
                String texttosend = t1.getText().toString();
                intent.putExtra("text", texttosend);
                startActivity(intent);


//                Intent intent2 = new Intent(ChooseTherapist.this, Detailandcancel.class);
//                String textToSend2 = t1.getText().toString();
//                intent2.putExtra("text1", textToSend2);
//                startActivity(intent2);



            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTherapist.this , appointment_timeslots.class);
                String texttosend = t2.getText().toString();
                intent.putExtra("text", texttosend);
                startActivity(intent);


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTherapist.this , appointment_timeslots.class);
                String texttosend = t3.getText().toString();
                intent.putExtra("text", texttosend);
                startActivity(intent);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTherapist.this , appointment_timeslots.class);
                String texttosend = t4.getText().toString();
                intent.putExtra("text", texttosend);
                startActivity(intent);

            }
        });



    }
}