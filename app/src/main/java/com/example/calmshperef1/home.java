//// MyCustomLayoutActivity.java
//package com.example.calmshperef1;
//
//import static android.content.ContentValues.TAG;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FieldPath;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.Query;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//import com.google.firebase.firestore.QuerySnapshot;
//
//import java.util.Objects;
//
//
//public class home extends AppCompatActivity {
//
//    public TextView displaytext;
//    public FirebaseAuth mauth;
//    public FirebaseFirestore db;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
////        setContentView(R.layout.home1);
//        fetchLatestBookingDetails();
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        Button buttonHappy = findViewById(R.id.buttonHappy);
//        Button buttonCalm = findViewById(R.id.buttonCalm);
//        Button buttonSad = findViewById(R.id.buttonSad);
//        Button buttonAngry = findViewById(R.id.buttonAngry);
////for bottom navigation
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
//
//
//        // Toast messages for moods
//        buttonHappy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Generate toast message for button2
//                Toast.makeText(home.this, "Button Happy clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        buttonCalm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Generate toast message for buttonCalm
//                Toast.makeText(home.this, "Button Calm clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        buttonSad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Generate toast message for buttonSad
//                Toast.makeText(home.this, "Button Sad clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        buttonAngry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Generate toast message for buttonAngry
//                Toast.makeText(home.this, "Button Angry clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
////For displaying Name
//        displaytext = findViewById(R.id.displayname);
//        mauth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance();
//
//        FirebaseUser currentUser = mauth.getCurrentUser();
//        if (currentUser != null) {
//            String userid = Objects.requireNonNull(mauth.getCurrentUser()).getUid();
//
//            DocumentReference userRef = db.collection("users").document(userid);
//            userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                @Override
//                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                    if (documentSnapshot.exists()) {
//                        // Document exists, extract user's name
//                        String userName = documentSnapshot.getString("name");
//                        // Display the user's name on the welcomeTextView
//                        displaytext.setText(userName);
//                        Toast.makeText(home.this, "", Toast.LENGTH_SHORT).show();
//                    } else {
//                        // Document does not exist
//                        Log.d(TAG, "No such document1");
//                    }
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    // Error retrieving user document
//                    Log.e(TAG, "Error getting user document1", e);
//                }
//            });
//
//        } else {
//            // Handle the case where the current user is null (not authenticated)
//            // For example, display a message to the user or redirect to the login screen
//            Log.d(TAG, "Current user is null, authentication required");
//            // You may want to navigate back to the login screen or display a message to the user
//        }
//
//
//
//
//
//
////        Setting intents
//
//        Button buttonActivity = findViewById(R.id.buttonActivity);
//        buttonActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create intent to open MediationActivity
//                Intent intent = new Intent(home.this, Meditation.class);
//                // Start the activity
//                startActivity(intent);
//            }
//        });
//
//        Button Safespace = findViewById(R.id.SafeSpacebutton);
//        Safespace.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create intent to open MediationActivity
//                Intent intent = new Intent(home.this, safe_space.class);
//                // Start the activity
//                startActivity(intent);
//            }
//        });
//        Button Book = findViewById(R.id.buttonbook);
//        Book.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create intent to open MediationActivity
//                Intent intent = new Intent(home.this, ChooseTherapist.class);
//                // Start the activity
//                startActivity(intent);
//            }
//        });
//
//        ImageButton profile = findViewById(R.id.ProfileBtn);
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create intent to open MediationActivity
//                Intent intent = new Intent(home.this, profile_page.class);
//                // Start the activity
//                startActivity(intent);
//            }
//        });
//
//        Button Startconversation = findViewById(R.id.buttonStartConversation);
//        Startconversation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create intent to open MediationActivity
//                Intent intent = new Intent(home.this, Chatbot.class);
//                // Start the activity
//                startActivity(intent);
//            }
//        });
//
//        Button Readmore = findViewById(R.id.buttonReadMore);
//        Readmore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create intent to open MediationActivity
//                Intent intent = new Intent(home.this, read_articles.class);
//                // Start the activity
//                startActivity(intent);
//            }
//        });
//
//        fetchLatestBookingDetails();
//
//
//    }
//
//
//    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    int itemId = item.getItemId();
//                    if (itemId == R.id.home) {
//                        // Navigate to HomeActivity
//                        Intent homeIntent = new Intent(home.this, home.class);
//                        startActivity(homeIntent);
//
//                        // Change the icon tint for the selected item to the desired color
//                        Drawable selectedIcon = item.getIcon();
//                        int color = Color.parseColor("#FF00FF"); // Replace "#FF00FF" with your hexadecimal color
//                        selectedIcon.setTint(color);
//                        item.setIcon(selectedIcon);
//
//                        return true;
//                    } else if (itemId == R.id.contentLibrary) {
//                        // Navigate to ContentLibraryActivity
//                        Intent contentLibraryIntent = new Intent(home.this, ContentLibrary.class);
//                        startActivity(contentLibraryIntent);
//                        return true;
//                    } else if (itemId == R.id.chatbot) {
//                        // Navigate to ChatbotActivity
//                        Intent chatbotIntent = new Intent(home.this, Chatbot.class);
//                        startActivity(chatbotIntent);
//                        return true;
//                    } else if (itemId == R.id.community) {
//                        // Navigate to CommunityActivity
//                        Intent communityIntent = new Intent(home.this, safe_space.class);
//                        startActivity(communityIntent);
//                        return true;
//                    }
//                    return false;
//                }
//            };
//
//
//        UpComingBookings
//
//    private void fetchLatestBookingDetails() {
//        // Get the current user's UID
//        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        // Reference to the "bookings" collection in Firestore
//        db.collection("booking")
//                .whereEqualTo("userId", userId) // Filter bookings by user ID
//                .orderBy(FieldPath.documentId(), Query.Direction.DESCENDING) // Order by document ID in descending order
//                .limit(1)
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                // Retrieve the latest added doctorName, selectedDate, and selectedTime from the document
//                                String doctorName = document.getString("doctorName");
//                                String selectedDate = document.getString("selectedDate");
//                                String selectedTime = document.getString("selectedTime");
//
//                                // Set the values in the respective TextViews
//                                TextView doctorNameTextView = findViewById(R.id.LatestDrName);
//                                TextView selectedDateTextView = findViewById(R.id.LatestDate);
//                                TextView selectedTimeTextView = findViewById(R.id.LatestTime);
//
//                                doctorNameTextView.setText(doctorName);
//                                selectedDateTextView.setText(selectedDate);
//                                selectedTimeTextView.setText(selectedTime);
//                                Log.d(TAG, "done etna", task.getException());
//                                Toast.makeText(home.this, "Appointment Updated", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(home.this, "Failed App", Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "Error getting documents: 1", task.getException());
//                        }
//                    }
//                });
//    }
//
//    private void fetchLatestBookingDetails() {
//        // Get the current user's UID
//        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        // Reference to the "bookings" collection in Firestore
//        db.collection("booking")
//                .whereEqualTo("userId", userId) // Filter bookings by user ID
//                .orderBy(FieldPath.documentId(), Query.Direction.DESCENDING) // Order by document ID in descending order
//                .limit(1)
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            if (task.getResult().isEmpty()) {
//                                // No bookings found, switch to home2.xml
//                                setContentView(R.layout.home2);
//                            } else {
//                                setContentView(R.layout.home1);
//                                for (QueryDocumentSnapshot document : task.getResult()) {
//                                    // Retrieve the latest added doctorName, selectedDate, and selectedTime from the document
//                                    String doctorName = document.getString("doctorName");
//                                    String selectedDate = document.getString("selectedDate");
//                                    String selectedTime = document.getString("selectedTime");
//
//                                    // Set the values in the respective TextViews
//                                    TextView doctorNameTextView = findViewById(R.id.LatestDrName);
//                                    TextView selectedDateTextView = findViewById(R.id.LatestDate);
//                                    TextView selectedTimeTextView = findViewById(R.id.LatestTime);
//
//                                    doctorNameTextView.setText(doctorName);
//                                    selectedDateTextView.setText(selectedDate);
//                                    selectedTimeTextView.setText(selectedTime);
//                                    Log.d(TAG, "done etna", task.getException());
//                                    Toast.makeText(home.this, "Appointment Updated", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        } else {
//                            Toast.makeText(home.this, "Failed App", Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "Error getting documents: 1", task.getException());
//                        }
//                    }
//                });
//    }
//
//
//
//}





package com.example.calmshperef1;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;


public class home extends AppCompatActivity {

        public TextView displaytext;
        public FirebaseAuth mauth;
        public FirebaseFirestore db;


        @Override
        protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);

                fetchLatestBookingDetails();

        }

        private void initializeHome1Views() {
                setContentView(R.layout.home1);
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                        return insets;
                });

                Button buttonHappy = findViewById(R.id.buttonHappy);
                Button buttonCalm = findViewById(R.id.buttonCalm);
                Button buttonSad = findViewById(R.id.buttonSad);
                Button buttonAngry = findViewById(R.id.buttonAngry);
//for bottom navigation
                BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
                bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


                // Toast messages for moods
                buttonHappy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Generate toast message for button2
                                Toast.makeText(home.this, "Woah You're Happy! Try our chatbot, connect in chatrooms, explore content!", Toast.LENGTH_SHORT).show();
                        }
                });

                buttonCalm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Generate toast message for buttonCalm
                                Toast.makeText(home.this, "Glad you're calm! Chatbot for stress, chatrooms for sharing, content for wellness!", Toast.LENGTH_SHORT).show();
                        }
                });

                buttonSad.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Generate toast message for buttonSad
                                Toast.makeText(home.this, "Sorry you're sad.Chatbot for support, chatrooms for connection, content for uplift", Toast.LENGTH_SHORT).show();
                        }
                });

                buttonAngry.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Generate toast message for buttonAngry
                                Toast.makeText(home.this, "Understand your anger.Chatbot for emotions, chatrooms for support, content for managing!", Toast.LENGTH_SHORT).show();
                        }
                });

//For displaying Name
                displaytext = findViewById(R.id.displayname);
                mauth = FirebaseAuth.getInstance();
                db = FirebaseFirestore.getInstance();

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
                                                Toast.makeText(home.this, "", Toast.LENGTH_SHORT).show();
                                        } else {
                                                // Document does not exist
                                                Log.d(TAG, "No such document1");
                                        }
                                }
                        }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                        // Error retrieving user document
                                        Log.e(TAG, "Error getting user document1", e);
                                }
                        });

                } else {
                        // Handle the case where the current user is null (not authenticated)
                        // For example, display a message to the user or redirect to the login screen
                        Log.d(TAG, "Current user is null, authentication required");
                        // You may want to navigate back to the login screen or display a message to the user
                }


//        Setting intents

                Button buttonActivity = findViewById(R.id.buttonActivity);
                buttonActivity.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Create intent to open MediationActivity
                                Intent intent = new Intent(home.this, Meditation.class);
                                // Start the activity
                                startActivity(intent);
                        }
                });

                Button Safespace = findViewById(R.id.SafeSpacebutton);
                Safespace.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Create intent to open MediationActivity
                                Intent intent = new Intent(home.this, safe_space.class);
                                // Start the activity
                                startActivity(intent);
                        }
                });
                Button Book = findViewById(R.id.buttonbook);
                Book.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Create intent to open MediationActivity
                                Intent intent = new Intent(home.this, AppointmentHomePage2.class);
                                // Start the activity
                                startActivity(intent);
                        }
                });

                ImageButton profile = findViewById(R.id.ProfileBtn);
                profile.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Create intent to open MediationActivity
                                Intent intent = new Intent(home.this, profile_page.class);
                                // Start the activity
                                startActivity(intent);
                        }
                });

                Button Startconversation = findViewById(R.id.buttonStartConversation);
                Startconversation.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                openWebPage("https://mediafiles.botpress.cloud/1b11a409-01d1-48ec-ae08-1ca8d74099db/webchat/bot.html");
                        }
                });


                Button Readmore = findViewById(R.id.buttonReadMore);
                Readmore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Create intent to open MediationActivity
                                Intent intent = new Intent(home.this, read_articles.class);
                                // Start the activity
                                startActivity(intent);
                        }
                });

                Button seeDetails = findViewById(R.id.seeDetails);
                seeDetails.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                                // Create intent to open MediationActivity
                                Intent intent = new Intent(home.this, Detailandcancel.class);
                                // Start the activity
                                startActivity(intent);
                        }
                });

                ImageButton buttonSOS = findViewById(R.id.buttonSOS);
                buttonSOS.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                                // Create intent to open MediationActivity
                                Intent intent = new Intent(home.this, SOS.class);
                                // Start the activity
                                startActivity(intent);
                        }
                });

        }

//        private void openWebPage(String url) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                        startActivity(intent);
//                }
//        }
        private BottomNavigationView.OnNavigationItemSelectedListener navListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                int itemId = item.getItemId();
                                // Change the icon tint for the selected item to the desired color

                                if (itemId == R.id.home) {
                                        // Navigate to HomeActivity
                                        Intent homeIntent = new Intent(home.this, home.class);
                                        startActivity(homeIntent);
                                        return true;
                                } else if (itemId == R.id.contentLibrary) {
                                        // Navigate to ContentLibraryActivity
                                        Intent contentLibraryIntent = new Intent(home.this, ContentLibrary.class);
                                        startActivity(contentLibraryIntent);
                                        return true;
                                } else if (itemId == R.id.chatbot) {
                                        // Navigate to ChatbotActivity
                                        Intent chatbotIntent = new Intent(home.this, AppointmentHomePage2.class);
                                        startActivity(chatbotIntent);
                                        return true;
                                } else if (itemId == R.id.community) {
                                        // Navigate to CommunityActivity
                                        Intent communityIntent = new Intent(home.this, safe_space.class);
                                        startActivity(communityIntent);
                                        return true;
                                }
                                return false;
                        }
                };


//private BottomNavigationView.OnNavigationItemSelectedListener navListener =
//        new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        int itemId = item.getItemId();
//                        // Change the icon tint for the selected item to the desired color
//                        Drawable selectedIcon = item.getIcon();
//                        int color = Color.parseColor("#FF00FF"); // Replace "#FF00FF" with your hexadecimal color
//
//                        if (itemId == R.id.home) {
//                                // Navigate to HomeActivity
//                                Intent homeIntent = new Intent(home.this, home.class);
//                                startActivity(homeIntent);
//
//                                // Set the tint only for the selected item
//                                selectedIcon.setTint(color);
//                                item.setIcon(selectedIcon);
//
//                                return true;
//                        } else if (itemId == R.id.contentLibrary) {
//                                // Navigate to ContentLibraryActivity
//                                Intent contentLibraryIntent = new Intent(home.this, ContentLibrary.class);
//                                startActivity(contentLibraryIntent);
//
//                                // Set the tint only for the selected item
//                                selectedIcon.setTint(color);
//                                item.setIcon(selectedIcon);
//
//                                return true;
//                        } else if (itemId == R.id.chatbot) {
//                                // Navigate to ChatbotActivity
//                                Intent chatbotIntent = new Intent(home.this, AppointmentHomePage2.class);
//                                startActivity(chatbotIntent);
//
//                                // Set the tint only for the selected item
//                                selectedIcon.setTint(color);
//                                item.setIcon(selectedIcon);
//
//                                return true;
//                        } else if (itemId == R.id.community) {
//                                // Navigate to CommunityActivity
//                                Intent communityIntent = new Intent(home.this, safe_space.class);
//                                startActivity(communityIntent);
//
//                                // Set the tint only for the selected item
//                                selectedIcon.setTint(color);
//                                item.setIcon(selectedIcon);
//
//                                return true;
//                        }
//                        return false;
//                }
//        };

        private void initializeHome2Views() {
        setContentView(R.layout.home2);

 ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
         Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
         v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
         return insets;
         });

         Button buttonHappy = findViewById(R.id.buttonHappy);
         Button buttonCalm = findViewById(R.id.buttonCalm);
         Button buttonSad = findViewById(R.id.buttonSad);
         Button buttonAngry = findViewById(R.id.buttonAngry);
//for bottom navigation
         BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
         bottomNavigationView.setOnNavigationItemSelectedListener(navListener);



                // Toast messages for moods
                buttonHappy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Generate toast message for button2
                                Toast.makeText(home.this, "Woah You're Happy! Try our chatbot, connect in chatrooms, explore content!", Toast.LENGTH_SHORT).show();
                        }
                });

                buttonCalm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Generate toast message for buttonCalm
                                Toast.makeText(home.this, "Glad you're calm! Chatbot for stress, chatrooms for sharing, content for wellness!", Toast.LENGTH_SHORT).show();
                        }
                });

                buttonSad.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Generate toast message for buttonSad
                                Toast.makeText(home.this, "Sorry you're sad.Chatbot for support, chatrooms for connection, content for uplift", Toast.LENGTH_SHORT).show();
                        }
                });
                buttonAngry.setOnClickListener(new View.OnClickListener() {
                        @Override 
                        public void onClick(View v) {
                                // Generate toast message for buttonAngry
                                Toast.makeText(home.this, "Understand your anger.Chatbot for emotions, chatrooms for support, content for managing!", Toast.LENGTH_SHORT).show();
                        }
                });

//For displaying Name
        displaytext = findViewById(R.id.displayname);
        mauth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

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
        Toast.makeText(home.this, "", Toast.LENGTH_SHORT).show();
        } else {
        // Document does not exist
        Log.d(TAG, "No such document1");
        }
        }
        }).addOnFailureListener(new OnFailureListener() {
@Override
public void onFailure(@NonNull Exception e) {
        // Error retrieving user document
        Log.e(TAG, "Error getting user document1", e);
        }
        });

        } else {
        // Handle the case where the current user is null (not authenticated)
        // For example, display a message to the user or redirect to the login screen
        Log.d(TAG, "Current user is null, authentication required");
        // You may want to navigate back to the login screen or display a message to the user
        }






//        Setting intents

        Button buttonActivity = findViewById(R.id.buttonActivity);
        buttonActivity.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        // Create intent to open MediationActivity
        Intent intent = new Intent(home.this, Meditation.class);
        // Start the activity
        startActivity(intent);
        }
        });

        Button Safespace = findViewById(R.id.SafeSpacebutton);
        Safespace.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        // Create intent to open MediationActivity
        Intent intent = new Intent(home.this, safe_space.class);
        // Start the activity
        startActivity(intent);
        }
        });
        Button Book = findViewById(R.id.buttonbook);
        Book.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        // Create intent to open MediationActivity
        Intent intent = new Intent(home.this, AppointmentHomePage2.class);
        // Start the activity
        startActivity(intent);
        }
        });

        ImageButton profile = findViewById(R.id.ProfileBtn);
        profile.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        // Create intent to open MediationActivity
        Intent intent = new Intent(home.this, profile_page.class);
        // Start the activity
        startActivity(intent);
        }
        });

        Button Startconversation = findViewById(R.id.buttonStartConversation);
        Startconversation.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        openWebPage("https://mediafiles.botpress.cloud/1b11a409-01d1-48ec-ae08-1ca8d74099db/webchat/bot.html");
        }
        });

        Button Readmore = findViewById(R.id.buttonReadMore);
        Readmore.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
        // Create intent to open MediationActivity
        Intent intent = new Intent(home.this, read_articles.class);
        // Start the activity
        startActivity(intent);
        }
        });
                ImageButton buttonSOS = findViewById(R.id.buttonSOS);
                buttonSOS.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                                // Create intent to open MediationActivity
                                Intent intent = new Intent(home.this, SOS.class);
                                // Start the activity
                                startActivity(intent);
                        }
                });




        }

        private void openWebPage(String url) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                }
        }
private BottomNavigationView.OnNavigationItemSelectedListener navListener2 =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
@Override
public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        // Change the icon tint for the selected item to the desired color
//        Drawable selectedIcon = item.getIcon();
//        int color = Color.parseColor("#FF00FF"); // Replace "#FF00FF" with your hexadecimal color
//        selectedIcon.setTint(color);
//        item.setIcon(selectedIcon);

        if (itemId == R.id.home) {
        // Navigate to HomeActivity
        Intent homeIntent = new Intent(home.this, home.class);
        startActivity(homeIntent);


        return true;
        } else if (itemId == R.id.contentLibrary) {
        // Navigate to ContentLibraryActivity
        Intent contentLibraryIntent = new Intent(home.this, ContentLibrary.class);
        startActivity(contentLibraryIntent);
        return true;
        } else if (itemId == R.id.chatbot) {
        // Navigate to ChatbotActivity
        Intent chatbotIntent = new Intent(home.this, AppointmentHomePage2.class);
        startActivity(chatbotIntent);
        return true;
        } else if (itemId == R.id.community) {
        // Navigate to CommunityActivity
        Intent communityIntent = new Intent(home.this, safe_space.class);
        startActivity(communityIntent);
        return true;
        }
        return false;
        }
        };




private void fetchLatestBookingDetails() {
        mauth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        if (mauth == null) {
                Log.e(TAG, "FirebaseAuth instance is null");
                return;
        }

        FirebaseUser currentUser = mauth.getCurrentUser();
        if (currentUser == null) {
                Log.d(TAG, "Current user is null, authentication required");
                return;
        }

        String userId = currentUser.getUid();

        if (db == null) {
                Log.e(TAG, "FirebaseFirestore instance is null");
                return;
        }

        DocumentReference userRef = db.collection("booking").document(userId);
        userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                                initializeHome1Views();
                                String doctorName = documentSnapshot.getString("doctorName");
                                String selectedDate = documentSnapshot.getString("selectedDate");
                                String selectedTime = documentSnapshot.getString("selectedTime");
                                TextView doctorNameTextView = findViewById(R.id.LatestDrName);
                                TextView selectedDateTextView = findViewById(R.id.LatestDate);
                                TextView selectedTimeTextView = findViewById(R.id.LatestTime);
                                doctorNameTextView.setText(doctorName);
                                selectedDateTextView.setText(selectedDate);
                                selectedTimeTextView.setText(selectedTime);
                                Toast.makeText(home.this, "pass", Toast.LENGTH_SHORT).show();
                        } else {
                                initializeHome2Views();
                                Log.d(TAG, "No such document1");
                        }
                }
        }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Error getting user document", e);
                }
        });
}



}



