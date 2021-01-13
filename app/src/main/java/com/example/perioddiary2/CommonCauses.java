package com.example.perioddiary2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class CommonCauses extends AppCompatActivity {

    ImageButton back;
    TextView tv1,tv2,tv3,tv4,tv5,tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_causes);

        //CONNECT XML IDs WITH JAVA FILE VARIABLES//
        setVariables();

        //SETTING ON CLICK LISTENERS//
        setListeners();
    }

    private void setVariables()
    {
        back=findViewById(R.id.back_arrow_CC);
        tv1=findViewById(R.id.tv1_CC);
        tv2=findViewById(R.id.tv2_CC);
        tv3=findViewById(R.id.tv3_CC);
        tv4=findViewById(R.id.tv4_CC);
        tv5=findViewById(R.id.tv5_CC);
        tv6=findViewById(R.id.tv6_CC);
    }

    private void setListeners()
    {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}