package com.epam.dal.transformer;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

/**
 * Created by Tamas_Boros on 6/2/2017.
 */
@Component
public class UserRegistrationRequestTranformer {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User transformUserRegistrationRequestToUser(UserRegistrationRequest request) {
        User user = new User();
        user.setUserEmail(request.getEmail());
        user.setUserPassword(bCryptPasswordEncoder.encode(request.getPasswordConfirmation()));
        user.setCreatedAt(ZonedDateTime.now());
        user.setUpdatedAt(ZonedDateTime.now());

        return user;
    }

}
