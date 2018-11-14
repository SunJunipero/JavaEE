package com.petshop.project.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserRole  {
    private int roles_id;
    private int user_id;
    private String authority;

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return authority;
    }

    public void setRole(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roles_id=" + roles_id +
                ", user_id=" + user_id +
                ", role='" + authority + '\'' +
                '}';
    }
}
