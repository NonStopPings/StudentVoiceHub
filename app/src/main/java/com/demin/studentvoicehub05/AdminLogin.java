package com.demin.studentvoicehub05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText username,password;
    Button admin_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        admin_login = findViewById(R.id.admin_login);
        admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("123456") && password.getText().toString().equals("123456")){
                    Intent intent = new Intent(AdminLogin.this,HomePageForAdmin.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Sorry you are not admin, please use google login",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
