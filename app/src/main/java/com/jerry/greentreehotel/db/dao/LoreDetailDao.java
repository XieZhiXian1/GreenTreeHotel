package com.jerry.greentreehotel.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.jerry.greentreehotel.base.BaseApplication;
import com.jerry.greentreehotel.module.home.entity.LoreDetail;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by mac on 23/4/16.
 * 一个实现DAO接口的具体类,把对数据库的操作（比如最基本的CRUD操作）全部封装在里面
 */
public class LoreDetailDao extends BaseDao<LoreDetail>
{
    public LoreDetailDao(Context context)
    {
        super(context);
    }

    /**
     * 插入记录
     * @param loreDetail
     * @return
     */
    @Override
    public boolean insert(LoreDetail loreDetail)
    {
        try
        {
            getDbManager().save(loreDetail);
        }
        catch (DbException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 检查数据是否存在
     * @param args 表字段=值
     * @return
     */
    @Override
    public boolean checkRecord(Map<String, Object> args)
    {

        return false;
    }
}
