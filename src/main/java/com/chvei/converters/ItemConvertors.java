package com.chvei.converters;

import com.chvei.domain.BasketItem;
import com.chvei.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemConvertors {

    public ItemDto toItemDto(BasketItem basketItem) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(basketItem.getId());
        itemDto.setTittle(basketItem.getProduct().getTittle());
        itemDto.setPrice(basketItem.getProduct().getPrice());
        itemDto.setQuantity(basketItem.getQuantity());
        itemDto.setTotal(basketItem.getTotal());
        return itemDto;
    }
}
