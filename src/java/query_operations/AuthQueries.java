package query_operations;

import database_connection.*;
import java.sql.*;
import java.util.*;

public class AuthQueries extends DatabaseConnection{
    
    private boolean result;
    
    private String email;
    private String password;
    
    public AuthQueries(){
        
    }
    
    
    public AuthQueries(boolean result, String email, String password){
        this.result = result;
        this.email = email;
        this.password = password;
    }
    
    public boolean getResult(){
        return result;
    }
    
    public boolean setResult(boolean result){
        return this.result = result;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String setEmail(String email){
        return this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String setPassword(String password){
        return this.password = password;
    }
    
      public boolean login(String email, String password){
         try {
             
            super.getConnectedToDatabaseHost();
             PreparedStatement statement = connection.prepareStatement("SELECT email_address, password FROM admins WHERE email_address = ? and password = ?;");
             statement.setString(1, email);
             statement.setString(2, password);
             
              ResultSet result = statement.executeQuery();

        // Check if a row was returned. If so, the login is successful.
            if (result.next()) {
                // You can store user data in the session or return true, indicating a successful login.
                
                return true;
            } else {
                // No matching user found, return false for an unsuccessful login.
                return false;
            }
             
        } catch (SQLException error) {
            System.err.println(error);
            return false;
        }
    }
}