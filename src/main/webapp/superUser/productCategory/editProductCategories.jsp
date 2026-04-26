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
<%@ page import="org.example.model.ProductCategory" %>
<%@ page import="org.example.dto.ProductCategoryDTO" %>
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
    <title>Редактировать категории товаров</title>
    <h1>Категории</h1>
</head>
<body>
<form action="superUser/productCategory/addProductCategory.jsp" method="post">
    <input type="submit" value="Добавить категорию">
</form>
<table>
    <thead>
    <tr>
        <th>Номер категории товара</th>
        <th>Категория</th>
        <th>Редактировать</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Получаем список из request, который положил туда Сервлет
        List<ProductCategoryDTO> productCategories = (List<ProductCategoryDTO>) request.getAttribute("productCategoriesList");

        // Проверяем, что список не null, чтобы не было ошибки
        if (productCategories != null && !productCategories.isEmpty()) {
            for (ProductCategoryDTO productCategoryDTO : productCategories) {

    %>
    <tr>
        <td><%= productCategoryDTO.getId() %>
        </td>

        <td><%= productCategoryDTO.getCategory() %>
        </td>

        <td>
            <form  method="post">
                <input type="submit" value="Редактировать" formaction="editProductCategory">
                <input type="submit" value="Удалить" formaction="removeProductCategory">
                <input type="hidden" name="productCategoryId" value="<%=productCategoryDTO.getId()%>">
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2" style="text-align: center;">База категорий пуста".</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
