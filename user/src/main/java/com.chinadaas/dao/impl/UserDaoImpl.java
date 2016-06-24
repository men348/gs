package com.chinadaas.dao.impl;

import com.chinadaas.dao.UserDao;
import com.chinadaas.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xie on 16/6/23.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User findByName(String username) {
        User user = new User();
        user.setUsername("simon");
        user.setPassword("123456");
        return user;
    }

    @Override
    public String getRole(String username) {
        return "role";
    }
}
