package com.epam.user.dao;


import com.epam.user.domain.User;
import com.epam.user.domain.UserEntity;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
public interface UserDAO {

    User getUserByEmail(String email);

    User getOneUserById(Long id);

    UserEntity save(User user);

    List<User> getAllUser();

    boolean existsByEmail(String email);
}
