package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

public class TransactionQueries extends DatabaseConnection {

    // Initializing variables
    private Integer transaction_id;
    private String verification_status;
    private String sender_name;
    private String sender_contact_number;
    private String receiver_name;
    private String receiver_contact_number;
    private String amount;
    private String control_number;
    private Integer sender_employee;
    private Integer receiver_employee;
    private Integer branch_sent;
    private Integer branch_withdrawn;
    private Timestamp date_sent;
    private String withdrawal_status;
    private Timestamp date_withdrawn;
    private Timestamp date_created;
    private Timestamp date_modified;
    private Collection<TransactionQueries> connectionData;

    // Default constructor
    public TransactionQueries() {
    }

    // Parameterized constructor
    public TransactionQueries(
            Integer transaction_id,
            String verification_status,
            String sender_name,
            String sender_contact_number,
            String receiver_name,
            String receiver_contact_number,
            String amount,
            String control_number,
            Integer sender_employee,
            Integer receiver_employee,
            Integer branch_sent,
            Integer branch_withdrawn,
            Timestamp date_sent,
            String withdrawal_status,
            Timestamp date_withdrawn,
            Timestamp date_created,
            Timestamp date_modified) {
        // Set values from constructor parameters
        this.transaction_id = transaction_id;
        this.verification_status = verification_status;
        this.sender_name = sender_name;
        this.sender_contact_number = sender_contact_number;
        this.receiver_name = receiver_name;
        this.receiver_contact_number = receiver_contact_number;
        this.amount = amount;
        this.control_number = control_number;
        this.sender_employee = sender_employee;
        this.receiver_employee = receiver_employee;
        this.branch_sent = branch_sent;
        this.branch_withdrawn = branch_withdrawn;
        this.date_sent = date_sent;
        this.withdrawal_status = withdrawal_status;
        this.date_withdrawn = date_withdrawn;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    // Getter and setter methods for each property
    public Integer getTransactionId() {
        return transaction_id;
    }

    public void setTransactionId(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getVerificationStatus() {
        return verification_status;
    }

    public void setVerificationStatus(String verification_status) {
        this.verification_status = verification_status;
    }

    public String getSenderName() {
        return sender_name;
    }

    public void setSenderName(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSenderContactNumber() {
        return sender_contact_number;
    }

    public void setSenderContactNumber(String sender_contact_number) {
        this.sender_contact_number = sender_contact_number;
    }

    public String getReceiverName() {
        return receiver_name;
    }

    public void setReceiverName(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiverContactNumber() {
        return receiver_contact_number;
    }

    public void setReceiverContactNumber(String receiver_contact_number) {
        this.receiver_contact_number = receiver_contact_number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getControlNumber() {
        return control_number;
    }

    public void setControlNumber(String control_number) {
        this.control_number = control_number;
    }

    public Integer getSenderEmployee() {
        return sender_employee;
    }

    public void setSenderEmployee(Integer sender_employee) {
        this.sender_employee = sender_employee;
    }

    public Integer getReceiverEmployee() {
        return receiver_employee;
    }

    public void setReceiverEmployee(Integer receiver_employee) {
        this.receiver_employee = receiver_employee;
    }

    public Integer getBranchSent() {
        return branch_sent;
    }

    public void setBranchSent(Integer branch_sent) {
        this.branch_sent = branch_sent;
    }

    public Integer getBranchWithdrawn() {
        return branch_withdrawn;
    }

    public void setBranchWithdrawn(Integer branch_withdrawn) {
        this.branch_withdrawn = branch_withdrawn;
    }

    public Timestamp getDateSent() {
        return date_sent;
    }

    public void setDateSent(Timestamp date_sent) {
        this.date_sent = date_sent;
    }

    public String getWithdrawalStatus() {
        return withdrawal_status;
    }

    public void setWithdrawalStatus(String withdrawal_status) {
        this.withdrawal_status = withdrawal_status;
    }

    public Timestamp getDateWithdrawn() {
        return date_withdrawn;
    }

    public void setDateWithdrawn(Timestamp date_withdrawn) {
        this.date_withdrawn = date_withdrawn;
    }

    public Timestamp getDateCreated() {
        return date_created;
    }

    public void setDateCreated(Timestamp date_created) {
        this.date_created = date_created;
    }

    public Timestamp getDateModified() {
        return date_modified;
    }

    public void setDateModified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    public Collection<TransactionQueries> getConnectionData() {
        return connectionData;
    }

    public void setConnectionData(Collection<TransactionQueries> connectionData) {
        this.connectionData = connectionData;
    }

    // Inserts a new transaction record into the database
    public void insertNewTransaction() {
        // Default values for various fields
        String default_verification_status_value = "Not Verified";
        String default_control_number_value = null;
        int default_sender_employee_value = 1;
        int default_receiver_employee_value = 1;
        int default_branch_sent_value = 1;
        int default_branch_withdrawn_value = 1;
        String default_withdrawal_status_value = null;
        try {
            // Establish a database connection
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO `transactions` "
                    + "(`verification_status`, "
                    + "`sender_name`, "
                    + "`sender_contact_number`, "
                    + "`receiver_name`, "
                    + "`receiver_contact_number`, "
                    + "`amount`, "
                    + "`control_number`, "
                    + "`sender_employee`, "
                    + "`receiver_employee`, "
                    + "`branch_sent`, "
                    + "`branch_withdrawn`, "
                    + "`date_sent`, "
                    + "`withdrawal_status`, "
                    + "`date_withdrawn`, "
                    + "`date_created`, "
                    + "`date_modified`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW());")) {
                // Set the values for the prepared statement
                statement.setString(1, default_verification_status_value);
                statement.setString(2, sender_name);
                statement.setString(3, sender_contact_number);
                statement.setString(4, receiver_name);
                statement.setString(5, receiver_contact_number);
                statement.setString(6, amount);
                statement.setString(7, default_control_number_value);
                statement.setInt(8, default_sender_employee_value);
                statement.setInt(9, default_receiver_employee_value);
                statement.setInt(10, default_branch_sent_value);
                statement.setInt(11, default_branch_withdrawn_value);
                if (date_sent != null) {
                    statement.setTimestamp(12, date_sent);
                } else {
                    statement.setNull(12, Types.TIMESTAMP);
                }
                statement.setString(13, default_withdrawal_status_value);
                if (date_withdrawn != null) {
                    statement.setTimestamp(14, date_withdrawn);
                } else {
                    statement.setNull(14, Types.TIMESTAMP);
                }
                // Execute the SQL statement
                statement.execute();
                statement.close();
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
    }

    // Selects all the transaction records in the database
    public List<TransactionQueries> selectAllTransactions() {
        // Create a new list to store instances
        List<TransactionQueries> transactions = new ArrayList<>();
        try {
            // Establish a database connection
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `transaction_id`, "
                    + "`verification_status`, "
                    + "`sender_name`, "
                    + "`sender_contact_number`, "
                    + "`receiver_name`, "
                    + "`receiver_contact_number`, "
                    + "`amount`, "
                    + "`control_number`, "
                    + "`sender_employee`, "
                    + "`receiver_employee`, "
                    + "`branch_sent`, "
                    + "`branch_withdrawn`, "
                    + "`date_sent`, "
                    + "`withdrawal_status`, "
                    + "`date_withdrawn` "
                    + "FROM `transactions`;"); ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    // Retrieve data from the result set
                    TransactionQueries transaction = new TransactionQueries();
                    transaction.setTransactionId(result.getInt("transaction_id"));
                    transaction.setVerificationStatus(result.getString("verification_status"));
                    transaction.setSenderName(result.getString("sender_name"));
                    transaction.setSenderContactNumber(result.getString("sender_contact_number"));
                    transaction.setReceiverName(result.getString("receiver_name"));
                    transaction.setReceiverContactNumber(result.getString("receiver_contact_number"));
                    transaction.setAmount(result.getString("amount"));
                    transaction.setControlNumber(result.getString("control_number"));
                    transaction.setSenderEmployee(result.getObject("sender_employee") != null ? result.getInt("sender_employee") : 0);
                    transaction.setReceiverEmployee(result.getObject("receiver_employee") != null ? result.getInt("receiver_employee") : 0);
                    transaction.setBranchSent(result.getObject("branch_sent") != null ? result.getInt("branch_sent") : 0);
                    transaction.setBranchWithdrawn(result.getObject("branch_withdrawn") != null ? result.getInt("branch_withdrawn") : 0);
                    transaction.setDateSent(result.getTimestamp("date_sent"));
                    transaction.setWithdrawalStatus(result.getString("withdrawal_status"));
                    transaction.setDateWithdrawn(result.getTimestamp("date_withdrawn"));
                    transactions.add(transaction);
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return transactions;
    }

    // Deletes a transaction record into the database
    public boolean deleteTransaction(int transactionId) {
        try {
            // Establish a database connection
            super.getConnectedToDatabaseHost();
            // Deleting a transaction by its primary key
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM `transactions` WHERE `transaction_id` = ?;")) {
                statement.setInt(1, transactionId);
                // Execute the SQL statement
                int rowsAffected = statement.executeUpdate();
                // Return true if rows were affected
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }
}