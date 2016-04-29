package com.jerry.greentreehotel;

import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.jerry.greentreehotel.base.BaseFragment;
import com.jerry.greentreehotel.constant.Url;
import com.jerry.greentreehotel.module.home.adapter.MyPageAdapter;
import com.jerry.greentreehotel.module.home.entity.ViewPageAdvertisement;
import com.jerry.greentreehotel.utils.HttpUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by mac on 27/4/16.
 */
@ContentView(R.layout.fragment_main)
public class MyFragment extends BaseFragment {
    @ViewInject(R.id.main_viewPage)
    private ViewPager mainViewPage;

    private android.support.v4.app.FragmentManager manager;
    @ViewInject(R.id.radioGroup_fragment)
    private RadioGroup radioGroup;

    @ViewInject(R.id.fragment_viewPage)
    private ViewPager fragmentViewPage;

    private HttpUtil httpUtil;


    public MyFragment() {

    }
    /*public static MyFragment newInstance(String type, MainActivity activity) {
        FragmentManager manager = activity.getSupportFragmentManager();
        if (lastFragment != null) {
            manager.beginTransaction().hide(lastFragment).commit();
        }
        NewsFragment fragment = (NewsFragment) manager.findFragmentByTag(type);
        if (fragment == null) {
            fragment = new MyFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            fragment.setArguments(bundle);
            manager.beginTransaction().add(R.id.main_fragment, fragment, type).commit();
        } else {

            manager.beginTransaction().show(fragment).commit();
        }
        lastFragment = fragment;
        return fragment;
    }*/

    @Override
    protected void initViews() {


        fragmentViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                RadioButton but = (RadioButton) radioGroup.getChildAt(position);
                but.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if(group.getChildAt(i).getId()==checkedId){
                        fragmentViewPage.setCurrentItem(i);
                    }
                }
            }
        });

    }

    @Override
    protected void loadData() {
        EventBus.getDefault().register(this);
        httpUtil = HttpUtil.getInstance();
        httpUtil.sendPost(Url.VIEWPAGE_ADVERT, null);
    }


    @Subscribe(threadMode = ThreadMode.MainThread)
    public void getData(String result) {
        Gson gson = new Gson();
        ViewPageAdvertisement vpAdvert = gson.fromJson(result, ViewPageAdvertisement.class);
        List<ViewPageAdvertisement.ResponseDataBean.BannerListBean>
                bannerListBeans = vpAdvert.getResponseData().getBannerList();
        MyPageAdapter adapter = new MyPageAdapter(getContext(), bannerListBeans);
        mainViewPage.setAdapter(adapter);

    }

}
