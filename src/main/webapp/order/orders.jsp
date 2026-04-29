<%@ page import="java.util.List" %>
<%@ page import="static org.example.util.NamesUtil.ACCOUNT_JSP" %>
<%@ page import="javax.swing.*" %>
<%@ page import="org.example.dto.UserOrderDTO" %>
<%@ page import="org.example.model.UserOrderProduct" %>
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
    <div><a href="<%=ACCOUNT_JSP%>">Вернуться в личный кабинет</a></div>
    <h1>Мои Заказы</h1>
    <title>Мои Заказы</title>
    <br>
    <br>
</head>
<body>
<% List<UserOrderDTO> list = (List<UserOrderDTO>) request.getAttribute("userOrderDTOList");
    if (list != null && !list.isEmpty()) {
        for (UserOrderDTO userOrderDTO : list) {
%>

<div>Номер заказа:<%=userOrderDTO.getId()%>
</div>
<br>
<div>Статус заказа: <%=userOrderDTO.getOrderStatus()%>
</div>
<br>
<div>Пункт выдачи: <%=userOrderDTO.getOrderPoint().getOrderPointAddress()%>
</div>
<br>
<div>Сумма заказа: <%=userOrderDTO.getOrderSum()%>
</div>
<br>
<div>Дата создания: <%=userOrderDTO.getCreateDateTime()%>
</div>
<br>

<table>
    <thead>
    <tr>
        <th>Название товара</th>
        <th>Цена</th>
        <th>Количество</th>
    </tr>
    </thead>
    <tbody>

    <%for (UserOrderProduct userOrderProduct : userOrderDTO.getUserOrderProduct()) {%>
    <tr>

        <td><%=userOrderProduct.getProduct().getProductName()%>
        </td>

        <td>
            <%=userOrderProduct.getProduct().getPrice()%>
        </td>

        <td>
            <%=userOrderProduct.getProductCount()%>
        </td>

    </tr>
    <%}%>
    </tbody>
</table>
<br>
<br>
<br>
<br>
<%}%>
<%
} else {
%>
<table>
    <tbody>
    <tr>
        <td colspan="2" style="text-align: center;">Список заказов пуст.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
