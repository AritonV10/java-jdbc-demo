<%-- 
    Document   : products
    Created on : Apr 19, 2018, 8:07:00 PM
    Author     : arito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <table>
                <tr>
                            <th>Product Name</th>
                            <th>Product Price</th>
                            <th>In stock</th>
                            <th></th>
                 </tr>
                <c:forEach items="${products}" var="product">
                    <form action="add_to_cart" method="post"> 
                        <tr>   
                            <td> 
                                <h1>${product.productName}</h1>
                            </td>
                            <td>
                                <h3>${product.productCost}</h3>
                            </td>
                            <td>
                                <c:choose>
                                   <c:when test="${product.isStock == false}">
                                       <h5>Not in stock</h5>
                                   </c:when>
                                   <c:when test="${product.isStock == true}">
                                       <h5>In stock</h5>
                                   </c:when>  
                               </c:choose>
                            </td>
                            <td>
                                <button type="submit">Add To Cart</button>
                            </td>
                        </tr>
                    </form>
                  </c:forEach>
               </table> 
        </div>
       <%@include file="/fragments/footer.html" %>
    </body>
</html>
