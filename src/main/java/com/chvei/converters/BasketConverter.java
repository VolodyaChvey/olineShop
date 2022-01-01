package com.chvei.converters;

import com.chvei.dto.BasketItemDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketConverter {

    public List<BasketItemDto> toDto(List<Object[]> list) {
        List<BasketItemDto> basketList = new ArrayList<>();
        for (Object[] O : list) {
            BasketItemDto item = new BasketItemDto();
            item.setProductId(Integer.valueOf((Integer) O[0]));
            item.setTittle((String) O[1]);
            item.setPrice(Float.valueOf(O[2].toString()));
            item.setQuantity(Integer.parseInt(O[3].toString()));
            item.setTotal(Math.round(Double.valueOf((Double) O[4])*100)/100.00);
            basketList.add(item);
        }
        return basketList;
    }
}
