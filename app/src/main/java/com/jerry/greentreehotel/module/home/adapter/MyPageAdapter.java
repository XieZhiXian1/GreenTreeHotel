package com.jerry.greentreehotel.module.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jerry.greentreehotel.R;
import com.jerry.greentreehotel.module.home.entity.ViewPageAdvertisement;
import com.jerry.greentreehotel.utils.HttpUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.List;

/**
 * Created by Administrator on 2016/4/28 0028.
 */
public class MyPageAdapter extends PagerAdapter {
    private Context context;
    private List<ViewPageAdvertisement.ResponseDataBean.BannerListBean> bannerListBeans;
    private com.nostra13.universalimageloader.core.ImageLoader imageLoader;
    private DisplayImageOptions options;

    public MyPageAdapter(Context context,
                         List<ViewPageAdvertisement.ResponseDataBean.BannerListBean> bannerListBeans) {
        this.bannerListBeans = bannerListBeans;
        this.context = context;

        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .showImageOnFail(R.mipmap.ic_launcher)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
    }

    @Override
    public int getCount() {
        return bannerListBeans == null ? 0 : bannerListBeans.size();
    }

    @Override
    public ImageView instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(params);
//        imageLoader = ((BaseApplication) context.getApplicationContext()).getImageLoader();
//        imageLoader.displayImage(bannerListBeans.get(position).getBannerUrl(), imageView, options);

        HttpUtil.getInstance().sendBitmap(bannerListBeans.get(position).getBannerUrl(), imageView);
        container.addView(imageView);
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
