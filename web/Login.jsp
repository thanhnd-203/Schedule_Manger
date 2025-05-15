<%-- 
    Document   : Login
    Created on : Apr 28, 2025, 11:43:51 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

h2 {
    text-align: center;
    color: #333;
}

form {
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    width: 300px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

input[type="text"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

h4 {
    text-align: center;
    font-size: 14px;
}

a {
    text-decoration: none;
    color: #4CAF50;
    font-size: 14px;
}

a:hover {
    text-decoration: underline;
}
        </style>
    </head>
    <body>
        <h2>Personal Diary - Login</h2>

        <form action="MainController" method="post">
            Username: <input type="text" name="username" placeholder="Username"> <br>
            Password: <input type="password" name="password" placeholder="Password"> <br>
            <input type="submit" value="Login" name="action">
        </form>

        <h4 style="color: red">${requestScope.error}</h4>
        <h4 style="color: green">${requestScope.success}</h4>
        <h4 style="color: red">${requestScope.loginAgain}</h4>

        <a href="MainController?action=InputRegister">Register</a>
    </body>
</html>
