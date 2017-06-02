package com.epam.dal.dao;

import com.epam.dal.domain.UserEntity;
import com.epam.dal.domain.UserRole;
import com.epam.dal.domain.UserRoleEntity;
import com.epam.dal.repository.UserRepository;
import com.epam.dal.repository.UserRoleRepository;
import com.epam.dal.transformer.UserRoleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
@Component
public class DefaultUserRoleDao implements UserRoleDao {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleTransformer userRoleTransformer;

    @Override
    public UserRole findByUser(Long userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        return userRoleTransformer.transformUserRoleEntityToUserRole(userRoleRepository.findByUserUserId(userEntity));
    }
}
