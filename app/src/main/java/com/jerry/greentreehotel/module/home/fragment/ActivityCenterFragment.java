package com.jerry.greentreehotel.module.home.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jerry.greentreehotel.MainActivity;
import com.jerry.greentreehotel.R;

public class ActivityCenterFragment extends Fragment {

    private static ActivityCenterFragment lastFragment = null;

    public ActivityCenterFragment() {
    }

    public static ActivityCenterFragment newInstance(String type, MainActivity activity) {
        FragmentManager manager = activity.getSupportFragmentManager();
        if (lastFragment != null) {
            manager.beginTransaction().hide(lastFragment).commit();
        }
        ActivityCenterFragment fragment = (ActivityCenterFragment) manager.findFragmentByTag(type);
        if (fragment == null) {
            fragment = new ActivityCenterFragment();
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
        return inflater.inflate(R.layout.fragment_activity_center, container, false);
    }

}
