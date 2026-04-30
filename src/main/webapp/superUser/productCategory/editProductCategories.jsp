<%@ page import="java.util.List" %>
<%@ page import="static org.example.util.NamesUtil.ACCOUNT_JSP" %>
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
    <title>Редактировать категории товаров</title>
    <h1>Категории</h1>
</head>
<body>
<form action="AddProductCategoryPage" method="post">
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
