<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ProductBagDTO" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="static org.example.util.NamesUtil.ACCOUNT_JSP" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page import="org.example.dto.OrderPointDTO" %>
<%@ page import="javax.swing.*" %>
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
    <form action="<%=SHOW_CATALOG%>" method="post">
        <input type="submit" value="Вернуться назад">
    </form>
    <h1>Каталог товаров</h1>
    <div><a href="<%=ACCOUNT_JSP%>">Вернуться в личный кабинет</a></div>
    <title>Каталог товаров</title>

    <%List<OrderPointDTO> orderPointList = (List<OrderPointDTO>) request.getAttribute("orderPointList");%>


    <br>
    <br>
</head>
<body>
<form action="confirmOrder" method="post">
    <input type="submit" value="Оформить заказ">
    Выбрать пункт выдачи:
    <select name="orderPointId">
        <%for (OrderPointDTO orderPointDTO : orderPointList) {%>
        <option value="<%=orderPointDTO.getId()%>">
            <%=orderPointDTO.getOrderPointAddress()%>
        </option>
        <%}%>
    </select>
    <table>
        <thead>
        <tr>
            <th>Название товара</th>
            <th>Категория</th>
            <th>Цена</th>
            <th>Продавец</th>
            <th>Количество</th>
            <th>Редактировать</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<ProductBagDTO> products = (List<ProductBagDTO>) request.getAttribute("BagList");
            Integer totalCount = 0;
            BigDecimal sum = new BigDecimal(0);
            if (products != null && !products.isEmpty()) {
                for (ProductBagDTO productbagDTO : products) {
        %>
        <tr>
            <td><%= productbagDTO.getProductName() %>
            </td>
            <td><%= productbagDTO.getCategory() %>
            </td>
            <td><%= productbagDTO.getPrice() %>
            </td>
            <td><%= productbagDTO.getSellerName() %>
            </td>
            <td><%= productbagDTO.getCount() %>
            </td>
            <td>


                <input type="hidden" name="func" value="bag"/>
                <input type="hidden" name="productId" value="<%=productbagDTO.getProductId()%>"/>
                Количество:
                <input type="number" name="count"
                       value="<%=productbagDTO.getCount()%>" min="0" max="99" step="1"/>
            </td>
        </tr>

        <%
            totalCount += productbagDTO.getCount();
            sum = sum.add((new BigDecimal(productbagDTO.getCount()).multiply(productbagDTO.getPrice())));

        %>
        <input type="hidden" name="productPrice"
               value="<%=new BigDecimal(productbagDTO.getCount()).multiply(productbagDTO.getPrice())%>">
        <%

            }
        } else {
        %>
        <tr>
            <td colspan="2" style="text-align: center;">Корзина пуста".</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <div>Количество: <%= totalCount%>
    </div>
    <div>Цена: <%= sum%>
    </div>
</form>
</body>
</html>
