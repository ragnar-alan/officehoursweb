package com.epam.user.service;


import com.epam.user.domain.User;
import com.epam.user.domain.UserRegistrationRequest;
import com.epam.user.transformer.UserRegistrationRequestTranformer;
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
    public User registrate(UserRegistrationRequest request) {
        if (request.getPassword().equals(request.getPasswordConfirmation())) {
            return userService.save(requestTranformer.transformUserRegistrationRequestToUser(request));
        }
        throw new RuntimeException("NULL LETT");
    }
}
