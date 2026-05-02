package org.example.service.bag;

import org.example.dto.BagDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BagService {
    void addProductToBag(BagDTO bagDTO);

    List<BagDTO> showAllBags(HttpServletRequest request);


    public void closeBag();
}
