import jakarta.persistence.EntityManager;
import org.example.connector.HibernateUtil;
import org.example.model.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Discount discount = Discount.builder().discount(10)
                .totalSum(new BigDecimal(1000)).build();
        User user = User.builder().name("name").login("login1")
                .password("password")
                .birthday(LocalDate.of(2020, 04, 07))
                .paymentMethods("paymentMethods")
                .sumOfPurchases(new BigDecimal(5000))
                .discount(discount).build();

        OrderPoint orderPoint = OrderPoint.builder()
                .orderPointAddress("orderPointAddress")
                .openingTime(new Time(10, 00, 00))
                .closeTime(new Time(21, 00, 00))
                .build();

        UserOrder order = UserOrder.builder().orderStatus("в пути")
                .user(user).orderPoint(orderPoint).build();

        ProductCategory productCategory = ProductCategory.builder()
                .category("Для дома").products(new HashSet<>())
                .build();

        Seller seller = Seller.builder().sellerName("sellerName")
                .sellerAddress("sellerAddress").build();

        Product product = Product.builder().productName("productName")
                .productCategory(productCategory)
                .price(new BigDecimal(10000))
                .seller(seller).build();

        Product product2 = Product.builder().productName("productName2")
                .productCategory(productCategory)
                .price(new BigDecimal(10000))
                .seller(seller).build();

        UserOrderProduct orderProduct = UserOrderProduct.builder()
                .userOrder(order).product(product).productCount(2).build();

        Bag bag = Bag.builder().user(user).product(product)
                .count(5).build();
        Bag bag1 = Bag.builder().user(user).product(product2)
                .count(5).build();

        entityManager.persist(discount);
        entityManager.persist(user);
        entityManager.persist(orderPoint);
        entityManager.persist(order);
        entityManager.persist(productCategory);
        entityManager.persist(seller);
        entityManager.persist(product);
        entityManager.persist(product2);
        entityManager.persist(orderProduct);
        entityManager.persist(bag);
        entityManager.persist(bag1);
        entityManager.getTransaction().commit();
    }
}
