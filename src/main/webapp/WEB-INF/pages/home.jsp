здесь нужно написать стартовую страницу, с полями login и password
<%--
  Created by IntelliJ IDEA.
  User: Taiton
  Date: 02.10.16
  Time: 03:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel='stylesheet' href='resources/css/login.css' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
  <title>Ну типа вот</title>
</head>
<div id="login_container">
  <div id="form_container">
    <p class="login-text">Sign in to Internet banking</p>
    <form:form method='POST' modelAttribute="user" action="submit" enctype="application/x-www-form-urlencoded">
      <form:input path="login" class='text_input' placeholder="login" aria-required="please enter login" />
      <form:input path="password" aria-required="please enter password" type='password' class='text_input' placeholder="password" />
      <form:button id='submit'>Submit</form:button>
    </form:form>
  </div>
</div>
</body>
</html>
