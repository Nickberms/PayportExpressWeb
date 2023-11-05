<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="extra_features.*"%>
<%@page import="web_services.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>




<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Login</title>
    <link rel="stylesheet" type="text/css" href="admin_styles.css">
    <link rel="stylesheet" type="text/css" href="styles/login.css">
        <script type="text/javascript" src="admin_scripts.js"></script>
        <% AuthWebServices service = new AuthWebServices(); %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  
  <%
    String action = request.getParameter("action");
    String _error = request.getParameter("error");

    try {
        
        String email = request.getParameter("emailAddress");
        String password = request.getParameter("password");
        
        
        if (action.equals("login")) {
            try {
            if (service.Login(email, password) == true){
                response.sendRedirect("manage_branches_view.jsp");
            }else{
                response.sendRedirect("admin_login.jsp?error=sorry cannot find account");
            }
            
            
            
            } catch (Exception error) {
                error.printStackTrace();
            }
            
            
        }
        
                
    } catch (Exception error) {
        error.printStackTrace();
    }
    

  
  %>
  
  <body style="background-color: #269e6a">
      
          <!-- Check if the "error" parameter is present and equal to "sorry cannot find account" -->
        <% if (_error != null && _error.equals("sorry cannot find account")) { %>
        <div class="alert alert-warning">
            Sorry, we cannot find your account. Please try again.
        </div>
        <% } %>
 

      
      <div class="container-fluid p-0">
          <div class="login_page">
                
              <div class="login_panel">
                  <h2 class="text-center mt-3">Admin Login</h2>
                  
                     <form action="admin_login.jsp?action=login" method="post">
                         <div class="row">
                             <div class="col-sm-12 p-4">
                                <label for="emailAddress" class="form-label">Email Address:</label>
                                <input type="text" id="emailAddress" name="emailAddress" class="form-control" required><br>
                                <label for="password" class="form-label">Password:</label>
                                <input type="password" id="password" name="password" required class="form-control"><br><br>
                                <div class="d-grid gap-2">
                                    <button class="btn btn-success" type="submit">Login</button>
                                </div>
                                
                             </div>
                         </div>
                        
                    </form>
                  
              </div>
              
          </div>
      </div>
           

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>