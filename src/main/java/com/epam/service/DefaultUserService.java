package com.epam.service;

import com.epam.dal.dao.UserDao;
import com.epam.dal.domain.User;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
public class DefaultUserService implements UserService {
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        return null;
    }

    @Override
    public User getUser(Long uid) {
        userDao.delete(uid);
        return null;
    }
}
