<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 29.05.2022
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>MyNotes</title>
    <link rel="stylesheet" href="<c:url value="/theme/css/main.css"/>">
    <link rel="stylesheet" href="<c:url value="/theme/css/notes.css"/>">
    <link rel="stylesheet" href="<c:url value="/theme/css/addNote.css"/>">
    <link rel="stylesheet" href="<c:url value="/theme/css/addFolder.css"/>">
</head>
<body>

<div id="sidebar" class="sidebar" onmouseover="showText()" onmouseout="hideText()">

    <%--Boczne menu--%>

    <div class="toolbar">
        <a href="/user/details"><img src="<c:url value="/theme/img/user.png"/>" alt="user">
            <%--${user.firstName} ${user.lastName}--%>
            <span class="menu_text">Dmytro Slesarenko</span>
        </a>
        <hr>
        <a href="/notes"><img src="<c:url value="/theme/img/notes.png"/>" alt="notes"><span class="menu_text">All notes</span></a>
        <hr>
        <ul class="folders-menu">
            <li>
                <a class="new_folder" href="/folder/all"><img src="<c:url value="/theme/img/folder.png"/>" alt="folder">
                    <span class="menu_text">All folders</span>
                </a>
            </li>
            <span class="menu_text limit">3 last folders</span>
            <%--@elvariable id="folders" type="java.util.List"--%>
            <c:forEach items="${folders}" var="folder">
                <li>
                    <img src="<c:url value="/theme/img/folder.png"/>" alt="folder">
                    <span class="menu_text"><c:out value="${folder.name}"/></span>
                </li>
            </c:forEach>

            <li>
                <a class="new_folder" href="/folder/add"><img src="<c:url value="/theme/img/add-folder.png"/>" alt="folder">
                    <span class="menu_text">New folder</span>
                </a>
            </li>
        </ul>
        <hr>
        <a href="/friends/all"><img src="<c:url value="/theme/img/group.png"/>" alt="friends"><span class="menu_text">Friends</span></a>
    </div>

    <div class="logout">
        <a href="/logout"><img src="<c:url value="/theme/img/logout.png"/>" alt="logout"><span class="menu_text">Logout</span></a>
    </div>
</div>
