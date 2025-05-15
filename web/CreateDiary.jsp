<%-- 
    Document   : CreateDiary
    Created on : Apr 28, 2025, 11:44:48 AM
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
        <h2>Personal Diary - Create New Entry</h2>

        <form action="MainController" method="post" accept-charset="UTF-8">
            Date: <input type="date" name="entryDate" required> <br><br>

            Entry Content: <br>
            <textarea name="entryContent" required></textarea> <br>

            Status: <br>
            <select name="status">
                <option value="Done">Done</option>
                <option value="ToDo">To Do</option>
                <option value="In Progress">In Progress</option>
            </select><br><br>
            <input type="submit" value="SaveDiary" name="action"> &nbsp;
            <a href="MainController?action=diaryList">Cancel</a>
        </form>

        <h4 style="color: red">${requestScope.error}</h4>
    </body>
</html>
