package com.epam.service;

import com.epam.dal.domain.User;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
public interface UserService {
    void save(User user);

    List<User> getAllUsers();

    User getUser(Long uid);
}
