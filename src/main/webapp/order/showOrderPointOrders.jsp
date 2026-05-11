<%@ page import="java.util.List" %>
<%@ page import="static org.example.util.NamesUtil.SHOW_ORDER_POINT_ORDER_PAGE" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page import="org.example.dto.NewDTO.NewUserOrderDTO" %>
<%@ page import="org.example.dto.NewDTO.NewUserOrderProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="<%=request.getContextPath() + "/" + ROLE +"/MainPage"%>" method="post">
        <input type="submit" value="Вернуться в личный кабинет">
    </form>
    <title>Заказы на пункте выдачи</title>

</head>
<body>
<h1>Заказы на пункте выдачи</h1>
<form action="<%=request.getContextPath() + SHOW_ARRIVED_ORDER_POINT_ORDERS%>" method="post">
    <input type="submit" value="Доставленные заказы">
</form>
<%
    List<NewUserOrderDTO> newUserOrderDTOList = (List<NewUserOrderDTO>) request.getAttribute("userOrderDTOList");
    if (newUserOrderDTOList != null && !newUserOrderDTOList.isEmpty()) {
%>

<div>Ваш пункт выдачи: <%=newUserOrderDTOList.get(0).getOrderPoint()%>
</div>
<%for (NewUserOrderDTO newUserOrderDTO : newUserOrderDTOList) {%>
<br>
<div>
    <a href="<%=request.getContextPath() + SHOW_ORDER_POINT_ORDER_PAGE%>?userOrderId=<%=newUserOrderDTO.getOrderId()%>">Номер
        заказа: <%=newUserOrderDTO.getOrderId()%>
    </a>
</div>
<br>
<table border="2">
    <tr>
        <th>Название товара</th>
        <th>Цена товара</th>
        <th>Количество товара</th>
    </tr>
    <%for (NewUserOrderProductDTO newUserOrderProductDTO : newUserOrderDTO.getUserOrderProducts()) {%>
    <tr>
        <td>
            <a href="<%=request.getContextPath() + PRODUCT_PAGE+"?productId="+ newUserOrderProductDTO.getNewProductDTO().getId()%>"><%= newUserOrderProductDTO.getNewProductDTO().getProductName() %><a/>
        </td>
        <td><%=newUserOrderProductDTO.getNewProductDTO().getPrice()%>
        </td>
        <td><%=newUserOrderProductDTO.getProductCount()%>
        </td>
        <%}%>
    </tr>
</table>
<div>Сумма заказа: <%=newUserOrderDTO.getOrderSum()%>
</div>
<%
    }
} else {
%>
Нет активных заказов
<%}%>

</body>
</html>
