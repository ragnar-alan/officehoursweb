package com.epam.user.transformer;

import com.epam.user.domain.UserToken;
import com.epam.user.domain.UserTokenEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 6/20/2017.
 */
@Component
public class UserTokenTransformer {

    public UserToken transformUserTokenEntityToUserToken(UserTokenEntity userTokenEntity) {
        UserToken userToken = new UserToken();
        userToken.setTokenId(userTokenEntity.getTokenId());
        userToken.setToken(userTokenEntity.getToken());
        userToken.setCreatedAt(userTokenEntity.getCreatedAt());
        userToken.setUpdatedAt(userTokenEntity.getUpdatedAt());
        userToken.setDeletedAt(userTokenEntity.getDeletedAt());
        return userToken;
    }

    public UserTokenEntity transformUserTokenToUserTokenEntity(UserToken userToken) {
        UserTokenEntity userTokenEntity = new UserTokenEntity();
        userTokenEntity.setTokenId(userToken.getTokenId());
        userTokenEntity.setToken(userToken.getToken());
        userTokenEntity.setCreatedAt(userToken.getCreatedAt());
        userTokenEntity.setUpdatedAt(userToken.getUpdatedAt());
        userTokenEntity.setDeletedAt(userToken.getDeletedAt());
        return userTokenEntity;
    }

}
