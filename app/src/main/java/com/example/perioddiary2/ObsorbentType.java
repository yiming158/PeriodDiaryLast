package com.example.perioddiary2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ObsorbentType extends AppCompatActivity {

    ImageButton back;
    TextView heading1,subheading1,content1,subheading2,content2,subheading3,content3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obsorbent_type);

        setVariables();
        setListeners();
    }

    private void setVariables()
    {
        back=findViewById(R.id.back_arrow_absorbentType);
        heading1=findViewById(R.id.heading1_AbsorbentTypes);
        subheading1=findViewById(R.id.subheading1_AbsorbentTypes);
        content1=findViewById(R.id.content1_AbsorbentTypes);
        subheading2=findViewById(R.id.subheading2_AbsorbentTypes);
        content2=findViewById(R.id.content2_AbsorbentTypes);
        subheading3=findViewById(R.id.subheading3_AbsorbentTypes);
        content3=findViewById(R.id.content3_AbsorbentTypes);
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