package com.epam.user.domain;

import lombok.Data;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (!id.equals(userRole.id)) return false;
        if (!role.equals(userRole.role)) return false;
        return user.equals(userRole.user);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
