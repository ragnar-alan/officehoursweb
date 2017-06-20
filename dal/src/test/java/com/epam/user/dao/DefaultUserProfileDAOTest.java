package com.epam.user.dao;

import com.epam.user.domain.*;
import com.epam.user.repository.UserProfileRepository;
import com.epam.user.transformer.UserProfileEntityTransformer;
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
 * Created by Tamas_Boros on 6/14/2017.
 */
public class DefaultUserProfileDAOTest {

    private static final long USER_ID = 1L;
    private static final String USER_EMAIL = "test@test.com";
    private static final String USER_PASSWORD = "password";
    private static final String DUMMY_USER_FIRSTNAME = "Test";
    private static final String DUMMY_USER_LASTNAME = "User";
    private static final String TOKEN = "12:AB:12:AB";
    public static final long TOKEN_ID = 1L;
    private static final ZonedDateTime NOW = ZonedDateTime.now();

    @InjectMocks
    private DefaultUserProfileDAO underTest;

    @Mock
    private UserProfileEntityTransformer userProfileEntityTransformer;

    @Mock
    private UserProfileRepository userProfileRepository;

    @BeforeMethod
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUserProfileShouldReturnTheSavedEntity() {
        User user = createNewUser(Optional.empty());
        UserEntity userEntity = createNewUserEntity(Optional.empty());
        UserProfile userProfile = createNewUserProfile(user);
        UserProfileEntity expected = createNewUserProfileEntity(userEntity);

        BDDMockito.given(userProfileEntityTransformer.transformUserProfileToUserProfileEntityForCreation(userProfile)).willReturn(expected);
        BDDMockito.given(userProfileRepository.save(expected)).willReturn(expected);

        UserProfileEntity savedEntity = underTest.save(userProfile);
        assertEquals(savedEntity, expected);
    }

    private User createNewUser(Optional<Long> userId) {
        User user = new User();
        setUserIdToNewUser(userId, user);
        user.setUserEmail(USER_EMAIL);
        user.setUserPassword(USER_PASSWORD);
        user.setCreatedAt(NOW);
        user.setUpdatedAt(NOW);
        user.setDeletedAt(null);
        return user;
    }

    private UserProfile createNewUserProfile(User user) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);
        userProfile.setFirstname(DUMMY_USER_FIRSTNAME);
        userProfile.setLastname(DUMMY_USER_LASTNAME);
        userProfile.setToken(createNewUserToken());
        userProfile.setCreatedAt(NOW);
        userProfile.setUpdatedAt(NOW);
        return userProfile;
    }

    private UserProfileEntity createNewUserProfileEntity(UserEntity userEntity) {
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        userProfileEntity.setUser(userEntity);
        userProfileEntity.setFirstname(DUMMY_USER_FIRSTNAME);
        userProfileEntity.setLastname(DUMMY_USER_LASTNAME);
        userProfileEntity.setUserTokenEntity(createNewUserTokenEntity());
        userProfileEntity.setCreatedAt(NOW);
        userProfileEntity.setUpdatedAt(NOW);
        return userProfileEntity;
    }

    private UserEntity createNewUserEntity(Optional<Long> userId) {
        UserEntity userEntity = new UserEntity();
        setUserIdToNewUserEntity(userId, userEntity);
        userEntity.setUserEmail(USER_EMAIL);
        userEntity.setUserPassword(USER_PASSWORD);
        userEntity.setCreatedAt(NOW);
        userEntity.setUpdatedAt(NOW);
        userEntity.setDeletedAt(null);
        return userEntity;
    }

    private void setUserIdToNewUser(Optional<Long> userId, User user) {
        if (userId.isPresent()) {
            user.setUserId(userId.get());
        } else {
            user.setUserId(USER_ID);
        }
    }

    private void setUserIdToNewUserEntity(Optional<Long> userId, UserEntity userEntity) {
        if (userId.isPresent()) {
            userEntity.setUserId(userId.get());
        } else {
            userEntity.setUserId(USER_ID);
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
