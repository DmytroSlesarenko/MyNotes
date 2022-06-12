<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<div id="main" class="main">
    <div class="add__note__container">
        <div class="container__note">
            <div class="add__note__body">
                <form:form method="post" action="/notes/add/${user.id}?type=note" modelAttribute="note">
                    <div class="error">
                        Note already exist! Change title!
                    </div>
                    <form:input path="title" placeholder="Title"/>
                    <form:textarea path="description" id="note__description" placeholder="Text"/>
                    <form:select path="folder">
                        <form:option value="" label="Select folder"/>
                        <form:options items="${folders}" itemLabel="name"/>
                    </form:select>
                    <div class="buttons">
                        <a href="/notes">
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
</div>

<%@include file="footer.jsp"%>