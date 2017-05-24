package com.epam.dal.transformer;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserEntity;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

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
        userEntity.setCreatedAt(ZonedDateTime.now());
        userEntity.setUpdatedAt(ZonedDateTime.now());
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

    public List<User> bulkTransformUserEntityToUser(Iterable<UserEntity> userEntities) {
        List<User> userList = new ArrayList<>();
        for(UserEntity ue : userEntities) {
            userList.add(transformUserEntityToUser(ue));
        }
        return userList;
    }



}
