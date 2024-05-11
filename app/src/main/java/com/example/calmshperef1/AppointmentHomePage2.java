package com.example.calmshperef1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AppointmentHomePage2 extends AppCompatActivity {
    public FirebaseAuth mauth;
    public FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_appointment_home_page2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//for bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        Button Book = findViewById(R.id.buttonbook);
        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to open MediationActivity
                Intent intent = new Intent(AppointmentHomePage2.this, ChooseTherapist.class);
                // Start the activity
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
//                    Drawable selectedIcon = item.getIcon();
//                    int color = Color.parseColor("#FF00FF"); // Replace "#FF00FF" with your hexadecimal color
//                    selectedIcon.setTint(color);
//                    item.setIcon(selectedIcon);
                    if (itemId == R.id.home) {
                        // Navigate to HomeActivity
                        Intent homeIntent = new Intent(AppointmentHomePage2.this, home.class);
                        startActivity(homeIntent);


                        return true;
                    } else if (itemId == R.id.contentLibrary) {
                        // Navigate to ContentLibraryActivity
                        Intent contentLibraryIntent = new Intent(AppointmentHomePage2.this, ContentLibrary.class);
                        startActivity(contentLibraryIntent);
                        return true;
                    } else if (itemId == R.id.chatbot) {
                        // Navigate to ChatbotActivity
                        Intent chatbotIntent = new Intent(AppointmentHomePage2.this, AppointmentHomePage2.class);
                        startActivity(chatbotIntent);
                        return true;
                    } else if (itemId == R.id.community) {
                        // Navigate to CommunityActivity
                        Intent communityIntent = new Intent(AppointmentHomePage2.this, safe_space.class);
                        startActivity(communityIntent);
                        return true;
                    }
                    return false;
                }
            };
//
//    private void fetchLatestBookingDetails() {
//
//        mauth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance();
//        if (mauth == null) {
//            Log.e(TAG, "FirebaseAuth instance is null");
//            return;
//        }
//
//        FirebaseUser currentUser = mauth.getCurrentUser();
//        if (currentUser == null) {
//            Log.d(TAG, "Current user is null, authentication required");
//            return;
//        }
//
//        String userId = currentUser.getUid();
//
//        if (db == null) {
//            Log.e(TAG, "FirebaseFirestore instance is null");
//            return;
//        }
//
//        DocumentReference userRef = db.collection("booking").document(userId);
//        userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if (documentSnapshot.exists()) {
//
//                    String doctorName = documentSnapshot.getString("doctorName");
//                    String selectedDate = documentSnapshot.getString("selectedDate");
//                    String selectedTime = documentSnapshot.getString("selectedTime");
//                    TextView doctorNameTextView = findViewById(R.id.LatestDrName);
//                    TextView selectedDateTextView = findViewById(R.id.LatestDate);
//                    TextView selectedTimeTextView = findViewById(R.id.LatestTime);
//                    doctorNameTextView.setText(doctorName);
//                    selectedDateTextView.setText(selectedDate);
//                    selectedTimeTextView.setText(selectedTime);
//                    Toast.makeText(AppointmentHomePage2.this, "pass", Toast.LENGTH_SHORT).show();
//                } else {
//
//                    Log.d(TAG, "No such document1");
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.e(TAG, "Error getting user document", e);
//            }
//        });
//    }



}