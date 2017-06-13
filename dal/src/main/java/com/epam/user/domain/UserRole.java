package com.epam.user.domain;

import lombok.Data;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
@Data
public class UserRole {

    private Long id;
    private String role;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
