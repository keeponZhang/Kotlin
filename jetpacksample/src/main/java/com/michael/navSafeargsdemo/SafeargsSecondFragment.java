package com.michael.navSafeargsdemo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhang.jetpacksample.R;

public class SafeargsSecondFragment extends Fragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_nav_safeargs_second, container, false);

        //未采用safe args的接收方式
       Bundle bundle = getArguments();
       if(bundle != null)
       {
           String userName = bundle.getString("user_name");
           int age = bundle.getInt("age");
           TextView tvSub = view.findViewById(R.id.tvSub);
           tvSub.setText("userName="+userName + " age="+age);
       }

        return view;
    }
}
