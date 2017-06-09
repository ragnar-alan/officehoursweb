package com.epam.user;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserProfile;
import com.epam.dal.domain.UserProfileEntity;
import com.epam.dal.repository.UserProfileRepository;
import com.epam.dal.repository.UserRepository;
import com.epam.dal.transformer.UserEntityTransformer;
import com.epam.dal.transformer.UserProfileEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Component
public class DefaultUserProfileDao implements UserProfileDao {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileEntityTransformer userProfileEntityTransformer;


    @Override
    public UserProfileEntity save(UserProfile userProfile) {
        return userProfileRepository.save(userProfileEntityTransformer.transformUserProfileToUserProfileEntityForCreation(userProfile));
    }

    @Override
    public void update(UserProfile user) {
        //TODO
    }

    @Override
    public void delete(Long uid) {
        userProfileRepository.delete(uid);
    }
}