<%-- 
    Document   : EditDiary
    Created on : Apr 28, 2025, 12:08:53 PM
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
        <h2>Personal Diary - Edit Entry</h2>

        <c:set var="c" value="${requestScope.diaryEntry}"/>
        <c:if test="${not empty requestScope.diaryEntry}">
            <form action="MainController" method="post">
                <input type="hidden" name="entryID" value="${c.entryID}">

                Date: <input type="date" name="entryDate" value="${c.entryDate}" required> <br><br>

                Entry Content: <br>
                <textarea name="entryContent" rows="10" cols="80" required>${c.entryContent}</textarea> <br><br>

                <select name="status">
                    <option value="Done" <c:if test="${c.status == 'Done'}">selected</c:if>>Done</option>
                    <option value="ToDo" <c:if test="${c.status == 'ToDo'}">selected</c:if>>To Do</option>
                    <option value="In Progress" <c:if test="${c.status == 'In Progress'}">selected</c:if>>In Progress</option>
                </select><br><br>

                <input type="submit" value="UpdateDiary" name="action"> &nbsp;
                     <a href="MainController?action=diaryList">Cancel</a>
                </form>
               
        </c:if>

        <c:if test="${empty requestScope.diaryEntry}">
            <p>Entry not found or access denied.</p>
            <a href="MainController?action=diaryList">Back to List</a>
        </c:if>

        <h4 style="color: red">${requestScope.error}</h4>
    </body>
</html>
