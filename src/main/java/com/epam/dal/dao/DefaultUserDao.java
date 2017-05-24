package com.epam.dal.dao;

import com.epam.dal.domain.User;
import com.epam.dal.repository.UserRepository;
import com.epam.dal.transformer.UserEntityTransformer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Component
public class DefaultUserDao implements UserDao{

    private UserRepository userRepository;

    private UserEntityTransformer userEntityTransformer;

    @Override
    public void save(User user) {
        userRepository.save(userEntityTransformer.transformUserToUserEntity(user));
    }

    @Override
    public void update(User user) {}

    @Override
    public void delete(Long uid) {
        userRepository.delete(uid);
    }

    @Override
    public List<User> getAllUser() {
        return userEntityTransformer.bulkTransformUserEntityToUser(userRepository.findAll());
    }
}
