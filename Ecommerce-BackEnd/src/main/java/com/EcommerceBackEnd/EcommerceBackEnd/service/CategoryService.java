package com.EcommerceBackEnd.EcommerceBackEnd.service;

import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DataNotFoundException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DeleteDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.UpdateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories() throws DataNotFoundException;

    public Category getCategoryById(Long categoryId) throws DataNotFoundException;

    public Category getCategoryByName(String cname) throws DataNotFoundException;

    public Category addCategory(Category category) throws CreateDataFailException;

    public void updateCategory(Category category) throws UpdateDataFailException;

    public void deleteCategory(Long categoryId) throws DeleteDataFailException;

    public List<Category> getByNameContainting(String name);
}
