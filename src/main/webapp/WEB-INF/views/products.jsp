<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Products</title>
</head>
<h2>Products :</h2>
<ul>
    <c:forEach items="${products}" var="product">
        <li>
            <div>${product.name} ${product.price}
                <a href="/spring-mvc/products/${product.id}">Details</a>
                <a href="/spring-mvc/products/modify/${product.id}">Modify</a>
                <a href="/spring-mvc/products/delete/${product.id}">Delete</a>
            </div>
        </li>
    </c:forEach>
</ul>

<form action="/spring-mvc/products/add/" method="get">
    <input type="hidden" name="action" value="add"/>
    <input type="submit" value="Add a new product"/>
</form>

<body>
${message}
</body>
</html>
