<%@ page import="java.util.List" %>
<%@ page import="static org.example.util.NamesUtil.SHOW_BAG" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page import="org.example.dto.NewDTO.NewProductDTO" %>
<%@ page import="org.example.dto.NewDTO.BagDTO" %>
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
    <form action="<%=request.getContextPath()+ "/"+ ROLE + "/MainPage"%>" method="post">
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

        List<NewProductDTO> products = (List<NewProductDTO>) request.getAttribute("productList");
        List<BagDTO> bagDTO = (List<BagDTO>) request.getSession().getAttribute("bagDTOList");
        int value = 0;
        if (products != null && !products.isEmpty()) {
            for (NewProductDTO productDTO : products) {
                for (BagDTO b1 : bagDTO) {
                    if (b1.getProduct().getId().equals(productDTO.getId())) {
                        value = b1.getCount();
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
                }
            %>
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

<% int currentPage = (int) request.getAttribute("currentPage");
    int productCountResult = (int) request.getAttribute("productCountResult");
    int lastPage = productCountResult / PRODUCT_PER_PAGE;
    int minPage = currentPage - 3;
    int maxPage = currentPage + 3;
    if (minPage < 1) {
        minPage = 1;
    }

    if (productCountResult % PRODUCT_PER_PAGE != 0) {
        lastPage = lastPage + 1;
    }
    if (maxPage > lastPage) {
        maxPage = lastPage;
    }%>

<a href="<%=request.getContextPath() + SHOW_CATALOG+"?currentPage=1"%>">Первая
</a>
<% for (int i = minPage; i < maxPage + 1; i++) {
    if (i == currentPage) {%>
<a href="<%=request.getContextPath() + SHOW_CATALOG + "?currentPage=" + i%>"><span style="font-size: 25px;"><%=i%>
</span>&nbsp;
</a>
<%} else {%><a href="<%=request.getContextPath() + SHOW_CATALOG + "?currentPage=" + i%>"><span
        style="font-size: 20px;"><%=i%>
</span>&nbsp;
</a>
<%
        }
    }
%>
<a href="<%=request.getContextPath() + SHOW_CATALOG+"?currentPage=" + lastPage%>">Последняя
</a>
</body>
</html>