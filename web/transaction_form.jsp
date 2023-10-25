<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Transaction Form</title>
        <style>
            table {
                border: 1px solid #000;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid #000;
                font-size: 14px;
                text-align: center;
                width: 80px;
            }
        </style>
        <script type="text/javascript" src="JAVASCRIPT-INF/javascripts.js"></script>
        <!-- Create a web service client and call the service -->
        <%TransactionWebServices service = new TransactionWebServices();%>
    </head>
    <body>
        <!-- JSP logic to handle the "insertNewTransaction" web service -->
        <%
            if (request.getMethod().equals("POST")) {
                // Retrieve and format sender's details from form input
                String senderFirstName = request.getParameter("senderFirstName");
                senderFirstName = NameFormatter.formatName(senderFirstName);
                String senderMiddleName = request.getParameter("senderMiddleName");
                senderMiddleName = NameFormatter.formatName(senderMiddleName);
                String senderLastName = request.getParameter("senderLastName");
                senderLastName = NameFormatter.formatName(senderLastName);
                String senderNameSuffix = request.getParameter("senderNameSuffix");
                // Create a formatted sender name from the components
                String senderName = senderFirstName;
                if (senderMiddleName != null && !senderMiddleName.isEmpty()) {
                    senderName += " " + senderMiddleName;
                }
                senderName += " " + senderLastName;
                if (senderNameSuffix != null && !senderNameSuffix.isEmpty()) {
                    senderName += " " + senderNameSuffix;
                }
                // Retrieve sender's contact number
                String senderContactNumber = request.getParameter("senderContactNumber");
                // Retrieve and format receiver's details from form input
                String receiverFirstName = request.getParameter("receiverFirstName");
                receiverFirstName = NameFormatter.formatName(receiverFirstName);
                String receiverMiddleName = request.getParameter("receiverMiddleName");
                receiverMiddleName = NameFormatter.formatName(receiverMiddleName);
                String receiverLastName = request.getParameter("receiverLastName");
                receiverLastName = NameFormatter.formatName(receiverLastName);
                String receiverNameSuffix = request.getParameter("receiverNameSuffix");
                // Create a formatted receiver name from the components
                String receiverName = receiverFirstName;
                if (receiverMiddleName != null && !receiverMiddleName.isEmpty()) {
                    receiverName += " " + receiverMiddleName;
                }
                receiverName += " " + receiverLastName;
                if (receiverNameSuffix != null && !receiverNameSuffix.isEmpty()) {
                    receiverName += " " + receiverNameSuffix;
                }
                // Retrieve receiver's contact number
                String receiverContactNumber = request.getParameter("receiverContactNumber");
                // Retrieve the transaction amount
                String amount = request.getParameter("amount");
                // Initialize a flag to track insertion result
                boolean insertionResult = false;
                try {
                    service.insertNewTransaction(senderName, senderContactNumber, receiverName, receiverContactNumber, amount);
                    insertionResult = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Check if the data was successfully inserted
                if (insertionResult) {
                    out.println("Your form has been successfully sent. We will contact you anytime for verification.");
                } else {
                    out.println("Sorry, an error occurred while processing your request. Please try again later or contact support.");
                }
            }
        %>
        <!-- JSP logic to handle the "deleteTransaction" web service -->
        <%
            String transactionIdParam = request.getParameter("transactionId");
            if (transactionIdParam != null && !transactionIdParam.isEmpty()) {
                int transactionId = Integer.parseInt(transactionIdParam);
                service.deleteTransaction(transactionId);
                response.sendRedirect("transaction_form.jsp");
            }
        %>
        <h2>Payport Express Transaction Form</h2>
        <form action="transaction_form.jsp" method="post">
            <div>
                <div>
                    <h2>Sender Details</h2>
                    <label for="senderFirstName">First Name:</label>
                    <input type="text" id="senderFirstName" name="senderFirstName" oninput="LettersOnly(this)" required><br>
                    <label for="senderMiddleName">Middle Name:</label>
                    <input type="text" id="senderMiddleName" name="senderMiddleName" oninput="LettersOnly(this)"><br>
                    <label for="senderLastName">Last Name:</label>
                    <input type="text" id="senderLastName" name="senderLastName" oninput="LettersOnly(this)" required><br>
                    <label for="senderNameSuffix">Name Suffix:</label>
                    <select id="senderNameSuffix" name="senderNameSuffix">
                        <option value="">None</option>
                        <option value="Sr.">Sr.</option>
                        <option value="Jr.">Jr.</option>
                        <option value="III">III</option>
                        <option value="IV">IV</option>
                        <option value="V">V</option>
                        <option value="VI">VI</option>
                        <option value="VII">VII</option>
                        <option value="VIII">VIII</option>
                        <option value="IX">IX</option>
                        <option value="X">X</option>
                    </select><br>
                    <label for="senderContactNumber">Contact Number:</label>
                    <input type="text" id="senderContactNumber" name="senderContactNumber" oninput="NumbersOnly(this)" required><br>
                </div>
                <div>
                    <h2>Receiver Details</h2>
                    <label for="receiverFirstName">First Name:</label>
                    <input type="text" id="receiverFirstName" name="receiverFirstName" oninput="LettersOnly(this)" required><br>
                    <label for="receiverMiddleName">Middle Name:</label>
                    <input type="text" id="receiverMiddleName" name="receiverMiddleName" oninput="LettersOnly(this)"><br>
                    <label for="receiverLastName">Last Name:</label>
                    <input type="text" id="receiverLastName" name="receiverLastName" oninput="LettersOnly(this)" required><br>
                    <label for="receiverNameSuffix">Name Suffix:</label>
                    <select id="receiverNameSuffix" name="receiverNameSuffix">
                        <option value="">None</option>
                        <option value="Sr.">Sr.</option>
                        <option value="Jr.">Jr.</option>
                        <option value="III">III</option>
                        <option value="IV">IV</option>
                        <option value="V">V</option>
                        <option value="VI">VI</option>
                        <option value="VII">VII</option>
                        <option value="VIII">VIII</option>
                        <option value="IX">IX</option>
                        <option value="X">X</option>
                    </select><br>
                    <label for="receiverContactNumber">Contact Number:</label>
                    <input type="text" id="receiverContactNumber" name="receiverContactNumber" oninput="NumbersOnly(this)" required><br>
                </div>
            </div>
            <div>
                <h2>Amount Money</h2>
                <label for="amount">Amount Money:</label>
                <input type="text" id="amount" name="amount" oninput="AmountOnly(this)" required><br><br>
                <button type="submit">Submit</button>
            </div>
        </form><br>
        <h2>Transaction Table</h2>
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
                <!-- JSP logic to handle the "selectAllTransactions" web service -->
                <%
                    // Retrieve the list of transactions
                    List<String[]> transactions = service.selectAllTransactions();
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
                        <a href="">Edit</a>
                        <a href="javascript:void(0);" onclick="ConfirmDelete('<%= transaction[0]%>')">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>   
            </tbody>
        </table><br><br><br>
    </body>
</html>