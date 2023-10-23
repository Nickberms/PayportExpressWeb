package database_connection;

import java.sql.*;

public class DatabaseConnection {

    // Database driver class name for MySQL
    private static String databaseDriver = "com.mysql.jdbc.Driver";

    // JDBC URL for connecting to the database
    private static String JDBCURL = "jdbc:mysql://localhost:3306/payport_express_db";

    // MySQL database username
    private static String MySQLUsername = "root";

    // MySQL database password
    private static String MySQLPassword = "";

    // Connection object to hold the database connection
    public static Connection connection;

    // Main method to test the connection in the console
    public static void main(String[] args) {
        DatabaseConnection database = new DatabaseConnection();
        database.getConnected();
        database.getConnectedToDatabaseHost();
    }

    // Get the database driver class name
    private static String getDatabaseDriver() {
        return databaseDriver;
    }

    // Set the database driver class name
    public static void setDatabaseDriver(String aDatabaseDriver) {
        databaseDriver = aDatabaseDriver;
    }

    // Get the JDBC URL
    private static String getJDBCURL() {
        return JDBCURL;
    }

    // Set the JDBC URL
    public static void setJDBCURL(String aJDBCURL) {
        JDBCURL = aJDBCURL;
    }

    // Get the MySQL username
    public static String getMySQLUsername() {
        return MySQLUsername;
    }

    // Set the MySQL username
    public static void setMySQLUsername(String aMySQLUsername) {
        MySQLUsername = aMySQLUsername;
    }

    // Get the username for database connection
    private String getUsername() {
        return getMySQLUsername();
    }

    // Set the username for database connection
    private void setUsername(String usernameValue) {
        DatabaseConnection.setMySQLUsername(usernameValue);
    }

    // Get the MySQL password
    public static String getMySQLPassword() {
        return MySQLPassword;
    }

    // Set the MySQL password
    public static void setMySQLPassword(String aMySQLPassword) {
        MySQLPassword = aMySQLPassword;
    }

    // Get the password for database connection
    private String getPassword() {
        return getMySQLPassword();
    }

    // Set the password for database connection
    private void setPassword(String passwordValue) {
        DatabaseConnection.setMySQLPassword(passwordValue);
    }

    // Get the database connection
    public static Connection getConnection() {
        return connection;
    }

    // Set the database connection
    public static void setConnection(Connection connectionValue) {
        connection = connectionValue;
    }

    // Method to establish a database connection
    public Connection getConnected() {
        try {
            if (getConnection() == null || getConnection().isClosed()) {
                try {
                    // Load the database driver class
                    Class.forName(getDatabaseDriver());
                    // Create a connection to the database
                    setConnection(DriverManager.getConnection(getJDBCURL(), getUsername(), getPassword()));
                    System.out.println("Connected successfully to the database");
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

    // Method to get connected to the database host
    public void getConnectedToDatabaseHost() {
        try {
            if (getConnection() == null || getConnection().isClosed()) {
                try {
                    // Load the database driver class using newInstance method
                    Class.forName(getDatabaseDriver()).newInstance();
                    // Create a connection to the database
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