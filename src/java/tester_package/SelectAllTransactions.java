package tester_package;

import web_services.*;
import java.io.*;
import java.util.*;

public class SelectAllTransactions {

    // Main method to test the web service in the console
    public static void main(String[] args) {
        // Create an instance of the web service
        TransactionWebServices service = new TransactionWebServices();
        // Call the web service method to retrieve transaction data
        List<String[]> transactionData = service.selectAllTransactions();
        // Display the retrieved data
        System.out.println("Transaction Data:");
        System.out.println("+----------------------+------------------------------------+------------------------------------+----------------------+");
        System.out.println("| Transaction ID       | Sender Name                        | Receiver Name                      | Amount               |");
        System.out.println("+----------------------+------------------------------------+------------------------------------+----------------------+");
        transactionData.forEach((transaction) -> {
            PrintStream printf = System.out.printf("| %-20s | %-34s | %-34s | %-20s |\n",
                    transaction[0], transaction[2], transaction[4], transaction[6]);
        });
        System.out.println("+----------------------+------------------------------------+------------------------------------+----------------------+");
        System.out.println();
    }
}