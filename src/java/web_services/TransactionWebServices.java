package web_services;

import query_operations.*;
import java.util.*;
import javax.jws.*;

@WebService(serviceName = "TransactionWebServices")
public class TransactionWebServices {

    @WebMethod(operationName = "insertNewTransaction")
    public void insertNewTransaction(
            @WebParam(name = "sender_name") String sender_name,
            @WebParam(name = "sender_contact_number") String sender_contact_number,
            @WebParam(name = "receiver_name") String receiver_name,
            @WebParam(name = "receiver_contact_number") String receiver_contact_number,
            @WebParam(name = "amount") String amount) {
        TransactionQueries insertNewTransaction = new TransactionQueries();
        insertNewTransaction.setSenderName(sender_name);
        insertNewTransaction.setSenderContactNumber(sender_contact_number);
        insertNewTransaction.setReceiverName(receiver_name);
        insertNewTransaction.setReceiverContactNumber(receiver_contact_number);
        insertNewTransaction.setAmount(amount);
        insertNewTransaction.insertNewTransaction_Query();
    }

    @WebMethod(operationName = "selectAllTransactions")
    public ArrayList<String[]> selectAllTransactions() {
        ArrayList<String[]> transactionStr = new ArrayList<>();
        TransactionQueries selectAllTransactions = new TransactionQueries();
        List<TransactionQueries> transactions = selectAllTransactions.selectAllTransactions_Query();
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

    @WebMethod(operationName = "updateTransaction")
    public boolean updateTransaction(int transactionId,
            @WebParam(name = "verification_status") String verification_status,
            @WebParam(name = "sender_name") String sender_name,
            @WebParam(name = "sender_contact_number") String sender_contact_number,
            @WebParam(name = "receiver_name") String receiver_name,
            @WebParam(name = "receiver_contact_number") String receiver_contact_number,
            @WebParam(name = "amount") String amount,
            @WebParam(name = "control_number") String control_number,
            @WebParam(name = "sender_employee") Integer sender_employee,
            @WebParam(name = "receiver_employee") Integer receiver_employee,
            @WebParam(name = "branch_sent") Integer branch_sent,
            @WebParam(name = "branch_withdrawn") Integer branch_withdrawn,
            @WebParam(name = "withdrawal_status") String withdrawal_status) {
        TransactionQueries updateTransaction = new TransactionQueries();
        updateTransaction.setVerificationStatus(verification_status);
        updateTransaction.setSenderName(sender_name);
        updateTransaction.setSenderContactNumber(sender_contact_number);
        updateTransaction.setReceiverName(receiver_name);
        updateTransaction.setReceiverContactNumber(receiver_contact_number);
        updateTransaction.setAmount(amount);
        updateTransaction.setControlNumber(control_number);
        updateTransaction.setSenderEmployee(sender_employee);
        updateTransaction.setReceiverEmployee(receiver_employee);
        updateTransaction.setBranchSent(branch_sent);
        updateTransaction.setBranchWithdrawn(branch_withdrawn);
        updateTransaction.setWithdrawalStatus(withdrawal_status);
        return updateTransaction.updateTransaction_Query(transactionId);
    }

    @WebMethod(operationName = "verifyTransaction")
    public boolean verifyTransaction(int transactionId) {
        TransactionQueries verifyTransaction = new TransactionQueries();
        return verifyTransaction.verifyTransaction_Query(transactionId);
    }

    @WebMethod(operationName = "deleteTransaction")
    public boolean deleteTransaction(int transactionId) {
        TransactionQueries deleteTransaction = new TransactionQueries();
        return deleteTransaction.deleteTransaction_Query(transactionId);
    }
}