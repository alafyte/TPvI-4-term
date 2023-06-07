package com.example.task1.db;

import com.example.task1.model.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDB {
    private static String url = "jdbc:mysql://localhost:3306/task1?useSSL=false";
    private static String username = "root";
    private static String password = "root";

    public static ArrayList<Book> select(int page) {
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            int counter = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM books";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        if ( counter == page*2 || counter==page*2+1) {
                            String author = resultSet.getString("author");
                            String book_name = resultSet.getString("book_name");
                            int publication_year = resultSet.getInt("publication_year");
                            int pages = resultSet.getInt("pages");

                            Book book = new Book(author, book_name, publication_year, pages);
                            books.add(book);
                        }
                        counter++;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

       return books;
    }

    public static int getDbSize() {
        int dbSize = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT COUNT(*) FROM books";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        dbSize = resultSet.getInt(1);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return dbSize;
    }
}
