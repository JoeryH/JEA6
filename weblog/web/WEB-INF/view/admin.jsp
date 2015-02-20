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
        <div class="right-link">
            <a href="/weblog/weblog">View My Blog</a>

            <c:set var="mode" value="${false}"/>
            <c:if test="${sessionScope.mode != null}"><c:set var="mode" value="${sessionScope.mode}"/></c:if>

                <form method="POST" action="admin/switch">
                    <input type="hidden" name="mode" value="${!mode}"/>
                <input type="submit" value="<c:if test="${mode}">Basic Mode</c:if> <c:if test="${!mode}">Advanced Mode</c:if>"/>
                </form>
            </div>
            <h1>My Blog Adm</h1>

            <form method="POST" action="admin/posting" class="center">
            <c:if test="${param.editId != null}">
                <input type="hidden" name="editId" value="${param.editId}"/>
                <c:forEach items="${postings}" var="posting">
                    <c:if test="${posting.id == param.editId}">
                        <c:set var="content" value="${posting.content}"/>
                        <c:set var="title" value="${posting.title}"/>
                    </c:if>
                </c:forEach>
            </c:if>
            <label for="title">Title:</label>
            <input type="text" name="title" id="title" value="${title}"><br/><br/>
            <label for="content">Posting:</label>
            <textarea name="content">${content}</textarea><br/>
            <c:if test="${param.editId == null}">
                <input type="submit" value="Add Posting">
            </c:if>
            <c:if test="${param.editId != null}">
                <input type="submit" value="Edit Posting">
            </c:if>
        </form>

        <hr>

        <c:if test="${mode}">
            <table >
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Posting</th>
                        <th>Date</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${postings}" var="posting">
                        <tr>
                            <td>${posting.title}</td>
                            <td>${posting.content}</td>
                            <td>${posting.date}</td>
                            <td>
                                <form method="GET" action="admin?editId=${postingId}">
                                    <input type="hidden" value="${posting.id}" name="editId"/>
                                    <input type="submit" value="Edit"/>
                                </form>
                            </td>
                            <td>
                                <form method="POST" action="admin/deletePosting">
                                    <input type="hidden" value="${posting.id}" name="id"/>
                                    <input type="submit" value="Delete"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
