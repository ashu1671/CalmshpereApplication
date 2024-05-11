package com.example.calmshperef1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Choosebooking extends AppCompatActivity {

    public int total = 0;
    String selectedtimeslotbyuser ;
    public CheckBox checkBox;
    public CheckBox checkBox1;

    public CheckBox checkBox2;

    public CheckBox checkBox3;
    public Spinner spinner;

    public Button cnfrm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choosebooking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        spinner = findViewById(R.id.timeslotchoose);
        cnfrm = findViewById(R.id.next);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.timeslots , android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object ts =  parent.getItemAtPosition(position);
                selectedtimeslotbyuser = String.valueOf(ts);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        checkBox = findViewById(R.id.messagecheckbox);
        checkBox1 = findViewById(R.id.voicecallcheckbox);
        checkBox2 = findViewById(R.id.videocallcheckbox);
        checkBox3 = findViewById(R.id.inpersoncheckbox);



        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("TOTAL", "Message has been chosen " + isChecked);

                if (checkBox.isChecked() && selectedtimeslotbyuser.equals("30 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 1,000 for 30 Minutes", Toast.LENGTH_SHORT).show();
                    total+=1000;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }

                if (checkBox.isChecked() && selectedtimeslotbyuser.equals("60 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 2,000 for 60 Minutes", Toast.LENGTH_SHORT).show();
                    total+=2000;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }

                if (checkBox.isChecked() && selectedtimeslotbyuser.equals("90 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 3,000 for 90 Minutes", Toast.LENGTH_SHORT).show();
                    total+=3000;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("TOTAL", "Voice Call has been chosen " + isChecked);
                if (checkBox1.isChecked() && selectedtimeslotbyuser.equals("30 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 1,500 for 30 Minutes", Toast.LENGTH_SHORT).show();
                    total+=1500;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }
                if (checkBox1.isChecked() && selectedtimeslotbyuser.equals("60 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 3,000 for 60 Minutes", Toast.LENGTH_SHORT).show();
                    total+=3000;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }

                if (checkBox1.isChecked() && selectedtimeslotbyuser.equals("90 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 4,500 for 90 Minutes", Toast.LENGTH_SHORT).show();
                    total+=4500;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }

            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("TOTAL", "Video Call has been chosen " + isChecked);
                if (checkBox2.isChecked() && selectedtimeslotbyuser.equals("30 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 2,000 for 30 Minutes", Toast.LENGTH_SHORT).show();
                    total+=2000;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }
                if (checkBox2.isChecked() && selectedtimeslotbyuser.equals("60 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 4,000 for 60 Minutes", Toast.LENGTH_SHORT).show();
                    total+=4000;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }

                if (checkBox2.isChecked() && selectedtimeslotbyuser.equals("90 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 6,000 for 90 Minutes", Toast.LENGTH_SHORT).show();
                    total+=6000;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("TOTAL", "In Person has been chosen " + isChecked);
                if (checkBox3.isChecked() && selectedtimeslotbyuser.equals("30 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 2,500 for 30 Minutes", Toast.LENGTH_SHORT).show();
                    total+=2500;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }
                if (checkBox3.isChecked() && selectedtimeslotbyuser.equals("60 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 5,000 for 60 Minutes", Toast.LENGTH_SHORT).show();
                    total+=5000;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }

                if (checkBox3.isChecked() && selectedtimeslotbyuser.equals("90 Minutes")) {
                    Toast.makeText(Choosebooking.this, "Rs 7,500 for 90 Minutes", Toast.LENGTH_SHORT).show();
                    total+=7500;
                    Toast.makeText(Choosebooking.this, "Total Sum in INR is: "+ total, Toast.LENGTH_SHORT).show();
                }
            }
        });


        cnfrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choosebooking.this , ReviewSummary.class);
                startActivity(intent);
            }
        });

    }
}