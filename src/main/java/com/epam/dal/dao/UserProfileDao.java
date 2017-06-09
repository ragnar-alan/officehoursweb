package com.epam.dal.dao;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserProfile;
import com.epam.dal.domain.UserProfileEntity;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
public interface UserProfileDao {
    UserProfileEntity save(UserProfile user);

    void update(UserProfile user);

    void delete(Long upid);

}
