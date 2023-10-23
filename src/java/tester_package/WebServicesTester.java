package tester_package;

import extra_features.NameFormatter;
import web_services.TransactionWebServices;
import java.util.*;

public class WebServicesTester {

    // Main method to test the web services in the console
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--------------------------------------------------");
            System.out.println("Enter Sender Details");
            System.out.println("--------------------------------------------------");
            System.out.println();
            // Sender details input
            System.out.print("Enter First Name: ");
            String senderFirstName = scanner.nextLine();
            senderFirstName = NameFormatter.formatName(senderFirstName);
            System.out.print("Enter Middle Name: ");
            String senderMiddleName = scanner.nextLine();
            senderMiddleName = NameFormatter.formatName(senderMiddleName);
            System.out.print("Enter Last Name: ");
            String senderLastName = scanner.nextLine();
            senderLastName = NameFormatter.formatName(senderLastName);
            System.out.print("Enter Name Suffix: ");
            String senderNameSuffix = scanner.nextLine();
            senderNameSuffix = NameFormatter.formatName(senderNameSuffix);
            String senderName = senderFirstName;
            // Construct full sender name
            if (senderMiddleName != null && !senderMiddleName.isEmpty()) {
                senderName += " " + senderMiddleName;
            }
            senderName += " " + senderLastName;
            if (senderNameSuffix != null && !senderNameSuffix.isEmpty()) {
                senderName += " " + senderNameSuffix;
            }
            System.out.print("Enter Contact Number: ");
            String senderContactNumber = scanner.nextLine();
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("Enter Receiver Details");
            System.out.println("--------------------------------------------------");
            System.out.println();
            // Receiver details input
            System.out.print("Enter First Name: ");
            String receiverFirstName = scanner.nextLine();
            receiverFirstName = NameFormatter.formatName(receiverFirstName);
            System.out.print("Enter Middle Name: ");
            String receiverMiddleName = scanner.nextLine();
            receiverMiddleName = NameFormatter.formatName(receiverMiddleName);
            System.out.print("Enter Last Name: ");
            String receiverLastName = scanner.nextLine();
            receiverLastName = NameFormatter.formatName(receiverLastName);
            System.out.print("Enter Name Suffix: ");
            String receiverNameSuffix = scanner.nextLine();
            receiverNameSuffix = NameFormatter.formatName(receiverNameSuffix);
            String receiverName = receiverFirstName;
            // Construct full receiver name
            if (receiverMiddleName != null && !receiverMiddleName.isEmpty()) {
                receiverName += " " + receiverMiddleName;
            }
            receiverName += " " + receiverLastName;
            if (receiverNameSuffix != null && !receiverNameSuffix.isEmpty()) {
                receiverName += " " + receiverNameSuffix;
            }
            System.out.print("Enter Contact Number: ");
            String receiverContactNumber = scanner.nextLine();
            System.out.println();
            System.out.print("Enter Amount: ");
            String amount = scanner.nextLine();
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("New Transaction Successfully Recorded");
            System.out.println("--------------------------------------------------");
            System.out.println();
            // Display recorded transaction information
            System.out.println("Sender Name: " + senderName);
            System.out.println("Sender Contact Number: " + senderContactNumber);
            System.out.println("Receiver Name: " + receiverName);
            System.out.println("Receiver Contact Number: " + receiverContactNumber);
            System.out.println("Amount: " + amount);
            System.out.println();
            // Create and call the insertNewTransaction web service
            TransactionWebServices service = new TransactionWebServices();
            service.insertNewTransaction(senderName, senderContactNumber, receiverName, receiverContactNumber, amount);
        }
    }
}