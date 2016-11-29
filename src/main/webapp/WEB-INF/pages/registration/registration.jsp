<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Регистрация</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="css/registration.css">
        <link href="css/registration.css" type="text/css" rel="stylesheet"/>

    </head>
    <body>

        <div  id="registration-form" class="modal-container" >

            <form id="formRegistration" method="POST" class="form-signin">
                <h2 class="form-signin-heading">Create your account</h2>
                <spring:bind path="userForm.username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <input type="text" name="${status.expression}" value="${status.value}" class="form-control" placeholder="Username"
                                    autofocus="true">
                        <errors path="username"></errors>
                    </div>
                </spring:bind>

                <spring:bind path="userForm.password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <input type="password" name="${status.expression}" value="${status.value}" class="form-control" placeholder="Password">
                        <errors path="password"></errors>
                    </div>
                </spring:bind>

                <spring:bind path="userForm.confirmPassword">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <input type="password" name="${status.expression}" value="${status.value}" class="form-control"
                                    placeholder="Confirm your password">
                        <errors path="confirmPassword"></errors>
                    </div>
                </spring:bind>

                <%--<spring:bind path="role">--%>
                    <%--<div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:radiobutton path="role" value="client" name="client" class="form-control"/>Client
                        <form:radiobutton path="role" value="operator" name="client" class="form-control"/>Operator
                        <form:radiobutton path="role" value="administration" name="client" class="form-control"/>Administration
                    </div>--%>
                <%--</spring:bind>--%>

                <spring:bind path="userForm.roleName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <select form="formRegistration" name="Выберите роль" required size="1">
                            <option value="client">Клиент</option>
                            <option value="operator">Оператор</option>
                            <option value="administration">Администратор</option>
                        </select>
                        <errors path="role"></errors>
                    </div>
                </spring:bind>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            </form>

        </div>

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='https://www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
        </script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>


    </body>
</html>
