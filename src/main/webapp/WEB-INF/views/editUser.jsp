<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<link rel="stylesheet" href="<c:url value="/theme/css/singUp.css"/>">

<div id="main" class="main">
    <div class="registration__container">
        <div class="registration__body">
            <form:form action="/user/edit/${user.id}" method="post" modelAttribute="user">
                <form:input cssClass="hidden" path="id"/>
                <form:input path="username" placeholder="Username" />
                <form:input path="email" placeholder="Email"/>
                <form:input path="firstName" placeholder="First name"/>
                <form:input path="lastName" placeholder="Last name"/>
                <form:password path="password" placeholder="New password" required="true"/>
                <form:input cssClass="hidden" path="role"/>
                <form:input cssClass="hidden" path="enabled"/>

                <div class="buttons">
                    <a href="/user/details/${user.id}">
                        <img src="<c:url value="/theme/img/cancel.png"/>" alt="cancel" onmouseover="this.src = '/theme/img/cancel-click.png'" onmouseout="this.src = '/theme/img/cancel.png'">
                    </a>
                    <button type="submit" class="submit__button">
                        <img src="<c:url value="/theme/img/ok.png"/>" alt="submit" onmouseover="this.src = '/theme/img/ok-click.png'" onmouseout="this.src = '/theme/img/ok.png'">
                    </button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
