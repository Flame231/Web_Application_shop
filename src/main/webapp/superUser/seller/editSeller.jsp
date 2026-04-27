<%@ page import="org.example.model.ProductCategory" %>
<%@ page import="org.example.dao.productCategory.ProductCategoryDAO" %>
<%@ page import="org.example.dao.productCategory.ProductCategoryDAOImpl" %>
<%@ page import="org.example.dao.seller.SellerDAOImpl" %>
<%@ page import="org.example.dao.seller.SellerDAO" %>
<%@ page import="org.example.model.Seller" %><%--
  Created by IntelliJ IDEA.
  User: System Administrator
  Date: 25.04.2026
  Time: 13:13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать продавца</title>
</head>
<body>
<%
    SellerDAO sellerDAO = new SellerDAOImpl();
    Integer sellerId = Integer.parseInt(request.getParameter("sellerId"));
    Seller seller = sellerDAO.get(sellerId);

%>
<form action="updateSeller" method="post">
    Номер продавца:
    <%=seller.getId()%>
    Название продавца:
    <input type="text" name="sellerName" value="<%=seller.getSellerName()%>">
    Адрес продавца:
    <input type="text" name="sellerAddress" value="<%=seller.getSellerAddress()%>">
    <input type="submit" value="Подтвердить">
    <input type="hidden" name="sellerId" value="<%=seller.getId()%>">
</form>
</body>
</html>
