package web_services;

import query_operations.*;
import java.sql.*;
import java.time.format.*;
import java.util.*;
import javax.jws.*;

/**
 * The {@code TransactionWebServices} class provides SOAP web services for
 * transaction-related operations. This class exposes methods for creating,
 * retrieving, updating, and deleting transaction information.
 *
 * @author Kein Bermejo
 */
@WebService(serviceName = "TransactionWebServices")
public class TransactionWebServices {

    /**
     * Web service operation for inserting a new transaction into the database.
     * Takes various transaction details as parameters and creates a new
     * transaction record.
     *
     * @param serviceFee The service fee associated with the transaction.
     * @param senderName The name of the sender client in the transaction.
     * @param senderContactNumber The contact number of the sender client.
     * @param receiverName The name of the receiver client in the transaction.
     * @param receiverContactNumber The contact number of the receiver client.
     * @param amount The amount of money being transacted.
     */
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

    /**
     * Web service operation for retrieving all transactions from the database.
     * Returns an array list of string arrays, each representing a transaction's
     * details.
     *
     * @return An ArrayList of String arrays, each array containing transaction
     * details.
     */
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

    /**
     * Web service operation for retrieving details of a specific transaction
     * based on its control number. Returns a string array containing the
     * details of the specified transaction if found.
     *
     * @param controlNumber The control number of the transaction to retrieve.
     * @return A String array containing the transaction details, or null if not
     * found.
     */
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

    /**
     * Web service operation for marking a transaction's service fee as paid in
     * the database.
     *
     * @param controlNumber The control number of the transaction for which to
     * update the fee status.
     * @return true if the update was successful, false otherwise.
     */
    @WebMethod(operationName = "payServiceFee")
    public boolean payServiceFee(int controlNumber) {
        TransactionQueries payServiceFee = new TransactionQueries();
        return payServiceFee.payServiceFee_Query(controlNumber);
    }

    /**
     * Web service operation for marking a transaction as sent in the database.
     * This method updates the sender employee and branch sent for the
     * transaction.
     *
     * @param controlNumber The control number of the transaction to mark as
     * sent.
     * @param senderEmployee The employee ID of the sender employee in the transaction.
     * @param branchSent The branch ID where the transaction was sent.
     * @return true if the update was successful, false otherwise.
     */
    @WebMethod(operationName = "sendAmount")
    public boolean sendAmount(int controlNumber,
            @WebParam(name = "sender_employee") Integer senderEmployee,
            @WebParam(name = "branch_sent") Integer branchSent) {
        TransactionQueries sendAmount = new TransactionQueries();
        sendAmount.setSenderEmployee(senderEmployee);
        sendAmount.setBranchSent(branchSent);
        return sendAmount.sendAmount_Query(controlNumber);
    }

    /**
     * Web service operation for marking a transaction as withdrawn in the
     * database. This method updates the receiver employee and branch withdrawn
     * for the transaction.
     *
     * @param controlNumber The control number of the transaction to mark as
     * withdrawn.
     * @param receiverEmployee The employee ID of the receiver employee in the
     * transaction.
     * @param branchWithdrawn The branch ID where the transaction was withdrawn.
     * @return true if the update was successful, false otherwise.
     */
    @WebMethod(operationName = "withdrawAmount")
    public boolean withdrawAmount(int controlNumber,
            @WebParam(name = "receiver_employee") Integer receiverEmployee,
            @WebParam(name = "branch_withdrawn") Integer branchWithdrawn) {
        TransactionQueries withdrawAmount = new TransactionQueries();
        withdrawAmount.setReceiverEmployee(receiverEmployee);
        withdrawAmount.setBranchWithdrawn(branchWithdrawn);
        return withdrawAmount.withdrawAmount_Query(controlNumber);
    }

    /**
     * Web service operation for deleting a transaction from the database based
     * on its control number.
     *
     * @param controlNumber The control number of the transaction to delete.
     * @return true if the deletion was successful, false otherwise.
     */
    @WebMethod(operationName = "deleteTransaction")
    public boolean deleteTransaction(int controlNumber) {
        TransactionQueries deleteTransaction = new TransactionQueries();
        return deleteTransaction.deleteTransaction_Query(controlNumber);
    }
}