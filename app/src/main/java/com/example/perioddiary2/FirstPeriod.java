package com.example.perioddiary2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstPeriod extends AppCompatActivity {

    ImageButton back;
    TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_period);

        back=findViewById(R.id.back_arrow_firstPeriod);
        content=findViewById(R.id.content_firstPeriod);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}