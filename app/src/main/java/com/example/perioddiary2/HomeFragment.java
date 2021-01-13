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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment {

    TextView tv1,tv2,tv3;
    ImageButton pms_arrow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home,container,false);

        setVariables(view);

        setListeners();

        return view;
    }

    private void setVariables(View view)
    {
        tv1=view.findViewById(R.id.dayOnCycle);
        tv2=view.findViewById(R.id.daysTillPeriods);
        tv3=view.findViewById(R.id.daysLeftOvulation);
        pms_arrow=view.findViewById(R.id.pms_HS);

        setTextViewValues();
    }

    private void setListeners()
    {
        pms_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                PMS_HomeScreen pms_HS=new PMS_HomeScreen();
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_HS,pms_HS).commit();
            }
        });
    }

    private void setTextViewValues()
    {
        String lastPeriod=MainActivity.user.getLastStartDate();;
        int year=Integer.parseInt(lastPeriod.split("/")[2]);
        int month=Integer.parseInt(lastPeriod.split("/")[1]);
        int date=Integer.parseInt(lastPeriod.split("/")[0]);

        Calendar today=Calendar.getInstance();
        Calendar lastPeriodDate=Calendar.getInstance();
        lastPeriodDate.set(year,month-1,date);

        long diffInMilliSeconds=today.getTimeInMillis()-lastPeriodDate.getTimeInMillis();
        long days=diffInMilliSeconds / (24 * 60 * 60 * 1000);

        int cycleLength=Integer.parseInt(MainActivity.user.getCycleLength());
        int daysLeftTillPeriod= (int) (cycleLength-days);
        int daysLeftTillOvulation=0;

        if(days<=Integer.parseInt(MainActivity.user.getUsualCycle()))
        {
            daysLeftTillOvulation= (int) (11-days);
        }
        else
        {
            daysLeftTillOvulation=daysLeftTillPeriod+11;
        }

        tv1.setText("You are "+days+" days into your cycle");
        tv2.setText(daysLeftTillPeriod+" days left until your next period starts!");
        tv3.setText(daysLeftTillOvulation+" days left until your Ovuation day");

    }
}
