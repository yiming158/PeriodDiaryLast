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

public class DietFragment extends Fragment {

    ImageButton back;
    TextView heading1,content1,heading2,content2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_diet,container,false);

        setVariabes(view);
        setListeners();

        return view;
    }

    private void setVariabes(View view)
    {
        back=view.findViewById(R.id.back_arrow_diet);
        heading1=view.findViewById(R.id.heading1_diet);
        content1=view.findViewById(R.id.content1_diet);
        heading2=view.findViewById(R.id.heading2_diet);
        content2=view.findViewById(R.id.content2_diet);

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
