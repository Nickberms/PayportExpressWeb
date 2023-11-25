package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

public class TransactionQueries extends DatabaseConnection {

    private Integer control_number;
    private String verification_status;
    private String sender_name;
    private String sender_contact_number;
    private String receiver_name;
    private String receiver_contact_number;
    private String amount;
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

    public TransactionQueries() {
    }

    public TransactionQueries(
            Integer control_number,
            String verification_status,
            String sender_name,
            String sender_contact_number,
            String receiver_name,
            String receiver_contact_number,
            String amount,
            Integer sender_employee,
            Integer receiver_employee,
            Integer branch_sent,
            Integer branch_withdrawn,
            Timestamp date_sent,
            String withdrawal_status,
            Timestamp date_withdrawn,
            Timestamp date_created,
            Timestamp date_modified) {
        this.control_number = control_number;
        this.verification_status = verification_status;
        this.sender_name = sender_name;
        this.sender_contact_number = sender_contact_number;
        this.receiver_name = receiver_name;
        this.receiver_contact_number = receiver_contact_number;
        this.amount = amount;
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

    public Integer getControlNumber() {
        return control_number;
    }

    public void setControlNumber(Integer control_number) {
        this.control_number = control_number;
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

    public void insertNewTransaction_Query() {
        String notVerifiedStatus = "Not Verified";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO `transactions` "
                    + "(`verification_status`, "
                    + "`sender_name`, "
                    + "`sender_contact_number`, "
                    + "`receiver_name`, "
                    + "`receiver_contact_number`, "
                    + "`amount`, "
                    + "`date_created`, "
                    + "`date_modified`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW());")) {
                statement.setString(1, notVerifiedStatus);
                statement.setString(2, sender_name);
                statement.setString(3, sender_contact_number);
                statement.setString(4, receiver_name);
                statement.setString(5, receiver_contact_number);
                statement.setString(6, amount);
                statement.execute();
                statement.close();
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
    }

    public List<TransactionQueries> selectAllTransactions_Query() {
        List<TransactionQueries> transactions = new ArrayList<>();
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `control_number`, "
                    + "`verification_status`, "
                    + "`sender_name`, "
                    + "`sender_contact_number`, "
                    + "`receiver_name`, "
                    + "`receiver_contact_number`, "
                    + "`amount`, "
                    + "`sender_employee`, "
                    + "`receiver_employee`, "
                    + "`branch_sent`, "
                    + "`branch_withdrawn`, "
                    + "`date_sent`, "
                    + "`withdrawal_status`, "
                    + "`date_withdrawn` "
                    + "FROM `transactions`;"); ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    TransactionQueries transaction = new TransactionQueries();
                    transaction.setControlNumber(result.getInt("control_number"));
                    transaction.setVerificationStatus(result.getString("verification_status"));
                    transaction.setSenderName(result.getString("sender_name"));
                    transaction.setSenderContactNumber(result.getString("sender_contact_number"));
                    transaction.setReceiverName(result.getString("receiver_name"));
                    transaction.setReceiverContactNumber(result.getString("receiver_contact_number"));
                    transaction.setAmount(result.getString("amount"));
                    transaction.setSenderEmployee(result.getInt("sender_employee"));
                    transaction.setReceiverEmployee(result.getInt("receiver_employee"));
                    transaction.setBranchSent(result.getInt("branch_sent"));
                    transaction.setBranchWithdrawn(result.getInt("branch_withdrawn"));
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

    public TransactionQueries selectTransaction_Query(int controlNumber) {
        TransactionQueries transaction = null;
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `control_number`, "
                    + "`verification_status`, "
                    + "`sender_name`, "
                    + "`sender_contact_number`, "
                    + "`receiver_name`, "
                    + "`receiver_contact_number`, "
                    + "`amount`, "
                    + "`sender_employee`, "
                    + "`receiver_employee`, "
                    + "`branch_sent`, "
                    + "`branch_withdrawn`, "
                    + "`date_sent`, "
                    + "`withdrawal_status`, "
                    + "`date_withdrawn` "
                    + "FROM `transactions` WHERE `control_number` = ?;")) {
                statement.setInt(1, controlNumber);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        transaction = new TransactionQueries();
                        transaction.setControlNumber(result.getInt("control_number"));
                        transaction.setVerificationStatus(result.getString("verification_status"));
                        transaction.setSenderName(result.getString("sender_name"));
                        transaction.setSenderContactNumber(result.getString("sender_contact_number"));
                        transaction.setReceiverName(result.getString("receiver_name"));
                        transaction.setReceiverContactNumber(result.getString("receiver_contact_number"));
                        transaction.setAmount(result.getString("amount"));
                        transaction.setSenderEmployee(result.getInt("sender_employee"));
                        transaction.setReceiverEmployee(result.getInt("receiver_employee"));
                        transaction.setBranchSent(result.getInt("branch_sent"));
                        transaction.setBranchWithdrawn(result.getInt("branch_withdrawn"));
                        transaction.setDateSent(result.getTimestamp("date_sent"));
                        transaction.setWithdrawalStatus(result.getString("withdrawal_status"));
                        transaction.setDateWithdrawn(result.getTimestamp("date_withdrawn"));
                    }
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return transaction;
    }

    public boolean verifyTransaction_Query(int controlNumber) {
        String verifiedStatus = "Verified";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `transactions` SET "
                    + "`verification_status` = ?, "
                    + "`date_modified` = NOW() "
                    + "WHERE `control_number` = ?;")) {
                statement.setString(1, verifiedStatus);
                statement.setInt(2, controlNumber);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

    public boolean sendMoney_Query(int controlNumber) {
        String notWithdrawnStatus = "Not Withdrawn";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `transactions` SET "
                    + "`sender_employee` = ?, "
                    + "`branch_sent` = ?, "
                    + "`date_sent` = NOW(), "
                    + "`withdrawal_status` = ?, "
                    + "`date_modified` = NOW() "
                    + "WHERE `control_number` = ?;")) {
                statement.setInt(1, sender_employee);
                statement.setInt(2, branch_sent);
                statement.setString(3, notWithdrawnStatus);
                statement.setInt(4, controlNumber);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

    public boolean withdrawMoney_Query(int controlNumber) {
        String withdrawnStatus = "Withdrawn";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `transactions` SET "
                    + "`receiver_employee` = ?, "
                    + "`branch_withdrawn` = ?, "
                    + "`withdrawal_status` = ?, "
                    + "`date_withdrawn` = NOW(), "
                    + "`date_modified` = NOW() "
                    + "WHERE `control_number` = ?;")) {
                statement.setInt(1, receiver_employee);
                statement.setInt(2, branch_withdrawn);
                statement.setString(3, withdrawnStatus);
                statement.setInt(4, controlNumber);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

    public boolean removeTransaction_Query(int controlNumber) {
        String removedStatus = "Removed";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `transactions` SET "
                    + "`verification_status` = ?, "
                    + "`date_modified` = NOW() "
                    + "WHERE `control_number` = ?;")) {
                statement.setString(1, removedStatus);
                statement.setInt(2, controlNumber);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }
}