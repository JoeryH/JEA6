<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
        <title>My Blog</title>
    </head>
    <body>
        <h1>My Blog</h1>

        <div id="left">
            <div class="div-border">About<br/><br/><br/></div><br/>
            <div class="div-border">Picture<br/><img src="notfound"/></div><br/>
            <div class="div-border">My Friends<br/><br/>
                <a href="friend1">Friend 1</a><br/>
                <a href="friend2">Friend 2</a><br/>
            </div>
        </div>


        <div id="content" class="left_content">

            <c:forEach items="${postings}" var="posting">
                <div class="div-border">
                    ${posting.title}<br/>
                    ${posting.content}</br>
                    Posted on ${posting.date}
                </div>

                </br>

                <c:if test="${posting.id == param.postingId}">
                    <c:forEach items="${posting.comments}" var="comment">
                        ${comment.content}<br/>
                    </c:forEach>
                    </br>
                </c:if>

            </c:forEach>
        </div>
    </body>
</html>
