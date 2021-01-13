package com.example.perioddiary2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PregnancySymptoms extends AppCompatActivity {

    ImageButton back;
    TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy_symptoms);

        back=findViewById(R.id.back_arrow_pregnancySymptoms);
        content=findViewById(R.id.content_pregnancySymptoms);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}