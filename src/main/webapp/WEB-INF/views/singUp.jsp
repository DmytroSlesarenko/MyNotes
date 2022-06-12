<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 09.06.2022
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My notes - Sing up</title>
    <link rel="stylesheet" href="<c:url value="/theme/css/singUp.css"/>">
</head>
<body>
    <div class="registration__container">
        <div class="registration__body">
            <form:form action="/registration" method="post" modelAttribute="user">
                <form:input path="username" placeholder="Username" />
                <form:input path="email" placeholder="Email"/>
                <form:input path="firstName" placeholder="First name"/>
                <form:input path="lastName" placeholder="Last name"/>
                <form:password path="password" placeholder="Password" required="true"/>
                <input type="password" name="reapedpass" placeholder="Reaped password" required>
                <form:input cssClass="hidden" path="role"/>
                <form:input cssClass="hidden" path="enabled"/>

                <div class="buttons__registration">
                    <a href="<c:url value="/login"/>">
                        Back
                    </a>
                    <input type="submit" value="Sing up">
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>
