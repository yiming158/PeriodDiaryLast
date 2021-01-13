package com.example.perioddiary2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ChangeUsernameFragment extends Fragment {

    ImageButton back;
    EditText username,password;
    Button ok,cancel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_change_username,container,false);

        setVariables(view);
        setListeners();

        return view;
    }

    private void setVariables(View view)
    {
        back=view.findViewById(R.id.back_arrow_change_username);
        username=view.findViewById(R.id.new_username_changeUsername);
        password=view.findViewById(R.id.password_changeUsername);
        ok=view.findViewById(R.id.ok_changeUsername);
        cancel=view.findViewById(R.id.cancel_changeUsername);
    }

    private void setListeners()
    {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditFragment fragment=new EditFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString();
                String pass=password.getText().toString();

                if(pass.equals(MainActivity.user.getPassword()))
                {
                    MainActivity.user.setUsername(name);
                    Toast.makeText(getActivity(), "Username changed to:"+name, Toast.LENGTH_SHORT).show();

                    EditFragment fragment=new EditFragment();
                    FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
                }
                else
                {
                    Toast.makeText(getActivity(), "Incorrect Password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditFragment fragment=new EditFragment();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
            }
        });
    }
}
