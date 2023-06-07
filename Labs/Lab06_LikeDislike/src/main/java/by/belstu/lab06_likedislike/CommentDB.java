package com.example.task2.db;

import com.example.task2.model.Comment;

import java.sql.*;
import java.util.ArrayList;

public class CommentDB {
    private static String url = "jdbc:mysql://localhost:3306/task2?useSSL=false";
    private static String username = "root";
    private static String password = "root";

    public static ArrayList<Comment> select() {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM comments";

                try(Statement statement = connection.createStatement()){
                    ResultSet resultSet = statement.executeQuery(sql);
                    while (resultSet.next()){
                        int id = resultSet.getInt("id");
                        String text = resultSet.getString("text");
                        int like = resultSet.getInt("like");
                        int dislike = resultSet.getInt("dislike");

                        Comment post = new Comment(id, text, like, dislike);
                        comments.add(post);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return comments;
    }

    public static int update(Comment comment) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE comments SET `like` = ?, dislike = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, comment.getLike());
                    preparedStatement.setInt(2, comment.getDislike());
                    preparedStatement.setInt(3, comment.getId());

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
