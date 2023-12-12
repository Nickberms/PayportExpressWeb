package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

/**
 * The {@code EmployeeQueries} class handles query operations for
 * employee-related data. This class extends the {@code DatabaseConnection}
 * class to utilize database connection capabilities. It encapsulates
 * information about employees and provides methods to interact with the
 * database.
 *
 * @author Kein Bermejo
 */
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

    /**
     * Default constructor for creating an instance of EmployeeQueries.
     */
    public EmployeeQueries() {
    }

    /**
     * Constructs an instance of EmployeeQueries with initial values for
     * employee details.
     *
     * @param employee_id Unique identifier for the employee record.
     * @param branch_stationed Branch ID where the employee is stationed.
     * @param working_status Working status of the employee.
     * @param first_name First name of the employee.
     * @param last_name Last name of the employee.
     * @param birthdate Birth date of the employee.
     * @param sex Sex of the employee.
     * @param address Address of the employee.
     * @param phone_number Phone number of the employee.
     * @param email_address Email address of the employee.
     * @param password Password for the employee.
     * @param date_created Timestamp when the employee record was created.
     * @param date_modified Timestamp when the employee record was last
     * modified.
     */
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

    /**
     * Gets the employee ID of the employee.
     *
     * @return The employee ID of the employee.
     */
    public Integer getEmployeeId() {
        return employee_id;
    }

    /**
     * Sets the employee ID of the employee.
     *
     * @param employee_id The employee ID to set for the employee.
     */
    public void setEmployeeId(Integer employee_id) {
        this.employee_id = employee_id;
    }

    /**
     * Gets the branch ID where the employee is stationed.
     *
     * @return The branch ID where the employee is stationed.
     */
    public Integer getBranchStationed() {
        return branch_stationed;
    }

    /**
     * Sets the branch ID where the employee is stationed.
     *
     * @param branch_stationed The branch ID to set for where the employee is
     * stationed.
     */
    public void setBranchStationed(Integer branch_stationed) {
        this.branch_stationed = branch_stationed;
    }

    /**
     * Gets the working status of the employee.
     *
     * @return The working status of the employee.
     */
    public String getWorkingStatus() {
        return working_status;
    }

    /**
     * Sets the working status of the employee.
     *
     * @param working_status The working status to set for the employee.
     */
    public void setWorkingStatus(String working_status) {
        this.working_status = working_status;
    }

    /**
     * Gets the first name of the employee.
     *
     * @return The first name of the employee.
     */
    public String getFirstName() {
        return first_name;
    }

    /**
     * Sets the first name of the employee.
     *
     * @param first_name The first name to set for the employee.
     */
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Gets the last name of the employee.
     *
     * @return The last name of the employee.
     */
    public String getLastName() {
        return last_name;
    }

    /**
     * Sets the last name of the employee.
     *
     * @param last_name The last name to set for the employee.
     */
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Gets the birthdate of the employee.
     *
     * @return The birthdate of the employee.
     */
    public java.util.Date getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate of the employee.
     *
     * @param birthdate The birthdate to set for the employee.
     */
    public void setBirthdate(java.util.Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Gets the sex of the employee.
     *
     * @return The sex of the employee.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the sex of the employee.
     *
     * @param sex The sex to set for the employee.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets the address of the employee.
     *
     * @return The address of the employee.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the employee.
     *
     * @param address The address to set for the employee.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number of the employee.
     *
     * @return The phone number of the employee.
     */
    public String getPhoneNumber() {
        return phone_number;
    }

    /**
     * Sets the phone number of the employee.
     *
     * @param phone_number The phone number to set for the employee.
     */
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * Gets the email address of the employee.
     *
     * @return The email address of the employee.
     */
    public String getEmailAddress() {
        return email_address;
    }

    /**
     * Sets the email address of the employee.
     *
     * @param email_address The email address to set for the employee.
     */
    public void setEmailAddress(String email_address) {
        this.email_address = email_address;
    }

    /**
     * Gets the password of the employee.
     *
     * @return The password of the employee.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the employee.
     *
     * @param password The password to set for the employee.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the timestamp when the employee record was created.
     *
     * @return The timestamp when the employee record was created.
     */
    public Timestamp getDateCreated() {
        return date_created;
    }

    /**
     * Sets the timestamp when the employee record was created.
     *
     * @param date_created The timestamp to set for when the employee record was
     * created.
     */
    public void setDateCreated(Timestamp date_created) {
        this.date_created = date_created;
    }

    /**
     * Gets the timestamp when the employee record was last modified.
     *
     * @return The timestamp when the employee record was last modified.
     */
    public Timestamp getDateModified() {
        return date_modified;
    }

    /**
     * Sets the timestamp when the employee record was last modified.
     *
     * @param date_modified The timestamp to set for when the employee record
     * was last modified.
     */
    public void setDateModified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    /**
     * Gets the collection of employee queries representing the connection data.
     *
     * @return The collection of connection data.
     */
    public Collection<EmployeeQueries> getConnectionData() {
        return connectionData;
    }

    /**
     * Sets the collection of employee queries representing the connection data.
     *
     * @param connectionData The new collection of connection data to set.
     */
    public void setConnectionData(Collection<EmployeeQueries> connectionData) {
        this.connectionData = connectionData;
    }

    /**
     * Inserts a new employee into the database using the current instance's
     * data. The working status is set to "Active" by default. This method also
     * sets the creation and modification timestamps to the current time.
     */
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

    /**
     * Retrieves a list of all employees from the database. Each employee is
     * represented as an {@code EmployeeQueries} object containing their
     * details.
     *
     * @return A list of {@code EmployeeQueries} objects, each representing an
     * employee.
     */
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

    /**
     * Retrieves a specific employee from the database based on the given
     * employee ID. The method returns an {@code EmployeeQueries} object
     * representing the employee if found.
     *
     * @param employeeId The employee ID of the employee to retrieve.
     * @return An {@code EmployeeQueries} object representing the requested
     * employee, or {@code null} if not found.
     */
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

    /**
     * Updates an existing employee details in the database based on the given
     * employee ID. This method updates most of the employee details. It also
     * sets the modification timestamp to the current time.
     *
     * @param employeeId The employee ID of the employee to update.
     * @return {@code true} if the update was successful, {@code false}
     * otherwise.
     */
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

    /**
     * Deletes an employee from the database based on the given employee ID.
     * This method removes the employee record with the specified employee ID
     * from the database.
     *
     * @param employeeId The employee ID of the employee to delete.
     * @return {@code true} if the deletion was successful, {@code false}
     * otherwise.
     */
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

    /**
     * Authenticates an employee against the database using the provided email
     * address and password. If authentication is successful, it returns an
     * {@code EmployeeQueries} object containing the employee's data.
     *
     * @param emailAddress The email address of the employee to authenticate.
     * @param password The password of the employee to authenticate.
     * @return An {@code EmployeeQueries} object containing the authenticated
     * employee's data, or {@code null} if authentication fails.
     */
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