<%@ page import="org.example.dto.ProductDTO" %>
<%@ page import="org.example.dao.product.ProductDAO" %>
<%@ page import="org.example.dao.product.ProductDAOImpl" %>
<%@ page import="org.example.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ProductCategoryDTO" %><%--
  Created by IntelliJ IDEA.
  User: System Administrator
  Date: 25.04.2026
  Time: 13:17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        ProductDAO productDAO = new ProductDAOImpl();
        Product product = productDAO.get(request.getParameter("productId"));
    %>
    <title>Редактировать продукт</title>
    <h1>Редактировать продукт</h1>
    Номер продукта:
    <%=product.getId()%>
    Название продукта:
    <input type="text" name="productName" value="<%=product.getProductName()%>">

    Категория продукта:
    <select name="productCategory">
        <%
            List<ProductCategoryDTO> list = (List<ProductCategoryDTO>) request.getAttribute("productCategoryDTOList");
            for (ProductCategoryDTO productCategoryDTO : list) {
        %>
        <option value="<%=productCategoryDTO%>"><%=productCategoryDTO.getCategory()%></option>
        <%
            }
        %>
    </select>
</head>
<body>
</body>
</html>
