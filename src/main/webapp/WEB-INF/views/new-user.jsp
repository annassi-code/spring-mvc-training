<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <!--    <link rel="stylesheet" href="../css/error.css">-->
    <style>
        .error {
            color: red;
        }
    </style>
    <title>Add a new user</title>
</head>
<body>

<form:form method="POST" action="" modelAttribute="user">
    <spring:hasBindErrors name="user">
        <div>
            <h5>There are problems in the user form </h5>
        </div>
    </spring:hasBindErrors>

    <form:label path="username">Name</form:label>
    <form:input path="username" placeholder="ex: PC"/>
    <form:errors path="username" cssClass="error"/>
    <br>

    <form:label path="password">Password</form:label>
    <form:input path="password" placeholder="Enter your password"/>
    <form:errors path="password" cssClass="error"/>
    <br>

    <form:label path="confirmPassword">Confirm Password</form:label>
    <form:input path="confirmPassword" placeholder="Enter your password again"/>
    <form:errors path="confirmPassword" cssClass="error"/>
    <br>

    <button type="submit">
        <c:choose>
            <c:when test="${action eq 'add'}">Create user</c:when>
            <c:otherwise>Update user</c:otherwise>
        </c:choose>
    </button>
</form:form>
</body>
</html>
