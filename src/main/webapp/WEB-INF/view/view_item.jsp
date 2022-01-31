<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="guru.noor.util.Mappings" %>

<html>
<head>
    <title>Todo Items</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>${todoItem.title}</h2></caption>

        <tr>
            <th>Title</th>
            <th>Details</th>
            <th>Deadline</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}">
            <c:param name="id" value="${todoItem.id}"/>
        </c:url>

        <c:url var="editUrl" value="${Mappings.ADD_ITEM}">
            <c:param name="id" value="${todoItem.id}"/>
        </c:url>

        <tr>
            <td><c:out value="${todoItem.title}"/></td>
            <td><c:out value="${todoItem.details}"/></td>
            <td><c:out value="${todoItem.deadline}"/></td>
            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
        </tr>
    </table>

    <c:url var="itemsLink" value="${Mappings.ITEMS}"/>
    <h2><a href="${itemsLink}">Show All Todo Items</a></h2>
</div>
</body>
</html>