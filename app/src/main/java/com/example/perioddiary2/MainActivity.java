package com.example.perioddiary2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button logIn, register;

    public static User user=null;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALISING DUMMY USER//
        if(user==null)
        {
            user=new User();
        }

        //CONNECT XML IDs WITH JAVA FILE VARIABLES//
        setVariables();

        //SETTING ON CLICK LISTENERS//
        setListeners();
    }

    private void setVariables()
    {
        username=findViewById(R.id.username_MS);
        password=findViewById(R.id.password_MS);
        logIn=findViewById(R.id.login_MS);
        register=findViewById(R.id.register_MS);
    }

    private void setListeners()
    {
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString();
                String pass=password.getText().toString();

                if(name.equals(user.getUsername()) && pass.equals(user.password))
                {
                    Intent intent=new Intent(MainActivity.this,HomeScreen.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Incorrect Username/Password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NewAccount.class);
                startActivity(intent);
            }
        });
    }
}