<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ArchivedUserOrderDTO" %>
<%@ page import="java.util.Objects" %>
Created by IntelliJ IDEA.
User: System Administrator
Date: 05.05.2026
Time: 16:11:59
To change this template use File | Settings | File Templates.
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>История заказов</title>
</head>
<body>

<h1>История заказов</h1>
<%
    List<ArchivedUserOrderDTO> archivedUserOrderDTOList = (List<ArchivedUserOrderDTO>) request.getAttribute("archivedUserOrderDTOList");
    for (ArchivedUserOrderDTO archivedUserOrderDTO : archivedUserOrderDTOList) {
%>
Номер заказа:<%=archivedUserOrderDTO.getUserOrderId()%><br>
Статус заказа: <%=archivedUserOrderDTO.getOrderStatus()%><br>
Сумма заказа: <%=archivedUserOrderDTO.getOrderSum()%><br>
Сумма выкупленных товаров: <%=archivedUserOrderDTO.getFinalOrderSum()%><br>
Дата создания заказа: <%=archivedUserOrderDTO.getUserOrderCreateDateTime()%><br>
Дата закрытия заказа:<%=archivedUserOrderDTO.getUserOrderCloseDateTime()%><br>
<table border="2">
    <thead>
    <tr>
        <th>Название продукта</th>
        <th>Заказанное количество продукта</th>
        <th>Выкупленное количество продукта</th>
        <th>Цена продукта на момент заказа</th>
    </tr>
    </thead>

    <%
        for (ArchivedUserOrderDTO archivedUserOrderDTO1 : archivedUserOrderDTOList) {
            if (Objects.equals(archivedUserOrderDTO.getUserOrderId(), archivedUserOrderDTO1.getUserOrderId())) {
    %>
    <tr>
        <td><%=archivedUserOrderDTO1.getProductName()%>
        </td>
        <td><%=archivedUserOrderDTO1.getProductCount()%>
        </td>
        <td><%=archivedUserOrderDTO1.getActualProductCount()%>
        </td>
        <td><%=archivedUserOrderDTO1.getProductPrice()%>
        </td>
    </tr>
    <%}
        }
    %>


</table>
<%}%>

</body>
</html>
