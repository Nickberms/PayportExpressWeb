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
            @WebParam(name = "service_fee") Float serviceFee,
            @WebParam(name = "sender_name") String senderName,
            @WebParam(name = "sender_contact_number") String senderContactNumber,
            @WebParam(name = "receiver_name") String receiverName,
            @WebParam(name = "receiver_contact_number") String receiverContactNumber,
            @WebParam(name = "amount") Float amount) {
        TransactionQueries insertNewTransaction = new TransactionQueries();
        insertNewTransaction.setServiceFee(serviceFee);
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
                str[1] = transaction.getFeeStatus();
                str[2] = String.valueOf(transaction.getServiceFee());
                str[3] = transaction.getSenderName();
                str[4] = transaction.getSenderContactNumber();
                str[5] = transaction.getReceiverName();
                str[6] = transaction.getReceiverContactNumber();
                str[7] = String.valueOf(transaction.getAmount());
                str[8] = String.valueOf(transaction.getSenderEmployee());
                str[9] = String.valueOf(transaction.getReceiverEmployee());
                str[10] = String.valueOf(transaction.getBranchSent());
                str[11] = String.valueOf(transaction.getBranchWithdrawn());
                Timestamp dateSent = transaction.getDateSent();
                Timestamp dateWithdrawn = transaction.getDateWithdrawn();
                str[12] = (dateSent != null) ? dateFormat.format(dateSent.toLocalDateTime()) : "";
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
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy h:mm a");
        if (transaction != null) {
            String[] str = new String[14];
            str[0] = String.valueOf(transaction.getControlNumber());
            str[1] = transaction.getFeeStatus();
            str[2] = String.valueOf(transaction.getServiceFee());
            str[3] = transaction.getSenderName();
            str[4] = transaction.getSenderContactNumber();
            str[5] = transaction.getReceiverName();
            str[6] = transaction.getReceiverContactNumber();
            str[7] = String.valueOf(transaction.getAmount());
            str[8] = String.valueOf(transaction.getSenderEmployee());
            str[9] = String.valueOf(transaction.getReceiverEmployee());
            str[10] = String.valueOf(transaction.getBranchSent());
            str[11] = String.valueOf(transaction.getBranchWithdrawn());
            Timestamp dateSent = transaction.getDateSent();
            Timestamp dateWithdrawn = transaction.getDateWithdrawn();
            str[12] = (dateSent != null) ? dateFormat.format(dateSent.toLocalDateTime()) : "";
            str[13] = (dateWithdrawn != null) ? dateFormat.format(dateWithdrawn.toLocalDateTime()) : "";
            return str;
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "payServiceFee")
    public boolean payServiceFee(int controlNumber) {
        TransactionQueries payServiceFee = new TransactionQueries();
        return payServiceFee.payServiceFee_Query(controlNumber);
    }

    @WebMethod(operationName = "sendAmount")
    public boolean sendAmount(int controlNumber,
            @WebParam(name = "sender_employee") Integer senderEmployee,
            @WebParam(name = "branch_sent") Integer branchSent) {
        TransactionQueries sendAmount = new TransactionQueries();
        sendAmount.setSenderEmployee(senderEmployee);
        sendAmount.setBranchSent(branchSent);
        return sendAmount.sendAmount_Query(controlNumber);
    }

    @WebMethod(operationName = "withdrawAmount")
    public boolean withdrawAmount(int controlNumber,
            @WebParam(name = "receiver_employee") Integer receiverEmployee,
            @WebParam(name = "branch_withdrawn") Integer branchWithdrawn) {
        TransactionQueries withdrawAmount = new TransactionQueries();
        withdrawAmount.setReceiverEmployee(receiverEmployee);
        withdrawAmount.setBranchWithdrawn(branchWithdrawn);
        return withdrawAmount.withdrawAmount_Query(controlNumber);
    }

    @WebMethod(operationName = "deleteTransaction")
    public boolean deleteTransaction(int controlNumber) {
        TransactionQueries deleteTransaction = new TransactionQueries();
        return deleteTransaction.deleteTransaction_Query(controlNumber);
    }
}