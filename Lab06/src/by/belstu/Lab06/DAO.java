package by.belstu.Lab06;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DAO implements IConnection, IQuery {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private String url;
    private String user;
    private String password;
    private Connection con;
    private Statement statement;
    private static final Logger logger = Logger.getLogger(Main.class);

    public void logInfo() {
        logger.info("Started main");
    }

    public DAO() {
        logInfo();
        getProperties();
    }

    public ArrayList<String> getProperties() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        url = resourceBundle.getString("db.url");
        user = resourceBundle.getString("db.username");
        password = resourceBundle.getString("db.password");

        ArrayList<String> ret = new ArrayList<>();
        ret.add(url);
        ret.add(user);
        ret.add(password);
        return ret;
    }
    public Boolean getConnection() {
        try {
            logger.debug("Соединение...");
            getProperties();
            con = DriverManager.getConnection(url, user, password);
            statement = con.createStatement();
            logger.info("Соединено!");
            return true;
        }
        catch(Exception ex) {
            logger.error("Ошибка при установке соединения!");
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
            logger.error("Ошибка при выполнении запроса");
            return null;
        }
    }
    public ResultSet ExecutePrepareStatement(int numberOfSatellites) {
        try {
            String sqlQuery = """
                    SELECT PLANETS.Name, PLANETS.Radius, COUNT(PLANETS.Name) as Satellites_Number
                    FROM PLANETS INNER JOIN SATELLITES\s
                    ON PLANETS.Name = SATELLITES.Planet_Name
                    GROUP BY PLANETS.Name, PLANETS.Radius HAVING COUNT(*) > ?;""";
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, numberOfSatellites);
            return preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.error("Ошибка при выполнении запроса");
            return null;
        }
    }

    public void ExecuteTransaction() {
        try {
            try {
                con.setAutoCommit(false);
                {
                statement.executeUpdate("UPDATE Planets SET Have_Life = 1 WHERE Name = 'Земля'");
                statement.executeUpdate("UPDATE Planets SET Have_Life = 0 WHERE Name = 'Марс'");
                }
                ResultSet rs = statement.executeQuery("SELECT Name, Have_Life FROM Planets");
                System.out.println("До обновления");
                while(rs.next()) {
                    System.out.print(rs.getString(1 ) + "\t");
                    System.out.print(rs.getString(2));
                    System.out.println();
                }
                System.out.println("После обновления");
                statement.executeUpdate("UPDATE Planets SET Have_Life = 1 WHERE Name = 'Марс'");
                statement.executeUpdate("UPDATE Planets SET Have_Life = 0 WHERE Name = 'Земля'");
                con.commit();
                rs = statement.executeQuery("SELECT Name, Have_Life FROM Planets");
                while(rs.next()) {
                    System.out.print(rs.getString(1 ) + "\t");
                    System.out.print(rs.getString(2));
                    System.out.println();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                logger.error("Ошибка в транзакции!");
                con.rollback();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            logger.error("Ошибка в транзакции!");
        }
    }
    public void closeConnection()
    {
        try {
            con.close();
            logger.info("Соединение закрыто!");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ошибка при закрытии соединения");
        }
    }

}
