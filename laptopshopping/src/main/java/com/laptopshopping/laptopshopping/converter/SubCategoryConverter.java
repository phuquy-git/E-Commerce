package com.laptopshopping.laptopshopping.converter;

import com.laptopshopping.laptopshopping.dto.SubCategoryDTO;
import com.laptopshopping.laptopshopping.dto.SubCategoryDTOCreate;
import com.laptopshopping.laptopshopping.dto.SubCategoryDTOUpdate;
import com.laptopshopping.laptopshopping.model.SubCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class SubCategoryConverter {
    @Autowired
    private ModelMapper modelMapper;

    public SubCategoryDTO convertToDto(SubCategory subCategory) {
        SubCategoryDTO subCategoryDTO = modelMapper.map(subCategory, SubCategoryDTO.class);
        subCategory.setSubCategoryId(subCategory.getSubCategoryId());
        return subCategoryDTO;
    }

    public SubCategory convertToEntity(SubCategoryDTO subCategoryDTO) throws ParseException {
        SubCategory subCategory = modelMapper.map(subCategoryDTO, SubCategory.class);
        return subCategory;
    }

    public SubCategory convertToEntityCreate(SubCategoryDTOCreate subCategoryDTOCreate) throws ParseException {
        SubCategory subCategory = modelMapper.map(subCategoryDTOCreate, SubCategory.class);
        return subCategory;
    }

    public SubCategory convertToEntityUpdate(SubCategoryDTOUpdate categoryDTOUpdate) throws ParseException {
        SubCategory subCategory = modelMapper.map(categoryDTOUpdate, SubCategory.class);
        return subCategory;
    }
}
