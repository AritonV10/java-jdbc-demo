<%-- 
    Document   : users
    Created on : Apr 18, 2018, 4:36:49 PM
    Author     : arito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${users}" var="user">
            <span>${user.username}</span>
            <span>${user.email}</span>
            <span>${user.password}</span>
        </c:forEach>
            <h4>Test</h4>
    </body>
</html>
