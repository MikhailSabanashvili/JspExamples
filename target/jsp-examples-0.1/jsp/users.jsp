<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 15.09.2021
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered:
    </div>
    <table>
        <tr>
            <th>First Name</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="users">
            <tr>
                <td>${users.firstName}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
