package org.example.service.seller;

import org.example.dto.SellerDTO;

import java.io.Serializable;
import java.util.List;

public interface SellerService {

    List<SellerDTO> getSellerDTOList();

    void updateSeller(SellerDTO sellerDTO);

    void addSeller(SellerDTO sellerDTO);

    void removeSeller(Serializable id);
}
