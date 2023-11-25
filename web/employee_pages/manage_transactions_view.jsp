<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Transactions</title>
        <link rel="stylesheet" type="text/css" href="employee_styles.css">
        <script type="text/javascript" src="employee_scripts.js"></script>
        <%BranchWebServices branch_service = new BranchWebServices();%>
        <%EmployeeWebServices employee_service = new EmployeeWebServices();%>
        <%TransactionWebServices transaction_service = new TransactionWebServices();%>
    </head>
    <body>        
        <%
            HttpServletResponse httpResponse = response;
            httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            httpResponse.setHeader("Pragma", "no-cache");
            httpResponse.setDateHeader("Expires", 0);
            session = request.getSession(false);
            String employeeId = (String) session.getAttribute("employeeId");
            if (session == null || session.getAttribute("employeeId") == null) {
                response.sendRedirect("../employee_login.jsp");
                return;
            }
            int branchId = 0;
            String branchName = "";
            if (session != null && session.getAttribute("branchStationed") != null) {
                branchId = Integer.parseInt((String) session.getAttribute("branchStationed"));
                HashMap<Integer, String> branchMap = new HashMap<>();
                List<String[]> branches = branch_service.selectAllBranches();
                for (String[] branch : branches) {
                    branchMap.put(Integer.parseInt(branch[0]), branch[2]);
                }
                branchName = branchMap.getOrDefault(branchId, "");
            }
            String firstName = (String) session.getAttribute("firstName");
            String lastName = (String) session.getAttribute("lastName");
            String action = request.getParameter("action");
            try {
                if (action.equals("logout")) {
                    if (session != null) {
                        session.invalidate();
                    }
                    response.sendRedirect("../employee_login.jsp");
                    return;
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        %>
        <h2>Welcome <%= firstName%> <%= lastName%></h2>
        <p>Employee ID: <%= employeeId%></p>
        <p>Branch Stationed: <%= branchId%> <%= branchName%></p>
        <a href="manage_transactions_view.jsp?action=logout">Logout</a>
        <%
            try {
                String controlNumberParam = request.getParameter("controlNumber");
                int controlNumber = Integer.parseInt(controlNumberParam);
                if (action.equals("verify")) {
                    String[] transaction = transaction_service.selectTransaction(controlNumber);
                    String verificationStatus = transaction[1];
                    if ("Verified".equals(verificationStatus)) {
                        response.sendRedirect("manage_transactions_view.jsp");
                    } else {
                        transaction_service.verifyTransaction(controlNumber);
                        response.sendRedirect("manage_transactions_view.jsp");
                    }
                } else if (action.equals("send")) {
                    String[] transaction = transaction_service.selectTransaction(controlNumber);
                    String verificationStatus = transaction[1];
                    String withdrawalStatus = transaction[12];
                    if ("Not Verified".equals(verificationStatus) || withdrawalStatus != null) {
                        response.sendRedirect("manage_transactions_view.jsp");
                    } else {
                        transaction_service.sendMoney(controlNumber, Integer.parseInt(employeeId), branchId);
                        response.sendRedirect("manage_transactions_view.jsp");
                    }
                } else if (action.equals("withdraw")) {
                    String[] transaction = transaction_service.selectTransaction(controlNumber);
                    String verificationStatus = transaction[1];
                    String withdrawalStatus = transaction[12];
                    if ("Verified".equals(verificationStatus) && "Not Withdrawn".equals(withdrawalStatus)) {
                        transaction_service.withdrawMoney(controlNumber, Integer.parseInt(employeeId), branchId);
                        response.sendRedirect("manage_transactions_view.jsp");
                    } else {
                        response.sendRedirect("manage_transactions_view.jsp");
                    }
                } else if (action.equals("remove")) {
                    String[] transaction = transaction_service.selectTransaction(controlNumber);
                    String withdrawalStatus = transaction[12];
                    if ("Not Withdrawn".equals(withdrawalStatus)) {
                        response.sendRedirect("manage_transactions_view.jsp");
                    } else {
                        transaction_service.removeTransaction(controlNumber);
                        response.sendRedirect("manage_transactions_view.jsp");
                    }
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        %>
        <h2>Manage Transactions</h2>
        <table>
            <thead>
                <tr>
                    <th>Control Number</th>
                    <th>Verification Status</th>
                    <th>Sender Name</th>
                    <th>Sender Contact Number</th>
                    <th>Receiver Name</th>
                    <th>Receiver Contact Number</th>
                    <th>Amount</th>
                    <th>Sender Employee</th>
                    <th>Receiver Employee</th>
                    <th>Branch Sent</th>
                    <th>Branch Withdrawn</th>
                    <th>Date Sent</th>
                    <th>Withdrawal Status</th>
                    <th>Date Withdrawn</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<String[]> transactions = transaction_service.selectAllTransactions();
                    for (String[] transaction : transactions) {
                        if (!"Removed".equals(transaction[1])) {
                %>
                <tr>
                    <td><%= (transaction[0] != null && !transaction[0].isEmpty()) ? transaction[0] : ""%></td>
                    <td><%= (transaction[1] != null && !transaction[1].isEmpty()) ? transaction[1] : ""%></td>
                    <td><%= (transaction[2] != null && !transaction[2].isEmpty()) ? transaction[2] : ""%></td>
                    <td><%= (transaction[3] != null && !transaction[3].isEmpty()) ? transaction[3] : ""%></td>
                    <td><%= (transaction[4] != null && !transaction[4].isEmpty()) ? transaction[4] : ""%></td>
                    <td><%= (transaction[5] != null && !transaction[5].isEmpty()) ? transaction[5] : ""%></td>
                    <td><%= (transaction[6] != null && !transaction[6].isEmpty()) ? transaction[6] : ""%></td>
                    <%
                        Map<String, String> employeeMap = new HashMap<>();
                        List<String[]> employees = employee_service.selectAllEmployees();
                        for (String[] employee : employees) {
                            employeeMap.put(employee[0], employee[3] + " " + employee[4]);
                        }
                    %>
                    <td><%= ("0".equals(transaction[7])) ? "" : transaction[7] + " " + employeeMap.getOrDefault(transaction[7], "")%></td>
                    <td><%= ("0".equals(transaction[8])) ? "" : transaction[8] + " " + employeeMap.getOrDefault(transaction[8], "")%></td>
                    <%
                        Map<String, String> branchMap = new HashMap<>();
                        List<String[]> branches = branch_service.selectAllBranches();
                        for (String[] branch : branches) {
                            branchMap.put(branch[0], branch[2]);
                        }
                    %>
                    <td><%= ("0".equals(transaction[9])) ? "" : transaction[9] + " " + branchMap.getOrDefault(transaction[9], "")%></td>
                    <td><%= ("0".equals(transaction[10])) ? "" : transaction[10] + " " + branchMap.getOrDefault(transaction[10], "")%></td>
                    <td><%= (transaction[11] != null && !transaction[11].isEmpty()) ? transaction[11] : ""%></td>
                    <td><%= (transaction[12] != null && !transaction[12].isEmpty()) ? transaction[12] : ""%></td>
                    <td><%= (transaction[13] != null && !transaction[13].isEmpty()) ? transaction[13] : ""%></td>
                    <td>
                        <a href="manage_transactions_view.jsp?action=verify&controlNumber=<%= transaction[0]%>" onclick="return confirm('Verify transaction? This action cannot be undone');">Verify</a>
                        <a href="manage_transactions_view.jsp?action=send&controlNumber=<%= transaction[0]%>" onclick="return confirm('Send transaction money? This action cannot be undone');">Send</a>
                        <a href="manage_transactions_view.jsp?action=withdraw&controlNumber=<%= transaction[0]%>" onclick="return confirm('Withdraw transaction money? This action cannot be undone');">Withdraw</a>
                        <a href="manage_transactions_view.jsp?action=remove&controlNumber=<%= transaction[0]%>" onclick="return confirm('Remove transaction? This action cannot be undone');">Remove</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>   
            </tbody>
        </table><br><br><br>
    </body>
</html>