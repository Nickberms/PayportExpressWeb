package web_services;

import query_operations.*;
import java.util.*;
import javax.jws.*;

/**
 * The {@code BranchWebServices} class provides SOAP web services for
 * branch-related operations. This class exposes methods for creating,
 * retrieving, updating, and deleting branch information.
 *
 * @author Kein Bermejo
 */
@WebService(serviceName = "BranchWebServices")
public class BranchWebServices {

    /**
     * Web service operation for inserting a new branch into the database. Takes
     * various branch details as parameters and creates a new branch record.
     *
     * @param branchName The branch name of the branch.
     * @param address The address of the branch.
     */
    @WebMethod(operationName = "insertNewBranch")
    public void insertNewBranch(
            @WebParam(name = "branch_name") String branchName,
            @WebParam(name = "address") String address) {
        BranchQueries insertNewBranch = new BranchQueries();
        insertNewBranch.setBranchName(branchName);
        insertNewBranch.setAddress(address);
        insertNewBranch.insertNewBranch_Query();
    }

    /**
     * Web service operation for retrieving all branches from the database.
     * Returns an array list of string arrays, each representing a branch's
     * details.
     *
     * @return An ArrayList of String arrays, each array containing branch
     * details.
     */
    @WebMethod(operationName = "selectAllBranches")
    public ArrayList<String[]> selectAllBranches() {
        ArrayList<String[]> branchStr = new ArrayList<>();
        BranchQueries selectAllBranches = new BranchQueries();
        List<BranchQueries> branches = selectAllBranches.selectAllBranches_Query();
        if (branches != null) {
            branches.forEach((branch) -> {
                String[] str = new String[4];
                str[0] = String.valueOf(branch.getBranchId());
                str[1] = branch.getOperationStatus();
                str[2] = branch.getBranchName();
                str[3] = branch.getAddress();
                branchStr.add(str);
            });
        }
        return branchStr;
    }

    /**
     * Web service operation for retrieving details of a specific branch based
     * on its branch ID. Returns a string array containing the details of the
     * specified branch if found.
     *
     * @param branchId The branch ID of the branch to retrieve.
     * @return A String array containing the branch details, or null if not
     * found.
     */
    @WebMethod(operationName = "selectBranch")
    public String[] selectBranch(@WebParam(name = "branch_id") int branchId) {
        BranchQueries selectBranch = new BranchQueries();
        BranchQueries branch = selectBranch.selectBranch_Query(branchId);
        if (branch != null) {
            String[] str = new String[4];
            str[0] = String.valueOf(branch.getBranchId());
            str[1] = branch.getOperationStatus();
            str[2] = branch.getBranchName();
            str[3] = branch.getAddress();
            return str;
        } else {
            return null;
        }
    }

    /**
     * Web service operation for updating a branch's details in the database
     * based on its branch ID. Takes various parameters to update the branch's
     * record.
     *
     * @param branchId The branch ID of the branch to update.
     * @param operationStatus The updated operation status of the branch.
     * @param branchName The updated branch name of the branch.
     * @param address The updated address of the branch.
     * @return true if the update was successful, false otherwise.
     */
    @WebMethod(operationName = "updateBranch")
    public boolean updateBranch(int branchId,
            @WebParam(name = "operation_status") String operationStatus,
            @WebParam(name = "branch_name") String branchName,
            @WebParam(name = "address") String address) {
        BranchQueries updateBranch = new BranchQueries();
        updateBranch.setOperationStatus(operationStatus);
        updateBranch.setBranchName(branchName);
        updateBranch.setAddress(address);
        return updateBranch.updateBranch_Query(branchId);
    }

    /**
     * Web service operation for deleting a branch from the database based on
     * its branch ID.
     *
     * @param branchId The branch ID of the branch to delete.
     * @return true if the deletion was successful, false otherwise.
     */
    @WebMethod(operationName = "deleteBranch")
    public boolean deleteBranch(int branchId) {
        BranchQueries deleteBranch = new BranchQueries();
        return deleteBranch.deleteBranch_Query(branchId);
    }
}