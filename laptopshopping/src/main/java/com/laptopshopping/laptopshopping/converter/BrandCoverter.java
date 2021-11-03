package com.laptopshopping.laptopshopping.converter;

import com.laptopshopping.laptopshopping.dto.BrandDTO;
import com.laptopshopping.laptopshopping.dto.BrandDTOCreate;
import com.laptopshopping.laptopshopping.dto.BrandDTOUpdate;
import com.laptopshopping.laptopshopping.model.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandCoverter {

    @Autowired
    private ModelMapper modelMapper;

    public BrandDTO convertToDto(Brand brand) {
        BrandDTO brandDTO = modelMapper.map(brand, BrandDTO.class);
        brandDTO.setBrandId(brand.getBrandId());
        return brandDTO;
    }

    public Brand convertToEntity(BrandDTO brandDTO) throws ParseException {
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        return brand;
    }

    public Brand convertToEntityCreate(BrandDTOCreate brandDTOCreate) throws ParseException {
        Brand brand = modelMapper.map(brandDTOCreate, Brand.class);
        return brand;
    }

    public Brand convertToEntityUpdate(BrandDTOUpdate brandDTOUpdate) throws ParseException {
        Brand brand = modelMapper.map(brandDTOUpdate, Brand.class);
        return brand;
    }
}
