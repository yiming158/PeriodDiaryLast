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
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class PregnancyFragment extends Fragment {

    ImageButton back,arrow1,arrow2,arrow3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_pregnancy,container,false);

        setVariabes(view);
        setListeners();

        return view;
    }

    private void setVariabes(View view)
    {
        back=view.findViewById(R.id.back_arrow_pregnancy);
        arrow1=view.findViewById(R.id.pregnancy_arrow1);
        arrow2=view.findViewById(R.id.pregnancy_arrow2);
        arrow3=view.findViewById(R.id.pregnancy_arrow3);
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

        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),PregnancySymptoms.class);
                startActivity(intent);
            }
        });

        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),PregnancyTips.class);
                startActivity(intent);
            }
        });

        arrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),PregnancyStages.class);
                startActivity(intent);
            }
        });
    }
}
