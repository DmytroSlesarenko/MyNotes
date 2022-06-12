<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>


<div id="main" class="main">
    <div class="header__main">
        <div class="header__title">${folder.name}</div>
        <div class="header__add__note">
            <a href="/folder/edit/${folder.id}"><img src="<c:url value="/theme/img/edit-white.png"/>" alt="edit folder" onmouseover="this.src = '/theme/img/edit.png'" onmouseout="this.src = '/theme/img/edit-white.png'"></a>
            <a href="/folder/delete/${folder.id}"><img src="<c:url value="/theme/img/delete-white.png"/>" alt="add note" onmouseover="this.src = '/theme/img/delete.png'" onmouseout="this.src = '/theme/img/delete-white.png'"></a>
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
                                    ${note.description}
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

                                        <div class="list__content">
                                            <c:forEach items="${note.checkType.split('; ')}" var="check">

                                                <img class="${check}"/>

                                            </c:forEach>
                                        </div>
                                        <div class="list__content inside">
                                            <c:forEach items="${note.description.split('; ')}" var="item">
                                                <p class="inside">${item}</p>
                                            </c:forEach>
                                        </div>
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