<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ProductDTO" %>
<%@ page import="static org.example.util.NamesUtil.SHOW_BAG" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page import="org.example.model.Bag" %>
<%@ page import="java.util.Set" %>
<%@ page import="org.example.dao.product.ProductDAO" %>
<%@ page import="org.example.dao.product.ProductDAOImpl" %>
<%@ page import="org.example.dto.UserDTO" %>
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
    <form action="<%=request.getContextPath()+MAIN_PAGE_CLIENT%>" method="post">
        <input type="submit" value="Вернуться в личный кабинет">
    </form>
    <title>Каталог товаров</title>
    <h1>Каталог товаров</h1>
    <form action="<%=request.getContextPath() + SHOW_BAG%>" method="post">
        <input type="submit" value="Корзина">
        <input name="page" type="hidden" value="bag">
    </form>

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
        <th>Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <%

        List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("productList");
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        Set<Bag> bags = userDTO.getBags();
        int value = 0;
        ProductDAO productDAO = new ProductDAOImpl();

        if (products != null && !products.isEmpty()) {
            for (ProductDTO productDTO : products) {
                for (Bag b1 : bags) {
                    for (Bag b2 : productDAO.get(productDTO.getId()).getBags()) {
                        if (b1 == b2) {
                            value = b1.getCount();
                        }
                    }
                }
    %>
    <tr>
        <td><%= productDTO.getId() %>
        </td>
        <td>
            <a href="<%=request.getContextPath() + PRODUCT_PAGE+"?productId="+ productDTO.getId()%>"><%= productDTO.getProductName() %>
            </a>
        </td>
        <td><%= productDTO.getProductCategory().getCategory() %>
        </td>
        <td><%= productDTO.getPrice() %>
        </td>
        <td><%= productDTO.getSeller().getSellerName() %>
        </td>
        <td>
            В корзине:<%=value%>
            <form action="<%=request.getContextPath() + ADD_TO_BAG%>" method="post">
                <input type="hidden" name="productId" value="<%= productDTO.getId()%>"/>
                <input type="hidden" name="count" value="1">
                <input type="submit" name="plusProduct" value="+">
                <input type="hidden" name="func" value="catalog">
            </form>
            <form action="<%=request.getContextPath() + ADD_TO_BAG%>" method="post">
                <input type="hidden" name="productId" value="<%= productDTO.getId()%>"/>
                <input type="hidden" name="count" value="-1">
                <input type="submit" name="minusProduct" value="-">
                <input type="hidden" name="func" value="catalog">
            </form>

            <%
                    value = 0;
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