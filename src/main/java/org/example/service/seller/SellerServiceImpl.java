package org.example.service.seller;

import org.example.converterDTO.ConverterDTO;
import org.example.converterDTO.SellerConverter;
import org.example.dao.seller.SellerDAO;
import org.example.dao.seller.SellerDAOImpl;
import org.example.dto.SellerDTO;
import org.example.model.Seller;

import java.io.Serializable;
import java.util.List;

public class SellerServiceImpl implements SellerService {
    private SellerDAO sellerDAO = new SellerDAOImpl();
    private ConverterDTO<Seller, SellerDTO> converterDTO = new SellerConverter();

    public List<SellerDTO> getSellerDTOList() {
        ConverterDTO<Seller, SellerDTO> converterDTO = new SellerConverter();
        return sellerDAO.getSellerList()
                .stream()
                .map(converterDTO::toDTO)
                .toList();
    }

    public Seller findSeller(Serializable id) {
        return sellerDAO.get(id);
    }

    @Override
    public void updateSeller(SellerDTO sellerDTO) {
        Seller seller = converterDTO.toEntity(sellerDTO);
        sellerDAO.update(seller);
    }

    @Override
    public void addSeller(SellerDTO sellerDTO) {
        Seller seller = converterDTO.toEntity(sellerDTO);
        sellerDAO.save(seller);
    }

    @Override
    public void removeSeller(Serializable id) {
        sellerDAO.delete(id);
    }
}
