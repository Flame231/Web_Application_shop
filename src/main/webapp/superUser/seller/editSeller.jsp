<%@ page import="org.example.dao.seller.SellerDAOImpl" %>
<%@ page import="org.example.dao.seller.SellerDAO" %>
<%@ page import="org.example.model.Seller" %>
<%@ page import="static org.example.util.NamesUtil.MAIN_PAGE_ADMINISTRATOR" %>
<%@ page import="static org.example.util.NamesUtil.UPDATE_SELLER" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать продавца</title>
    <form action="<%=request.getContextPath() + MAIN_PAGE_ADMINISTRATOR%>" method="post">
        <input type="submit" value="Вернуться в личный кабинет">
    </form>
</head>
<body>
<%
    SellerDAO sellerDAO = new SellerDAOImpl();
    Integer sellerId = Integer.parseInt(request.getParameter("sellerId"));
    Seller seller = sellerDAO.get(sellerId);

%>
<form action="<%=request.getContextPath() + UPDATE_SELLER%>" method="post">
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
