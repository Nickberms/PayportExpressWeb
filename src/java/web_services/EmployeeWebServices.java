package web_services;

import query_operations.*;
import java.text.*;
import java.util.*;
import javax.jws.*;

@WebService(serviceName = "EmployeeWebServices")
public class EmployeeWebServices {

    @WebMethod(operationName = "insertNewEmployee")
    public void insertNewEmployee(
            @WebParam(name = "branch_stationed") Integer branch_stationed,
            @WebParam(name = "first_name") String first_name,
            @WebParam(name = "last_name") String last_name,
            @WebParam(name = "birthdate") Date birthdate,
            @WebParam(name = "sex") String sex,
            @WebParam(name = "address") String address,
            @WebParam(name = "phone_number") String phone_number,
            @WebParam(name = "email_address") String email_address,
            @WebParam(name = "password") String password) {
        EmployeeQueries insertNewEmployee = new EmployeeQueries();
        insertNewEmployee.setBranchStationed(branch_stationed);
        insertNewEmployee.setFirstName(first_name);
        insertNewEmployee.setLastName(last_name);
        insertNewEmployee.setBirthdate(birthdate);
        insertNewEmployee.setSex(sex);
        insertNewEmployee.setAddress(address);
        insertNewEmployee.setPhoneNumber(phone_number);
        insertNewEmployee.setEmailAddress(email_address);
        insertNewEmployee.setPassword(password);
        insertNewEmployee.insertNewEmployee_Query();
    }

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

    @WebMethod(operationName = "updateEmployee")
    public boolean updateEmployee(int employeeId,
            @WebParam(name = "branch_stationed") int branch_stationed,
            @WebParam(name = "working_status") String working_status,
            @WebParam(name = "first_name") String first_name,
            @WebParam(name = "last_name") String last_name,
            @WebParam(name = "birthdate") Date birthdate,
            @WebParam(name = "sex") String sex,
            @WebParam(name = "address") String address,
            @WebParam(name = "phone_number") String phone_number,
            @WebParam(name = "email_address") String email_address,
            @WebParam(name = "password") String password) {
        EmployeeQueries updateEmployee = new EmployeeQueries();
        updateEmployee.setBranchStationed(branch_stationed);
        updateEmployee.setWorkingStatus(working_status);
        updateEmployee.setFirstName(first_name);
        updateEmployee.setLastName(last_name);
        updateEmployee.setBirthdate(birthdate);
        updateEmployee.setSex(sex);
        updateEmployee.setAddress(address);
        updateEmployee.setPhoneNumber(phone_number);
        updateEmployee.setEmailAddress(email_address);
        updateEmployee.setPassword(password);
        return updateEmployee.updateEmployee_Query(employeeId);
    }

    @WebMethod(operationName = "deleteEmployee")
    public boolean deleteEmployee(int employeeId) {
        EmployeeQueries deleteEmployee = new EmployeeQueries();
        return deleteEmployee.deleteEmployee_Query(employeeId);
    }
}