<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
        <title>Manage blog</title>
    </head>
    <body>
        <div class="right-link"><a href="/weblog/weblog">View My Blog</a></div>
        <h1>My Blog Adm</h1>

        <form method="POST" action="admin/addPosting" class="center">
            <label for="title">Title:</label>
            <input type="text" name="title" id="title"><br/><br/>
            <label for="content">Posting:</label>
            <textarea name="content"></textarea><br/>
            <input type="submit" value="Add Posting">
        </form>
        
        <hr>
    </body>
</html>
