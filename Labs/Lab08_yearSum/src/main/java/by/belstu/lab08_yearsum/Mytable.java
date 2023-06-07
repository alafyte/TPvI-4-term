package db;

import model.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Mytable {
    private static String url = "jdbc:mysql://localhost:3306/mybase?useSSL=false";
    private static String username = "root";
    private static String password = "root";

    static Integer commonSum = 0;
    public static ArrayList<Table> select(int year,int sum) {
        ArrayList<Table> tables = new ArrayList<Table>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM mytable WHERE year = ? AND sum >= ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, year);
                    preparedStatement.setInt(2, sum);

                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int year1 = resultSet.getInt("year");
                        int sum1 = resultSet.getInt("sum");

                        Table tb = new Table(year1, sum1);
                        tables.add(tb);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return tables;
    }



}
