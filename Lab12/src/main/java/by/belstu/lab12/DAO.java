package by.belstu.lab12;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DAO implements IConnection, IQuery {
    private String url;
    private String user;
    private String password;
    private String driver;
    private Connection con;
    private Statement statement;

    public DAO() {

    }

    public ArrayList<String> getProperties() {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        url = resourceBundle.getString("db.url");
        user = resourceBundle.getString("db.username");
        password = resourceBundle.getString("db.password");
        driver = resourceBundle.getString("db.driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver class is missing in classpath", e);
        }

        ArrayList<String> ret = new ArrayList<>();
        ret.add(url);
        ret.add(user);
        ret.add(password);
        return ret;
    }
    public Boolean getConnection() {
        try {
            getProperties();
            con = DriverManager.getConnection(url, user, password);
            statement = con.createStatement();
            return true;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ResultSet ExecuteQuery(String sqlQuery) {
        try {
            return statement.executeQuery(sqlQuery);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void closeConnection()
    {
        try {
            con.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
