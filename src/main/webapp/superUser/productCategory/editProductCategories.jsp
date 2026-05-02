<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ProductCategoryDTO" %>
<%@ page import="static org.example.util.NamesUtil.REMOVE_PRODUCT_CATEGORY" %>
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
    <form action="<%=request.getContextPath() + MAIN_PAGE_ADMINISTRATOR%>" method="post">
        <input type="submit" value="Вернуться в личный кабинет">
    </form>
    <title>Редактировать категории товаров</title>
    <h1>Категории</h1>
</head>
<body>
<form action="<%=request.getContextPath() + ADD_PRODUCT_CATEGORY_PAGE%>" method="post">
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
        List<ProductCategoryDTO> productCategories = (List<ProductCategoryDTO>) request.getAttribute("productCategoriesList");
        if (productCategories != null && !productCategories.isEmpty()) {
            for (ProductCategoryDTO productCategoryDTO : productCategories) {

    %>
    <tr>
        <td><%= productCategoryDTO.getId() %>
        </td>

        <td><%= productCategoryDTO.getCategory() %>
        </td>

        <td>
            <form method="post">
                <input type="submit" value="Редактировать"
                       formaction="<%=request.getContextPath() + EDIT_PRODUCT_CATEGORY%>">
                <input type="submit" value="Удалить"
                       formaction="<%=request.getContextPath() + REMOVE_PRODUCT_CATEGORY%>">
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
