package com.trojan.gamegenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    Button btnLogin, btnsignup;
    FrameLayout resetpassbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        btnLogin = findViewById(R.id.btnLogin);
        btnsignup = findViewById(R.id.signupbtn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, SignUp.class);
                startActivity(intent);
            }
        });

        resetpassbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginScreen.this, "Password Reset Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void login() {

        Intent intent = new Intent(LoginScreen.this, MainActivity.class);
        startActivity(intent);
    }
}
