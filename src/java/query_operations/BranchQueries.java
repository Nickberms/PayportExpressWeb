package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

/**
 * The {@code BranchQueries} class handles query operations for branch-related
 * data. This class extends the {@code DatabaseConnection} class to utilize
 * database connection capabilities. It encapsulates information about branches
 * and provides methods to interact with the database.
 *
 * @author Kein Bermejo
 */
public class BranchQueries extends DatabaseConnection {

    private Integer branch_id;
    private String operation_status;
    private String branch_name;
    private String address;
    private Timestamp date_created;
    private Timestamp date_modified;
    private Collection<BranchQueries> connectionData;

    /**
     * Default constructor for creating an instance of BranchQueries.
     */
    public BranchQueries() {
    }

    /**
     * Constructs an instance of BranchQueries with initial values for branch
     * details.
     *
     * @param branch_id Unique identifier for the branch.
     * @param operation_status Operational status of the branch.
     * @param branch_name Name of the branch.
     * @param address Address of the branch.
     * @param date_created Timestamp when the branch was created.
     * @param date_modified Timestamp when the branch was last modified.
     */
    public BranchQueries(
            Integer branch_id,
            String operation_status,
            String branch_name,
            String address,
            Timestamp date_created,
            Timestamp date_modified) {
        this.branch_id = branch_id;
        this.operation_status = operation_status;
        this.branch_name = branch_name;
        this.address = address;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    /**
     * Gets the branch's unique identifier.
     *
     * @return The branch ID.
     */
    public Integer getBranchId() {
        return branch_id;
    }

    /**
     * Sets the branch's unique identifier.
     *
     * @param branch_id The new ID to set for the branch.
     */
    public void setBranchId(Integer branch_id) {
        this.branch_id = branch_id;
    }

    /**
     * Gets the operational status of the branch.
     *
     * @return The operation status of the branch.
     */
    public String getOperationStatus() {
        return operation_status;
    }

    /**
     * Sets the operational status of the branch.
     *
     * @param operation_status The new operation status to set for the branch.
     */
    public void setOperationStatus(String operation_status) {
        this.operation_status = operation_status;
    }

    /**
     * Gets the name of the branch.
     *
     * @return The branch name.
     */
    public String getBranchName() {
        return branch_name;
    }

    /**
     * Sets the name of the branch.
     *
     * @param branch_name The new branch name to set.
     */
    public void setBranchName(String branch_name) {
        this.branch_name = branch_name;
    }

    /**
     * Gets the address of the branch.
     *
     * @return The address of the branch.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the branch.
     *
     * @param address The new address to set for the branch.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the timestamp when the branch was created.
     *
     * @return The creation timestamp of the branch.
     */
    public Timestamp getDateCreated() {
        return date_created;
    }

    /**
     * Sets the timestamp when the branch was created.
     *
     * @param date_created The new creation timestamp to set for the branch.
     */
    public void setDateCreated(Timestamp date_created) {
        this.date_created = date_created;
    }

    /**
     * Gets the timestamp when the branch was last modified.
     *
     * @return The last modified timestamp of the branch.
     */
    public Timestamp getDateModified() {
        return date_modified;
    }

    /**
     * Sets the timestamp when the branch was last modified.
     *
     * @param date_modified The new modified timestamp to set for the branch.
     */
    public void setDateModified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    /**
     * Gets the collection of branch queries representing the connection data.
     *
     * @return The collection of connection data.
     */
    public Collection<BranchQueries> getConnectionData() {
        return connectionData;
    }

    /**
     * Sets the collection of branch queries representing the connection data.
     *
     * @param connectionData The new collection of connection data to set.
     */
    public void setConnectionData(Collection<BranchQueries> connectionData) {
        this.connectionData = connectionData;
    }

    /**
     * Inserts a new branch with the current instance's data into the database.
     * This method sets the branch's operation status to "Active" and uses the
     * current branch name and address. It automatically sets the creation and
     * modification timestamps to the current time.
     */
    public void insertNewBranch_Query() {
        String activeStatus = "Active";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO `branches` "
                    + "(`operation_status`, "
                    + "`branch_name`, "
                    + "`address`, "
                    + "`date_created`, "
                    + "`date_modified`) "
                    + "VALUES (?, ?, ?, NOW(), NOW());")) {
                statement.setString(1, activeStatus);
                statement.setString(2, branch_name);
                statement.setString(3, address);
                statement.execute();
                statement.close();
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
    }

    /**
     * Retrieves a list of all branches from the database. This method queries
     * the database for all branch records and returns them as a list of
     * {@code BranchQueries} objects.
     *
     * @return A list of {@code BranchQueries} objects representing all branches
     * in the database.
     */
    public List<BranchQueries> selectAllBranches_Query() {
        List<BranchQueries> branches = new ArrayList<>();
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `branch_id`, "
                    + "`operation_status`, "
                    + "`branch_name`, "
                    + "`address` "
                    + "FROM `branches`;"); ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    BranchQueries branch = new BranchQueries();
                    branch.setBranchId(result.getInt("branch_id"));
                    branch.setOperationStatus(result.getString("operation_status"));
                    branch.setBranchName(result.getString("branch_name"));
                    branch.setAddress(result.getString("address"));
                    branches.add(branch);
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return branches;
    }

    /**
     * Retrieves a specific branch from the database based on the given branch
     * ID. This method queries the database for a branch with the specified ID
     * and returns it as a {@code BranchQueries} object.
     *
     * @param branchId The ID of the branch to retrieve.
     * @return A {@code BranchQueries} object representing the requested branch,
     * or {@code null} if not found.
     */
    public BranchQueries selectBranch_Query(int branchId) {
        BranchQueries branch = null;
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `branch_id`, "
                    + "`operation_status`, "
                    + "`branch_name`, "
                    + "`address` "
                    + "FROM `branches` WHERE `branch_id` = ?;")) {
                statement.setInt(1, branchId);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        branch = new BranchQueries();
                        branch.setBranchId(result.getInt("branch_id"));
                        branch.setOperationStatus(result.getString("operation_status"));
                        branch.setBranchName(result.getString("branch_name"));
                        branch.setAddress(result.getString("address"));
                    }
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return branch;
    }

    /**
     * Updates an existing branch in the database with the current instance's
     * data, based on the given branch ID. This method updates the operation
     * status, branch name, and address of the specified branch. It
     * automatically sets the modification timestamp to the current time.
     *
     * @param branchId The ID of the branch to update.
     * @return {@code true} if the update was successful, {@code false}
     * otherwise.
     */
    public boolean updateBranch_Query(int branchId) {
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `branches` SET "
                    + "`operation_status` = ?, "
                    + "`branch_name` = ?, "
                    + "`address` = ?, "
                    + "`date_modified` = NOW() "
                    + "WHERE `branch_id` = ?;")) {
                statement.setString(1, operation_status);
                statement.setString(2, branch_name);
                statement.setString(3, address);
                statement.setInt(4, branchId);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

    /**
     * Deletes a branch from the database based on the given branch ID. This
     * method removes the branch record with the specified ID from the database.
     *
     * @param branchId The ID of the branch to delete.
     * @return {@code true} if the deletion was successful, {@code false}
     * otherwise.
     */
    public boolean deleteBranch_Query(int branchId) {
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM `branches` WHERE `branch_id` = ?;")) {
                statement.setInt(1, branchId);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }
}