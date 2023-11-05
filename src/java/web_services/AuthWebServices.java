package web_services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import query_operations.AuthQueries;

@WebService(serviceName = "AuthWebServices")
public class AuthWebServices {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
   public boolean Login(String email, String password){
       AuthQueries login_query = new AuthQueries();
       
       return login_query.login(email, password);

   }
   
}