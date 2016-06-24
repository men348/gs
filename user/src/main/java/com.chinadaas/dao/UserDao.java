package com.chinadaas.dao;

import com.chinadaas.entity.User;

/**
 * Created by xie on 16/6/23.
 */
public interface UserDao {

    User findByName(String username);

    String getRole(String username);
}
