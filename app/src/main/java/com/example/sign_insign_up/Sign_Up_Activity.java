package com.example.sign_insign_up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_Up_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, usernameEditText, emailEditText , passwordEditText;
    private Button signUpButton;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);

        nameEditText = findViewById(R.id.nameID);
        usernameEditText = findViewById(R.id.userNameID);
        emailEditText = findViewById(R.id.emailID);
        passwordEditText = findViewById(R.id.passwordID);
        signUpButton = findViewById(R.id.signUpButton);

        databaseHelper = new DatabaseHelper(this);
        userDetails = new UserDetails();

        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name  = nameEditText.getText().toString();
        String username  = usernameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password  = passwordEditText.getText().toString();

        userDetails.setName(name);
        userDetails.setUsername(username);
        userDetails.setEmail(email);
        userDetails.setPassword(password);

        long rowID = databaseHelper.insertData(userDetails);

        if (rowID>0){
            Toast.makeText(getApplicationContext(),"Row "+rowID+" is successfully inserted",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Row insertion failed",Toast.LENGTH_SHORT).show();
        }

    }
}
