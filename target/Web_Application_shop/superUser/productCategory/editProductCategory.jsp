<%@ page import="org.example.model.ProductCategory" %>
<%@ page import="org.example.dao.productCategory.ProductCategoryDAO" %>
<%@ page import="org.example.dao.productCategory.ProductCategoryDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: System Administrator
  Date: 25.04.2026
  Time: 13:13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать категорию</title>
</head>
<body>
<%
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAOImpl();
    Integer productCategoryId = Integer.parseInt(request.getParameter("productCategoryId"));
    ProductCategory productCategory = productCategoryDAO.get(productCategoryId);

%>
<form action="updateProductCategory" method="post">
    Номер категории:
    <%=productCategory.getId()%>
    Название категории:
    <input type="text" name="productCategoryName" value="<%=productCategory.getCategory()%>">
    <input type="submit" value="Подтвердить">
    <input type="hidden" name="productCategoryId" value="<%=productCategory.getId()%>">
</form>
</body>
</html>
