package web_services;

import query_operations.*;
import java.text.*;
import javax.jws.*;

/**
 * The {@code AdminWebServices} class provides a SOAP web service for
 * an admin-related operation. This class exposes a method for authenticating admin users.
 *
 * @author Kein Bermejo
 */
@WebService(serviceName = "AdminWebServices")
public class AdminWebServices {

    /**
     * Authenticates an admin user and returns an array of strings containing
     * admin details. It allows an admin to log in using their email
     * address and password. If the authentication is successful, it returns an
     * array of admin details; otherwise, it returns {@code null}.
     *
     * @param emailAddress The email address of the admin to authenticate.
     * @param password The password of the admin to authenticate.
     * @return An array of {@code String} representing admin details if
     * authentication succeeds, or {@code null} if it fails.
     */
    @WebMethod(operationName = "adminLogin")
    public String[] adminLogin(@WebParam(name = "email_address") String emailAddress,
            @WebParam(name = "password") String password) {
        AdminQueries adminLogin = new AdminQueries();
        AdminQueries admin = adminLogin.adminLogin_Query(emailAddress, password);
        if (admin != null) {
            String[] str = new String[9];
            str[0] = String.valueOf(admin.getAdminId());
            str[1] = admin.getFirstName();
            str[2] = admin.getLastName();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date birthdate = admin.getBirthdate();
            str[3] = (birthdate != null) ? dateFormat.format(birthdate) : "";
            str[4] = admin.getSex();
            str[5] = admin.getAddress();
            str[6] = admin.getPhoneNumber();
            str[7] = admin.getEmailAddress();
            str[8] = admin.getPassword();
            return str;
        } else {
            return null;
        }
    }
}