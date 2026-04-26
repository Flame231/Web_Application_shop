package org.example.service.seller;

import org.example.converterDTO.SellerConverter;
import org.example.dao.seller.SellerDAO;
import org.example.dao.seller.SellerDAOImpl;
import org.example.dto.SellerDTO;
import org.example.model.Seller;

import java.io.Serializable;
import java.util.List;

public class SellerServiceImpl implements SellerService {

    SellerDAO sellerDAO = new SellerDAOImpl();

    public List<SellerDTO> getSellerDTOList() {
        return sellerDAO.getSellerList()
                .stream()
                .map(SellerConverter::toSellerDTO)
                .toList();
    }

    public Seller findSeller(Serializable id) {
        return sellerDAO.get(id);
    }
}
