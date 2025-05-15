<%-- 
    Document   : doneDiaryList
    Created on : Apr 28, 2025, 7:29:05 PM
    Author     : nguye
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
        <h2>Done List</h2>
        <a href="MainController?action=CreateDiary">Create New Entry</a> | 
        <a href="MainController?action=todoList&userName=${sessionScope.user.username}">Done</a> |
        <a href="MainController?action=Logout">Logout</a><br> <br>
        <c:if test="${not empty doneDiaryEntries}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Entry ID</th>
                        <th>Date</th>
                        <th>Content</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${doneDiaryEntries}">
                        <tr>
                            <td>${entry.entryID}</td>
                            <td>${entry.entryDate}</td>
                            <td>${entry.entryContent}</td>
                            <td>${entry.status}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty doneDiaryEntries}">
            <p>Nothing done in here.</p>
        </c:if>

        <br/>
        <a href="MainController?action=diaryList">Back to List</a>
    </body>
</html>
