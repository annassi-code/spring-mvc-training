<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="../css/error.css">
    <style>
        .error {
            color: red;
        }
    </style>
    <title>Add/Modify product</title>
</head>
<body>

<form:form method="POST" action="" modelAttribute="product">
    <spring:hasBindErrors name="product">
        <div>
            <h5>There are problems in the product form </h5>
        </div>
    </spring:hasBindErrors>

    <form:label path="name">Name</form:label>
    <form:input path="name" placeholder="ex: PC"/>
    <form:errors path="name" cssClass="error"/>
    <br>

    <form:label path="price">Price</form:label>
    <form:input path="price" placeholder="ex: 1000"/>
    <form:errors path="price" cssStyle="color:red"/>
    <br>

    <button type="submit">
        <c:choose>
            <c:when test="${action eq 'add'}">Create product</c:when>
            <c:otherwise>Update product</c:otherwise>
        </c:choose>
    </button>
</form:form>
</body>
</html>
