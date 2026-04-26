<%@ page import="org.example.dto.ProductDTO" %>
<%@ page import="org.example.dao.product.ProductDAO" %>
<%@ page import="org.example.dao.product.ProductDAOImpl" %>
<%@ page import="org.example.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.ProductCategoryDTO" %>
<%@ page import="org.example.service.product.ProductService" %>
<%@ page import="org.example.service.product.ProductServiceImpl" %>
<%@ page import="org.example.model.Seller" %>
<%@ page import="org.example.dto.SellerDTO" %>
<%@ page import="org.example.model.ProductCategory" %>
<%@ page import="org.example.service.productCategory.ProductCategoryService" %>
<%@ page import="org.example.service.productCategory.ProductCategoryServiceImpl" %>
<%@ page import="org.example.service.seller.SellerServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: System Administrator
  Date: 25.04.2026
  Time: 13:17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить товар в каталог</title>
    <h1>Добавить товар в каталог</h1>
    <form action="addProduct" method="post">
        <div>
            Название продукта:
            <input type="text" name="productName">
        </div>
        <div>
            Категория продукта:
            <select name="productCategory">
                </option>
                <%
                    List<ProductCategoryDTO> list = (List<ProductCategoryDTO>) request.getAttribute("productCategoryDTOList");
                    for (ProductCategoryDTO productCategoryDTO : list) {
                %>
                <option value="<%=productCategoryDTO.getId()%>"><%=productCategoryDTO.getCategory()%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
        <div>
            Цена:
            <input name="price">
        </div>

        <div>
            Продавец:
            <select name="seller">
                <%
                    List<SellerDTO> listSeller = (List<SellerDTO>) request.getAttribute("sellerDTOList");
                    for (SellerDTO sellerDTO : listSeller) {
                %>
                <option value="<%=sellerDTO.getId()%>"><%=sellerDTO.getSellerName()%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
        <input type="submit" value="Подтвердить">
    </form>
</head>
<body>
</body>
</html>
