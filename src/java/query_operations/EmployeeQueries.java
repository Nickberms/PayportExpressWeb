package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

public class EmployeeQueries extends DatabaseConnection {

    private Integer employee_id;
    private Integer branch_stationed;
    private String working_status;
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
    private Collection<EmployeeQueries> connectionData;

    public EmployeeQueries() {
    }

    public EmployeeQueries(
            Integer employee_id,
            Integer branch_stationed,
            String working_status,
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
        this.employee_id = employee_id;
        this.branch_stationed = branch_stationed;
        this.working_status = working_status;
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

    public Integer getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getBranchStationed() {
        return branch_stationed;
    }

    public void setBranchStationed(Integer branch_stationed) {
        this.branch_stationed = branch_stationed;
    }

    public String getWorkingStatus() {
        return working_status;
    }

    public void setWorkingStatus(String working_status) {
        this.working_status = working_status;
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

    public Collection<EmployeeQueries> getConnectionData() {
        return connectionData;
    }

    public void setConnectionData(Collection<EmployeeQueries> connectionData) {
        this.connectionData = connectionData;
    }

    public void insertNewEmployee_Query() {
        String activeStatus = "Active";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO `employees` "
                    + "(`branch_stationed`, "
                    + "`working_status`, "
                    + "`first_name`, "
                    + "`last_name`, "
                    + "`birthdate`, "
                    + "`sex`, "
                    + "`address`, "
                    + "`phone_number`, "
                    + "`email_address`, "
                    + "`password`, "
                    + "`date_created`, "
                    + "`date_modified`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW());")) {
                statement.setInt(1, branch_stationed);
                statement.setString(2, activeStatus);
                statement.setString(3, first_name);
                statement.setString(4, last_name);
                statement.setDate(5, new java.sql.Date(birthdate.getTime()));
                statement.setString(6, sex);
                statement.setString(7, address);
                statement.setString(8, phone_number);
                statement.setString(9, email_address);
                statement.setString(10, password);
                statement.execute();
                statement.close();
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
    }

    public List<EmployeeQueries> selectAllEmployees_Query() {
        List<EmployeeQueries> employees = new ArrayList<>();
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `employee_id`, "
                    + "`branch_stationed`, "
                    + "`working_status`, "
                    + "`first_name`, "
                    + "`last_name`, "
                    + "`birthdate`, "
                    + "`sex`, "
                    + "`address`, "
                    + "`phone_number`, "
                    + "`email_address` "
                    + "FROM `employees`;"); ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    EmployeeQueries employee = new EmployeeQueries();
                    employee.setEmployeeId(result.getInt("employee_id"));
                    employee.setBranchStationed(result.getInt("branch_stationed"));
                    employee.setWorkingStatus(result.getString("working_status"));
                    employee.setFirstName(result.getString("first_name"));
                    employee.setLastName(result.getString("last_name"));
                    employee.setBirthdate(result.getDate("birthdate"));
                    employee.setSex(result.getString("sex"));
                    employee.setAddress(result.getString("address"));
                    employee.setPhoneNumber(result.getString("phone_number"));
                    employee.setEmailAddress(result.getString("email_address"));
                    employees.add(employee);
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return employees;
    }

    public EmployeeQueries selectEmployee_Query(int employeeId) {
        EmployeeQueries employee = null;
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `employee_id`, "
                    + "`branch_stationed`, "
                    + "`working_status`, "
                    + "`first_name`, "
                    + "`last_name`, "
                    + "`birthdate`, "
                    + "`sex`, "
                    + "`address`, "
                    + "`phone_number`, "
                    + "`email_address`, "
                    + "`password` "
                    + "FROM `employees` WHERE `employee_id` = ?;")) {
                statement.setInt(1, employeeId);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        employee = new EmployeeQueries();
                        employee.setEmployeeId(result.getInt("employee_id"));
                        employee.setBranchStationed(result.getInt("branch_stationed"));
                        employee.setWorkingStatus(result.getString("working_status"));
                        employee.setFirstName(result.getString("first_name"));
                        employee.setLastName(result.getString("last_name"));
                        employee.setBirthdate(result.getDate("birthdate"));
                        employee.setSex(result.getString("sex"));
                        employee.setAddress(result.getString("address"));
                        employee.setPhoneNumber(result.getString("phone_number"));
                        employee.setEmailAddress(result.getString("email_address"));
                        employee.setPassword(result.getString("password"));
                    }
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return employee;
    }

    public boolean updateEmployee_Query(int employeeId) {
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `employees` SET "
                    + "`branch_stationed` = ?, "
                    + "`working_status` = ?, "
                    + "`first_name` = ?, "
                    + "`last_name` = ?, "
                    + "`birthdate` = ?, "
                    + "`sex` = ?, "
                    + "`address` = ?, "
                    + "`phone_number` = ?, "
                    + "`email_address` = ?, "
                    + "`password` = ?, "
                    + "`date_modified` = NOW() "
                    + "WHERE `employee_id` = ?;")) {
                statement.setInt(1, branch_stationed);
                statement.setString(2, working_status);
                statement.setString(3, first_name);
                statement.setString(4, last_name);
                statement.setDate(5, new java.sql.Date(birthdate.getTime()));
                statement.setString(6, sex);
                statement.setString(7, address);
                statement.setString(8, phone_number);
                statement.setString(9, email_address);
                statement.setString(10, password);
                statement.setInt(11, employeeId);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

    public boolean deleteEmployee_Query(int employeeId) {
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM `employees` WHERE `employee_id` = ?;")) {
                statement.setInt(1, employeeId);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

    public EmployeeQueries employeeLogin_Query(String emailAddress, String password) {
        EmployeeQueries employee = null;
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM `employees` WHERE `email_address` = ? AND `password` = ?;")) {
                statement.setString(1, emailAddress);
                statement.setString(2, password);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        employee = new EmployeeQueries();
                        employee.setEmployeeId(result.getInt("employee_id"));
                        employee.setBranchStationed(result.getInt("branch_stationed"));
                        employee.setWorkingStatus(result.getString("working_status"));
                        employee.setFirstName(result.getString("first_name"));
                        employee.setLastName(result.getString("last_name"));
                        employee.setBirthdate(result.getDate("birthdate"));
                        employee.setSex(result.getString("sex"));
                        employee.setAddress(result.getString("address"));
                        employee.setPhoneNumber(result.getString("phone_number"));
                        employee.setEmailAddress(result.getString("email_address"));
                        employee.setPassword(result.getString("password"));
                    }
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return employee;
    }
}