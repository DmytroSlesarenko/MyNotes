<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

    <%--Wszystkie notatki--%>

    <div id="main" class="main">
        <div class="header__main">
            <div class="header__title">All notes</div>
            <div class="header__add__note">
                <input type="text" id="mySearch" onkeyup="myFunction()" placeholder="Search...">
                <a href="/notes/add"><img src="<c:url value="/theme/img/note-white.png"/>" alt="add note" onmouseover="this.src = '/theme/img/note.png'" onmouseout="this.src = '/theme/img/note-white.png'"></a>
                <a href="/list/add"><img src="<c:url value="/theme/img/list-white.png"/>" alt="add list" onmouseover="this.src = '/theme/img/list.png'" onmouseout="this.src = '/theme/img/list-white.png'"></a>
            </div>
        </div>
        <div class="notes__row">
            <div class="content__box">

                <c:forEach items="${notes}" var="note">

                    <c:choose>
                        <c:when test="${note.type == 'note'}">
                            <div class="notes__element">

                                <div class="notes__header">
                                    <div class="notes__title">${note.title}</div>
                                    <div class="note__details">
                                        <a href="/notes/details/${note.id}?type=note"><img src="<c:url value="/theme/img/more-white.png"/>" alt="details" onmouseover="this.src = '/theme/img/more.png'" onmouseout="this.src = '/theme/img/more-white.png'"></a>
                                    </div>
                                </div>

                                <div class="notes__content">
                                    <p class="inside">${note.description}</p>
                                </div>

                            </div>
                        </c:when>

                        <c:otherwise>
                            <div class="notes__element">

                                <div class="notes__header">
                                    <div class="notes__title">${note.title}</div>
                                    <div class="note__details">
                                        <a href="/notes/details/${note.id}?type=list"><img src="<c:url value="/theme/img/more-white.png"/>" alt="details" onmouseover="this.src = '/theme/img/more.png'" onmouseout="this.src = '/theme/img/more-white.png'"></a>
                                    </div>
                                </div>

                                <div class="notes__content">
                                    <div class="pointView">
                                        <c:forEach items="${note.description.split('; ')}" var="item">
                                            <div class="list__content">
                                                <img class="uncheck"/>
                                                <p>${item}</p>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </div>
        </div>
    </div>

<%@include file="footer.jsp"%>