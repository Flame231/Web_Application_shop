package org.example.service.archivedUserOrderProduct;

import org.example.dao.archivedUserOrderProduct.ArchivedUserOrderDAOProductImpl;
import org.example.dao.archivedUserOrderProduct.ArchivedUserOrderProductDAO;
import org.example.model.ArchivedUserOrder;
import org.example.model.ArchivedUserOrderProduct;
import org.example.model.UserOrder.UserOrderProduct;

import java.util.Set;
import java.util.stream.Collectors;

public class ArchivedUserOrderProductServiceImpl implements ArchivedUserOrderProductService {
    private ArchivedUserOrderProductDAO archivedUserOrderProductDAO = new ArchivedUserOrderDAOProductImpl();

    @Override
    public Set<ArchivedUserOrderProduct> createUserOrderProduct(Set<UserOrderProduct> userOrderProducts, ArchivedUserOrder archivedUserOrder) {

        return userOrderProducts.stream().map(e -> ArchivedUserOrderProduct
                .builder()
                .archivedUserOrder(archivedUserOrder)
                .productId(e.getProduct().getId()).productName(e.getProduct().getProductName())
                .productCount(e.getProductCount())
                .finalProductCount(e.getActualProductCount())
                .price(e.getProductPrice())
                .build()).collect(Collectors.toSet());
    }
}
