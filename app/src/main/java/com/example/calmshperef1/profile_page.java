package com.example.calmshperef1;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class profile_page extends AppCompatActivity {
    public TextView displaytext;
    public FirebaseAuth mAuth;
    
    public FirebaseFirestore db;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Add a click listener to your logout button
        Button logoutButton = findViewById(R.id.logoutBtn);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the logout function when the button is clicked
                logout();
            }
        });


        //For displaying Name
        displaytext = findViewById(R.id.displayname);
        db = FirebaseFirestore.getInstance();
        FirebaseAuth mauth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mauth.getCurrentUser();
        if (currentUser != null) {
            String userid = Objects.requireNonNull(mauth.getCurrentUser()).getUid();

            DocumentReference userRef = db.collection("users").document(userid);
            userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        // Document exists, extract user's name
                        String userName = documentSnapshot.getString("name");
                        // Display the user's name on the welcomeTextView
                        displaytext.setText(userName);
                        Toast.makeText(profile_page.this, "", Toast.LENGTH_SHORT).show();
                    } else {
                        // Document does not exist
                        Log.d(TAG, "No such document");
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // Error retrieving user document
                    Log.e(TAG, "Error getting user document", e);
                }
            });

        } else {
            // Handle the case where the current user is null (not authenticated)
            // For example, display a message to the user or redirect to the login screen
            Log.d(TAG, "Current user is null, authentication required");
            // You may want to navigate back to the login screen or display a message to the user
        }
    }

        private void logout () {
            mAuth.signOut();
            // After signing out, redirect the user to the login page
            Intent intent = new Intent(profile_page.this, LoginPage.class);
            // Clear the back stack to prevent the user from navigating back to the home2.xml page
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            // Finish the current activity (home2.xml page) to prevent going back when logged out
            finish();
        }


    }

