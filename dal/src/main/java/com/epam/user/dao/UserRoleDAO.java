package com.epam.user.dao;


import com.epam.user.domain.UserRole;
import com.epam.user.domain.UserRoleEntity;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
public interface UserRoleDAO {
    UserRole findByUser(Long role);
    UserRoleEntity save(UserRole userRole);
}
