<%@ page import="java.util.List" %>
<%@ page import="static org.example.util.NamesUtil.EDIT_PRODUCT" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page import="org.example.dto.NewDTO.NewProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>

    table {
        width: 50%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    {
        display: grid
    ;
        grid-template-columns: 120px 300px
    ;
        gap: 15px
    ;
        align-items: center
    ;
    }
</style>
<html>
<head>
    <form action="<%=request.getContextPath() + MAIN_PAGE_ADMINISTRATOR%>" method="post">
        <input type="submit" value="Вернуться в личный кабинет">
    </form>
    <title>Редактировать каталог</title>
    <h1>Редактировать каталог товаров</h1>
</head>
<body>
<form action="<%=request.getContextPath() + ADD_PRODUCT_PAGE%>" method="post">
    <input type="submit" value="Добавить товар в каталог">
</form>
<table>
    <thead>
    <tr>
        <th>Номер товара</th>
        <th>Название</th>
        <th>Категория</th>
        <th>Цена</th>
        <th>Продавец</th>
        <th>Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<NewProductDTO> products = (List<NewProductDTO>) request.getAttribute("productList");
        if (products != null && !products.isEmpty()) {
            for (NewProductDTO newProductDTO : products) {
    %>
    <tr>
        <td><%= newProductDTO.getId() %>
        </td>
        <td><%= newProductDTO.getProductName() %>
        </td>
        <td><%= newProductDTO.getProductCategory().getCategory() %>
        </td>
        <td><%= newProductDTO.getPrice() %>
        </td>
        <td><%= newProductDTO.getSeller().getSellerName() %>
        </td>
        <td>
            <form method="post">
                <input type="hidden" name="productId" value="<%=newProductDTO.getId()%>">
                <input type="hidden" name="func" value="catalog">
                <input type="submit" value="Редактировать" formaction="<%=request.getContextPath() + EDIT_PRODUCT%>"/>
                <input type="submit" value="Удалить" formaction="<%=request.getContextPath() + REMOVE_PRODUCT%>"/>
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2" style="text-align: center;">База товаров пуста".</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
