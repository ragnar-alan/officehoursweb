package com.epam.dal.dao;

import com.epam.dal.domain.UserRole;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
public interface UserRoleDao {
    public UserRole findByUser(Long role);
}
