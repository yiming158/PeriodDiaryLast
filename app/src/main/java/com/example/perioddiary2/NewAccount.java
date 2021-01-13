package com.example.perioddiary2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class NewAccount extends AppCompatActivity {

    ImageButton back;
    EditText name,username,email,password;
    Button signUp;

    public static String currName, currUsername, currEmail, currPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        //CONNECT XML IDs WITH JAVA FILE VARIABLES//
        setVariables();

        //SETTING ON CLICK LISTENERS//
        setListeners();
    }

    private void setVariables()
    {
        back=findViewById(R.id.back_arrow_NA);
        name=findViewById(R.id.name_NA);
        username=findViewById(R.id.username_NA);
        email=findViewById(R.id.email_NA);
        password=findViewById(R.id.password_NA);
        signUp=findViewById(R.id.signUp_NA);
    }

    private void setListeners()
    {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currName=name.getText().toString();
                currUsername=username.getText().toString();
                currEmail=email.getText().toString();
                currPassword=password.getText().toString();

                if(currName.equals("") || currUsername.equals("") || currEmail.equals("") || currPassword.equals(""))
                {
                    Toast.makeText(NewAccount.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    MainActivity.user=new User(currName,currUsername,currEmail,currPassword);
                    Intent intent=new Intent(NewAccount.this,AboutUser.class);
                    startActivity(intent);
                }

            }
        });
    }
}