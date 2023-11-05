/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_package;

import static database_connection.DatabaseConnection.connection;
import extra_features.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import web_services.*;
import java.util.*;

import static database_connection.DatabaseConnection.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author KAPITAL_B
 */
public class Login {
     public static void main(String[] args){
         
       AuthWebServices service = new AuthWebServices();
       
       Scanner scan = new Scanner(System.in);
       
       String email = scan.nextLine();
       String password = scan.nextLine();
       
       if (service.Login(email, password)){
           System.out.print("Login");
       }else{
           System.out.print("Fail");
       }
         
     }
     
     
}
