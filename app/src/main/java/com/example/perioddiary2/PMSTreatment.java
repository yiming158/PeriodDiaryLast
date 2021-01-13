package com.example.perioddiary2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class PMSTreatment extends Fragment {

    ImageButton back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_pms_treatment,container,false);

        back=view.findViewById(R.id.back_arrow_PMS_Treatment);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PMS_HomeScreen fragment=new PMS_HomeScreen();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });

        return view;
    }
}