<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.NameFormatter"%>
<%@page import="web_services.TransactionWebServices"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Transaction Form</title>
    </head>
    <body>
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
                    // Create a web service client and call the service to insert data
                    TransactionWebServices service = new TransactionWebServices();
                    service.insertNewTransaction(senderName, senderContactNumber, receiverName, receiverContactNumber, amount);
                    // Set insertionResult to true if the insertion was successful
                    insertionResult = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Check if the data was successfully inserted
                if (insertionResult) {
        %>
        <p>Your form has been successfully sent. We will contact you anytime for verification.</p>
        <%
        } else {
            // Display an error message if the insertion failed
        %>
        <p>Sorry, an error occurred while processing your request. Please try again later or contact support.</p>
        <%
                }
            }
        %>
        <h1>Payport Express Transaction Form</h1>
        <form action="TransactionFormView.jsp" method="post">
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
                <input type="text" id="amount" name="amount" oninput="AmountOnly(this)" required><br>
                <button type="submit">Submit</button>
            </div>
        </form>
        <script>
            function LettersOnly(inputField) {
                // Regular expression to allow only letters and a single space
                var pattern = /^[A-Za-z]+( [A-Za-z]+)*$/;
                var inputValue = inputField.value;
                if (!pattern.test(inputValue)) {
                    // Remove non-alphabet characters and extra spaces
                    inputField.value = inputValue.replace(/[^A-Za-z\s]/g, '').replace(/\s{2,}/g, ' ');
                }
            }
            function NumbersOnly(inputField) {
                // Regular expression to allow only numbers
                var pattern = /^[0-9]+$/;
                var inputValue = inputField.value;
                if (!pattern.test(inputValue)) {
                    // Remove non-number characters
                    inputField.value = inputValue.replace(/[^0-9]/g, '');
                }
            }
            function AmountOnly(inputField) {
                var inputValue = inputField.value;
                // Remove any extra periods
                var cleanedValue = inputValue.replace(/(\.\d*)\./, '$1');
                // Regular expression to allow numbers with one decimal point
                var pattern = /^\d*\.?\d*$/;
                if (!pattern.test(cleanedValue)) {
                    // Remove non-number or extra decimal characters
                    cleanedValue = cleanedValue.replace(/[^0-9.]/g, '');
                }
                // Set the cleaned value back in the input field
                inputField.value = cleanedValue;
            }
        </script>
    </body>
</html>