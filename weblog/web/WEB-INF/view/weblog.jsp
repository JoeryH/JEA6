<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="<c:url value="/resources/javascript/functions.js" />"></script>
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
                    ${posting.content}<br/>
                    Posted on ${posting.date}
                    <div class="comment-link">
                        <a href="#" onclick="onClickComment(${posting.id})">comment</a>
                    </div>
                    <!--<div class="clear"></div> -->
                </div>
                <br/>
                <div id="comments${posting.id}"></div>
                <c:if test="${posting.id == param.postingId}">
                    <div id="comments">

                    </c:if>
                </c:forEach>
            </div>
    </body>
</html>
