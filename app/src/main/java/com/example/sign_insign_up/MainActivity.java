package com.example.sign_insign_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userNameEditText, passWordEditText;
    private Button signInButton, signUpButton;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.userNameID);
        passWordEditText = findViewById(R.id.passwordID);
        signInButton = findViewById(R.id.signInButtonID);
        signUpButton = findViewById(R.id.signUpButtonID);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        signInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String username = userNameEditText.getText().toString();
        String password = passWordEditText.getText().toString();

        if (v.getId() == R.id.signInButtonID){

            Boolean result = databaseHelper.findPassword(username,password);

            if (result == true){
                Intent intent = new Intent(MainActivity.this,Inner_Activity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(),"Incorrect Username or Password",Toast.LENGTH_SHORT).show();
            }


        }else if (v.getId() == R.id.signUpButtonID){
            Intent intent = new Intent(MainActivity.this,Sign_Up_Activity.class);
            startActivity(intent);
        }

    }
}
