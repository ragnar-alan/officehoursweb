package com.epam.dal.dao;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserEntity;
import com.epam.dal.domain.UserRole;
import com.epam.dal.domain.UserRoleEntity;
import com.epam.dal.repository.UserRepository;
import com.epam.dal.repository.UserRoleRepository;
import com.epam.dal.transformer.UserEntityTransformer;
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

    @Autowired
    private UserEntityTransformer userEntityTransformer;

    @Override
    public UserRole findByUser(Long userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        User user = userEntityTransformer.transformUserEntityToUser(userEntity);
        return userRoleTransformer.transformUserRoleEntityToUserRole(userRoleRepository.findByUser(userEntity));
    }

    @Override
    public UserRoleEntity save(UserRole userRole) {
        return userRoleRepository.save(userRoleTransformer.tranformUserRoleToUserRoleEntity(userRole));
    }
}
