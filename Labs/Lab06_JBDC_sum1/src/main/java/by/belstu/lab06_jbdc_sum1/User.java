package com.example.task3.model;

public class User {
    private int id;
    private String login;
    private int sum;

    //region Constructors
    public User(int id, String login, int sum) {
        this.id = id;
        this.login = login;
        this.sum = sum;
    }
    public User() { }
    //endregion
    //region Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    //endregion
}
