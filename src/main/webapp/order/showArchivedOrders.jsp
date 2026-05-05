<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ArchivedUserOrderDTO" %><%--
  Created by IntelliJ IDEA.
  User: System Administrator
  Date: 05.05.2026
  Time: 16:11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>История заказов</title>
</head>
<body>
<h1>История заказов</h1>
<%List<ArchivedUserOrderDTO> archivedUserOrderDTOList = (List<ArchivedUserOrderDTO>) request.getAttribute("archivedUserOrderDTOList");
for(ArchivedUserOrderDTO archivedUserOrderDTO :archivedUserOrderDTOList ){
    archivedUserOrderDTO.getOrderSum();
    archivedUserOrderDTO.getOrderStatus();
    archivedUserOrderDTO.getProductCount();
    archivedUserOrderDTO.getOrderSum();
%>
<%}%>
</body>
</html>
