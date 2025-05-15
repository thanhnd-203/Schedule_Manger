<%-- 
    Document   : DiaryList
    Created on : Apr 28, 2025, 11:44:27 AM
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
        <h2>Personal Diary - My Entries</h2>
        <h3>Welcome, ${sessionScope.user.name}!</h3>

        <a href="MainController?action=CreateDiary">Create New Entry</a> | 
        <a href="MainController?action=todoList&userName=${sessionScope.user.username}">Done</a> |
        <a href="MainController?action=Logout">Logout</a>

        <h4 style="color: red">${requestScope.error}</h4>
        <h4 style="color: green">${requestScope.success}</h4>


        
        <c:if test="${empty requestScope.diaryList}">
            <p>Nothing In Here</p>
        </c:if>

        <c:if test="${not empty requestScope.diaryList}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Entry ID</th>
                        <th>Date</th>
                        <th>Content Preview</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${requestScope.diaryList}">
                        <tr>
                            <td>${entry.entryID}</td>
                            <td>${entry.entryDate}</td>
                            <td> 
                                <c:choose>
                                    <c:when test="${entry.entryContent.length() > 50}">
                                        ${entry.entryContent.substring(0, 50)}...
                                    </c:when>
                                    <c:otherwise>
                                        ${entry.entryContent}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${entry.status}</td>
                            <td>
                                <a href="MainController?action=ViewDiary&entryID=${entry.entryID}">View</a> | 
                                <a href="MainController?action=EditDiary&entryID=${entry.entryID}">Edit</a> | 
                                <a href="MainController?action=DeleteDiary&entryID=${entry.entryID}" 
                                   onclick="return confirm('Are you sure you want to delete this entry?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
