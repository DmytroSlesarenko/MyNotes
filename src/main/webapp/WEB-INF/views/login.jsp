<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 09.06.2022
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Notes - Login</title>
    <link rel="stylesheet" href="<c:url value="/theme/css/loginStyle.css"/>">
</head>
<body>

<div class="login__container">
    <div class="login__body">
        <form:form action="/login" method="post">
            <input type="text" name="username" placeholder="Email...">
            <input type="password" name="password" placeholder="Password...">
            <div class="buttons__login">
                <a href="/registration">
                    Sing up
                </a>
                <input type="submit" value="Log in">
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
