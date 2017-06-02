package com.epam.service;

import com.epam.dal.dao.UserDao;
import com.epam.dal.domain.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tamas_Boros on 6/2/2017.
 */
@Service
public class DefaultRegistrationService implements RegistrationService {

    @Autowired
    private UserService userService;

    @Override
    public void registrate(UserRegistrationRequest request) {

    }
}
