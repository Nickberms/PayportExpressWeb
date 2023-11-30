<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Employee Login</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <script type="text/javascript" src="scripts.js"></script>
        <%BranchWebServices branch_service = new BranchWebServices();%>
        <%EmployeeWebServices employee_service = new EmployeeWebServices();%>
    </head>
    <body>
        <%
            HttpServletResponse httpResponse = response;
            httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            httpResponse.setHeader("Pragma", "no-cache");
            httpResponse.setDateHeader("Expires", 0);
            session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            String errorMessage = "";
            if ("POST".equals(request.getMethod())) {
                String emailAddress = request.getParameter("emailAddress");
                String password = request.getParameter("password");
                String[] employee = employee_service.employeeLogin(emailAddress, password);
                if (employee != null) {
                    String workingStatus = employee[2];
                    int branchId = Integer.parseInt(employee[1]);
                    String[] branch = null;
                    try {
                        branch = branch_service.selectBranch(branchId);
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                    String operationStatus = branch[1];
                    if ("Fired".equals(workingStatus)) {
                        errorMessage = "Access is prohibited for former employees.";
                    } else if ("On Leave".equals(workingStatus)) {
                        errorMessage = "Access is prohibited for employees on leave.";
                    } else if ("Inactive".equals(operationStatus)) {
                        errorMessage = "Access is prohibited for employees at inactive branches.";
                    } else {
                        session = request.getSession(true);
                        session.setAttribute("employeeId", employee[0]);
                        session.setAttribute("branchStationed", employee[1]);
                        session.setAttribute("firstName", employee[3]);
                        session.setAttribute("lastName", employee[4]);
                        response.sendRedirect("employee_pages/manage_transactions_view.jsp");
                        return;
                    }
                } else {
                    errorMessage = "Invalid email address or password.";
                }
            }
        %>
        <form method="POST">
            <h2>Employee Login</h2>
            <label for="emailAddress">Email Address:</label>
            <input type="text" id="emailAddress" name="emailAddress" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" value="Log In"><br><br>
            <div><%= errorMessage%></div><br>
        </form>
        <form action="add_transaction_form.jsp">
            <input type="submit" value="Go to Add Transaction Form">
        </form>
        <p><a href="admin_login.jsp">Log in as Admin</a></p>
    </body>
</html>