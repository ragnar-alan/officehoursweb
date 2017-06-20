package com.epam.user.transformer;

import com.epam.user.domain.*;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tamas_Boros on 6/13/2017.
 */
public class UserProfileEntityTransformerTest {

    private static final long DUMMY_USER_PROFILE_ID = 1L;
    private static final Long DUMMY_USER_ID= 1L;
    private static final String DUMMY_USER_EMAIL = "test@test.com";
    private static final String DUMMY_USER_PASSWORD = "1234";
    private static final String DUMMY_USER_FIRSTNAME = "Test";
    private static final String DUMMY_USER_LASTNAME = "User";
    private static final String TOKEN = "12:AB:12:AB";
    public static final long TOKEN_ID = 1L;
    private static final ZonedDateTime NOW = ZonedDateTime.now();

    @InjectMocks
    private UserProfileEntityTransformer underTest;

    @Mock
    private UserEntityTransformer userEntityTransformer;

    @Mock
    private UserTokenTransformer userTokenTransformer;

    @BeforeMethod
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTransformUPEToUPShouldReturnUserProfile() {
        //GIVEN
        UserProfile userProfile = createUserProfile(Optional.empty());
        UserProfileEntity expected = createUserProfileEntity(Optional.empty());
        UserTokenEntity userTokenEntity = createNewUserTokenEntity();
        UserToken userToken = createNewUserToken();

        BDDMockito.given(userTokenTransformer.transformUserTokenToUserTokenEntity(userToken)).willReturn(userTokenEntity);

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
        userProfile.setFirstname(DUMMY_USER_FIRSTNAME);
        userProfile.setLastname(DUMMY_USER_LASTNAME);
        userProfile.setToken(createNewUserToken());
        userProfile.setUser(dummyUser);
        userProfile.setCreatedAt(NOW);
        userProfile.setUpdatedAt(NOW);

        return userProfile;
    }

    private UserProfileEntity createUserProfileEntity(Optional<Long> userProfileEntityId) {
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        User dummyUser = createDummyUser(Optional.empty());
        UserEntity dummyUserEntity = createDummyUserEntity(Optional.empty());
        setUserProfileEntityId(userProfileEntityId, userProfileEntity);

        BDDMockito.given(userEntityTransformer.transformUserToUserEntity(dummyUser)).willReturn(dummyUserEntity);
        userProfileEntity.setUser(dummyUserEntity);
        userProfileEntity.setFirstname(DUMMY_USER_FIRSTNAME);
        userProfileEntity.setLastname(DUMMY_USER_LASTNAME);
        userProfileEntity.setUserTokenEntity(createNewUserTokenEntity());
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

    private UserEntity createDummyUserEntity(Optional<Long> userId) {
        UserEntity userEntity = new UserEntity();
        setUserIdToNewUserEntity(userId, userEntity);
        userEntity.setUserEmail(DUMMY_USER_EMAIL);
        userEntity.setUserPassword(DUMMY_USER_PASSWORD);
        userEntity.setCreatedAt(NOW);
        userEntity.setUpdatedAt(NOW);
        return userEntity;
    }

    private void setUserIdToNewUser(Optional<Long> userId, User user) {
        if (userId.isPresent()) {
            user.setUserId(userId.get());
        } else {
            user.setUserId(DUMMY_USER_ID);
        }
    }

    private void setUserIdToNewUserEntity(Optional<Long> userId, UserEntity userEntity) {
        if (userId.isPresent()) {
            userEntity.setUserId(userId.get());
        } else {
            userEntity.setUserId(DUMMY_USER_ID);
        }
    }

    private UserTokenEntity createNewUserTokenEntity() {
        UserTokenEntity userTokenEntity = new UserTokenEntity();
        userTokenEntity.setToken(TOKEN);
        userTokenEntity.setTokenId(TOKEN_ID);
        userTokenEntity.setCreatedAt(NOW);
        userTokenEntity.setUpdatedAt(NOW);
        userTokenEntity.setDeletedAt(null);
        return userTokenEntity;
    }

    private UserToken createNewUserToken() {
        UserToken userToken = new UserToken();
        userToken.setToken(TOKEN);
        userToken.setTokenId(TOKEN_ID);
        userToken.setCreatedAt(NOW);
        userToken.setUpdatedAt(NOW);
        userToken.setDeletedAt(null);
        return userToken;
    }
}
