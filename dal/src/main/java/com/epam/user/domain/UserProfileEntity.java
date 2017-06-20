package com.epam.user.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */

@Entity
@Table(name = "user_profiles", uniqueConstraints = @UniqueConstraint(columnNames={"user_id"}))
public class UserProfileEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "first_name", columnDefinition = "VARCHAR(200) DEFAULT NULL")
    private String firstname;

    @Column(name = "last_name", columnDefinition = "VARCHAR(200) DEFAULT NULL")
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "token_id", columnDefinition = "VARCHAR(255) DEFAULT NULL")
    private UserTokenEntity userTokenEntity;

    @Column(name = "created_at", columnDefinition = "DATETIME DEFAULT NOW() NOT NULL")
    @NotNull
    private ZonedDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT NULL")
    private ZonedDateTime updatedAt;

    @Column(name = "deleted_at", columnDefinition = "DATETIME DEFAULT NULL")
    private ZonedDateTime deletedAt;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
