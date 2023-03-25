<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="person">
    <form:input path="login" />
    <form:password path="password" />
    <form:input type="email" path="email"/>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
