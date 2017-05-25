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

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="user_id")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="token_id", columnDefinition = "VARCHAR(255) NOT NULL")
    private UserTokenEntity userTokenEntity;

    @Column(name="created_at", columnDefinition = "DATETIME DEFAULT NOW() NOT NULL" )
    private ZonedDateTime createdAt;

    @Column(name="updated_at", nullable = true)
    private ZonedDateTime updatedAt;

    @Column(name="deleted_at", columnDefinition = "DATETIME DEFAULT NULL")
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

    public UserTokenEntity getUserTokenEntity() {
        return userTokenEntity;
    }

    public void setUserTokenEntity(UserTokenEntity userTokenEntity) {
        this.userTokenEntity = userTokenEntity;
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
