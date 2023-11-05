package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

public class BranchQueries extends DatabaseConnection {

    private Integer branch_id;
    private String operation_status;
    private String branch_name;
    private String address;
    private String contact_information;
    private Timestamp date_created;
    private Timestamp date_modified;
    private Collection<TransactionQueries> connectionData;

    public BranchQueries() {
    }

    public BranchQueries(
            Integer branch_id,
            String operation_status,
            String branch_name,
            String address,
            String contact_information,
            Timestamp date_created,
            Timestamp date_modified) {
        this.branch_id = branch_id;
        this.operation_status = operation_status;
        this.branch_name = branch_name;
        this.address = address;
        this.contact_information = contact_information;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    public Integer getBranchId() {
        return branch_id;
    }

    public void setBranchId(Integer branch_id) {
        this.branch_id = branch_id;
    }

    public String getOperationStatus() {
        return operation_status;
    }

    public void setOperationStatus(String operation_status) {
        this.operation_status = operation_status;
    }

    public String getBranchName() {
        return branch_name;
    }

    public void setBranchName(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contact_information;
    }

    public void setContactInformation(String contact_information) {
        this.contact_information = contact_information;
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

    public void insertNewBranch() {
        String default_operation_status_value = "Active";
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO `branches` "
                    + "(`operation_status`, "
                    + "`branch_name`, "
                    + "`address`, "
                    + "`contact_information`, "
                    + "`date_created`, "
                    + "`date_modified`) "
                    + "VALUES (?, ?, ?, ?, NOW(), NOW());")) {
                statement.setString(1, default_operation_status_value);
                statement.setString(2, branch_name);
                statement.setString(3, address);
                statement.setString(4, contact_information);
                statement.execute();
                statement.close();
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
    }

    public List<BranchQueries> selectAllBranches_Query() {
        List<BranchQueries> branches = new ArrayList<>();
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `branch_id`, "
                    + "`operation_status`, "
                    + "`branch_name`, "
                    + "`address`, "
                    + "`contact_information` "
                    + "FROM `branches`;"); ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    BranchQueries branch = new BranchQueries();
                    branch.setBranchId(result.getInt("branch_id"));
                    branch.setOperationStatus(result.getString("operation_status"));
                    branch.setBranchName(result.getString("branch_name"));
                    branch.setAddress(result.getString("address"));
                    branch.setContactInformation(result.getString("contact_information"));
                    branches.add(branch);
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return branches;
    }

    public BranchQueries selectBranch_Query(int branchId) {
        BranchQueries branch = null;
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("SELECT `branch_id`, "
                    + "`operation_status`, "
                    + "`branch_name`, "
                    + "`address`, "
                    + "`contact_information` "
                    + "FROM `branches` WHERE `branch_id` = ?;")) {
                statement.setInt(1, branchId);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        branch = new BranchQueries();
                        branch.setBranchId(result.getInt("branch_id"));
                        branch.setOperationStatus(result.getString("operation_status"));
                        branch.setBranchName(result.getString("branch_name"));
                        branch.setAddress(result.getString("address"));
                        branch.setContactInformation(result.getString("contact_information"));
                    }
                }
            }
        } catch (SQLException error) {
            System.err.println(error);
        }
        return branch;
    }

    public boolean updateBranch_Query(int branchId) {
        try {
            super.getConnectedToDatabaseHost();
            try (PreparedStatement statement = connection.prepareStatement("UPDATE `branches` SET "
                    + "`operation_status` = ?, "
                    + "`branch_name` = ?, "
                    + "`address` = ?, "
                    + "`contact_information` = ?, "
                    + "`date_modified` = NOW() "
                    + "WHERE `branch_id` = ?;")) {
                statement.setString(1, operation_status);
                statement.setString(2, branch_name);
                statement.setString(3, address);
                statement.setString(4, contact_information);
                statement.setInt(5, branchId);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }

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