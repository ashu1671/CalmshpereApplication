package com.example.calmshperef1;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class ReviewSummary extends AppCompatActivity implements PaymentResultListener
{
    private Button btnPayNow;
    private EditText editAmount;
    //    private TextView TotalAmount;
    private TextView txtPaymentStatus , t4 , t5;

    private FirebaseAuth mauth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_summary);

        btnPayNow = findViewById(R.id.button5);
//        TotalAmount = findViewById(R.id.Totalamt);
        editAmount = findViewById(R.id.editAmount);
        txtPaymentStatus = findViewById(R.id.paymentStatus);
        t4 = findViewById(R.id.dcname);
        t5=findViewById(R.id.dater);




        mauth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        FirebaseUser currentUser = mauth.getCurrentUser();
//        userid = currentUser.getUid();
        if (currentUser != null) {
            String userid = currentUser.getUid();

            DocumentReference userRef = db.collection("booking").document(userid);
            userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        String username = documentSnapshot.getString("doctorName");
                        String datee = documentSnapshot.getString("selectedDate");
                        if (username != null) {
                            t4.setText(username);
                            t5.setText(datee);
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
        }
            else {
                Log.d(TAG, "Current user is null, authentication required");
                // Handle the case where the current user is null (not authenticated)
                // For example, display a message to the user or redirect to the login screen
                // You may want to navigate back to the login screen or display a message to the user
            }




        Checkout.preload(ReviewSummary.this);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve amount from EditText field
//                String amountString = TotalAmount.getText().toString();
                String amountString = editAmount.getText().toString();
//                if (!amountString.isEmpty()) {
                int amount = Integer.parseInt(amountString);
                startPayment(amount);
//                } else {
//                    Toast.makeText(ReviewSummary.this, "Please enter a valid amount.", Toast.LENGTH_LONG).show();
//                }
            }
        });


//        payNowButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }
    public void startPayment(int amountInRupees){
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_MwFMUrmWHbhXp0");
        try{
            int amountInPaisa = amountInRupees * 100; // Convert rupees to paisa
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "RazorPay Demo");
            jsonObject.put("description", "Pay to book appointment");
            jsonObject.put("theme.color", "#3399cc");
            jsonObject.put("currency", "INR");
            jsonObject.put("amount", amountInPaisa); // Pass amount in paisa

            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4 );
            jsonObject.put("retry", retryObj);

            checkout.open(ReviewSummary.this, jsonObject);
        } catch (Exception e){
            Toast.makeText(ReviewSummary.this, "Something went wrong!!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        txtPaymentStatus.setText(s);
        Toast.makeText(this, "Payment Successfull", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ReviewSummary.this, paymentsuccessful.class);
        startActivity(intent);

    }
    @Override
    public void onPaymentError(int i, String s){
        txtPaymentStatus.setText("Error : " + s);
        Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();
    }
}