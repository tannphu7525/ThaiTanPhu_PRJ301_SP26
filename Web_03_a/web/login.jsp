<%-- 
    Document   : login
    Created on : Jan 8, 2026, 11:21:13 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername"/> <br/>
            Password: <input type="password" name="txtPassword"/> <br/>
            <input type="submit" value="Dang Nhap" />
        </form>
        
        <%
            String mess = request.getAttribute("message")+"";
            mess = (mess.equals("null"))?"":mess;
        %>
        
        <span style="color: red"> <%= mess%> </span>
    </body>
</html>
