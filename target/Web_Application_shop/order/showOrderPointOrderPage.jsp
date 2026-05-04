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
        <th width="100">Номер товара</th>
        <th width="100">Название товара</th>
        <th width="100">Цена товара</th>
        <th width="60">Заказано товара</th>
        <%if(userOrderDTO.getOrderStatus().equals("Готов")){%>
        <th width="100">Изменить
            количество товара
        </th>
        <%}%>
    </tr>

    <%
        BigDecimal TotalSum = BigDecimal.ZERO;
        BigDecimal actualTotalSum = BigDecimal.ZERO;
        for (UserOrderProduct userOrderProductDTO : userOrderDTO.getUserOrderProduct()) {
    %>
    <tr height="30">
        <td><%=userOrderProductDTO.getProduct().getId()%>
        </td>
        <td><%=userOrderProductDTO.getProduct().getProductName()%>
        </td>
        <td><%=userOrderProductDTO.getProduct().getPrice()%>
        </td>
        <td>
            <%=userOrderProductDTO.getProductCount()%>
        </td>
     <%if(userOrderDTO.getOrderStatus().equals("Готов")){%>
        <td>
            <%=userOrderProductDTO.getActualProductCount()%>
            <form action="<%=request.getContextPath() + CHANGE_ORDER%>" method="post">
                <input type="submit" name="plus" value="+">
                <input type="hidden" name="count" value="1">
                <input type="hidden" name="userOrderId" value="<%=userOrderProductDTO.getUserOrder().getId()%>">
                <input type="hidden" name="productId" value="<%=userOrderProductDTO.getProduct().getId()%>">
            </form>

            <form action="<%=request.getContextPath() + CHANGE_ORDER%>" method="post">
                <input type="submit" name="minus" value="-">
                <input type="hidden" name="count" value="-1">
                <input type="hidden" name="userOrderId" value="<%=userOrderProductDTO.getUserOrder().getId()%>">
                <input type="hidden" name="productId" value="<%=userOrderProductDTO.getProduct().getId()%>">
            </form>
        </td>
        <%}
            BigDecimal productSum = userOrderProductDTO.getProduct().getPrice()
                    .multiply(new BigDecimal(userOrderProductDTO.getProductCount()));
            TotalSum = TotalSum.add(productSum);
            BigDecimal actualProductSum = userOrderProductDTO.getProduct().getPrice()
                    .multiply(new BigDecimal(userOrderProductDTO.getActualProductCount()));
            actualTotalSum = actualTotalSum.add(actualProductSum);
        %>
    </tr>
    <%}%>
</table>
<div>Сумма заказа: <%=TotalSum%>
    <br>
    <%if(userOrderDTO.getOrderStatus().equals("Готов")){%>
    Итоговая сумма заказа: <%=actualTotalSum%>
    <%}%>
</div>
</body>
</html>
