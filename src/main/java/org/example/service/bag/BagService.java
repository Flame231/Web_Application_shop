package org.example.service.bag;

import org.example.dto.ProductBagDTO;
import org.example.dto.ProductDTO;
import org.example.model.Bag;
import org.example.model.Product;
import org.example.model.User;

import java.util.List;

public interface BagService {
    void addProductToBag(Bag bag);

    List<ProductBagDTO> showAllBags(Integer userId);

    public  void closeBag();
}
