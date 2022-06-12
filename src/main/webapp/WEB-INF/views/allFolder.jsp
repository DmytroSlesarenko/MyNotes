<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<%--Wszystkie notatki--%>

<div id="main" class="main">
    <div class="header__main">
        <div class="header__title">All folders</div>
        <div class="header__add__note">
            <input type="text" id="mySearch" onkeyup="myFunctionFolder()" placeholder="Search...">
            <a href="/folder/all/add"><img src="<c:url value="/theme/img/add-folder-white.png"/>" alt="add note" onmouseover="this.src = '/theme/img/add-folder-click.png'" onmouseout="this.src = '/theme/img/add-folder-white.png'"></a>
        </div>
    </div>
    <div class="notes__row">
        <div class="content__box">

            <c:forEach items="${folders}" var="folder">
                <div class="folders__element">
                    <a href="/folder/${folder.id}?type=note">
                    <div class="folder__header">
                        <div class="folder__details">
                            <img class="folder_img" src="<c:url value="/theme/img/folder-96.png"/>" alt="details" onmouseover="this.src = '/theme/img/folder-96-click.png'" onmouseout="this.src = '/theme/img/folder-96.png'">
                        </div>
                        <div class="notes__title">
                                <span class="inside">${folder.name}</span>
                        </div>
                    </div>
                    </a>
                </div>

            </c:forEach>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>