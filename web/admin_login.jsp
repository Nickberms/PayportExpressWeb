<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Login</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <script type="text/javascript" src="scripts.js"></script>
        <%AdminWebServices admin_service = new AdminWebServices();%>
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
                String[] admin = admin_service.adminLogin(emailAddress, password);
                if (admin != null) {
                    session = request.getSession(true);
                    session.setAttribute("adminId", admin[0]);
                    session.setAttribute("firstName", admin[1]);
                    session.setAttribute("lastName", admin[2]);
                    response.sendRedirect("admin_pages/manage_employees_view.jsp");
                    return;
                } else {
                    errorMessage = "Invalid email address or password";
                }
            }
        %>
        <form method="POST">
            <h2>Admin Login</h2>
            <label for="emailAddress">Email Address:</label>
            <input type="text" id="emailAddress" name="emailAddress" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" value="Log In"><br><br>
            <div><%= errorMessage%></div>
        </form>
        <p><a href="employee_login.jsp">Log in as Employee</a></p>
    </body>
</html>