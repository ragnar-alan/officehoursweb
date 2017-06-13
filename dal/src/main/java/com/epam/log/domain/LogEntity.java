package com.epam.log.domain;

import com.epam.user.domain.UserTokenEntity;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Entity
@Table(name = "logs")
public class LogEntity {
    @Id
    @GeneratedValue
    @Column(name = "log_id")
    private Long logId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "token_id")
    private UserTokenEntity userTokenEntity;

    @Column(name = "user_added_time")
    private byte userAddedTime;

    @Column(name = "created_at", columnDefinition = "DATETIME DEFAULT NOW() NOT NULL")
    private ZonedDateTime createdAt;

    @Column(name = "deleted_at")
    private ZonedDateTime deletedAt;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
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

    public ZonedDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(ZonedDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public byte getUserAddedTime() {
        return userAddedTime;
    }

    public void setUserAddedTime(byte userAddedTime) {
        this.userAddedTime = userAddedTime;
    }
}
