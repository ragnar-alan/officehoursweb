package com.epam.user.dao;

import com.epam.user.domain.UserToken;
import com.epam.user.domain.UserTokenEntity;
import com.epam.user.repository.UserTokenRepository;
import com.epam.user.transformer.UserTokenTransformer;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;

/**
 * Created by Tamas_Boros on 6/20/2017.
 */
public class DefaultUserTokenDAOTest {

    private static final String TOKEN = "12:AB:12:AB";
    public static final long TOKEN_ID = 1L;
    public static final ZonedDateTime NOW = ZonedDateTime.now();

    @InjectMocks
    private DefaultUserTokenDAO underTest;

    @Mock
    private UserTokenTransformer userTokenTransformer;

    @Mock
    private UserTokenRepository userTokenRepository;

    @BeforeMethod
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testFindOneShouldReturnExactlyOneUserToken() {
        UserTokenEntity userTokenEntity = createNewUserTokenEntity();
        UserToken expected = createNewUserToken();

        BDDMockito.given(userTokenTransformer.transformUserTokenEntityToUserToken(userTokenEntity)).willReturn(expected);
        BDDMockito.given(userTokenRepository.findOne(TOKEN_ID)).willReturn(userTokenEntity);

        UserToken result = underTest.findOne(TOKEN_ID);

        assertEquals(result, expected);
    }


    private UserToken createNewUserToken() {
        UserToken userToken = new UserToken();
        userToken.setToken(TOKEN);
        userToken.setTokenId(TOKEN_ID);
        userToken.setCreatedAt(NOW);
        userToken.setUpdatedAt(NOW);
        userToken.setDeletedAt(null);
        return userToken;
    }

    private UserTokenEntity createNewUserTokenEntity() {
        UserTokenEntity userTokenEntity = new UserTokenEntity();
        userTokenEntity.setToken(TOKEN);
        userTokenEntity.setTokenId(TOKEN_ID);
        userTokenEntity.setCreatedAt(NOW);
        userTokenEntity.setUpdatedAt(NOW);
        userTokenEntity.setDeletedAt(null);
        return userTokenEntity;
    }

}
