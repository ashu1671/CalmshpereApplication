package com.example.calmshperef1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class safe_space extends AppCompatActivity {
    ImageButton i1, i2, i3, i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safe_space);

        i4 = findViewById(R.id.anxietysprt);
        i1 = findViewById(R.id.depressionsprt);
        i2 = findViewById(R.id.bipolarsprt);
        i3 = findViewById(R.id.griefsprt);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //for bottom navigation

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);



        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(safe_space.this, anxiety_community_page.class);
                startActivity(intent);
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(safe_space.this, depression_community_page.class);
                startActivity(intent);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(safe_space.this, grief_community_page.class);
                startActivity(intent);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(safe_space.this, bipolar_community_page.class);
                startActivity(intent);
            }
        });
    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();
                    // Change the icon tint for the selected item to the desired color

                    if (itemId == R.id.home) {
                        // Navigate to HomeActivity
                        Intent homeIntent = new Intent(safe_space.this, home.class);
                        startActivity(homeIntent);


                        return true;
                    } else if (itemId == R.id.contentLibrary) {
                        // Navigate to ContentLibraryActivity
                        Intent contentLibraryIntent = new Intent(safe_space.this, ContentLibrary.class);
                        startActivity(contentLibraryIntent);

                        return true;
                    } else if (itemId == R.id.chatbot) {
                        // Navigate to ChatbotActivity
                        Intent chatbotIntent = new Intent(safe_space.this, AppointmentHomePage2.class);
                        startActivity(chatbotIntent);

                        return true;
                    } else if (itemId == R.id.community) {
                        // Navigate to CommunityActivity
                        Intent communityIntent = new Intent(safe_space.this, safe_space.class);
                        startActivity(communityIntent);
                        return true;
                    }
                    return false;
                }
            };




}
