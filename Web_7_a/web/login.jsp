<%-- 
    Document   : login
    Created on : Jan 19, 2026, 9:46:49 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController">
        <h1>Login</h1>
        Username: <input type="text" name="username" value="" required /> <br/>
        Password: <input type="password" name="password" value="" required/> <br/>
        <input type="hidden" name="action" value="login"/>
        <input type="submit" value="SUBMIT" />                
        </form>
        
        <c:if test="not empty message">
            ${message}
        </c:if>        
    </body>
</html>
