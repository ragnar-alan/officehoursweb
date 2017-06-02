package com.epam.service;

import com.epam.dal.dao.UserDao;
import com.epam.dal.domain.UserRegistrationRequest;
import com.epam.dal.transformer.UserRegistrationRequestTranformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tamas_Boros on 6/2/2017.
 */
@Service
public class DefaultRegistrationService implements RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegistrationRequestTranformer requestTranformer;

    @Override
    public void registrate(UserRegistrationRequest request) {
        userService.save(requestTranformer.transformUserRegustrationRequestToUser(request));
    }
}
