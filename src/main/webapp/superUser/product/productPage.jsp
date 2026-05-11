<%@ page import="static org.example.util.NamesUtil.MAIN_PAGE_ADMINISTRATOR" %>
<%@ page import="org.example.dto.ProductDTO" %>
<%@ page import="static org.example.util.NamesUtil.MAIN_PAGE_CLIENT" %>
<%@ page import="org.example.dto.NewDTO.NewProductDTO" %>
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
    NewProductDTO newProductDTO = (NewProductDTO) request.getAttribute("productDTO");%>
<div>Номер товара: <%=newProductDTO.getId()%>
</div>
<br>
<div>Название товара: <%=newProductDTO.getProductName()%>
</div>
<br>
<div>Категория: <%=newProductDTO.getProductCategory().getCategory()%>
</div>
<br>
<div>Цена: <%=newProductDTO.getPrice()%>
</div>
<br>
<div>Продавец: <%=newProductDTO.getSeller().getSellerName()%>, <%=newProductDTO.getSeller().getSellerAddress()%>
</div>
<br>
<div>Обновлено: <%=newProductDTO.getUpdateDateTime()%>
</div>
<br>
</body>
</html>
