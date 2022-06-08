<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

  <div id="main" class="main">
    <div class="details__note__container">
      <div class="container__note__details">
        <div class="details__note__body">
            <div class="note__body">
                <div class="title__body">
                  <p>${note.title}</p>
                </div>
                <div class="description">
                    <p>${note.description}</p>
                </div>
            </div>
            <div class="buttons">
              <a href="/notes">
                <img src="<c:url value="/theme/img/cancel.png"/>" alt="cancel" onmouseover="this.src = '/theme/img/cancel-click.png'" onmouseout="this.src = '/theme/img/cancel.png'">
              </a>
              <a href="/notes/share/${note.id}">
                <img src="<c:url value="/theme/img/share.png"/>" alt="share" onmouseover="this.src = '/theme/img/share-click.png'" onmouseout="this.src = '/theme/img/share.png'">
              </a>
              <a href="/notes/edit/${note.id}">
                <img src="<c:url value="/theme/img/edit-blue.png"/>" alt="edit" onmouseover="this.src = '/theme/img/edit-click.png'" onmouseout="this.src = '/theme/img/edit-blue.png'">
              </a>
              <a href="/notes/delete/${note.id}">
                <img src="<c:url value="/theme/img/delete-blue.png"/>" alt="delete" onmouseover="this.src = '/theme/img/delete-click.png'" onmouseout="this.src = '/theme/img/delete-blue.png'">
              </a>
            </div>
        </div>
      </div>
    </div>
  </div>

<%@include file="footer.jsp"%>