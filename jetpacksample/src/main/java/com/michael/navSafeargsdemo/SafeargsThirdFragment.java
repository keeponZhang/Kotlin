package com.michael.navSafeargsdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhang.jetpacksample.R;

import androidx.fragment.app.Fragment;

public class SafeargsThirdFragment extends Fragment
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
        View view = inflater.inflate(R.layout.fragment_nav_safeargs_third, container, false);


        //通过safe args完成参数接收
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            String userName = SafeargsMainFragmentArgs.fromBundle(getArguments()).getUserName();
            int age = SafeargsMainFragmentArgs.fromBundle(getArguments()).getAge();
            TextView tvSub = view.findViewById(R.id.tvSub);
            tvSub.setText("userName="+userName + " age="+age);
        }
        return view;
    }
}
