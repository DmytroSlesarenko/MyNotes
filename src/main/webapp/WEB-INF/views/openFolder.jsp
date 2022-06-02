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
                <div class="notes__element">

                    <div class="notes__header">
                        <div class="notes__title">${note.title}</div>
                        <div class="note__details">
                            <a href="/notes/details/${note.id}"><img src="<c:url value="/theme/img/more-white.png"/>" alt="add note" onmouseover="this.src = '/theme/img/more.png'" onmouseout="this.src = '/theme/img/more-white.png'"></a>
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