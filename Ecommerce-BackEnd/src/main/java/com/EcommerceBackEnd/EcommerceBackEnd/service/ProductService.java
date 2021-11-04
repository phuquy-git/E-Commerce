package com.EcommerceBackEnd.EcommerceBackEnd.service;

import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DataNotFoundException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DeleteDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.UpdateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Brand;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Category;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts() throws DataNotFoundException;

    public Product getProductById(Long productId) throws DataNotFoundException;

    public List<Product> getAllSortById();

    public List<Product> getByNameContainting(String name);

    public List<Product> sortProductByPriceAsc(Category category);

    public List<Product> sortProductByPriceDesc(Category category);

    public List<Product> sortByProductByCreatedInDesc(Category category);

    public List<Product> sortByProductByRatingDesc(Category category);

    public List<Product> getProductByCategory(Category category);

    public Product addProduct(Product product) throws CreateDataFailException;

    public void deleteProduct(Long productId) throws DeleteDataFailException;

    public void updateProduct(Product product) throws UpdateDataFailException;

    public List<Product> getProductByBrand(Brand brand);

    public Float calculateRatingStar(Product product) throws DataNotFoundException;
}
