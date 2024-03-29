package com.michael.navigationbasicdemo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhang.jetpacksample.R;

import androidx.navigation.Navigation;


public class NavBasicMainFragment extends Fragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_nav_basic_main, container, false);

        //方法一
        view.findViewById(R.id.btnToSecondFragment).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_secondFragment);
            }
        });

        //方法二
        view.findViewById(R.id.btnToSecondFragment2).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_secondFragment));

        return view;
    }
}
