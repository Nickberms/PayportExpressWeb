<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Employees</title>
        <link rel="stylesheet" type="text/css" href="admin_styles.css">
        <script type="text/javascript" src="admin_scripts.js"></script>
        <%BranchWebServices branch_service = new BranchWebServices();%>
        <%EmployeeWebServices employee_service = new EmployeeWebServices();%>
    </head>
    <body>        
        <%
            String action = request.getParameter("action");
            try {
                if (action.equals("delete")) {
                    String employeeIdParam = request.getParameter("employeeId");
                    int employeeId = Integer.parseInt(employeeIdParam);
                    employee_service.deleteEmployee(employeeId);
                    response.sendRedirect("manage_employees_view.jsp");
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        %>
        <h2>Employees Table</h2>
        <form action="manage_branches_view.jsp">
            <input type="submit" value="Go to Branches Table">
        </form><br>
        <form action="add_employee_form.jsp">
            <input type="submit" value="Add New Employee">
        </form><br>
        <table>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Branch Stationed</th>
                    <th>Working Status</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Birthdate</th>
                    <th>Sex</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Email Address</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    HashMap<Integer, String> branchMap = new HashMap<>();
                    List<String[]> branches = branch_service.selectAllBranches();
                    for (String[] branch : branches) {
                        branchMap.put(Integer.parseInt(branch[0]), branch[2]);
                    }
                    List<String[]> employees = employee_service.selectAllEmployees();
                    for (String[] employee : employees) {
                        String branchName = branchMap.getOrDefault(Integer.parseInt(employee[1]), "No Branch");
                %>
                <tr>
                    <td><%= employee[0]%></td>
                    <td><%= branchName%></td>
                    <td><%= employee[2]%></td>
                    <td><%= employee[3]%></td>
                    <td><%= employee[4]%></td>
                    <td><%= employee[5]%></td>
                    <td><%= employee[6]%></td>
                    <td><%= employee[7]%></td>
                    <td><%= employee[8]%></td>
                    <td><%= employee[9]%></td>
                    <td>
                        <a href="update_employee_form.jsp?employeeId=<%= employee[0]%>">Update</a>
                        <a href="manage_employees_view.jsp?action=delete&employeeId=<%= employee[0]%>">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>   
            </tbody>
        </table><br><br><br>
    </body>
</html>