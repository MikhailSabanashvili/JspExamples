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
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Посредством таких тегов в jsp можно писать код на java -->
<%
    ArrayList<User> users = (ArrayList<User>) request.getAttribute("usersFromServer");
%>
<table>
    <!-- тег для определения строки в таблице  -->
    <tr>
        <!-- Тег <th> предназначен для создания одной ячейки таблицы, которая обозначается как
        заголовочная. Текст в такой ячейке отображается браузером обычно жирным шрифтом
         и выравнивается по центру.  -->
        <th>User name</th>
        <th>Birth Date</th>
    </tr>
    <%
        for(User user: users){


    %>
    <tr>
        <!-- Ячейка таблицы. Фактически мы сейчас находимся в цикле for и печатаем
         значения в ячейки таблицы-->
        <td><%=user.getName()%></td>
        <td><%=user.getBirthDate()%></td>
    </tr>
    <!-- Закрыли цикл -->
    <%}%>
</table>
</body>
</html>
