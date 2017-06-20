package com.epam.user.dao;

import com.epam.user.domain.UserToken;

/**
 * Created by Tamas_Boros on 6/20/2017.
 */
public interface UserTokenDAO {

    UserToken findOne(Long tokenId);

}
