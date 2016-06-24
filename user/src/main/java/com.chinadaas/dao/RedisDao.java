package com.chinadaas.dao;

import com.chinadaas.entity.User;

/**
 * Created by xie on 16/6/22.
 */
public interface RedisDao {

    void saveString(String key,String value);

    String getString(String key);

    void saveObject(String key,Object object);

    Object getObject(String key);

}
