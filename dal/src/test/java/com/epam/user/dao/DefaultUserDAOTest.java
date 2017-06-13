package com.epam.user.dao;

import com.epam.user.domain.User;
import com.epam.user.domain.UserEntity;
import com.epam.user.repository.UserRepository;
import com.epam.user.transformer.UserEntityTransformer;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tamas_Boros on 5/29/2017.
 */
public class DefaultUserDAOTest {

    private static final long USER_ID = 1L;
    private static final String USER_EMAIL = "test@test.com";
    private static final String USER_PASSWORD = "password";
    private static final ZonedDateTime NOW = ZonedDateTime.now();
    private static final Long[] USER_IDS = {1L, 2L, 3L};

    @InjectMocks
    private DefaultUserDAO underTest;

    @Mock
    private UserEntityTransformer userEntityTransformer;

    @Mock
    private UserRepository userRepository;

    @BeforeMethod
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserShouldReturnUser() {
        //GIVEN
        UserEntity userEntity = createNewUserEntity(Optional.empty());
        User user = createNewUser(Optional.empty());

        BDDMockito.given(userRepository.findOne(USER_ID)).willReturn(userEntity);
        BDDMockito.given(userEntityTransformer.transformUserEntityToUser(userEntity)).willReturn(user);
        //WHEN
        User result = underTest.getOneUserById(USER_ID);
        //THEN

        assertEquals(result, user);
    }

    @Test
    public void testGetUsersShouldReturnListOfUsers() {
        //GIVEN
        List<UserEntity> userEntities = getUserEntities();
        List<User> users = getUsers();

        BDDMockito.given(userRepository.findAll()).willReturn(userEntities);
        BDDMockito.given(userEntityTransformer.bulkTransformUserEntityToUser(userEntities)).willReturn(users);
        //WHEN

        List<User> results = underTest.getAllUser();
        //THEN
        assertEquals(results, users);
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (Long userId : USER_IDS) {
            users.add(createNewUser(Optional.of(userId)));
        }
        return users;
    }

    private List<UserEntity> getUserEntities() {
        List<UserEntity> userEntities = new ArrayList<>();
        for (Long userId : USER_IDS) {
            userEntities.add(createNewUserEntity(Optional.of(userId)));
        }
        return userEntities;
    }

    @Test
    public void tesUserShouldBeSavedAndReturnTheSavedEntity() {
        User user = createNewUser(Optional.empty());
        UserEntity userEntity = createNewUserEntity(Optional.empty());

        BDDMockito.given(userEntityTransformer.transformUserToUserEntity(user)).willReturn(userEntity);
        BDDMockito.given(userRepository.save(userEntity)).willReturn(userEntity);

        UserEntity savedEntity = underTest.save(user);
        assertEquals(savedEntity, userEntity);
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

    private void setUserIdToNewUserEntity(Optional<Long> userId, UserEntity userEntity) {
        if (userId.isPresent()) {
            userEntity.setUserId(userId.get());
        } else {
            userEntity.setUserId(USER_ID);
        }
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

    private void setUserIdToNewUser(Optional<Long> userId, User user) {
        if (userId.isPresent()) {
            user.setUserId(userId.get());
        } else {
            user.setUserId(USER_ID);
        }
    }
}
