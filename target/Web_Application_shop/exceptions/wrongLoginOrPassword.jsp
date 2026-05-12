<%--
  Created by IntelliJ IDEA.
  User: System Administrator
  Date: 12.05.2026
  Time: 14:52:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Ошибка авторизации</title>
</head>
<body>
<h1>Ошибка</h1>
<h2><%=exception.getMessage()%></h2>
<a href="<%=request.getContextPath()%>">Вернуться на главную страницу</a>
</body>
</html>
