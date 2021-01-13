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

public class ChangePasswordFragment extends Fragment {

    ImageButton back;
    EditText oldPassword,newPassword,confirmPassword;
    Button ok,cancel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_change_password,container,false);

        setVariables(view);
        setListeners();

        return view;
    }

    private void setVariables(View view)
    {
        back=view.findViewById(R.id.back_arrow_change_password);
        oldPassword=view.findViewById(R.id.old_password_changePassword);
        newPassword=view.findViewById(R.id.new_password_changePassword);
        confirmPassword=view.findViewById(R.id.confirm_password_changePassword);
        ok=view.findViewById(R.id.ok_changePassword);
        cancel=view.findViewById(R.id.cancel_changePassword);
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
                String oldPass=oldPassword.getText().toString();
                String newPass=newPassword.getText().toString();
                String confirmPass=confirmPassword.getText().toString();

                if(oldPass.equals(MainActivity.user.getPassword()))
                {
                    if(newPass.equals(confirmPass))
                    {
                        MainActivity.user.setPassword(newPass);
                        Toast.makeText(getActivity(), "New Password set", Toast.LENGTH_SHORT).show();

                        EditFragment fragment=new EditFragment();
                        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container_HS,fragment).commit();
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "New Password re-entered incorrectly", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "Original Password Incorrect", Toast.LENGTH_SHORT).show();
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
