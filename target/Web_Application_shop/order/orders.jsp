<%@ page import="java.util.List" %>
<%@ page import="javax.swing.*" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page import="org.example.dto.dto.UserOrderDTO" %>
<%@ page import="org.example.dto.dto.UserOrderProductDTO" %>
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
    <div>
        <form action="<%=request.getContextPath() + MAIN_PAGE_CLIENT%>" method="post">
            <input type="submit" value="Вернуться в личный кабинет">
        </form>
    </div>
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

<div>Номер заказа:<%=userOrderDTO.getOrderId()%>
</div>
<br>
<div>Статус заказа: <%=userOrderDTO.getOrderStatus().getDescription()%>
</div>
<br>
<div>Пункт выдачи: <%=userOrderDTO.getOrderPoint()%>
</div>
<br>
<div>Сумма заказа: <%=userOrderDTO.getOrderSum()%>
</div>
<br>
<div>Дата создания: <%=userOrderDTO.getOrderCreateDateTime()%>
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

    <%for (UserOrderProductDTO userOrderProductDTO : userOrderDTO.getUserOrderProducts()) {%>
    <tr>

        <td><%=userOrderProductDTO.getProductDTO().getProductName()%>
        </td>

        <td>
            <%=userOrderProductDTO.getProductDTO().getPrice()%>
        </td>

        <td>
            <%=userOrderProductDTO.getProductCount()%>
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
     Список заказов пуст
    <%
        }
    %>
</body>
</html>
