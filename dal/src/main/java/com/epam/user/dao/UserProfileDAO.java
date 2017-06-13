package com.epam.user.dao;

import com.epam.user.domain.UserProfile;
import com.epam.user.domain.UserProfileEntity;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
public interface UserProfileDAO {
    UserProfileEntity save(UserProfile user);

    void update(UserProfile user);

    void delete(Long upid);

}
