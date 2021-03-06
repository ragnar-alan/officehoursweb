package com.epam.user.transformer;


import com.epam.user.domain.UserProfile;
import com.epam.user.domain.UserProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Component
public class UserProfileEntityTransformer {

    @Autowired
    private UserEntityTransformer userEntityTransformer;

    @Autowired
    private UserTokenTransformer userTokenTransformer;

    public UserProfileEntity transformUserProfileToUserProfileEntityForCreation(UserProfile userProfile) {
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        userProfileEntity.setProfileId(userProfile.getProfileId());
        userProfileEntity.setFirstname(userProfile.getFirstname());
        userProfileEntity.setLastname(userProfile.getLastname());
        userProfileEntity.setUserTokenEntity(userTokenTransformer.transformUserTokenToUserTokenEntity(userProfile.getToken()));
        userProfileEntity.setUser(userEntityTransformer.transformUserToUserEntity(userProfile.getUser()));
        userProfileEntity.setCreatedAt(userProfile.getCreatedAt());
        userProfileEntity.setUpdatedAt(userProfile.getUpdatedAt());
        return userProfileEntity;
    }
}
