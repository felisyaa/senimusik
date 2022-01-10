package com.example.senimusik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    TextView user_email;
    Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user_email=findViewById(R.id.user_email);
        btn_logout=findViewById(R.id.btn_logout);

        getUser();
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        Intent intent=new Intent(profile.this, login.class);
        startActivity(intent);
        finish();
    }

    private void getUser() {
        user_email.setText("Name: ");
    }
}