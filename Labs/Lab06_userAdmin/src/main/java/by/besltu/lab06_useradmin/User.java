package com.example.task8_JDBC_UserAdmin.model;

public class User {
    private int id;
    private String password;
    private Role role;

    public enum Role {
        USER,
        ADMIN
    }

    //region Constructors
    public User(int id, String password, Role role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }
    //endregion
    //region Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    //endregion
}
