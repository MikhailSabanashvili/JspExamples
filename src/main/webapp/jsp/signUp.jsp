<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.sabanashvili.modules.User" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 26.03.2021
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<!-- Понимай это как сторону клиента. Это страничка, которая генерируется джавой -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- доступен весь набор тэгов jsp через префикс c-->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please, sign up!
    </div>
    <!-- Указываем в форме тип запроса, который уйдет со странички на сервер и куда уйдет -->
    <form method="post" action="${pageContext.request.contextPath}/signUp">
        <label for="name">User name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <!-- текст - когда обычный текст, пароль - когда точки -->
        <label for="birthDate">Birth date
            <input class="input-field" type="date" id="birthDate" name="birthDate">
        </label>
        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <!-- сделаем кнопочку для отправки -->
        <input type="submit" value="Sign Up">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered:
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.birthDate}</td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>
