package com.epam.dal.transformer;

import com.epam.dal.domain.UserProfile;
import com.epam.dal.domain.UserProfileEntity;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Component
public class UserProfileEntityTransformer {

    public UserProfileEntity transformUserProfileToUserProfileEntityForCreation(UserProfile userProfile) {
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        userProfileEntity.setProfileId(userProfile.getProfileId());
        userProfileEntity.setUserTokenEntity(userProfile.getToken());
        userProfileEntity.setUser(userProfile.getUser());
        userProfileEntity.setCreatedAt(ZonedDateTime.now());
        userProfileEntity.setUpdatedAt(ZonedDateTime.now());
        return userProfileEntity;
    }
}
