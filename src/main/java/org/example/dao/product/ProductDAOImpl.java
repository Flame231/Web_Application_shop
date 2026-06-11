package org.example.dao.product;

import org.example.dao.DAOImpl;
import org.example.model.Product;
import org.example.model.ProductCategory;
import org.example.model.Seller;

import java.util.List;

import static org.example.util.NamesUtil.PRODUCT_PER_PAGE;

public class ProductDAOImpl extends DAOImpl<Product> implements ProductDAO {
    public ProductDAOImpl() {
        super(Product.class);
    }

    @Override
    public void addSeller(Product product, Seller seller) {
        begin();
        product.setSeller(seller);
        seller.getProduct().add(product);
        commit();
    }

    @Override
    public void addProductCategory(Product product, ProductCategory productCategory) {
        begin();
        product.setProductCategory(productCategory);
        productCategory.getProducts().add(product);
        commit();
    }

    @Override
    public List<Product> getProductList(int currentPage) {
        getEm().clear();
        return getEm().createQuery("select distinct p from Product p left join fetch p.productCategory" +
                        " left join fetch  p.seller", Product.class)
                .setFirstResult((currentPage - 1) * PRODUCT_PER_PAGE).setMaxResults(PRODUCT_PER_PAGE).getResultList();
    }

    @Override
    public Integer getProductsCount() {
        Long count = (Long) getEm().createQuery("select count(*) from  Product ").getSingleResult();
        return count.intValue();
    }
}
