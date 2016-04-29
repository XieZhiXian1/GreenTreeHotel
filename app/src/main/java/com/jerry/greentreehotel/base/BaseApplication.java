package com.jerry.greentreehotel.base;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LimitedAgeMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Created by mac on 27/4/16.
 */
public class BaseApplication extends Application
{
    private ImageLoader imageLoader;

    private DbManager dbManager;

    @Override
    public void onCreate()
    {
        super.onCreate();

        // 初始化xUtils
        x.Ext.init(this);

        DbManager.DaoConfig config = new DbManager.DaoConfig();
        config.setDbDir(new File("/mnt/sdcard"));
        config.setDbVersion(1);
        config.setDbName("greenTreeHotel.db");
        config.setDbOpenListener(new DbManager.DbOpenListener()
        {
            @Override
            public void onDbOpened(DbManager db)
            {
                db.getDatabase().enableWriteAheadLogging();
            }
        });

        dbManager = x.getDb(config);

        initImageLoader();

    }

    public DbManager getDbManager()
    {
        return dbManager;
    }

    // 初始化ImageLoader
    private void initImageLoader()
    {
        imageLoader = ImageLoader.getInstance();

        int cacheSize = (int) Runtime.getRuntime().maxMemory() / 8;

        ImageLoaderConfiguration configuration =
                new ImageLoaderConfiguration.Builder(this)
                .diskCache(
                        new LimitedAgeDiskCache(
                                new File("/mnt/sdcard/imagecache"),60* 60 * 1000))
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(1000)
                .memoryCache(
                        new LimitedAgeMemoryCache(
                            new LruMemoryCache(cacheSize),
                            60 * 60 * 1000))
                .build();

        ImageLoader.getInstance().init(configuration);
    }

    public ImageLoader getImageLoader()
    {
        return this.imageLoader;
    }
}
