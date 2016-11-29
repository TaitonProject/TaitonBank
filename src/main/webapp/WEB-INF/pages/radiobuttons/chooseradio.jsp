<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Taiton
  Date: 11/27/2016
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/radioresult" modelAttribute="role">
        <form:radiobutton path="nameRole" value="client"/>client
        <form:radiobutton path="nameRole" value="operator"/>operator
        <form:radiobutton path="nameRole" value="administration"/>administration
        <button type="submit">Submit</button>
    </form:form>
</body>
</html>
