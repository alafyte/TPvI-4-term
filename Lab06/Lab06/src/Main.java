import by.belstu.Lab06.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DAO db = new DAO();
            db.getConnection();

            System.out.println("Запрос №1");
            /* Вывести информацию обо всех планетах, на которых присутствует жизнь, и их спутниках.*/
            ResultSet rs = db.ExecuteQuery("""
                    SELECT * FROM PLANETS\s
                    INNER JOIN SATELLITES\s
                    ON PLANETS.Name = SATELLITES.Planet_Name
                    WHERE PLANETS.Have_Life = 1""");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t|\t");
                System.out.print(rs.getString(2) + "\t|\t");
                System.out.print(rs.getString(3) + "\t|\t");
                System.out.print(rs.getString(4) + "\t|\t");
                System.out.print(rs.getString(5) + "\t|\t");
                System.out.print(rs.getString(6) + "\t|\t");
                System.out.print(rs.getString(7) + "\t|\t");
                System.out.print(rs.getString(8) + "\t|\t");
                System.out.print(rs.getString(9));
                System.out.println();
            }
            System.out.println("\nЗапрос №2");
            /*Вывести информацию о планетах и их спутниках, имеющих наименьший радиус и
            наибольшее количество спутников. */
            rs = db.ExecuteQuery("""
                    SELECT PLANETS.Name, PLANETS.Radius, COUNT(PLANETS.Name) as Satellites_Number
                    FROM PLANETS INNER JOIN SATELLITES\s
                    ON PLANETS.Name = SATELLITES.Planet_Name
                    GROUP BY PLANETS.Name, PLANETS.Radius
                    ORDER BY PLANETS.Radius ASC, Satellites_Number DESC""");
            while(rs.next()) {
                System.out.print(rs.getString(1) + "\t|\t");
                System.out.print(rs.getString(2) + "\t|\t");
                System.out.print(rs.getString(3));
                System.out.println();
            }
            System.out.println("\nЗапрос №3");
            /* Найти планету, сумма радиусов спутников которой наибольшая*/
            rs = db.ExecuteQuery("""
                    SELECT TOP(1) PLANETS.Name, PLANETS.Radius, SUM(SATELLITES.Radius) as Sum_Of_Radiuses
                    FROM PLANETS INNER JOIN SATELLITES\s
                    ON PLANETS.Name = SATELLITES.Planet_Name
                    GROUP BY PLANETS.Name, PLANETS.Radius
                    ORDER BY Sum_Of_Radiuses DESC""");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t|\t");
                System.out.print(rs.getString(2) + "\t| ");
                System.out.print(rs.getString(3));
                System.out.println();
            }

            System.out.println("\nPrepared statement");
            rs = db.ExecutePrepareStatement(2);
            while(rs.next()) {
                System.out.print(rs.getString(1) + "\t|\t");
                System.out.print(rs.getString(2) + "\t| ");
                System.out.print(rs.getString(3));
                System.out.println();
            }
            System.out.println("\nТранзакция");
            db.ExecuteTransaction();
            db.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}