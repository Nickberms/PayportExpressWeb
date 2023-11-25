package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

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

    public AdminQueries() {
    }

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

    public Integer getAdminId() {
        return admin_id;
    }

    public void setAdminId(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public java.util.Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(java.util.Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmailAddress() {
        return email_address;
    }

    public void setEmailAddress(String email_address) {
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDateCreated() {
        return date_created;
    }

    public void setDateCreated(Timestamp date_created) {
        this.date_created = date_created;
    }

    public Timestamp getDateModified() {
        return date_modified;
    }

    public void setDateModified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    public Collection<AdminQueries> getConnectionData() {
        return connectionData;
    }

    public void setConnectionData(Collection<AdminQueries> connectionData) {
        this.connectionData = connectionData;
    }

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