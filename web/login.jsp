<%-- 
    Document   : login
    Created on : Apr 19, 2018, 6:38:32 PM
    Author     : arito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/static/index.css"/>" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="fragments/nav.html" %>
        <div class="wrapper">
            <div class="register-box">
                <c:if test="${error == true}">
                    <h2>${error}</h2>
                </c:if>
                <div class="register">
                    <c:if test="${error == true}">
                    <h2>${error}</h2>
                </c:if>
                    <ul class="register-list">
                        <form action="login" method="POST">
                        <li>
                            <label>Username</label>
                            <input type="text" name="username">
                        </li>
                        <li>
                            <label>Password</label>
                            <input type="password" name="password">
                        </li>
                        <span><a style='color: white' href="/register.jsp">Don't have an account</a></span>
                        <br>
                        <button class="register_button" type="submit">Login</button>
                        </form>
                    </ul>
                </div>
            </div>
        </div>
       <%@include file="/fragments/footer.html" %>
    </body>
</html>
