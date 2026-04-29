package org.example.controller.postConverters;

import org.example.dto.BagDTO;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static org.example.util.NamesUtil.*;

public class PostToBagDTO {
    public static List<BagDTO> toBagDTO(HttpServletRequest request) {

        PostConverter postConverter = new PostConverter(request);
        Integer userId = postConverter.convert(USER_ID_PARAMETER, Integer.class);
        List<Integer> productId = postConverter.convertValues(PRODUCT_ID_PARAMETER, Integer.class);
        List<Integer> count = postConverter.convertValues(COUNT_PARAMETER, Integer.class);
        List<BagDTO> bagDTOList = new ArrayList<>();
        for (int i = 0; i < count.size(); i++) {
            BagDTO bagDTO = BagDTO.builder()
                    .userId(userId)
                    .productId(productId.get(i))
                    .count(count.get(i))
                    .build();
            bagDTOList.add(bagDTO);
        }
        return bagDTOList;
    }
}
