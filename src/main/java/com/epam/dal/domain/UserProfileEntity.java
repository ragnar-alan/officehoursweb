package com.epam.dal.domain;


import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */

@Entity
@Table(name="user_profiles")
public class UserProfileEntity {

    @Id
    @GeneratedValue
    @Column(name="profile_id")
    private Long profileId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="token_id", columnDefinition = "NOT NULL")
    private UserTokenEntity token;

    @Column(name="created_at", columnDefinition = "DEFAULT NOW() NOT NULL" )
    private ZonedDateTime createdAt;

    @Column(name="updated_at", nullable = true)
    private ZonedDateTime updatedAt;

    @Column(name="deleted_at", columnDefinition = "DEFAULT NULL")
    private ZonedDateTime deletedAt;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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
