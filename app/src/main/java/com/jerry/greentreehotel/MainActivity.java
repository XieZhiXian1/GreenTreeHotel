package com.jerry.greentreehotel;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jerry.greentreehotel.base.BaseActivity;
import com.jerry.greentreehotel.constant.Url;
import com.jerry.greentreehotel.utils.HttpUtil;

import org.xutils.view.annotation.ContentView;

import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    SlidingMenu menu = null;

    private android.support.v4.app.FragmentManager manager;

    /**
     * 初始化视图
     */
    @Override
    protected void initViews() {
        menu = new SlidingMenu(this);
        // 设置左边侧边栏
        menu.setMode(SlidingMenu.LEFT);
        // 设置什么位置可以拉动侧边栏
        //menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        // 中间阴影部分宽度
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.sliding_shadow);
        // 侧边栏后面的布局的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //menu.setBehindOffset(DensityUtil.dip2px(120));
        menu.setFadeDegree(0.35f);
        // 把侧边栏附加到当前的Activity
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        // 设置侧边栏的布局
        menu.setMenu(R.layout.main_left_menu);

        RelativeLayout btn = (RelativeLayout) findViewById(R.id.btn_mainpage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.main_fragment, new MyFragment(), "1").commit();
                menu.toggle();
            }
        });
    }


    /**
     * 加载数据
     */
    @Override
    protected void loadData() {
        HttpUtil util = HttpUtil.getInstance();
        Map<String, Object> param = new HashMap<>();
        param.put("pageindex", 3);

        util.sendPost(Url.HOTEL_LIST, param);
        // manager = getSupportFragmentManager();
        // manager.beginTransaction().replace(R.id.main_fragment, new MyFragment(), "1").commit();

    }

    /**
     * 获取具体的结果
     *
     * @param result
     */
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onGetResult(String result) {
        Log.d("getResult", "onGetResult() returned: " + result);
    }

}

