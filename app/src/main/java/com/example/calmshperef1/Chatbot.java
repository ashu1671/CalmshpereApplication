package com.example.calmshperef1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Chatbot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chatbot);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //for bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();
                    if (itemId == R.id.home) {
                        // Navigate to HomeActivity
                        Intent homeIntent = new Intent(Chatbot.this, home.class);
                        startActivity(homeIntent);

                        // Change the icon tint for the selected item to the desired color
                        Drawable selectedIcon = item.getIcon();
                        int color = Color.parseColor("#FF00FF"); // Replace "#FF00FF" with your hexadecimal color
                        selectedIcon.setTint(color);
                        item.setIcon(selectedIcon);

                        return true;
                    } else if (itemId == R.id.contentLibrary) {
                        // Navigate to ContentLibraryActivity
                        Intent contentLibraryIntent = new Intent(Chatbot.this, ContentLibrary.class);
                        startActivity(contentLibraryIntent);
                        return true;
                    } else if (itemId == R.id.chatbot) {
                        // Navigate to ChatbotActivity
                        Intent chatbotIntent = new Intent(Chatbot.this, Chatbot.class);
                        startActivity(chatbotIntent);
                        return true;
                    } else if (itemId == R.id.community) {
                        // Navigate to CommunityActivity
                        Intent communityIntent = new Intent(Chatbot.this, safe_space.class);
                        startActivity(communityIntent);
                        return true;
                    }
                    return false;
                }
            };
}