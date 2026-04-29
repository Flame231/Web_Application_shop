<%@ page import="org.example.dao.seller.SellerDAOImpl" %>
<%@ page import="org.example.dao.seller.SellerDAO" %>
<%@ page import="org.example.model.Seller" %>
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
