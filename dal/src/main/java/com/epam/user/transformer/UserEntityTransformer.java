package com.epam.user.transformer;

import com.epam.user.domain.User;
import com.epam.user.domain.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Component
public class UserEntityTransformer {

    public UserEntity transformUserToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(user.getUserId());
        userEntity.setUserEmail(user.getUserEmail());
        userEntity.setUserPassword(user.getUserPassword());
        userEntity.setCreatedAt(user.getCreatedAt());
        userEntity.setUpdatedAt(user.getUpdatedAt());
        return userEntity;
    }

    public User transformUserEntityToUser(UserEntity userEntity) {
        User user = new User();
        user.setUserId(userEntity.getUserId());
        user.setUserEmail(userEntity.getUserEmail());
        user.setUserPassword(userEntity.getUserPassword());
        user.setCreatedAt(userEntity.getCreatedAt());
        user.setUpdatedAt(userEntity.getUpdatedAt());
        return user;
    }

    public List<User> bulkTransformUserEntityToUser(List<UserEntity> userEntities) {
        return userEntities.stream().map(ue -> transformUserEntityToUser(ue)).collect(Collectors.toList());
    }
}
