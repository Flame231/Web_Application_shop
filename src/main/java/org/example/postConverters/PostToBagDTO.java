package org.example.postConverters;

import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.BagDTO;

import javax.servlet.http.HttpServletRequest;

import static org.example.util.NamesUtil.*;

public class PostToBagDTO {
    public static BagDTO toBagDTO(HttpServletRequest request) {

        ConverterPost converterPost = new ConverterPost(request);
        Integer userId = converterPost.convertParameter(USER_ID_PARAMETER, Integer.class);
        Integer productId = converterPost.convertParameter(PRODUCT_ID_PARAMETER, Integer.class);
        Integer count = converterPost.convertParameter(COUNT_PARAMETER, Integer.class);
        System.out.println(count + "!!!!!!!!!!!!!!!!!!!!!!");
        UserDAO userDAO = new UserDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();

        BagDTO bagDTO = BagDTO.builder().user(userDAO.get(userId))
                .product(productDAO.get(productId)).count(count).build();
        return bagDTO;
    }

}
