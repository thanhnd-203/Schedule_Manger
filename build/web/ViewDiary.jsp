<%-- 
    Document   : ViewDiary
    Created on : Apr 28, 2025, 12:08:29 PM
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
        <h2>Personal Diary - View Entry</h2>

        <c:set var="c" value="${requestScope.diaryEntry}"/>

        <c:if test="${not empty requestScope.diaryEntry}">
            <h3>Entry Date: ${c.entryDate}</h3>

            
            <label style="color: blueviolet"s>CONTENT:  </label>   ${c.entryContent} <br><br>
             <label style="color: blueviolet"s>STATUS:  </label>  ${c.status} <br>
             
            

            <br>
            <a href="MainController?action=EditDiary&entryID=${c.entryID}">Edit</a> | 
            <a href="MainController?action=DeleteDiary&entryID=${c.entryID}" 
               onclick="return confirm('Are you sure you want to delete this entry?')">Delete</a> | 
            <a href="MainController?action=diaryList">Back to List</a>
        </c:if>

        <c:if test="${empty requestScope.diaryEntry}">
            <p>Entry not found or access denied.</p>
            <a href="MainController?action=diaryList">Back to List</a>
        </c:if>
    </body>

</html>
