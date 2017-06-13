package com.epam.user.transformer;

import com.epam.user.domain.User;
import com.epam.user.domain.UserEntity;
import org.assertj.core.api.ListAssert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Tamas_Boros on 6/13/2017.
 */
public class UserEntityTransformerTest {

    private static final Long DUMMY_USER_ID= 1L;
    private static final String DUMMY_USER_EMAIL = "test@test.com";
    private static final String DUMMY_USER_PASSWORD = "1234";
    private static final Long[] DUMMY_USER_IDS = {1L, 2L, 3L};
    private static final ZonedDateTime NOW = ZonedDateTime.now();

    @InjectMocks
    private UserEntityTransformer underTest;

    @BeforeMethod
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTransformUserEntityToUserShouldReturnUser() {
        UserEntity dummyUserEntity = createDummyUserEntity(Optional.empty());
        User expected = createDummyUser(Optional.empty());

        User result = underTest.transformUserEntityToUser(dummyUserEntity);

        assertEquals(result, expected);
    }

    @Test
    public void testTransformUserToUserEntityShouldReturnUser() {
        User dummyUser = createDummyUser(Optional.empty());
        UserEntity expected = createDummyUserEntity(Optional.empty());

        UserEntity result = underTest.transformUserToUserEntity(dummyUser);

        assertEquals(result.getUserId(), expected.getUserId());
        assertEquals(result.getUserEmail(), expected.getUserEmail());
        assertEquals(result.getUserPassword(), expected.getUserPassword());
        assertEquals(result.getCreatedAt(), expected.getCreatedAt());
    }

    @Test
    public void testTransformUserEntitiesToUserListShouldReturnListOfUsers() {
        //GIVEN
        List<UserEntity> userEntityList = createDummyUserEntities();
        List<User> expected =  createDummyUsers();

        //WHEN
        List<User> result = underTest.bulkTransformUserEntityToUser(userEntityList);

        //THEN
        assertEquals(result, expected);
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

    private List<UserEntity> createDummyUserEntities() {
        List<UserEntity> list = new ArrayList<>();
        for (Long id : DUMMY_USER_IDS) {
            list.add(createDummyUserEntity(Optional.of(id)));
        }
        return list;
    }

    private List<User> createDummyUsers() {
        List<User> list = new ArrayList<>();
        for (Long id : DUMMY_USER_IDS) {
            list.add(createDummyUser(Optional.of(id)));
        }
        return list;
    }
}
