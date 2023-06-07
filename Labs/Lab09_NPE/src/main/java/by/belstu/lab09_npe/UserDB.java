package db;


import model.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class UserDB {
   private static String url = "jdbc:mysql://localhost:3306/task22?useSSL=false";
    private static String username = "root";
    private static String password = "root";
    public static ArrayList<User> select() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM users";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String phone = resultSet.getString("phone");


                        User us = new User(name, email, phone);
                        users.add(us);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return users;
    }

    public static void addUser(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO users (name, email, phone) VALUES (?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getEmail());
                    preparedStatement.setString(3, user.getPhone());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }




}


