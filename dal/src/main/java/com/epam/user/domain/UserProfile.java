package com.epam.user.domain;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Data
public class UserProfile {

    private Long profileId;
    private User user;
    private UserTokenEntity token;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime deletedAt;

}
