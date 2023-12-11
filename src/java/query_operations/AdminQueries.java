package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

/**
 * The {@code AdminQueries} class handles a query operation for admin-related
 * data. This class extends the {@code DatabaseConnection} class to utilize
 * database connection capabilities. It encapsulates information about admins
 * and provides methods to interact with the database.
 *
 * @author Kein Bermejo
 */
public class AdminQueries extends DatabaseConnection {

    private Integer admin_id;
    private String first_name;
    private String last_name;
    private java.util.Date birthdate;
    private String sex;
    private String address;
    private String phone_number;
    private String email_address;
    private String password;
    private Timestamp date_created;
    private Timestamp date_modified;
    private Collection<AdminQueries> connectionData;

    /**
     * Default constructor for creating an instance of AdminQueries.
     */
    public AdminQueries() {
    }

    /**
     * Constructs an instance of AdminQueries with initial values for admin
     * details.
     *
     * @param admin_id Unique identifier for the admin.
     * @param first_name Admin's first name.
     * @param last_name Admin's last name.
     * @param birthdate Admin's birth date.
     * @param sex Admin's sex.
     * @param address Admin's address.
     * @param phone_number Admin's phone number.
     * @param email_address Admin's email address.
     * @param password Admin's password.
     * @param date_created Timestamp when the admin was created.
     * @param date_modified Timestamp when the admin was last modified.
     */
    public AdminQueries(
            Integer admin_id,
            String first_name,
            String last_name,
            java.util.Date birthdate,
            String sex,
            String address,
            String phone_number,
            String email_address,
            String password,
            Timestamp date_created,
            Timestamp date_modified) {
        this.admin_id = admin_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.address = address;
        this.phone_number = phone_number;
        this.email_address = email_address;
        this.password = password;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    /**
     * Gets the admin's unique identifier.
     *
     * @return The admin's ID.
     */
    public Integer getAdminId() {
        return admin_id;
    }

    /**
     * Sets the admin's unique identifier.
     *
     * @param admin_id The new ID to set for the admin.
     */
    public void setAdminId(Integer admin_id) {
        this.admin_id = admin_id;
    }

    /**
     * Gets the admin's first name.
     *
     * @return The first name of the admin.
     */
    public String getFirstName() {
        return first_name;
    }

    /**
     * Sets the admin's first name.
     *
     * @param first_name The new first name to set for the admin.
     */
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Gets the admin's last name.
     *
     * @return The last name of the admin.
     */
    public String getLastName() {
        return last_name;
    }

    /**
     * Sets the admin's last name.
     *
     * @param last_name The new last name to set for the admin.
     */
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Gets the admin's birth date.
     *
     * @return The birth date of the admin.
     */
    public java.util.Date getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the admin's birth date.
     *
     * @param birthdate The new birth date to set for the admin.
     */
    public void setBirthdate(java.util.Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Gets the admin's sex.
     *
     * @return The sex of the admin.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the admin's sex.
     *
     * @param sex The new sex to set for the admin.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets the admin's address.
     *
     * @return The address of the admin.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the admin's address.
     *
     * @param address The new address to set for the admin.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the admin's phone number.
     *
     * @return The phone number of the admin.
     */
    public String getPhoneNumber() {
        return phone_number;
    }

    /**
     * Sets the admin's phone number.
     *
     * @param phone_number The new phone number to set for the admin.
     */
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * Gets the admin's email address.
     *
     * @return The email address of the admin.
     */
    public String getEmailAddress() {
        return email_address;
    }

    /**
     * Sets the admin's email address.
     *
     * @param email_address The new email address to set for the admin.
     */
    public void setEmailAddress(String email_address) {
        this.email_address = email_address;
    }

    /**
     * Gets the admin's password.
     *
     * @return The password of the admin.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the admin's password.
     *
     * @param password The new password to set for the admin.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the timestamp when the admin was created.
     *
     * @return The creation timestamp of the admin.
     */
    public Timestamp getDateCreated() {
        return date_created;
    }

    /**
     * Sets the timestamp when the admin was created.
     *
     * @param date_created The new creation timestamp to set for the admin.
     */
    public void setDateCreated(Timestamp date_created) {
        this.date_created = date_created;
    }

    /**
     * Gets the timestamp when the admin was last modified.
     *
     * @return The last modified timestamp of the admin.
     */
    public Timestamp getDateModified() {
        return date_modified;
    }

    /**
     * Sets the timestamp when the admin was last modified.
     *
     * @param date_modified The new modified timestamp to set for the admin.
     */
    public void setDateModified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    /**
     * Gets the collection of admin queries representing the connection data.
     *
     * @return The collection of connection data.
     */
    public Collection<AdminQueries> getConnectionData() {
        return connectionData;
    }

    /**
     * Sets the collection of admin queries representing the connection data.
     *
     * @param connectionData The new collection of connection data to set.
     */
    public void setConnectionData(Collection<AdminQueries> connectionData) {
        this.connectionData = connectionData;
    }

    /**
     * Authenticates an admin user against the database using the provided email
     * address and password.
     *
     * @param emailAddress The email address of the admin to authenticate.
     * @param password The password of the admin to authenticate.
     * @return An {@code AdminQueries} object containing the authenticated
     * admin's data if authentication is successful; otherwise, {@code null}.
     */
    public AdminQueries adminLogin_Query(String emailAddress, String password) {
        AdminQueries admin = null;
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM `admins` WHERE `email_address` = ? AND `password` = ?;")) {
                statement.setString(1, emailAddress);
                statement.setString(2, password);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        admin = new AdminQueries();
                        admin.setAdminId(result.getInt("admin_id"));
                        admin.setFirstName(result.getString("first_name"));
                        admin.setLastName(result.getString("last_name"));
                        admin.setBirthdate(result.getDate("birthdate"));
                        admin.setSex(result.getString("sex"));
                        admin.setAddress(result.getString("address"));
                        admin.setPhoneNumber(result.getString("phone_number"));
                        admin.setEmailAddress(result.getString("email_address"));
                        admin.setPassword(result.getString("password"));
                    }
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return admin;
    }
}