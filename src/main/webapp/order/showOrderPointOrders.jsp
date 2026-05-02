<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.UserOrderDTO" %>
<%@ page import="org.example.dto.ProductDTO" %>
<%@ page import="org.example.model.UserOrderProductDTO" %><%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 03.05.2026
  Time: 01:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
<div>Номер заказа: <%=userOrderDTO.getId()%>
</div>
<%for (UserOrderProductDTO userOrderProductDTO : userOrderDTO.getUserOrderProduct()) {%>
<div>Название товара: <%=userOrderProductDTO.getProduct().getProductName()%>
</div>
<div>Цена товара: <%=userOrderProductDTO.getProduct().getPrice()%>
</div>
<%}%>

<div>Сумма заказа: <%=userOrderDTO.getOrderSum()%>
</div>
<% }
%>

</body>
</html>
