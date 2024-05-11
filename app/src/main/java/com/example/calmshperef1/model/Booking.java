package com.example.calmshperef1.model;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Booking {
    private String doctorName;
    private String selectedDate;
    private String selectedTime;

    public Booking() {
        // Default constructor required for Firestore
    }

    public Booking(String doctorName, String selectedDate, String selectedTime) {
        this.doctorName = doctorName;
        this.selectedDate = selectedDate;
        this.selectedTime = selectedTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime;
    }
}
