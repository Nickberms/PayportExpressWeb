package database_connection;

import java.sql.*;

/**
 * This class handles the database connection to a MySQL database. It provides
 * methods to establish a connection and access the database credentials. Note:
 * This class contains static members for simplicity, which may not be suitable
 * for production code.
 *
 * @author Kein Bermejo
 */
public class DatabaseConnection {

    private static String databaseDriver = "com.mysql.jdbc.Driver";
    private static String JDBCURL = "jdbc:mysql://136.172.221.179:3306/payport_express_db?characterEncoding=utf8";
    private static String MySQLUsername = "Web Server";
    private static String MySQLPassword = "123456789";
    public static Connection connection;

    /**
     * The main method for testing the connection to the database.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        DatabaseConnection database = new DatabaseConnection();
        database.getConnected();
        database.getConnectedToDatabaseHost();
    }

    /**
     * Retrieves the database driver string.
     *
     * @return A {@code String} representing the database driver.
     */
    private static String getDatabaseDriver() {
        return databaseDriver;
    }

    /**
     * Sets the database driver string.
     *
     * @param aDatabaseDriver The new database driver string to set.
     */
    public static void setDatabaseDriver(String aDatabaseDriver) {
        databaseDriver = aDatabaseDriver;
    }

    /**
     * Retrieves the JDBC URL for database connection.
     *
     * @return A {@code String} representing the JDBC URL.
     */
    private static String getJDBCURL() {
        return JDBCURL;
    }

    /**
     * Sets the JDBC URL for database connection.
     *
     * @param aJDBCURL The new JDBC URL to set.
     */
    public static void setJDBCURL(String aJDBCURL) {
        JDBCURL = aJDBCURL;
    }

    /**
     * Retrieves the MySQL username.
     *
     * @return A {@code String} representing the MySQL username.
     */
    public static String getMySQLUsername() {
        return MySQLUsername;
    }

    /**
     * Sets the MySQL username.
     *
     * @param aMySQLUsername The new MySQL username to set.
     */
    public static void setMySQLUsername(String aMySQLUsername) {
        MySQLUsername = aMySQLUsername;
    }

    /**
     * Retrieves the MySQL password.
     *
     * @return A {@code String} representing the MySQL password.
     */
    public static String getMySQLPassword() {
        return MySQLPassword;
    }

    /**
     * Sets the MySQL password.
     *
     * @param aMySQLPassword The new MySQL password to set.
     */
    public static void setMySQLPassword(String aMySQLPassword) {
        MySQLPassword = aMySQLPassword;
    }

    /**
     * Retrieves the current database connection object.
     *
     * @return The current {@code Connection} object or {@code null} if not
     * connected.
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * Sets the database connection object.
     *
     * @param connectionValue The new {@code Connection} object to set.
     */
    public static void setConnection(Connection connectionValue) {
        connection = connectionValue;
    }

    /**
     * Establishes a connection to the database. If a connection already exists
     * and is open, it returns the existing connection. If no connection exists,
     * it attempts to establish a new connection.
     *
     * @return The established {@code Connection} object, or {@code null} if the
     * connection could not be established.
     */
    public Connection getConnected() {
        try {
            if (getConnection() == null || getConnection().isClosed()) {
                try {
                    Class.forName(getDatabaseDriver());
                    setConnection(DriverManager.getConnection(getJDBCURL(), getMySQLUsername(), getMySQLPassword()));
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

    /**
     * Establishes a connection to the database host with the given credentials.
     * This method attempts to create a new instance of the database driver and
     * establish a new connection. It should be used when an explicit new
     * connection is required.
     */
    public void getConnectedToDatabaseHost() {
        try {
            if (getConnection() == null || getConnection().isClosed()) {
                try {
                    Class.forName(getDatabaseDriver()).newInstance();
                    setConnection(DriverManager.getConnection(getJDBCURL(), getMySQLUsername(), getMySQLPassword()));
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException error) {
                    System.err.println(error);
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
    }
}