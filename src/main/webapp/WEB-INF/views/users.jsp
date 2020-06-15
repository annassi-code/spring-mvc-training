<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <h2>Users :</h2>
    <ul>
        <c:forEach items="${users}" var="user">
            <li>
                <div>${user.username}
                    <br/>
                    <a href="/spring-mvc/users/${user.username}">Details</a>
                    <br/>
                    <a href="/spring-mvc/users/modify/${user.username}">Modify</a>
                    <br/>
                    <a href="/spring-mvc/users/delete/${user.username}">Delete</a>
                </div>
            </li>
        </c:forEach>
    </ul>

    <form action="/spring-mvc/users/add/" method="get">
        <input type="hidden" name="action" value="add"/>
        <input type="submit" value="Add a new user"/>
    </form>
</body>
</html>
