<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add New Branch</title>
        <link rel="stylesheet" type="text/css" href="admin_styles.css">
        <script type="text/javascript" src="admin_scripts.js"></script>
        <%BranchWebServices branch_service = new BranchWebServices();%>
    </head>
    <body>  
        <%
            String action = request.getParameter("action");
            try {
                if (action.equals("insert")) {
                    String branchName = request.getParameter("branchName");
                    branchName = NameFormatter.formatName(branchName);
                    String town = request.getParameter("town");
                    town = NameFormatter.formatName(town);
                    String municipality = request.getParameter("municipality");
                    municipality = NameFormatter.formatName(municipality);
                    String province = request.getParameter("province");
                    province = NameFormatter.formatName(province);
                    String address = town + ", " + municipality + ", " + province;
                    String contactInformation = request.getParameter("contactInformation");
                    try {
                        branch_service.insertNewBranch(branchName, address, contactInformation);
                        response.sendRedirect("manage_branches_view.jsp");
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        %>
        <h2>Add New Payport Express Branch</h2>
        <form action="add_branch_form.jsp?action=insert" method="post">
            <div>
                <div>
                    <h3>Name</h3>
                    <label for="branchName">Branch Name:</label>
                    <input type="text" id="branchName" name="branchName" oninput="LettersOnly(this)" required><br>
                    <h3>Address and Contact</h3>
                    <label for="town">Town:</label>
                    <input type="text" id="town" name="town" oninput="LettersOnly(this)" required><br>
                    <label for="municipality">Municipality:</label>
                    <input type="text" id="municipality" name="municipality" oninput="LettersOnly(this)" required><br>
                    <label for="province">Province:</label>
                    <input type="text" id="province" name="province" oninput="LettersOnly(this)" required><br>
                    <label for="contactInformation">Contact Information:</label>
                    <input type="text" id="contactInformation" name="contactInformation" oninput="NumbersOnly(this)" required><br><br>
                </div>
            </div>
            <div>
                <button type="submit">Save</button>
            </div>
        </form><br>
        <form action="manage_branches_view.jsp">
            <input type="submit" value="Cancel">
        </form>
    </body>
</html>