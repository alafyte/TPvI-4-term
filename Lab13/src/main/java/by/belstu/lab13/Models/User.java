package by.belstu.lab13.Models;

public class User {
    private String login;
    private byte[] password;
    private String role = "user";

    public User(String login, byte[] password) {
        this.login = login;
        this.password = password;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
