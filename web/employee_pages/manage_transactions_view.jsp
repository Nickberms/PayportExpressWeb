<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Transactions</title>
        <link rel="stylesheet" type="text/css" href="employee_styles.css">
        <script type="text/javascript" src="employee_scripts.js"></script>
        <%TransactionWebServices transaction_service = new TransactionWebServices();%>
    </head>
    <body>        
        <%
            String action = request.getParameter("action");
            try {
                if (action.equals("verify")) {
                    String transactionIdParam = request.getParameter("transactionId");
                    int transactionId = Integer.parseInt(transactionIdParam);
                    transaction_service.verifyTransaction(transactionId);
                    response.sendRedirect("manage_transactions_view.jsp");
                } else if (action.equals("send")) {
                    // Execute code for the "Send" action
                    // Add your Send action code here
                } else if (action.equals("withdraw")) {
                    // Execute code for the "Withdraw" action
                    // Add your Withdraw action code here
                } else if (action.equals("delete")) {
                    String transactionIdParam = request.getParameter("transactionId");
                    int transactionId = Integer.parseInt(transactionIdParam);
                    transaction_service.deleteTransaction(transactionId);
                    response.sendRedirect("manage_transactions_view.jsp");
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        %>
        <h2>Transactions Table</h2>
        <table>
            <thead>
                <tr>
                    <th>Transaction ID</th>
                    <th>Verification Status</th>
                    <th>Sender Name</th>
                    <th>Sender Contact Number</th>
                    <th>Receiver Name</th>
                    <th>Receiver Contact Number</th>
                    <th>Amount</th>
                    <th>Control Number</th>
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
                %>
                <tr>
                    <td><%= (transaction[0] != null && !transaction[0].isEmpty()) ? transaction[0] : ""%></td>
                    <td><%= (transaction[1] != null && !transaction[1].isEmpty()) ? transaction[1] : ""%></td>
                    <td><%= (transaction[2] != null && !transaction[2].isEmpty()) ? transaction[2] : ""%></td>
                    <td><%= (transaction[3] != null && !transaction[3].isEmpty()) ? transaction[3] : ""%></td>
                    <td><%= (transaction[4] != null && !transaction[4].isEmpty()) ? transaction[4] : ""%></td>
                    <td><%= (transaction[5] != null && !transaction[5].isEmpty()) ? transaction[5] : ""%></td>
                    <td><%= (transaction[6] != null && !transaction[6].isEmpty()) ? transaction[6] : ""%></td>
                    <td><%= (transaction[7] != null && !transaction[7].isEmpty()) ? transaction[7] : ""%></td>
                    <td><%= ("1".equals(transaction[8])) ? "" : transaction[8]%></td>
                    <td><%= ("1".equals(transaction[9])) ? "" : transaction[9]%></td>
                    <td><%= ("1".equals(transaction[10])) ? "" : transaction[10]%></td>
                    <td><%= ("1".equals(transaction[11])) ? "" : transaction[11]%></td>
                    <td><%= (transaction[12] != null && !transaction[12].isEmpty()) ? transaction[12] : ""%></td>
                    <td><%= (transaction[13] != null && !transaction[13].isEmpty()) ? transaction[13] : ""%></td>
                    <td><%= (transaction[14] != null && !transaction[14].isEmpty()) ? transaction[14] : ""%></td>
                    <td>
                        <a href="manage_transactions_view.jsp?action=verify&transactionId=<%= transaction[0]%>">Verify</a>
                        <a href="">Send</a>
                        <a href="">Withdraw</a>
                        <a href="manage_transactions_view.jsp?action=delete&transactionId=<%= transaction[0]%>">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>   
            </tbody>
        </table><br><br><br>
    </body>
</html>