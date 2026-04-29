<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ProductDTO" %>
<%@ page import="static org.example.util.NamesUtil.ACCOUNT_JSP" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
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
    <br><a href="<%=ACCOUNT_JSP%>">Вернуться в личный кабинет</a></br>
    <title>Редактировать каталог</title>
    <h1>Редактировать каталог товаров</h1>
</head>
<body>
<form action="addProductPage" method="post">
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
        List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("productList");
        if (products != null && !products.isEmpty()) {
            for (ProductDTO productDTO : products) {
    %>
    <tr>
        <td><%= productDTO.getId() %>
        </td>
        <td><%= productDTO.getProductName() %>
        </td>
        <td><%= productDTO.getProductCategory().getCategory() %>
        </td>
        <td><%= productDTO.getPrice() %>
        </td>
        <td><%= productDTO.getSeller().getSellerName() %>
        </td>
        <td>
            <form method="post">
                <input type="hidden" name="productId" value="<%=productDTO.getId()%>">
                <input type="hidden" name="func" value="catalog">
                <input type="submit" value="Редактировать" formaction="<%=EDIT_PRODUCT%>"/>
                <input type="submit" value="Удалить" formaction="removeProduct"/>
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
