package com.jerry.greentreehotel.db.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 23/4/16.
 * 一个DAO接口或者抽象类，定义基础DAO接口规范，定义CRUD操作
 */
public interface IBaseDao<T>
{
    // 添加
    public boolean insert(T t);

    // 修改
    public boolean update(T t, Map<String, Object> args);

    // 删除
    public boolean delete(T t, Map<String, Object> args);

    // 查询
    public List<T> selectAll();

    // 带参数
    public  List<T> selectWithArgs(Map<String, Object> args);

    // 查询单个
    public T selectSingle(Map<String, Object> args);

    // 判断某条记录是否存在
    public boolean checkRecord(Map<String, Object> args);
}
