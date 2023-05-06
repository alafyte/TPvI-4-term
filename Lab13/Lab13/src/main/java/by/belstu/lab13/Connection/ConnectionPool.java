package by.belstu.lab13.Connection;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final String PROPERTY_PATH = "db";
    private static final int INITIAL_CAPACITY = 10;
    private ArrayBlockingQueue<Connection> freeConnections = new ArrayBlockingQueue<>(INITIAL_CAPACITY);
    private ArrayBlockingQueue<Connection> releaseConnections = new ArrayBlockingQueue<>(INITIAL_CAPACITY);
    private static ReentrantLock lock = new ReentrantLock();
    private volatile static ConnectionPool connectionPool;
    public static ConnectionPool getInstance() {
        try {
            lock.lock();
            if (connectionPool == null) {
                connectionPool = new ConnectionPool();
            }
        } catch (Exception e) {
            LOGGER.error("Can not get Instance", e);
        } finally {
            lock.unlock();
        }
        return connectionPool;
    }
    private ConnectionPool() throws SQLException {
        try {
            lock.lock();
            if (connectionPool != null) {
                throw new UnsupportedOperationException();
            } else {
                init();
            }
        } finally {
            lock.unlock();
        }
    }
    private void init() {
        Properties properties = new Properties();
        ResourceBundle resource = ResourceBundle.getBundle(PROPERTY_PATH);
        if (resource == null) {
            LOGGER.error("Error while reading properties");
        } else {
            String connectionURL = resource.getString("db.url");
            String initialCapacityString = resource.getString("db.poolsize");
            String user = resource.getString("db.username");
            String pass = resource.getString("db.password");
            String driver = resource.getString("db.driver");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Driver class is missing in classpath", e);
            }
            Integer initialCapacity = Integer.valueOf(initialCapacityString);
            for (int i = 0; i < initialCapacity; i++) {
                try {
                    Connection connection = DriverManager.getConnection(connectionURL, user, pass);
                    freeConnections.add(connection);
                } catch (SQLException e) {
                    LOGGER.error("Pool can not initialize", e);
                    throw new RuntimeException("Pool can not initialize", e);
                }
            }
        }
    }
    public Connection getConnection() {
        try {
            Connection connection = freeConnections.take();
            releaseConnections.offer(connection);
            return connection;
        } catch (InterruptedException e) {
            throw new RuntimeException("Can not get database", e);
        }
    }
    public void releaseConnection(Connection connection) {
        releaseConnections.remove(connection);
        freeConnections.offer(connection);
        LOGGER.info("Connection was released, the are free connection " + freeConnections.size());
    }
    public void destroy() {
        for (int i = 0; i < freeConnections.size(); i++) {
            try {
                Connection connection = (Connection) freeConnections.take();
                connection.close();
            } catch (InterruptedException e) {
                LOGGER.error("Connection close exception", e);
            } catch (SQLException e) {
                LOGGER.error("database is not closed", e);
                throw new RuntimeException("database is not closed", e);
            }
        }
        try {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                java.sql.Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            }
        } catch (SQLException e) {
            LOGGER.error("Drivers were not deregistrated", e);
        }
    }
}
