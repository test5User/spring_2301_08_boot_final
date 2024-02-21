<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Airplane</title>
</head>
<body>
<h1>Model: ${airplane.model}</h1>
<h2>Places: ${airplane.place}</h2>
<h2>Passengers:</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="passenger" items="${airplane.passengers}">
        <tr>
            <td>${passenger.name}</td>
            <td>
                <a href="/delPass/${airplane.id}/${passenger.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
