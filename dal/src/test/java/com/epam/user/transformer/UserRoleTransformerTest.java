package com.epam.user.transformer;

import com.epam.user.domain.User;
import com.epam.user.domain.UserEntity;
import com.epam.user.domain.UserRole;
import com.epam.user.domain.UserRoleEntity;
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
 * Created by Tamas_Boros on 6/13/2017.
 */
public class UserRoleTransformerTest {

    private static final long DUMMY_USER_ROLE_ENTITY_ID = 1L;
    private static final String DUMMY_USER_ROLE = "ADMIN";
    private static final Long DUMMY_USER_ID= 1L;
    private static final String DUMMY_USER_EMAIL = "test@test.com";
    private static final String DUMMY_USER_PASSWORD = "1234";
    private static final ZonedDateTime NOW = ZonedDateTime.now();

    @InjectMocks
    private UserRoleTransformer underTest;

    @Mock
    private UserEntityTransformer userEntityTransformer;

    @BeforeMethod
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTransformUserRoleEntityToUserRoleShouldReturnUserRole() {
        //GIVEN
        UserEntity userEntity = createDummyUserEntity(Optional.empty());
        UserRoleEntity userRoleEntity = createUserRoleEntity(userEntity);
        UserRole expected = createUserRole();
        User user = createDummyUser(Optional.empty());

        //WHEN
        BDDMockito.given(userEntityTransformer.transformUserEntityToUser(userEntity)).willReturn(user);
        UserRole result = underTest.transformUserRoleEntityToUserRole(userRoleEntity);

        //THEN
        assertEquals(result, expected);
    }

    @Test
    public void testTransformUserRoleToUserRoleEntityShouldReturnUserRoleEntity() {
        //GIVEN
        UserEntity userEntity = createDummyUserEntity(Optional.empty());
        User user = createDummyUser(Optional.empty());
        UserRole userRole = createUserRole();
        UserRoleEntity expected = createUserRoleEntity(userEntity);

        //WHEN
        BDDMockito.given(userEntityTransformer.transformUserToUserEntity(user)).willReturn(userEntity);
        UserRoleEntity result = underTest.transformUserRoleToUserRoleEntity(userRole);

        //THEN
        assertEquals(result.getId(), expected.getId());
        assertEquals(result.getRole(), expected.getRole());
        assertEquals(result.getUserEntity(), expected.getUserEntity());
    }

    private UserRoleEntity createUserRoleEntity(UserEntity userEntity) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setId(DUMMY_USER_ROLE_ENTITY_ID);
        userRoleEntity.setRole(DUMMY_USER_ROLE);
        userRoleEntity.setUserEntity(userEntity);

        return userRoleEntity;
    }

    private UserRole createUserRole() {
        User dummyUser = createDummyUser(Optional.empty());

        UserRole userRole = new UserRole();
        userRole.setId(DUMMY_USER_ROLE_ENTITY_ID);
        userRole.setRole(DUMMY_USER_ROLE);
        userRole.setUser(dummyUser);

        return userRole;
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
}

