<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Airplane</title>
</head>
<body>
<sf:form method="post" action="/save" modelAttribute="airplane">
    <sf:input path="id" type="hidden"/>
    Airplane model: <sf:input path="model"/>
    Airplane place: <sf:input path="place"/>
    <input type="submit" value="Save">
</sf:form>
</body>
</html>
