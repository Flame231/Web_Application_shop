<%@ page import="org.example.model.ProductCategory" %>
<%@ page import="org.example.dao.productCategory.ProductCategoryDAO" %>
<%@ page import="org.example.dao.productCategory.ProductCategoryDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: System Administrator
  Date: 25.04.2026
  Time: 13:13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить продавца</title>
</head>
<body>

<form action="/Web_Application_shop_war/addSeller" method="post">
    Название продавца:
    <input type="text" name="sellerName">
    Адрес продавца:
    <input type="text" name="sellerAddress">
    <input type="submit" value="Подтвердить">
</form>
</body>
</html>