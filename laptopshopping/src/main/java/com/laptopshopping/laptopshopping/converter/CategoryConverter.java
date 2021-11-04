package com.laptopshopping.laptopshopping.converter;

import com.laptopshopping.laptopshopping.dto.CategoryDTO;
import com.laptopshopping.laptopshopping.dto.CategoryDTOCreate;
import com.laptopshopping.laptopshopping.dto.CategoryDTOUpdate;
import com.laptopshopping.laptopshopping.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class CategoryConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO covertToDto(Category category) {
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        category.setCategoryId((category.getCategoryId()));
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
