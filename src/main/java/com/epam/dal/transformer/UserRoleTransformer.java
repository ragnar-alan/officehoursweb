package com.epam.dal.transformer;

import com.epam.dal.domain.UserRole;
import com.epam.dal.domain.UserRoleEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
@Component
public class UserRoleTransformer {

    public UserRole transformUserRoleEntityToUserRole(UserRoleEntity userRoleEntity) {
        UserRole role = new UserRole();
        role.setId(userRoleEntity.getId());
        role.setRole(userRoleEntity.getRole());
        return role;
    }
}
