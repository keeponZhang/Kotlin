package com.michael.navSafeargsdemo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhang.jetpacksample.R;

/**
 *
 */
public class SafeargsMainFragment extends Fragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_nav_safeargs_main, container, false);

        view.findViewById(R.id.btnToSecondFragment).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //未采用safe args的传递方式
               Bundle bundle = new Bundle();
               bundle.putString("user_name", "Michael2");
               bundle.putInt("age", 30);
               Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_secondFragment, bundle);


            }
        });
        view.findViewById(R.id.btnToThirdFragment).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                // 通过safe args完成参数传递
                Bundle bundle =
                        new SafeargsMainFragmentArgs.Builder().setUserName("Michael3").setAge(130).build().toBundle();
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_thirdFragment, bundle);
            }
        });
        return view;
    }
}
