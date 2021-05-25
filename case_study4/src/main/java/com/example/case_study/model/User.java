package com.example.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String user;
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String users) {
        this.user = users;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
