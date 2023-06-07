package com.example.task3.db;

import com.example.task3.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    private static String url = "jdbc:mysql://localhost:3306/task3?useSSL=false";
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
                        int id = resultSet.getInt("id");
                        String login = resultSet.getString("login");
                        int sum = resultSet.getInt("sum");

                        User user = new User(id, login, sum);
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
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE users SET login = ?, sum = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setInt(2, user.getSum());
                    preparedStatement.setInt(3, user.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
