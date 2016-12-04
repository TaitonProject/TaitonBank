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
<form method="post">
    <spring:bind path="user.username">
        <input  name="${status.expression}" value="${status.value}" type="text" placeholder="Username"/>
    </spring:bind>
    <spring:bind path="user.password">
        <input name="${status.expression}" value="${status.value}"  type="password" placeholder="Password"/>
    </spring:bind>
    <spring:bind path="user.confirmPassword">
        <input name="${status.expression}" value="${status.value}"  type="password" placeholder="Confirm your password"/>
    </spring:bind>

    <spring:bind path="user.role">
        <select items="${roles}">
            <c:forEach items="${roles}" var="rol">
               <option value="role[${status.index}]">${rol.nameRole}</option>
           </c:forEach>
        </select>
    </spring:bind>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" value="Регистрация">Submit</button>
</form>

<span>&copy; ЯГОР 2016</span>
</body>
</html>
