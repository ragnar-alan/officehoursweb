package com.epam.user.dao;


import com.epam.user.domain.UserProfile;
import com.epam.user.domain.UserProfileEntity;
import com.epam.user.repository.UserProfileRepository;
import com.epam.user.transformer.UserProfileEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Component
public class DefaultUserProfileDAO implements UserProfileDAO {

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
