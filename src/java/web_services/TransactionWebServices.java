package web_services;

import query_operations.TransactionQueries;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;

@WebService(serviceName = "TransactionWebServices")
public class TransactionWebServices {

    // This method is exposed as a web service operation with the name "insertNewTransaction"
    @WebMethod(operationName = "insertNewTransaction")
    public void insertNewTransaction(
            @WebParam(name = "sender_name") String sender_name,
            @WebParam(name = "sender_contact_number") String sender_contact_number,
            @WebParam(name = "receiver_name") String receiver_name,
            @WebParam(name = "receiver_contact_number") String receiver_contact_number,
            @WebParam(name = "amount") String amount) {
        // Create an instance of the TransactionQueries class
        TransactionQueries parameter = new TransactionQueries();
        // Set the values of the parameters received from the web service request
        parameter.setSenderName(sender_name);
        parameter.setSenderContactNumber(sender_contact_number);
        parameter.setReceiverName(receiver_name);
        parameter.setReceiverContactNumber(receiver_contact_number);
        parameter.setAmount(amount);
        // Call the "insertNewTransaction" method on the TransactionQueries instance to insert data into the database
        parameter.insertNewTransaction();
    }
}