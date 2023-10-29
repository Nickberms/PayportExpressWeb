package web_services;

import query_operations.*;
import java.util.*;
import javax.jws.*;

@WebService(serviceName = "BranchWebServices")
public class BranchWebServices {

    @WebMethod(operationName = "insertNewBranch")
    public void insertNewBranch(
            @WebParam(name = "branch_name") String branch_name,
            @WebParam(name = "address") String address,
            @WebParam(name = "contact_information") String contact_information) {
        BranchQueries insertNewBranch = new BranchQueries();
        insertNewBranch.setBranchName(branch_name);
        insertNewBranch.setAddress(address);
        insertNewBranch.setContactInformation(contact_information);
        insertNewBranch.insertNewBranch();
    }

    @WebMethod(operationName = "selectAllBranches")
    public ArrayList<String[]> selectAllBranches() {
        ArrayList<String[]> branchStr = new ArrayList<>();
        BranchQueries selectAllBranches = new BranchQueries();
        List<BranchQueries> branches = selectAllBranches.selectAllBranches();
        if (branches != null) {
            branches.forEach((branch) -> {
                String[] str = new String[5];
                str[0] = String.valueOf(branch.getBranchId());
                str[1] = branch.getOperationStatus();
                str[2] = branch.getBranchName();
                str[3] = branch.getAddress();
                str[4] = branch.getContactInformation();
                branchStr.add(str);
            });
        }
        return branchStr;
    }

    @WebMethod(operationName = "deleteBranch")
    public boolean deleteBranch(int branchId) {
        BranchQueries deleteBranch = new BranchQueries();
        return deleteBranch.deleteBranch(branchId);
    }
}