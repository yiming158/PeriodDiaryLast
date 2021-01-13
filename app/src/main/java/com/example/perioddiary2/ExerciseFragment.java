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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ExerciseFragment extends Fragment {

    ImageButton back;
    TextView heading1,content1,content2,content3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_exercise,container,false);

        setVariables(view);
        setListeners();

        return view;
    }

    private void setVariables(View view)
    {
        back=view.findViewById(R.id.back_arrow_exercise);
        heading1=view.findViewById(R.id.heading1_exercise);
        content1=view.findViewById(R.id.content1_exercise);
        content2=view.findViewById(R.id.content2_exercise);
        content3=view.findViewById(R.id.content3_exercise);

        String text1="Light cardio workout - Cycling/bike riding, low impact jumping jack, squat to jsb, swimming.\nCheck more web link. ";
        SpannableString ss1=new SpannableString(text1);

        String text2="Yoga - Bound angle pose, Bow pose, Bridge pose, Lotus pose.\nCheck more web link";
        SpannableString ss2=new SpannableString(text2);

        String text3="Kegel Exercise - clench-and-release exercise that you can do to make the muscles of your pelvic floor stronger.\nCheck more web link";
        SpannableString ss3=new SpannableString(text3);

        ClickableSpan clickableSpan1=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                //OPEN WEBSITE LINK//
                Toast.makeText(getActivity(), "Link 1 clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        ClickableSpan clickableSpan2=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                //OPEN WEBSITE LINK//
                Toast.makeText(getActivity(), "Link 2 clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        ClickableSpan clickableSpan3=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                //OPEN WEBSITE LINK//
                Toast.makeText(getActivity(), "Link 3 clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        ss1.setSpan(clickableSpan1,104,112, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        content1.setText(ss1);
        content1.setMovementMethod(LinkMovementMethod.getInstance());

        ss2.setSpan(clickableSpan2,71,79, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        content2.setText(ss2);
        content2.setMovementMethod(LinkMovementMethod.getInstance());

        ss3.setSpan(clickableSpan3,123,131, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        content3.setText(ss3);
        content3.setMovementMethod(LinkMovementMethod.getInstance());
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
