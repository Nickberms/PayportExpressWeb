<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Login</title>
        <link rel="stylesheet" type="text/css" href="admin_styles.css">
        <script type="text/javascript" src="admin_scripts.js"></script>
        <%BranchWebServices service = new BranchWebServices();%>
    </head>
    <body>
        <form action="manage_branches_view.jsp">
            <h2>Admin Login</h2>
            <label for="emailAddress">Email Address:</label>
            <input type="text" id="emailAddress" name="emailAddress" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" value="Log In">
        </form>
    </body>
</html>