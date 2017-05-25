package com.epam.dal.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */

@Entity
@Table(name="token")
public class UserTokenEntity {

    @Id
    @GeneratedValue
    @Column(name="token_id")
    private Long tokenId;

    @Column(name="token")
    private String token;

    @Column(name="created_at", columnDefinition = "DATETIME DEFAULT NOW() NOT NULL" )
    private ZonedDateTime createdAt;

    @Column(name="updated_at", columnDefinition = "DATETIME DEFAULT NULL")
    private ZonedDateTime updatedAt;

    @Column(name="deleted_at", columnDefinition = "DATETIME DEFAULT NULL")
    private ZonedDateTime deletedAt;

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
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
