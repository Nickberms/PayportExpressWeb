package tester_package;

import web_services.*;
import java.util.*;

public class DeleteTransaction {

    // Main method to test the web service in the console
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt the user for a transaction ID to delete
        System.out.print("Enter the Transaction ID to Delete: ");
        int transactionId = scanner.nextInt();
        // Create and call the web service
        TransactionWebServices service = new TransactionWebServices();
        // Call the web service method to delete the transaction
        boolean deleted = service.deleteTransaction(transactionId);
        if (deleted) {
            System.out.println("Transaction record has been deleted");
        } else {
            System.out.println("Failed to delete the transaction");
        }
        System.out.println();
    }
}