package database_connection;

import java.sql.*;

public class DatabaseConnection {

    private static String databaseDriver = "com.mysql.jdbc.Driver";

    private static String JDBCURL = "jdbc:mysql://136.172.221.179:3306/payport_express_db?characterEncoding=utf8";

    private static String MySQLUsername = "Web Server";

    private static String MySQLPassword = "123456789";

    public static Connection connection;

    public static void main(String[] args) {
        DatabaseConnection database = new DatabaseConnection();
        database.getConnected();
        database.getConnectedToDatabaseHost();
    }

    private static String getDatabaseDriver() {
        return databaseDriver;
    }

    public static void setDatabaseDriver(String aDatabaseDriver) {
        databaseDriver = aDatabaseDriver;
    }

    private static String getJDBCURL() {
        return JDBCURL;
    }

    public static void setJDBCURL(String aJDBCURL) {
        JDBCURL = aJDBCURL;
    }

    public static String getMySQLUsername() {
        return MySQLUsername;
    }

    public static void setMySQLUsername(String aMySQLUsername) {
        MySQLUsername = aMySQLUsername;
    }

    private String getUsername() {
        return getMySQLUsername();
    }

    public static String getMySQLPassword() {
        return MySQLPassword;
    }

    public static void setMySQLPassword(String aMySQLPassword) {
        MySQLPassword = aMySQLPassword;
    }

    private String getPassword() {
        return getMySQLPassword();
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connectionValue) {
        connection = connectionValue;
    }

    public Connection getConnected() {
        try {
            if (getConnection() == null || getConnection().isClosed()) {
                try {
                    Class.forName(getDatabaseDriver());
                    setConnection(DriverManager.getConnection(getJDBCURL(), getUsername(), getPassword()));
                    System.out.println("Connected successfully to the database");
                    System.out.println();
                } catch (ClassNotFoundException | SQLException error) {
                    System.err.println(error);
                }
            } else {
                System.err.println("Failed to connect to the database");
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return getConnection();
    }

    public void getConnectedToDatabaseHost() {
        try {
            if (getConnection() == null || getConnection().isClosed()) {
                try {
                    Class.forName(getDatabaseDriver()).newInstance();
                    setConnection(DriverManager.getConnection(getJDBCURL(), getUsername(), getPassword()));
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException error) {
                    System.err.println(error);
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
    }
}