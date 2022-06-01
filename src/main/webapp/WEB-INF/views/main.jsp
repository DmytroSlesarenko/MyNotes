<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

    <%--Wszystkie notatki--%>

    <div id="main" class="main">
        <div class="header__main">
            <div class="header__title">All notes</div>
            <div class="header__add__note">
                <a href="/notes/add"><img src="<c:url value="/theme/img/note-white.png"/>" alt="add note" onmouseover="this.src = '/theme/img/note.png'" onmouseout="this.src = '/theme/img/note-white.png'"></a>
                <a href="/list/add"><img src="<c:url value="/theme/img/list-white.png"/>" alt="add note" onmouseover="this.src = '/theme/img/list.png'" onmouseout="this.src = '/theme/img/list-white.png'"></a>
            </div>
        </div>
        <div class="notes__row">
            <div class="content__box">

                <c:forEach items="${notes}" var="note">
                    <div class="notes__element">

                        <div class="notes__header">
                            <div class="notes__title">${note.title}</div>
                            <div class="note__details">
                                <a href="/notes/details"><img src="<c:url value="/theme/img/more-white.png"/>" alt="add note" onmouseover="this.src = '/theme/img/more.png'" onmouseout="this.src = '/theme/img/more-white.png'"></a>
                            </div>
                        </div>

                        <div class="notes__content">
                            ${note.description}
                        </div>

                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

<%@include file="footer.jsp"%>