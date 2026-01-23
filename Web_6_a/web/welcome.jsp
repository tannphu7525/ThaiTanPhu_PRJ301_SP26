<%-- 
    Document   : loginsuccess
    Created on : Jan 19, 2026, 10:25:53 AM
    Author     : admin
--%>

<%@page import="model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDTO u = (UserDTO) session.getAttribute("user");
            if (u != null) {
        %>
        
        <<h2>Welcome, <%= u.getFullName() %> </h2>
        <h2>Bang dieu khien</h2> 
        <a href="search.jsp">Search</a>
        
        <br/>
        <a href="MainController?action=logout">LOGOUT</a>
        
        <%
            } else {
                response.sendRedirect("login.jsp");
            }
        %>
    </body>
</html>
