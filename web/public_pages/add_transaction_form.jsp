<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add New Transaction</title>
        <link rel="stylesheet" type="text/css" href="public_styles.css">
        <script type="text/javascript" src="public_scripts.js"></script>
        <%TransactionWebServices service = new TransactionWebServices();%>
    </head>
    <body>        
        <%
            String action = request.getParameter("action");
            try {
                if (action.equals("insert")) {
                    String senderFirstName = request.getParameter("senderFirstName");
                    senderFirstName = NameFormatter.formatName(senderFirstName);
                    String senderMiddleName = request.getParameter("senderMiddleName");
                    senderMiddleName = NameFormatter.formatName(senderMiddleName);
                    String senderLastName = request.getParameter("senderLastName");
                    senderLastName = NameFormatter.formatName(senderLastName);
                    String senderNameSuffix = request.getParameter("senderNameSuffix");
                    String senderName = senderFirstName;
                    if (senderMiddleName != null && !senderMiddleName.isEmpty()) {
                        senderName += " " + senderMiddleName;
                    }
                    senderName += " " + senderLastName;
                    if (senderNameSuffix != null && !senderNameSuffix.isEmpty()) {
                        senderName += " " + senderNameSuffix;
                    }
                    String senderContactNumber = request.getParameter("senderContactNumber");
                    String receiverFirstName = request.getParameter("receiverFirstName");
                    receiverFirstName = NameFormatter.formatName(receiverFirstName);
                    String receiverMiddleName = request.getParameter("receiverMiddleName");
                    receiverMiddleName = NameFormatter.formatName(receiverMiddleName);
                    String receiverLastName = request.getParameter("receiverLastName");
                    receiverLastName = NameFormatter.formatName(receiverLastName);
                    String receiverNameSuffix = request.getParameter("receiverNameSuffix");
                    String receiverName = receiverFirstName;
                    if (receiverMiddleName != null && !receiverMiddleName.isEmpty()) {
                        receiverName += " " + receiverMiddleName;
                    }
                    receiverName += " " + receiverLastName;
                    if (receiverNameSuffix != null && !receiverNameSuffix.isEmpty()) {
                        receiverName += " " + receiverNameSuffix;
                    }
                    String receiverContactNumber = request.getParameter("receiverContactNumber");
                    String amount = request.getParameter("amount");
                    boolean insertionResult = false;
                    try {
                        service.insertNewTransaction(senderName, senderContactNumber, receiverName, receiverContactNumber, amount);
                        insertionResult = true;
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                    if (insertionResult) {
                        out.println("Your form has been successfully sent. We will contact you anytime for verification.");
                    } else {
                        out.println("Sorry, an error occurred while processing your request. Please try again later or contact support.");
                    }
                } else if (action.equals("verify")) {
                    String transactionIdParam = request.getParameter("transactionId");
                    int transactionId = Integer.parseInt(transactionIdParam);
                    service.verifyTransaction(transactionId);
                    response.sendRedirect("add_transaction_form.jsp");
                } else if (action.equals("send")) {
                    // Execute code for the "Send" action
                    // Add your Send action code here
                } else if (action.equals("withdraw")) {
                    // Execute code for the "Withdraw" action
                    // Add your Withdraw action code here
                } else if (action.equals("delete")) {
                    String transactionIdParam = request.getParameter("transactionId");
                    int transactionId = Integer.parseInt(transactionIdParam);
                    service.deleteTransaction(transactionId);
                    response.sendRedirect("add_transaction_form.jsp");
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        %>
        <h2>Payport Express Transaction Form</h2>
        <form action="add_transaction_form.jsp?action=insert" method="post">
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
        </form>
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
                        <a href="add_transaction_form.jsp?action=verify&transactionId=<%= transaction[0]%>">Verify</a>
                        <a href="">Send</a>
                        <a href="">Withdraw</a>
                        <a href="add_transaction_form.jsp?action=delete&transactionId=<%= transaction[0]%>">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>   
            </tbody>
        </table><br><br><br>
    </body>
</html>