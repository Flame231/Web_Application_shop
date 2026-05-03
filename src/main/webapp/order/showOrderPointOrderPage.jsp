<%@ page import="org.example.dto.UserOrderDTO" %>
<%@ page import="org.example.model.UserOrderProduct" %>
<%@ page import="static org.example.util.NamesUtil.MAIN_PAGE_OPERATOR" %>
<%@ page import="static org.example.util.NamesUtil.SHOW_ORDER_POINT_ORDERS" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="<%=request.getContextPath() + MAIN_PAGE_OPERATOR%>" method="post">
        <input type="submit" value="Вернуться в личный кабинет">
    </form>
    <form action="<%=request.getContextPath() + SHOW_ORDER_POINT_ORDERS%>" method="post">
        <input type="submit" value="Назад">
    </form>
    <title>Страница заказа</title>

</head>
<body>
<h1>Страница заказа</h1>
<%
    UserOrderDTO userOrderDTO = (UserOrderDTO) request.getAttribute("userOrderDTO");
%>
Статус заказа: <%=userOrderDTO.getOrderStatus()%>
<br>
<table border="2">
    <tr>
        <th>Номер товара</th>
        <th>Название товара</th>
        <th>Цена товара</th>
        <th>Количество товара</th>
    </tr>

    <%
        BigDecimal TotalSum = BigDecimal.ZERO;
        for (UserOrderProduct userOrderProductDTO : userOrderDTO.getUserOrderProduct()) {
    %>
    <tr>
        <td><%=userOrderProductDTO.getProduct().getId()%>
        </td>
        <td><%=userOrderProductDTO.getProduct().getProductName()%>
        </td>
        <td><%=userOrderProductDTO.getProduct().getPrice()%>
        </td>
        <td><%=userOrderProductDTO.getProductCount()%>
            <form action="<%=CHANGE_BAG%>">
                <input type="submit" name="plus" value="+">
                <input type="hidden" name="count" value="1">
                <input type="hidden" name="userOrderId" value="<%=userOrderProductDTO.getUserOrder().getId()%>">
                <input type="hidden" name="productId" value="<%=userOrderProductDTO.getProduct().getId()%>">
            </form>
            <form action="<%=CHANGE_BAG%>">
                <input type="submit" name="minus" value="-">
                <input type="hidden" name="count" value="-1">
                <input type="hidden" name="userOrderId" value="<%=userOrderProductDTO.getUserOrder().getId()%>">
                <input type="hidden" name="productId" value="<%=userOrderProductDTO.getProduct().getId()%>">
            </form>
        </td>
        <%
            BigDecimal productSum = userOrderProductDTO.getProduct().getPrice()
                    .multiply(new BigDecimal(userOrderProductDTO.getProductCount()));
            TotalSum = TotalSum.add(productSum);
        %>
    </tr>
    <%}%>
</table>
<div>Сумма заказа: <%=TotalSum%>
</div>
</body>
</html>
