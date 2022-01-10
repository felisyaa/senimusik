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

public class login extends AppCompatActivity {

    TextInputLayout sign_in_email_input, sign_in_pass_input;
    Button login_button;
    TextView buttonregist;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sign_in_email_input=findViewById(R.id.sign_up_email_input);
        sign_in_pass_input=findViewById(R.id.sign_up_pass_input);
        login_button=findViewById(R.id.login_button);
        buttonregist=findViewById(R.id.buttonregist);
        buttonregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });
        
//        login_button.setOnClickListener(view1->{
//            if (!sign_in_email_input.getEditText().getText().toString().isEmpty()
//                    && !sign_in_pass_input.getEditText().getText().toString().isEmpty()){
//                String email=sign_in_email_input.getEditText().getText().toString().trim();
//                String pass=sign_in_pass_input.getEditText().getText().toString().trim();
//                loginViewModel.login(email, pass).observe(requireActivity(), tokenResponse -> {
//                    if(tokenResponse !=null){
//                        helper.saveAccessToken(tokenResponse.getAuthorization());
//                        NavDirections actions=LoginFragmentDirections.actionLoginFragmentToProjectFragment2();
//                        Navigation.findNavController(view1).navigate(actions);
//                        Toast.makeText(requireActivity(),"Login Success", Toast.LENGTH_SHORT).show();
//                    }else {
//                        Toast.makeText(requireActivity(),"Login Failed", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }else {
//                Toast.makeText(requireActivity(),"Insert Email and Password", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void checkLogin() {
        String email=sign_in_email_input.getEditText().getText().toString().trim();
        String pass=sign_in_pass_input.getEditText().getText().toString().trim();
        if (sign_in_email_input.getEditText().getText().toString().isEmpty()
                && sign_in_pass_input.getEditText().getText().toString().isEmpty()){
            alertFail("email and password is required");
        }else {
            sendLogin();
        }
    }

    private void sendLogin(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
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