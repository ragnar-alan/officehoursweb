package com.epam.dal.dao;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserProfile;
import com.epam.dal.repository.UserProfileRepository;
import com.epam.dal.repository.UserRepository;
import com.epam.dal.transformer.UserEntityTransformer;
import com.epam.dal.transformer.UserProfileEntityTransformer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Component
public class DefaultUserProfileDao implements UserProfileDao{

    private UserProfileRepository userProfileRepository;

    private UserProfileEntityTransformer userProfileEntityTransformer;


    @Override
    public void save(UserProfile userProfile) {
        userProfileRepository.save(userProfileEntityTransformer.transformUserProfileToUserProfileEntityForCreation(userProfile));
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
