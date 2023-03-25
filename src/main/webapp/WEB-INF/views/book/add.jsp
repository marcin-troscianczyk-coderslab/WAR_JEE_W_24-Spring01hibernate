<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>

<h3>Add book</h3>

<form:form method="post" modelAttribute="book">

    Title: <form:input path="title"/>
    Description: <form:input path="description"/>
    Rating: <form:input path="rating" type="number"/>
    Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>
    Authors: <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id" multiple="true"/>
    <input type="submit" value="Add book">
</form:form>

</body>
</html>
