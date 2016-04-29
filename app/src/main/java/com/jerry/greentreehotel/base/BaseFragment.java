package com.jerry.greentreehotel.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;

/**
 * Created by mac on 27/4/16.
 */
public abstract class BaseFragment extends Fragment
{
    private boolean injected = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = x.view().inject(this, inflater, container);
        injected = true;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        if (!injected)
        {
            x.view().inject(this, this.getView());
        }
        initViews();
        loadData();
    }

    protected abstract void initViews();
    protected abstract void loadData();
}
