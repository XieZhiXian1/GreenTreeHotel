package com.jerry.greentreehotel.module.welcome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jerry.greentreehotel.MainActivity;

/**
 * Created by Administrator on 2016/4/28 0028.
 */
public class MyGuideAdapter extends PagerAdapter {
    private int[] imageId;
    private Context context;

    public MyGuideAdapter(int[] imageId, Context context) {
        this.imageId = imageId;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageId == null ? 0 : imageId.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageId[position]);
        container.addView(imageView);
        if (position == imageId.length - 1) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    ((Activity) context).finish();

                    SharedPreferences sp = context.getSharedPreferences("green", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("isFirstRun", false);
                    editor.commit();
                }
            });
        }

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
