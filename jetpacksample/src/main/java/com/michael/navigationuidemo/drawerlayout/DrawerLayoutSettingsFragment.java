package com.michael.navigationuidemo.drawerlayout;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhang.jetpacksample.R;

public class DrawerLayoutSettingsFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)

    {
        return inflater.inflate(R.layout.fragment_drawer_layout_settings, container, false);
    }
}