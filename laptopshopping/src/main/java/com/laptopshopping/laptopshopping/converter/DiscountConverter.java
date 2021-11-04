package com.laptopshopping.laptopshopping.converter;

import com.laptopshopping.laptopshopping.dto.DiscountDTO;
import com.laptopshopping.laptopshopping.dto.DiscountDTOCreate;
import com.laptopshopping.laptopshopping.dto.DiscountDTOUpdate;
import com.laptopshopping.laptopshopping.model.Discount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class DiscountConverter {
    @Autowired
    private ModelMapper modelMapper;

    public DiscountDTO convertToDto(Discount discount) {
        DiscountDTO discountDTO = modelMapper.map(discount, DiscountDTO.class);
        discountDTO.setDiscountId(discount.getDiscountId());
        return discountDTO;
    }

    private Discount covertToEntity(DiscountDTO discountDTO) throws ParseException {
        Discount discount = modelMapper.map(discountDTO, Discount.class);
        return discount;
    }

    private Discount covertToEntityCreate(DiscountDTOCreate discountDTOCreate) throws ParseException {
        Discount discount = modelMapper.map(discountDTOCreate, Discount.class);
        return discount;
    }

    private Discount covertToEntityUpdate(DiscountDTOUpdate discountDTOUpdate) throws ParseException {
        Discount discount = modelMapper.map(discountDTOUpdate, Discount.class);
        return discount;
    }

}
