package web_services;

import query_operations.*;
import java.util.*;
import javax.jws.*;

@WebService(serviceName = "TransactionWebServices")
public class TransactionWebServices {

    // This method is exposed as a web service operation with the name "insertNewTransaction"
    @WebMethod(operationName = "insertNewTransaction")
    public void insertNewTransaction(
            @WebParam(name = "sender_name") String sender_name,
            @WebParam(name = "sender_contact_number") String sender_contact_number,
            @WebParam(name = "receiver_name") String receiver_name,
            @WebParam(name = "receiver_contact_number") String receiver_contact_number,
            @WebParam(name = "amount") String amount) {
        // Create an instance of TransactionQueries class
        TransactionQueries insertNewTransaction = new TransactionQueries();
        // Set the values of the parameters received from the web service request
        insertNewTransaction.setSenderName(sender_name);
        insertNewTransaction.setSenderContactNumber(sender_contact_number);
        insertNewTransaction.setReceiverName(receiver_name);
        insertNewTransaction.setReceiverContactNumber(receiver_contact_number);
        insertNewTransaction.setAmount(amount);
        // Call the "insertNewTransaction" method to insert data into the database
        insertNewTransaction.insertNewTransaction();
    }

    // This method is exposed as a web service operation with the name "selectAllTransactions"
    @WebMethod(operationName = "selectAllTransactions")
    public ArrayList<String[]> selectAllTransactions() {
        ArrayList<String[]> transactionStr = new ArrayList<>();
        // Create an instance of TransactionQueries class
        TransactionQueries selectAllTransactions = new TransactionQueries();
        // Call the "selectAllTransactions" method to retrieve a list of transactions
        List<TransactionQueries> transactions = selectAllTransactions.selectAllTransactions();
        if (transactions != null) {
            transactions.forEach((transaction) -> {
                String[] str = new String[15];
                str[0] = String.valueOf(transaction.getTransactionId());
                str[1] = transaction.getVerificationStatus();
                str[2] = transaction.getSenderName();
                str[3] = transaction.getSenderContactNumber();
                str[4] = transaction.getReceiverName();
                str[5] = transaction.getReceiverContactNumber();
                str[6] = transaction.getAmount();
                str[7] = transaction.getControlNumber();
                str[8] = String.valueOf(transaction.getSenderEmployee());
                str[9] = String.valueOf(transaction.getReceiverEmployee());
                str[10] = String.valueOf(transaction.getBranchSent());
                str[11] = String.valueOf(transaction.getBranchWithdrawn());
                str[12] = transaction.getDateSent() != null ? transaction.getDateSent().toString() : "";
                str[13] = transaction.getWithdrawalStatus();
                str[14] = transaction.getDateWithdrawn() != null ? transaction.getDateWithdrawn().toString() : "";
                transactionStr.add(str);
            });
        }
        return transactionStr;
    }

    // This method is exposed as a web service operation with the name "deleteTransaction"
    @WebMethod(operationName = "deleteTransaction")
    public boolean deleteTransaction(int transactionId) {
        // Create an instance of TransactionQueries class
        TransactionQueries deleteTransaction = new TransactionQueries();
        // Call the "deleteTransaction" method to perform the deletion
        return deleteTransaction.deleteTransaction(transactionId);
    }
}