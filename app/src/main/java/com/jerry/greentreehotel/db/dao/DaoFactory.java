package com.jerry.greentreehotel.db.dao;

import android.content.Context;


import com.jerry.greentreehotel.module.home.entity.LoreDetail;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mac on 23/4/16.
 * 一个DAO工厂类，通过数据对象类型，产生对应的DAO操作对象
 */
public class DaoFactory
{
    // 缓存对象，用于保存实例化得DAO对象
    private static Map<String, IBaseDao> cache = new HashMap<>();

    public static IBaseDao getDao(Context context, Class<?> daoClass)
    {
        // 获取类名
        String name = daoClass.getName();

        // 从缓存中获取是否有对应类名的DAO对象
        IBaseDao dao = cache.get(name);

        // 如果存在，则直接返回对应的缓存的DAO对象
        if (name != null && dao != null)
        {
            return dao;
        }

        // 判断是否为对应值对象类型
        if (daoClass == LoreDetail.class)
        {
            // 实例化DAO对象
            dao = new LoreDetailDao(context);
            // 把DAO对象缓存起来，以便下次获取时加快获取速度
            cache.put(name, dao);
        }
//        if (daoClass == XXXX.class)
//        {
//            dao = new XXXXDao(context);
//            cache.put(name, dao);
//        }


        return dao;
    }
}
