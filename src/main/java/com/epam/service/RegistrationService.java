package com.epam.service;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserRegistrationRequest;

/**
 * Created by Tamas_Boros on 6/2/2017.
 */
public interface RegistrationService {
    User registrate(UserRegistrationRequest request);
}
