package com.example.perioddiary2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class YoungerUserFragment extends Fragment {

    ImageButton back;
    TextView tv1,tv2,tv3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.younger_user_fragment,container,false);

        setVariables(view);
        setListeners();

        return view;
    }


    private void setVariables(View view)
    {
        back=view.findViewById(R.id.back_arrow_YoungerUser);
        tv1=view.findViewById(R.id.card1_YoungerUsers);
        tv2=view.findViewById(R.id.card2_YoungerUsers);
        tv3=view.findViewById(R.id.card3_YoungerUsers);
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

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),WhatPeriods.class);
                startActivity(intent);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),FirstPeriod.class);
                startActivity(intent);
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),FeelBetterPeriod.class);
                startActivity(intent);
            }
        });

    }
}