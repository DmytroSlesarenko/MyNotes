<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<div id="main" class="main">
    <div class="details__note__container">
        <div class="container__note__details">
            <div class="details__note__body">
                <div id="addInput">
                    <input type="text" id="myInputs" placeholder="New point...">
                    <button onclick="newElement()" class="submit__button addPoint">
                        <img src="<c:url value="/theme/img/plus.png"/>" alt="plus" onmouseover="this.src = '/theme/img/plus-click.png'" onmouseout="this.src = '/theme/img/plus.png'">
                    </button>
                </div>
                <form:form action="/list/add?type=list" method="post" modelAttribute="note">
                    <form:input path="title" placeholder="Title..."/>
                    <div id="checklist">

                    </div>

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