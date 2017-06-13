package com.epam.user.service;


import com.epam.user.domain.User;
import com.epam.user.domain.UserRegistrationRequest;

/**
 * Created by Tamas_Boros on 6/2/2017.
 */
public interface RegistrationService {
    User registrate(UserRegistrationRequest request);
}
