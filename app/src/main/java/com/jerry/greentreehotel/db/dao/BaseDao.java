package com.jerry.greentreehotel.db.dao;

import android.content.Context;

import com.jerry.greentreehotel.base.BaseApplication;

import org.xutils.DbManager;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 23/4/16.
 * 适配器类，实现接口方法，并且构造方法中获取SQLiteOpenHelper实例
 */
public class BaseDao<T> implements IBaseDao<T>
{
    private DbManager dbManager;

    public BaseDao(Context context)
    {
        dbManager = ((BaseApplication) context.getApplicationContext()).getDbManager();
    }

    protected DbManager getDbManager()
    {
        return dbManager;
    }

    @Override
    public boolean insert(T t)
    {
        return false;
    }

    @Override
    public boolean update(T t, Map<String, Object> args)
    {
        return false;
    }

    @Override
    public boolean delete(T t, Map<String, Object> args)
    {
        return false;
    }

    @Override
    public List<T> selectAll()
    {
        return null;
    }

    @Override
    public List<T> selectWithArgs(Map<String, Object> args)
    {
        return null;
    }

    @Override
    public T selectSingle(Map<String, Object> args)
    {
        return null;
    }

    @Override
    public boolean checkRecord(Map<String, Object> args)
    {
        return false;
    }
}
