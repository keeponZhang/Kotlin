package com.michael.navDeeplinkdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhang.jetpacksample.R;

import androidx.fragment.app.Fragment;

public class DeepLinkSettingsFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deep_link_settings, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String params = bundle.getString("params");
            TextView tvDesc = view.findViewById(R.id.tvDesc);
            if (!TextUtils.isEmpty(params)) {
                tvDesc.setText("传过来的params=" + params);
            }
        }
        return view;
    }
}
