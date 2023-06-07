package task.loginsum.BD;

import task.loginsum.Model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    private static String url = "jdbc:mysql://localhost:3306/loginSum?useSSL=false";
    private static String username = "root";
    private static String password = "root";

    public static ArrayList<User> select() {
        ArrayList<User> users = new ArrayList<User>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM users";

                try(Statement statement = connection.createStatement()){
                    ResultSet resultSet = statement.executeQuery(sql);
                    while (resultSet.next()){
                        String login = resultSet.getString("login");
                        String password = resultSet.getString("password");
                        int sum = resultSet.getInt("sum");

                        User user = new User( login, password,sum);
                        users.add(user);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return users;
    }

    public static int update(User user) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

               /* String sql = "UPDATE users SET login = ?, sum = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setInt(2, user.getSum());


                    return  preparedStatement.executeUpdate();
                }*/
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int getSum(String username_1) {
        int sum = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT sum FROM users WHERE login = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, username_1);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        sum = resultSet.getInt("sum");

                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
     return  sum;
    }

    public static void updateSelectedUser(int newSum, String username_1) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE users SET sum = ? WHERE login = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, newSum);
                    preparedStatement.setString(2, username_1);
                    preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
