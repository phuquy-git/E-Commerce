package com.EcommerceBackEnd.EcommerceBackEnd.converter;

import com.EcommerceBackEnd.EcommerceBackEnd.dto.CategoryDTO;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.CategoryDTOCreate;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.CategoryDTOUpdate;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class CategoryConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO convertToDto(Category category) {
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        categoryDTO.setCategoryId(category.getCategoryId());
        return categoryDTO;
    }

    public Category convertToEntity(CategoryDTO categoryDTO) throws ParseException {
        Category category = modelMapper.map(categoryDTO, Category.class);
        return category;
    }

    public Category convertToEntityCreate(CategoryDTOCreate categoryDTOCreate) throws ParseException {
        Category category = modelMapper.map(categoryDTOCreate, Category.class);
        return category;
    }

    public Category convertToEntityUpdate(CategoryDTOUpdate categoryDTOUpdate) throws ParseException {
        Category category = modelMapper.map(categoryDTOUpdate, Category.class);
        return category;
    }
}
