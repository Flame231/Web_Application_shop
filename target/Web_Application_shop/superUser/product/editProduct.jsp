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
    <%
        String productId = request.getParameter("productId");
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProduct(productId);
    %>
    <title>Редактировать продукт</title>
    <h1>Редактировать продукт</h1>
    <form action="updateProduct" method="post">
        Номер продукта:
        <%=product.getId()%>
        <input type="hidden" name="productId" value="<%=product.getId()%>">
        <div>
            Название продукта:
            <input type="text" name="productName" value="<%=product.getProductName()%>">
        </div>

        <div>
            Категория продукта:
            <select name="productCategory">
                <option value="<%=product.getProductCategory().getId()%>" selected>
                    <%=product.getProductCategory().getCategory()%>
                </option>
                <%
                    List<ProductCategoryDTO> list = (List<ProductCategoryDTO>) request.getAttribute("productCategoryDTOList");
                    for (ProductCategoryDTO productCategoryDTO : list) {
                        if (!productCategoryDTO.getId().equals(product.getProductCategory().getId())) {
                %>
                <option value="<%=productCategoryDTO.getId()%>"><%=productCategoryDTO.getCategory()%>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        <div>
            Цена:
            <input name="price" value="<%=product.getPrice()%>">
        </div>

        <div>
            Продавец:
            <select name="seller">
                <option value="<%=product.getSeller().getId()%>" selected><%=product.getSeller().getSellerName()%>
                </option>
                <%
                    List<SellerDTO> listSeller = (List<SellerDTO>) request.getAttribute("sellerDTOList");
                    for (SellerDTO sellerDTO : listSeller) {
                        if (!product.getSeller().getId().equals(sellerDTO.getId())) {
                %>
                <option value="<%=sellerDTO.getId()%>"><%=sellerDTO.getSellerName()%>
                </option>
                <%
                        }
                    } %>

            </select>
        </div>
        <input type="submit" value="Подтвердить">
    </form>
</head>
<body>
</body>
</html>
