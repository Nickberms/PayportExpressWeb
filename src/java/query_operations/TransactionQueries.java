package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

/**
 * The {@code TransactionQueries} class handles query operations for
 * transaction-related data. This class extends the {@code DatabaseConnection}
 * class to utilize database connection capabilities. It encapsulates
 * information about transactions and provides methods to interact with the
 * database.
 *
 * @author Kein Bermejo
 */
public class TransactionQueries extends DatabaseConnection {

    private Integer control_number;
    private String fee_status;
    private Float service_fee;
    private String sender_name;
    private String sender_contact_number;
    private String receiver_name;
    private String receiver_contact_number;
    private Float amount;
    private Integer sender_employee;
    private Integer receiver_employee;
    private Integer branch_sent;
    private Integer branch_withdrawn;
    private Timestamp date_sent;
    private Timestamp date_withdrawn;
    private Timestamp date_created;
    private Timestamp date_modified;
    private Collection<TransactionQueries> connectionData;

    /**
     * Default constructor for creating an instance of TransactionQueries.
     */
    public TransactionQueries() {
    }

    /**
     * Constructs an instance of TransactionQueries with initial values for
     * transaction details.
     *
     * @param control_number Unique identifier for the transaction record.
     * @param fee_status Fee status of the transaction.
     * @param service_fee Service fee associated with the transaction.
     * @param sender_name Name of the sender client in the transaction.
     * @param sender_contact_number Contact number of the sender client.
     * @param receiver_name Name of the receiver client in the transaction.
     * @param receiver_contact_number Contact number of the receiver client.
     * @param amount Amount of money being transacted.
     * @param sender_employee Employee ID of the sender employee.
     * @param receiver_employee Employee ID of the receiver employee.
     * @param branch_sent Branch ID where the transaction was sent.
     * @param branch_withdrawn Branch ID where the transaction was withdrawn.
     * @param date_sent Timestamp when the transaction was sent.
     * @param date_withdrawn Timestamp when the transaction was withdrawn.
     * @param date_created Timestamp when the transaction record was created.
     * @param date_modified Timestamp when the transaction record was last
     * modified.
     */
    public TransactionQueries(
            Integer control_number,
            String fee_status,
            Float service_fee,
            String sender_name,
            String sender_contact_number,
            String receiver_name,
            String receiver_contact_number,
            Float amount,
            Integer sender_employee,
            Integer receiver_employee,
            Integer branch_sent,
            Integer branch_withdrawn,
            Timestamp date_sent,
            Timestamp date_withdrawn,
            Timestamp date_created,
            Timestamp date_modified) {
        this.control_number = control_number;
        this.fee_status = fee_status;
        this.service_fee = service_fee;
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
        this.date_withdrawn = date_withdrawn;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    /**
     * Gets the control number of the transaction.
     *
     * @return The control number of the transaction.
     */
    public Integer getControlNumber() {
        return control_number;
    }

    /**
     * Sets the control number of the transaction.
     *
     * @param control_number The control number to set for the transaction.
     */
    public void setControlNumber(Integer control_number) {
        this.control_number = control_number;
    }

    /**
     * Gets the fee status of the transaction.
     *
     * @return The fee status of the transaction.
     */
    public String getFeeStatus() {
        return fee_status;
    }

    /**
     * Sets the fee status of the transaction.
     *
     * @param fee_status The fee status to set for the transaction.
     */
    public void setFeeStatus(String fee_status) {
        this.fee_status = fee_status;
    }

    /**
     * Gets the service fee of the transaction.
     *
     * @return The service fee of the transaction.
     */
    public Float getServiceFee() {
        return service_fee;
    }

    /**
     * Sets the service fee of the transaction.
     *
     * @param service_fee The service fee to set for the transaction.
     */
    public void setServiceFee(Float service_fee) {
        this.service_fee = service_fee;
    }

    /**
     * Gets the name of the sender client in the transaction.
     *
     * @return The name of the sender client in the transaction.
     */
    public String getSenderName() {
        return sender_name;
    }

    /**
     * Sets the name of the sender client in the transaction.
     *
     * @param sender_name The name of the sender client to set for the
     * transaction.
     */
    public void setSenderName(String sender_name) {
        this.sender_name = sender_name;
    }

    /**
     * Gets the contact number of the sender client in the transaction.
     *
     * @return The contact number of the sender client in the transaction.
     */
    public String getSenderContactNumber() {
        return sender_contact_number;
    }

    /**
     * Sets the contact number of the sender client in the transaction.
     *
     * @param sender_contact_number The contact number of the sender client to
     * set for the transaction.
     */
    public void setSenderContactNumber(String sender_contact_number) {
        this.sender_contact_number = sender_contact_number;
    }

    /**
     * Gets the name of the receiver client in the transaction.
     *
     * @return The name of the receiver client in the transaction.
     */
    public String getReceiverName() {
        return receiver_name;
    }

    /**
     * Sets the name of the receiver client in the transaction.
     *
     * @param receiver_name The name of the receiver client to set for the
     * transaction.
     */
    public void setReceiverName(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    /**
     * Gets the contact number of the receiver client in the transaction.
     *
     * @return The contact number of the receiver client in the transaction.
     */
    public String getReceiverContactNumber() {
        return receiver_contact_number;
    }

    /**
     * Sets the contact number of the receiver client in the transaction.
     *
     * @param receiver_contact_number The contact number of the receiver client
     * to set for the transaction.
     */
    public void setReceiverContactNumber(String receiver_contact_number) {
        this.receiver_contact_number = receiver_contact_number;
    }

    /**
     * Gets the amount of the transaction.
     *
     * @return The amount of the transaction.
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the transaction.
     *
     * @param amount The amount to set for the transaction.
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * Gets the employee ID of the sender employee in the transaction.
     *
     * @return The employee ID of the sender employee in the transaction.
     */
    public Integer getSenderEmployee() {
        return sender_employee;
    }

    /**
     * Sets the employee ID of the sender employee in the transaction.
     *
     * @param sender_employee The employee ID of the sender employee to set for
     * the transaction.
     */
    public void setSenderEmployee(Integer sender_employee) {
        this.sender_employee = sender_employee;
    }

    /**
     * Gets the employee ID of the receiver employee in the transaction.
     *
     * @return The employee ID of the receiver employee in the transaction.
     */
    public Integer getReceiverEmployee() {
        return receiver_employee;
    }

    /**
     * Sets the employee ID of the receiver employee in the transaction.
     *
     * @param receiver_employee The employee ID of the receiver employee to set
     * for the transaction.
     */
    public void setReceiverEmployee(Integer receiver_employee) {
        this.receiver_employee = receiver_employee;
    }

    /**
     * Gets the branch ID where the transaction was sent.
     *
     * @return The branch ID where the transaction was sent.
     */
    public Integer getBranchSent() {
        return branch_sent;
    }

    /**
     * Sets the branch ID where the transaction was sent.
     *
     * @param branch_sent The branch ID to set for where the transaction was
     * sent.
     */
    public void setBranchSent(Integer branch_sent) {
        this.branch_sent = branch_sent;
    }

    /**
     * Gets the branch ID where the transaction was withdrawn.
     *
     * @return The branch ID where the transaction was withdrawn.
     */
    public Integer getBranchWithdrawn() {
        return branch_withdrawn;
    }

    /**
     * Sets the branch ID where the transaction was withdrawn.
     *
     * @param branch_withdrawn The branch ID to set for where the transaction
     * was withdrawn.
     */
    public void setBranchWithdrawn(Integer branch_withdrawn) {
        this.branch_withdrawn = branch_withdrawn;
    }

    /**
     * Gets the timestamp when the transaction was sent.
     *
     * @return The timestamp when the transaction was sent.
     */
    public Timestamp getDateSent() {
        return date_sent;
    }

    /**
     * Sets the timestamp when the transaction was sent.
     *
     * @param date_sent The timestamp to set for when the transaction was sent.
     */
    public void setDateSent(Timestamp date_sent) {
        this.date_sent = date_sent;
    }

    /**
     * Gets the timestamp when the transaction was withdrawn.
     *
     * @return The timestamp when the transaction was withdrawn.
     */
    public Timestamp getDateWithdrawn() {
        return date_withdrawn;
    }

    /**
     * Sets the timestamp when the transaction was withdrawn.
     *
     * @param date_withdrawn The timestamp to set for when the transaction was
     * withdrawn.
     */
    public void setDateWithdrawn(Timestamp date_withdrawn) {
        this.date_withdrawn = date_withdrawn;
    }

    /**
     * Gets the timestamp when the transaction record was created.
     *
     * @return The timestamp when the transaction record was created.
     */
    public Timestamp getDateCreated() {
        return date_created;
    }

    /**
     * Sets the timestamp when the transaction record was created.
     *
     * @param date_created The timestamp to set for when the transaction record
     * was created.
     */
    public void setDateCreated(Timestamp date_created) {
        this.date_created = date_created;
    }

    /**
     * Gets the timestamp when the transaction record was last modified.
     *
     * @return The timestamp when the transaction record was last modified.
     */
    public Timestamp getDateModified() {
        return date_modified;
    }

    /**
     * Sets the timestamp when the transaction record was last modified.
     *
     * @param date_modified The timestamp to set for when the transaction record
     * was last modified.
     */
    public void setDateModified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    /**
     * Gets the collection of transaction queries representing the connection
     * data.
     *
     * @return The collection of connection data.
     */
    public Collection<TransactionQueries> getConnectionData() {
        return connectionData;
    }

    /**
     * Sets the collection of transaction queries representing the connection
     * data.
     *
     * @param connectionData The new collection of connection data to set.
     */
    public void setConnectionData(Collection<TransactionQueries> connectionData) {
        this.connectionData = connectionData;
    }

    /**
     * Inserts a new transaction into the database using the current instance's
     * data. The transaction's fee status is set to "Unpaid" by default. This
     * method also sets the creation and modification timestamps to the current
     * time.
     */
    public void insertNewTransaction_Query() {
        String unpaidStatus = "Unpaid";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO `transactions` "
                    + "(`fee_status`, "
                    + "`service_fee`, "
                    + "`sender_name`, "
                    + "`sender_contact_number`, "
                    + "`receiver_name`, "
                    + "`receiver_contact_number`, "
                    + "`amount`, "
                    + "`date_created`, "
                    + "`date_modified`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW());")) {
                statement.setString(1, unpaidStatus);
                statement.setFloat(2, service_fee);
                statement.setString(3, sender_name);
                statement.setString(4, sender_contact_number);
                statement.setString(5, receiver_name);
                statement.setString(6, receiver_contact_number);
                statement.setFloat(7, amount);
                statement.execute();
                statement.close();
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
    }

    /**
     * Retrieves a list of all transactions from the database. Each transaction
     * is represented as a {@code TransactionQueries} object containing its
     * details.
     *
     * @return A list of {@code TransactionQueries} objects, each representing a
     * transaction.
     */
    public List<TransactionQueries> selectAllTransactions_Query() {
        List<TransactionQueries> transactions = new ArrayList<>();
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `control_number`, "
                    + "`fee_status`, "
                    + "`service_fee`, "
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
                    + "`date_withdrawn` "
                    + "FROM `transactions`;"); ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    TransactionQueries transaction = new TransactionQueries();
                    transaction.setControlNumber(result.getInt("control_number"));
                    transaction.setFeeStatus(result.getString("fee_status"));
                    transaction.setServiceFee(result.getFloat("service_fee"));
                    transaction.setSenderName(result.getString("sender_name"));
                    transaction.setSenderContactNumber(result.getString("sender_contact_number"));
                    transaction.setReceiverName(result.getString("receiver_name"));
                    transaction.setReceiverContactNumber(result.getString("receiver_contact_number"));
                    transaction.setAmount(result.getFloat("amount"));
                    transaction.setSenderEmployee(result.getInt("sender_employee"));
                    transaction.setReceiverEmployee(result.getInt("receiver_employee"));
                    transaction.setBranchSent(result.getInt("branch_sent"));
                    transaction.setBranchWithdrawn(result.getInt("branch_withdrawn"));
                    transaction.setDateSent(result.getTimestamp("date_sent"));
                    transaction.setDateWithdrawn(result.getTimestamp("date_withdrawn"));
                    transactions.add(transaction);
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return transactions;
    }

    /**
     * Retrieves a specific transaction from the database based on the given
     * control number. The method returns a {@code TransactionQueries} object
     * representing the transaction if found.
     *
     * @param controlNumber The control number of the transaction to retrieve.
     * @return A {@code TransactionQueries} object representing the requested
     * transaction, or {@code null} if not found.
     */
    public TransactionQueries selectTransaction_Query(int controlNumber) {
        TransactionQueries transaction = null;
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `control_number`, "
                    + "`fee_status`, "
                    + "`service_fee`, "
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
                    + "`date_withdrawn` "
                    + "FROM `transactions` WHERE `control_number` = ?;")) {
                statement.setInt(1, controlNumber);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        transaction = new TransactionQueries();
                        transaction.setControlNumber(result.getInt("control_number"));
                        transaction.setFeeStatus(result.getString("fee_status"));
                        transaction.setServiceFee(result.getFloat("service_fee"));
                        transaction.setSenderName(result.getString("sender_name"));
                        transaction.setSenderContactNumber(result.getString("sender_contact_number"));
                        transaction.setReceiverName(result.getString("receiver_name"));
                        transaction.setReceiverContactNumber(result.getString("receiver_contact_number"));
                        transaction.setAmount(result.getFloat("amount"));
                        transaction.setSenderEmployee(result.getInt("sender_employee"));
                        transaction.setReceiverEmployee(result.getInt("receiver_employee"));
                        transaction.setBranchSent(result.getInt("branch_sent"));
                        transaction.setBranchWithdrawn(result.getInt("branch_withdrawn"));
                        transaction.setDateSent(result.getTimestamp("date_sent"));
                        transaction.setDateWithdrawn(result.getTimestamp("date_withdrawn"));
                    }
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return transaction;
    }

    /**
     * Updates the fee status of a transaction in the database to "Paid". This
     * method is used to mark a transaction's service fee as paid.
     *
     * @param controlNumber The control number of the transaction for which to
     * update the fee status.
     * @return {@code true} if the update was successful, {@code false}
     * otherwise.
     */
    public boolean payServiceFee_Query(int controlNumber) {
        String paidStatus = "Paid";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `transactions` SET "
                    + "`fee_status` = ?, "
                    + "`date_modified` = NOW() "
                    + "WHERE `control_number` = ?;")) {
                statement.setString(1, paidStatus);
                statement.setInt(2, controlNumber);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

    /**
     * Marks a transaction as sent in the database. This method updates the
     * sender employee, branch sent, and date sent for the transaction.
     *
     * @param controlNumber The control number of the transaction to mark as
     * sent.
     * @return {@code true} if the update was successful, {@code false}
     * otherwise.
     */
    public boolean sendAmount_Query(int controlNumber) {
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `transactions` SET "
                    + "`sender_employee` = ?, "
                    + "`branch_sent` = ?, "
                    + "`date_sent` = NOW(), "
                    + "`date_modified` = NOW() "
                    + "WHERE `control_number` = ?;")) {
                statement.setInt(1, sender_employee);
                statement.setInt(2, branch_sent);
                statement.setInt(3, controlNumber);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

    /**
     * Marks a transaction as withdrawn in the database. This method updates the
     * receiver employee, branch withdrawn, and date withdrawn for the
     * transaction.
     *
     * @param controlNumber The control number of the transaction to mark as
     * withdrawn.
     * @return {@code true} if the update was successful, {@code false}
     * otherwise.
     */
    public boolean withdrawAmount_Query(int controlNumber) {
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `transactions` SET "
                    + "`receiver_employee` = ?, "
                    + "`branch_withdrawn` = ?, "
                    + "`date_withdrawn` = NOW(), "
                    + "`date_modified` = NOW() "
                    + "WHERE `control_number` = ?;")) {
                statement.setInt(1, receiver_employee);
                statement.setInt(2, branch_withdrawn);
                statement.setInt(3, controlNumber);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

    /**
     * Deletes a transaction from the database based on the given control
     * number. This method removes the transaction record with the specified
     * control number from the database.
     *
     * @param controlNumber The control number of the transaction to delete.
     * @return {@code true} if the deletion was successful, {@code false}
     * otherwise.
     */
    public boolean deleteTransaction_Query(int controlNumber) {
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM `transactions` WHERE `control_number` = ?;")) {
                statement.setInt(1, controlNumber);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }
}