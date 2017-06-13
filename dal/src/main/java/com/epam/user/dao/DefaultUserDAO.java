package com.epam.user.dao;


import com.epam.user.domain.User;
import com.epam.user.domain.UserEntity;
import com.epam.user.repository.UserRepository;
import com.epam.user.transformer.UserEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Component
public class DefaultUserDAO implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityTransformer userEntityTransformer;

    @Override
    public UserEntity save(User user) {
        return userRepository.save(userEntityTransformer.transformUserToUserEntity(user));
    }

    @Override
    public List<User> getAllUser() {
        return userEntityTransformer.bulkTransformUserEntityToUser(userRepository.findAll());
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByUserEmail(email);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        UserEntity userEntity = userRepository.findByUserEmail(userEmail);
        return userEntityTransformer.transformUserEntityToUser(userEntity);
    }

    @Override
    public User getOneUserById(Long userId) {
        return userEntityTransformer.transformUserEntityToUser(userRepository.findOne(userId));
    }
}
