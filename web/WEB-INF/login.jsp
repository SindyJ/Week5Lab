<%-- 
    Document   : login
    Created on : Oct 10, 2020, 1:35:42 PM
    Author     : 726772
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post"> 
            <label for="username">Username: </label><input type="text" value="${username}" id="username" name="username"><br>
            <label for="password">Password: </label><input type="text" value="${password}" id="password" name="password"><br>
            <input type="submit" value="Log in">
        </form> 
        <p> ${message}</p>
    </body>
</html>
