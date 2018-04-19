<%-- 
    Document   : register
    Created on : Apr 18, 2018, 9:05:14 PM
    Author     : arito
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/static/index.css"/>" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="fragments/nav.html" %>
        <div class="wrapper">
            <div class="register-box">
                <div class="register">
                    <ul class="register-list">
                        <form action="register" method="POST">
                        <li>
                            <label>Username</label>
                            <input type="text" name="username">
                        </li>
                        <li>
                            <label>Email</label>
                            <input type="text" name="email">
                        </li>
                        <li>
                            <label>Password</label>
                            <input type="password" name="password">
                        </li>
                        <button class="register_button" type="submit">Register</button>
                        </form>
                    </ul>
                </div>
            </div>
        </div>
        <%@include file="/fragments/footer.html" %>
    </body>
</html>
