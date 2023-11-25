package web_services;

import query_operations.*;
import java.util.*;
import javax.jws.*;

@WebService(serviceName = "BranchWebServices")
public class BranchWebServices {

    @WebMethod(operationName = "insertNewBranch")
    public void insertNewBranch(
            @WebParam(name = "branch_name") String branchName,
            @WebParam(name = "address") String address) {
        BranchQueries insertNewBranch = new BranchQueries();
        insertNewBranch.setBranchName(branchName);
        insertNewBranch.setAddress(address);
        insertNewBranch.insertNewBranch_Query();
    }

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

    @WebMethod(operationName = "deleteBranch")
    public boolean deleteBranch(int branchId) {
        BranchQueries deleteBranch = new BranchQueries();
        return deleteBranch.deleteBranch_Query(branchId);
    }
}