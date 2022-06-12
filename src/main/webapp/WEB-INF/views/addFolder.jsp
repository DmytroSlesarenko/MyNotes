<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

    <div id="main" class="main">
        <div class="add__note__container">
            <div class="container__folder">
                <div class="add__note__body">
                    <form:form method="post" action="/folder/add/${user.id}" modelAttribute="folder">
                        <form:input path="name" placeholder="Name"/>
                        <div class="buttons">
                            <a href="/notes">
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