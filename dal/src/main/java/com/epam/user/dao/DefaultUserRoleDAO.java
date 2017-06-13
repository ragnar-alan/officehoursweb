package com.epam.user.dao;


import com.epam.user.domain.User;
import com.epam.user.domain.UserEntity;
import com.epam.user.domain.UserRole;
import com.epam.user.domain.UserRoleEntity;
import com.epam.user.repository.UserRepository;
import com.epam.user.repository.UserRoleRepository;
import com.epam.user.transformer.UserEntityTransformer;
import com.epam.user.transformer.UserRoleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
@Component
public class DefaultUserRoleDAO implements UserRoleDAO {

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
        return userRoleRepository.save(userRoleTransformer.transformUserRoleToUserRoleEntity(userRole));
    }
}
