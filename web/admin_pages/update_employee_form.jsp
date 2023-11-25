<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Employee</title>
        <link rel="stylesheet" type="text/css" href="admin_styles.css">
        <script type="text/javascript" src="admin_scripts.js"></script>
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
            String employeeIdParam = request.getParameter("employeeId");
            if (session == null || session.getAttribute("adminId") == null) {
                response.sendRedirect("../admin_login.jsp");
                return;
            } else if (employeeIdParam == null || employeeIdParam.trim().isEmpty()) {
                String referer = request.getHeader("Referer");
                if (referer != null && !referer.isEmpty()) {
                    response.sendRedirect(referer);
                } else {
                    response.sendRedirect("manage_employees_view.jsp");
                }
                return;
            }
            String action = request.getParameter("action");
            try {
                if (action.equals("update")) {
                    int employeeId = Integer.parseInt(request.getParameter("employeeId"));
                    int branchStationed = Integer.parseInt(request.getParameter("branchStationed"));
                    String workingStatus = request.getParameter("workingStatus");
                    String firstName = request.getParameter("firstName");
                    firstName = NameFormatter.formatName(firstName);
                    String lastName = request.getParameter("lastName");
                    lastName = NameFormatter.formatName(lastName);
                    String birthdateString = request.getParameter("birthdate");
                    Date birthdate = null;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    birthdate = dateFormat.parse(birthdateString);
                    String sex = request.getParameter("sex");
                    String town = request.getParameter("town");
                    town = NameFormatter.formatName(town);
                    String municipality = request.getParameter("municipality");
                    municipality = NameFormatter.formatName(municipality);
                    String province = request.getParameter("province");
                    province = NameFormatter.formatName(province);
                    String address = town + ", " + municipality + ", " + province;
                    String phoneNumber = request.getParameter("phoneNumber");
                    String emailAddress = request.getParameter("emailAddress");
                    String password = request.getParameter("password");
                    try {
                        employee_service.updateEmployee(employeeId, branchStationed, workingStatus, firstName, lastName, birthdate, sex, address, phoneNumber, emailAddress, password);
                        response.sendRedirect("manage_employees_view.jsp");
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        %>
        <h2>Update Payport Express Employee</h2>
        <form action="update_employee_form.jsp?action=update" method="post">
            <div> <%
                String employeeIdStr = request.getParameter("employeeId");
                int employeeId = 0;
                String[] employee = null;
                if (employeeIdStr != null && !employeeIdStr.isEmpty()) {
                    try {
                        employeeId = Integer.parseInt(employeeIdStr);
                        employee = employee_service.selectEmployee(employeeId);
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }
                String fullAddress = employee[7];
                String[] addressParts = fullAddress.split(",");
                String town = addressParts.length > 0 ? addressParts[0].trim() : "";
                String municipality = addressParts.length > 1 ? addressParts[1].trim() : "";
                String province = addressParts.length > 2 ? addressParts[2].trim() : "";
                %>
                <div>
                    <label for="employeeId">Employee ID:</label>
                    <input type="text" id="employeeId" name="employeeId" value="<%= employee[0]%>" readonly><br>
                    <h3>Branch and Status</h3>
                    <label for="branchStationed">Branch Station:</label>
                    <select id="branchStationed" name="branchStationed">
                        <%
                            List<String[]> branches = branch_service.selectAllBranches();
                            for (String[] branch : branches) {
                                boolean isSelected = employee != null && employee[1].equals(branch[0]);
                        %>
                        <option value="<%= branch[0]%>" <%= isSelected ? "selected" : ""%>><%= branch[0]%> <%= branch[2]%></option>
                        <%
                            }
                        %>
                    </select><br>
                    <label for="workingStatus">Working Status:</label>
                    <select id="workingStatus" name="workingStatus">
                        <option value="Active" <%= "Active".equals(employee[2].trim()) ? "selected" : ""%>>Active</option>
                        <option value="On Leave" <%= "On Leave".equals(employee[2].trim()) ? "selected" : ""%>>On Leave</option>
                        <option value="Fired" <%= "Fired".equals(employee[2].trim()) ? "selected" : ""%>>Fired</option>
                    </select><br>
                    <h3>Basic Information</h3>
                    <label for="firstName">First Name:</label>
                    <input type="text" id="firstName" name="firstName" value="<%= employee[3]%>" oninput="LettersOnly(this)" required><br>
                    <label for="lastName">Last Name:</label>
                    <input type="text" id="lastName" name="lastName" value="<%= employee[4]%>" oninput="LettersOnly(this)" required><br>
                    <label for="birthdate">Birthdate:</label>
                    <input type="date" id="birthdate" name="birthdate" value="<%= employee[5]%>" required><br>
                    <label for="sex">Sex:</label>
                    <select id="sex" name="sex">
                        <option value="Male" <%= "Male".equals(employee[6].trim()) ? "selected" : ""%>>Male</option>
                        <option value="Female" <%= "Female".equals(employee[6].trim()) ? "selected" : ""%>>Female</option>
                    </select><br>
                    <h3>Address</h3>
                    <label for="town">Town:</label>
                    <input type="text" id="town" name="town" value="<%= town%>" oninput="LettersOnly(this)" required><br>
                    <label for="municipality">Municipality:</label>
                    <input type="text" id="municipality" name="municipality" value="<%= municipality%>" oninput="LettersOnly(this)" required><br>
                    <label for="province">Province:</label>
                    <input type="text" id="province" name="province" value="<%= province%>" oninput="LettersOnly(this)" required><br>
                    <h3>Credentials</h3>
                    <label for="phoneNumber">Phone Number:</label>
                    <input type="text" id="phoneNumber" name="phoneNumber" value="<%= employee[8]%>" oninput="NumbersOnly(this)" required><br>
                    <label for="emailAddress">Email Address:</label>
                    <input type="email" id="emailAddress" name="emailAddress" value="<%= employee[9]%>" oninput="EmailOnly(this)" required><br>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" value="<%= employee[10]%>" required><br><br>
                </div>
            </div>
            <div>
                <button type="submit">Save</button>
            </div>
        </form><br>
        <form action="manage_employees_view.jsp">
            <input type="submit" value="Cancel">
        </form><br><br>
    </body>
</html>