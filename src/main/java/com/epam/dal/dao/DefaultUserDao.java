package com.epam.dal.dao;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserEntity;
import com.epam.dal.repository.UserRepository;
import com.epam.dal.transformer.UserEntityTransformer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Component
public class DefaultUserDao implements UserDao {

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
    public User getUserByEmail(String email) {
        return userEntityTransformer.transformUserEntityToUser(userRepository.findByUserEmail(email));
    }

    @Override
    public User getOneUserById(Long userId) {
        return userEntityTransformer.transformUserEntityToUser(userRepository.findOne(userId));
    }
}
