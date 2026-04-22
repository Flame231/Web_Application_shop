<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ProductDTO" %>
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

    /* Стилизуем форму как сетку */
    .my-form {
        display: grid;
        grid-template-columns: 120px 300px; /* 1-я колонка для текста, 2-я для полей */
        gap: 15px; /* Расстояние между строками и столбцами */
        align-items: center; /* Центрируем текст по вертикали относительно инпута */
    }
</style>
<html>
<head>
    <form action="showBag" method="post">
        <input type="submit" value="Корзина">
        <input name="page" type="hidden" value="bag">
    </form>
    <title>Каталог товаров</title>
    <h1>Каталог товаров</h1>
    <a href="shop.jsp">Вернуться в личный кабинет</a>
    <br>
    <br>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>Номер товара</th>
        <th>Название</th>
        <th>Категория</th>
        <th>Цена</th>
        <th>Продавец</th>
        <th>Добавление в корзину</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Получаем список из request, который положил туда Сервлет
        List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("productList");

        // Проверяем, что список не null, чтобы не было ошибки
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
            <form action="addToBag" method="post">
                <input type="hidden" name="func" value="catalog">
                <input type="submit" value="Добавить в корзину"/>
                <input type="hidden" name="product_id" value="<%= productDTO.getId() %>"/>
                Количество: <input type="number" name="count"
                                   value="0" min="0" max="99" step="1">
            </form>
            <%
                }%>
        </td>

    </tr>
    <%
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
