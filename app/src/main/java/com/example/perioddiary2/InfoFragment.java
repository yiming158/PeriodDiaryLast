package com.example.perioddiary2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class InfoFragment extends Fragment {

    ImageButton back;
    Button hygiene,diet,exercise,pregnancy,pms,younger;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_info,container,false);

        setVariabes(view);
        setListeners();

        return view;
    }

    private void setVariabes(View view)
    {
        back=view.findViewById(R.id.back_arrow_info_MS);
        hygiene=view.findViewById(R.id.hygiene_button);
        diet=view.findViewById(R.id.diet_button);
        exercise=view.findViewById(R.id.exercise_button);
        pregnancy=view.findViewById(R.id.pregnancy_button);
        pms=view.findViewById(R.id.pms_button);
        younger=view.findViewById(R.id.younger_user_button);
    }

    private void setListeners()
    {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment fragment=new HomeFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });

        hygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HygieneFragment fragment=new HygieneFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });

        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DietFragment fragment=new DietFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExerciseFragment fragment=new ExerciseFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });

        pregnancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PregnancyFragment fragment=new PregnancyFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });

        pms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PMS_HomeScreen fragment=new PMS_HomeScreen();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });

        younger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoungerUserFragment fragment=new YoungerUserFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });
    }
}
