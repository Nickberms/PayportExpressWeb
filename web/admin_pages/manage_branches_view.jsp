<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Branches</title>
        <link rel="stylesheet" type="text/css" href="admin_styles.css">
        <script type="text/javascript" src="admin_scripts.js"></script>
        <%BranchWebServices service = new BranchWebServices();%>
    </head>
    <body>        
        <%
            String action = request.getParameter("action");
            try {
                if (action.equals("delete")) {
                    String branchIdParam = request.getParameter("branchId");
                    int branchId = Integer.parseInt(branchIdParam);
                    service.deleteBranch(branchId);
                    response.sendRedirect("manage_branches_view.jsp");
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        %>
        <h2>Branches Table</h2>
        <form action="add_branch_form.jsp">
            <input type="submit" value="Add New Branch">
        </form><br>
        <table>
            <thead>
                <tr>
                    <th>Branch ID</th>
                    <th>Operation Status</th>
                    <th>Branch Name</th>
                    <th>Address</th>
                    <th>Contact Information</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<String[]> branches = service.selectAllBranches();
                    for (String[] branch : branches) {
                %>
                <tr>
                    <td><%= (branch[0] != null && !branch[0].isEmpty()) ? branch[0] : ""%></td>
                    <td><%= (branch[1] != null && !branch[1].isEmpty()) ? branch[1] : ""%></td>
                    <td><%= (branch[2] != null && !branch[2].isEmpty()) ? branch[2] : ""%></td>
                    <td><%= (branch[3] != null && !branch[3].isEmpty()) ? branch[3] : ""%></td>
                    <td><%= (branch[4] != null && !branch[4].isEmpty()) ? branch[4] : ""%></td>
                    <td>
                        <a href="update_branch_form.jsp?branchId=<%= branch[0]%>">Update</a>
                        <a href="manage_branches_view.jsp?action=delete&branchId=<%= branch[0]%>">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>   
            </tbody>
        </table><br><br><br>
    </body>
</html>