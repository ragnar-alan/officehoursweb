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

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserTokenEntity getToken() {
        return token;
    }

    public void setToken(UserTokenEntity token) {
        this.token = token;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ZonedDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(ZonedDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
