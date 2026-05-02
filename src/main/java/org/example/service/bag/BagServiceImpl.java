package org.example.service.bag;

import org.example.converterDTO.BagConverter;
import org.example.converterDTO.ConverterDTO;
import org.example.dao.bag.BagDAO;
import org.example.dao.bag.BagDAOImpl;
import org.example.dto.BagDTO;
import org.example.model.Bag;
import org.example.model.additional.primaryKeys.PrimaryKeyBag;
import org.example.model.additional.primaryKeys.PrimaryKeyUtil;
import org.example.postConverters.ConverterPost;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BagServiceImpl implements BagService {
    private BagDAO bagDAO = new BagDAOImpl();
    private ConverterDTO<Bag, BagDTO> converterDTO = new BagConverter();

    @Override
    public void addProductToBag(BagDTO bagDTO) {
        Bag bag = converterDTO.toEntity(bagDTO);
        PrimaryKeyBag primaryKeyBag = PrimaryKeyUtil.getPrimaryKeyBag(bag.getUser(), bag.getProduct());
        Bag bagManaged = bagDAO.get(primaryKeyBag);
        if (bagManaged != null) {
            int count = bagManaged.getCount() + bag.getCount();
            if (count > 0) {
                bagDAO.begin();
                bagManaged.setCount(count);
                bagDAO.commit();
            } else {
                bagDAO.delete(primaryKeyBag);
            }
        } else if (bag.getCount() >= 1) {
            bagDAO.save(bag);
        }
    }

    public void closeBag() {
    }

    public List<BagDTO> showAllBags(HttpServletRequest request) {
        ConverterPost converterPost = new ConverterPost(request);
        Integer userId = converterPost.convertSessionAttribute("userId");
        List<Bag> bagList = bagDAO.getBagList(userId);
        return bagList.stream().map(converterDTO::toDTO).toList();
    }

}
