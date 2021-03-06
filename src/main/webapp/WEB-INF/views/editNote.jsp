<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<div id="main" class="main">
    <div class="add__note__container">
        <div class="container__note">
            <div class="add__note__body">
                <form:form method="post" action="/notes/edit/${user.id}" modelAttribute="note">
                    <form:input style="display: none" path="id"/>
                    <form:input path="title"/>
                    <form:textarea path="description" id="note__description"/>
                    <form:input style="display: none" path="type"/>
                    <form:input style="display: none" path="checkType"/>
                    <form:select path="folder">
                        <form:option value="" label="Select folder"/>
                        <form:options items="${folders}" itemLabel="name"/>
                    </form:select>
                    <div class="buttons">
                        <a href="/notes/details/${note.id}">
                            <img src="<c:url value="/theme/img/cancel.png"/>" alt="submit" onmouseover="this.src = '/theme/img/cancel-click.png'" onmouseout="this.src = '/theme/img/cancel.png'">
                        </a>
                        <button type="submit" class="submit__button">
                            <img src="<c:url value="/theme/img/ok.png"/>" alt="submit" onmouseover="this.src = '/theme/img/ok-click.png'" onmouseout="this.src = '/theme/img/ok.png'">
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>