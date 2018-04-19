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
            <div class="index-container">
                <div class="text">
                    <c:choose>
                        <c:when test="${user != null}">
                            <h1>Hello, <c:out value="${user.username}"></c:out></h1>
                        </c:when>
                        <c:when test="${user == null}">
                            <h1>Hello, stranger!</h1>
                        </c:when>
                    </c:choose>
                     <p>This is just a demo page</p>
                </div>
            </div>
        </div>
        
        <%@include file="/fragments/footer.html" %>
    </body>
</html>
