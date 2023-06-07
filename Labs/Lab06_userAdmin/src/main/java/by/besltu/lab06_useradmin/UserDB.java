package com.example.task8_JDBC_UserAdmin.db;

import com.example.task8_JDBC_UserAdmin.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    private static String url = "jdbc:mysql://localhost:3306/task8?useSSL=false";
    private static String username = "root";
    private static String password = "root";

    public static ArrayList<User> select(String role_param) {
        ArrayList<User> users = new ArrayList<User>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM users WHERE role=?";

                try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setString(1, role_param);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        int id = resultSet.getInt("id");
                        String password = resultSet.getString("password");
                        User.Role role = User.Role.valueOf(resultSet.getString("role"));

                        User user = new User(id, password, role);
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
}
