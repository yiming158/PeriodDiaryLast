package com.example.perioddiary2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class AboutUser extends AppCompatActivity {

    ImageButton back;
    Button yes, no, done;
    EditText date;
    ElegantNumberButton cycle_length, usual_cycle, age;

    int choose;
    public static String currRegular, currStartDate, currCycleLength, currUsualCycle, currAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_user);

        //CONNECT XML IDs WITH JAVA FILE VARIABLES//
        setVariables();

        //SETTING ON CLICK LISTENERS//
        setListeners();
    }

    private void setVariables()
    {
        choose=0;
        back=findViewById(R.id.back_arrow_AU);
        yes=findViewById(R.id.yes_card1_AU);
        no=findViewById(R.id.no_card1_AU);
        done=findViewById(R.id.done_AU);
        date=findViewById(R.id.start_date_AU);
        cycle_length=findViewById(R.id.cycle_length_AU);
        usual_cycle=findViewById(R.id.usual_cycle_AU);
        age=findViewById(R.id.age_AU);
    }

    private void setListeners()
    {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if(choose==0)
                {
                    yes.setBackground(getDrawable(R.drawable.clicked_buttons_background));
                    choose=1;
                }
                else if (choose==1)
                {
                    yes.setBackground(getDrawable(R.drawable.mainscreen_buttons_background));
                    choose=0;
                }
                else if(choose==2)
                {
                    yes.setBackground(getDrawable(R.drawable.clicked_buttons_background));
                    no.setBackground(getDrawable(R.drawable.mainscreen_buttons_background));
                    choose=1;
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if(choose==0)
                {
                    no.setBackground(getDrawable(R.drawable.clicked_buttons_background));
                    choose=2;
                }
                else if (choose==1)
                {
                    no.setBackground(getDrawable(R.drawable.clicked_buttons_background));
                    yes.setBackground(getDrawable(R.drawable.mainscreen_buttons_background));
                    choose=2;
                }
                else if(choose==2)
                {
                    no.setBackground(getDrawable(R.drawable.mainscreen_buttons_background));
                    choose=0;
                }
                Intent intent=new Intent(AboutUser.this,CommonCauses.class);
                startActivity(intent);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(choose==1)
                {
                    currRegular="Yes";
                }
                else if(choose==2)
                {
                    currRegular="No";
                }

                currStartDate=date.getText().toString();
                currCycleLength=cycle_length.getNumber();
                currUsualCycle=usual_cycle.getNumber();
                currAge=age.getNumber();

                if(currStartDate.equals("") || currCycleLength.equals("") || currUsualCycle.equals("") || currAge.equals(""))
                {
                    Toast.makeText(AboutUser.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //CREATING NEW DUMMY USER//
                    MainActivity.user=new User(MainActivity.user.getName(), MainActivity.user.getUsername(), MainActivity.user.getEmail(),
                            MainActivity.user.getPassword(),currRegular, currStartDate, currCycleLength, currUsualCycle, currAge);

                    Toast.makeText(AboutUser.this, "User Information Updated", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(AboutUser.this,HomeScreen.class);
                    startActivity(intent);
                }


            }
        });
    }
}