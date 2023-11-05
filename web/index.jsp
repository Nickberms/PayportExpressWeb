<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Landing Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <style>
            .landing_page{
                width:100%;
                height:100vh;
                overflow:hidden;
                background-color: #269e6a
            }
            
            .button_panel{
                width:50%;
                margin: 20px auto;
                background: white;
                padding:10px;
                border:1px solid gray;
                border-radius:10px;
            }
        </style>
    
    </head>
    <body>
        
        <div class="container-fluid p-0">
            <div class="landing_page">
                
                <div class="row">
                    <div class="col-sm-12">
                        <div class="button_panel">
                            
                            <h3 class="text-center">Payport Money Sender Express</h3>
                            <form action="public_pages/add_transaction_form.jsp">
                                <div class="d-grid gap-2">
                                    <input type="submit" class="btn btn-success" value="Go to Add Transaction Form">
                                </div>

                           </form>
                           <form action="admin_pages/admin_login.jsp">
                               <div class="d-grid gap-2 mt-3">
                                    <input type="submit" class="btn btn-success" value="Go to Admin Login">
                                </div>
                               
                           </form>
                        </div>
                         
                    </div>
                    
                        
                </div>
                
            </div>
        </div>
        
       
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>