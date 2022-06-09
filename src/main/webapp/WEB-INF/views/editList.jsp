<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<div id="main" class="main">
    <div class="details__note__container">
        <div class="container__note__details">
            <div class="details__note__body">
                <form:form action="/list/edit" method="post" modelAttribute="note">
                    <form:input style="display: none" cssClass="note__id" path="id"/>
                    <form:input path="title" placeholder="Title"/>
                    <div id="checklist">
                        <c:forEach items="${note.description.split('; ')}" var="item">
                            <div class="point">
                                <img class="uncheck">
                                <input name="lista" type="text" value="${item}">
                                <img class="close" src="<c:url value="/theme/img/cancel.png"/>" alt="cancel" onmouseover="this.src = '/theme/img/cancel-click.png'" onmouseout="this.src = '/theme/img/cancel.png'">
                            </div>
                        </c:forEach>
                    </div>

                    <div id="addInput">
                        <input type="text" id="myInputs" placeholder="New point">
                        <button type="button" onclick="newElement()" class="submit__button addPoint">
                            <img src="<c:url value="/theme/img/plus.png"/>" alt="plus" onmouseover="this.src = '/theme/img/plus-click.png'" onmouseout="this.src = '/theme/img/plus.png'">
                        </button>
                    </div>

                    <form:input style="display: none" cssClass="note__type" path="type"/>
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