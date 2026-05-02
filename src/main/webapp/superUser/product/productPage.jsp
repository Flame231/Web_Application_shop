<%@ page import="static org.example.util.NamesUtil.MAIN_PAGE_ADMINISTRATOR" %>
<%@ page import="org.example.dto.ProductDTO" %>
<%@ page import="static org.example.util.NamesUtil.MAIN_PAGE_CLIENT" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница товара</title>
    <form action="<%=request.getContextPath() + MAIN_PAGE_CLIENT%>" method="post">
        <input type="submit" value="Вернуться в личный кабинет">
    </form>
    <h1>Страница товара</h1>
</head>
<body>
<%
    ProductDTO productDTO = (ProductDTO) request.getAttribute("productDTO");%>
<div>Номер товара: <%=productDTO.getId()%>
</div>
<br>
<div>Название товара: <%=productDTO.getProductName()%>
</div>
<br>
<div>Категория: <%=productDTO.getProductCategory().getCategory()%>
</div>
<br>
<div>Цена: <%=productDTO.getPrice()%>
</div>
<br>
<div>Продавец: <%=productDTO.getSeller().getSellerName()%>, <%=productDTO.getSeller().getSellerAddress()%>
</div>
<br>
<div>Обновлено: <%=productDTO.getUpdateDateTime()%>
</div>
<br>
</body>
</html>
