package com.epam.service;

import com.epam.dal.domain.UserRegistrationRequest;

/**
 * Created by Tamas_Boros on 6/2/2017.
 */
public interface RegistrationService {
    void registrate(UserRegistrationRequest request);
}
