<%--
  Created by IntelliJ IDEA.
  User: Taiton
  Date: 12/1/2016
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    input{
        display: block;
        margin-top: 10px;
    }
    select{
        display: block;
        margin-top: 10px;
    }
</style>
<form:form method="post">
    <form:input path="${user.username}" type="text" placeholder="Username"/>
    <input:input path="${user.password}" type="password" placeholder="Password"/>
    <form:input path="${user.confirmPassword}" type="password" placeholder="Confirm your password"/>
    <form:select path="${user.roleIdRole}">
        <form:option value="1">Клиент</form:option>
        <form:option value="2">Оператор</form:option>
        <form:option value="3">Администратор</form:option>
    </form:select>
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    <form:button type="submit" value="Регистрация"/>
</form:form>
<span>&copy; ЯГОР 2016</span>
</body>
</html>
