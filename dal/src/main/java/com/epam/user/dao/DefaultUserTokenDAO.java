package com.epam.user.dao;

import com.epam.user.domain.UserToken;
import com.epam.user.repository.UserTokenRepository;
import com.epam.user.transformer.UserTokenTransformer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Tamas_Boros on 6/20/2017.
 */
public class DefaultUserTokenDAO implements UserTokenDAO {

    @Autowired
    private UserTokenRepository userTokenRepository;

    @Autowired
    private UserTokenTransformer userTokenTransformer;

    @Override
    public UserToken findOne(Long tokenId) {
        return userTokenTransformer.transformUserTokenEntityToUserToken(userTokenRepository.findOne(tokenId));
    }
}
