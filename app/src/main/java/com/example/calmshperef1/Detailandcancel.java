package com.example.calmshperef1;

import static android.content.ContentValues.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

public class Detailandcancel extends AppCompatActivity {
    public TextView t1, t2, t3, t4;
    public String Dr, userid;

    public Button b1;

    private FirebaseAuth mauth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detailandcancel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        t1 = findViewById(R.id.displaydoctorname);
        t2 = findViewById(R.id.getdatefrombefore);
        t3 = findViewById(R.id.gettimefrombefore);
        t4 = findViewById(R.id.patientinfoname);
        b1 = findViewById(R.id.cancelbutton);

        mauth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        FirebaseUser currentUser = mauth.getCurrentUser();
//        userid = currentUser.getUid();
        if (currentUser != null) {
            userid = currentUser.getUid();

            DocumentReference userRef = db.collection("users").document(userid);
            userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        String username = documentSnapshot.getString("name");
                        if (username != null) {
                            t4.setText(username);
                        } else {
                            Log.d(TAG, "Username is null");
                        }
                    } else {
                        Log.d(TAG, "User document does not exist");
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e(TAG, "Error getting user document", e);
                }
            });

            DocumentReference bookingRef = db.collection("booking").document(userid);
            bookingRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        String doctorname = documentSnapshot.getString("doctorName");
                        String selectedDate = documentSnapshot.getString("selectedDate");
                        String selectedTime = documentSnapshot.getString("selectedTime");
                        if (doctorname != null && selectedDate != null && selectedTime != null) {
                            t1.setText(doctorname);
                            t2.setText(selectedDate);
                            t3.setText(selectedTime);
                        } else {
                            Log.d(TAG, "Doctor name, selected date, or selected time is null");
                        }
                    } else {
                        Log.d(TAG, "Booking document does not exist");
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e(TAG, "Error getting booking document", e);
                }
            });
        } else {
            Log.d(TAG, "Current user is null, authentication required");
            // Handle the case where the current user is null (not authenticated)
            // For example, display a message to the user or redirect to the login screen
            // You may want to navigate back to the login screen or display a message to the user
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancelConfirmationDialog(userid);
            }
        });
    }
    private void showCancelConfirmationDialog(String userid) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cancel Appointment");
        builder.setMessage("Are you sure you want to cancel this appointment?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Perform cancellation logic here
                removedat(userid);
                Toast.makeText(Detailandcancel.this, "Appointment canceled", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Detailandcancel.this , home.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User clicked No, do nothing or dismiss the dialog
                dialog.dismiss();
            }
        });
        builder.show();

    }
    private void removedat(String useri) {

        // Get a reference to the document you want to delete
        DocumentReference docRef = db.collection("booking").document(userid);

        // Delete the document
        docRef.delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully deleted");
                        // Document successfully deleted
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error deleting document", e);
                        // An error occurred while deleting the document
                    }
                });
    }

}
