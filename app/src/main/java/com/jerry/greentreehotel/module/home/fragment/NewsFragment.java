package com.jerry.greentreehotel.module.home.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jerry.greentreehotel.MainActivity;
import com.jerry.greentreehotel.R;

public class NewsFragment extends Fragment {
    private static NewsFragment lastFragment = null;


    public NewsFragment() {
    }

    public static NewsFragment newInstance(String type, MainActivity activity) {
        FragmentManager manager = activity.getSupportFragmentManager();
        if (lastFragment != null) {
            manager.beginTransaction().hide(lastFragment).commit();
        }
        NewsFragment fragment = (NewsFragment) manager.findFragmentByTag(type);
        if (fragment == null) {
            fragment = new NewsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            fragment.setArguments(bundle);
            manager.beginTransaction().add(R.id.main_fragment, fragment, type).commit();
        } else {

            manager.beginTransaction().show(fragment).commit();
        }
        lastFragment = fragment;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String type = getArguments().getString("type");
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
