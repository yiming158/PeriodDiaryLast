package com.example.perioddiary2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HygieneFragment extends Fragment {

    ImageButton back;
    TextView heading,content;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_hygiene,container,false);

        setVariabes(view);
        setListeners();

        return view;
    }

    private void setVariabes(View view)
    {
        back=view.findViewById(R.id.back_arrow_hygiene);
        heading=view.findViewById(R.id.heading_hygiene);
        content=view.findViewById(R.id.content_PMSHygiene);

        String text="Change pads or tampons (Click here to learn more about absorbents) regularly to prevent infections - once every six hours, for a tampon, it's every two hours.\n...\n...\nUse clean underwear and change it everyday.\nDo not use soaps or vaginal hygiene products to wash the genital area.";
        SpannableString ss=new SpannableString(text);

        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent=new Intent(getActivity(),ObsorbentType.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        ss.setSpan(clickableSpan,30,34, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        content.setText(ss);
        content.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setListeners()
    {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InfoFragment fragment=new InfoFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });
    }
}
