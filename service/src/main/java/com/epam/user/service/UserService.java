package com.epam.user.service;

import com.epam.user.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
public interface UserService extends UserDetailsService {
    User save(User user);

    List<User> getAllUsers();

    User getUser(Long uid);

    User getUserByEmail(String email);
}
