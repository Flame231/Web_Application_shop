<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ProductDTO" %>
<%@ page import="static org.example.util.NamesUtil.SHOW_BAG" %>
<%@ page import="static org.example.util.NamesUtil.ACCOUNT_JSP" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page import="org.example.dao.bag.BagDAO" %>
<%@ page import="org.example.dao.bag.BagDAOImpl" %>
<%@ page import="org.example.model.User" %>
<%@ page import="org.example.dao.user.UserDAO" %>
<%@ page import="org.example.dao.user.UserDAOImpl" %>
<%@ page import="org.example.model.Bag" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.example.model.Product" %>
<%@ page import="org.example.dao.product.ProductDAO" %>
<%@ page import="org.example.dao.product.ProductDAOImpl" %>
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
    <br><a href="<%=ACCOUNT_JSP%>">Вернуться в личный кабинет</a></br>
    <title>Каталог товаров</title>
    <h1>Каталог товаров</h1>
    <form action="<%=SHOW_BAG%>" method="post">
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
        // Получаем список из request, который положил туда Сервлет
        List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("productList");
        UserDAO userDAO = new UserDAOImpl();
        Integer userId = (Integer)(session.getAttribute("userId"));
        User user = userDAO.get(userId);
        Set<Bag> bags = user.getBags();
        int value = 0;
        ProductDAO productDAO = new ProductDAOImpl();

        // Проверяем, что список не null, чтобы не было ошибки

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
        <td><%= productDTO.getProductName() %>
        </td>
        <td><%= productDTO.getProductCategory().getCategory() %>
        </td>
        <td><%= productDTO.getPrice() %>
        </td>
        <td><%= productDTO.getSeller().getSellerName() %>
        </td>
        <td>
            <form action="<%=ADD_TO_BAG%>" method="post">
                <input type="hidden" name="func" value="catalog">
                <input type="submit" value="Редактировать количество"/>
                <input type="hidden" name="productId" value="<%= productDTO.getId()%>"/>
                Количество: <input type="number" name="count"
                                   value="<%=value%>" min="0" max="99" step="1">
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
