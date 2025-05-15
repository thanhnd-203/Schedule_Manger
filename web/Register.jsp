<%-- 
    Document   : Register
    Created on : Apr 28, 2025, 11:44:12 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Personal Diary - Register</h2>

        <form action="MainController" method="post">
            Username: <input type="text" name="username" placeholder="Username"> <br>
            Password: <input type="password" name="password" placeholder="Password"> <br>
            Confirm Password: <input type="password" name="confirmPassword" placeholder="Confirm Password"> <br>
            Full Name: <input type="text" name="name" placeholder="Full Name"> <br>
            <input type="submit" value="Register" name="action">
        </form>

        <h4 style="color: red">${requestScope.error}</h4>

        <a href="MainController">Back to Login</a>
    </body>
</html>
