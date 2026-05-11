<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.NewDTO.ArchivedUserOrderDTO" %>
<%@ page import="org.example.dto.NewDTO.ArchivedUserOrderProductDTO" %>
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
Статус заказа: <%=archivedUserOrderDTO.getOrderStatus().getDescription()%><br>
Сумма заказа: <%=archivedUserOrderDTO.getOrderSum()%><br>
Сумма выкупленных товаров: <%=archivedUserOrderDTO.getFinalOrderSum()%><br>
Дата создания заказа: <%=archivedUserOrderDTO.getUserOrderCreateDateTime()%><br>
Дата закрытия заказа:<%=archivedUserOrderDTO.getCreateDateTime()%><br>
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
        for (ArchivedUserOrderProductDTO archivedUserOrderProductDTO : archivedUserOrderDTO.getArchivedUserOrderProducts()) {
    %>
    <tr>
        <td><%=archivedUserOrderProductDTO.getProductName()%>
        </td>
        <td><%=archivedUserOrderProductDTO.getProductCount()%>
        </td>
        <td><%=archivedUserOrderProductDTO.getFinalProductCount()%>
        </td>
        <td><%=archivedUserOrderProductDTO.getPrice()%>
        </td>
    </tr>
    <%
        }%>

</table>
<br>
<%
    }
%>
</body>
</html>
