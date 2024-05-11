package com.example.calmshperef1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


//import java.util.logging.Handler;

public class launchscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launchscreen);


        // Check if the user is logged in
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            // User is logged in, redirect to home2.xml page
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(launchscreen.this, home.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000); // 2000 milliseconds
        } else {
            // User is not logged in, redirect to login page
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(launchscreen.this, LoginPage.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000); // 2000 milliseconds
        }




    }

    }
