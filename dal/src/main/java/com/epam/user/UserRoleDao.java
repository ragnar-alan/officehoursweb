package com.epam.user;

import com.epam.dal.domain.UserRole;
import com.epam.dal.domain.UserRoleEntity;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
public interface UserRoleDao {
    UserRole findByUser(Long role);
    UserRoleEntity save(UserRole userRole);
}
