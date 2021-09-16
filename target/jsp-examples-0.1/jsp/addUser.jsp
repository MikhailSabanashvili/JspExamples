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
        Please, add user
    </div>
    <!-- Указываем в форме тип запроса, который уйдет со странички на сервер и куда уйдет -->
    <form method="post" action="${pageContext.request.contextPath}/users">
        <label for="first-name">First Name
            <input class="input-field" type="text" id="first-name" name="first-name">
        </label>
        <!-- текст - когда обычный текст, пароль - когда точки -->
        <label for="last-name">Last Name
            <input class="input-field" type="text" id="last-name" name="last-name">
        </label>
        <!-- сделаем кнопочку для отправки -->
        <input type="submit" value="Add user">
    </form>
</div>


</body>
</html>
