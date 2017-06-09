package com.epam.user.transformer;

import com.epam.dal.domain.UserEntity;
import com.epam.dal.domain.UserRole;
import com.epam.dal.domain.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
@Component
public class UserRoleTransformer {

    @Autowired
    private UserEntityTransformer userEntityTransformer;

    public UserRole transformUserRoleEntityToUserRole(UserRoleEntity userRoleEntity) {
        UserRole role = new UserRole();
        role.setId(userRoleEntity.getId());
        role.setRole(userRoleEntity.getRole());
        role.setUser(userEntityTransformer.transformUserEntityToUser(userRoleEntity.getUserEntity()));
        return role;
    }

    public UserRoleEntity tranformUserRoleToUserRoleEntity(UserRole userRole) {
        UserRoleEntity roleEntity = new UserRoleEntity();
        roleEntity.setId(userRole.getId());
        roleEntity.setRole(userRole.getRole());
        roleEntity.setUserEntity(userEntityTransformer.transformUserToUserEntity(userRole.getUser()));
        return roleEntity;
    }
}
