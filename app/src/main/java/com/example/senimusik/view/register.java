package com.example.senimusik.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.senimusik.R;
import com.google.android.material.textfield.TextInputLayout;

public class register extends AppCompatActivity {
    TextInputLayout inputemail, inputpassword;
    Button login_button;
    TextView buttonregist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputemail=findViewById(R.id.sign_up_email_input);
        inputpassword=findViewById(R.id.sign_up_pass_input);
        login_button=findViewById(R.id.login_button);
        buttonregist=findViewById(R.id.buttonregist);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this, login.class);
                startActivity(intent);
            }
        });
        
        buttonregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRegister();
            }
        });
    }

    private void checkRegister() {
        String email=inputemail.getEditText().getText().toString().trim();
        String pass=inputpassword.getEditText().getText().toString().trim();
        if (inputemail.getEditText().getText().toString().isEmpty()
                && inputpassword.getEditText().getText().toString().isEmpty()){
            alertFail("email and password is required");
        }else{
            sendRegister();
        }
    }

    private void sendRegister() {
        alertSuccess("Register is Success");
    }

    private void alertSuccess(String s) {
        new AlertDialog.Builder(this)
                .setTitle("Success")
                .setMessage(s)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                }).show();
    }

    private void alertFail(String s) {
        new AlertDialog.Builder(this)
                .setTitle("Failed")
                .setMessage(s)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}