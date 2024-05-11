package com.example.calmshperef1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calmshperef1.model.Booking;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class appointment_timeslots extends AppCompatActivity {
    private static final String TAG = "AppointmentTimeslots";

    private TextView text;
    private TextView text1;
    private TextView text2;

    public String selectedDate;
    public String selectedTime;
    public String drName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_timeslots);

//        Intent intent = getIntent();

//        text2 = findViewById(R.id.DrName);


        drName = getIntent().getStringExtra("text" );
        text2 = findViewById(R.id.DrName);
        text2.setText(drName);

        text = findViewById(R.id.apntdate);
        Button button = findViewById(R.id.date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        text1 = findViewById(R.id.timeslot);
        Button button1 = findViewById(R.id.date1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog1();
            }
        });

        // Assuming you have a button named confirmButton
        Button confirmButton = findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                saveBookingDataToFirestore();
                // Check if date and time are selected
                if (selectedDate != null && selectedTime != null) {
                    // Call the method to save booking data to Firestore
                    saveBookingDataToFirestore();

                    // Start the next activity
                    Intent intent = new Intent(appointment_timeslots.this, Choosebooking.class);
                    intent.putExtra("doctorname",drName);
                    startActivity(intent);
                } else {
                    // Provide feedback to the user that date and time need to be selected
                    Toast.makeText(appointment_timeslots.this, "Please select date and time", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }



    private void openDialog() {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                selectedDate = String.format("%s / %s / %s", year, (month + 1), dayOfMonth);
                text.setText(selectedDate);
//                Toast.makeText(this, selectedDate, Toast.LENGTH_SHORT).show();

            }
        }, 2024, 0, 10);

        dialog.show();

    }

    private void openDialog1() {
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                selectedTime = String.format("%s : %s", String.valueOf(hourOfDay), String.valueOf(minute));
                text1.setText(selectedTime);
//                Toast.makeText(this, selectedTime, Toast.LENGTH_SHORT).show();
            }
        }, 11, 11, true);

        dialog.show();
    }
    private void saveBookingDataToFirestore() {
//        String drName = "Dr. Smith";
//        String selectedDate = "2024-05-01";
//        String selectedTime = "09:00 AM";

        // Create an instance of FirebaseFirestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Create a Booking object with the data to be saved
        Booking booking = new Booking(drName, selectedDate, selectedTime);
        String UserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Add a new document with a generated ID to the "bookings" collection
        db.collection("booking")
                .document(UserId) // Use the UID as the document ID
                .set(booking) // Set the UserModel object as the document data
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(appointment_timeslots.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "User document added successfully with ID: " + UserId);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(appointment_timeslots.this, "Booking Failed", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Error adding user document", e);
                    }
                });





//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                          @Override
//                                          public void onSuccess(Void unused) {
//                                              Toast.makeText(appointment_timeslots.this, "Booking Successful", Toast.LENGTH_SHORT).show();
//                                              Log.d(TAG, "DocumentSnapshot added with ID");
//                                          }
//                                      }).addOnFailureListener(OnFailureListener)
//
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        // Handle success
//                        Toast.makeText(appointment_timeslots.this, "Booking Successful", Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Handle failures
//                        Toast.makeText(appointment_timeslots.this, "Booking Failed", Toast.LENGTH_SHORT).show();
//                        Log.w(TAG, "Error adding document", e);
//                    }
//                });
    }

}
