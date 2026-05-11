<%@ page import="java.util.List" %>
<%@ page import="org.example.dto.NewDTO.ProductCategoryDTO" %>
<%@ page import="org.example.service.product.ProductService" %>
<%@ page import="org.example.service.product.ProductServiceImpl" %>
<%@ page import="org.example.dto.NewDTO.SellerDTO" %>
<%@ page import="static org.example.util.NamesUtil.PRODUCT_CATEGORY_ID_PARAMETER" %>
<%@ page import="static org.example.util.NamesUtil.MAIN_PAGE_ADMINISTRATOR" %>
<%@ page import="static org.example.util.NamesUtil.*" %>
<%@ page import="org.example.dto.NewDTO.NewProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        ProductService productService = new ProductServiceImpl();
        NewProductDTO newProductDTO = productService.findProduct(productId);
    %>
    <form action="<%=request.getContextPath() + MAIN_PAGE_ADMINISTRATOR%>" method="post">
        <input type="submit" value="Вернуться в личный кабинет">
    </form>
    <title>Редактировать продукт</title>
    <h1>Редактировать продукт</h1>
    <form action="<%=request.getContextPath() + UPDATE_PRODUCT%>" method="post">
        Номер продукта:
        <%=newProductDTO.getId()%>
        <input type="hidden" name="productId" value="<%=newProductDTO.getId()%>">
        <div>
            Название продукта:
            <input type="text" name="productName" value="<%=newProductDTO.getProductName()%>">
        </div>

        <div>
            Категория продукта:
            <select name="<%=PRODUCT_CATEGORY_ID_PARAMETER%>">
                <option value="<%=newProductDTO.getProductCategory().getId()%>" selected>
                    <%=newProductDTO.getProductCategory().getCategory()%>
                </option>
                <%
                    List<ProductCategoryDTO> list = (List<ProductCategoryDTO>) request.getAttribute("productCategoryDTOList");
                    for (ProductCategoryDTO productCategoryDTO : list) {
                        if (!productCategoryDTO.getId().equals(newProductDTO.getProductCategory().getId())) {
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
            <input name="price" value="<%=newProductDTO.getPrice()%>">
        </div>

        <div>
            Продавец:
            <select name="seller">
                <option value="<%=newProductDTO.getSeller().getId()%>"
                        selected><%=newProductDTO.getSeller().getSellerName()%>
                </option>
                <%
                    List<SellerDTO> listSeller = (List<SellerDTO>) request.getAttribute("sellerDTOList");
                    for (SellerDTO sellerDTO : listSeller) {
                        if (!newProductDTO.getSeller().getId().equals(sellerDTO.getId())) {
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
