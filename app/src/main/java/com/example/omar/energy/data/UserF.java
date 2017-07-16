package com.example.omar.energy.data;
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by omar on 15/07/17.
 */

public class UserF {
    public String name;
    public String email;
    public String status;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public UserF() {
    }


    public UserF(String name, String email,String status) {
        this.name = name;
        this.email = email;
        this.status=status;
    }

    public UserF(String status) {
        this.status = status;
    }
}