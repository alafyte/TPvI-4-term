package task.loginsum.Model;

public class User {

    private String login;

    private  String password;
    private int sum;

    //region Constructors
    public User( String login, String password, int sum) {

        this.login = login;
        this.password = password;
        this.sum = sum;
    }
    public User() { }
    //endregion
    //region Getter and Setter


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion
}
