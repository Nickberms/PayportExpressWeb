<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Branch</title>
        <link rel="stylesheet" type="text/css" href="admin_styles.css">
        <script type="text/javascript" src="admin_scripts.js"></script>
        <%BranchWebServices service = new BranchWebServices();%>
    </head>
    <body>
        <%
            String action = request.getParameter("action");
            try {
                if (action.equals("update")) {
                    int branchId = Integer.parseInt(request.getParameter("branchId"));
                    String operationStatus = request.getParameter("operationStatus");
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
                        service.updateBranch(branchId, operationStatus, branchName, address, contactInformation);
                        response.sendRedirect("manage_branches_view.jsp");
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        %>
        <h2>Update Payport Express Branch</h2>
        <form action="update_branch_form.jsp?action=update" method="post">
            <div> <%
                String branchIdStr = request.getParameter("branchId");
                int branchId = 0;
                String[] branch = null;
                if (branchIdStr != null && !branchIdStr.isEmpty()) {
                    try {
                        branchId = Integer.parseInt(branchIdStr);
                        branch = service.selectBranch(branchId);
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }
                String fullAddress = branch[3];
                String[] addressParts = fullAddress.split(",");
                String town = addressParts.length > 0 ? addressParts[0].trim() : "";
                String municipality = addressParts.length > 1 ? addressParts[1].trim() : "";
                String province = addressParts.length > 2 ? addressParts[2].trim() : "";
                %>
                <div>
                    <h2>Branch Details</h2>
                    <label for="branchId">Branch ID:</label>
                    <input type="text" id="branchId" name="branchId" value="<%= branch[0]%>" readonly><br>
                    <label for="operationStatus">Operation Status:</label>
                    <select id="operationStatus" name="operationStatus">
                        <option value="Active" <%= "Active".equals(branch[1].trim()) ? "selected" : ""%>>Active</option>
                        <option value="Inactive" <%= "Inactive".equals(branch[1].trim()) ? "selected" : ""%>>Inactive</option>
                    </select><br>
                    <label for="branchName">Branch Name:</label>
                    <input type="text" id="branchName" name="branchName" value="<%= branch[2]%>" oninput="LettersOnly(this)" required><br>
                    <label for="town">Town:</label>
                    <input type="text" id="town" name="town" value="<%= town%>" oninput="LettersOnly(this)" required><br>
                    <label for="municipality">Municipality:</label>
                    <input type="text" id="municipality" name="municipality" value="<%= municipality%>" oninput="LettersOnly(this)" required><br>
                    <label for="province">Province:</label>
                    <input type="text" id="province" name="province" value="<%= province%>" oninput="LettersOnly(this)" required><br>
                    <label for="contactInformation">Contact Information:</label>
                    <input type="text" id="contactInformation" name="contactInformation" value="<%= branch[4]%>" oninput="NumbersOnly(this)" required><br><br>
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