package com.jerry.greentreehotel.module.welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jerry.greentreehotel.MainActivity;
import com.jerry.greentreehotel.R;

/**
 * Created by Administrator on 2016/4/28 0028.
 */
public class GuideActivity extends AppCompatActivity {

    private boolean isFirstRuntime = true;
    private ViewPager viewPager;
    private MyGuideAdapter adapter;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isFirstRuntime = isFirstRuntime();
        if (isFirstRuntime) {
            setContentView(R.layout.activity_guide);
            initGuide();
        } else {
            setContentView(R.layout.activity_welcom);
            goToHome();
        }
    }

    private int imageId[] = {R.drawable.g1, R.drawable.g2, R.drawable.g3};

    private void initGuide() {
        viewPager = (ViewPager) findViewById(R.id.guide_viewPage);
        group = (RadioGroup) findViewById(R.id.guide_group);
        adapter = new MyGuideAdapter(imageId,this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                RadioButton but = (RadioButton) group.getChildAt(position);
                but.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if(group.getChildAt(i).getId()==checkedId){
                        viewPager.setCurrentItem(i);
                    }
                }
            }
        });

    }

    private void goToHome() {
        handler.sendEmptyMessageDelayed(1, 1000);

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    private boolean isFirstRuntime() {
        SharedPreferences sp = getSharedPreferences("green", MODE_PRIVATE);
        boolean isFirstRun = sp.getBoolean("isFirstRun", true);
        return isFirstRun;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    public void onSkip(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
        SharedPreferences sp = getSharedPreferences("green",MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("isFirstRun",false);
        edit.commit();
    }
}
