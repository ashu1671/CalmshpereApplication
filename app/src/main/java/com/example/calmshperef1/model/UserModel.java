package com.example.calmshperef1.model;


import com.google.firebase.Timestamp;

public class UserModel {

    private String name;
    private String email;
    private Timestamp createdTimestamp;

    public UserModel() {
        // Default constructor required for Firestore
    }

    public UserModel(String name, String email, Timestamp createdTimestamp) {
        this.name = name;
        this.email = email;
        this.createdTimestamp = createdTimestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }


}