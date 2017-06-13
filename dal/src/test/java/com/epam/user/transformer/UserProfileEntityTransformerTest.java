package com.epam.user.transformer;

import com.epam.user.domain.User;
import com.epam.user.domain.UserProfile;
import com.epam.user.domain.UserProfileEntity;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Created by Tamas_Boros on 6/13/2017.
 */
public class UserProfileEntityTransformerTest {

    private static final long DUMMY_USER_PROFILE_ID = 1L;
    private static final Long DUMMY_USER_ID= 1L;
    private static final String DUMMY_USER_EMAIL = "test@test.com";
    private static final String DUMMY_USER_PASSWORD = "1234";
    private static final ZonedDateTime NOW = ZonedDateTime.now();

    @InjectMocks
    private UserProfileEntityTransformer underTest;

    @Mock
    private UserEntityTransformer userEntityTransformer;

    @BeforeMethod
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTransformUPEToUPShouldReturnUserProfile() {
        //GIVEN
        UserProfile userProfile = createUserProfile(Optional.empty());
        UserProfileEntity expected = createUserProfileEntity(Optional.empty());

        //WHEN
        UserProfileEntity result = underTest.transformUserProfileToUserProfileEntityForCreation(userProfile);

        //THEN
        assertEquals(result.getProfileId(), expected.getProfileId());
        assertEquals(result.getUser(), expected.getUser());
    }

    private UserProfile createUserProfile(Optional<Long> userProfileId) {
        User dummyUser = createDummyUser(Optional.empty());

        UserProfile userProfile = new UserProfile();
        setUserProfileId(userProfileId, userProfile);
        userProfile.setUser(dummyUser);
        userProfile.setCreatedAt(NOW);
        userProfile.setUpdatedAt(NOW);

        return userProfile;
    }

    private UserProfileEntity createUserProfileEntity(Optional<Long> userProfileEntityId) {
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        User dummyUser = createDummyUser(Optional.empty());
        setUserProfileEntityId(userProfileEntityId, userProfileEntity);

        ////BDDmockito
        userProfileEntity.setUser(userEntityTransformer.transformUserToUserEntity(dummyUser));
        userProfileEntity.setCreatedAt(NOW);
        userProfileEntity.setUpdatedAt(NOW);

        return userProfileEntity;
    }

    private void setUserProfileId(Optional<Long> userProfileId, UserProfile userProfile) {
        if (userProfileId.isPresent()) {
            userProfile.setProfileId(userProfileId.get());
        } else {
            userProfile.setProfileId(DUMMY_USER_PROFILE_ID);
        }
    }

    private void setUserProfileEntityId(Optional<Long> userProfileEntityId, UserProfileEntity userProfileEntity) {
        if (userProfileEntityId.isPresent()) {
            userProfileEntity.setProfileId(userProfileEntityId.get());
        } else {
            userProfileEntity.setProfileId(DUMMY_USER_PROFILE_ID);
        }
    }

    private User createDummyUser(Optional<Long> userId) {
        User user = new User();
        setUserIdToNewUser(userId, user);
        user.setUserEmail(DUMMY_USER_EMAIL);
        user.setUserPassword(DUMMY_USER_PASSWORD);
        user.setCreatedAt(NOW);
        user.setUpdatedAt(NOW);
        return user;
    }

    private void setUserIdToNewUser(Optional<Long> userId, User user) {
        if (userId.isPresent()) {
            user.setUserId(userId.get());
        } else {
            user.setUserId(DUMMY_USER_ID);
        }
    }
}
