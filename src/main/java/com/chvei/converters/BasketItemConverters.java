package com.chvei.converters;

import com.chvei.domain.BasketItem;
import com.chvei.dto.BasketItemDto;
import org.springframework.stereotype.Component;

@Component
public class BasketItemConverters {

    public BasketItemDto toDto(BasketItem basketItem) {
        BasketItemDto basketItemDto = new BasketItemDto();
        basketItemDto.setTittle(basketItem.getProduct().getTittle());
        basketItemDto.setQuantity(basketItem.getQuantity());
        basketItemDto.setTotal(basketItem.getTotal());
        return basketItemDto;
    }
}
