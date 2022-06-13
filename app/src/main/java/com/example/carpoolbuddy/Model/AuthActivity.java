package com.example.carpoolbuddy.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.carpoolbuddy.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class AuthActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
    }

    public void signup(View V){
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            Intent intent = new Intent(this, UserProfileActivity.class);
            startActivity(intent);
        }
    }

    public void signIn(View V){
        System.out.println("Log In");
        String emailString = emailField.getText().toString();
        String passwordString = passwordField.getText().toString();
        System.out.println(String.format("email: %s and password: %s", emailString, passwordString));

        FirebaseUser mUser = mAuth.getCurrentUser();
        updateUI(mUser);
    }

    public void updateUI(FirebaseUser currentUser){
        if(currentUser != null){
            Intent intent = new Intent(this, UserProfileActivity.class);
            startActivity(intent);
        }
    }
}