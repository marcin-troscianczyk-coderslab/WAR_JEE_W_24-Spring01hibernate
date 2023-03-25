<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All books</title>
</head>
<body>

<table>
    <tr>
        <th>Lp.</th>
        <th>Title</th>
        <th>Rating</th>
        <th>Description</th>
        <th>Publisher</th>
        <th>Category</th>
        <th>Authors</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
            <td>
                <c:forEach items="${book.authors}" var="author">
                    ${author.firstName} ${author.lastName}
                </c:forEach>
            </td>
            <td><a href="edit?id=${book.id}">Edit</a></td>
            <td><a href="remove?id=${book.id}" onclick="return confirm('Are you sure?')">Remove</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
