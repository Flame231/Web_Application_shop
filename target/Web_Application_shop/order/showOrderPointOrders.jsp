<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.UserOrderDTO" %>
<%@ page import="org.example.model.UserOrderProduct" %>
<%@ page import="static org.example.util.NamesUtil.MAIN_PAGE_CLIENT" %>
<%@ page import="static org.example.util.NamesUtil.SHOW_ORDER_POINT_ORDER_PAGE" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="<%=request.getContextPath() + MAIN_PAGE_OPERATOR%>" method="post">
        <input type="submit" value="Вернуться в личный кабинет">
    </form>
    <title>Заказы на пункте выдачи</title>

</head>
<body>
<h1>Заказы на пункте выдачи</h1>
<%
    List<UserOrderDTO> userOrderDTOList = (List<UserOrderDTO>) request.getAttribute("userOrderDTOList");
%>
<div>Ваш пункт выдачи: <%=userOrderDTOList.get(0).getOrderPoint().getOrderPointAddress()%>
</div>
<%for (UserOrderDTO userOrderDTO : userOrderDTOList) {%>
<br>
<div><a href="<%=request.getContextPath() + SHOW_ORDER_POINT_ORDER_PAGE%>?userOrderId=<%=userOrderDTO.getId()%>">Номер
    заказа: <%=userOrderDTO.getId()%>
</a>
</div>
<br>
<table border="2">
    <tr>
        <th>Название товара</th>
        <th>Цена товара</th>
        <th>Количество товара</th>
    </tr>
    <%for (UserOrderProduct userOrderProductDTO : userOrderDTO.getUserOrderProduct()) {%>
    <tr>
        <td><%=userOrderProductDTO.getProduct().getProductName()%>
        </td>
        <td><%=userOrderProductDTO.getProduct().getPrice()%>
        </td>
        <td><%=userOrderProductDTO.getProductCount()%>
        </td>
        <%}%>
    </tr>
</table>
<div>Сумма заказа: <%=userOrderDTO.getOrderSum()%>
</div>
<%}%>

</body>
</html>
