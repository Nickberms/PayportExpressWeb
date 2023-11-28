package web_services;

import query_operations.*;
import java.sql.*;
import java.time.format.*;
import java.util.*;
import javax.jws.*;

@WebService(serviceName = "TransactionWebServices")
public class TransactionWebServices {

    @WebMethod(operationName = "insertNewTransaction")
    public void insertNewTransaction(
            @WebParam(name = "sender_name") String senderName,
            @WebParam(name = "sender_contact_number") String senderContactNumber,
            @WebParam(name = "receiver_name") String receiverName,
            @WebParam(name = "receiver_contact_number") String receiverContactNumber,
            @WebParam(name = "amount") String amount) {
        TransactionQueries insertNewTransaction = new TransactionQueries();
        insertNewTransaction.setSenderName(senderName);
        insertNewTransaction.setSenderContactNumber(senderContactNumber);
        insertNewTransaction.setReceiverName(receiverName);
        insertNewTransaction.setReceiverContactNumber(receiverContactNumber);
        insertNewTransaction.setAmount(amount);
        insertNewTransaction.insertNewTransaction_Query();
    }

    @WebMethod(operationName = "selectAllTransactions")
    public ArrayList<String[]> selectAllTransactions() {
        ArrayList<String[]> transactionStr = new ArrayList<>();
        TransactionQueries selectAllTransactions = new TransactionQueries();
        List<TransactionQueries> transactions = selectAllTransactions.selectAllTransactions_Query();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy h:mm a");
        if (transactions != null) {
            transactions.forEach((transaction) -> {
                String[] str = new String[14];
                str[0] = String.valueOf(transaction.getControlNumber());
                str[1] = transaction.getVerificationStatus();
                str[2] = transaction.getSenderName();
                str[3] = transaction.getSenderContactNumber();
                str[4] = transaction.getReceiverName();
                str[5] = transaction.getReceiverContactNumber();
                str[6] = transaction.getAmount();
                str[7] = String.valueOf(transaction.getSenderEmployee());
                str[8] = String.valueOf(transaction.getReceiverEmployee());
                str[9] = String.valueOf(transaction.getBranchSent());
                str[10] = String.valueOf(transaction.getBranchWithdrawn());
                Timestamp dateSent = transaction.getDateSent();
                Timestamp dateWithdrawn = transaction.getDateWithdrawn();
                str[11] = (dateSent != null) ? dateFormat.format(dateSent.toLocalDateTime()) : "";
                str[12] = transaction.getWithdrawalStatus();
                str[13] = (dateWithdrawn != null) ? dateFormat.format(dateWithdrawn.toLocalDateTime()) : "";
                transactionStr.add(str);
            });
        }
        return transactionStr;
    }

    @WebMethod(operationName = "selectTransaction")
    public String[] selectTransaction(@WebParam(name = "control_number") int controlNumber) {
        TransactionQueries selectTransaction = new TransactionQueries();
        TransactionQueries transaction = selectTransaction.selectTransaction_Query(controlNumber);
        if (transaction != null) {
            String[] str = new String[14];
            str[0] = String.valueOf(transaction.getControlNumber());
            str[1] = transaction.getVerificationStatus();
            str[2] = transaction.getSenderName();
            str[3] = transaction.getSenderContactNumber();
            str[4] = transaction.getReceiverName();
            str[5] = transaction.getReceiverContactNumber();
            str[6] = transaction.getAmount();
            str[7] = String.valueOf(transaction.getSenderEmployee());
            str[8] = String.valueOf(transaction.getReceiverEmployee());
            str[9] = String.valueOf(transaction.getBranchSent());
            str[10] = String.valueOf(transaction.getBranchWithdrawn());
            str[11] = transaction.getDateSent() != null ? transaction.getDateSent().toString() : "";
            str[12] = transaction.getWithdrawalStatus();
            str[13] = transaction.getDateWithdrawn() != null ? transaction.getDateWithdrawn().toString() : "";
            return str;
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "verifyTransaction")
    public boolean verifyTransaction(int controlNumber) {
        TransactionQueries verifyTransaction = new TransactionQueries();
        return verifyTransaction.verifyTransaction_Query(controlNumber);
    }

    @WebMethod(operationName = "sendMoney")
    public boolean sendMoney(int controlNumber,
            @WebParam(name = "sender_employee") Integer senderEmployee,
            @WebParam(name = "branch_sent") Integer branchSent) {
        TransactionQueries sendMoney = new TransactionQueries();
        sendMoney.setSenderEmployee(senderEmployee);
        sendMoney.setBranchSent(branchSent);
        return sendMoney.sendMoney_Query(controlNumber);
    }

    @WebMethod(operationName = "withdrawMoney")
    public boolean withdrawMoney(int controlNumber,
            @WebParam(name = "receiver_employee") Integer receiverEmployee,
            @WebParam(name = "branch_withdrawn") Integer branchWithdrawn) {
        TransactionQueries withdrawMoney = new TransactionQueries();
        withdrawMoney.setReceiverEmployee(receiverEmployee);
        withdrawMoney.setBranchWithdrawn(branchWithdrawn);
        return withdrawMoney.withdrawMoney_Query(controlNumber);
    }

    @WebMethod(operationName = "removeTransaction")
    public boolean removeTransaction(int controlNumber) {
        TransactionQueries removeTransaction = new TransactionQueries();
        return removeTransaction.removeTransaction_Query(controlNumber);
    }
}