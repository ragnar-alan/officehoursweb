package com.epam.dal.dao;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserEntity;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
public interface UserDao {

    User getOneUserById(Long id);

    UserEntity save(User user);

    List<User> getAllUser();
}
