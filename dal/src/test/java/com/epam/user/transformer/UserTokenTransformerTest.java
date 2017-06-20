package com.epam.user.transformer;

import com.epam.user.domain.UserToken;
import com.epam.user.domain.UserTokenEntity;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;

/**
 * Created by Tamas_Boros on 6/20/2017.
 */
public class UserTokenTransformerTest {

    private static final String TOKEN = "12:AB:12:AB";
    public static final long TOKEN_ID = 1L;
    public static final ZonedDateTime NOW = ZonedDateTime.now();

    @InjectMocks
    UserTokenTransformer underTest;

    @BeforeMethod
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTransformUserTokenEntityToUserTokenShouldReturnUserToken() {
        UserTokenEntity userTokenEntity = createNewUserTokenEntity();
        UserToken expected = createNewUserToken();

        UserToken result = underTest.transformUserTokenEntityToUserToken(userTokenEntity);

        assertEquals(result, expected);
    }

    @Test
    public void testTransformUserTokenToUserTokenEntityShouldReturnUserTokenEntity() {
        UserToken userToken = createNewUserToken();
        UserTokenEntity expected = createNewUserTokenEntity();

        UserTokenEntity result = underTest.transformUserTokenToUserTokenEntity(userToken);

        assertEquals(result.getTokenId(), expected.getTokenId());
        assertEquals(result.getToken(), expected.getToken());
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
