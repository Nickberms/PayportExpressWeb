package tester_package;

import web_services.*;
import java.io.*;

public class UpdateTransaction {

    // Main method to test the web service in the console
    public static void main(String[] args) {
        // Create and call the web service
        TransactionWebServices service = new TransactionWebServices();
        // Prompt the user for a transaction ID to update
        int transactionId;
        try {
            System.out.print("Enter the Transaction ID to Update: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            transactionId = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException error) {
            System.err.println(error);
            return;
        }
        // Collect data for transaction update
        String verificationStatus, senderName, senderContactNumber, receiverName, receiverContactNumber;
        String amount, controlNumber, withdrawalStatus;
        Integer senderEmployee, receiverEmployee, branchSent, branchWithdrawn;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("Enter Updated Details");
            System.out.println("--------------------------------------------------");
            System.out.println();
            System.out.print("Verification Status: ");
            verificationStatus = br.readLine();
            System.out.print("Sender Name: ");
            senderName = br.readLine();
            System.out.print("Sender Contact Number: ");
            senderContactNumber = br.readLine();
            System.out.print("Receiver Name: ");
            receiverName = br.readLine();
            System.out.print("Receiver Contact Number: ");
            receiverContactNumber = br.readLine();
            System.out.print("Amount: ");
            amount = br.readLine();
            System.out.print("Control Number: ");
            controlNumber = br.readLine();
            System.out.print("Sender Employee: ");
            senderEmployee = Integer.parseInt(br.readLine());
            System.out.print("Receiver Employee: ");
            receiverEmployee = Integer.parseInt(br.readLine());
            System.out.print("Branch Sent: ");
            branchSent = Integer.parseInt(br.readLine());
            System.out.print("Branch Withdrawn: ");
            branchWithdrawn = Integer.parseInt(br.readLine());
            System.out.print("Withdrawal Status: ");
            withdrawalStatus = br.readLine();
            // Call the web service method to update the transaction
            boolean updated = service.updateTransaction(
                    transactionId,
                    verificationStatus,
                    senderName,
                    senderContactNumber,
                    receiverName,
                    receiverContactNumber,
                    amount,
                    controlNumber,
                    senderEmployee,
                    receiverEmployee,
                    branchSent,
                    branchWithdrawn,
                    withdrawalStatus
            );
            System.out.println();
            if (updated) {
                System.out.println("--------------------------------------------------");
                System.out.println("Transaction Successfully Updated");
                System.out.println("--------------------------------------------------");
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("Failed to Update the Transaction");
                System.out.println("--------------------------------------------------");
            }
            System.out.println();
        } catch (IOException | NumberFormatException error) {
            System.err.println(error);
        }
    }
}