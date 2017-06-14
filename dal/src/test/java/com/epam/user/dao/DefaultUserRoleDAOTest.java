package com.epam.user.dao;

import com.epam.user.domain.User;
import com.epam.user.domain.UserEntity;
import com.epam.user.domain.UserRole;
import com.epam.user.domain.UserRoleEntity;
import com.epam.user.repository.UserRepository;
import com.epam.user.repository.UserRoleRepository;
import com.epam.user.transformer.UserRoleTransformer;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Created by Tamas_Boros on 6/14/2017.
 */
public class DefaultUserRoleDAOTest {

    private static final long USER_ID = 1L;
    private static final String USER_EMAIL = "test@test.com";
    private static final String USER_PASSWORD = "password";
    private static final ZonedDateTime NOW = ZonedDateTime.now();
    private static final String ROLE = "ADMIN";

    @InjectMocks
    private DefaultUserRoleDAO underTest;

    @Mock
    private UserRoleTransformer userRoleTransformer;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRoleRepository userRoleRepository;

    @BeforeMethod
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByUserShouldReturnThatUserRole() {
        UserEntity userEntity = createNewUserEntity(Optional.empty());
        UserRoleEntity userRoleEntity = createNewUserRoleEntity(userEntity);
        User user = createNewUser(Optional.empty());
        UserRole expected = createNewUserRole(user);

        BDDMockito.given(userRepository.findByUserId(USER_ID)).willReturn(userEntity);
        BDDMockito.given(userRoleTransformer.transformUserRoleEntityToUserRole(userRoleEntity)).willReturn(expected);
        BDDMockito.given(userRoleRepository.findByUserEntity(userEntity)).willReturn(userRoleEntity);

        UserRole result = underTest.findByUser(USER_ID);

        assertEquals(result, expected);
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

    private UserRoleEntity createNewUserRoleEntity(UserEntity userEntity) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setId(USER_ID);
        userRoleEntity.setUserEntity(userEntity);
        userRoleEntity.setRole(ROLE);
        return userRoleEntity;
    }

    private UserRole createNewUserRole(User user) {
        UserRole userRole = new UserRole();
        userRole.setId(USER_ID);
        userRole.setRole(ROLE);
        userRole.setUser(user);
        return userRole;
    }

    private void setUserIdToNewUserEntity(Optional<Long> userId, UserEntity userEntity) {
        if (userId.isPresent()) {
            userEntity.setUserId(userId.get());
        } else {
            userEntity.setUserId(USER_ID);
        }
    }

    private void setUserIdToNewUser(Optional<Long> userId, User user) {
        if (userId.isPresent()) {
            user.setUserId(userId.get());
        } else {
            user.setUserId(USER_ID);
        }
    }
}
