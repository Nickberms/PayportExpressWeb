package web_services;

import query_operations.*;
import java.text.*;
import java.util.*;
import javax.jws.*;

/**
 * The {@code EmployeeWebServices} class provides SOAP web services for
 * employee-related operations. This class exposes methods for creating,
 * retrieving, updating, and deleting employee information. This class also
 * exposes a method for authenticating employee users.
 *
 * @author Kein Bermejo
 */
@WebService(serviceName = "EmployeeWebServices")
public class EmployeeWebServices {

    /**
     * Web service operation for inserting a new employee into the database.
     * Takes various employee details as parameters and creates a new employee
     * record.
     *
     * @param branchStationed The branch ID where the employee is stationed.
     * @param firstName The first name of the employee.
     * @param lastName The last name of the employee.
     * @param birthdate The birthdate of the employee.
     * @param sex The sex of the employee.
     * @param address The address of the employee.
     * @param phoneNumber The phone number of the employee.
     * @param emailAddress The email address of the employee.
     * @param password The password for the employee.
     */
    @WebMethod(operationName = "insertNewEmployee")
    public void insertNewEmployee(
            @WebParam(name = "branch_stationed") Integer branchStationed,
            @WebParam(name = "first_name") String firstName,
            @WebParam(name = "last_name") String lastName,
            @WebParam(name = "birthdate") Date birthdate,
            @WebParam(name = "sex") String sex,
            @WebParam(name = "address") String address,
            @WebParam(name = "phone_number") String phoneNumber,
            @WebParam(name = "email_address") String emailAddress,
            @WebParam(name = "password") String password) {
        EmployeeQueries insertNewEmployee = new EmployeeQueries();
        insertNewEmployee.setBranchStationed(branchStationed);
        insertNewEmployee.setFirstName(firstName);
        insertNewEmployee.setLastName(lastName);
        insertNewEmployee.setBirthdate(birthdate);
        insertNewEmployee.setSex(sex);
        insertNewEmployee.setAddress(address);
        insertNewEmployee.setPhoneNumber(phoneNumber);
        insertNewEmployee.setEmailAddress(emailAddress);
        insertNewEmployee.setPassword(password);
        insertNewEmployee.insertNewEmployee_Query();
    }

    /**
     * Web service operation for retrieving all employees from the database.
     * Returns an array list of string arrays, each representing an employee's
     * details.
     *
     * @return An ArrayList of String arrays, each array containing employee
     * details.
     */
    @WebMethod(operationName = "selectAllEmployees")
    public ArrayList<String[]> selectAllEmployees() {
        ArrayList<String[]> employeeStr = new ArrayList<>();
        EmployeeQueries selectAllEmployees = new EmployeeQueries();
        List<EmployeeQueries> employees = selectAllEmployees.selectAllEmployees_Query();
        if (employees != null) {
            employees.forEach((employee) -> {
                String[] str = new String[10];
                str[0] = String.valueOf(employee.getEmployeeId());
                str[1] = String.valueOf(employee.getBranchStationed());
                str[2] = employee.getWorkingStatus();
                str[3] = employee.getFirstName();
                str[4] = employee.getLastName();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
                str[5] = dateFormat.format(employee.getBirthdate());
                str[6] = employee.getSex();
                str[7] = employee.getAddress();
                str[8] = employee.getPhoneNumber();
                str[9] = employee.getEmailAddress();
                employeeStr.add(str);
            });
        }
        return employeeStr;
    }

    /**
     * Web service operation for retrieving details of a specific employee based
     * on their employee ID. Returns a string array containing the details of
     * the specified employee if found.
     *
     * @param employeeId The employee ID of the employee to retrieve.
     * @return A String array containing the employee details, or null if not
     * found.
     */
    @WebMethod(operationName = "selectEmployee")
    public String[] selectEmployee(@WebParam(name = "employee_id") int employeeId) {
        EmployeeQueries selectEmployee = new EmployeeQueries();
        EmployeeQueries employee = selectEmployee.selectEmployee_Query(employeeId);
        if (employee != null) {
            String[] str = new String[11];
            str[0] = String.valueOf(employee.getEmployeeId());
            str[1] = String.valueOf(employee.getBranchStationed());
            str[2] = employee.getWorkingStatus();
            str[3] = employee.getFirstName();
            str[4] = employee.getLastName();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date birthdate = employee.getBirthdate();
            str[5] = (birthdate != null) ? dateFormat.format(birthdate) : "";
            str[6] = employee.getSex();
            str[7] = employee.getAddress();
            str[8] = employee.getPhoneNumber();
            str[9] = employee.getEmailAddress();
            str[10] = employee.getPassword();
            return str;
        } else {
            return null;
        }
    }

    /**
     * Web service operation for updating an employee's details in the database
     * based on their employee ID. Takes various parameters to update the
     * employee's record.
     *
     * @param employeeId The employee ID of the employee to update.
     * @param branchStationed The updated branch ID where the employee is
     * stationed.
     * @param workingStatus The updated working status of the employee.
     * @param firstName The updated first name of the employee.
     * @param lastName The updated last name of the employee.
     * @param birthdate The updated birthdate of the employee.
     * @param sex The updated sex of the employee.
     * @param address The updated address of the employee.
     * @param phoneNumber The updated phone number of the employee.
     * @param emailAddress The updated email address of the employee.
     * @param password The updated password for the employee.
     * @return true if the update was successful, false otherwise.
     */
    @WebMethod(operationName = "updateEmployee")
    public boolean updateEmployee(int employeeId,
            @WebParam(name = "branch_stationed") int branchStationed,
            @WebParam(name = "working_status") String workingStatus,
            @WebParam(name = "first_name") String firstName,
            @WebParam(name = "last_name") String lastName,
            @WebParam(name = "birthdate") Date birthdate,
            @WebParam(name = "sex") String sex,
            @WebParam(name = "address") String address,
            @WebParam(name = "phone_number") String phoneNumber,
            @WebParam(name = "email_address") String emailAddress,
            @WebParam(name = "password") String password) {
        EmployeeQueries updateEmployee = new EmployeeQueries();
        updateEmployee.setBranchStationed(branchStationed);
        updateEmployee.setWorkingStatus(workingStatus);
        updateEmployee.setFirstName(firstName);
        updateEmployee.setLastName(lastName);
        updateEmployee.setBirthdate(birthdate);
        updateEmployee.setSex(sex);
        updateEmployee.setAddress(address);
        updateEmployee.setPhoneNumber(phoneNumber);
        updateEmployee.setEmailAddress(emailAddress);
        updateEmployee.setPassword(password);
        return updateEmployee.updateEmployee_Query(employeeId);
    }

    /**
     * Web service operation for deleting an employee from the database based on
     * their employee ID.
     *
     * @param employeeId The employee ID of the employee to delete.
     * @return true if the deletion was successful, false otherwise.
     */
    @WebMethod(operationName = "deleteEmployee")
    public boolean deleteEmployee(int employeeId) {
        EmployeeQueries deleteEmployee = new EmployeeQueries();
        return deleteEmployee.deleteEmployee_Query(employeeId);
    }

    /**
     * Web service operation for authenticating an employee against the
     * database. Uses email address and password for authentication. Returns a
     * string array containing the authenticated employee's details if
     * successful.
     *
     * @param emailAddress The email address of the employee for authentication.
     * @param password The password of the employee for authentication.
     * @return A String array containing the authenticated employee's details,
     * or null if authentication fails.
     */
    @WebMethod(operationName = "employeeLogin")
    public String[] employeeLogin(@WebParam(name = "email_address") String emailAddress,
            @WebParam(name = "password") String password) {
        EmployeeQueries employeeLogin = new EmployeeQueries();
        EmployeeQueries employee = employeeLogin.employeeLogin_Query(emailAddress, password);
        if (employee != null) {
            String[] str = new String[11];
            str[0] = String.valueOf(employee.getEmployeeId());
            str[1] = String.valueOf(employee.getBranchStationed());
            str[2] = employee.getWorkingStatus();
            str[3] = employee.getFirstName();
            str[4] = employee.getLastName();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date birthdate = employee.getBirthdate();
            str[5] = (birthdate != null) ? dateFormat.format(birthdate) : "";
            str[6] = employee.getSex();
            str[7] = employee.getAddress();
            str[8] = employee.getPhoneNumber();
            str[9] = employee.getEmailAddress();
            str[10] = employee.getPassword();
            return str;
        } else {
            return null;
        }
    }
}