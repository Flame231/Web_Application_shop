package org.example.service.archivedUserOrderProduct;

import org.example.model.ArchivedUserOrder;
import org.example.model.ArchivedUserOrderProduct;
import org.example.model.UserOrder.UserOrderProduct;

import java.util.Set;

public interface ArchivedUserOrderProductService {

    Set<ArchivedUserOrderProduct> createUserOrderProduct(Set<UserOrderProduct> userOrderProducts, ArchivedUserOrder archivedUserOrder);
}
