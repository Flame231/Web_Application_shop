package org.example.service.seller;

import org.example.dto.SellerDTO;
import org.example.model.Seller;

import java.io.Serializable;
import java.util.List;

public interface SellerService {

    List<SellerDTO> getSellerDTOList();

    void updateSeller(Seller seller);

    void addSeller(Seller seller);

    void removeSeller(Serializable id);
}
